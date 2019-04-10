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

#ifndef ROQMEREADERT_H
#define ROQMEREADERT_H
#include "RoqmeDataReader.h"
#include <RoqmeDDSException.h>

namespace Roqme
{

template <typename T>
class RoqmeDataReaderWrapper
{
protected:
	RoqmeDataReaderWrapper(Roqme::RoqmeDDSListener<T>* elistener, const std::string& partitionName, const int& samplesResourceLimits, const std::string& filteredExpression, const std::string& topicName)
	{
		try
		{
			reader_ptr = std::unique_ptr<RoqmeDataReader<T>>	( new RoqmeDataReader<T>(	partitionName, 
																							topicName, 
																							elistener, 
																							filteredExpression, 
																							samplesResourceLimits ));
		}
		catch(...)
		{
			throw RoqmeDDSException("Error creating DDS DataReader: Could not possible to create unique_ptr!");
		}	
	}
public:	
	dds::sub::LoanedSamples<T> take()
	{
		
		return reader_ptr->take();
	}
	
	void close()
	{
		reader_ptr->close();
	}

private:
	std::unique_ptr<RoqmeDataReader<T>> reader_ptr;
};

}

#endif // ROQMEREADERT_H
