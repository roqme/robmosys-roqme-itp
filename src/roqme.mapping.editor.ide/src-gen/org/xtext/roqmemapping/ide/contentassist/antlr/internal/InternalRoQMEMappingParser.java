package org.xtext.roqmemapping.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.xtext.roqmemapping.services.RoQMEMappingGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRoQMEMappingParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'ms'", "'s'", "'min'", "'h'", "'import'", "'context'", "'monitor'", "'{'", "'}'", "'attribute'", "':'", "'['", "']'", "'service'", "'period'", "'minTimeBtwUpdates'", "'minDiffBtwUpdates'", "'-'", "'.'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalRoQMEMappingParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRoQMEMappingParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRoQMEMappingParser.tokenNames; }
    public String getGrammarFileName() { return "InternalRoQMEMapping.g"; }


    	private RoQMEMappingGrammarAccess grammarAccess;

    	public void setGrammarAccess(RoQMEMappingGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleMappingModel"
    // InternalRoQMEMapping.g:53:1: entryRuleMappingModel : ruleMappingModel EOF ;
    public final void entryRuleMappingModel() throws RecognitionException {
        try {
            // InternalRoQMEMapping.g:54:1: ( ruleMappingModel EOF )
            // InternalRoQMEMapping.g:55:1: ruleMappingModel EOF
            {
             before(grammarAccess.getMappingModelRule()); 
            pushFollow(FOLLOW_1);
            ruleMappingModel();

            state._fsp--;

             after(grammarAccess.getMappingModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMappingModel"


    // $ANTLR start "ruleMappingModel"
    // InternalRoQMEMapping.g:62:1: ruleMappingModel : ( ( rule__MappingModel__Group__0 ) ) ;
    public final void ruleMappingModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:66:2: ( ( ( rule__MappingModel__Group__0 ) ) )
            // InternalRoQMEMapping.g:67:2: ( ( rule__MappingModel__Group__0 ) )
            {
            // InternalRoQMEMapping.g:67:2: ( ( rule__MappingModel__Group__0 ) )
            // InternalRoQMEMapping.g:68:3: ( rule__MappingModel__Group__0 )
            {
             before(grammarAccess.getMappingModelAccess().getGroup()); 
            // InternalRoQMEMapping.g:69:3: ( rule__MappingModel__Group__0 )
            // InternalRoQMEMapping.g:69:4: rule__MappingModel__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MappingModel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMappingModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMappingModel"


    // $ANTLR start "entryRuleImport"
    // InternalRoQMEMapping.g:78:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalRoQMEMapping.g:79:1: ( ruleImport EOF )
            // InternalRoQMEMapping.g:80:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalRoQMEMapping.g:87:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:91:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalRoQMEMapping.g:92:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalRoQMEMapping.g:92:2: ( ( rule__Import__Group__0 ) )
            // InternalRoQMEMapping.g:93:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalRoQMEMapping.g:94:3: ( rule__Import__Group__0 )
            // InternalRoQMEMapping.g:94:4: rule__Import__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleMonitor"
    // InternalRoQMEMapping.g:103:1: entryRuleMonitor : ruleMonitor EOF ;
    public final void entryRuleMonitor() throws RecognitionException {
        try {
            // InternalRoQMEMapping.g:104:1: ( ruleMonitor EOF )
            // InternalRoQMEMapping.g:105:1: ruleMonitor EOF
            {
             before(grammarAccess.getMonitorRule()); 
            pushFollow(FOLLOW_1);
            ruleMonitor();

            state._fsp--;

             after(grammarAccess.getMonitorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMonitor"


    // $ANTLR start "ruleMonitor"
    // InternalRoQMEMapping.g:112:1: ruleMonitor : ( ( rule__Monitor__Group__0 ) ) ;
    public final void ruleMonitor() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:116:2: ( ( ( rule__Monitor__Group__0 ) ) )
            // InternalRoQMEMapping.g:117:2: ( ( rule__Monitor__Group__0 ) )
            {
            // InternalRoQMEMapping.g:117:2: ( ( rule__Monitor__Group__0 ) )
            // InternalRoQMEMapping.g:118:3: ( rule__Monitor__Group__0 )
            {
             before(grammarAccess.getMonitorAccess().getGroup()); 
            // InternalRoQMEMapping.g:119:3: ( rule__Monitor__Group__0 )
            // InternalRoQMEMapping.g:119:4: rule__Monitor__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Monitor__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMonitorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMonitor"


    // $ANTLR start "entryRulePeriod"
    // InternalRoQMEMapping.g:128:1: entryRulePeriod : rulePeriod EOF ;
    public final void entryRulePeriod() throws RecognitionException {
        try {
            // InternalRoQMEMapping.g:129:1: ( rulePeriod EOF )
            // InternalRoQMEMapping.g:130:1: rulePeriod EOF
            {
             before(grammarAccess.getPeriodRule()); 
            pushFollow(FOLLOW_1);
            rulePeriod();

            state._fsp--;

             after(grammarAccess.getPeriodRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePeriod"


    // $ANTLR start "rulePeriod"
    // InternalRoQMEMapping.g:137:1: rulePeriod : ( ( rule__Period__Group__0 ) ) ;
    public final void rulePeriod() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:141:2: ( ( ( rule__Period__Group__0 ) ) )
            // InternalRoQMEMapping.g:142:2: ( ( rule__Period__Group__0 ) )
            {
            // InternalRoQMEMapping.g:142:2: ( ( rule__Period__Group__0 ) )
            // InternalRoQMEMapping.g:143:3: ( rule__Period__Group__0 )
            {
             before(grammarAccess.getPeriodAccess().getGroup()); 
            // InternalRoQMEMapping.g:144:3: ( rule__Period__Group__0 )
            // InternalRoQMEMapping.g:144:4: rule__Period__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Period__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPeriodAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePeriod"


    // $ANTLR start "entryRuleMinTimeBtwUpdates"
    // InternalRoQMEMapping.g:153:1: entryRuleMinTimeBtwUpdates : ruleMinTimeBtwUpdates EOF ;
    public final void entryRuleMinTimeBtwUpdates() throws RecognitionException {
        try {
            // InternalRoQMEMapping.g:154:1: ( ruleMinTimeBtwUpdates EOF )
            // InternalRoQMEMapping.g:155:1: ruleMinTimeBtwUpdates EOF
            {
             before(grammarAccess.getMinTimeBtwUpdatesRule()); 
            pushFollow(FOLLOW_1);
            ruleMinTimeBtwUpdates();

            state._fsp--;

             after(grammarAccess.getMinTimeBtwUpdatesRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMinTimeBtwUpdates"


    // $ANTLR start "ruleMinTimeBtwUpdates"
    // InternalRoQMEMapping.g:162:1: ruleMinTimeBtwUpdates : ( ( rule__MinTimeBtwUpdates__Group__0 ) ) ;
    public final void ruleMinTimeBtwUpdates() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:166:2: ( ( ( rule__MinTimeBtwUpdates__Group__0 ) ) )
            // InternalRoQMEMapping.g:167:2: ( ( rule__MinTimeBtwUpdates__Group__0 ) )
            {
            // InternalRoQMEMapping.g:167:2: ( ( rule__MinTimeBtwUpdates__Group__0 ) )
            // InternalRoQMEMapping.g:168:3: ( rule__MinTimeBtwUpdates__Group__0 )
            {
             before(grammarAccess.getMinTimeBtwUpdatesAccess().getGroup()); 
            // InternalRoQMEMapping.g:169:3: ( rule__MinTimeBtwUpdates__Group__0 )
            // InternalRoQMEMapping.g:169:4: rule__MinTimeBtwUpdates__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MinTimeBtwUpdates__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMinTimeBtwUpdatesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMinTimeBtwUpdates"


    // $ANTLR start "entryRuleMinDiffBtwUpdates"
    // InternalRoQMEMapping.g:178:1: entryRuleMinDiffBtwUpdates : ruleMinDiffBtwUpdates EOF ;
    public final void entryRuleMinDiffBtwUpdates() throws RecognitionException {
        try {
            // InternalRoQMEMapping.g:179:1: ( ruleMinDiffBtwUpdates EOF )
            // InternalRoQMEMapping.g:180:1: ruleMinDiffBtwUpdates EOF
            {
             before(grammarAccess.getMinDiffBtwUpdatesRule()); 
            pushFollow(FOLLOW_1);
            ruleMinDiffBtwUpdates();

            state._fsp--;

             after(grammarAccess.getMinDiffBtwUpdatesRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMinDiffBtwUpdates"


    // $ANTLR start "ruleMinDiffBtwUpdates"
    // InternalRoQMEMapping.g:187:1: ruleMinDiffBtwUpdates : ( ( rule__MinDiffBtwUpdates__Group__0 ) ) ;
    public final void ruleMinDiffBtwUpdates() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:191:2: ( ( ( rule__MinDiffBtwUpdates__Group__0 ) ) )
            // InternalRoQMEMapping.g:192:2: ( ( rule__MinDiffBtwUpdates__Group__0 ) )
            {
            // InternalRoQMEMapping.g:192:2: ( ( rule__MinDiffBtwUpdates__Group__0 ) )
            // InternalRoQMEMapping.g:193:3: ( rule__MinDiffBtwUpdates__Group__0 )
            {
             before(grammarAccess.getMinDiffBtwUpdatesAccess().getGroup()); 
            // InternalRoQMEMapping.g:194:3: ( rule__MinDiffBtwUpdates__Group__0 )
            // InternalRoQMEMapping.g:194:4: rule__MinDiffBtwUpdates__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MinDiffBtwUpdates__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMinDiffBtwUpdatesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMinDiffBtwUpdates"


    // $ANTLR start "entryRuleEString"
    // InternalRoQMEMapping.g:203:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalRoQMEMapping.g:204:1: ( ruleEString EOF )
            // InternalRoQMEMapping.g:205:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalRoQMEMapping.g:212:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:216:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalRoQMEMapping.g:217:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalRoQMEMapping.g:217:2: ( ( rule__EString__Alternatives ) )
            // InternalRoQMEMapping.g:218:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalRoQMEMapping.g:219:3: ( rule__EString__Alternatives )
            // InternalRoQMEMapping.g:219:4: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleEDouble"
    // InternalRoQMEMapping.g:228:1: entryRuleEDouble : ruleEDouble EOF ;
    public final void entryRuleEDouble() throws RecognitionException {
        try {
            // InternalRoQMEMapping.g:229:1: ( ruleEDouble EOF )
            // InternalRoQMEMapping.g:230:1: ruleEDouble EOF
            {
             before(grammarAccess.getEDoubleRule()); 
            pushFollow(FOLLOW_1);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getEDoubleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEDouble"


    // $ANTLR start "ruleEDouble"
    // InternalRoQMEMapping.g:237:1: ruleEDouble : ( ( rule__EDouble__Group__0 ) ) ;
    public final void ruleEDouble() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:241:2: ( ( ( rule__EDouble__Group__0 ) ) )
            // InternalRoQMEMapping.g:242:2: ( ( rule__EDouble__Group__0 ) )
            {
            // InternalRoQMEMapping.g:242:2: ( ( rule__EDouble__Group__0 ) )
            // InternalRoQMEMapping.g:243:3: ( rule__EDouble__Group__0 )
            {
             before(grammarAccess.getEDoubleAccess().getGroup()); 
            // InternalRoQMEMapping.g:244:3: ( rule__EDouble__Group__0 )
            // InternalRoQMEMapping.g:244:4: rule__EDouble__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EDouble__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEDoubleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEDouble"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalRoQMEMapping.g:253:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalRoQMEMapping.g:254:1: ( ruleQualifiedName EOF )
            // InternalRoQMEMapping.g:255:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalRoQMEMapping.g:262:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:266:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalRoQMEMapping.g:267:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalRoQMEMapping.g:267:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalRoQMEMapping.g:268:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalRoQMEMapping.g:269:3: ( rule__QualifiedName__Group__0 )
            // InternalRoQMEMapping.g:269:4: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "rule__Period__UnitAlternatives_3_0"
    // InternalRoQMEMapping.g:277:1: rule__Period__UnitAlternatives_3_0 : ( ( 'ms' ) | ( 's' ) | ( 'min' ) | ( 'h' ) );
    public final void rule__Period__UnitAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:281:1: ( ( 'ms' ) | ( 's' ) | ( 'min' ) | ( 'h' ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 12:
                {
                alt1=2;
                }
                break;
            case 13:
                {
                alt1=3;
                }
                break;
            case 14:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalRoQMEMapping.g:282:2: ( 'ms' )
                    {
                    // InternalRoQMEMapping.g:282:2: ( 'ms' )
                    // InternalRoQMEMapping.g:283:3: 'ms'
                    {
                     before(grammarAccess.getPeriodAccess().getUnitMsKeyword_3_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getPeriodAccess().getUnitMsKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRoQMEMapping.g:288:2: ( 's' )
                    {
                    // InternalRoQMEMapping.g:288:2: ( 's' )
                    // InternalRoQMEMapping.g:289:3: 's'
                    {
                     before(grammarAccess.getPeriodAccess().getUnitSKeyword_3_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getPeriodAccess().getUnitSKeyword_3_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalRoQMEMapping.g:294:2: ( 'min' )
                    {
                    // InternalRoQMEMapping.g:294:2: ( 'min' )
                    // InternalRoQMEMapping.g:295:3: 'min'
                    {
                     before(grammarAccess.getPeriodAccess().getUnitMinKeyword_3_0_2()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getPeriodAccess().getUnitMinKeyword_3_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalRoQMEMapping.g:300:2: ( 'h' )
                    {
                    // InternalRoQMEMapping.g:300:2: ( 'h' )
                    // InternalRoQMEMapping.g:301:3: 'h'
                    {
                     before(grammarAccess.getPeriodAccess().getUnitHKeyword_3_0_3()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getPeriodAccess().getUnitHKeyword_3_0_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Period__UnitAlternatives_3_0"


    // $ANTLR start "rule__MinTimeBtwUpdates__UnitAlternatives_3_0"
    // InternalRoQMEMapping.g:310:1: rule__MinTimeBtwUpdates__UnitAlternatives_3_0 : ( ( 'ms' ) | ( 's' ) | ( 'min' ) | ( 'h' ) );
    public final void rule__MinTimeBtwUpdates__UnitAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:314:1: ( ( 'ms' ) | ( 's' ) | ( 'min' ) | ( 'h' ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            case 14:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalRoQMEMapping.g:315:2: ( 'ms' )
                    {
                    // InternalRoQMEMapping.g:315:2: ( 'ms' )
                    // InternalRoQMEMapping.g:316:3: 'ms'
                    {
                     before(grammarAccess.getMinTimeBtwUpdatesAccess().getUnitMsKeyword_3_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getMinTimeBtwUpdatesAccess().getUnitMsKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRoQMEMapping.g:321:2: ( 's' )
                    {
                    // InternalRoQMEMapping.g:321:2: ( 's' )
                    // InternalRoQMEMapping.g:322:3: 's'
                    {
                     before(grammarAccess.getMinTimeBtwUpdatesAccess().getUnitSKeyword_3_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getMinTimeBtwUpdatesAccess().getUnitSKeyword_3_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalRoQMEMapping.g:327:2: ( 'min' )
                    {
                    // InternalRoQMEMapping.g:327:2: ( 'min' )
                    // InternalRoQMEMapping.g:328:3: 'min'
                    {
                     before(grammarAccess.getMinTimeBtwUpdatesAccess().getUnitMinKeyword_3_0_2()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getMinTimeBtwUpdatesAccess().getUnitMinKeyword_3_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalRoQMEMapping.g:333:2: ( 'h' )
                    {
                    // InternalRoQMEMapping.g:333:2: ( 'h' )
                    // InternalRoQMEMapping.g:334:3: 'h'
                    {
                     before(grammarAccess.getMinTimeBtwUpdatesAccess().getUnitHKeyword_3_0_3()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getMinTimeBtwUpdatesAccess().getUnitHKeyword_3_0_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinTimeBtwUpdates__UnitAlternatives_3_0"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalRoQMEMapping.g:343:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:347:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_STRING) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalRoQMEMapping.g:348:2: ( RULE_STRING )
                    {
                    // InternalRoQMEMapping.g:348:2: ( RULE_STRING )
                    // InternalRoQMEMapping.g:349:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRoQMEMapping.g:354:2: ( RULE_ID )
                    {
                    // InternalRoQMEMapping.g:354:2: ( RULE_ID )
                    // InternalRoQMEMapping.g:355:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__MappingModel__Group__0"
    // InternalRoQMEMapping.g:364:1: rule__MappingModel__Group__0 : rule__MappingModel__Group__0__Impl rule__MappingModel__Group__1 ;
    public final void rule__MappingModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:368:1: ( rule__MappingModel__Group__0__Impl rule__MappingModel__Group__1 )
            // InternalRoQMEMapping.g:369:2: rule__MappingModel__Group__0__Impl rule__MappingModel__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__MappingModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MappingModel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingModel__Group__0"


    // $ANTLR start "rule__MappingModel__Group__0__Impl"
    // InternalRoQMEMapping.g:376:1: rule__MappingModel__Group__0__Impl : ( ( rule__MappingModel__ImportsAssignment_0 )* ) ;
    public final void rule__MappingModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:380:1: ( ( ( rule__MappingModel__ImportsAssignment_0 )* ) )
            // InternalRoQMEMapping.g:381:1: ( ( rule__MappingModel__ImportsAssignment_0 )* )
            {
            // InternalRoQMEMapping.g:381:1: ( ( rule__MappingModel__ImportsAssignment_0 )* )
            // InternalRoQMEMapping.g:382:2: ( rule__MappingModel__ImportsAssignment_0 )*
            {
             before(grammarAccess.getMappingModelAccess().getImportsAssignment_0()); 
            // InternalRoQMEMapping.g:383:2: ( rule__MappingModel__ImportsAssignment_0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalRoQMEMapping.g:383:3: rule__MappingModel__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__MappingModel__ImportsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getMappingModelAccess().getImportsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingModel__Group__0__Impl"


    // $ANTLR start "rule__MappingModel__Group__1"
    // InternalRoQMEMapping.g:391:1: rule__MappingModel__Group__1 : rule__MappingModel__Group__1__Impl ;
    public final void rule__MappingModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:395:1: ( rule__MappingModel__Group__1__Impl )
            // InternalRoQMEMapping.g:396:2: rule__MappingModel__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MappingModel__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingModel__Group__1"


    // $ANTLR start "rule__MappingModel__Group__1__Impl"
    // InternalRoQMEMapping.g:402:1: rule__MappingModel__Group__1__Impl : ( ( rule__MappingModel__MonitorsAssignment_1 )* ) ;
    public final void rule__MappingModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:406:1: ( ( ( rule__MappingModel__MonitorsAssignment_1 )* ) )
            // InternalRoQMEMapping.g:407:1: ( ( rule__MappingModel__MonitorsAssignment_1 )* )
            {
            // InternalRoQMEMapping.g:407:1: ( ( rule__MappingModel__MonitorsAssignment_1 )* )
            // InternalRoQMEMapping.g:408:2: ( rule__MappingModel__MonitorsAssignment_1 )*
            {
             before(grammarAccess.getMappingModelAccess().getMonitorsAssignment_1()); 
            // InternalRoQMEMapping.g:409:2: ( rule__MappingModel__MonitorsAssignment_1 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==16) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalRoQMEMapping.g:409:3: rule__MappingModel__MonitorsAssignment_1
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__MappingModel__MonitorsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getMappingModelAccess().getMonitorsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingModel__Group__1__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // InternalRoQMEMapping.g:418:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:422:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalRoQMEMapping.g:423:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // InternalRoQMEMapping.g:430:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:434:1: ( ( 'import' ) )
            // InternalRoQMEMapping.g:435:1: ( 'import' )
            {
            // InternalRoQMEMapping.g:435:1: ( 'import' )
            // InternalRoQMEMapping.g:436:2: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // InternalRoQMEMapping.g:445:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:449:1: ( rule__Import__Group__1__Impl )
            // InternalRoQMEMapping.g:450:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // InternalRoQMEMapping.g:456:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:460:1: ( ( ( rule__Import__ImportURIAssignment_1 ) ) )
            // InternalRoQMEMapping.g:461:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            {
            // InternalRoQMEMapping.g:461:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            // InternalRoQMEMapping.g:462:2: ( rule__Import__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1()); 
            // InternalRoQMEMapping.g:463:2: ( rule__Import__ImportURIAssignment_1 )
            // InternalRoQMEMapping.g:463:3: rule__Import__ImportURIAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Import__ImportURIAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getImportURIAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__Monitor__Group__0"
    // InternalRoQMEMapping.g:472:1: rule__Monitor__Group__0 : rule__Monitor__Group__0__Impl rule__Monitor__Group__1 ;
    public final void rule__Monitor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:476:1: ( rule__Monitor__Group__0__Impl rule__Monitor__Group__1 )
            // InternalRoQMEMapping.g:477:2: rule__Monitor__Group__0__Impl rule__Monitor__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Monitor__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monitor__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group__0"


    // $ANTLR start "rule__Monitor__Group__0__Impl"
    // InternalRoQMEMapping.g:484:1: rule__Monitor__Group__0__Impl : ( 'context' ) ;
    public final void rule__Monitor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:488:1: ( ( 'context' ) )
            // InternalRoQMEMapping.g:489:1: ( 'context' )
            {
            // InternalRoQMEMapping.g:489:1: ( 'context' )
            // InternalRoQMEMapping.g:490:2: 'context'
            {
             before(grammarAccess.getMonitorAccess().getContextKeyword_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getMonitorAccess().getContextKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group__0__Impl"


    // $ANTLR start "rule__Monitor__Group__1"
    // InternalRoQMEMapping.g:499:1: rule__Monitor__Group__1 : rule__Monitor__Group__1__Impl rule__Monitor__Group__2 ;
    public final void rule__Monitor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:503:1: ( rule__Monitor__Group__1__Impl rule__Monitor__Group__2 )
            // InternalRoQMEMapping.g:504:2: rule__Monitor__Group__1__Impl rule__Monitor__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__Monitor__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monitor__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group__1"


    // $ANTLR start "rule__Monitor__Group__1__Impl"
    // InternalRoQMEMapping.g:511:1: rule__Monitor__Group__1__Impl : ( ( rule__Monitor__ContextAssignment_1 ) ) ;
    public final void rule__Monitor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:515:1: ( ( ( rule__Monitor__ContextAssignment_1 ) ) )
            // InternalRoQMEMapping.g:516:1: ( ( rule__Monitor__ContextAssignment_1 ) )
            {
            // InternalRoQMEMapping.g:516:1: ( ( rule__Monitor__ContextAssignment_1 ) )
            // InternalRoQMEMapping.g:517:2: ( rule__Monitor__ContextAssignment_1 )
            {
             before(grammarAccess.getMonitorAccess().getContextAssignment_1()); 
            // InternalRoQMEMapping.g:518:2: ( rule__Monitor__ContextAssignment_1 )
            // InternalRoQMEMapping.g:518:3: rule__Monitor__ContextAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Monitor__ContextAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMonitorAccess().getContextAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group__1__Impl"


    // $ANTLR start "rule__Monitor__Group__2"
    // InternalRoQMEMapping.g:526:1: rule__Monitor__Group__2 : rule__Monitor__Group__2__Impl rule__Monitor__Group__3 ;
    public final void rule__Monitor__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:530:1: ( rule__Monitor__Group__2__Impl rule__Monitor__Group__3 )
            // InternalRoQMEMapping.g:531:2: rule__Monitor__Group__2__Impl rule__Monitor__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__Monitor__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monitor__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group__2"


    // $ANTLR start "rule__Monitor__Group__2__Impl"
    // InternalRoQMEMapping.g:538:1: rule__Monitor__Group__2__Impl : ( 'monitor' ) ;
    public final void rule__Monitor__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:542:1: ( ( 'monitor' ) )
            // InternalRoQMEMapping.g:543:1: ( 'monitor' )
            {
            // InternalRoQMEMapping.g:543:1: ( 'monitor' )
            // InternalRoQMEMapping.g:544:2: 'monitor'
            {
             before(grammarAccess.getMonitorAccess().getMonitorKeyword_2()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getMonitorAccess().getMonitorKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group__2__Impl"


    // $ANTLR start "rule__Monitor__Group__3"
    // InternalRoQMEMapping.g:553:1: rule__Monitor__Group__3 : rule__Monitor__Group__3__Impl rule__Monitor__Group__4 ;
    public final void rule__Monitor__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:557:1: ( rule__Monitor__Group__3__Impl rule__Monitor__Group__4 )
            // InternalRoQMEMapping.g:558:2: rule__Monitor__Group__3__Impl rule__Monitor__Group__4
            {
            pushFollow(FOLLOW_10);
            rule__Monitor__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monitor__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group__3"


    // $ANTLR start "rule__Monitor__Group__3__Impl"
    // InternalRoQMEMapping.g:565:1: rule__Monitor__Group__3__Impl : ( '{' ) ;
    public final void rule__Monitor__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:569:1: ( ( '{' ) )
            // InternalRoQMEMapping.g:570:1: ( '{' )
            {
            // InternalRoQMEMapping.g:570:1: ( '{' )
            // InternalRoQMEMapping.g:571:2: '{'
            {
             before(grammarAccess.getMonitorAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getMonitorAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group__3__Impl"


    // $ANTLR start "rule__Monitor__Group__4"
    // InternalRoQMEMapping.g:580:1: rule__Monitor__Group__4 : rule__Monitor__Group__4__Impl rule__Monitor__Group__5 ;
    public final void rule__Monitor__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:584:1: ( rule__Monitor__Group__4__Impl rule__Monitor__Group__5 )
            // InternalRoQMEMapping.g:585:2: rule__Monitor__Group__4__Impl rule__Monitor__Group__5
            {
            pushFollow(FOLLOW_11);
            rule__Monitor__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monitor__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group__4"


    // $ANTLR start "rule__Monitor__Group__4__Impl"
    // InternalRoQMEMapping.g:592:1: rule__Monitor__Group__4__Impl : ( ( rule__Monitor__UnorderedGroup_4 ) ) ;
    public final void rule__Monitor__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:596:1: ( ( ( rule__Monitor__UnorderedGroup_4 ) ) )
            // InternalRoQMEMapping.g:597:1: ( ( rule__Monitor__UnorderedGroup_4 ) )
            {
            // InternalRoQMEMapping.g:597:1: ( ( rule__Monitor__UnorderedGroup_4 ) )
            // InternalRoQMEMapping.g:598:2: ( rule__Monitor__UnorderedGroup_4 )
            {
             before(grammarAccess.getMonitorAccess().getUnorderedGroup_4()); 
            // InternalRoQMEMapping.g:599:2: ( rule__Monitor__UnorderedGroup_4 )
            // InternalRoQMEMapping.g:599:3: rule__Monitor__UnorderedGroup_4
            {
            pushFollow(FOLLOW_2);
            rule__Monitor__UnorderedGroup_4();

            state._fsp--;


            }

             after(grammarAccess.getMonitorAccess().getUnorderedGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group__4__Impl"


    // $ANTLR start "rule__Monitor__Group__5"
    // InternalRoQMEMapping.g:607:1: rule__Monitor__Group__5 : rule__Monitor__Group__5__Impl ;
    public final void rule__Monitor__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:611:1: ( rule__Monitor__Group__5__Impl )
            // InternalRoQMEMapping.g:612:2: rule__Monitor__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Monitor__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group__5"


    // $ANTLR start "rule__Monitor__Group__5__Impl"
    // InternalRoQMEMapping.g:618:1: rule__Monitor__Group__5__Impl : ( '}' ) ;
    public final void rule__Monitor__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:622:1: ( ( '}' ) )
            // InternalRoQMEMapping.g:623:1: ( '}' )
            {
            // InternalRoQMEMapping.g:623:1: ( '}' )
            // InternalRoQMEMapping.g:624:2: '}'
            {
             before(grammarAccess.getMonitorAccess().getRightCurlyBracketKeyword_5()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getMonitorAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group__5__Impl"


    // $ANTLR start "rule__Monitor__Group_4_0__0"
    // InternalRoQMEMapping.g:634:1: rule__Monitor__Group_4_0__0 : rule__Monitor__Group_4_0__0__Impl rule__Monitor__Group_4_0__1 ;
    public final void rule__Monitor__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:638:1: ( rule__Monitor__Group_4_0__0__Impl rule__Monitor__Group_4_0__1 )
            // InternalRoQMEMapping.g:639:2: rule__Monitor__Group_4_0__0__Impl rule__Monitor__Group_4_0__1
            {
            pushFollow(FOLLOW_12);
            rule__Monitor__Group_4_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monitor__Group_4_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group_4_0__0"


    // $ANTLR start "rule__Monitor__Group_4_0__0__Impl"
    // InternalRoQMEMapping.g:646:1: rule__Monitor__Group_4_0__0__Impl : ( 'attribute' ) ;
    public final void rule__Monitor__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:650:1: ( ( 'attribute' ) )
            // InternalRoQMEMapping.g:651:1: ( 'attribute' )
            {
            // InternalRoQMEMapping.g:651:1: ( 'attribute' )
            // InternalRoQMEMapping.g:652:2: 'attribute'
            {
             before(grammarAccess.getMonitorAccess().getAttributeKeyword_4_0_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getMonitorAccess().getAttributeKeyword_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group_4_0__0__Impl"


    // $ANTLR start "rule__Monitor__Group_4_0__1"
    // InternalRoQMEMapping.g:661:1: rule__Monitor__Group_4_0__1 : rule__Monitor__Group_4_0__1__Impl rule__Monitor__Group_4_0__2 ;
    public final void rule__Monitor__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:665:1: ( rule__Monitor__Group_4_0__1__Impl rule__Monitor__Group_4_0__2 )
            // InternalRoQMEMapping.g:666:2: rule__Monitor__Group_4_0__1__Impl rule__Monitor__Group_4_0__2
            {
            pushFollow(FOLLOW_7);
            rule__Monitor__Group_4_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monitor__Group_4_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group_4_0__1"


    // $ANTLR start "rule__Monitor__Group_4_0__1__Impl"
    // InternalRoQMEMapping.g:673:1: rule__Monitor__Group_4_0__1__Impl : ( ':' ) ;
    public final void rule__Monitor__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:677:1: ( ( ':' ) )
            // InternalRoQMEMapping.g:678:1: ( ':' )
            {
            // InternalRoQMEMapping.g:678:1: ( ':' )
            // InternalRoQMEMapping.g:679:2: ':'
            {
             before(grammarAccess.getMonitorAccess().getColonKeyword_4_0_1()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getMonitorAccess().getColonKeyword_4_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group_4_0__1__Impl"


    // $ANTLR start "rule__Monitor__Group_4_0__2"
    // InternalRoQMEMapping.g:688:1: rule__Monitor__Group_4_0__2 : rule__Monitor__Group_4_0__2__Impl rule__Monitor__Group_4_0__3 ;
    public final void rule__Monitor__Group_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:692:1: ( rule__Monitor__Group_4_0__2__Impl rule__Monitor__Group_4_0__3 )
            // InternalRoQMEMapping.g:693:2: rule__Monitor__Group_4_0__2__Impl rule__Monitor__Group_4_0__3
            {
            pushFollow(FOLLOW_13);
            rule__Monitor__Group_4_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monitor__Group_4_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group_4_0__2"


    // $ANTLR start "rule__Monitor__Group_4_0__2__Impl"
    // InternalRoQMEMapping.g:700:1: rule__Monitor__Group_4_0__2__Impl : ( ( rule__Monitor__SourceAssignment_4_0_2 ) ) ;
    public final void rule__Monitor__Group_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:704:1: ( ( ( rule__Monitor__SourceAssignment_4_0_2 ) ) )
            // InternalRoQMEMapping.g:705:1: ( ( rule__Monitor__SourceAssignment_4_0_2 ) )
            {
            // InternalRoQMEMapping.g:705:1: ( ( rule__Monitor__SourceAssignment_4_0_2 ) )
            // InternalRoQMEMapping.g:706:2: ( rule__Monitor__SourceAssignment_4_0_2 )
            {
             before(grammarAccess.getMonitorAccess().getSourceAssignment_4_0_2()); 
            // InternalRoQMEMapping.g:707:2: ( rule__Monitor__SourceAssignment_4_0_2 )
            // InternalRoQMEMapping.g:707:3: rule__Monitor__SourceAssignment_4_0_2
            {
            pushFollow(FOLLOW_2);
            rule__Monitor__SourceAssignment_4_0_2();

            state._fsp--;


            }

             after(grammarAccess.getMonitorAccess().getSourceAssignment_4_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group_4_0__2__Impl"


    // $ANTLR start "rule__Monitor__Group_4_0__3"
    // InternalRoQMEMapping.g:715:1: rule__Monitor__Group_4_0__3 : rule__Monitor__Group_4_0__3__Impl rule__Monitor__Group_4_0__4 ;
    public final void rule__Monitor__Group_4_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:719:1: ( rule__Monitor__Group_4_0__3__Impl rule__Monitor__Group_4_0__4 )
            // InternalRoQMEMapping.g:720:2: rule__Monitor__Group_4_0__3__Impl rule__Monitor__Group_4_0__4
            {
            pushFollow(FOLLOW_6);
            rule__Monitor__Group_4_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monitor__Group_4_0__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group_4_0__3"


    // $ANTLR start "rule__Monitor__Group_4_0__3__Impl"
    // InternalRoQMEMapping.g:727:1: rule__Monitor__Group_4_0__3__Impl : ( '[' ) ;
    public final void rule__Monitor__Group_4_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:731:1: ( ( '[' ) )
            // InternalRoQMEMapping.g:732:1: ( '[' )
            {
            // InternalRoQMEMapping.g:732:1: ( '[' )
            // InternalRoQMEMapping.g:733:2: '['
            {
             before(grammarAccess.getMonitorAccess().getLeftSquareBracketKeyword_4_0_3()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getMonitorAccess().getLeftSquareBracketKeyword_4_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group_4_0__3__Impl"


    // $ANTLR start "rule__Monitor__Group_4_0__4"
    // InternalRoQMEMapping.g:742:1: rule__Monitor__Group_4_0__4 : rule__Monitor__Group_4_0__4__Impl rule__Monitor__Group_4_0__5 ;
    public final void rule__Monitor__Group_4_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:746:1: ( rule__Monitor__Group_4_0__4__Impl rule__Monitor__Group_4_0__5 )
            // InternalRoQMEMapping.g:747:2: rule__Monitor__Group_4_0__4__Impl rule__Monitor__Group_4_0__5
            {
            pushFollow(FOLLOW_14);
            rule__Monitor__Group_4_0__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monitor__Group_4_0__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group_4_0__4"


    // $ANTLR start "rule__Monitor__Group_4_0__4__Impl"
    // InternalRoQMEMapping.g:754:1: rule__Monitor__Group_4_0__4__Impl : ( ( rule__Monitor__SourceTypeAssignment_4_0_4 ) ) ;
    public final void rule__Monitor__Group_4_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:758:1: ( ( ( rule__Monitor__SourceTypeAssignment_4_0_4 ) ) )
            // InternalRoQMEMapping.g:759:1: ( ( rule__Monitor__SourceTypeAssignment_4_0_4 ) )
            {
            // InternalRoQMEMapping.g:759:1: ( ( rule__Monitor__SourceTypeAssignment_4_0_4 ) )
            // InternalRoQMEMapping.g:760:2: ( rule__Monitor__SourceTypeAssignment_4_0_4 )
            {
             before(grammarAccess.getMonitorAccess().getSourceTypeAssignment_4_0_4()); 
            // InternalRoQMEMapping.g:761:2: ( rule__Monitor__SourceTypeAssignment_4_0_4 )
            // InternalRoQMEMapping.g:761:3: rule__Monitor__SourceTypeAssignment_4_0_4
            {
            pushFollow(FOLLOW_2);
            rule__Monitor__SourceTypeAssignment_4_0_4();

            state._fsp--;


            }

             after(grammarAccess.getMonitorAccess().getSourceTypeAssignment_4_0_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group_4_0__4__Impl"


    // $ANTLR start "rule__Monitor__Group_4_0__5"
    // InternalRoQMEMapping.g:769:1: rule__Monitor__Group_4_0__5 : rule__Monitor__Group_4_0__5__Impl ;
    public final void rule__Monitor__Group_4_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:773:1: ( rule__Monitor__Group_4_0__5__Impl )
            // InternalRoQMEMapping.g:774:2: rule__Monitor__Group_4_0__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Monitor__Group_4_0__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group_4_0__5"


    // $ANTLR start "rule__Monitor__Group_4_0__5__Impl"
    // InternalRoQMEMapping.g:780:1: rule__Monitor__Group_4_0__5__Impl : ( ']' ) ;
    public final void rule__Monitor__Group_4_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:784:1: ( ( ']' ) )
            // InternalRoQMEMapping.g:785:1: ( ']' )
            {
            // InternalRoQMEMapping.g:785:1: ( ']' )
            // InternalRoQMEMapping.g:786:2: ']'
            {
             before(grammarAccess.getMonitorAccess().getRightSquareBracketKeyword_4_0_5()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getMonitorAccess().getRightSquareBracketKeyword_4_0_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group_4_0__5__Impl"


    // $ANTLR start "rule__Monitor__Group_4_1__0"
    // InternalRoQMEMapping.g:796:1: rule__Monitor__Group_4_1__0 : rule__Monitor__Group_4_1__0__Impl rule__Monitor__Group_4_1__1 ;
    public final void rule__Monitor__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:800:1: ( rule__Monitor__Group_4_1__0__Impl rule__Monitor__Group_4_1__1 )
            // InternalRoQMEMapping.g:801:2: rule__Monitor__Group_4_1__0__Impl rule__Monitor__Group_4_1__1
            {
            pushFollow(FOLLOW_12);
            rule__Monitor__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monitor__Group_4_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group_4_1__0"


    // $ANTLR start "rule__Monitor__Group_4_1__0__Impl"
    // InternalRoQMEMapping.g:808:1: rule__Monitor__Group_4_1__0__Impl : ( 'service' ) ;
    public final void rule__Monitor__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:812:1: ( ( 'service' ) )
            // InternalRoQMEMapping.g:813:1: ( 'service' )
            {
            // InternalRoQMEMapping.g:813:1: ( 'service' )
            // InternalRoQMEMapping.g:814:2: 'service'
            {
             before(grammarAccess.getMonitorAccess().getServiceKeyword_4_1_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getMonitorAccess().getServiceKeyword_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group_4_1__0__Impl"


    // $ANTLR start "rule__Monitor__Group_4_1__1"
    // InternalRoQMEMapping.g:823:1: rule__Monitor__Group_4_1__1 : rule__Monitor__Group_4_1__1__Impl rule__Monitor__Group_4_1__2 ;
    public final void rule__Monitor__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:827:1: ( rule__Monitor__Group_4_1__1__Impl rule__Monitor__Group_4_1__2 )
            // InternalRoQMEMapping.g:828:2: rule__Monitor__Group_4_1__1__Impl rule__Monitor__Group_4_1__2
            {
            pushFollow(FOLLOW_7);
            rule__Monitor__Group_4_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Monitor__Group_4_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group_4_1__1"


    // $ANTLR start "rule__Monitor__Group_4_1__1__Impl"
    // InternalRoQMEMapping.g:835:1: rule__Monitor__Group_4_1__1__Impl : ( ':' ) ;
    public final void rule__Monitor__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:839:1: ( ( ':' ) )
            // InternalRoQMEMapping.g:840:1: ( ':' )
            {
            // InternalRoQMEMapping.g:840:1: ( ':' )
            // InternalRoQMEMapping.g:841:2: ':'
            {
             before(grammarAccess.getMonitorAccess().getColonKeyword_4_1_1()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getMonitorAccess().getColonKeyword_4_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group_4_1__1__Impl"


    // $ANTLR start "rule__Monitor__Group_4_1__2"
    // InternalRoQMEMapping.g:850:1: rule__Monitor__Group_4_1__2 : rule__Monitor__Group_4_1__2__Impl ;
    public final void rule__Monitor__Group_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:854:1: ( rule__Monitor__Group_4_1__2__Impl )
            // InternalRoQMEMapping.g:855:2: rule__Monitor__Group_4_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Monitor__Group_4_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group_4_1__2"


    // $ANTLR start "rule__Monitor__Group_4_1__2__Impl"
    // InternalRoQMEMapping.g:861:1: rule__Monitor__Group_4_1__2__Impl : ( ( rule__Monitor__ServiceAssignment_4_1_2 ) ) ;
    public final void rule__Monitor__Group_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:865:1: ( ( ( rule__Monitor__ServiceAssignment_4_1_2 ) ) )
            // InternalRoQMEMapping.g:866:1: ( ( rule__Monitor__ServiceAssignment_4_1_2 ) )
            {
            // InternalRoQMEMapping.g:866:1: ( ( rule__Monitor__ServiceAssignment_4_1_2 ) )
            // InternalRoQMEMapping.g:867:2: ( rule__Monitor__ServiceAssignment_4_1_2 )
            {
             before(grammarAccess.getMonitorAccess().getServiceAssignment_4_1_2()); 
            // InternalRoQMEMapping.g:868:2: ( rule__Monitor__ServiceAssignment_4_1_2 )
            // InternalRoQMEMapping.g:868:3: rule__Monitor__ServiceAssignment_4_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Monitor__ServiceAssignment_4_1_2();

            state._fsp--;


            }

             after(grammarAccess.getMonitorAccess().getServiceAssignment_4_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__Group_4_1__2__Impl"


    // $ANTLR start "rule__Period__Group__0"
    // InternalRoQMEMapping.g:877:1: rule__Period__Group__0 : rule__Period__Group__0__Impl rule__Period__Group__1 ;
    public final void rule__Period__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:881:1: ( rule__Period__Group__0__Impl rule__Period__Group__1 )
            // InternalRoQMEMapping.g:882:2: rule__Period__Group__0__Impl rule__Period__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__Period__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Period__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Period__Group__0"


    // $ANTLR start "rule__Period__Group__0__Impl"
    // InternalRoQMEMapping.g:889:1: rule__Period__Group__0__Impl : ( 'period' ) ;
    public final void rule__Period__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:893:1: ( ( 'period' ) )
            // InternalRoQMEMapping.g:894:1: ( 'period' )
            {
            // InternalRoQMEMapping.g:894:1: ( 'period' )
            // InternalRoQMEMapping.g:895:2: 'period'
            {
             before(grammarAccess.getPeriodAccess().getPeriodKeyword_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getPeriodAccess().getPeriodKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Period__Group__0__Impl"


    // $ANTLR start "rule__Period__Group__1"
    // InternalRoQMEMapping.g:904:1: rule__Period__Group__1 : rule__Period__Group__1__Impl rule__Period__Group__2 ;
    public final void rule__Period__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:908:1: ( rule__Period__Group__1__Impl rule__Period__Group__2 )
            // InternalRoQMEMapping.g:909:2: rule__Period__Group__1__Impl rule__Period__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__Period__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Period__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Period__Group__1"


    // $ANTLR start "rule__Period__Group__1__Impl"
    // InternalRoQMEMapping.g:916:1: rule__Period__Group__1__Impl : ( ':' ) ;
    public final void rule__Period__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:920:1: ( ( ':' ) )
            // InternalRoQMEMapping.g:921:1: ( ':' )
            {
            // InternalRoQMEMapping.g:921:1: ( ':' )
            // InternalRoQMEMapping.g:922:2: ':'
            {
             before(grammarAccess.getPeriodAccess().getColonKeyword_1()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getPeriodAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Period__Group__1__Impl"


    // $ANTLR start "rule__Period__Group__2"
    // InternalRoQMEMapping.g:931:1: rule__Period__Group__2 : rule__Period__Group__2__Impl rule__Period__Group__3 ;
    public final void rule__Period__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:935:1: ( rule__Period__Group__2__Impl rule__Period__Group__3 )
            // InternalRoQMEMapping.g:936:2: rule__Period__Group__2__Impl rule__Period__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__Period__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Period__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Period__Group__2"


    // $ANTLR start "rule__Period__Group__2__Impl"
    // InternalRoQMEMapping.g:943:1: rule__Period__Group__2__Impl : ( ( rule__Period__ValueAssignment_2 ) ) ;
    public final void rule__Period__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:947:1: ( ( ( rule__Period__ValueAssignment_2 ) ) )
            // InternalRoQMEMapping.g:948:1: ( ( rule__Period__ValueAssignment_2 ) )
            {
            // InternalRoQMEMapping.g:948:1: ( ( rule__Period__ValueAssignment_2 ) )
            // InternalRoQMEMapping.g:949:2: ( rule__Period__ValueAssignment_2 )
            {
             before(grammarAccess.getPeriodAccess().getValueAssignment_2()); 
            // InternalRoQMEMapping.g:950:2: ( rule__Period__ValueAssignment_2 )
            // InternalRoQMEMapping.g:950:3: rule__Period__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Period__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPeriodAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Period__Group__2__Impl"


    // $ANTLR start "rule__Period__Group__3"
    // InternalRoQMEMapping.g:958:1: rule__Period__Group__3 : rule__Period__Group__3__Impl ;
    public final void rule__Period__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:962:1: ( rule__Period__Group__3__Impl )
            // InternalRoQMEMapping.g:963:2: rule__Period__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Period__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Period__Group__3"


    // $ANTLR start "rule__Period__Group__3__Impl"
    // InternalRoQMEMapping.g:969:1: rule__Period__Group__3__Impl : ( ( rule__Period__UnitAssignment_3 ) ) ;
    public final void rule__Period__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:973:1: ( ( ( rule__Period__UnitAssignment_3 ) ) )
            // InternalRoQMEMapping.g:974:1: ( ( rule__Period__UnitAssignment_3 ) )
            {
            // InternalRoQMEMapping.g:974:1: ( ( rule__Period__UnitAssignment_3 ) )
            // InternalRoQMEMapping.g:975:2: ( rule__Period__UnitAssignment_3 )
            {
             before(grammarAccess.getPeriodAccess().getUnitAssignment_3()); 
            // InternalRoQMEMapping.g:976:2: ( rule__Period__UnitAssignment_3 )
            // InternalRoQMEMapping.g:976:3: rule__Period__UnitAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Period__UnitAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getPeriodAccess().getUnitAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Period__Group__3__Impl"


    // $ANTLR start "rule__MinTimeBtwUpdates__Group__0"
    // InternalRoQMEMapping.g:985:1: rule__MinTimeBtwUpdates__Group__0 : rule__MinTimeBtwUpdates__Group__0__Impl rule__MinTimeBtwUpdates__Group__1 ;
    public final void rule__MinTimeBtwUpdates__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:989:1: ( rule__MinTimeBtwUpdates__Group__0__Impl rule__MinTimeBtwUpdates__Group__1 )
            // InternalRoQMEMapping.g:990:2: rule__MinTimeBtwUpdates__Group__0__Impl rule__MinTimeBtwUpdates__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__MinTimeBtwUpdates__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MinTimeBtwUpdates__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinTimeBtwUpdates__Group__0"


    // $ANTLR start "rule__MinTimeBtwUpdates__Group__0__Impl"
    // InternalRoQMEMapping.g:997:1: rule__MinTimeBtwUpdates__Group__0__Impl : ( 'minTimeBtwUpdates' ) ;
    public final void rule__MinTimeBtwUpdates__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1001:1: ( ( 'minTimeBtwUpdates' ) )
            // InternalRoQMEMapping.g:1002:1: ( 'minTimeBtwUpdates' )
            {
            // InternalRoQMEMapping.g:1002:1: ( 'minTimeBtwUpdates' )
            // InternalRoQMEMapping.g:1003:2: 'minTimeBtwUpdates'
            {
             before(grammarAccess.getMinTimeBtwUpdatesAccess().getMinTimeBtwUpdatesKeyword_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getMinTimeBtwUpdatesAccess().getMinTimeBtwUpdatesKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinTimeBtwUpdates__Group__0__Impl"


    // $ANTLR start "rule__MinTimeBtwUpdates__Group__1"
    // InternalRoQMEMapping.g:1012:1: rule__MinTimeBtwUpdates__Group__1 : rule__MinTimeBtwUpdates__Group__1__Impl rule__MinTimeBtwUpdates__Group__2 ;
    public final void rule__MinTimeBtwUpdates__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1016:1: ( rule__MinTimeBtwUpdates__Group__1__Impl rule__MinTimeBtwUpdates__Group__2 )
            // InternalRoQMEMapping.g:1017:2: rule__MinTimeBtwUpdates__Group__1__Impl rule__MinTimeBtwUpdates__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__MinTimeBtwUpdates__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MinTimeBtwUpdates__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinTimeBtwUpdates__Group__1"


    // $ANTLR start "rule__MinTimeBtwUpdates__Group__1__Impl"
    // InternalRoQMEMapping.g:1024:1: rule__MinTimeBtwUpdates__Group__1__Impl : ( ':' ) ;
    public final void rule__MinTimeBtwUpdates__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1028:1: ( ( ':' ) )
            // InternalRoQMEMapping.g:1029:1: ( ':' )
            {
            // InternalRoQMEMapping.g:1029:1: ( ':' )
            // InternalRoQMEMapping.g:1030:2: ':'
            {
             before(grammarAccess.getMinTimeBtwUpdatesAccess().getColonKeyword_1()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getMinTimeBtwUpdatesAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinTimeBtwUpdates__Group__1__Impl"


    // $ANTLR start "rule__MinTimeBtwUpdates__Group__2"
    // InternalRoQMEMapping.g:1039:1: rule__MinTimeBtwUpdates__Group__2 : rule__MinTimeBtwUpdates__Group__2__Impl rule__MinTimeBtwUpdates__Group__3 ;
    public final void rule__MinTimeBtwUpdates__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1043:1: ( rule__MinTimeBtwUpdates__Group__2__Impl rule__MinTimeBtwUpdates__Group__3 )
            // InternalRoQMEMapping.g:1044:2: rule__MinTimeBtwUpdates__Group__2__Impl rule__MinTimeBtwUpdates__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__MinTimeBtwUpdates__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MinTimeBtwUpdates__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinTimeBtwUpdates__Group__2"


    // $ANTLR start "rule__MinTimeBtwUpdates__Group__2__Impl"
    // InternalRoQMEMapping.g:1051:1: rule__MinTimeBtwUpdates__Group__2__Impl : ( ( rule__MinTimeBtwUpdates__ValueAssignment_2 ) ) ;
    public final void rule__MinTimeBtwUpdates__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1055:1: ( ( ( rule__MinTimeBtwUpdates__ValueAssignment_2 ) ) )
            // InternalRoQMEMapping.g:1056:1: ( ( rule__MinTimeBtwUpdates__ValueAssignment_2 ) )
            {
            // InternalRoQMEMapping.g:1056:1: ( ( rule__MinTimeBtwUpdates__ValueAssignment_2 ) )
            // InternalRoQMEMapping.g:1057:2: ( rule__MinTimeBtwUpdates__ValueAssignment_2 )
            {
             before(grammarAccess.getMinTimeBtwUpdatesAccess().getValueAssignment_2()); 
            // InternalRoQMEMapping.g:1058:2: ( rule__MinTimeBtwUpdates__ValueAssignment_2 )
            // InternalRoQMEMapping.g:1058:3: rule__MinTimeBtwUpdates__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__MinTimeBtwUpdates__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMinTimeBtwUpdatesAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinTimeBtwUpdates__Group__2__Impl"


    // $ANTLR start "rule__MinTimeBtwUpdates__Group__3"
    // InternalRoQMEMapping.g:1066:1: rule__MinTimeBtwUpdates__Group__3 : rule__MinTimeBtwUpdates__Group__3__Impl ;
    public final void rule__MinTimeBtwUpdates__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1070:1: ( rule__MinTimeBtwUpdates__Group__3__Impl )
            // InternalRoQMEMapping.g:1071:2: rule__MinTimeBtwUpdates__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MinTimeBtwUpdates__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinTimeBtwUpdates__Group__3"


    // $ANTLR start "rule__MinTimeBtwUpdates__Group__3__Impl"
    // InternalRoQMEMapping.g:1077:1: rule__MinTimeBtwUpdates__Group__3__Impl : ( ( rule__MinTimeBtwUpdates__UnitAssignment_3 ) ) ;
    public final void rule__MinTimeBtwUpdates__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1081:1: ( ( ( rule__MinTimeBtwUpdates__UnitAssignment_3 ) ) )
            // InternalRoQMEMapping.g:1082:1: ( ( rule__MinTimeBtwUpdates__UnitAssignment_3 ) )
            {
            // InternalRoQMEMapping.g:1082:1: ( ( rule__MinTimeBtwUpdates__UnitAssignment_3 ) )
            // InternalRoQMEMapping.g:1083:2: ( rule__MinTimeBtwUpdates__UnitAssignment_3 )
            {
             before(grammarAccess.getMinTimeBtwUpdatesAccess().getUnitAssignment_3()); 
            // InternalRoQMEMapping.g:1084:2: ( rule__MinTimeBtwUpdates__UnitAssignment_3 )
            // InternalRoQMEMapping.g:1084:3: rule__MinTimeBtwUpdates__UnitAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__MinTimeBtwUpdates__UnitAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMinTimeBtwUpdatesAccess().getUnitAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinTimeBtwUpdates__Group__3__Impl"


    // $ANTLR start "rule__MinDiffBtwUpdates__Group__0"
    // InternalRoQMEMapping.g:1093:1: rule__MinDiffBtwUpdates__Group__0 : rule__MinDiffBtwUpdates__Group__0__Impl rule__MinDiffBtwUpdates__Group__1 ;
    public final void rule__MinDiffBtwUpdates__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1097:1: ( rule__MinDiffBtwUpdates__Group__0__Impl rule__MinDiffBtwUpdates__Group__1 )
            // InternalRoQMEMapping.g:1098:2: rule__MinDiffBtwUpdates__Group__0__Impl rule__MinDiffBtwUpdates__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__MinDiffBtwUpdates__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MinDiffBtwUpdates__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinDiffBtwUpdates__Group__0"


    // $ANTLR start "rule__MinDiffBtwUpdates__Group__0__Impl"
    // InternalRoQMEMapping.g:1105:1: rule__MinDiffBtwUpdates__Group__0__Impl : ( 'minDiffBtwUpdates' ) ;
    public final void rule__MinDiffBtwUpdates__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1109:1: ( ( 'minDiffBtwUpdates' ) )
            // InternalRoQMEMapping.g:1110:1: ( 'minDiffBtwUpdates' )
            {
            // InternalRoQMEMapping.g:1110:1: ( 'minDiffBtwUpdates' )
            // InternalRoQMEMapping.g:1111:2: 'minDiffBtwUpdates'
            {
             before(grammarAccess.getMinDiffBtwUpdatesAccess().getMinDiffBtwUpdatesKeyword_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getMinDiffBtwUpdatesAccess().getMinDiffBtwUpdatesKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinDiffBtwUpdates__Group__0__Impl"


    // $ANTLR start "rule__MinDiffBtwUpdates__Group__1"
    // InternalRoQMEMapping.g:1120:1: rule__MinDiffBtwUpdates__Group__1 : rule__MinDiffBtwUpdates__Group__1__Impl rule__MinDiffBtwUpdates__Group__2 ;
    public final void rule__MinDiffBtwUpdates__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1124:1: ( rule__MinDiffBtwUpdates__Group__1__Impl rule__MinDiffBtwUpdates__Group__2 )
            // InternalRoQMEMapping.g:1125:2: rule__MinDiffBtwUpdates__Group__1__Impl rule__MinDiffBtwUpdates__Group__2
            {
            pushFollow(FOLLOW_17);
            rule__MinDiffBtwUpdates__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MinDiffBtwUpdates__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinDiffBtwUpdates__Group__1"


    // $ANTLR start "rule__MinDiffBtwUpdates__Group__1__Impl"
    // InternalRoQMEMapping.g:1132:1: rule__MinDiffBtwUpdates__Group__1__Impl : ( ':' ) ;
    public final void rule__MinDiffBtwUpdates__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1136:1: ( ( ':' ) )
            // InternalRoQMEMapping.g:1137:1: ( ':' )
            {
            // InternalRoQMEMapping.g:1137:1: ( ':' )
            // InternalRoQMEMapping.g:1138:2: ':'
            {
             before(grammarAccess.getMinDiffBtwUpdatesAccess().getColonKeyword_1()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getMinDiffBtwUpdatesAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinDiffBtwUpdates__Group__1__Impl"


    // $ANTLR start "rule__MinDiffBtwUpdates__Group__2"
    // InternalRoQMEMapping.g:1147:1: rule__MinDiffBtwUpdates__Group__2 : rule__MinDiffBtwUpdates__Group__2__Impl ;
    public final void rule__MinDiffBtwUpdates__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1151:1: ( rule__MinDiffBtwUpdates__Group__2__Impl )
            // InternalRoQMEMapping.g:1152:2: rule__MinDiffBtwUpdates__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MinDiffBtwUpdates__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinDiffBtwUpdates__Group__2"


    // $ANTLR start "rule__MinDiffBtwUpdates__Group__2__Impl"
    // InternalRoQMEMapping.g:1158:1: rule__MinDiffBtwUpdates__Group__2__Impl : ( ( rule__MinDiffBtwUpdates__ValueAssignment_2 ) ) ;
    public final void rule__MinDiffBtwUpdates__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1162:1: ( ( ( rule__MinDiffBtwUpdates__ValueAssignment_2 ) ) )
            // InternalRoQMEMapping.g:1163:1: ( ( rule__MinDiffBtwUpdates__ValueAssignment_2 ) )
            {
            // InternalRoQMEMapping.g:1163:1: ( ( rule__MinDiffBtwUpdates__ValueAssignment_2 ) )
            // InternalRoQMEMapping.g:1164:2: ( rule__MinDiffBtwUpdates__ValueAssignment_2 )
            {
             before(grammarAccess.getMinDiffBtwUpdatesAccess().getValueAssignment_2()); 
            // InternalRoQMEMapping.g:1165:2: ( rule__MinDiffBtwUpdates__ValueAssignment_2 )
            // InternalRoQMEMapping.g:1165:3: rule__MinDiffBtwUpdates__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__MinDiffBtwUpdates__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMinDiffBtwUpdatesAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinDiffBtwUpdates__Group__2__Impl"


    // $ANTLR start "rule__EDouble__Group__0"
    // InternalRoQMEMapping.g:1174:1: rule__EDouble__Group__0 : rule__EDouble__Group__0__Impl rule__EDouble__Group__1 ;
    public final void rule__EDouble__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1178:1: ( rule__EDouble__Group__0__Impl rule__EDouble__Group__1 )
            // InternalRoQMEMapping.g:1179:2: rule__EDouble__Group__0__Impl rule__EDouble__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__EDouble__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__0"


    // $ANTLR start "rule__EDouble__Group__0__Impl"
    // InternalRoQMEMapping.g:1186:1: rule__EDouble__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EDouble__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1190:1: ( ( ( '-' )? ) )
            // InternalRoQMEMapping.g:1191:1: ( ( '-' )? )
            {
            // InternalRoQMEMapping.g:1191:1: ( ( '-' )? )
            // InternalRoQMEMapping.g:1192:2: ( '-' )?
            {
             before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); 
            // InternalRoQMEMapping.g:1193:2: ( '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==28) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalRoQMEMapping.g:1193:3: '-'
                    {
                    match(input,28,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__0__Impl"


    // $ANTLR start "rule__EDouble__Group__1"
    // InternalRoQMEMapping.g:1201:1: rule__EDouble__Group__1 : rule__EDouble__Group__1__Impl rule__EDouble__Group__2 ;
    public final void rule__EDouble__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1205:1: ( rule__EDouble__Group__1__Impl rule__EDouble__Group__2 )
            // InternalRoQMEMapping.g:1206:2: rule__EDouble__Group__1__Impl rule__EDouble__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__EDouble__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__1"


    // $ANTLR start "rule__EDouble__Group__1__Impl"
    // InternalRoQMEMapping.g:1213:1: rule__EDouble__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__EDouble__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1217:1: ( ( RULE_INT ) )
            // InternalRoQMEMapping.g:1218:1: ( RULE_INT )
            {
            // InternalRoQMEMapping.g:1218:1: ( RULE_INT )
            // InternalRoQMEMapping.g:1219:2: RULE_INT
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__1__Impl"


    // $ANTLR start "rule__EDouble__Group__2"
    // InternalRoQMEMapping.g:1228:1: rule__EDouble__Group__2 : rule__EDouble__Group__2__Impl ;
    public final void rule__EDouble__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1232:1: ( rule__EDouble__Group__2__Impl )
            // InternalRoQMEMapping.g:1233:2: rule__EDouble__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EDouble__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__2"


    // $ANTLR start "rule__EDouble__Group__2__Impl"
    // InternalRoQMEMapping.g:1239:1: rule__EDouble__Group__2__Impl : ( ( rule__EDouble__Group_2__0 )? ) ;
    public final void rule__EDouble__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1243:1: ( ( ( rule__EDouble__Group_2__0 )? ) )
            // InternalRoQMEMapping.g:1244:1: ( ( rule__EDouble__Group_2__0 )? )
            {
            // InternalRoQMEMapping.g:1244:1: ( ( rule__EDouble__Group_2__0 )? )
            // InternalRoQMEMapping.g:1245:2: ( rule__EDouble__Group_2__0 )?
            {
             before(grammarAccess.getEDoubleAccess().getGroup_2()); 
            // InternalRoQMEMapping.g:1246:2: ( rule__EDouble__Group_2__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==29) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalRoQMEMapping.g:1246:3: rule__EDouble__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EDouble__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__2__Impl"


    // $ANTLR start "rule__EDouble__Group_2__0"
    // InternalRoQMEMapping.g:1255:1: rule__EDouble__Group_2__0 : rule__EDouble__Group_2__0__Impl rule__EDouble__Group_2__1 ;
    public final void rule__EDouble__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1259:1: ( rule__EDouble__Group_2__0__Impl rule__EDouble__Group_2__1 )
            // InternalRoQMEMapping.g:1260:2: rule__EDouble__Group_2__0__Impl rule__EDouble__Group_2__1
            {
            pushFollow(FOLLOW_15);
            rule__EDouble__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_2__0"


    // $ANTLR start "rule__EDouble__Group_2__0__Impl"
    // InternalRoQMEMapping.g:1267:1: rule__EDouble__Group_2__0__Impl : ( '.' ) ;
    public final void rule__EDouble__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1271:1: ( ( '.' ) )
            // InternalRoQMEMapping.g:1272:1: ( '.' )
            {
            // InternalRoQMEMapping.g:1272:1: ( '.' )
            // InternalRoQMEMapping.g:1273:2: '.'
            {
             before(grammarAccess.getEDoubleAccess().getFullStopKeyword_2_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getEDoubleAccess().getFullStopKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_2__0__Impl"


    // $ANTLR start "rule__EDouble__Group_2__1"
    // InternalRoQMEMapping.g:1282:1: rule__EDouble__Group_2__1 : rule__EDouble__Group_2__1__Impl ;
    public final void rule__EDouble__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1286:1: ( rule__EDouble__Group_2__1__Impl )
            // InternalRoQMEMapping.g:1287:2: rule__EDouble__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EDouble__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_2__1"


    // $ANTLR start "rule__EDouble__Group_2__1__Impl"
    // InternalRoQMEMapping.g:1293:1: rule__EDouble__Group_2__1__Impl : ( RULE_INT ) ;
    public final void rule__EDouble__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1297:1: ( ( RULE_INT ) )
            // InternalRoQMEMapping.g:1298:1: ( RULE_INT )
            {
            // InternalRoQMEMapping.g:1298:1: ( RULE_INT )
            // InternalRoQMEMapping.g:1299:2: RULE_INT
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_2_1()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_2__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalRoQMEMapping.g:1309:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1313:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalRoQMEMapping.g:1314:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // InternalRoQMEMapping.g:1321:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1325:1: ( ( RULE_ID ) )
            // InternalRoQMEMapping.g:1326:1: ( RULE_ID )
            {
            // InternalRoQMEMapping.g:1326:1: ( RULE_ID )
            // InternalRoQMEMapping.g:1327:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // InternalRoQMEMapping.g:1336:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1340:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalRoQMEMapping.g:1341:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // InternalRoQMEMapping.g:1347:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1351:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalRoQMEMapping.g:1352:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalRoQMEMapping.g:1352:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalRoQMEMapping.g:1353:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalRoQMEMapping.g:1354:2: ( rule__QualifiedName__Group_1__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==29) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalRoQMEMapping.g:1354:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // InternalRoQMEMapping.g:1363:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1367:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalRoQMEMapping.g:1368:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_7);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // InternalRoQMEMapping.g:1375:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1379:1: ( ( '.' ) )
            // InternalRoQMEMapping.g:1380:1: ( '.' )
            {
            // InternalRoQMEMapping.g:1380:1: ( '.' )
            // InternalRoQMEMapping.g:1381:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // InternalRoQMEMapping.g:1390:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1394:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalRoQMEMapping.g:1395:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // InternalRoQMEMapping.g:1401:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1405:1: ( ( RULE_ID ) )
            // InternalRoQMEMapping.g:1406:1: ( RULE_ID )
            {
            // InternalRoQMEMapping.g:1406:1: ( RULE_ID )
            // InternalRoQMEMapping.g:1407:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__Monitor__UnorderedGroup_4"
    // InternalRoQMEMapping.g:1417:1: rule__Monitor__UnorderedGroup_4 : rule__Monitor__UnorderedGroup_4__0 {...}?;
    public final void rule__Monitor__UnorderedGroup_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getMonitorAccess().getUnorderedGroup_4());
        	
        try {
            // InternalRoQMEMapping.g:1422:1: ( rule__Monitor__UnorderedGroup_4__0 {...}?)
            // InternalRoQMEMapping.g:1423:2: rule__Monitor__UnorderedGroup_4__0 {...}?
            {
            pushFollow(FOLLOW_2);
            rule__Monitor__UnorderedGroup_4__0();

            state._fsp--;

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getMonitorAccess().getUnorderedGroup_4()) ) {
                throw new FailedPredicateException(input, "rule__Monitor__UnorderedGroup_4", "getUnorderedGroupHelper().canLeave(grammarAccess.getMonitorAccess().getUnorderedGroup_4())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getMonitorAccess().getUnorderedGroup_4());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__UnorderedGroup_4"


    // $ANTLR start "rule__Monitor__UnorderedGroup_4__Impl"
    // InternalRoQMEMapping.g:1431:1: rule__Monitor__UnorderedGroup_4__Impl : ( ({...}? => ( ( ( rule__Monitor__Group_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Monitor__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Monitor__OptsAssignment_4_2 ) ) ) ) | ({...}? => ( ( ( rule__Monitor__OptsAssignment_4_3 ) ) ) ) | ({...}? => ( ( ( rule__Monitor__OptsAssignment_4_4 ) ) ) ) ) ;
    public final void rule__Monitor__UnorderedGroup_4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
        	
        try {
            // InternalRoQMEMapping.g:1436:1: ( ( ({...}? => ( ( ( rule__Monitor__Group_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Monitor__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Monitor__OptsAssignment_4_2 ) ) ) ) | ({...}? => ( ( ( rule__Monitor__OptsAssignment_4_3 ) ) ) ) | ({...}? => ( ( ( rule__Monitor__OptsAssignment_4_4 ) ) ) ) ) )
            // InternalRoQMEMapping.g:1437:3: ( ({...}? => ( ( ( rule__Monitor__Group_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Monitor__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Monitor__OptsAssignment_4_2 ) ) ) ) | ({...}? => ( ( ( rule__Monitor__OptsAssignment_4_3 ) ) ) ) | ({...}? => ( ( ( rule__Monitor__OptsAssignment_4_4 ) ) ) ) )
            {
            // InternalRoQMEMapping.g:1437:3: ( ({...}? => ( ( ( rule__Monitor__Group_4_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Monitor__Group_4_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Monitor__OptsAssignment_4_2 ) ) ) ) | ({...}? => ( ( ( rule__Monitor__OptsAssignment_4_3 ) ) ) ) | ({...}? => ( ( ( rule__Monitor__OptsAssignment_4_4 ) ) ) ) )
            int alt9=5;
            int LA9_0 = input.LA(1);

            if ( LA9_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 0) ) {
                alt9=1;
            }
            else if ( LA9_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 1) ) {
                alt9=2;
            }
            else if ( LA9_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 2) ) {
                alt9=3;
            }
            else if ( LA9_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 3) ) {
                alt9=4;
            }
            else if ( LA9_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 4) ) {
                alt9=5;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalRoQMEMapping.g:1438:3: ({...}? => ( ( ( rule__Monitor__Group_4_0__0 ) ) ) )
                    {
                    // InternalRoQMEMapping.g:1438:3: ({...}? => ( ( ( rule__Monitor__Group_4_0__0 ) ) ) )
                    // InternalRoQMEMapping.g:1439:4: {...}? => ( ( ( rule__Monitor__Group_4_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Monitor__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 0)");
                    }
                    // InternalRoQMEMapping.g:1439:103: ( ( ( rule__Monitor__Group_4_0__0 ) ) )
                    // InternalRoQMEMapping.g:1440:5: ( ( rule__Monitor__Group_4_0__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 0);
                    				

                    					selected = true;
                    				
                    // InternalRoQMEMapping.g:1446:5: ( ( rule__Monitor__Group_4_0__0 ) )
                    // InternalRoQMEMapping.g:1447:6: ( rule__Monitor__Group_4_0__0 )
                    {
                     before(grammarAccess.getMonitorAccess().getGroup_4_0()); 
                    // InternalRoQMEMapping.g:1448:6: ( rule__Monitor__Group_4_0__0 )
                    // InternalRoQMEMapping.g:1448:7: rule__Monitor__Group_4_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Monitor__Group_4_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMonitorAccess().getGroup_4_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRoQMEMapping.g:1453:3: ({...}? => ( ( ( rule__Monitor__Group_4_1__0 ) ) ) )
                    {
                    // InternalRoQMEMapping.g:1453:3: ({...}? => ( ( ( rule__Monitor__Group_4_1__0 ) ) ) )
                    // InternalRoQMEMapping.g:1454:4: {...}? => ( ( ( rule__Monitor__Group_4_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Monitor__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 1)");
                    }
                    // InternalRoQMEMapping.g:1454:103: ( ( ( rule__Monitor__Group_4_1__0 ) ) )
                    // InternalRoQMEMapping.g:1455:5: ( ( rule__Monitor__Group_4_1__0 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 1);
                    				

                    					selected = true;
                    				
                    // InternalRoQMEMapping.g:1461:5: ( ( rule__Monitor__Group_4_1__0 ) )
                    // InternalRoQMEMapping.g:1462:6: ( rule__Monitor__Group_4_1__0 )
                    {
                     before(grammarAccess.getMonitorAccess().getGroup_4_1()); 
                    // InternalRoQMEMapping.g:1463:6: ( rule__Monitor__Group_4_1__0 )
                    // InternalRoQMEMapping.g:1463:7: rule__Monitor__Group_4_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Monitor__Group_4_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMonitorAccess().getGroup_4_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalRoQMEMapping.g:1468:3: ({...}? => ( ( ( rule__Monitor__OptsAssignment_4_2 ) ) ) )
                    {
                    // InternalRoQMEMapping.g:1468:3: ({...}? => ( ( ( rule__Monitor__OptsAssignment_4_2 ) ) ) )
                    // InternalRoQMEMapping.g:1469:4: {...}? => ( ( ( rule__Monitor__OptsAssignment_4_2 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 2) ) {
                        throw new FailedPredicateException(input, "rule__Monitor__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 2)");
                    }
                    // InternalRoQMEMapping.g:1469:103: ( ( ( rule__Monitor__OptsAssignment_4_2 ) ) )
                    // InternalRoQMEMapping.g:1470:5: ( ( rule__Monitor__OptsAssignment_4_2 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 2);
                    				

                    					selected = true;
                    				
                    // InternalRoQMEMapping.g:1476:5: ( ( rule__Monitor__OptsAssignment_4_2 ) )
                    // InternalRoQMEMapping.g:1477:6: ( rule__Monitor__OptsAssignment_4_2 )
                    {
                     before(grammarAccess.getMonitorAccess().getOptsAssignment_4_2()); 
                    // InternalRoQMEMapping.g:1478:6: ( rule__Monitor__OptsAssignment_4_2 )
                    // InternalRoQMEMapping.g:1478:7: rule__Monitor__OptsAssignment_4_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Monitor__OptsAssignment_4_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getMonitorAccess().getOptsAssignment_4_2()); 

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalRoQMEMapping.g:1483:3: ({...}? => ( ( ( rule__Monitor__OptsAssignment_4_3 ) ) ) )
                    {
                    // InternalRoQMEMapping.g:1483:3: ({...}? => ( ( ( rule__Monitor__OptsAssignment_4_3 ) ) ) )
                    // InternalRoQMEMapping.g:1484:4: {...}? => ( ( ( rule__Monitor__OptsAssignment_4_3 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 3) ) {
                        throw new FailedPredicateException(input, "rule__Monitor__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 3)");
                    }
                    // InternalRoQMEMapping.g:1484:103: ( ( ( rule__Monitor__OptsAssignment_4_3 ) ) )
                    // InternalRoQMEMapping.g:1485:5: ( ( rule__Monitor__OptsAssignment_4_3 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 3);
                    				

                    					selected = true;
                    				
                    // InternalRoQMEMapping.g:1491:5: ( ( rule__Monitor__OptsAssignment_4_3 ) )
                    // InternalRoQMEMapping.g:1492:6: ( rule__Monitor__OptsAssignment_4_3 )
                    {
                     before(grammarAccess.getMonitorAccess().getOptsAssignment_4_3()); 
                    // InternalRoQMEMapping.g:1493:6: ( rule__Monitor__OptsAssignment_4_3 )
                    // InternalRoQMEMapping.g:1493:7: rule__Monitor__OptsAssignment_4_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Monitor__OptsAssignment_4_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getMonitorAccess().getOptsAssignment_4_3()); 

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalRoQMEMapping.g:1498:3: ({...}? => ( ( ( rule__Monitor__OptsAssignment_4_4 ) ) ) )
                    {
                    // InternalRoQMEMapping.g:1498:3: ({...}? => ( ( ( rule__Monitor__OptsAssignment_4_4 ) ) ) )
                    // InternalRoQMEMapping.g:1499:4: {...}? => ( ( ( rule__Monitor__OptsAssignment_4_4 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 4) ) {
                        throw new FailedPredicateException(input, "rule__Monitor__UnorderedGroup_4__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 4)");
                    }
                    // InternalRoQMEMapping.g:1499:103: ( ( ( rule__Monitor__OptsAssignment_4_4 ) ) )
                    // InternalRoQMEMapping.g:1500:5: ( ( rule__Monitor__OptsAssignment_4_4 ) )
                    {

                    					getUnorderedGroupHelper().select(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 4);
                    				

                    					selected = true;
                    				
                    // InternalRoQMEMapping.g:1506:5: ( ( rule__Monitor__OptsAssignment_4_4 ) )
                    // InternalRoQMEMapping.g:1507:6: ( rule__Monitor__OptsAssignment_4_4 )
                    {
                     before(grammarAccess.getMonitorAccess().getOptsAssignment_4_4()); 
                    // InternalRoQMEMapping.g:1508:6: ( rule__Monitor__OptsAssignment_4_4 )
                    // InternalRoQMEMapping.g:1508:7: rule__Monitor__OptsAssignment_4_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__Monitor__OptsAssignment_4_4();

                    state._fsp--;


                    }

                     after(grammarAccess.getMonitorAccess().getOptsAssignment_4_4()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMonitorAccess().getUnorderedGroup_4());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__UnorderedGroup_4__Impl"


    // $ANTLR start "rule__Monitor__UnorderedGroup_4__0"
    // InternalRoQMEMapping.g:1521:1: rule__Monitor__UnorderedGroup_4__0 : rule__Monitor__UnorderedGroup_4__Impl ( rule__Monitor__UnorderedGroup_4__1 )? ;
    public final void rule__Monitor__UnorderedGroup_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1525:1: ( rule__Monitor__UnorderedGroup_4__Impl ( rule__Monitor__UnorderedGroup_4__1 )? )
            // InternalRoQMEMapping.g:1526:2: rule__Monitor__UnorderedGroup_4__Impl ( rule__Monitor__UnorderedGroup_4__1 )?
            {
            pushFollow(FOLLOW_20);
            rule__Monitor__UnorderedGroup_4__Impl();

            state._fsp--;

            // InternalRoQMEMapping.g:1527:2: ( rule__Monitor__UnorderedGroup_4__1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( LA10_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 0) ) {
                alt10=1;
            }
            else if ( LA10_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 1) ) {
                alt10=1;
            }
            else if ( LA10_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 2) ) {
                alt10=1;
            }
            else if ( LA10_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 3) ) {
                alt10=1;
            }
            else if ( LA10_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 4) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalRoQMEMapping.g:1527:2: rule__Monitor__UnorderedGroup_4__1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Monitor__UnorderedGroup_4__1();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__UnorderedGroup_4__0"


    // $ANTLR start "rule__Monitor__UnorderedGroup_4__1"
    // InternalRoQMEMapping.g:1533:1: rule__Monitor__UnorderedGroup_4__1 : rule__Monitor__UnorderedGroup_4__Impl ( rule__Monitor__UnorderedGroup_4__2 )? ;
    public final void rule__Monitor__UnorderedGroup_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1537:1: ( rule__Monitor__UnorderedGroup_4__Impl ( rule__Monitor__UnorderedGroup_4__2 )? )
            // InternalRoQMEMapping.g:1538:2: rule__Monitor__UnorderedGroup_4__Impl ( rule__Monitor__UnorderedGroup_4__2 )?
            {
            pushFollow(FOLLOW_20);
            rule__Monitor__UnorderedGroup_4__Impl();

            state._fsp--;

            // InternalRoQMEMapping.g:1539:2: ( rule__Monitor__UnorderedGroup_4__2 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( LA11_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 0) ) {
                alt11=1;
            }
            else if ( LA11_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 1) ) {
                alt11=1;
            }
            else if ( LA11_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 2) ) {
                alt11=1;
            }
            else if ( LA11_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 3) ) {
                alt11=1;
            }
            else if ( LA11_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 4) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalRoQMEMapping.g:1539:2: rule__Monitor__UnorderedGroup_4__2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Monitor__UnorderedGroup_4__2();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__UnorderedGroup_4__1"


    // $ANTLR start "rule__Monitor__UnorderedGroup_4__2"
    // InternalRoQMEMapping.g:1545:1: rule__Monitor__UnorderedGroup_4__2 : rule__Monitor__UnorderedGroup_4__Impl ( rule__Monitor__UnorderedGroup_4__3 )? ;
    public final void rule__Monitor__UnorderedGroup_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1549:1: ( rule__Monitor__UnorderedGroup_4__Impl ( rule__Monitor__UnorderedGroup_4__3 )? )
            // InternalRoQMEMapping.g:1550:2: rule__Monitor__UnorderedGroup_4__Impl ( rule__Monitor__UnorderedGroup_4__3 )?
            {
            pushFollow(FOLLOW_20);
            rule__Monitor__UnorderedGroup_4__Impl();

            state._fsp--;

            // InternalRoQMEMapping.g:1551:2: ( rule__Monitor__UnorderedGroup_4__3 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( LA12_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 0) ) {
                alt12=1;
            }
            else if ( LA12_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 1) ) {
                alt12=1;
            }
            else if ( LA12_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 2) ) {
                alt12=1;
            }
            else if ( LA12_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 3) ) {
                alt12=1;
            }
            else if ( LA12_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 4) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalRoQMEMapping.g:1551:2: rule__Monitor__UnorderedGroup_4__3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Monitor__UnorderedGroup_4__3();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__UnorderedGroup_4__2"


    // $ANTLR start "rule__Monitor__UnorderedGroup_4__3"
    // InternalRoQMEMapping.g:1557:1: rule__Monitor__UnorderedGroup_4__3 : rule__Monitor__UnorderedGroup_4__Impl ( rule__Monitor__UnorderedGroup_4__4 )? ;
    public final void rule__Monitor__UnorderedGroup_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1561:1: ( rule__Monitor__UnorderedGroup_4__Impl ( rule__Monitor__UnorderedGroup_4__4 )? )
            // InternalRoQMEMapping.g:1562:2: rule__Monitor__UnorderedGroup_4__Impl ( rule__Monitor__UnorderedGroup_4__4 )?
            {
            pushFollow(FOLLOW_20);
            rule__Monitor__UnorderedGroup_4__Impl();

            state._fsp--;

            // InternalRoQMEMapping.g:1563:2: ( rule__Monitor__UnorderedGroup_4__4 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( LA13_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 0) ) {
                alt13=1;
            }
            else if ( LA13_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 1) ) {
                alt13=1;
            }
            else if ( LA13_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 2) ) {
                alt13=1;
            }
            else if ( LA13_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 3) ) {
                alt13=1;
            }
            else if ( LA13_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 4) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalRoQMEMapping.g:1563:2: rule__Monitor__UnorderedGroup_4__4
                    {
                    pushFollow(FOLLOW_2);
                    rule__Monitor__UnorderedGroup_4__4();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__UnorderedGroup_4__3"


    // $ANTLR start "rule__Monitor__UnorderedGroup_4__4"
    // InternalRoQMEMapping.g:1569:1: rule__Monitor__UnorderedGroup_4__4 : rule__Monitor__UnorderedGroup_4__Impl ;
    public final void rule__Monitor__UnorderedGroup_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1573:1: ( rule__Monitor__UnorderedGroup_4__Impl )
            // InternalRoQMEMapping.g:1574:2: rule__Monitor__UnorderedGroup_4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Monitor__UnorderedGroup_4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__UnorderedGroup_4__4"


    // $ANTLR start "rule__MappingModel__ImportsAssignment_0"
    // InternalRoQMEMapping.g:1581:1: rule__MappingModel__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__MappingModel__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1585:1: ( ( ruleImport ) )
            // InternalRoQMEMapping.g:1586:2: ( ruleImport )
            {
            // InternalRoQMEMapping.g:1586:2: ( ruleImport )
            // InternalRoQMEMapping.g:1587:3: ruleImport
            {
             before(grammarAccess.getMappingModelAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getMappingModelAccess().getImportsImportParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingModel__ImportsAssignment_0"


    // $ANTLR start "rule__MappingModel__MonitorsAssignment_1"
    // InternalRoQMEMapping.g:1596:1: rule__MappingModel__MonitorsAssignment_1 : ( ruleMonitor ) ;
    public final void rule__MappingModel__MonitorsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1600:1: ( ( ruleMonitor ) )
            // InternalRoQMEMapping.g:1601:2: ( ruleMonitor )
            {
            // InternalRoQMEMapping.g:1601:2: ( ruleMonitor )
            // InternalRoQMEMapping.g:1602:3: ruleMonitor
            {
             before(grammarAccess.getMappingModelAccess().getMonitorsMonitorParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMonitor();

            state._fsp--;

             after(grammarAccess.getMappingModelAccess().getMonitorsMonitorParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MappingModel__MonitorsAssignment_1"


    // $ANTLR start "rule__Import__ImportURIAssignment_1"
    // InternalRoQMEMapping.g:1611:1: rule__Import__ImportURIAssignment_1 : ( ruleEString ) ;
    public final void rule__Import__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1615:1: ( ( ruleEString ) )
            // InternalRoQMEMapping.g:1616:2: ( ruleEString )
            {
            // InternalRoQMEMapping.g:1616:2: ( ruleEString )
            // InternalRoQMEMapping.g:1617:3: ruleEString
            {
             before(grammarAccess.getImportAccess().getImportURIEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getImportAccess().getImportURIEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__ImportURIAssignment_1"


    // $ANTLR start "rule__Monitor__ContextAssignment_1"
    // InternalRoQMEMapping.g:1626:1: rule__Monitor__ContextAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Monitor__ContextAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1630:1: ( ( ( ruleQualifiedName ) ) )
            // InternalRoQMEMapping.g:1631:2: ( ( ruleQualifiedName ) )
            {
            // InternalRoQMEMapping.g:1631:2: ( ( ruleQualifiedName ) )
            // InternalRoQMEMapping.g:1632:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getMonitorAccess().getContextContextCrossReference_1_0()); 
            // InternalRoQMEMapping.g:1633:3: ( ruleQualifiedName )
            // InternalRoQMEMapping.g:1634:4: ruleQualifiedName
            {
             before(grammarAccess.getMonitorAccess().getContextContextQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getMonitorAccess().getContextContextQualifiedNameParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getMonitorAccess().getContextContextCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__ContextAssignment_1"


    // $ANTLR start "rule__Monitor__SourceAssignment_4_0_2"
    // InternalRoQMEMapping.g:1645:1: rule__Monitor__SourceAssignment_4_0_2 : ( ruleQualifiedName ) ;
    public final void rule__Monitor__SourceAssignment_4_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1649:1: ( ( ruleQualifiedName ) )
            // InternalRoQMEMapping.g:1650:2: ( ruleQualifiedName )
            {
            // InternalRoQMEMapping.g:1650:2: ( ruleQualifiedName )
            // InternalRoQMEMapping.g:1651:3: ruleQualifiedName
            {
             before(grammarAccess.getMonitorAccess().getSourceQualifiedNameParserRuleCall_4_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getMonitorAccess().getSourceQualifiedNameParserRuleCall_4_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__SourceAssignment_4_0_2"


    // $ANTLR start "rule__Monitor__SourceTypeAssignment_4_0_4"
    // InternalRoQMEMapping.g:1660:1: rule__Monitor__SourceTypeAssignment_4_0_4 : ( ruleEString ) ;
    public final void rule__Monitor__SourceTypeAssignment_4_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1664:1: ( ( ruleEString ) )
            // InternalRoQMEMapping.g:1665:2: ( ruleEString )
            {
            // InternalRoQMEMapping.g:1665:2: ( ruleEString )
            // InternalRoQMEMapping.g:1666:3: ruleEString
            {
             before(grammarAccess.getMonitorAccess().getSourceTypeEStringParserRuleCall_4_0_4_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getMonitorAccess().getSourceTypeEStringParserRuleCall_4_0_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__SourceTypeAssignment_4_0_4"


    // $ANTLR start "rule__Monitor__ServiceAssignment_4_1_2"
    // InternalRoQMEMapping.g:1675:1: rule__Monitor__ServiceAssignment_4_1_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Monitor__ServiceAssignment_4_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1679:1: ( ( ( ruleQualifiedName ) ) )
            // InternalRoQMEMapping.g:1680:2: ( ( ruleQualifiedName ) )
            {
            // InternalRoQMEMapping.g:1680:2: ( ( ruleQualifiedName ) )
            // InternalRoQMEMapping.g:1681:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getMonitorAccess().getServiceCommunicationServiceDefinitionCrossReference_4_1_2_0()); 
            // InternalRoQMEMapping.g:1682:3: ( ruleQualifiedName )
            // InternalRoQMEMapping.g:1683:4: ruleQualifiedName
            {
             before(grammarAccess.getMonitorAccess().getServiceCommunicationServiceDefinitionQualifiedNameParserRuleCall_4_1_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getMonitorAccess().getServiceCommunicationServiceDefinitionQualifiedNameParserRuleCall_4_1_2_0_1()); 

            }

             after(grammarAccess.getMonitorAccess().getServiceCommunicationServiceDefinitionCrossReference_4_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__ServiceAssignment_4_1_2"


    // $ANTLR start "rule__Monitor__OptsAssignment_4_2"
    // InternalRoQMEMapping.g:1694:1: rule__Monitor__OptsAssignment_4_2 : ( rulePeriod ) ;
    public final void rule__Monitor__OptsAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1698:1: ( ( rulePeriod ) )
            // InternalRoQMEMapping.g:1699:2: ( rulePeriod )
            {
            // InternalRoQMEMapping.g:1699:2: ( rulePeriod )
            // InternalRoQMEMapping.g:1700:3: rulePeriod
            {
             before(grammarAccess.getMonitorAccess().getOptsPeriodParserRuleCall_4_2_0()); 
            pushFollow(FOLLOW_2);
            rulePeriod();

            state._fsp--;

             after(grammarAccess.getMonitorAccess().getOptsPeriodParserRuleCall_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__OptsAssignment_4_2"


    // $ANTLR start "rule__Monitor__OptsAssignment_4_3"
    // InternalRoQMEMapping.g:1709:1: rule__Monitor__OptsAssignment_4_3 : ( ruleMinTimeBtwUpdates ) ;
    public final void rule__Monitor__OptsAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1713:1: ( ( ruleMinTimeBtwUpdates ) )
            // InternalRoQMEMapping.g:1714:2: ( ruleMinTimeBtwUpdates )
            {
            // InternalRoQMEMapping.g:1714:2: ( ruleMinTimeBtwUpdates )
            // InternalRoQMEMapping.g:1715:3: ruleMinTimeBtwUpdates
            {
             before(grammarAccess.getMonitorAccess().getOptsMinTimeBtwUpdatesParserRuleCall_4_3_0()); 
            pushFollow(FOLLOW_2);
            ruleMinTimeBtwUpdates();

            state._fsp--;

             after(grammarAccess.getMonitorAccess().getOptsMinTimeBtwUpdatesParserRuleCall_4_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__OptsAssignment_4_3"


    // $ANTLR start "rule__Monitor__OptsAssignment_4_4"
    // InternalRoQMEMapping.g:1724:1: rule__Monitor__OptsAssignment_4_4 : ( ruleMinDiffBtwUpdates ) ;
    public final void rule__Monitor__OptsAssignment_4_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1728:1: ( ( ruleMinDiffBtwUpdates ) )
            // InternalRoQMEMapping.g:1729:2: ( ruleMinDiffBtwUpdates )
            {
            // InternalRoQMEMapping.g:1729:2: ( ruleMinDiffBtwUpdates )
            // InternalRoQMEMapping.g:1730:3: ruleMinDiffBtwUpdates
            {
             before(grammarAccess.getMonitorAccess().getOptsMinDiffBtwUpdatesParserRuleCall_4_4_0()); 
            pushFollow(FOLLOW_2);
            ruleMinDiffBtwUpdates();

            state._fsp--;

             after(grammarAccess.getMonitorAccess().getOptsMinDiffBtwUpdatesParserRuleCall_4_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Monitor__OptsAssignment_4_4"


    // $ANTLR start "rule__Period__ValueAssignment_2"
    // InternalRoQMEMapping.g:1739:1: rule__Period__ValueAssignment_2 : ( RULE_INT ) ;
    public final void rule__Period__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1743:1: ( ( RULE_INT ) )
            // InternalRoQMEMapping.g:1744:2: ( RULE_INT )
            {
            // InternalRoQMEMapping.g:1744:2: ( RULE_INT )
            // InternalRoQMEMapping.g:1745:3: RULE_INT
            {
             before(grammarAccess.getPeriodAccess().getValueINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPeriodAccess().getValueINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Period__ValueAssignment_2"


    // $ANTLR start "rule__Period__UnitAssignment_3"
    // InternalRoQMEMapping.g:1754:1: rule__Period__UnitAssignment_3 : ( ( rule__Period__UnitAlternatives_3_0 ) ) ;
    public final void rule__Period__UnitAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1758:1: ( ( ( rule__Period__UnitAlternatives_3_0 ) ) )
            // InternalRoQMEMapping.g:1759:2: ( ( rule__Period__UnitAlternatives_3_0 ) )
            {
            // InternalRoQMEMapping.g:1759:2: ( ( rule__Period__UnitAlternatives_3_0 ) )
            // InternalRoQMEMapping.g:1760:3: ( rule__Period__UnitAlternatives_3_0 )
            {
             before(grammarAccess.getPeriodAccess().getUnitAlternatives_3_0()); 
            // InternalRoQMEMapping.g:1761:3: ( rule__Period__UnitAlternatives_3_0 )
            // InternalRoQMEMapping.g:1761:4: rule__Period__UnitAlternatives_3_0
            {
            pushFollow(FOLLOW_2);
            rule__Period__UnitAlternatives_3_0();

            state._fsp--;


            }

             after(grammarAccess.getPeriodAccess().getUnitAlternatives_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Period__UnitAssignment_3"


    // $ANTLR start "rule__MinTimeBtwUpdates__ValueAssignment_2"
    // InternalRoQMEMapping.g:1769:1: rule__MinTimeBtwUpdates__ValueAssignment_2 : ( RULE_INT ) ;
    public final void rule__MinTimeBtwUpdates__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1773:1: ( ( RULE_INT ) )
            // InternalRoQMEMapping.g:1774:2: ( RULE_INT )
            {
            // InternalRoQMEMapping.g:1774:2: ( RULE_INT )
            // InternalRoQMEMapping.g:1775:3: RULE_INT
            {
             before(grammarAccess.getMinTimeBtwUpdatesAccess().getValueINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getMinTimeBtwUpdatesAccess().getValueINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinTimeBtwUpdates__ValueAssignment_2"


    // $ANTLR start "rule__MinTimeBtwUpdates__UnitAssignment_3"
    // InternalRoQMEMapping.g:1784:1: rule__MinTimeBtwUpdates__UnitAssignment_3 : ( ( rule__MinTimeBtwUpdates__UnitAlternatives_3_0 ) ) ;
    public final void rule__MinTimeBtwUpdates__UnitAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1788:1: ( ( ( rule__MinTimeBtwUpdates__UnitAlternatives_3_0 ) ) )
            // InternalRoQMEMapping.g:1789:2: ( ( rule__MinTimeBtwUpdates__UnitAlternatives_3_0 ) )
            {
            // InternalRoQMEMapping.g:1789:2: ( ( rule__MinTimeBtwUpdates__UnitAlternatives_3_0 ) )
            // InternalRoQMEMapping.g:1790:3: ( rule__MinTimeBtwUpdates__UnitAlternatives_3_0 )
            {
             before(grammarAccess.getMinTimeBtwUpdatesAccess().getUnitAlternatives_3_0()); 
            // InternalRoQMEMapping.g:1791:3: ( rule__MinTimeBtwUpdates__UnitAlternatives_3_0 )
            // InternalRoQMEMapping.g:1791:4: rule__MinTimeBtwUpdates__UnitAlternatives_3_0
            {
            pushFollow(FOLLOW_2);
            rule__MinTimeBtwUpdates__UnitAlternatives_3_0();

            state._fsp--;


            }

             after(grammarAccess.getMinTimeBtwUpdatesAccess().getUnitAlternatives_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinTimeBtwUpdates__UnitAssignment_3"


    // $ANTLR start "rule__MinDiffBtwUpdates__ValueAssignment_2"
    // InternalRoQMEMapping.g:1799:1: rule__MinDiffBtwUpdates__ValueAssignment_2 : ( ruleEDouble ) ;
    public final void rule__MinDiffBtwUpdates__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRoQMEMapping.g:1803:1: ( ( ruleEDouble ) )
            // InternalRoQMEMapping.g:1804:2: ( ruleEDouble )
            {
            // InternalRoQMEMapping.g:1804:2: ( ruleEDouble )
            // InternalRoQMEMapping.g:1805:3: ruleEDouble
            {
             before(grammarAccess.getMinDiffBtwUpdatesAccess().getValueEDoubleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getMinDiffBtwUpdatesAccess().getValueEDoubleParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinDiffBtwUpdates__ValueAssignment_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x000000000F100000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000007800L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x000000000F100002L});

}
