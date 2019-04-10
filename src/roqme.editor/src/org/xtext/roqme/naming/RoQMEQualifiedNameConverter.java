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

import java.util.regex.Pattern;

import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;

/**
 * This implementation allows supporting two different formats for referring to Roqme elements, i.e., 
 * variable format and literal format. These two format differ in how to delimit the qualified
 * name segments (by default, variable use '.' and literals '::'). It is possible to change these 
 * delimiters by overriding the <code>getDelimiter</code> method. This implementation needs to be 
 * bound in <code>RootRuntimeModule</code>.
 * 
 * 
 * @author Juan F. Ingles Romero
 *
 */
public class RoQMEQualifiedNameConverter extends IQualifiedNameConverter.DefaultImpl {

	@Override 
	public String toString(QualifiedName qualifiedName) {
		
		// Argument checking
		if (qualifiedName == null)
			throw new IllegalArgumentException("Qualified name cannot be null");
		
		String result = "";
		
		// For RoqmeQualifiedName objects
		if(qualifiedName instanceof RoQMEQualifiedName) {
			
			if (qualifiedName.getSegmentCount() == 1)
				result = qualifiedName.getFirstSegment();
			
			StringBuilder builder = new StringBuilder();
			boolean isFirst = true;
			for (String segment : qualifiedName.getSegments()) {
				if (!isFirst)
					builder.append(getDelimiter(
							((RoQMEQualifiedName)qualifiedName).getQualifiedNameType()));
				isFirst = false;
				builder.append(segment);
			}
			result = builder.toString();
		}
		// For other objects
		else {
			result = super.toString(qualifiedName);
		}
		return result;
	}
	
	@Override
	public QualifiedName toQualifiedName(String qualifiedNameAsString) {
		
		// Arguments checking
		if (qualifiedNameAsString == null)
			throw new IllegalArgumentException("Qualified name cannot be null");
		if (qualifiedNameAsString.equals(""))
			throw new IllegalArgumentException("Qualified name cannot be empty");
		
		QualifiedName result = null;
		String[] segments;
		
		// For literal qualified names
		if(qualifiedNameAsString.contains(
				getDelimiter(RoQMEQualifiedName.QualifiedNameTypeEnum.literal))) 
		{
			segments = qualifiedNameAsString.split(Pattern.quote(
					getDelimiter(RoQMEQualifiedName.QualifiedNameTypeEnum.literal)));	
			result = new RoQMEQualifiedName(segments);
			((RoQMEQualifiedName)result).setQualifiedNameType(
					RoQMEQualifiedName.QualifiedNameTypeEnum.literal);
		}
		
		// For variable qualified names
		else if(qualifiedNameAsString.contains(
				getDelimiter(RoQMEQualifiedName.QualifiedNameTypeEnum.variable))) 
		{
			segments = qualifiedNameAsString.split(Pattern.quote(
					getDelimiter(RoQMEQualifiedName.QualifiedNameTypeEnum.variable)));
			result = new RoQMEQualifiedName(segments);
			((RoQMEQualifiedName)result).setQualifiedNameType(
					RoQMEQualifiedName.QualifiedNameTypeEnum.variable);
		}
		
		// For other qualified names
		else {
			result = super.toQualifiedName(qualifiedNameAsString);
		}
		
		return result;
	}

	/**
	 * This method defines the delimiter used in each type of naming format. By default,
	 * variables use '.' and literals '::'.
	 * 
	 * @param type qualified name type.
	 * @return segment delimiter.
	 */
	public String getDelimiter(RoQMEQualifiedName.QualifiedNameTypeEnum type) {
		
		String result = getDelimiter();
		
		if(type == RoQMEQualifiedName.QualifiedNameTypeEnum.literal) 
			result = "::";
		
		else if (type == RoQMEQualifiedName.QualifiedNameTypeEnum.variable)
			result = ".";
		
		return result;
	}
}

