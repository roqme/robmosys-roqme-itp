/**
 */
package roqme.metamodel.expressions.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import roqme.metamodel.expressions.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see roqme.metamodel.expressions.ExpressionsPackage
 * @generated
 */
public class ExpressionsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExpressionsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ExpressionsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionsSwitch<Adapter> modelSwitch =
		new ExpressionsSwitch<Adapter>() {
			@Override
			public Adapter caseTerm(Term object) {
				return createTermAdapter();
			}
			@Override
			public Adapter caseConstTerm(ConstTerm object) {
				return createConstTermAdapter();
			}
			@Override
			public Adapter caseVarTerm(VarTerm object) {
				return createVarTermAdapter();
			}
			@Override
			public Adapter caseBinaryTermOp(BinaryTermOp object) {
				return createBinaryTermOpAdapter();
			}
			@Override
			public Adapter caseUnaryTermOp(UnaryTermOp object) {
				return createUnaryTermOpAdapter();
			}
			@Override
			public Adapter caseFunctionTerm(FunctionTerm object) {
				return createFunctionTermAdapter();
			}
			@Override
			public Adapter caseUnaryLogicalOp(UnaryLogicalOp object) {
				return createUnaryLogicalOpAdapter();
			}
			@Override
			public Adapter caseUnaryPatternOp(UnaryPatternOp object) {
				return createUnaryPatternOpAdapter();
			}
			@Override
			public Adapter caseNotBooleanTerm(NotBooleanTerm object) {
				return createNotBooleanTermAdapter();
			}
			@Override
			public Adapter caseRepeatTerm(RepeatTerm object) {
				return createRepeatTermAdapter();
			}
			@Override
			public Adapter caseBinaryArithOp(BinaryArithOp object) {
				return createBinaryArithOpAdapter();
			}
			@Override
			public Adapter caseBinaryRelationalOp(BinaryRelationalOp object) {
				return createBinaryRelationalOpAdapter();
			}
			@Override
			public Adapter caseBinaryLogicalOp(BinaryLogicalOp object) {
				return createBinaryLogicalOpAdapter();
			}
			@Override
			public Adapter caseBinaryPatternOp(BinaryPatternOp object) {
				return createBinaryPatternOpAdapter();
			}
			@Override
			public Adapter caseAddTerm(AddTerm object) {
				return createAddTermAdapter();
			}
			@Override
			public Adapter caseMultTerm(MultTerm object) {
				return createMultTermAdapter();
			}
			@Override
			public Adapter caseSubTerm(SubTerm object) {
				return createSubTermAdapter();
			}
			@Override
			public Adapter caseDivTerm(DivTerm object) {
				return createDivTermAdapter();
			}
			@Override
			public Adapter caseAndBooleanTerm(AndBooleanTerm object) {
				return createAndBooleanTermAdapter();
			}
			@Override
			public Adapter caseOrBooleanTerm(OrBooleanTerm object) {
				return createOrBooleanTermAdapter();
			}
			@Override
			public Adapter caseLessEqualTerm(LessEqualTerm object) {
				return createLessEqualTermAdapter();
			}
			@Override
			public Adapter caseGreaterEqualTerm(GreaterEqualTerm object) {
				return createGreaterEqualTermAdapter();
			}
			@Override
			public Adapter caseNotEqualTerm(NotEqualTerm object) {
				return createNotEqualTermAdapter();
			}
			@Override
			public Adapter caseEqualTerm(EqualTerm object) {
				return createEqualTermAdapter();
			}
			@Override
			public Adapter caseGreaterThanTerm(GreaterThanTerm object) {
				return createGreaterThanTermAdapter();
			}
			@Override
			public Adapter caseLessThanTerm(LessThanTerm object) {
				return createLessThanTermAdapter();
			}
			@Override
			public Adapter caseFollowedByTerm(FollowedByTerm object) {
				return createFollowedByTermAdapter();
			}
			@Override
			public Adapter caseArithFunction(ArithFunction object) {
				return createArithFunctionAdapter();
			}
			@Override
			public Adapter caseAggregationFunction(AggregationFunction object) {
				return createAggregationFunctionAdapter();
			}
			@Override
			public Adapter casePatternFunction(PatternFunction object) {
				return createPatternFunctionAdapter();
			}
			@Override
			public Adapter caseGeneralExpression(GeneralExpression object) {
				return createGeneralExpressionAdapter();
			}
			@Override
			public Adapter caseContextPattern(ContextPattern object) {
				return createContextPatternAdapter();
			}
			@Override
			public Adapter caseOutputTransformation(OutputTransformation object) {
				return createOutputTransformationAdapter();
			}
			@Override
			public Adapter caseWhileTerm(WhileTerm object) {
				return createWhileTermAdapter();
			}
			@Override
			public Adapter caseConditionalTerm(ConditionalTerm object) {
				return createConditionalTermAdapter();
			}
			@Override
			public Adapter caseNaryTermOp(NaryTermOp object) {
				return createNaryTermOpAdapter();
			}
			@Override
			public Adapter caseSelfTerm(SelfTerm object) {
				return createSelfTermAdapter();
			}
			@Override
			public Adapter caseCollectionFunction(CollectionFunction object) {
				return createCollectionFunctionAdapter();
			}
			@Override
			public Adapter caseOnceTerm(OnceTerm object) {
				return createOnceTermAdapter();
			}
			@Override
			public Adapter caseRangeTerm(RangeTerm object) {
				return createRangeTermAdapter();
			}
			@Override
			public Adapter caseModTerm(ModTerm object) {
				return createModTermAdapter();
			}
			@Override
			public Adapter caseScheduleFunction(ScheduleFunction object) {
				return createScheduleFunctionAdapter();
			}
			@Override
			public Adapter caseAndEventTerm(AndEventTerm object) {
				return createAndEventTermAdapter();
			}
			@Override
			public Adapter caseOrEventTerm(OrEventTerm object) {
				return createOrEventTermAdapter();
			}
			@Override
			public Adapter caseNotEventTerm(NotEventTerm object) {
				return createNotEventTermAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.Term <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.Term
	 * @generated
	 */
	public Adapter createTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.ConstTerm <em>Const Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.ConstTerm
	 * @generated
	 */
	public Adapter createConstTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.VarTerm <em>Var Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.VarTerm
	 * @generated
	 */
	public Adapter createVarTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.BinaryTermOp <em>Binary Term Op</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.BinaryTermOp
	 * @generated
	 */
	public Adapter createBinaryTermOpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.UnaryTermOp <em>Unary Term Op</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.UnaryTermOp
	 * @generated
	 */
	public Adapter createUnaryTermOpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.FunctionTerm <em>Function Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.FunctionTerm
	 * @generated
	 */
	public Adapter createFunctionTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.UnaryLogicalOp <em>Unary Logical Op</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.UnaryLogicalOp
	 * @generated
	 */
	public Adapter createUnaryLogicalOpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.UnaryPatternOp <em>Unary Pattern Op</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.UnaryPatternOp
	 * @generated
	 */
	public Adapter createUnaryPatternOpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.NotBooleanTerm <em>Not Boolean Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.NotBooleanTerm
	 * @generated
	 */
	public Adapter createNotBooleanTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.RepeatTerm <em>Repeat Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.RepeatTerm
	 * @generated
	 */
	public Adapter createRepeatTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.BinaryArithOp <em>Binary Arith Op</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.BinaryArithOp
	 * @generated
	 */
	public Adapter createBinaryArithOpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.BinaryRelationalOp <em>Binary Relational Op</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.BinaryRelationalOp
	 * @generated
	 */
	public Adapter createBinaryRelationalOpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.BinaryLogicalOp <em>Binary Logical Op</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.BinaryLogicalOp
	 * @generated
	 */
	public Adapter createBinaryLogicalOpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.BinaryPatternOp <em>Binary Pattern Op</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.BinaryPatternOp
	 * @generated
	 */
	public Adapter createBinaryPatternOpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.AddTerm <em>Add Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.AddTerm
	 * @generated
	 */
	public Adapter createAddTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.MultTerm <em>Mult Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.MultTerm
	 * @generated
	 */
	public Adapter createMultTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.SubTerm <em>Sub Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.SubTerm
	 * @generated
	 */
	public Adapter createSubTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.DivTerm <em>Div Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.DivTerm
	 * @generated
	 */
	public Adapter createDivTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.AndBooleanTerm <em>And Boolean Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.AndBooleanTerm
	 * @generated
	 */
	public Adapter createAndBooleanTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.OrBooleanTerm <em>Or Boolean Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.OrBooleanTerm
	 * @generated
	 */
	public Adapter createOrBooleanTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.LessEqualTerm <em>Less Equal Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.LessEqualTerm
	 * @generated
	 */
	public Adapter createLessEqualTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.GreaterEqualTerm <em>Greater Equal Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.GreaterEqualTerm
	 * @generated
	 */
	public Adapter createGreaterEqualTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.NotEqualTerm <em>Not Equal Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.NotEqualTerm
	 * @generated
	 */
	public Adapter createNotEqualTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.EqualTerm <em>Equal Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.EqualTerm
	 * @generated
	 */
	public Adapter createEqualTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.GreaterThanTerm <em>Greater Than Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.GreaterThanTerm
	 * @generated
	 */
	public Adapter createGreaterThanTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.LessThanTerm <em>Less Than Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.LessThanTerm
	 * @generated
	 */
	public Adapter createLessThanTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.FollowedByTerm <em>Followed By Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.FollowedByTerm
	 * @generated
	 */
	public Adapter createFollowedByTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.ArithFunction <em>Arith Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.ArithFunction
	 * @generated
	 */
	public Adapter createArithFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.AggregationFunction <em>Aggregation Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.AggregationFunction
	 * @generated
	 */
	public Adapter createAggregationFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.PatternFunction <em>Pattern Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.PatternFunction
	 * @generated
	 */
	public Adapter createPatternFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.GeneralExpression <em>General Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.GeneralExpression
	 * @generated
	 */
	public Adapter createGeneralExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.ContextPattern <em>Context Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.ContextPattern
	 * @generated
	 */
	public Adapter createContextPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.OutputTransformation <em>Output Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.OutputTransformation
	 * @generated
	 */
	public Adapter createOutputTransformationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.WhileTerm <em>While Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.WhileTerm
	 * @generated
	 */
	public Adapter createWhileTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.ConditionalTerm <em>Conditional Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.ConditionalTerm
	 * @generated
	 */
	public Adapter createConditionalTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.NaryTermOp <em>Nary Term Op</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.NaryTermOp
	 * @generated
	 */
	public Adapter createNaryTermOpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.SelfTerm <em>Self Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.SelfTerm
	 * @generated
	 */
	public Adapter createSelfTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.CollectionFunction <em>Collection Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.CollectionFunction
	 * @generated
	 */
	public Adapter createCollectionFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.OnceTerm <em>Once Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.OnceTerm
	 * @generated
	 */
	public Adapter createOnceTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.RangeTerm <em>Range Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.RangeTerm
	 * @generated
	 */
	public Adapter createRangeTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.ModTerm <em>Mod Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.ModTerm
	 * @generated
	 */
	public Adapter createModTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.ScheduleFunction <em>Schedule Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.ScheduleFunction
	 * @generated
	 */
	public Adapter createScheduleFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.AndEventTerm <em>And Event Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.AndEventTerm
	 * @generated
	 */
	public Adapter createAndEventTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.OrEventTerm <em>Or Event Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.OrEventTerm
	 * @generated
	 */
	public Adapter createOrEventTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.expressions.NotEventTerm <em>Not Event Term</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.expressions.NotEventTerm
	 * @generated
	 */
	public Adapter createNotEventTermAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ExpressionsAdapterFactory
