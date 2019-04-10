#ifndef ROQMEWRITERINTERFACE_H
#define ROQMEWRITERINTERFACE_H

#include <memory> //@
#include "RoqmeDataWriter.h"
#include "RoqmeDDSException.h"


namespace Roqme
{

template <typename T>
class RoqmeDataWriterWrapper
{
public:
	/**
	 * Publicación de una instancia del tópico RoqmeContext
	 * @param data. Estructura del tópico a enviar.
	 */
	void write(const T& data)	
	{
		if(writer_ptr == nullptr)
		{
			throw RoqmeDDSException("Error in write operation. writer_ptr has not been initialized!");
		}
		else
		{
			writer_ptr->write(data);
		}
	}

protected:
		/**
	 * Crea el DataWriter que permite publicar tópicos RoqmeContext. 
	 * @param partitionName. Nombre de la partición donde se publicará el dato. Si se omite se utiliza una por defecto.
	 */
	RoqmeDataWriterWrapper(const std::string& partitionName, const int& samplesResourceLimits, const std::string& topicName)
	{
		try
		{
			writer_ptr = 
				std::unique_ptr<RoqmeDataWriter<T>>
				(
					new RoqmeDataWriter<T>(partitionName, topicName, samplesResourceLimits)
				);
		}
		catch(...)
		{
			throw RoqmeDDSException("Error creating DDS DataWriter: Could not possible to create unique_ptr!");
		}
	}

protected:
	/**
	 * Puntero inteligente a un objeto RoqmeDataWriter para publicar el tópico RoqmeContext
	 */
	std::unique_ptr<RoqmeDataWriter<T>> writer_ptr;

};

} //roqme namespace

#endif // ROQMEWRITERINTERFACE_H
