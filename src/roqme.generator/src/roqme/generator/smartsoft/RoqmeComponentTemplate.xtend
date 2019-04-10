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

package roqme.generator.smartsoft
import org.eclipse.xtext.generator.IFileSystemAccess2

import roqme.metamodel.mapping.MappingModel
import roqme.metamodel.mapping.Monitor 
import java.util.Vector
import org.ecore.service.communicationPattern.QueryPattern
import org.ecore.service.communicationPattern.PushPattern
import org.ecore.service.communicationPattern.SendPattern
import org.ecore.service.communicationPattern.EventPattern
import roqme.metamodel.mapping.Period
import roqme.metamodel.mapping.MinDiffBtwUpdates
import java.util.Map

class RoqmeComponentTemplate
{
	private String projectName;
	private String rootPath;
	
	new (String projectName, boolean createProject) {
		this.projectName = projectName;
		this.rootPath = if (createProject) projectName + "/" else "";
	}
	
	def compile(MappingModel mm, IFileSystemAccess2 fsa) ''' 
		«fsa.generateFile(rootPath + "smartsoft/CMakeLists.txt", generateCMakeLists(mm))»
        «fsa.generateFile(rootPath + ".classpath", generateClassPath(mm))»
        «fsa.generateFile(rootPath + ".cproject", generateCProject(mm))»
        «fsa.generateFile(rootPath + ".project", generateProject(mm))»
        «fsa.generateFile(rootPath + ".settings/language.settings", generateLanguageSettings(mm))»
    	«fsa.generateFile(rootPath + "representations.aird", generateRepresentations(mm))»        
        «fsa.generateFile(rootPath + "model/" + projectName + ".component", generateComponentFile(mm, fsa))»
        «fsa.generateFile(rootPath + "model/" + projectName + ".componentDocumentation", generateComponentDocFile(mm, fsa))»
        «fsa.generateFile(rootPath + "model/" + projectName + ".componentParameters", generateComponentParamFile(mm, fsa))»
        «generateSmartSoftSrcFolder(mm, fsa)»
    '''
   //TODO: Arreglar lo del Period. Falta el event!
   def generateComponentFile(MappingModel mm, IFileSystemAccess2 fsa) '''
	ComponentDefinition «projectName» 
	{	
       	«FOR monitor : mm.monitors»
	       	«var String[] segments = monitor.service.eContainer.toString.split(' ')»
			«val String repositoryNameAux = segments.get(segments.length-1)»
			«val String repositoryName = repositoryNameAux.substring(0, repositoryNameAux.length-1)» 		
			«FOR pattern : monitor.service.eContents »
				«IF pattern instanceof QueryPattern»
		RequestPort «monitor.service.name»Req«monitor.context.name.toFirstUpper()» implements «repositoryName».«monitor.service.name»{}
		Activity «monitor.service.name»ReqActivity«monitor.context.name.toFirstUpper()» {
			RequestPortLink «monitor.service.name»Req«monitor.context.name.toFirstUpper()»
					«FOR options : monitor.opts»
						«IF options instanceof Period»
						«val period=options as Period»
			DefaultTrigger PeriodicTimer «period.value».0 Hz		
						«ENDIF»
					«ENDFOR»
			
		}
				«ELSEIF pattern instanceof PushPattern || pattern instanceof SendPattern || pattern instanceof EventPattern»	
		InputPort «monitor.service.name»In«monitor.context.name.toFirstUpper()»  implements «repositoryName».«monitor.service.name»{}
		InputHandler «monitor.service.name»InHandler«monitor.context.name.toFirstUpper()» triggeredFrom «monitor.service.name»In«monitor.context.name.toFirstUpper()» {}
				«ENDIF»
			«ENDFOR»
       «ENDFOR»
		Activity EstimateActivity
		{
			DefaultTrigger PeriodicTimer 10.0 Hz
		} 
		OutputPort EstimateServiceOut implements CommRoqmeEstimate.EstimateService realizedBy EstimateActivity {}
	}
    '''
    def generateComponentDocFile(MappingModel mm, IFileSystemAccess2 fsa) '''
       ComponentDocumentation «projectName» {
       
       }
    '''
    def generateComponentParamFile(MappingModel mm, IFileSystemAccess2 fsa) '''
      ComponentParameter «projectName»Params component «projectName» {
      
      }
    '''
    
	def Map<String, Integer> getElementPatterns(MappingModel mm)
    {
    	var Map<String, Integer> mapType
    	
    	return mapType	
    } 
    
 	def generateSmartSoftSrcFolder(MappingModel mm, IFileSystemAccess2 fsa) '''
       	«FOR monitor : mm.monitors»
	       	«var String communicationType = monitor.service.eClass.name»
	       	«IF (communicationType.contains("JoiningService") || communicationType.contains("ForkingService"))»       		
				«fsa.generateFile(rootPath + "smartsoft/src/" + monitor.service.name + "InHandler" + monitor.context.name.toFirstUpper() +".hh", generateHandlersHH(monitor))»
				«fsa.generateFile(rootPath + "smartsoft/src/" + monitor.service.name + "InHandler" + monitor.context.name.toFirstUpper() +".cc", generateHandlersCC(monitor))»
			«ELSEIF communicationType.contains("RequestAnswerService")»
				«fsa.generateFile(rootPath + "smartsoft/src/" + monitor.service.name + "ReqActivity" + monitor.context.name.toFirstUpper() +".hh", generateActivityHH(monitor))»
				«fsa.generateFile(rootPath + "smartsoft/src/" + monitor.service.name + "ReqActivity" + monitor.context.name.toFirstUpper() +".cc", generateActivityCC(monitor))»
       		«ENDIF»
       «ENDFOR»
       «fsa.generateFile(rootPath + "smartsoft/src/EstimateActivity.hh", generateEstimateActivityHH())»
       «fsa.generateFile(rootPath + "smartsoft/src/EstimateActivity.cc", generateEstimateActivityCC())»
	   «fsa.generateFile(rootPath + "smartsoft/src/EstimateListener.hh", generateEstimateListenerHH())»
       «fsa.generateFile(rootPath + "smartsoft/src/EstimateListener.cc", generateEstimateListenerCC())»
    '''
   
    //TODO: completar con todos los tipos de datos
    def generateHandlersHH(Monitor monitor) '''
 		«var String type = monitor.sourceType»
 		«var String roqmeType = getType(type)»
     	«var String roqmetypelower = roqmeType.toLowerCase()»
    	«var String[] segments = monitor.service.eContainer.toString.split(' ')»
		«val String repositoryNameAux = segments.get(segments.length-1)»
		«val String repositoryName = repositoryNameAux.substring(0, repositoryNameAux.length-1)» 

		
		#ifndef _«monitor.service.name.toUpperCase()»INHANDLER«monitor.context.name.toFirstUpper()»_HH
		#define _«monitor.service.name.toUpperCase()»INHANDLER«monitor.context.name.toFirstUpper()»_HH
		
		#include "«monitor.service.name»InHandler«monitor.context.name.toFirstUpper()»Core.hh"
		#include <RoqmeWriterImpl.h>
			
		class «monitor.service.name»InHandler«monitor.context.name.toFirstUpper()» : public «monitor.service.name»InHandler«monitor.context.name.toFirstUpper()»Core
		{		
		public:
			«FOR pattern : monitor.service.eContents »
			«IF pattern instanceof PushPattern»
				«var dad=pattern  as PushPattern»
			«monitor.service.name»InHandler«monitor.context.name.toFirstUpper()»(Smart::InputSubject<«repositoryName»::«dad.dataType.name»> *subject, const int &prescaleFactor=1);
			«ELSEIF pattern instanceof SendPattern»
				«var dad=pattern  as SendPattern»
			«monitor.service.name»InHandler«monitor.context.name.toFirstUpper()»(Smart::InputSubject<«repositoryName»::«dad.dataType.name»> *subject, const int &prescaleFactor=1);
			«ELSEIF pattern instanceof EventPattern»
				«var dad=pattern  as EventPattern»
			«monitor.service.name»InHandler«monitor.context.name.toFirstUpper()»(Smart::InputSubject<«repositoryName»::«dad.eventType.name»> *subject, const int &prescaleFactor=1);
			«ENDIF»
			«ENDFOR»
			virtual ~«monitor.service.name»InHandler«monitor.context.name.toFirstUpper()»();
			
			«FOR pattern : monitor.service.eContents »
			«IF pattern instanceof PushPattern»
				«var dad=pattern  as PushPattern»
			virtual void on_«monitor.service.name»In«monitor.context.name.toFirstUpper()»(const «repositoryName»::«dad.dataType.name» &input);
			«ELSEIF pattern instanceof SendPattern»
				«var dad=pattern  as SendPattern»
			virtual void on_«monitor.service.name»In«monitor.context.name.toFirstUpper()»(const «repositoryName»::«dad.dataType.name» &input);
			«ELSEIF pattern instanceof EventPattern»
				«var dad=pattern  as EventPattern»
			virtual void on_«monitor.service.name»In«monitor.context.name.toFirstUpper()»(const «repositoryName»::«dad.eventType.name» &input);
			«ENDIF»
			«ENDFOR»
			
		private:
			Roqme::Roqme«roqmeType»Writer «roqmetypelower»_dw;
			«FOR options : monitor.opts»
				«IF options instanceof MinDiffBtwUpdates»
				bool activatedFilter;	
				«ENDIF»
			«ENDFOR»
		};
		
		#endif
    '''
    
  	def String getType(String datatype)
    {
    	var String type = datatype
    	return type	
    } 
    
    
    def String getAttribute(String fields)
    {
    	var String res  = ""
    	var int posicion_inicio = 0
    	var boolean cond = false
	    while(cond==false)
	    {
	        var int posicion_actual = fields.indexOf('.', posicion_inicio);
	        if(posicion_actual!=-1){
	        	var String field = fields.substring(posicion_inicio, posicion_actual)
	        	res = res.concat(".get"+ field.toFirstUpper + "()")
	            posicion_inicio = posicion_actual+1;
	        }else{
	        	var String field = fields.substring(posicion_inicio)
	        	res = res.concat(".get"+ field.toFirstUpper + "()")
	        	cond = true        	
	        }
	        
	    } 
  		return res
    }
   			
    def generateHandlersCC(Monitor monitor) '''
    	«val String monitorServiceName = monitor.service.name»
    	«var String source = monitor.source»
 		«var String type = monitor.sourceType»
 		«var String roqmeType = getType(type)»
     	«var String roqmetypelower = roqmeType.toLowerCase()»
    	«var String[] segments = monitor.service.eContainer.toString.split(' ')»
		«val String repositoryNameAux = segments.get(segments.length-1)»
		«val String repositoryName = repositoryNameAux.substring(0, repositoryNameAux.length-1)»
		«var String attribute = getAttribute(source)»
		 
		#include "«monitor.service.name»InHandler«monitor.context.name.toFirstUpper()».hh"
		#include <iostream>
		
		«FOR pattern : monitor.service.eContents »
		«IF pattern instanceof PushPattern»
			«var dad=pattern  as PushPattern»
		«monitorServiceName»InHandler«monitor.context.name.toFirstUpper()»::«monitorServiceName»InHandler«monitor.context.name.toFirstUpper()»(Smart::InputSubject<«repositoryName»::«dad.dataType.name»> *subject, const int &prescaleFactor)
		«ELSEIF pattern instanceof SendPattern»
			«var dad=pattern  as SendPattern»
		«monitorServiceName»InHandler«monitor.context.name.toFirstUpper()»::«monitorServiceName»InHandler«monitor.context.name.toFirstUpper()»(Smart::InputSubject<«repositoryName»::«dad.dataType.name»> *subject, const int &prescaleFactor)
		«ELSEIF pattern instanceof EventPattern»
			«var dad=pattern  as EventPattern»
		«monitorServiceName»InHandler«monitor.context.name.toFirstUpper()»::«monitorServiceName»InHandler«monitor.context.name.toFirstUpper()»(Smart::InputSubject<«repositoryName»::«dad.eventType.name»> *subject, const int &prescaleFactor)
		«ENDIF»
		«ENDFOR»
		:	«monitorServiceName»InHandler«monitor.context.name.toFirstUpper()»Core(subject, prescaleFactor)
		{
			std::cout << "constructor «monitorServiceName»InHandler\n";
			«FOR options : monitor.opts»
				«IF options instanceof MinDiffBtwUpdates»
				activatedFilter = false;	
				«ENDIF»
			«ENDFOR»
		}
		«monitorServiceName»InHandler«monitor.context.name.toFirstUpper()»::~«monitorServiceName»InHandler«monitor.context.name.toFirstUpper()»() 
		{
			std::cout << "destructor «monitorServiceName»InHandler«monitor.context.name.toFirstUpper()»\n";
		}
		
		«FOR pattern : monitor.service.eContents »
		«IF pattern instanceof PushPattern»
			«var dad=pattern  as PushPattern»
		void «monitorServiceName»InHandler«monitor.context.name.toFirstUpper()»::on_«monitorServiceName»In«monitor.context.name.toFirstUpper()»(const «repositoryName»::«dad.dataType.name» &input)
		«ELSEIF pattern instanceof SendPattern»
			«var dad=pattern  as SendPattern»
		void «monitorServiceName»InHandler«monitor.context.name.toFirstUpper()»::on_«monitorServiceName»In«monitor.context.name.toFirstUpper()»(const «repositoryName»::«dad.dataType.name» &input)
		«ELSEIF pattern instanceof EventPattern»
			«var dad=pattern  as EventPattern»
		void «monitorServiceName»InHandler«monitor.context.name.toFirstUpper()»::on_«monitorServiceName»In«monitor.context.name.toFirstUpper()»(const «repositoryName»::«dad.eventType.name» &input)
		«ENDIF»
		«ENDFOR»
		{
			«var Boolean existsMinDiffBtw = false»
			«var Double minDiffBtwValue = 0.0»
			«FOR options : monitor.opts»
				«IF options instanceof MinDiffBtwUpdates»
					«{existsMinDiffBtw = true; ""}»
					«val minDiffBtw=options as MinDiffBtwUpdates»
					«{minDiffBtwValue = minDiffBtw.value;""}»
				«ELSE»
				«ENDIF»
			«ENDFOR»
			
			«IF existsMinDiffBtw == true»
				const double minDiffBtwUpdates = «minDiffBtwValue»;
				bool manda = true;
				double current = input«attribute»;
				static double prevValue;
				if(activatedFilter)
				{
					if(fabs(current-prevValue) < minDiffBtwUpdates)
					{
						manda = false;
					}
					else
					{
						manda = true;
					}
				}
				if(manda)
				{
					try
					{
						RoqmeDDSTopics::Roqme«roqmeType»Context «roqmetypelower»Context;
						«roqmetypelower»Context.name("«monitor.context.name»");
						«IF roqmeType.equals("Enum")»
						«roqmetypelower»Context.value().push_back(input«attribute».to_string());
						«ELSE»
						«roqmetypelower»Context.value().push_back(input«attribute»);
						«ENDIF»
						std::cout << "Publishing data context" << std::endl;
						«roqmetypelower»_dw.write(«roqmetypelower»Context);
						activatedFilter = true;
					}
					catch(Roqme::RoqmeDDSException& e)
					{
						std::cerr << e.what() << std::endl;
					}
				}
				prevValue = current;
			«ELSE»
				try
				{
					RoqmeDDSTopics::Roqme«roqmeType»Context «roqmetypelower»Context;
					«roqmetypelower»Context.name("«monitor.context.name»");
					«IF roqmeType.equals("Enum")»
					«roqmetypelower»Context.value().push_back(input«attribute».to_string());
					«ELSE»
					«roqmetypelower»Context.value().push_back(input«attribute»);
					«ENDIF»
					std::cout << "Publishing data context" << std::endl;
					«roqmetypelower»_dw.write(«roqmetypelower»Context);
				}
				catch(Roqme::RoqmeDDSException& e)
				{
					std::cerr << e.what() << std::endl;
				}
			«ENDIF»
			
			
		}
    '''
    
    def generateActivityHH(Monitor monitor) '''
    	«var String monitorServiceName = monitor.service.name»
 		«var String type = monitor.sourceType»
 		«var String roqmeType = getType(type)»
     	«var String roqmetypelower = roqmeType.toLowerCase()»
		#ifndef _«monitorServiceName.toUpperCase()»REQACTIVITY«monitor.context.name.toFirstUpper()»_HH
		#define _«monitorServiceName.toUpperCase()»REQACTIVITY«monitor.context.name.toFirstUpper()»_HH
		
		#include "«monitorServiceName»ReqActivity«monitor.context.name.toFirstUpper()»Core.hh"
		#include <RoqmeWriterImpl.h>
		
		class «monitorServiceName»ReqActivity«monitor.context.name.toFirstUpper()»  : public «monitorServiceName»ReqActivity«monitor.context.name.toFirstUpper()»Core
		{
		public:
			«monitorServiceName»ReqActivity«monitor.context.name.toFirstUpper()»(SmartACE::SmartComponent *comp);
			virtual ~«monitorServiceName»ReqActivity«monitor.context.name.toFirstUpper()»();
			
			virtual int on_entry();
			virtual int on_execute();
			virtual int on_exit();
		private:
			Roqme::Roqme«roqmeType»Writer «roqmetypelower»_dw;
			«FOR options : monitor.opts»
				«IF options instanceof MinDiffBtwUpdates»
				bool activatedFilter;	
				«ENDIF»
			«ENDFOR»
		};
		
		#endif
    '''
    
    def generateActivityCC(Monitor monitor) '''
    	«var String monitorServiceName = monitor.service.name»
    	«var String source = monitor.source»
 		«var String type = monitor.sourceType»
 		«var String roqmeType = getType(type)»
     	«var String roqmetypelower = roqmeType.toLowerCase()»
    	«var String[] segments = monitor.service.eContainer.toString.split(' ')»

		«var String attribute = getAttribute(source)»
		
		#include "«monitorServiceName»ReqActivity«monitor.context.name.toFirstUpper()».hh"
		#include "«projectName».hh"
		
		#include <iostream>
		
		«monitorServiceName»ReqActivity«monitor.context.name.toFirstUpper()»::«monitorServiceName»ReqActivity«monitor.context.name.toFirstUpper()»(SmartACE::SmartComponent *comp) 
		:	«monitorServiceName»ReqActivity«monitor.context.name.toFirstUpper()»Core(comp)
		{
			std::cout << "constructor «monitorServiceName»ReqActivity«monitor.context.name.toFirstUpper()»\n";
			«FOR options : monitor.opts»
				«IF options instanceof MinDiffBtwUpdates»
				activatedFilter = false;	
				«ENDIF»
			«ENDFOR»
		}
		«monitorServiceName»ReqActivity«monitor.context.name.toFirstUpper()»::~«monitorServiceName»ReqActivity«monitor.context.name.toFirstUpper()»() 
		{
			std::cout << "destructor «monitorServiceName»ReqActivity«monitor.context.name.toFirstUpper()»\n";
		}
				
		int «monitorServiceName»ReqActivity«monitor.context.name.toFirstUpper()»::on_entry()
		{
			// do initialization procedures here, which are called once, each time the task is started
			// it is possible to return != 0 (e.g. when initialization fails) then the task is not executed further
			return 0;
		}
		int «monitorServiceName»ReqActivity«monitor.context.name.toFirstUpper()»::on_execute()
		{
			// this method is called from an outside loop,
			// hence, NEVER use an infinite loop (like "while(1)") here inside!!!
			// also do not use blocking calls which do not result from smartsoft kernel
			
			// to get the incoming data, use this methods:
			Smart::StatusCode status;
			
			«FOR pattern : monitor.service.eContents »
				«IF pattern instanceof QueryPattern»
					«var String[] elements = monitor.service.eContainer.toString.split(' ')»
					«val String repoQuery = elements.get(segments.length-1)»
					«val String repoQueryName = repoQuery.substring(0, repoQuery.length-1)» 		
					«var dad=pattern  as QueryPattern»					
					«repoQueryName»::«dad.answerType.name» response;
					«repoQueryName»::«dad.requestType.name» request;
				«ENDIF»
			«ENDFOR»

			status = COMP->«monitor.service.name.substring(0, 1).toLowerCase() + monitor.service.name.substring(1)»Req«monitor.context.name.toFirstUpper()»->query(request, response);
			if(status!= Smart::SMART_OK)
			{
				std::cout << "Error sending data: " << Smart::StatusCodeConversion(status) << std::endl;
			}
			else 
			{
				«var Boolean existsMinDiffBtw = false»
				«var Double minDiffBtwValue = 0.0»
				«FOR options : monitor.opts»
					«IF options instanceof MinDiffBtwUpdates»
						«{existsMinDiffBtw = true; ""}»
						«val minDiffBtw=options as MinDiffBtwUpdates»
						«{minDiffBtwValue = minDiffBtw.value;""}»
					«ELSE»
					«ENDIF»
				«ENDFOR»
							
				«IF existsMinDiffBtw == true»
					const double minDiffBtwUpdates = «minDiffBtwValue»;
					bool manda = true;
					double current = response«attribute»);
					static double prevValue;
					if(activatedFilter)
					{
						if(fabs(current-prevValue) < minDiffBtwUpdates)
						{
							manda = false;
						}
						else
						{
							manda = true;
						}
					}
					if(manda)
					{
						try
						{
							RoqmeDDSTopics::Roqme«roqmeType»Context «roqmetypelower»Context;
							«roqmetypelower»Context.name("«monitor.context.name»");
							«IF roqmeType.equals("Enum")»
							«roqmetypelower»Context.value().push_back(response«attribute».to_string());
							«ELSE»
							«roqmetypelower»Context.value().push_back(response«attribute»);
							«ENDIF»
							std::cout << "Publishing data context" << std::endl;
							«roqmetypelower»_dw.write(«roqmetypelower»Context);
						}
						catch(Roqme::RoqmeDDSException& e)
						{
							std::cerr << e.what() << std::endl;
						}
					}
					prevValue = current;
				«ELSE»
					try
					{
						RoqmeDDSTopics::Roqme«roqmeType»Context «roqmetypelower»Context;
						«roqmetypelower»Context.name("«monitor.context.name»");
						«IF roqmeType.equals("Enum")»
						«roqmetypelower»Context.value().push_back(response«attribute».to_string());
						«ELSE»
						«roqmetypelower»Context.value().push_back(response«attribute»);
						«ENDIF»
						std::cout << "Publishing data context" << std::endl;
						«roqmetypelower»_dw.write(«roqmetypelower»Context);
					}
					catch(Roqme::RoqmeDDSException& e)
					{
						std::cerr << e.what() << std::endl;
					}	
				«ENDIF»
			}
			
			return 0;
		}
		int «monitorServiceName»ReqActivity«monitor.context.name.toFirstUpper()»::on_exit()
		{
			// use this method to clean-up resources which are initialized in on_entry() and needs to be freed before the on_execute() can be called again
			return 0;
		}
    '''
    
    def generateCMakeLists(MappingModel mm) '''
    #--------------------------------------------------------------------------
    # Code generated by the SmartSoft MDSD Toolchain
    # The SmartSoft Toolchain has been developed by:
    #  
    # Service Robotics Research Center
    # University of Applied Sciences Ulm
    # Prittwitzstr. 10
    # 89075 Ulm (Germany)
    #
    # Information about the SmartSoft MDSD Toolchain is available at:
    # www.servicerobotik-ulm.de
    #
    # This file is generated once. Modify this file to your needs. 
    # If you want the toolchain to re-generate this file, please 
    # delete it before running the code generator.
    #--------------------------------------------------------------------------
    
    CMAKE_MINIMUM_REQUIRED(VERSION 3.0)
    
    # find the SmartSoft CMake Macros (version 2 that uses CMake v3)
    FIND_FILE(SMART_MACROS SmartMacros2.cmake PATHS $ENV{SMART_ROOT_ACE}/CMakeMacros /opt/smartSoftAce/CMakeMacros/)
    INCLUDE(${SMART_MACROS})
    
    # Create and configure a CMake project for a CommunicationObject
    SMART_COMPONENT_PROJECT()
    
    # find SmartSoft package
    #FIND_SMARTSOFT(3.0)
    #FIXME: generalize this
    FIND_PACKAGE(AceSmartSoft PATHS $ENV{SMART_ROOT_ACE}/build)
    
    # generte doxygen documentation
    SMART_COMPONENT_GENERATE_DOC()
    
    # automatically build CommunicationObject dependencies
    SMART_COMPONENT_AUTOBUILD_DEPENDENCIES()
    
    #################################################################################
    ## here you can put all your project-specific compiler configurations          ##
    ## using regular CMake commands (like FIND_PACKAGE, INCLUDE_DIRECTORIES, etc.) ##
    
    # you can add additional external libraries using regular CMake commands, e.g.:
    #FIND_PACKAGE(<SomePackageName>)
    FIND_PACKAGE(open62541 QUIET PATHS /usr/local/lib/cmake)
    
    # these are the regular includes (add your own includes, if needed)
    INCLUDE_DIRECTORIES(
      ${CMAKE_CURRENT_LIST_DIR}/src
      ${CMAKE_CURRENT_LIST_DIR}/src-gen
      ${CMAKE_CURRENT_LIST_DIR}/src-gen/params
      ${ROQME_ROOT}/roqme_git/cpp/roqmeDDS/include
      ${ROQME_ROOT}/roqme_git/cpp/roqmeDDS/idl
      ${OSPL_HOME}/include/dcps/C++/isocpp2
      ${OSPL_HOME}/include/sys
      ${OSPL_HOME}/include
      ${OSPL_HOME}/include/dcps/C++/SACPP
    )
    
    LINK_DIRECTORIES($ENV{OSPL_HOME}/lib)
    LINK_DIRECTORIES($ENV{ROQME_ROOT}/roqme_git/cpp/roqmeDDS/lib)
    
    # collect the toolchain-generated source-files
    FILE(GLOB_RECURSE SRC ${CMAKE_CURRENT_LIST_DIR}/src/*.cc)
    FILE(GLOB_RECURSE SRC_GEN ${CMAKE_CURRENT_LIST_DIR}/src-gen/*.cc)
    FILE(GLOB_RECURSE SRC_GEN_PARAMS ${CMAKE_CURRENT_LIST_DIR}/src-gen/params/*.cc)
    
    # collect your own (local) source-files here (if needed)
    #FILE(GLOB_RECURSE USER_SRC ${CMAKE_CURRENT_LIST_DIR}/src/<your-sources>)
    
    # create the executable using collected source-files
    ADD_EXECUTABLE(${PROJECT_NAME} ${SRC} ${SRC_GEN} ${SRC_GEN_PARAMS}) # add ${USER_SRC} (if needed)
    
    # link your external libraries here (if there are any)
    TARGET_LINK_LIBRARIES(${PROJECT_NAME} dcpssacpp dcpsgapi ddsdatabase ddsos ddskernel dcpsisocpp2 roqmedds)
    IF(open62541_FOUND)
    TARGET_LINK_LIBRARIES(${PROJECT_NAME} open62541)
    ENDIF(open62541_FOUND)
    
    #INSTALL(FILES ${PROJECT_SOURCE_DIR}/src-gen/${PROJECT_NAME}.ini.template DESTINATION etc)
    
    ## end user-code                                                               ##
    #################################################################################
    
    # SmartSoftKernel is one of the default dependencies for each component
    TARGET_LINK_LIBRARIES(${PROJECT_NAME} AceSmartSoftKernel)
    
    # automatically link to all dependent CommunicationObjects
    SMART_COMPONENT_AUTOLINK_DEPENDENCIES()
    
    # automatically install the component target
    SMART_COMPONENT_AUTOINSTALL()
    '''

	def generateLanguageSettings(MappingModel mm) '''
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<project>
	<configuration id="cdt.managedbuild.config.gnu.exe.release.1094538128" name="Release">
		<extension point="org.eclipse.cdt.core.LanguageSettingsProvider">
			<provider copy-of="extension" id="org.eclipse.cdt.ui.UserLanguageSettingsProvider"/>
			<provider-reference id="org.eclipse.cdt.core.ReferencedProjectsLanguageSettingsProvider" ref="shared-provider"/>
			<provider-reference id="org.eclipse.cdt.managedbuilder.core.MBSLanguageSettingsProvider" ref="shared-provider"/>
			<provider class="org.eclipse.cdt.managedbuilder.language.settings.providers.GCCBuiltinSpecsDetector" console="false" env-hash="805257480388894640" id="org.eclipse.cdt.managedbuilder.core.GCCBuiltinSpecsDetector" keep-relative-paths="false" name="CDT GCC Built-in Compiler Settings" parameter="${COMMAND} ${FLAGS} -E -P -v -dD &quot;${INPUTS}&quot;" prefer-non-shared="true">
				<language-scope id="org.eclipse.cdt.core.gcc"/>
				<language-scope id="org.eclipse.cdt.core.g++"/>
			</provider>
		</extension>
	</configuration>
	<configuration id="cdt.managedbuild.config.gnu.exe.debug.1430384519" name="Debug">
		<extension point="org.eclipse.cdt.core.LanguageSettingsProvider">
			<provider copy-of="extension" id="org.eclipse.cdt.ui.UserLanguageSettingsProvider"/>
			<provider-reference id="org.eclipse.cdt.core.ReferencedProjectsLanguageSettingsProvider" ref="shared-provider"/>
			<provider-reference id="org.eclipse.cdt.managedbuilder.core.MBSLanguageSettingsProvider" ref="shared-provider"/>
			<provider class="org.eclipse.cdt.managedbuilder.language.settings.providers.GCCBuiltinSpecsDetector" console="false" env-hash="805257480388894640" id="org.eclipse.cdt.managedbuilder.core.GCCBuiltinSpecsDetector" keep-relative-paths="false" name="CDT GCC Built-in Compiler Settings" parameter="${COMMAND} ${FLAGS} -E -P -v -dD &quot;${INPUTS}&quot;" prefer-non-shared="true">
				<language-scope id="org.eclipse.cdt.core.gcc"/>
				<language-scope id="org.eclipse.cdt.core.g++"/>
			</provider>
		</extension>
	</configuration>
</project>
 	'''

	def Vector<String> getRepositories(MappingModel mm)
	{
		var Vector<String> vres = new Vector()
		for (monitor : mm.monitors)
		{
			var String[] segments = monitor.service.eContainer.toString.split(' ')
			val String repositoryNameAux = segments.get(segments.length-1)
			val String repositoryName = repositoryNameAux.substring(0, repositoryNameAux.length-1) 
			if (!vres.contains(repositoryName))
			{
				vres.add(repositoryName)
			}
		}
		return vres
	}

 	def generateClassPath(MappingModel mm) '''
	 	«val Vector<String> repository_vector = getRepositories(mm)»
<?xml version="1.0" encoding="UTF-8"?>
<classpath>
	<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER"/>
	<classpathentry kind="src" path="model"/>
		«FOR repo_name : repository_vector»
			<classpathentry kind="src" path="/«repo_name»"/>
		«ENDFOR»
		<classpathentry kind="src" path="/CommRoqmeEstimate"/>
	<classpathentry kind="output" path="bin"/>
</classpath>
 	'''


 	def generateCProject(MappingModel mm) '''
 <?xml version="1.0" encoding="UTF-8" standalone="no"?>
 <?fileVersion 4.0.0?><cproject storage_type_id="org.eclipse.cdt.core.XmlProjectDescriptionStorage">
 	<storageModule moduleId="org.eclipse.cdt.core.settings">
 		<cconfiguration id="cdt.managedbuild.config.gnu.exe.release.1094538128">
 			<storageModule buildSystemId="org.eclipse.cdt.managedbuilder.core.configurationDataProvider" id="cdt.managedbuild.config.gnu.exe.release.1094538128" moduleId="org.eclipse.cdt.core.settings" name="Release">
 				<externalSettings/>
 				<extensions>
 					<extension id="org.eclipse.cdt.core.GNU_ELF" point="org.eclipse.cdt.core.BinaryParser"/>
 					<extension id="org.eclipse.cdt.core.GASErrorParser" point="org.eclipse.cdt.core.ErrorParser"/>
 					<extension id="org.eclipse.cdt.core.GmakeErrorParser" point="org.eclipse.cdt.core.ErrorParser"/>
 					<extension id="org.eclipse.cdt.core.GLDErrorParser" point="org.eclipse.cdt.core.ErrorParser"/>
 					<extension id="org.eclipse.cdt.core.CWDLocator" point="org.eclipse.cdt.core.ErrorParser"/>
 					<extension id="org.eclipse.cdt.core.GCCErrorParser" point="org.eclipse.cdt.core.ErrorParser"/>
 				</extensions>
 			</storageModule>
 			<storageModule moduleId="cdtBuildSystem" version="4.0.0">
 				<configuration artifactName="${ProjName}" buildArtefactType="org.eclipse.cdt.build.core.buildArtefactType.exe" buildProperties="org.eclipse.cdt.build.core.buildArtefactType=org.eclipse.cdt.build.core.buildArtefactType.exe,org.eclipse.cdt.build.core.buildType=org.eclipse.cdt.build.core.buildType.release" cleanCommand="rm -rf" description="" id="cdt.managedbuild.config.gnu.exe.release.1094538128" name="Release" parent="cdt.managedbuild.config.gnu.exe.release">
 					<folderInfo id="cdt.managedbuild.config.gnu.exe.release.1094538128." name="/" resourcePath="">
 						<toolChain id="cdt.managedbuild.toolchain.gnu.exe.release.1992305411" name="Linux GCC" superClass="cdt.managedbuild.toolchain.gnu.exe.release">
 							<targetPlatform id="cdt.managedbuild.target.gnu.platform.exe.release.2119336264" name="Debug Platform" superClass="cdt.managedbuild.target.gnu.platform.exe.release"/>
 							<builder buildPath="${workspace_loc:/«projectName»}/Release" id="cdt.managedbuild.target.gnu.builder.exe.release.1291724581" keepEnvironmentInBuildfile="false" managedBuildOn="true" name="Gnu Make Builder" superClass="cdt.managedbuild.target.gnu.builder.exe.release"/>
 							<tool id="cdt.managedbuild.tool.gnu.archiver.base.70362669" name="GCC Archiver" superClass="cdt.managedbuild.tool.gnu.archiver.base"/>
 							<tool id="cdt.managedbuild.tool.gnu.cpp.compiler.exe.release.1640960755" name="GCC C++ Compiler" superClass="cdt.managedbuild.tool.gnu.cpp.compiler.exe.release">
 								<option id="gnu.cpp.compiler.exe.release.option.optimization.level.1938861351" name="Optimization Level" superClass="gnu.cpp.compiler.exe.release.option.optimization.level" useByScannerDiscovery="false" value="gnu.cpp.compiler.optimization.level.most" valueType="enumerated"/>
 								<option id="gnu.cpp.compiler.exe.release.option.debugging.level.1868181196" name="Debug Level" superClass="gnu.cpp.compiler.exe.release.option.debugging.level" useByScannerDiscovery="false" value="gnu.cpp.compiler.debugging.level.none" valueType="enumerated"/>
 								<option id="gnu.cpp.compiler.option.include.paths.106306000" superClass="gnu.cpp.compiler.option.include.paths" valueType="includePath">
 									<listOptionValue builtIn="false" value="/usr/include/boost"/>
 									<listOptionValue builtIn="false" value="../"/>
 									<listOptionValue builtIn="false" value="&quot;${ACE_ROOT}&quot;"/>
 									<listOptionValue builtIn="false" value="&quot;${SMART_ROOT_ACE}/include&quot;"/>
 									<listOptionValue builtIn="false" value="&quot;${SMART_ROOT_ACE}/include/SmartSoft_CD_API&quot;"/>
 									<listOptionValue builtIn="false" value="&quot;${SMART_ROOT_ACE}/include/AceSmartSoftKernel&quot;"/>
 									<listOptionValue builtIn="false" value="&quot;${workspace_loc:/«projectName»/smartsoft/src}&quot;"/>
 									<listOptionValue builtIn="false" value="&quot;${workspace_loc:/«projectName»/smartsoft/src-gen}&quot;"/>
 								</option>
 								<inputType id="cdt.managedbuild.tool.gnu.cpp.compiler.input.1688958472" superClass="cdt.managedbuild.tool.gnu.cpp.compiler.input"/>
 							</tool>
 							<tool id="cdt.managedbuild.tool.gnu.c.compiler.exe.release.1848381550" name="GCC C Compiler" superClass="cdt.managedbuild.tool.gnu.c.compiler.exe.release">
 								<option defaultValue="gnu.c.optimization.level.most" id="gnu.c.compiler.exe.release.option.optimization.level.1081798197" name="Optimization Level" superClass="gnu.c.compiler.exe.release.option.optimization.level" useByScannerDiscovery="false" valueType="enumerated"/>
 								<option id="gnu.c.compiler.exe.release.option.debugging.level.1279508392" name="Debug Level" superClass="gnu.c.compiler.exe.release.option.debugging.level" useByScannerDiscovery="false" value="gnu.c.debugging.level.none" valueType="enumerated"/>
 								<inputType id="cdt.managedbuild.tool.gnu.c.compiler.input.1604501524" superClass="cdt.managedbuild.tool.gnu.c.compiler.input"/>
 							</tool>
 							<tool id="cdt.managedbuild.tool.gnu.c.linker.exe.release.1287198104" name="GCC C Linker" superClass="cdt.managedbuild.tool.gnu.c.linker.exe.release"/>
 							<tool id="cdt.managedbuild.tool.gnu.cpp.linker.exe.release.802849387" name="GCC C++ Linker" superClass="cdt.managedbuild.tool.gnu.cpp.linker.exe.release">
 								<inputType id="cdt.managedbuild.tool.gnu.cpp.linker.input.48664972" superClass="cdt.managedbuild.tool.gnu.cpp.linker.input">
 									<additionalInput kind="additionalinputdependency" paths="$(USER_OBJS)"/>
 									<additionalInput kind="additionalinput" paths="$(LIBS)"/>
 								</inputType>
 							</tool>
 							<tool id="cdt.managedbuild.tool.gnu.assembler.exe.release.1675494146" name="GCC Assembler" superClass="cdt.managedbuild.tool.gnu.assembler.exe.release">
 								<inputType id="cdt.managedbuild.tool.gnu.assembler.input.1353898168" superClass="cdt.managedbuild.tool.gnu.assembler.input"/>
 							</tool>
 						</toolChain>
 					</folderInfo>
 				</configuration>
 			</storageModule>
 			<storageModule moduleId="org.eclipse.cdt.core.externalSettings"/>
 		</cconfiguration>
 		<cconfiguration id="cdt.managedbuild.config.gnu.exe.debug.1430384519">
 			<storageModule buildSystemId="org.eclipse.cdt.managedbuilder.core.configurationDataProvider" id="cdt.managedbuild.config.gnu.exe.debug.1430384519" moduleId="org.eclipse.cdt.core.settings" name="Debug">
 				<externalSettings/>
 				<extensions>
 					<extension id="org.eclipse.cdt.core.GNU_ELF" point="org.eclipse.cdt.core.BinaryParser"/>
 					<extension id="org.eclipse.cdt.core.GASErrorParser" point="org.eclipse.cdt.core.ErrorParser"/>
 					<extension id="org.eclipse.cdt.core.GmakeErrorParser" point="org.eclipse.cdt.core.ErrorParser"/>
 					<extension id="org.eclipse.cdt.core.GLDErrorParser" point="org.eclipse.cdt.core.ErrorParser"/>
 					<extension id="org.eclipse.cdt.core.CWDLocator" point="org.eclipse.cdt.core.ErrorParser"/>
 					<extension id="org.eclipse.cdt.core.GCCErrorParser" point="org.eclipse.cdt.core.ErrorParser"/>
 				</extensions>
 			</storageModule>
 			<storageModule moduleId="cdtBuildSystem" version="4.0.0">
 				<configuration artifactName="${ProjName}" buildArtefactType="org.eclipse.cdt.build.core.buildArtefactType.exe" buildProperties="org.eclipse.cdt.build.core.buildArtefactType=org.eclipse.cdt.build.core.buildArtefactType.exe,org.eclipse.cdt.build.core.buildType=org.eclipse.cdt.build.core.buildType.debug" cleanCommand="rm -rf" description="" id="cdt.managedbuild.config.gnu.exe.debug.1430384519" name="Debug" parent="cdt.managedbuild.config.gnu.exe.debug">
 					<folderInfo id="cdt.managedbuild.config.gnu.exe.debug.1430384519." name="/" resourcePath="">
 						<toolChain id="cdt.managedbuild.toolchain.gnu.exe.debug.994599997" name="Linux GCC" superClass="cdt.managedbuild.toolchain.gnu.exe.debug">
 							<targetPlatform id="cdt.managedbuild.target.gnu.platform.exe.debug.1647703317" name="Debug Platform" superClass="cdt.managedbuild.target.gnu.platform.exe.debug"/>
 							<builder buildPath="${workspace_loc:/«projectName»}/Debug" id="cdt.managedbuild.target.gnu.builder.exe.debug.160397755" keepEnvironmentInBuildfile="false" managedBuildOn="true" name="Gnu Make Builder" superClass="cdt.managedbuild.target.gnu.builder.exe.debug"/>
 							<tool id="cdt.managedbuild.tool.gnu.archiver.base.802945952" name="GCC Archiver" superClass="cdt.managedbuild.tool.gnu.archiver.base"/>
 							<tool id="cdt.managedbuild.tool.gnu.cpp.compiler.exe.debug.903444635" name="GCC C++ Compiler" superClass="cdt.managedbuild.tool.gnu.cpp.compiler.exe.debug">
 								<option id="gnu.cpp.compiler.exe.debug.option.optimization.level.1395411718" name="Optimization Level" superClass="gnu.cpp.compiler.exe.debug.option.optimization.level" useByScannerDiscovery="false" value="gnu.cpp.compiler.optimization.level.none" valueType="enumerated"/>
 								<option id="gnu.cpp.compiler.exe.debug.option.debugging.level.2061785009" name="Debug Level" superClass="gnu.cpp.compiler.exe.debug.option.debugging.level" useByScannerDiscovery="false" value="gnu.cpp.compiler.debugging.level.max" valueType="enumerated"/>
 								<option id="gnu.cpp.compiler.option.include.paths.11777158" superClass="gnu.cpp.compiler.option.include.paths" valueType="includePath">
 									<listOptionValue builtIn="false" value="../"/>
 									<listOptionValue builtIn="false" value="&quot;${ACE_ROOT}&quot;"/>
 									<listOptionValue builtIn="false" value="&quot;${SMART_ROOT_ACE}/include&quot;"/>
 									<listOptionValue builtIn="false" value="&quot;${SMART_ROOT_ACE}/include/SmartSoft_CD_API&quot;"/>
 									<listOptionValue builtIn="false" value="&quot;${SMART_ROOT_ACE}/include/AceSmartSoftKernel&quot;"/>
 									<listOptionValue builtIn="false" value="&quot;${workspace_loc:/«projectName»/smartsoft/src}&quot;"/>
 									<listOptionValue builtIn="false" value="&quot;${workspace_loc:/«projectName»/smartsoft/src-gen}&quot;"/>
 								</option>
 								<inputType id="cdt.managedbuild.tool.gnu.cpp.compiler.input.176282506" superClass="cdt.managedbuild.tool.gnu.cpp.compiler.input"/>
 							</tool>
 							<tool id="cdt.managedbuild.tool.gnu.c.compiler.exe.debug.197126114" name="GCC C Compiler" superClass="cdt.managedbuild.tool.gnu.c.compiler.exe.debug">
 								<option defaultValue="gnu.c.optimization.level.none" id="gnu.c.compiler.exe.debug.option.optimization.level.1134663659" name="Optimization Level" superClass="gnu.c.compiler.exe.debug.option.optimization.level" useByScannerDiscovery="false" valueType="enumerated"/>
 								<option id="gnu.c.compiler.exe.debug.option.debugging.level.440703353" name="Debug Level" superClass="gnu.c.compiler.exe.debug.option.debugging.level" useByScannerDiscovery="false" value="gnu.c.debugging.level.max" valueType="enumerated"/>
 								<inputType id="cdt.managedbuild.tool.gnu.c.compiler.input.1399782395" superClass="cdt.managedbuild.tool.gnu.c.compiler.input"/>
 							</tool>
 							<tool id="cdt.managedbuild.tool.gnu.c.linker.exe.debug.651359436" name="GCC C Linker" superClass="cdt.managedbuild.tool.gnu.c.linker.exe.debug"/>
 							<tool id="cdt.managedbuild.tool.gnu.cpp.linker.exe.debug.547714321" name="GCC C++ Linker" superClass="cdt.managedbuild.tool.gnu.cpp.linker.exe.debug">
 								<inputType id="cdt.managedbuild.tool.gnu.cpp.linker.input.2099844027" superClass="cdt.managedbuild.tool.gnu.cpp.linker.input">
 									<additionalInput kind="additionalinputdependency" paths="$(USER_OBJS)"/>
 									<additionalInput kind="additionalinput" paths="$(LIBS)"/>
 								</inputType>
 							</tool>
 							<tool id="cdt.managedbuild.tool.gnu.assembler.exe.debug.389163518" name="GCC Assembler" superClass="cdt.managedbuild.tool.gnu.assembler.exe.debug">
 								<inputType id="cdt.managedbuild.tool.gnu.assembler.input.982210319" superClass="cdt.managedbuild.tool.gnu.assembler.input"/>
 							</tool>
 						</toolChain>
 					</folderInfo>
 				</configuration>
 			</storageModule>
 			<storageModule moduleId="org.eclipse.cdt.core.externalSettings"/>
 		</cconfiguration>
 	</storageModule>
 	<storageModule moduleId="cdtBuildSystem" version="4.0.0">
 		<project id="«projectName».cdt.managedbuild.target.gnu.exe.370733719" name="Executable" projectType="cdt.managedbuild.target.gnu.exe"/>
 	</storageModule>
 	<storageModule moduleId="scannerConfiguration">
 		<autodiscovery enabled="true" problemReportingEnabled="true" selectedProfileId=""/>
 		<scannerConfigBuildInfo instanceId="cdt.managedbuild.config.gnu.exe.release.1094538128;cdt.managedbuild.config.gnu.exe.release.1094538128.;cdt.managedbuild.tool.gnu.cpp.compiler.exe.release.1640960755;cdt.managedbuild.tool.gnu.cpp.compiler.input.1688958472">
 			<autodiscovery enabled="true" problemReportingEnabled="true" selectedProfileId=""/>
 		</scannerConfigBuildInfo>
 		<scannerConfigBuildInfo instanceId="cdt.managedbuild.config.gnu.exe.debug.1430384519;cdt.managedbuild.config.gnu.exe.debug.1430384519.;cdt.managedbuild.tool.gnu.c.compiler.exe.debug.197126114;cdt.managedbuild.tool.gnu.c.compiler.input.1399782395">
 			<autodiscovery enabled="true" problemReportingEnabled="true" selectedProfileId=""/>
 		</scannerConfigBuildInfo>
 		<scannerConfigBuildInfo instanceId="cdt.managedbuild.config.gnu.exe.debug.1430384519;cdt.managedbuild.config.gnu.exe.debug.1430384519.;cdt.managedbuild.tool.gnu.cpp.compiler.exe.debug.903444635;cdt.managedbuild.tool.gnu.cpp.compiler.input.176282506">
 			<autodiscovery enabled="true" problemReportingEnabled="true" selectedProfileId=""/>
 		</scannerConfigBuildInfo>
 		<scannerConfigBuildInfo instanceId="cdt.managedbuild.config.gnu.exe.release.1094538128;cdt.managedbuild.config.gnu.exe.release.1094538128.;cdt.managedbuild.tool.gnu.c.compiler.exe.release.1848381550;cdt.managedbuild.tool.gnu.c.compiler.input.1604501524">
 			<autodiscovery enabled="true" problemReportingEnabled="true" selectedProfileId=""/>
 		</scannerConfigBuildInfo>
 	</storageModule>
 	<storageModule moduleId="org.eclipse.cdt.core.LanguageSettingsProviders"/>
 </cproject>
  	'''	

 	def generateProject(MappingModel mm) '''
<?xml version="1.0" encoding="UTF-8"?>
<projectDescription>
	<name>«projectName»</name>
	<comment></comment>
	<projects>
	</projects>
	<buildSpec>
		<buildCommand>
			<name>org.eclipse.cdt.managedbuilder.core.genmakebuilder</name>
			<triggers>clean,full,incremental,</triggers>
			<arguments>
			</arguments>
		</buildCommand>
		<buildCommand>
			<name>org.eclipse.jdt.core.javabuilder</name>
			<arguments>
			</arguments>
		</buildCommand>
		<buildCommand>
			<name>org.eclipse.xtext.ui.shared.xtextBuilder</name>
			<arguments>
			</arguments>
		</buildCommand>
		<buildCommand>
			<name>org.eclipse.cdt.managedbuilder.core.ScannerConfigBuilder</name>
			<triggers>full,incremental,</triggers>
			<arguments>
			</arguments>
		</buildCommand>
	</buildSpec>
	<natures>
		<nature>org.eclipse.sirius.nature.modelingproject</nature>
		<nature>org.eclipse.xtext.ui.shared.xtextNature</nature>
		<nature>org.eclipse.jdt.core.javanature</nature>
		<nature>org.eclipse.cdt.core.cnature</nature>
		<nature>org.eclipse.cdt.core.ccnature</nature>
		<nature>org.eclipse.cdt.managedbuilder.core.managedBuildNature</nature>
		<nature>org.eclipse.cdt.managedbuilder.core.ScannerConfigNature</nature>
	</natures>
</projectDescription>
 	'''
 	def generateRepresentations(MappingModel mm) '''
 		«val Vector<String> repository_vector = getRepositories(mm)»
<?xml version="1.0" encoding="UTF-8"?>
<xmi:XMI xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:ComponentDefinition="http://www.ecore.org/component/ComponentDefinition" xmlns:description="http://www.eclipse.org/sirius/description/1.1.0" xmlns:description_1="http://www.eclipse.org/sirius/diagram/description/1.1.0" xmlns:diagram="http://www.eclipse.org/sirius/diagram/1.1.0" xmlns:notation="http://www.eclipse.org/gmf/runtime/1.0.2/notation" xmlns:style="http://www.eclipse.org/sirius/diagram/description/style/1.1.0" xmlns:viewpoint="http://www.eclipse.org/sirius/1.1.0" xsi:schemaLocation="http://www.eclipse.org/sirius/description/1.1.0 http://www.eclipse.org/sirius/1.1.0#//description http://www.eclipse.org/sirius/diagram/description/1.1.0 http://www.eclipse.org/sirius/diagram/1.1.0#//description http://www.eclipse.org/sirius/diagram/description/style/1.1.0 http://www.eclipse.org/sirius/diagram/1.1.0#//description/style">
  <viewpoint:DAnalysis xmi:id="_u7Y4cMZDEeimeMmQD7-mxQ" selectedViews="_vCPHUMZDEeimeMmQD7-mxQ" version="12.1.0.201708031200">
    <semanticResources>model/«projectName».component</semanticResources>
    <semanticResources>model/«projectName».componentDocumentation</semanticResources>
    <semanticResources>model/«projectName».componentParameters</semanticResources>
    «FOR repo_name : repository_vector»
    	<semanticResources>platform:/resource/«repo_name»/model/«repo_name».services</semanticResources>
    	<semanticResources>platform:/resource/«repo_name»/model/«repo_name».types</semanticResources>
   	«ENDFOR»
    <ownedViews xmi:type="viewpoint:DView" xmi:id="_vCPHUMZDEeimeMmQD7-mxQ">
      <viewpoint xmi:type="description:Viewpoint" href="platform:/plugin/org.sirius.component.design/description/component.odesign#//@ownedViewpoints[name='ComponentDefinitionViewpoint']"/>
      <ownedRepresentationDescriptors xmi:type="viewpoint:DRepresentationDescriptor" xmi:id="_vCzvEMZDEeimeMmQD7-mxQ" name="«projectName»" repPath="#_vCg0IMZDEeimeMmQD7-mxQ">
        <description xmi:type="description_1:DiagramDescription" href="platform:/plugin/org.sirius.component.design/description/component.odesign#//@ownedViewpoints[name='ComponentDefinitionViewpoint']/@ownedRepresentations[name='ComponentDefinitionDiagram']"/>
        <target xmi:type="ComponentDefinition:ComponentDefModel" href="model/«projectName».component#/"/>
      </ownedRepresentationDescriptors>
    </ownedViews>
  </viewpoint:DAnalysis>
  <diagram:DSemanticDiagram xmi:id="_vCwrwMZDEeimeMmQD7-mxQ" name="«projectName»" uid="_vCg0IMZDEeimeMmQD7-mxQ">
    <ownedAnnotationEntries xmi:type="description:AnnotationEntry" xmi:id="_vCwrwcZDEeimeMmQD7-mxQ" source="DANNOTATION_CUSTOMIZATION_KEY">
      <data xmi:type="diagram:ComputedStyleDescriptionRegistry" xmi:id="_vCwrwsZDEeimeMmQD7-mxQ"/>
    </ownedAnnotationEntries>
    <ownedAnnotationEntries xmi:type="description:AnnotationEntry" xmi:id="_vDIfMMZDEeimeMmQD7-mxQ" source="GMF_DIAGRAMS">
      <data xmi:type="notation:Diagram" xmi:id="_vDIfMcZDEeimeMmQD7-mxQ" type="Sirius" element="_vCwrwMZDEeimeMmQD7-mxQ" measurementUnit="Pixel">
        <children xmi:type="notation:Node" xmi:id="_vDPM4MZDEeimeMmQD7-mxQ" type="2002" element="_vCwrxMZDEeimeMmQD7-mxQ">
          <children xmi:type="notation:Node" xmi:id="_vDTeUMZDEeimeMmQD7-mxQ" type="5006"/>
          <children xmi:type="notation:Node" xmi:id="_vDUFYMZDEeimeMmQD7-mxQ" type="7001">
            <styles xmi:type="notation:SortingStyle" xmi:id="_vDUFYcZDEeimeMmQD7-mxQ"/>
            <styles xmi:type="notation:FilteringStyle" xmi:id="_vDUFYsZDEeimeMmQD7-mxQ"/>
          </children>
          <styles xmi:type="notation:ShapeStyle" xmi:id="_vDPM4cZDEeimeMmQD7-mxQ" fontName="Ubuntu" fontHeight="10" bold="true"/>
          <layoutConstraint xmi:type="notation:Bounds" xmi:id="_vDPM4sZDEeimeMmQD7-mxQ"/>
        </children>
        <styles xmi:type="notation:DiagramStyle" xmi:id="_vDIfMsZDEeimeMmQD7-mxQ"/>
      </data>
    </ownedAnnotationEntries>
    <ownedDiagramElements xmi:type="diagram:DNodeContainer" xmi:id="_vCwrxMZDEeimeMmQD7-mxQ" name="«projectName»" tooltipText="ComponentDefinition">
      <target xmi:type="ComponentDefinition:ComponentDefinition" href="model/«projectName».component#//@component"/>
      <semanticElements xmi:type="ComponentDefinition:ComponentDefinition" href="model/«projectName».component#//@component"/>
      <ownedStyle xmi:type="diagram:FlatContainerStyle" xmi:id="_vCwrxcZDEeimeMmQD7-mxQ" labelSize="10" borderSize="1" borderSizeComputationExpression="1" foregroundColor="255,245,181">
        <labelFormat>bold</labelFormat>
        <description xmi:type="style:FlatContainerStyleDescription" href="platform:/plugin/org.sirius.component.design/description/component.odesign#//@ownedViewpoints[name='ComponentDefinitionViewpoint']/@ownedRepresentations[name='ComponentDefinitionDiagram']/@defaultLayer/@containerMappings[name='ComponentContainer']/@style"/>
      </ownedStyle>
      <actualMapping xmi:type="description_1:ContainerMapping" href="platform:/plugin/org.sirius.component.design/description/component.odesign#//@ownedViewpoints[name='ComponentDefinitionViewpoint']/@ownedRepresentations[name='ComponentDefinitionDiagram']/@defaultLayer/@containerMappings[name='ComponentContainer']"/>
    </ownedDiagramElements>
    <description xmi:type="description_1:DiagramDescription" href="platform:/plugin/org.sirius.component.design/description/component.odesign#//@ownedViewpoints[name='ComponentDefinitionViewpoint']/@ownedRepresentations[name='ComponentDefinitionDiagram']"/>
    <filterVariableHistory xmi:type="diagram:FilterVariableHistory" xmi:id="_vCwrxsZDEeimeMmQD7-mxQ"/>
    <activatedLayers xmi:type="description_1:Layer" href="platform:/plugin/org.sirius.component.design/description/component.odesign#//@ownedViewpoints[name='ComponentDefinitionViewpoint']/@ownedRepresentations[name='ComponentDefinitionDiagram']/@defaultLayer"/>
    <target xmi:type="ComponentDefinition:ComponentDefModel" href="model/«projectName».component#/"/>
  </diagram:DSemanticDiagram>
</xmi:XMI>
 	'''
 	
	def generateEstimateActivityHH() '''
	//--------------------------------------------------------------------------
	// Code generated by the SmartSoft MDSD Toolchain
	// The SmartSoft Toolchain has been developed by:
	//  
	// Service Robotics Research Center
	// University of Applied Sciences Ulm
	// Prittwitzstr. 10
	// 89075 Ulm (Germany)
	//
	// Information about the SmartSoft MDSD Toolchain is available at:
	// www.servicerobotik-ulm.de
	//
	// This file is generated once. Modify this file to your needs. 
	// If you want the toolchain to re-generate this file, please 
	// delete it before running the code generator.
	//--------------------------------------------------------------------------
	#ifndef _ESTIMATEACTIVITY_HH
	#define _ESTIMATEACTIVITY_HH
	
	#include "EstimateActivityCore.hh"
	#include "EstimateListener.hh"
	
	class EstimateActivity  : public EstimateActivityCore
	{
	private:
		Roqme::RoqmeEstimateReader *estimateReader;
	public:
		EstimateActivity(SmartACE::SmartComponent *comp);
		virtual ~EstimateActivity();
		
		virtual int on_entry();
		virtual int on_execute();
		virtual int on_exit();
	};
	
	#endif
	
	'''
	
	def generateEstimateActivityCC() '''
	//--------------------------------------------------------------------------
	// Code generated by the SmartSoft MDSD Toolchain
	// The SmartSoft Toolchain has been developed by:
	//  
	// Service Robotics Research Center
	// University of Applied Sciences Ulm
	// Prittwitzstr. 10
	// 89075 Ulm (Germany)
	//
	// Information about the SmartSoft MDSD Toolchain is available at:
	// www.servicerobotik-ulm.de
	//
	// This file is generated once. Modify this file to your needs. 
	// If you want the toolchain to re-generate this file, please 
	// delete it before running the code generator.
	//--------------------------------------------------------------------------
	#include "EstimateActivity.hh"
	#include "«projectName».hh"
	#include <iostream>
	
	EstimateActivity::EstimateActivity(SmartACE::SmartComponent *comp) 
	:	EstimateActivityCore(comp)
	{
		estimateReader = new Roqme::RoqmeEstimateReader(new EstimateListener(this));
	}
	EstimateActivity::~EstimateActivity() 
	{
		delete estimateReader;
	}
	
	
	
	int EstimateActivity::on_entry()
	{
		// do initialization procedures here, which are called once, each time the task is started
		// it is possible to return != 0 (e.g. when initialization fails) then the task is not executed further
		return 0;
	}
	
	int EstimateActivity::on_execute()
	{
		// this method is called from an outside loop,
		// hence, NEVER use an infinite loop (like "while(1)") here inside!!!
		// also do not use blocking calls which do not result from smartsoft kernel
	
		// it is possible to return != 0 (e.g. when the task detects errors), then the outer loop breaks and the task stops
		return 0;
	}
	int EstimateActivity::on_exit()
	{
		// use this method to clean-up resources which are initialized in on_entry() and needs to be freed before the on_execute() can be called again
		return 0;
	}
	
	'''
	
	def generateEstimateListenerHH() '''
	
	#ifndef _ROQMEESTIMATELISTENER_HH
	#define _ROQMEESTIMATELISTENER_HH
	
	#include <RoqmeReaderImpl.h>
	
	class EstimateActivity;
	
	class EstimateListener: public Roqme::RoqmeDDSListener<RoqmeDDSTopics::RoqmeEstimate>
	{
	public:
		EstimateListener(EstimateActivity* activity);
		void dataAvailable(const RoqmeDDSTopics::RoqmeEstimate& data, const dds::sub::SampleInfo& sampleInfo);
	
	private:
		EstimateActivity* activity;
	};
	
	#endif
	
	'''
	
	def generateEstimateListenerCC() '''
	#include "EstimateListener.hh"
	#include "«projectName».hh"
	#include "EstimateActivity.hh"
	
	EstimateListener::EstimateListener(EstimateActivity* activity)
	{
		this->activity = activity;
	}
	
	void EstimateListener::dataAvailable(const RoqmeDDSTopics::RoqmeEstimate& data, const dds::sub::SampleInfo& sampleInfo)
	{
		std::cout << "ESTIMATE sample available:" << std::endl;
		std::cout << "\t name: " << data.name() << std::endl;
		std::cout << "\t value: " << data.value() << std::endl;
	
		CommRoqmeEstimate::RoqmeEstimate estimate;
		estimate.setName(data.name());
		estimate.setValue(data.value());
	
		std::cout << "Publishing data" << std::endl;
		Smart::StatusCode status = COMP->estimateServiceOut->put(estimate);
		if(status!= Smart::SMART_OK)
		{
			std::cout << "Error pushing estimate data: " << Smart::StatusCodeConversion(status) << std::endl;
		}
	
	}
	
	'''
}
