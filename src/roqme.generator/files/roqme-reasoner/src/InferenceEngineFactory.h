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

#ifndef INFERENCEENGINEFACTORY_H
#define INFERENCEENGINEFACTORY_H

#include "variable.h"
#include "factor.h"

#include <vector>
#include <unordered_map>
#include <set>

using namespace std;

namespace Roqme
{
    typedef struct {
        unsigned order;
        vector<unique_ptr<Variable>> variables;
        vector<shared_ptr<Factor>> factors;
        set<unsigned> interface;
        set<unsigned> sensor;
        set<unsigned> prior;
        set<unsigned> internals;
        unordered_map<unsigned, const Variable*> transition;
    } bn_model;

    class InferenceEngine {

    public:
        virtual ~InferenceEngine() = 0;
        virtual bool init(const bn_model& model) = 0;
        virtual bool reset() = 0;
        virtual Factor update(const unordered_map<unsigned,unsigned> &evidence) = 0;
    };

    class InferenceEngineFactory
    {
    public:
        static InferenceEngine* createEngine(string method);
    };
}

#endif // INFERENCEENGINEFACTORY_H
