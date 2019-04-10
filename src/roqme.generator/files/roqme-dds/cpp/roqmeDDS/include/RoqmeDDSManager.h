#ifndef _RoqmeDDSInterface__
#define _RoqmeDDSInterface__

#include "RoqmeConstantDefinitions.h"
#include "RoqmeDataWriter.h"
#include "RoqmeDataReader.h"


namespace Roqme
{

/**
 * La clase RoqmeDDSManager es un wrapper de DDS que permite enviar y recibir tópicos utilizados en el proyecto Roqme. 
 */
class RoqmeDDSManager
{
public:
	/**
	 * Permite crear instancias de la clase RoqmeDDSManager. Internamente utilizará dos DataWriters (para publicar tópicos RoqmeContext y RoqmeObservation) y dos DataReaders (para suscribirse a tópicos RoqmeContext y RoqmeObservation). Inicialmente estas entidades DDS no están inicializadas.
	 * @param maxInstances. Número máximo de datos que podrá almacenar cada DataWriter/DataReader en DDS. El valor por defecto indica un número infinito de datos.
	 */
	RoqmeDDSManager(const int& maxInstances = -1);		
	/**
	 * Crea el DataWriter que permite publicar tópicos RoqmeContext. 
	 * @param partitionName. Nombre de la partición donde se publicará el dato. Si se omite se utiliza una por defecto.
	 */
	void createIntContextWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME);
	/**
	 * Crea el DataWriter que permite publicar tópicos RoqmeContext. 
	 * @param partitionName. Nombre de la partición donde se publicará el dato. Si se omite se utiliza una por defecto.
	 */
	void createUIntContextWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME);
	/**
	 * Crea el DataWriter que permite publicar tópicos RoqmeContext. 
	 * @param partitionName. Nombre de la partición donde se publicará el dato. Si se omite se utiliza una por defecto.
	 */
	void createDoubleContextWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME);
	/**
	 * Crea el DataWriter que permite publicar tópicos RoqmeContext. 
	 * @param partitionName. Nombre de la partición donde se publicará el dato. Si se omite se utiliza una por defecto.
	 */
	void createBoolContextWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME);
	/**
	 * Crea el DataWriter que permite publicar tópicos RoqmeContext. 
	 * @param partitionName. Nombre de la partición donde se publicará el dato. Si se omite se utiliza una por defecto.
	 */
	void createEnumContextWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME);
	/**
	 * Crea el DataWriter que permite publicar tópicos RoqmeContext. 
	 * @param partitionName. Nombre de la partición donde se publicará el dato. Si se omite se utiliza una por defecto.
	 */
	void createEventContextWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME);
	/**
	 * Crea el DataWriter que permite publicar tópicos RoqmeObservation. 
	 * @param partitionName. Nombre de la partición donde se publicará el dato. Si se omite se utiliza una por defecto.
	 */
	void createObservationWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME);
	/**
	 * Crea el DataWriter que permite publicar tópicos RoqmeObservation. 
	 * @param partitionName. Nombre de la partición donde se publicará el dato. Si se omite se utiliza una por defecto.
	 */
	void createEstimateWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME);
	/**
	 * Crea el DataReader que permite suscribir a tópicos RoqmeContext. 
	 * @param elistener. Listener que se utiliza para recibir datos de forma asíncrona
	 * @param partitionName. Nombre de la partición donde se publicará el dato. Si se omite se utiliza una por defecto.
	 */
	void createIntContextReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeIntContext>* elistener = nullptr, 
									const std::string& filtered_expression = DEFAULT_FILTERED_EXPRESSION, 
									const std::string& partitionName = DEFAULT_PARTITION_NAME);	
	/**
	 * Crea el DataReader que permite suscribir a tópicos RoqmeContext. 
	 * @param elistener. Listener que se utiliza para recibir datos de forma asíncrona
	 * @param partitionName. Nombre de la partición donde se publicará el dato. Si se omite se utiliza una por defecto.
	 */
	void createUIntContextReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeUIntContext>* elistener = nullptr, 
									const std::string& filtered_expression = DEFAULT_FILTERED_EXPRESSION, 
									const std::string& partitionName = DEFAULT_PARTITION_NAME);	
	/**
	 * Crea el DataReader que permite suscribir a tópicos RoqmeContext. 
	 * @param elistener. Listener que se utiliza para recibir datos de forma asíncrona
	 * @param partitionName. Nombre de la partición donde se publicará el dato. Si se omite se utiliza una por defecto.
	 */
	void createDoubleContextReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeDoubleContext>* elistener = nullptr, 
									const std::string& filtered_expression = DEFAULT_FILTERED_EXPRESSION, 
									const std::string& partitionName = DEFAULT_PARTITION_NAME);	
	/**
	 * Crea el DataReader que permite suscribir a tópicos RoqmeContext. 
	 * @param elistener. Listener que se utiliza para recibir datos de forma asíncrona
	 * @param partitionName. Nombre de la partición donde se publicará el dato. Si se omite se utiliza una por defecto.
	 */
	void createBoolContextReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeBoolContext>* elistener = nullptr, 
									const std::string& filtered_expression = DEFAULT_FILTERED_EXPRESSION, 
									const std::string& partitionName = DEFAULT_PARTITION_NAME);	
	/**
	 * Crea el DataReader que permite suscribir a tópicos RoqmeContext. 
	 * @param elistener. Listener que se utiliza para recibir datos de forma asíncrona
	 * @param partitionName. Nombre de la partición donde se publicará el dato. Si se omite se utiliza una por defecto.
	 */
	void createEventContextReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeEventContext>* elistener = nullptr, 
									const std::string& filtered_expression = DEFAULT_FILTERED_EXPRESSION, 
									const std::string& partitionName = DEFAULT_PARTITION_NAME);	
	/**
	 * Crea el DataReader que permite suscribir a tópicos RoqmeContext. 
	 * @param elistener. Listener que se utiliza para recibir datos de forma asíncrona
	 * @param partitionName. Nombre de la partición donde se publicará el dato. Si se omite se utiliza una por defecto.
	 */
	void createEnumContextReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeEnumContext>* elistener = nullptr, 
									const std::string& filtered_expression = DEFAULT_FILTERED_EXPRESSION, 
									const std::string& partitionName = DEFAULT_PARTITION_NAME);	
	
	/**
	 * Crea el DataReader que permite suscribir a tópicos RoqmeObservation. 
	 * @param elistener. Listener que se utiliza para recibir datos de forma asíncrona
	 * @param partitionName. Nombre de la partición donde se publicará el dato. Si se omite se utiliza una por defecto.
	 */
	void createObservationReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeObservation>* elistener = nullptr, 
									const std::string& filtered_expression = DEFAULT_FILTERED_EXPRESSION, 
									const std::string& partitionName = DEFAULT_PARTITION_NAME);	
		/**
	 * Crea el DataReader que permite suscribir a tópicos RoqmeObservation. 
	 * @param elistener. Listener que se utiliza para recibir datos de forma asíncrona
	 * @param partitionName. Nombre de la partición donde se publicará el dato. Si se omite se utiliza una por defecto.
	 */
	void createEstimateReader(		Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeEstimate>* elistener = nullptr, 
									const std::string& filtered_expression = DEFAULT_FILTERED_EXPRESSION, 
									const std::string& partitionName = DEFAULT_PARTITION_NAME);	
	/**
	 * Publicación de una instancia del tópico RoqmeContext
	 * @param data. Estructura del tópico a enviar.
	 */
	void write(const RoqmeDDSTopics::RoqmeIntContext& data);	
	/**
	 * Publicación de una instancia del tópico RoqmeContext
	 * @param data. Estructura del tópico a enviar.
	 */
	void write(const RoqmeDDSTopics::RoqmeUIntContext& data);	
	/**
	 * Publicación de una instancia del tópico RoqmeContext
	 * @param data. Estructura del tópico a enviar.
	 */
	void write(const RoqmeDDSTopics::RoqmeDoubleContext& data);	
	/**
	 * Publicación de una instancia del tópico RoqmeContext
	 * @param data. Estructura del tópico a enviar.
	 */
	void write(const RoqmeDDSTopics::RoqmeBoolContext& data);	
	/**
	 * Publicación de una instancia del tópico RoqmeContext
	 * @param data. Estructura del tópico a enviar.
	 */
	void write(const RoqmeDDSTopics::RoqmeEventContext& data);	
	/**
	 * Publicación de una instancia del tópico RoqmeContext
	 * @param data. Estructura del tópico a enviar.
	 */
	void write(const RoqmeDDSTopics::RoqmeEnumContext& data);		
	/**
	 * Publicación de una instancia del tópico RoqmeObservation
	 * @param data. Estructura del tópico a enviar.
	 */
	void write(const RoqmeDDSTopics::RoqmeObservation& data);
		/**
	 * Publicación de una instancia del tópico RoqmeObservation
	 * @param data. Estructura del tópico a enviar.
	 */
	void write(const RoqmeDDSTopics::RoqmeEstimate& data);
	
private:
	template<typename T>
	void createWriter(	std::unique_ptr<RoqmeDataWriter<T>>& dwriter, 
						const std::string& partitionName, 
						const std::string& topicName,
						const std::string& fname 
 					);
	
	template<typename T>
	void createReader(	std::unique_ptr<RoqmeDataReader<T>> & dataReader,
						Roqme::RoqmeDDSListener<T>* elistener,
						const std::string& filtered_expression, 
						const std::string& partitionName,
						const std::string& topicName,
						const std::string& fname
 					);	
	template <typename T>
	void write(std::unique_ptr<RoqmeDataWriter<T>>& dataWriterPtr, 
								const T& data, 
								const std::string& dwname
							   );	
private:
	/**
	 * Puntero inteligente a un objeto RoqmeDataReader para suscribirse a al tópico RoqmeContext
	 */
	std::unique_ptr<RoqmeDataReader<RoqmeDDSTopics::RoqmeIntContext>> intContextReaderPtr;
	/**
	 * Puntero inteligente a un objeto RoqmeDataWriter para publicar el tópico RoqmeContext
	 */
	std::unique_ptr<RoqmeDataWriter<RoqmeDDSTopics::RoqmeIntContext>> intContextWriterPtr;
	/**
	 * Puntero inteligente a un objeto RoqmeDataReader para suscribirse a al tópico RoqmeContext
	 */
	std::unique_ptr<RoqmeDataReader<RoqmeDDSTopics::RoqmeUIntContext>> uintContextReaderPtr;
	/**
	 * Puntero inteligente a un objeto RoqmeDataWriter para publicar el tópico RoqmeContext
	 */
	std::unique_ptr<RoqmeDataWriter<RoqmeDDSTopics::RoqmeUIntContext>> uintContextWriterPtr;
	/**
	 * Puntero inteligente a un objeto RoqmeDataWriter para publicar el tópico RoqmeContext
	 */
	std::unique_ptr<RoqmeDataWriter<RoqmeDDSTopics::RoqmeDoubleContext>> doubleContextWriterPtr;
	/**
	 * Puntero inteligente a un objeto RoqmeDataReader para suscribirse a al tópico RoqmeContext
	 */
	std::unique_ptr<RoqmeDataReader<RoqmeDDSTopics::RoqmeDoubleContext>> doubleContextReaderPtr;
	/**
	 * Puntero inteligente a un objeto RoqmeDataReader para suscribirse a al tópico RoqmeContext
	 */
	std::unique_ptr<RoqmeDataReader<RoqmeDDSTopics::RoqmeBoolContext>> boolContextReaderPtr;
	/**
	 * Puntero inteligente a un objeto RoqmeDataWriter para publicar el tópico RoqmeContext
	 */
	std::unique_ptr<RoqmeDataWriter<RoqmeDDSTopics::RoqmeBoolContext>> boolContextWriterPtr;
	/**
	 * Puntero inteligente a un objeto RoqmeDataReader para suscribirse a al tópico RoqmeContext
	 */
	std::unique_ptr<RoqmeDataReader<RoqmeDDSTopics::RoqmeEventContext>> eventContextReaderPtr;
	/**
	 * Puntero inteligente a un objeto RoqmeDataWriter para publicar el tópico RoqmeContext
	 */
	std::unique_ptr<RoqmeDataWriter<RoqmeDDSTopics::RoqmeEventContext>> eventContextWriterPtr;
	/**
	 * Puntero inteligente a un objeto RoqmeDataReader para suscribirse a al tópico RoqmeContext
	 */
	std::unique_ptr<RoqmeDataReader<RoqmeDDSTopics::RoqmeEnumContext>> enumContextReaderPtr;
	/**
	 * Puntero inteligente a un objeto RoqmeDataWriter para publicar el tópico RoqmeContext
	 */
	std::unique_ptr<RoqmeDataWriter<RoqmeDDSTopics::RoqmeEnumContext>> enumContextWriterPtr;
	/**
	 * Puntero inteligente a un objeto RoqmeDataReader para publicar datos del tipo RoqmeObservation
	 */
	std::unique_ptr<RoqmeDataReader<RoqmeDDSTopics::RoqmeObservation>> observationReaderPtr;
	/**
	 * Puntero inteligente a un objeto RoqmeDataWriter para publicar datos del tipo RoqmeObservation
	 */
	std::unique_ptr<RoqmeDataWriter<RoqmeDDSTopics::RoqmeObservation>> observationWriterPtr;	
	/**
	 * Puntero inteligente a un objeto RoqmeDataReader para publicar datos del tipo RoqmeObservation
	 */
	std::unique_ptr<RoqmeDataReader<RoqmeDDSTopics::RoqmeEstimate>> estimateReaderPtr;
	/**
	 * Puntero inteligente a un objeto RoqmeDataWriter para publicar datos del tipo RoqmeObservation
	 */
	std::unique_ptr<RoqmeDataWriter<RoqmeDDSTopics::RoqmeEstimate>> estimateWriterPtr;	
	/**
	 * Número máximos de samples que almacenarán las entidades DDS 
	 */
	int samplesResourceLimits;
};

} //namespace Roqme

#endif
