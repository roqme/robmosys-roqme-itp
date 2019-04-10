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

package org.xtext.roqmemapping.ui.syntaxcoloring;

import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;

/**
 * This class allows defining the different highlighting styles used in VML. It basically 
 * associates a style with an ID that later is used in the lexical analysis 
 * (see <code>RoqmeAntlrTokenToAttributeIdMapper</code>). This class needs to be bound in 
 * <code>RootUiModule</code>. 
 * 
 * @author Juan F. Ingles Romero
 *
 */
public class RoQMEMappingHighlightingConfiguration implements IHighlightingConfiguration {

	/**
	 * First-level keywords. It is used for the most important keywords, 
	 * such as "context", "observation" and "property"
	 */
	public static final String KEYWORD_ID = "keyword";
	
	/**
	 * Second-level keywords. This is used for secondary keywords like 
	 * data types.
	 */
	public static final String SECOND_LEVEL_KEYWORD_ID = "keyword2";
	
	/**
	 * Third-level keywords. It is used for optional features in the 
	 * definition of Roqme variables, e.g., "defaultTo", "isOptional", etc.
	 */
	public static final String THIRD_LEVEL_KEYWORD_ID = "keyword3";
	
	/**
	 * Fourth-level keywords. It is used for functions 
	 * functions.
	 */
	public static final String FOURTH_LEVEL_KEYWORD_ID = "keyword4";
	
	/**
	 * Fifth-level keywords. It is used for the rest of keywords, e.g., 
	 * literals (such as true/false).
	 */
	public static final String FIFTH_LEVEL_KEYWORD_ID = "keyword5";
	
	/**
	 * Identifies descriptions for documentation.
	 */
	public static final String DESCRIPTION_ID = "description";
	
	/**
	 * Identifies punctuation characters.
	 */
	public static final String PUNCTUATION_ID = "punctuation";
	
	/**
	 * Identifies comments.
	 */
	public static final String COMMENT_ID = "comment";
	
	/**
	 * Identifies strings.
	 */
	public static final String STRING_ID = "string";
	
	/**
	 * Identifies numbers.
	 */
	public static final String NUMBER_ID = "number";
	
	/**
	 * Default identifier. 
	 */
	public static final String DEFAULT_ID = "default";
	
	/**
	 * Identifies errors.
	 */
	public static final String INVALID_TOKEN_ID = "error";
	
	
	/**
	 * Establishes the mapping between the IDs and the method to defined the style.
	 */
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		acceptor.acceptDefaultHighlighting(KEYWORD_ID, "Keyword", keyword1TextStyle());
		acceptor.acceptDefaultHighlighting(SECOND_LEVEL_KEYWORD_ID, "Second-level keyword", keyword2TextStyle());
		acceptor.acceptDefaultHighlighting(THIRD_LEVEL_KEYWORD_ID, "Third-level keyword", keyword3TextStyle());
		acceptor.acceptDefaultHighlighting(FOURTH_LEVEL_KEYWORD_ID, "Fourth-level keyword", keyword4TextStyle());
		acceptor.acceptDefaultHighlighting(FIFTH_LEVEL_KEYWORD_ID, "Fifth-level keyword", keyword5TextStyle());
		acceptor.acceptDefaultHighlighting(DESCRIPTION_ID, "Description", descriptionTextStyle());
		acceptor.acceptDefaultHighlighting(PUNCTUATION_ID, "Punctuation character", punctuationTextStyle());
		acceptor.acceptDefaultHighlighting(COMMENT_ID, "Comment", commentTextStyle());
		acceptor.acceptDefaultHighlighting(STRING_ID, "String", stringTextStyle());
		acceptor.acceptDefaultHighlighting(NUMBER_ID, "Number", numberTextStyle());
		acceptor.acceptDefaultHighlighting(DEFAULT_ID, "Default", defaultTextStyle());
		acceptor.acceptDefaultHighlighting(INVALID_TOKEN_ID, "Invalid Symbol", errorTextStyle());
	}   
	
	/**
	 * Style definition for first-level keywords.
	 * @return text style.
	 */
	public TextStyle keyword1TextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(127, 0, 85));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}
	
	/**
	 * Style definition for second-level keywords.
	 * @return text style.
	 */
	public TextStyle keyword2TextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(82, 80, 139)); //RGB(82, 80, 139) morado // RGB(0,0,170) azul-lila //RGB(192, 14, 0) rojo // RGB(41, 91, 215) azul claro
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}
	
	/**
	 * Style definition for third-level keywords.
	 * @return text style.
	 */
	public TextStyle keyword3TextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(/*212, 172, 13*/128, 128, 38));
		return textStyle;
	}
	
	/**
	 * Style definition for strings.
	 * @return text style.
	 */
	public TextStyle keyword4TextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(/*244, 108, 10*/142, 76, 27));
		return textStyle;
	}
	
	/**
	 * Style definition for fifth-level keywords.
	 * @return text style.
	 */
	public TextStyle keyword5TextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(125, 125, 125));
		return textStyle;
	}
	
	/**
	 * Style definition for description.
	 * @return text style.
	 */
	public TextStyle descriptionTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(127, 159, 191));
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}	
	
	/**
	 * Style definition for errors.
	 * @return text style.
	 */
	public TextStyle errorTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		return textStyle;
	}
	
	/**
	 * Style definition for numbers.
	 * @return text style.
	 */
	public TextStyle numberTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(125, 125, 125));
		return textStyle;
	}

	/**
	 * Style definition for strings.
	 * @return text style.
	 */
	public TextStyle stringTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(69, 9, 244));
		return textStyle;
	}

	/**
	 * Style definition for comments.
	 * @return text style.
	 */
	public TextStyle commentTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(63, 127, 95));
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}

	/**
	 * Style definition for punctuation characters.
	 * @return text style.
	 */
	public TextStyle punctuationTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		return textStyle;
	}
	
	/**
	 * Default style definition.
	 * @return text style.
	 */
	public TextStyle defaultTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(new RGB(0, 0, 0));
		return textStyle;
	}
}

