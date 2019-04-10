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
