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