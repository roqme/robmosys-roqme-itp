package org.xtext.roqme.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.roqme.services.RoQMEGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRoQMEParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ROQME_DESCRIPTION", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'roqme'", "'context'", "':'", "':='", "'var'", "'param'", "'default'", "'timer'", "'offset'", "'onetime'", "'paused'", "'beliefvar'", "'reference'", "'survival'", "'property'", "'import'", "'observation'", "'{'", "'}'", "'sets'", "'clears'", "'starts'", "'stops'", "'resumes'", "'type'", "'boolean'", "'['", "']'", "'enum'", "','", "'eventtype'", "'number'", "'lower'", "'upper'", "'unit'", "'time'", "'event'", "'milliseconds'", "'seconds'", "'minutes'", "'hours'", "'days'", "'millisecond'", "'second'", "'minute'", "'hour'", "'day'", "'once'", "'while'", "'('", "')'", "'repeat'", "'range'", "'->'", "'or'", "'and'", "'not'", "'?'", "'|'", "'&'", "'!'", "'='", "'<'", "'>'", "'<='", "'>='", "'!='", "'+'", "'-'", "'*'", "'/'", "'belief'", "'schedule'", "'\\''", "'.'", "'true'", "'false'", "'::'", "'reinforces'", "'undermines'", "'veryhigh'", "'high'", "'MEDIUM'", "'low'", "'verylow'", "'pow'", "'sqrt'", "'exp'", "'abs'", "'avg'", "'min'", "'max'", "'count'", "'sum'", "'decreasing'", "'increasing'", "'stable'", "'eventWhen'", "'update'", "'period'", "'first'", "'last'", "'at'", "'size'", "'isEmpty'", "'includes'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_INT=5;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=10;
    public static final int RULE_ROQME_DESCRIPTION=7;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalRoQMEParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRoQMEParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRoQMEParser.tokenNames; }
    public String getGrammarFileName() { return "InternalRoQME.g"; }



     	private RoQMEGrammarAccess grammarAccess;

        public InternalRoQMEParser(TokenStream input, RoQMEGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "RoqmeModel";
       	}

       	@Override
       	protected RoQMEGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleRoqmeModel"
    // InternalRoQME.g:65:1: entryRuleRoqmeModel returns [EObject current=null] : iv_ruleRoqmeModel= ruleRoqmeModel EOF ;
    public final EObject entryRuleRoqmeModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoqmeModel = null;


        try {
            // InternalRoQME.g:65:51: (iv_ruleRoqmeModel= ruleRoqmeModel EOF )
            // InternalRoQME.g:66:2: iv_ruleRoqmeModel= ruleRoqmeModel EOF
            {
             newCompositeNode(grammarAccess.getRoqmeModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRoqmeModel=ruleRoqmeModel();

            state._fsp--;

             current =iv_ruleRoqmeModel; 
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
    // $ANTLR end "entryRuleRoqmeModel"


    // $ANTLR start "ruleRoqmeModel"
    // InternalRoQME.g:72:1: ruleRoqmeModel returns [EObject current=null] : ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'roqme' ( (lv_namespace_2_0= ruleEString ) ) )? ( (lv_sentences_3_0= ruleImport ) )* ( ( (lv_dataTypes_4_0= ruleDataTypeDefinition ) ) | ( (lv_variables_5_0= ruleTypedVariable ) ) | ( (lv_sentences_6_0= ruleSentence ) ) )* ) ;
    public final EObject ruleRoqmeModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_description_0_0 = null;

        AntlrDatatypeRuleToken lv_namespace_2_0 = null;

        EObject lv_sentences_3_0 = null;

        EObject lv_dataTypes_4_0 = null;

        EObject lv_variables_5_0 = null;

        EObject lv_sentences_6_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:78:2: ( ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'roqme' ( (lv_namespace_2_0= ruleEString ) ) )? ( (lv_sentences_3_0= ruleImport ) )* ( ( (lv_dataTypes_4_0= ruleDataTypeDefinition ) ) | ( (lv_variables_5_0= ruleTypedVariable ) ) | ( (lv_sentences_6_0= ruleSentence ) ) )* ) )
            // InternalRoQME.g:79:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'roqme' ( (lv_namespace_2_0= ruleEString ) ) )? ( (lv_sentences_3_0= ruleImport ) )* ( ( (lv_dataTypes_4_0= ruleDataTypeDefinition ) ) | ( (lv_variables_5_0= ruleTypedVariable ) ) | ( (lv_sentences_6_0= ruleSentence ) ) )* )
            {
            // InternalRoQME.g:79:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'roqme' ( (lv_namespace_2_0= ruleEString ) ) )? ( (lv_sentences_3_0= ruleImport ) )* ( ( (lv_dataTypes_4_0= ruleDataTypeDefinition ) ) | ( (lv_variables_5_0= ruleTypedVariable ) ) | ( (lv_sentences_6_0= ruleSentence ) ) )* )
            // InternalRoQME.g:80:3: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'roqme' ( (lv_namespace_2_0= ruleEString ) ) )? ( (lv_sentences_3_0= ruleImport ) )* ( ( (lv_dataTypes_4_0= ruleDataTypeDefinition ) ) | ( (lv_variables_5_0= ruleTypedVariable ) ) | ( (lv_sentences_6_0= ruleSentence ) ) )*
            {
            // InternalRoQME.g:80:3: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'roqme' ( (lv_namespace_2_0= ruleEString ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ROQME_DESCRIPTION) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==12) ) {
                    alt2=1;
                }
            }
            else if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalRoQME.g:81:4: ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'roqme' ( (lv_namespace_2_0= ruleEString ) )
                    {
                    // InternalRoQME.g:81:4: ( (lv_description_0_0= ruleElementDescription ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_ROQME_DESCRIPTION) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // InternalRoQME.g:82:5: (lv_description_0_0= ruleElementDescription )
                            {
                            // InternalRoQME.g:82:5: (lv_description_0_0= ruleElementDescription )
                            // InternalRoQME.g:83:6: lv_description_0_0= ruleElementDescription
                            {

                            						newCompositeNode(grammarAccess.getRoqmeModelAccess().getDescriptionElementDescriptionParserRuleCall_0_0_0());
                            					
                            pushFollow(FOLLOW_3);
                            lv_description_0_0=ruleElementDescription();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getRoqmeModelRule());
                            						}
                            						set(
                            							current,
                            							"description",
                            							lv_description_0_0,
                            							"org.xtext.roqme.RoQME.ElementDescription");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    otherlv_1=(Token)match(input,12,FOLLOW_4); 

                    				newLeafNode(otherlv_1, grammarAccess.getRoqmeModelAccess().getRoqmeKeyword_0_1());
                    			
                    // InternalRoQME.g:104:4: ( (lv_namespace_2_0= ruleEString ) )
                    // InternalRoQME.g:105:5: (lv_namespace_2_0= ruleEString )
                    {
                    // InternalRoQME.g:105:5: (lv_namespace_2_0= ruleEString )
                    // InternalRoQME.g:106:6: lv_namespace_2_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getRoqmeModelAccess().getNamespaceEStringParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_5);
                    lv_namespace_2_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRoqmeModelRule());
                    						}
                    						set(
                    							current,
                    							"namespace",
                    							lv_namespace_2_0,
                    							"org.xtext.roqme.RoQME.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRoQME.g:124:3: ( (lv_sentences_3_0= ruleImport ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==27) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalRoQME.g:125:4: (lv_sentences_3_0= ruleImport )
            	    {
            	    // InternalRoQME.g:125:4: (lv_sentences_3_0= ruleImport )
            	    // InternalRoQME.g:126:5: lv_sentences_3_0= ruleImport
            	    {

            	    					newCompositeNode(grammarAccess.getRoqmeModelAccess().getSentencesImportParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_sentences_3_0=ruleImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRoqmeModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"sentences",
            	    						lv_sentences_3_0,
            	    						"org.xtext.roqme.RoQME.Import");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalRoQME.g:143:3: ( ( (lv_dataTypes_4_0= ruleDataTypeDefinition ) ) | ( (lv_variables_5_0= ruleTypedVariable ) ) | ( (lv_sentences_6_0= ruleSentence ) ) )*
            loop4:
            do {
                int alt4=4;
                switch ( input.LA(1) ) {
                case 36:
                    {
                    alt4=1;
                    }
                    break;
                case RULE_ROQME_DESCRIPTION:
                    {
                    int LA4_3 = input.LA(2);

                    if ( (LA4_3==13||LA4_3==17||LA4_3==23||LA4_3==26) ) {
                        alt4=2;
                    }
                    else if ( (LA4_3==28) ) {
                        alt4=3;
                    }


                    }
                    break;
                case 13:
                case 16:
                case 17:
                case 19:
                case 23:
                case 26:
                    {
                    alt4=2;
                    }
                    break;
                case 28:
                    {
                    alt4=3;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // InternalRoQME.g:144:4: ( (lv_dataTypes_4_0= ruleDataTypeDefinition ) )
            	    {
            	    // InternalRoQME.g:144:4: ( (lv_dataTypes_4_0= ruleDataTypeDefinition ) )
            	    // InternalRoQME.g:145:5: (lv_dataTypes_4_0= ruleDataTypeDefinition )
            	    {
            	    // InternalRoQME.g:145:5: (lv_dataTypes_4_0= ruleDataTypeDefinition )
            	    // InternalRoQME.g:146:6: lv_dataTypes_4_0= ruleDataTypeDefinition
            	    {

            	    						newCompositeNode(grammarAccess.getRoqmeModelAccess().getDataTypesDataTypeDefinitionParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_6);
            	    lv_dataTypes_4_0=ruleDataTypeDefinition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getRoqmeModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"dataTypes",
            	    							lv_dataTypes_4_0,
            	    							"org.xtext.roqme.RoQME.DataTypeDefinition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRoQME.g:164:4: ( (lv_variables_5_0= ruleTypedVariable ) )
            	    {
            	    // InternalRoQME.g:164:4: ( (lv_variables_5_0= ruleTypedVariable ) )
            	    // InternalRoQME.g:165:5: (lv_variables_5_0= ruleTypedVariable )
            	    {
            	    // InternalRoQME.g:165:5: (lv_variables_5_0= ruleTypedVariable )
            	    // InternalRoQME.g:166:6: lv_variables_5_0= ruleTypedVariable
            	    {

            	    						newCompositeNode(grammarAccess.getRoqmeModelAccess().getVariablesTypedVariableParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_6);
            	    lv_variables_5_0=ruleTypedVariable();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getRoqmeModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"variables",
            	    							lv_variables_5_0,
            	    							"org.xtext.roqme.RoQME.TypedVariable");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRoQME.g:184:4: ( (lv_sentences_6_0= ruleSentence ) )
            	    {
            	    // InternalRoQME.g:184:4: ( (lv_sentences_6_0= ruleSentence ) )
            	    // InternalRoQME.g:185:5: (lv_sentences_6_0= ruleSentence )
            	    {
            	    // InternalRoQME.g:185:5: (lv_sentences_6_0= ruleSentence )
            	    // InternalRoQME.g:186:6: lv_sentences_6_0= ruleSentence
            	    {

            	    						newCompositeNode(grammarAccess.getRoqmeModelAccess().getSentencesSentenceParserRuleCall_2_2_0());
            	    					
            	    pushFollow(FOLLOW_6);
            	    lv_sentences_6_0=ruleSentence();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getRoqmeModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"sentences",
            	    							lv_sentences_6_0,
            	    							"org.xtext.roqme.RoQME.Sentence");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // $ANTLR end "ruleRoqmeModel"


    // $ANTLR start "entryRuleTypedVariable"
    // InternalRoQME.g:208:1: entryRuleTypedVariable returns [EObject current=null] : iv_ruleTypedVariable= ruleTypedVariable EOF ;
    public final EObject entryRuleTypedVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedVariable = null;


        try {
            // InternalRoQME.g:208:54: (iv_ruleTypedVariable= ruleTypedVariable EOF )
            // InternalRoQME.g:209:2: iv_ruleTypedVariable= ruleTypedVariable EOF
            {
             newCompositeNode(grammarAccess.getTypedVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypedVariable=ruleTypedVariable();

            state._fsp--;

             current =iv_ruleTypedVariable; 
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
    // $ANTLR end "entryRuleTypedVariable"


    // $ANTLR start "ruleTypedVariable"
    // InternalRoQME.g:215:1: ruleTypedVariable returns [EObject current=null] : (this_Parameter_0= ruleParameter | this_Timer_1= ruleTimer | this_GeneralPurposeVariable_2= ruleGeneralPurposeVariable | this_Context_3= ruleContext | this_BeliefVariable_4= ruleBeliefVariable ) ;
    public final EObject ruleTypedVariable() throws RecognitionException {
        EObject current = null;

        EObject this_Parameter_0 = null;

        EObject this_Timer_1 = null;

        EObject this_GeneralPurposeVariable_2 = null;

        EObject this_Context_3 = null;

        EObject this_BeliefVariable_4 = null;



        	enterRule();

        try {
            // InternalRoQME.g:221:2: ( (this_Parameter_0= ruleParameter | this_Timer_1= ruleTimer | this_GeneralPurposeVariable_2= ruleGeneralPurposeVariable | this_Context_3= ruleContext | this_BeliefVariable_4= ruleBeliefVariable ) )
            // InternalRoQME.g:222:2: (this_Parameter_0= ruleParameter | this_Timer_1= ruleTimer | this_GeneralPurposeVariable_2= ruleGeneralPurposeVariable | this_Context_3= ruleContext | this_BeliefVariable_4= ruleBeliefVariable )
            {
            // InternalRoQME.g:222:2: (this_Parameter_0= ruleParameter | this_Timer_1= ruleTimer | this_GeneralPurposeVariable_2= ruleGeneralPurposeVariable | this_Context_3= ruleContext | this_BeliefVariable_4= ruleBeliefVariable )
            int alt5=5;
            switch ( input.LA(1) ) {
            case RULE_ROQME_DESCRIPTION:
                {
                switch ( input.LA(2) ) {
                case 13:
                    {
                    alt5=4;
                    }
                    break;
                case 23:
                case 26:
                    {
                    alt5=5;
                    }
                    break;
                case 17:
                    {
                    alt5=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }

                }
                break;
            case 17:
                {
                alt5=1;
                }
                break;
            case 19:
                {
                alt5=2;
                }
                break;
            case 16:
                {
                alt5=3;
                }
                break;
            case 13:
                {
                alt5=4;
                }
                break;
            case 23:
            case 26:
                {
                alt5=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalRoQME.g:223:3: this_Parameter_0= ruleParameter
                    {

                    			newCompositeNode(grammarAccess.getTypedVariableAccess().getParameterParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Parameter_0=ruleParameter();

                    state._fsp--;


                    			current = this_Parameter_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:232:3: this_Timer_1= ruleTimer
                    {

                    			newCompositeNode(grammarAccess.getTypedVariableAccess().getTimerParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Timer_1=ruleTimer();

                    state._fsp--;


                    			current = this_Timer_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRoQME.g:241:3: this_GeneralPurposeVariable_2= ruleGeneralPurposeVariable
                    {

                    			newCompositeNode(grammarAccess.getTypedVariableAccess().getGeneralPurposeVariableParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_GeneralPurposeVariable_2=ruleGeneralPurposeVariable();

                    state._fsp--;


                    			current = this_GeneralPurposeVariable_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalRoQME.g:250:3: this_Context_3= ruleContext
                    {

                    			newCompositeNode(grammarAccess.getTypedVariableAccess().getContextParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Context_3=ruleContext();

                    state._fsp--;


                    			current = this_Context_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalRoQME.g:259:3: this_BeliefVariable_4= ruleBeliefVariable
                    {

                    			newCompositeNode(grammarAccess.getTypedVariableAccess().getBeliefVariableParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_BeliefVariable_4=ruleBeliefVariable();

                    state._fsp--;


                    			current = this_BeliefVariable_4;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleTypedVariable"


    // $ANTLR start "entryRuleContext"
    // InternalRoQME.g:271:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // InternalRoQME.g:271:48: (iv_ruleContext= ruleContext EOF )
            // InternalRoQME.g:272:2: iv_ruleContext= ruleContext EOF
            {
             newCompositeNode(grammarAccess.getContextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContext=ruleContext();

            state._fsp--;

             current =iv_ruleContext; 
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
    // $ANTLR end "entryRuleContext"


    // $ANTLR start "ruleContext"
    // InternalRoQME.g:278:1: ruleContext returns [EObject current=null] : (this_DerivedContext_0= ruleDerivedContext | this_PrimitiveContext_1= rulePrimitiveContext ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

        EObject this_DerivedContext_0 = null;

        EObject this_PrimitiveContext_1 = null;



        	enterRule();

        try {
            // InternalRoQME.g:284:2: ( (this_DerivedContext_0= ruleDerivedContext | this_PrimitiveContext_1= rulePrimitiveContext ) )
            // InternalRoQME.g:285:2: (this_DerivedContext_0= ruleDerivedContext | this_PrimitiveContext_1= rulePrimitiveContext )
            {
            // InternalRoQME.g:285:2: (this_DerivedContext_0= ruleDerivedContext | this_PrimitiveContext_1= rulePrimitiveContext )
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalRoQME.g:286:3: this_DerivedContext_0= ruleDerivedContext
                    {

                    			newCompositeNode(grammarAccess.getContextAccess().getDerivedContextParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_DerivedContext_0=ruleDerivedContext();

                    state._fsp--;


                    			current = this_DerivedContext_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:295:3: this_PrimitiveContext_1= rulePrimitiveContext
                    {

                    			newCompositeNode(grammarAccess.getContextAccess().getPrimitiveContextParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_PrimitiveContext_1=rulePrimitiveContext();

                    state._fsp--;


                    			current = this_PrimitiveContext_1;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleContext"


    // $ANTLR start "entryRulePrimitiveContext"
    // InternalRoQME.g:307:1: entryRulePrimitiveContext returns [EObject current=null] : iv_rulePrimitiveContext= rulePrimitiveContext EOF ;
    public final EObject entryRulePrimitiveContext() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveContext = null;


        try {
            // InternalRoQME.g:307:57: (iv_rulePrimitiveContext= rulePrimitiveContext EOF )
            // InternalRoQME.g:308:2: iv_rulePrimitiveContext= rulePrimitiveContext EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveContextRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimitiveContext=rulePrimitiveContext();

            state._fsp--;

             current =iv_rulePrimitiveContext; 
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
    // $ANTLR end "entryRulePrimitiveContext"


    // $ANTLR start "rulePrimitiveContext"
    // InternalRoQME.g:314:1: rulePrimitiveContext returns [EObject current=null] : ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) ) ;
    public final EObject rulePrimitiveContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_description_0_0 = null;

        EObject lv_declaration_4_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:320:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) ) )
            // InternalRoQME.g:321:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) )
            {
            // InternalRoQME.g:321:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) )
            // InternalRoQME.g:322:3: ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) )
            {
            // InternalRoQME.g:322:3: ( (lv_description_0_0= ruleElementDescription ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ROQME_DESCRIPTION) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalRoQME.g:323:4: (lv_description_0_0= ruleElementDescription )
                    {
                    // InternalRoQME.g:323:4: (lv_description_0_0= ruleElementDescription )
                    // InternalRoQME.g:324:5: lv_description_0_0= ruleElementDescription
                    {

                    					newCompositeNode(grammarAccess.getPrimitiveContextAccess().getDescriptionElementDescriptionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_7);
                    lv_description_0_0=ruleElementDescription();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPrimitiveContextRule());
                    					}
                    					set(
                    						current,
                    						"description",
                    						lv_description_0_0,
                    						"org.xtext.roqme.RoQME.ElementDescription");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getPrimitiveContextAccess().getContextKeyword_1());
            		
            // InternalRoQME.g:345:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoQME.g:346:4: (lv_name_2_0= RULE_ID )
            {
            // InternalRoQME.g:346:4: (lv_name_2_0= RULE_ID )
            // InternalRoQME.g:347:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_2_0, grammarAccess.getPrimitiveContextAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPrimitiveContextRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getPrimitiveContextAccess().getColonKeyword_3());
            		
            // InternalRoQME.g:367:3: ( (lv_declaration_4_0= ruleDataTypeDeclaration ) )
            // InternalRoQME.g:368:4: (lv_declaration_4_0= ruleDataTypeDeclaration )
            {
            // InternalRoQME.g:368:4: (lv_declaration_4_0= ruleDataTypeDeclaration )
            // InternalRoQME.g:369:5: lv_declaration_4_0= ruleDataTypeDeclaration
            {

            					newCompositeNode(grammarAccess.getPrimitiveContextAccess().getDeclarationDataTypeDeclarationParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_declaration_4_0=ruleDataTypeDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPrimitiveContextRule());
            					}
            					set(
            						current,
            						"declaration",
            						lv_declaration_4_0,
            						"org.xtext.roqme.RoQME.DataTypeDeclaration");
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
    // $ANTLR end "rulePrimitiveContext"


    // $ANTLR start "entryRuleDerivedContext"
    // InternalRoQME.g:390:1: entryRuleDerivedContext returns [EObject current=null] : iv_ruleDerivedContext= ruleDerivedContext EOF ;
    public final EObject entryRuleDerivedContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDerivedContext = null;


        try {
            // InternalRoQME.g:390:55: (iv_ruleDerivedContext= ruleDerivedContext EOF )
            // InternalRoQME.g:391:2: iv_ruleDerivedContext= ruleDerivedContext EOF
            {
             newCompositeNode(grammarAccess.getDerivedContextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDerivedContext=ruleDerivedContext();

            state._fsp--;

             current =iv_ruleDerivedContext; 
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
    // $ANTLR end "entryRuleDerivedContext"


    // $ANTLR start "ruleDerivedContext"
    // InternalRoQME.g:397:1: ruleDerivedContext returns [EObject current=null] : ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_definition_6_0= ruleContextPattern ) ) ) ;
    public final EObject ruleDerivedContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_description_0_0 = null;

        EObject lv_declaration_4_0 = null;

        EObject lv_definition_6_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:403:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_definition_6_0= ruleContextPattern ) ) ) )
            // InternalRoQME.g:404:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_definition_6_0= ruleContextPattern ) ) )
            {
            // InternalRoQME.g:404:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_definition_6_0= ruleContextPattern ) ) )
            // InternalRoQME.g:405:3: ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'context' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_definition_6_0= ruleContextPattern ) )
            {
            // InternalRoQME.g:405:3: ( (lv_description_0_0= ruleElementDescription ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ROQME_DESCRIPTION) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalRoQME.g:406:4: (lv_description_0_0= ruleElementDescription )
                    {
                    // InternalRoQME.g:406:4: (lv_description_0_0= ruleElementDescription )
                    // InternalRoQME.g:407:5: lv_description_0_0= ruleElementDescription
                    {

                    					newCompositeNode(grammarAccess.getDerivedContextAccess().getDescriptionElementDescriptionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_7);
                    lv_description_0_0=ruleElementDescription();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getDerivedContextRule());
                    					}
                    					set(
                    						current,
                    						"description",
                    						lv_description_0_0,
                    						"org.xtext.roqme.RoQME.ElementDescription");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getDerivedContextAccess().getContextKeyword_1());
            		
            // InternalRoQME.g:428:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoQME.g:429:4: (lv_name_2_0= RULE_ID )
            {
            // InternalRoQME.g:429:4: (lv_name_2_0= RULE_ID )
            // InternalRoQME.g:430:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_2_0, grammarAccess.getDerivedContextAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDerivedContextRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getDerivedContextAccess().getColonKeyword_3());
            		
            // InternalRoQME.g:450:3: ( (lv_declaration_4_0= ruleDataTypeDeclaration ) )
            // InternalRoQME.g:451:4: (lv_declaration_4_0= ruleDataTypeDeclaration )
            {
            // InternalRoQME.g:451:4: (lv_declaration_4_0= ruleDataTypeDeclaration )
            // InternalRoQME.g:452:5: lv_declaration_4_0= ruleDataTypeDeclaration
            {

            					newCompositeNode(grammarAccess.getDerivedContextAccess().getDeclarationDataTypeDeclarationParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_11);
            lv_declaration_4_0=ruleDataTypeDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDerivedContextRule());
            					}
            					set(
            						current,
            						"declaration",
            						lv_declaration_4_0,
            						"org.xtext.roqme.RoQME.DataTypeDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,15,FOLLOW_12); 

            			newLeafNode(otherlv_5, grammarAccess.getDerivedContextAccess().getColonEqualsSignKeyword_5());
            		
            // InternalRoQME.g:473:3: ( (lv_definition_6_0= ruleContextPattern ) )
            // InternalRoQME.g:474:4: (lv_definition_6_0= ruleContextPattern )
            {
            // InternalRoQME.g:474:4: (lv_definition_6_0= ruleContextPattern )
            // InternalRoQME.g:475:5: lv_definition_6_0= ruleContextPattern
            {

            					newCompositeNode(grammarAccess.getDerivedContextAccess().getDefinitionContextPatternParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_2);
            lv_definition_6_0=ruleContextPattern();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDerivedContextRule());
            					}
            					set(
            						current,
            						"definition",
            						lv_definition_6_0,
            						"org.xtext.roqme.RoQME.ContextPattern");
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
    // $ANTLR end "ruleDerivedContext"


    // $ANTLR start "entryRuleGeneralPurposeVariable"
    // InternalRoQME.g:496:1: entryRuleGeneralPurposeVariable returns [EObject current=null] : iv_ruleGeneralPurposeVariable= ruleGeneralPurposeVariable EOF ;
    public final EObject entryRuleGeneralPurposeVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneralPurposeVariable = null;


        try {
            // InternalRoQME.g:496:63: (iv_ruleGeneralPurposeVariable= ruleGeneralPurposeVariable EOF )
            // InternalRoQME.g:497:2: iv_ruleGeneralPurposeVariable= ruleGeneralPurposeVariable EOF
            {
             newCompositeNode(grammarAccess.getGeneralPurposeVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGeneralPurposeVariable=ruleGeneralPurposeVariable();

            state._fsp--;

             current =iv_ruleGeneralPurposeVariable; 
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
    // $ANTLR end "entryRuleGeneralPurposeVariable"


    // $ANTLR start "ruleGeneralPurposeVariable"
    // InternalRoQME.g:503:1: ruleGeneralPurposeVariable returns [EObject current=null] : (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) (otherlv_4= ':=' ( (lv_definition_5_0= ruleGeneralExpression ) ) ) ) ;
    public final EObject ruleGeneralPurposeVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_declaration_3_0 = null;

        EObject lv_definition_5_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:509:2: ( (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) (otherlv_4= ':=' ( (lv_definition_5_0= ruleGeneralExpression ) ) ) ) )
            // InternalRoQME.g:510:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) (otherlv_4= ':=' ( (lv_definition_5_0= ruleGeneralExpression ) ) ) )
            {
            // InternalRoQME.g:510:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) (otherlv_4= ':=' ( (lv_definition_5_0= ruleGeneralExpression ) ) ) )
            // InternalRoQME.g:511:3: otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_declaration_3_0= ruleDataTypeDeclaration ) ) (otherlv_4= ':=' ( (lv_definition_5_0= ruleGeneralExpression ) ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getGeneralPurposeVariableAccess().getVarKeyword_0());
            		
            // InternalRoQME.g:515:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoQME.g:516:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRoQME.g:516:4: (lv_name_1_0= RULE_ID )
            // InternalRoQME.g:517:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_1_0, grammarAccess.getGeneralPurposeVariableAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGeneralPurposeVariableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getGeneralPurposeVariableAccess().getColonKeyword_2());
            		
            // InternalRoQME.g:537:3: ( (lv_declaration_3_0= ruleDataTypeDeclaration ) )
            // InternalRoQME.g:538:4: (lv_declaration_3_0= ruleDataTypeDeclaration )
            {
            // InternalRoQME.g:538:4: (lv_declaration_3_0= ruleDataTypeDeclaration )
            // InternalRoQME.g:539:5: lv_declaration_3_0= ruleDataTypeDeclaration
            {

            					newCompositeNode(grammarAccess.getGeneralPurposeVariableAccess().getDeclarationDataTypeDeclarationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_declaration_3_0=ruleDataTypeDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGeneralPurposeVariableRule());
            					}
            					set(
            						current,
            						"declaration",
            						lv_declaration_3_0,
            						"org.xtext.roqme.RoQME.DataTypeDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoQME.g:556:3: (otherlv_4= ':=' ( (lv_definition_5_0= ruleGeneralExpression ) ) )
            // InternalRoQME.g:557:4: otherlv_4= ':=' ( (lv_definition_5_0= ruleGeneralExpression ) )
            {
            otherlv_4=(Token)match(input,15,FOLLOW_12); 

            				newLeafNode(otherlv_4, grammarAccess.getGeneralPurposeVariableAccess().getColonEqualsSignKeyword_4_0());
            			
            // InternalRoQME.g:561:4: ( (lv_definition_5_0= ruleGeneralExpression ) )
            // InternalRoQME.g:562:5: (lv_definition_5_0= ruleGeneralExpression )
            {
            // InternalRoQME.g:562:5: (lv_definition_5_0= ruleGeneralExpression )
            // InternalRoQME.g:563:6: lv_definition_5_0= ruleGeneralExpression
            {

            						newCompositeNode(grammarAccess.getGeneralPurposeVariableAccess().getDefinitionGeneralExpressionParserRuleCall_4_1_0());
            					
            pushFollow(FOLLOW_2);
            lv_definition_5_0=ruleGeneralExpression();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getGeneralPurposeVariableRule());
            						}
            						set(
            							current,
            							"definition",
            							lv_definition_5_0,
            							"org.xtext.roqme.RoQME.GeneralExpression");
            						afterParserOrEnumRuleCall();
            					

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
    // $ANTLR end "ruleGeneralPurposeVariable"


    // $ANTLR start "entryRuleParameter"
    // InternalRoQME.g:585:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalRoQME.g:585:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalRoQME.g:586:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalRoQME.g:592:1: ruleParameter returns [EObject current=null] : ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'param' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) (otherlv_5= 'default' ( (lv_initializedTo_6_0= ruleTypedValue ) ) )? ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_description_0_0 = null;

        EObject lv_declaration_4_0 = null;

        EObject lv_initializedTo_6_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:598:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'param' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) (otherlv_5= 'default' ( (lv_initializedTo_6_0= ruleTypedValue ) ) )? ) )
            // InternalRoQME.g:599:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'param' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) (otherlv_5= 'default' ( (lv_initializedTo_6_0= ruleTypedValue ) ) )? )
            {
            // InternalRoQME.g:599:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'param' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) (otherlv_5= 'default' ( (lv_initializedTo_6_0= ruleTypedValue ) ) )? )
            // InternalRoQME.g:600:3: ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'param' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) (otherlv_5= 'default' ( (lv_initializedTo_6_0= ruleTypedValue ) ) )?
            {
            // InternalRoQME.g:600:3: ( (lv_description_0_0= ruleElementDescription ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ROQME_DESCRIPTION) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalRoQME.g:601:4: (lv_description_0_0= ruleElementDescription )
                    {
                    // InternalRoQME.g:601:4: (lv_description_0_0= ruleElementDescription )
                    // InternalRoQME.g:602:5: lv_description_0_0= ruleElementDescription
                    {

                    					newCompositeNode(grammarAccess.getParameterAccess().getDescriptionElementDescriptionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_13);
                    lv_description_0_0=ruleElementDescription();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getParameterRule());
                    					}
                    					set(
                    						current,
                    						"description",
                    						lv_description_0_0,
                    						"org.xtext.roqme.RoQME.ElementDescription");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,17,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getParamKeyword_1());
            		
            // InternalRoQME.g:623:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoQME.g:624:4: (lv_name_2_0= RULE_ID )
            {
            // InternalRoQME.g:624:4: (lv_name_2_0= RULE_ID )
            // InternalRoQME.g:625:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_2_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getParameterAccess().getColonKeyword_3());
            		
            // InternalRoQME.g:645:3: ( (lv_declaration_4_0= ruleDataTypeDeclaration ) )
            // InternalRoQME.g:646:4: (lv_declaration_4_0= ruleDataTypeDeclaration )
            {
            // InternalRoQME.g:646:4: (lv_declaration_4_0= ruleDataTypeDeclaration )
            // InternalRoQME.g:647:5: lv_declaration_4_0= ruleDataTypeDeclaration
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getDeclarationDataTypeDeclarationParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_14);
            lv_declaration_4_0=ruleDataTypeDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRule());
            					}
            					set(
            						current,
            						"declaration",
            						lv_declaration_4_0,
            						"org.xtext.roqme.RoQME.DataTypeDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoQME.g:664:3: (otherlv_5= 'default' ( (lv_initializedTo_6_0= ruleTypedValue ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalRoQME.g:665:4: otherlv_5= 'default' ( (lv_initializedTo_6_0= ruleTypedValue ) )
                    {
                    otherlv_5=(Token)match(input,18,FOLLOW_15); 

                    				newLeafNode(otherlv_5, grammarAccess.getParameterAccess().getDefaultKeyword_5_0());
                    			
                    // InternalRoQME.g:669:4: ( (lv_initializedTo_6_0= ruleTypedValue ) )
                    // InternalRoQME.g:670:5: (lv_initializedTo_6_0= ruleTypedValue )
                    {
                    // InternalRoQME.g:670:5: (lv_initializedTo_6_0= ruleTypedValue )
                    // InternalRoQME.g:671:6: lv_initializedTo_6_0= ruleTypedValue
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getInitializedToTypedValueParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_initializedTo_6_0=ruleTypedValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterRule());
                    						}
                    						set(
                    							current,
                    							"initializedTo",
                    							lv_initializedTo_6_0,
                    							"org.xtext.roqme.RoQME.TypedValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleTimer"
    // InternalRoQME.g:693:1: entryRuleTimer returns [EObject current=null] : iv_ruleTimer= ruleTimer EOF ;
    public final EObject entryRuleTimer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimer = null;


        try {
            // InternalRoQME.g:693:46: (iv_ruleTimer= ruleTimer EOF )
            // InternalRoQME.g:694:2: iv_ruleTimer= ruleTimer EOF
            {
             newCompositeNode(grammarAccess.getTimerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimer=ruleTimer();

            state._fsp--;

             current =iv_ruleTimer; 
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
    // $ANTLR end "entryRuleTimer"


    // $ANTLR start "ruleTimer"
    // InternalRoQME.g:700:1: ruleTimer returns [EObject current=null] : (otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( (lv_declaration_2_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) ) ) ) ;
    public final EObject ruleTimer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_4=null;
        Token lv_once_6_0=null;
        Token lv_paused_7_0=null;
        Token otherlv_8=null;
        EObject lv_declaration_2_0 = null;

        EObject lv_offset_5_0 = null;

        EObject lv_definition_9_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:706:2: ( (otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( (lv_declaration_2_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) ) ) ) )
            // InternalRoQME.g:707:2: (otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( (lv_declaration_2_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) ) ) )
            {
            // InternalRoQME.g:707:2: (otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( (lv_declaration_2_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) ) ) )
            // InternalRoQME.g:708:3: otherlv_0= 'timer' ( (lv_name_1_0= RULE_ID ) ) ( (lv_declaration_2_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) ) )
            {
            otherlv_0=(Token)match(input,19,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getTimerAccess().getTimerKeyword_0());
            		
            // InternalRoQME.g:712:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoQME.g:713:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRoQME.g:713:4: (lv_name_1_0= RULE_ID )
            // InternalRoQME.g:714:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTimerAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalRoQME.g:730:3: ( (lv_declaration_2_0= ruleInbuiltDeclaration ) )
            // InternalRoQME.g:731:4: (lv_declaration_2_0= ruleInbuiltDeclaration )
            {
            // InternalRoQME.g:731:4: (lv_declaration_2_0= ruleInbuiltDeclaration )
            // InternalRoQME.g:732:5: lv_declaration_2_0= ruleInbuiltDeclaration
            {

            					newCompositeNode(grammarAccess.getTimerAccess().getDeclarationInbuiltDeclarationParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_16);
            lv_declaration_2_0=ruleInbuiltDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTimerRule());
            					}
            					set(
            						current,
            						"declaration",
            						lv_declaration_2_0,
            						"org.xtext.roqme.RoQME.InbuiltDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoQME.g:749:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) ) )
            // InternalRoQME.g:750:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) )
            {
            // InternalRoQME.g:750:4: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?) )
            // InternalRoQME.g:751:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getTimerAccess().getUnorderedGroup_3());
            				
            // InternalRoQME.g:754:5: ( ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?)
            // InternalRoQME.g:755:6: ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+ {...}?
            {
            // InternalRoQME.g:755:6: ( ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) ) )+
            int cnt11=0;
            loop11:
            do {
                int alt11=5;
                int LA11_0 = input.LA(1);

                if ( LA11_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 0) ) {
                    alt11=1;
                }
                else if ( LA11_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 1) ) {
                    alt11=2;
                }
                else if ( LA11_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 2) ) {
                    alt11=3;
                }
                else if ( LA11_0 == 15 && getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 3) ) {
                    alt11=4;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalRoQME.g:756:4: ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) )
            	    {
            	    // InternalRoQME.g:756:4: ({...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) ) )
            	    // InternalRoQME.g:757:5: {...}? => ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // InternalRoQME.g:757:102: ( ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) ) )
            	    // InternalRoQME.g:758:6: ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 0);
            	    					
            	    // InternalRoQME.g:761:9: ({...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) ) )
            	    // InternalRoQME.g:761:10: {...}? => (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "true");
            	    }
            	    // InternalRoQME.g:761:19: (otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) ) )
            	    // InternalRoQME.g:761:20: otherlv_4= 'offset' ( (lv_offset_5_0= ruleTimeValue ) )
            	    {
            	    otherlv_4=(Token)match(input,20,FOLLOW_17); 

            	    									newLeafNode(otherlv_4, grammarAccess.getTimerAccess().getOffsetKeyword_3_0_0());
            	    								
            	    // InternalRoQME.g:765:9: ( (lv_offset_5_0= ruleTimeValue ) )
            	    // InternalRoQME.g:766:10: (lv_offset_5_0= ruleTimeValue )
            	    {
            	    // InternalRoQME.g:766:10: (lv_offset_5_0= ruleTimeValue )
            	    // InternalRoQME.g:767:11: lv_offset_5_0= ruleTimeValue
            	    {

            	    											newCompositeNode(grammarAccess.getTimerAccess().getOffsetTimeValueParserRuleCall_3_0_1_0());
            	    										
            	    pushFollow(FOLLOW_18);
            	    lv_offset_5_0=ruleTimeValue();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getTimerRule());
            	    											}
            	    											set(
            	    												current,
            	    												"offset",
            	    												lv_offset_5_0,
            	    												"org.xtext.roqme.RoQME.TimeValue");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimerAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRoQME.g:790:4: ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) )
            	    {
            	    // InternalRoQME.g:790:4: ({...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) ) )
            	    // InternalRoQME.g:791:5: {...}? => ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // InternalRoQME.g:791:102: ( ({...}? => ( (lv_once_6_0= 'onetime' ) ) ) )
            	    // InternalRoQME.g:792:6: ({...}? => ( (lv_once_6_0= 'onetime' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 1);
            	    					
            	    // InternalRoQME.g:795:9: ({...}? => ( (lv_once_6_0= 'onetime' ) ) )
            	    // InternalRoQME.g:795:10: {...}? => ( (lv_once_6_0= 'onetime' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "true");
            	    }
            	    // InternalRoQME.g:795:19: ( (lv_once_6_0= 'onetime' ) )
            	    // InternalRoQME.g:795:20: (lv_once_6_0= 'onetime' )
            	    {
            	    // InternalRoQME.g:795:20: (lv_once_6_0= 'onetime' )
            	    // InternalRoQME.g:796:10: lv_once_6_0= 'onetime'
            	    {
            	    lv_once_6_0=(Token)match(input,21,FOLLOW_18); 

            	    										newLeafNode(lv_once_6_0, grammarAccess.getTimerAccess().getOnceOnetimeKeyword_3_1_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getTimerRule());
            	    										}
            	    										setWithLastConsumed(current, "once", true, "onetime");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimerAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRoQME.g:813:4: ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) )
            	    {
            	    // InternalRoQME.g:813:4: ({...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) ) )
            	    // InternalRoQME.g:814:5: {...}? => ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // InternalRoQME.g:814:102: ( ({...}? => ( (lv_paused_7_0= 'paused' ) ) ) )
            	    // InternalRoQME.g:815:6: ({...}? => ( (lv_paused_7_0= 'paused' ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 2);
            	    					
            	    // InternalRoQME.g:818:9: ({...}? => ( (lv_paused_7_0= 'paused' ) ) )
            	    // InternalRoQME.g:818:10: {...}? => ( (lv_paused_7_0= 'paused' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "true");
            	    }
            	    // InternalRoQME.g:818:19: ( (lv_paused_7_0= 'paused' ) )
            	    // InternalRoQME.g:818:20: (lv_paused_7_0= 'paused' )
            	    {
            	    // InternalRoQME.g:818:20: (lv_paused_7_0= 'paused' )
            	    // InternalRoQME.g:819:10: lv_paused_7_0= 'paused'
            	    {
            	    lv_paused_7_0=(Token)match(input,22,FOLLOW_18); 

            	    										newLeafNode(lv_paused_7_0, grammarAccess.getTimerAccess().getPausedPausedKeyword_3_2_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getTimerRule());
            	    										}
            	    										setWithLastConsumed(current, "paused", true, "paused");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimerAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalRoQME.g:836:4: ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) )
            	    {
            	    // InternalRoQME.g:836:4: ({...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) ) )
            	    // InternalRoQME.g:837:5: {...}? => ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "getUnorderedGroupHelper().canSelect(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // InternalRoQME.g:837:102: ( ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) ) )
            	    // InternalRoQME.g:838:6: ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getTimerAccess().getUnorderedGroup_3(), 3);
            	    					
            	    // InternalRoQME.g:841:9: ({...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) ) )
            	    // InternalRoQME.g:841:10: {...}? => (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTimer", "true");
            	    }
            	    // InternalRoQME.g:841:19: (otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) ) )
            	    // InternalRoQME.g:841:20: otherlv_8= ':=' ( (lv_definition_9_0= ruleGeneralExpression ) )
            	    {
            	    otherlv_8=(Token)match(input,15,FOLLOW_12); 

            	    									newLeafNode(otherlv_8, grammarAccess.getTimerAccess().getColonEqualsSignKeyword_3_3_0());
            	    								
            	    // InternalRoQME.g:845:9: ( (lv_definition_9_0= ruleGeneralExpression ) )
            	    // InternalRoQME.g:846:10: (lv_definition_9_0= ruleGeneralExpression )
            	    {
            	    // InternalRoQME.g:846:10: (lv_definition_9_0= ruleGeneralExpression )
            	    // InternalRoQME.g:847:11: lv_definition_9_0= ruleGeneralExpression
            	    {

            	    											newCompositeNode(grammarAccess.getTimerAccess().getDefinitionGeneralExpressionParserRuleCall_3_3_1_0());
            	    										
            	    pushFollow(FOLLOW_18);
            	    lv_definition_9_0=ruleGeneralExpression();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getTimerRule());
            	    											}
            	    											set(
            	    												current,
            	    												"definition",
            	    												lv_definition_9_0,
            	    												"org.xtext.roqme.RoQME.GeneralExpression");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTimerAccess().getUnorderedGroup_3());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getTimerAccess().getUnorderedGroup_3()) ) {
                throw new FailedPredicateException(input, "ruleTimer", "getUnorderedGroupHelper().canLeave(grammarAccess.getTimerAccess().getUnorderedGroup_3())");
            }

            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getTimerAccess().getUnorderedGroup_3());
            				

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
    // $ANTLR end "ruleTimer"


    // $ANTLR start "entryRuleBeliefVariable"
    // InternalRoQME.g:882:1: entryRuleBeliefVariable returns [EObject current=null] : iv_ruleBeliefVariable= ruleBeliefVariable EOF ;
    public final EObject entryRuleBeliefVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeliefVariable = null;


        try {
            // InternalRoQME.g:882:55: (iv_ruleBeliefVariable= ruleBeliefVariable EOF )
            // InternalRoQME.g:883:2: iv_ruleBeliefVariable= ruleBeliefVariable EOF
            {
             newCompositeNode(grammarAccess.getBeliefVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBeliefVariable=ruleBeliefVariable();

            state._fsp--;

             current =iv_ruleBeliefVariable; 
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
    // $ANTLR end "entryRuleBeliefVariable"


    // $ANTLR start "ruleBeliefVariable"
    // InternalRoQME.g:889:1: ruleBeliefVariable returns [EObject current=null] : (this_BeliefVariableImpl_0= ruleBeliefVariableImpl | this_Property_1= ruleProperty ) ;
    public final EObject ruleBeliefVariable() throws RecognitionException {
        EObject current = null;

        EObject this_BeliefVariableImpl_0 = null;

        EObject this_Property_1 = null;



        	enterRule();

        try {
            // InternalRoQME.g:895:2: ( (this_BeliefVariableImpl_0= ruleBeliefVariableImpl | this_Property_1= ruleProperty ) )
            // InternalRoQME.g:896:2: (this_BeliefVariableImpl_0= ruleBeliefVariableImpl | this_Property_1= ruleProperty )
            {
            // InternalRoQME.g:896:2: (this_BeliefVariableImpl_0= ruleBeliefVariableImpl | this_Property_1= ruleProperty )
            int alt12=2;
            switch ( input.LA(1) ) {
            case RULE_ROQME_DESCRIPTION:
                {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==23) ) {
                    alt12=1;
                }
                else if ( (LA12_1==26) ) {
                    alt12=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
                }
                break;
            case 23:
                {
                alt12=1;
                }
                break;
            case 26:
                {
                alt12=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalRoQME.g:897:3: this_BeliefVariableImpl_0= ruleBeliefVariableImpl
                    {

                    			newCompositeNode(grammarAccess.getBeliefVariableAccess().getBeliefVariableImplParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_BeliefVariableImpl_0=ruleBeliefVariableImpl();

                    state._fsp--;


                    			current = this_BeliefVariableImpl_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:906:3: this_Property_1= ruleProperty
                    {

                    			newCompositeNode(grammarAccess.getBeliefVariableAccess().getPropertyParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Property_1=ruleProperty();

                    state._fsp--;


                    			current = this_Property_1;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleBeliefVariable"


    // $ANTLR start "entryRuleBeliefVariableImpl"
    // InternalRoQME.g:918:1: entryRuleBeliefVariableImpl returns [EObject current=null] : iv_ruleBeliefVariableImpl= ruleBeliefVariableImpl EOF ;
    public final EObject entryRuleBeliefVariableImpl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeliefVariableImpl = null;


        try {
            // InternalRoQME.g:918:59: (iv_ruleBeliefVariableImpl= ruleBeliefVariableImpl EOF )
            // InternalRoQME.g:919:2: iv_ruleBeliefVariableImpl= ruleBeliefVariableImpl EOF
            {
             newCompositeNode(grammarAccess.getBeliefVariableImplRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBeliefVariableImpl=ruleBeliefVariableImpl();

            state._fsp--;

             current =iv_ruleBeliefVariableImpl; 
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
    // $ANTLR end "entryRuleBeliefVariableImpl"


    // $ANTLR start "ruleBeliefVariableImpl"
    // InternalRoQME.g:925:1: ruleBeliefVariableImpl returns [EObject current=null] : ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'beliefvar' ( (lv_name_2_0= RULE_ID ) ) ( (lv_declaration_3_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) ) ;
    public final EObject ruleBeliefVariableImpl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_description_0_0 = null;

        EObject lv_declaration_3_0 = null;

        AntlrDatatypeRuleToken lv_reference_6_0 = null;

        EObject lv_survival_8_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:931:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'beliefvar' ( (lv_name_2_0= RULE_ID ) ) ( (lv_declaration_3_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) ) )
            // InternalRoQME.g:932:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'beliefvar' ( (lv_name_2_0= RULE_ID ) ) ( (lv_declaration_3_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) )
            {
            // InternalRoQME.g:932:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'beliefvar' ( (lv_name_2_0= RULE_ID ) ) ( (lv_declaration_3_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) )
            // InternalRoQME.g:933:3: ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'beliefvar' ( (lv_name_2_0= RULE_ID ) ) ( (lv_declaration_3_0= ruleInbuiltDeclaration ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) ) )
            {
            // InternalRoQME.g:933:3: ( (lv_description_0_0= ruleElementDescription ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ROQME_DESCRIPTION) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalRoQME.g:934:4: (lv_description_0_0= ruleElementDescription )
                    {
                    // InternalRoQME.g:934:4: (lv_description_0_0= ruleElementDescription )
                    // InternalRoQME.g:935:5: lv_description_0_0= ruleElementDescription
                    {

                    					newCompositeNode(grammarAccess.getBeliefVariableImplAccess().getDescriptionElementDescriptionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_19);
                    lv_description_0_0=ruleElementDescription();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getBeliefVariableImplRule());
                    					}
                    					set(
                    						current,
                    						"description",
                    						lv_description_0_0,
                    						"org.xtext.roqme.RoQME.ElementDescription");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,23,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getBeliefVariableImplAccess().getBeliefvarKeyword_1());
            		
            // InternalRoQME.g:956:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoQME.g:957:4: (lv_name_2_0= RULE_ID )
            {
            // InternalRoQME.g:957:4: (lv_name_2_0= RULE_ID )
            // InternalRoQME.g:958:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_20); 

            					newLeafNode(lv_name_2_0, grammarAccess.getBeliefVariableImplAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBeliefVariableImplRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalRoQME.g:974:3: ( (lv_declaration_3_0= ruleInbuiltDeclaration ) )
            // InternalRoQME.g:975:4: (lv_declaration_3_0= ruleInbuiltDeclaration )
            {
            // InternalRoQME.g:975:4: (lv_declaration_3_0= ruleInbuiltDeclaration )
            // InternalRoQME.g:976:5: lv_declaration_3_0= ruleInbuiltDeclaration
            {

            					newCompositeNode(grammarAccess.getBeliefVariableImplAccess().getDeclarationInbuiltDeclarationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_21);
            lv_declaration_3_0=ruleInbuiltDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBeliefVariableImplRule());
            					}
            					set(
            						current,
            						"declaration",
            						lv_declaration_3_0,
            						"org.xtext.roqme.RoQME.InbuiltDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoQME.g:993:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) ) )
            // InternalRoQME.g:994:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) )
            {
            // InternalRoQME.g:994:4: ( ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* ) )
            // InternalRoQME.g:995:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4());
            				
            // InternalRoQME.g:998:5: ( ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )* )
            // InternalRoQME.g:999:6: ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )*
            {
            // InternalRoQME.g:999:6: ( ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) ) )*
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( LA14_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 0) ) {
                    alt14=1;
                }
                else if ( LA14_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 1) ) {
                    alt14=2;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalRoQME.g:1000:4: ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) )
            	    {
            	    // InternalRoQME.g:1000:4: ({...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) ) )
            	    // InternalRoQME.g:1001:5: {...}? => ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleBeliefVariableImpl", "getUnorderedGroupHelper().canSelect(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalRoQME.g:1001:115: ( ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) ) )
            	    // InternalRoQME.g:1002:6: ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalRoQME.g:1005:9: ({...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) ) )
            	    // InternalRoQME.g:1005:10: {...}? => (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBeliefVariableImpl", "true");
            	    }
            	    // InternalRoQME.g:1005:19: (otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) ) )
            	    // InternalRoQME.g:1005:20: otherlv_5= 'reference' ( (lv_reference_6_0= ruleEDouble ) )
            	    {
            	    otherlv_5=(Token)match(input,24,FOLLOW_17); 

            	    									newLeafNode(otherlv_5, grammarAccess.getBeliefVariableImplAccess().getReferenceKeyword_4_0_0());
            	    								
            	    // InternalRoQME.g:1009:9: ( (lv_reference_6_0= ruleEDouble ) )
            	    // InternalRoQME.g:1010:10: (lv_reference_6_0= ruleEDouble )
            	    {
            	    // InternalRoQME.g:1010:10: (lv_reference_6_0= ruleEDouble )
            	    // InternalRoQME.g:1011:11: lv_reference_6_0= ruleEDouble
            	    {

            	    											newCompositeNode(grammarAccess.getBeliefVariableImplAccess().getReferenceEDoubleParserRuleCall_4_0_1_0());
            	    										
            	    pushFollow(FOLLOW_21);
            	    lv_reference_6_0=ruleEDouble();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getBeliefVariableImplRule());
            	    											}
            	    											set(
            	    												current,
            	    												"reference",
            	    												lv_reference_6_0,
            	    												"org.xtext.roqme.RoQME.EDouble");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRoQME.g:1034:4: ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) )
            	    {
            	    // InternalRoQME.g:1034:4: ({...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) ) )
            	    // InternalRoQME.g:1035:5: {...}? => ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleBeliefVariableImpl", "getUnorderedGroupHelper().canSelect(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalRoQME.g:1035:115: ( ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) ) )
            	    // InternalRoQME.g:1036:6: ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalRoQME.g:1039:9: ({...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) ) )
            	    // InternalRoQME.g:1039:10: {...}? => (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBeliefVariableImpl", "true");
            	    }
            	    // InternalRoQME.g:1039:19: (otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) ) )
            	    // InternalRoQME.g:1039:20: otherlv_7= 'survival' ( (lv_survival_8_0= ruleTimeValue ) )
            	    {
            	    otherlv_7=(Token)match(input,25,FOLLOW_17); 

            	    									newLeafNode(otherlv_7, grammarAccess.getBeliefVariableImplAccess().getSurvivalKeyword_4_1_0());
            	    								
            	    // InternalRoQME.g:1043:9: ( (lv_survival_8_0= ruleTimeValue ) )
            	    // InternalRoQME.g:1044:10: (lv_survival_8_0= ruleTimeValue )
            	    {
            	    // InternalRoQME.g:1044:10: (lv_survival_8_0= ruleTimeValue )
            	    // InternalRoQME.g:1045:11: lv_survival_8_0= ruleTimeValue
            	    {

            	    											newCompositeNode(grammarAccess.getBeliefVariableImplAccess().getSurvivalTimeValueParserRuleCall_4_1_1_0());
            	    										
            	    pushFollow(FOLLOW_21);
            	    lv_survival_8_0=ruleTimeValue();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getBeliefVariableImplRule());
            	    											}
            	    											set(
            	    												current,
            	    												"survival",
            	    												lv_survival_8_0,
            	    												"org.xtext.roqme.RoQME.TimeValue");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getBeliefVariableImplAccess().getUnorderedGroup_4());
            				

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
    // $ANTLR end "ruleBeliefVariableImpl"


    // $ANTLR start "entryRuleProperty"
    // InternalRoQME.g:1079:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // InternalRoQME.g:1079:49: (iv_ruleProperty= ruleProperty EOF )
            // InternalRoQME.g:1080:2: iv_ruleProperty= ruleProperty EOF
            {
             newCompositeNode(grammarAccess.getPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProperty=ruleProperty();

            state._fsp--;

             current =iv_ruleProperty; 
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
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // InternalRoQME.g:1086:1: ruleProperty returns [EObject current=null] : ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'property' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) ) | ( (lv_declaration_7_0= ruleInbuiltDeclaration ) ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_description_0_0 = null;

        EObject lv_declaration_4_0 = null;

        EObject lv_transformation_6_0 = null;

        EObject lv_declaration_7_0 = null;

        AntlrDatatypeRuleToken lv_reference_10_0 = null;

        EObject lv_survival_12_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:1092:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'property' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) ) | ( (lv_declaration_7_0= ruleInbuiltDeclaration ) ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) ) )
            // InternalRoQME.g:1093:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'property' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) ) | ( (lv_declaration_7_0= ruleInbuiltDeclaration ) ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) )
            {
            // InternalRoQME.g:1093:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'property' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) ) | ( (lv_declaration_7_0= ruleInbuiltDeclaration ) ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) )
            // InternalRoQME.g:1094:3: ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'property' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) ) | ( (lv_declaration_7_0= ruleInbuiltDeclaration ) ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) ) )
            {
            // InternalRoQME.g:1094:3: ( (lv_description_0_0= ruleElementDescription ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ROQME_DESCRIPTION) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalRoQME.g:1095:4: (lv_description_0_0= ruleElementDescription )
                    {
                    // InternalRoQME.g:1095:4: (lv_description_0_0= ruleElementDescription )
                    // InternalRoQME.g:1096:5: lv_description_0_0= ruleElementDescription
                    {

                    					newCompositeNode(grammarAccess.getPropertyAccess().getDescriptionElementDescriptionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_22);
                    lv_description_0_0=ruleElementDescription();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPropertyRule());
                    					}
                    					set(
                    						current,
                    						"description",
                    						lv_description_0_0,
                    						"org.xtext.roqme.RoQME.ElementDescription");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,26,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getPropertyAccess().getPropertyKeyword_1());
            		
            // InternalRoQME.g:1117:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoQME.g:1118:4: (lv_name_2_0= RULE_ID )
            {
            // InternalRoQME.g:1118:4: (lv_name_2_0= RULE_ID )
            // InternalRoQME.g:1119:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(lv_name_2_0, grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPropertyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalRoQME.g:1135:3: ( (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) ) | ( (lv_declaration_7_0= ruleInbuiltDeclaration ) ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14) ) {
                alt16=1;
            }
            else if ( (LA16_0==EOF||LA16_0==RULE_ROQME_DESCRIPTION||LA16_0==13||(LA16_0>=15 && LA16_0<=26)||LA16_0==28||LA16_0==36) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalRoQME.g:1136:4: (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) )
                    {
                    // InternalRoQME.g:1136:4: (otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) ) )
                    // InternalRoQME.g:1137:5: otherlv_3= ':' ( (lv_declaration_4_0= ruleDataTypeDeclaration ) ) otherlv_5= ':=' ( (lv_transformation_6_0= ruleOutputTransformation ) )
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_10); 

                    					newLeafNode(otherlv_3, grammarAccess.getPropertyAccess().getColonKeyword_3_0_0());
                    				
                    // InternalRoQME.g:1141:5: ( (lv_declaration_4_0= ruleDataTypeDeclaration ) )
                    // InternalRoQME.g:1142:6: (lv_declaration_4_0= ruleDataTypeDeclaration )
                    {
                    // InternalRoQME.g:1142:6: (lv_declaration_4_0= ruleDataTypeDeclaration )
                    // InternalRoQME.g:1143:7: lv_declaration_4_0= ruleDataTypeDeclaration
                    {

                    							newCompositeNode(grammarAccess.getPropertyAccess().getDeclarationDataTypeDeclarationParserRuleCall_3_0_1_0());
                    						
                    pushFollow(FOLLOW_11);
                    lv_declaration_4_0=ruleDataTypeDeclaration();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getPropertyRule());
                    							}
                    							set(
                    								current,
                    								"declaration",
                    								lv_declaration_4_0,
                    								"org.xtext.roqme.RoQME.DataTypeDeclaration");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_5=(Token)match(input,15,FOLLOW_12); 

                    					newLeafNode(otherlv_5, grammarAccess.getPropertyAccess().getColonEqualsSignKeyword_3_0_2());
                    				
                    // InternalRoQME.g:1164:5: ( (lv_transformation_6_0= ruleOutputTransformation ) )
                    // InternalRoQME.g:1165:6: (lv_transformation_6_0= ruleOutputTransformation )
                    {
                    // InternalRoQME.g:1165:6: (lv_transformation_6_0= ruleOutputTransformation )
                    // InternalRoQME.g:1166:7: lv_transformation_6_0= ruleOutputTransformation
                    {

                    							newCompositeNode(grammarAccess.getPropertyAccess().getTransformationOutputTransformationParserRuleCall_3_0_3_0());
                    						
                    pushFollow(FOLLOW_21);
                    lv_transformation_6_0=ruleOutputTransformation();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getPropertyRule());
                    							}
                    							set(
                    								current,
                    								"transformation",
                    								lv_transformation_6_0,
                    								"org.xtext.roqme.RoQME.OutputTransformation");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRoQME.g:1185:4: ( (lv_declaration_7_0= ruleInbuiltDeclaration ) )
                    {
                    // InternalRoQME.g:1185:4: ( (lv_declaration_7_0= ruleInbuiltDeclaration ) )
                    // InternalRoQME.g:1186:5: (lv_declaration_7_0= ruleInbuiltDeclaration )
                    {
                    // InternalRoQME.g:1186:5: (lv_declaration_7_0= ruleInbuiltDeclaration )
                    // InternalRoQME.g:1187:6: lv_declaration_7_0= ruleInbuiltDeclaration
                    {

                    						newCompositeNode(grammarAccess.getPropertyAccess().getDeclarationInbuiltDeclarationParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_declaration_7_0=ruleInbuiltDeclaration();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPropertyRule());
                    						}
                    						set(
                    							current,
                    							"declaration",
                    							lv_declaration_7_0,
                    							"org.xtext.roqme.RoQME.InbuiltDeclaration");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRoQME.g:1205:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) ) )
            // InternalRoQME.g:1206:4: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) )
            {
            // InternalRoQME.g:1206:4: ( ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* ) )
            // InternalRoQME.g:1207:5: ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getPropertyAccess().getUnorderedGroup_4());
            				
            // InternalRoQME.g:1210:5: ( ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )* )
            // InternalRoQME.g:1211:6: ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )*
            {
            // InternalRoQME.g:1211:6: ( ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) ) )*
            loop17:
            do {
                int alt17=3;
                int LA17_0 = input.LA(1);

                if ( LA17_0 == 24 && getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 0) ) {
                    alt17=1;
                }
                else if ( LA17_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 1) ) {
                    alt17=2;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalRoQME.g:1212:4: ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) )
            	    {
            	    // InternalRoQME.g:1212:4: ({...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) ) )
            	    // InternalRoQME.g:1213:5: {...}? => ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleProperty", "getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalRoQME.g:1213:105: ( ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) ) )
            	    // InternalRoQME.g:1214:6: ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalRoQME.g:1217:9: ({...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) ) )
            	    // InternalRoQME.g:1217:10: {...}? => (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProperty", "true");
            	    }
            	    // InternalRoQME.g:1217:19: (otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) ) )
            	    // InternalRoQME.g:1217:20: otherlv_9= 'reference' ( (lv_reference_10_0= ruleEDouble ) )
            	    {
            	    otherlv_9=(Token)match(input,24,FOLLOW_17); 

            	    									newLeafNode(otherlv_9, grammarAccess.getPropertyAccess().getReferenceKeyword_4_0_0());
            	    								
            	    // InternalRoQME.g:1221:9: ( (lv_reference_10_0= ruleEDouble ) )
            	    // InternalRoQME.g:1222:10: (lv_reference_10_0= ruleEDouble )
            	    {
            	    // InternalRoQME.g:1222:10: (lv_reference_10_0= ruleEDouble )
            	    // InternalRoQME.g:1223:11: lv_reference_10_0= ruleEDouble
            	    {

            	    											newCompositeNode(grammarAccess.getPropertyAccess().getReferenceEDoubleParserRuleCall_4_0_1_0());
            	    										
            	    pushFollow(FOLLOW_21);
            	    lv_reference_10_0=ruleEDouble();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getPropertyRule());
            	    											}
            	    											set(
            	    												current,
            	    												"reference",
            	    												lv_reference_10_0,
            	    												"org.xtext.roqme.RoQME.EDouble");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPropertyAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRoQME.g:1246:4: ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) )
            	    {
            	    // InternalRoQME.g:1246:4: ({...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) ) )
            	    // InternalRoQME.g:1247:5: {...}? => ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleProperty", "getUnorderedGroupHelper().canSelect(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalRoQME.g:1247:105: ( ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) ) )
            	    // InternalRoQME.g:1248:6: ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getPropertyAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalRoQME.g:1251:9: ({...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) ) )
            	    // InternalRoQME.g:1251:10: {...}? => (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProperty", "true");
            	    }
            	    // InternalRoQME.g:1251:19: (otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) ) )
            	    // InternalRoQME.g:1251:20: otherlv_11= 'survival' ( (lv_survival_12_0= ruleTimeValue ) )
            	    {
            	    otherlv_11=(Token)match(input,25,FOLLOW_17); 

            	    									newLeafNode(otherlv_11, grammarAccess.getPropertyAccess().getSurvivalKeyword_4_1_0());
            	    								
            	    // InternalRoQME.g:1255:9: ( (lv_survival_12_0= ruleTimeValue ) )
            	    // InternalRoQME.g:1256:10: (lv_survival_12_0= ruleTimeValue )
            	    {
            	    // InternalRoQME.g:1256:10: (lv_survival_12_0= ruleTimeValue )
            	    // InternalRoQME.g:1257:11: lv_survival_12_0= ruleTimeValue
            	    {

            	    											newCompositeNode(grammarAccess.getPropertyAccess().getSurvivalTimeValueParserRuleCall_4_1_1_0());
            	    										
            	    pushFollow(FOLLOW_21);
            	    lv_survival_12_0=ruleTimeValue();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getPropertyRule());
            	    											}
            	    											set(
            	    												current,
            	    												"survival",
            	    												lv_survival_12_0,
            	    												"org.xtext.roqme.RoQME.TimeValue");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPropertyAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getPropertyAccess().getUnorderedGroup_4());
            				

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
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRuleSentence"
    // InternalRoQME.g:1291:1: entryRuleSentence returns [EObject current=null] : iv_ruleSentence= ruleSentence EOF ;
    public final EObject entryRuleSentence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSentence = null;


        try {
            // InternalRoQME.g:1291:49: (iv_ruleSentence= ruleSentence EOF )
            // InternalRoQME.g:1292:2: iv_ruleSentence= ruleSentence EOF
            {
             newCompositeNode(grammarAccess.getSentenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSentence=ruleSentence();

            state._fsp--;

             current =iv_ruleSentence; 
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
    // $ANTLR end "entryRuleSentence"


    // $ANTLR start "ruleSentence"
    // InternalRoQME.g:1298:1: ruleSentence returns [EObject current=null] : this_Observation_0= ruleObservation ;
    public final EObject ruleSentence() throws RecognitionException {
        EObject current = null;

        EObject this_Observation_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:1304:2: (this_Observation_0= ruleObservation )
            // InternalRoQME.g:1305:2: this_Observation_0= ruleObservation
            {

            		newCompositeNode(grammarAccess.getSentenceAccess().getObservationParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_Observation_0=ruleObservation();

            state._fsp--;


            		current = this_Observation_0;
            		afterParserOrEnumRuleCall();
            	

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
    // $ANTLR end "ruleSentence"


    // $ANTLR start "entryRuleImport"
    // InternalRoQME.g:1316:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalRoQME.g:1316:47: (iv_ruleImport= ruleImport EOF )
            // InternalRoQME.g:1317:2: iv_ruleImport= ruleImport EOF
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
    // InternalRoQME.g:1323:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= ruleEString ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importURI_1_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:1329:2: ( (otherlv_0= 'import' ( (lv_importURI_1_0= ruleEString ) ) ) )
            // InternalRoQME.g:1330:2: (otherlv_0= 'import' ( (lv_importURI_1_0= ruleEString ) ) )
            {
            // InternalRoQME.g:1330:2: (otherlv_0= 'import' ( (lv_importURI_1_0= ruleEString ) ) )
            // InternalRoQME.g:1331:3: otherlv_0= 'import' ( (lv_importURI_1_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalRoQME.g:1335:3: ( (lv_importURI_1_0= ruleEString ) )
            // InternalRoQME.g:1336:4: (lv_importURI_1_0= ruleEString )
            {
            // InternalRoQME.g:1336:4: (lv_importURI_1_0= ruleEString )
            // InternalRoQME.g:1337:5: lv_importURI_1_0= ruleEString
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
            						"org.xtext.roqme.RoQME.EString");
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


    // $ANTLR start "entryRuleObservation"
    // InternalRoQME.g:1358:1: entryRuleObservation returns [EObject current=null] : iv_ruleObservation= ruleObservation EOF ;
    public final EObject entryRuleObservation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObservation = null;


        try {
            // InternalRoQME.g:1358:52: (iv_ruleObservation= ruleObservation EOF )
            // InternalRoQME.g:1359:2: iv_ruleObservation= ruleObservation EOF
            {
             newCompositeNode(grammarAccess.getObservationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObservation=ruleObservation();

            state._fsp--;

             current =iv_ruleObservation; 
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
    // $ANTLR end "entryRuleObservation"


    // $ANTLR start "ruleObservation"
    // InternalRoQME.g:1365:1: ruleObservation returns [EObject current=null] : ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'observation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_pattern_4_0= ruleContextPattern ) ) ( ( (lv_actions_5_0= ruleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' ) ) ) ;
    public final EObject ruleObservation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_description_0_0 = null;

        EObject lv_pattern_4_0 = null;

        EObject lv_actions_5_0 = null;

        EObject lv_actions_7_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:1371:2: ( ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'observation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_pattern_4_0= ruleContextPattern ) ) ( ( (lv_actions_5_0= ruleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' ) ) ) )
            // InternalRoQME.g:1372:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'observation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_pattern_4_0= ruleContextPattern ) ) ( ( (lv_actions_5_0= ruleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' ) ) )
            {
            // InternalRoQME.g:1372:2: ( ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'observation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_pattern_4_0= ruleContextPattern ) ) ( ( (lv_actions_5_0= ruleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' ) ) )
            // InternalRoQME.g:1373:3: ( (lv_description_0_0= ruleElementDescription ) )? otherlv_1= 'observation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_pattern_4_0= ruleContextPattern ) ) ( ( (lv_actions_5_0= ruleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' ) )
            {
            // InternalRoQME.g:1373:3: ( (lv_description_0_0= ruleElementDescription ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ROQME_DESCRIPTION) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalRoQME.g:1374:4: (lv_description_0_0= ruleElementDescription )
                    {
                    // InternalRoQME.g:1374:4: (lv_description_0_0= ruleElementDescription )
                    // InternalRoQME.g:1375:5: lv_description_0_0= ruleElementDescription
                    {

                    					newCompositeNode(grammarAccess.getObservationAccess().getDescriptionElementDescriptionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_24);
                    lv_description_0_0=ruleElementDescription();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getObservationRule());
                    					}
                    					set(
                    						current,
                    						"description",
                    						lv_description_0_0,
                    						"org.xtext.roqme.RoQME.ElementDescription");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,28,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getObservationAccess().getObservationKeyword_1());
            		
            // InternalRoQME.g:1396:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalRoQME.g:1397:4: (lv_name_2_0= RULE_ID )
            {
            // InternalRoQME.g:1397:4: (lv_name_2_0= RULE_ID )
            // InternalRoQME.g:1398:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(lv_name_2_0, grammarAccess.getObservationAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObservationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_12); 

            			newLeafNode(otherlv_3, grammarAccess.getObservationAccess().getColonKeyword_3());
            		
            // InternalRoQME.g:1418:3: ( (lv_pattern_4_0= ruleContextPattern ) )
            // InternalRoQME.g:1419:4: (lv_pattern_4_0= ruleContextPattern )
            {
            // InternalRoQME.g:1419:4: (lv_pattern_4_0= ruleContextPattern )
            // InternalRoQME.g:1420:5: lv_pattern_4_0= ruleContextPattern
            {

            					newCompositeNode(grammarAccess.getObservationAccess().getPatternContextPatternParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_25);
            lv_pattern_4_0=ruleContextPattern();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObservationRule());
            					}
            					set(
            						current,
            						"pattern",
            						lv_pattern_4_0,
            						"org.xtext.roqme.RoQME.ContextPattern");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoQME.g:1437:3: ( ( (lv_actions_5_0= ruleAction ) ) | (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=31 && LA20_0<=35)||(LA20_0>=90 && LA20_0<=91)) ) {
                alt20=1;
            }
            else if ( (LA20_0==29) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalRoQME.g:1438:4: ( (lv_actions_5_0= ruleAction ) )
                    {
                    // InternalRoQME.g:1438:4: ( (lv_actions_5_0= ruleAction ) )
                    // InternalRoQME.g:1439:5: (lv_actions_5_0= ruleAction )
                    {
                    // InternalRoQME.g:1439:5: (lv_actions_5_0= ruleAction )
                    // InternalRoQME.g:1440:6: lv_actions_5_0= ruleAction
                    {

                    						newCompositeNode(grammarAccess.getObservationAccess().getActionsActionParserRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_actions_5_0=ruleAction();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObservationRule());
                    						}
                    						add(
                    							current,
                    							"actions",
                    							lv_actions_5_0,
                    							"org.xtext.roqme.RoQME.Action");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRoQME.g:1458:4: (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' )
                    {
                    // InternalRoQME.g:1458:4: (otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}' )
                    // InternalRoQME.g:1459:5: otherlv_6= '{' ( (lv_actions_7_0= ruleAction ) )+ otherlv_8= '}'
                    {
                    otherlv_6=(Token)match(input,29,FOLLOW_26); 

                    					newLeafNode(otherlv_6, grammarAccess.getObservationAccess().getLeftCurlyBracketKeyword_5_1_0());
                    				
                    // InternalRoQME.g:1463:5: ( (lv_actions_7_0= ruleAction ) )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>=31 && LA19_0<=35)||(LA19_0>=90 && LA19_0<=91)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalRoQME.g:1464:6: (lv_actions_7_0= ruleAction )
                    	    {
                    	    // InternalRoQME.g:1464:6: (lv_actions_7_0= ruleAction )
                    	    // InternalRoQME.g:1465:7: lv_actions_7_0= ruleAction
                    	    {

                    	    							newCompositeNode(grammarAccess.getObservationAccess().getActionsActionParserRuleCall_5_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_27);
                    	    lv_actions_7_0=ruleAction();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getObservationRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"actions",
                    	    								lv_actions_7_0,
                    	    								"org.xtext.roqme.RoQME.Action");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);

                    otherlv_8=(Token)match(input,30,FOLLOW_2); 

                    					newLeafNode(otherlv_8, grammarAccess.getObservationAccess().getRightCurlyBracketKeyword_5_1_2());
                    				

                    }


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
    // $ANTLR end "ruleObservation"


    // $ANTLR start "entryRuleAction"
    // InternalRoQME.g:1492:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalRoQME.g:1492:47: (iv_ruleAction= ruleAction EOF )
            // InternalRoQME.g:1493:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
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
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalRoQME.g:1499:1: ruleAction returns [EObject current=null] : (this_SetVariable_0= ruleSetVariable | this_ClearEvidence_1= ruleClearEvidence | this_SetEvidence_2= ruleSetEvidence | this_TimerAction_3= ruleTimerAction ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        EObject this_SetVariable_0 = null;

        EObject this_ClearEvidence_1 = null;

        EObject this_SetEvidence_2 = null;

        EObject this_TimerAction_3 = null;



        	enterRule();

        try {
            // InternalRoQME.g:1505:2: ( (this_SetVariable_0= ruleSetVariable | this_ClearEvidence_1= ruleClearEvidence | this_SetEvidence_2= ruleSetEvidence | this_TimerAction_3= ruleTimerAction ) )
            // InternalRoQME.g:1506:2: (this_SetVariable_0= ruleSetVariable | this_ClearEvidence_1= ruleClearEvidence | this_SetEvidence_2= ruleSetEvidence | this_TimerAction_3= ruleTimerAction )
            {
            // InternalRoQME.g:1506:2: (this_SetVariable_0= ruleSetVariable | this_ClearEvidence_1= ruleClearEvidence | this_SetEvidence_2= ruleSetEvidence | this_TimerAction_3= ruleTimerAction )
            int alt21=4;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt21=1;
                }
                break;
            case 32:
                {
                alt21=2;
                }
                break;
            case 90:
            case 91:
                {
                alt21=3;
                }
                break;
            case 33:
            case 34:
            case 35:
                {
                alt21=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalRoQME.g:1507:3: this_SetVariable_0= ruleSetVariable
                    {

                    			newCompositeNode(grammarAccess.getActionAccess().getSetVariableParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SetVariable_0=ruleSetVariable();

                    state._fsp--;


                    			current = this_SetVariable_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:1516:3: this_ClearEvidence_1= ruleClearEvidence
                    {

                    			newCompositeNode(grammarAccess.getActionAccess().getClearEvidenceParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ClearEvidence_1=ruleClearEvidence();

                    state._fsp--;


                    			current = this_ClearEvidence_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRoQME.g:1525:3: this_SetEvidence_2= ruleSetEvidence
                    {

                    			newCompositeNode(grammarAccess.getActionAccess().getSetEvidenceParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_SetEvidence_2=ruleSetEvidence();

                    state._fsp--;


                    			current = this_SetEvidence_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalRoQME.g:1534:3: this_TimerAction_3= ruleTimerAction
                    {

                    			newCompositeNode(grammarAccess.getActionAccess().getTimerActionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_TimerAction_3=ruleTimerAction();

                    state._fsp--;


                    			current = this_TimerAction_3;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleTimerAction"
    // InternalRoQME.g:1546:1: entryRuleTimerAction returns [EObject current=null] : iv_ruleTimerAction= ruleTimerAction EOF ;
    public final EObject entryRuleTimerAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimerAction = null;


        try {
            // InternalRoQME.g:1546:52: (iv_ruleTimerAction= ruleTimerAction EOF )
            // InternalRoQME.g:1547:2: iv_ruleTimerAction= ruleTimerAction EOF
            {
             newCompositeNode(grammarAccess.getTimerActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimerAction=ruleTimerAction();

            state._fsp--;

             current =iv_ruleTimerAction; 
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
    // $ANTLR end "entryRuleTimerAction"


    // $ANTLR start "ruleTimerAction"
    // InternalRoQME.g:1553:1: ruleTimerAction returns [EObject current=null] : (this_StartTimer_0= ruleStartTimer | this_StopTimer_1= ruleStopTimer | this_ResumeTimer_2= ruleResumeTimer ) ;
    public final EObject ruleTimerAction() throws RecognitionException {
        EObject current = null;

        EObject this_StartTimer_0 = null;

        EObject this_StopTimer_1 = null;

        EObject this_ResumeTimer_2 = null;



        	enterRule();

        try {
            // InternalRoQME.g:1559:2: ( (this_StartTimer_0= ruleStartTimer | this_StopTimer_1= ruleStopTimer | this_ResumeTimer_2= ruleResumeTimer ) )
            // InternalRoQME.g:1560:2: (this_StartTimer_0= ruleStartTimer | this_StopTimer_1= ruleStopTimer | this_ResumeTimer_2= ruleResumeTimer )
            {
            // InternalRoQME.g:1560:2: (this_StartTimer_0= ruleStartTimer | this_StopTimer_1= ruleStopTimer | this_ResumeTimer_2= ruleResumeTimer )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt22=1;
                }
                break;
            case 34:
                {
                alt22=2;
                }
                break;
            case 35:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalRoQME.g:1561:3: this_StartTimer_0= ruleStartTimer
                    {

                    			newCompositeNode(grammarAccess.getTimerActionAccess().getStartTimerParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_StartTimer_0=ruleStartTimer();

                    state._fsp--;


                    			current = this_StartTimer_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:1570:3: this_StopTimer_1= ruleStopTimer
                    {

                    			newCompositeNode(grammarAccess.getTimerActionAccess().getStopTimerParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_StopTimer_1=ruleStopTimer();

                    state._fsp--;


                    			current = this_StopTimer_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRoQME.g:1579:3: this_ResumeTimer_2= ruleResumeTimer
                    {

                    			newCompositeNode(grammarAccess.getTimerActionAccess().getResumeTimerParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ResumeTimer_2=ruleResumeTimer();

                    state._fsp--;


                    			current = this_ResumeTimer_2;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleTimerAction"


    // $ANTLR start "entryRuleSetVariable"
    // InternalRoQME.g:1591:1: entryRuleSetVariable returns [EObject current=null] : iv_ruleSetVariable= ruleSetVariable EOF ;
    public final EObject entryRuleSetVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetVariable = null;


        try {
            // InternalRoQME.g:1591:52: (iv_ruleSetVariable= ruleSetVariable EOF )
            // InternalRoQME.g:1592:2: iv_ruleSetVariable= ruleSetVariable EOF
            {
             newCompositeNode(grammarAccess.getSetVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSetVariable=ruleSetVariable();

            state._fsp--;

             current =iv_ruleSetVariable; 
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
    // $ANTLR end "entryRuleSetVariable"


    // $ANTLR start "ruleSetVariable"
    // InternalRoQME.g:1598:1: ruleSetVariable returns [EObject current=null] : (otherlv_0= 'sets' ( ( ruleQualifiedName ) ) otherlv_2= ':=' ( (lv_expression_3_0= ruleGeneralExpression ) ) ) ;
    public final EObject ruleSetVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:1604:2: ( (otherlv_0= 'sets' ( ( ruleQualifiedName ) ) otherlv_2= ':=' ( (lv_expression_3_0= ruleGeneralExpression ) ) ) )
            // InternalRoQME.g:1605:2: (otherlv_0= 'sets' ( ( ruleQualifiedName ) ) otherlv_2= ':=' ( (lv_expression_3_0= ruleGeneralExpression ) ) )
            {
            // InternalRoQME.g:1605:2: (otherlv_0= 'sets' ( ( ruleQualifiedName ) ) otherlv_2= ':=' ( (lv_expression_3_0= ruleGeneralExpression ) ) )
            // InternalRoQME.g:1606:3: otherlv_0= 'sets' ( ( ruleQualifiedName ) ) otherlv_2= ':=' ( (lv_expression_3_0= ruleGeneralExpression ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getSetVariableAccess().getSetsKeyword_0());
            		
            // InternalRoQME.g:1610:3: ( ( ruleQualifiedName ) )
            // InternalRoQME.g:1611:4: ( ruleQualifiedName )
            {
            // InternalRoQME.g:1611:4: ( ruleQualifiedName )
            // InternalRoQME.g:1612:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSetVariableRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSetVariableAccess().getVariableTypedVariableCrossReference_1_0());
            				
            pushFollow(FOLLOW_11);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getSetVariableAccess().getColonEqualsSignKeyword_2());
            		
            // InternalRoQME.g:1630:3: ( (lv_expression_3_0= ruleGeneralExpression ) )
            // InternalRoQME.g:1631:4: (lv_expression_3_0= ruleGeneralExpression )
            {
            // InternalRoQME.g:1631:4: (lv_expression_3_0= ruleGeneralExpression )
            // InternalRoQME.g:1632:5: lv_expression_3_0= ruleGeneralExpression
            {

            					newCompositeNode(grammarAccess.getSetVariableAccess().getExpressionGeneralExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_expression_3_0=ruleGeneralExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSetVariableRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_3_0,
            						"org.xtext.roqme.RoQME.GeneralExpression");
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
    // $ANTLR end "ruleSetVariable"


    // $ANTLR start "entryRuleClearEvidence"
    // InternalRoQME.g:1653:1: entryRuleClearEvidence returns [EObject current=null] : iv_ruleClearEvidence= ruleClearEvidence EOF ;
    public final EObject entryRuleClearEvidence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClearEvidence = null;


        try {
            // InternalRoQME.g:1653:54: (iv_ruleClearEvidence= ruleClearEvidence EOF )
            // InternalRoQME.g:1654:2: iv_ruleClearEvidence= ruleClearEvidence EOF
            {
             newCompositeNode(grammarAccess.getClearEvidenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClearEvidence=ruleClearEvidence();

            state._fsp--;

             current =iv_ruleClearEvidence; 
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
    // $ANTLR end "entryRuleClearEvidence"


    // $ANTLR start "ruleClearEvidence"
    // InternalRoQME.g:1660:1: ruleClearEvidence returns [EObject current=null] : (otherlv_0= 'clears' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleClearEvidence() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRoQME.g:1666:2: ( (otherlv_0= 'clears' ( ( ruleQualifiedName ) ) ) )
            // InternalRoQME.g:1667:2: (otherlv_0= 'clears' ( ( ruleQualifiedName ) ) )
            {
            // InternalRoQME.g:1667:2: (otherlv_0= 'clears' ( ( ruleQualifiedName ) ) )
            // InternalRoQME.g:1668:3: otherlv_0= 'clears' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,32,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getClearEvidenceAccess().getClearsKeyword_0());
            		
            // InternalRoQME.g:1672:3: ( ( ruleQualifiedName ) )
            // InternalRoQME.g:1673:4: ( ruleQualifiedName )
            {
            // InternalRoQME.g:1673:4: ( ruleQualifiedName )
            // InternalRoQME.g:1674:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClearEvidenceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getClearEvidenceAccess().getTargetBeliefVariableCrossReference_1_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


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
    // $ANTLR end "ruleClearEvidence"


    // $ANTLR start "entryRuleSetEvidence"
    // InternalRoQME.g:1692:1: entryRuleSetEvidence returns [EObject current=null] : iv_ruleSetEvidence= ruleSetEvidence EOF ;
    public final EObject entryRuleSetEvidence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetEvidence = null;


        try {
            // InternalRoQME.g:1692:52: (iv_ruleSetEvidence= ruleSetEvidence EOF )
            // InternalRoQME.g:1693:2: iv_ruleSetEvidence= ruleSetEvidence EOF
            {
             newCompositeNode(grammarAccess.getSetEvidenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSetEvidence=ruleSetEvidence();

            state._fsp--;

             current =iv_ruleSetEvidence; 
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
    // $ANTLR end "entryRuleSetEvidence"


    // $ANTLR start "ruleSetEvidence"
    // InternalRoQME.g:1699:1: ruleSetEvidence returns [EObject current=null] : ( ( (lv_influence_0_0= ruleInfluenceEnum ) ) ( ( ruleQualifiedName ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) ) ;
    public final EObject ruleSetEvidence() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        Enumerator lv_influence_0_0 = null;

        Enumerator lv_strength_3_0 = null;

        EObject lv_survival_5_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:1705:2: ( ( ( (lv_influence_0_0= ruleInfluenceEnum ) ) ( ( ruleQualifiedName ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) ) )
            // InternalRoQME.g:1706:2: ( ( (lv_influence_0_0= ruleInfluenceEnum ) ) ( ( ruleQualifiedName ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) )
            {
            // InternalRoQME.g:1706:2: ( ( (lv_influence_0_0= ruleInfluenceEnum ) ) ( ( ruleQualifiedName ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) ) ) )
            // InternalRoQME.g:1707:3: ( (lv_influence_0_0= ruleInfluenceEnum ) ) ( ( ruleQualifiedName ) ) ( ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) ) )
            {
            // InternalRoQME.g:1707:3: ( (lv_influence_0_0= ruleInfluenceEnum ) )
            // InternalRoQME.g:1708:4: (lv_influence_0_0= ruleInfluenceEnum )
            {
            // InternalRoQME.g:1708:4: (lv_influence_0_0= ruleInfluenceEnum )
            // InternalRoQME.g:1709:5: lv_influence_0_0= ruleInfluenceEnum
            {

            					newCompositeNode(grammarAccess.getSetEvidenceAccess().getInfluenceInfluenceEnumEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_8);
            lv_influence_0_0=ruleInfluenceEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSetEvidenceRule());
            					}
            					set(
            						current,
            						"influence",
            						lv_influence_0_0,
            						"org.xtext.roqme.RoQME.InfluenceEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoQME.g:1726:3: ( ( ruleQualifiedName ) )
            // InternalRoQME.g:1727:4: ( ruleQualifiedName )
            {
            // InternalRoQME.g:1727:4: ( ruleQualifiedName )
            // InternalRoQME.g:1728:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSetEvidenceRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSetEvidenceAccess().getTargetBeliefVariableCrossReference_1_0());
            				
            pushFollow(FOLLOW_28);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoQME.g:1742:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) ) )
            // InternalRoQME.g:1743:4: ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) )
            {
            // InternalRoQME.g:1743:4: ( ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* ) )
            // InternalRoQME.g:1744:5: ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* )
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2());
            				
            // InternalRoQME.g:1747:5: ( ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )* )
            // InternalRoQME.g:1748:6: ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )*
            {
            // InternalRoQME.g:1748:6: ( ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) ) )*
            loop23:
            do {
                int alt23=3;
                int LA23_0 = input.LA(1);

                if ( LA23_0 >= 92 && LA23_0 <= 96 && getUnorderedGroupHelper().canSelect(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 0) ) {
                    alt23=1;
                }
                else if ( LA23_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 1) ) {
                    alt23=2;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalRoQME.g:1749:4: ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) )
            	    {
            	    // InternalRoQME.g:1749:4: ({...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) ) )
            	    // InternalRoQME.g:1750:5: {...}? => ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleSetEvidence", "getUnorderedGroupHelper().canSelect(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // InternalRoQME.g:1750:108: ( ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) ) )
            	    // InternalRoQME.g:1751:6: ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 0);
            	    					
            	    // InternalRoQME.g:1754:9: ({...}? => ( (lv_strength_3_0= ruleStrengthEnum ) ) )
            	    // InternalRoQME.g:1754:10: {...}? => ( (lv_strength_3_0= ruleStrengthEnum ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleSetEvidence", "true");
            	    }
            	    // InternalRoQME.g:1754:19: ( (lv_strength_3_0= ruleStrengthEnum ) )
            	    // InternalRoQME.g:1754:20: (lv_strength_3_0= ruleStrengthEnum )
            	    {
            	    // InternalRoQME.g:1754:20: (lv_strength_3_0= ruleStrengthEnum )
            	    // InternalRoQME.g:1755:10: lv_strength_3_0= ruleStrengthEnum
            	    {

            	    										newCompositeNode(grammarAccess.getSetEvidenceAccess().getStrengthStrengthEnumEnumRuleCall_2_0_0());
            	    									
            	    pushFollow(FOLLOW_28);
            	    lv_strength_3_0=ruleStrengthEnum();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getSetEvidenceRule());
            	    										}
            	    										set(
            	    											current,
            	    											"strength",
            	    											lv_strength_3_0,
            	    											"org.xtext.roqme.RoQME.StrengthEnum");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRoQME.g:1777:4: ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) )
            	    {
            	    // InternalRoQME.g:1777:4: ({...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) ) )
            	    // InternalRoQME.g:1778:5: {...}? => ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleSetEvidence", "getUnorderedGroupHelper().canSelect(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // InternalRoQME.g:1778:108: ( ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) ) )
            	    // InternalRoQME.g:1779:6: ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2(), 1);
            	    					
            	    // InternalRoQME.g:1782:9: ({...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) ) )
            	    // InternalRoQME.g:1782:10: {...}? => (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleSetEvidence", "true");
            	    }
            	    // InternalRoQME.g:1782:19: (otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) ) )
            	    // InternalRoQME.g:1782:20: otherlv_4= 'survival' ( (lv_survival_5_0= ruleTimeValue ) )
            	    {
            	    otherlv_4=(Token)match(input,25,FOLLOW_17); 

            	    									newLeafNode(otherlv_4, grammarAccess.getSetEvidenceAccess().getSurvivalKeyword_2_1_0());
            	    								
            	    // InternalRoQME.g:1786:9: ( (lv_survival_5_0= ruleTimeValue ) )
            	    // InternalRoQME.g:1787:10: (lv_survival_5_0= ruleTimeValue )
            	    {
            	    // InternalRoQME.g:1787:10: (lv_survival_5_0= ruleTimeValue )
            	    // InternalRoQME.g:1788:11: lv_survival_5_0= ruleTimeValue
            	    {

            	    											newCompositeNode(grammarAccess.getSetEvidenceAccess().getSurvivalTimeValueParserRuleCall_2_1_1_0());
            	    										
            	    pushFollow(FOLLOW_28);
            	    lv_survival_5_0=ruleTimeValue();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getSetEvidenceRule());
            	    											}
            	    											set(
            	    												current,
            	    												"survival",
            	    												lv_survival_5_0,
            	    												"org.xtext.roqme.RoQME.TimeValue");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getSetEvidenceAccess().getUnorderedGroup_2());
            				

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
    // $ANTLR end "ruleSetEvidence"


    // $ANTLR start "entryRuleStartTimer"
    // InternalRoQME.g:1822:1: entryRuleStartTimer returns [EObject current=null] : iv_ruleStartTimer= ruleStartTimer EOF ;
    public final EObject entryRuleStartTimer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStartTimer = null;


        try {
            // InternalRoQME.g:1822:51: (iv_ruleStartTimer= ruleStartTimer EOF )
            // InternalRoQME.g:1823:2: iv_ruleStartTimer= ruleStartTimer EOF
            {
             newCompositeNode(grammarAccess.getStartTimerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStartTimer=ruleStartTimer();

            state._fsp--;

             current =iv_ruleStartTimer; 
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
    // $ANTLR end "entryRuleStartTimer"


    // $ANTLR start "ruleStartTimer"
    // InternalRoQME.g:1829:1: ruleStartTimer returns [EObject current=null] : (otherlv_0= 'starts' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleStartTimer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRoQME.g:1835:2: ( (otherlv_0= 'starts' ( ( ruleQualifiedName ) ) ) )
            // InternalRoQME.g:1836:2: (otherlv_0= 'starts' ( ( ruleQualifiedName ) ) )
            {
            // InternalRoQME.g:1836:2: (otherlv_0= 'starts' ( ( ruleQualifiedName ) ) )
            // InternalRoQME.g:1837:3: otherlv_0= 'starts' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getStartTimerAccess().getStartsKeyword_0());
            		
            // InternalRoQME.g:1841:3: ( ( ruleQualifiedName ) )
            // InternalRoQME.g:1842:4: ( ruleQualifiedName )
            {
            // InternalRoQME.g:1842:4: ( ruleQualifiedName )
            // InternalRoQME.g:1843:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStartTimerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStartTimerAccess().getTimerTimerCrossReference_1_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


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
    // $ANTLR end "ruleStartTimer"


    // $ANTLR start "entryRuleStopTimer"
    // InternalRoQME.g:1861:1: entryRuleStopTimer returns [EObject current=null] : iv_ruleStopTimer= ruleStopTimer EOF ;
    public final EObject entryRuleStopTimer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStopTimer = null;


        try {
            // InternalRoQME.g:1861:50: (iv_ruleStopTimer= ruleStopTimer EOF )
            // InternalRoQME.g:1862:2: iv_ruleStopTimer= ruleStopTimer EOF
            {
             newCompositeNode(grammarAccess.getStopTimerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStopTimer=ruleStopTimer();

            state._fsp--;

             current =iv_ruleStopTimer; 
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
    // $ANTLR end "entryRuleStopTimer"


    // $ANTLR start "ruleStopTimer"
    // InternalRoQME.g:1868:1: ruleStopTimer returns [EObject current=null] : (otherlv_0= 'stops' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleStopTimer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRoQME.g:1874:2: ( (otherlv_0= 'stops' ( ( ruleQualifiedName ) ) ) )
            // InternalRoQME.g:1875:2: (otherlv_0= 'stops' ( ( ruleQualifiedName ) ) )
            {
            // InternalRoQME.g:1875:2: (otherlv_0= 'stops' ( ( ruleQualifiedName ) ) )
            // InternalRoQME.g:1876:3: otherlv_0= 'stops' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getStopTimerAccess().getStopsKeyword_0());
            		
            // InternalRoQME.g:1880:3: ( ( ruleQualifiedName ) )
            // InternalRoQME.g:1881:4: ( ruleQualifiedName )
            {
            // InternalRoQME.g:1881:4: ( ruleQualifiedName )
            // InternalRoQME.g:1882:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStopTimerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStopTimerAccess().getTimerTimerCrossReference_1_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


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
    // $ANTLR end "ruleStopTimer"


    // $ANTLR start "entryRuleResumeTimer"
    // InternalRoQME.g:1900:1: entryRuleResumeTimer returns [EObject current=null] : iv_ruleResumeTimer= ruleResumeTimer EOF ;
    public final EObject entryRuleResumeTimer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResumeTimer = null;


        try {
            // InternalRoQME.g:1900:52: (iv_ruleResumeTimer= ruleResumeTimer EOF )
            // InternalRoQME.g:1901:2: iv_ruleResumeTimer= ruleResumeTimer EOF
            {
             newCompositeNode(grammarAccess.getResumeTimerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleResumeTimer=ruleResumeTimer();

            state._fsp--;

             current =iv_ruleResumeTimer; 
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
    // $ANTLR end "entryRuleResumeTimer"


    // $ANTLR start "ruleResumeTimer"
    // InternalRoQME.g:1907:1: ruleResumeTimer returns [EObject current=null] : (otherlv_0= 'resumes' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleResumeTimer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRoQME.g:1913:2: ( (otherlv_0= 'resumes' ( ( ruleQualifiedName ) ) ) )
            // InternalRoQME.g:1914:2: (otherlv_0= 'resumes' ( ( ruleQualifiedName ) ) )
            {
            // InternalRoQME.g:1914:2: (otherlv_0= 'resumes' ( ( ruleQualifiedName ) ) )
            // InternalRoQME.g:1915:3: otherlv_0= 'resumes' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getResumeTimerAccess().getResumesKeyword_0());
            		
            // InternalRoQME.g:1919:3: ( ( ruleQualifiedName ) )
            // InternalRoQME.g:1920:4: ( ruleQualifiedName )
            {
            // InternalRoQME.g:1920:4: ( ruleQualifiedName )
            // InternalRoQME.g:1921:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getResumeTimerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getResumeTimerAccess().getTimerTimerCrossReference_1_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


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
    // $ANTLR end "ruleResumeTimer"


    // $ANTLR start "entryRuleDataTypeDefinition"
    // InternalRoQME.g:1939:1: entryRuleDataTypeDefinition returns [EObject current=null] : iv_ruleDataTypeDefinition= ruleDataTypeDefinition EOF ;
    public final EObject entryRuleDataTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeDefinition = null;


        try {
            // InternalRoQME.g:1939:59: (iv_ruleDataTypeDefinition= ruleDataTypeDefinition EOF )
            // InternalRoQME.g:1940:2: iv_ruleDataTypeDefinition= ruleDataTypeDefinition EOF
            {
             newCompositeNode(grammarAccess.getDataTypeDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataTypeDefinition=ruleDataTypeDefinition();

            state._fsp--;

             current =iv_ruleDataTypeDefinition; 
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
    // $ANTLR end "entryRuleDataTypeDefinition"


    // $ANTLR start "ruleDataTypeDefinition"
    // InternalRoQME.g:1946:1: ruleDataTypeDefinition returns [EObject current=null] : (otherlv_0= 'type' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_dataType_3_0= ruleDataType ) ) ) ;
    public final EObject ruleDataTypeDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_dataType_3_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:1952:2: ( (otherlv_0= 'type' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_dataType_3_0= ruleDataType ) ) ) )
            // InternalRoQME.g:1953:2: (otherlv_0= 'type' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_dataType_3_0= ruleDataType ) ) )
            {
            // InternalRoQME.g:1953:2: (otherlv_0= 'type' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_dataType_3_0= ruleDataType ) ) )
            // InternalRoQME.g:1954:3: otherlv_0= 'type' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_dataType_3_0= ruleDataType ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getDataTypeDefinitionAccess().getTypeKeyword_0());
            		
            // InternalRoQME.g:1958:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRoQME.g:1959:4: (lv_name_1_0= ruleEString )
            {
            // InternalRoQME.g:1959:4: (lv_name_1_0= ruleEString )
            // InternalRoQME.g:1960:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDataTypeDefinitionAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_9);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataTypeDefinitionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.roqme.RoQME.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getDataTypeDefinitionAccess().getColonKeyword_2());
            		
            // InternalRoQME.g:1981:3: ( (lv_dataType_3_0= ruleDataType ) )
            // InternalRoQME.g:1982:4: (lv_dataType_3_0= ruleDataType )
            {
            // InternalRoQME.g:1982:4: (lv_dataType_3_0= ruleDataType )
            // InternalRoQME.g:1983:5: lv_dataType_3_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getDataTypeDefinitionAccess().getDataTypeDataTypeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_dataType_3_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataTypeDefinitionRule());
            					}
            					set(
            						current,
            						"dataType",
            						lv_dataType_3_0,
            						"org.xtext.roqme.RoQME.DataType");
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
    // $ANTLR end "ruleDataTypeDefinition"


    // $ANTLR start "entryRuleDataType"
    // InternalRoQME.g:2004:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // InternalRoQME.g:2004:49: (iv_ruleDataType= ruleDataType EOF )
            // InternalRoQME.g:2005:2: iv_ruleDataType= ruleDataType EOF
            {
             newCompositeNode(grammarAccess.getDataTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataType=ruleDataType();

            state._fsp--;

             current =iv_ruleDataType; 
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
    // $ANTLR end "entryRuleDataType"


    // $ANTLR start "ruleDataType"
    // InternalRoQME.g:2011:1: ruleDataType returns [EObject current=null] : (this_BooleanType_0= ruleBooleanType | this_EnumType_1= ruleEnumType | this_EventType_2= ruleEventType | this_NumericType_3= ruleNumericType | this_UnitMeasuredType_4= ruleUnitMeasuredType | this_TimeType_5= ruleTimeType ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanType_0 = null;

        EObject this_EnumType_1 = null;

        EObject this_EventType_2 = null;

        EObject this_NumericType_3 = null;

        EObject this_UnitMeasuredType_4 = null;

        EObject this_TimeType_5 = null;



        	enterRule();

        try {
            // InternalRoQME.g:2017:2: ( (this_BooleanType_0= ruleBooleanType | this_EnumType_1= ruleEnumType | this_EventType_2= ruleEventType | this_NumericType_3= ruleNumericType | this_UnitMeasuredType_4= ruleUnitMeasuredType | this_TimeType_5= ruleTimeType ) )
            // InternalRoQME.g:2018:2: (this_BooleanType_0= ruleBooleanType | this_EnumType_1= ruleEnumType | this_EventType_2= ruleEventType | this_NumericType_3= ruleNumericType | this_UnitMeasuredType_4= ruleUnitMeasuredType | this_TimeType_5= ruleTimeType )
            {
            // InternalRoQME.g:2018:2: (this_BooleanType_0= ruleBooleanType | this_EnumType_1= ruleEnumType | this_EventType_2= ruleEventType | this_NumericType_3= ruleNumericType | this_UnitMeasuredType_4= ruleUnitMeasuredType | this_TimeType_5= ruleTimeType )
            int alt24=6;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // InternalRoQME.g:2019:3: this_BooleanType_0= ruleBooleanType
                    {

                    			newCompositeNode(grammarAccess.getDataTypeAccess().getBooleanTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanType_0=ruleBooleanType();

                    state._fsp--;


                    			current = this_BooleanType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:2028:3: this_EnumType_1= ruleEnumType
                    {

                    			newCompositeNode(grammarAccess.getDataTypeAccess().getEnumTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EnumType_1=ruleEnumType();

                    state._fsp--;


                    			current = this_EnumType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRoQME.g:2037:3: this_EventType_2= ruleEventType
                    {

                    			newCompositeNode(grammarAccess.getDataTypeAccess().getEventTypeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_EventType_2=ruleEventType();

                    state._fsp--;


                    			current = this_EventType_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalRoQME.g:2046:3: this_NumericType_3= ruleNumericType
                    {

                    			newCompositeNode(grammarAccess.getDataTypeAccess().getNumericTypeParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumericType_3=ruleNumericType();

                    state._fsp--;


                    			current = this_NumericType_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalRoQME.g:2055:3: this_UnitMeasuredType_4= ruleUnitMeasuredType
                    {

                    			newCompositeNode(grammarAccess.getDataTypeAccess().getUnitMeasuredTypeParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnitMeasuredType_4=ruleUnitMeasuredType();

                    state._fsp--;


                    			current = this_UnitMeasuredType_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalRoQME.g:2064:3: this_TimeType_5= ruleTimeType
                    {

                    			newCompositeNode(grammarAccess.getDataTypeAccess().getTimeTypeParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_TimeType_5=ruleTimeType();

                    state._fsp--;


                    			current = this_TimeType_5;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleDataType"


    // $ANTLR start "entryRuleBooleanType"
    // InternalRoQME.g:2076:1: entryRuleBooleanType returns [EObject current=null] : iv_ruleBooleanType= ruleBooleanType EOF ;
    public final EObject entryRuleBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanType = null;


        try {
            // InternalRoQME.g:2076:52: (iv_ruleBooleanType= ruleBooleanType EOF )
            // InternalRoQME.g:2077:2: iv_ruleBooleanType= ruleBooleanType EOF
            {
             newCompositeNode(grammarAccess.getBooleanTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanType=ruleBooleanType();

            state._fsp--;

             current =iv_ruleBooleanType; 
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
    // $ANTLR end "entryRuleBooleanType"


    // $ANTLR start "ruleBooleanType"
    // InternalRoQME.g:2083:1: ruleBooleanType returns [EObject current=null] : ( () otherlv_1= 'boolean' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ) ;
    public final EObject ruleBooleanType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_cardinality_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalRoQME.g:2089:2: ( ( () otherlv_1= 'boolean' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ) )
            // InternalRoQME.g:2090:2: ( () otherlv_1= 'boolean' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? )
            {
            // InternalRoQME.g:2090:2: ( () otherlv_1= 'boolean' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? )
            // InternalRoQME.g:2091:3: () otherlv_1= 'boolean' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            {
            // InternalRoQME.g:2091:3: ()
            // InternalRoQME.g:2092:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanTypeAccess().getBooleanTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,37,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getBooleanTypeAccess().getBooleanKeyword_1());
            		
            // InternalRoQME.g:2102:3: (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==38) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalRoQME.g:2103:4: otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,38,FOLLOW_30); 

                    				newLeafNode(otherlv_2, grammarAccess.getBooleanTypeAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRoQME.g:2107:4: ( (lv_cardinality_3_0= RULE_INT ) )
                    // InternalRoQME.g:2108:5: (lv_cardinality_3_0= RULE_INT )
                    {
                    // InternalRoQME.g:2108:5: (lv_cardinality_3_0= RULE_INT )
                    // InternalRoQME.g:2109:6: lv_cardinality_3_0= RULE_INT
                    {
                    lv_cardinality_3_0=(Token)match(input,RULE_INT,FOLLOW_31); 

                    						newLeafNode(lv_cardinality_3_0, grammarAccess.getBooleanTypeAccess().getCardinalityINTTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBooleanTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"cardinality",
                    							lv_cardinality_3_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,39,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getBooleanTypeAccess().getRightSquareBracketKeyword_2_2());
                    			

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
    // $ANTLR end "ruleBooleanType"


    // $ANTLR start "entryRuleEnumType"
    // InternalRoQME.g:2134:1: entryRuleEnumType returns [EObject current=null] : iv_ruleEnumType= ruleEnumType EOF ;
    public final EObject entryRuleEnumType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumType = null;


        try {
            // InternalRoQME.g:2134:49: (iv_ruleEnumType= ruleEnumType EOF )
            // InternalRoQME.g:2135:2: iv_ruleEnumType= ruleEnumType EOF
            {
             newCompositeNode(grammarAccess.getEnumTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumType=ruleEnumType();

            state._fsp--;

             current =iv_ruleEnumType; 
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
    // $ANTLR end "entryRuleEnumType"


    // $ANTLR start "ruleEnumType"
    // InternalRoQME.g:2141:1: ruleEnumType returns [EObject current=null] : (otherlv_0= 'enum' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_literals_5_0= ruleEnumLiteral ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteral ) ) )+ otherlv_8= '}' ) ;
    public final EObject ruleEnumType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_cardinality_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_literals_5_0 = null;

        EObject lv_literals_7_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:2147:2: ( (otherlv_0= 'enum' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_literals_5_0= ruleEnumLiteral ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteral ) ) )+ otherlv_8= '}' ) )
            // InternalRoQME.g:2148:2: (otherlv_0= 'enum' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_literals_5_0= ruleEnumLiteral ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteral ) ) )+ otherlv_8= '}' )
            {
            // InternalRoQME.g:2148:2: (otherlv_0= 'enum' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_literals_5_0= ruleEnumLiteral ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteral ) ) )+ otherlv_8= '}' )
            // InternalRoQME.g:2149:3: otherlv_0= 'enum' (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_literals_5_0= ruleEnumLiteral ) ) (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteral ) ) )+ otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumTypeAccess().getEnumKeyword_0());
            		
            // InternalRoQME.g:2153:3: (otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==38) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalRoQME.g:2154:4: otherlv_1= '[' ( (lv_cardinality_2_0= RULE_INT ) ) otherlv_3= ']'
                    {
                    otherlv_1=(Token)match(input,38,FOLLOW_30); 

                    				newLeafNode(otherlv_1, grammarAccess.getEnumTypeAccess().getLeftSquareBracketKeyword_1_0());
                    			
                    // InternalRoQME.g:2158:4: ( (lv_cardinality_2_0= RULE_INT ) )
                    // InternalRoQME.g:2159:5: (lv_cardinality_2_0= RULE_INT )
                    {
                    // InternalRoQME.g:2159:5: (lv_cardinality_2_0= RULE_INT )
                    // InternalRoQME.g:2160:6: lv_cardinality_2_0= RULE_INT
                    {
                    lv_cardinality_2_0=(Token)match(input,RULE_INT,FOLLOW_31); 

                    						newLeafNode(lv_cardinality_2_0, grammarAccess.getEnumTypeAccess().getCardinalityINTTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEnumTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"cardinality",
                    							lv_cardinality_2_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,39,FOLLOW_33); 

                    				newLeafNode(otherlv_3, grammarAccess.getEnumTypeAccess().getRightSquareBracketKeyword_1_2());
                    			

                    }
                    break;

            }

            otherlv_4=(Token)match(input,29,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getEnumTypeAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalRoQME.g:2185:3: ( (lv_literals_5_0= ruleEnumLiteral ) )
            // InternalRoQME.g:2186:4: (lv_literals_5_0= ruleEnumLiteral )
            {
            // InternalRoQME.g:2186:4: (lv_literals_5_0= ruleEnumLiteral )
            // InternalRoQME.g:2187:5: lv_literals_5_0= ruleEnumLiteral
            {

            					newCompositeNode(grammarAccess.getEnumTypeAccess().getLiteralsEnumLiteralParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_34);
            lv_literals_5_0=ruleEnumLiteral();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEnumTypeRule());
            					}
            					add(
            						current,
            						"literals",
            						lv_literals_5_0,
            						"org.xtext.roqme.RoQME.EnumLiteral");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoQME.g:2204:3: (otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteral ) ) )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==41) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalRoQME.g:2205:4: otherlv_6= ',' ( (lv_literals_7_0= ruleEnumLiteral ) )
            	    {
            	    otherlv_6=(Token)match(input,41,FOLLOW_8); 

            	    				newLeafNode(otherlv_6, grammarAccess.getEnumTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalRoQME.g:2209:4: ( (lv_literals_7_0= ruleEnumLiteral ) )
            	    // InternalRoQME.g:2210:5: (lv_literals_7_0= ruleEnumLiteral )
            	    {
            	    // InternalRoQME.g:2210:5: (lv_literals_7_0= ruleEnumLiteral )
            	    // InternalRoQME.g:2211:6: lv_literals_7_0= ruleEnumLiteral
            	    {

            	    						newCompositeNode(grammarAccess.getEnumTypeAccess().getLiteralsEnumLiteralParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_35);
            	    lv_literals_7_0=ruleEnumLiteral();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEnumTypeRule());
            	    						}
            	    						add(
            	    							current,
            	    							"literals",
            	    							lv_literals_7_0,
            	    							"org.xtext.roqme.RoQME.EnumLiteral");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);

            otherlv_8=(Token)match(input,30,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getEnumTypeAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleEnumType"


    // $ANTLR start "entryRuleEnumLiteral"
    // InternalRoQME.g:2237:1: entryRuleEnumLiteral returns [EObject current=null] : iv_ruleEnumLiteral= ruleEnumLiteral EOF ;
    public final EObject entryRuleEnumLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumLiteral = null;


        try {
            // InternalRoQME.g:2237:52: (iv_ruleEnumLiteral= ruleEnumLiteral EOF )
            // InternalRoQME.g:2238:2: iv_ruleEnumLiteral= ruleEnumLiteral EOF
            {
             newCompositeNode(grammarAccess.getEnumLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumLiteral=ruleEnumLiteral();

            state._fsp--;

             current =iv_ruleEnumLiteral; 
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
    // $ANTLR end "entryRuleEnumLiteral"


    // $ANTLR start "ruleEnumLiteral"
    // InternalRoQME.g:2244:1: ruleEnumLiteral returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEnumLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalRoQME.g:2250:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalRoQME.g:2251:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalRoQME.g:2251:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalRoQME.g:2252:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalRoQME.g:2252:3: ()
            // InternalRoQME.g:2253:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEnumLiteralAccess().getEnumLiteralAction_0(),
            					current);
            			

            }

            // InternalRoQME.g:2259:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRoQME.g:2260:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRoQME.g:2260:4: (lv_name_1_0= RULE_ID )
            // InternalRoQME.g:2261:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEnumLiteralAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumLiteralRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // $ANTLR end "ruleEnumLiteral"


    // $ANTLR start "entryRuleEventType"
    // InternalRoQME.g:2281:1: entryRuleEventType returns [EObject current=null] : iv_ruleEventType= ruleEventType EOF ;
    public final EObject entryRuleEventType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventType = null;


        try {
            // InternalRoQME.g:2281:50: (iv_ruleEventType= ruleEventType EOF )
            // InternalRoQME.g:2282:2: iv_ruleEventType= ruleEventType EOF
            {
             newCompositeNode(grammarAccess.getEventTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEventType=ruleEventType();

            state._fsp--;

             current =iv_ruleEventType; 
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
    // $ANTLR end "entryRuleEventType"


    // $ANTLR start "ruleEventType"
    // InternalRoQME.g:2288:1: ruleEventType returns [EObject current=null] : ( () otherlv_1= 'eventtype' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ) ;
    public final EObject ruleEventType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_cardinality_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalRoQME.g:2294:2: ( ( () otherlv_1= 'eventtype' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ) )
            // InternalRoQME.g:2295:2: ( () otherlv_1= 'eventtype' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? )
            {
            // InternalRoQME.g:2295:2: ( () otherlv_1= 'eventtype' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? )
            // InternalRoQME.g:2296:3: () otherlv_1= 'eventtype' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            {
            // InternalRoQME.g:2296:3: ()
            // InternalRoQME.g:2297:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEventTypeAccess().getEventTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,42,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getEventTypeAccess().getEventtypeKeyword_1());
            		
            // InternalRoQME.g:2307:3: (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==38) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalRoQME.g:2308:4: otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,38,FOLLOW_30); 

                    				newLeafNode(otherlv_2, grammarAccess.getEventTypeAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRoQME.g:2312:4: ( (lv_cardinality_3_0= RULE_INT ) )
                    // InternalRoQME.g:2313:5: (lv_cardinality_3_0= RULE_INT )
                    {
                    // InternalRoQME.g:2313:5: (lv_cardinality_3_0= RULE_INT )
                    // InternalRoQME.g:2314:6: lv_cardinality_3_0= RULE_INT
                    {
                    lv_cardinality_3_0=(Token)match(input,RULE_INT,FOLLOW_31); 

                    						newLeafNode(lv_cardinality_3_0, grammarAccess.getEventTypeAccess().getCardinalityINTTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEventTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"cardinality",
                    							lv_cardinality_3_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,39,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getEventTypeAccess().getRightSquareBracketKeyword_2_2());
                    			

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
    // $ANTLR end "ruleEventType"


    // $ANTLR start "entryRuleNumericType"
    // InternalRoQME.g:2339:1: entryRuleNumericType returns [EObject current=null] : iv_ruleNumericType= ruleNumericType EOF ;
    public final EObject entryRuleNumericType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericType = null;


        try {
            // InternalRoQME.g:2339:52: (iv_ruleNumericType= ruleNumericType EOF )
            // InternalRoQME.g:2340:2: iv_ruleNumericType= ruleNumericType EOF
            {
             newCompositeNode(grammarAccess.getNumericTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericType=ruleNumericType();

            state._fsp--;

             current =iv_ruleNumericType; 
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
    // $ANTLR end "entryRuleNumericType"


    // $ANTLR start "ruleNumericType"
    // InternalRoQME.g:2346:1: ruleNumericType returns [EObject current=null] : ( () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* ) ;
    public final EObject ruleNumericType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_cardinality_3_0=null;
        Token otherlv_4=null;
        EObject lv_constraints_5_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:2352:2: ( ( () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* ) )
            // InternalRoQME.g:2353:2: ( () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* )
            {
            // InternalRoQME.g:2353:2: ( () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* )
            // InternalRoQME.g:2354:3: () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )*
            {
            // InternalRoQME.g:2354:3: ()
            // InternalRoQME.g:2355:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNumericTypeAccess().getNumericTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,43,FOLLOW_36); 

            			newLeafNode(otherlv_1, grammarAccess.getNumericTypeAccess().getNumberKeyword_1());
            		
            // InternalRoQME.g:2365:3: (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==38) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalRoQME.g:2366:4: otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,38,FOLLOW_30); 

                    				newLeafNode(otherlv_2, grammarAccess.getNumericTypeAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRoQME.g:2370:4: ( (lv_cardinality_3_0= RULE_INT ) )
                    // InternalRoQME.g:2371:5: (lv_cardinality_3_0= RULE_INT )
                    {
                    // InternalRoQME.g:2371:5: (lv_cardinality_3_0= RULE_INT )
                    // InternalRoQME.g:2372:6: lv_cardinality_3_0= RULE_INT
                    {
                    lv_cardinality_3_0=(Token)match(input,RULE_INT,FOLLOW_31); 

                    						newLeafNode(lv_cardinality_3_0, grammarAccess.getNumericTypeAccess().getCardinalityINTTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNumericTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"cardinality",
                    							lv_cardinality_3_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,39,FOLLOW_37); 

                    				newLeafNode(otherlv_4, grammarAccess.getNumericTypeAccess().getRightSquareBracketKeyword_2_2());
                    			

                    }
                    break;

            }

            // InternalRoQME.g:2393:3: ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=44 && LA30_0<=45)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalRoQME.g:2394:4: (lv_constraints_5_0= ruleNumericTypeConstraint )
            	    {
            	    // InternalRoQME.g:2394:4: (lv_constraints_5_0= ruleNumericTypeConstraint )
            	    // InternalRoQME.g:2395:5: lv_constraints_5_0= ruleNumericTypeConstraint
            	    {

            	    					newCompositeNode(grammarAccess.getNumericTypeAccess().getConstraintsNumericTypeConstraintParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_37);
            	    lv_constraints_5_0=ruleNumericTypeConstraint();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getNumericTypeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"constraints",
            	    						lv_constraints_5_0,
            	    						"org.xtext.roqme.RoQME.NumericTypeConstraint");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // $ANTLR end "ruleNumericType"


    // $ANTLR start "entryRuleNumericTypeConstraint"
    // InternalRoQME.g:2416:1: entryRuleNumericTypeConstraint returns [EObject current=null] : iv_ruleNumericTypeConstraint= ruleNumericTypeConstraint EOF ;
    public final EObject entryRuleNumericTypeConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericTypeConstraint = null;


        try {
            // InternalRoQME.g:2416:62: (iv_ruleNumericTypeConstraint= ruleNumericTypeConstraint EOF )
            // InternalRoQME.g:2417:2: iv_ruleNumericTypeConstraint= ruleNumericTypeConstraint EOF
            {
             newCompositeNode(grammarAccess.getNumericTypeConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericTypeConstraint=ruleNumericTypeConstraint();

            state._fsp--;

             current =iv_ruleNumericTypeConstraint; 
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
    // $ANTLR end "entryRuleNumericTypeConstraint"


    // $ANTLR start "ruleNumericTypeConstraint"
    // InternalRoQME.g:2423:1: ruleNumericTypeConstraint returns [EObject current=null] : (this_LowerBound_0= ruleLowerBound | this_UpperBound_1= ruleUpperBound ) ;
    public final EObject ruleNumericTypeConstraint() throws RecognitionException {
        EObject current = null;

        EObject this_LowerBound_0 = null;

        EObject this_UpperBound_1 = null;



        	enterRule();

        try {
            // InternalRoQME.g:2429:2: ( (this_LowerBound_0= ruleLowerBound | this_UpperBound_1= ruleUpperBound ) )
            // InternalRoQME.g:2430:2: (this_LowerBound_0= ruleLowerBound | this_UpperBound_1= ruleUpperBound )
            {
            // InternalRoQME.g:2430:2: (this_LowerBound_0= ruleLowerBound | this_UpperBound_1= ruleUpperBound )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==44) ) {
                alt31=1;
            }
            else if ( (LA31_0==45) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalRoQME.g:2431:3: this_LowerBound_0= ruleLowerBound
                    {

                    			newCompositeNode(grammarAccess.getNumericTypeConstraintAccess().getLowerBoundParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_LowerBound_0=ruleLowerBound();

                    state._fsp--;


                    			current = this_LowerBound_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:2440:3: this_UpperBound_1= ruleUpperBound
                    {

                    			newCompositeNode(grammarAccess.getNumericTypeConstraintAccess().getUpperBoundParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_UpperBound_1=ruleUpperBound();

                    state._fsp--;


                    			current = this_UpperBound_1;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleNumericTypeConstraint"


    // $ANTLR start "entryRuleLowerBound"
    // InternalRoQME.g:2452:1: entryRuleLowerBound returns [EObject current=null] : iv_ruleLowerBound= ruleLowerBound EOF ;
    public final EObject entryRuleLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerBound = null;


        try {
            // InternalRoQME.g:2452:51: (iv_ruleLowerBound= ruleLowerBound EOF )
            // InternalRoQME.g:2453:2: iv_ruleLowerBound= ruleLowerBound EOF
            {
             newCompositeNode(grammarAccess.getLowerBoundRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLowerBound=ruleLowerBound();

            state._fsp--;

             current =iv_ruleLowerBound; 
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
    // $ANTLR end "entryRuleLowerBound"


    // $ANTLR start "ruleLowerBound"
    // InternalRoQME.g:2459:1: ruleLowerBound returns [EObject current=null] : (otherlv_0= 'lower' ( (lv_value_1_0= ruleEDouble ) ) ) ;
    public final EObject ruleLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:2465:2: ( (otherlv_0= 'lower' ( (lv_value_1_0= ruleEDouble ) ) ) )
            // InternalRoQME.g:2466:2: (otherlv_0= 'lower' ( (lv_value_1_0= ruleEDouble ) ) )
            {
            // InternalRoQME.g:2466:2: (otherlv_0= 'lower' ( (lv_value_1_0= ruleEDouble ) ) )
            // InternalRoQME.g:2467:3: otherlv_0= 'lower' ( (lv_value_1_0= ruleEDouble ) )
            {
            otherlv_0=(Token)match(input,44,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getLowerBoundAccess().getLowerKeyword_0());
            		
            // InternalRoQME.g:2471:3: ( (lv_value_1_0= ruleEDouble ) )
            // InternalRoQME.g:2472:4: (lv_value_1_0= ruleEDouble )
            {
            // InternalRoQME.g:2472:4: (lv_value_1_0= ruleEDouble )
            // InternalRoQME.g:2473:5: lv_value_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getLowerBoundAccess().getValueEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLowerBoundRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.xtext.roqme.RoQME.EDouble");
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
    // $ANTLR end "ruleLowerBound"


    // $ANTLR start "entryRuleUpperBound"
    // InternalRoQME.g:2494:1: entryRuleUpperBound returns [EObject current=null] : iv_ruleUpperBound= ruleUpperBound EOF ;
    public final EObject entryRuleUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpperBound = null;


        try {
            // InternalRoQME.g:2494:51: (iv_ruleUpperBound= ruleUpperBound EOF )
            // InternalRoQME.g:2495:2: iv_ruleUpperBound= ruleUpperBound EOF
            {
             newCompositeNode(grammarAccess.getUpperBoundRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUpperBound=ruleUpperBound();

            state._fsp--;

             current =iv_ruleUpperBound; 
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
    // $ANTLR end "entryRuleUpperBound"


    // $ANTLR start "ruleUpperBound"
    // InternalRoQME.g:2501:1: ruleUpperBound returns [EObject current=null] : (otherlv_0= 'upper' ( (lv_value_1_0= ruleEDouble ) ) ) ;
    public final EObject ruleUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:2507:2: ( (otherlv_0= 'upper' ( (lv_value_1_0= ruleEDouble ) ) ) )
            // InternalRoQME.g:2508:2: (otherlv_0= 'upper' ( (lv_value_1_0= ruleEDouble ) ) )
            {
            // InternalRoQME.g:2508:2: (otherlv_0= 'upper' ( (lv_value_1_0= ruleEDouble ) ) )
            // InternalRoQME.g:2509:3: otherlv_0= 'upper' ( (lv_value_1_0= ruleEDouble ) )
            {
            otherlv_0=(Token)match(input,45,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getUpperBoundAccess().getUpperKeyword_0());
            		
            // InternalRoQME.g:2513:3: ( (lv_value_1_0= ruleEDouble ) )
            // InternalRoQME.g:2514:4: (lv_value_1_0= ruleEDouble )
            {
            // InternalRoQME.g:2514:4: (lv_value_1_0= ruleEDouble )
            // InternalRoQME.g:2515:5: lv_value_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getUpperBoundAccess().getValueEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUpperBoundRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.xtext.roqme.RoQME.EDouble");
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
    // $ANTLR end "ruleUpperBound"


    // $ANTLR start "entryRuleUnitMeasuredType"
    // InternalRoQME.g:2536:1: entryRuleUnitMeasuredType returns [EObject current=null] : iv_ruleUnitMeasuredType= ruleUnitMeasuredType EOF ;
    public final EObject entryRuleUnitMeasuredType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitMeasuredType = null;


        try {
            // InternalRoQME.g:2536:57: (iv_ruleUnitMeasuredType= ruleUnitMeasuredType EOF )
            // InternalRoQME.g:2537:2: iv_ruleUnitMeasuredType= ruleUnitMeasuredType EOF
            {
             newCompositeNode(grammarAccess.getUnitMeasuredTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnitMeasuredType=ruleUnitMeasuredType();

            state._fsp--;

             current =iv_ruleUnitMeasuredType; 
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
    // $ANTLR end "entryRuleUnitMeasuredType"


    // $ANTLR start "ruleUnitMeasuredType"
    // InternalRoQME.g:2543:1: ruleUnitMeasuredType returns [EObject current=null] : ( () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* otherlv_6= 'unit' ( (lv_unit_7_0= ruleEString ) ) ( (lv_constraints_8_0= ruleNumericTypeConstraint ) )* ) ;
    public final EObject ruleUnitMeasuredType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_cardinality_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_constraints_5_0 = null;

        AntlrDatatypeRuleToken lv_unit_7_0 = null;

        EObject lv_constraints_8_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:2549:2: ( ( () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* otherlv_6= 'unit' ( (lv_unit_7_0= ruleEString ) ) ( (lv_constraints_8_0= ruleNumericTypeConstraint ) )* ) )
            // InternalRoQME.g:2550:2: ( () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* otherlv_6= 'unit' ( (lv_unit_7_0= ruleEString ) ) ( (lv_constraints_8_0= ruleNumericTypeConstraint ) )* )
            {
            // InternalRoQME.g:2550:2: ( () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* otherlv_6= 'unit' ( (lv_unit_7_0= ruleEString ) ) ( (lv_constraints_8_0= ruleNumericTypeConstraint ) )* )
            // InternalRoQME.g:2551:3: () otherlv_1= 'number' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )* otherlv_6= 'unit' ( (lv_unit_7_0= ruleEString ) ) ( (lv_constraints_8_0= ruleNumericTypeConstraint ) )*
            {
            // InternalRoQME.g:2551:3: ()
            // InternalRoQME.g:2552:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUnitMeasuredTypeAccess().getUnitMeasuredTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,43,FOLLOW_38); 

            			newLeafNode(otherlv_1, grammarAccess.getUnitMeasuredTypeAccess().getNumberKeyword_1());
            		
            // InternalRoQME.g:2562:3: (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==38) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalRoQME.g:2563:4: otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,38,FOLLOW_30); 

                    				newLeafNode(otherlv_2, grammarAccess.getUnitMeasuredTypeAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRoQME.g:2567:4: ( (lv_cardinality_3_0= RULE_INT ) )
                    // InternalRoQME.g:2568:5: (lv_cardinality_3_0= RULE_INT )
                    {
                    // InternalRoQME.g:2568:5: (lv_cardinality_3_0= RULE_INT )
                    // InternalRoQME.g:2569:6: lv_cardinality_3_0= RULE_INT
                    {
                    lv_cardinality_3_0=(Token)match(input,RULE_INT,FOLLOW_31); 

                    						newLeafNode(lv_cardinality_3_0, grammarAccess.getUnitMeasuredTypeAccess().getCardinalityINTTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getUnitMeasuredTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"cardinality",
                    							lv_cardinality_3_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,39,FOLLOW_39); 

                    				newLeafNode(otherlv_4, grammarAccess.getUnitMeasuredTypeAccess().getRightSquareBracketKeyword_2_2());
                    			

                    }
                    break;

            }

            // InternalRoQME.g:2590:3: ( (lv_constraints_5_0= ruleNumericTypeConstraint ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=44 && LA33_0<=45)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalRoQME.g:2591:4: (lv_constraints_5_0= ruleNumericTypeConstraint )
            	    {
            	    // InternalRoQME.g:2591:4: (lv_constraints_5_0= ruleNumericTypeConstraint )
            	    // InternalRoQME.g:2592:5: lv_constraints_5_0= ruleNumericTypeConstraint
            	    {

            	    					newCompositeNode(grammarAccess.getUnitMeasuredTypeAccess().getConstraintsNumericTypeConstraintParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_39);
            	    lv_constraints_5_0=ruleNumericTypeConstraint();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getUnitMeasuredTypeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"constraints",
            	    						lv_constraints_5_0,
            	    						"org.xtext.roqme.RoQME.NumericTypeConstraint");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            otherlv_6=(Token)match(input,46,FOLLOW_4); 

            			newLeafNode(otherlv_6, grammarAccess.getUnitMeasuredTypeAccess().getUnitKeyword_4());
            		
            // InternalRoQME.g:2613:3: ( (lv_unit_7_0= ruleEString ) )
            // InternalRoQME.g:2614:4: (lv_unit_7_0= ruleEString )
            {
            // InternalRoQME.g:2614:4: (lv_unit_7_0= ruleEString )
            // InternalRoQME.g:2615:5: lv_unit_7_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getUnitMeasuredTypeAccess().getUnitEStringParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_37);
            lv_unit_7_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnitMeasuredTypeRule());
            					}
            					set(
            						current,
            						"unit",
            						lv_unit_7_0,
            						"org.xtext.roqme.RoQME.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoQME.g:2632:3: ( (lv_constraints_8_0= ruleNumericTypeConstraint ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=44 && LA34_0<=45)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalRoQME.g:2633:4: (lv_constraints_8_0= ruleNumericTypeConstraint )
            	    {
            	    // InternalRoQME.g:2633:4: (lv_constraints_8_0= ruleNumericTypeConstraint )
            	    // InternalRoQME.g:2634:5: lv_constraints_8_0= ruleNumericTypeConstraint
            	    {

            	    					newCompositeNode(grammarAccess.getUnitMeasuredTypeAccess().getConstraintsNumericTypeConstraintParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_37);
            	    lv_constraints_8_0=ruleNumericTypeConstraint();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getUnitMeasuredTypeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"constraints",
            	    						lv_constraints_8_0,
            	    						"org.xtext.roqme.RoQME.NumericTypeConstraint");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
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
    // $ANTLR end "ruleUnitMeasuredType"


    // $ANTLR start "entryRuleTimeType"
    // InternalRoQME.g:2655:1: entryRuleTimeType returns [EObject current=null] : iv_ruleTimeType= ruleTimeType EOF ;
    public final EObject entryRuleTimeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeType = null;


        try {
            // InternalRoQME.g:2655:49: (iv_ruleTimeType= ruleTimeType EOF )
            // InternalRoQME.g:2656:2: iv_ruleTimeType= ruleTimeType EOF
            {
             newCompositeNode(grammarAccess.getTimeTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeType=ruleTimeType();

            state._fsp--;

             current =iv_ruleTimeType; 
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
    // $ANTLR end "entryRuleTimeType"


    // $ANTLR start "ruleTimeType"
    // InternalRoQME.g:2662:1: ruleTimeType returns [EObject current=null] : ( () otherlv_1= 'time' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ) ;
    public final EObject ruleTimeType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_cardinality_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalRoQME.g:2668:2: ( ( () otherlv_1= 'time' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? ) )
            // InternalRoQME.g:2669:2: ( () otherlv_1= 'time' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? )
            {
            // InternalRoQME.g:2669:2: ( () otherlv_1= 'time' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )? )
            // InternalRoQME.g:2670:3: () otherlv_1= 'time' (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            {
            // InternalRoQME.g:2670:3: ()
            // InternalRoQME.g:2671:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTimeTypeAccess().getTimeTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,47,FOLLOW_29); 

            			newLeafNode(otherlv_1, grammarAccess.getTimeTypeAccess().getTimeKeyword_1());
            		
            // InternalRoQME.g:2681:3: (otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==38) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalRoQME.g:2682:4: otherlv_2= '[' ( (lv_cardinality_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,38,FOLLOW_30); 

                    				newLeafNode(otherlv_2, grammarAccess.getTimeTypeAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRoQME.g:2686:4: ( (lv_cardinality_3_0= RULE_INT ) )
                    // InternalRoQME.g:2687:5: (lv_cardinality_3_0= RULE_INT )
                    {
                    // InternalRoQME.g:2687:5: (lv_cardinality_3_0= RULE_INT )
                    // InternalRoQME.g:2688:6: lv_cardinality_3_0= RULE_INT
                    {
                    lv_cardinality_3_0=(Token)match(input,RULE_INT,FOLLOW_31); 

                    						newLeafNode(lv_cardinality_3_0, grammarAccess.getTimeTypeAccess().getCardinalityINTTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTimeTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"cardinality",
                    							lv_cardinality_3_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,39,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getTimeTypeAccess().getRightSquareBracketKeyword_2_2());
                    			

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
    // $ANTLR end "ruleTimeType"


    // $ANTLR start "entryRuleTypedValue"
    // InternalRoQME.g:2713:1: entryRuleTypedValue returns [EObject current=null] : iv_ruleTypedValue= ruleTypedValue EOF ;
    public final EObject entryRuleTypedValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedValue = null;


        try {
            // InternalRoQME.g:2713:51: (iv_ruleTypedValue= ruleTypedValue EOF )
            // InternalRoQME.g:2714:2: iv_ruleTypedValue= ruleTypedValue EOF
            {
             newCompositeNode(grammarAccess.getTypedValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypedValue=ruleTypedValue();

            state._fsp--;

             current =iv_ruleTypedValue; 
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
    // $ANTLR end "entryRuleTypedValue"


    // $ANTLR start "ruleTypedValue"
    // InternalRoQME.g:2720:1: ruleTypedValue returns [EObject current=null] : (this_SingleValue_0= ruleSingleValue | this_ArrayValue_1= ruleArrayValue ) ;
    public final EObject ruleTypedValue() throws RecognitionException {
        EObject current = null;

        EObject this_SingleValue_0 = null;

        EObject this_ArrayValue_1 = null;



        	enterRule();

        try {
            // InternalRoQME.g:2726:2: ( (this_SingleValue_0= ruleSingleValue | this_ArrayValue_1= ruleArrayValue ) )
            // InternalRoQME.g:2727:2: (this_SingleValue_0= ruleSingleValue | this_ArrayValue_1= ruleArrayValue )
            {
            // InternalRoQME.g:2727:2: (this_SingleValue_0= ruleSingleValue | this_ArrayValue_1= ruleArrayValue )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=RULE_ID && LA36_0<=RULE_INT)||LA36_0==48||LA36_0==80||(LA36_0>=87 && LA36_0<=88)) ) {
                alt36=1;
            }
            else if ( (LA36_0==38) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalRoQME.g:2728:3: this_SingleValue_0= ruleSingleValue
                    {

                    			newCompositeNode(grammarAccess.getTypedValueAccess().getSingleValueParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SingleValue_0=ruleSingleValue();

                    state._fsp--;


                    			current = this_SingleValue_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:2737:3: this_ArrayValue_1= ruleArrayValue
                    {

                    			newCompositeNode(grammarAccess.getTypedValueAccess().getArrayValueParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArrayValue_1=ruleArrayValue();

                    state._fsp--;


                    			current = this_ArrayValue_1;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleTypedValue"


    // $ANTLR start "entryRuleSingleValue"
    // InternalRoQME.g:2749:1: entryRuleSingleValue returns [EObject current=null] : iv_ruleSingleValue= ruleSingleValue EOF ;
    public final EObject entryRuleSingleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleValue = null;


        try {
            // InternalRoQME.g:2749:52: (iv_ruleSingleValue= ruleSingleValue EOF )
            // InternalRoQME.g:2750:2: iv_ruleSingleValue= ruleSingleValue EOF
            {
             newCompositeNode(grammarAccess.getSingleValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSingleValue=ruleSingleValue();

            state._fsp--;

             current =iv_ruleSingleValue; 
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
    // $ANTLR end "entryRuleSingleValue"


    // $ANTLR start "ruleSingleValue"
    // InternalRoQME.g:2756:1: ruleSingleValue returns [EObject current=null] : (this_BooleanValue_0= ruleBooleanValue | this_EnumValue_1= ruleEnumValue | this_NumericValue_2= ruleNumericValue | this_EventValue_3= ruleEventValue ) ;
    public final EObject ruleSingleValue() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanValue_0 = null;

        EObject this_EnumValue_1 = null;

        EObject this_NumericValue_2 = null;

        EObject this_EventValue_3 = null;



        	enterRule();

        try {
            // InternalRoQME.g:2762:2: ( (this_BooleanValue_0= ruleBooleanValue | this_EnumValue_1= ruleEnumValue | this_NumericValue_2= ruleNumericValue | this_EventValue_3= ruleEventValue ) )
            // InternalRoQME.g:2763:2: (this_BooleanValue_0= ruleBooleanValue | this_EnumValue_1= ruleEnumValue | this_NumericValue_2= ruleNumericValue | this_EventValue_3= ruleEventValue )
            {
            // InternalRoQME.g:2763:2: (this_BooleanValue_0= ruleBooleanValue | this_EnumValue_1= ruleEnumValue | this_NumericValue_2= ruleNumericValue | this_EventValue_3= ruleEventValue )
            int alt37=4;
            switch ( input.LA(1) ) {
            case 87:
            case 88:
                {
                alt37=1;
                }
                break;
            case RULE_ID:
                {
                alt37=2;
                }
                break;
            case RULE_INT:
            case 80:
                {
                alt37=3;
                }
                break;
            case 48:
                {
                alt37=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalRoQME.g:2764:3: this_BooleanValue_0= ruleBooleanValue
                    {

                    			newCompositeNode(grammarAccess.getSingleValueAccess().getBooleanValueParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanValue_0=ruleBooleanValue();

                    state._fsp--;


                    			current = this_BooleanValue_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:2773:3: this_EnumValue_1= ruleEnumValue
                    {

                    			newCompositeNode(grammarAccess.getSingleValueAccess().getEnumValueParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EnumValue_1=ruleEnumValue();

                    state._fsp--;


                    			current = this_EnumValue_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRoQME.g:2782:3: this_NumericValue_2= ruleNumericValue
                    {

                    			newCompositeNode(grammarAccess.getSingleValueAccess().getNumericValueParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumericValue_2=ruleNumericValue();

                    state._fsp--;


                    			current = this_NumericValue_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalRoQME.g:2791:3: this_EventValue_3= ruleEventValue
                    {

                    			newCompositeNode(grammarAccess.getSingleValueAccess().getEventValueParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_EventValue_3=ruleEventValue();

                    state._fsp--;


                    			current = this_EventValue_3;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleSingleValue"


    // $ANTLR start "entryRuleEventValue"
    // InternalRoQME.g:2803:1: entryRuleEventValue returns [EObject current=null] : iv_ruleEventValue= ruleEventValue EOF ;
    public final EObject entryRuleEventValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventValue = null;


        try {
            // InternalRoQME.g:2803:51: (iv_ruleEventValue= ruleEventValue EOF )
            // InternalRoQME.g:2804:2: iv_ruleEventValue= ruleEventValue EOF
            {
             newCompositeNode(grammarAccess.getEventValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEventValue=ruleEventValue();

            state._fsp--;

             current =iv_ruleEventValue; 
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
    // $ANTLR end "entryRuleEventValue"


    // $ANTLR start "ruleEventValue"
    // InternalRoQME.g:2810:1: ruleEventValue returns [EObject current=null] : ( () otherlv_1= 'event' ) ;
    public final EObject ruleEventValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRoQME.g:2816:2: ( ( () otherlv_1= 'event' ) )
            // InternalRoQME.g:2817:2: ( () otherlv_1= 'event' )
            {
            // InternalRoQME.g:2817:2: ( () otherlv_1= 'event' )
            // InternalRoQME.g:2818:3: () otherlv_1= 'event'
            {
            // InternalRoQME.g:2818:3: ()
            // InternalRoQME.g:2819:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEventValueAccess().getEventValueAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,48,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getEventValueAccess().getEventKeyword_1());
            		

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
    // $ANTLR end "ruleEventValue"


    // $ANTLR start "entryRuleBooleanValue"
    // InternalRoQME.g:2833:1: entryRuleBooleanValue returns [EObject current=null] : iv_ruleBooleanValue= ruleBooleanValue EOF ;
    public final EObject entryRuleBooleanValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanValue = null;


        try {
            // InternalRoQME.g:2833:53: (iv_ruleBooleanValue= ruleBooleanValue EOF )
            // InternalRoQME.g:2834:2: iv_ruleBooleanValue= ruleBooleanValue EOF
            {
             newCompositeNode(grammarAccess.getBooleanValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanValue=ruleBooleanValue();

            state._fsp--;

             current =iv_ruleBooleanValue; 
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
    // $ANTLR end "entryRuleBooleanValue"


    // $ANTLR start "ruleBooleanValue"
    // InternalRoQME.g:2840:1: ruleBooleanValue returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEBoolean ) ) ) ;
    public final EObject ruleBooleanValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:2846:2: ( ( () ( (lv_value_1_0= ruleEBoolean ) ) ) )
            // InternalRoQME.g:2847:2: ( () ( (lv_value_1_0= ruleEBoolean ) ) )
            {
            // InternalRoQME.g:2847:2: ( () ( (lv_value_1_0= ruleEBoolean ) ) )
            // InternalRoQME.g:2848:3: () ( (lv_value_1_0= ruleEBoolean ) )
            {
            // InternalRoQME.g:2848:3: ()
            // InternalRoQME.g:2849:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanValueAccess().getBooleanValueAction_0(),
            					current);
            			

            }

            // InternalRoQME.g:2855:3: ( (lv_value_1_0= ruleEBoolean ) )
            // InternalRoQME.g:2856:4: (lv_value_1_0= ruleEBoolean )
            {
            // InternalRoQME.g:2856:4: (lv_value_1_0= ruleEBoolean )
            // InternalRoQME.g:2857:5: lv_value_1_0= ruleEBoolean
            {

            					newCompositeNode(grammarAccess.getBooleanValueAccess().getValueEBooleanParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleEBoolean();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBooleanValueRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.xtext.roqme.RoQME.EBoolean");
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
    // $ANTLR end "ruleBooleanValue"


    // $ANTLR start "entryRuleEnumValue"
    // InternalRoQME.g:2878:1: entryRuleEnumValue returns [EObject current=null] : iv_ruleEnumValue= ruleEnumValue EOF ;
    public final EObject entryRuleEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumValue = null;


        try {
            // InternalRoQME.g:2878:50: (iv_ruleEnumValue= ruleEnumValue EOF )
            // InternalRoQME.g:2879:2: iv_ruleEnumValue= ruleEnumValue EOF
            {
             newCompositeNode(grammarAccess.getEnumValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumValue=ruleEnumValue();

            state._fsp--;

             current =iv_ruleEnumValue; 
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
    // $ANTLR end "entryRuleEnumValue"


    // $ANTLR start "ruleEnumValue"
    // InternalRoQME.g:2885:1: ruleEnumValue returns [EObject current=null] : ( () ( ( ruleLiteralQualifiedName ) ) ) ;
    public final EObject ruleEnumValue() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalRoQME.g:2891:2: ( ( () ( ( ruleLiteralQualifiedName ) ) ) )
            // InternalRoQME.g:2892:2: ( () ( ( ruleLiteralQualifiedName ) ) )
            {
            // InternalRoQME.g:2892:2: ( () ( ( ruleLiteralQualifiedName ) ) )
            // InternalRoQME.g:2893:3: () ( ( ruleLiteralQualifiedName ) )
            {
            // InternalRoQME.g:2893:3: ()
            // InternalRoQME.g:2894:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getEnumValueAccess().getEnumValueAction_0(),
            					current);
            			

            }

            // InternalRoQME.g:2900:3: ( ( ruleLiteralQualifiedName ) )
            // InternalRoQME.g:2901:4: ( ruleLiteralQualifiedName )
            {
            // InternalRoQME.g:2901:4: ( ruleLiteralQualifiedName )
            // InternalRoQME.g:2902:5: ruleLiteralQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEnumValueAccess().getValueEnumLiteralCrossReference_1_0());
            				
            pushFollow(FOLLOW_2);
            ruleLiteralQualifiedName();

            state._fsp--;


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
    // $ANTLR end "ruleEnumValue"


    // $ANTLR start "entryRuleNumericValue"
    // InternalRoQME.g:2920:1: entryRuleNumericValue returns [EObject current=null] : iv_ruleNumericValue= ruleNumericValue EOF ;
    public final EObject entryRuleNumericValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericValue = null;


        try {
            // InternalRoQME.g:2920:53: (iv_ruleNumericValue= ruleNumericValue EOF )
            // InternalRoQME.g:2921:2: iv_ruleNumericValue= ruleNumericValue EOF
            {
             newCompositeNode(grammarAccess.getNumericValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericValue=ruleNumericValue();

            state._fsp--;

             current =iv_ruleNumericValue; 
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
    // $ANTLR end "entryRuleNumericValue"


    // $ANTLR start "ruleNumericValue"
    // InternalRoQME.g:2927:1: ruleNumericValue returns [EObject current=null] : (this_NumericValue_Impl_0= ruleNumericValue_Impl | this_UnitMeasuredValue_1= ruleUnitMeasuredValue ) ;
    public final EObject ruleNumericValue() throws RecognitionException {
        EObject current = null;

        EObject this_NumericValue_Impl_0 = null;

        EObject this_UnitMeasuredValue_1 = null;



        	enterRule();

        try {
            // InternalRoQME.g:2933:2: ( (this_NumericValue_Impl_0= ruleNumericValue_Impl | this_UnitMeasuredValue_1= ruleUnitMeasuredValue ) )
            // InternalRoQME.g:2934:2: (this_NumericValue_Impl_0= ruleNumericValue_Impl | this_UnitMeasuredValue_1= ruleUnitMeasuredValue )
            {
            // InternalRoQME.g:2934:2: (this_NumericValue_Impl_0= ruleNumericValue_Impl | this_UnitMeasuredValue_1= ruleUnitMeasuredValue )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==80) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==RULE_INT) ) {
                    switch ( input.LA(3) ) {
                    case 86:
                        {
                        int LA38_3 = input.LA(4);

                        if ( (LA38_3==RULE_INT) ) {
                            int LA38_6 = input.LA(5);

                            if ( (LA38_6==EOF||LA38_6==RULE_ROQME_DESCRIPTION||(LA38_6>=13 && LA38_6<=17)||(LA38_6>=19 && LA38_6<=26)||(LA38_6>=28 && LA38_6<=36)||LA38_6==41||LA38_6==60||(LA38_6>=62 && LA38_6<=67)||(LA38_6>=69 && LA38_6<=71)||(LA38_6>=73 && LA38_6<=82)||(LA38_6>=90 && LA38_6<=91)) ) {
                                alt38=1;
                            }
                            else if ( (LA38_6==RULE_ID||LA38_6==RULE_STRING||(LA38_6>=49 && LA38_6<=58)) ) {
                                alt38=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 38, 6, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 38, 3, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_ID:
                    case RULE_STRING:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                        {
                        alt38=2;
                        }
                        break;
                    case EOF:
                    case RULE_ROQME_DESCRIPTION:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 41:
                    case 60:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 69:
                    case 70:
                    case 71:
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                    case 79:
                    case 80:
                    case 81:
                    case 82:
                    case 90:
                    case 91:
                        {
                        alt38=1;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 2, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA38_0==RULE_INT) ) {
                switch ( input.LA(2) ) {
                case 86:
                    {
                    int LA38_3 = input.LA(3);

                    if ( (LA38_3==RULE_INT) ) {
                        int LA38_6 = input.LA(4);

                        if ( (LA38_6==EOF||LA38_6==RULE_ROQME_DESCRIPTION||(LA38_6>=13 && LA38_6<=17)||(LA38_6>=19 && LA38_6<=26)||(LA38_6>=28 && LA38_6<=36)||LA38_6==41||LA38_6==60||(LA38_6>=62 && LA38_6<=67)||(LA38_6>=69 && LA38_6<=71)||(LA38_6>=73 && LA38_6<=82)||(LA38_6>=90 && LA38_6<=91)) ) {
                            alt38=1;
                        }
                        else if ( (LA38_6==RULE_ID||LA38_6==RULE_STRING||(LA38_6>=49 && LA38_6<=58)) ) {
                            alt38=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 38, 6, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case RULE_ID:
                case RULE_STRING:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                    {
                    alt38=2;
                    }
                    break;
                case EOF:
                case RULE_ROQME_DESCRIPTION:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 41:
                case 60:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 69:
                case 70:
                case 71:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 90:
                case 91:
                    {
                    alt38=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 2, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalRoQME.g:2935:3: this_NumericValue_Impl_0= ruleNumericValue_Impl
                    {

                    			newCompositeNode(grammarAccess.getNumericValueAccess().getNumericValue_ImplParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumericValue_Impl_0=ruleNumericValue_Impl();

                    state._fsp--;


                    			current = this_NumericValue_Impl_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:2944:3: this_UnitMeasuredValue_1= ruleUnitMeasuredValue
                    {

                    			newCompositeNode(grammarAccess.getNumericValueAccess().getUnitMeasuredValueParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnitMeasuredValue_1=ruleUnitMeasuredValue();

                    state._fsp--;


                    			current = this_UnitMeasuredValue_1;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleNumericValue"


    // $ANTLR start "entryRuleUnitMeasuredValue"
    // InternalRoQME.g:2956:1: entryRuleUnitMeasuredValue returns [EObject current=null] : iv_ruleUnitMeasuredValue= ruleUnitMeasuredValue EOF ;
    public final EObject entryRuleUnitMeasuredValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitMeasuredValue = null;


        try {
            // InternalRoQME.g:2956:58: (iv_ruleUnitMeasuredValue= ruleUnitMeasuredValue EOF )
            // InternalRoQME.g:2957:2: iv_ruleUnitMeasuredValue= ruleUnitMeasuredValue EOF
            {
             newCompositeNode(grammarAccess.getUnitMeasuredValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnitMeasuredValue=ruleUnitMeasuredValue();

            state._fsp--;

             current =iv_ruleUnitMeasuredValue; 
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
    // $ANTLR end "entryRuleUnitMeasuredValue"


    // $ANTLR start "ruleUnitMeasuredValue"
    // InternalRoQME.g:2963:1: ruleUnitMeasuredValue returns [EObject current=null] : (this_UnitMeasuredValue_Impl_0= ruleUnitMeasuredValue_Impl | this_TimeValue_1= ruleTimeValue ) ;
    public final EObject ruleUnitMeasuredValue() throws RecognitionException {
        EObject current = null;

        EObject this_UnitMeasuredValue_Impl_0 = null;

        EObject this_TimeValue_1 = null;



        	enterRule();

        try {
            // InternalRoQME.g:2969:2: ( (this_UnitMeasuredValue_Impl_0= ruleUnitMeasuredValue_Impl | this_TimeValue_1= ruleTimeValue ) )
            // InternalRoQME.g:2970:2: (this_UnitMeasuredValue_Impl_0= ruleUnitMeasuredValue_Impl | this_TimeValue_1= ruleTimeValue )
            {
            // InternalRoQME.g:2970:2: (this_UnitMeasuredValue_Impl_0= ruleUnitMeasuredValue_Impl | this_TimeValue_1= ruleTimeValue )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==80) ) {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==RULE_INT) ) {
                    switch ( input.LA(3) ) {
                    case 86:
                        {
                        int LA39_3 = input.LA(4);

                        if ( (LA39_3==RULE_INT) ) {
                            int LA39_6 = input.LA(5);

                            if ( (LA39_6==RULE_ID||LA39_6==RULE_STRING) ) {
                                alt39=1;
                            }
                            else if ( ((LA39_6>=49 && LA39_6<=58)) ) {
                                alt39=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 39, 6, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 39, 3, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                        {
                        alt39=2;
                        }
                        break;
                    case RULE_ID:
                    case RULE_STRING:
                        {
                        alt39=1;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 2, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA39_0==RULE_INT) ) {
                switch ( input.LA(2) ) {
                case 86:
                    {
                    int LA39_3 = input.LA(3);

                    if ( (LA39_3==RULE_INT) ) {
                        int LA39_6 = input.LA(4);

                        if ( (LA39_6==RULE_ID||LA39_6==RULE_STRING) ) {
                            alt39=1;
                        }
                        else if ( ((LA39_6>=49 && LA39_6<=58)) ) {
                            alt39=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 39, 6, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                    {
                    alt39=2;
                    }
                    break;
                case RULE_ID:
                case RULE_STRING:
                    {
                    alt39=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 2, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalRoQME.g:2971:3: this_UnitMeasuredValue_Impl_0= ruleUnitMeasuredValue_Impl
                    {

                    			newCompositeNode(grammarAccess.getUnitMeasuredValueAccess().getUnitMeasuredValue_ImplParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnitMeasuredValue_Impl_0=ruleUnitMeasuredValue_Impl();

                    state._fsp--;


                    			current = this_UnitMeasuredValue_Impl_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:2980:3: this_TimeValue_1= ruleTimeValue
                    {

                    			newCompositeNode(grammarAccess.getUnitMeasuredValueAccess().getTimeValueParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TimeValue_1=ruleTimeValue();

                    state._fsp--;


                    			current = this_TimeValue_1;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleUnitMeasuredValue"


    // $ANTLR start "entryRuleNumericValue_Impl"
    // InternalRoQME.g:2992:1: entryRuleNumericValue_Impl returns [EObject current=null] : iv_ruleNumericValue_Impl= ruleNumericValue_Impl EOF ;
    public final EObject entryRuleNumericValue_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericValue_Impl = null;


        try {
            // InternalRoQME.g:2992:58: (iv_ruleNumericValue_Impl= ruleNumericValue_Impl EOF )
            // InternalRoQME.g:2993:2: iv_ruleNumericValue_Impl= ruleNumericValue_Impl EOF
            {
             newCompositeNode(grammarAccess.getNumericValue_ImplRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericValue_Impl=ruleNumericValue_Impl();

            state._fsp--;

             current =iv_ruleNumericValue_Impl; 
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
    // $ANTLR end "entryRuleNumericValue_Impl"


    // $ANTLR start "ruleNumericValue_Impl"
    // InternalRoQME.g:2999:1: ruleNumericValue_Impl returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEDouble ) ) ) ;
    public final EObject ruleNumericValue_Impl() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:3005:2: ( ( () ( (lv_value_1_0= ruleEDouble ) ) ) )
            // InternalRoQME.g:3006:2: ( () ( (lv_value_1_0= ruleEDouble ) ) )
            {
            // InternalRoQME.g:3006:2: ( () ( (lv_value_1_0= ruleEDouble ) ) )
            // InternalRoQME.g:3007:3: () ( (lv_value_1_0= ruleEDouble ) )
            {
            // InternalRoQME.g:3007:3: ()
            // InternalRoQME.g:3008:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNumericValue_ImplAccess().getNumericValueAction_0(),
            					current);
            			

            }

            // InternalRoQME.g:3014:3: ( (lv_value_1_0= ruleEDouble ) )
            // InternalRoQME.g:3015:4: (lv_value_1_0= ruleEDouble )
            {
            // InternalRoQME.g:3015:4: (lv_value_1_0= ruleEDouble )
            // InternalRoQME.g:3016:5: lv_value_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getNumericValue_ImplAccess().getValueEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNumericValue_ImplRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.xtext.roqme.RoQME.EDouble");
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
    // $ANTLR end "ruleNumericValue_Impl"


    // $ANTLR start "entryRuleUnitMeasuredValue_Impl"
    // InternalRoQME.g:3037:1: entryRuleUnitMeasuredValue_Impl returns [EObject current=null] : iv_ruleUnitMeasuredValue_Impl= ruleUnitMeasuredValue_Impl EOF ;
    public final EObject entryRuleUnitMeasuredValue_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitMeasuredValue_Impl = null;


        try {
            // InternalRoQME.g:3037:63: (iv_ruleUnitMeasuredValue_Impl= ruleUnitMeasuredValue_Impl EOF )
            // InternalRoQME.g:3038:2: iv_ruleUnitMeasuredValue_Impl= ruleUnitMeasuredValue_Impl EOF
            {
             newCompositeNode(grammarAccess.getUnitMeasuredValue_ImplRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnitMeasuredValue_Impl=ruleUnitMeasuredValue_Impl();

            state._fsp--;

             current =iv_ruleUnitMeasuredValue_Impl; 
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
    // $ANTLR end "entryRuleUnitMeasuredValue_Impl"


    // $ANTLR start "ruleUnitMeasuredValue_Impl"
    // InternalRoQME.g:3044:1: ruleUnitMeasuredValue_Impl returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_unit_2_0= ruleEString ) ) ) ;
    public final EObject ruleUnitMeasuredValue_Impl() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;

        AntlrDatatypeRuleToken lv_unit_2_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:3050:2: ( ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_unit_2_0= ruleEString ) ) ) )
            // InternalRoQME.g:3051:2: ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_unit_2_0= ruleEString ) ) )
            {
            // InternalRoQME.g:3051:2: ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_unit_2_0= ruleEString ) ) )
            // InternalRoQME.g:3052:3: () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_unit_2_0= ruleEString ) )
            {
            // InternalRoQME.g:3052:3: ()
            // InternalRoQME.g:3053:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUnitMeasuredValue_ImplAccess().getUnitMeasuredValueAction_0(),
            					current);
            			

            }

            // InternalRoQME.g:3059:3: ( (lv_value_1_0= ruleEDouble ) )
            // InternalRoQME.g:3060:4: (lv_value_1_0= ruleEDouble )
            {
            // InternalRoQME.g:3060:4: (lv_value_1_0= ruleEDouble )
            // InternalRoQME.g:3061:5: lv_value_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getUnitMeasuredValue_ImplAccess().getValueEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_value_1_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnitMeasuredValue_ImplRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.xtext.roqme.RoQME.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoQME.g:3078:3: ( (lv_unit_2_0= ruleEString ) )
            // InternalRoQME.g:3079:4: (lv_unit_2_0= ruleEString )
            {
            // InternalRoQME.g:3079:4: (lv_unit_2_0= ruleEString )
            // InternalRoQME.g:3080:5: lv_unit_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getUnitMeasuredValue_ImplAccess().getUnitEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_unit_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnitMeasuredValue_ImplRule());
            					}
            					set(
            						current,
            						"unit",
            						lv_unit_2_0,
            						"org.xtext.roqme.RoQME.EString");
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
    // $ANTLR end "ruleUnitMeasuredValue_Impl"


    // $ANTLR start "entryRuleTimeValue"
    // InternalRoQME.g:3101:1: entryRuleTimeValue returns [EObject current=null] : iv_ruleTimeValue= ruleTimeValue EOF ;
    public final EObject entryRuleTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeValue = null;


        try {
            // InternalRoQME.g:3101:50: (iv_ruleTimeValue= ruleTimeValue EOF )
            // InternalRoQME.g:3102:2: iv_ruleTimeValue= ruleTimeValue EOF
            {
             newCompositeNode(grammarAccess.getTimeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeValue=ruleTimeValue();

            state._fsp--;

             current =iv_ruleTimeValue; 
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
    // $ANTLR end "entryRuleTimeValue"


    // $ANTLR start "ruleTimeValue"
    // InternalRoQME.g:3108:1: ruleTimeValue returns [EObject current=null] : ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_unit_2_0= ruleTimeUnitEnum ) ) ) ;
    public final EObject ruleTimeValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;

        AntlrDatatypeRuleToken lv_unit_2_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:3114:2: ( ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_unit_2_0= ruleTimeUnitEnum ) ) ) )
            // InternalRoQME.g:3115:2: ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_unit_2_0= ruleTimeUnitEnum ) ) )
            {
            // InternalRoQME.g:3115:2: ( () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_unit_2_0= ruleTimeUnitEnum ) ) )
            // InternalRoQME.g:3116:3: () ( (lv_value_1_0= ruleEDouble ) ) ( (lv_unit_2_0= ruleTimeUnitEnum ) )
            {
            // InternalRoQME.g:3116:3: ()
            // InternalRoQME.g:3117:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTimeValueAccess().getTimeValueAction_0(),
            					current);
            			

            }

            // InternalRoQME.g:3123:3: ( (lv_value_1_0= ruleEDouble ) )
            // InternalRoQME.g:3124:4: (lv_value_1_0= ruleEDouble )
            {
            // InternalRoQME.g:3124:4: (lv_value_1_0= ruleEDouble )
            // InternalRoQME.g:3125:5: lv_value_1_0= ruleEDouble
            {

            					newCompositeNode(grammarAccess.getTimeValueAccess().getValueEDoubleParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_40);
            lv_value_1_0=ruleEDouble();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTimeValueRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.xtext.roqme.RoQME.EDouble");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoQME.g:3142:3: ( (lv_unit_2_0= ruleTimeUnitEnum ) )
            // InternalRoQME.g:3143:4: (lv_unit_2_0= ruleTimeUnitEnum )
            {
            // InternalRoQME.g:3143:4: (lv_unit_2_0= ruleTimeUnitEnum )
            // InternalRoQME.g:3144:5: lv_unit_2_0= ruleTimeUnitEnum
            {

            					newCompositeNode(grammarAccess.getTimeValueAccess().getUnitTimeUnitEnumParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_unit_2_0=ruleTimeUnitEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTimeValueRule());
            					}
            					set(
            						current,
            						"unit",
            						lv_unit_2_0,
            						"org.xtext.roqme.RoQME.TimeUnitEnum");
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
    // $ANTLR end "ruleTimeValue"


    // $ANTLR start "entryRuleTimeUnitEnum"
    // InternalRoQME.g:3165:1: entryRuleTimeUnitEnum returns [String current=null] : iv_ruleTimeUnitEnum= ruleTimeUnitEnum EOF ;
    public final String entryRuleTimeUnitEnum() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTimeUnitEnum = null;


        try {
            // InternalRoQME.g:3165:52: (iv_ruleTimeUnitEnum= ruleTimeUnitEnum EOF )
            // InternalRoQME.g:3166:2: iv_ruleTimeUnitEnum= ruleTimeUnitEnum EOF
            {
             newCompositeNode(grammarAccess.getTimeUnitEnumRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeUnitEnum=ruleTimeUnitEnum();

            state._fsp--;

             current =iv_ruleTimeUnitEnum.getText(); 
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
    // $ANTLR end "entryRuleTimeUnitEnum"


    // $ANTLR start "ruleTimeUnitEnum"
    // InternalRoQME.g:3172:1: ruleTimeUnitEnum returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'milliseconds' | kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'millisecond' | kw= 'second' | kw= 'minute' | kw= 'hour' | kw= 'day' ) ;
    public final AntlrDatatypeRuleToken ruleTimeUnitEnum() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRoQME.g:3178:2: ( (kw= 'milliseconds' | kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'millisecond' | kw= 'second' | kw= 'minute' | kw= 'hour' | kw= 'day' ) )
            // InternalRoQME.g:3179:2: (kw= 'milliseconds' | kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'millisecond' | kw= 'second' | kw= 'minute' | kw= 'hour' | kw= 'day' )
            {
            // InternalRoQME.g:3179:2: (kw= 'milliseconds' | kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'millisecond' | kw= 'second' | kw= 'minute' | kw= 'hour' | kw= 'day' )
            int alt40=10;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt40=1;
                }
                break;
            case 50:
                {
                alt40=2;
                }
                break;
            case 51:
                {
                alt40=3;
                }
                break;
            case 52:
                {
                alt40=4;
                }
                break;
            case 53:
                {
                alt40=5;
                }
                break;
            case 54:
                {
                alt40=6;
                }
                break;
            case 55:
                {
                alt40=7;
                }
                break;
            case 56:
                {
                alt40=8;
                }
                break;
            case 57:
                {
                alt40=9;
                }
                break;
            case 58:
                {
                alt40=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalRoQME.g:3180:3: kw= 'milliseconds'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getMillisecondsKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:3186:3: kw= 'seconds'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getSecondsKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRoQME.g:3192:3: kw= 'minutes'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getMinutesKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRoQME.g:3198:3: kw= 'hours'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getHoursKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRoQME.g:3204:3: kw= 'days'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getDaysKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRoQME.g:3210:3: kw= 'millisecond'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getMillisecondKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRoQME.g:3216:3: kw= 'second'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getSecondKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalRoQME.g:3222:3: kw= 'minute'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getMinuteKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalRoQME.g:3228:3: kw= 'hour'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getHourKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalRoQME.g:3234:3: kw= 'day'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitEnumAccess().getDayKeyword_9());
                    		

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
    // $ANTLR end "ruleTimeUnitEnum"


    // $ANTLR start "entryRuleArrayValue"
    // InternalRoQME.g:3243:1: entryRuleArrayValue returns [EObject current=null] : iv_ruleArrayValue= ruleArrayValue EOF ;
    public final EObject entryRuleArrayValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayValue = null;


        try {
            // InternalRoQME.g:3243:51: (iv_ruleArrayValue= ruleArrayValue EOF )
            // InternalRoQME.g:3244:2: iv_ruleArrayValue= ruleArrayValue EOF
            {
             newCompositeNode(grammarAccess.getArrayValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArrayValue=ruleArrayValue();

            state._fsp--;

             current =iv_ruleArrayValue; 
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
    // $ANTLR end "entryRuleArrayValue"


    // $ANTLR start "ruleArrayValue"
    // InternalRoQME.g:3250:1: ruleArrayValue returns [EObject current=null] : (this_NumericArray_0= ruleNumericArray | this_BooleanArray_1= ruleBooleanArray | this_EnumArray_2= ruleEnumArray ) ;
    public final EObject ruleArrayValue() throws RecognitionException {
        EObject current = null;

        EObject this_NumericArray_0 = null;

        EObject this_BooleanArray_1 = null;

        EObject this_EnumArray_2 = null;



        	enterRule();

        try {
            // InternalRoQME.g:3256:2: ( (this_NumericArray_0= ruleNumericArray | this_BooleanArray_1= ruleBooleanArray | this_EnumArray_2= ruleEnumArray ) )
            // InternalRoQME.g:3257:2: (this_NumericArray_0= ruleNumericArray | this_BooleanArray_1= ruleBooleanArray | this_EnumArray_2= ruleEnumArray )
            {
            // InternalRoQME.g:3257:2: (this_NumericArray_0= ruleNumericArray | this_BooleanArray_1= ruleBooleanArray | this_EnumArray_2= ruleEnumArray )
            int alt41=3;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==38) ) {
                switch ( input.LA(2) ) {
                case RULE_INT:
                case 80:
                    {
                    alt41=1;
                    }
                    break;
                case 87:
                case 88:
                    {
                    alt41=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt41=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalRoQME.g:3258:3: this_NumericArray_0= ruleNumericArray
                    {

                    			newCompositeNode(grammarAccess.getArrayValueAccess().getNumericArrayParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumericArray_0=ruleNumericArray();

                    state._fsp--;


                    			current = this_NumericArray_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:3267:3: this_BooleanArray_1= ruleBooleanArray
                    {

                    			newCompositeNode(grammarAccess.getArrayValueAccess().getBooleanArrayParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanArray_1=ruleBooleanArray();

                    state._fsp--;


                    			current = this_BooleanArray_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRoQME.g:3276:3: this_EnumArray_2= ruleEnumArray
                    {

                    			newCompositeNode(grammarAccess.getArrayValueAccess().getEnumArrayParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_EnumArray_2=ruleEnumArray();

                    state._fsp--;


                    			current = this_EnumArray_2;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleArrayValue"


    // $ANTLR start "entryRuleBooleanArray"
    // InternalRoQME.g:3288:1: entryRuleBooleanArray returns [EObject current=null] : iv_ruleBooleanArray= ruleBooleanArray EOF ;
    public final EObject entryRuleBooleanArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanArray = null;


        try {
            // InternalRoQME.g:3288:53: (iv_ruleBooleanArray= ruleBooleanArray EOF )
            // InternalRoQME.g:3289:2: iv_ruleBooleanArray= ruleBooleanArray EOF
            {
             newCompositeNode(grammarAccess.getBooleanArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanArray=ruleBooleanArray();

            state._fsp--;

             current =iv_ruleBooleanArray; 
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
    // $ANTLR end "entryRuleBooleanArray"


    // $ANTLR start "ruleBooleanArray"
    // InternalRoQME.g:3295:1: ruleBooleanArray returns [EObject current=null] : (otherlv_0= '[' ( (lv_values_1_0= ruleBooleanValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleBooleanValue ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleBooleanArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:3301:2: ( (otherlv_0= '[' ( (lv_values_1_0= ruleBooleanValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleBooleanValue ) ) )* otherlv_4= ']' ) )
            // InternalRoQME.g:3302:2: (otherlv_0= '[' ( (lv_values_1_0= ruleBooleanValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleBooleanValue ) ) )* otherlv_4= ']' )
            {
            // InternalRoQME.g:3302:2: (otherlv_0= '[' ( (lv_values_1_0= ruleBooleanValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleBooleanValue ) ) )* otherlv_4= ']' )
            // InternalRoQME.g:3303:3: otherlv_0= '[' ( (lv_values_1_0= ruleBooleanValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleBooleanValue ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_41); 

            			newLeafNode(otherlv_0, grammarAccess.getBooleanArrayAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalRoQME.g:3307:3: ( (lv_values_1_0= ruleBooleanValue ) )
            // InternalRoQME.g:3308:4: (lv_values_1_0= ruleBooleanValue )
            {
            // InternalRoQME.g:3308:4: (lv_values_1_0= ruleBooleanValue )
            // InternalRoQME.g:3309:5: lv_values_1_0= ruleBooleanValue
            {

            					newCompositeNode(grammarAccess.getBooleanArrayAccess().getValuesBooleanValueParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_42);
            lv_values_1_0=ruleBooleanValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBooleanArrayRule());
            					}
            					add(
            						current,
            						"values",
            						lv_values_1_0,
            						"org.xtext.roqme.RoQME.BooleanValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoQME.g:3326:3: (otherlv_2= ',' ( (lv_values_3_0= ruleBooleanValue ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==41) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalRoQME.g:3327:4: otherlv_2= ',' ( (lv_values_3_0= ruleBooleanValue ) )
            	    {
            	    otherlv_2=(Token)match(input,41,FOLLOW_41); 

            	    				newLeafNode(otherlv_2, grammarAccess.getBooleanArrayAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalRoQME.g:3331:4: ( (lv_values_3_0= ruleBooleanValue ) )
            	    // InternalRoQME.g:3332:5: (lv_values_3_0= ruleBooleanValue )
            	    {
            	    // InternalRoQME.g:3332:5: (lv_values_3_0= ruleBooleanValue )
            	    // InternalRoQME.g:3333:6: lv_values_3_0= ruleBooleanValue
            	    {

            	    						newCompositeNode(grammarAccess.getBooleanArrayAccess().getValuesBooleanValueParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_42);
            	    lv_values_3_0=ruleBooleanValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBooleanArrayRule());
            	    						}
            	    						add(
            	    							current,
            	    							"values",
            	    							lv_values_3_0,
            	    							"org.xtext.roqme.RoQME.BooleanValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            otherlv_4=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getBooleanArrayAccess().getRightSquareBracketKeyword_3());
            		

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
    // $ANTLR end "ruleBooleanArray"


    // $ANTLR start "entryRuleEnumArray"
    // InternalRoQME.g:3359:1: entryRuleEnumArray returns [EObject current=null] : iv_ruleEnumArray= ruleEnumArray EOF ;
    public final EObject entryRuleEnumArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumArray = null;


        try {
            // InternalRoQME.g:3359:50: (iv_ruleEnumArray= ruleEnumArray EOF )
            // InternalRoQME.g:3360:2: iv_ruleEnumArray= ruleEnumArray EOF
            {
             newCompositeNode(grammarAccess.getEnumArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumArray=ruleEnumArray();

            state._fsp--;

             current =iv_ruleEnumArray; 
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
    // $ANTLR end "entryRuleEnumArray"


    // $ANTLR start "ruleEnumArray"
    // InternalRoQME.g:3366:1: ruleEnumArray returns [EObject current=null] : (otherlv_0= '[' ( (lv_values_1_0= ruleEnumValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleEnumValue ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleEnumArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:3372:2: ( (otherlv_0= '[' ( (lv_values_1_0= ruleEnumValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleEnumValue ) ) )* otherlv_4= ']' ) )
            // InternalRoQME.g:3373:2: (otherlv_0= '[' ( (lv_values_1_0= ruleEnumValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleEnumValue ) ) )* otherlv_4= ']' )
            {
            // InternalRoQME.g:3373:2: (otherlv_0= '[' ( (lv_values_1_0= ruleEnumValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleEnumValue ) ) )* otherlv_4= ']' )
            // InternalRoQME.g:3374:3: otherlv_0= '[' ( (lv_values_1_0= ruleEnumValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleEnumValue ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumArrayAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalRoQME.g:3378:3: ( (lv_values_1_0= ruleEnumValue ) )
            // InternalRoQME.g:3379:4: (lv_values_1_0= ruleEnumValue )
            {
            // InternalRoQME.g:3379:4: (lv_values_1_0= ruleEnumValue )
            // InternalRoQME.g:3380:5: lv_values_1_0= ruleEnumValue
            {

            					newCompositeNode(grammarAccess.getEnumArrayAccess().getValuesEnumValueParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_42);
            lv_values_1_0=ruleEnumValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEnumArrayRule());
            					}
            					add(
            						current,
            						"values",
            						lv_values_1_0,
            						"org.xtext.roqme.RoQME.EnumValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoQME.g:3397:3: (otherlv_2= ',' ( (lv_values_3_0= ruleEnumValue ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==41) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalRoQME.g:3398:4: otherlv_2= ',' ( (lv_values_3_0= ruleEnumValue ) )
            	    {
            	    otherlv_2=(Token)match(input,41,FOLLOW_8); 

            	    				newLeafNode(otherlv_2, grammarAccess.getEnumArrayAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalRoQME.g:3402:4: ( (lv_values_3_0= ruleEnumValue ) )
            	    // InternalRoQME.g:3403:5: (lv_values_3_0= ruleEnumValue )
            	    {
            	    // InternalRoQME.g:3403:5: (lv_values_3_0= ruleEnumValue )
            	    // InternalRoQME.g:3404:6: lv_values_3_0= ruleEnumValue
            	    {

            	    						newCompositeNode(grammarAccess.getEnumArrayAccess().getValuesEnumValueParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_42);
            	    lv_values_3_0=ruleEnumValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEnumArrayRule());
            	    						}
            	    						add(
            	    							current,
            	    							"values",
            	    							lv_values_3_0,
            	    							"org.xtext.roqme.RoQME.EnumValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            otherlv_4=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getEnumArrayAccess().getRightSquareBracketKeyword_3());
            		

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
    // $ANTLR end "ruleEnumArray"


    // $ANTLR start "entryRuleNumericArray"
    // InternalRoQME.g:3430:1: entryRuleNumericArray returns [EObject current=null] : iv_ruleNumericArray= ruleNumericArray EOF ;
    public final EObject entryRuleNumericArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericArray = null;


        try {
            // InternalRoQME.g:3430:53: (iv_ruleNumericArray= ruleNumericArray EOF )
            // InternalRoQME.g:3431:2: iv_ruleNumericArray= ruleNumericArray EOF
            {
             newCompositeNode(grammarAccess.getNumericArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericArray=ruleNumericArray();

            state._fsp--;

             current =iv_ruleNumericArray; 
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
    // $ANTLR end "entryRuleNumericArray"


    // $ANTLR start "ruleNumericArray"
    // InternalRoQME.g:3437:1: ruleNumericArray returns [EObject current=null] : (this_NumericArray_Impl_0= ruleNumericArray_Impl | this_UnitMeasuredArray_1= ruleUnitMeasuredArray ) ;
    public final EObject ruleNumericArray() throws RecognitionException {
        EObject current = null;

        EObject this_NumericArray_Impl_0 = null;

        EObject this_UnitMeasuredArray_1 = null;



        	enterRule();

        try {
            // InternalRoQME.g:3443:2: ( (this_NumericArray_Impl_0= ruleNumericArray_Impl | this_UnitMeasuredArray_1= ruleUnitMeasuredArray ) )
            // InternalRoQME.g:3444:2: (this_NumericArray_Impl_0= ruleNumericArray_Impl | this_UnitMeasuredArray_1= ruleUnitMeasuredArray )
            {
            // InternalRoQME.g:3444:2: (this_NumericArray_Impl_0= ruleNumericArray_Impl | this_UnitMeasuredArray_1= ruleUnitMeasuredArray )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==38) ) {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==80) ) {
                    int LA44_2 = input.LA(3);

                    if ( (LA44_2==RULE_INT) ) {
                        switch ( input.LA(4) ) {
                        case 86:
                            {
                            int LA44_4 = input.LA(5);

                            if ( (LA44_4==RULE_INT) ) {
                                int LA44_7 = input.LA(6);

                                if ( (LA44_7==RULE_ID||LA44_7==RULE_STRING||(LA44_7>=49 && LA44_7<=58)) ) {
                                    alt44=2;
                                }
                                else if ( (LA44_7==39||LA44_7==41) ) {
                                    alt44=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 44, 7, input);

                                    throw nvae;
                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 44, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                            {
                            alt44=2;
                            }
                            break;
                        case 39:
                        case 41:
                            {
                            alt44=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 44, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA44_1==RULE_INT) ) {
                    switch ( input.LA(3) ) {
                    case 86:
                        {
                        int LA44_4 = input.LA(4);

                        if ( (LA44_4==RULE_INT) ) {
                            int LA44_7 = input.LA(5);

                            if ( (LA44_7==RULE_ID||LA44_7==RULE_STRING||(LA44_7>=49 && LA44_7<=58)) ) {
                                alt44=2;
                            }
                            else if ( (LA44_7==39||LA44_7==41) ) {
                                alt44=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 44, 7, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 44, 4, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_ID:
                    case RULE_STRING:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                        {
                        alt44=2;
                        }
                        break;
                    case 39:
                    case 41:
                        {
                        alt44=1;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 3, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // InternalRoQME.g:3445:3: this_NumericArray_Impl_0= ruleNumericArray_Impl
                    {

                    			newCompositeNode(grammarAccess.getNumericArrayAccess().getNumericArray_ImplParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumericArray_Impl_0=ruleNumericArray_Impl();

                    state._fsp--;


                    			current = this_NumericArray_Impl_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:3454:3: this_UnitMeasuredArray_1= ruleUnitMeasuredArray
                    {

                    			newCompositeNode(grammarAccess.getNumericArrayAccess().getUnitMeasuredArrayParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnitMeasuredArray_1=ruleUnitMeasuredArray();

                    state._fsp--;


                    			current = this_UnitMeasuredArray_1;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleNumericArray"


    // $ANTLR start "entryRuleUnitMeasuredArray"
    // InternalRoQME.g:3466:1: entryRuleUnitMeasuredArray returns [EObject current=null] : iv_ruleUnitMeasuredArray= ruleUnitMeasuredArray EOF ;
    public final EObject entryRuleUnitMeasuredArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitMeasuredArray = null;


        try {
            // InternalRoQME.g:3466:58: (iv_ruleUnitMeasuredArray= ruleUnitMeasuredArray EOF )
            // InternalRoQME.g:3467:2: iv_ruleUnitMeasuredArray= ruleUnitMeasuredArray EOF
            {
             newCompositeNode(grammarAccess.getUnitMeasuredArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnitMeasuredArray=ruleUnitMeasuredArray();

            state._fsp--;

             current =iv_ruleUnitMeasuredArray; 
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
    // $ANTLR end "entryRuleUnitMeasuredArray"


    // $ANTLR start "ruleUnitMeasuredArray"
    // InternalRoQME.g:3473:1: ruleUnitMeasuredArray returns [EObject current=null] : (this_UnitMeasuredArray_Impl_0= ruleUnitMeasuredArray_Impl | this_TimeArray_1= ruleTimeArray ) ;
    public final EObject ruleUnitMeasuredArray() throws RecognitionException {
        EObject current = null;

        EObject this_UnitMeasuredArray_Impl_0 = null;

        EObject this_TimeArray_1 = null;



        	enterRule();

        try {
            // InternalRoQME.g:3479:2: ( (this_UnitMeasuredArray_Impl_0= ruleUnitMeasuredArray_Impl | this_TimeArray_1= ruleTimeArray ) )
            // InternalRoQME.g:3480:2: (this_UnitMeasuredArray_Impl_0= ruleUnitMeasuredArray_Impl | this_TimeArray_1= ruleTimeArray )
            {
            // InternalRoQME.g:3480:2: (this_UnitMeasuredArray_Impl_0= ruleUnitMeasuredArray_Impl | this_TimeArray_1= ruleTimeArray )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==38) ) {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==80) ) {
                    int LA45_2 = input.LA(3);

                    if ( (LA45_2==RULE_INT) ) {
                        switch ( input.LA(4) ) {
                        case 86:
                            {
                            int LA45_4 = input.LA(5);

                            if ( (LA45_4==RULE_INT) ) {
                                int LA45_7 = input.LA(6);

                                if ( (LA45_7==RULE_ID||LA45_7==RULE_STRING) ) {
                                    alt45=1;
                                }
                                else if ( ((LA45_7>=49 && LA45_7<=58)) ) {
                                    alt45=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 45, 7, input);

                                    throw nvae;
                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 45, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                            {
                            alt45=2;
                            }
                            break;
                        case RULE_ID:
                        case RULE_STRING:
                            {
                            alt45=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 45, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA45_1==RULE_INT) ) {
                    switch ( input.LA(3) ) {
                    case 86:
                        {
                        int LA45_4 = input.LA(4);

                        if ( (LA45_4==RULE_INT) ) {
                            int LA45_7 = input.LA(5);

                            if ( (LA45_7==RULE_ID||LA45_7==RULE_STRING) ) {
                                alt45=1;
                            }
                            else if ( ((LA45_7>=49 && LA45_7<=58)) ) {
                                alt45=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 45, 7, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 45, 4, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                        {
                        alt45=2;
                        }
                        break;
                    case RULE_ID:
                    case RULE_STRING:
                        {
                        alt45=1;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 3, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalRoQME.g:3481:3: this_UnitMeasuredArray_Impl_0= ruleUnitMeasuredArray_Impl
                    {

                    			newCompositeNode(grammarAccess.getUnitMeasuredArrayAccess().getUnitMeasuredArray_ImplParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnitMeasuredArray_Impl_0=ruleUnitMeasuredArray_Impl();

                    state._fsp--;


                    			current = this_UnitMeasuredArray_Impl_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:3490:3: this_TimeArray_1= ruleTimeArray
                    {

                    			newCompositeNode(grammarAccess.getUnitMeasuredArrayAccess().getTimeArrayParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TimeArray_1=ruleTimeArray();

                    state._fsp--;


                    			current = this_TimeArray_1;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleUnitMeasuredArray"


    // $ANTLR start "entryRuleNumericArray_Impl"
    // InternalRoQME.g:3502:1: entryRuleNumericArray_Impl returns [EObject current=null] : iv_ruleNumericArray_Impl= ruleNumericArray_Impl EOF ;
    public final EObject entryRuleNumericArray_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericArray_Impl = null;


        try {
            // InternalRoQME.g:3502:58: (iv_ruleNumericArray_Impl= ruleNumericArray_Impl EOF )
            // InternalRoQME.g:3503:2: iv_ruleNumericArray_Impl= ruleNumericArray_Impl EOF
            {
             newCompositeNode(grammarAccess.getNumericArray_ImplRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericArray_Impl=ruleNumericArray_Impl();

            state._fsp--;

             current =iv_ruleNumericArray_Impl; 
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
    // $ANTLR end "entryRuleNumericArray_Impl"


    // $ANTLR start "ruleNumericArray_Impl"
    // InternalRoQME.g:3509:1: ruleNumericArray_Impl returns [EObject current=null] : (otherlv_0= '[' ( (lv_values_1_0= ruleNumericValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleNumericValue_Impl ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleNumericArray_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:3515:2: ( (otherlv_0= '[' ( (lv_values_1_0= ruleNumericValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleNumericValue_Impl ) ) )* otherlv_4= ']' ) )
            // InternalRoQME.g:3516:2: (otherlv_0= '[' ( (lv_values_1_0= ruleNumericValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleNumericValue_Impl ) ) )* otherlv_4= ']' )
            {
            // InternalRoQME.g:3516:2: (otherlv_0= '[' ( (lv_values_1_0= ruleNumericValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleNumericValue_Impl ) ) )* otherlv_4= ']' )
            // InternalRoQME.g:3517:3: otherlv_0= '[' ( (lv_values_1_0= ruleNumericValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleNumericValue_Impl ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getNumericArray_ImplAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalRoQME.g:3521:3: ( (lv_values_1_0= ruleNumericValue_Impl ) )
            // InternalRoQME.g:3522:4: (lv_values_1_0= ruleNumericValue_Impl )
            {
            // InternalRoQME.g:3522:4: (lv_values_1_0= ruleNumericValue_Impl )
            // InternalRoQME.g:3523:5: lv_values_1_0= ruleNumericValue_Impl
            {

            					newCompositeNode(grammarAccess.getNumericArray_ImplAccess().getValuesNumericValue_ImplParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_42);
            lv_values_1_0=ruleNumericValue_Impl();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNumericArray_ImplRule());
            					}
            					add(
            						current,
            						"values",
            						lv_values_1_0,
            						"org.xtext.roqme.RoQME.NumericValue_Impl");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoQME.g:3540:3: (otherlv_2= ',' ( (lv_values_3_0= ruleNumericValue_Impl ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==41) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalRoQME.g:3541:4: otherlv_2= ',' ( (lv_values_3_0= ruleNumericValue_Impl ) )
            	    {
            	    otherlv_2=(Token)match(input,41,FOLLOW_17); 

            	    				newLeafNode(otherlv_2, grammarAccess.getNumericArray_ImplAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalRoQME.g:3545:4: ( (lv_values_3_0= ruleNumericValue_Impl ) )
            	    // InternalRoQME.g:3546:5: (lv_values_3_0= ruleNumericValue_Impl )
            	    {
            	    // InternalRoQME.g:3546:5: (lv_values_3_0= ruleNumericValue_Impl )
            	    // InternalRoQME.g:3547:6: lv_values_3_0= ruleNumericValue_Impl
            	    {

            	    						newCompositeNode(grammarAccess.getNumericArray_ImplAccess().getValuesNumericValue_ImplParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_42);
            	    lv_values_3_0=ruleNumericValue_Impl();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getNumericArray_ImplRule());
            	    						}
            	    						add(
            	    							current,
            	    							"values",
            	    							lv_values_3_0,
            	    							"org.xtext.roqme.RoQME.NumericValue_Impl");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            otherlv_4=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getNumericArray_ImplAccess().getRightSquareBracketKeyword_3());
            		

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
    // $ANTLR end "ruleNumericArray_Impl"


    // $ANTLR start "entryRuleUnitMeasuredArray_Impl"
    // InternalRoQME.g:3573:1: entryRuleUnitMeasuredArray_Impl returns [EObject current=null] : iv_ruleUnitMeasuredArray_Impl= ruleUnitMeasuredArray_Impl EOF ;
    public final EObject entryRuleUnitMeasuredArray_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitMeasuredArray_Impl = null;


        try {
            // InternalRoQME.g:3573:63: (iv_ruleUnitMeasuredArray_Impl= ruleUnitMeasuredArray_Impl EOF )
            // InternalRoQME.g:3574:2: iv_ruleUnitMeasuredArray_Impl= ruleUnitMeasuredArray_Impl EOF
            {
             newCompositeNode(grammarAccess.getUnitMeasuredArray_ImplRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnitMeasuredArray_Impl=ruleUnitMeasuredArray_Impl();

            state._fsp--;

             current =iv_ruleUnitMeasuredArray_Impl; 
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
    // $ANTLR end "entryRuleUnitMeasuredArray_Impl"


    // $ANTLR start "ruleUnitMeasuredArray_Impl"
    // InternalRoQME.g:3580:1: ruleUnitMeasuredArray_Impl returns [EObject current=null] : (otherlv_0= '[' ( (lv_values_1_0= ruleUnitMeasuredValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleUnitMeasuredValue_Impl ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleUnitMeasuredArray_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:3586:2: ( (otherlv_0= '[' ( (lv_values_1_0= ruleUnitMeasuredValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleUnitMeasuredValue_Impl ) ) )* otherlv_4= ']' ) )
            // InternalRoQME.g:3587:2: (otherlv_0= '[' ( (lv_values_1_0= ruleUnitMeasuredValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleUnitMeasuredValue_Impl ) ) )* otherlv_4= ']' )
            {
            // InternalRoQME.g:3587:2: (otherlv_0= '[' ( (lv_values_1_0= ruleUnitMeasuredValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleUnitMeasuredValue_Impl ) ) )* otherlv_4= ']' )
            // InternalRoQME.g:3588:3: otherlv_0= '[' ( (lv_values_1_0= ruleUnitMeasuredValue_Impl ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleUnitMeasuredValue_Impl ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getUnitMeasuredArray_ImplAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalRoQME.g:3592:3: ( (lv_values_1_0= ruleUnitMeasuredValue_Impl ) )
            // InternalRoQME.g:3593:4: (lv_values_1_0= ruleUnitMeasuredValue_Impl )
            {
            // InternalRoQME.g:3593:4: (lv_values_1_0= ruleUnitMeasuredValue_Impl )
            // InternalRoQME.g:3594:5: lv_values_1_0= ruleUnitMeasuredValue_Impl
            {

            					newCompositeNode(grammarAccess.getUnitMeasuredArray_ImplAccess().getValuesUnitMeasuredValue_ImplParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_42);
            lv_values_1_0=ruleUnitMeasuredValue_Impl();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnitMeasuredArray_ImplRule());
            					}
            					add(
            						current,
            						"values",
            						lv_values_1_0,
            						"org.xtext.roqme.RoQME.UnitMeasuredValue_Impl");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoQME.g:3611:3: (otherlv_2= ',' ( (lv_values_3_0= ruleUnitMeasuredValue_Impl ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==41) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalRoQME.g:3612:4: otherlv_2= ',' ( (lv_values_3_0= ruleUnitMeasuredValue_Impl ) )
            	    {
            	    otherlv_2=(Token)match(input,41,FOLLOW_17); 

            	    				newLeafNode(otherlv_2, grammarAccess.getUnitMeasuredArray_ImplAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalRoQME.g:3616:4: ( (lv_values_3_0= ruleUnitMeasuredValue_Impl ) )
            	    // InternalRoQME.g:3617:5: (lv_values_3_0= ruleUnitMeasuredValue_Impl )
            	    {
            	    // InternalRoQME.g:3617:5: (lv_values_3_0= ruleUnitMeasuredValue_Impl )
            	    // InternalRoQME.g:3618:6: lv_values_3_0= ruleUnitMeasuredValue_Impl
            	    {

            	    						newCompositeNode(grammarAccess.getUnitMeasuredArray_ImplAccess().getValuesUnitMeasuredValue_ImplParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_42);
            	    lv_values_3_0=ruleUnitMeasuredValue_Impl();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getUnitMeasuredArray_ImplRule());
            	    						}
            	    						add(
            	    							current,
            	    							"values",
            	    							lv_values_3_0,
            	    							"org.xtext.roqme.RoQME.UnitMeasuredValue_Impl");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            otherlv_4=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getUnitMeasuredArray_ImplAccess().getRightSquareBracketKeyword_3());
            		

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
    // $ANTLR end "ruleUnitMeasuredArray_Impl"


    // $ANTLR start "entryRuleTimeArray"
    // InternalRoQME.g:3644:1: entryRuleTimeArray returns [EObject current=null] : iv_ruleTimeArray= ruleTimeArray EOF ;
    public final EObject entryRuleTimeArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeArray = null;


        try {
            // InternalRoQME.g:3644:50: (iv_ruleTimeArray= ruleTimeArray EOF )
            // InternalRoQME.g:3645:2: iv_ruleTimeArray= ruleTimeArray EOF
            {
             newCompositeNode(grammarAccess.getTimeArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeArray=ruleTimeArray();

            state._fsp--;

             current =iv_ruleTimeArray; 
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
    // $ANTLR end "entryRuleTimeArray"


    // $ANTLR start "ruleTimeArray"
    // InternalRoQME.g:3651:1: ruleTimeArray returns [EObject current=null] : (otherlv_0= '[' ( (lv_values_1_0= ruleTimeValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleTimeValue ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleTimeArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_values_1_0 = null;

        EObject lv_values_3_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:3657:2: ( (otherlv_0= '[' ( (lv_values_1_0= ruleTimeValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleTimeValue ) ) )* otherlv_4= ']' ) )
            // InternalRoQME.g:3658:2: (otherlv_0= '[' ( (lv_values_1_0= ruleTimeValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleTimeValue ) ) )* otherlv_4= ']' )
            {
            // InternalRoQME.g:3658:2: (otherlv_0= '[' ( (lv_values_1_0= ruleTimeValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleTimeValue ) ) )* otherlv_4= ']' )
            // InternalRoQME.g:3659:3: otherlv_0= '[' ( (lv_values_1_0= ruleTimeValue ) ) (otherlv_2= ',' ( (lv_values_3_0= ruleTimeValue ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getTimeArrayAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalRoQME.g:3663:3: ( (lv_values_1_0= ruleTimeValue ) )
            // InternalRoQME.g:3664:4: (lv_values_1_0= ruleTimeValue )
            {
            // InternalRoQME.g:3664:4: (lv_values_1_0= ruleTimeValue )
            // InternalRoQME.g:3665:5: lv_values_1_0= ruleTimeValue
            {

            					newCompositeNode(grammarAccess.getTimeArrayAccess().getValuesTimeValueParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_42);
            lv_values_1_0=ruleTimeValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTimeArrayRule());
            					}
            					add(
            						current,
            						"values",
            						lv_values_1_0,
            						"org.xtext.roqme.RoQME.TimeValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoQME.g:3682:3: (otherlv_2= ',' ( (lv_values_3_0= ruleTimeValue ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==41) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalRoQME.g:3683:4: otherlv_2= ',' ( (lv_values_3_0= ruleTimeValue ) )
            	    {
            	    otherlv_2=(Token)match(input,41,FOLLOW_17); 

            	    				newLeafNode(otherlv_2, grammarAccess.getTimeArrayAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalRoQME.g:3687:4: ( (lv_values_3_0= ruleTimeValue ) )
            	    // InternalRoQME.g:3688:5: (lv_values_3_0= ruleTimeValue )
            	    {
            	    // InternalRoQME.g:3688:5: (lv_values_3_0= ruleTimeValue )
            	    // InternalRoQME.g:3689:6: lv_values_3_0= ruleTimeValue
            	    {

            	    						newCompositeNode(grammarAccess.getTimeArrayAccess().getValuesTimeValueParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_42);
            	    lv_values_3_0=ruleTimeValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTimeArrayRule());
            	    						}
            	    						add(
            	    							current,
            	    							"values",
            	    							lv_values_3_0,
            	    							"org.xtext.roqme.RoQME.TimeValue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

            otherlv_4=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getTimeArrayAccess().getRightSquareBracketKeyword_3());
            		

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
    // $ANTLR end "ruleTimeArray"


    // $ANTLR start "entryRuleDataTypeDeclaration"
    // InternalRoQME.g:3715:1: entryRuleDataTypeDeclaration returns [EObject current=null] : iv_ruleDataTypeDeclaration= ruleDataTypeDeclaration EOF ;
    public final EObject entryRuleDataTypeDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeDeclaration = null;


        try {
            // InternalRoQME.g:3715:60: (iv_ruleDataTypeDeclaration= ruleDataTypeDeclaration EOF )
            // InternalRoQME.g:3716:2: iv_ruleDataTypeDeclaration= ruleDataTypeDeclaration EOF
            {
             newCompositeNode(grammarAccess.getDataTypeDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataTypeDeclaration=ruleDataTypeDeclaration();

            state._fsp--;

             current =iv_ruleDataTypeDeclaration; 
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
    // $ANTLR end "entryRuleDataTypeDeclaration"


    // $ANTLR start "ruleDataTypeDeclaration"
    // InternalRoQME.g:3722:1: ruleDataTypeDeclaration returns [EObject current=null] : (this_InbuiltDeclaration_0= ruleInbuiltDeclaration | this_ReferencedDeclaration_1= ruleReferencedDeclaration | this_ContainedDeclaration_2= ruleContainedDeclaration ) ;
    public final EObject ruleDataTypeDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_InbuiltDeclaration_0 = null;

        EObject this_ReferencedDeclaration_1 = null;

        EObject this_ContainedDeclaration_2 = null;



        	enterRule();

        try {
            // InternalRoQME.g:3728:2: ( (this_InbuiltDeclaration_0= ruleInbuiltDeclaration | this_ReferencedDeclaration_1= ruleReferencedDeclaration | this_ContainedDeclaration_2= ruleContainedDeclaration ) )
            // InternalRoQME.g:3729:2: (this_InbuiltDeclaration_0= ruleInbuiltDeclaration | this_ReferencedDeclaration_1= ruleReferencedDeclaration | this_ContainedDeclaration_2= ruleContainedDeclaration )
            {
            // InternalRoQME.g:3729:2: (this_InbuiltDeclaration_0= ruleInbuiltDeclaration | this_ReferencedDeclaration_1= ruleReferencedDeclaration | this_ContainedDeclaration_2= ruleContainedDeclaration )
            int alt49=3;
            switch ( input.LA(1) ) {
            case EOF:
            case RULE_ROQME_DESCRIPTION:
            case 13:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 28:
            case 36:
                {
                alt49=1;
                }
                break;
            case RULE_ID:
                {
                alt49=2;
                }
                break;
            case 37:
            case 40:
            case 42:
            case 43:
            case 47:
                {
                alt49=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalRoQME.g:3730:3: this_InbuiltDeclaration_0= ruleInbuiltDeclaration
                    {

                    			newCompositeNode(grammarAccess.getDataTypeDeclarationAccess().getInbuiltDeclarationParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_InbuiltDeclaration_0=ruleInbuiltDeclaration();

                    state._fsp--;


                    			current = this_InbuiltDeclaration_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:3739:3: this_ReferencedDeclaration_1= ruleReferencedDeclaration
                    {

                    			newCompositeNode(grammarAccess.getDataTypeDeclarationAccess().getReferencedDeclarationParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ReferencedDeclaration_1=ruleReferencedDeclaration();

                    state._fsp--;


                    			current = this_ReferencedDeclaration_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRoQME.g:3748:3: this_ContainedDeclaration_2= ruleContainedDeclaration
                    {

                    			newCompositeNode(grammarAccess.getDataTypeDeclarationAccess().getContainedDeclarationParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ContainedDeclaration_2=ruleContainedDeclaration();

                    state._fsp--;


                    			current = this_ContainedDeclaration_2;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleDataTypeDeclaration"


    // $ANTLR start "entryRuleContainedDeclaration"
    // InternalRoQME.g:3760:1: entryRuleContainedDeclaration returns [EObject current=null] : iv_ruleContainedDeclaration= ruleContainedDeclaration EOF ;
    public final EObject entryRuleContainedDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedDeclaration = null;


        try {
            // InternalRoQME.g:3760:61: (iv_ruleContainedDeclaration= ruleContainedDeclaration EOF )
            // InternalRoQME.g:3761:2: iv_ruleContainedDeclaration= ruleContainedDeclaration EOF
            {
             newCompositeNode(grammarAccess.getContainedDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContainedDeclaration=ruleContainedDeclaration();

            state._fsp--;

             current =iv_ruleContainedDeclaration; 
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
    // $ANTLR end "entryRuleContainedDeclaration"


    // $ANTLR start "ruleContainedDeclaration"
    // InternalRoQME.g:3767:1: ruleContainedDeclaration returns [EObject current=null] : ( (lv_type_0_0= ruleDataType ) ) ;
    public final EObject ruleContainedDeclaration() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:3773:2: ( ( (lv_type_0_0= ruleDataType ) ) )
            // InternalRoQME.g:3774:2: ( (lv_type_0_0= ruleDataType ) )
            {
            // InternalRoQME.g:3774:2: ( (lv_type_0_0= ruleDataType ) )
            // InternalRoQME.g:3775:3: (lv_type_0_0= ruleDataType )
            {
            // InternalRoQME.g:3775:3: (lv_type_0_0= ruleDataType )
            // InternalRoQME.g:3776:4: lv_type_0_0= ruleDataType
            {

            				newCompositeNode(grammarAccess.getContainedDeclarationAccess().getTypeDataTypeParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_type_0_0=ruleDataType();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getContainedDeclarationRule());
            				}
            				set(
            					current,
            					"type",
            					lv_type_0_0,
            					"org.xtext.roqme.RoQME.DataType");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleContainedDeclaration"


    // $ANTLR start "entryRuleInbuiltDeclaration"
    // InternalRoQME.g:3796:1: entryRuleInbuiltDeclaration returns [EObject current=null] : iv_ruleInbuiltDeclaration= ruleInbuiltDeclaration EOF ;
    public final EObject entryRuleInbuiltDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInbuiltDeclaration = null;


        try {
            // InternalRoQME.g:3796:59: (iv_ruleInbuiltDeclaration= ruleInbuiltDeclaration EOF )
            // InternalRoQME.g:3797:2: iv_ruleInbuiltDeclaration= ruleInbuiltDeclaration EOF
            {
             newCompositeNode(grammarAccess.getInbuiltDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInbuiltDeclaration=ruleInbuiltDeclaration();

            state._fsp--;

             current =iv_ruleInbuiltDeclaration; 
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
    // $ANTLR end "entryRuleInbuiltDeclaration"


    // $ANTLR start "ruleInbuiltDeclaration"
    // InternalRoQME.g:3803:1: ruleInbuiltDeclaration returns [EObject current=null] : () ;
    public final EObject ruleInbuiltDeclaration() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalRoQME.g:3809:2: ( () )
            // InternalRoQME.g:3810:2: ()
            {
            // InternalRoQME.g:3810:2: ()
            // InternalRoQME.g:3811:3: 
            {

            			current = forceCreateModelElement(
            				grammarAccess.getInbuiltDeclarationAccess().getInbuiltDeclarationAction(),
            				current);
            		

            }


            }


            	leaveRule();

        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInbuiltDeclaration"


    // $ANTLR start "entryRuleReferencedDeclaration"
    // InternalRoQME.g:3820:1: entryRuleReferencedDeclaration returns [EObject current=null] : iv_ruleReferencedDeclaration= ruleReferencedDeclaration EOF ;
    public final EObject entryRuleReferencedDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedDeclaration = null;


        try {
            // InternalRoQME.g:3820:62: (iv_ruleReferencedDeclaration= ruleReferencedDeclaration EOF )
            // InternalRoQME.g:3821:2: iv_ruleReferencedDeclaration= ruleReferencedDeclaration EOF
            {
             newCompositeNode(grammarAccess.getReferencedDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReferencedDeclaration=ruleReferencedDeclaration();

            state._fsp--;

             current =iv_ruleReferencedDeclaration; 
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
    // $ANTLR end "entryRuleReferencedDeclaration"


    // $ANTLR start "ruleReferencedDeclaration"
    // InternalRoQME.g:3827:1: ruleReferencedDeclaration returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleReferencedDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRoQME.g:3833:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalRoQME.g:3834:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalRoQME.g:3834:2: ( (otherlv_0= RULE_ID ) )
            // InternalRoQME.g:3835:3: (otherlv_0= RULE_ID )
            {
            // InternalRoQME.g:3835:3: (otherlv_0= RULE_ID )
            // InternalRoQME.g:3836:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getReferencedDeclarationRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getReferencedDeclarationAccess().getTypeDataTypeDefinitionCrossReference_0());
            			

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
    // $ANTLR end "ruleReferencedDeclaration"


    // $ANTLR start "entryRuleGeneralExpression"
    // InternalRoQME.g:3850:1: entryRuleGeneralExpression returns [EObject current=null] : iv_ruleGeneralExpression= ruleGeneralExpression EOF ;
    public final EObject entryRuleGeneralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneralExpression = null;


        try {
            // InternalRoQME.g:3850:58: (iv_ruleGeneralExpression= ruleGeneralExpression EOF )
            // InternalRoQME.g:3851:2: iv_ruleGeneralExpression= ruleGeneralExpression EOF
            {
             newCompositeNode(grammarAccess.getGeneralExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGeneralExpression=ruleGeneralExpression();

            state._fsp--;

             current =iv_ruleGeneralExpression; 
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
    // $ANTLR end "entryRuleGeneralExpression"


    // $ANTLR start "ruleGeneralExpression"
    // InternalRoQME.g:3857:1: ruleGeneralExpression returns [EObject current=null] : ( (lv_term_0_0= ruleTerm ) ) ;
    public final EObject ruleGeneralExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_term_0_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:3863:2: ( ( (lv_term_0_0= ruleTerm ) ) )
            // InternalRoQME.g:3864:2: ( (lv_term_0_0= ruleTerm ) )
            {
            // InternalRoQME.g:3864:2: ( (lv_term_0_0= ruleTerm ) )
            // InternalRoQME.g:3865:3: (lv_term_0_0= ruleTerm )
            {
            // InternalRoQME.g:3865:3: (lv_term_0_0= ruleTerm )
            // InternalRoQME.g:3866:4: lv_term_0_0= ruleTerm
            {

            				newCompositeNode(grammarAccess.getGeneralExpressionAccess().getTermTermParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_term_0_0=ruleTerm();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getGeneralExpressionRule());
            				}
            				set(
            					current,
            					"term",
            					lv_term_0_0,
            					"org.xtext.roqme.RoQME.Term");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleGeneralExpression"


    // $ANTLR start "entryRuleOutputTransformation"
    // InternalRoQME.g:3886:1: entryRuleOutputTransformation returns [EObject current=null] : iv_ruleOutputTransformation= ruleOutputTransformation EOF ;
    public final EObject entryRuleOutputTransformation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutputTransformation = null;


        try {
            // InternalRoQME.g:3886:61: (iv_ruleOutputTransformation= ruleOutputTransformation EOF )
            // InternalRoQME.g:3887:2: iv_ruleOutputTransformation= ruleOutputTransformation EOF
            {
             newCompositeNode(grammarAccess.getOutputTransformationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutputTransformation=ruleOutputTransformation();

            state._fsp--;

             current =iv_ruleOutputTransformation; 
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
    // $ANTLR end "entryRuleOutputTransformation"


    // $ANTLR start "ruleOutputTransformation"
    // InternalRoQME.g:3893:1: ruleOutputTransformation returns [EObject current=null] : ( (lv_term_0_0= ruleTerm ) ) ;
    public final EObject ruleOutputTransformation() throws RecognitionException {
        EObject current = null;

        EObject lv_term_0_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:3899:2: ( ( (lv_term_0_0= ruleTerm ) ) )
            // InternalRoQME.g:3900:2: ( (lv_term_0_0= ruleTerm ) )
            {
            // InternalRoQME.g:3900:2: ( (lv_term_0_0= ruleTerm ) )
            // InternalRoQME.g:3901:3: (lv_term_0_0= ruleTerm )
            {
            // InternalRoQME.g:3901:3: (lv_term_0_0= ruleTerm )
            // InternalRoQME.g:3902:4: lv_term_0_0= ruleTerm
            {

            				newCompositeNode(grammarAccess.getOutputTransformationAccess().getTermTermParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_term_0_0=ruleTerm();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getOutputTransformationRule());
            				}
            				set(
            					current,
            					"term",
            					lv_term_0_0,
            					"org.xtext.roqme.RoQME.Term");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleOutputTransformation"


    // $ANTLR start "entryRuleContextPattern"
    // InternalRoQME.g:3922:1: entryRuleContextPattern returns [EObject current=null] : iv_ruleContextPattern= ruleContextPattern EOF ;
    public final EObject entryRuleContextPattern() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextPattern = null;


        try {
            // InternalRoQME.g:3922:55: (iv_ruleContextPattern= ruleContextPattern EOF )
            // InternalRoQME.g:3923:2: iv_ruleContextPattern= ruleContextPattern EOF
            {
             newCompositeNode(grammarAccess.getContextPatternRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContextPattern=ruleContextPattern();

            state._fsp--;

             current =iv_ruleContextPattern; 
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
    // $ANTLR end "entryRuleContextPattern"


    // $ANTLR start "ruleContextPattern"
    // InternalRoQME.g:3929:1: ruleContextPattern returns [EObject current=null] : ( (lv_term_0_0= ruleTerm ) ) ;
    public final EObject ruleContextPattern() throws RecognitionException {
        EObject current = null;

        EObject lv_term_0_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:3935:2: ( ( (lv_term_0_0= ruleTerm ) ) )
            // InternalRoQME.g:3936:2: ( (lv_term_0_0= ruleTerm ) )
            {
            // InternalRoQME.g:3936:2: ( (lv_term_0_0= ruleTerm ) )
            // InternalRoQME.g:3937:3: (lv_term_0_0= ruleTerm )
            {
            // InternalRoQME.g:3937:3: (lv_term_0_0= ruleTerm )
            // InternalRoQME.g:3938:4: lv_term_0_0= ruleTerm
            {

            				newCompositeNode(grammarAccess.getContextPatternAccess().getTermTermParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_term_0_0=ruleTerm();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getContextPatternRule());
            				}
            				set(
            					current,
            					"term",
            					lv_term_0_0,
            					"org.xtext.roqme.RoQME.Term");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleContextPattern"


    // $ANTLR start "entryRuleTerm"
    // InternalRoQME.g:3958:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // InternalRoQME.g:3958:45: (iv_ruleTerm= ruleTerm EOF )
            // InternalRoQME.g:3959:2: iv_ruleTerm= ruleTerm EOF
            {
             newCompositeNode(grammarAccess.getTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerm=ruleTerm();

            state._fsp--;

             current =iv_ruleTerm; 
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
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // InternalRoQME.g:3965:1: ruleTerm returns [EObject current=null] : (this_OnceTerm_0= ruleOnceTerm | this_WhileTerm_1= ruleWhileTerm ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_OnceTerm_0 = null;

        EObject this_WhileTerm_1 = null;



        	enterRule();

        try {
            // InternalRoQME.g:3971:2: ( (this_OnceTerm_0= ruleOnceTerm | this_WhileTerm_1= ruleWhileTerm ) )
            // InternalRoQME.g:3972:2: (this_OnceTerm_0= ruleOnceTerm | this_WhileTerm_1= ruleWhileTerm )
            {
            // InternalRoQME.g:3972:2: (this_OnceTerm_0= ruleOnceTerm | this_WhileTerm_1= ruleWhileTerm )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==59) ) {
                alt50=1;
            }
            else if ( ((LA50_0>=RULE_ID && LA50_0<=RULE_INT)||LA50_0==38||LA50_0==48||LA50_0==61||LA50_0==68||LA50_0==72||LA50_0==80||(LA50_0>=83 && LA50_0<=84)||(LA50_0>=87 && LA50_0<=88)||(LA50_0>=97 && LA50_0<=117)) ) {
                alt50=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalRoQME.g:3973:3: this_OnceTerm_0= ruleOnceTerm
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getOnceTermParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_OnceTerm_0=ruleOnceTerm();

                    state._fsp--;


                    			current = this_OnceTerm_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:3982:3: this_WhileTerm_1= ruleWhileTerm
                    {

                    			newCompositeNode(grammarAccess.getTermAccess().getWhileTermParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_WhileTerm_1=ruleWhileTerm();

                    state._fsp--;


                    			current = this_WhileTerm_1;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleOnceTerm"
    // InternalRoQME.g:3994:1: entryRuleOnceTerm returns [EObject current=null] : iv_ruleOnceTerm= ruleOnceTerm EOF ;
    public final EObject entryRuleOnceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOnceTerm = null;


        try {
            // InternalRoQME.g:3994:49: (iv_ruleOnceTerm= ruleOnceTerm EOF )
            // InternalRoQME.g:3995:2: iv_ruleOnceTerm= ruleOnceTerm EOF
            {
             newCompositeNode(grammarAccess.getOnceTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOnceTerm=ruleOnceTerm();

            state._fsp--;

             current =iv_ruleOnceTerm; 
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
    // $ANTLR end "entryRuleOnceTerm"


    // $ANTLR start "ruleOnceTerm"
    // InternalRoQME.g:4001:1: ruleOnceTerm returns [EObject current=null] : (otherlv_0= 'once' ( (lv_term_1_0= ruleWhileTerm ) ) ) ;
    public final EObject ruleOnceTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_term_1_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:4007:2: ( (otherlv_0= 'once' ( (lv_term_1_0= ruleWhileTerm ) ) ) )
            // InternalRoQME.g:4008:2: (otherlv_0= 'once' ( (lv_term_1_0= ruleWhileTerm ) ) )
            {
            // InternalRoQME.g:4008:2: (otherlv_0= 'once' ( (lv_term_1_0= ruleWhileTerm ) ) )
            // InternalRoQME.g:4009:3: otherlv_0= 'once' ( (lv_term_1_0= ruleWhileTerm ) )
            {
            otherlv_0=(Token)match(input,59,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getOnceTermAccess().getOnceKeyword_0());
            		
            // InternalRoQME.g:4013:3: ( (lv_term_1_0= ruleWhileTerm ) )
            // InternalRoQME.g:4014:4: (lv_term_1_0= ruleWhileTerm )
            {
            // InternalRoQME.g:4014:4: (lv_term_1_0= ruleWhileTerm )
            // InternalRoQME.g:4015:5: lv_term_1_0= ruleWhileTerm
            {

            					newCompositeNode(grammarAccess.getOnceTermAccess().getTermWhileTermParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_term_1_0=ruleWhileTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOnceTermRule());
            					}
            					set(
            						current,
            						"term",
            						lv_term_1_0,
            						"org.xtext.roqme.RoQME.WhileTerm");
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
    // $ANTLR end "ruleOnceTerm"


    // $ANTLR start "entryRuleWhileTerm"
    // InternalRoQME.g:4036:1: entryRuleWhileTerm returns [EObject current=null] : iv_ruleWhileTerm= ruleWhileTerm EOF ;
    public final EObject entryRuleWhileTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileTerm = null;


        try {
            // InternalRoQME.g:4036:50: (iv_ruleWhileTerm= ruleWhileTerm EOF )
            // InternalRoQME.g:4037:2: iv_ruleWhileTerm= ruleWhileTerm EOF
            {
             newCompositeNode(grammarAccess.getWhileTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWhileTerm=ruleWhileTerm();

            state._fsp--;

             current =iv_ruleWhileTerm; 
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
    // $ANTLR end "entryRuleWhileTerm"


    // $ANTLR start "ruleWhileTerm"
    // InternalRoQME.g:4043:1: ruleWhileTerm returns [EObject current=null] : (this_RepetionTerm_0= ruleRepetionTerm ( () otherlv_2= 'while' otherlv_3= '(' ( (lv_right_4_0= ruleOrBooleanTerm ) ) otherlv_5= ')' )? ) ;
    public final EObject ruleWhileTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject this_RepetionTerm_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:4049:2: ( (this_RepetionTerm_0= ruleRepetionTerm ( () otherlv_2= 'while' otherlv_3= '(' ( (lv_right_4_0= ruleOrBooleanTerm ) ) otherlv_5= ')' )? ) )
            // InternalRoQME.g:4050:2: (this_RepetionTerm_0= ruleRepetionTerm ( () otherlv_2= 'while' otherlv_3= '(' ( (lv_right_4_0= ruleOrBooleanTerm ) ) otherlv_5= ')' )? )
            {
            // InternalRoQME.g:4050:2: (this_RepetionTerm_0= ruleRepetionTerm ( () otherlv_2= 'while' otherlv_3= '(' ( (lv_right_4_0= ruleOrBooleanTerm ) ) otherlv_5= ')' )? )
            // InternalRoQME.g:4051:3: this_RepetionTerm_0= ruleRepetionTerm ( () otherlv_2= 'while' otherlv_3= '(' ( (lv_right_4_0= ruleOrBooleanTerm ) ) otherlv_5= ')' )?
            {

            			newCompositeNode(grammarAccess.getWhileTermAccess().getRepetionTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_43);
            this_RepetionTerm_0=ruleRepetionTerm();

            state._fsp--;


            			current = this_RepetionTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalRoQME.g:4059:3: ( () otherlv_2= 'while' otherlv_3= '(' ( (lv_right_4_0= ruleOrBooleanTerm ) ) otherlv_5= ')' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==60) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalRoQME.g:4060:4: () otherlv_2= 'while' otherlv_3= '(' ( (lv_right_4_0= ruleOrBooleanTerm ) ) otherlv_5= ')'
                    {
                    // InternalRoQME.g:4060:4: ()
                    // InternalRoQME.g:4061:5: 
                    {

                    					current = forceCreateModelElementAndSet(
                    						grammarAccess.getWhileTermAccess().getWhileTermLeftAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,60,FOLLOW_44); 

                    				newLeafNode(otherlv_2, grammarAccess.getWhileTermAccess().getWhileKeyword_1_1());
                    			
                    otherlv_3=(Token)match(input,61,FOLLOW_12); 

                    				newLeafNode(otherlv_3, grammarAccess.getWhileTermAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalRoQME.g:4075:4: ( (lv_right_4_0= ruleOrBooleanTerm ) )
                    // InternalRoQME.g:4076:5: (lv_right_4_0= ruleOrBooleanTerm )
                    {
                    // InternalRoQME.g:4076:5: (lv_right_4_0= ruleOrBooleanTerm )
                    // InternalRoQME.g:4077:6: lv_right_4_0= ruleOrBooleanTerm
                    {

                    						newCompositeNode(grammarAccess.getWhileTermAccess().getRightOrBooleanTermParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_45);
                    lv_right_4_0=ruleOrBooleanTerm();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWhileTermRule());
                    						}
                    						set(
                    							current,
                    							"right",
                    							lv_right_4_0,
                    							"org.xtext.roqme.RoQME.OrBooleanTerm");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,62,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getWhileTermAccess().getRightParenthesisKeyword_1_4());
                    			

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
    // $ANTLR end "ruleWhileTerm"


    // $ANTLR start "entryRuleRepetionTerm"
    // InternalRoQME.g:4103:1: entryRuleRepetionTerm returns [EObject current=null] : iv_ruleRepetionTerm= ruleRepetionTerm EOF ;
    public final EObject entryRuleRepetionTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRepetionTerm = null;


        try {
            // InternalRoQME.g:4103:53: (iv_ruleRepetionTerm= ruleRepetionTerm EOF )
            // InternalRoQME.g:4104:2: iv_ruleRepetionTerm= ruleRepetionTerm EOF
            {
             newCompositeNode(grammarAccess.getRepetionTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRepetionTerm=ruleRepetionTerm();

            state._fsp--;

             current =iv_ruleRepetionTerm; 
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
    // $ANTLR end "entryRuleRepetionTerm"


    // $ANTLR start "ruleRepetionTerm"
    // InternalRoQME.g:4110:1: ruleRepetionTerm returns [EObject current=null] : (this_SequenceTerm_0= ruleSequenceTerm ( ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' ) | ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' ) )? ) ;
    public final EObject ruleRepetionTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_nrep_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_lowerBound_9_0=null;
        Token otherlv_10=null;
        Token lv_upperBound_11_0=null;
        Token otherlv_12=null;
        EObject this_SequenceTerm_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:4116:2: ( (this_SequenceTerm_0= ruleSequenceTerm ( ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' ) | ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' ) )? ) )
            // InternalRoQME.g:4117:2: (this_SequenceTerm_0= ruleSequenceTerm ( ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' ) | ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' ) )? )
            {
            // InternalRoQME.g:4117:2: (this_SequenceTerm_0= ruleSequenceTerm ( ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' ) | ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' ) )? )
            // InternalRoQME.g:4118:3: this_SequenceTerm_0= ruleSequenceTerm ( ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' ) | ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' ) )?
            {

            			newCompositeNode(grammarAccess.getRepetionTermAccess().getSequenceTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_46);
            this_SequenceTerm_0=ruleSequenceTerm();

            state._fsp--;


            			current = this_SequenceTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalRoQME.g:4126:3: ( ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' ) | ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' ) )?
            int alt52=3;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==63) ) {
                alt52=1;
            }
            else if ( (LA52_0==64) ) {
                alt52=2;
            }
            switch (alt52) {
                case 1 :
                    // InternalRoQME.g:4127:4: ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' )
                    {
                    // InternalRoQME.g:4127:4: ( () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')' )
                    // InternalRoQME.g:4128:5: () otherlv_2= 'repeat' otherlv_3= '(' ( (lv_nrep_4_0= RULE_INT ) ) otherlv_5= ')'
                    {
                    // InternalRoQME.g:4128:5: ()
                    // InternalRoQME.g:4129:6: 
                    {

                    						current = forceCreateModelElementAndSet(
                    							grammarAccess.getRepetionTermAccess().getRepeatTermTermAction_1_0_0(),
                    							current);
                    					

                    }

                    otherlv_2=(Token)match(input,63,FOLLOW_44); 

                    					newLeafNode(otherlv_2, grammarAccess.getRepetionTermAccess().getRepeatKeyword_1_0_1());
                    				
                    otherlv_3=(Token)match(input,61,FOLLOW_30); 

                    					newLeafNode(otherlv_3, grammarAccess.getRepetionTermAccess().getLeftParenthesisKeyword_1_0_2());
                    				
                    // InternalRoQME.g:4143:5: ( (lv_nrep_4_0= RULE_INT ) )
                    // InternalRoQME.g:4144:6: (lv_nrep_4_0= RULE_INT )
                    {
                    // InternalRoQME.g:4144:6: (lv_nrep_4_0= RULE_INT )
                    // InternalRoQME.g:4145:7: lv_nrep_4_0= RULE_INT
                    {
                    lv_nrep_4_0=(Token)match(input,RULE_INT,FOLLOW_45); 

                    							newLeafNode(lv_nrep_4_0, grammarAccess.getRepetionTermAccess().getNrepINTTerminalRuleCall_1_0_3_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRepetionTermRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"nrep",
                    								lv_nrep_4_0,
                    								"org.eclipse.xtext.common.Terminals.INT");
                    						

                    }


                    }

                    otherlv_5=(Token)match(input,62,FOLLOW_2); 

                    					newLeafNode(otherlv_5, grammarAccess.getRepetionTermAccess().getRightParenthesisKeyword_1_0_4());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRoQME.g:4167:4: ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' )
                    {
                    // InternalRoQME.g:4167:4: ( () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')' )
                    // InternalRoQME.g:4168:5: () otherlv_7= 'range' otherlv_8= '(' ( (lv_lowerBound_9_0= RULE_INT ) ) otherlv_10= ',' ( (lv_upperBound_11_0= RULE_INT ) ) otherlv_12= ')'
                    {
                    // InternalRoQME.g:4168:5: ()
                    // InternalRoQME.g:4169:6: 
                    {

                    						current = forceCreateModelElementAndSet(
                    							grammarAccess.getRepetionTermAccess().getRangeTermTermAction_1_1_0(),
                    							current);
                    					

                    }

                    otherlv_7=(Token)match(input,64,FOLLOW_44); 

                    					newLeafNode(otherlv_7, grammarAccess.getRepetionTermAccess().getRangeKeyword_1_1_1());
                    				
                    otherlv_8=(Token)match(input,61,FOLLOW_30); 

                    					newLeafNode(otherlv_8, grammarAccess.getRepetionTermAccess().getLeftParenthesisKeyword_1_1_2());
                    				
                    // InternalRoQME.g:4183:5: ( (lv_lowerBound_9_0= RULE_INT ) )
                    // InternalRoQME.g:4184:6: (lv_lowerBound_9_0= RULE_INT )
                    {
                    // InternalRoQME.g:4184:6: (lv_lowerBound_9_0= RULE_INT )
                    // InternalRoQME.g:4185:7: lv_lowerBound_9_0= RULE_INT
                    {
                    lv_lowerBound_9_0=(Token)match(input,RULE_INT,FOLLOW_34); 

                    							newLeafNode(lv_lowerBound_9_0, grammarAccess.getRepetionTermAccess().getLowerBoundINTTerminalRuleCall_1_1_3_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRepetionTermRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"lowerBound",
                    								lv_lowerBound_9_0,
                    								"org.eclipse.xtext.common.Terminals.INT");
                    						

                    }


                    }

                    otherlv_10=(Token)match(input,41,FOLLOW_30); 

                    					newLeafNode(otherlv_10, grammarAccess.getRepetionTermAccess().getCommaKeyword_1_1_4());
                    				
                    // InternalRoQME.g:4205:5: ( (lv_upperBound_11_0= RULE_INT ) )
                    // InternalRoQME.g:4206:6: (lv_upperBound_11_0= RULE_INT )
                    {
                    // InternalRoQME.g:4206:6: (lv_upperBound_11_0= RULE_INT )
                    // InternalRoQME.g:4207:7: lv_upperBound_11_0= RULE_INT
                    {
                    lv_upperBound_11_0=(Token)match(input,RULE_INT,FOLLOW_45); 

                    							newLeafNode(lv_upperBound_11_0, grammarAccess.getRepetionTermAccess().getUpperBoundINTTerminalRuleCall_1_1_5_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getRepetionTermRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"upperBound",
                    								lv_upperBound_11_0,
                    								"org.eclipse.xtext.common.Terminals.INT");
                    						

                    }


                    }

                    otherlv_12=(Token)match(input,62,FOLLOW_2); 

                    					newLeafNode(otherlv_12, grammarAccess.getRepetionTermAccess().getRightParenthesisKeyword_1_1_6());
                    				

                    }


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
    // $ANTLR end "ruleRepetionTerm"


    // $ANTLR start "entryRuleSequenceTerm"
    // InternalRoQME.g:4233:1: entryRuleSequenceTerm returns [EObject current=null] : iv_ruleSequenceTerm= ruleSequenceTerm EOF ;
    public final EObject entryRuleSequenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceTerm = null;


        try {
            // InternalRoQME.g:4233:53: (iv_ruleSequenceTerm= ruleSequenceTerm EOF )
            // InternalRoQME.g:4234:2: iv_ruleSequenceTerm= ruleSequenceTerm EOF
            {
             newCompositeNode(grammarAccess.getSequenceTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSequenceTerm=ruleSequenceTerm();

            state._fsp--;

             current =iv_ruleSequenceTerm; 
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
    // $ANTLR end "entryRuleSequenceTerm"


    // $ANTLR start "ruleSequenceTerm"
    // InternalRoQME.g:4240:1: ruleSequenceTerm returns [EObject current=null] : (this_OrEventTerm_0= ruleOrEventTerm ( () otherlv_2= '->' ( (lv_right_3_0= ruleConditionalTerm ) ) )* ) ;
    public final EObject ruleSequenceTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_OrEventTerm_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:4246:2: ( (this_OrEventTerm_0= ruleOrEventTerm ( () otherlv_2= '->' ( (lv_right_3_0= ruleConditionalTerm ) ) )* ) )
            // InternalRoQME.g:4247:2: (this_OrEventTerm_0= ruleOrEventTerm ( () otherlv_2= '->' ( (lv_right_3_0= ruleConditionalTerm ) ) )* )
            {
            // InternalRoQME.g:4247:2: (this_OrEventTerm_0= ruleOrEventTerm ( () otherlv_2= '->' ( (lv_right_3_0= ruleConditionalTerm ) ) )* )
            // InternalRoQME.g:4248:3: this_OrEventTerm_0= ruleOrEventTerm ( () otherlv_2= '->' ( (lv_right_3_0= ruleConditionalTerm ) ) )*
            {

            			newCompositeNode(grammarAccess.getSequenceTermAccess().getOrEventTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_47);
            this_OrEventTerm_0=ruleOrEventTerm();

            state._fsp--;


            			current = this_OrEventTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalRoQME.g:4256:3: ( () otherlv_2= '->' ( (lv_right_3_0= ruleConditionalTerm ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==65) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalRoQME.g:4257:4: () otherlv_2= '->' ( (lv_right_3_0= ruleConditionalTerm ) )
            	    {
            	    // InternalRoQME.g:4257:4: ()
            	    // InternalRoQME.g:4258:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getSequenceTermAccess().getFollowedByTermLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,65,FOLLOW_12); 

            	    				newLeafNode(otherlv_2, grammarAccess.getSequenceTermAccess().getHyphenMinusGreaterThanSignKeyword_1_1());
            	    			
            	    // InternalRoQME.g:4268:4: ( (lv_right_3_0= ruleConditionalTerm ) )
            	    // InternalRoQME.g:4269:5: (lv_right_3_0= ruleConditionalTerm )
            	    {
            	    // InternalRoQME.g:4269:5: (lv_right_3_0= ruleConditionalTerm )
            	    // InternalRoQME.g:4270:6: lv_right_3_0= ruleConditionalTerm
            	    {

            	    						newCompositeNode(grammarAccess.getSequenceTermAccess().getRightConditionalTermParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_47);
            	    lv_right_3_0=ruleConditionalTerm();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSequenceTermRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.xtext.roqme.RoQME.ConditionalTerm");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
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
    // $ANTLR end "ruleSequenceTerm"


    // $ANTLR start "entryRuleOrEventTerm"
    // InternalRoQME.g:4292:1: entryRuleOrEventTerm returns [EObject current=null] : iv_ruleOrEventTerm= ruleOrEventTerm EOF ;
    public final EObject entryRuleOrEventTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrEventTerm = null;


        try {
            // InternalRoQME.g:4292:52: (iv_ruleOrEventTerm= ruleOrEventTerm EOF )
            // InternalRoQME.g:4293:2: iv_ruleOrEventTerm= ruleOrEventTerm EOF
            {
             newCompositeNode(grammarAccess.getOrEventTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrEventTerm=ruleOrEventTerm();

            state._fsp--;

             current =iv_ruleOrEventTerm; 
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
    // $ANTLR end "entryRuleOrEventTerm"


    // $ANTLR start "ruleOrEventTerm"
    // InternalRoQME.g:4299:1: ruleOrEventTerm returns [EObject current=null] : (this_AndEventTerm_0= ruleAndEventTerm ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndEventTerm ) ) )* ) ;
    public final EObject ruleOrEventTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndEventTerm_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:4305:2: ( (this_AndEventTerm_0= ruleAndEventTerm ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndEventTerm ) ) )* ) )
            // InternalRoQME.g:4306:2: (this_AndEventTerm_0= ruleAndEventTerm ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndEventTerm ) ) )* )
            {
            // InternalRoQME.g:4306:2: (this_AndEventTerm_0= ruleAndEventTerm ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndEventTerm ) ) )* )
            // InternalRoQME.g:4307:3: this_AndEventTerm_0= ruleAndEventTerm ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndEventTerm ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrEventTermAccess().getAndEventTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_48);
            this_AndEventTerm_0=ruleAndEventTerm();

            state._fsp--;


            			current = this_AndEventTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalRoQME.g:4315:3: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndEventTerm ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==66) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalRoQME.g:4316:4: () otherlv_2= 'or' ( (lv_right_3_0= ruleAndEventTerm ) )
            	    {
            	    // InternalRoQME.g:4316:4: ()
            	    // InternalRoQME.g:4317:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrEventTermAccess().getOrEventTermLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,66,FOLLOW_12); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrEventTermAccess().getOrKeyword_1_1());
            	    			
            	    // InternalRoQME.g:4327:4: ( (lv_right_3_0= ruleAndEventTerm ) )
            	    // InternalRoQME.g:4328:5: (lv_right_3_0= ruleAndEventTerm )
            	    {
            	    // InternalRoQME.g:4328:5: (lv_right_3_0= ruleAndEventTerm )
            	    // InternalRoQME.g:4329:6: lv_right_3_0= ruleAndEventTerm
            	    {

            	    						newCompositeNode(grammarAccess.getOrEventTermAccess().getRightAndEventTermParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_48);
            	    lv_right_3_0=ruleAndEventTerm();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrEventTermRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.xtext.roqme.RoQME.AndEventTerm");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
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
    // $ANTLR end "ruleOrEventTerm"


    // $ANTLR start "entryRuleAndEventTerm"
    // InternalRoQME.g:4351:1: entryRuleAndEventTerm returns [EObject current=null] : iv_ruleAndEventTerm= ruleAndEventTerm EOF ;
    public final EObject entryRuleAndEventTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndEventTerm = null;


        try {
            // InternalRoQME.g:4351:53: (iv_ruleAndEventTerm= ruleAndEventTerm EOF )
            // InternalRoQME.g:4352:2: iv_ruleAndEventTerm= ruleAndEventTerm EOF
            {
             newCompositeNode(grammarAccess.getAndEventTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndEventTerm=ruleAndEventTerm();

            state._fsp--;

             current =iv_ruleAndEventTerm; 
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
    // $ANTLR end "entryRuleAndEventTerm"


    // $ANTLR start "ruleAndEventTerm"
    // InternalRoQME.g:4358:1: ruleAndEventTerm returns [EObject current=null] : ( (this_NotEventTerm_0= ruleNotEventTerm | this_ConditionalTerm_1= ruleConditionalTerm ) ( () otherlv_3= 'and' ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) ) )* ) ;
    public final EObject ruleAndEventTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject this_NotEventTerm_0 = null;

        EObject this_ConditionalTerm_1 = null;

        EObject lv_right_4_1 = null;

        EObject lv_right_4_2 = null;



        	enterRule();

        try {
            // InternalRoQME.g:4364:2: ( ( (this_NotEventTerm_0= ruleNotEventTerm | this_ConditionalTerm_1= ruleConditionalTerm ) ( () otherlv_3= 'and' ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) ) )* ) )
            // InternalRoQME.g:4365:2: ( (this_NotEventTerm_0= ruleNotEventTerm | this_ConditionalTerm_1= ruleConditionalTerm ) ( () otherlv_3= 'and' ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) ) )* )
            {
            // InternalRoQME.g:4365:2: ( (this_NotEventTerm_0= ruleNotEventTerm | this_ConditionalTerm_1= ruleConditionalTerm ) ( () otherlv_3= 'and' ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) ) )* )
            // InternalRoQME.g:4366:3: (this_NotEventTerm_0= ruleNotEventTerm | this_ConditionalTerm_1= ruleConditionalTerm ) ( () otherlv_3= 'and' ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) ) )*
            {
            // InternalRoQME.g:4366:3: (this_NotEventTerm_0= ruleNotEventTerm | this_ConditionalTerm_1= ruleConditionalTerm )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==68) ) {
                alt55=1;
            }
            else if ( ((LA55_0>=RULE_ID && LA55_0<=RULE_INT)||LA55_0==38||LA55_0==48||LA55_0==61||LA55_0==72||LA55_0==80||(LA55_0>=83 && LA55_0<=84)||(LA55_0>=87 && LA55_0<=88)||(LA55_0>=97 && LA55_0<=117)) ) {
                alt55=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // InternalRoQME.g:4367:4: this_NotEventTerm_0= ruleNotEventTerm
                    {

                    				newCompositeNode(grammarAccess.getAndEventTermAccess().getNotEventTermParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_49);
                    this_NotEventTerm_0=ruleNotEventTerm();

                    state._fsp--;


                    				current = this_NotEventTerm_0;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:4376:4: this_ConditionalTerm_1= ruleConditionalTerm
                    {

                    				newCompositeNode(grammarAccess.getAndEventTermAccess().getConditionalTermParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_49);
                    this_ConditionalTerm_1=ruleConditionalTerm();

                    state._fsp--;


                    				current = this_ConditionalTerm_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalRoQME.g:4385:3: ( () otherlv_3= 'and' ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==67) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalRoQME.g:4386:4: () otherlv_3= 'and' ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) )
            	    {
            	    // InternalRoQME.g:4386:4: ()
            	    // InternalRoQME.g:4387:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndEventTermAccess().getAndEventTermLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_3=(Token)match(input,67,FOLLOW_12); 

            	    				newLeafNode(otherlv_3, grammarAccess.getAndEventTermAccess().getAndKeyword_1_1());
            	    			
            	    // InternalRoQME.g:4397:4: ( ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) ) )
            	    // InternalRoQME.g:4398:5: ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) )
            	    {
            	    // InternalRoQME.g:4398:5: ( (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm ) )
            	    // InternalRoQME.g:4399:6: (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm )
            	    {
            	    // InternalRoQME.g:4399:6: (lv_right_4_1= ruleNotEventTerm | lv_right_4_2= ruleConditionalTerm )
            	    int alt56=2;
            	    int LA56_0 = input.LA(1);

            	    if ( (LA56_0==68) ) {
            	        alt56=1;
            	    }
            	    else if ( ((LA56_0>=RULE_ID && LA56_0<=RULE_INT)||LA56_0==38||LA56_0==48||LA56_0==61||LA56_0==72||LA56_0==80||(LA56_0>=83 && LA56_0<=84)||(LA56_0>=87 && LA56_0<=88)||(LA56_0>=97 && LA56_0<=117)) ) {
            	        alt56=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 56, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt56) {
            	        case 1 :
            	            // InternalRoQME.g:4400:7: lv_right_4_1= ruleNotEventTerm
            	            {

            	            							newCompositeNode(grammarAccess.getAndEventTermAccess().getRightNotEventTermParserRuleCall_1_2_0_0());
            	            						
            	            pushFollow(FOLLOW_49);
            	            lv_right_4_1=ruleNotEventTerm();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getAndEventTermRule());
            	            							}
            	            							set(
            	            								current,
            	            								"right",
            	            								lv_right_4_1,
            	            								"org.xtext.roqme.RoQME.NotEventTerm");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalRoQME.g:4416:7: lv_right_4_2= ruleConditionalTerm
            	            {

            	            							newCompositeNode(grammarAccess.getAndEventTermAccess().getRightConditionalTermParserRuleCall_1_2_0_1());
            	            						
            	            pushFollow(FOLLOW_49);
            	            lv_right_4_2=ruleConditionalTerm();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getAndEventTermRule());
            	            							}
            	            							set(
            	            								current,
            	            								"right",
            	            								lv_right_4_2,
            	            								"org.xtext.roqme.RoQME.ConditionalTerm");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop57;
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
    // $ANTLR end "ruleAndEventTerm"


    // $ANTLR start "entryRuleNotEventTerm"
    // InternalRoQME.g:4439:1: entryRuleNotEventTerm returns [EObject current=null] : iv_ruleNotEventTerm= ruleNotEventTerm EOF ;
    public final EObject entryRuleNotEventTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotEventTerm = null;


        try {
            // InternalRoQME.g:4439:53: (iv_ruleNotEventTerm= ruleNotEventTerm EOF )
            // InternalRoQME.g:4440:2: iv_ruleNotEventTerm= ruleNotEventTerm EOF
            {
             newCompositeNode(grammarAccess.getNotEventTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNotEventTerm=ruleNotEventTerm();

            state._fsp--;

             current =iv_ruleNotEventTerm; 
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
    // $ANTLR end "entryRuleNotEventTerm"


    // $ANTLR start "ruleNotEventTerm"
    // InternalRoQME.g:4446:1: ruleNotEventTerm returns [EObject current=null] : ( () otherlv_1= 'not' ( (lv_term_2_0= ruleConditionalTerm ) ) ) ;
    public final EObject ruleNotEventTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_term_2_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:4452:2: ( ( () otherlv_1= 'not' ( (lv_term_2_0= ruleConditionalTerm ) ) ) )
            // InternalRoQME.g:4453:2: ( () otherlv_1= 'not' ( (lv_term_2_0= ruleConditionalTerm ) ) )
            {
            // InternalRoQME.g:4453:2: ( () otherlv_1= 'not' ( (lv_term_2_0= ruleConditionalTerm ) ) )
            // InternalRoQME.g:4454:3: () otherlv_1= 'not' ( (lv_term_2_0= ruleConditionalTerm ) )
            {
            // InternalRoQME.g:4454:3: ()
            // InternalRoQME.g:4455:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNotEventTermAccess().getNotEventTermAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,68,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getNotEventTermAccess().getNotKeyword_1());
            		
            // InternalRoQME.g:4465:3: ( (lv_term_2_0= ruleConditionalTerm ) )
            // InternalRoQME.g:4466:4: (lv_term_2_0= ruleConditionalTerm )
            {
            // InternalRoQME.g:4466:4: (lv_term_2_0= ruleConditionalTerm )
            // InternalRoQME.g:4467:5: lv_term_2_0= ruleConditionalTerm
            {

            					newCompositeNode(grammarAccess.getNotEventTermAccess().getTermConditionalTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_term_2_0=ruleConditionalTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNotEventTermRule());
            					}
            					set(
            						current,
            						"term",
            						lv_term_2_0,
            						"org.xtext.roqme.RoQME.ConditionalTerm");
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
    // $ANTLR end "ruleNotEventTerm"


    // $ANTLR start "entryRuleConditionalTerm"
    // InternalRoQME.g:4488:1: entryRuleConditionalTerm returns [EObject current=null] : iv_ruleConditionalTerm= ruleConditionalTerm EOF ;
    public final EObject entryRuleConditionalTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalTerm = null;


        try {
            // InternalRoQME.g:4488:56: (iv_ruleConditionalTerm= ruleConditionalTerm EOF )
            // InternalRoQME.g:4489:2: iv_ruleConditionalTerm= ruleConditionalTerm EOF
            {
             newCompositeNode(grammarAccess.getConditionalTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConditionalTerm=ruleConditionalTerm();

            state._fsp--;

             current =iv_ruleConditionalTerm; 
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
    // $ANTLR end "entryRuleConditionalTerm"


    // $ANTLR start "ruleConditionalTerm"
    // InternalRoQME.g:4495:1: ruleConditionalTerm returns [EObject current=null] : (this_OrBooleanTerm_0= ruleOrBooleanTerm ( () otherlv_2= '?' ( (lv_terms_3_0= ruleOrBooleanTerm ) ) otherlv_4= ':' ( (lv_terms_5_0= ruleConditionalTerm ) ) )? ) ;
    public final EObject ruleConditionalTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_OrBooleanTerm_0 = null;

        EObject lv_terms_3_0 = null;

        EObject lv_terms_5_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:4501:2: ( (this_OrBooleanTerm_0= ruleOrBooleanTerm ( () otherlv_2= '?' ( (lv_terms_3_0= ruleOrBooleanTerm ) ) otherlv_4= ':' ( (lv_terms_5_0= ruleConditionalTerm ) ) )? ) )
            // InternalRoQME.g:4502:2: (this_OrBooleanTerm_0= ruleOrBooleanTerm ( () otherlv_2= '?' ( (lv_terms_3_0= ruleOrBooleanTerm ) ) otherlv_4= ':' ( (lv_terms_5_0= ruleConditionalTerm ) ) )? )
            {
            // InternalRoQME.g:4502:2: (this_OrBooleanTerm_0= ruleOrBooleanTerm ( () otherlv_2= '?' ( (lv_terms_3_0= ruleOrBooleanTerm ) ) otherlv_4= ':' ( (lv_terms_5_0= ruleConditionalTerm ) ) )? )
            // InternalRoQME.g:4503:3: this_OrBooleanTerm_0= ruleOrBooleanTerm ( () otherlv_2= '?' ( (lv_terms_3_0= ruleOrBooleanTerm ) ) otherlv_4= ':' ( (lv_terms_5_0= ruleConditionalTerm ) ) )?
            {

            			newCompositeNode(grammarAccess.getConditionalTermAccess().getOrBooleanTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_50);
            this_OrBooleanTerm_0=ruleOrBooleanTerm();

            state._fsp--;


            			current = this_OrBooleanTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalRoQME.g:4511:3: ( () otherlv_2= '?' ( (lv_terms_3_0= ruleOrBooleanTerm ) ) otherlv_4= ':' ( (lv_terms_5_0= ruleConditionalTerm ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==69) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalRoQME.g:4512:4: () otherlv_2= '?' ( (lv_terms_3_0= ruleOrBooleanTerm ) ) otherlv_4= ':' ( (lv_terms_5_0= ruleConditionalTerm ) )
                    {
                    // InternalRoQME.g:4512:4: ()
                    // InternalRoQME.g:4513:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getConditionalTermAccess().getConditionalTermTermsAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,69,FOLLOW_12); 

                    				newLeafNode(otherlv_2, grammarAccess.getConditionalTermAccess().getQuestionMarkKeyword_1_1());
                    			
                    // InternalRoQME.g:4523:4: ( (lv_terms_3_0= ruleOrBooleanTerm ) )
                    // InternalRoQME.g:4524:5: (lv_terms_3_0= ruleOrBooleanTerm )
                    {
                    // InternalRoQME.g:4524:5: (lv_terms_3_0= ruleOrBooleanTerm )
                    // InternalRoQME.g:4525:6: lv_terms_3_0= ruleOrBooleanTerm
                    {

                    						newCompositeNode(grammarAccess.getConditionalTermAccess().getTermsOrBooleanTermParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_terms_3_0=ruleOrBooleanTerm();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConditionalTermRule());
                    						}
                    						add(
                    							current,
                    							"terms",
                    							lv_terms_3_0,
                    							"org.xtext.roqme.RoQME.OrBooleanTerm");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,14,FOLLOW_12); 

                    				newLeafNode(otherlv_4, grammarAccess.getConditionalTermAccess().getColonKeyword_1_3());
                    			
                    // InternalRoQME.g:4546:4: ( (lv_terms_5_0= ruleConditionalTerm ) )
                    // InternalRoQME.g:4547:5: (lv_terms_5_0= ruleConditionalTerm )
                    {
                    // InternalRoQME.g:4547:5: (lv_terms_5_0= ruleConditionalTerm )
                    // InternalRoQME.g:4548:6: lv_terms_5_0= ruleConditionalTerm
                    {

                    						newCompositeNode(grammarAccess.getConditionalTermAccess().getTermsConditionalTermParserRuleCall_1_4_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_terms_5_0=ruleConditionalTerm();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConditionalTermRule());
                    						}
                    						add(
                    							current,
                    							"terms",
                    							lv_terms_5_0,
                    							"org.xtext.roqme.RoQME.ConditionalTerm");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


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
    // $ANTLR end "ruleConditionalTerm"


    // $ANTLR start "entryRuleOrBooleanTerm"
    // InternalRoQME.g:4570:1: entryRuleOrBooleanTerm returns [EObject current=null] : iv_ruleOrBooleanTerm= ruleOrBooleanTerm EOF ;
    public final EObject entryRuleOrBooleanTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrBooleanTerm = null;


        try {
            // InternalRoQME.g:4570:54: (iv_ruleOrBooleanTerm= ruleOrBooleanTerm EOF )
            // InternalRoQME.g:4571:2: iv_ruleOrBooleanTerm= ruleOrBooleanTerm EOF
            {
             newCompositeNode(grammarAccess.getOrBooleanTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrBooleanTerm=ruleOrBooleanTerm();

            state._fsp--;

             current =iv_ruleOrBooleanTerm; 
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
    // $ANTLR end "entryRuleOrBooleanTerm"


    // $ANTLR start "ruleOrBooleanTerm"
    // InternalRoQME.g:4577:1: ruleOrBooleanTerm returns [EObject current=null] : (this_AndBooleanTerm_0= ruleAndBooleanTerm ( () otherlv_2= '|' ( (lv_right_3_0= ruleAndBooleanTerm ) ) )* ) ;
    public final EObject ruleOrBooleanTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndBooleanTerm_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:4583:2: ( (this_AndBooleanTerm_0= ruleAndBooleanTerm ( () otherlv_2= '|' ( (lv_right_3_0= ruleAndBooleanTerm ) ) )* ) )
            // InternalRoQME.g:4584:2: (this_AndBooleanTerm_0= ruleAndBooleanTerm ( () otherlv_2= '|' ( (lv_right_3_0= ruleAndBooleanTerm ) ) )* )
            {
            // InternalRoQME.g:4584:2: (this_AndBooleanTerm_0= ruleAndBooleanTerm ( () otherlv_2= '|' ( (lv_right_3_0= ruleAndBooleanTerm ) ) )* )
            // InternalRoQME.g:4585:3: this_AndBooleanTerm_0= ruleAndBooleanTerm ( () otherlv_2= '|' ( (lv_right_3_0= ruleAndBooleanTerm ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrBooleanTermAccess().getAndBooleanTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_51);
            this_AndBooleanTerm_0=ruleAndBooleanTerm();

            state._fsp--;


            			current = this_AndBooleanTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalRoQME.g:4593:3: ( () otherlv_2= '|' ( (lv_right_3_0= ruleAndBooleanTerm ) ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==70) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalRoQME.g:4594:4: () otherlv_2= '|' ( (lv_right_3_0= ruleAndBooleanTerm ) )
            	    {
            	    // InternalRoQME.g:4594:4: ()
            	    // InternalRoQME.g:4595:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrBooleanTermAccess().getOrBooleanTermLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,70,FOLLOW_12); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrBooleanTermAccess().getVerticalLineKeyword_1_1());
            	    			
            	    // InternalRoQME.g:4605:4: ( (lv_right_3_0= ruleAndBooleanTerm ) )
            	    // InternalRoQME.g:4606:5: (lv_right_3_0= ruleAndBooleanTerm )
            	    {
            	    // InternalRoQME.g:4606:5: (lv_right_3_0= ruleAndBooleanTerm )
            	    // InternalRoQME.g:4607:6: lv_right_3_0= ruleAndBooleanTerm
            	    {

            	    						newCompositeNode(grammarAccess.getOrBooleanTermAccess().getRightAndBooleanTermParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_51);
            	    lv_right_3_0=ruleAndBooleanTerm();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrBooleanTermRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.xtext.roqme.RoQME.AndBooleanTerm");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop59;
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
    // $ANTLR end "ruleOrBooleanTerm"


    // $ANTLR start "entryRuleAndBooleanTerm"
    // InternalRoQME.g:4629:1: entryRuleAndBooleanTerm returns [EObject current=null] : iv_ruleAndBooleanTerm= ruleAndBooleanTerm EOF ;
    public final EObject entryRuleAndBooleanTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndBooleanTerm = null;


        try {
            // InternalRoQME.g:4629:55: (iv_ruleAndBooleanTerm= ruleAndBooleanTerm EOF )
            // InternalRoQME.g:4630:2: iv_ruleAndBooleanTerm= ruleAndBooleanTerm EOF
            {
             newCompositeNode(grammarAccess.getAndBooleanTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndBooleanTerm=ruleAndBooleanTerm();

            state._fsp--;

             current =iv_ruleAndBooleanTerm; 
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
    // $ANTLR end "entryRuleAndBooleanTerm"


    // $ANTLR start "ruleAndBooleanTerm"
    // InternalRoQME.g:4636:1: ruleAndBooleanTerm returns [EObject current=null] : ( (this_NotBooleanTerm_0= ruleNotBooleanTerm | this_RelationalTerm_1= ruleRelationalTerm ) ( () otherlv_3= '&' ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) ) )* ) ;
    public final EObject ruleAndBooleanTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject this_NotBooleanTerm_0 = null;

        EObject this_RelationalTerm_1 = null;

        EObject lv_right_4_1 = null;

        EObject lv_right_4_2 = null;



        	enterRule();

        try {
            // InternalRoQME.g:4642:2: ( ( (this_NotBooleanTerm_0= ruleNotBooleanTerm | this_RelationalTerm_1= ruleRelationalTerm ) ( () otherlv_3= '&' ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) ) )* ) )
            // InternalRoQME.g:4643:2: ( (this_NotBooleanTerm_0= ruleNotBooleanTerm | this_RelationalTerm_1= ruleRelationalTerm ) ( () otherlv_3= '&' ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) ) )* )
            {
            // InternalRoQME.g:4643:2: ( (this_NotBooleanTerm_0= ruleNotBooleanTerm | this_RelationalTerm_1= ruleRelationalTerm ) ( () otherlv_3= '&' ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) ) )* )
            // InternalRoQME.g:4644:3: (this_NotBooleanTerm_0= ruleNotBooleanTerm | this_RelationalTerm_1= ruleRelationalTerm ) ( () otherlv_3= '&' ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) ) )*
            {
            // InternalRoQME.g:4644:3: (this_NotBooleanTerm_0= ruleNotBooleanTerm | this_RelationalTerm_1= ruleRelationalTerm )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==72) ) {
                alt60=1;
            }
            else if ( ((LA60_0>=RULE_ID && LA60_0<=RULE_INT)||LA60_0==38||LA60_0==48||LA60_0==61||LA60_0==80||(LA60_0>=83 && LA60_0<=84)||(LA60_0>=87 && LA60_0<=88)||(LA60_0>=97 && LA60_0<=117)) ) {
                alt60=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // InternalRoQME.g:4645:4: this_NotBooleanTerm_0= ruleNotBooleanTerm
                    {

                    				newCompositeNode(grammarAccess.getAndBooleanTermAccess().getNotBooleanTermParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_52);
                    this_NotBooleanTerm_0=ruleNotBooleanTerm();

                    state._fsp--;


                    				current = this_NotBooleanTerm_0;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:4654:4: this_RelationalTerm_1= ruleRelationalTerm
                    {

                    				newCompositeNode(grammarAccess.getAndBooleanTermAccess().getRelationalTermParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_52);
                    this_RelationalTerm_1=ruleRelationalTerm();

                    state._fsp--;


                    				current = this_RelationalTerm_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalRoQME.g:4663:3: ( () otherlv_3= '&' ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==71) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalRoQME.g:4664:4: () otherlv_3= '&' ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) )
            	    {
            	    // InternalRoQME.g:4664:4: ()
            	    // InternalRoQME.g:4665:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndBooleanTermAccess().getAndBooleanTermLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_3=(Token)match(input,71,FOLLOW_12); 

            	    				newLeafNode(otherlv_3, grammarAccess.getAndBooleanTermAccess().getAmpersandKeyword_1_1());
            	    			
            	    // InternalRoQME.g:4675:4: ( ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) ) )
            	    // InternalRoQME.g:4676:5: ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) )
            	    {
            	    // InternalRoQME.g:4676:5: ( (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm ) )
            	    // InternalRoQME.g:4677:6: (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm )
            	    {
            	    // InternalRoQME.g:4677:6: (lv_right_4_1= ruleNotBooleanTerm | lv_right_4_2= ruleRelationalTerm )
            	    int alt61=2;
            	    int LA61_0 = input.LA(1);

            	    if ( (LA61_0==72) ) {
            	        alt61=1;
            	    }
            	    else if ( ((LA61_0>=RULE_ID && LA61_0<=RULE_INT)||LA61_0==38||LA61_0==48||LA61_0==61||LA61_0==80||(LA61_0>=83 && LA61_0<=84)||(LA61_0>=87 && LA61_0<=88)||(LA61_0>=97 && LA61_0<=117)) ) {
            	        alt61=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 61, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt61) {
            	        case 1 :
            	            // InternalRoQME.g:4678:7: lv_right_4_1= ruleNotBooleanTerm
            	            {

            	            							newCompositeNode(grammarAccess.getAndBooleanTermAccess().getRightNotBooleanTermParserRuleCall_1_2_0_0());
            	            						
            	            pushFollow(FOLLOW_52);
            	            lv_right_4_1=ruleNotBooleanTerm();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getAndBooleanTermRule());
            	            							}
            	            							set(
            	            								current,
            	            								"right",
            	            								lv_right_4_1,
            	            								"org.xtext.roqme.RoQME.NotBooleanTerm");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalRoQME.g:4694:7: lv_right_4_2= ruleRelationalTerm
            	            {

            	            							newCompositeNode(grammarAccess.getAndBooleanTermAccess().getRightRelationalTermParserRuleCall_1_2_0_1());
            	            						
            	            pushFollow(FOLLOW_52);
            	            lv_right_4_2=ruleRelationalTerm();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getAndBooleanTermRule());
            	            							}
            	            							set(
            	            								current,
            	            								"right",
            	            								lv_right_4_2,
            	            								"org.xtext.roqme.RoQME.RelationalTerm");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop62;
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
    // $ANTLR end "ruleAndBooleanTerm"


    // $ANTLR start "entryRuleNotBooleanTerm"
    // InternalRoQME.g:4717:1: entryRuleNotBooleanTerm returns [EObject current=null] : iv_ruleNotBooleanTerm= ruleNotBooleanTerm EOF ;
    public final EObject entryRuleNotBooleanTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotBooleanTerm = null;


        try {
            // InternalRoQME.g:4717:55: (iv_ruleNotBooleanTerm= ruleNotBooleanTerm EOF )
            // InternalRoQME.g:4718:2: iv_ruleNotBooleanTerm= ruleNotBooleanTerm EOF
            {
             newCompositeNode(grammarAccess.getNotBooleanTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNotBooleanTerm=ruleNotBooleanTerm();

            state._fsp--;

             current =iv_ruleNotBooleanTerm; 
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
    // $ANTLR end "entryRuleNotBooleanTerm"


    // $ANTLR start "ruleNotBooleanTerm"
    // InternalRoQME.g:4724:1: ruleNotBooleanTerm returns [EObject current=null] : ( () otherlv_1= '!' ( (lv_term_2_0= ruleRelationalTerm ) ) ) ;
    public final EObject ruleNotBooleanTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_term_2_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:4730:2: ( ( () otherlv_1= '!' ( (lv_term_2_0= ruleRelationalTerm ) ) ) )
            // InternalRoQME.g:4731:2: ( () otherlv_1= '!' ( (lv_term_2_0= ruleRelationalTerm ) ) )
            {
            // InternalRoQME.g:4731:2: ( () otherlv_1= '!' ( (lv_term_2_0= ruleRelationalTerm ) ) )
            // InternalRoQME.g:4732:3: () otherlv_1= '!' ( (lv_term_2_0= ruleRelationalTerm ) )
            {
            // InternalRoQME.g:4732:3: ()
            // InternalRoQME.g:4733:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNotBooleanTermAccess().getNotBooleanTermAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,72,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getNotBooleanTermAccess().getExclamationMarkKeyword_1());
            		
            // InternalRoQME.g:4743:3: ( (lv_term_2_0= ruleRelationalTerm ) )
            // InternalRoQME.g:4744:4: (lv_term_2_0= ruleRelationalTerm )
            {
            // InternalRoQME.g:4744:4: (lv_term_2_0= ruleRelationalTerm )
            // InternalRoQME.g:4745:5: lv_term_2_0= ruleRelationalTerm
            {

            					newCompositeNode(grammarAccess.getNotBooleanTermAccess().getTermRelationalTermParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_term_2_0=ruleRelationalTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNotBooleanTermRule());
            					}
            					set(
            						current,
            						"term",
            						lv_term_2_0,
            						"org.xtext.roqme.RoQME.RelationalTerm");
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
    // $ANTLR end "ruleNotBooleanTerm"


    // $ANTLR start "entryRuleRelationalTerm"
    // InternalRoQME.g:4766:1: entryRuleRelationalTerm returns [EObject current=null] : iv_ruleRelationalTerm= ruleRelationalTerm EOF ;
    public final EObject entryRuleRelationalTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalTerm = null;


        try {
            // InternalRoQME.g:4766:55: (iv_ruleRelationalTerm= ruleRelationalTerm EOF )
            // InternalRoQME.g:4767:2: iv_ruleRelationalTerm= ruleRelationalTerm EOF
            {
             newCompositeNode(grammarAccess.getRelationalTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelationalTerm=ruleRelationalTerm();

            state._fsp--;

             current =iv_ruleRelationalTerm; 
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
    // $ANTLR end "entryRuleRelationalTerm"


    // $ANTLR start "ruleRelationalTerm"
    // InternalRoQME.g:4773:1: ruleRelationalTerm returns [EObject current=null] : (this_AdditionTerm_0= ruleAdditionTerm ( ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) ) ( (lv_right_13_0= ruleAdditionTerm ) ) )? ) ;
    public final EObject ruleRelationalTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject this_AdditionTerm_0 = null;

        EObject lv_right_13_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:4779:2: ( (this_AdditionTerm_0= ruleAdditionTerm ( ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) ) ( (lv_right_13_0= ruleAdditionTerm ) ) )? ) )
            // InternalRoQME.g:4780:2: (this_AdditionTerm_0= ruleAdditionTerm ( ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) ) ( (lv_right_13_0= ruleAdditionTerm ) ) )? )
            {
            // InternalRoQME.g:4780:2: (this_AdditionTerm_0= ruleAdditionTerm ( ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) ) ( (lv_right_13_0= ruleAdditionTerm ) ) )? )
            // InternalRoQME.g:4781:3: this_AdditionTerm_0= ruleAdditionTerm ( ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) ) ( (lv_right_13_0= ruleAdditionTerm ) ) )?
            {

            			newCompositeNode(grammarAccess.getRelationalTermAccess().getAdditionTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_53);
            this_AdditionTerm_0=ruleAdditionTerm();

            state._fsp--;


            			current = this_AdditionTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalRoQME.g:4789:3: ( ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) ) ( (lv_right_13_0= ruleAdditionTerm ) ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( ((LA64_0>=73 && LA64_0<=78)) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalRoQME.g:4790:4: ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) ) ( (lv_right_13_0= ruleAdditionTerm ) )
                    {
                    // InternalRoQME.g:4790:4: ( ( () otherlv_2= '=' ) | ( () otherlv_4= '<' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '<=' ) | ( () otherlv_10= '>=' ) | ( () otherlv_12= '!=' ) )
                    int alt63=6;
                    switch ( input.LA(1) ) {
                    case 73:
                        {
                        alt63=1;
                        }
                        break;
                    case 74:
                        {
                        alt63=2;
                        }
                        break;
                    case 75:
                        {
                        alt63=3;
                        }
                        break;
                    case 76:
                        {
                        alt63=4;
                        }
                        break;
                    case 77:
                        {
                        alt63=5;
                        }
                        break;
                    case 78:
                        {
                        alt63=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 63, 0, input);

                        throw nvae;
                    }

                    switch (alt63) {
                        case 1 :
                            // InternalRoQME.g:4791:5: ( () otherlv_2= '=' )
                            {
                            // InternalRoQME.g:4791:5: ( () otherlv_2= '=' )
                            // InternalRoQME.g:4792:6: () otherlv_2= '='
                            {
                            // InternalRoQME.g:4792:6: ()
                            // InternalRoQME.g:4793:7: 
                            {

                            							current = forceCreateModelElementAndSet(
                            								grammarAccess.getRelationalTermAccess().getEqualTermLeftAction_1_0_0_0(),
                            								current);
                            						

                            }

                            otherlv_2=(Token)match(input,73,FOLLOW_12); 

                            						newLeafNode(otherlv_2, grammarAccess.getRelationalTermAccess().getEqualsSignKeyword_1_0_0_1());
                            					

                            }


                            }
                            break;
                        case 2 :
                            // InternalRoQME.g:4805:5: ( () otherlv_4= '<' )
                            {
                            // InternalRoQME.g:4805:5: ( () otherlv_4= '<' )
                            // InternalRoQME.g:4806:6: () otherlv_4= '<'
                            {
                            // InternalRoQME.g:4806:6: ()
                            // InternalRoQME.g:4807:7: 
                            {

                            							current = forceCreateModelElementAndSet(
                            								grammarAccess.getRelationalTermAccess().getLessThanTermLeftAction_1_0_1_0(),
                            								current);
                            						

                            }

                            otherlv_4=(Token)match(input,74,FOLLOW_12); 

                            						newLeafNode(otherlv_4, grammarAccess.getRelationalTermAccess().getLessThanSignKeyword_1_0_1_1());
                            					

                            }


                            }
                            break;
                        case 3 :
                            // InternalRoQME.g:4819:5: ( () otherlv_6= '>' )
                            {
                            // InternalRoQME.g:4819:5: ( () otherlv_6= '>' )
                            // InternalRoQME.g:4820:6: () otherlv_6= '>'
                            {
                            // InternalRoQME.g:4820:6: ()
                            // InternalRoQME.g:4821:7: 
                            {

                            							current = forceCreateModelElementAndSet(
                            								grammarAccess.getRelationalTermAccess().getGreaterThanTermLeftAction_1_0_2_0(),
                            								current);
                            						

                            }

                            otherlv_6=(Token)match(input,75,FOLLOW_12); 

                            						newLeafNode(otherlv_6, grammarAccess.getRelationalTermAccess().getGreaterThanSignKeyword_1_0_2_1());
                            					

                            }


                            }
                            break;
                        case 4 :
                            // InternalRoQME.g:4833:5: ( () otherlv_8= '<=' )
                            {
                            // InternalRoQME.g:4833:5: ( () otherlv_8= '<=' )
                            // InternalRoQME.g:4834:6: () otherlv_8= '<='
                            {
                            // InternalRoQME.g:4834:6: ()
                            // InternalRoQME.g:4835:7: 
                            {

                            							current = forceCreateModelElementAndSet(
                            								grammarAccess.getRelationalTermAccess().getLessEqualTermLeftAction_1_0_3_0(),
                            								current);
                            						

                            }

                            otherlv_8=(Token)match(input,76,FOLLOW_12); 

                            						newLeafNode(otherlv_8, grammarAccess.getRelationalTermAccess().getLessThanSignEqualsSignKeyword_1_0_3_1());
                            					

                            }


                            }
                            break;
                        case 5 :
                            // InternalRoQME.g:4847:5: ( () otherlv_10= '>=' )
                            {
                            // InternalRoQME.g:4847:5: ( () otherlv_10= '>=' )
                            // InternalRoQME.g:4848:6: () otherlv_10= '>='
                            {
                            // InternalRoQME.g:4848:6: ()
                            // InternalRoQME.g:4849:7: 
                            {

                            							current = forceCreateModelElementAndSet(
                            								grammarAccess.getRelationalTermAccess().getGreaterEqualTermLeftAction_1_0_4_0(),
                            								current);
                            						

                            }

                            otherlv_10=(Token)match(input,77,FOLLOW_12); 

                            						newLeafNode(otherlv_10, grammarAccess.getRelationalTermAccess().getGreaterThanSignEqualsSignKeyword_1_0_4_1());
                            					

                            }


                            }
                            break;
                        case 6 :
                            // InternalRoQME.g:4861:5: ( () otherlv_12= '!=' )
                            {
                            // InternalRoQME.g:4861:5: ( () otherlv_12= '!=' )
                            // InternalRoQME.g:4862:6: () otherlv_12= '!='
                            {
                            // InternalRoQME.g:4862:6: ()
                            // InternalRoQME.g:4863:7: 
                            {

                            							current = forceCreateModelElementAndSet(
                            								grammarAccess.getRelationalTermAccess().getNotEqualTermLeftAction_1_0_5_0(),
                            								current);
                            						

                            }

                            otherlv_12=(Token)match(input,78,FOLLOW_12); 

                            						newLeafNode(otherlv_12, grammarAccess.getRelationalTermAccess().getExclamationMarkEqualsSignKeyword_1_0_5_1());
                            					

                            }


                            }
                            break;

                    }

                    // InternalRoQME.g:4875:4: ( (lv_right_13_0= ruleAdditionTerm ) )
                    // InternalRoQME.g:4876:5: (lv_right_13_0= ruleAdditionTerm )
                    {
                    // InternalRoQME.g:4876:5: (lv_right_13_0= ruleAdditionTerm )
                    // InternalRoQME.g:4877:6: lv_right_13_0= ruleAdditionTerm
                    {

                    						newCompositeNode(grammarAccess.getRelationalTermAccess().getRightAdditionTermParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_right_13_0=ruleAdditionTerm();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRelationalTermRule());
                    						}
                    						set(
                    							current,
                    							"right",
                    							lv_right_13_0,
                    							"org.xtext.roqme.RoQME.AdditionTerm");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


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
    // $ANTLR end "ruleRelationalTerm"


    // $ANTLR start "entryRuleAdditionTerm"
    // InternalRoQME.g:4899:1: entryRuleAdditionTerm returns [EObject current=null] : iv_ruleAdditionTerm= ruleAdditionTerm EOF ;
    public final EObject entryRuleAdditionTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditionTerm = null;


        try {
            // InternalRoQME.g:4899:53: (iv_ruleAdditionTerm= ruleAdditionTerm EOF )
            // InternalRoQME.g:4900:2: iv_ruleAdditionTerm= ruleAdditionTerm EOF
            {
             newCompositeNode(grammarAccess.getAdditionTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAdditionTerm=ruleAdditionTerm();

            state._fsp--;

             current =iv_ruleAdditionTerm; 
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
    // $ANTLR end "entryRuleAdditionTerm"


    // $ANTLR start "ruleAdditionTerm"
    // InternalRoQME.g:4906:1: ruleAdditionTerm returns [EObject current=null] : (this_MultiplicationTerm_0= ruleMultiplicationTerm ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationTerm ) ) )* ) ;
    public final EObject ruleAdditionTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_MultiplicationTerm_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:4912:2: ( (this_MultiplicationTerm_0= ruleMultiplicationTerm ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationTerm ) ) )* ) )
            // InternalRoQME.g:4913:2: (this_MultiplicationTerm_0= ruleMultiplicationTerm ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationTerm ) ) )* )
            {
            // InternalRoQME.g:4913:2: (this_MultiplicationTerm_0= ruleMultiplicationTerm ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationTerm ) ) )* )
            // InternalRoQME.g:4914:3: this_MultiplicationTerm_0= ruleMultiplicationTerm ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationTerm ) ) )*
            {

            			newCompositeNode(grammarAccess.getAdditionTermAccess().getMultiplicationTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_54);
            this_MultiplicationTerm_0=ruleMultiplicationTerm();

            state._fsp--;


            			current = this_MultiplicationTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalRoQME.g:4922:3: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationTerm ) ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( ((LA66_0>=79 && LA66_0<=80)) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalRoQME.g:4923:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplicationTerm ) )
            	    {
            	    // InternalRoQME.g:4923:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt65=2;
            	    int LA65_0 = input.LA(1);

            	    if ( (LA65_0==79) ) {
            	        alt65=1;
            	    }
            	    else if ( (LA65_0==80) ) {
            	        alt65=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 65, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt65) {
            	        case 1 :
            	            // InternalRoQME.g:4924:5: ( () otherlv_2= '+' )
            	            {
            	            // InternalRoQME.g:4924:5: ( () otherlv_2= '+' )
            	            // InternalRoQME.g:4925:6: () otherlv_2= '+'
            	            {
            	            // InternalRoQME.g:4925:6: ()
            	            // InternalRoQME.g:4926:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionTermAccess().getAddTermLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,79,FOLLOW_12); 

            	            						newLeafNode(otherlv_2, grammarAccess.getAdditionTermAccess().getPlusSignKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalRoQME.g:4938:5: ( () otherlv_4= '-' )
            	            {
            	            // InternalRoQME.g:4938:5: ( () otherlv_4= '-' )
            	            // InternalRoQME.g:4939:6: () otherlv_4= '-'
            	            {
            	            // InternalRoQME.g:4939:6: ()
            	            // InternalRoQME.g:4940:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionTermAccess().getSubTermLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,80,FOLLOW_12); 

            	            						newLeafNode(otherlv_4, grammarAccess.getAdditionTermAccess().getHyphenMinusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalRoQME.g:4952:4: ( (lv_right_5_0= ruleMultiplicationTerm ) )
            	    // InternalRoQME.g:4953:5: (lv_right_5_0= ruleMultiplicationTerm )
            	    {
            	    // InternalRoQME.g:4953:5: (lv_right_5_0= ruleMultiplicationTerm )
            	    // InternalRoQME.g:4954:6: lv_right_5_0= ruleMultiplicationTerm
            	    {

            	    						newCompositeNode(grammarAccess.getAdditionTermAccess().getRightMultiplicationTermParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_54);
            	    lv_right_5_0=ruleMultiplicationTerm();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAdditionTermRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_5_0,
            	    							"org.xtext.roqme.RoQME.MultiplicationTerm");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop66;
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
    // $ANTLR end "ruleAdditionTerm"


    // $ANTLR start "entryRuleMultiplicationTerm"
    // InternalRoQME.g:4976:1: entryRuleMultiplicationTerm returns [EObject current=null] : iv_ruleMultiplicationTerm= ruleMultiplicationTerm EOF ;
    public final EObject entryRuleMultiplicationTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicationTerm = null;


        try {
            // InternalRoQME.g:4976:59: (iv_ruleMultiplicationTerm= ruleMultiplicationTerm EOF )
            // InternalRoQME.g:4977:2: iv_ruleMultiplicationTerm= ruleMultiplicationTerm EOF
            {
             newCompositeNode(grammarAccess.getMultiplicationTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicationTerm=ruleMultiplicationTerm();

            state._fsp--;

             current =iv_ruleMultiplicationTerm; 
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
    // $ANTLR end "entryRuleMultiplicationTerm"


    // $ANTLR start "ruleMultiplicationTerm"
    // InternalRoQME.g:4983:1: ruleMultiplicationTerm returns [EObject current=null] : (this_PrimaryTerm_0= rulePrimaryTerm ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryTerm ) ) )* ) ;
    public final EObject ruleMultiplicationTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_PrimaryTerm_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:4989:2: ( (this_PrimaryTerm_0= rulePrimaryTerm ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryTerm ) ) )* ) )
            // InternalRoQME.g:4990:2: (this_PrimaryTerm_0= rulePrimaryTerm ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryTerm ) ) )* )
            {
            // InternalRoQME.g:4990:2: (this_PrimaryTerm_0= rulePrimaryTerm ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryTerm ) ) )* )
            // InternalRoQME.g:4991:3: this_PrimaryTerm_0= rulePrimaryTerm ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryTerm ) ) )*
            {

            			newCompositeNode(grammarAccess.getMultiplicationTermAccess().getPrimaryTermParserRuleCall_0());
            		
            pushFollow(FOLLOW_55);
            this_PrimaryTerm_0=rulePrimaryTerm();

            state._fsp--;


            			current = this_PrimaryTerm_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalRoQME.g:4999:3: ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryTerm ) ) )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( ((LA68_0>=81 && LA68_0<=82)) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalRoQME.g:5000:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryTerm ) )
            	    {
            	    // InternalRoQME.g:5000:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) )
            	    int alt67=2;
            	    int LA67_0 = input.LA(1);

            	    if ( (LA67_0==81) ) {
            	        alt67=1;
            	    }
            	    else if ( (LA67_0==82) ) {
            	        alt67=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 67, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt67) {
            	        case 1 :
            	            // InternalRoQME.g:5001:5: ( () otherlv_2= '*' )
            	            {
            	            // InternalRoQME.g:5001:5: ( () otherlv_2= '*' )
            	            // InternalRoQME.g:5002:6: () otherlv_2= '*'
            	            {
            	            // InternalRoQME.g:5002:6: ()
            	            // InternalRoQME.g:5003:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationTermAccess().getMultTermLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,81,FOLLOW_12); 

            	            						newLeafNode(otherlv_2, grammarAccess.getMultiplicationTermAccess().getAsteriskKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalRoQME.g:5015:5: ( () otherlv_4= '/' )
            	            {
            	            // InternalRoQME.g:5015:5: ( () otherlv_4= '/' )
            	            // InternalRoQME.g:5016:6: () otherlv_4= '/'
            	            {
            	            // InternalRoQME.g:5016:6: ()
            	            // InternalRoQME.g:5017:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationTermAccess().getDivTermLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,82,FOLLOW_12); 

            	            						newLeafNode(otherlv_4, grammarAccess.getMultiplicationTermAccess().getSolidusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalRoQME.g:5029:4: ( (lv_right_5_0= rulePrimaryTerm ) )
            	    // InternalRoQME.g:5030:5: (lv_right_5_0= rulePrimaryTerm )
            	    {
            	    // InternalRoQME.g:5030:5: (lv_right_5_0= rulePrimaryTerm )
            	    // InternalRoQME.g:5031:6: lv_right_5_0= rulePrimaryTerm
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplicationTermAccess().getRightPrimaryTermParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_55);
            	    lv_right_5_0=rulePrimaryTerm();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMultiplicationTermRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_5_0,
            	    							"org.xtext.roqme.RoQME.PrimaryTerm");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop68;
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
    // $ANTLR end "ruleMultiplicationTerm"


    // $ANTLR start "entryRulePrimaryTerm"
    // InternalRoQME.g:5053:1: entryRulePrimaryTerm returns [EObject current=null] : iv_rulePrimaryTerm= rulePrimaryTerm EOF ;
    public final EObject entryRulePrimaryTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryTerm = null;


        try {
            // InternalRoQME.g:5053:52: (iv_rulePrimaryTerm= rulePrimaryTerm EOF )
            // InternalRoQME.g:5054:2: iv_rulePrimaryTerm= rulePrimaryTerm EOF
            {
             newCompositeNode(grammarAccess.getPrimaryTermRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryTerm=rulePrimaryTerm();

            state._fsp--;

             current =iv_rulePrimaryTerm; 
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
    // $ANTLR end "entryRulePrimaryTerm"


    // $ANTLR start "rulePrimaryTerm"
    // InternalRoQME.g:5060:1: rulePrimaryTerm returns [EObject current=null] : ( (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' ) | this_ConstTerm_3= ruleConstTerm | this_VarTerm_4= ruleVarTerm | this_SelfTerm_5= ruleSelfTerm | this_FunctionTerm_6= ruleFunctionTerm ) ;
    public final EObject rulePrimaryTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Term_1 = null;

        EObject this_ConstTerm_3 = null;

        EObject this_VarTerm_4 = null;

        EObject this_SelfTerm_5 = null;

        EObject this_FunctionTerm_6 = null;



        	enterRule();

        try {
            // InternalRoQME.g:5066:2: ( ( (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' ) | this_ConstTerm_3= ruleConstTerm | this_VarTerm_4= ruleVarTerm | this_SelfTerm_5= ruleSelfTerm | this_FunctionTerm_6= ruleFunctionTerm ) )
            // InternalRoQME.g:5067:2: ( (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' ) | this_ConstTerm_3= ruleConstTerm | this_VarTerm_4= ruleVarTerm | this_SelfTerm_5= ruleSelfTerm | this_FunctionTerm_6= ruleFunctionTerm )
            {
            // InternalRoQME.g:5067:2: ( (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' ) | this_ConstTerm_3= ruleConstTerm | this_VarTerm_4= ruleVarTerm | this_SelfTerm_5= ruleSelfTerm | this_FunctionTerm_6= ruleFunctionTerm )
            int alt69=5;
            alt69 = dfa69.predict(input);
            switch (alt69) {
                case 1 :
                    // InternalRoQME.g:5068:3: (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' )
                    {
                    // InternalRoQME.g:5068:3: (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' )
                    // InternalRoQME.g:5069:4: otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,61,FOLLOW_12); 

                    				newLeafNode(otherlv_0, grammarAccess.getPrimaryTermAccess().getLeftParenthesisKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryTermAccess().getTermParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_45);
                    this_Term_1=ruleTerm();

                    state._fsp--;


                    				current = this_Term_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,62,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrimaryTermAccess().getRightParenthesisKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRoQME.g:5087:3: this_ConstTerm_3= ruleConstTerm
                    {

                    			newCompositeNode(grammarAccess.getPrimaryTermAccess().getConstTermParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ConstTerm_3=ruleConstTerm();

                    state._fsp--;


                    			current = this_ConstTerm_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRoQME.g:5096:3: this_VarTerm_4= ruleVarTerm
                    {

                    			newCompositeNode(grammarAccess.getPrimaryTermAccess().getVarTermParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_VarTerm_4=ruleVarTerm();

                    state._fsp--;


                    			current = this_VarTerm_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalRoQME.g:5105:3: this_SelfTerm_5= ruleSelfTerm
                    {

                    			newCompositeNode(grammarAccess.getPrimaryTermAccess().getSelfTermParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_SelfTerm_5=ruleSelfTerm();

                    state._fsp--;


                    			current = this_SelfTerm_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalRoQME.g:5114:3: this_FunctionTerm_6= ruleFunctionTerm
                    {

                    			newCompositeNode(grammarAccess.getPrimaryTermAccess().getFunctionTermParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_FunctionTerm_6=ruleFunctionTerm();

                    state._fsp--;


                    			current = this_FunctionTerm_6;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "rulePrimaryTerm"


    // $ANTLR start "entryRuleVarTerm"
    // InternalRoQME.g:5126:1: entryRuleVarTerm returns [EObject current=null] : iv_ruleVarTerm= ruleVarTerm EOF ;
    public final EObject entryRuleVarTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarTerm = null;


        try {
            // InternalRoQME.g:5126:48: (iv_ruleVarTerm= ruleVarTerm EOF )
            // InternalRoQME.g:5127:2: iv_ruleVarTerm= ruleVarTerm EOF
            {
             newCompositeNode(grammarAccess.getVarTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVarTerm=ruleVarTerm();

            state._fsp--;

             current =iv_ruleVarTerm; 
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
    // $ANTLR end "entryRuleVarTerm"


    // $ANTLR start "ruleVarTerm"
    // InternalRoQME.g:5133:1: ruleVarTerm returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleVarTerm() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalRoQME.g:5139:2: ( ( ( ruleQualifiedName ) ) )
            // InternalRoQME.g:5140:2: ( ( ruleQualifiedName ) )
            {
            // InternalRoQME.g:5140:2: ( ( ruleQualifiedName ) )
            // InternalRoQME.g:5141:3: ( ruleQualifiedName )
            {
            // InternalRoQME.g:5141:3: ( ruleQualifiedName )
            // InternalRoQME.g:5142:4: ruleQualifiedName
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getVarTermRule());
            				}
            			

            				newCompositeNode(grammarAccess.getVarTermAccess().getVariableTypedVariableCrossReference_0());
            			
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleVarTerm"


    // $ANTLR start "entryRuleConstTerm"
    // InternalRoQME.g:5159:1: entryRuleConstTerm returns [EObject current=null] : iv_ruleConstTerm= ruleConstTerm EOF ;
    public final EObject entryRuleConstTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstTerm = null;


        try {
            // InternalRoQME.g:5159:50: (iv_ruleConstTerm= ruleConstTerm EOF )
            // InternalRoQME.g:5160:2: iv_ruleConstTerm= ruleConstTerm EOF
            {
             newCompositeNode(grammarAccess.getConstTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstTerm=ruleConstTerm();

            state._fsp--;

             current =iv_ruleConstTerm; 
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
    // $ANTLR end "entryRuleConstTerm"


    // $ANTLR start "ruleConstTerm"
    // InternalRoQME.g:5166:1: ruleConstTerm returns [EObject current=null] : ( (lv_value_0_0= ruleTypedValue ) ) ;
    public final EObject ruleConstTerm() throws RecognitionException {
        EObject current = null;

        EObject lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:5172:2: ( ( (lv_value_0_0= ruleTypedValue ) ) )
            // InternalRoQME.g:5173:2: ( (lv_value_0_0= ruleTypedValue ) )
            {
            // InternalRoQME.g:5173:2: ( (lv_value_0_0= ruleTypedValue ) )
            // InternalRoQME.g:5174:3: (lv_value_0_0= ruleTypedValue )
            {
            // InternalRoQME.g:5174:3: (lv_value_0_0= ruleTypedValue )
            // InternalRoQME.g:5175:4: lv_value_0_0= ruleTypedValue
            {

            				newCompositeNode(grammarAccess.getConstTermAccess().getValueTypedValueParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleTypedValue();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getConstTermRule());
            				}
            				set(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.xtext.roqme.RoQME.TypedValue");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleConstTerm"


    // $ANTLR start "entryRuleSelfTerm"
    // InternalRoQME.g:5195:1: entryRuleSelfTerm returns [EObject current=null] : iv_ruleSelfTerm= ruleSelfTerm EOF ;
    public final EObject entryRuleSelfTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfTerm = null;


        try {
            // InternalRoQME.g:5195:49: (iv_ruleSelfTerm= ruleSelfTerm EOF )
            // InternalRoQME.g:5196:2: iv_ruleSelfTerm= ruleSelfTerm EOF
            {
             newCompositeNode(grammarAccess.getSelfTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSelfTerm=ruleSelfTerm();

            state._fsp--;

             current =iv_ruleSelfTerm; 
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
    // $ANTLR end "entryRuleSelfTerm"


    // $ANTLR start "ruleSelfTerm"
    // InternalRoQME.g:5202:1: ruleSelfTerm returns [EObject current=null] : ( () otherlv_1= 'belief' ) ;
    public final EObject ruleSelfTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRoQME.g:5208:2: ( ( () otherlv_1= 'belief' ) )
            // InternalRoQME.g:5209:2: ( () otherlv_1= 'belief' )
            {
            // InternalRoQME.g:5209:2: ( () otherlv_1= 'belief' )
            // InternalRoQME.g:5210:3: () otherlv_1= 'belief'
            {
            // InternalRoQME.g:5210:3: ()
            // InternalRoQME.g:5211:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSelfTermAccess().getSelfTermAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,83,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getSelfTermAccess().getBeliefKeyword_1());
            		

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
    // $ANTLR end "ruleSelfTerm"


    // $ANTLR start "entryRuleFunctionTerm"
    // InternalRoQME.g:5225:1: entryRuleFunctionTerm returns [EObject current=null] : iv_ruleFunctionTerm= ruleFunctionTerm EOF ;
    public final EObject entryRuleFunctionTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionTerm = null;


        try {
            // InternalRoQME.g:5225:53: (iv_ruleFunctionTerm= ruleFunctionTerm EOF )
            // InternalRoQME.g:5226:2: iv_ruleFunctionTerm= ruleFunctionTerm EOF
            {
             newCompositeNode(grammarAccess.getFunctionTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionTerm=ruleFunctionTerm();

            state._fsp--;

             current =iv_ruleFunctionTerm; 
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
    // $ANTLR end "entryRuleFunctionTerm"


    // $ANTLR start "ruleFunctionTerm"
    // InternalRoQME.g:5232:1: ruleFunctionTerm returns [EObject current=null] : (this_ArithFunction_0= ruleArithFunction | this_AggregationFunction_1= ruleAggregationFunction | this_PatternFunction_2= rulePatternFunction | this_CollectionFunction_3= ruleCollectionFunction | this_ScheduleFunction_4= ruleScheduleFunction ) ;
    public final EObject ruleFunctionTerm() throws RecognitionException {
        EObject current = null;

        EObject this_ArithFunction_0 = null;

        EObject this_AggregationFunction_1 = null;

        EObject this_PatternFunction_2 = null;

        EObject this_CollectionFunction_3 = null;

        EObject this_ScheduleFunction_4 = null;



        	enterRule();

        try {
            // InternalRoQME.g:5238:2: ( (this_ArithFunction_0= ruleArithFunction | this_AggregationFunction_1= ruleAggregationFunction | this_PatternFunction_2= rulePatternFunction | this_CollectionFunction_3= ruleCollectionFunction | this_ScheduleFunction_4= ruleScheduleFunction ) )
            // InternalRoQME.g:5239:2: (this_ArithFunction_0= ruleArithFunction | this_AggregationFunction_1= ruleAggregationFunction | this_PatternFunction_2= rulePatternFunction | this_CollectionFunction_3= ruleCollectionFunction | this_ScheduleFunction_4= ruleScheduleFunction )
            {
            // InternalRoQME.g:5239:2: (this_ArithFunction_0= ruleArithFunction | this_AggregationFunction_1= ruleAggregationFunction | this_PatternFunction_2= rulePatternFunction | this_CollectionFunction_3= ruleCollectionFunction | this_ScheduleFunction_4= ruleScheduleFunction )
            int alt70=5;
            alt70 = dfa70.predict(input);
            switch (alt70) {
                case 1 :
                    // InternalRoQME.g:5240:3: this_ArithFunction_0= ruleArithFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionTermAccess().getArithFunctionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArithFunction_0=ruleArithFunction();

                    state._fsp--;


                    			current = this_ArithFunction_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:5249:3: this_AggregationFunction_1= ruleAggregationFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionTermAccess().getAggregationFunctionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_AggregationFunction_1=ruleAggregationFunction();

                    state._fsp--;


                    			current = this_AggregationFunction_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRoQME.g:5258:3: this_PatternFunction_2= rulePatternFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionTermAccess().getPatternFunctionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_PatternFunction_2=rulePatternFunction();

                    state._fsp--;


                    			current = this_PatternFunction_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalRoQME.g:5267:3: this_CollectionFunction_3= ruleCollectionFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionTermAccess().getCollectionFunctionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_CollectionFunction_3=ruleCollectionFunction();

                    state._fsp--;


                    			current = this_CollectionFunction_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalRoQME.g:5276:3: this_ScheduleFunction_4= ruleScheduleFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionTermAccess().getScheduleFunctionParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_ScheduleFunction_4=ruleScheduleFunction();

                    state._fsp--;


                    			current = this_ScheduleFunction_4;
                    			afterParserOrEnumRuleCall();
                    		

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
    // $ANTLR end "ruleFunctionTerm"


    // $ANTLR start "entryRuleScheduleFunction"
    // InternalRoQME.g:5288:1: entryRuleScheduleFunction returns [EObject current=null] : iv_ruleScheduleFunction= ruleScheduleFunction EOF ;
    public final EObject entryRuleScheduleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScheduleFunction = null;


        try {
            // InternalRoQME.g:5288:57: (iv_ruleScheduleFunction= ruleScheduleFunction EOF )
            // InternalRoQME.g:5289:2: iv_ruleScheduleFunction= ruleScheduleFunction EOF
            {
             newCompositeNode(grammarAccess.getScheduleFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScheduleFunction=ruleScheduleFunction();

            state._fsp--;

             current =iv_ruleScheduleFunction; 
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
    // $ANTLR end "entryRuleScheduleFunction"


    // $ANTLR start "ruleScheduleFunction"
    // InternalRoQME.g:5295:1: ruleScheduleFunction returns [EObject current=null] : ( () otherlv_1= 'schedule' otherlv_2= '(' ( (lv_pattern_3_0= ruleEString ) ) otherlv_4= ')' ) ;
    public final EObject ruleScheduleFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_pattern_3_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:5301:2: ( ( () otherlv_1= 'schedule' otherlv_2= '(' ( (lv_pattern_3_0= ruleEString ) ) otherlv_4= ')' ) )
            // InternalRoQME.g:5302:2: ( () otherlv_1= 'schedule' otherlv_2= '(' ( (lv_pattern_3_0= ruleEString ) ) otherlv_4= ')' )
            {
            // InternalRoQME.g:5302:2: ( () otherlv_1= 'schedule' otherlv_2= '(' ( (lv_pattern_3_0= ruleEString ) ) otherlv_4= ')' )
            // InternalRoQME.g:5303:3: () otherlv_1= 'schedule' otherlv_2= '(' ( (lv_pattern_3_0= ruleEString ) ) otherlv_4= ')'
            {
            // InternalRoQME.g:5303:3: ()
            // InternalRoQME.g:5304:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getScheduleFunctionAccess().getScheduleFunctionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,84,FOLLOW_44); 

            			newLeafNode(otherlv_1, grammarAccess.getScheduleFunctionAccess().getScheduleKeyword_1());
            		
            otherlv_2=(Token)match(input,61,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getScheduleFunctionAccess().getLeftParenthesisKeyword_2());
            		
            // InternalRoQME.g:5318:3: ( (lv_pattern_3_0= ruleEString ) )
            // InternalRoQME.g:5319:4: (lv_pattern_3_0= ruleEString )
            {
            // InternalRoQME.g:5319:4: (lv_pattern_3_0= ruleEString )
            // InternalRoQME.g:5320:5: lv_pattern_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getScheduleFunctionAccess().getPatternEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_45);
            lv_pattern_3_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScheduleFunctionRule());
            					}
            					set(
            						current,
            						"pattern",
            						lv_pattern_3_0,
            						"org.xtext.roqme.RoQME.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,62,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getScheduleFunctionAccess().getRightParenthesisKeyword_4());
            		

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
    // $ANTLR end "ruleScheduleFunction"


    // $ANTLR start "entryRuleArithFunction"
    // InternalRoQME.g:5345:1: entryRuleArithFunction returns [EObject current=null] : iv_ruleArithFunction= ruleArithFunction EOF ;
    public final EObject entryRuleArithFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithFunction = null;


        try {
            // InternalRoQME.g:5345:54: (iv_ruleArithFunction= ruleArithFunction EOF )
            // InternalRoQME.g:5346:2: iv_ruleArithFunction= ruleArithFunction EOF
            {
             newCompositeNode(grammarAccess.getArithFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArithFunction=ruleArithFunction();

            state._fsp--;

             current =iv_ruleArithFunction; 
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
    // $ANTLR end "entryRuleArithFunction"


    // $ANTLR start "ruleArithFunction"
    // InternalRoQME.g:5352:1: ruleArithFunction returns [EObject current=null] : ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleArithFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) ;
    public final EObject ruleArithFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_terms_0_1 = null;

        EObject lv_terms_0_2 = null;

        Enumerator lv_name_2_0 = null;

        EObject lv_terms_4_0 = null;

        EObject lv_terms_6_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:5358:2: ( ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleArithFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) )
            // InternalRoQME.g:5359:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleArithFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            {
            // InternalRoQME.g:5359:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleArithFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            // InternalRoQME.g:5360:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleArithFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            {
            // InternalRoQME.g:5360:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_ID||LA72_0==83) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalRoQME.g:5361:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\''
                    {
                    // InternalRoQME.g:5361:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) )
                    // InternalRoQME.g:5362:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    {
                    // InternalRoQME.g:5362:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    // InternalRoQME.g:5363:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    {
                    // InternalRoQME.g:5363:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==RULE_ID) ) {
                        alt71=1;
                    }
                    else if ( (LA71_0==83) ) {
                        alt71=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 71, 0, input);

                        throw nvae;
                    }
                    switch (alt71) {
                        case 1 :
                            // InternalRoQME.g:5364:7: lv_terms_0_1= ruleVarTerm
                            {

                            							newCompositeNode(grammarAccess.getArithFunctionAccess().getTermsVarTermParserRuleCall_0_0_0_0());
                            						
                            pushFollow(FOLLOW_56);
                            lv_terms_0_1=ruleVarTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getArithFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_0_1,
                            								"org.xtext.roqme.RoQME.VarTerm");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;
                        case 2 :
                            // InternalRoQME.g:5380:7: lv_terms_0_2= ruleSelfTerm
                            {

                            							newCompositeNode(grammarAccess.getArithFunctionAccess().getTermsSelfTermParserRuleCall_0_0_0_1());
                            						
                            pushFollow(FOLLOW_56);
                            lv_terms_0_2=ruleSelfTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getArithFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_0_2,
                            								"org.xtext.roqme.RoQME.SelfTerm");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_1=(Token)match(input,85,FOLLOW_57); 

                    				newLeafNode(otherlv_1, grammarAccess.getArithFunctionAccess().getApostropheKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalRoQME.g:5403:3: ( (lv_name_2_0= ruleArithFtnEnum ) )
            // InternalRoQME.g:5404:4: (lv_name_2_0= ruleArithFtnEnum )
            {
            // InternalRoQME.g:5404:4: (lv_name_2_0= ruleArithFtnEnum )
            // InternalRoQME.g:5405:5: lv_name_2_0= ruleArithFtnEnum
            {

            					newCompositeNode(grammarAccess.getArithFunctionAccess().getNameArithFtnEnumEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_58);
            lv_name_2_0=ruleArithFtnEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArithFunctionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.roqme.RoQME.ArithFtnEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoQME.g:5422:3: (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==61) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalRoQME.g:5423:4: otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,61,FOLLOW_59); 

                    				newLeafNode(otherlv_3, grammarAccess.getArithFunctionAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalRoQME.g:5427:4: ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( ((LA74_0>=RULE_ID && LA74_0<=RULE_INT)||LA74_0==38||LA74_0==48||LA74_0==59||LA74_0==61||LA74_0==68||LA74_0==72||LA74_0==80||(LA74_0>=83 && LA74_0<=84)||(LA74_0>=87 && LA74_0<=88)||(LA74_0>=97 && LA74_0<=117)) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // InternalRoQME.g:5428:5: ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            {
                            // InternalRoQME.g:5428:5: ( (lv_terms_4_0= ruleTerm ) )
                            // InternalRoQME.g:5429:6: (lv_terms_4_0= ruleTerm )
                            {
                            // InternalRoQME.g:5429:6: (lv_terms_4_0= ruleTerm )
                            // InternalRoQME.g:5430:7: lv_terms_4_0= ruleTerm
                            {

                            							newCompositeNode(grammarAccess.getArithFunctionAccess().getTermsTermParserRuleCall_2_1_0_0());
                            						
                            pushFollow(FOLLOW_60);
                            lv_terms_4_0=ruleTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getArithFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_4_0,
                            								"org.xtext.roqme.RoQME.Term");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalRoQME.g:5447:5: (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            loop73:
                            do {
                                int alt73=2;
                                int LA73_0 = input.LA(1);

                                if ( (LA73_0==41) ) {
                                    alt73=1;
                                }


                                switch (alt73) {
                            	case 1 :
                            	    // InternalRoQME.g:5448:6: otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) )
                            	    {
                            	    otherlv_5=(Token)match(input,41,FOLLOW_12); 

                            	    						newLeafNode(otherlv_5, grammarAccess.getArithFunctionAccess().getCommaKeyword_2_1_1_0());
                            	    					
                            	    // InternalRoQME.g:5452:6: ( (lv_terms_6_0= ruleTerm ) )
                            	    // InternalRoQME.g:5453:7: (lv_terms_6_0= ruleTerm )
                            	    {
                            	    // InternalRoQME.g:5453:7: (lv_terms_6_0= ruleTerm )
                            	    // InternalRoQME.g:5454:8: lv_terms_6_0= ruleTerm
                            	    {

                            	    								newCompositeNode(grammarAccess.getArithFunctionAccess().getTermsTermParserRuleCall_2_1_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_60);
                            	    lv_terms_6_0=ruleTerm();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getArithFunctionRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"terms",
                            	    									lv_terms_6_0,
                            	    									"org.xtext.roqme.RoQME.Term");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop73;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,62,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getArithFunctionAccess().getRightParenthesisKeyword_2_2());
                    			

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
    // $ANTLR end "ruleArithFunction"


    // $ANTLR start "entryRuleAggregationFunction"
    // InternalRoQME.g:5482:1: entryRuleAggregationFunction returns [EObject current=null] : iv_ruleAggregationFunction= ruleAggregationFunction EOF ;
    public final EObject entryRuleAggregationFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAggregationFunction = null;


        try {
            // InternalRoQME.g:5482:60: (iv_ruleAggregationFunction= ruleAggregationFunction EOF )
            // InternalRoQME.g:5483:2: iv_ruleAggregationFunction= ruleAggregationFunction EOF
            {
             newCompositeNode(grammarAccess.getAggregationFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAggregationFunction=ruleAggregationFunction();

            state._fsp--;

             current =iv_ruleAggregationFunction; 
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
    // $ANTLR end "entryRuleAggregationFunction"


    // $ANTLR start "ruleAggregationFunction"
    // InternalRoQME.g:5489:1: ruleAggregationFunction returns [EObject current=null] : ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleAggregationFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) ;
    public final EObject ruleAggregationFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_terms_0_1 = null;

        EObject lv_terms_0_2 = null;

        Enumerator lv_name_2_0 = null;

        EObject lv_terms_4_0 = null;

        EObject lv_terms_6_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:5495:2: ( ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleAggregationFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) )
            // InternalRoQME.g:5496:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleAggregationFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            {
            // InternalRoQME.g:5496:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleAggregationFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            // InternalRoQME.g:5497:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleAggregationFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            {
            // InternalRoQME.g:5497:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==RULE_ID||LA77_0==83) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalRoQME.g:5498:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\''
                    {
                    // InternalRoQME.g:5498:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) )
                    // InternalRoQME.g:5499:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    {
                    // InternalRoQME.g:5499:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    // InternalRoQME.g:5500:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    {
                    // InternalRoQME.g:5500:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( (LA76_0==RULE_ID) ) {
                        alt76=1;
                    }
                    else if ( (LA76_0==83) ) {
                        alt76=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 76, 0, input);

                        throw nvae;
                    }
                    switch (alt76) {
                        case 1 :
                            // InternalRoQME.g:5501:7: lv_terms_0_1= ruleVarTerm
                            {

                            							newCompositeNode(grammarAccess.getAggregationFunctionAccess().getTermsVarTermParserRuleCall_0_0_0_0());
                            						
                            pushFollow(FOLLOW_56);
                            lv_terms_0_1=ruleVarTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getAggregationFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_0_1,
                            								"org.xtext.roqme.RoQME.VarTerm");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;
                        case 2 :
                            // InternalRoQME.g:5517:7: lv_terms_0_2= ruleSelfTerm
                            {

                            							newCompositeNode(grammarAccess.getAggregationFunctionAccess().getTermsSelfTermParserRuleCall_0_0_0_1());
                            						
                            pushFollow(FOLLOW_56);
                            lv_terms_0_2=ruleSelfTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getAggregationFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_0_2,
                            								"org.xtext.roqme.RoQME.SelfTerm");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_1=(Token)match(input,85,FOLLOW_61); 

                    				newLeafNode(otherlv_1, grammarAccess.getAggregationFunctionAccess().getApostropheKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalRoQME.g:5540:3: ( (lv_name_2_0= ruleAggregationFtnEnum ) )
            // InternalRoQME.g:5541:4: (lv_name_2_0= ruleAggregationFtnEnum )
            {
            // InternalRoQME.g:5541:4: (lv_name_2_0= ruleAggregationFtnEnum )
            // InternalRoQME.g:5542:5: lv_name_2_0= ruleAggregationFtnEnum
            {

            					newCompositeNode(grammarAccess.getAggregationFunctionAccess().getNameAggregationFtnEnumEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_58);
            lv_name_2_0=ruleAggregationFtnEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAggregationFunctionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.roqme.RoQME.AggregationFtnEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoQME.g:5559:3: (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==61) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalRoQME.g:5560:4: otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,61,FOLLOW_59); 

                    				newLeafNode(otherlv_3, grammarAccess.getAggregationFunctionAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalRoQME.g:5564:4: ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )?
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( ((LA79_0>=RULE_ID && LA79_0<=RULE_INT)||LA79_0==38||LA79_0==48||LA79_0==59||LA79_0==61||LA79_0==68||LA79_0==72||LA79_0==80||(LA79_0>=83 && LA79_0<=84)||(LA79_0>=87 && LA79_0<=88)||(LA79_0>=97 && LA79_0<=117)) ) {
                        alt79=1;
                    }
                    switch (alt79) {
                        case 1 :
                            // InternalRoQME.g:5565:5: ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            {
                            // InternalRoQME.g:5565:5: ( (lv_terms_4_0= ruleTerm ) )
                            // InternalRoQME.g:5566:6: (lv_terms_4_0= ruleTerm )
                            {
                            // InternalRoQME.g:5566:6: (lv_terms_4_0= ruleTerm )
                            // InternalRoQME.g:5567:7: lv_terms_4_0= ruleTerm
                            {

                            							newCompositeNode(grammarAccess.getAggregationFunctionAccess().getTermsTermParserRuleCall_2_1_0_0());
                            						
                            pushFollow(FOLLOW_60);
                            lv_terms_4_0=ruleTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getAggregationFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_4_0,
                            								"org.xtext.roqme.RoQME.Term");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalRoQME.g:5584:5: (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            loop78:
                            do {
                                int alt78=2;
                                int LA78_0 = input.LA(1);

                                if ( (LA78_0==41) ) {
                                    alt78=1;
                                }


                                switch (alt78) {
                            	case 1 :
                            	    // InternalRoQME.g:5585:6: otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) )
                            	    {
                            	    otherlv_5=(Token)match(input,41,FOLLOW_12); 

                            	    						newLeafNode(otherlv_5, grammarAccess.getAggregationFunctionAccess().getCommaKeyword_2_1_1_0());
                            	    					
                            	    // InternalRoQME.g:5589:6: ( (lv_terms_6_0= ruleTerm ) )
                            	    // InternalRoQME.g:5590:7: (lv_terms_6_0= ruleTerm )
                            	    {
                            	    // InternalRoQME.g:5590:7: (lv_terms_6_0= ruleTerm )
                            	    // InternalRoQME.g:5591:8: lv_terms_6_0= ruleTerm
                            	    {

                            	    								newCompositeNode(grammarAccess.getAggregationFunctionAccess().getTermsTermParserRuleCall_2_1_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_60);
                            	    lv_terms_6_0=ruleTerm();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getAggregationFunctionRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"terms",
                            	    									lv_terms_6_0,
                            	    									"org.xtext.roqme.RoQME.Term");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop78;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,62,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getAggregationFunctionAccess().getRightParenthesisKeyword_2_2());
                    			

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
    // $ANTLR end "ruleAggregationFunction"


    // $ANTLR start "entryRulePatternFunction"
    // InternalRoQME.g:5619:1: entryRulePatternFunction returns [EObject current=null] : iv_rulePatternFunction= rulePatternFunction EOF ;
    public final EObject entryRulePatternFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternFunction = null;


        try {
            // InternalRoQME.g:5619:56: (iv_rulePatternFunction= rulePatternFunction EOF )
            // InternalRoQME.g:5620:2: iv_rulePatternFunction= rulePatternFunction EOF
            {
             newCompositeNode(grammarAccess.getPatternFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePatternFunction=rulePatternFunction();

            state._fsp--;

             current =iv_rulePatternFunction; 
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
    // $ANTLR end "entryRulePatternFunction"


    // $ANTLR start "rulePatternFunction"
    // InternalRoQME.g:5626:1: rulePatternFunction returns [EObject current=null] : ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= rulePatternFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) ;
    public final EObject rulePatternFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_terms_0_1 = null;

        EObject lv_terms_0_2 = null;

        Enumerator lv_name_2_0 = null;

        EObject lv_terms_4_0 = null;

        EObject lv_terms_6_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:5632:2: ( ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= rulePatternFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) )
            // InternalRoQME.g:5633:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= rulePatternFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            {
            // InternalRoQME.g:5633:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= rulePatternFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            // InternalRoQME.g:5634:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= rulePatternFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            {
            // InternalRoQME.g:5634:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==RULE_ID||LA82_0==83) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalRoQME.g:5635:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\''
                    {
                    // InternalRoQME.g:5635:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) )
                    // InternalRoQME.g:5636:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    {
                    // InternalRoQME.g:5636:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    // InternalRoQME.g:5637:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    {
                    // InternalRoQME.g:5637:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==RULE_ID) ) {
                        alt81=1;
                    }
                    else if ( (LA81_0==83) ) {
                        alt81=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 81, 0, input);

                        throw nvae;
                    }
                    switch (alt81) {
                        case 1 :
                            // InternalRoQME.g:5638:7: lv_terms_0_1= ruleVarTerm
                            {

                            							newCompositeNode(grammarAccess.getPatternFunctionAccess().getTermsVarTermParserRuleCall_0_0_0_0());
                            						
                            pushFollow(FOLLOW_56);
                            lv_terms_0_1=ruleVarTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getPatternFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_0_1,
                            								"org.xtext.roqme.RoQME.VarTerm");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;
                        case 2 :
                            // InternalRoQME.g:5654:7: lv_terms_0_2= ruleSelfTerm
                            {

                            							newCompositeNode(grammarAccess.getPatternFunctionAccess().getTermsSelfTermParserRuleCall_0_0_0_1());
                            						
                            pushFollow(FOLLOW_56);
                            lv_terms_0_2=ruleSelfTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getPatternFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_0_2,
                            								"org.xtext.roqme.RoQME.SelfTerm");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_1=(Token)match(input,85,FOLLOW_62); 

                    				newLeafNode(otherlv_1, grammarAccess.getPatternFunctionAccess().getApostropheKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalRoQME.g:5677:3: ( (lv_name_2_0= rulePatternFtnEnum ) )
            // InternalRoQME.g:5678:4: (lv_name_2_0= rulePatternFtnEnum )
            {
            // InternalRoQME.g:5678:4: (lv_name_2_0= rulePatternFtnEnum )
            // InternalRoQME.g:5679:5: lv_name_2_0= rulePatternFtnEnum
            {

            					newCompositeNode(grammarAccess.getPatternFunctionAccess().getNamePatternFtnEnumEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_58);
            lv_name_2_0=rulePatternFtnEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPatternFunctionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.roqme.RoQME.PatternFtnEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoQME.g:5696:3: (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==61) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalRoQME.g:5697:4: otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,61,FOLLOW_59); 

                    				newLeafNode(otherlv_3, grammarAccess.getPatternFunctionAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalRoQME.g:5701:4: ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )?
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( ((LA84_0>=RULE_ID && LA84_0<=RULE_INT)||LA84_0==38||LA84_0==48||LA84_0==59||LA84_0==61||LA84_0==68||LA84_0==72||LA84_0==80||(LA84_0>=83 && LA84_0<=84)||(LA84_0>=87 && LA84_0<=88)||(LA84_0>=97 && LA84_0<=117)) ) {
                        alt84=1;
                    }
                    switch (alt84) {
                        case 1 :
                            // InternalRoQME.g:5702:5: ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            {
                            // InternalRoQME.g:5702:5: ( (lv_terms_4_0= ruleTerm ) )
                            // InternalRoQME.g:5703:6: (lv_terms_4_0= ruleTerm )
                            {
                            // InternalRoQME.g:5703:6: (lv_terms_4_0= ruleTerm )
                            // InternalRoQME.g:5704:7: lv_terms_4_0= ruleTerm
                            {

                            							newCompositeNode(grammarAccess.getPatternFunctionAccess().getTermsTermParserRuleCall_2_1_0_0());
                            						
                            pushFollow(FOLLOW_60);
                            lv_terms_4_0=ruleTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getPatternFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_4_0,
                            								"org.xtext.roqme.RoQME.Term");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalRoQME.g:5721:5: (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            loop83:
                            do {
                                int alt83=2;
                                int LA83_0 = input.LA(1);

                                if ( (LA83_0==41) ) {
                                    alt83=1;
                                }


                                switch (alt83) {
                            	case 1 :
                            	    // InternalRoQME.g:5722:6: otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) )
                            	    {
                            	    otherlv_5=(Token)match(input,41,FOLLOW_12); 

                            	    						newLeafNode(otherlv_5, grammarAccess.getPatternFunctionAccess().getCommaKeyword_2_1_1_0());
                            	    					
                            	    // InternalRoQME.g:5726:6: ( (lv_terms_6_0= ruleTerm ) )
                            	    // InternalRoQME.g:5727:7: (lv_terms_6_0= ruleTerm )
                            	    {
                            	    // InternalRoQME.g:5727:7: (lv_terms_6_0= ruleTerm )
                            	    // InternalRoQME.g:5728:8: lv_terms_6_0= ruleTerm
                            	    {

                            	    								newCompositeNode(grammarAccess.getPatternFunctionAccess().getTermsTermParserRuleCall_2_1_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_60);
                            	    lv_terms_6_0=ruleTerm();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getPatternFunctionRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"terms",
                            	    									lv_terms_6_0,
                            	    									"org.xtext.roqme.RoQME.Term");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop83;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,62,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getPatternFunctionAccess().getRightParenthesisKeyword_2_2());
                    			

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
    // $ANTLR end "rulePatternFunction"


    // $ANTLR start "entryRuleCollectionFunction"
    // InternalRoQME.g:5756:1: entryRuleCollectionFunction returns [EObject current=null] : iv_ruleCollectionFunction= ruleCollectionFunction EOF ;
    public final EObject entryRuleCollectionFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionFunction = null;


        try {
            // InternalRoQME.g:5756:59: (iv_ruleCollectionFunction= ruleCollectionFunction EOF )
            // InternalRoQME.g:5757:2: iv_ruleCollectionFunction= ruleCollectionFunction EOF
            {
             newCompositeNode(grammarAccess.getCollectionFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCollectionFunction=ruleCollectionFunction();

            state._fsp--;

             current =iv_ruleCollectionFunction; 
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
    // $ANTLR end "entryRuleCollectionFunction"


    // $ANTLR start "ruleCollectionFunction"
    // InternalRoQME.g:5763:1: ruleCollectionFunction returns [EObject current=null] : ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleCollectionFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) ;
    public final EObject ruleCollectionFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_terms_0_1 = null;

        EObject lv_terms_0_2 = null;

        Enumerator lv_name_2_0 = null;

        EObject lv_terms_4_0 = null;

        EObject lv_terms_6_0 = null;



        	enterRule();

        try {
            // InternalRoQME.g:5769:2: ( ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleCollectionFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? ) )
            // InternalRoQME.g:5770:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleCollectionFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            {
            // InternalRoQME.g:5770:2: ( ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleCollectionFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )? )
            // InternalRoQME.g:5771:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )? ( (lv_name_2_0= ruleCollectionFtnEnum ) ) (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            {
            // InternalRoQME.g:5771:3: ( ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\'' )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==RULE_ID||LA87_0==83) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalRoQME.g:5772:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) ) otherlv_1= '\\''
                    {
                    // InternalRoQME.g:5772:4: ( ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) ) )
                    // InternalRoQME.g:5773:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    {
                    // InternalRoQME.g:5773:5: ( (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm ) )
                    // InternalRoQME.g:5774:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    {
                    // InternalRoQME.g:5774:6: (lv_terms_0_1= ruleVarTerm | lv_terms_0_2= ruleSelfTerm )
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( (LA86_0==RULE_ID) ) {
                        alt86=1;
                    }
                    else if ( (LA86_0==83) ) {
                        alt86=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 86, 0, input);

                        throw nvae;
                    }
                    switch (alt86) {
                        case 1 :
                            // InternalRoQME.g:5775:7: lv_terms_0_1= ruleVarTerm
                            {

                            							newCompositeNode(grammarAccess.getCollectionFunctionAccess().getTermsVarTermParserRuleCall_0_0_0_0());
                            						
                            pushFollow(FOLLOW_56);
                            lv_terms_0_1=ruleVarTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getCollectionFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_0_1,
                            								"org.xtext.roqme.RoQME.VarTerm");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;
                        case 2 :
                            // InternalRoQME.g:5791:7: lv_terms_0_2= ruleSelfTerm
                            {

                            							newCompositeNode(grammarAccess.getCollectionFunctionAccess().getTermsSelfTermParserRuleCall_0_0_0_1());
                            						
                            pushFollow(FOLLOW_56);
                            lv_terms_0_2=ruleSelfTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getCollectionFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_0_2,
                            								"org.xtext.roqme.RoQME.SelfTerm");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_1=(Token)match(input,85,FOLLOW_63); 

                    				newLeafNode(otherlv_1, grammarAccess.getCollectionFunctionAccess().getApostropheKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalRoQME.g:5814:3: ( (lv_name_2_0= ruleCollectionFtnEnum ) )
            // InternalRoQME.g:5815:4: (lv_name_2_0= ruleCollectionFtnEnum )
            {
            // InternalRoQME.g:5815:4: (lv_name_2_0= ruleCollectionFtnEnum )
            // InternalRoQME.g:5816:5: lv_name_2_0= ruleCollectionFtnEnum
            {

            					newCompositeNode(grammarAccess.getCollectionFunctionAccess().getNameCollectionFtnEnumEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_58);
            lv_name_2_0=ruleCollectionFtnEnum();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCollectionFunctionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.roqme.RoQME.CollectionFtnEnum");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRoQME.g:5833:3: (otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')' )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==61) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalRoQME.g:5834:4: otherlv_3= '(' ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )? otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,61,FOLLOW_59); 

                    				newLeafNode(otherlv_3, grammarAccess.getCollectionFunctionAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalRoQME.g:5838:4: ( ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )* )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( ((LA89_0>=RULE_ID && LA89_0<=RULE_INT)||LA89_0==38||LA89_0==48||LA89_0==59||LA89_0==61||LA89_0==68||LA89_0==72||LA89_0==80||(LA89_0>=83 && LA89_0<=84)||(LA89_0>=87 && LA89_0<=88)||(LA89_0>=97 && LA89_0<=117)) ) {
                        alt89=1;
                    }
                    switch (alt89) {
                        case 1 :
                            // InternalRoQME.g:5839:5: ( (lv_terms_4_0= ruleTerm ) ) (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            {
                            // InternalRoQME.g:5839:5: ( (lv_terms_4_0= ruleTerm ) )
                            // InternalRoQME.g:5840:6: (lv_terms_4_0= ruleTerm )
                            {
                            // InternalRoQME.g:5840:6: (lv_terms_4_0= ruleTerm )
                            // InternalRoQME.g:5841:7: lv_terms_4_0= ruleTerm
                            {

                            							newCompositeNode(grammarAccess.getCollectionFunctionAccess().getTermsTermParserRuleCall_2_1_0_0());
                            						
                            pushFollow(FOLLOW_60);
                            lv_terms_4_0=ruleTerm();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getCollectionFunctionRule());
                            							}
                            							add(
                            								current,
                            								"terms",
                            								lv_terms_4_0,
                            								"org.xtext.roqme.RoQME.Term");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalRoQME.g:5858:5: (otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) ) )*
                            loop88:
                            do {
                                int alt88=2;
                                int LA88_0 = input.LA(1);

                                if ( (LA88_0==41) ) {
                                    alt88=1;
                                }


                                switch (alt88) {
                            	case 1 :
                            	    // InternalRoQME.g:5859:6: otherlv_5= ',' ( (lv_terms_6_0= ruleTerm ) )
                            	    {
                            	    otherlv_5=(Token)match(input,41,FOLLOW_12); 

                            	    						newLeafNode(otherlv_5, grammarAccess.getCollectionFunctionAccess().getCommaKeyword_2_1_1_0());
                            	    					
                            	    // InternalRoQME.g:5863:6: ( (lv_terms_6_0= ruleTerm ) )
                            	    // InternalRoQME.g:5864:7: (lv_terms_6_0= ruleTerm )
                            	    {
                            	    // InternalRoQME.g:5864:7: (lv_terms_6_0= ruleTerm )
                            	    // InternalRoQME.g:5865:8: lv_terms_6_0= ruleTerm
                            	    {

                            	    								newCompositeNode(grammarAccess.getCollectionFunctionAccess().getTermsTermParserRuleCall_2_1_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_60);
                            	    lv_terms_6_0=ruleTerm();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getCollectionFunctionRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"terms",
                            	    									lv_terms_6_0,
                            	    									"org.xtext.roqme.RoQME.Term");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop88;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,62,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getCollectionFunctionAccess().getRightParenthesisKeyword_2_2());
                    			

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
    // $ANTLR end "ruleCollectionFunction"


    // $ANTLR start "entryRuleEString"
    // InternalRoQME.g:5893:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalRoQME.g:5893:47: (iv_ruleEString= ruleEString EOF )
            // InternalRoQME.g:5894:2: iv_ruleEString= ruleEString EOF
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
    // InternalRoQME.g:5900:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalRoQME.g:5906:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalRoQME.g:5907:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalRoQME.g:5907:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==RULE_STRING) ) {
                alt91=1;
            }
            else if ( (LA91_0==RULE_ID) ) {
                alt91=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // InternalRoQME.g:5908:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:5916:3: this_ID_1= RULE_ID
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
    // InternalRoQME.g:5927:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // InternalRoQME.g:5927:47: (iv_ruleEDouble= ruleEDouble EOF )
            // InternalRoQME.g:5928:2: iv_ruleEDouble= ruleEDouble EOF
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
    // InternalRoQME.g:5934:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;


        	enterRule();

        try {
            // InternalRoQME.g:5940:2: ( ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? ) )
            // InternalRoQME.g:5941:2: ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? )
            {
            // InternalRoQME.g:5941:2: ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? )
            // InternalRoQME.g:5942:3: (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )?
            {
            // InternalRoQME.g:5942:3: (kw= '-' )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==80) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalRoQME.g:5943:4: kw= '-'
                    {
                    kw=(Token)match(input,80,FOLLOW_30); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_64); 

            			current.merge(this_INT_1);
            		

            			newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1());
            		
            // InternalRoQME.g:5956:3: (kw= '.' this_INT_3= RULE_INT )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==86) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalRoQME.g:5957:4: kw= '.' this_INT_3= RULE_INT
                    {
                    kw=(Token)match(input,86,FOLLOW_30); 

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


    // $ANTLR start "entryRuleEBoolean"
    // InternalRoQME.g:5974:1: entryRuleEBoolean returns [String current=null] : iv_ruleEBoolean= ruleEBoolean EOF ;
    public final String entryRuleEBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBoolean = null;


        try {
            // InternalRoQME.g:5974:48: (iv_ruleEBoolean= ruleEBoolean EOF )
            // InternalRoQME.g:5975:2: iv_ruleEBoolean= ruleEBoolean EOF
            {
             newCompositeNode(grammarAccess.getEBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEBoolean=ruleEBoolean();

            state._fsp--;

             current =iv_ruleEBoolean.getText(); 
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
    // $ANTLR end "entryRuleEBoolean"


    // $ANTLR start "ruleEBoolean"
    // InternalRoQME.g:5981:1: ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRoQME.g:5987:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalRoQME.g:5988:2: (kw= 'true' | kw= 'false' )
            {
            // InternalRoQME.g:5988:2: (kw= 'true' | kw= 'false' )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==87) ) {
                alt94=1;
            }
            else if ( (LA94_0==88) ) {
                alt94=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }
            switch (alt94) {
                case 1 :
                    // InternalRoQME.g:5989:3: kw= 'true'
                    {
                    kw=(Token)match(input,87,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRoQME.g:5995:3: kw= 'false'
                    {
                    kw=(Token)match(input,88,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanAccess().getFalseKeyword_1());
                    		

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
    // $ANTLR end "ruleEBoolean"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalRoQME.g:6004:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalRoQME.g:6004:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalRoQME.g:6005:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalRoQME.g:6011:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalRoQME.g:6017:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalRoQME.g:6018:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalRoQME.g:6018:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalRoQME.g:6019:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_64); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalRoQME.g:6026:3: (kw= '.' this_ID_2= RULE_ID )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==86) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // InternalRoQME.g:6027:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,86,FOLLOW_8); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_64); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop95;
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


    // $ANTLR start "entryRuleLiteralQualifiedName"
    // InternalRoQME.g:6044:1: entryRuleLiteralQualifiedName returns [String current=null] : iv_ruleLiteralQualifiedName= ruleLiteralQualifiedName EOF ;
    public final String entryRuleLiteralQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLiteralQualifiedName = null;


        try {
            // InternalRoQME.g:6044:60: (iv_ruleLiteralQualifiedName= ruleLiteralQualifiedName EOF )
            // InternalRoQME.g:6045:2: iv_ruleLiteralQualifiedName= ruleLiteralQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getLiteralQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralQualifiedName=ruleLiteralQualifiedName();

            state._fsp--;

             current =iv_ruleLiteralQualifiedName.getText(); 
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
    // $ANTLR end "entryRuleLiteralQualifiedName"


    // $ANTLR start "ruleLiteralQualifiedName"
    // InternalRoQME.g:6051:1: ruleLiteralQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ ) ;
    public final AntlrDatatypeRuleToken ruleLiteralQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalRoQME.g:6057:2: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ ) )
            // InternalRoQME.g:6058:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ )
            {
            // InternalRoQME.g:6058:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+ )
            // InternalRoQME.g:6059:3: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )+
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_65); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getLiteralQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalRoQME.g:6066:3: (kw= '::' this_ID_2= RULE_ID )+
            int cnt96=0;
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==89) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // InternalRoQME.g:6067:4: kw= '::' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,89,FOLLOW_8); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getLiteralQualifiedNameAccess().getColonColonKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_66); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getLiteralQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt96 >= 1 ) break loop96;
                        EarlyExitException eee =
                            new EarlyExitException(96, input);
                        throw eee;
                }
                cnt96++;
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
    // $ANTLR end "ruleLiteralQualifiedName"


    // $ANTLR start "entryRuleElementDescription"
    // InternalRoQME.g:6084:1: entryRuleElementDescription returns [String current=null] : iv_ruleElementDescription= ruleElementDescription EOF ;
    public final String entryRuleElementDescription() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleElementDescription = null;


        try {
            // InternalRoQME.g:6084:58: (iv_ruleElementDescription= ruleElementDescription EOF )
            // InternalRoQME.g:6085:2: iv_ruleElementDescription= ruleElementDescription EOF
            {
             newCompositeNode(grammarAccess.getElementDescriptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElementDescription=ruleElementDescription();

            state._fsp--;

             current =iv_ruleElementDescription.getText(); 
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
    // $ANTLR end "entryRuleElementDescription"


    // $ANTLR start "ruleElementDescription"
    // InternalRoQME.g:6091:1: ruleElementDescription returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ROQME_DESCRIPTION_0= RULE_ROQME_DESCRIPTION ;
    public final AntlrDatatypeRuleToken ruleElementDescription() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ROQME_DESCRIPTION_0=null;


        	enterRule();

        try {
            // InternalRoQME.g:6097:2: (this_ROQME_DESCRIPTION_0= RULE_ROQME_DESCRIPTION )
            // InternalRoQME.g:6098:2: this_ROQME_DESCRIPTION_0= RULE_ROQME_DESCRIPTION
            {
            this_ROQME_DESCRIPTION_0=(Token)match(input,RULE_ROQME_DESCRIPTION,FOLLOW_2); 

            		current.merge(this_ROQME_DESCRIPTION_0);
            	

            		newLeafNode(this_ROQME_DESCRIPTION_0, grammarAccess.getElementDescriptionAccess().getROQME_DESCRIPTIONTerminalRuleCall());
            	

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
    // $ANTLR end "ruleElementDescription"


    // $ANTLR start "ruleInfluenceEnum"
    // InternalRoQME.g:6108:1: ruleInfluenceEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'reinforces' ) | (enumLiteral_1= 'undermines' ) ) ;
    public final Enumerator ruleInfluenceEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRoQME.g:6114:2: ( ( (enumLiteral_0= 'reinforces' ) | (enumLiteral_1= 'undermines' ) ) )
            // InternalRoQME.g:6115:2: ( (enumLiteral_0= 'reinforces' ) | (enumLiteral_1= 'undermines' ) )
            {
            // InternalRoQME.g:6115:2: ( (enumLiteral_0= 'reinforces' ) | (enumLiteral_1= 'undermines' ) )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==90) ) {
                alt97=1;
            }
            else if ( (LA97_0==91) ) {
                alt97=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }
            switch (alt97) {
                case 1 :
                    // InternalRoQME.g:6116:3: (enumLiteral_0= 'reinforces' )
                    {
                    // InternalRoQME.g:6116:3: (enumLiteral_0= 'reinforces' )
                    // InternalRoQME.g:6117:4: enumLiteral_0= 'reinforces'
                    {
                    enumLiteral_0=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getInfluenceEnumAccess().getREINFORCEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getInfluenceEnumAccess().getREINFORCEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRoQME.g:6124:3: (enumLiteral_1= 'undermines' )
                    {
                    // InternalRoQME.g:6124:3: (enumLiteral_1= 'undermines' )
                    // InternalRoQME.g:6125:4: enumLiteral_1= 'undermines'
                    {
                    enumLiteral_1=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getInfluenceEnumAccess().getUNDERMINEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getInfluenceEnumAccess().getUNDERMINEEnumLiteralDeclaration_1());
                    			

                    }


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
    // $ANTLR end "ruleInfluenceEnum"


    // $ANTLR start "ruleStrengthEnum"
    // InternalRoQME.g:6135:1: ruleStrengthEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'veryhigh' ) | (enumLiteral_1= 'high' ) | (enumLiteral_2= 'MEDIUM' ) | (enumLiteral_3= 'low' ) | (enumLiteral_4= 'verylow' ) ) ;
    public final Enumerator ruleStrengthEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalRoQME.g:6141:2: ( ( (enumLiteral_0= 'veryhigh' ) | (enumLiteral_1= 'high' ) | (enumLiteral_2= 'MEDIUM' ) | (enumLiteral_3= 'low' ) | (enumLiteral_4= 'verylow' ) ) )
            // InternalRoQME.g:6142:2: ( (enumLiteral_0= 'veryhigh' ) | (enumLiteral_1= 'high' ) | (enumLiteral_2= 'MEDIUM' ) | (enumLiteral_3= 'low' ) | (enumLiteral_4= 'verylow' ) )
            {
            // InternalRoQME.g:6142:2: ( (enumLiteral_0= 'veryhigh' ) | (enumLiteral_1= 'high' ) | (enumLiteral_2= 'MEDIUM' ) | (enumLiteral_3= 'low' ) | (enumLiteral_4= 'verylow' ) )
            int alt98=5;
            switch ( input.LA(1) ) {
            case 92:
                {
                alt98=1;
                }
                break;
            case 93:
                {
                alt98=2;
                }
                break;
            case 94:
                {
                alt98=3;
                }
                break;
            case 95:
                {
                alt98=4;
                }
                break;
            case 96:
                {
                alt98=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }

            switch (alt98) {
                case 1 :
                    // InternalRoQME.g:6143:3: (enumLiteral_0= 'veryhigh' )
                    {
                    // InternalRoQME.g:6143:3: (enumLiteral_0= 'veryhigh' )
                    // InternalRoQME.g:6144:4: enumLiteral_0= 'veryhigh'
                    {
                    enumLiteral_0=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getStrengthEnumAccess().getVERY_HIGHEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getStrengthEnumAccess().getVERY_HIGHEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRoQME.g:6151:3: (enumLiteral_1= 'high' )
                    {
                    // InternalRoQME.g:6151:3: (enumLiteral_1= 'high' )
                    // InternalRoQME.g:6152:4: enumLiteral_1= 'high'
                    {
                    enumLiteral_1=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getStrengthEnumAccess().getHIGHEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getStrengthEnumAccess().getHIGHEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRoQME.g:6159:3: (enumLiteral_2= 'MEDIUM' )
                    {
                    // InternalRoQME.g:6159:3: (enumLiteral_2= 'MEDIUM' )
                    // InternalRoQME.g:6160:4: enumLiteral_2= 'MEDIUM'
                    {
                    enumLiteral_2=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getStrengthEnumAccess().getMEDIUMEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getStrengthEnumAccess().getMEDIUMEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRoQME.g:6167:3: (enumLiteral_3= 'low' )
                    {
                    // InternalRoQME.g:6167:3: (enumLiteral_3= 'low' )
                    // InternalRoQME.g:6168:4: enumLiteral_3= 'low'
                    {
                    enumLiteral_3=(Token)match(input,95,FOLLOW_2); 

                    				current = grammarAccess.getStrengthEnumAccess().getLOWEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getStrengthEnumAccess().getLOWEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalRoQME.g:6175:3: (enumLiteral_4= 'verylow' )
                    {
                    // InternalRoQME.g:6175:3: (enumLiteral_4= 'verylow' )
                    // InternalRoQME.g:6176:4: enumLiteral_4= 'verylow'
                    {
                    enumLiteral_4=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getStrengthEnumAccess().getVERY_LOWEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getStrengthEnumAccess().getVERY_LOWEnumLiteralDeclaration_4());
                    			

                    }


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
    // $ANTLR end "ruleStrengthEnum"


    // $ANTLR start "ruleArithFtnEnum"
    // InternalRoQME.g:6186:1: ruleArithFtnEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'pow' ) | (enumLiteral_1= 'sqrt' ) | (enumLiteral_2= 'exp' ) | (enumLiteral_3= 'abs' ) ) ;
    public final Enumerator ruleArithFtnEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalRoQME.g:6192:2: ( ( (enumLiteral_0= 'pow' ) | (enumLiteral_1= 'sqrt' ) | (enumLiteral_2= 'exp' ) | (enumLiteral_3= 'abs' ) ) )
            // InternalRoQME.g:6193:2: ( (enumLiteral_0= 'pow' ) | (enumLiteral_1= 'sqrt' ) | (enumLiteral_2= 'exp' ) | (enumLiteral_3= 'abs' ) )
            {
            // InternalRoQME.g:6193:2: ( (enumLiteral_0= 'pow' ) | (enumLiteral_1= 'sqrt' ) | (enumLiteral_2= 'exp' ) | (enumLiteral_3= 'abs' ) )
            int alt99=4;
            switch ( input.LA(1) ) {
            case 97:
                {
                alt99=1;
                }
                break;
            case 98:
                {
                alt99=2;
                }
                break;
            case 99:
                {
                alt99=3;
                }
                break;
            case 100:
                {
                alt99=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;
            }

            switch (alt99) {
                case 1 :
                    // InternalRoQME.g:6194:3: (enumLiteral_0= 'pow' )
                    {
                    // InternalRoQME.g:6194:3: (enumLiteral_0= 'pow' )
                    // InternalRoQME.g:6195:4: enumLiteral_0= 'pow'
                    {
                    enumLiteral_0=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getArithFtnEnumAccess().getPOWEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getArithFtnEnumAccess().getPOWEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRoQME.g:6202:3: (enumLiteral_1= 'sqrt' )
                    {
                    // InternalRoQME.g:6202:3: (enumLiteral_1= 'sqrt' )
                    // InternalRoQME.g:6203:4: enumLiteral_1= 'sqrt'
                    {
                    enumLiteral_1=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getArithFtnEnumAccess().getSQRTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getArithFtnEnumAccess().getSQRTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRoQME.g:6210:3: (enumLiteral_2= 'exp' )
                    {
                    // InternalRoQME.g:6210:3: (enumLiteral_2= 'exp' )
                    // InternalRoQME.g:6211:4: enumLiteral_2= 'exp'
                    {
                    enumLiteral_2=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getArithFtnEnumAccess().getEXPEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getArithFtnEnumAccess().getEXPEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRoQME.g:6218:3: (enumLiteral_3= 'abs' )
                    {
                    // InternalRoQME.g:6218:3: (enumLiteral_3= 'abs' )
                    // InternalRoQME.g:6219:4: enumLiteral_3= 'abs'
                    {
                    enumLiteral_3=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getArithFtnEnumAccess().getABSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getArithFtnEnumAccess().getABSEnumLiteralDeclaration_3());
                    			

                    }


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
    // $ANTLR end "ruleArithFtnEnum"


    // $ANTLR start "ruleAggregationFtnEnum"
    // InternalRoQME.g:6229:1: ruleAggregationFtnEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'avg' ) | (enumLiteral_1= 'min' ) | (enumLiteral_2= 'max' ) | (enumLiteral_3= 'count' ) | (enumLiteral_4= 'sum' ) | (enumLiteral_5= 'decreasing' ) | (enumLiteral_6= 'increasing' ) | (enumLiteral_7= 'stable' ) ) ;
    public final Enumerator ruleAggregationFtnEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;


        	enterRule();

        try {
            // InternalRoQME.g:6235:2: ( ( (enumLiteral_0= 'avg' ) | (enumLiteral_1= 'min' ) | (enumLiteral_2= 'max' ) | (enumLiteral_3= 'count' ) | (enumLiteral_4= 'sum' ) | (enumLiteral_5= 'decreasing' ) | (enumLiteral_6= 'increasing' ) | (enumLiteral_7= 'stable' ) ) )
            // InternalRoQME.g:6236:2: ( (enumLiteral_0= 'avg' ) | (enumLiteral_1= 'min' ) | (enumLiteral_2= 'max' ) | (enumLiteral_3= 'count' ) | (enumLiteral_4= 'sum' ) | (enumLiteral_5= 'decreasing' ) | (enumLiteral_6= 'increasing' ) | (enumLiteral_7= 'stable' ) )
            {
            // InternalRoQME.g:6236:2: ( (enumLiteral_0= 'avg' ) | (enumLiteral_1= 'min' ) | (enumLiteral_2= 'max' ) | (enumLiteral_3= 'count' ) | (enumLiteral_4= 'sum' ) | (enumLiteral_5= 'decreasing' ) | (enumLiteral_6= 'increasing' ) | (enumLiteral_7= 'stable' ) )
            int alt100=8;
            switch ( input.LA(1) ) {
            case 101:
                {
                alt100=1;
                }
                break;
            case 102:
                {
                alt100=2;
                }
                break;
            case 103:
                {
                alt100=3;
                }
                break;
            case 104:
                {
                alt100=4;
                }
                break;
            case 105:
                {
                alt100=5;
                }
                break;
            case 106:
                {
                alt100=6;
                }
                break;
            case 107:
                {
                alt100=7;
                }
                break;
            case 108:
                {
                alt100=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }

            switch (alt100) {
                case 1 :
                    // InternalRoQME.g:6237:3: (enumLiteral_0= 'avg' )
                    {
                    // InternalRoQME.g:6237:3: (enumLiteral_0= 'avg' )
                    // InternalRoQME.g:6238:4: enumLiteral_0= 'avg'
                    {
                    enumLiteral_0=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getAVGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAggregationFtnEnumAccess().getAVGEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRoQME.g:6245:3: (enumLiteral_1= 'min' )
                    {
                    // InternalRoQME.g:6245:3: (enumLiteral_1= 'min' )
                    // InternalRoQME.g:6246:4: enumLiteral_1= 'min'
                    {
                    enumLiteral_1=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getMINEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getAggregationFtnEnumAccess().getMINEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRoQME.g:6253:3: (enumLiteral_2= 'max' )
                    {
                    // InternalRoQME.g:6253:3: (enumLiteral_2= 'max' )
                    // InternalRoQME.g:6254:4: enumLiteral_2= 'max'
                    {
                    enumLiteral_2=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getMAXEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getAggregationFtnEnumAccess().getMAXEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRoQME.g:6261:3: (enumLiteral_3= 'count' )
                    {
                    // InternalRoQME.g:6261:3: (enumLiteral_3= 'count' )
                    // InternalRoQME.g:6262:4: enumLiteral_3= 'count'
                    {
                    enumLiteral_3=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getCOUNTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getAggregationFtnEnumAccess().getCOUNTEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalRoQME.g:6269:3: (enumLiteral_4= 'sum' )
                    {
                    // InternalRoQME.g:6269:3: (enumLiteral_4= 'sum' )
                    // InternalRoQME.g:6270:4: enumLiteral_4= 'sum'
                    {
                    enumLiteral_4=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getSUMEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getAggregationFtnEnumAccess().getSUMEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalRoQME.g:6277:3: (enumLiteral_5= 'decreasing' )
                    {
                    // InternalRoQME.g:6277:3: (enumLiteral_5= 'decreasing' )
                    // InternalRoQME.g:6278:4: enumLiteral_5= 'decreasing'
                    {
                    enumLiteral_5=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getDECREASINGEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getAggregationFtnEnumAccess().getDECREASINGEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalRoQME.g:6285:3: (enumLiteral_6= 'increasing' )
                    {
                    // InternalRoQME.g:6285:3: (enumLiteral_6= 'increasing' )
                    // InternalRoQME.g:6286:4: enumLiteral_6= 'increasing'
                    {
                    enumLiteral_6=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getINCREASINGEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getAggregationFtnEnumAccess().getINCREASINGEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalRoQME.g:6293:3: (enumLiteral_7= 'stable' )
                    {
                    // InternalRoQME.g:6293:3: (enumLiteral_7= 'stable' )
                    // InternalRoQME.g:6294:4: enumLiteral_7= 'stable'
                    {
                    enumLiteral_7=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getAggregationFtnEnumAccess().getSTABLEEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getAggregationFtnEnumAccess().getSTABLEEnumLiteralDeclaration_7());
                    			

                    }


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
    // $ANTLR end "ruleAggregationFtnEnum"


    // $ANTLR start "rulePatternFtnEnum"
    // InternalRoQME.g:6304:1: rulePatternFtnEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'eventWhen' ) | (enumLiteral_1= 'update' ) | (enumLiteral_2= 'period' ) ) ;
    public final Enumerator rulePatternFtnEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalRoQME.g:6310:2: ( ( (enumLiteral_0= 'eventWhen' ) | (enumLiteral_1= 'update' ) | (enumLiteral_2= 'period' ) ) )
            // InternalRoQME.g:6311:2: ( (enumLiteral_0= 'eventWhen' ) | (enumLiteral_1= 'update' ) | (enumLiteral_2= 'period' ) )
            {
            // InternalRoQME.g:6311:2: ( (enumLiteral_0= 'eventWhen' ) | (enumLiteral_1= 'update' ) | (enumLiteral_2= 'period' ) )
            int alt101=3;
            switch ( input.LA(1) ) {
            case 109:
                {
                alt101=1;
                }
                break;
            case 110:
                {
                alt101=2;
                }
                break;
            case 111:
                {
                alt101=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }

            switch (alt101) {
                case 1 :
                    // InternalRoQME.g:6312:3: (enumLiteral_0= 'eventWhen' )
                    {
                    // InternalRoQME.g:6312:3: (enumLiteral_0= 'eventWhen' )
                    // InternalRoQME.g:6313:4: enumLiteral_0= 'eventWhen'
                    {
                    enumLiteral_0=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getPatternFtnEnumAccess().getEVENT_WHENEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPatternFtnEnumAccess().getEVENT_WHENEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRoQME.g:6320:3: (enumLiteral_1= 'update' )
                    {
                    // InternalRoQME.g:6320:3: (enumLiteral_1= 'update' )
                    // InternalRoQME.g:6321:4: enumLiteral_1= 'update'
                    {
                    enumLiteral_1=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getPatternFtnEnumAccess().getUPDATEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPatternFtnEnumAccess().getUPDATEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRoQME.g:6328:3: (enumLiteral_2= 'period' )
                    {
                    // InternalRoQME.g:6328:3: (enumLiteral_2= 'period' )
                    // InternalRoQME.g:6329:4: enumLiteral_2= 'period'
                    {
                    enumLiteral_2=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getPatternFtnEnumAccess().getPERIODEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getPatternFtnEnumAccess().getPERIODEnumLiteralDeclaration_2());
                    			

                    }


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
    // $ANTLR end "rulePatternFtnEnum"


    // $ANTLR start "ruleCollectionFtnEnum"
    // InternalRoQME.g:6339:1: ruleCollectionFtnEnum returns [Enumerator current=null] : ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'last' ) | (enumLiteral_2= 'at' ) | (enumLiteral_3= 'size' ) | (enumLiteral_4= 'isEmpty' ) | (enumLiteral_5= 'includes' ) ) ;
    public final Enumerator ruleCollectionFtnEnum() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalRoQME.g:6345:2: ( ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'last' ) | (enumLiteral_2= 'at' ) | (enumLiteral_3= 'size' ) | (enumLiteral_4= 'isEmpty' ) | (enumLiteral_5= 'includes' ) ) )
            // InternalRoQME.g:6346:2: ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'last' ) | (enumLiteral_2= 'at' ) | (enumLiteral_3= 'size' ) | (enumLiteral_4= 'isEmpty' ) | (enumLiteral_5= 'includes' ) )
            {
            // InternalRoQME.g:6346:2: ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'last' ) | (enumLiteral_2= 'at' ) | (enumLiteral_3= 'size' ) | (enumLiteral_4= 'isEmpty' ) | (enumLiteral_5= 'includes' ) )
            int alt102=6;
            switch ( input.LA(1) ) {
            case 112:
                {
                alt102=1;
                }
                break;
            case 113:
                {
                alt102=2;
                }
                break;
            case 114:
                {
                alt102=3;
                }
                break;
            case 115:
                {
                alt102=4;
                }
                break;
            case 116:
                {
                alt102=5;
                }
                break;
            case 117:
                {
                alt102=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }

            switch (alt102) {
                case 1 :
                    // InternalRoQME.g:6347:3: (enumLiteral_0= 'first' )
                    {
                    // InternalRoQME.g:6347:3: (enumLiteral_0= 'first' )
                    // InternalRoQME.g:6348:4: enumLiteral_0= 'first'
                    {
                    enumLiteral_0=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getCollectionFtnEnumAccess().getFIRSTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCollectionFtnEnumAccess().getFIRSTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRoQME.g:6355:3: (enumLiteral_1= 'last' )
                    {
                    // InternalRoQME.g:6355:3: (enumLiteral_1= 'last' )
                    // InternalRoQME.g:6356:4: enumLiteral_1= 'last'
                    {
                    enumLiteral_1=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getCollectionFtnEnumAccess().getLASTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCollectionFtnEnumAccess().getLASTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRoQME.g:6363:3: (enumLiteral_2= 'at' )
                    {
                    // InternalRoQME.g:6363:3: (enumLiteral_2= 'at' )
                    // InternalRoQME.g:6364:4: enumLiteral_2= 'at'
                    {
                    enumLiteral_2=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getCollectionFtnEnumAccess().getATEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getCollectionFtnEnumAccess().getATEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRoQME.g:6371:3: (enumLiteral_3= 'size' )
                    {
                    // InternalRoQME.g:6371:3: (enumLiteral_3= 'size' )
                    // InternalRoQME.g:6372:4: enumLiteral_3= 'size'
                    {
                    enumLiteral_3=(Token)match(input,115,FOLLOW_2); 

                    				current = grammarAccess.getCollectionFtnEnumAccess().getSIZEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getCollectionFtnEnumAccess().getSIZEEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalRoQME.g:6379:3: (enumLiteral_4= 'isEmpty' )
                    {
                    // InternalRoQME.g:6379:3: (enumLiteral_4= 'isEmpty' )
                    // InternalRoQME.g:6380:4: enumLiteral_4= 'isEmpty'
                    {
                    enumLiteral_4=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getCollectionFtnEnumAccess().getIS_EMPTYEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getCollectionFtnEnumAccess().getIS_EMPTYEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalRoQME.g:6387:3: (enumLiteral_5= 'includes' )
                    {
                    // InternalRoQME.g:6387:3: (enumLiteral_5= 'includes' )
                    // InternalRoQME.g:6388:4: enumLiteral_5= 'includes'
                    {
                    enumLiteral_5=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getCollectionFtnEnumAccess().getINCLUDESEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getCollectionFtnEnumAccess().getINCLUDESEnumLiteralDeclaration_5());
                    			

                    }


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
    // $ANTLR end "ruleCollectionFtnEnum"

    // Delegated rules


    protected DFA6 dfa6 = new DFA6(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA69 dfa69 = new DFA69(this);
    protected DFA70 dfa70 = new DFA70(this);
    static final String dfa_1s = "\70\uffff";
    static final String dfa_2s = "\4\uffff\1\14\1\uffff\2\14\1\uffff\3\14\20\uffff\1\14\1\uffff\3\14\1\uffff\1\14\2\uffff\2\14\4\uffff\1\14\1\uffff\2\14\1\uffff\1\14\1\uffff\2\14\2\uffff\2\14";
    static final String dfa_3s = "\1\7\1\15\1\4\1\16\1\4\1\uffff\2\7\1\35\3\7\1\uffff\2\5\1\4\4\5\1\4\1\5\2\47\1\51\2\47\1\5\1\7\1\5\3\7\1\47\1\7\1\35\1\4\2\7\4\5\1\7\1\36\2\7\1\5\1\7\1\5\2\7\2\5\2\7";
    static final String dfa_4s = "\2\15\1\4\1\16\1\57\1\uffff\1\44\3\46\1\56\1\46\1\uffff\2\5\1\4\2\5\2\120\1\6\1\5\2\47\1\51\2\47\1\5\1\126\1\5\1\126\2\55\1\47\1\44\1\35\1\4\1\44\1\56\2\5\2\120\1\44\1\51\2\56\1\5\1\126\1\5\1\126\1\44\2\5\2\55";
    static final String dfa_5s = "\5\uffff\1\1\6\uffff\1\2\53\uffff";
    static final String dfa_6s = "\70\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\5\uffff\1\2",
            "\1\2",
            "\1\3",
            "\1\4",
            "\1\6\2\uffff\1\14\5\uffff\1\14\1\uffff\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1\uffff\1\14\7\uffff\1\14\1\7\2\uffff\1\10\1\uffff\1\11\1\12\3\uffff\1\13",
            "",
            "\1\14\5\uffff\1\14\1\uffff\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1\uffff\1\14\7\uffff\1\14",
            "\1\14\5\uffff\1\14\1\uffff\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1\uffff\1\14\7\uffff\1\14\1\uffff\1\15",
            "\1\17\10\uffff\1\16",
            "\1\14\5\uffff\1\14\1\uffff\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1\uffff\1\14\7\uffff\1\14\1\uffff\1\20",
            "\1\14\5\uffff\1\14\1\uffff\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1\uffff\1\14\7\uffff\1\14\1\uffff\1\21\5\uffff\1\22\1\23\1\24",
            "\1\14\5\uffff\1\14\1\uffff\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1\uffff\1\14\7\uffff\1\14\1\uffff\1\25",
            "",
            "\1\26",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\34\112\uffff\1\33",
            "\1\36\112\uffff\1\35",
            "\1\40\1\uffff\1\37",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\34",
            "\1\14\5\uffff\1\14\1\uffff\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1\uffff\1\14\7\uffff\1\14\7\uffff\1\22\1\23\1\24\47\uffff\1\47",
            "\1\36",
            "\1\14\5\uffff\1\14\1\uffff\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1\uffff\1\14\7\uffff\1\14\7\uffff\1\22\1\23\1\24\47\uffff\1\50",
            "\1\14\5\uffff\1\14\1\uffff\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1\uffff\1\14\7\uffff\1\14\7\uffff\1\51\1\52",
            "\1\14\5\uffff\1\14\1\uffff\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1\uffff\1\14\7\uffff\1\14\7\uffff\1\51\1\52",
            "\1\53",
            "\1\14\5\uffff\1\14\1\uffff\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1\uffff\1\14\7\uffff\1\14",
            "\1\17",
            "\1\54",
            "\1\14\5\uffff\1\14\1\uffff\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1\uffff\1\14\7\uffff\1\14",
            "\1\14\5\uffff\1\14\1\uffff\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1\uffff\1\14\7\uffff\1\14\7\uffff\1\22\1\23\1\24",
            "\1\55",
            "\1\56",
            "\1\60\112\uffff\1\57",
            "\1\62\112\uffff\1\61",
            "\1\14\5\uffff\1\14\1\uffff\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1\uffff\1\14\7\uffff\1\14",
            "\1\63\12\uffff\1\44",
            "\1\14\5\uffff\1\14\1\uffff\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1\uffff\1\14\7\uffff\1\14\7\uffff\1\22\1\23\1\24",
            "\1\14\5\uffff\1\14\1\uffff\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1\uffff\1\14\7\uffff\1\14\7\uffff\1\22\1\23\1\24",
            "\1\60",
            "\1\14\5\uffff\1\14\1\uffff\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1\uffff\1\14\7\uffff\1\14\7\uffff\1\51\1\52\50\uffff\1\64",
            "\1\62",
            "\1\14\5\uffff\1\14\1\uffff\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1\uffff\1\14\7\uffff\1\14\7\uffff\1\51\1\52\50\uffff\1\65",
            "\1\14\5\uffff\1\14\1\uffff\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1\uffff\1\14\7\uffff\1\14",
            "\1\66",
            "\1\67",
            "\1\14\5\uffff\1\14\1\uffff\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1\uffff\1\14\7\uffff\1\14\7\uffff\1\51\1\52",
            "\1\14\5\uffff\1\14\1\uffff\1\5\2\14\1\uffff\1\14\3\uffff\1\14\2\uffff\1\14\1\uffff\1\14\7\uffff\1\14\7\uffff\1\51\1\52"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "285:2: (this_DerivedContext_0= ruleDerivedContext | this_PrimitiveContext_1= rulePrimitiveContext )";
        }
    }
    static final String dfa_8s = "\25\uffff";
    static final String dfa_9s = "\4\uffff\1\11\10\uffff\1\11\1\uffff\2\11\2\uffff\2\11";
    static final String dfa_10s = "\1\45\3\uffff\1\7\1\uffff\3\5\2\uffff\1\47\1\5\1\7\1\5\2\7\2\5\2\7";
    static final String dfa_11s = "\1\57\3\uffff\1\56\1\uffff\1\5\2\120\2\uffff\1\47\1\5\1\126\1\5\1\126\1\56\2\5\2\56";
    static final String dfa_12s = "\1\uffff\1\1\1\2\1\3\1\uffff\1\6\3\uffff\1\4\1\5\12\uffff";
    static final String dfa_13s = "\25\uffff}>";
    static final String[] dfa_14s = {
            "\1\1\2\uffff\1\2\1\uffff\1\3\1\4\3\uffff\1\5",
            "",
            "",
            "",
            "\1\11\5\uffff\1\11\1\uffff\5\11\3\uffff\1\11\2\uffff\1\11\1\uffff\1\11\7\uffff\1\11\1\uffff\1\6\5\uffff\1\7\1\10\1\12",
            "",
            "\1\13",
            "\1\15\112\uffff\1\14",
            "\1\17\112\uffff\1\16",
            "",
            "",
            "\1\20",
            "\1\15",
            "\1\11\5\uffff\1\11\1\uffff\5\11\3\uffff\1\11\2\uffff\1\11\1\uffff\1\11\7\uffff\1\11\7\uffff\1\7\1\10\1\12\47\uffff\1\21",
            "\1\17",
            "\1\11\5\uffff\1\11\1\uffff\5\11\3\uffff\1\11\2\uffff\1\11\1\uffff\1\11\7\uffff\1\11\7\uffff\1\7\1\10\1\12\47\uffff\1\22",
            "\1\11\5\uffff\1\11\1\uffff\5\11\3\uffff\1\11\2\uffff\1\11\1\uffff\1\11\7\uffff\1\11\7\uffff\1\7\1\10\1\12",
            "\1\23",
            "\1\24",
            "\1\11\5\uffff\1\11\1\uffff\5\11\3\uffff\1\11\2\uffff\1\11\1\uffff\1\11\7\uffff\1\11\7\uffff\1\7\1\10\1\12",
            "\1\11\5\uffff\1\11\1\uffff\5\11\3\uffff\1\11\2\uffff\1\11\1\uffff\1\11\7\uffff\1\11\7\uffff\1\7\1\10\1\12"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "2018:2: (this_BooleanType_0= ruleBooleanType | this_EnumType_1= ruleEnumType | this_EventType_2= ruleEventType | this_NumericType_3= ruleNumericType | this_UnitMeasuredType_4= ruleUnitMeasuredType | this_TimeType_5= ruleTimeType )";
        }
    }
    static final String dfa_15s = "\12\uffff";
    static final String dfa_16s = "\3\uffff\1\7\1\10\4\uffff\1\7";
    static final String dfa_17s = "\1\4\2\uffff\2\7\1\uffff\1\4\2\uffff\1\7";
    static final String dfa_18s = "\1\165\2\uffff\2\133\1\uffff\1\4\2\uffff\1\133";
    static final String dfa_19s = "\1\uffff\1\1\1\2\2\uffff\1\5\1\uffff\1\3\1\4\1\uffff";
    static final String dfa_20s = "\12\uffff}>";
    static final String[] dfa_21s = {
            "\1\3\1\2\40\uffff\1\2\11\uffff\1\2\14\uffff\1\1\22\uffff\1\2\2\uffff\1\4\1\5\2\uffff\2\2\10\uffff\25\5",
            "",
            "",
            "\1\7\5\uffff\5\7\1\uffff\10\7\1\uffff\11\7\4\uffff\1\7\22\uffff\1\7\1\uffff\6\7\1\uffff\3\7\1\uffff\12\7\2\uffff\1\5\1\6\2\uffff\1\2\2\7",
            "\1\10\5\uffff\5\10\1\uffff\10\10\1\uffff\11\10\4\uffff\1\10\22\uffff\1\10\1\uffff\6\10\1\uffff\3\10\1\uffff\12\10\2\uffff\1\5\4\uffff\2\10",
            "",
            "\1\11",
            "",
            "",
            "\1\7\5\uffff\5\7\1\uffff\10\7\1\uffff\11\7\4\uffff\1\7\22\uffff\1\7\1\uffff\6\7\1\uffff\3\7\1\uffff\12\7\2\uffff\1\5\1\6\3\uffff\2\7"
    };

    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final char[] dfa_18 = DFA.unpackEncodedStringToUnsignedChars(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[][] dfa_21 = unpackEncodedStringArray(dfa_21s);

    class DFA69 extends DFA {

        public DFA69(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 69;
            this.eot = dfa_15;
            this.eof = dfa_16;
            this.min = dfa_17;
            this.max = dfa_18;
            this.accept = dfa_19;
            this.special = dfa_20;
            this.transition = dfa_21;
        }
        public String getDescription() {
            return "5067:2: ( (otherlv_0= '(' this_Term_1= ruleTerm otherlv_2= ')' ) | this_ConstTerm_3= ruleConstTerm | this_VarTerm_4= ruleVarTerm | this_SelfTerm_5= ruleSelfTerm | this_FunctionTerm_6= ruleFunctionTerm )";
        }
    }
    static final String dfa_22s = "\13\uffff";
    static final String dfa_23s = "\1\4\2\125\5\uffff\1\4\1\141\1\125";
    static final String dfa_24s = "\1\165\1\126\1\125\5\uffff\1\4\1\165\1\126";
    static final String dfa_25s = "\3\uffff\1\1\1\2\1\3\1\4\1\5\3\uffff";
    static final String dfa_26s = "\13\uffff}>";
    static final String[] dfa_27s = {
            "\1\1\116\uffff\1\2\1\7\14\uffff\4\3\10\4\3\5\6\6",
            "\1\11\1\10",
            "\1\11",
            "",
            "",
            "",
            "",
            "",
            "\1\12",
            "\4\3\10\4\3\5\6\6",
            "\1\11\1\10"
    };

    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final char[] dfa_24 = DFA.unpackEncodedStringToUnsignedChars(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final short[][] dfa_27 = unpackEncodedStringArray(dfa_27s);

    class DFA70 extends DFA {

        public DFA70(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 70;
            this.eot = dfa_22;
            this.eof = dfa_22;
            this.min = dfa_23;
            this.max = dfa_24;
            this.accept = dfa_25;
            this.special = dfa_26;
            this.transition = dfa_27;
        }
        public String getDescription() {
            return "5239:2: (this_ArithFunction_0= ruleArithFunction | this_AggregationFunction_1= ruleAggregationFunction | this_PatternFunction_2= rulePatternFunction | this_CollectionFunction_3= ruleCollectionFunction | this_ScheduleFunction_4= ruleScheduleFunction )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000101C8B2082L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000010148B2082L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00008D2000000010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x2801004000000030L,0x003FFFFE01990110L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0001004000000030L,0x0000000001810000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000708000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000020L,0x0000000000010000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000708002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000003004000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000FA0000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000F80000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000FC0000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000002000002L,0x00000001F0000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000004020000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000020040000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000304000000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000300000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000704000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000700000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x07FE000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000001800000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000028000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000002L,0x0000000000007E00L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000002L,0x0000000000018000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000002L,0x0000000000060000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000010L,0x0000001E00080000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x6801004000000030L,0x003FFFFE01990110L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x4000020000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000010L,0x00001FE000080000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000010L,0x0000E00000080000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000010L,0x003F000000080000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});

}
