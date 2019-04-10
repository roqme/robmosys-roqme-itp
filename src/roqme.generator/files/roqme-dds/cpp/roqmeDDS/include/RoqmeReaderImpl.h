#ifndef ROQMEREADERIMPL_H
#define ROQMEREADERIMPL_H

#include "RoqmeDataReaderWrapper.h"
#include "RoqmeConstantDefinitions.h"

namespace Roqme
{

class RoqmeIntReader:public RoqmeDataReaderWrapper<RoqmeDDSTopics::RoqmeIntContext>
{
public:
	RoqmeIntReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeIntContext>* elistener = nullptr, 
				const std::string& partitionName = DEFAULT_PARTITION_NAME, 
				const int& samplesResourceLimits = UNLIMITED_RESOURCES, 
				const std::string& filteredExpression = DEFAULT_FILTERED_EXPRESSION, 
				const std::string& topicName = DEFAULT_TOPIC_INT_CONTEXT_NAME
			 );
};

class RoqmeUIntReader:public RoqmeDataReaderWrapper<RoqmeDDSTopics::RoqmeUIntContext>
{
public:
	RoqmeUIntReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeUIntContext>* elistener = nullptr, 
				const std::string& partitionName = DEFAULT_PARTITION_NAME, 
				const int& samplesResourceLimits = UNLIMITED_RESOURCES, 
				const std::string& filteredExpression = DEFAULT_FILTERED_EXPRESSION, 
				const std::string& topicName = DEFAULT_TOPIC_UINT_CONTEXT_NAME
			 );
};

class RoqmeBoolReader:public RoqmeDataReaderWrapper<RoqmeDDSTopics::RoqmeBoolContext>
{
public:
	RoqmeBoolReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeBoolContext>* elistener = nullptr, 
				const std::string& partitionName = DEFAULT_PARTITION_NAME, 
				const int& samplesResourceLimits = UNLIMITED_RESOURCES, 
				const std::string& filteredExpression = DEFAULT_FILTERED_EXPRESSION, 
				const std::string& topicName = DEFAULT_TOPIC_BOOL_CONTEXT_NAME
			 );
};

class RoqmeDoubleReader:public RoqmeDataReaderWrapper<RoqmeDDSTopics::RoqmeDoubleContext>
{
public:
	RoqmeDoubleReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeDoubleContext>* elistener = nullptr, 
				const std::string& partitionName = DEFAULT_PARTITION_NAME, 
				const int& samplesResourceLimits = UNLIMITED_RESOURCES, 
				const std::string& filteredExpression = DEFAULT_FILTERED_EXPRESSION, 
				const std::string& topicName = DEFAULT_TOPIC_DOUBLE_CONTEXT_NAME
			 );
};

class RoqmeEnumReader:public RoqmeDataReaderWrapper<RoqmeDDSTopics::RoqmeEnumContext>
{
public:
	RoqmeEnumReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeEnumContext>* elistener = nullptr, 
				const std::string& partitionName = DEFAULT_PARTITION_NAME, 
				const int& samplesResourceLimits = UNLIMITED_RESOURCES, 
				const std::string& filteredExpression = DEFAULT_FILTERED_EXPRESSION, 
				const std::string& topicName = DEFAULT_TOPIC_ENUM_CONTEXT_NAME
			 );
};

class RoqmeEventReader:public RoqmeDataReaderWrapper<RoqmeDDSTopics::RoqmeEventContext>
{
public:
	RoqmeEventReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeEventContext>* elistener = nullptr, 
				const std::string& partitionName = DEFAULT_PARTITION_NAME, 
				const int& samplesResourceLimits = UNLIMITED_RESOURCES, 
				const std::string& filteredExpression = DEFAULT_FILTERED_EXPRESSION, 
				const std::string& topicName = DEFAULT_TOPIC_EVENT_CONTEXT_NAME
			 );
};

class RoqmeObservationReader:public RoqmeDataReaderWrapper<RoqmeDDSTopics::RoqmeObservation>
{
public:
	RoqmeObservationReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeObservation>* elistener = nullptr, 
				const std::string& partitionName = DEFAULT_PARTITION_NAME, 
				const int& samplesResourceLimits = UNLIMITED_RESOURCES, 
				const std::string& filteredExpression = DEFAULT_FILTERED_EXPRESSION, 
				const std::string& topicName = DEFAULT_TOPIC_OBSERVATION_NAME
			 );
};

class RoqmeEstimateReader:public RoqmeDataReaderWrapper<RoqmeDDSTopics::RoqmeEstimate>
{
public:
	RoqmeEstimateReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeEstimate>* elistener = nullptr, 
				const std::string& partitionName = DEFAULT_PARTITION_NAME, 
				const int& samplesResourceLimits = UNLIMITED_RESOURCES, 
				const std::string& filteredExpression = DEFAULT_FILTERED_EXPRESSION, 
				const std::string& topicName = DEFAULT_TOPIC_ESTIMATE_NAME
			 );
};

} //roqme namespace

#endif // ROQMEREADERIMPL_H
