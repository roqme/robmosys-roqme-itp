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
