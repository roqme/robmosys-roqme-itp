//  This file belongs to the RoQME toolchain.
//  Copyright (C) 2019  University of Extremadura, University of Málaga, Biometric Vox.
//
//  RoQME is free software; you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation; either version 3 of the License, or
//  any later version.
//
//  RoQME is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
//
//  GNU GPLv3 link: http://www.gnu.org/licenses/gpl-3.0.html

#ifndef ROQME_CONFIGURATIONPARAMS_H
#define ROQME_CONFIGURATIONPARAMS_H

#define GET_MACRO(_1,_2,NAME,...) NAME
#define PARAM(...) GET_MACRO(__VA_ARGS__, PARAM2, PARAM1)(__VA_ARGS__)
#define PARAM1(attr) PARAM1_##attr
#define PARAM2(id, attr) PARAM2_##attr(id)

#define PARAM1_numarray		(double*)ConfigurationParams::workingEntry()->getValue()
#define PARAM2_numarray(id)	(double*)ConfigurationParams::instance()->getParam(id)->getValue()
#define PARAM1_strarray		(string*)ConfigurationParams::workingEntry()->getValue()
#define PARAM2_strarray(id)	(string*)ConfigurationParams::instance()->getParam(id)->getValue()
#define PARAM1_str			    *((string*)ConfigurationParams::workingEntry()->getValue())
#define PARAM2_str(id)		    *((string*)ConfigurationParams::instance()->getParam(id)->getValue())
#define PARAM1_number		    *((double*)ConfigurationParams::workingEntry()->getValue())
#define PARAM2_number(id)	    *((double*)ConfigurationParams::instance()->getParam(id)->getValue())
#define PARAM1_length		    ConfigurationParams::workingEntry()->getLength()
#define PARAM2_length(id)	    ConfigurationParams::instance()->getParam(id)->getLength()
#define PARAM1_isset			(ConfigurationParams::workingEntry() != NULL)
#define PARAM2_isset(id)		(ConfigurationParams::instance()->getParam(id) != NULL)

#include <vector>
#include <string>
#include <map>

using std::string;
using std::multimap;
using std::vector;
using std::ifstream;

namespace Roqme
{

/**
 * Enumeration to identify the data type of a parameter.
 */
enum ParamTypeEnum {

	/** Unknown data type */
	unknown = 0,

	/** Numeric type */
	number = 1,

	/** String type */
	str = 2
};


/**
 * @class ParamEntry
 * Auxiliary class to save all the information of a parameter.
 *
 * @author Juan Francisco Inglés Romero
 */
class ParamEntry {

	friend class ConfigurationParams;

protected:
	string 			m_name;
	bool 			m_loaded;
	void* 			m_value;
	int 			m_length;
	ParamTypeEnum 	m_type;

public:
	string			getName()		{ return m_name;	}
	bool			isLoaded()		{ return m_loaded;	}
	void*			getValue()		{ return m_value;	}
	int				getLength()		{ return m_length;	}
	ParamTypeEnum	getType()		{ return m_type;	}
};


/**
 * @class ConfigurationParams
 * Singleton class for managing the parameters defined in a configuration file.
 *
 * <H3>Example usage</H3>
 * @code
 *
 * // Sets the cofiguration file path
 * ConfigurationParams::settings("../settings.txt");
 *
 * ConfigurationParams* config = ConfigurationParams::instance();
 *
 * // Reads a number
 * double param1 = *((double*) config->getParam("param1")->getValue());
 *
 * // Reads a string
 * string param2 = *((string*) config->getParam("param2")->getValue());
 *
 * // Reads an array of numbers
 * double* param3 = (double*) config->getParam("param3")->getValue();
 *
 * // Reads an array of strings
 * string* param4 = (string*) config->getParam("param4")->getValue();
 *
 * // The previous sentences can be simplified using the macro PARAM
 * double param1 = PARAM("param1", number);
 * string param2 = PARAM("param2", str);
 * double* param3 = PARAM("param3", numarray);
 * string* param4 = PARAM("param4", strarray);
 *
 * // The macro PARAM also allows users to check availability (e.g., PARAM(id, isset))
 * // and the length of an array (e.g., PARAM(id, length))
 *
 * double param1;
 *
 * if(PARAM("param1", isset))
 * 	param1 = PARAM(number); // Remembers the parameter id set in the last query
 * else
 * 	param1 = 0;
 * @endcode
 * <H3>File format</H3>
 *
 * @code
 *
 * // This is a comment and below a numeric parameter
 * param1 = 342.12
 *
 * // A string parameter
 * param2 = /path/to/some/resource
 *
 * // An alternative way to define string parameters
 * param2 = "/path/to/some/resource"
 *
 * // An array of numbers
 * param3 = 12, 34.1, 56.7, 19, 44
 *
 * // An array of strings
 * param4 = value1, value2, value3
 *
 * @endcode
 *
 * @author Juan Francisco Inglés Romero
 */
class ConfigurationParams
{

private:

	static ConfigurationParams* m_instance;
	static string m_filepath;
	static bool m_loadAtFirst;
	static ParamEntry* m_workingEntry;

	multimap<string, ParamEntry*>* m_parameters;

public:

	~ConfigurationParams();

	static void settings(const string& filepath, const bool loadAtFirst = true);
	static ConfigurationParams* instance();
	static ParamEntry* workingEntry();

	ParamEntry* load(const string& param);
	void unload(const string& param);

	ParamEntry* getParam(const string& param);

protected:

	ConfigurationParams();

	ParamEntry* createEntry(const string& param);

	vector<string>* read(const string& param);
	vector<string>* readParamNames();
	vector<string>* string2vector(const string& s);

	bool is_comment(const string& line);
	bool is_numeric(const string& s);
	bool has_quotationMarks(const string& s);
};
}

#endif // ROQME_CONFIGURATIONPARAMS_H
