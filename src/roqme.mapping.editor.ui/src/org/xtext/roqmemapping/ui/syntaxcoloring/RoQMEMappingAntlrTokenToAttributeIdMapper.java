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

import java.util.regex.Pattern;
import com.google.inject.Singleton;

import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;

/**
 * This class maps tokens obtained in the lexical analysis with concrete styles defined in 
 * <code>RoqmeHightlightingConfiguration</code>. This class needs to be bound in 
 * <code>RootUiModule</code>. 
 * 
 * @author Juan F. Ingles Romero
 */
@Singleton
public class RoQMEMappingAntlrTokenToAttributeIdMapper extends AbstractAntlrTokenToAttributeIdMapper {

private static final Pattern QUOTED = Pattern.compile("(?:^'([^']*)'$)|(?:^\"([^\"]*)\")$", Pattern.MULTILINE);
	
	private static final Pattern PUNCTUATION = Pattern.compile("\\p{Punct}*");
	
	@Override
	protected String calculateId(String tokenName, int tokenType) {
		
		String result = RoQMEMappingHighlightingConfiguration.DEFAULT_ID;
		String aux;
		
		if(PUNCTUATION.matcher(tokenName).matches()) {
			result = RoQMEMappingHighlightingConfiguration.PUNCTUATION_ID;
		}	
		else if(QUOTED.matcher(tokenName).matches()) {
			
			aux = tokenName.substring(1, tokenName.length()-1);
			
			if(isFirstLevelKeywork(aux)) {	
				result = RoQMEMappingHighlightingConfiguration.KEYWORD_ID;
			}
			else if(isSecondLevelKeywork(aux)) {
				result = RoQMEMappingHighlightingConfiguration.SECOND_LEVEL_KEYWORD_ID;
			}
			else if(isThirdLevelKeywork(aux)) {
				result = RoQMEMappingHighlightingConfiguration.THIRD_LEVEL_KEYWORD_ID;
			}
			else if(isFourthLevelKeywork(aux)) {
				result = RoQMEMappingHighlightingConfiguration.FOURTH_LEVEL_KEYWORD_ID;
			}
			else if(isFifthLevelKeywork(aux)) {
				result = RoQMEMappingHighlightingConfiguration.FIFTH_LEVEL_KEYWORD_ID;
			}
		}
		else if("RULE_STRING".equals(tokenName)) {
			return RoQMEMappingHighlightingConfiguration.STRING_ID;
		}
		else if("RULE_INT".equals(tokenName)) {
			return RoQMEMappingHighlightingConfiguration.NUMBER_ID;
		}
		else if("RULE_ML_COMMENT".equals(tokenName) || "RULE_SL_COMMENT".equals(tokenName)) {
			return RoQMEMappingHighlightingConfiguration.COMMENT_ID;
		}
		else if("RULE_ROQME_DESCRIPTION".equals(tokenName)) {
			return RoQMEMappingHighlightingConfiguration.DESCRIPTION_ID;
		}
		return result;
	}
	
	private boolean isFirstLevelKeywork(String tokenName) {
		return tokenName.equalsIgnoreCase("import")
				|| tokenName.equalsIgnoreCase("context")
				|| tokenName.equalsIgnoreCase("monitor");
	}
	
	private boolean isSecondLevelKeywork(String tokenName) {
		return false;
	}
	
	private boolean isThirdLevelKeywork(String tokenName) {
		return false;
	}
	
	private boolean isFourthLevelKeywork(String tokenName) {
		return tokenName.equalsIgnoreCase("period") 
				|| tokenName.equalsIgnoreCase("minTimeBtwUpdates") 
				|| tokenName.equalsIgnoreCase("minDiffBtwUpdates") 
				|| tokenName.equalsIgnoreCase("attribute") 
				|| tokenName.equalsIgnoreCase("service");
	}
	
	private boolean isFifthLevelKeywork(String tokenName) {
		return tokenName.equalsIgnoreCase("ms")
				|| tokenName.equalsIgnoreCase("s")
				|| tokenName.equalsIgnoreCase("min")
				|| tokenName.equalsIgnoreCase("h");
	}
}
