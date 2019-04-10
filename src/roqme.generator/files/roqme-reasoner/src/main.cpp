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

#include <cstring>
#include <iostream>

#include "DDSConnRoqmeReasoner.h"

using namespace std;
using namespace Roqme;

/**
 * Main program for executing the RoQME Reasoner. This reasoner is started passing
 * the model and the configuration file as arguments. The process finishes when the
 * user types bye<ENTER> in the console. Usage example:
 *
 * @code
 * 		> roqme-reasoner model.duai reasoner.config
 * @endcode
 *
 */
int main(int argc, char *argv[])
{
    if (argc != 3) {
        string usage = "Usage: " + std::string(argv[0]) + " /path/to/model.duai /path/to/configuration.duai.config";
        cout << usage << endl << endl;
        return -1;
    }

    // Getting arguments
    char *modelPath  = argv[1];
    char *configPath = argv[2];

    DDSConnRoqmeReasoner* ddsConnRoqmeReasoner = DDSConnRoqmeReasoner::instance();
    ddsConnRoqmeReasoner->start(modelPath, configPath);

    std::cout << "\nRoqme Reasoner is running. Please, type bye<Enter> to stop it.\n";

    string cmd;
    do {
        std::cin >> cmd;
    }
    while(cmd.compare("bye") != 0);

    ddsConnRoqmeReasoner->stop();

    return 0;
}
