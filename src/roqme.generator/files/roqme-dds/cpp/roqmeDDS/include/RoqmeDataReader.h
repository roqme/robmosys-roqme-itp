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
 * This classs wrapps a DDS DataReader object
 */
template<typename T>
class RoqmeDataReader: public virtual dds::sub::DataReaderListener<T>, public virtual dds::sub::NoOpDataReaderListener<T>
{
public:
	/**
	 * Initializes the DataReader object.
	 * @param partitionName. Partition name used to read data
	 * @param topicName. The name of the topic
	 * @param elistener. Listener used in asynchronous subscription
	 * @param maxSamples. Max number of samples a DataReader can store
	 */
	RoqmeDataReader(const std::string& partitionName, 
			const std::string& topicName, 
			RoqmeDDSListener<T>* elistener = nullptr, 
			const std::string& filtered_expression = DEFAULT_FILTERED_EXPRESSION, 
			const int& maxSamples = -1);
	/**
	 * Synchronous data reception.
	 * @param sample. Topic instance
	 * @param data. Data received
	 * @param duration. Duration time the method will block waiting for data
	 */ 	
	bool waitAndTakeInstance(const T& sample, T& data, const dds::core::Duration& duration);
	/**
	 * Synchronous data reception.
	 * @param data. Data received
	 * @param duration. Duration time the method will block waiting for data
	 */
	bool waitAndTake(std::vector<dds::sub::Sample<T>>& data, const dds::core::Duration& duration);
	/**
	 * This method is executed when the DeadlineQos policy is missed
	 * @param the_reader. DataReader where the policy is missed
	 * @param status. Event information
	 */
	virtual void on_requested_deadline_missed(dds::sub::DataReader<T>& the_reader, const dds::core::status::RequestedDeadlineMissedStatus& status);
    /**
	 * This method is executed when new data is available (when a listener is used)
	 * @param the_reader. DataReader used to reade the data
	 */
	virtual void on_data_available(dds::sub::DataReader<T>& the_reader);
		/**
	 * This method is used to read data from DDS.
	 */
    dds::sub::LoanedSamples<T> take();

    void close();
	
private:
	/**
	 * It reads from DDS queues all the samples available of an instance
	 * @param key. Instance key
	 * @param data. Data obtained from DDS queues
	 */
	bool takeInstance(const T& key, T& data);
	/**
	 * It reads all the samples available in DDS queues.
	 * @param data. Data obtained from DDS queues
	 */
	bool take(std::vector<dds::sub::Sample<T>>& data);

private:
	/**
	 * DDS DataReader object
	 */
	dds::sub::DataReader<T> dataReader;
	/**
	 * Listener used to read data asynchronously
	 */
	std::unique_ptr<RoqmeDDSListener<T>> elistener;
    	/**
	 * DDS object used to configure synchronous data reception
	 */
	dds::core::cond::WaitSet waitSet;
	/**
	 * DDS GuardCondition
	 */ 
	dds::core::cond::GuardCondition terminated;
};

}

#endif // ROQMEDATAREADER_H
