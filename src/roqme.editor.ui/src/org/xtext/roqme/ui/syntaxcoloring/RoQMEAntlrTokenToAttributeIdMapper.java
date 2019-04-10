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

package org.xtext.roqme.ui.syntaxcoloring;

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
public class RoQMEAntlrTokenToAttributeIdMapper extends AbstractAntlrTokenToAttributeIdMapper {

private static final Pattern QUOTED = Pattern.compile("(?:^'([^']*)'$)|(?:^\"([^\"]*)\")$", Pattern.MULTILINE);
	
	private static final Pattern PUNCTUATION = Pattern.compile("\\p{Punct}*");
	
	@Override
	protected String calculateId(String tokenName, int tokenType) {
		
		String result = RoQMEHighlightingConfiguration.DEFAULT_ID;
		String aux;
		
		if(PUNCTUATION.matcher(tokenName).matches()) {
			result = RoQMEHighlightingConfiguration.PUNCTUATION_ID;
		}	
		else if(QUOTED.matcher(tokenName).matches()) {
			
			aux = tokenName.substring(1, tokenName.length()-1);
			
			if(isFirstLevelKeywork(aux)) {	
				result = RoQMEHighlightingConfiguration.KEYWORD_ID;
			}
			else if(isSecondLevelKeywork(aux)) {
				result = RoQMEHighlightingConfiguration.SECOND_LEVEL_KEYWORD_ID;
			}
			else if(isThirdLevelKeywork(aux)) {
				result = RoQMEHighlightingConfiguration.THIRD_LEVEL_KEYWORD_ID;
			}
			else if(isFourthLevelKeywork(aux)) {
				result = RoQMEHighlightingConfiguration.FOURTH_LEVEL_KEYWORD_ID;
			}
			else if(isFifthLevelKeywork(aux)) {
				result = RoQMEHighlightingConfiguration.FIFTH_LEVEL_KEYWORD_ID;
			}
		}
		else if("RULE_STRING".equals(tokenName)) {
			return RoQMEHighlightingConfiguration.STRING_ID;
		}
		else if("RULE_INT".equals(tokenName)) {
			return RoQMEHighlightingConfiguration.NUMBER_ID;
		}
		else if("RULE_ML_COMMENT".equals(tokenName) || "RULE_SL_COMMENT".equals(tokenName)) {
			return RoQMEHighlightingConfiguration.COMMENT_ID;
		}
		else if("RULE_ROQME_DESCRIPTION".equals(tokenName)) {
			return RoQMEHighlightingConfiguration.DESCRIPTION_ID;
		}
		return result;
	}
	
	private boolean isFirstLevelKeywork(String tokenName) {
		return tokenName.equalsIgnoreCase("import")
				|| tokenName.equalsIgnoreCase("roqme")
				|| tokenName.equalsIgnoreCase("type")
				|| tokenName.equalsIgnoreCase("context")
				|| tokenName.equalsIgnoreCase("beliefvar")
				|| tokenName.equalsIgnoreCase("property")
				|| tokenName.equalsIgnoreCase("observation")
				|| tokenName.equalsIgnoreCase("var")
				|| tokenName.equalsIgnoreCase("timer")
				|| tokenName.equalsIgnoreCase("param")
				|| tokenName.equalsIgnoreCase("reinforces")
				|| tokenName.equalsIgnoreCase("undermines")
				|| tokenName.equalsIgnoreCase("sets")
				|| tokenName.equalsIgnoreCase("starts")
				|| tokenName.equalsIgnoreCase("stops")
				|| tokenName.equalsIgnoreCase("resumes")
				|| tokenName.equalsIgnoreCase("clears");
	}
	
	private boolean isSecondLevelKeywork(String tokenName) {
		return tokenName.equalsIgnoreCase("number") 
				|| tokenName.equalsIgnoreCase("boolean") 
				|| tokenName.equalsIgnoreCase("time") 
				|| tokenName.equalsIgnoreCase("enum")
				|| tokenName.equalsIgnoreCase("eventtype");
	}
	
	private boolean isThirdLevelKeywork(String tokenName) {
		return tokenName.equalsIgnoreCase("upper") 
				|| tokenName.equalsIgnoreCase("lower") 
				|| tokenName.equalsIgnoreCase("unit")
				|| tokenName.equalsIgnoreCase("veryhigh")
				|| tokenName.equalsIgnoreCase("verylow")
				|| tokenName.equalsIgnoreCase("low")
				|| tokenName.equalsIgnoreCase("high")
				|| tokenName.equalsIgnoreCase("default")
				|| tokenName.equalsIgnoreCase("survival")
				|| tokenName.equalsIgnoreCase("reference")
				|| tokenName.equalsIgnoreCase("onetime")
				|| tokenName.equalsIgnoreCase("offset")
				|| tokenName.equalsIgnoreCase("paused");
	}
	
	private boolean isFourthLevelKeywork(String tokenName) {
		return tokenName.equalsIgnoreCase("while") 
				|| tokenName.equalsIgnoreCase("once")
				|| tokenName.equalsIgnoreCase("repeat")
				|| tokenName.equalsIgnoreCase("range")
				|| tokenName.equalsIgnoreCase("schedule")
				|| tokenName.equalsIgnoreCase("pow")
				|| tokenName.equalsIgnoreCase("sqrt")
				|| tokenName.equalsIgnoreCase("exp")
				|| tokenName.equalsIgnoreCase("abs")
				|| tokenName.equalsIgnoreCase("avg")
				|| tokenName.equalsIgnoreCase("min")
				|| tokenName.equalsIgnoreCase("max")
				|| tokenName.equalsIgnoreCase("count")
				|| tokenName.equalsIgnoreCase("sum")
				|| tokenName.equalsIgnoreCase("increasing")
				|| tokenName.equalsIgnoreCase("decreasing")
				|| tokenName.equalsIgnoreCase("stable")
				|| tokenName.equalsIgnoreCase("eventWhen")
				|| tokenName.equalsIgnoreCase("update")
				|| tokenName.equalsIgnoreCase("period")
				|| tokenName.equalsIgnoreCase("first")
				|| tokenName.equalsIgnoreCase("last")
				|| tokenName.equalsIgnoreCase("at")
				|| tokenName.equalsIgnoreCase("size")
				|| tokenName.equalsIgnoreCase("belief")
				|| tokenName.equalsIgnoreCase("and")
				|| tokenName.equalsIgnoreCase("or")
				|| tokenName.equalsIgnoreCase("not");
	}
	
	private boolean isFifthLevelKeywork(String tokenName) {
		return tokenName.equalsIgnoreCase("true")
				|| tokenName.equalsIgnoreCase("false")
				|| tokenName.equalsIgnoreCase("event")
				|| tokenName.equalsIgnoreCase("milliseconds")
				|| tokenName.equalsIgnoreCase("seconds")
				|| tokenName.equalsIgnoreCase("minutes")
				|| tokenName.equalsIgnoreCase("hours")
				|| tokenName.equalsIgnoreCase("days")
				|| tokenName.equalsIgnoreCase("millisecond")
				|| tokenName.equalsIgnoreCase("second")
				|| tokenName.equalsIgnoreCase("minute")
				|| tokenName.equalsIgnoreCase("hour")
				|| tokenName.equalsIgnoreCase("day");
	}
}
