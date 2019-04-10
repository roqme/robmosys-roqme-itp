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

#ifndef DDSCONNROQMEREASONER_H
#define DDSCONNROQMEREASONER_H

#include "RoqmeReasoner.h"
#include "RoqmeDDSManager.h"

using namespace std;

namespace Roqme {

    class DDSConnRoqmeReasoner : public RoqmeDDSListener<RoqmeDDSTopics::RoqmeObservation>
    {
    private:
        static DDSConnRoqmeReasoner*    m_instance;
        RoqmeDDSManager*                m_roqmeDDSManager;
        RoqmeReasoner*                  m_roqmeReasoner;
        bool                            m_started;

    public:
        ~DDSConnRoqmeReasoner();
        static DDSConnRoqmeReasoner* instance();

        void start(const string & modelPath, const string & configPath);
        void stop();

    protected:

        DDSConnRoqmeReasoner();

        RoqmeReasoner* getReasoner();
        RoqmeDDSManager* getDDSManager();

        void dataAvailable(
            const RoqmeDDSTopics::RoqmeObservation& data,
            const dds::sub::SampleInfo& sampleInfo);

        static void reasonerResultCallback(unordered_map<string, double> results);

    };
}

#endif // DDSCONNROQMEREASONER_H
