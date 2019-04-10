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
