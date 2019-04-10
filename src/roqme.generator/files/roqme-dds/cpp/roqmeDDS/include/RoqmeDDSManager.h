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

#ifndef _RoqmeDDSInterface__
#define _RoqmeDDSInterface__

#include "RoqmeConstantDefinitions.h"
#include "RoqmeDataWriter.h"
#include "RoqmeDataReader.h"


namespace Roqme
{

/**
 * Deprecated
 */
class RoqmeDDSManager
{
public:
	/**
	 * It creates RoqmeDDSManager instances.
	 * @param maxInstances. Max number of instances a DataWriter/DataReader can store in DDS. A default value specifies unlimited resources.
	 */
	RoqmeDDSManager(const int& maxInstances = -1);		
	/**
	 * It creates a DataWriter for RoqmeIntContext topics
	 * @param partitionName. Partition name used. If ommited, a default value will be used.
	 */
	void createIntContextWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME);
	/**
	 * It creates a DataWriter for RoqmeIntContext topics
	 * @param partitionName. Partition name used. If ommited, a default value will be used.
	 */
	void createUIntContextWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME);
	/**
	 * It creates a DataWriter for RoqmeIntContext topics
	 * @param partitionName. Partition name used. If ommited, a default value will be used.
	 */
	void createDoubleContextWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME);
	/**
	 * It creates a DataWriter for RoqmeIntContext topics
	 * @param partitionName. Partition name used. If ommited, a default value will be used.
	 */
	void createBoolContextWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME);
	/**
	 * It creates a DataWriter for RoqmeIntContext topics
	 * @param partitionName. Partition name used. If ommited, a default value will be used.
	 */
	void createEnumContextWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME);
	/**
	 * It creates a DataWriter for RoqmeIntContext topics
	 * @param partitionName. Partition name used. If ommited, a default value will be used.
	 */
	void createEventContextWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME);
	/**
	 * It creates a DataWriter for RoqmeIntContext topics
	 * @param partitionName. Partition name used. If ommited, a default value will be used.
	 */
	void createObservationWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME);
	/**
	 * It creates a DataWriter for RoqmeIntContext topics
	 * @param partitionName. Partition name used. If ommited, a default value will be used.
	 */
	void createEstimateWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME);
	/**
	 * It creates a DataReader for RoqmeIntContext topics
	 * @param elistener. Listener used for asynchronous data reception
	 * @param partitionName. Partition name used. If ommited, a default value will be used.
	 */
	void createIntContextReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeIntContext>* elistener = nullptr, 
									const std::string& filtered_expression = DEFAULT_FILTERED_EXPRESSION, 
									const std::string& partitionName = DEFAULT_PARTITION_NAME);	
	/**
	 * It creates a DataReader for RoqmeUIntContext topics
	 * @param elistener. Listener used for asynchronous data reception
	 * @param partitionName. Partition name used. If ommited, a default value will be used.
	 */
	void createUIntContextReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeUIntContext>* elistener = nullptr, 
									const std::string& filtered_expression = DEFAULT_FILTERED_EXPRESSION, 
									const std::string& partitionName = DEFAULT_PARTITION_NAME);	
	/**
	 * It creates a DataReader for RoqmeDoubleContext topics
	 * @param elistener. Listener used for asynchronous data reception
	 * @param partitionName. Partition name used. If ommited, a default value will be used.
	 */
	void createDoubleContextReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeDoubleContext>* elistener = nullptr, 
									const std::string& filtered_expression = DEFAULT_FILTERED_EXPRESSION, 
									const std::string& partitionName = DEFAULT_PARTITION_NAME);	
	/**
	 * It creates a DataReader for RoqmeBoolContext topics
	 * @param elistener. Listener used for asynchronous data reception
	 * @param partitionName. Partition name used. If ommited, a default value will be used.
	 */
	void createBoolContextReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeBoolContext>* elistener = nullptr, 
									const std::string& filtered_expression = DEFAULT_FILTERED_EXPRESSION, 
									const std::string& partitionName = DEFAULT_PARTITION_NAME);	
	/**
	 * It creates a DataReader for RoqmeEventContext topics
	 * @param elistener. Listener used for asynchronous data reception
	 * @param partitionName. Partition name used. If ommited, a default value will be used.
	 */
	void createEventContextReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeEventContext>* elistener = nullptr, 
									const std::string& filtered_expression = DEFAULT_FILTERED_EXPRESSION, 
									const std::string& partitionName = DEFAULT_PARTITION_NAME);	
	/**
	 * It creates a DataReader for RoqmeEnumContext topics
	 * @param elistener. Listener used for asynchronous data reception
	 * @param partitionName. Partition name used. If ommited, a default value will be used.
	 */
	void createEnumContextReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeEnumContext>* elistener = nullptr, 
									const std::string& filtered_expression = DEFAULT_FILTERED_EXPRESSION, 
									const std::string& partitionName = DEFAULT_PARTITION_NAME);	
	
	/**
	 * It creates a DataReader for RoqmeObservation topics
	 * @param elistener. Listener used for asynchronous data reception
	 * @param partitionName. Partition name used. If ommited, a default value will be used.
	 */
	void createObservationReader(	Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeObservation>* elistener = nullptr, 
									const std::string& filtered_expression = DEFAULT_FILTERED_EXPRESSION, 
									const std::string& partitionName = DEFAULT_PARTITION_NAME);	
	/**
	 * It creates a DataReader for RoqmeIntContext topics
	 * @param elistener. Listener used for asynchronous data reception
	 * @param partitionName. Partition name used. If ommited, a default value will be used.
	 */
	void createEstimateReader(		Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeEstimate>* elistener = nullptr, 
									const std::string& filtered_expression = DEFAULT_FILTERED_EXPRESSION, 
									const std::string& partitionName = DEFAULT_PARTITION_NAME);	
	/**
	 * Publishes a RoqmeIntContext topic sample
	 * @param data. Data that will be distributed
	 */
	void write(const RoqmeDDSTopics::RoqmeIntContext& data);	
	/**
	 * Publishes a RoqmeUIntContext topic sample
	 * @param data. Data that will be distributed
	 */
	void write(const RoqmeDDSTopics::RoqmeUIntContext& data);	
	/**
	 * Publishes a RoqmeDoubleContext topic sample
	 * @param data. Data that will be distributed
	 */
	void write(const RoqmeDDSTopics::RoqmeDoubleContext& data);	
	/**
	 * Publishes a RoqmeBoolContext topic sample
	 * @param data. Data that will be distributed
	 */
	void write(const RoqmeDDSTopics::RoqmeBoolContext& data);	
	/**
	 * Publishes a RoqmeEventContext topic sample
	 * @param data. Data that will be distributed
	 */
	void write(const RoqmeDDSTopics::RoqmeEventContext& data);	
	/**
	 * Publishes a RoqmeEnumContext topic sample
	 * @param data. Data that will be distributed
	 */
	void write(const RoqmeDDSTopics::RoqmeEnumContext& data);		
	/**
	 * Publishes a RoqmeObservation topic sample
	 * @param data. Data that will be distributed
	 */
	void write(const RoqmeDDSTopics::RoqmeObservation& data);
	/**
	 * Publishes a RoqmeEstimate topic sample
	 * @param data. Data that will be distributed
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
	 * Smart pointer to a RoqmeDataReader<RoqmeIntContext>
	 */
	std::unique_ptr<RoqmeDataReader<RoqmeDDSTopics::RoqmeIntContext>> intContextReaderPtr;
	/**
	 * Smart pointer to a RoqmeDataWriter<RoqmeIntContext>
	 */
	std::unique_ptr<RoqmeDataWriter<RoqmeDDSTopics::RoqmeIntContext>> intContextWriterPtr;
	/**
	 * Smart pointer to a RoqmeDataReader<RoqmeUIntContext>
	 */
	std::unique_ptr<RoqmeDataReader<RoqmeDDSTopics::RoqmeUIntContext>> uintContextReaderPtr;
	/**
	 * Smart pointer to a RoqmeDataWriter<RoqmeUIntContext>
	 */
	std::unique_ptr<RoqmeDataWriter<RoqmeDDSTopics::RoqmeUIntContext>> uintContextWriterPtr;
	/**
	 * Smart pointer to a RoqmeDataReader<RoqmeDoubleContext>
	 */
	std::unique_ptr<RoqmeDataWriter<RoqmeDDSTopics::RoqmeDoubleContext>> doubleContextWriterPtr;
	/**
	 * Smart pointer to a RoqmeDataReader<RoqmeBoolContext>
	 */
	std::unique_ptr<RoqmeDataReader<RoqmeDDSTopics::RoqmeDoubleContext>> doubleContextReaderPtr;
	/**
	 * Smart pointer to a RoqmeDataWriter<RoqmeBoolContext>
	 */
	std::unique_ptr<RoqmeDataReader<RoqmeDDSTopics::RoqmeBoolContext>> boolContextReaderPtr;
	/**
	 * Smart pointer to a RoqmeDataWriter<RoqmeBoolContext>
	 */
	std::unique_ptr<RoqmeDataWriter<RoqmeDDSTopics::RoqmeBoolContext>> boolContextWriterPtr;
	/**
	 * Smart pointer to a RoqmeDataReader<RoqmeEventContext>
	 */
	std::unique_ptr<RoqmeDataReader<RoqmeDDSTopics::RoqmeEventContext>> eventContextReaderPtr;
	/**
	 * Smart pointer to a RoqmeDataWriter<RoqmeEventContext>
	 */
	std::unique_ptr<RoqmeDataWriter<RoqmeDDSTopics::RoqmeEventContext>> eventContextWriterPtr;
	/**
	 * Smart pointer to a RoqmeDataReader<RoqmeEnumContext>
	 */
	std::unique_ptr<RoqmeDataReader<RoqmeDDSTopics::RoqmeEnumContext>> enumContextReaderPtr;
	/**
	 * Smart pointer to a RoqmeDataWriter<RoqmeEnumContext>
	 */
	std::unique_ptr<RoqmeDataWriter<RoqmeDDSTopics::RoqmeEnumContext>> enumContextWriterPtr;
	/**
	 * Smart pointer to a RoqmeDataReader<RoqmeObservation>
	 */
	std::unique_ptr<RoqmeDataReader<RoqmeDDSTopics::RoqmeObservation>> observationReaderPtr;
	/**
	 * Smart pointer to a RoqmeDataReader<RoqmeObservation>
	 */
	std::unique_ptr<RoqmeDataWriter<RoqmeDDSTopics::RoqmeObservation>> observationWriterPtr;	
	/**
	 * Smart pointer to a RoqmeDataReader<RoqmeEstimate>
	 */
	std::unique_ptr<RoqmeDataReader<RoqmeDDSTopics::RoqmeEstimate>> estimateReaderPtr;
	/**
	 * Smart pointer to a RoqmeDataWriter<RoqmeEstimate>
	 */
	std::unique_ptr<RoqmeDataWriter<RoqmeDDSTopics::RoqmeEstimate>> estimateWriterPtr;	
	/**
	 * Número máximos de samples que almacenarán las entidades DDS 
	 */
	int samplesResourceLimits;
};

} //namespace Roqme

#endif
