/*
 * This file belongs to the RoQME toolchain.
 * Copyright (C) 2019  University of Extremadura, University of Málaga, Biometric Vox.

 * RoQME is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * any later version.

 * RoQME is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * GNU GPLv3 link: http://www.gnu.org/licenses/gpl-3.0.html
 *
 */

#include "RoqmeDataReader.h"

namespace Roqme
{

template<typename T>	
RoqmeDataReader<T>::RoqmeDataReader(const std::string& partitionName, 
				    const std::string& topicName, RoqmeDDSListener<T>* elistener, 
				    const std::string& filtered_expression,
				    const int& maxSamples): dataReader(dds::core::null), waitSet(dds::core::null)
{
    try
    {
		this->elistener = std::unique_ptr<RoqmeDDSListener<T>>(elistener);
			
		dds::domain::DomainParticipant participant = dds::domain::DomainParticipant(org::opensplice::domain::default_id());
			
		dds::topic::Topic<T> topic = dds::topic::Topic<T>(participant, topicName);
		dds::sub::qos::SubscriberQos subQos = participant.default_subscriber_qos() << dds::core::policy::Partition(partitionName);
		dds::sub::Subscriber subscriber(participant, subQos);
		dds::sub::qos::DataReaderQos drqos = topic.qos() << dds::core::policy::Reliability::Reliable();
		if(maxSamples!=-1) 
		{
			drqos << dds::core::policy::ResourceLimits(maxSamples)<< dds::core::policy::History::KeepLast(maxSamples); ;
		}
		else
		{
			drqos << dds::core::policy::History::KeepAll();
		}
			
		if(elistener != nullptr)
		{
			dds::core::status::StatusMask mask;
			mask << dds::core::status::StatusMask::data_available()
				<< dds::core::status::StatusMask::requested_deadline_missed();	
			//TODO:: Meter esto en un método
			if(filtered_expression != DEFAULT_FILTERED_EXPRESSION)
			{
				dds::topic::Filter filter(filtered_expression);
				dds::topic::ContentFilteredTopic<T> cftopic(topic, topicName, filter);
				dataReader = dds::sub::DataReader<T>(subscriber, cftopic, drqos, this, mask);
			}
			else
			{
				dataReader = dds::sub::DataReader<T>(subscriber, topic, drqos, this, mask);
			}  
		}
		else
		{
			if(filtered_expression != DEFAULT_FILTERED_EXPRESSION)
			{
				dds::topic::Filter filter(filtered_expression);
				dds::topic::ContentFilteredTopic<T> cftopic(topic, topicName, filter);
				dataReader = dds::sub::DataReader<T>(subscriber, cftopic, drqos);
			}
			else
			{
				dataReader = dds::sub::DataReader<T>(subscriber, topic, drqos);
			}  
				
			dds::core::cond::StatusCondition dataAvailable(dataReader);
			dds::core::status::StatusMask statusMask;
			statusMask << dds::core::status::StatusMask::data_available();
			dataAvailable.enabled_statuses(statusMask);
			waitSet = dds::core::cond::WaitSet();
			waitSet += dataAvailable;
			waitSet += terminated;	    
		}
    }
    catch (const dds::core::Exception& e)
    {
	    throw RoqmeDDSException("Error creating RoqmeDataReader: Could not possible to create DDS entities.");
    }
}

template<typename T>
void RoqmeDataReader<T>::on_requested_deadline_missed(dds::sub::DataReader<T>& the_reader, const dds::core::status::RequestedDeadlineMissedStatus& status)
{
    std::cout << "\n=== [ContextReaderListener::on_requested_deadline_missed] : triggered" << std::endl;
    std::cout << "\n=== [ContextReaderListener::on_requested_deadline_missed] : stopping" << std::endl;
}


template<typename T>
void RoqmeDataReader<T>::on_data_available(dds::sub::DataReader<T>& dr)
{
	elistener->dataAvailable(dr);
	/*dds::sub::LoanedSamples<T> samples = dr.take();
	if((*samples.begin()).info().valid())
	{
		for (auto sample = samples.begin(); sample < samples.end(); ++sample)
		{
			elistener->dataAvailable(sample->data(), sample->info());
		}
	}*/
}
template<typename T>
dds::sub::LoanedSamples<T> RoqmeDataReader<T>::take()
{
	return dataReader.take();
}


template<typename T>
bool RoqmeDataReader<T>::waitAndTakeInstance(const T& sample, T& data, const dds::core::Duration& duration)
{
    bool dataReceived = false;
    try
    {
	waitSet.wait(duration);
	if (takeInstance(sample, data))
	{
	    dataReceived = true;
	}
    }
    catch(dds::core::Exception& e)
    {
	std::cerr << "ERROR: Exception: " << e.what() << std::endl;
    }
    return dataReceived;
}

template<typename T>
bool RoqmeDataReader<T>::waitAndTake(std::vector<dds::sub::Sample<T>>& data, const dds::core::Duration& duration)
{
    bool dataReceived = false;
    try
    {
	waitSet.wait(duration);
	if(take(data))
	{
	    dataReceived = true;
	}
    }
    catch(dds::core::Exception& e)
    {
	std::cerr << "ERROR: Exception: " << e.what() << std::endl;
    }
    return dataReceived;
}

template<typename T>
bool RoqmeDataReader<T>::take(std::vector<dds::sub::Sample<T>>& data)
{
    bool dataReceived = false;
    try
    {
	if(dataReader.take(data.begin()))
	{
	    dataReceived = true;
	}
    }
    catch(const dds::core::Exception& e)
    {
	std::cerr << "ERROR: Exception: " << e.what() << std::endl;
    }
    
    return dataReceived;
}

template<typename T>
void RoqmeDataReader<T>::close()
{

	dataReader.listener(0, dds::core::status::StatusMask::none());
}


template<typename T>
bool RoqmeDataReader<T>::takeInstance(const T& sample, T& data)
{
    bool dataReceived = false;
    try
    {
	// Implicit use of Selector
	dds::sub::LoanedSamples<T> samples = dataReader.select().instance(dataReader.lookup_instance(sample)).take();
	for (typename dds::sub::LoanedSamples<T>::const_iterator sample = samples.begin(); !terminated.trigger_value() && sample < samples.end(); ++sample)
	{
	    if(sample->info().valid())
	    {
		data = sample->data();
		dataReceived = true;
	    }
	}
    }
    catch(const dds::core::Exception& e)
    {
	std::cerr << "ERROR: Exception: key instance does not exist!." << std::endl << "More details: " << e.what() << std::endl;
    }
    return dataReceived;
}

}
