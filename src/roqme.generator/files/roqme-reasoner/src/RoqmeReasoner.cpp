//  This file belongs to the RoQME toolchain.
//  Copyright (C) 2019  University of Extremadura, University of Málaga, Biometric Vox.
//
//  RoQME is free software; you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation; either version 3 of the License, or
//  any later version.
//
//  RoQME is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
//
//  GNU GPLv3 link: http://www.gnu.org/licenses/gpl-3.0.html

#include "RoqmeReasoner.h"
#include "FilteringVarElimination.h"
#include "ConfigurationParams.h"
#include "io.h"
#include "DebuggingSupport.h"

#include <time.h>
#include <iostream>
#include <fstream>


namespace Roqme {

    /**
     * RoqmeReasoner constructor.
     * @param modelPath Path to the model specifying the bayesian belief network.
     * @param configPath Path to the configuration file.
     * @return a Roqme Reasoner object.
     */
    RoqmeReasoner::RoqmeReasoner(const string & modelPath, const string & configPath)
    {
        ConfigurationParams::settings(configPath);

        m_stopReasoningLoop = false;
        m_isrunning = false;
        m_period_ms = 1000;
        m_varnames_length = 0;
        m_inferenceMethod = FilteringVarElimination::ID;

        if(read_uai_model(modelPath.c_str(), m_model.order, m_model.variables, m_model.factors,
            m_model.prior, m_model.interface, m_model.sensor, m_model.internals, m_model.transition) < 0)
        {
            fprintf(stderr,"[RoqmeReasoner] Error while reading the UAI model\n");
            exit(EXIT_FAILURE);
        }

        if(PARAM("period.ms", isset)) {
            m_period_ms = PARAM(number);
        }
        if(PARAM("variables.names", isset)) {
            m_varnames = PARAM(strarray);
            m_varnames_length = PARAM(length);

            if(m_model.variables.size() == m_varnames_length) {
                for(int i=0; i<m_varnames_length; i++) {
                    m_model.variables[i]->name(m_varnames[i]);
                }
            }
            else {
                fprintf(stderr,"[RoqmeReasoner] Mismatch number of variables and names\n");
                exit(EXIT_FAILURE);
            }
        }
        if(PARAM("variables.query", isset)) {
            string* query_vars = PARAM(strarray);
            int query_vars_length = PARAM(length);

            for(int i=0; i<query_vars_length; i++) {
                m_query_vars.insert(query_vars[i]);
            }
        }
        if((m_testingEnabled = PARAM("testing.output", isset))) {
            m_testingOutputPath = PARAM(str);
        }
        if(PARAM("inference.method", isset)) {
            m_inferenceMethod = PARAM(str);
        }

        if(m_inferenceMethod == FilteringVarElimination::ID) {
            m_engine = InferenceEngineFactory::createEngine(FilteringVarElimination::ID);
        }
        else {
            fprintf(stderr,"[RoqmeReasoner] Unknown inference method\n");
            exit(EXIT_FAILURE);
        }

        m_engine->init(m_model);
    }

    /**
     * Class destructor.
     */
    RoqmeReasoner::~RoqmeReasoner() {
        delete m_engine;
        delete &m_model;
        delete &m_query_vars;
    }

    /**
     * Indicates wether or not the reasoner is running.
     * @return True if the reasoner is running, false otherwise.
     */
    bool RoqmeReasoner::isRunning() {
        return m_isrunning;
    }

    /**
     * Sets a callback function to be notified when new results are available.
     * @param callback Function invoked when the reasoner outputs a new result.
     */
    void RoqmeReasoner::setCallback(function<void(unordered_map<string,double>)> callback) {
        m_callback = callback;
    }

    /**
     * Indicates the occurrence of new evidence.
     * @param varname Variable name with which this observation is associated.
     * @param value Observed value. Note that, if the variable is binary, this
     * value will only take two values (0 or 1).
     */
    void RoqmeReasoner::observation(const string & varname, int value) {

        DEBUGGING("RoqmeReasoner", "New evidence (name = " << varname << ", value = " << value << ")");

        int varid;
        m_obsMutex.lock();
        if( (varid = identifierOf(varname)) > 0) {
            m_observations[varid] = value;
        }
        m_obsMutex.unlock();
    }

    /**
     * Queries the probability of a set of variables.
     * @param queryVarNames Names of the variables to be queried.
     * @return Resulting probability values.
     */
    Factor RoqmeReasoner::query(const string & queryVarName) {
        Factor result = Factor(m_currentBelief);
        unsigned varid;
        const Variable * var;

        Domain domain = result.domain();

        for (unsigned i=0; i<domain.width(); i++) {
            var = domain[i];

            if(queryVarName.compare(var->name()) != 0) {
                result = result.sum_out(var);
            }
        }
        return result;
    }

    bool RoqmeReasoner::start() {
        bool result = false;
        if(!m_isrunning) {
            m_reasoningThread = new thread(&RoqmeReasoner::runReasoningLoop, this);
            result = true;
        }
        return result;
    }

    bool RoqmeReasoner::stop() {
        bool result = false;
        if(m_isrunning) {
            m_stopReasoningLoop = true;
            m_reasoningThread->join();
            m_engine->reset();
            result = true;
        }
        return result;
    }

    void RoqmeReasoner::notify() {

        if(m_callback != nullptr) {
            unordered_map<string, double> results;

            for (set<string>::iterator it = m_query_vars.begin(); it != m_query_vars.end(); it++) {
                const Factor factor = query(*it);
                const Domain domain = factor.domain();

                if(domain.width() == 1)
                    results[domain[(unsigned) 0]->name()] = factor[1];
            }

            m_callback(results);
        }
    }

    void RoqmeReasoner::runReasoningLoop() {

        DEBUGGING("RoqmeReasoner", "Starting RoQME Reasoner");

        clock_t t;
        int t_diff;
        unordered_map<unsigned,unsigned> obs;
        m_isrunning = true;
        m_stopReasoningLoop = false;
        int timeSlotCounter = 0;
        ofstream testingOutputFile;

        // Code for testing purposes
        if(m_testingEnabled) {
            testingOutputFile.open(m_testingOutputPath);
        }

        while(!m_stopReasoningLoop)
        {
            t = clock();

            // Getting the set of current observations that will be considered in this slot
            m_obsMutex.lock();
            obs = unordered_map<unsigned,unsigned>(m_observations);
            m_observations.clear();
            m_obsMutex.unlock();

            // Updating the belief
            m_currentBelief = m_engine->update(obs);

            // Notify listener
            notify();

            // Code for testing purposes. It saves the results in a local file
            if(m_testingEnabled) {
                Domain domain = m_currentBelief.domain();

                for (unsigned i=0; i<domain.width(); i++) {
                    testingOutputFile << timeSlotCounter << ", " << domain[i]->id() << ", " << m_currentBelief[i] << endl;
                }
            }

            // Elapsed processing time
            t = clock() - t;

            if( (t_diff = ( m_period_ms - ((float)t)/CLOCKS_PER_SEC*1000)) > 0 )
            {
                this_thread::sleep_for(chrono::milliseconds(t_diff));
            }
            timeSlotCounter++;
        }

        if(m_testingEnabled) {
            testingOutputFile.close();
        }

        m_isrunning = false;

        DEBUGGING("RoqmeReasoner", "RoQME Reasoner finished");
    }

    int RoqmeReasoner::identifierOf(string varname) {
        int index = 0;
        bool found = false;

        if(m_varnames_length > 0) {
            while(!found && ++index<m_varnames_length) {
                found = (m_varnames[index].compare(varname) == 0);
            }
        }
        return found ? index : -1;
    }
}
