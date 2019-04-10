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

#ifndef ROQMECONSTANTDEFINITIONS_H
#define ROQMECONSTANTDEFINITIONS_H

#include <string>

namespace Roqme
{
/**
 * Partition name used by default.
 */	
const std::string DEFAULT_PARTITION_NAME = "Roqme DDS partition";
/**
 * RoqmeContext topic name used by default. This name is used by DDS to identify the topic internally.
 */
const std::string DEFAULT_TOPIC_INT_CONTEXT_NAME = "RoqmeIntContext";
/**
 * RoqmeContext topic name used by default. This name is used by DDS to identify the topic internally.
 */
const std::string DEFAULT_TOPIC_UINT_CONTEXT_NAME = "RoqmeUIntContext";
/**
 * RoqmeContext topic name used by default. This name is used by DDS to identify the topic internally.
 */
const std::string DEFAULT_TOPIC_DOUBLE_CONTEXT_NAME = "RoqmeDoubleContext";
/**
 * RoqmeContext topic name used by default. This name is used by DDS to identify the topic internally.
 */
const std::string DEFAULT_TOPIC_BOOL_CONTEXT_NAME = "RoqmeBoolContext";
/**
 * RoqmeContext topic name used by default. This name is used by DDS to identify the topic internally.
 */
const std::string DEFAULT_TOPIC_EVENT_CONTEXT_NAME = "RoqmeEventContext";
/**
 * RoqmeContext topic name used by default. This name is used by DDS to identify the topic internally.
 */
const std::string DEFAULT_TOPIC_ENUM_CONTEXT_NAME = "RoqmeEnumContext";
/**
 * RoqmeContext topic name used by default. This name is used by DDS to identify the topic internally.
 */
const std::string DEFAULT_TOPIC_OBSERVATION_NAME = "RoqmeObservation";
/**
 * RoqmeContext topic name used by default. This name is used by DDS to identify the topic internally.
 */
const std::string DEFAULT_TOPIC_ESTIMATE_NAME = "RoqmeEstimate";
/**
 * It defines the unlimited_resource value
 */
const int UNLIMITED_RESOURCES = -1;

}

#endif // ROQMECONSTANTDEFINITIONS_H
