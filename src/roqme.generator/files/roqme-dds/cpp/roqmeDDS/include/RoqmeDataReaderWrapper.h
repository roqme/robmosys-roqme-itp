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
