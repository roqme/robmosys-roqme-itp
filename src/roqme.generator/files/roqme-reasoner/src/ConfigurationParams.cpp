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

#include "ConfigurationParams.h"

#include <iostream>
#include <fstream>
#include "string.h"
#include "c++/5/bits/stl_algo.h"

namespace Roqme
{

/*
 * Static class attributes
 */
ConfigurationParams* 	ConfigurationParams::m_instance;
string 					ConfigurationParams::m_filepath;
bool 					ConfigurationParams::m_loadAtFirst;
ParamEntry* 			ConfigurationParams::m_workingEntry;


/**
 * Class constructor.
 * @return An object instance.
 */
ConfigurationParams::ConfigurationParams()
{
	m_parameters = new multimap<string, ParamEntry*> ();
	vector<string>* paramNames = readParamNames();

	if(paramNames != NULL)
	{
		for (std::vector<string>::iterator it = paramNames->begin(); it != paramNames->end(); ++it)
		{
			m_parameters->insert (make_pair(*it, createEntry(*it)));
			if(m_loadAtFirst) load(*it);
		}
	}
}


/**
 * Class destructor.
 */
ConfigurationParams::~ConfigurationParams()
{
	for (multimap<string, ParamEntry*>::iterator it = m_parameters->begin();
			it!=m_parameters->end(); ++it)
	{
		unload( (*it).first );
	}
	m_parameters->clear();

	delete(m_parameters);
	delete(&m_filepath);
}


/**
 * This method sets the configuration file and the reading strategy. The user has
 * to call this method at the begining, before instantiation.
 * @param filepath Path to the configuration file.
 * @param loadAtFirst When true, it indicates that the parameters in the file have
 * to be loaded in memory at the begining. Otherwise, they are loaded on demand.
 */
void ConfigurationParams::settings(const string& filepath, const bool loadAtFirst)
{
	string aux = string(filepath);
	ifstream* file = new ifstream(aux.c_str());

	if(file->good()) {
		m_filepath = aux;
		m_loadAtFirst = loadAtFirst;
	}
	else {
		fprintf(stderr,"[ConfigurationParams] Invalid file path.\n");
		exit(EXIT_FAILURE);
	}
}


/**
 * As ConfigurationParams is a singleton class, this method is the way
 * to get the instance.
 * @return ConfigurationParams instance.
 */
ConfigurationParams* ConfigurationParams::instance()
{
	if(m_instance == NULL && !m_filepath.empty()) {
		m_instance = new ConfigurationParams();
	}
	return m_instance;
}


/**
 * It returns the most recently read parameter.
 * @return The most recently accessed parameter.
 */
ParamEntry* ConfigurationParams::workingEntry()
{
	return m_workingEntry;
}


/**
 * This methods allows users to obtain a specific parameter entry.
 * @param param The parameter name.
 * @return A parameter entry.
 */
ParamEntry* ConfigurationParams::getParam(const string& param)
{
	multimap<string, ParamEntry*>::iterator it = m_parameters->find(param);

	if(it != m_parameters->end()) {
		m_workingEntry = it->second;
	} else {
		m_workingEntry = NULL;
	}
	return m_workingEntry;
}


/**
 * This method creates and initializes an entry for a new parameter.
 * @param param The parameter name.
 * @return A parameter entry.
 */
ParamEntry* ConfigurationParams::createEntry(const string& param)
{
	ParamEntry* result = NULL;

	if(!param.empty())
	{
		result = new ParamEntry();
		result->m_name = param;
		result->m_length = 0;
		result->m_loaded = false;
		result->m_type = ParamTypeEnum::unknown;
		result->m_value = NULL;
	}
	return result;
}


/**
 * Method for loading in memory a specific parameter.
 * @param param The parameter name.
 * @return The parameter entry.
 */
ParamEntry* ConfigurationParams::load(const string& param)
{
	ParamEntry* entry = NULL;

	if(!param.empty())
	{
		entry = getParam(param);
		vector<string> * svalues = read(param);

		if(svalues != NULL)
		{
			int length = svalues->size();
			entry->m_length = length;
			entry->m_loaded = true;

			if(is_numeric(svalues->at(0)))
			{
				entry->m_type = ParamTypeEnum::number;
				entry->m_value = malloc(sizeof(double) * length);
				for(int i=0; i<length; i++)
					((double*)entry->m_value)[i] = atof(svalues->at(i).c_str());
			}
			else
			{
				string* values = svalues->data();

				string str;
				for(int i=0; i<length; i++) {
					string str = values[i];

					if(has_quotationMarks(str)) {
						values[i] = str.substr(1, str.length()-2);
					}
					else {
						values[i] = str;
					}
				}
				entry->m_value = values;
				entry->m_type = ParamTypeEnum::str;
			}
		}
		else {
			entry->m_length = 0;
			entry->m_loaded = false;
		}
	}
	return entry;
}


/**
 * Method for releasing a parameter that is loaded.
 * @param param The parameter name.
 */
void ConfigurationParams::unload(const string& param)
{
	if(!param.empty())
	{
		ParamEntry* entry = getParam(param);
		free(entry->m_value);
		entry->m_length = 0;
		entry->m_loaded = false;
	}
}


/**
 * Reads the value of a specific parameter in the configuration file.
 * @param param The parameter name.
 * @return A string vector containing the value (or values in case of arrays).
 */
vector<string> * ConfigurationParams::read(const string& param)
{
	vector<string> * result = NULL;
	ifstream* file = new ifstream(m_filepath.c_str());

	if(!file->is_open()) {
		fprintf(stderr,"[ConfigurationParams] read: Configuration file not found\n");
		exit(EXIT_FAILURE);
	}

	string line = string();
	string::size_type npos;

	bool found = false;

	while(getline(*file, line) && !found)
	{
		if(!is_comment(line))
		{
			// It removes spaces
			line.erase(remove_if(line.begin(), line.end(), ::isspace), line.end());

			npos = line.find('=');
			if(strcmp((line.substr(0,npos)).c_str(),param.c_str())==0)
			{
				found = true;
				result = string2vector(line.substr(npos+1));
			}
		}
	}
	file->close();
	delete file;
	return result;
}


/**
 * This method reads the parameter identifiers that are declared in the
 * configuration file.
 * @return A vector with the parameter names.
 */
vector<string>* ConfigurationParams::readParamNames()
{
	vector<string> * result = NULL;
	static ifstream* file = new ifstream(m_filepath.c_str());

	if(!file->is_open()) {
		//debugMsg("ConfigurationParams", "Configuration file not found");
		exit(EXIT_FAILURE);
	}

	result = new vector<string>();
	string line = string();

	while(getline(*file, line))
	{
		if(!is_comment(line))
		{
			// It removes spaces
			line.erase(remove_if(line.begin(), line.end(), ::isspace), line.end());
			result->push_back(line.substr(0, line.find('=')));
		}
	}
	file->close();
	delete file;
	return result;
}


/**
 * Auxiliary method for parsing a sequence of separated-by-commas values
 * into a vector.
 * @param s The input string.
 * @return Vector of string values.
 */
vector<string> * ConfigurationParams::string2vector(string const & s)
{
	vector<string> * values = new vector<string>();
	string * sub = new string(s);
	string::size_type find = s.find(',');
	while(find!=string::npos)
	{
		values->push_back(sub->substr(0,find));
		*sub = sub->substr(find+1);
		find = sub->find(',');
	}
	values->push_back(*sub);
	delete sub;
	return values;
}


/**
 * Auxiliary method for checking whether or not an input string is a comment.
 * @param s The input string.
 * @return True if it is a comment line, false otherwise.
 */
bool ConfigurationParams::is_comment(string const & s)
{
	return (strcmp((s.substr(0,2)).c_str(), "//") == 0);
}


/**
 * Auxiliary method for checking whether or not the an input string is a number.
 * @param s The input string.
 * @return True if it is a number, false otherwise.
 */
bool ConfigurationParams::is_numeric(const string& s)
{
	return !s.empty() && s.find_first_not_of("0123456789.") == string::npos;
}


/**
 * Auxiliary method for checking whether or not an input string has quotation marks.
 * @param s The input string.
 * @return True if it has quotation marks, false otherwise.
 */
bool ConfigurationParams::has_quotationMarks(const string& s)
{
	return (s[0] == '"' && s[s.length()-1] == '"');
}

}
