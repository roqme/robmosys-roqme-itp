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

#ifndef FILTERINGVARELIMINATIONENGINE_H
#define FILTERINGVARELIMINATIONENGINE_H

#include "InferenceEngineFactory.h"

using namespace std;

namespace Roqme {

    class FilteringVarElimination : InferenceEngine
    {

    private:
        bool                        m_initialized;
        const bn_model*             m_bn_model;
        Factor                      m_prior_model;
        Factor                      m_sensor_model;
        Factor                      m_forward;
        vector<const Variable*>     m_ordering;
        vector<shared_ptr<Factor>>  m_sum_prod_factors;

    public:
        static const string ID;

        FilteringVarElimination();
        ~FilteringVarElimination();
        bool init(const bn_model& model);
        bool reset();
        Factor update(const unordered_map<unsigned,unsigned> &evidence);

    private:
        Factor variable_elimination(
            vector<const Variable*> &variables,
            vector<shared_ptr<Factor>> &factors);

        Factor project(
            const vector<shared_ptr<Factor>> &factors,
            const unordered_map<unsigned,const Variable*> &transition,
            const Factor &forward);

        Factor update(
            const Factor &projection,
            const Factor &sensor_model,
            const unordered_map<unsigned,unsigned> &evidence);
    };
};

#endif // FILTERINGVARELIMINATIONENGINE_H
