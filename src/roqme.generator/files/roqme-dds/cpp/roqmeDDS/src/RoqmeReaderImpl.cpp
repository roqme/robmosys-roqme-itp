#include "RoqmeReaderImpl.h"

namespace Roqme
{

RoqmeIntReader::RoqmeIntReader ( 	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeIntContext>* elistener, 
						const std::string& partitionName, 
						const int& samplesResourceLimits, 
						const std::string& filteredExpression,	
						const std::string& topicName
						):RoqmeDataReaderWrapper<RoqmeDDSTopics::RoqmeIntContext>(elistener, partitionName, samplesResourceLimits, filteredExpression, topicName)
{
}

RoqmeUIntReader::RoqmeUIntReader( Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeUIntContext>* elistener, 
						const std::string& partitionName, 
						const int& samplesResourceLimits, 
						const std::string& filteredExpression,	
						const std::string& topicName
						):RoqmeDataReaderWrapper<RoqmeDDSTopics::RoqmeUIntContext>(elistener, partitionName, samplesResourceLimits, filteredExpression, topicName)
{
}

RoqmeBoolReader::RoqmeBoolReader( Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeBoolContext>* elistener, 
						const std::string& partitionName, 
						const int& samplesResourceLimits, 
						const std::string& filteredExpression,	
						const std::string& topicName
						):RoqmeDataReaderWrapper<RoqmeDDSTopics::RoqmeBoolContext>(elistener, partitionName, samplesResourceLimits, filteredExpression, topicName)
{
}

RoqmeDoubleReader::RoqmeDoubleReader( Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeDoubleContext>* elistener, 
							const std::string& partitionName, 
							const int& samplesResourceLimits, 
							const std::string& filteredExpression,	
							const std::string& topicName
							):RoqmeDataReaderWrapper<RoqmeDDSTopics::RoqmeDoubleContext>(elistener, partitionName, samplesResourceLimits, filteredExpression, topicName)
{
}

RoqmeEventReader::RoqmeEventReader( 	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeEventContext>* elistener, 
							const std::string& partitionName, 
							const int& samplesResourceLimits, 
							const std::string& filteredExpression,	
							const std::string& topicName
							):RoqmeDataReaderWrapper<RoqmeDDSTopics::RoqmeEventContext>(elistener, partitionName, samplesResourceLimits, filteredExpression, topicName)
{
}

RoqmeEnumReader::RoqmeEnumReader( Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeEnumContext>* elistener, 
						const std::string& partitionName, 
						const int& samplesResourceLimits, 
						const std::string& filteredExpression,	
						const std::string& topicName
						):RoqmeDataReaderWrapper<RoqmeDDSTopics::RoqmeEnumContext>(elistener, partitionName, samplesResourceLimits, filteredExpression, topicName)
{
}

RoqmeObservationReader::RoqmeObservationReader( 	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeObservation>* elistener, 
										const std::string& partitionName, 
										const int& samplesResourceLimits, 
										const std::string& filteredExpression,	
										const std::string& topicName
										):RoqmeDataReaderWrapper<RoqmeDDSTopics::RoqmeObservation>(elistener, partitionName, samplesResourceLimits, filteredExpression, topicName)
{
}

RoqmeEstimateReader::RoqmeEstimateReader( Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeEstimate>* elistener, 
								const std::string& partitionName, 
								const int& samplesResourceLimits, 
								const std::string& filteredExpression,	
								const std::string& topicName
								):RoqmeDataReaderWrapper<RoqmeDDSTopics::RoqmeEstimate>(elistener, partitionName, samplesResourceLimits, filteredExpression, topicName)
{
}



} //roqme namespace
