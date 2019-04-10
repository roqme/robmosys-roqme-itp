/**
 */
package roqme.metamodel.expressions;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see roqme.metamodel.expressions.ExpressionsPackage
 * @generated
 */
public interface ExpressionsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionsFactory eINSTANCE = roqme.metamodel.expressions.impl.ExpressionsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Const Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Const Term</em>'.
	 * @generated
	 */
	ConstTerm createConstTerm();

	/**
	 * Returns a new object of class '<em>Var Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Var Term</em>'.
	 * @generated
	 */
	VarTerm createVarTerm();

	/**
	 * Returns a new object of class '<em>Not Boolean Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not Boolean Term</em>'.
	 * @generated
	 */
	NotBooleanTerm createNotBooleanTerm();

	/**
	 * Returns a new object of class '<em>Repeat Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Repeat Term</em>'.
	 * @generated
	 */
	RepeatTerm createRepeatTerm();

	/**
	 * Returns a new object of class '<em>Add Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Term</em>'.
	 * @generated
	 */
	AddTerm createAddTerm();

	/**
	 * Returns a new object of class '<em>Mult Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mult Term</em>'.
	 * @generated
	 */
	MultTerm createMultTerm();

	/**
	 * Returns a new object of class '<em>Sub Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Term</em>'.
	 * @generated
	 */
	SubTerm createSubTerm();

	/**
	 * Returns a new object of class '<em>Div Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Div Term</em>'.
	 * @generated
	 */
	DivTerm createDivTerm();

	/**
	 * Returns a new object of class '<em>And Boolean Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And Boolean Term</em>'.
	 * @generated
	 */
	AndBooleanTerm createAndBooleanTerm();

	/**
	 * Returns a new object of class '<em>Or Boolean Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or Boolean Term</em>'.
	 * @generated
	 */
	OrBooleanTerm createOrBooleanTerm();

	/**
	 * Returns a new object of class '<em>Less Equal Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Less Equal Term</em>'.
	 * @generated
	 */
	LessEqualTerm createLessEqualTerm();

	/**
	 * Returns a new object of class '<em>Greater Equal Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Greater Equal Term</em>'.
	 * @generated
	 */
	GreaterEqualTerm createGreaterEqualTerm();

	/**
	 * Returns a new object of class '<em>Not Equal Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not Equal Term</em>'.
	 * @generated
	 */
	NotEqualTerm createNotEqualTerm();

	/**
	 * Returns a new object of class '<em>Equal Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equal Term</em>'.
	 * @generated
	 */
	EqualTerm createEqualTerm();

	/**
	 * Returns a new object of class '<em>Greater Than Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Greater Than Term</em>'.
	 * @generated
	 */
	GreaterThanTerm createGreaterThanTerm();

	/**
	 * Returns a new object of class '<em>Less Than Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Less Than Term</em>'.
	 * @generated
	 */
	LessThanTerm createLessThanTerm();

	/**
	 * Returns a new object of class '<em>Followed By Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Followed By Term</em>'.
	 * @generated
	 */
	FollowedByTerm createFollowedByTerm();

	/**
	 * Returns a new object of class '<em>Arith Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Arith Function</em>'.
	 * @generated
	 */
	ArithFunction createArithFunction();

	/**
	 * Returns a new object of class '<em>Aggregation Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aggregation Function</em>'.
	 * @generated
	 */
	AggregationFunction createAggregationFunction();

	/**
	 * Returns a new object of class '<em>Pattern Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern Function</em>'.
	 * @generated
	 */
	PatternFunction createPatternFunction();

	/**
	 * Returns a new object of class '<em>General Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>General Expression</em>'.
	 * @generated
	 */
	GeneralExpression createGeneralExpression();

	/**
	 * Returns a new object of class '<em>Context Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Context Pattern</em>'.
	 * @generated
	 */
	ContextPattern createContextPattern();

	/**
	 * Returns a new object of class '<em>Output Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Transformation</em>'.
	 * @generated
	 */
	OutputTransformation createOutputTransformation();

	/**
	 * Returns a new object of class '<em>While Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>While Term</em>'.
	 * @generated
	 */
	WhileTerm createWhileTerm();

	/**
	 * Returns a new object of class '<em>Conditional Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conditional Term</em>'.
	 * @generated
	 */
	ConditionalTerm createConditionalTerm();

	/**
	 * Returns a new object of class '<em>Self Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Self Term</em>'.
	 * @generated
	 */
	SelfTerm createSelfTerm();

	/**
	 * Returns a new object of class '<em>Collection Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Function</em>'.
	 * @generated
	 */
	CollectionFunction createCollectionFunction();

	/**
	 * Returns a new object of class '<em>Once Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Once Term</em>'.
	 * @generated
	 */
	OnceTerm createOnceTerm();

	/**
	 * Returns a new object of class '<em>Range Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Range Term</em>'.
	 * @generated
	 */
	RangeTerm createRangeTerm();

	/**
	 * Returns a new object of class '<em>Mod Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mod Term</em>'.
	 * @generated
	 */
	ModTerm createModTerm();

	/**
	 * Returns a new object of class '<em>Schedule Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Schedule Function</em>'.
	 * @generated
	 */
	ScheduleFunction createScheduleFunction();

	/**
	 * Returns a new object of class '<em>And Event Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And Event Term</em>'.
	 * @generated
	 */
	AndEventTerm createAndEventTerm();

	/**
	 * Returns a new object of class '<em>Or Event Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or Event Term</em>'.
	 * @generated
	 */
	OrEventTerm createOrEventTerm();

	/**
	 * Returns a new object of class '<em>Not Event Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not Event Term</em>'.
	 * @generated
	 */
	NotEventTerm createNotEventTerm();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExpressionsPackage getExpressionsPackage();

} //ExpressionsFactory
