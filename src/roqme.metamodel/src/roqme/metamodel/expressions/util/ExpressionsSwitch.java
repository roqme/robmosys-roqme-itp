/**
 */
package roqme.metamodel.expressions.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import roqme.metamodel.expressions.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see roqme.metamodel.expressions.ExpressionsPackage
 * @generated
 */
public class ExpressionsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExpressionsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsSwitch() {
		if (modelPackage == null) {
			modelPackage = ExpressionsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ExpressionsPackage.TERM: {
				Term term = (Term)theEObject;
				T result = caseTerm(term);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.CONST_TERM: {
				ConstTerm constTerm = (ConstTerm)theEObject;
				T result = caseConstTerm(constTerm);
				if (result == null) result = caseTerm(constTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.VAR_TERM: {
				VarTerm varTerm = (VarTerm)theEObject;
				T result = caseVarTerm(varTerm);
				if (result == null) result = caseTerm(varTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.BINARY_TERM_OP: {
				BinaryTermOp binaryTermOp = (BinaryTermOp)theEObject;
				T result = caseBinaryTermOp(binaryTermOp);
				if (result == null) result = caseTerm(binaryTermOp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.UNARY_TERM_OP: {
				UnaryTermOp unaryTermOp = (UnaryTermOp)theEObject;
				T result = caseUnaryTermOp(unaryTermOp);
				if (result == null) result = caseTerm(unaryTermOp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.FUNCTION_TERM: {
				FunctionTerm functionTerm = (FunctionTerm)theEObject;
				T result = caseFunctionTerm(functionTerm);
				if (result == null) result = caseNaryTermOp(functionTerm);
				if (result == null) result = caseTerm(functionTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.UNARY_LOGICAL_OP: {
				UnaryLogicalOp unaryLogicalOp = (UnaryLogicalOp)theEObject;
				T result = caseUnaryLogicalOp(unaryLogicalOp);
				if (result == null) result = caseUnaryTermOp(unaryLogicalOp);
				if (result == null) result = caseTerm(unaryLogicalOp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.UNARY_PATTERN_OP: {
				UnaryPatternOp unaryPatternOp = (UnaryPatternOp)theEObject;
				T result = caseUnaryPatternOp(unaryPatternOp);
				if (result == null) result = caseUnaryTermOp(unaryPatternOp);
				if (result == null) result = caseTerm(unaryPatternOp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.NOT_BOOLEAN_TERM: {
				NotBooleanTerm notBooleanTerm = (NotBooleanTerm)theEObject;
				T result = caseNotBooleanTerm(notBooleanTerm);
				if (result == null) result = caseUnaryLogicalOp(notBooleanTerm);
				if (result == null) result = caseUnaryTermOp(notBooleanTerm);
				if (result == null) result = caseTerm(notBooleanTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.REPEAT_TERM: {
				RepeatTerm repeatTerm = (RepeatTerm)theEObject;
				T result = caseRepeatTerm(repeatTerm);
				if (result == null) result = caseUnaryPatternOp(repeatTerm);
				if (result == null) result = caseUnaryTermOp(repeatTerm);
				if (result == null) result = caseTerm(repeatTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.BINARY_ARITH_OP: {
				BinaryArithOp binaryArithOp = (BinaryArithOp)theEObject;
				T result = caseBinaryArithOp(binaryArithOp);
				if (result == null) result = caseBinaryTermOp(binaryArithOp);
				if (result == null) result = caseTerm(binaryArithOp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.BINARY_RELATIONAL_OP: {
				BinaryRelationalOp binaryRelationalOp = (BinaryRelationalOp)theEObject;
				T result = caseBinaryRelationalOp(binaryRelationalOp);
				if (result == null) result = caseBinaryTermOp(binaryRelationalOp);
				if (result == null) result = caseTerm(binaryRelationalOp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.BINARY_LOGICAL_OP: {
				BinaryLogicalOp binaryLogicalOp = (BinaryLogicalOp)theEObject;
				T result = caseBinaryLogicalOp(binaryLogicalOp);
				if (result == null) result = caseBinaryTermOp(binaryLogicalOp);
				if (result == null) result = caseTerm(binaryLogicalOp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.BINARY_PATTERN_OP: {
				BinaryPatternOp binaryPatternOp = (BinaryPatternOp)theEObject;
				T result = caseBinaryPatternOp(binaryPatternOp);
				if (result == null) result = caseBinaryTermOp(binaryPatternOp);
				if (result == null) result = caseTerm(binaryPatternOp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ADD_TERM: {
				AddTerm addTerm = (AddTerm)theEObject;
				T result = caseAddTerm(addTerm);
				if (result == null) result = caseBinaryArithOp(addTerm);
				if (result == null) result = caseBinaryTermOp(addTerm);
				if (result == null) result = caseTerm(addTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.MULT_TERM: {
				MultTerm multTerm = (MultTerm)theEObject;
				T result = caseMultTerm(multTerm);
				if (result == null) result = caseBinaryArithOp(multTerm);
				if (result == null) result = caseBinaryTermOp(multTerm);
				if (result == null) result = caseTerm(multTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.SUB_TERM: {
				SubTerm subTerm = (SubTerm)theEObject;
				T result = caseSubTerm(subTerm);
				if (result == null) result = caseBinaryArithOp(subTerm);
				if (result == null) result = caseBinaryTermOp(subTerm);
				if (result == null) result = caseTerm(subTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.DIV_TERM: {
				DivTerm divTerm = (DivTerm)theEObject;
				T result = caseDivTerm(divTerm);
				if (result == null) result = caseBinaryArithOp(divTerm);
				if (result == null) result = caseBinaryTermOp(divTerm);
				if (result == null) result = caseTerm(divTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.AND_BOOLEAN_TERM: {
				AndBooleanTerm andBooleanTerm = (AndBooleanTerm)theEObject;
				T result = caseAndBooleanTerm(andBooleanTerm);
				if (result == null) result = caseBinaryLogicalOp(andBooleanTerm);
				if (result == null) result = caseBinaryTermOp(andBooleanTerm);
				if (result == null) result = caseTerm(andBooleanTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.OR_BOOLEAN_TERM: {
				OrBooleanTerm orBooleanTerm = (OrBooleanTerm)theEObject;
				T result = caseOrBooleanTerm(orBooleanTerm);
				if (result == null) result = caseBinaryLogicalOp(orBooleanTerm);
				if (result == null) result = caseBinaryTermOp(orBooleanTerm);
				if (result == null) result = caseTerm(orBooleanTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.LESS_EQUAL_TERM: {
				LessEqualTerm lessEqualTerm = (LessEqualTerm)theEObject;
				T result = caseLessEqualTerm(lessEqualTerm);
				if (result == null) result = caseBinaryRelationalOp(lessEqualTerm);
				if (result == null) result = caseBinaryTermOp(lessEqualTerm);
				if (result == null) result = caseTerm(lessEqualTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.GREATER_EQUAL_TERM: {
				GreaterEqualTerm greaterEqualTerm = (GreaterEqualTerm)theEObject;
				T result = caseGreaterEqualTerm(greaterEqualTerm);
				if (result == null) result = caseBinaryRelationalOp(greaterEqualTerm);
				if (result == null) result = caseBinaryTermOp(greaterEqualTerm);
				if (result == null) result = caseTerm(greaterEqualTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.NOT_EQUAL_TERM: {
				NotEqualTerm notEqualTerm = (NotEqualTerm)theEObject;
				T result = caseNotEqualTerm(notEqualTerm);
				if (result == null) result = caseBinaryRelationalOp(notEqualTerm);
				if (result == null) result = caseBinaryTermOp(notEqualTerm);
				if (result == null) result = caseTerm(notEqualTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.EQUAL_TERM: {
				EqualTerm equalTerm = (EqualTerm)theEObject;
				T result = caseEqualTerm(equalTerm);
				if (result == null) result = caseBinaryRelationalOp(equalTerm);
				if (result == null) result = caseBinaryTermOp(equalTerm);
				if (result == null) result = caseTerm(equalTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.GREATER_THAN_TERM: {
				GreaterThanTerm greaterThanTerm = (GreaterThanTerm)theEObject;
				T result = caseGreaterThanTerm(greaterThanTerm);
				if (result == null) result = caseBinaryRelationalOp(greaterThanTerm);
				if (result == null) result = caseBinaryTermOp(greaterThanTerm);
				if (result == null) result = caseTerm(greaterThanTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.LESS_THAN_TERM: {
				LessThanTerm lessThanTerm = (LessThanTerm)theEObject;
				T result = caseLessThanTerm(lessThanTerm);
				if (result == null) result = caseBinaryRelationalOp(lessThanTerm);
				if (result == null) result = caseBinaryTermOp(lessThanTerm);
				if (result == null) result = caseTerm(lessThanTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.FOLLOWED_BY_TERM: {
				FollowedByTerm followedByTerm = (FollowedByTerm)theEObject;
				T result = caseFollowedByTerm(followedByTerm);
				if (result == null) result = caseBinaryPatternOp(followedByTerm);
				if (result == null) result = caseBinaryTermOp(followedByTerm);
				if (result == null) result = caseTerm(followedByTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ARITH_FUNCTION: {
				ArithFunction arithFunction = (ArithFunction)theEObject;
				T result = caseArithFunction(arithFunction);
				if (result == null) result = caseFunctionTerm(arithFunction);
				if (result == null) result = caseNaryTermOp(arithFunction);
				if (result == null) result = caseTerm(arithFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.AGGREGATION_FUNCTION: {
				AggregationFunction aggregationFunction = (AggregationFunction)theEObject;
				T result = caseAggregationFunction(aggregationFunction);
				if (result == null) result = caseFunctionTerm(aggregationFunction);
				if (result == null) result = caseNaryTermOp(aggregationFunction);
				if (result == null) result = caseTerm(aggregationFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.PATTERN_FUNCTION: {
				PatternFunction patternFunction = (PatternFunction)theEObject;
				T result = casePatternFunction(patternFunction);
				if (result == null) result = caseFunctionTerm(patternFunction);
				if (result == null) result = caseNaryTermOp(patternFunction);
				if (result == null) result = caseTerm(patternFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.GENERAL_EXPRESSION: {
				GeneralExpression generalExpression = (GeneralExpression)theEObject;
				T result = caseGeneralExpression(generalExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.CONTEXT_PATTERN: {
				ContextPattern contextPattern = (ContextPattern)theEObject;
				T result = caseContextPattern(contextPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.OUTPUT_TRANSFORMATION: {
				OutputTransformation outputTransformation = (OutputTransformation)theEObject;
				T result = caseOutputTransformation(outputTransformation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.WHILE_TERM: {
				WhileTerm whileTerm = (WhileTerm)theEObject;
				T result = caseWhileTerm(whileTerm);
				if (result == null) result = caseBinaryPatternOp(whileTerm);
				if (result == null) result = caseBinaryTermOp(whileTerm);
				if (result == null) result = caseTerm(whileTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.CONDITIONAL_TERM: {
				ConditionalTerm conditionalTerm = (ConditionalTerm)theEObject;
				T result = caseConditionalTerm(conditionalTerm);
				if (result == null) result = caseNaryTermOp(conditionalTerm);
				if (result == null) result = caseTerm(conditionalTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.NARY_TERM_OP: {
				NaryTermOp naryTermOp = (NaryTermOp)theEObject;
				T result = caseNaryTermOp(naryTermOp);
				if (result == null) result = caseTerm(naryTermOp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.SELF_TERM: {
				SelfTerm selfTerm = (SelfTerm)theEObject;
				T result = caseSelfTerm(selfTerm);
				if (result == null) result = caseTerm(selfTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.COLLECTION_FUNCTION: {
				CollectionFunction collectionFunction = (CollectionFunction)theEObject;
				T result = caseCollectionFunction(collectionFunction);
				if (result == null) result = caseFunctionTerm(collectionFunction);
				if (result == null) result = caseNaryTermOp(collectionFunction);
				if (result == null) result = caseTerm(collectionFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.ONCE_TERM: {
				OnceTerm onceTerm = (OnceTerm)theEObject;
				T result = caseOnceTerm(onceTerm);
				if (result == null) result = caseUnaryPatternOp(onceTerm);
				if (result == null) result = caseUnaryTermOp(onceTerm);
				if (result == null) result = caseTerm(onceTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.RANGE_TERM: {
				RangeTerm rangeTerm = (RangeTerm)theEObject;
				T result = caseRangeTerm(rangeTerm);
				if (result == null) result = caseUnaryPatternOp(rangeTerm);
				if (result == null) result = caseUnaryTermOp(rangeTerm);
				if (result == null) result = caseTerm(rangeTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.MOD_TERM: {
				ModTerm modTerm = (ModTerm)theEObject;
				T result = caseModTerm(modTerm);
				if (result == null) result = caseBinaryArithOp(modTerm);
				if (result == null) result = caseBinaryTermOp(modTerm);
				if (result == null) result = caseTerm(modTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.SCHEDULE_FUNCTION: {
				ScheduleFunction scheduleFunction = (ScheduleFunction)theEObject;
				T result = caseScheduleFunction(scheduleFunction);
				if (result == null) result = caseFunctionTerm(scheduleFunction);
				if (result == null) result = caseNaryTermOp(scheduleFunction);
				if (result == null) result = caseTerm(scheduleFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.AND_EVENT_TERM: {
				AndEventTerm andEventTerm = (AndEventTerm)theEObject;
				T result = caseAndEventTerm(andEventTerm);
				if (result == null) result = caseBinaryPatternOp(andEventTerm);
				if (result == null) result = caseBinaryTermOp(andEventTerm);
				if (result == null) result = caseTerm(andEventTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.OR_EVENT_TERM: {
				OrEventTerm orEventTerm = (OrEventTerm)theEObject;
				T result = caseOrEventTerm(orEventTerm);
				if (result == null) result = caseBinaryPatternOp(orEventTerm);
				if (result == null) result = caseBinaryTermOp(orEventTerm);
				if (result == null) result = caseTerm(orEventTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.NOT_EVENT_TERM: {
				NotEventTerm notEventTerm = (NotEventTerm)theEObject;
				T result = caseNotEventTerm(notEventTerm);
				if (result == null) result = caseUnaryPatternOp(notEventTerm);
				if (result == null) result = caseUnaryTermOp(notEventTerm);
				if (result == null) result = caseTerm(notEventTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerm(Term object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Const Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Const Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstTerm(ConstTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVarTerm(VarTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Term Op</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Term Op</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryTermOp(BinaryTermOp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Term Op</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Term Op</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryTermOp(UnaryTermOp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionTerm(FunctionTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Logical Op</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Logical Op</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryLogicalOp(UnaryLogicalOp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Pattern Op</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Pattern Op</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryPatternOp(UnaryPatternOp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Boolean Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Boolean Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotBooleanTerm(NotBooleanTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repeat Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repeat Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepeatTerm(RepeatTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Arith Op</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Arith Op</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryArithOp(BinaryArithOp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Relational Op</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Relational Op</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryRelationalOp(BinaryRelationalOp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Logical Op</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Logical Op</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryLogicalOp(BinaryLogicalOp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Pattern Op</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Pattern Op</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryPatternOp(BinaryPatternOp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddTerm(AddTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mult Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mult Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultTerm(MultTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubTerm(SubTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Div Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Div Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDivTerm(DivTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Boolean Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Boolean Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAndBooleanTerm(AndBooleanTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Boolean Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Boolean Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrBooleanTerm(OrBooleanTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Less Equal Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Less Equal Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLessEqualTerm(LessEqualTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Greater Equal Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Greater Equal Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGreaterEqualTerm(GreaterEqualTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Equal Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Equal Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotEqualTerm(NotEqualTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equal Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equal Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEqualTerm(EqualTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Greater Than Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Greater Than Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGreaterThanTerm(GreaterThanTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Less Than Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Less Than Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLessThanTerm(LessThanTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Followed By Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Followed By Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFollowedByTerm(FollowedByTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Arith Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Arith Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArithFunction(ArithFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregation Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregation Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAggregationFunction(AggregationFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternFunction(PatternFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>General Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>General Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeneralExpression(GeneralExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContextPattern(ContextPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Transformation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputTransformation(OutputTransformation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhileTerm(WhileTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalTerm(ConditionalTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nary Term Op</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nary Term Op</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNaryTermOp(NaryTermOp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Self Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Self Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelfTerm(SelfTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionFunction(CollectionFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Once Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Once Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOnceTerm(OnceTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Range Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Range Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRangeTerm(RangeTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mod Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mod Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModTerm(ModTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Schedule Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Schedule Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScheduleFunction(ScheduleFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Event Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Event Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAndEventTerm(AndEventTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Event Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Event Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrEventTerm(OrEventTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Event Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Event Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotEventTerm(NotEventTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ExpressionsSwitch
