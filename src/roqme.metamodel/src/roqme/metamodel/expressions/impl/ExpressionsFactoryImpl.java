/**
 */
package roqme.metamodel.expressions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import roqme.metamodel.expressions.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionsFactoryImpl extends EFactoryImpl implements ExpressionsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExpressionsFactory init() {
		try {
			ExpressionsFactory theExpressionsFactory = (ExpressionsFactory)EPackage.Registry.INSTANCE.getEFactory(ExpressionsPackage.eNS_URI);
			if (theExpressionsFactory != null) {
				return theExpressionsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExpressionsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ExpressionsPackage.CONST_TERM: return createConstTerm();
			case ExpressionsPackage.VAR_TERM: return createVarTerm();
			case ExpressionsPackage.NOT_BOOLEAN_TERM: return createNotBooleanTerm();
			case ExpressionsPackage.REPEAT_TERM: return createRepeatTerm();
			case ExpressionsPackage.ADD_TERM: return createAddTerm();
			case ExpressionsPackage.MULT_TERM: return createMultTerm();
			case ExpressionsPackage.SUB_TERM: return createSubTerm();
			case ExpressionsPackage.DIV_TERM: return createDivTerm();
			case ExpressionsPackage.AND_BOOLEAN_TERM: return createAndBooleanTerm();
			case ExpressionsPackage.OR_BOOLEAN_TERM: return createOrBooleanTerm();
			case ExpressionsPackage.LESS_EQUAL_TERM: return createLessEqualTerm();
			case ExpressionsPackage.GREATER_EQUAL_TERM: return createGreaterEqualTerm();
			case ExpressionsPackage.NOT_EQUAL_TERM: return createNotEqualTerm();
			case ExpressionsPackage.EQUAL_TERM: return createEqualTerm();
			case ExpressionsPackage.GREATER_THAN_TERM: return createGreaterThanTerm();
			case ExpressionsPackage.LESS_THAN_TERM: return createLessThanTerm();
			case ExpressionsPackage.FOLLOWED_BY_TERM: return createFollowedByTerm();
			case ExpressionsPackage.ARITH_FUNCTION: return createArithFunction();
			case ExpressionsPackage.AGGREGATION_FUNCTION: return createAggregationFunction();
			case ExpressionsPackage.PATTERN_FUNCTION: return createPatternFunction();
			case ExpressionsPackage.GENERAL_EXPRESSION: return createGeneralExpression();
			case ExpressionsPackage.CONTEXT_PATTERN: return createContextPattern();
			case ExpressionsPackage.OUTPUT_TRANSFORMATION: return createOutputTransformation();
			case ExpressionsPackage.WHILE_TERM: return createWhileTerm();
			case ExpressionsPackage.CONDITIONAL_TERM: return createConditionalTerm();
			case ExpressionsPackage.SELF_TERM: return createSelfTerm();
			case ExpressionsPackage.COLLECTION_FUNCTION: return createCollectionFunction();
			case ExpressionsPackage.ONCE_TERM: return createOnceTerm();
			case ExpressionsPackage.RANGE_TERM: return createRangeTerm();
			case ExpressionsPackage.MOD_TERM: return createModTerm();
			case ExpressionsPackage.SCHEDULE_FUNCTION: return createScheduleFunction();
			case ExpressionsPackage.AND_EVENT_TERM: return createAndEventTerm();
			case ExpressionsPackage.OR_EVENT_TERM: return createOrEventTerm();
			case ExpressionsPackage.NOT_EVENT_TERM: return createNotEventTerm();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ExpressionsPackage.ARITH_FTN_ENUM:
				return createArithFtnEnumFromString(eDataType, initialValue);
			case ExpressionsPackage.AGGREGATION_FTN_ENUM:
				return createAggregationFtnEnumFromString(eDataType, initialValue);
			case ExpressionsPackage.PATTERN_FTN_ENUM:
				return createPatternFtnEnumFromString(eDataType, initialValue);
			case ExpressionsPackage.COLLECTION_FTN_ENUM:
				return createCollectionFtnEnumFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ExpressionsPackage.ARITH_FTN_ENUM:
				return convertArithFtnEnumToString(eDataType, instanceValue);
			case ExpressionsPackage.AGGREGATION_FTN_ENUM:
				return convertAggregationFtnEnumToString(eDataType, instanceValue);
			case ExpressionsPackage.PATTERN_FTN_ENUM:
				return convertPatternFtnEnumToString(eDataType, instanceValue);
			case ExpressionsPackage.COLLECTION_FTN_ENUM:
				return convertCollectionFtnEnumToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstTerm createConstTerm() {
		ConstTermImpl constTerm = new ConstTermImpl();
		return constTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VarTerm createVarTerm() {
		VarTermImpl varTerm = new VarTermImpl();
		return varTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotBooleanTerm createNotBooleanTerm() {
		NotBooleanTermImpl notBooleanTerm = new NotBooleanTermImpl();
		return notBooleanTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepeatTerm createRepeatTerm() {
		RepeatTermImpl repeatTerm = new RepeatTermImpl();
		return repeatTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddTerm createAddTerm() {
		AddTermImpl addTerm = new AddTermImpl();
		return addTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultTerm createMultTerm() {
		MultTermImpl multTerm = new MultTermImpl();
		return multTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubTerm createSubTerm() {
		SubTermImpl subTerm = new SubTermImpl();
		return subTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DivTerm createDivTerm() {
		DivTermImpl divTerm = new DivTermImpl();
		return divTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndBooleanTerm createAndBooleanTerm() {
		AndBooleanTermImpl andBooleanTerm = new AndBooleanTermImpl();
		return andBooleanTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrBooleanTerm createOrBooleanTerm() {
		OrBooleanTermImpl orBooleanTerm = new OrBooleanTermImpl();
		return orBooleanTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LessEqualTerm createLessEqualTerm() {
		LessEqualTermImpl lessEqualTerm = new LessEqualTermImpl();
		return lessEqualTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GreaterEqualTerm createGreaterEqualTerm() {
		GreaterEqualTermImpl greaterEqualTerm = new GreaterEqualTermImpl();
		return greaterEqualTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotEqualTerm createNotEqualTerm() {
		NotEqualTermImpl notEqualTerm = new NotEqualTermImpl();
		return notEqualTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EqualTerm createEqualTerm() {
		EqualTermImpl equalTerm = new EqualTermImpl();
		return equalTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GreaterThanTerm createGreaterThanTerm() {
		GreaterThanTermImpl greaterThanTerm = new GreaterThanTermImpl();
		return greaterThanTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LessThanTerm createLessThanTerm() {
		LessThanTermImpl lessThanTerm = new LessThanTermImpl();
		return lessThanTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FollowedByTerm createFollowedByTerm() {
		FollowedByTermImpl followedByTerm = new FollowedByTermImpl();
		return followedByTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArithFunction createArithFunction() {
		ArithFunctionImpl arithFunction = new ArithFunctionImpl();
		return arithFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregationFunction createAggregationFunction() {
		AggregationFunctionImpl aggregationFunction = new AggregationFunctionImpl();
		return aggregationFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternFunction createPatternFunction() {
		PatternFunctionImpl patternFunction = new PatternFunctionImpl();
		return patternFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralExpression createGeneralExpression() {
		GeneralExpressionImpl generalExpression = new GeneralExpressionImpl();
		return generalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextPattern createContextPattern() {
		ContextPatternImpl contextPattern = new ContextPatternImpl();
		return contextPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputTransformation createOutputTransformation() {
		OutputTransformationImpl outputTransformation = new OutputTransformationImpl();
		return outputTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhileTerm createWhileTerm() {
		WhileTermImpl whileTerm = new WhileTermImpl();
		return whileTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalTerm createConditionalTerm() {
		ConditionalTermImpl conditionalTerm = new ConditionalTermImpl();
		return conditionalTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelfTerm createSelfTerm() {
		SelfTermImpl selfTerm = new SelfTermImpl();
		return selfTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionFunction createCollectionFunction() {
		CollectionFunctionImpl collectionFunction = new CollectionFunctionImpl();
		return collectionFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OnceTerm createOnceTerm() {
		OnceTermImpl onceTerm = new OnceTermImpl();
		return onceTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeTerm createRangeTerm() {
		RangeTermImpl rangeTerm = new RangeTermImpl();
		return rangeTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModTerm createModTerm() {
		ModTermImpl modTerm = new ModTermImpl();
		return modTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScheduleFunction createScheduleFunction() {
		ScheduleFunctionImpl scheduleFunction = new ScheduleFunctionImpl();
		return scheduleFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndEventTerm createAndEventTerm() {
		AndEventTermImpl andEventTerm = new AndEventTermImpl();
		return andEventTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrEventTerm createOrEventTerm() {
		OrEventTermImpl orEventTerm = new OrEventTermImpl();
		return orEventTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotEventTerm createNotEventTerm() {
		NotEventTermImpl notEventTerm = new NotEventTermImpl();
		return notEventTerm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArithFtnEnum createArithFtnEnumFromString(EDataType eDataType, String initialValue) {
		ArithFtnEnum result = ArithFtnEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertArithFtnEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregationFtnEnum createAggregationFtnEnumFromString(EDataType eDataType, String initialValue) {
		AggregationFtnEnum result = AggregationFtnEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAggregationFtnEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternFtnEnum createPatternFtnEnumFromString(EDataType eDataType, String initialValue) {
		PatternFtnEnum result = PatternFtnEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPatternFtnEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionFtnEnum createCollectionFtnEnumFromString(EDataType eDataType, String initialValue) {
		CollectionFtnEnum result = CollectionFtnEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCollectionFtnEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsPackage getExpressionsPackage() {
		return (ExpressionsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExpressionsPackage getPackage() {
		return ExpressionsPackage.eINSTANCE;
	}

} //ExpressionsFactoryImpl
