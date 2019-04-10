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

package org.xtext.roqme.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;

import roqme.metamodel.datatypes.TypedVariable;
import roqme.metamodel.datatypes.ContainedDeclaration;
import roqme.metamodel.datatypes.DataTypeDefinition;
import roqme.metamodel.datatypes.EnumLiteral;
import roqme.metamodel.datatypes.EnumType;

/**
 * Extension of the Xtext Name Provider to tailor how to refer to some Roqme elements. 
 * This class is bound in <code>RootRuntimeModule</code>.
 * 
 * @author Juan F. Ingles Romero
 *
 */
public class RoQMEQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	/**
	 * This method returns qualified names for EnumLiteral elements, which are referred using :: 
	 * Thanks to this method the correct qualified name is shown by the auto-completion
	 * 
	 * @param enumLiteral Roqme EnumLiteral.
	 * @return qualified name.
	 */
	public QualifiedName qualifiedName(EnumLiteral enumLiteral) {
		
		IQualifiedNameConverter converter = getConverter();

		EnumType enumType = (EnumType) enumLiteral.eContainer();
		EObject aux = enumType.eContainer();
		StringBuilder strQualifiedName = new StringBuilder();
		
		if(aux instanceof ContainedDeclaration) {
			TypedVariable variable = (TypedVariable) aux.eContainer();
			
			strQualifiedName.append(variable.getName());
			strQualifiedName.append("::");
			strQualifiedName.append(enumLiteral.getName());
		}
		else if (aux instanceof DataTypeDefinition) {
			strQualifiedName.append(((DataTypeDefinition) aux).getName());
			strQualifiedName.append("::");
			strQualifiedName.append(enumLiteral.getName());
		}

		return converter.toQualifiedName(strQualifiedName.toString());		
	}
}

