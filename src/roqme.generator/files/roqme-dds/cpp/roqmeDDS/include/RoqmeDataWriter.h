#ifndef _RoqmeDataWriter_
#define _RoqmeDataWriter_
#include "RoqmeDDSTopics_DCPS.hpp"
#include <dds/dds.hpp> //@
#include "RoqmeDDSException.h"

namespace Roqme 
{

/**
 * La clase RoqmeDataWriter encapsula a un objeto DataWriter de DDS y permita publicar tópicos utilizando dicho objeto.
 */
template<typename T>
class RoqmeDataWriter
{
public:
	/**
	 * Inicializa internamente el objeto DataWriter.
	 * @param partitionName. Nombre de la partición donde se publicarán los datos.
	 * @param topicName. Nombre del tópico.
	 * @param maxSamples. Número máximo de samples que puede almacenar el DataWriter.
	 */
	RoqmeDataWriter(const std::string& partitionName, const std::string& topicName, const int& maxSamples = -1);
	/**
	 * Permite publicar un tópico
	 * @param data. Tópico a enviar
	 */
	int write(const T& data);

private:
	/**
	 * Entidad DataWriter de DDS
	 */
	dds::pub::DataWriter<T> dataWriter;
};

}

#endif
