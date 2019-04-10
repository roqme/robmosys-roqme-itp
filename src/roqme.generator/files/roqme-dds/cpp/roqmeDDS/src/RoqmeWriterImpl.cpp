#include "RoqmeWriterImpl.h"

namespace Roqme 
{
RoqmeIntWriter::RoqmeIntWriter(const std::string& partitionName, const int& maxInstances, const std::string& topicName)
	:RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeIntContext>(partitionName, maxInstances, topicName)
{
}

RoqmeUIntWriter::RoqmeUIntWriter(const std::string& partitionName, const int& maxInstances, const std::string& topicName)
	:RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeUIntContext>(partitionName, maxInstances, topicName)
{
}

RoqmeBoolWriter::RoqmeBoolWriter(const std::string& partitionName, const int& maxInstances, const std::string& topicName)
	:RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeBoolContext>(partitionName, maxInstances, topicName)
{
}

RoqmeDoubleWriter::RoqmeDoubleWriter(const std::string& partitionName, const int& maxInstances, const std::string& topicName)
	:RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeDoubleContext>(partitionName, maxInstances, topicName)
{
}

RoqmeEventWriter::RoqmeEventWriter(const std::string& partitionName, const int& maxInstances, const std::string& topicName)
	:RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeEventContext>(partitionName, maxInstances, topicName)
{
}

RoqmeEnumWriter::RoqmeEnumWriter(const std::string& partitionName, const int& maxInstances, const std::string& topicName)
	:RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeEnumContext>(partitionName, maxInstances, topicName)
{
}

RoqmeObservationWriter::RoqmeObservationWriter(const std::string& partitionName, const int& maxInstances, const std::string& topicName)
	:RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeObservation>(partitionName, maxInstances, topicName)
{
}

RoqmeEstimateWriter::RoqmeEstimateWriter(const std::string& partitionName, const int& maxInstances, const std::string& topicName)
	:RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeEstimate>(partitionName, maxInstances, topicName)
{
}
	
} //roqme namespace
