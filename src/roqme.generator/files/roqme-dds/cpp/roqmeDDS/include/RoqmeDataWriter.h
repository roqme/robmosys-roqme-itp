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

#ifndef _RoqmeDataWriter_
#define _RoqmeDataWriter_
#include "RoqmeDDSTopics_DCPS.hpp"
#include <dds/dds.hpp> //@
#include "RoqmeDDSException.h"

namespace Roqme 
{

/**
 * This classs wrapps a DDS DataReader object
 */
template<typename T>
class RoqmeDataWriter
{
public:
	/**
	 * Initializes the DataWriter object.
	 * @param partitionName. Partition name used to publish data
	 * @param topicName. The name of the topic
	 * @param maxSamples. Max number of samples a DataWriter can store
	 */
	RoqmeDataWriter(const std::string& partitionName, const std::string& topicName, const int& maxSamples = -1);
	/**
	 * It publishes a data
	 * @param data. Data to be sent
	 */
	int write(const T& data);

private:
	/**
	 * DDS DataWriter
	 */
	dds::pub::DataWriter<T> dataWriter;
};

}

#endif
