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

#ifndef ROQMEINTWRITER_H
#define ROQMEINTWRITER_H

#include "RoqmeDataWriterWrapper.h"
#include "RoqmeConstantDefinitions.h"

namespace Roqme
{	

/**
 * This class provides a writer object for a RoqmeIntContext topic
 */
class RoqmeIntWriter: public RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeIntContext>
{
public:
	RoqmeIntWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME, const int& maxInstances = UNLIMITED_RESOURCES, const std::string& topicName = DEFAULT_TOPIC_INT_CONTEXT_NAME);
};

/**
 * This class provides a writer object for a RoqmeUIntContext topic
 */
class RoqmeUIntWriter: public RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeUIntContext>
{
public:
	RoqmeUIntWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME, const int& maxInstances = UNLIMITED_RESOURCES, const std::string& topicName = DEFAULT_TOPIC_UINT_CONTEXT_NAME);
};

/**
 * This class provides a writer object for a RoqmeBoolContext topic
 */
class RoqmeBoolWriter: public RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeBoolContext>
{
public:
	RoqmeBoolWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME, const int& maxInstances = UNLIMITED_RESOURCES, const std::string& topicName = DEFAULT_TOPIC_BOOL_CONTEXT_NAME);
};

/**
 * This class provides a writer object for a RoqmeDoubleContext topic
 */
class RoqmeDoubleWriter: public RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeDoubleContext>
{
public:
	RoqmeDoubleWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME, const int& maxInstances = UNLIMITED_RESOURCES, const std::string& topicName = DEFAULT_TOPIC_DOUBLE_CONTEXT_NAME);
};

/**
 * This class provides a writer object for a RoqmeEventContext topic
 */
class RoqmeEventWriter: public RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeEventContext>
{
public:
	RoqmeEventWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME, const int& maxInstances = UNLIMITED_RESOURCES, const std::string& topicName = DEFAULT_TOPIC_EVENT_CONTEXT_NAME);
};

/**
 * This class provides a writer object for a RoqmeEnumContext topic
 */
class RoqmeEnumWriter: public RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeEnumContext>
{
public:
	RoqmeEnumWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME, const int& maxInstances = UNLIMITED_RESOURCES, const std::string& topicName = DEFAULT_TOPIC_ENUM_CONTEXT_NAME);
};

/**
 * This class provides a writer object for a RoqmeObservation topic
 */
class RoqmeObservationWriter: public RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeObservation>
{
public:
	RoqmeObservationWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME, const int& maxInstances = UNLIMITED_RESOURCES, const std::string& topicName = DEFAULT_TOPIC_OBSERVATION_NAME);
};

/**
 * This class provides a writer object for a RoqmeEstimate topic
 */
class RoqmeEstimateWriter: public RoqmeDataWriterWrapper<RoqmeDDSTopics::RoqmeEstimate>
{
public:
	RoqmeEstimateWriter(const std::string& partitionName = DEFAULT_PARTITION_NAME, const int& maxInstances = UNLIMITED_RESOURCES, const std::string& topicName = DEFAULT_TOPIC_ESTIMATE_NAME);
};


} //roqme namespace

#endif // ROQMEINTWRITER_H
