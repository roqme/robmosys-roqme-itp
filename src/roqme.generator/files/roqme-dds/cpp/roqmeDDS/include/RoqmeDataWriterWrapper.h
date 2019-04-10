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

#ifndef ROQMEWRITERINTERFACE_H
#define ROQMEWRITERINTERFACE_H

#include <memory> //@
#include "RoqmeDataWriter.h"
#include "RoqmeDDSException.h"


namespace Roqme
{

template <typename T>
class RoqmeDataWriterWrapper
{
public:
	/**
	 * It publishes a RoqmeContext instance
	 * @param data. Data type that will be sent
	 */
	void write(const T& data)	
	{
		if(writer_ptr == nullptr)
		{
			throw RoqmeDDSException("Error in write operation. writer_ptr has not been initialized!");
		}
		else
		{
			writer_ptr->write(data);
		}
	}

protected:
	/**
	 * It creates a DataWriter that allows to send RoqmeContext topics.
	 * @param partitionName. Partition name used to publish data. It is optional, if not used, a default value will be used
	 */
	RoqmeDataWriterWrapper(const std::string& partitionName, const int& samplesResourceLimits, const std::string& topicName)
	{
		try
		{
			writer_ptr = 
				std::unique_ptr<RoqmeDataWriter<T>>
				(
					new RoqmeDataWriter<T>(partitionName, topicName, samplesResourceLimits)
				);
		}
		catch(...)
		{
			throw RoqmeDDSException("Error creating DDS DataWriter: Could not possible to create unique_ptr!");
		}
	}

protected:
	/**
	 * Smart pointer to a RoqmeDataWriter object.
	 */
	std::unique_ptr<RoqmeDataWriter<T>> writer_ptr;

};

} //roqme namespace

#endif // ROQMEWRITERINTERFACE_H
