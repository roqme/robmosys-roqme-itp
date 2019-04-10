#ifndef ROQMECONSTANTDEFINITIONS_H
#define ROQMECONSTANTDEFINITIONS_H

#include <string>

namespace Roqme
{
	/**
 * Nombre de la partición DDS utilizada por defecto.	
 */
const std::string DEFAULT_PARTITION_NAME = "Roqme DDS partition";
/**
 * Nombre del tópico RoqmeContext utilizado por defecto. Este nombre es utilizado por DDS para indentificar el tópico internamente.
 */
const std::string DEFAULT_TOPIC_INT_CONTEXT_NAME = "RoqmeIntContext";
/**
 * Nombre del tópico RoqmeContext utilizado por defecto. Este nombre es utilizado por DDS para indentificar el tópico internamente.
 */
const std::string DEFAULT_TOPIC_UINT_CONTEXT_NAME = "RoqmeUIntContext";
/**
 * Nombre del tópico RoqmeContext utilizado por defecto. Este nombre es utilizado por DDS para indentificar el tópico internamente.
 */
const std::string DEFAULT_TOPIC_DOUBLE_CONTEXT_NAME = "RoqmeDoubleContext";
/**
 * Nombre del tópico RoqmeContext utilizado por defecto. Este nombre es utilizado por DDS para indentificar el tópico internamente.
 */
const std::string DEFAULT_TOPIC_BOOL_CONTEXT_NAME = "RoqmeBoolContext";
/**
 * Nombre del tópico RoqmeContext utilizado por defecto. Este nombre es utilizado por DDS para indentificar el tópico internamente.
 */
const std::string DEFAULT_TOPIC_EVENT_CONTEXT_NAME = "RoqmeEventContext";
/**
 * Nombre del tópico RoqmeContext utilizado por defecto. Este nombre es utilizado por DDS para indentificar el tópico internamente.
 */
const std::string DEFAULT_TOPIC_ENUM_CONTEXT_NAME = "RoqmeEnumContext";
/**
 * Nombre del tópico RoqmeObservation utilizado por defecto. Este nombre es utilizado por DDS para indentificar el tópico internamente.
 */
const std::string DEFAULT_TOPIC_OBSERVATION_NAME = "RoqmeObservation";
/**
 * Nombre del tópico RoqmeObservation utilizado por defecto. Este nombre es utilizado por DDS para indentificar el tópico internamente.
 */
const std::string DEFAULT_TOPIC_ESTIMATE_NAME = "RoqmeEstimate";

const int UNLIMITED_RESOURCES = -1;

}

#endif // ROQMECONSTANTDEFINITIONS_H
