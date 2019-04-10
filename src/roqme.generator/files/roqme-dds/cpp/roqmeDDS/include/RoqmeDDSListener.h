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

#ifndef CONTEXTREADERLISTENER_H
#define CONTEXTREADERLISTENER_H


namespace Roqme
{

/**
 * This class is used for asynchronous data subscription
 **/	
template <typename T>
class RoqmeDDSListener 
{
public:
	
	virtual ~RoqmeDDSListener(){}

	/**
	 * This method is executed when new data is available
	 * @param data. Data received
	 */
    virtual void dataAvailable(const T& data, const dds::sub::SampleInfo& sampleInfo) = 0;
	
	virtual void dataAvailable(dds::sub::DataReader<T>& dr)
	{
		dds::sub::LoanedSamples<T> samples = dr.take();
		if(samples.length() > 0 && (*samples.begin()).info().valid())
		{
			for (auto sample = samples.begin(); sample < samples.end(); ++sample)
			{
				dataAvailable(sample->data(), sample->info());
			}
		}
	}

};

} // namespace

#endif // CONTEXTREADERLISTENER_H
