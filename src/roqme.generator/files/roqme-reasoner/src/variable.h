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

#ifndef ROQME_VARIABLE_H
#define ROQME_VARIABLE_H

#include <ostream>

namespace Roqme {

    class Variable {
    public:
        Variable(unsigned id, unsigned size) : m_id(id), m_size(size) { }

        unsigned id()   const { return m_id;   }
        unsigned size() const { return m_size; }
        std::string name() const { return m_name; }
        void name(const std::string & name)  { m_name = name; }

        friend std::ostream &operator<<(std::ostream &o, const Variable &v);

    private:
        std::string m_name;
        unsigned m_id;
        unsigned m_size;
    };

}

#endif
