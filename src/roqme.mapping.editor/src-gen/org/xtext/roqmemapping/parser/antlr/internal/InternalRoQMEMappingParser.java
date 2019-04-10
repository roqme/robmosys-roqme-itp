package org.xtext.roqmemapping.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.roqmemapping.services.RoQMEMappingGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRoQMEMappingParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'context'", "'monitor'", "'{'", "'attribute'", "':'", "'['", "']'", "'service'", "'}'", "'period'", "'ms'", "'s'", "'min'", "'h'", "'minTimeBtwUpdates'", "'minDiffBtwUpdates'", "'-'", "'.'"
    };
    public static final int RULE_STRING=5;
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
    public static final int RULE_ID=6;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=4;
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

        public InternalRoQMEMappingParser(TokenStream input, RoQMEMappingGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "MappingModel";
       	}

       	@Override
       	protected RoQMEMappingGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleMappingModel"
    // InternalRoQMEMapping.g:64:1: entryRuleMappingModel returns [EObject current=null] : iv_ruleMappingModel= ruleMappingModel EOF ;
    public final EObject entryRuleMappingModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingModel = null;


        try {
            // InternalRoQMEMapping.g:64:53: (iv_ruleMappingModel= ruleMappingModel EOF )
            // InternalRoQMEMapping.g:65:2: iv_ruleMappingModel= ruleMappingModel EOF
            {
             newCompositeNode(grammarAccess.getMappingModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMappingModel=ruleMappingModel();

            state._fsp--;

             current =iv_ruleMappingModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMappingModel"


    // $ANTLR start "ruleMappingModel"
    // InternalRoQMEMapping.g:71:1: ruleMappingModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_monitors_1_0= ruleMonitor ) )* ) ;
    public final EObject ruleMappingModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_monitors_1_0 = null;



        	enterRule();

        try {
            // InternalRoQMEMapping.g:77:2: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_monitors_1_0= ruleMonitor ) )* ) )
            // InternalRoQMEMapping.g:78:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_monitors_1_0= ruleMonitor ) )* )
            {
            // InternalRoQMEMapping.g:78:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_monitors_1_0= ruleMonitor ) )* )
            // InternalRoQMEMapping.g:79:3: ( (lv_imports_0_0= ruleImport ) )* ( (lv_monitors_1_0= ruleMonitor ) )*
            {
            // InternalRoQMEMapping.g:79:3: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalRoQMEMapping.g:80:4: (lv_imports_0_0= ruleImport )
            	    {
            	    // InternalRoQMEMapping.g:80:4: (lv_imports_0_0= ruleImport )
            	    // InternalRoQMEMapping.g:81:5: lv_imports_0_0= ruleImport
            	    {

            	    					newCompositeNode(grammarAccess.getMappingModelAccess().getImportsImportParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMappingModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_0_0,
            	    						"org.xtext.roqmemapping.RoQMEMapping.Import");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalRoQMEMapping.g:98:3: ( (lv_monitors_1_0= ruleMonitor ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalRoQMEMapping.g:99:4: (lv_monitors_1_0= ruleMonitor )
            	    {
            	    // InternalRoQMEMapping.g:99:4: (lv_monitors_1_0= ruleMonitor )
            	    // InternalRoQMEMapping.g:100:5: lv_monitors_1_0= ruleMonitor
            	    {

            	    					newCompositeNode(grammarAccess.getMappingModelAccess().getMonitorsMonitorParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_monitors_1_0=ruleMonitor();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMappingModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"monitors",
            	    						lv_monitors_1_0,
            	    						"org.xtext.roqmemapping.RoQMEMapping.Monitor");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMappingModel"


    // $ANTLR start "entryRuleImport"
    // InternalRoQMEMapping.g:121:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalRoQMEMapping.g:121:47: (iv_ruleImport= ruleImport EOF )
            // InternalRoQMEMapping.g:122:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalRoQMEMapping.g:128:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= ruleEString ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importURI_1_0 = null;



        	enterRule();

        try {
            // InternalRoQMEMapping.g:134:2: ( (otherlv_0= 'import' ( (lv_importURI_1_0= ruleEString ) ) ) )
            // InternalRoQMEMapping.g:135:2: (otherlv_0= 'import' ( (lv_importURI_1_0= ruleEString ) ) )
            {
            // InternalRoQMEMapping.g:135:2: (otherlv_0= 'import' ( (lv_importURI_1_0= ruleEString ) ) )
            // InternalRoQMEMapping.g:136:3: otherlv_0= 'import' ( (lv_importURI_1_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalRoQMEMapping.g:140:3: ( (lv_importURI_1_0= ruleEString ) )
            // InternalRoQMEMapping.g:141:4: (lv_importURI_1_0= ruleEString )
            {
            // InternalRoQMEMapping.g:141:4: (lv_importURI_1_0= ruleEString )
            // InternalRoQMEMapping.g:142:5: lv_importURI_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getImportAccess().getImportURIEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_importURI_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImportRule());
            					}
            					set(
            						current,
            						"importURI",
            						lv_importURI_1_0,
            						"org.xtext.roqmemapping.RoQMEMapping.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleMonitor"
    // InternalRoQMEMapping.g:163:1: entryRuleMonitor returns [EObject current=null] : iv_ruleMonitor= ruleMonitor EOF ;
    public final EObject entryRuleMonitor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMonitor = null;


        try {
            // InternalRoQMEMapping.g:163:48: (iv_ruleMonitor= ruleMonitor EOF )
            // InternalRoQMEMapping.g:164:2: iv_ruleMonitor= ruleMonitor EOF
            {
             newCompositeNode(grammarAccess.getMonitorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMonitor=ruleMonitor();

            state._fsp--;

             current =iv_ruleMonitor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMonitor"


    // $ANTLR start "ruleMonitor"
    // InternalRoQMEMapping.g:170:1: ruleMonitor returns [EObject current=null] : (otherlv_0= 'context' ( ( ruleQualifiedName ) ) otherlv_2= 'monitor' otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'attribute' otherlv_6= ':' ( (lv_source_7_0= ruleQualifiedName ) ) otherlv_8= '[' ( (lv_sourceType_9_0= ruleEString ) ) otherlv_10= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'service' otherlv_12= ':' ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_14_0= rulePeriod ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_15_0= ruleMinTimeBtwUpdates ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_16_0= ruleMinDiffBtwUpdates ) ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' ) ;
    public final EObject ruleMonitor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_17=null;
        AntlrDatatypeRuleToken lv_source_7_0 = null;

        AntlrDatatypeRuleToken lv_sourceType_9_0 = null;

        EObject lv_opts_14_0 = null;

        EObject lv_opts_15_0 = null;

        EObject lv_opts_16_0 = null;



        	enterRule();

        try {
            // InternalRoQMEMapping.g:176:2: ( (otherlv_0= 'context' ( ( ruleQualifiedName ) ) otherlv_2= 'monitor' otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'attribute' otherlv_6= ':' ( (lv_source_7_0= ruleQualifiedName ) ) otherlv_8= '[' ( (lv_sourceType_9_0= ruleEString ) ) otherlv_10= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'service' otherlv_12= ':' ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_14_0= rulePeriod ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_15_0= ruleMinTimeBtwUpdates ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_16_0= ruleMinDiffBtwUpdates ) ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' ) )
            // InternalRoQMEMapping.g:177:2: (otherlv_0= 'context' ( ( ruleQualifiedName ) ) otherlv_2= 'monitor' otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'attribute' otherlv_6= ':' ( (lv_source_7_0= ruleQualifiedName ) ) otherlv_8= '[' ( (lv_sourceType_9_0= ruleEString ) ) otherlv_10= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'service' otherlv_12= ':' ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_14_0= rulePeriod ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_15_0= ruleMinTimeBtwUpdates ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_16_0= ruleMinDiffBtwUpdates ) ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )
            {
            // InternalRoQMEMapping.g:177:2: (otherlv_0= 'context' ( ( ruleQualifiedName ) ) otherlv_2= 'monitor' otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'attribute' otherlv_6= ':' ( (lv_source_7_0= ruleQualifiedName ) ) otherlv_8= '[' ( (lv_sourceType_9_0= ruleEString ) ) otherlv_10= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'service' otherlv_12= ':' ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_14_0= rulePeriod ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_15_0= ruleMinTimeBtwUpdates ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_16_0= ruleMinDiffBtwUpdates ) ) ) ) ) )+ {...}?) ) ) otherlv_17= '}' )
            // InternalRoQMEMapping.g:178:3: otherlv_0= 'context' ( ( ruleQualifiedName ) ) otherlv_2= 'monitor' otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'attribute' otherlv_6= ':' ( (lv_source_7_0= ruleQualifiedName ) ) otherlv_8= '[' ( (lv_sourceType_9_0= ruleEString ) ) otherlv_10= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'service' otherlv_12= ':' ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_14_0= rulePeriod ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_15_0= ruleMinTimeBtwUpdates ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_16_0= ruleMinDiffBtwUpdates ) ) ) ) ) )+ {...}?) ) ) otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getMonitorAccess().getContextKeyword_0());
            		
            // InternalRoQMEMapping.g:182:3: ( ( ruleQualifiedName ) )
            // InternalRoQMEMapping.g:183:4: ( ruleQualifiedName )
            {
            // InternalRoQMEMapping.g:183:4: ( ruleQualifiedName )
            // InternalRoQMEMapping.g:184:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMonitorRule());
            					}
            				

            					newCompositeNode(grammarAccess.getMonitorAccess().getContextContextCrossReference_1_0());
            				
            pushFollow(FOLLOW_7);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getMonitorAccess().getMonitorKeyword_2());
            		
            otherlv_3=(Token)match(input,14,FOLLOW_9); 

            			newLeafNode(otherlv_3, grammarAccess.getMonitorAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalRoQMEMapping.g:206:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'attribute' otherlv_6= ':' ( (lv_source_7_0= ruleQualifiedName ) ) otherlv_8= '[' ( (lv_sourceType_9_0= ruleEString ) ) otherlv_10= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'service' otherlv_12= ':' ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_14_0= rulePeriod ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_15_0= ruleMinTimeBtwUpdates ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_16_0= ruleMinDiffBtwUpdates ) ) ) ) ) )+ {...}?) ) )
            // InternalRoQMEMapping.g:207:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'attribute' otherlv_6= ':' ( (lv_source_7_0= ruleQualifiedName ) ) otherlv_8= '[' ( (lv_sourceType_9_0= ruleEString ) ) otherlv_10= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'service' otherlv_12= ':' ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_14_0= rulePeriod ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_15_0= ruleMinTimeBtwUpdates ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_16_0= ruleMinDiffBtwUpdates ) ) ) ) ) )+ {...}?) )
            {
            // InternalRoQMEMapping.g:207:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'attribute' otherlv_6= ':' ( (lv_source_7_0= ruleQualifiedName ) ) otherlv_8= '[' ( (lv_sourceType_9_0= ruleEString ) ) otherlv_10= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'service' otherlv_12= ':' ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_14_0= rulePeriod ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_15_0= ruleMinTimeBtwUpdates ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_16_0= ruleMinDiffBtwUpdates ) ) ) ) ) )+ {...}?) )
            // InternalRoQMEMapping.g:208:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'attribute' otherlv_6= ':' ( (lv_source_7_0= ruleQualifiedName ) ) otherlv_8= '[' ( (lv_sourceType_9_0= ruleEString ) ) otherlv_10= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'service' otherlv_12= ':' ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_14_0= rulePeriod ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_15_0= ruleMinTimeBtwUpdates ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_16_0= ruleMinDiffBtwUpdates ) ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getMonitorAccess().getUnorderedGroup_4());
            				
            // InternalRoQMEMapping.g:211:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'attribute' otherlv_6= ':' ( (lv_source_7_0= ruleQualifiedName ) ) otherlv_8= '[' ( (lv_sourceType_9_0= ruleEString ) ) otherlv_10= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'service' otherlv_12= ':' ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_14_0= rulePeriod ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_15_0= ruleMinTimeBtwUpdates ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_16_0= ruleMinDiffBtwUpdates ) ) ) ) ) )+ {...}?)
            // InternalRoQMEMapping.g:212:6: ( ({...}? => ( ({...}? => (otherlv_5= 'attribute' otherlv_6= ':' ( (lv_source_7_0= ruleQualifiedName ) ) otherlv_8= '[' ( (lv_sourceType_9_0= ruleEString ) ) otherlv_10= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'service' otherlv_12= ':' ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_14_0= rulePeriod ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_15_0= ruleMinTimeBtwUpdates ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_16_0= ruleMinDiffBtwUpdates ) ) ) ) ) )+ {...}?
            {
            // InternalRoQMEMapping.g:212:6: ( ({...}? => ( ({...}? => (otherlv_5= 'attribute' otherlv_6= ':' ( (lv_source_7_0= ruleQualifiedName ) ) otherlv_8= '[' ( (lv_sourceType_9_0= ruleEString ) ) otherlv_10= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'service' otherlv_12= ':' ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_14_0= rulePeriod ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_15_0= ruleMinTimeBtwUpdates ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_opts_16_0= ruleMinDiffBtwUpdates ) ) ) ) ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=6;
                int LA3_0 = input.LA(1);

                if ( LA3_0 == 15 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 0) ) {
                    alt3=1;
                }
                else if ( LA3_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 1) ) {
                    alt3=2;
                }
                else if ( LA3_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 2) ) {
                    alt3=3;
                }
                else if ( LA3_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 3) ) {
                    alt3=4;
                }
                else if ( LA3_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 4) ) {
                    alt3=5;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalRoQMEMapping.g:213:4: ({...}? => ( ({...}? => (otherlv_5= 'attribute' otherlv_6= ':' ( (lv_source_7_0= ruleQualifiedName ) ) otherlv_8= '[' ( (lv_sourceType_9_0= ruleEString ) ) otherlv_10= ']' ) ) ) )
            	    {
            	    // InternalRoQMEMapping.g:213:4: ({...}? => ( ({...}? => (otherlv_5= 'attribute' otherlv_6= ':' ( (lv_source_7_0= ruleQualifiedName ) ) otherlv_8= '[' ( (lv_sourceType_9_0= ruleEString ) ) otherlv_10= ']' ) ) ) )
            	    // InternalRoQMEMapping.g:214:5: {...}? => ( ({...}? => (otherlv_5= 'attribute' otherlv_6= ':' ( (lv_source_7_0= ruleQualifiedName ) ) otherlv_8= '[' ( (lv_sourceType_9_0= ruleEString ) ) otherlv_10= ']' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleMonitor", "getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalRoQMEMapping.g:214:104: ( ({...}? => (otherlv_5= 'attribute' otherlv_6= ':' ( (lv_source_7_0= ruleQualifiedName ) ) otherlv_8= '[' ( (lv_sourceType_9_0= ruleEString ) ) otherlv_10= ']' ) ) )
            	    // InternalRoQMEMapping.g:215:6: ({...}? => (otherlv_5= 'attribute' otherlv_6= ':' ( (lv_source_7_0= ruleQualifiedName ) ) otherlv_8= '[' ( (lv_sourceType_9_0= ruleEString ) ) otherlv_10= ']' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalRoQMEMapping.g:218:9: ({...}? => (otherlv_5= 'attribute' otherlv_6= ':' ( (lv_source_7_0= ruleQualifiedName ) ) otherlv_8= '[' ( (lv_sourceType_9_0= ruleEString ) ) otherlv_10= ']' ) )
            	    // InternalRoQMEMapping.g:218:10: {...}? => (otherlv_5= 'attribute' otherlv_6= ':' ( (lv_source_7_0= ruleQualifiedName ) ) otherlv_8= '[' ( (lv_sourceType_9_0= ruleEString ) ) otherlv_10= ']' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleMonitor", "true");
            	    }
            	    // InternalRoQMEMapping.g:218:19: (otherlv_5= 'attribute' otherlv_6= ':' ( (lv_source_7_0= ruleQualifiedName ) ) otherlv_8= '[' ( (lv_sourceType_9_0= ruleEString ) ) otherlv_10= ']' )
            	    // InternalRoQMEMapping.g:218:20: otherlv_5= 'attribute' otherlv_6= ':' ( (lv_source_7_0= ruleQualifiedName ) ) otherlv_8= '[' ( (lv_sourceType_9_0= ruleEString ) ) otherlv_10= ']'
            	    {
            	    otherlv_5=(Token)match(input,15,FOLLOW_10); 

            	    									newLeafNode(otherlv_5, grammarAccess.getMonitorAccess().getAttributeKeyword_4_0_0());
            	    								
            	    otherlv_6=(Token)match(input,16,FOLLOW_6); 

            	    									newLeafNode(otherlv_6, grammarAccess.getMonitorAccess().getColonKeyword_4_0_1());
            	    								
            	    // InternalRoQMEMapping.g:226:9: ( (lv_source_7_0= ruleQualifiedName ) )
            	    // InternalRoQMEMapping.g:227:10: (lv_source_7_0= ruleQualifiedName )
            	    {
            	    // InternalRoQMEMapping.g:227:10: (lv_source_7_0= ruleQualifiedName )
            	    // InternalRoQMEMapping.g:228:11: lv_source_7_0= ruleQualifiedName
            	    {

            	    											newCompositeNode(grammarAccess.getMonitorAccess().getSourceQualifiedNameParserRuleCall_4_0_2_0());
            	    										
            	    pushFollow(FOLLOW_11);
            	    lv_source_7_0=ruleQualifiedName();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getMonitorRule());
            	    											}
            	    											set(
            	    												current,
            	    												"source",
            	    												lv_source_7_0,
            	    												"org.xtext.roqmemapping.RoQMEMapping.QualifiedName");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }

            	    otherlv_8=(Token)match(input,17,FOLLOW_5); 

            	    									newLeafNode(otherlv_8, grammarAccess.getMonitorAccess().getLeftSquareBracketKeyword_4_0_3());
            	    								
            	    // InternalRoQMEMapping.g:249:9: ( (lv_sourceType_9_0= ruleEString ) )
            	    // InternalRoQMEMapping.g:250:10: (lv_sourceType_9_0= ruleEString )
            	    {
            	    // InternalRoQMEMapping.g:250:10: (lv_sourceType_9_0= ruleEString )
            	    // InternalRoQMEMapping.g:251:11: lv_sourceType_9_0= ruleEString
            	    {

            	    											newCompositeNode(grammarAccess.getMonitorAccess().getSourceTypeEStringParserRuleCall_4_0_4_0());
            	    										
            	    pushFollow(FOLLOW_12);
            	    lv_sourceType_9_0=ruleEString();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getMonitorRule());
            	    											}
            	    											set(
            	    												current,
            	    												"sourceType",
            	    												lv_sourceType_9_0,
            	    												"org.xtext.roqmemapping.RoQMEMapping.EString");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }

            	    otherlv_10=(Token)match(input,18,FOLLOW_13); 

            	    									newLeafNode(otherlv_10, grammarAccess.getMonitorAccess().getRightSquareBracketKeyword_4_0_5());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMonitorAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRoQMEMapping.g:278:4: ({...}? => ( ({...}? => (otherlv_11= 'service' otherlv_12= ':' ( ( ruleQualifiedName ) ) ) ) ) )
            	    {
            	    // InternalRoQMEMapping.g:278:4: ({...}? => ( ({...}? => (otherlv_11= 'service' otherlv_12= ':' ( ( ruleQualifiedName ) ) ) ) ) )
            	    // InternalRoQMEMapping.g:279:5: {...}? => ( ({...}? => (otherlv_11= 'service' otherlv_12= ':' ( ( ruleQualifiedName ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleMonitor", "getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalRoQMEMapping.g:279:104: ( ({...}? => (otherlv_11= 'service' otherlv_12= ':' ( ( ruleQualifiedName ) ) ) ) )
            	    // InternalRoQMEMapping.g:280:6: ({...}? => (otherlv_11= 'service' otherlv_12= ':' ( ( ruleQualifiedName ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalRoQMEMapping.g:283:9: ({...}? => (otherlv_11= 'service' otherlv_12= ':' ( ( ruleQualifiedName ) ) ) )
            	    // InternalRoQMEMapping.g:283:10: {...}? => (otherlv_11= 'service' otherlv_12= ':' ( ( ruleQualifiedName ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleMonitor", "true");
            	    }
            	    // InternalRoQMEMapping.g:283:19: (otherlv_11= 'service' otherlv_12= ':' ( ( ruleQualifiedName ) ) )
            	    // InternalRoQMEMapping.g:283:20: otherlv_11= 'service' otherlv_12= ':' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_11=(Token)match(input,19,FOLLOW_10); 

            	    									newLeafNode(otherlv_11, grammarAccess.getMonitorAccess().getServiceKeyword_4_1_0());
            	    								
            	    otherlv_12=(Token)match(input,16,FOLLOW_6); 

            	    									newLeafNode(otherlv_12, grammarAccess.getMonitorAccess().getColonKeyword_4_1_1());
            	    								
            	    // InternalRoQMEMapping.g:291:9: ( ( ruleQualifiedName ) )
            	    // InternalRoQMEMapping.g:292:10: ( ruleQualifiedName )
            	    {
            	    // InternalRoQMEMapping.g:292:10: ( ruleQualifiedName )
            	    // InternalRoQMEMapping.g:293:11: ruleQualifiedName
            	    {

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getMonitorRule());
            	    											}
            	    										

            	    											newCompositeNode(grammarAccess.getMonitorAccess().getServiceCommunicationServiceDefinitionCrossReference_4_1_2_0());
            	    										
            	    pushFollow(FOLLOW_13);
            	    ruleQualifiedName();

            	    state._fsp--;


            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMonitorAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRoQMEMapping.g:313:4: ({...}? => ( ({...}? => ( (lv_opts_14_0= rulePeriod ) ) ) ) )
            	    {
            	    // InternalRoQMEMapping.g:313:4: ({...}? => ( ({...}? => ( (lv_opts_14_0= rulePeriod ) ) ) ) )
            	    // InternalRoQMEMapping.g:314:5: {...}? => ( ({...}? => ( (lv_opts_14_0= rulePeriod ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleMonitor", "getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalRoQMEMapping.g:314:104: ( ({...}? => ( (lv_opts_14_0= rulePeriod ) ) ) )
            	    // InternalRoQMEMapping.g:315:6: ({...}? => ( (lv_opts_14_0= rulePeriod ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalRoQMEMapping.g:318:9: ({...}? => ( (lv_opts_14_0= rulePeriod ) ) )
            	    // InternalRoQMEMapping.g:318:10: {...}? => ( (lv_opts_14_0= rulePeriod ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleMonitor", "true");
            	    }
            	    // InternalRoQMEMapping.g:318:19: ( (lv_opts_14_0= rulePeriod ) )
            	    // InternalRoQMEMapping.g:318:20: (lv_opts_14_0= rulePeriod )
            	    {
            	    // InternalRoQMEMapping.g:318:20: (lv_opts_14_0= rulePeriod )
            	    // InternalRoQMEMapping.g:319:10: lv_opts_14_0= rulePeriod
            	    {

            	    										newCompositeNode(grammarAccess.getMonitorAccess().getOptsPeriodParserRuleCall_4_2_0());
            	    									
            	    pushFollow(FOLLOW_13);
            	    lv_opts_14_0=rulePeriod();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getMonitorRule());
            	    										}
            	    										add(
            	    											current,
            	    											"opts",
            	    											lv_opts_14_0,
            	    											"org.xtext.roqmemapping.RoQMEMapping.Period");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMonitorAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalRoQMEMapping.g:341:4: ({...}? => ( ({...}? => ( (lv_opts_15_0= ruleMinTimeBtwUpdates ) ) ) ) )
            	    {
            	    // InternalRoQMEMapping.g:341:4: ({...}? => ( ({...}? => ( (lv_opts_15_0= ruleMinTimeBtwUpdates ) ) ) ) )
            	    // InternalRoQMEMapping.g:342:5: {...}? => ( ({...}? => ( (lv_opts_15_0= ruleMinTimeBtwUpdates ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleMonitor", "getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalRoQMEMapping.g:342:104: ( ({...}? => ( (lv_opts_15_0= ruleMinTimeBtwUpdates ) ) ) )
            	    // InternalRoQMEMapping.g:343:6: ({...}? => ( (lv_opts_15_0= ruleMinTimeBtwUpdates ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalRoQMEMapping.g:346:9: ({...}? => ( (lv_opts_15_0= ruleMinTimeBtwUpdates ) ) )
            	    // InternalRoQMEMapping.g:346:10: {...}? => ( (lv_opts_15_0= ruleMinTimeBtwUpdates ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleMonitor", "true");
            	    }
            	    // InternalRoQMEMapping.g:346:19: ( (lv_opts_15_0= ruleMinTimeBtwUpdates ) )
            	    // InternalRoQMEMapping.g:346:20: (lv_opts_15_0= ruleMinTimeBtwUpdates )
            	    {
            	    // InternalRoQMEMapping.g:346:20: (lv_opts_15_0= ruleMinTimeBtwUpdates )
            	    // InternalRoQMEMapping.g:347:10: lv_opts_15_0= ruleMinTimeBtwUpdates
            	    {

            	    										newCompositeNode(grammarAccess.getMonitorAccess().getOptsMinTimeBtwUpdatesParserRuleCall_4_3_0());
            	    									
            	    pushFollow(FOLLOW_13);
            	    lv_opts_15_0=ruleMinTimeBtwUpdates();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getMonitorRule());
            	    										}
            	    										add(
            	    											current,
            	    											"opts",
            	    											lv_opts_15_0,
            	    											"org.xtext.roqmemapping.RoQMEMapping.MinTimeBtwUpdates");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMonitorAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalRoQMEMapping.g:369:4: ({...}? => ( ({...}? => ( (lv_opts_16_0= ruleMinDiffBtwUpdates ) ) ) ) )
            	    {
            	    // InternalRoQMEMapping.g:369:4: ({...}? => ( ({...}? => ( (lv_opts_16_0= ruleMinDiffBtwUpdates ) ) ) ) )
            	    // InternalRoQMEMapping.g:370:5: {...}? => ( ({...}? => ( (lv_opts_16_0= ruleMinDiffBtwUpdates ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleMonitor", "getUnorderedGroupHelper().canSelect(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 4)");
            	    }
            	    // InternalRoQMEMapping.g:370:104: ( ({...}? => ( (lv_opts_16_0= ruleMinDiffBtwUpdates ) ) ) )
            	    // InternalRoQMEMapping.g:371:6: ({...}? => ( (lv_opts_16_0= ruleMinDiffBtwUpdates ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getMonitorAccess().getUnorderedGroup_4(), 4);
            	    					
            	    // InternalRoQMEMapping.g:374:9: ({...}? => ( (lv_opts_16_0= ruleMinDiffBtwUpdates ) ) )
            	    // InternalRoQMEMapping.g:374:10: {...}? => ( (lv_opts_16_0= ruleMinDiffBtwUpdates ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleMonitor", "true");
            	    }
            	    // InternalRoQMEMapping.g:374:19: ( (lv_opts_16_0= ruleMinDiffBtwUpdates ) )
            	    // InternalRoQMEMapping.g:374:20: (lv_opts_16_0= ruleMinDiffBtwUpdates )
            	    {
            	    // InternalRoQMEMapping.g:374:20: (lv_opts_16_0= ruleMinDiffBtwUpdates )
            	    // InternalRoQMEMapping.g:375:10: lv_opts_16_0= ruleMinDiffBtwUpdates
            	    {

            	    										newCompositeNode(grammarAccess.getMonitorAccess().getOptsMinDiffBtwUpdatesParserRuleCall_4_4_0());
            	    									
            	    pushFollow(FOLLOW_13);
            	    lv_opts_16_0=ruleMinDiffBtwUpdates();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getMonitorRule());
            	    										}
            	    										add(
            	    											current,
            	    											"opts",
            	    											lv_opts_16_0,
            	    											"org.xtext.roqmemapping.RoQMEMapping.MinDiffBtwUpdates");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMonitorAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getMonitorAccess().getUnorderedGroup_4()) ) {
                throw new FailedPredicateException(input, "ruleMonitor", "getUnorderedGroupHelper().canLeave(grammarAccess.getMonitorAccess().getUnorderedGroup_4())");
            }

            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getMonitorAccess().getUnorderedGroup_4());
            				

            }

            otherlv_17=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getMonitorAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMonitor"


    // $ANTLR start "entryRulePeriod"
    // InternalRoQMEMapping.g:413:1: entryRulePeriod returns [EObject current=null] : iv_rulePeriod= rulePeriod EOF ;
    public final EObject entryRulePeriod() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePeriod = null;


        try {
            // InternalRoQMEMapping.g:413:47: (iv_rulePeriod= rulePeriod EOF )
            // InternalRoQMEMapping.g:414:2: iv_rulePeriod= rulePeriod EOF
            {
             newCompositeNode(grammarAccess.getPeriodRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePeriod=rulePeriod();

            state._fsp--;

             current =iv_rulePeriod; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePeriod"


    // $ANTLR start "rulePeriod"
    // InternalRoQMEMapping.g:420:1: rulePeriod returns [EObject current=null] : (otherlv_0= 'period' otherlv_1= ':' ( (lv_value_2_0= RULE_INT ) ) ( ( (lv_unit_3_1= 'ms' | lv_unit_3_2= 's' | lv_unit_3_3= 'min' | lv_unit_3_4= 'h' ) ) ) ) ;
    public final EObject rulePeriod() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token lv_unit_3_1=null;
        Token lv_unit_3_2=null;
        Token lv_unit_3_3=null;
        Token lv_unit_3_4=null;


        	enterRule();

        try {
            // InternalRoQMEMapping.g:426:2: ( (otherlv_0= 'period' otherlv_1= ':' ( (lv_value_2_0= RULE_INT ) ) ( ( (lv_unit_3_1= 'ms' | lv_unit_3_2= 's' | lv_unit_3_3= 'min' | lv_unit_3_4= 'h' ) ) ) ) )
            // InternalRoQMEMapping.g:427:2: (otherlv_0= 'period' otherlv_1= ':' ( (lv_value_2_0= RULE_INT ) ) ( ( (lv_unit_3_1= 'ms' | lv_unit_3_2= 's' | lv_unit_3_3= 'min' | lv_unit_3_4= 'h' ) ) ) )
            {
            // InternalRoQMEMapping.g:427:2: (otherlv_0= 'period' otherlv_1= ':' ( (lv_value_2_0= RULE_INT ) ) ( ( (lv_unit_3_1= 'ms' | lv_unit_3_2= 's' | lv_unit_3_3= 'min' | lv_unit_3_4= 'h' ) ) ) )
            // InternalRoQMEMapping.g:428:3: otherlv_0= 'period' otherlv_1= ':' ( (lv_value_2_0= RULE_INT ) ) ( ( (lv_unit_3_1= 'ms' | lv_unit_3_2= 's' | lv_unit_3_3= 'min' | lv_unit_3_4= 'h' ) ) )
            {
            otherlv_0=(Token)match(input,21,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getPeriodAccess().getPeriodKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_14); 

            			newLeafNode(otherlv_1, grammarAccess.getPeriodAccess().getColonKeyword_1());
            		
            // InternalRoQMEMapping.g:436:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalRoQMEMapping.g:437:4: (lv_value_2_0= RULE_INT )
            {
            // InternalRoQMEMapping.g:437:4: (lv_value_2_0= RULE_INT )
            // InternalRoQMEMapping.g:438:5: lv_value_2_0= RULE_INT
            {
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_15); 

            					newLeafNode(lv_value_2_0, grammarAccess.getPeriodAccess().getValueINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPeriodRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalRoQMEMapping.g:454:3: ( ( (lv_unit_3_1= 'ms' | lv_unit_3_2= 's' | lv_unit_3_3= 'min' | lv_unit_3_4= 'h' ) ) )
            // InternalRoQMEMapping.g:455:4: ( (lv_unit_3_1= 'ms' | lv_unit_3_2= 's' | lv_unit_3_3= 'min' | lv_unit_3_4= 'h' ) )
            {
            // InternalRoQMEMapping.g:455:4: ( (lv_unit_3_1= 'ms' | lv_unit_3_2= 's' | lv_unit_3_3= 'min' | lv_unit_3_4= 'h' ) )
            // InternalRoQMEMapping.g:456:5: (lv_unit_3_1= 'ms' | lv_unit_3_2= 's' | lv_unit_3_3= 'min' | lv_unit_3_4= 'h' )
            {
            // InternalRoQMEMapping.g:456:5: (lv_unit_3_1= 'ms' | lv_unit_3_2= 's' | lv_unit_3_3= 'min' | lv_unit_3_4= 'h' )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt4=1;
                }
                break;
            case 23:
                {
                alt4=2;
                }
                break;
            case 24:
                {
                alt4=3;
                }
                break;
            case 25:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalRoQMEMapping.g:457:6: lv_unit_3_1= 'ms'
                    {
                    lv_unit_3_1=(Token)match(input,22,FOLLOW_2); 

                    						newLeafNode(lv_unit_3_1, grammarAccess.getPeriodAccess().getUnitMsKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPeriodRule());
                    						}
                    						setWithLastConsumed(current, "unit", lv_unit_3_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalRoQMEMapping.g:468:6: lv_unit_3_2= 's'
                    {
                    lv_unit_3_2=(Token)match(input,23,FOLLOW_2); 

                    						newLeafNode(lv_unit_3_2, grammarAccess.getPeriodAccess().getUnitSKeyword_3_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPeriodRule());
                    						}
                    						setWithLastConsumed(current, "unit", lv_unit_3_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalRoQMEMapping.g:479:6: lv_unit_3_3= 'min'
                    {
                    lv_unit_3_3=(Token)match(input,24,FOLLOW_2); 

                    						newLeafNode(lv_unit_3_3, grammarAccess.getPeriodAccess().getUnitMinKeyword_3_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPeriodRule());
                    						}
                    						setWithLastConsumed(current, "unit", lv_unit_3_3, null);
                    					

                    }
                    break;
                case 4 :
                    // InternalRoQMEMapping.g:490:6: lv_unit_3_4= 'h'
                    {
                    lv_unit_3_4=(Token)match(input,25,FOLLOW_2); 

                    						newLeafNode(lv_unit_3_4, grammarAccess.getPeriodAccess().getUnitHKeyword_3_0_3());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPeriodRule());
                    						}
                    						setWithLastConsumed(current, "unit", lv_unit_3_4, null);
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePeriod"


    // $ANTLR start "entryRuleMinTimeBtwUpdates"
    // InternalRoQMEMapping.g:507:1: entryRuleMinTimeBtwUpdates returns [EObject current=null] : iv_ruleMinTimeBtwUpdates= ruleMinTimeBtwUpdates EOF ;
    public final EObject entryRuleMinTimeBtwUpdates() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinTimeBtwUpdates = null;


        try {
            // InternalRoQMEMapping.g:507:58: (iv_ruleMinTimeBtwUpdates= ruleMinTimeBtwUpdates EOF )
            // InternalRoQMEMapping.g:508:2: iv_ruleMinTimeBtwUpdates= ruleMinTimeBtwUpdates EOF
            {
             newCompositeNode(grammarAccess.getMinTimeBtwUpdatesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMinTimeBtwUpdates=ruleMinTimeBtwUpdates();

            state._fsp--;

             current =iv_ruleMinTimeBtwUpdates; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMinTimeBtwUpdates"


    // $ANTLR start "ruleMinTimeBtwUpdates"
    // InternalRoQMEMapping.g:514:1: ruleMinTimeBtwUpdates returns [EObject current=null] : (otherlv_0= 'minTimeBtwUpdates' otherlv_1= ':' ( (lv_value_2_0= RULE_INT ) ) ( ( (lv_unit_3_1= 'ms' | lv_unit_3_2= 's' | lv_unit_3_3= 'min' | lv_unit_3_4= 'h' ) ) ) ) ;
    public final EObject ruleMinTimeBtwUpdates() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token lv_unit_3_1=null;
        Token lv_unit_3_2=null;
        Token lv_unit_3_3=null;
        Token lv_unit_3_4=null;


        	enterRule();

        try {
            // InternalRoQMEMapping.g:520:2: ( (otherlv_0= 'minTimeBtwUpdates' otherlv_1= ':' ( (lv_value_2_0= RULE_INT ) ) ( ( (lv_unit_3_1= 'ms' | lv_unit_3_2= 's' | lv_unit_3_3= 'min' | lv_unit_3_4= 'h' ) ) ) ) )
            // InternalRoQMEMapping.g:521:2: (otherlv_0= 'minTimeBtwUpdates' otherlv_1= ':' ( (lv_value_2_0= RULE_INT ) ) ( ( (lv_unit_3_1= 'ms' | lv_unit_3_2= 's' | lv_unit_3_3= 'min' | lv_unit_3_4= 'h' ) ) ) )
            {
            // InternalRoQMEMapping.g:521:2: (otherlv_0= 'minTimeBtwUpdates' otherlv_1= ':' ( (lv_value_2_0= RULE_INT ) ) ( ( (lv_unit_3_1= 'ms' | lv_unit_3_2= 's' | lv_unit_3_3= 'min' | lv_unit_3_4= 'h' ) ) ) )
            // InternalRoQMEMapping.g:522:3: otherlv_0= 'minTimeBtwUpdates' otherlv_1= ':' ( (lv_value_2_0= RULE_INT ) ) ( ( (lv_unit_3_1= 'ms' | lv_unit_3_2= 's' | lv_unit_3_3= 'min' | lv_unit_3_4= 'h' ) ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getMinTimeBtwUpdatesAccess().getMinTimeBtwUpdatesKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_14); 

            			newLeafNode(otherlv_1, grammarAccess.getMinTimeBtwUpdatesAccess().getColonKeyword_1());
            		
            // InternalRoQMEMapping.g:530:3: ( (lv_value_2_0= RULE_INT ) )
            // InternalRoQMEMapping.g:531:4: (lv_value_2_0= RULE_INT )
            {
            // InternalRoQMEMapping.g:531:4: (lv_value_2_0= RULE_INT )
            // InternalRoQMEMapping.g:532:5: lv_value_2_0= RULE_INT
            {
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_15); 

            					newLeafNode(lv_value_2_0, grammarAccess.getMinTimeBtwUpdatesAccess().getValueINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMinTimeBtwUpdatesRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalRoQMEMapping.g:548:3: ( ( (lv_unit_3_1= 'ms' | lv_unit_3_2= 's' | lv_unit_3_3= 'min' | lv_unit_3_4= 'h' ) ) )
            // InternalRoQMEMapping.g:549:4: ( (lv_unit_3_1= 'ms' | lv_unit_3_2= 's' | lv_unit_3_3= 'min' | lv_unit_3_4= 'h' ) )
            {
            // InternalRoQMEMapping.g:549:4: ( (lv_unit_3_1= 'ms' | lv_unit_3_2= 's' | lv_unit_3_3= 'min' | lv_unit_3_4= 'h' ) )
            // InternalRoQMEMapping.g:550:5: (lv_unit_3_1= 'ms' | lv_unit_3_2= 's' | lv_unit_3_3= 'min' | lv_unit_3_4= 'h' )
            {
            // InternalRoQMEMapping.g:550:5: (lv_unit_3_1= 'ms' | lv_unit_3_2= 's' | lv_unit_3_3= 'min' | lv_unit_3_4= 'h' )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt5=1;
                }
                break;
            case 23:
                {
                alt5=2;
                }
                break;
            case 24:
                {
                alt5=3;
                }
                break;
            case 25:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalRoQMEMapping.g:551:6: lv_unit_3_1= 'ms'
                    {
                    lv_unit_3_1=(Token)match(input,22,FOLLOW_2); 

                    						newLeafNode(lv_unit_3_1, grammarAccess.getMinTimeBtwUpdatesAccess().getUnitMsKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMinTimeBtwUpdatesRule());
                    						}
                    						setWithLastConsumed(current, "unit", lv_unit_3_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalRoQMEMapping.g:562:6: lv_unit_3_2= 's'
                    {
                    lv_unit_3_2=(Token)match(input,23,FOLLOW_2); 

                    						newLeafNode(lv_unit_3_2, grammarAccess.getMinTimeBtwUpdatesAccess().getUnitSKeyword_3_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMinTimeBtwUpdatesRule());
                    						}
                    						setWithLastConsumed(current, "unit", lv_unit_3_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalRoQMEMapping.g:573:6: lv_unit_3_3= 'min'
                    {
                    lv_unit_3_3=(Token)match(input,24,FOLLOW_2); 

                    						newLeafNode(lv_unit_3_3, grammarAccess.getMinTimeBtwUpdatesAccess().getUnitMinKeyword_3_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMinTimeBtwUpdatesRule());
                    						}
                    						setWithLastConsumed(current, "unit", lv_unit_3_3, null);
                    					

                    }
                    break;
                case 4 :
                    // InternalRoQMEMapping.g:584:6: lv_unit_3_4= 'h'
                    {
                    lv_unit_3_4=(Token)match(input,25,FOLLOW_2); 

                    						newLeafNode(lv_unit_3_4, grammarAccess.getMinTimeBtwUpdatesAccess().getUnitHKeyword_3_0_3());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMinTimeBtwUpdatesRule());
                    						}
                    						setWithLastConsumed(current, "unit", lv_unit_3_4, null);
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMinTimeBtwUpdates"


    // $ANTLR start "entryRuleMinDiffBtwUpdates"
    // InternalRoQMEMapping.g:601:1: entryRuleMinDiffBtwUpdates returns [EObject current=null] : iv_ruleMinDiffBtwUpdates= ruleMinDiffBtwUpdates EOF ;
    public final EObject entryRuleMinDiffBtwUpdates() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinDiffBtwUpdates = null;


        try {
            // InternalRoQMEMapping.g:601:58: (iv_ruleMinDiffBtwUpdates= ruleMinDiffBtwUpdates EOF )
            // InternalRoQMEMapping.g:602:2: iv_ruleMinDiffBtwUpdates= ruleMinDiffBtwUpdates EOF
            {
             newCompositeNode(grammarAccess.getMinDiffBtwUpdatesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMinDiffBtwUpdates=ruleMinDiffBtwUpdates();

            state._fsp--;

             current =iv_ruleMinDiffBtwUpdates; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMinDiffBtwUpdates"


    // $ANTLR start "ruleMinDiffBtwUpdates"
    // InternalRoQMEMapping.g:608:1: ruleMinDiffBtwUpdates returns [EObject current=null] : (otherlv_0= 'minDiffBtwUpdates' otherlv_1= ':' ( (lv_value_2_0= ruleEDouble ) ) ) ;
    public final EObject ruleMinDiffBtwUpdates() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalRoQMEMapping.g:614:2: ( (otherlv_0= 'minDiffBtwUpdates' otherlv_1= ':' ( (lv_value_2_0= ruleEDouble ) ) ) )
            // InternalRoQMEMapping.g:615:2: (otherlv_0= 'minDiffBtwUpdates' otherlv_1= ':' ( (lv_value_2_0= ruleEDouble ) ) )
            {
            // InternalRoQMEMapping.g:615:2: (otherlv_0= 'minDiffBtwUpdates' otherlv_1= ':' ( (lv_value_2_0= ruleEDouble ) ) )
            // InternalRoQMEMapping.g:616:3: otherlv_0= 'minDiffBtwUpdates' otherlv_1= ':' ( (lv_value_2_0= ruleEDouble ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getMinDiffBtwUpdatesAccess().getMinDiffBtwUpdatesKeyword_0());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_16); 

            			newLeafNode(otherlv_1, grammarAccess.getMinDiffBtwUpdatesAccess().getColonKeyword_1());
            		
            // InternalRoQMEMapping.g:624:3: ( (lv_value_2_0= ruleEDouble ) )
            // InternalRoQMEMapping.g:625:4: (lv_value_2_0= ruleEDouble )
            {
            // InternalRoQMEMapping.g:625:4: (lv_value_2_0= ruleEDouble )
            // InternalRoQMEMapping.g:626:5: lv_value_2_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getMinDiffBtwUpdatesAccess().getValueEDoubleParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMinDiffBtwUpdatesRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.xtext.roqmemapping.RoQMEMapping.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMinDiffBtwUpdates"


    // $ANTLR start "entryRuleEString"
    // InternalRoQMEMapping.g:647:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalRoQMEMapping.g:647:47: (iv_ruleEString= ruleEString EOF )
            // InternalRoQMEMapping.g:648:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalRoQMEMapping.g:654:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalRoQMEMapping.g:660:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalRoQMEMapping.g:661:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalRoQMEMapping.g:661:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalRoQMEMapping.g:662:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRoQMEMapping.g:670:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleEDouble"
    // InternalRoQMEMapping.g:681:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalRoQMEMapping.g:681:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalRoQMEMapping.g:682:2: iv_ruleEDouble= ruleEDouble EOF
            {
             newCompositeNode(grammarAccess.getEDoubleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEDouble=ruleEDouble();

            state._fsp--;

             current =iv_ruleEDouble.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEDouble"


    // $ANTLR start "ruleEDouble"
    // InternalRoQMEMapping.g:688:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;


        	enterRule();

        try {
            // InternalRoQMEMapping.g:694:2: ( ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? ) )
            // InternalRoQMEMapping.g:695:2: ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? )
            {
            // InternalRoQMEMapping.g:695:2: ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? )
            // InternalRoQMEMapping.g:696:3: (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )?
            {
            // InternalRoQMEMapping.g:696:3: (kw= '-' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==28) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalRoQMEMapping.g:697:4: kw= '-'
                    {
                    kw=(Token)match(input,28,FOLLOW_14); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_17); 

            			current.merge(this_INT_1);
            		

            			newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1());
            		
            // InternalRoQMEMapping.g:710:3: (kw= '.' this_INT_3= RULE_INT )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==29) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalRoQMEMapping.g:711:4: kw= '.' this_INT_3= RULE_INT
                    {
                    kw=(Token)match(input,29,FOLLOW_14); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2_0());
                    			
                    this_INT_3=(Token)match(input,RULE_INT,FOLLOW_2); 

                    				current.merge(this_INT_3);
                    			

                    				newLeafNode(this_INT_3, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_2_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEDouble"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalRoQMEMapping.g:728:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalRoQMEMapping.g:728:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalRoQMEMapping.g:729:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalRoQMEMapping.g:735:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalRoQMEMapping.g:741:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalRoQMEMapping.g:742:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalRoQMEMapping.g:742:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalRoQMEMapping.g:743:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalRoQMEMapping.g:750:3: (kw= '.' this_ID_2= RULE_ID )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==29) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalRoQMEMapping.g:751:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,29,FOLLOW_6); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_17); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x000000000C288000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000000000C388000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000003C00000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000020000002L});

}
