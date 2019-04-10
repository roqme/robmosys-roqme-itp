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

#include "FilteringVarElimination.h"

#include <forward_list>
#include <set>
#include <iostream>
#include <algorithm>


namespace Roqme {

    const string FilteringVarElimination::ID = "Filtering-VE";

    FilteringVarElimination::FilteringVarElimination()
    {
        m_initialized = false;
    }

    FilteringVarElimination::~FilteringVarElimination()
    {}

    bool FilteringVarElimination::init(const bn_model& model)
    {
        m_bn_model = &model;

        // Prior model
		m_prior_model = Factor(1.0);
		for (auto id : m_bn_model->prior) {
			m_prior_model = m_prior_model * *(m_bn_model->factors[id]);
		}

		// Generalized sensor model

        vector<const Variable*> vars;
        for (auto const &v : m_bn_model->variables) {
            vars.push_back(v.get());
        }

		vector<shared_ptr<Factor>> sensor_factors;
		for (auto id : m_bn_model->sensor) {
			sensor_factors.push_back(m_bn_model->factors[id]);
		}
		for (auto id : m_bn_model->internals) {
			sensor_factors.push_back(m_bn_model->factors[id]);
		}
		vector<const Variable*> internal_variables;
		for (auto id : m_bn_model->internals) {
			internal_variables.push_back(vars[id]);
		}
		m_sensor_model = variable_elimination(internal_variables, sensor_factors);

        // Initialize forward message
        m_forward = Factor(m_prior_model);

        // Initialized
        m_initialized = true;

        return m_initialized;
    }

    bool FilteringVarElimination::reset()
    {
        bool result = false;

        if(m_initialized) {
            m_forward = Factor(m_prior_model);
            m_ordering.clear();
            m_sum_prod_factors.clear();
            result = true;
        }
        return result;
    }

    Factor FilteringVarElimination::update(const unordered_map<unsigned,unsigned> &evidence)
    {
        if(m_initialized) {
            // project belief state
            Factor projection = project(m_bn_model->factors, m_bn_model->transition, m_forward);

            // update belief state
            m_forward = update(projection, m_sensor_model, evidence);
        }
        return m_forward;
    }

	Factor FilteringVarElimination::variable_elimination(
        vector<const Variable*> &variables,
        vector<shared_ptr<Factor>> &factors) {

		// initialize result
		Factor result(1.0);

		// choose elimination ordering
		forward_list<const Variable*> ordering(variables.begin(), variables.end());

		// initialize buckets
		unordered_map<unsigned,set<shared_ptr<Factor>>> buckets;
		for (auto pv : ordering) {
			set<shared_ptr<Factor>> bfactors;
			buckets[pv->id()] = bfactors;
		}

        bool in_bucket;
        for (auto pf : factors) {
            in_bucket = false;
            for (auto pv : ordering) {
				if (pf->domain().in_scope(pv)) {
					buckets[pv->id()].insert(pf);
					in_bucket = true;
					break;
				}
			}
			if (!in_bucket) {
				result *= *pf;
			}
		}

		// eliminate all variables

        const Variable *var;
        shared_ptr<Factor> new_factor;

		while (!ordering.empty()) {
			var = ordering.front();
			ordering.pop_front();

			// eliminate var
			Factor prod(1.0);
			for (auto pf : buckets[var->id()]) {
                prod *= *pf;
			}
			new_factor = make_shared<Factor>(prod.sum_out(var));

			// stop if finished
			if (buckets.empty()) {
				result *= *new_factor;
				break;
			}

			// update bucket list with new factor
			in_bucket = false;
			for (auto pv : ordering) {
                if (new_factor->domain().in_scope(pv)) {
                    buckets[pv->id()].insert(new_factor);
                    in_bucket = true;
                    break;
                }
			}
			if (!in_bucket) {
				result *= *new_factor;
			}
		}

		return result;
	}

	Factor FilteringVarElimination::project(
		const vector<shared_ptr<Factor>> &factors,
		const unordered_map<unsigned,const Variable*> &transition,
		const Factor &forward) {

		if (m_ordering.size() == 0 && m_sum_prod_factors.size() == 0) {
            unsigned id_prime;
            const Variable *variable;
			for (auto it_transition : transition) {
                id_prime = it_transition.first;
                variable = it_transition.second;
                m_ordering.push_back(variable);
                m_sum_prod_factors.push_back(factors[id_prime]);
			}
		}

		// variable elimination
		m_sum_prod_factors.push_back(make_shared<Factor>(forward));
		Factor projection = variable_elimination(m_ordering, m_sum_prod_factors);

		projection = projection.change_variables(transition);
		m_sum_prod_factors.pop_back();

		return projection;
	}

    Factor FilteringVarElimination::update(
            const Factor &projection,
            const Factor &sensor_model,
            const unordered_map<unsigned,unsigned> &evidence)
    {
        if(evidence.size() > 0) {
            // add observation from time t
            Factor evidence_t = sensor_model.conditioning(evidence);

            // update projection with observation
            Factor belief_state = evidence_t * projection;

            // return move(belief_state);
            return belief_state.normalize();
        }
        else {
            return projection;
        }
    }
}
