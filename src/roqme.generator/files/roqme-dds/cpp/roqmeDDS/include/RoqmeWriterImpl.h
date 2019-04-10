#ifndef ROQMEINTWRITER_H
#define ROQMEINTWRITER_H

#include "RoqmeDataWriterWrapper.h"
#include "RoqmeConstantDefinitions.h"

namespace Roqme
{	

class RoqmeIntWriter: public RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeIntContext>
{
public:
	RoqmeIntWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME, const int& maxInstances = UNLIMITED_RESOURCES, const std::string& topicName = DEFAULT_TOPIC_INT_CONTEXT_NAME);
};

class RoqmeUIntWriter: public RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeUIntContext>
{
public:
	RoqmeUIntWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME, const int& maxInstances = UNLIMITED_RESOURCES, const std::string& topicName = DEFAULT_TOPIC_UINT_CONTEXT_NAME);
};

class RoqmeBoolWriter: public RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeBoolContext>
{
public:
	RoqmeBoolWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME, const int& maxInstances = UNLIMITED_RESOURCES, const std::string& topicName = DEFAULT_TOPIC_BOOL_CONTEXT_NAME);
};

class RoqmeDoubleWriter: public RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeDoubleContext>
{
public:
	RoqmeDoubleWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME, const int& maxInstances = UNLIMITED_RESOURCES, const std::string& topicName = DEFAULT_TOPIC_DOUBLE_CONTEXT_NAME);
};

class RoqmeEventWriter: public RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeEventContext>
{
public:
	RoqmeEventWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME, const int& maxInstances = UNLIMITED_RESOURCES, const std::string& topicName = DEFAULT_TOPIC_EVENT_CONTEXT_NAME);
};

class RoqmeEnumWriter: public RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeEnumContext>
{
public:
	RoqmeEnumWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME, const int& maxInstances = UNLIMITED_RESOURCES, const std::string& topicName = DEFAULT_TOPIC_ENUM_CONTEXT_NAME);
};

class RoqmeObservationWriter: public RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeObservation>
{
public:
	RoqmeObservationWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME, const int& maxInstances = UNLIMITED_RESOURCES, const std::string& topicName = DEFAULT_TOPIC_OBSERVATION_NAME);
};

class RoqmeEstimateWriter: public RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeEstimate>
{
public:
	RoqmeEstimateWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME, const int& maxInstances = UNLIMITED_RESOURCES, const std::string& topicName = DEFAULT_TOPIC_ESTIMATE_NAME);
};


} //roqme namespace

#endif // ROQMEINTWRITER_H
