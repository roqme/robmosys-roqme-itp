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

#ifndef ROQMEDDSEXCEPTION_H
#define ROQMEDDSEXCEPTION_H

#include <string>

namespace Roqme
{
/**
 * RoqmeDDSException class
 */
class RoqmeDDSException: public std::exception
{
public:
	/**
	 * Constructor
	 * @param message. Message in C string style
	 */
    	explicit RoqmeDDSException(const char* message);
     	/**
	 * Constructor
	 * @param message. Message in C++ string style
	 */
	explicit RoqmeDDSException(const std::string& message);
	/**
	 * Destructor
	 */
    	virtual ~RoqmeDDSException() throw ();
	/**
	 * It shows the exception error information
	 */
    	virtual const char* what() const throw ();

protected:
	/**
	 * Message that contains exception information
	 */
    std::string msg;
};

}

#endif // ROQMEDDSEXCEPTION_H
