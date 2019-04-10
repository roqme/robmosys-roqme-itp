/**
 */
package roqme.metamodel.expressions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see roqme.metamodel.expressions.ExpressionsFactory
 * @model kind="package"
 * @generated
 */
public interface ExpressionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "expressions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://robmosys.eu/roqme/expressions";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "roqme.expressions";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionsPackage eINSTANCE = roqme.metamodel.expressions.impl.ExpressionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.TermImpl <em>Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.TermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getTerm()
	 * @generated
	 */
	int TERM = 0;

	/**
	 * The number of structural features of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.ConstTermImpl <em>Const Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.ConstTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getConstTerm()
	 * @generated
	 */
	int CONST_TERM = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_TERM__VALUE = TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Const Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_TERM_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Const Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONST_TERM_OPERATION_COUNT = TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.VarTermImpl <em>Var Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.VarTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getVarTerm()
	 * @generated
	 */
	int VAR_TERM = 2;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_TERM__VARIABLE = TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Var Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_TERM_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Var Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_TERM_OPERATION_COUNT = TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.BinaryTermOpImpl <em>Binary Term Op</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.BinaryTermOpImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getBinaryTermOp()
	 * @generated
	 */
	int BINARY_TERM_OP = 3;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_TERM_OP__LEFT = TERM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_TERM_OP__RIGHT = TERM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Term Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_TERM_OP_FEATURE_COUNT = TERM_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Binary Term Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_TERM_OP_OPERATION_COUNT = TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.UnaryTermOpImpl <em>Unary Term Op</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.UnaryTermOpImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getUnaryTermOp()
	 * @generated
	 */
	int UNARY_TERM_OP = 4;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_TERM_OP__TERM = TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unary Term Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_TERM_OP_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Unary Term Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_TERM_OP_OPERATION_COUNT = TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.NaryTermOpImpl <em>Nary Term Op</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.NaryTermOpImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getNaryTermOp()
	 * @generated
	 */
	int NARY_TERM_OP = 35;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_TERM_OP__TERMS = TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Nary Term Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_TERM_OP_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Nary Term Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_TERM_OP_OPERATION_COUNT = TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.FunctionTermImpl <em>Function Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.FunctionTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getFunctionTerm()
	 * @generated
	 */
	int FUNCTION_TERM = 5;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TERM__TERMS = NARY_TERM_OP__TERMS;

	/**
	 * The number of structural features of the '<em>Function Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TERM_FEATURE_COUNT = NARY_TERM_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Function Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_TERM_OPERATION_COUNT = NARY_TERM_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.UnaryLogicalOpImpl <em>Unary Logical Op</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.UnaryLogicalOpImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getUnaryLogicalOp()
	 * @generated
	 */
	int UNARY_LOGICAL_OP = 6;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_LOGICAL_OP__TERM = UNARY_TERM_OP__TERM;

	/**
	 * The number of structural features of the '<em>Unary Logical Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_LOGICAL_OP_FEATURE_COUNT = UNARY_TERM_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Unary Logical Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_LOGICAL_OP_OPERATION_COUNT = UNARY_TERM_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.UnaryPatternOpImpl <em>Unary Pattern Op</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.UnaryPatternOpImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getUnaryPatternOp()
	 * @generated
	 */
	int UNARY_PATTERN_OP = 7;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_PATTERN_OP__TERM = UNARY_TERM_OP__TERM;

	/**
	 * The number of structural features of the '<em>Unary Pattern Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_PATTERN_OP_FEATURE_COUNT = UNARY_TERM_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Unary Pattern Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_PATTERN_OP_OPERATION_COUNT = UNARY_TERM_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.NotBooleanTermImpl <em>Not Boolean Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.NotBooleanTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getNotBooleanTerm()
	 * @generated
	 */
	int NOT_BOOLEAN_TERM = 8;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_BOOLEAN_TERM__TERM = UNARY_LOGICAL_OP__TERM;

	/**
	 * The number of structural features of the '<em>Not Boolean Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_BOOLEAN_TERM_FEATURE_COUNT = UNARY_LOGICAL_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Not Boolean Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_BOOLEAN_TERM_OPERATION_COUNT = UNARY_LOGICAL_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.RepeatTermImpl <em>Repeat Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.RepeatTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getRepeatTerm()
	 * @generated
	 */
	int REPEAT_TERM = 9;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_TERM__TERM = UNARY_PATTERN_OP__TERM;

	/**
	 * The feature id for the '<em><b>Nrep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_TERM__NREP = UNARY_PATTERN_OP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Repeat Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_TERM_FEATURE_COUNT = UNARY_PATTERN_OP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Repeat Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_TERM_OPERATION_COUNT = UNARY_PATTERN_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.BinaryArithOpImpl <em>Binary Arith Op</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.BinaryArithOpImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getBinaryArithOp()
	 * @generated
	 */
	int BINARY_ARITH_OP = 10;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_ARITH_OP__LEFT = BINARY_TERM_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_ARITH_OP__RIGHT = BINARY_TERM_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Binary Arith Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_ARITH_OP_FEATURE_COUNT = BINARY_TERM_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Binary Arith Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_ARITH_OP_OPERATION_COUNT = BINARY_TERM_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.BinaryRelationalOpImpl <em>Binary Relational Op</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.BinaryRelationalOpImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getBinaryRelationalOp()
	 * @generated
	 */
	int BINARY_RELATIONAL_OP = 11;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONAL_OP__LEFT = BINARY_TERM_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONAL_OP__RIGHT = BINARY_TERM_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Binary Relational Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONAL_OP_FEATURE_COUNT = BINARY_TERM_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Binary Relational Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONAL_OP_OPERATION_COUNT = BINARY_TERM_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.BinaryLogicalOpImpl <em>Binary Logical Op</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.BinaryLogicalOpImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getBinaryLogicalOp()
	 * @generated
	 */
	int BINARY_LOGICAL_OP = 12;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LOGICAL_OP__LEFT = BINARY_TERM_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LOGICAL_OP__RIGHT = BINARY_TERM_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Binary Logical Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LOGICAL_OP_FEATURE_COUNT = BINARY_TERM_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Binary Logical Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_LOGICAL_OP_OPERATION_COUNT = BINARY_TERM_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.BinaryPatternOpImpl <em>Binary Pattern Op</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.BinaryPatternOpImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getBinaryPatternOp()
	 * @generated
	 */
	int BINARY_PATTERN_OP = 13;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_PATTERN_OP__LEFT = BINARY_TERM_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_PATTERN_OP__RIGHT = BINARY_TERM_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Binary Pattern Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_PATTERN_OP_FEATURE_COUNT = BINARY_TERM_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Binary Pattern Op</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_PATTERN_OP_OPERATION_COUNT = BINARY_TERM_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.AddTermImpl <em>Add Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.AddTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getAddTerm()
	 * @generated
	 */
	int ADD_TERM = 14;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TERM__LEFT = BINARY_ARITH_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TERM__RIGHT = BINARY_ARITH_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Add Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TERM_FEATURE_COUNT = BINARY_ARITH_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Add Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TERM_OPERATION_COUNT = BINARY_ARITH_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.MultTermImpl <em>Mult Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.MultTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getMultTerm()
	 * @generated
	 */
	int MULT_TERM = 15;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULT_TERM__LEFT = BINARY_ARITH_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULT_TERM__RIGHT = BINARY_ARITH_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Mult Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULT_TERM_FEATURE_COUNT = BINARY_ARITH_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mult Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULT_TERM_OPERATION_COUNT = BINARY_ARITH_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.SubTermImpl <em>Sub Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.SubTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getSubTerm()
	 * @generated
	 */
	int SUB_TERM = 16;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TERM__LEFT = BINARY_ARITH_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TERM__RIGHT = BINARY_ARITH_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Sub Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TERM_FEATURE_COUNT = BINARY_ARITH_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sub Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_TERM_OPERATION_COUNT = BINARY_ARITH_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.DivTermImpl <em>Div Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.DivTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getDivTerm()
	 * @generated
	 */
	int DIV_TERM = 17;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIV_TERM__LEFT = BINARY_ARITH_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIV_TERM__RIGHT = BINARY_ARITH_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Div Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIV_TERM_FEATURE_COUNT = BINARY_ARITH_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Div Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIV_TERM_OPERATION_COUNT = BINARY_ARITH_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.AndBooleanTermImpl <em>And Boolean Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.AndBooleanTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getAndBooleanTerm()
	 * @generated
	 */
	int AND_BOOLEAN_TERM = 18;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_BOOLEAN_TERM__LEFT = BINARY_LOGICAL_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_BOOLEAN_TERM__RIGHT = BINARY_LOGICAL_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>And Boolean Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_BOOLEAN_TERM_FEATURE_COUNT = BINARY_LOGICAL_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>And Boolean Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_BOOLEAN_TERM_OPERATION_COUNT = BINARY_LOGICAL_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.OrBooleanTermImpl <em>Or Boolean Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.OrBooleanTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getOrBooleanTerm()
	 * @generated
	 */
	int OR_BOOLEAN_TERM = 19;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_BOOLEAN_TERM__LEFT = BINARY_LOGICAL_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_BOOLEAN_TERM__RIGHT = BINARY_LOGICAL_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Or Boolean Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_BOOLEAN_TERM_FEATURE_COUNT = BINARY_LOGICAL_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Or Boolean Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_BOOLEAN_TERM_OPERATION_COUNT = BINARY_LOGICAL_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.LessEqualTermImpl <em>Less Equal Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.LessEqualTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getLessEqualTerm()
	 * @generated
	 */
	int LESS_EQUAL_TERM = 20;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_EQUAL_TERM__LEFT = BINARY_RELATIONAL_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_EQUAL_TERM__RIGHT = BINARY_RELATIONAL_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Less Equal Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_EQUAL_TERM_FEATURE_COUNT = BINARY_RELATIONAL_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Less Equal Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_EQUAL_TERM_OPERATION_COUNT = BINARY_RELATIONAL_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.GreaterEqualTermImpl <em>Greater Equal Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.GreaterEqualTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getGreaterEqualTerm()
	 * @generated
	 */
	int GREATER_EQUAL_TERM = 21;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_EQUAL_TERM__LEFT = BINARY_RELATIONAL_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_EQUAL_TERM__RIGHT = BINARY_RELATIONAL_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Greater Equal Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_EQUAL_TERM_FEATURE_COUNT = BINARY_RELATIONAL_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Greater Equal Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_EQUAL_TERM_OPERATION_COUNT = BINARY_RELATIONAL_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.NotEqualTermImpl <em>Not Equal Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.NotEqualTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getNotEqualTerm()
	 * @generated
	 */
	int NOT_EQUAL_TERM = 22;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUAL_TERM__LEFT = BINARY_RELATIONAL_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUAL_TERM__RIGHT = BINARY_RELATIONAL_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Not Equal Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUAL_TERM_FEATURE_COUNT = BINARY_RELATIONAL_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Not Equal Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EQUAL_TERM_OPERATION_COUNT = BINARY_RELATIONAL_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.EqualTermImpl <em>Equal Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.EqualTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getEqualTerm()
	 * @generated
	 */
	int EQUAL_TERM = 23;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL_TERM__LEFT = BINARY_RELATIONAL_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL_TERM__RIGHT = BINARY_RELATIONAL_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Equal Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL_TERM_FEATURE_COUNT = BINARY_RELATIONAL_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Equal Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUAL_TERM_OPERATION_COUNT = BINARY_RELATIONAL_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.GreaterThanTermImpl <em>Greater Than Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.GreaterThanTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getGreaterThanTerm()
	 * @generated
	 */
	int GREATER_THAN_TERM = 24;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_TERM__LEFT = BINARY_RELATIONAL_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_TERM__RIGHT = BINARY_RELATIONAL_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Greater Than Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_TERM_FEATURE_COUNT = BINARY_RELATIONAL_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Greater Than Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_THAN_TERM_OPERATION_COUNT = BINARY_RELATIONAL_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.LessThanTermImpl <em>Less Than Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.LessThanTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getLessThanTerm()
	 * @generated
	 */
	int LESS_THAN_TERM = 25;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_TERM__LEFT = BINARY_RELATIONAL_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_TERM__RIGHT = BINARY_RELATIONAL_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Less Than Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_TERM_FEATURE_COUNT = BINARY_RELATIONAL_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Less Than Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_THAN_TERM_OPERATION_COUNT = BINARY_RELATIONAL_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.FollowedByTermImpl <em>Followed By Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.FollowedByTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getFollowedByTerm()
	 * @generated
	 */
	int FOLLOWED_BY_TERM = 26;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWED_BY_TERM__LEFT = BINARY_PATTERN_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWED_BY_TERM__RIGHT = BINARY_PATTERN_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Followed By Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWED_BY_TERM_FEATURE_COUNT = BINARY_PATTERN_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Followed By Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOWED_BY_TERM_OPERATION_COUNT = BINARY_PATTERN_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.ArithFunctionImpl <em>Arith Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.ArithFunctionImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getArithFunction()
	 * @generated
	 */
	int ARITH_FUNCTION = 27;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_FUNCTION__TERMS = FUNCTION_TERM__TERMS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_FUNCTION__NAME = FUNCTION_TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Arith Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_FUNCTION_FEATURE_COUNT = FUNCTION_TERM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Arith Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITH_FUNCTION_OPERATION_COUNT = FUNCTION_TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.AggregationFunctionImpl <em>Aggregation Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.AggregationFunctionImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getAggregationFunction()
	 * @generated
	 */
	int AGGREGATION_FUNCTION = 28;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_FUNCTION__TERMS = FUNCTION_TERM__TERMS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_FUNCTION__NAME = FUNCTION_TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Aggregation Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_FUNCTION_FEATURE_COUNT = FUNCTION_TERM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Aggregation Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_FUNCTION_OPERATION_COUNT = FUNCTION_TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.PatternFunctionImpl <em>Pattern Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.PatternFunctionImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getPatternFunction()
	 * @generated
	 */
	int PATTERN_FUNCTION = 29;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_FUNCTION__TERMS = FUNCTION_TERM__TERMS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_FUNCTION__NAME = FUNCTION_TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pattern Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_FUNCTION_FEATURE_COUNT = FUNCTION_TERM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Pattern Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_FUNCTION_OPERATION_COUNT = FUNCTION_TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.GeneralExpressionImpl <em>General Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.GeneralExpressionImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getGeneralExpression()
	 * @generated
	 */
	int GENERAL_EXPRESSION = 30;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_EXPRESSION__TERM = 0;

	/**
	 * The number of structural features of the '<em>General Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_EXPRESSION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>General Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.ContextPatternImpl <em>Context Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.ContextPatternImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getContextPattern()
	 * @generated
	 */
	int CONTEXT_PATTERN = 31;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_PATTERN__TERM = 0;

	/**
	 * The number of structural features of the '<em>Context Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_PATTERN_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Context Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_PATTERN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.OutputTransformationImpl <em>Output Transformation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.OutputTransformationImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getOutputTransformation()
	 * @generated
	 */
	int OUTPUT_TRANSFORMATION = 32;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_TRANSFORMATION__TERM = 0;

	/**
	 * The number of structural features of the '<em>Output Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_TRANSFORMATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Output Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_TRANSFORMATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.WhileTermImpl <em>While Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.WhileTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getWhileTerm()
	 * @generated
	 */
	int WHILE_TERM = 33;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_TERM__LEFT = BINARY_PATTERN_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_TERM__RIGHT = BINARY_PATTERN_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>While Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_TERM_FEATURE_COUNT = BINARY_PATTERN_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>While Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_TERM_OPERATION_COUNT = BINARY_PATTERN_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.ConditionalTermImpl <em>Conditional Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.ConditionalTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getConditionalTerm()
	 * @generated
	 */
	int CONDITIONAL_TERM = 34;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_TERM__TERMS = NARY_TERM_OP__TERMS;

	/**
	 * The number of structural features of the '<em>Conditional Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_TERM_FEATURE_COUNT = NARY_TERM_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Conditional Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_TERM_OPERATION_COUNT = NARY_TERM_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.SelfTermImpl <em>Self Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.SelfTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getSelfTerm()
	 * @generated
	 */
	int SELF_TERM = 36;

	/**
	 * The number of structural features of the '<em>Self Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TERM_FEATURE_COUNT = TERM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Self Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_TERM_OPERATION_COUNT = TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.CollectionFunctionImpl <em>Collection Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.CollectionFunctionImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getCollectionFunction()
	 * @generated
	 */
	int COLLECTION_FUNCTION = 37;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_FUNCTION__TERMS = FUNCTION_TERM__TERMS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_FUNCTION__NAME = FUNCTION_TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_FUNCTION_FEATURE_COUNT = FUNCTION_TERM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Collection Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_FUNCTION_OPERATION_COUNT = FUNCTION_TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.OnceTermImpl <em>Once Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.OnceTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getOnceTerm()
	 * @generated
	 */
	int ONCE_TERM = 38;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONCE_TERM__TERM = UNARY_PATTERN_OP__TERM;

	/**
	 * The number of structural features of the '<em>Once Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONCE_TERM_FEATURE_COUNT = UNARY_PATTERN_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Once Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONCE_TERM_OPERATION_COUNT = UNARY_PATTERN_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.RangeTermImpl <em>Range Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.RangeTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getRangeTerm()
	 * @generated
	 */
	int RANGE_TERM = 39;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_TERM__TERM = UNARY_PATTERN_OP__TERM;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_TERM__LOWER_BOUND = UNARY_PATTERN_OP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_TERM__UPPER_BOUND = UNARY_PATTERN_OP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Range Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_TERM_FEATURE_COUNT = UNARY_PATTERN_OP_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Range Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_TERM_OPERATION_COUNT = UNARY_PATTERN_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.ModTermImpl <em>Mod Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.ModTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getModTerm()
	 * @generated
	 */
	int MOD_TERM = 40;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOD_TERM__LEFT = BINARY_ARITH_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOD_TERM__RIGHT = BINARY_ARITH_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Mod Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOD_TERM_FEATURE_COUNT = BINARY_ARITH_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mod Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOD_TERM_OPERATION_COUNT = BINARY_ARITH_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.ScheduleFunctionImpl <em>Schedule Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.ScheduleFunctionImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getScheduleFunction()
	 * @generated
	 */
	int SCHEDULE_FUNCTION = 41;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_FUNCTION__TERMS = FUNCTION_TERM__TERMS;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_FUNCTION__PATTERN = FUNCTION_TERM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Schedule Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_FUNCTION_FEATURE_COUNT = FUNCTION_TERM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Schedule Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_FUNCTION_OPERATION_COUNT = FUNCTION_TERM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.AndEventTermImpl <em>And Event Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.AndEventTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getAndEventTerm()
	 * @generated
	 */
	int AND_EVENT_TERM = 42;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EVENT_TERM__LEFT = BINARY_PATTERN_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EVENT_TERM__RIGHT = BINARY_PATTERN_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>And Event Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EVENT_TERM_FEATURE_COUNT = BINARY_PATTERN_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>And Event Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EVENT_TERM_OPERATION_COUNT = BINARY_PATTERN_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.OrEventTermImpl <em>Or Event Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.OrEventTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getOrEventTerm()
	 * @generated
	 */
	int OR_EVENT_TERM = 43;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EVENT_TERM__LEFT = BINARY_PATTERN_OP__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EVENT_TERM__RIGHT = BINARY_PATTERN_OP__RIGHT;

	/**
	 * The number of structural features of the '<em>Or Event Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EVENT_TERM_FEATURE_COUNT = BINARY_PATTERN_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Or Event Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EVENT_TERM_OPERATION_COUNT = BINARY_PATTERN_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.impl.NotEventTermImpl <em>Not Event Term</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.impl.NotEventTermImpl
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getNotEventTerm()
	 * @generated
	 */
	int NOT_EVENT_TERM = 44;

	/**
	 * The feature id for the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EVENT_TERM__TERM = UNARY_PATTERN_OP__TERM;

	/**
	 * The number of structural features of the '<em>Not Event Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EVENT_TERM_FEATURE_COUNT = UNARY_PATTERN_OP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Not Event Term</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EVENT_TERM_OPERATION_COUNT = UNARY_PATTERN_OP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.ArithFtnEnum <em>Arith Ftn Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.ArithFtnEnum
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getArithFtnEnum()
	 * @generated
	 */
	int ARITH_FTN_ENUM = 45;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.AggregationFtnEnum <em>Aggregation Ftn Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.AggregationFtnEnum
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getAggregationFtnEnum()
	 * @generated
	 */
	int AGGREGATION_FTN_ENUM = 46;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.PatternFtnEnum <em>Pattern Ftn Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.PatternFtnEnum
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getPatternFtnEnum()
	 * @generated
	 */
	int PATTERN_FTN_ENUM = 47;

	/**
	 * The meta object id for the '{@link roqme.metamodel.expressions.CollectionFtnEnum <em>Collection Ftn Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.expressions.CollectionFtnEnum
	 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getCollectionFtnEnum()
	 * @generated
	 */
	int COLLECTION_FTN_ENUM = 48;


	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.Term <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Term</em>'.
	 * @see roqme.metamodel.expressions.Term
	 * @generated
	 */
	EClass getTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.ConstTerm <em>Const Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Const Term</em>'.
	 * @see roqme.metamodel.expressions.ConstTerm
	 * @generated
	 */
	EClass getConstTerm();

	/**
	 * Returns the meta object for the containment reference '{@link roqme.metamodel.expressions.ConstTerm#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see roqme.metamodel.expressions.ConstTerm#getValue()
	 * @see #getConstTerm()
	 * @generated
	 */
	EReference getConstTerm_Value();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.VarTerm <em>Var Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var Term</em>'.
	 * @see roqme.metamodel.expressions.VarTerm
	 * @generated
	 */
	EClass getVarTerm();

	/**
	 * Returns the meta object for the reference '{@link roqme.metamodel.expressions.VarTerm#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see roqme.metamodel.expressions.VarTerm#getVariable()
	 * @see #getVarTerm()
	 * @generated
	 */
	EReference getVarTerm_Variable();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.BinaryTermOp <em>Binary Term Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Term Op</em>'.
	 * @see roqme.metamodel.expressions.BinaryTermOp
	 * @generated
	 */
	EClass getBinaryTermOp();

	/**
	 * Returns the meta object for the containment reference '{@link roqme.metamodel.expressions.BinaryTermOp#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see roqme.metamodel.expressions.BinaryTermOp#getLeft()
	 * @see #getBinaryTermOp()
	 * @generated
	 */
	EReference getBinaryTermOp_Left();

	/**
	 * Returns the meta object for the containment reference '{@link roqme.metamodel.expressions.BinaryTermOp#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see roqme.metamodel.expressions.BinaryTermOp#getRight()
	 * @see #getBinaryTermOp()
	 * @generated
	 */
	EReference getBinaryTermOp_Right();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.UnaryTermOp <em>Unary Term Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Term Op</em>'.
	 * @see roqme.metamodel.expressions.UnaryTermOp
	 * @generated
	 */
	EClass getUnaryTermOp();

	/**
	 * Returns the meta object for the containment reference '{@link roqme.metamodel.expressions.UnaryTermOp#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Term</em>'.
	 * @see roqme.metamodel.expressions.UnaryTermOp#getTerm()
	 * @see #getUnaryTermOp()
	 * @generated
	 */
	EReference getUnaryTermOp_Term();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.FunctionTerm <em>Function Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Term</em>'.
	 * @see roqme.metamodel.expressions.FunctionTerm
	 * @generated
	 */
	EClass getFunctionTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.UnaryLogicalOp <em>Unary Logical Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Logical Op</em>'.
	 * @see roqme.metamodel.expressions.UnaryLogicalOp
	 * @generated
	 */
	EClass getUnaryLogicalOp();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.UnaryPatternOp <em>Unary Pattern Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Pattern Op</em>'.
	 * @see roqme.metamodel.expressions.UnaryPatternOp
	 * @generated
	 */
	EClass getUnaryPatternOp();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.NotBooleanTerm <em>Not Boolean Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Boolean Term</em>'.
	 * @see roqme.metamodel.expressions.NotBooleanTerm
	 * @generated
	 */
	EClass getNotBooleanTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.RepeatTerm <em>Repeat Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repeat Term</em>'.
	 * @see roqme.metamodel.expressions.RepeatTerm
	 * @generated
	 */
	EClass getRepeatTerm();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.expressions.RepeatTerm#getNrep <em>Nrep</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nrep</em>'.
	 * @see roqme.metamodel.expressions.RepeatTerm#getNrep()
	 * @see #getRepeatTerm()
	 * @generated
	 */
	EAttribute getRepeatTerm_Nrep();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.BinaryArithOp <em>Binary Arith Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Arith Op</em>'.
	 * @see roqme.metamodel.expressions.BinaryArithOp
	 * @generated
	 */
	EClass getBinaryArithOp();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.BinaryRelationalOp <em>Binary Relational Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Relational Op</em>'.
	 * @see roqme.metamodel.expressions.BinaryRelationalOp
	 * @generated
	 */
	EClass getBinaryRelationalOp();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.BinaryLogicalOp <em>Binary Logical Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Logical Op</em>'.
	 * @see roqme.metamodel.expressions.BinaryLogicalOp
	 * @generated
	 */
	EClass getBinaryLogicalOp();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.BinaryPatternOp <em>Binary Pattern Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Pattern Op</em>'.
	 * @see roqme.metamodel.expressions.BinaryPatternOp
	 * @generated
	 */
	EClass getBinaryPatternOp();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.AddTerm <em>Add Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Term</em>'.
	 * @see roqme.metamodel.expressions.AddTerm
	 * @generated
	 */
	EClass getAddTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.MultTerm <em>Mult Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mult Term</em>'.
	 * @see roqme.metamodel.expressions.MultTerm
	 * @generated
	 */
	EClass getMultTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.SubTerm <em>Sub Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Term</em>'.
	 * @see roqme.metamodel.expressions.SubTerm
	 * @generated
	 */
	EClass getSubTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.DivTerm <em>Div Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Div Term</em>'.
	 * @see roqme.metamodel.expressions.DivTerm
	 * @generated
	 */
	EClass getDivTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.AndBooleanTerm <em>And Boolean Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Boolean Term</em>'.
	 * @see roqme.metamodel.expressions.AndBooleanTerm
	 * @generated
	 */
	EClass getAndBooleanTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.OrBooleanTerm <em>Or Boolean Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Boolean Term</em>'.
	 * @see roqme.metamodel.expressions.OrBooleanTerm
	 * @generated
	 */
	EClass getOrBooleanTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.LessEqualTerm <em>Less Equal Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Less Equal Term</em>'.
	 * @see roqme.metamodel.expressions.LessEqualTerm
	 * @generated
	 */
	EClass getLessEqualTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.GreaterEqualTerm <em>Greater Equal Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Greater Equal Term</em>'.
	 * @see roqme.metamodel.expressions.GreaterEqualTerm
	 * @generated
	 */
	EClass getGreaterEqualTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.NotEqualTerm <em>Not Equal Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Equal Term</em>'.
	 * @see roqme.metamodel.expressions.NotEqualTerm
	 * @generated
	 */
	EClass getNotEqualTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.EqualTerm <em>Equal Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equal Term</em>'.
	 * @see roqme.metamodel.expressions.EqualTerm
	 * @generated
	 */
	EClass getEqualTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.GreaterThanTerm <em>Greater Than Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Greater Than Term</em>'.
	 * @see roqme.metamodel.expressions.GreaterThanTerm
	 * @generated
	 */
	EClass getGreaterThanTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.LessThanTerm <em>Less Than Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Less Than Term</em>'.
	 * @see roqme.metamodel.expressions.LessThanTerm
	 * @generated
	 */
	EClass getLessThanTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.FollowedByTerm <em>Followed By Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Followed By Term</em>'.
	 * @see roqme.metamodel.expressions.FollowedByTerm
	 * @generated
	 */
	EClass getFollowedByTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.ArithFunction <em>Arith Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arith Function</em>'.
	 * @see roqme.metamodel.expressions.ArithFunction
	 * @generated
	 */
	EClass getArithFunction();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.expressions.ArithFunction#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see roqme.metamodel.expressions.ArithFunction#getName()
	 * @see #getArithFunction()
	 * @generated
	 */
	EAttribute getArithFunction_Name();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.AggregationFunction <em>Aggregation Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregation Function</em>'.
	 * @see roqme.metamodel.expressions.AggregationFunction
	 * @generated
	 */
	EClass getAggregationFunction();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.expressions.AggregationFunction#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see roqme.metamodel.expressions.AggregationFunction#getName()
	 * @see #getAggregationFunction()
	 * @generated
	 */
	EAttribute getAggregationFunction_Name();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.PatternFunction <em>Pattern Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Function</em>'.
	 * @see roqme.metamodel.expressions.PatternFunction
	 * @generated
	 */
	EClass getPatternFunction();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.expressions.PatternFunction#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see roqme.metamodel.expressions.PatternFunction#getName()
	 * @see #getPatternFunction()
	 * @generated
	 */
	EAttribute getPatternFunction_Name();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.GeneralExpression <em>General Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>General Expression</em>'.
	 * @see roqme.metamodel.expressions.GeneralExpression
	 * @generated
	 */
	EClass getGeneralExpression();

	/**
	 * Returns the meta object for the containment reference '{@link roqme.metamodel.expressions.GeneralExpression#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Term</em>'.
	 * @see roqme.metamodel.expressions.GeneralExpression#getTerm()
	 * @see #getGeneralExpression()
	 * @generated
	 */
	EReference getGeneralExpression_Term();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.ContextPattern <em>Context Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context Pattern</em>'.
	 * @see roqme.metamodel.expressions.ContextPattern
	 * @generated
	 */
	EClass getContextPattern();

	/**
	 * Returns the meta object for the containment reference '{@link roqme.metamodel.expressions.ContextPattern#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Term</em>'.
	 * @see roqme.metamodel.expressions.ContextPattern#getTerm()
	 * @see #getContextPattern()
	 * @generated
	 */
	EReference getContextPattern_Term();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.OutputTransformation <em>Output Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Transformation</em>'.
	 * @see roqme.metamodel.expressions.OutputTransformation
	 * @generated
	 */
	EClass getOutputTransformation();

	/**
	 * Returns the meta object for the containment reference '{@link roqme.metamodel.expressions.OutputTransformation#getTerm <em>Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Term</em>'.
	 * @see roqme.metamodel.expressions.OutputTransformation#getTerm()
	 * @see #getOutputTransformation()
	 * @generated
	 */
	EReference getOutputTransformation_Term();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.WhileTerm <em>While Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While Term</em>'.
	 * @see roqme.metamodel.expressions.WhileTerm
	 * @generated
	 */
	EClass getWhileTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.ConditionalTerm <em>Conditional Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional Term</em>'.
	 * @see roqme.metamodel.expressions.ConditionalTerm
	 * @generated
	 */
	EClass getConditionalTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.NaryTermOp <em>Nary Term Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nary Term Op</em>'.
	 * @see roqme.metamodel.expressions.NaryTermOp
	 * @generated
	 */
	EClass getNaryTermOp();

	/**
	 * Returns the meta object for the containment reference list '{@link roqme.metamodel.expressions.NaryTermOp#getTerms <em>Terms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Terms</em>'.
	 * @see roqme.metamodel.expressions.NaryTermOp#getTerms()
	 * @see #getNaryTermOp()
	 * @generated
	 */
	EReference getNaryTermOp_Terms();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.SelfTerm <em>Self Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Self Term</em>'.
	 * @see roqme.metamodel.expressions.SelfTerm
	 * @generated
	 */
	EClass getSelfTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.CollectionFunction <em>Collection Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Function</em>'.
	 * @see roqme.metamodel.expressions.CollectionFunction
	 * @generated
	 */
	EClass getCollectionFunction();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.expressions.CollectionFunction#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see roqme.metamodel.expressions.CollectionFunction#getName()
	 * @see #getCollectionFunction()
	 * @generated
	 */
	EAttribute getCollectionFunction_Name();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.OnceTerm <em>Once Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Once Term</em>'.
	 * @see roqme.metamodel.expressions.OnceTerm
	 * @generated
	 */
	EClass getOnceTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.RangeTerm <em>Range Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Range Term</em>'.
	 * @see roqme.metamodel.expressions.RangeTerm
	 * @generated
	 */
	EClass getRangeTerm();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.expressions.RangeTerm#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see roqme.metamodel.expressions.RangeTerm#getLowerBound()
	 * @see #getRangeTerm()
	 * @generated
	 */
	EAttribute getRangeTerm_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.expressions.RangeTerm#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see roqme.metamodel.expressions.RangeTerm#getUpperBound()
	 * @see #getRangeTerm()
	 * @generated
	 */
	EAttribute getRangeTerm_UpperBound();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.ModTerm <em>Mod Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mod Term</em>'.
	 * @see roqme.metamodel.expressions.ModTerm
	 * @generated
	 */
	EClass getModTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.ScheduleFunction <em>Schedule Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schedule Function</em>'.
	 * @see roqme.metamodel.expressions.ScheduleFunction
	 * @generated
	 */
	EClass getScheduleFunction();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.expressions.ScheduleFunction#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see roqme.metamodel.expressions.ScheduleFunction#getPattern()
	 * @see #getScheduleFunction()
	 * @generated
	 */
	EAttribute getScheduleFunction_Pattern();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.AndEventTerm <em>And Event Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Event Term</em>'.
	 * @see roqme.metamodel.expressions.AndEventTerm
	 * @generated
	 */
	EClass getAndEventTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.OrEventTerm <em>Or Event Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Event Term</em>'.
	 * @see roqme.metamodel.expressions.OrEventTerm
	 * @generated
	 */
	EClass getOrEventTerm();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.expressions.NotEventTerm <em>Not Event Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Event Term</em>'.
	 * @see roqme.metamodel.expressions.NotEventTerm
	 * @generated
	 */
	EClass getNotEventTerm();

	/**
	 * Returns the meta object for enum '{@link roqme.metamodel.expressions.ArithFtnEnum <em>Arith Ftn Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Arith Ftn Enum</em>'.
	 * @see roqme.metamodel.expressions.ArithFtnEnum
	 * @generated
	 */
	EEnum getArithFtnEnum();

	/**
	 * Returns the meta object for enum '{@link roqme.metamodel.expressions.AggregationFtnEnum <em>Aggregation Ftn Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Aggregation Ftn Enum</em>'.
	 * @see roqme.metamodel.expressions.AggregationFtnEnum
	 * @generated
	 */
	EEnum getAggregationFtnEnum();

	/**
	 * Returns the meta object for enum '{@link roqme.metamodel.expressions.PatternFtnEnum <em>Pattern Ftn Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Pattern Ftn Enum</em>'.
	 * @see roqme.metamodel.expressions.PatternFtnEnum
	 * @generated
	 */
	EEnum getPatternFtnEnum();

	/**
	 * Returns the meta object for enum '{@link roqme.metamodel.expressions.CollectionFtnEnum <em>Collection Ftn Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Collection Ftn Enum</em>'.
	 * @see roqme.metamodel.expressions.CollectionFtnEnum
	 * @generated
	 */
	EEnum getCollectionFtnEnum();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExpressionsFactory getExpressionsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.TermImpl <em>Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.TermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getTerm()
		 * @generated
		 */
		EClass TERM = eINSTANCE.getTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.ConstTermImpl <em>Const Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.ConstTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getConstTerm()
		 * @generated
		 */
		EClass CONST_TERM = eINSTANCE.getConstTerm();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONST_TERM__VALUE = eINSTANCE.getConstTerm_Value();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.VarTermImpl <em>Var Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.VarTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getVarTerm()
		 * @generated
		 */
		EClass VAR_TERM = eINSTANCE.getVarTerm();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_TERM__VARIABLE = eINSTANCE.getVarTerm_Variable();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.BinaryTermOpImpl <em>Binary Term Op</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.BinaryTermOpImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getBinaryTermOp()
		 * @generated
		 */
		EClass BINARY_TERM_OP = eINSTANCE.getBinaryTermOp();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_TERM_OP__LEFT = eINSTANCE.getBinaryTermOp_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_TERM_OP__RIGHT = eINSTANCE.getBinaryTermOp_Right();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.UnaryTermOpImpl <em>Unary Term Op</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.UnaryTermOpImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getUnaryTermOp()
		 * @generated
		 */
		EClass UNARY_TERM_OP = eINSTANCE.getUnaryTermOp();

		/**
		 * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_TERM_OP__TERM = eINSTANCE.getUnaryTermOp_Term();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.FunctionTermImpl <em>Function Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.FunctionTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getFunctionTerm()
		 * @generated
		 */
		EClass FUNCTION_TERM = eINSTANCE.getFunctionTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.UnaryLogicalOpImpl <em>Unary Logical Op</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.UnaryLogicalOpImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getUnaryLogicalOp()
		 * @generated
		 */
		EClass UNARY_LOGICAL_OP = eINSTANCE.getUnaryLogicalOp();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.UnaryPatternOpImpl <em>Unary Pattern Op</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.UnaryPatternOpImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getUnaryPatternOp()
		 * @generated
		 */
		EClass UNARY_PATTERN_OP = eINSTANCE.getUnaryPatternOp();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.NotBooleanTermImpl <em>Not Boolean Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.NotBooleanTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getNotBooleanTerm()
		 * @generated
		 */
		EClass NOT_BOOLEAN_TERM = eINSTANCE.getNotBooleanTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.RepeatTermImpl <em>Repeat Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.RepeatTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getRepeatTerm()
		 * @generated
		 */
		EClass REPEAT_TERM = eINSTANCE.getRepeatTerm();

		/**
		 * The meta object literal for the '<em><b>Nrep</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPEAT_TERM__NREP = eINSTANCE.getRepeatTerm_Nrep();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.BinaryArithOpImpl <em>Binary Arith Op</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.BinaryArithOpImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getBinaryArithOp()
		 * @generated
		 */
		EClass BINARY_ARITH_OP = eINSTANCE.getBinaryArithOp();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.BinaryRelationalOpImpl <em>Binary Relational Op</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.BinaryRelationalOpImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getBinaryRelationalOp()
		 * @generated
		 */
		EClass BINARY_RELATIONAL_OP = eINSTANCE.getBinaryRelationalOp();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.BinaryLogicalOpImpl <em>Binary Logical Op</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.BinaryLogicalOpImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getBinaryLogicalOp()
		 * @generated
		 */
		EClass BINARY_LOGICAL_OP = eINSTANCE.getBinaryLogicalOp();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.BinaryPatternOpImpl <em>Binary Pattern Op</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.BinaryPatternOpImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getBinaryPatternOp()
		 * @generated
		 */
		EClass BINARY_PATTERN_OP = eINSTANCE.getBinaryPatternOp();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.AddTermImpl <em>Add Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.AddTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getAddTerm()
		 * @generated
		 */
		EClass ADD_TERM = eINSTANCE.getAddTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.MultTermImpl <em>Mult Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.MultTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getMultTerm()
		 * @generated
		 */
		EClass MULT_TERM = eINSTANCE.getMultTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.SubTermImpl <em>Sub Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.SubTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getSubTerm()
		 * @generated
		 */
		EClass SUB_TERM = eINSTANCE.getSubTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.DivTermImpl <em>Div Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.DivTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getDivTerm()
		 * @generated
		 */
		EClass DIV_TERM = eINSTANCE.getDivTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.AndBooleanTermImpl <em>And Boolean Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.AndBooleanTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getAndBooleanTerm()
		 * @generated
		 */
		EClass AND_BOOLEAN_TERM = eINSTANCE.getAndBooleanTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.OrBooleanTermImpl <em>Or Boolean Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.OrBooleanTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getOrBooleanTerm()
		 * @generated
		 */
		EClass OR_BOOLEAN_TERM = eINSTANCE.getOrBooleanTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.LessEqualTermImpl <em>Less Equal Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.LessEqualTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getLessEqualTerm()
		 * @generated
		 */
		EClass LESS_EQUAL_TERM = eINSTANCE.getLessEqualTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.GreaterEqualTermImpl <em>Greater Equal Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.GreaterEqualTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getGreaterEqualTerm()
		 * @generated
		 */
		EClass GREATER_EQUAL_TERM = eINSTANCE.getGreaterEqualTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.NotEqualTermImpl <em>Not Equal Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.NotEqualTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getNotEqualTerm()
		 * @generated
		 */
		EClass NOT_EQUAL_TERM = eINSTANCE.getNotEqualTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.EqualTermImpl <em>Equal Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.EqualTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getEqualTerm()
		 * @generated
		 */
		EClass EQUAL_TERM = eINSTANCE.getEqualTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.GreaterThanTermImpl <em>Greater Than Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.GreaterThanTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getGreaterThanTerm()
		 * @generated
		 */
		EClass GREATER_THAN_TERM = eINSTANCE.getGreaterThanTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.LessThanTermImpl <em>Less Than Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.LessThanTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getLessThanTerm()
		 * @generated
		 */
		EClass LESS_THAN_TERM = eINSTANCE.getLessThanTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.FollowedByTermImpl <em>Followed By Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.FollowedByTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getFollowedByTerm()
		 * @generated
		 */
		EClass FOLLOWED_BY_TERM = eINSTANCE.getFollowedByTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.ArithFunctionImpl <em>Arith Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.ArithFunctionImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getArithFunction()
		 * @generated
		 */
		EClass ARITH_FUNCTION = eINSTANCE.getArithFunction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARITH_FUNCTION__NAME = eINSTANCE.getArithFunction_Name();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.AggregationFunctionImpl <em>Aggregation Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.AggregationFunctionImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getAggregationFunction()
		 * @generated
		 */
		EClass AGGREGATION_FUNCTION = eINSTANCE.getAggregationFunction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATION_FUNCTION__NAME = eINSTANCE.getAggregationFunction_Name();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.PatternFunctionImpl <em>Pattern Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.PatternFunctionImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getPatternFunction()
		 * @generated
		 */
		EClass PATTERN_FUNCTION = eINSTANCE.getPatternFunction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN_FUNCTION__NAME = eINSTANCE.getPatternFunction_Name();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.GeneralExpressionImpl <em>General Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.GeneralExpressionImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getGeneralExpression()
		 * @generated
		 */
		EClass GENERAL_EXPRESSION = eINSTANCE.getGeneralExpression();

		/**
		 * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERAL_EXPRESSION__TERM = eINSTANCE.getGeneralExpression_Term();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.ContextPatternImpl <em>Context Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.ContextPatternImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getContextPattern()
		 * @generated
		 */
		EClass CONTEXT_PATTERN = eINSTANCE.getContextPattern();

		/**
		 * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT_PATTERN__TERM = eINSTANCE.getContextPattern_Term();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.OutputTransformationImpl <em>Output Transformation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.OutputTransformationImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getOutputTransformation()
		 * @generated
		 */
		EClass OUTPUT_TRANSFORMATION = eINSTANCE.getOutputTransformation();

		/**
		 * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_TRANSFORMATION__TERM = eINSTANCE.getOutputTransformation_Term();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.WhileTermImpl <em>While Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.WhileTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getWhileTerm()
		 * @generated
		 */
		EClass WHILE_TERM = eINSTANCE.getWhileTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.ConditionalTermImpl <em>Conditional Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.ConditionalTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getConditionalTerm()
		 * @generated
		 */
		EClass CONDITIONAL_TERM = eINSTANCE.getConditionalTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.NaryTermOpImpl <em>Nary Term Op</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.NaryTermOpImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getNaryTermOp()
		 * @generated
		 */
		EClass NARY_TERM_OP = eINSTANCE.getNaryTermOp();

		/**
		 * The meta object literal for the '<em><b>Terms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NARY_TERM_OP__TERMS = eINSTANCE.getNaryTermOp_Terms();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.SelfTermImpl <em>Self Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.SelfTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getSelfTerm()
		 * @generated
		 */
		EClass SELF_TERM = eINSTANCE.getSelfTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.CollectionFunctionImpl <em>Collection Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.CollectionFunctionImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getCollectionFunction()
		 * @generated
		 */
		EClass COLLECTION_FUNCTION = eINSTANCE.getCollectionFunction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_FUNCTION__NAME = eINSTANCE.getCollectionFunction_Name();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.OnceTermImpl <em>Once Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.OnceTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getOnceTerm()
		 * @generated
		 */
		EClass ONCE_TERM = eINSTANCE.getOnceTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.RangeTermImpl <em>Range Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.RangeTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getRangeTerm()
		 * @generated
		 */
		EClass RANGE_TERM = eINSTANCE.getRangeTerm();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANGE_TERM__LOWER_BOUND = eINSTANCE.getRangeTerm_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANGE_TERM__UPPER_BOUND = eINSTANCE.getRangeTerm_UpperBound();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.ModTermImpl <em>Mod Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.ModTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getModTerm()
		 * @generated
		 */
		EClass MOD_TERM = eINSTANCE.getModTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.ScheduleFunctionImpl <em>Schedule Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.ScheduleFunctionImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getScheduleFunction()
		 * @generated
		 */
		EClass SCHEDULE_FUNCTION = eINSTANCE.getScheduleFunction();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULE_FUNCTION__PATTERN = eINSTANCE.getScheduleFunction_Pattern();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.AndEventTermImpl <em>And Event Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.AndEventTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getAndEventTerm()
		 * @generated
		 */
		EClass AND_EVENT_TERM = eINSTANCE.getAndEventTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.OrEventTermImpl <em>Or Event Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.OrEventTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getOrEventTerm()
		 * @generated
		 */
		EClass OR_EVENT_TERM = eINSTANCE.getOrEventTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.impl.NotEventTermImpl <em>Not Event Term</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.impl.NotEventTermImpl
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getNotEventTerm()
		 * @generated
		 */
		EClass NOT_EVENT_TERM = eINSTANCE.getNotEventTerm();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.ArithFtnEnum <em>Arith Ftn Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.ArithFtnEnum
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getArithFtnEnum()
		 * @generated
		 */
		EEnum ARITH_FTN_ENUM = eINSTANCE.getArithFtnEnum();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.AggregationFtnEnum <em>Aggregation Ftn Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.AggregationFtnEnum
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getAggregationFtnEnum()
		 * @generated
		 */
		EEnum AGGREGATION_FTN_ENUM = eINSTANCE.getAggregationFtnEnum();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.PatternFtnEnum <em>Pattern Ftn Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.PatternFtnEnum
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getPatternFtnEnum()
		 * @generated
		 */
		EEnum PATTERN_FTN_ENUM = eINSTANCE.getPatternFtnEnum();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.expressions.CollectionFtnEnum <em>Collection Ftn Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.expressions.CollectionFtnEnum
		 * @see roqme.metamodel.expressions.impl.ExpressionsPackageImpl#getCollectionFtnEnum()
		 * @generated
		 */
		EEnum COLLECTION_FTN_ENUM = eINSTANCE.getCollectionFtnEnum();

	}

} //ExpressionsPackage
