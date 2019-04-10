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

package roqme.generator.cep

import java.util.HashMap
import java.util.List
import org.eclipse.emf.common.util.EList
import org.eclipse.xtext.generator.IFileSystemAccess2
import roqme.metamodel.datatypes.BooleanType
import roqme.metamodel.datatypes.BooleanValue
import roqme.metamodel.datatypes.ContainedDeclaration
import roqme.metamodel.datatypes.DataType
import roqme.metamodel.datatypes.EnumType
import roqme.metamodel.datatypes.EnumValue
import roqme.metamodel.datatypes.EventType
import roqme.metamodel.datatypes.NumericType
import roqme.metamodel.datatypes.NumericValue
import roqme.metamodel.datatypes.RoqmeModel
import roqme.metamodel.datatypes.Sentence
import roqme.metamodel.datatypes.SingleValue
import roqme.metamodel.datatypes.TimeType
import roqme.metamodel.datatypes.TypedValue
import roqme.metamodel.datatypes.TypedVariable
import roqme.metamodel.expressions.AndBooleanTerm
import roqme.metamodel.expressions.AndEventTerm
import roqme.metamodel.expressions.BinaryArithOp
import roqme.metamodel.expressions.BinaryLogicalOp
import roqme.metamodel.expressions.BinaryPatternOp
import roqme.metamodel.expressions.BinaryRelationalOp
import roqme.metamodel.expressions.BinaryTermOp
import roqme.metamodel.expressions.ConditionalTerm
import roqme.metamodel.expressions.ConstTerm
import roqme.metamodel.expressions.EqualTerm
import roqme.metamodel.expressions.FollowedByTerm
import roqme.metamodel.expressions.FunctionTerm
import roqme.metamodel.expressions.GreaterEqualTerm
import roqme.metamodel.expressions.GreaterThanTerm
import roqme.metamodel.expressions.LessEqualTerm
import roqme.metamodel.expressions.LessThanTerm
import roqme.metamodel.expressions.NaryTermOp
import roqme.metamodel.expressions.NotEqualTerm
import roqme.metamodel.expressions.OrBooleanTerm
import roqme.metamodel.expressions.OrEventTerm
import roqme.metamodel.expressions.PatternFunction
import roqme.metamodel.expressions.ScheduleFunction
import roqme.metamodel.expressions.SelfTerm
import roqme.metamodel.expressions.Term
import roqme.metamodel.expressions.UnaryTermOp
import roqme.metamodel.expressions.VarTerm
import roqme.metamodel.expressions.WhileTerm
import roqme.metamodel.kernel.Context
import roqme.metamodel.kernel.DerivedContext
import roqme.metamodel.kernel.Import
import roqme.metamodel.kernel.Observation
import roqme.metamodel.kernel.Parameter
import roqme.metamodel.expressions.DivTerm
import roqme.metamodel.expressions.MultTerm
import roqme.metamodel.expressions.SubTerm
import roqme.metamodel.expressions.AddTerm
import java.util.Map
import roqme.metamodel.expressions.UnaryPatternOp
import roqme.metamodel.expressions.UnaryLogicalOp
import roqme.metamodel.expressions.RepeatTerm
import roqme.metamodel.expressions.NotEventTerm
import roqme.metamodel.expressions.RangeTerm
import roqme.metamodel.expressions.OnceTerm
import roqme.metamodel.expressions.CollectionFunction
import roqme.metamodel.expressions.AggregationFunction
import roqme.metamodel.expressions.ArithFunction
import java.util.LinkedHashMap
import roqme.metamodel.expressions.NotBooleanTerm
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IGeneratorContext
import roqme.metamodel.expressions.PatternFtnEnum
import roqme.metamodel.expressions.AggregationFtnEnum
import roqme.metamodel.expressions.ArithFtnEnum
import roqme.metamodel.datatypes.DataTypeDeclaration
import roqme.metamodel.kernel.GeneralPurposeVariable
import roqme.metamodel.kernel.SetVariable
import java.util.ArrayList
import roqme.metamodel.kernel.Timer
import roqme.metamodel.datatypes.DataTypeDefinition
import roqme.metamodel.datatypes.ReferencedDeclaration
import roqme.metamodel.datatypes.UnitMeasuredValue
import org.eclipse.emf.ecore.resource.ResourceSet

class RoqmeCepGenerator extends AbstractGenerator{
	private static final String BASE_PATH = 'src/';
	private static final String ENUM_PACKAGE_PATH = BASE_PATH + 'enums';
	private static final String ENUM_PACKAGE_NAME = 'enums';
	private static final String JAVA_EXTENSION = '.java';
	private static char letter='a';
	private Map<Term,String> auxPatternsNames=new HashMap<Term,String>();
	private Map<String,String> varTermAs=new LinkedHashMap<String,String>();
	private boolean once = false;

	
	override void doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		
		if(input.getURI().fileExtension().equalsIgnoreCase("roqme")) {
			for (model : input.allContents.toIterable.filter(RoqmeModel)) {		
				
				if(model.namespace.isNullOrEmpty){
					val splitStr = input.getURI().lastSegment().split('\\.')
					model.namespace = splitStr.get(0)
				}
				
				fsa.generateFile(BASE_PATH + model.namespace+'.epl', generateEPL(model,fsa))
				fsa.generateFile(BASE_PATH + model.namespace.capitalize+'.java', generateEsperEngine(model))
			}
		}
	}
	
	def capitalize(String line) {
   		Character.toUpperCase(line.charAt(0)) + line.substring(1);
   	}
	
	def generateEPL(RoqmeModel model, IFileSystemAccess2 fsa) '''
		module «model.namespace»;
		«IF anyEnum(model.variables)»import «ENUM_PACKAGE_NAME».*;«ENDIF»
		«generateImports(model.sentences)»
		«generateTypesDefinitions(model.dataTypes,fsa)»
		«generateDataDefinitions(model.variables,fsa)»
		«generatePatternDefinitions(model.sentences)»
		«generateObservationStreamPattern()»
	'''
	
	def generateObservationStreamPattern() {
		'''
		
		@Name('Observations')
		SELECT val
		FROM Observations;
		'''
	}
	
	def generateTypesDefinitions(EList<DataTypeDefinition>types,IFileSystemAccess2 fsa) '''
		 «FOR type : types»	
		  	«IF type.dataType instanceof BooleanType»
		  	create objectarray schema «type.name»(val bool,ts long) starttimestamp ts endtimestamp ts;
		  	«ELSEIF type.dataType   instanceof EventType»
		  	create objectarray schema «type.name»(ts long) starttimestamp ts endtimestamp ts;
			«ELSEIF type.dataType   instanceof EnumType»
				«val enumVar = type.dataType as EnumType»
				«fsa.generateFile(ENUM_PACKAGE_PATH+'/'+type.name+JAVA_EXTENSION,generateJavaEnums(enumVar,type.name))»
			create objectarray schema «type.name»(val «type.name»,ts long) starttimestamp ts endtimestamp ts;
			«ELSEIF type.dataType  instanceof NumericType»
		  	create objectarray schema «type.name»(val double,ts long) starttimestamp ts endtimestamp ts;
		  	«ENDIF»
		  «ENDFOR»
	'''

	def generateEsperEngine(RoqmeModel model) '''
	import org.roqme.cep.PatternDetector;
	import Roqme.RoqmeDDSException;
	
	public class «model.namespace.capitalize» {
	
		public static void main(String[] args) throws RoqmeDDSException, InterruptedException {
			«model.namespace.capitalize» exec = new «model.namespace.capitalize»();
			PatternDetector pd=null;
			«val imports = getImportURIs(model.sentences)»
			
			try{
				«IF anyEnum(model.variables)»
				pd = new PatternDetector("«ENUM_PACKAGE_NAME»");
				«ELSE»
				pd = new PatternDetector();
				«ENDIF»
				«IF imports.nullOrEmpty»
				pd.launch("«model.namespace +'.epl'»");
				«ELSE»
				List imports = new ArrayList<String>();
				«FOR resource : imports»
				imports.add("«resource.replace('roqme','epl')»");
				«ENDFOR»
				imports.add("«model.namespace +'.epl'»");
				pd.launch(imports);
				«ENDIF»
				synchronized (pd) {
					exec.wait();
				}
			} catch(Exception e){
				e.printStackTrace();
			} finally {
				pd.destroy();
			}
		}
	}
	'''

	def generateImports(List<Sentence> sentences) '''
		«var imports = getImportURIs(sentences)»
		«FOR elem : imports»
			«var uses = elem»
			«IF uses.contains('/')»
				«uses = uses.split('/').last»
			«ENDIF»
			uses «uses.split('\\.').iterator.next»;
		«ENDFOR»
	'''
	
	def anyEnum(EList<TypedVariable> variables){
		var res = false;
		
		if(!variables.isNullOrEmpty){
			var varIt = variables.iterator
			
			while(varIt.hasNext && !res){
				
				val next = varIt.next
				
				if(next?.declaration instanceof ContainedDeclaration){
					val contDec = next.declaration as ContainedDeclaration
					val dataType = contDec.type as DataType
					res = dataType instanceof EnumType
				}
			}
		}
		
		return res;
	}

	def List<String> getImportURIs(List<Sentence> sentences) {
		var modules = newArrayList
		for (sentence : sentences) {
			if (sentence instanceof Import) {
				var imp = sentence as Import
				modules.add(imp.importURI)
			}
		}
		return modules
	}

	def generateDataDefinitions(EList<TypedVariable> variables, IFileSystemAccess2 fsa) '''
		 «FOR typedVar : variables»			
		  	«IF typedVar instanceof Context»
				«generateContext(typedVar as Context,fsa)»
		  	«ELSEIF typedVar instanceof Parameter || typedVar instanceof GeneralPurposeVariable»
				«generateVariable(typedVar,fsa)»
			«ELSEIF typedVar instanceof Timer»
				«generateTimer(typedVar as Timer)»
		  	«ENDIF»
		  «ENDFOR»
		
		«generateDerivedContexts(variables)»
	'''
	
	def void generateTimer(Timer timer) {
		val timerTerm = timer.definition.term
		if(timerTerm instanceof ConstTerm){
			val timeValue = timerTerm.value as UnitMeasuredValue
			val value = timeValue.value
			val unit = timeValue.unit
			auxPatternsNames.put(timerTerm,'timer:interval('+value+' '+unit+')')
		}else if(timerTerm instanceof ScheduleFunction){
			generateSchedule(timerTerm)
		}
		
	}
	
	def void generateSchedule(ScheduleFunction timerTerm){
		auxPatternsNames.put(timerTerm,'timer:at('+timerTerm.pattern+')')
	}
	
	def generateScheduleFunctionTerm(ScheduleFunction function) {
		auxPatternsNames.get(function)
	}	

	def generateVariable(TypedVariable param, IFileSystemAccess2 fsa) {
		val contDec = param.declaration as ContainedDeclaration
		val typedValue = param.initializedTo as TypedValue
		val dataType = contDec.type as DataType
		var dec = ''
		val paramName = param.name
		var type = ''
		var init = ''
		
		if(dataType instanceof EnumType){
			fsa.generateFile(ENUM_PACKAGE_PATH+'/'+paramName+JAVA_EXTENSION,generateJavaEnums(dataType,paramName))
			type = paramName
		}else{
			type = getEsperDataType(dataType)
		}
		
		if(param instanceof Parameter){
			dec = 'create constant variable'
			if(typedValue instanceof SingleValue){
				init = '= ' + generateSingleValue(typedValue)
			}
		}else if (param instanceof GeneralPurposeVariable){
			dec = 'create variable'
			val gpvTerm = param.definition.term
			if(gpvTerm instanceof ConstTerm){
				init = '= ' + generateConstTerm(gpvTerm)
			}
		}
		
		'''«dec» «type» «paramName»«IF !init.isEmpty» «init»«ENDIF»;'''
	}
	
	def getEsperDataType(DataType dt){
		if(dt instanceof TimeType){
			'long'
		}else if(dt instanceof BooleanType){
			'bool'
		}else if(dt instanceof NumericType){
			'double'
		}
	}
	
	def generateSingleValue(SingleValue sv){
		if(sv instanceof NumericValue){
			val nv = sv as NumericValue
			nv.value	
		} else if(sv instanceof BooleanValue){
			val bv = sv as BooleanValue
			bv.value	
		} else if(sv instanceof EnumValue){
			generateEnumConstTerm(sv)	
		}
	}

	def generateContext(Context context, IFileSystemAccess2 fsa) '''
		«IF context.declaration instanceof ReferencedDeclaration»
			«val refDec = context.declaration as ReferencedDeclaration»
			create objectarray schema «context.name»() starttimestamp ts endtimestamp ts inherits «refDec.type.name»;
		«ELSE»
			«val contDec = context.declaration as ContainedDeclaration»
			«val dataType = contDec.type as DataType»
			«var contextName = context.name»
			«IF dataType instanceof EnumType»
				«val enumVar = dataType as EnumType»
				«fsa.generateFile(ENUM_PACKAGE_PATH+'/'+contextName+JAVA_EXTENSION,generateJavaEnums(enumVar,contextName))»
				create objectarray schema «contextName»(val «contextName»,ts long) starttimestamp ts endtimestamp ts;
			«ELSEIF dataType instanceof TimeType»
				create objectarray schema «contextName»(val long,ts long) starttimestamp ts endtimestamp ts;
			«ELSEIF dataType instanceof NumericType»
				create objectarray schema «contextName»(val double,ts long) starttimestamp ts endtimestamp ts;
			«ELSEIF dataType instanceof BooleanType»
				create objectarray schema «contextName»(val bool,ts long) starttimestamp ts endtimestamp ts;
			«ELSEIF dataType instanceof EventType»
				create objectarray schema «contextName»(ts long) starttimestamp ts endtimestamp ts;
			«ENDIF»
		«ENDIF»
	'''

	def generateDerivedContexts(List<TypedVariable> derivedContexts) '''
		«FOR element : derivedContexts»
			«IF element instanceof DerivedContext»			
				«val name = element.name»
				«val ctxPattern = element.definition»
				«val contDec = element.declaration»
				«IF contDec instanceof ContainedDeclaration»
					«val dataType = contDec.type as DataType»
					«generateDerivedContextPatterns(name,ctxPattern.term,dataType)»
				«ELSEIF contDec instanceof ReferencedDeclaration»
					«val refdec = contDec as ReferencedDeclaration»
					«val dataType = refdec.type.dataType as DataType»
					«generateDerivedContextPatterns(name,ctxPattern.term,dataType)»
				«ENDIF»
			«ELSEIF element instanceof GeneralPurposeVariable»
				 «generateOnSetClausePatterns(element as GeneralPurposeVariable)»
			«ENDIF»
		«ENDFOR»
	'''
	
	def generateOnSetClausePatterns(GeneralPurposeVariable variable) {
		val gpvTerm = variable.definition.term
		val streamName = variable.name
		val contDec = variable.declaration as ContainedDeclaration
		val dataType = contDec.type as DataType
		generateOnSetClausePattern(gpvTerm,dataType,streamName)
	}
	
	def generateOnSetClausePatterns(SetVariable setVar) {
		val setTerm = setVar.expression.term
		val streamName = setVar.variable.name
		val contDec = setVar.variable.declaration as ContainedDeclaration
		val dataType = contDec.type as DataType
		generateOnSetClausePattern(setTerm,dataType,streamName)
	}
	
	def generateOnSetClausePattern(Term term,DataType dataType,String streamName){
		letter ='a'
			
		if(!(term instanceof ConstTerm)){
			val aux = '''«generateAuxiliarPatterns(streamName,term,false)»'''
			
			if( dataType instanceof NumericType || dataType instanceof EnumType){
			aux + '''«generateOnSetClauseEPL(streamName,'a.val',generateTerm(term))»'''
			}else if(dataType instanceof BooleanType){
				aux + '''«generateOnSetClauseEPL(streamName,'true',generateTerm(term))»''' +
				'''«generateOnSetClauseEPL(streamName,'false',generateNotTerm(term).toString)»'''
			}
		} 
	}
	
	def generateOnSetClauseEPL(String varName,String value,String pattern){
		var finalPattern = pattern
		if('a.val'==value){
			finalPattern = 'a = ' + pattern
		}
		
		'''
		on pattern [every ( «finalPattern» ) ]
		set «varName» = «value»;
		
		'''
	}	
	
	def generateDerivedContextPatterns(String streamName,Term term,DataType dataType) {
		val aux = '''«generateAuxiliarPatterns(streamName,term,false)»'''
		letter ='a'
		
		if( dataType instanceof NumericType || dataType instanceof EnumType){
			aux + '''«generateDerivedContextPattern(streamName,'a.val',generateTerm(term))»'''
		}else if(dataType instanceof BooleanType){
			if(term instanceof ConditionalTerm || isCustomAggregationFunction(term)){
				val termStr = generateNaryTermOp(term as NaryTermOp)?.toString
				aux + '''«generateDerivedContextPattern(streamName,'a.val',termStr)»'''
			}else{
				aux + '''«generateDerivedContextPattern(streamName,'true',generateTerm(term))»''' +
			'''«generateDerivedContextPattern(streamName,'false',generateNotTerm(term).toString)»'''	
			}
		}else if(dataType instanceof EventType){
			aux + '''«generateDerivedContextPattern(streamName,'',generateTerm(term))»'''
		}
	}
	
	def generateDerivedContextPattern(String streamName,String selectattrs ,String pattern) {		
		var finalSelectAttrs = ''
		var finalPattern = pattern
		
		switch(selectattrs){
			case selectattrs.isNullOrEmpty : finalSelectAttrs = selectattrs
			case 'a.val' : {
					finalSelectAttrs = selectattrs + ' as val'
					finalPattern = 'a = ' + pattern	
			}
			default : finalSelectAttrs = selectattrs + ' as val'			
		}
		
		val strPattern = 'pattern [ '+getEveryO()+ finalPattern + getEveryC()+' ]'
		
		'''«generateInsertIntoPattern(streamName,finalSelectAttrs,strPattern)»'''
	}
	
	def generatePatternDefinitions(EList<Sentence> sentences) '''
		«FOR sentence : sentences»
			«IF sentence instanceof Observation»
				«generateObservation(sentence as Observation)»
			«ENDIF»
		«ENDFOR»
	'''
	
	def generateObservation(Observation obs) {
		val aux = '''«generateAuxiliarPatterns(obs.name,obs.pattern.term,false)»'''
		letter ='a'
		aux + '''«generateObservationPattern(obs.name,obs.pattern.term)»''' + '''«generateSetVariableActions(obs)»'''
	}
	
	def generateSetVariableActions(Observation observation) {
		val obsName = observation.name
		var res = ''
		for(action : observation.actions){
			if(action instanceof SetVariable){
				val name = action.variable.name
				if(action.expression.term instanceof ConstTerm){
					val value = generateConstTerm(action.expression.term as ConstTerm)?.toString
					res = res + generateOnSetClauseEPL(name,value,"Observations(val = '" + obsName + "')")
				}else if(action.expression.term instanceof BinaryArithOp){
					val value = generateExpressionClause(action.expression.term)?.toString
					res = res + generateOnSetClauseEPL(name,value,"Observations(val = '" + obsName + "')")
				}	
			}
		}
		
		return res
	}
	
	def generateAuxiliarPatterns(String obsName,Term term,boolean arith){
		if(term instanceof BinaryArithOp){
			'''
			«generateAuxiliarPatterns(obsName,term.left,true)»
			«generateAuxiliarPatterns(obsName,term.right,true)»
			«IF !arith»«generateArithmeticsPatterns(obsName,term)»«ENDIF»'''
		}else if(term instanceof BinaryTermOp){
			'''
			«generateAuxiliarPatterns(obsName,term.left,false)»
			«generateAuxiliarPatterns(obsName,term.right,false)»'''
		}else if(term instanceof AggregationFunction){
			'''
			«FOR nary : term.terms»«generateAuxiliarPatterns(obsName,nary,false)»«ENDFOR»
			«generateAggregationPatterns(obsName,term)»
			'''
		}else if(term instanceof ArithFunction){
			'''
			«FOR nary : term.terms»«generateAuxiliarPatterns(obsName,nary,false)»«ENDFOR»
			«generateArithFunctionPatterns(obsName,term)»
			'''
		}else if(term instanceof PatternFunction){
			'''
			«FOR nary : term.terms»«generateAuxiliarPatterns(obsName,nary,false)»«ENDFOR»
			«generatePatternFunctionPatterns(obsName,term)»
			'''
		}else if(term instanceof ConditionalTerm){
			val condition = term.terms.get(0)
			'''
			«generateAuxiliarPatterns(obsName,condition,false)»
			«generateConditionalPatterns(obsName,term)»
			'''
		}else if(term instanceof ScheduleFunction){
			generateSchedule(term)
		}else if(term instanceof NaryTermOp){
			'''«FOR nary : term.terms»«generateAuxiliarPatterns(obsName,nary,false)»«ENDFOR»'''
		}else if (term instanceof RangeTerm){
			'''
			«generateAuxiliarPatterns(obsName,term.term,false)»
			«generateRangeTermPatterns(obsName,term)»
			'''
		}else if(term instanceof UnaryTermOp){
			once = term instanceof OnceTerm
			'''«generateAuxiliarPatterns(obsName,term.term,false)»'''
		}
	}
	
	def generateRangeTermPatterns(String obsName, RangeTerm term) {
		val streamName = generateStreamName(term,obsName)
		auxPatternsNames.put(term,streamName)
		val strTerm = generateTerm(term.term)
		val pattern = 'pattern [ '+getEveryO()+ strTerm + getEveryC()+' ]'
		val lowerBound = term.lowerBound
		val upperBound = term.upperBound
		val havingClause = 'count(*) >= ' + lowerBound + ' and ' + 'count(*) <= ' + upperBound
		'''«generateInsertIntoHavingPattern(streamName,'',pattern,havingClause)»'''
	}
	
	def generateConditionalPatterns(String obsName, ConditionalTerm term) {
		val condition = term.terms.get(0) as BinaryTermOp
		val trueCase = term.terms.get(1) as ConstTerm
		val falseCase = term.terms.get(2) as ConstTerm
		val streamName = generateStreamName(term,obsName)
		auxPatternsNames.put(term,streamName)
		val expr = generateExpressionClause(condition).toString
		val caseExpr = generateCaseExpresion(expr,trueCase,falseCase)
		val strPattern = generateFromClause(condition,'lastevent').toString
		'''«generateInsertIntoPattern(streamName, caseExpr,strPattern)»'''
	}
	
	def generateCaseExpresion(String expr, ConstTerm trueCase, ConstTerm falseCase) {
		'CASE WHEN ' + expr + ' THEN ' + generateConstTerm(trueCase) + ' ELSE ' + generateConstTerm(falseCase) +' END as val'
	}
	
	def generateArithFunctionPatterns(String obsName, ArithFunction term) {
		val functionName = term.name.toString.toLowerCase		
		val streamName = generateStreamName(term,obsName)
		var selectAttr = 'val'
		
		if(term.name == ArithFtnEnum.POW && term.terms.get(1)!==null){
			val exp = generateTerm(term.terms.get(1))
			selectAttr = 'val,'+ exp
		}
		
		auxPatternsNames.put(term,streamName)
		'''«generateInsertIntoPattern(streamName, 'Math.'+functionName+'(' + selectAttr + ')' + ' as val',generateTerm(term.terms.get(0)))»'''
	}
	
	def generateAggregationPatterns(String obsName, AggregationFunction term) {
		val streamName = generateStreamName(term,obsName)
		auxPatternsNames.put(term,streamName)
		
		if(isCustomAggregationFunction(term)){
			generateCustomAggregationFunctions(streamName,term)
		}else{
			generateEsperAggregationFunctions(streamName,term)
		}
	}
	
	def isCustomAggregationFunction(Term term){
		var res = false;
		
		if(term instanceof AggregationFunction){
			if(term.name == AggregationFtnEnum.DECREASING || term.name == AggregationFtnEnum.INCREASING || term.name == AggregationFtnEnum.STABLE){
				res = true;
			}
		}
	}
	
	def generateCustomAggregationFunctions(String streamName,AggregationFunction term){
		val symbol = getSymbolForCustomAggregation(term)
		var selectAttr =  'window('+ 'b.val' + symbol + 'a.val).allOf(v=>v=true) as val'
		val size = term.terms.size
		
		if(size==2){
			val termStr = generateTerm(term.terms.get(0))
			val window = generateAggregationWindow(term.terms.get(1) as ConstTerm)
			val pattern = 'pattern [ ' +getEveryO() +  'a=' + termStr + ' -> b=' + termStr +getEveryC()+' ]#'+window
			generateInsertIntoPattern(streamName,selectAttr,pattern);
		}
		
	}
	
	def getSymbolForCustomAggregation(AggregationFunction term) {
		switch(term.name){
			case AggregationFtnEnum.DECREASING : '<'
			case AggregationFtnEnum.INCREASING : '>'
			case AggregationFtnEnum.STABLE : '='
		}
	}
	
	def generateEsperAggregationFunctions(String streamName,AggregationFunction term){
		val functionName = term.name.toString
		val lowerFunctionName = functionName.toLowerCase
		val size = term.terms.size
		var selectAttr = 'val'
		
		if(term.name == AggregationFtnEnum.COUNT){
			selectAttr = '*'
		}
		
		switch(size){
			case 1: {
				val fromClause = generateTerm(term.terms.get(0))
				generateInsertIntoPattern(streamName, lowerFunctionName +'(' + selectAttr +')'+' as val',fromClause)
			}
			case 2:{
				val window = generateAggregationWindow(term.terms.get(1) as ConstTerm)
				val fromClause = generateFromClause(term.terms.get(0),window)?.toString
				generateInsertIntoPattern(streamName, lowerFunctionName +'(' + selectAttr +')'+' as val',fromClause)
			}
			case 3:{
				val window = generateAggregationWindow(term.terms.get(1) as ConstTerm)
				val fromClause = generateFromClause(term.terms.get(0),window)?.toString
				val whereClause = generateExpressionClause(term.terms.get(2))?.toString
				generateInsertIntoWherePattern(streamName,lowerFunctionName +'(' + selectAttr +')'+' as val',fromClause,whereClause)
			}
		}
	}
	
	def generateAggregationWindow(ConstTerm const){
		var window = ''
		
		val value = const.value
		
		if(value instanceof UnitMeasuredValue){
			val realValue = value.value
			val unit = value.unit
			window = 'time_batch('+ realValue +' '+ unit +')'
		}else if(value instanceof NumericValue){
			window = 'lenght('+value.value+')'
		}
		
		window;
	}
	
	def generatePatternFunctionPatterns(String obsName, PatternFunction term) {
		val functionName = term.name
		val streamName = generateStreamName(term,obsName)
		auxPatternsNames.put(term,streamName)
		
		if(functionName==PatternFtnEnum.EVENT_WHEN){
			'''«generateEventWhenPattern(term,streamName)»'''
		}else if(functionName==PatternFtnEnum.UPDATE){
			'''«generateUpdatePattern(term,streamName)»'''
		}else if(functionName==PatternFtnEnum.PERIOD){
			'''«generatePeriodPattern(term,streamName)»'''
		}
	}
	
	def generatePeriodPattern(PatternFunction term, String streamName) {
		val firstTerm = term.terms.get(0)
		if(firstTerm!==null && isContextNode(firstTerm)){
			val varTerm = generateContextTerm(firstTerm)
			val selectClause = 'cast((b.ts - a.ts)/1000,long)  as val'
			var strPattern = ' ( a = ' + varTerm + ' )' + ' -> ' + '( not '+ varTerm + ' AND ' + '( b = ' + varTerm +'(val!=a.val)' + ' ) )'
			val pattern = 'pattern [ '+getEveryO()+ strPattern + getEveryC()+' ]'
			generateInsertIntoPattern(streamName,selectClause,pattern)
		}else if(firstTerm instanceof FollowedByTerm){
			val leftStr = generateTerm(firstTerm.left)
			val rightStr = generateTerm(firstTerm.right)
			val selectClause = 'cast((b.ts - a.ts)/1000,long) as val'
			var strPattern = ' ( a = ' + leftStr + ' )' + ' -> ' +  '( b = ' + rightStr +' )'
			val pattern = 'pattern [ '+getEveryO()+ strPattern + getEveryC()+' ]'
			generateInsertIntoPattern(streamName,selectClause,pattern)
		}
	}
	
	def generateUpdatePattern(PatternFunction term, String streamName) {
		var whereClause = ''
		val firstTerm = term.terms.get(0)
		
		var patternTrueToFalse = ''
		var patternFalseToTrue = ''
		
		if(firstTerm instanceof FollowedByTerm){
			val termStr = generateTerm(firstTerm)
			val notTermStr = generateNotTerm(firstTerm)
			patternTrueToFalse = 'pattern [ '+ getEveryO()+ '(' + termStr + ')' + '->' + '(' + notTermStr + ')' + getEveryC() +' ]'
			patternFalseToTrue = 'pattern [ '+ getEveryO()+ '(' + notTermStr + ')' + '->' + '(' + termStr + ')' + getEveryC() +' ]'
			'''
			«generateInsertIntoPattern(streamName, '',patternTrueToFalse)»
			«generateInsertIntoPattern(streamName, '',patternFalseToTrue)»'''
		}else if(!isContextNode(firstTerm)){
			whereClause = generateExpressionClause(firstTerm).toString
			val termStr = generateTerm(firstTerm)
			val notTermStr = generateNotTerm(firstTerm)
			var startPattern = generateFromClause(firstTerm,'firstevent')
			patternTrueToFalse = 'pattern [ '+ getEveryO()+ '(' + termStr + ')' + '->' + '(' + notTermStr + ')' + getEveryC() +' ]'
			patternFalseToTrue = 'pattern [ '+ getEveryO()+ '(' + notTermStr + ')' + '->' + '(' + termStr + ')' + getEveryC() +' ]'
			'''
			«generateInsertIntoWherePattern(streamName,'',startPattern.toString,whereClause)»
			«generateInsertIntoPattern(streamName, '',patternTrueToFalse)»
			«generateInsertIntoPattern(streamName, '',patternFalseToTrue)»'''			
		}else{
			val ctxName = generateContextTerm(firstTerm)
			patternTrueToFalse = '(a = ' + ctxName + ')' + '->' + '('+ 'not ' +ctxName + ' AND ' +ctxName +'(val!=a.val)' + ')'
			val finalpatternTrueToFalse = 'pattern [ '+ getEveryO()+ '('+ patternTrueToFalse + ')' + getEveryC() +' ]'
			var startPattern = generateFromClause(firstTerm,'firstevent')
			'''
			«generateInsertIntoPattern(streamName,'',startPattern.toString)»
			«generateInsertIntoPattern(streamName, '',finalpatternTrueToFalse)»'''
		}
	}
	
	def generateEventWhenPattern(PatternFunction term, String streamName) {
		val firstTerm = term.terms.get(0)
		var whereClause = generateExpressionClause(firstTerm)?.toString
		val startPattern = generateFromClause(firstTerm,'firstevent')
		val pattern = '(' + generateNotTerm(firstTerm)+ ')' + '->' + '(' + generateTerm(firstTerm) + ')'
		val finalPattern = 'pattern [ '+ getEveryO() + pattern +  getEveryC() + ' ]'
		'''
		«generateInsertIntoWherePattern(streamName,'',startPattern.toString,whereClause.toString)»
		«generateInsertIntoPattern(streamName, '',finalPattern)»
		'''
	}
		
	def String generateArithmeticsPatterns(String obsName, BinaryArithOp term){
		var streamName = generateStreamName(term,obsName)
		auxPatternsNames.put(term,streamName)
		'''«generateBinaryArithOpPattern(term,streamName)»'''
	}
	
	def generateStreamName(Term term, String obsName) {
		var opName = "" 
						
		if (term instanceof AddTerm){
			opName = "ADD"
		}else if(term instanceof SubTerm){
			opName = "SUB"
		}else if(term instanceof MultTerm){
			opName = "MUL"
		}else if(term instanceof DivTerm){
			opName = "DIV"
		}else if(term instanceof ArithFunction){
			opName = term.name.toString
		}else if(term instanceof AggregationFunction){
			opName = term.name.toString
		}else if(term instanceof PatternFunction){
			val functionName = term.name
			if(functionName==PatternFtnEnum.EVENT_WHEN){
				opName = 'EW'
			}else if(functionName==PatternFtnEnum.UPDATE){
				opName = 'UP'
			}else if(functionName==PatternFtnEnum.PERIOD){
				opName = 'PE'
			}
		}else if(term instanceof ConditionalTerm){
			opName = 'IF'
		}else if(term instanceof RangeTerm){
			opName = 'RG'
		}
		
		getUniqueStreamName(obsName + opName)
	}
	
	def getUniqueStreamName(String streamName) {
		val streamNames = auxPatternsNames.values()
		var res = ''
		
		if(!streamNames.contains(streamName)){
			res = streamName
		} else {
			var i = 1
			var uniqueStreamName = streamName + i
			
			while(streamNames.contains(uniqueStreamName)){
				i = i+1
				uniqueStreamName = streamName + i
			}
			
			res = uniqueStreamName
		}
		
		return res
	}

	def generateObservationPattern(String obsName,Term term) {
		var strAuxPattern = generateTerm(term)
		val strPattern = 'pattern [ '+getEveryO()+ strAuxPattern + getEveryC()+' ]'
		'''«generateObsInsertIntoPattern(obsName,strPattern)»'''
	}
	
	def generateBinaryArithOpPattern(BinaryArithOp term,String streamName) {
		val selectAttrs = generateExpressionClause(term)
		val strPattern = generateFromArithClause(term,'lastevent')?.toString
		'''«generateInsertIntoPattern(streamName,selectAttrs + ' as val',strPattern)»'''
	}
	
	def generateObsInsertIntoPattern(String selectAttrs, String pattern) '''
		INSERT INTO Observations
		SELECT '«selectAttrs»' as val
		FROM «pattern?.replace('\n','')»;
			
	'''		
		
	def generateInsertIntoPattern(String streamName,String selectAttrs,String pattern)'''
		INSERT INTO «streamName»
		SELECT «IF !selectAttrs.isNullOrEmpty»«selectAttrs»,«ENDIF»current_timestamp as ts
		FROM «pattern?.replace('\n','')»;
		
	'''
	
	def generateInsertIntoWherePattern(String streamName,String selectAttrs,String pattern,String whereClause)'''
		INSERT INTO «streamName»
		SELECT «IF !selectAttrs.isNullOrEmpty»«selectAttrs»,«ENDIF»current_timestamp as ts
		FROM «pattern?.replace('\n','')»
		WHERE «whereClause»;
		
	'''
	
	def generateInsertIntoHavingPattern(String streamName,String selectAttrs,String pattern,String havingClause)'''
		INSERT INTO «streamName»
		SELECT «IF !selectAttrs.isNullOrEmpty»«selectAttrs»,«ENDIF»current_timestamp as ts
		FROM «pattern?.replace('\n','')»
		HAVING «havingClause»;
		
	'''

	def String generateTerm(Term term) {
		if (term instanceof NaryTermOp) {
			'''«generateNaryTermOp(term as NaryTermOp)»'''
		} else if(term instanceof ConstTerm) {
			if(isEnumConstTerm(term)){
				generateEnumFilter(term as ConstTerm,'=')
			}else{
				'''«generateConstTerm(term as ConstTerm)»'''	
			}
		}else if(term instanceof BinaryTermOp) {
			'''«generateBinaryTermOp(term as BinaryTermOp)»'''
		}else if(isBooleanVarTerm(term)){
			'''«generateVarBooleanTerm(term,'true','=')»'''	
		}else if(term instanceof VarTerm) {
			'''«generateVarTerm(term as VarTerm)»'''
		}else if(term instanceof SelfTerm) {
			'''«generateSelfTerm(term as SelfTerm)»'''
		}else if(term instanceof UnaryTermOp) {
			'''«generateUnaryTermOp(term as UnaryTermOp)»'''
		}
	}
		
	def generateUnaryTermOp(UnaryTermOp term){
		if(term instanceof UnaryLogicalOp){
			'''«generateUnaryLogicalOp(term)»'''			
		}else if(term instanceof UnaryPatternOp){
			'''«generateUnaryPatternOP(term)»'''
		}
	}
	
	def generateUnaryPatternOP(UnaryPatternOp term) {
		if(term instanceof RepeatTerm){
			'''«generateRepeatTerm(term)»'''			
		}else if(term instanceof NotEventTerm){
			'''«generateNotEventTerm(term)»'''
		}else if(term instanceof RangeTerm){
			'''«generateRangeTerm(term)»'''
		}else if(term instanceof OnceTerm){
			'''«generateOnceTerm(term)»'''
		}
	}

	def generateBinaryTermOp(BinaryTermOp term) {
		if (term instanceof BinaryLogicalOp) {
			'''«generateBinaryLogicalOP(term as BinaryLogicalOp)»'''
		} else if(term instanceof BinaryArithOp) {
			'''«generateBinaryArithOpTerm(term)»'''
		}else if(term instanceof BinaryPatternOp) {
			'''«generateBinaryPatternOp(term as BinaryPatternOp)»'''
		}else if(term instanceof BinaryRelationalOp) {
			'''«generateBinaryRelationalOp(term as BinaryRelationalOp)»'''
		}
	}
	
	def generateBinaryArithOpTerm(BinaryArithOp term){
		val varTermName = auxPatternsNames.get(term)
		
		if(varTermName!==null && !varTermName.isEmpty){
			varTermName			
		}
	}
	
	def generateBinaryRelationalOp(BinaryRelationalOp term) {
		val symbol = getSymbol(term)
		generateBinaryRelationalTerm(term,symbol)
	}
	
	def generateBinaryRelationalTerm(BinaryRelationalOp term,String symbol) {
		var valStr = '(val'
		val right = term.right
		val left = term.left
		
		if(isBooleanVarTerm(left) && right instanceof ConstTerm){
			val boolVal = generateConstTerm(right as ConstTerm)		
			'''«generateVarBooleanTerm(left,boolVal.toString,symbol)»'''
		}else if(isBooleanVarTerm(right) && left instanceof ConstTerm){
			val boolVal = generateConstTerm(left as ConstTerm)
			val finalSymbol = getReverseSymbol(symbol)		
			'''«generateVarBooleanTerm(right,boolVal.toString,finalSymbol)»'''
		}else if(isContextNode(left) && isContextNode(right)){
			val aLetter = letter++
			val bLetter = letter++
			'''(«aLetter»=«generateTerm(left)» AND «bLetter»=«generateTerm(right)») while(«aLetter».val «symbol» «bLetter».val)'''
		}else if(isContextNode(right)){
			var finalSymbol = getReverseSymbol(symbol)
			var lefttStr = ''
			if(isEnumConstTerm(left)){
				lefttStr = generateConstTerm(left as ConstTerm)?.toString
			}else{
				lefttStr = generateTerm(left)
			}
			'''«generateTerm(right)»«valStr» «finalSymbol» «lefttStr»)'''
		}else if(isContextNode(left)){
			var rightStr = ''
			if(isEnumConstTerm(right)){
				rightStr = generateConstTerm(right as ConstTerm)?.toString
			}else{
				rightStr=generateTerm(right)
			}
			'''«generateTerm(left)»«valStr» «symbol» «rightStr»)'''
		}		
	}
	
	def getReverseSymbol(String symbol) {
		switch(symbol){
			case '<' : '>'
			case '>' : '<'
			case '<=' : '>='
			case '>=' : '<='
			default : symbol
		}
	}
		
	def getOpossiteSymbol(String symbol) {
		switch(symbol){
			case '>' : '<='
			case '<' : '>='
			case '=' : '!='
			case '!=' : '='
			case '>=' : '<'
			case '<=' : '>'
			case 'AND' : 'OR'
			case 'OR' : 'AND'
			default : symbol
		}
	}
	
	def generateBinaryPatternOp(BinaryPatternOp term) {
		var symbol = getSymbol(term)
				
		if(term instanceof WhileTerm){
			'''«generateWhileTerm(term)»'''
		}else{
			val leftStr = getBinaryOpStrTerm(term.left)
			val rightStr = getBinaryOpStrTerm(term.right) 
			
			'''«leftStr» «symbol» «rightStr»'''
		}			
	}
	
	def getBinaryOpStrTerm(Term term){
		if(isBooleanVarTerm(term)){
			generateVarBooleanTerm(term,'true','=')		
		}else{
			generateTerm(term)
		} 
	}
	
	def generateWhileTerm(WhileTerm term) {
		val right = term.right
		val whileVarTerms = newArrayList
		var expr = ''
		
		fillVarTermList(right,whileVarTerms)
		
		expr = generateExpressionClause(right)?.toString
		
		letter = 'a'
		'''«generateWhileTermRec(term.left,whileVarTerms)» while («expr»)'''
	}
	
	def fillVarTermList(Term term, ArrayList<String> whileVarTerms) {
		if(isContextNode(term)){
			var varTerm = ''
			if(term instanceof VarTerm){
				varTerm = generateVarTerm(term) 
			}else{
				varTerm = generateTerm(term)
			}
			if(!whileVarTerms.contains(varTerm)){
				whileVarTerms.add(varTerm)
			}
		}else if(term instanceof BinaryTermOp){
			fillVarTermList(term.left,whileVarTerms)
			fillVarTermList(term.right,whileVarTerms)
		}
	}
	
	def generateWhileTermRec(Term term, List<String> whileVarTerms){
		var strTerm = generateTerm(term)
		for(contextName : whileVarTerms){
			if(strTerm.contains(contextName)){
				strTerm = strTerm.replace(contextName.toString,letter++ + ' = ' + contextName.toString)
			}else{
				strTerm = strTerm + ' AND ' + letter++ + ' = ' + contextName
			}
		}
		return strTerm 
	}
	
	def generateFromClause(Term term, String window) {
		letter='a'
		varTermAs.clear();
		generateFromClauseRec(term,window)
	}
	
	def generateFromArithClause(Term term, String window) {
		letter='a'
		varTermAs.clear();
		generateFromArithClauseRec(term,window)
	}
	
	def generateFromClauseRec(Term term, String window) {
		if(isContextNode(term)){
			val varTermName = generateContextTerm(term)
			if(varTermAs.get(varTermName)===null){
				val varTermCharacter = getVarTermLetter(varTermName)
				varTermName +'#'+window+' as '+varTermCharacter
			}
		}else if(term instanceof BinaryTermOp){
				val left = generateFromClauseRec(term.left,window)?.toString
				val right = generateFromClauseRec(term.right,window)?.toString
				if(!left.isNullOrEmpty && !right.isNullOrEmpty){
					left +',' + right
				}else if(left.isNullOrEmpty){
					right
				}else{
					left
				}
		}else if(term instanceof NaryTermOp){
			var res = ''
			var prev = ''
			var current = ''
			
			for(nary : term.terms){
				current = generateFromClauseRec(nary,window).toString
				if(!prev.isNullOrEmpty && !current.isNullOrEmpty){
					res = res + ',' + current
				}else{
					res = res + ', '
				}
				prev = current					
			}
			return res
		}else if(term instanceof UnaryTermOp){
			generateFromClauseRec(term.term,window)
		}else if(term instanceof ConstTerm){
			if(term.value instanceof EnumValue){
				val enumVal = term.value as EnumValue
				val enumType = enumVal.value.enumType as DataType
				val contDec = enumType.eContainer as DataTypeDeclaration
				val typedVar = contDec.eContainer as TypedVariable
				val varTermName = typedVar.name
				
				if(varTermAs.get(varTermName)===null){
					val varTermCharacter = getVarTermLetter(varTermName)
					varTermName +'#'+window+' as '+varTermCharacter
				}
			}
		}
	}
	
	def generateContextTerm(Term term) {
		if(!(term instanceof VarTerm)){
			auxPatternsNames.get(term)	
		}else{
			generateVarTerm(term as VarTerm)
		}
	}
	
	def generateFromArithClauseRec(Term term, String window) {
		if(isContextNode(term) && !(term instanceof BinaryArithOp)){
			val varTermName = generateContextTerm(term)
			if(varTermAs.get(varTermName)===null){
				val varTermCharacter = getVarTermLetter(varTermName)
				varTermName +'#'+window+' as '+varTermCharacter
			}
		}else if(term instanceof BinaryTermOp){
				val left = generateFromArithClauseRec(term.left,window)?.toString
				val right = generateFromArithClauseRec(term.right,window)?.toString
				if(!left.isNullOrEmpty && !right.isNullOrEmpty){
					left +',' + right
				}else if(left.isNullOrEmpty){
					right
				}else{
					left
				}
		}else if(term instanceof NaryTermOp){
			var res = ''
			var prev = ''
			var current = ''
			
			for(nary : term.terms){
				current = generateFromArithClauseRec(nary,window).toString
				if(!prev.isNullOrEmpty && !current.isNullOrEmpty){
					res = res + ',' + current
				}else{
					res = res + ', '
				}
				prev = current					
			}
			res
		}else if(term instanceof UnaryTermOp){
			generateFromArithClauseRec(term.term,window)
		}else if(term instanceof ConstTerm){
			if(term.value instanceof EnumValue){
				val enumVal = term.value as EnumValue
				val enumType = enumVal.value.enumType as DataType
				val contDec = enumType.eContainer as DataTypeDeclaration
				val typedVar = contDec.eContainer as TypedVariable
				val varTermName = typedVar.name
				
				if(varTermAs.get(varTermName)===null){
					val varTermCharacter = getVarTermLetter(varTermName)
					varTermName +'#'+window+' as '+varTermCharacter
				}
			}
		}
	}
	
	def generateExpressionClauseRec(Term term) {
		if(term instanceof BinaryTermOp){
			val symbol = getSymbol(term)
			generateBinaryTermExpression(term,symbol,false)	
		}else if(isBooleanVarTerm(term)){
				getExpresionOperand(term)+ ' = true'	
		}else if(isEnumConstTerm(term)){
				val constTerm = term as ConstTerm
				getExpresionOperand(term)+ ' = ' + generateEnumConstTerm(constTerm.value as EnumValue)
		}else if(term instanceof NotBooleanTerm){
			generateNotExpressionClauseRec(term.term)
		}else{
			getExpresionOperand(term)
		}
	}
	
	def generateNotExpressionClauseRec(Term term) {
		if(term instanceof BinaryTermOp){
			val symbol = getSymbol(term)
			val opossiteSymbol = getOpossiteSymbol(symbol)
			generateBinaryTermExpression(term,opossiteSymbol,true)
		}else if(isBooleanVarTerm(term)){
				getExpresionOperand(term)+ ' = false'	
		}else if(isEnumConstTerm(term)){
				val constTerm = term as ConstTerm
				getExpresionOperand(term)+ ' != ' + generateEnumConstTerm(constTerm.value as EnumValue)
		}else if(term instanceof NotBooleanTerm){
			generateExpressionClauseRec(term.term)
		}else{
			getExpresionOperand(term)
		}
	}
	
	def generateExpressionClause(Term term) {
		letter='a'
		varTermAs.clear();
		generateExpressionClauseRec(term);
	}	
	
	def generateBinaryTermExpression(BinaryTermOp term, String symbol,boolean isFromNot) {
		val left = term.left
		val right = term.right
		
		if(isEnumConstTerm(right) && isContextNode(left)){
			'''«getExpresionOperand(left)» «symbol» «generateEnumConstTerm(right as ConstTerm)»'''	
		}else if(isBooleanConstTerm(right) && isContextNode(left)){
			'''«getExpresionOperand(left)» «symbol» «generateConstTerm(right as ConstTerm)»'''	
		}else{
			if(isFromNot){
				'''«generateNotExpressionClauseRec(left)» «symbol» «generateNotExpressionClauseRec(right)»'''	
			}else{
				'''«generateExpressionClauseRec(left)» «symbol» «generateExpressionClauseRec(right)»'''
			}
		}
	}
	
	def isBooleanConstTerm(Term term) {
		var res = false
		if(term instanceof ConstTerm){
			val valueTerm = term.value
			res =  valueTerm instanceof BooleanValue
		}
		return res
	}
	
	def getExpresionOperand(Term term){
		var pattName = auxPatternsNames.get(term)
		var result = ''
		
		if(!pattName.isNullOrEmpty){
			result = getVarTermLetter(pattName) + '.val'
		}else if(term instanceof VarTerm){
			if(term.variable instanceof Parameter || term.variable instanceof GeneralPurposeVariable){
				result = generateVarTerm(term)
			}else{
				result = getVarTermLetter(generateVarTerm(term))+'.val'
			}
		}else if(term instanceof ConstTerm){
			if(term.value instanceof EnumValue){
				val enumVal = term.value as EnumValue
				val enumType = enumVal.value.enumType as DataType
				val contDec = enumType.eContainer as DataTypeDeclaration
				val typedVar = contDec.eContainer as TypedVariable
				val varTermName = typedVar.name
				result = varTermAs.get(varTermName)
				if(result.isNullOrEmpty){
					result = getVarTermLetter(varTermName)
				}
				result = result + '.val'
			}else{
				result = generateConstTerm(term).toString
			}
		}
			
		result
	}
	
	def String getVarTermLetter(String varTermName) {
		var varTermLetter = varTermAs.get(varTermName)
		
		if(varTermLetter.isNullOrEmpty){
			varTermLetter = String.valueOf(letter++)
			varTermAs.put(varTermName,varTermLetter );	
		}
		
		return varTermLetter	
	}
	
	def generateBinaryLogicalOP(BinaryLogicalOp term) {
		var symbol = getSymbol(term)
		'''«generateTerm(term.left)» «symbol» «generateTerm(term.right)»'''		
	}
	
	def generateConstTerm(ConstTerm term) {
		val valueTerm = term.value
		if(valueTerm instanceof EnumValue){
			generateEnumConstTerm(term)
		}else if(valueTerm instanceof BooleanValue){
			valueTerm.value
		}else if(valueTerm instanceof NumericValue){
			if(valueTerm instanceof UnitMeasuredValue){
				val doubleVal = Double.parseDouble(valueTerm.value.toString)
				val intVal = doubleVal.intValue
				String.valueOf(intVal)			
			}else{
				valueTerm.value	
			}
		}
	}
	
	def generateEnumConstTerm(ConstTerm constTerm){
		val enumVal = constTerm.value as EnumValue
		val enumType = enumVal.value.enumType as DataType
		var contDec = enumType.eContainer
		var name = ''
		
		if(contDec instanceof DataTypeDeclaration){
			val typedVar = contDec.eContainer as TypedVariable
			name = typedVar.name 
		}else if(contDec instanceof DataTypeDefinition){
			name = contDec.name
		}
		
		 name + '.' + enumVal.value.name
	}
	
	def generateEnumConstTerm(EnumValue enumVal){
		val enumType = enumVal.value.enumType as DataType
		var contDec = enumType.eContainer
		var name = ''
		
		if(contDec instanceof DataTypeDeclaration){
			val typedVar = contDec.eContainer as TypedVariable
			name = typedVar.name 
		}else if(contDec instanceof DataTypeDefinition){
			name = contDec.name
		}
		
		 name + '.' + enumVal.value.name
	}
	
	def generateEnumFilter(ConstTerm term,String symbol){
		val valueTerm = term.value
		if(valueTerm instanceof EnumValue){
			val value = generateConstTerm(term)
			val enumType = valueTerm.value.enumType as DataType
			val contDec = enumType.eContainer as DataTypeDeclaration
			val typedVar = contDec.eContainer as TypedVariable
			typedVar.name + '(val'+ symbol + value +')'
		}
	}

	def generateNaryTermOp(NaryTermOp term) {
		if(term instanceof FunctionTerm){
			generateFuncionTerm(term as FunctionTerm)
		}else if(term instanceof ConditionalTerm){
			generateConditionalTerm(term)
		}
	}
	
	def generateConditionalTerm(ConditionalTerm term) {
		auxPatternsNames.get(term)
	}

	def generateFuncionTerm(FunctionTerm term) {
		if(term instanceof ScheduleFunction){
			generateScheduleFunctionTerm(term)
		}else if(term instanceof PatternFunction){
			generatePatternFunctionTerm(term)
		}else if(term instanceof ArithFunction){
			generateArithFunctionTerm(term)
		}else if(term instanceof AggregationFunction){
			generateAggregationFunctionTerm(term)
		}else if(term instanceof CollectionFunction){
			generateCollectionFunctionTerm(term)
		}
	}
	
	def generateCollectionFunctionTerm(CollectionFunction function) {
	}
	
	def generateAggregationFunctionTerm(AggregationFunction term) {
		auxPatternsNames.get(term)
	}
	
	def generateArithFunctionTerm(ArithFunction term) {
		auxPatternsNames.get(term)
	}
	
	def generateOnceTerm(OnceTerm once) {
		once=true;
		'''«generateTerm(once.term)»'''
	}
	
	def generateRangeTerm(RangeTerm term) {
		auxPatternsNames.get(term)
	}
	
	def generateNotEventTerm(NotEventTerm not) {
		''' not («generateTerm(not.term)»)'''
	}
	
	def generateRepeatTerm(RepeatTerm term) {
		'''[«term.nrep»] («generateTerm(term.term)»)'''
	}
	
	def generateUnaryLogicalOp(UnaryLogicalOp not) {
		'''«generateNotTerm(not.term)»'''
	}
	
	def generateNotTerm(Term term) {
		if(term instanceof BinaryTermOp){
			if (term instanceof BinaryLogicalOp) {
				generateNotBinaryLogicalOP(term as BinaryLogicalOp)
			}else if(term instanceof BinaryPatternOp) {
				generateNotBinaryPatternOp(term as BinaryPatternOp)
			}else if(term instanceof BinaryRelationalOp) {
				generateNotBinaryRelationalOp(term as BinaryRelationalOp)
			}else if(term instanceof BinaryArithOp){
				generateTerm(term)
			}
		}else if(term instanceof NotEventTerm || term instanceof NotBooleanTerm){
			val unaryTerm = term as UnaryTermOp
			if(isBooleanVarTerm(unaryTerm.term)){
				generateVarBooleanTerm(unaryTerm.term,'true','=')	
			}else if(isEnumConstTerm(unaryTerm.term)){
				generateEnumFilter(unaryTerm.term as ConstTerm,'=')	
			}else{
				generateTerm(unaryTerm.term)
			}
		} else if(isEnumConstTerm(term)){
			generateEnumFilter(term as ConstTerm,'!=')	
		}else if(isBooleanVarTerm(term)){
				generateVarBooleanTerm(term,'false','=')
		}else{
			generateTerm(term)
		}
	}
	
	def isBooleanVarTerm(Term term){
		var res = false;
		
		if(term instanceof VarTerm){
			if(term.variable.declaration instanceof ContainedDeclaration){
				val contDec = term.variable.declaration as ContainedDeclaration
				res = contDec.type instanceof BooleanType
			}
		}else if(isCustomAggregationFunction(term) || term instanceof ConditionalTerm){
			res = true;
		}
		
		return res;
	}
	
	def isEnumConstTerm(Term term){
		var res = false
		if(term instanceof ConstTerm){
			val valueTerm = term.value
			res =  valueTerm instanceof EnumValue
		}
		return res
	}
	
	def generateNotBinaryRelationalOp(BinaryRelationalOp term) {		
		var valStr = '(val'
		var symbol = getOpossiteSymbol(getSymbol(term)) 
			
		val right = term.right
		val left = term.left
		
		if(isBooleanVarTerm(left) && right instanceof ConstTerm){
			val boolVal = generateConstTerm(right as ConstTerm)		
			'''«generateVarBooleanTerm(left,boolVal.toString,symbol)»'''
		}else if(isBooleanVarTerm(right) && left instanceof ConstTerm){
			val boolVal = generateConstTerm(left as ConstTerm)
			val finalSymbol = getReverseSymbol(symbol)		
			'''«generateVarBooleanTerm(right,boolVal.toString,finalSymbol)»'''
		}else if(isContextNode(left) && isContextNode(right)){
			val aLetter = letter++
			val bLetter = letter++
			'''(«aLetter»=«generateNotTerm(left)» AND «bLetter»=«generateNotTerm(right)») while(«aLetter».val «symbol» «bLetter».val)'''
		}else if(isContextNode(right)){
			var finalSymbol = getReverseSymbol(symbol)
			var lefttStr = ''
			if(isEnumConstTerm(left)){
				lefttStr = generateConstTerm(left as ConstTerm)?.toString
			}else{
				lefttStr = generateNotTerm(left)?.toString
			}
			'''«generateNotTerm(right)»«valStr» «finalSymbol» «lefttStr»)'''
		}else if(isContextNode(left)){
			var rightStr = ''
			if(isEnumConstTerm(right)){
				rightStr = generateConstTerm(right as ConstTerm)?.toString
			}else{
				rightStr=generateNotTerm(right)?.toString
			}
			'''«generateNotTerm(left)»«valStr» «symbol» «rightStr»)'''
		}		
	}
	
	def boolean isContextNode(Term term){
		var res = false
		
		if(term instanceof VarTerm){			
			if(!(term.variable instanceof Parameter || term.variable instanceof GeneralPurposeVariable)){
				res = true				
			}			
		}else if(term instanceof BinaryArithOp || term instanceof NaryTermOp){
			res = true;
		}		
		
		return res;				
	}
	
	def generateNotBinaryLogicalOP(BinaryLogicalOp term) {
		var symbol = getSymbol(term)
		var opossiteSymbol = getOpossiteSymbol(symbol)
		val left = term.left
		val right = term.right
		var leftStr = ''
		var rightStr = ''
		
		if(isContextNode(left)){
			leftStr = '''not ( «generateTerm(left)» )'''
		}else{
			leftStr = '''«generateNotTerm(left)»'''
		}
		
		if(isContextNode(right)){
			rightStr = '''not ( «generateTerm(right)» )'''
		}else{
			rightStr = '''«generateNotTerm(right)»'''
		}
		
		
		'''«leftStr» «opossiteSymbol» «rightStr»'''
	}
	
	def generateNotBinaryPatternOp(BinaryPatternOp term) {
		var symbol = getSymbol(term)
		var opossiteSymbol = getOpossiteSymbol(symbol)
		val left = term.left
		val right = term.right
		var leftStr = ''
		var rightStr = ''
		
		if(isContextNode(left) && !isBooleanVarTerm(left) && !isEnumConstTerm(left)){
			leftStr = '''not «generateTerm(left)»'''
		}else{
			leftStr = '''«generateNotTerm(left)»'''
		}
		
		if(isContextNode(right) && !isBooleanVarTerm(right) && !isEnumConstTerm(right)){
			rightStr = '''not «generateTerm(right)»'''
		}else{
			rightStr = '''«generateNotTerm(right)»'''
		}
		
		'''«leftStr» «opossiteSymbol» «rightStr»'''			
	}
		
	def generateSelfTerm(SelfTerm term) '''
	'''

	def generateVarTerm(VarTerm term) {
		if(term.variable instanceof Timer){
			val timer = term.variable as Timer
			auxPatternsNames.get(timer.definition.term)
		}else{
		 	term.variable.name	
		}
	}
	
	def generateVarBooleanTerm(Term term,String value,String symbol){
		val filter = '(val'+symbol+value+')'
		if(term instanceof VarTerm){
			term.variable.name + filter
		}else if(isCustomAggregationFunction(term) || term instanceof ConditionalTerm){
			generateTerm(term) + filter	
		}
	}
		

	def generatePatternFunctionTerm(PatternFunction term) {
		auxPatternsNames.get(term)
	}
		

	def generateJavaEnums(EnumType enumVar, String contextName) '''
		package «ENUM_PACKAGE_NAME»;
		public enum «contextName» {
			«FOR lit : enumVar.literals SEPARATOR ', ' AFTER ';'»«lit.name»«ENDFOR»
		}
	'''
	
	def getSymbol(BinaryTermOp term){
		var symbol = ""
		
		if (term instanceof LessThanTerm){
			symbol = '<'
		}else if(term instanceof NotEqualTerm){
			symbol = '!='
		}else if(term instanceof EqualTerm){
			symbol = '='
		}else if(term instanceof GreaterEqualTerm){
			symbol = '>='
		}else if(term instanceof LessEqualTerm){
			symbol = '<='
		}else if(term instanceof GreaterThanTerm){
			symbol = '>'
		}else if(term instanceof AndBooleanTerm){
			symbol = 'AND'
		}else if(term instanceof OrBooleanTerm){
			symbol = 'OR'
		}if(term instanceof FollowedByTerm){
			symbol= '->'		
		}else if(term instanceof WhileTerm){
			symbol= 'while'
		}else if(term instanceof AndEventTerm){
			symbol= 'AND'
		}else if(term instanceof OrEventTerm){
			symbol= 'OR'
		}else if (term instanceof AddTerm){
			symbol= '+'
		}else if(term instanceof SubTerm){
			symbol= '-'
		}else if(term instanceof MultTerm){
			symbol= '*'
		}else if(term instanceof DivTerm){
			symbol= '/'
		}
		return symbol
	}
	
	def String getEveryO(){
			if(once){
				''''''
			}else{
				'''every ( '''
			}
		}

	def String getEveryC(){
		if(once){
			once=false
			''''''
		}else{
			''' )'''
		}
	}
}