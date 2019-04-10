#include "RoqmeDDSManager.h"

namespace Roqme 
{
	
RoqmeDDSManager::RoqmeDDSManager(const int& maxSamples):
	samplesResourceLimits(maxSamples),
	intContextWriterPtr(nullptr), 
	intContextReaderPtr(nullptr),
	uintContextWriterPtr(nullptr), 
	uintContextReaderPtr(nullptr), 
	doubleContextWriterPtr(nullptr), 
	doubleContextReaderPtr(nullptr), 
	boolContextWriterPtr(nullptr), 
	boolContextReaderPtr(nullptr), 
	enumContextWriterPtr(nullptr), 
	enumContextReaderPtr(nullptr), 
	eventContextWriterPtr(nullptr), 
	eventContextReaderPtr(nullptr), 
	observationReaderPtr(nullptr), 
	observationWriterPtr(nullptr)
{

}
// ContextWrapper

void RoqmeDDSManager::createIntContextWriter(const std::string& partitionName)
{
	createWriter<RoqmeDDSTopics::RoqmeIntContext>(intContextWriterPtr, partitionName, DEFAULT_TOPIC_INT_CONTEXT_NAME, "createIntContextWriter");
}

void RoqmeDDSManager::createUIntContextWriter(const std::string& partitionName)
{
	createWriter<RoqmeDDSTopics::RoqmeUIntContext>(uintContextWriterPtr, partitionName, DEFAULT_TOPIC_UINT_CONTEXT_NAME, "createUIntContextWriter");
}

void RoqmeDDSManager::createDoubleContextWriter(const std::string& partitionName)
{
	createWriter<RoqmeDDSTopics::RoqmeDoubleContext>(doubleContextWriterPtr, partitionName, DEFAULT_TOPIC_DOUBLE_CONTEXT_NAME, "createDoubleContextWriter");
}

void RoqmeDDSManager::createBoolContextWriter(const std::string& partitionName)
{
	createWriter<RoqmeDDSTopics::RoqmeBoolContext>(boolContextWriterPtr, partitionName, DEFAULT_TOPIC_BOOL_CONTEXT_NAME, "createBoolContextWriter");
}

void RoqmeDDSManager::createEventContextWriter(const std::string& partitionName)
{
	createWriter<RoqmeDDSTopics::RoqmeEventContext>(eventContextWriterPtr, partitionName, DEFAULT_TOPIC_EVENT_CONTEXT_NAME, "createEventContextWriter");
}

void RoqmeDDSManager::createEnumContextWriter(const std::string& partitionName)
{
	createWriter<RoqmeDDSTopics::RoqmeEnumContext>(enumContextWriterPtr, partitionName, DEFAULT_TOPIC_ENUM_CONTEXT_NAME, "createEnumContextWriter");
}

void RoqmeDDSManager::createObservationWriter(const std::string& partitionName)
{
	createWriter<RoqmeDDSTopics::RoqmeObservation>(observationWriterPtr, partitionName, DEFAULT_TOPIC_OBSERVATION_NAME, "createObservationWriter");
}

void RoqmeDDSManager::createEstimateWriter(const std::string& partitionName)
{
	createWriter<RoqmeDDSTopics::RoqmeEstimate>(estimateWriterPtr, partitionName, DEFAULT_TOPIC_ESTIMATE_NAME, "createEstimateWriter");
}


template<typename T>
void RoqmeDDSManager::createWriter(std::unique_ptr<RoqmeDataWriter<T>>& dwriter, 
								   const std::string& partitionName, 
								   const std::string& topicName,
								   const std::string& fname
  								)
{
	if(dwriter != nullptr)
	{
		throw RoqmeDDSException("Error creating DDS DataWriter in " + fname + ": Entity already exists!");
	}
	try
	{
		dwriter = 
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

void RoqmeDDSManager::createIntContextReader(RoqmeDDSListener<RoqmeDDSTopics::RoqmeIntContext>* elistener, 
											 const std::string& filtered_expression, 
											 const std::string& partitionName)
{
	createReader<RoqmeDDSTopics::RoqmeIntContext>(intContextReaderPtr, elistener, filtered_expression, partitionName, DEFAULT_TOPIC_INT_CONTEXT_NAME, "createIntContextReader");
}

void RoqmeDDSManager::createUIntContextReader(	RoqmeDDSListener<RoqmeDDSTopics::RoqmeUIntContext>* elistener, 
												const std::string& filtered_expression, 
												const std::string& partitionName )
{
	createReader<RoqmeDDSTopics::RoqmeUIntContext>(uintContextReaderPtr, elistener, filtered_expression, partitionName, DEFAULT_TOPIC_UINT_CONTEXT_NAME, "createUIntContextReader");
}

void RoqmeDDSManager::createDoubleContextReader(RoqmeDDSListener<RoqmeDDSTopics::RoqmeDoubleContext>* elistener, 
												const std::string& filtered_expression, 
												const std::string& partitionName )
{
	createReader<RoqmeDDSTopics::RoqmeDoubleContext>(doubleContextReaderPtr, elistener, filtered_expression, partitionName, DEFAULT_TOPIC_DOUBLE_CONTEXT_NAME, "createDoubleContextReader");
}

void RoqmeDDSManager::createBoolContextReader(RoqmeDDSListener<RoqmeDDSTopics::RoqmeBoolContext>* elistener, 
												const std::string& filtered_expression, 
												const std::string& partitionName)
{
	createReader<RoqmeDDSTopics::RoqmeBoolContext>(boolContextReaderPtr, elistener, filtered_expression, partitionName, DEFAULT_TOPIC_BOOL_CONTEXT_NAME, "createBoolContextReader");
}

void RoqmeDDSManager::createEventContextReader(RoqmeDDSListener<RoqmeDDSTopics::RoqmeEventContext>* elistener, 
												const std::string& filtered_expression, 
												const std::string& partitionName)
{
	createReader<RoqmeDDSTopics::RoqmeEventContext>(eventContextReaderPtr, elistener, filtered_expression, partitionName, DEFAULT_TOPIC_EVENT_CONTEXT_NAME, "createEventContextReader");
}

void RoqmeDDSManager::createEnumContextReader(RoqmeDDSListener<RoqmeDDSTopics::RoqmeEnumContext>* elistener, 
												const std::string& filtered_expression, 
												const std::string& partitionName)
{
	createReader<RoqmeDDSTopics::RoqmeEnumContext>(enumContextReaderPtr, elistener, filtered_expression, partitionName, DEFAULT_TOPIC_ENUM_CONTEXT_NAME, "createEnumContextReader");
}

void RoqmeDDSManager::createObservationReader(	RoqmeDDSListener<RoqmeDDSTopics::RoqmeObservation>* elistener,
												const std::string& filtered_expression,
												const std::string& partitionName )
{
	createReader<RoqmeDDSTopics::RoqmeObservation>(observationReaderPtr, elistener, filtered_expression, partitionName, DEFAULT_TOPIC_OBSERVATION_NAME, "createObservationReader");
}

void RoqmeDDSManager::createEstimateReader(	RoqmeDDSListener<RoqmeDDSTopics::RoqmeEstimate>* elistener,
											const std::string& filtered_expression,
											const std::string& partitionName )
{
	createReader<RoqmeDDSTopics::RoqmeEstimate>(estimateReaderPtr, elistener, filtered_expression, partitionName, DEFAULT_TOPIC_ESTIMATE_NAME, "createEstimateReader");
}

template<typename T>
void RoqmeDDSManager::createReader(	std::unique_ptr<RoqmeDataReader<T>>& dataReaderPtr, 
									Roqme::RoqmeDDSListener<T>* elistener, 
									const std::string& filtered_expression, 
									const std::string& partitionName,
									const std::string& topicName,
									const std::string& fname
  								)
{
	if(dataReaderPtr != nullptr)
	{
		throw RoqmeDDSException("Error creating DDS DataReader in " + fname + ": Entity already exists!");
	}
	try
	{
		dataReaderPtr = std::unique_ptr<RoqmeDataReader<T>>	( new RoqmeDataReader<T>(	partitionName, 
																						topicName, 
																						elistener, 
																						filtered_expression, 
																						samplesResourceLimits ));
	}
	catch(...)
	{
		throw RoqmeDDSException("Error creating DDS DataReader (createReader): Could not possible to create unique_ptr!");
	}	
}


void RoqmeDDSManager::write(const RoqmeDDSTopics::RoqmeIntContext& data)
{
	write<RoqmeDDSTopics::RoqmeIntContext>(intContextWriterPtr, data, "intContextWriterPtr");
}

void RoqmeDDSManager::write(const RoqmeDDSTopics::RoqmeUIntContext& data)
{
	write<RoqmeDDSTopics::RoqmeUIntContext>(uintContextWriterPtr, data, "uintContextWriterPtr");
}

void RoqmeDDSManager::write(const RoqmeDDSTopics::RoqmeDoubleContext& data)
{
	write<RoqmeDDSTopics::RoqmeDoubleContext>(doubleContextWriterPtr, data, "doubleContextWriterPtr");
}

void RoqmeDDSManager::write(const RoqmeDDSTopics::RoqmeBoolContext& data)
{
	write<RoqmeDDSTopics::RoqmeBoolContext>(boolContextWriterPtr, data, "boolContextWriterPtr");
}

void RoqmeDDSManager::write(const RoqmeDDSTopics::RoqmeEventContext& data)
{
	write<RoqmeDDSTopics::RoqmeEventContext>(eventContextWriterPtr, data, "eventContextWriterPtr");
}

void RoqmeDDSManager::write(const RoqmeDDSTopics::RoqmeEnumContext& data)
{
	write<RoqmeDDSTopics::RoqmeEnumContext>(enumContextWriterPtr, data, "enumContextWriterPtr");
}

void RoqmeDDSManager::write(const RoqmeDDSTopics::RoqmeObservation& data)
{
	write<RoqmeDDSTopics::RoqmeObservation>(observationWriterPtr, data, "observationWriterPtr");
}	

void RoqmeDDSManager::write(const RoqmeDDSTopics::RoqmeEstimate& data)
{
	write<RoqmeDDSTopics::RoqmeEstimate>(estimateWriterPtr, data, "estimateWriterPtr");
}

template <typename T>
void RoqmeDDSManager::write(std::unique_ptr<RoqmeDataWriter<T>>& dataWriterPtr, const T& data, const std::string& dwname)
{
	if(dataWriterPtr == nullptr)
	{
		throw RoqmeDDSException("Error in write operation. " + dwname + " has not been initialized!");
	}
	else
	{
		dataWriterPtr->write(data);
	}
}


} //namespace Roqme