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

import org.eclipse.xtext.naming.QualifiedName;

/**
 * Extension of the Qualified Name for supporting two different types
 * of referring to Roqme elements, i.e., variable format: "var1.ctx1" and
 * literal format: "var1::literal1".
 * 
 * @author Juan F. Ingles Romero
 *
 */
public class RoQMEQualifiedName extends QualifiedName {
	
	/**
	 * Enumerator for identifying the qualified name format in VML.
	 * 
	 * @author Juan F. Ingles Romero
	 *
	 */
	public enum QualifiedNameTypeEnum { 
		/**
		 * Literal format for expressing references to literal values in VML (e.g., enum literals).
		 */
		literal, 
		
		/**
		 * Variable format for expressing references to VML variables.
		 */
		variable }
	
	/**
	 * Attribute to indicate the type of format present in this name instance.
	 */
	private QualifiedNameTypeEnum m_qualifiedNameType;
	
	/**
	 * Creates an instance using the qualified name segments. By default, it considers 
	 * variable format. 
	 * 
	 * @param segments name segments.
	 */
	RoQMEQualifiedName(String... segments) {
		super(segments);
		
		m_qualifiedNameType = QualifiedNameTypeEnum.variable;	
	}
	
	/**
	 * Gets the format type of the qualified name.
	 * @return format type.
	 */
	public QualifiedNameTypeEnum getQualifiedNameType() {
		return m_qualifiedNameType;
	}
	
	/**
	 * Sets the format type of the qualified name.
	 * @param type format type.
	 */
	public void setQualifiedNameType(QualifiedNameTypeEnum type) {
		m_qualifiedNameType = type;
	}
}
