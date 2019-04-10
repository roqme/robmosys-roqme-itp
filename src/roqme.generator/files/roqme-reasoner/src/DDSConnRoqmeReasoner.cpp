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

#include "DDSConnRoqmeReasoner.h"
#include "DebuggingSupport.h"

namespace Roqme {

    DDSConnRoqmeReasoner* DDSConnRoqmeReasoner::m_instance;

    DDSConnRoqmeReasoner* DDSConnRoqmeReasoner::instance() {
        if(m_instance == nullptr) {
            m_instance = new DDSConnRoqmeReasoner();
        }
        return m_instance;
    }

    DDSConnRoqmeReasoner::DDSConnRoqmeReasoner()
    {
        m_roqmeReasoner = nullptr;
        m_roqmeDDSManager = nullptr;
        m_started = false;
    }

    DDSConnRoqmeReasoner::~DDSConnRoqmeReasoner()
    {
        delete m_roqmeDDSManager;
        delete m_roqmeReasoner;
    }

    void DDSConnRoqmeReasoner::start(const string & modelPath, const string & configPath)
    {
        if(!m_started) {
            m_roqmeDDSManager = new RoqmeDDSManager();
            m_roqmeDDSManager->createObservationReader(this);
            m_roqmeDDSManager->createEstimateWriter();
            m_roqmeReasoner = new RoqmeReasoner(modelPath, configPath);
            m_roqmeReasoner->setCallback(reasonerResultCallback);
            m_roqmeReasoner->start();
            m_started = true;
        }
    }

    void DDSConnRoqmeReasoner::stop()
    {
        if(m_started) {
            m_roqmeReasoner->stop();
            m_started = false;
            //delete m_roqmeDDSManager;
        }
    }

    void DDSConnRoqmeReasoner::dataAvailable(
        const RoqmeDDSTopics::RoqmeObservation& data,
        const dds::sub::SampleInfo& sampleInfo)
    {
        DEBUGGING("DDSConnRoqmeReasoner", "An observation (name = " << data.name() << ") has been received");

        if(m_roqmeReasoner != nullptr
            && m_roqmeReasoner->isRunning())
        {
             m_roqmeReasoner->observation(data.name());
        }
    }

    RoqmeReasoner* DDSConnRoqmeReasoner::getReasoner() {
        return m_roqmeReasoner;
    }

    RoqmeDDSManager* DDSConnRoqmeReasoner::getDDSManager() {
        return m_roqmeDDSManager;
    }

    void DDSConnRoqmeReasoner::reasonerResultCallback(unordered_map<string, double> results)
    {
        DEBUGGING("DDSConnRoqmeReasoner", "New QoS estimation");

        DDSConnRoqmeReasoner* ddsConnRoqmeReasoner = DDSConnRoqmeReasoner::instance();
        RoqmeDDSManager* roqmeDDSManager = ddsConnRoqmeReasoner->getDDSManager();

        if(roqmeDDSManager != nullptr) {

            for ( auto it = results.begin(); it != results.end(); it++ ) {

                RoqmeDDSTopics::RoqmeEstimate estimate(it->first, it->second);
                roqmeDDSManager->write(estimate);
                DEBUGGING("DDSConnRoqmeReasoner", "Sending estimation (name = " << estimate.name() << ", value = " << estimate.value() << ")");
            }
        }
    }
}
