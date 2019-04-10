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

#ifndef ROQME_FACTOR_H
#define ROQME_FACTOR_H

#include "domain.h"

#include <vector>
#include <memory>

namespace Roqme {

    class Factor {
    public:
        Factor(Domain *domain);
        Factor(Domain *domain, double value);
        Factor(double value = 1.0);
        Factor(const Factor &f);
        Factor(Factor &&f);

        Factor &operator=(Factor &&f);
        Factor operator*(const Factor &f);
        void operator*=(const Factor &f);

        const Domain &domain() const { return *_domain; }
        unsigned size()        const { return _domain->size();  }
        unsigned width()       const { return _domain->width(); }
        double partition()     const { return _partition; }

        void partition(double p) { _partition = p; }

        const double &operator[](unsigned i) const;
        double &operator[](unsigned i);

        double operator[](std::vector<unsigned> instantiation) const;

        Factor change_variables(std::unordered_map<unsigned,const Variable*> renaming);
        bool in_scope(const Variable *variable) const;

        Factor sum_out(const Variable *variable) const;
        Factor product(const Factor &f) const;
        Factor normalize() const;
        Factor conditioning(const std::unordered_map<unsigned,unsigned> &evidence) const;

        friend std::ostream &operator<<(std::ostream &os, const Factor &f);

    private:
        std::unique_ptr<Domain> _domain;
        std::vector<double> _values;
        double _partition;
    };

}

#endif
