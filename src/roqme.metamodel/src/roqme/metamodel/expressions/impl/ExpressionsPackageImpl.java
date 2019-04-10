/**
 */
package roqme.metamodel.expressions.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import roqme.metamodel.datatypes.DatatypesPackage;

import roqme.metamodel.expressions.AddTerm;
import roqme.metamodel.expressions.AggregationFtnEnum;
import roqme.metamodel.expressions.AggregationFunction;
import roqme.metamodel.expressions.AndBooleanTerm;
import roqme.metamodel.expressions.AndEventTerm;
import roqme.metamodel.expressions.ArithFtnEnum;
import roqme.metamodel.expressions.ArithFunction;
import roqme.metamodel.expressions.BinaryArithOp;
import roqme.metamodel.expressions.BinaryLogicalOp;
import roqme.metamodel.expressions.BinaryPatternOp;
import roqme.metamodel.expressions.BinaryRelationalOp;
import roqme.metamodel.expressions.BinaryTermOp;
import roqme.metamodel.expressions.CollectionFtnEnum;
import roqme.metamodel.expressions.CollectionFunction;
import roqme.metamodel.expressions.ConditionalTerm;
import roqme.metamodel.expressions.ConstTerm;
import roqme.metamodel.expressions.ContextPattern;
import roqme.metamodel.expressions.DivTerm;
import roqme.metamodel.expressions.EqualTerm;
import roqme.metamodel.expressions.ExpressionsFactory;
import roqme.metamodel.expressions.ExpressionsPackage;
import roqme.metamodel.expressions.FollowedByTerm;
import roqme.metamodel.expressions.FunctionTerm;
import roqme.metamodel.expressions.GeneralExpression;
import roqme.metamodel.expressions.GreaterEqualTerm;
import roqme.metamodel.expressions.GreaterThanTerm;
import roqme.metamodel.expressions.LessEqualTerm;
import roqme.metamodel.expressions.LessThanTerm;
import roqme.metamodel.expressions.ModTerm;
import roqme.metamodel.expressions.MultTerm;
import roqme.metamodel.expressions.NaryTermOp;
import roqme.metamodel.expressions.NotBooleanTerm;
import roqme.metamodel.expressions.NotEqualTerm;
import roqme.metamodel.expressions.NotEventTerm;
import roqme.metamodel.expressions.OnceTerm;
import roqme.metamodel.expressions.OrBooleanTerm;
import roqme.metamodel.expressions.OrEventTerm;
import roqme.metamodel.expressions.OutputTransformation;
import roqme.metamodel.expressions.PatternFtnEnum;
import roqme.metamodel.expressions.PatternFunction;
import roqme.metamodel.expressions.RangeTerm;
import roqme.metamodel.expressions.RepeatTerm;
import roqme.metamodel.expressions.ScheduleFunction;
import roqme.metamodel.expressions.SelfTerm;
import roqme.metamodel.expressions.SubTerm;
import roqme.metamodel.expressions.Term;
import roqme.metamodel.expressions.UnaryLogicalOp;
import roqme.metamodel.expressions.UnaryPatternOp;
import roqme.metamodel.expressions.UnaryTermOp;
import roqme.metamodel.expressions.VarTerm;
import roqme.metamodel.expressions.WhileTerm;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionsPackageImpl extends EPackageImpl implements ExpressionsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass termEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass varTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryTermOpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryTermOpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryLogicalOpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryPatternOpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notBooleanTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repeatTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryArithOpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryRelationalOpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryLogicalOpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryPatternOpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass divTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andBooleanTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orBooleanTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lessEqualTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass greaterEqualTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notEqualTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equalTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass greaterThanTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lessThanTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass followedByTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arithFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregationFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputTransformationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whileTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionalTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass naryTermOpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selfTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass onceTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rangeTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scheduleFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andEventTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orEventTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notEventTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum arithFtnEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum aggregationFtnEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum patternFtnEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum collectionFtnEnumEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see roqme.metamodel.expressions.ExpressionsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExpressionsPackageImpl() {
		super(eNS_URI, ExpressionsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ExpressionsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExpressionsPackage init() {
		if (isInited) return (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

		// Obtain or create and register package
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExpressionsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DatatypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theExpressionsPackage.createPackageContents();

		// Initialize created meta-data
		theExpressionsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExpressionsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExpressionsPackage.eNS_URI, theExpressionsPackage);
		return theExpressionsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerm() {
		return termEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstTerm() {
		return constTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstTerm_Value() {
		return (EReference)constTermEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVarTerm() {
		return varTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVarTerm_Variable() {
		return (EReference)varTermEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryTermOp() {
		return binaryTermOpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryTermOp_Left() {
		return (EReference)binaryTermOpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryTermOp_Right() {
		return (EReference)binaryTermOpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnaryTermOp() {
		return unaryTermOpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnaryTermOp_Term() {
		return (EReference)unaryTermOpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionTerm() {
		return functionTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnaryLogicalOp() {
		return unaryLogicalOpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnaryPatternOp() {
		return unaryPatternOpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotBooleanTerm() {
		return notBooleanTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepeatTerm() {
		return repeatTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepeatTerm_Nrep() {
		return (EAttribute)repeatTermEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryArithOp() {
		return binaryArithOpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryRelationalOp() {
		return binaryRelationalOpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryLogicalOp() {
		return binaryLogicalOpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryPatternOp() {
		return binaryPatternOpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddTerm() {
		return addTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultTerm() {
		return multTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubTerm() {
		return subTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDivTerm() {
		return divTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAndBooleanTerm() {
		return andBooleanTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrBooleanTerm() {
		return orBooleanTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLessEqualTerm() {
		return lessEqualTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGreaterEqualTerm() {
		return greaterEqualTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotEqualTerm() {
		return notEqualTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEqualTerm() {
		return equalTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGreaterThanTerm() {
		return greaterThanTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLessThanTerm() {
		return lessThanTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFollowedByTerm() {
		return followedByTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArithFunction() {
		return arithFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArithFunction_Name() {
		return (EAttribute)arithFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAggregationFunction() {
		return aggregationFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregationFunction_Name() {
		return (EAttribute)aggregationFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternFunction() {
		return patternFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPatternFunction_Name() {
		return (EAttribute)patternFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneralExpression() {
		return generalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneralExpression_Term() {
		return (EReference)generalExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContextPattern() {
		return contextPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextPattern_Term() {
		return (EReference)contextPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputTransformation() {
		return outputTransformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputTransformation_Term() {
		return (EReference)outputTransformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhileTerm() {
		return whileTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionalTerm() {
		return conditionalTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNaryTermOp() {
		return naryTermOpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNaryTermOp_Terms() {
		return (EReference)naryTermOpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelfTerm() {
		return selfTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionFunction() {
		return collectionFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionFunction_Name() {
		return (EAttribute)collectionFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOnceTerm() {
		return onceTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRangeTerm() {
		return rangeTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRangeTerm_LowerBound() {
		return (EAttribute)rangeTermEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRangeTerm_UpperBound() {
		return (EAttribute)rangeTermEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModTerm() {
		return modTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScheduleFunction() {
		return scheduleFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScheduleFunction_Pattern() {
		return (EAttribute)scheduleFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAndEventTerm() {
		return andEventTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrEventTerm() {
		return orEventTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotEventTerm() {
		return notEventTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getArithFtnEnum() {
		return arithFtnEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAggregationFtnEnum() {
		return aggregationFtnEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPatternFtnEnum() {
		return patternFtnEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCollectionFtnEnum() {
		return collectionFtnEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsFactory getExpressionsFactory() {
		return (ExpressionsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		termEClass = createEClass(TERM);

		constTermEClass = createEClass(CONST_TERM);
		createEReference(constTermEClass, CONST_TERM__VALUE);

		varTermEClass = createEClass(VAR_TERM);
		createEReference(varTermEClass, VAR_TERM__VARIABLE);

		binaryTermOpEClass = createEClass(BINARY_TERM_OP);
		createEReference(binaryTermOpEClass, BINARY_TERM_OP__LEFT);
		createEReference(binaryTermOpEClass, BINARY_TERM_OP__RIGHT);

		unaryTermOpEClass = createEClass(UNARY_TERM_OP);
		createEReference(unaryTermOpEClass, UNARY_TERM_OP__TERM);

		functionTermEClass = createEClass(FUNCTION_TERM);

		unaryLogicalOpEClass = createEClass(UNARY_LOGICAL_OP);

		unaryPatternOpEClass = createEClass(UNARY_PATTERN_OP);

		notBooleanTermEClass = createEClass(NOT_BOOLEAN_TERM);

		repeatTermEClass = createEClass(REPEAT_TERM);
		createEAttribute(repeatTermEClass, REPEAT_TERM__NREP);

		binaryArithOpEClass = createEClass(BINARY_ARITH_OP);

		binaryRelationalOpEClass = createEClass(BINARY_RELATIONAL_OP);

		binaryLogicalOpEClass = createEClass(BINARY_LOGICAL_OP);

		binaryPatternOpEClass = createEClass(BINARY_PATTERN_OP);

		addTermEClass = createEClass(ADD_TERM);

		multTermEClass = createEClass(MULT_TERM);

		subTermEClass = createEClass(SUB_TERM);

		divTermEClass = createEClass(DIV_TERM);

		andBooleanTermEClass = createEClass(AND_BOOLEAN_TERM);

		orBooleanTermEClass = createEClass(OR_BOOLEAN_TERM);

		lessEqualTermEClass = createEClass(LESS_EQUAL_TERM);

		greaterEqualTermEClass = createEClass(GREATER_EQUAL_TERM);

		notEqualTermEClass = createEClass(NOT_EQUAL_TERM);

		equalTermEClass = createEClass(EQUAL_TERM);

		greaterThanTermEClass = createEClass(GREATER_THAN_TERM);

		lessThanTermEClass = createEClass(LESS_THAN_TERM);

		followedByTermEClass = createEClass(FOLLOWED_BY_TERM);

		arithFunctionEClass = createEClass(ARITH_FUNCTION);
		createEAttribute(arithFunctionEClass, ARITH_FUNCTION__NAME);

		aggregationFunctionEClass = createEClass(AGGREGATION_FUNCTION);
		createEAttribute(aggregationFunctionEClass, AGGREGATION_FUNCTION__NAME);

		patternFunctionEClass = createEClass(PATTERN_FUNCTION);
		createEAttribute(patternFunctionEClass, PATTERN_FUNCTION__NAME);

		generalExpressionEClass = createEClass(GENERAL_EXPRESSION);
		createEReference(generalExpressionEClass, GENERAL_EXPRESSION__TERM);

		contextPatternEClass = createEClass(CONTEXT_PATTERN);
		createEReference(contextPatternEClass, CONTEXT_PATTERN__TERM);

		outputTransformationEClass = createEClass(OUTPUT_TRANSFORMATION);
		createEReference(outputTransformationEClass, OUTPUT_TRANSFORMATION__TERM);

		whileTermEClass = createEClass(WHILE_TERM);

		conditionalTermEClass = createEClass(CONDITIONAL_TERM);

		naryTermOpEClass = createEClass(NARY_TERM_OP);
		createEReference(naryTermOpEClass, NARY_TERM_OP__TERMS);

		selfTermEClass = createEClass(SELF_TERM);

		collectionFunctionEClass = createEClass(COLLECTION_FUNCTION);
		createEAttribute(collectionFunctionEClass, COLLECTION_FUNCTION__NAME);

		onceTermEClass = createEClass(ONCE_TERM);

		rangeTermEClass = createEClass(RANGE_TERM);
		createEAttribute(rangeTermEClass, RANGE_TERM__LOWER_BOUND);
		createEAttribute(rangeTermEClass, RANGE_TERM__UPPER_BOUND);

		modTermEClass = createEClass(MOD_TERM);

		scheduleFunctionEClass = createEClass(SCHEDULE_FUNCTION);
		createEAttribute(scheduleFunctionEClass, SCHEDULE_FUNCTION__PATTERN);

		andEventTermEClass = createEClass(AND_EVENT_TERM);

		orEventTermEClass = createEClass(OR_EVENT_TERM);

		notEventTermEClass = createEClass(NOT_EVENT_TERM);

		// Create enums
		arithFtnEnumEEnum = createEEnum(ARITH_FTN_ENUM);
		aggregationFtnEnumEEnum = createEEnum(AGGREGATION_FTN_ENUM);
		patternFtnEnumEEnum = createEEnum(PATTERN_FTN_ENUM);
		collectionFtnEnumEEnum = createEEnum(COLLECTION_FTN_ENUM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		DatatypesPackage theDatatypesPackage = (DatatypesPackage)EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		constTermEClass.getESuperTypes().add(this.getTerm());
		varTermEClass.getESuperTypes().add(this.getTerm());
		binaryTermOpEClass.getESuperTypes().add(this.getTerm());
		unaryTermOpEClass.getESuperTypes().add(this.getTerm());
		functionTermEClass.getESuperTypes().add(this.getNaryTermOp());
		unaryLogicalOpEClass.getESuperTypes().add(this.getUnaryTermOp());
		unaryPatternOpEClass.getESuperTypes().add(this.getUnaryTermOp());
		notBooleanTermEClass.getESuperTypes().add(this.getUnaryLogicalOp());
		repeatTermEClass.getESuperTypes().add(this.getUnaryPatternOp());
		binaryArithOpEClass.getESuperTypes().add(this.getBinaryTermOp());
		binaryRelationalOpEClass.getESuperTypes().add(this.getBinaryTermOp());
		binaryLogicalOpEClass.getESuperTypes().add(this.getBinaryTermOp());
		binaryPatternOpEClass.getESuperTypes().add(this.getBinaryTermOp());
		addTermEClass.getESuperTypes().add(this.getBinaryArithOp());
		multTermEClass.getESuperTypes().add(this.getBinaryArithOp());
		subTermEClass.getESuperTypes().add(this.getBinaryArithOp());
		divTermEClass.getESuperTypes().add(this.getBinaryArithOp());
		andBooleanTermEClass.getESuperTypes().add(this.getBinaryLogicalOp());
		orBooleanTermEClass.getESuperTypes().add(this.getBinaryLogicalOp());
		lessEqualTermEClass.getESuperTypes().add(this.getBinaryRelationalOp());
		greaterEqualTermEClass.getESuperTypes().add(this.getBinaryRelationalOp());
		notEqualTermEClass.getESuperTypes().add(this.getBinaryRelationalOp());
		equalTermEClass.getESuperTypes().add(this.getBinaryRelationalOp());
		greaterThanTermEClass.getESuperTypes().add(this.getBinaryRelationalOp());
		lessThanTermEClass.getESuperTypes().add(this.getBinaryRelationalOp());
		followedByTermEClass.getESuperTypes().add(this.getBinaryPatternOp());
		arithFunctionEClass.getESuperTypes().add(this.getFunctionTerm());
		aggregationFunctionEClass.getESuperTypes().add(this.getFunctionTerm());
		patternFunctionEClass.getESuperTypes().add(this.getFunctionTerm());
		whileTermEClass.getESuperTypes().add(this.getBinaryPatternOp());
		conditionalTermEClass.getESuperTypes().add(this.getNaryTermOp());
		naryTermOpEClass.getESuperTypes().add(this.getTerm());
		selfTermEClass.getESuperTypes().add(this.getTerm());
		collectionFunctionEClass.getESuperTypes().add(this.getFunctionTerm());
		onceTermEClass.getESuperTypes().add(this.getUnaryPatternOp());
		rangeTermEClass.getESuperTypes().add(this.getUnaryPatternOp());
		modTermEClass.getESuperTypes().add(this.getBinaryArithOp());
		scheduleFunctionEClass.getESuperTypes().add(this.getFunctionTerm());
		andEventTermEClass.getESuperTypes().add(this.getBinaryPatternOp());
		orEventTermEClass.getESuperTypes().add(this.getBinaryPatternOp());
		notEventTermEClass.getESuperTypes().add(this.getUnaryPatternOp());

		// Initialize classes, features, and operations; add parameters
		initEClass(termEClass, Term.class, "Term", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constTermEClass, ConstTerm.class, "ConstTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstTerm_Value(), theDatatypesPackage.getTypedValue(), null, "value", null, 1, 1, ConstTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(varTermEClass, VarTerm.class, "VarTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVarTerm_Variable(), theDatatypesPackage.getTypedVariable(), null, "variable", null, 1, 1, VarTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryTermOpEClass, BinaryTermOp.class, "BinaryTermOp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryTermOp_Left(), this.getTerm(), null, "left", null, 1, 1, BinaryTermOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryTermOp_Right(), this.getTerm(), null, "right", null, 1, 1, BinaryTermOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unaryTermOpEClass, UnaryTermOp.class, "UnaryTermOp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnaryTermOp_Term(), this.getTerm(), null, "term", null, 1, 1, UnaryTermOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionTermEClass, FunctionTerm.class, "FunctionTerm", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unaryLogicalOpEClass, UnaryLogicalOp.class, "UnaryLogicalOp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unaryPatternOpEClass, UnaryPatternOp.class, "UnaryPatternOp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(notBooleanTermEClass, NotBooleanTerm.class, "NotBooleanTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(repeatTermEClass, RepeatTerm.class, "RepeatTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRepeatTerm_Nrep(), ecorePackage.getEInt(), "nrep", null, 1, 1, RepeatTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryArithOpEClass, BinaryArithOp.class, "BinaryArithOp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(binaryRelationalOpEClass, BinaryRelationalOp.class, "BinaryRelationalOp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(binaryLogicalOpEClass, BinaryLogicalOp.class, "BinaryLogicalOp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(binaryPatternOpEClass, BinaryPatternOp.class, "BinaryPatternOp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(addTermEClass, AddTerm.class, "AddTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(multTermEClass, MultTerm.class, "MultTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(subTermEClass, SubTerm.class, "SubTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(divTermEClass, DivTerm.class, "DivTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(andBooleanTermEClass, AndBooleanTerm.class, "AndBooleanTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orBooleanTermEClass, OrBooleanTerm.class, "OrBooleanTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lessEqualTermEClass, LessEqualTerm.class, "LessEqualTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(greaterEqualTermEClass, GreaterEqualTerm.class, "GreaterEqualTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(notEqualTermEClass, NotEqualTerm.class, "NotEqualTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(equalTermEClass, EqualTerm.class, "EqualTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(greaterThanTermEClass, GreaterThanTerm.class, "GreaterThanTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lessThanTermEClass, LessThanTerm.class, "LessThanTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(followedByTermEClass, FollowedByTerm.class, "FollowedByTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(arithFunctionEClass, ArithFunction.class, "ArithFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArithFunction_Name(), this.getArithFtnEnum(), "name", null, 1, 1, ArithFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aggregationFunctionEClass, AggregationFunction.class, "AggregationFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAggregationFunction_Name(), this.getAggregationFtnEnum(), "name", null, 1, 1, AggregationFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(patternFunctionEClass, PatternFunction.class, "PatternFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPatternFunction_Name(), this.getPatternFtnEnum(), "name", null, 1, 1, PatternFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(generalExpressionEClass, GeneralExpression.class, "GeneralExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGeneralExpression_Term(), this.getTerm(), null, "term", null, 1, 1, GeneralExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contextPatternEClass, ContextPattern.class, "ContextPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContextPattern_Term(), this.getTerm(), null, "term", null, 1, 1, ContextPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputTransformationEClass, OutputTransformation.class, "OutputTransformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputTransformation_Term(), this.getTerm(), null, "term", null, 1, 1, OutputTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(whileTermEClass, WhileTerm.class, "WhileTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conditionalTermEClass, ConditionalTerm.class, "ConditionalTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(naryTermOpEClass, NaryTermOp.class, "NaryTermOp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNaryTermOp_Terms(), this.getTerm(), null, "terms", null, 0, -1, NaryTermOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selfTermEClass, SelfTerm.class, "SelfTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(collectionFunctionEClass, CollectionFunction.class, "CollectionFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCollectionFunction_Name(), this.getCollectionFtnEnum(), "name", null, 1, 1, CollectionFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(onceTermEClass, OnceTerm.class, "OnceTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rangeTermEClass, RangeTerm.class, "RangeTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRangeTerm_LowerBound(), ecorePackage.getEInt(), "lowerBound", null, 1, 1, RangeTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRangeTerm_UpperBound(), ecorePackage.getEInt(), "upperBound", null, 1, 1, RangeTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modTermEClass, ModTerm.class, "ModTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scheduleFunctionEClass, ScheduleFunction.class, "ScheduleFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScheduleFunction_Pattern(), ecorePackage.getEString(), "pattern", null, 1, 1, ScheduleFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(andEventTermEClass, AndEventTerm.class, "AndEventTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orEventTermEClass, OrEventTerm.class, "OrEventTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(notEventTermEClass, NotEventTerm.class, "NotEventTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(arithFtnEnumEEnum, ArithFtnEnum.class, "ArithFtnEnum");
		addEEnumLiteral(arithFtnEnumEEnum, ArithFtnEnum.POW);
		addEEnumLiteral(arithFtnEnumEEnum, ArithFtnEnum.SQRT);
		addEEnumLiteral(arithFtnEnumEEnum, ArithFtnEnum.EXP);
		addEEnumLiteral(arithFtnEnumEEnum, ArithFtnEnum.ABS);

		initEEnum(aggregationFtnEnumEEnum, AggregationFtnEnum.class, "AggregationFtnEnum");
		addEEnumLiteral(aggregationFtnEnumEEnum, AggregationFtnEnum.AVG);
		addEEnumLiteral(aggregationFtnEnumEEnum, AggregationFtnEnum.MIN);
		addEEnumLiteral(aggregationFtnEnumEEnum, AggregationFtnEnum.MAX);
		addEEnumLiteral(aggregationFtnEnumEEnum, AggregationFtnEnum.COUNT);
		addEEnumLiteral(aggregationFtnEnumEEnum, AggregationFtnEnum.SUM);
		addEEnumLiteral(aggregationFtnEnumEEnum, AggregationFtnEnum.DECREASING);
		addEEnumLiteral(aggregationFtnEnumEEnum, AggregationFtnEnum.INCREASING);
		addEEnumLiteral(aggregationFtnEnumEEnum, AggregationFtnEnum.STABLE);

		initEEnum(patternFtnEnumEEnum, PatternFtnEnum.class, "PatternFtnEnum");
		addEEnumLiteral(patternFtnEnumEEnum, PatternFtnEnum.EVENT_WHEN);
		addEEnumLiteral(patternFtnEnumEEnum, PatternFtnEnum.UPDATE);
		addEEnumLiteral(patternFtnEnumEEnum, PatternFtnEnum.PERIOD);

		initEEnum(collectionFtnEnumEEnum, CollectionFtnEnum.class, "CollectionFtnEnum");
		addEEnumLiteral(collectionFtnEnumEEnum, CollectionFtnEnum.FIRST);
		addEEnumLiteral(collectionFtnEnumEEnum, CollectionFtnEnum.LAST);
		addEEnumLiteral(collectionFtnEnumEEnum, CollectionFtnEnum.AT);
		addEEnumLiteral(collectionFtnEnumEEnum, CollectionFtnEnum.SIZE);
		addEEnumLiteral(collectionFtnEnumEEnum, CollectionFtnEnum.IS_EMPTY);
		addEEnumLiteral(collectionFtnEnumEEnum, CollectionFtnEnum.INCLUDES);

		// Create resource
		createResource(eNS_URI);
	}

} //ExpressionsPackageImpl
