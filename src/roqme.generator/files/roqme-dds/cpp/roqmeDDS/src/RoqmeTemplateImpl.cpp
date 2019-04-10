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

#include "RoqmeDataWriter.cpp"
#include "RoqmeDataReader.cpp"
namespace Roqme 
{
template class RoqmeDataWriter<RoqmeDDSTopics::RoqmeIntContext>;
template class RoqmeDataWriter<RoqmeDDSTopics::RoqmeUIntContext>;
template class RoqmeDataWriter<RoqmeDDSTopics::RoqmeDoubleContext>;
template class RoqmeDataWriter<RoqmeDDSTopics::RoqmeBoolContext>;
template class RoqmeDataWriter<RoqmeDDSTopics::RoqmeEventContext>;
template class RoqmeDataWriter<RoqmeDDSTopics::RoqmeEnumContext>;
template class RoqmeDataWriter<RoqmeDDSTopics::RoqmeObservation>;
template class RoqmeDataWriter<RoqmeDDSTopics::RoqmeEstimate>;

template class RoqmeDataReader<RoqmeDDSTopics::RoqmeIntContext>;
template class RoqmeDataReader<RoqmeDDSTopics::RoqmeUIntContext>;
template class RoqmeDataReader<RoqmeDDSTopics::RoqmeDoubleContext>;
template class RoqmeDataReader<RoqmeDDSTopics::RoqmeBoolContext>;
template class RoqmeDataReader<RoqmeDDSTopics::RoqmeEventContext>;
template class RoqmeDataReader<RoqmeDDSTopics::RoqmeEnumContext>;
template class RoqmeDataReader<RoqmeDDSTopics::RoqmeObservation>;
template class RoqmeDataReader<RoqmeDDSTopics::RoqmeEstimate>;
}
