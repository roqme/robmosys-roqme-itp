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

#ifndef ROQME_IO_FILE_H
#define ROQME_IO_FILE_H

#include "variable.h"
#include "factor.h"

#include <vector>
#include <unordered_map>
#include <set>
#include <memory>

namespace Roqme {

	int read_uai_model(
		const char *filename,
		unsigned &order,
		std::vector<std::unique_ptr<Variable>> &variables,
		std::vector<std::shared_ptr<Factor>> &factors,
		std::set<unsigned> &prior, std::set<unsigned> &interface, std::set<unsigned> &sensor, std::set<unsigned> &internals,
		std::unordered_map<unsigned,const Variable*> &transition
	);

	int read_observations(
		const char *filename,
		std::vector<std::unordered_map<unsigned,unsigned>> &observations,
		std::set<unsigned> &state_variables
	);

}

#endif
