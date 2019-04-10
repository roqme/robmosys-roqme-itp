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

#ifndef ROQMEREASONER_H
#define ROQMEREASONER_H

#include "InferenceEngineFactory.h"

#include <thread>
#include <mutex>

using namespace std;

namespace Roqme {

    /**
     * @class RoqmeReasoner
     * This class implements the probabilistic reasoner that is used in RoQME
     * to estimate the value of QoS metrics associated with non-functional
     * properties.
     */
    class RoqmeReasoner
    {

    private:
        bn_model                            m_model;
        InferenceEngine*                    m_engine;
        string                              m_inferenceMethod;
        double                              m_period_ms;
        string*                             m_varnames;
        int                                 m_varnames_length;
        set<string>                         m_query_vars;
        bool                                m_stopReasoningLoop;
        bool                                m_isrunning;
        thread*                             m_reasoningThread;
        Factor                              m_currentBelief;
        unordered_map<unsigned,unsigned>    m_observations;
        mutex                               m_obsMutex;
        bool                                m_testingEnabled;
        string                              m_testingOutputPath;
        function<void(unordered_map<string,double>)> m_callback;

    public:

        RoqmeReasoner(const string & modelPath, const string & configPath);
        ~RoqmeReasoner();

        bool isRunning();
        void setCallback(function<void(unordered_map<string,double>)> callback);
        void observation(const string & varname, int value = 1);
        Factor query(const string & queryVarName);
        bool start();
        bool stop();

    private:
        void notify();
        void runReasoningLoop();
        int identifierOf(string varname);
    };
}

#endif // ROQMEREASONER_H
