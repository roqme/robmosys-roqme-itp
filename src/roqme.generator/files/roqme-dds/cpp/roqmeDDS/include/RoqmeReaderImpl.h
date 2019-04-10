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
