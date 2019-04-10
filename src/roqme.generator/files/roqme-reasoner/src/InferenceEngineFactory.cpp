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

#include "InferenceEngineFactory.h"
#include "FilteringVarElimination.h"

namespace Roqme {

    InferenceEngine* InferenceEngineFactory::createEngine(string method)
    {
        InferenceEngine* result = NULL;

        if(method == FilteringVarElimination::ID) {
            result = (InferenceEngine*) new FilteringVarElimination();
        }
        // Add here more inference engines
        return result;
    }

    InferenceEngine::~InferenceEngine() {};
}
