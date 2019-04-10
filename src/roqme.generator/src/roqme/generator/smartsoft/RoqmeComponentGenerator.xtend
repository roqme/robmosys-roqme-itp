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

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import roqme.metamodel.mapping.MappingModel


class RoqmeComponentGenerator extends AbstractGenerator {
  	
  	RoqmeComponentTemplate template;
  	
  	new (String projectName, boolean createProject) {
  		template = new RoqmeComponentTemplate(projectName, createProject);
  	}
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		if(resource.getURI().fileExtension().equalsIgnoreCase("roqmemap")) {
			for (mappModel : resource.allContents.toIterable.filter(MappingModel)) {
	            template.compile(mappModel, fsa)
	        }
        }
	}	  
}
