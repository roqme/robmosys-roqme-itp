/*
 * generated by Xtext 2.12.0
 */
package org.xtext.roqmemapping.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.xtext.roqmemapping.parser.antlr.internal.InternalRoQMEMappingParser;
import org.xtext.roqmemapping.services.RoQMEMappingGrammarAccess;

public class RoQMEMappingParser extends AbstractAntlrParser {

	@Inject
	private RoQMEMappingGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalRoQMEMappingParser createParser(XtextTokenStream stream) {
		return new InternalRoQMEMappingParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "MappingModel";
	}

	public RoQMEMappingGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(RoQMEMappingGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}