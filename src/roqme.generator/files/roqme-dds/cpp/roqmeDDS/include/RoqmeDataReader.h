#ifndef ROQMEDATAREADER_H
#define ROQMEDATAREADER_H

#include <string>
#include <memory> //@
#include <vector>  //@
#include "RoqmeDDSTopics_DCPS.hpp"
#include <dds/dds.hpp> //@
#include "RoqmeDDSListener.h"
#include "RoqmeDDSException.h"

namespace Roqme 
{
    
const std::string DEFAULT_FILTERED_EXPRESSION = "empty expression";
    
/**
 * La clase RoqmeDataWriter encapsula a un objeto DataWriter de DDS y permita publicar tópicos utilizando dicho objeto.
 */
template<typename T>
class RoqmeDataReader: public virtual dds::sub::DataReaderListener<T>, public virtual dds::sub::NoOpDataReaderListener<T>
{
public:
	/**
	 * Inicializa internamente el objeto DataWriter.
	 * @param partitionName. Nombre de la partición donde se publicarán los datos.
	 * @param topicName. Nombre del tópico.
	 * @param elistener. Listener utilizado para recepción de datos asíncrona.
	 * @param maxSamples. Número máximo de samples que puede almacenar el DataWriter.
	 */
	RoqmeDataReader(const std::string& partitionName, 
			const std::string& topicName, 
			RoqmeDDSListener<T>* elistener = nullptr, 
			const std::string& filtered_expression = DEFAULT_FILTERED_EXPRESSION, 
			const int& maxSamples = -1);
	/**
	 * Recepción de datos síncrona. Devuelve todos los samples de una instancia concreta.
	 * @param sample. Instancia del tópico
	 * @param data. Dato recibido.
	 * @param duration. Tiempo que el método espera a la recepción de un dato.
	 */ 	
	bool waitAndTakeInstance(const T& sample, T& data, const dds::core::Duration& duration);
	/**
	 * Recepción de datos síncrona. Devuelve todos los samples disponibles
	 * @param data. Dato recibido.
	 * @param duration. Tiempo que el método espera a la recepción de un dato.
	 */
	bool waitAndTake(std::vector<dds::sub::Sample<T>>& data, const dds::core::Duration& duration);
	/**
	 * Método que se ejecuta cuando no se cumple la política DeadlineQos de RoqmeDDSException
	 * @param the_reader. DataReader donde se produce el evento.
	 * @param status. Información del evento.
	 */
	virtual void on_requested_deadline_missed(dds::sub::DataReader<T>& the_reader, const dds::core::status::RequestedDeadlineMissedStatus& status);
    /**
	 * Método que se ejecuta cuando hay un dato disponible (en caso de utilizar un lístener)
	 * @param the_reader. DataReader donde se produce el evento.
	 */
	virtual void on_data_available(dds::sub::DataReader<T>& the_reader);
	
    dds::sub::LoanedSamples<T> take();

    void close();
	
private:
	/**
	 * Obtiene de las colas de DDS todos los samples disponible de una instancia en particular.
	 * @param key. Clave de la instancia
	 * @param data. Dato leído de las colas de DDS.
	 */
	bool takeInstance(const T& key, T& data);
	/**
	 * Obtiene de las colas de DDS todos los samples disponibles
	 * @param data. Datos leídos de las colas de DDS.
	 */
	bool take(std::vector<dds::sub::Sample<T>>& data);

private:
	/**
	 * Objeto DataReader de DDS para suscribirse a un tópico de tipo T
	 */
	dds::sub::DataReader<T> dataReader;
	/**
	 * Objeto listener utilizado para leer datos de forma asíncrona
	 */
	std::unique_ptr<RoqmeDDSListener<T>> elistener;
    /**
	 * Objeto DDS para configurar la recepción de datos síncrona
	 */
	dds::core::cond::WaitSet waitSet;
	/**
	 * Objeto DDS
	 */ 
	dds::core::cond::GuardCondition terminated;
};

}

#endif // ROQMEDATAREADER_H
