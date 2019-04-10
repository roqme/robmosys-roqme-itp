#include "RoqmeDataWriter.h"

namespace Roqme
{

template<typename T>	
RoqmeDataWriter<T>::RoqmeDataWriter(const std::string& partitionName, const std::string& topicName, const int& maxSamples):
	dataWriter(dds::core::null)
{
	try
    {
		dds::domain::DomainParticipant dp(org::opensplice::domain::default_id());
		
		dds::topic::qos::TopicQos topicQos = dp.default_topic_qos();    
		dds::topic::Topic<T> topic(dp, topicName, topicQos);

		dds::pub::qos::PublisherQos pubQos = dp.default_publisher_qos() << dds::core::policy::Partition(partitionName);
		dds::pub::Publisher pub (dp, pubQos);
		
		dds::pub::qos::DataWriterQos dataWriterQos = topic.qos() << dds::core::policy::Reliability::Reliable();
		
		if(maxSamples!=-1) 
		{
			dataWriterQos << dds::core::policy::ResourceLimits(maxSamples) << dds::core::policy::History::KeepLast(maxSamples);
		}
		else 
		{ 
			dataWriterQos << dds::core::policy::History::KeepAll();			
		}
		
		dataWriter = dds::pub::DataWriter<T>(pub, topic, dataWriterQos);	    
	}
	catch (const dds::core::Exception& e)
    {
        throw RoqmeDDSException("Error creating RoqmeDataWriter: Could not possible to create DDS entities.");
	}
}

template<typename T>
int RoqmeDataWriter<T>::write(const T& data)
{
	try
    {
		dataWriter << data;
	}
	catch (const dds::core::Exception& e)
    {
		std::string err("Error in write operation:");
		err.append(e.what());
        throw RoqmeDDSException(err);
    }
    return 0;
}

}
