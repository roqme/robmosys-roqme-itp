/*
 * This file belongs to the RoQME toolchain.
 * Copyright (C) 2019  University of Extremadura, University of Málaga, Biometric Vox.

 * RoQME is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * any later version.

 * RoQME is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * GNU GPLv3 link: http://www.gnu.org/licenses/gpl-3.0.html
 *
 */

#include "RoqmeDDSException.h"  
    
namespace Roqme
{
    
RoqmeDDSException::RoqmeDDSException(const char* message):msg(message)
{
	
}

RoqmeDDSException::RoqmeDDSException(const std::string& message): msg(message)
{
	
}

RoqmeDDSException::~RoqmeDDSException() throw ()
{
	
}

const char* RoqmeDDSException::what() const throw ()
{
	return msg.c_str();
}

}
