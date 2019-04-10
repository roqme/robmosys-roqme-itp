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
 * Clase utilizada para controlar excepciones en la creación y uso de la librería
 */
class RoqmeDDSException: public std::exception
{
public:
	/**
	 * Constructor
	 * @param message. Mensaje en formato C string.
	 */
    explicit RoqmeDDSException(const char* message);
    /**
	 * Constructor
	 * @param message. Mensaje en formato string C++.
	 */
	explicit RoqmeDDSException(const std::string& message);
	/**
	 * Destructor
	 */
    virtual ~RoqmeDDSException() throw ();
	/**
	 * Muestra información de la excepción
	 */
    virtual const char* what() const throw ();

protected:
	/**
	 * Mensaje con información de la excepción
	 */
    std::string msg;
};

}

#endif // ROQMEDDSEXCEPTION_H
