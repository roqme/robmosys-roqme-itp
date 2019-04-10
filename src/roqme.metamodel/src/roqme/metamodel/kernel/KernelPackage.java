/**
 */
package roqme.metamodel.kernel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import roqme.metamodel.datatypes.DatatypesPackage;

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
 * @see roqme.metamodel.kernel.KernelFactory
 * @model kind="package"
 * @generated
 */
public interface KernelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "kernel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://robmosys.eu/roqme/kernel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "roqme.kernel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KernelPackage eINSTANCE = roqme.metamodel.kernel.impl.KernelPackageImpl.init();

	/**
	 * The meta object id for the '{@link roqme.metamodel.kernel.impl.ContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.kernel.impl.ContextImpl
	 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 9;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__DESCRIPTION = DatatypesPackage.TYPED_VARIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__NAME = DatatypesPackage.TYPED_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__DECLARATION = DatatypesPackage.TYPED_VARIABLE__DECLARATION;

	/**
	 * The feature id for the '<em><b>Initialized To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__INITIALIZED_TO = DatatypesPackage.TYPED_VARIABLE__INITIALIZED_TO;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_FEATURE_COUNT = DatatypesPackage.TYPED_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_OPERATION_COUNT = DatatypesPackage.TYPED_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.kernel.impl.PrimitiveContextImpl <em>Primitive Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.kernel.impl.PrimitiveContextImpl
	 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getPrimitiveContext()
	 * @generated
	 */
	int PRIMITIVE_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_CONTEXT__DESCRIPTION = CONTEXT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_CONTEXT__NAME = CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_CONTEXT__DECLARATION = CONTEXT__DECLARATION;

	/**
	 * The feature id for the '<em><b>Initialized To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_CONTEXT__INITIALIZED_TO = CONTEXT__INITIALIZED_TO;

	/**
	 * The number of structural features of the '<em>Primitive Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_CONTEXT_FEATURE_COUNT = CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Primitive Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_CONTEXT_OPERATION_COUNT = CONTEXT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.kernel.impl.DerivedContextImpl <em>Derived Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.kernel.impl.DerivedContextImpl
	 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getDerivedContext()
	 * @generated
	 */
	int DERIVED_CONTEXT = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_CONTEXT__DESCRIPTION = CONTEXT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_CONTEXT__NAME = CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_CONTEXT__DECLARATION = CONTEXT__DECLARATION;

	/**
	 * The feature id for the '<em><b>Initialized To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_CONTEXT__INITIALIZED_TO = CONTEXT__INITIALIZED_TO;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_CONTEXT__DEFINITION = CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Derived Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_CONTEXT_FEATURE_COUNT = CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Derived Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_CONTEXT_OPERATION_COUNT = CONTEXT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.kernel.impl.GeneralPurposeVariableImpl <em>General Purpose Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.kernel.impl.GeneralPurposeVariableImpl
	 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getGeneralPurposeVariable()
	 * @generated
	 */
	int GENERAL_PURPOSE_VARIABLE = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_PURPOSE_VARIABLE__DESCRIPTION = DatatypesPackage.TYPED_VARIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_PURPOSE_VARIABLE__NAME = DatatypesPackage.TYPED_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_PURPOSE_VARIABLE__DECLARATION = DatatypesPackage.TYPED_VARIABLE__DECLARATION;

	/**
	 * The feature id for the '<em><b>Initialized To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_PURPOSE_VARIABLE__INITIALIZED_TO = DatatypesPackage.TYPED_VARIABLE__INITIALIZED_TO;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_PURPOSE_VARIABLE__DEFINITION = DatatypesPackage.TYPED_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>General Purpose Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_PURPOSE_VARIABLE_FEATURE_COUNT = DatatypesPackage.TYPED_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>General Purpose Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_PURPOSE_VARIABLE_OPERATION_COUNT = DatatypesPackage.TYPED_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.kernel.impl.ObservationImpl <em>Observation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.kernel.impl.ObservationImpl
	 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getObservation()
	 * @generated
	 */
	int OBSERVATION = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION__DESCRIPTION = DatatypesPackage.SENTENCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION__NAME = DatatypesPackage.SENTENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION__PATTERN = DatatypesPackage.SENTENCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION__ACTIONS = DatatypesPackage.SENTENCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Observation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION_FEATURE_COUNT = DatatypesPackage.SENTENCE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Observation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVATION_OPERATION_COUNT = DatatypesPackage.SENTENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.kernel.impl.BeliefVariableImpl <em>Belief Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.kernel.impl.BeliefVariableImpl
	 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getBeliefVariable()
	 * @generated
	 */
	int BELIEF_VARIABLE = 5;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BELIEF_VARIABLE__DESCRIPTION = DatatypesPackage.TYPED_VARIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BELIEF_VARIABLE__NAME = DatatypesPackage.TYPED_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BELIEF_VARIABLE__DECLARATION = DatatypesPackage.TYPED_VARIABLE__DECLARATION;

	/**
	 * The feature id for the '<em><b>Initialized To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BELIEF_VARIABLE__INITIALIZED_TO = DatatypesPackage.TYPED_VARIABLE__INITIALIZED_TO;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BELIEF_VARIABLE__REFERENCE = DatatypesPackage.TYPED_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Survival</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BELIEF_VARIABLE__SURVIVAL = DatatypesPackage.TYPED_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Belief Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BELIEF_VARIABLE_FEATURE_COUNT = DatatypesPackage.TYPED_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Belief Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BELIEF_VARIABLE_OPERATION_COUNT = DatatypesPackage.TYPED_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.kernel.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.kernel.impl.PropertyImpl
	 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DESCRIPTION = BELIEF_VARIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = BELIEF_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__DECLARATION = BELIEF_VARIABLE__DECLARATION;

	/**
	 * The feature id for the '<em><b>Initialized To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__INITIALIZED_TO = BELIEF_VARIABLE__INITIALIZED_TO;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__REFERENCE = BELIEF_VARIABLE__REFERENCE;

	/**
	 * The feature id for the '<em><b>Survival</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__SURVIVAL = BELIEF_VARIABLE__SURVIVAL;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__TRANSFORMATION = BELIEF_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = BELIEF_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = BELIEF_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.kernel.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.kernel.impl.ActionImpl
	 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 10;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.kernel.impl.SetEvidenceImpl <em>Set Evidence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.kernel.impl.SetEvidenceImpl
	 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getSetEvidence()
	 * @generated
	 */
	int SET_EVIDENCE = 6;

	/**
	 * The feature id for the '<em><b>Influence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EVIDENCE__INFLUENCE = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EVIDENCE__TARGET = ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Strength</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EVIDENCE__STRENGTH = ACTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Survival</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EVIDENCE__SURVIVAL = ACTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Conditioned By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EVIDENCE__CONDITIONED_BY = ACTION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Set Evidence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EVIDENCE_FEATURE_COUNT = ACTION_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Set Evidence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_EVIDENCE_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.kernel.impl.ImportImpl <em>Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.kernel.impl.ImportImpl
	 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getImport()
	 * @generated
	 */
	int IMPORT = 7;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__DESCRIPTION = DatatypesPackage.SENTENCE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Import URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__IMPORT_URI = DatatypesPackage.SENTENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_FEATURE_COUNT = DatatypesPackage.SENTENCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_OPERATION_COUNT = DatatypesPackage.SENTENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.kernel.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.kernel.impl.ParameterImpl
	 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 8;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DESCRIPTION = DatatypesPackage.TYPED_VARIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = DatatypesPackage.TYPED_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DECLARATION = DatatypesPackage.TYPED_VARIABLE__DECLARATION;

	/**
	 * The feature id for the '<em><b>Initialized To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__INITIALIZED_TO = DatatypesPackage.TYPED_VARIABLE__INITIALIZED_TO;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = DatatypesPackage.TYPED_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = DatatypesPackage.TYPED_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.kernel.impl.SetVariableImpl <em>Set Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.kernel.impl.SetVariableImpl
	 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getSetVariable()
	 * @generated
	 */
	int SET_VARIABLE = 11;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE__VARIABLE = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE__EXPRESSION = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Set Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_VARIABLE_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.kernel.impl.TimerImpl <em>Timer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.kernel.impl.TimerImpl
	 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getTimer()
	 * @generated
	 */
	int TIMER = 12;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER__DESCRIPTION = DatatypesPackage.TYPED_VARIABLE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER__NAME = DatatypesPackage.TYPED_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER__DECLARATION = DatatypesPackage.TYPED_VARIABLE__DECLARATION;

	/**
	 * The feature id for the '<em><b>Initialized To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER__INITIALIZED_TO = DatatypesPackage.TYPED_VARIABLE__INITIALIZED_TO;

	/**
	 * The feature id for the '<em><b>Once</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER__ONCE = DatatypesPackage.TYPED_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER__DEFINITION = DatatypesPackage.TYPED_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER__OFFSET = DatatypesPackage.TYPED_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Paused</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER__PAUSED = DatatypesPackage.TYPED_VARIABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Timer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_FEATURE_COUNT = DatatypesPackage.TYPED_VARIABLE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Timer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_OPERATION_COUNT = DatatypesPackage.TYPED_VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.kernel.impl.TimerActionImpl <em>Timer Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.kernel.impl.TimerActionImpl
	 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getTimerAction()
	 * @generated
	 */
	int TIMER_ACTION = 13;

	/**
	 * The feature id for the '<em><b>Timer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_ACTION__TIMER = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Timer Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Timer Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_ACTION_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.kernel.impl.StartTimerImpl <em>Start Timer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.kernel.impl.StartTimerImpl
	 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getStartTimer()
	 * @generated
	 */
	int START_TIMER = 14;

	/**
	 * The feature id for the '<em><b>Timer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_TIMER__TIMER = TIMER_ACTION__TIMER;

	/**
	 * The number of structural features of the '<em>Start Timer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_TIMER_FEATURE_COUNT = TIMER_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Start Timer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_TIMER_OPERATION_COUNT = TIMER_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.kernel.impl.StopTimerImpl <em>Stop Timer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.kernel.impl.StopTimerImpl
	 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getStopTimer()
	 * @generated
	 */
	int STOP_TIMER = 15;

	/**
	 * The feature id for the '<em><b>Timer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_TIMER__TIMER = TIMER_ACTION__TIMER;

	/**
	 * The number of structural features of the '<em>Stop Timer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_TIMER_FEATURE_COUNT = TIMER_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Stop Timer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_TIMER_OPERATION_COUNT = TIMER_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.kernel.impl.ResumeTimerImpl <em>Resume Timer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.kernel.impl.ResumeTimerImpl
	 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getResumeTimer()
	 * @generated
	 */
	int RESUME_TIMER = 16;

	/**
	 * The feature id for the '<em><b>Timer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESUME_TIMER__TIMER = TIMER_ACTION__TIMER;

	/**
	 * The number of structural features of the '<em>Resume Timer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESUME_TIMER_FEATURE_COUNT = TIMER_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Resume Timer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESUME_TIMER_OPERATION_COUNT = TIMER_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.kernel.impl.ClearEvidenceImpl <em>Clear Evidence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.kernel.impl.ClearEvidenceImpl
	 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getClearEvidence()
	 * @generated
	 */
	int CLEAR_EVIDENCE = 17;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLEAR_EVIDENCE__TARGET = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Clear Evidence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLEAR_EVIDENCE_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Clear Evidence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLEAR_EVIDENCE_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.kernel.StrengthEnum <em>Strength Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.kernel.StrengthEnum
	 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getStrengthEnum()
	 * @generated
	 */
	int STRENGTH_ENUM = 18;

	/**
	 * The meta object id for the '{@link roqme.metamodel.kernel.InfluenceEnum <em>Influence Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.kernel.InfluenceEnum
	 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getInfluenceEnum()
	 * @generated
	 */
	int INFLUENCE_ENUM = 19;


	/**
	 * Returns the meta object for class '{@link roqme.metamodel.kernel.PrimitiveContext <em>Primitive Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Context</em>'.
	 * @see roqme.metamodel.kernel.PrimitiveContext
	 * @generated
	 */
	EClass getPrimitiveContext();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.kernel.DerivedContext <em>Derived Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Derived Context</em>'.
	 * @see roqme.metamodel.kernel.DerivedContext
	 * @generated
	 */
	EClass getDerivedContext();

	/**
	 * Returns the meta object for the containment reference '{@link roqme.metamodel.kernel.DerivedContext#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Definition</em>'.
	 * @see roqme.metamodel.kernel.DerivedContext#getDefinition()
	 * @see #getDerivedContext()
	 * @generated
	 */
	EReference getDerivedContext_Definition();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.kernel.GeneralPurposeVariable <em>General Purpose Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>General Purpose Variable</em>'.
	 * @see roqme.metamodel.kernel.GeneralPurposeVariable
	 * @generated
	 */
	EClass getGeneralPurposeVariable();

	/**
	 * Returns the meta object for the containment reference '{@link roqme.metamodel.kernel.GeneralPurposeVariable#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Definition</em>'.
	 * @see roqme.metamodel.kernel.GeneralPurposeVariable#getDefinition()
	 * @see #getGeneralPurposeVariable()
	 * @generated
	 */
	EReference getGeneralPurposeVariable_Definition();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.kernel.Observation <em>Observation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Observation</em>'.
	 * @see roqme.metamodel.kernel.Observation
	 * @generated
	 */
	EClass getObservation();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.kernel.Observation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see roqme.metamodel.kernel.Observation#getName()
	 * @see #getObservation()
	 * @generated
	 */
	EAttribute getObservation_Name();

	/**
	 * Returns the meta object for the containment reference '{@link roqme.metamodel.kernel.Observation#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pattern</em>'.
	 * @see roqme.metamodel.kernel.Observation#getPattern()
	 * @see #getObservation()
	 * @generated
	 */
	EReference getObservation_Pattern();

	/**
	 * Returns the meta object for the containment reference list '{@link roqme.metamodel.kernel.Observation#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see roqme.metamodel.kernel.Observation#getActions()
	 * @see #getObservation()
	 * @generated
	 */
	EReference getObservation_Actions();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.kernel.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see roqme.metamodel.kernel.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the containment reference '{@link roqme.metamodel.kernel.Property#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Transformation</em>'.
	 * @see roqme.metamodel.kernel.Property#getTransformation()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Transformation();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.kernel.BeliefVariable <em>Belief Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Belief Variable</em>'.
	 * @see roqme.metamodel.kernel.BeliefVariable
	 * @generated
	 */
	EClass getBeliefVariable();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.kernel.BeliefVariable#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference</em>'.
	 * @see roqme.metamodel.kernel.BeliefVariable#getReference()
	 * @see #getBeliefVariable()
	 * @generated
	 */
	EAttribute getBeliefVariable_Reference();

	/**
	 * Returns the meta object for the containment reference '{@link roqme.metamodel.kernel.BeliefVariable#getSurvival <em>Survival</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Survival</em>'.
	 * @see roqme.metamodel.kernel.BeliefVariable#getSurvival()
	 * @see #getBeliefVariable()
	 * @generated
	 */
	EReference getBeliefVariable_Survival();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.kernel.SetEvidence <em>Set Evidence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Evidence</em>'.
	 * @see roqme.metamodel.kernel.SetEvidence
	 * @generated
	 */
	EClass getSetEvidence();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.kernel.SetEvidence#getInfluence <em>Influence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Influence</em>'.
	 * @see roqme.metamodel.kernel.SetEvidence#getInfluence()
	 * @see #getSetEvidence()
	 * @generated
	 */
	EAttribute getSetEvidence_Influence();

	/**
	 * Returns the meta object for the reference '{@link roqme.metamodel.kernel.SetEvidence#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see roqme.metamodel.kernel.SetEvidence#getTarget()
	 * @see #getSetEvidence()
	 * @generated
	 */
	EReference getSetEvidence_Target();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.kernel.SetEvidence#getStrength <em>Strength</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strength</em>'.
	 * @see roqme.metamodel.kernel.SetEvidence#getStrength()
	 * @see #getSetEvidence()
	 * @generated
	 */
	EAttribute getSetEvidence_Strength();

	/**
	 * Returns the meta object for the containment reference '{@link roqme.metamodel.kernel.SetEvidence#getSurvival <em>Survival</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Survival</em>'.
	 * @see roqme.metamodel.kernel.SetEvidence#getSurvival()
	 * @see #getSetEvidence()
	 * @generated
	 */
	EReference getSetEvidence_Survival();

	/**
	 * Returns the meta object for the containment reference '{@link roqme.metamodel.kernel.SetEvidence#getConditionedBy <em>Conditioned By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Conditioned By</em>'.
	 * @see roqme.metamodel.kernel.SetEvidence#getConditionedBy()
	 * @see #getSetEvidence()
	 * @generated
	 */
	EReference getSetEvidence_ConditionedBy();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.kernel.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import</em>'.
	 * @see roqme.metamodel.kernel.Import
	 * @generated
	 */
	EClass getImport();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.kernel.Import#getImportURI <em>Import URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import URI</em>'.
	 * @see roqme.metamodel.kernel.Import#getImportURI()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_ImportURI();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.kernel.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see roqme.metamodel.kernel.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.kernel.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see roqme.metamodel.kernel.Context
	 * @generated
	 */
	EClass getContext();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.kernel.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see roqme.metamodel.kernel.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.kernel.SetVariable <em>Set Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Variable</em>'.
	 * @see roqme.metamodel.kernel.SetVariable
	 * @generated
	 */
	EClass getSetVariable();

	/**
	 * Returns the meta object for the reference '{@link roqme.metamodel.kernel.SetVariable#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see roqme.metamodel.kernel.SetVariable#getVariable()
	 * @see #getSetVariable()
	 * @generated
	 */
	EReference getSetVariable_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link roqme.metamodel.kernel.SetVariable#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see roqme.metamodel.kernel.SetVariable#getExpression()
	 * @see #getSetVariable()
	 * @generated
	 */
	EReference getSetVariable_Expression();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.kernel.Timer <em>Timer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timer</em>'.
	 * @see roqme.metamodel.kernel.Timer
	 * @generated
	 */
	EClass getTimer();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.kernel.Timer#isOnce <em>Once</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Once</em>'.
	 * @see roqme.metamodel.kernel.Timer#isOnce()
	 * @see #getTimer()
	 * @generated
	 */
	EAttribute getTimer_Once();

	/**
	 * Returns the meta object for the containment reference '{@link roqme.metamodel.kernel.Timer#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Definition</em>'.
	 * @see roqme.metamodel.kernel.Timer#getDefinition()
	 * @see #getTimer()
	 * @generated
	 */
	EReference getTimer_Definition();

	/**
	 * Returns the meta object for the containment reference '{@link roqme.metamodel.kernel.Timer#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Offset</em>'.
	 * @see roqme.metamodel.kernel.Timer#getOffset()
	 * @see #getTimer()
	 * @generated
	 */
	EReference getTimer_Offset();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.kernel.Timer#isPaused <em>Paused</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Paused</em>'.
	 * @see roqme.metamodel.kernel.Timer#isPaused()
	 * @see #getTimer()
	 * @generated
	 */
	EAttribute getTimer_Paused();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.kernel.TimerAction <em>Timer Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timer Action</em>'.
	 * @see roqme.metamodel.kernel.TimerAction
	 * @generated
	 */
	EClass getTimerAction();

	/**
	 * Returns the meta object for the reference '{@link roqme.metamodel.kernel.TimerAction#getTimer <em>Timer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Timer</em>'.
	 * @see roqme.metamodel.kernel.TimerAction#getTimer()
	 * @see #getTimerAction()
	 * @generated
	 */
	EReference getTimerAction_Timer();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.kernel.StartTimer <em>Start Timer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Timer</em>'.
	 * @see roqme.metamodel.kernel.StartTimer
	 * @generated
	 */
	EClass getStartTimer();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.kernel.StopTimer <em>Stop Timer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stop Timer</em>'.
	 * @see roqme.metamodel.kernel.StopTimer
	 * @generated
	 */
	EClass getStopTimer();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.kernel.ResumeTimer <em>Resume Timer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resume Timer</em>'.
	 * @see roqme.metamodel.kernel.ResumeTimer
	 * @generated
	 */
	EClass getResumeTimer();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.kernel.ClearEvidence <em>Clear Evidence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clear Evidence</em>'.
	 * @see roqme.metamodel.kernel.ClearEvidence
	 * @generated
	 */
	EClass getClearEvidence();

	/**
	 * Returns the meta object for the reference '{@link roqme.metamodel.kernel.ClearEvidence#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see roqme.metamodel.kernel.ClearEvidence#getTarget()
	 * @see #getClearEvidence()
	 * @generated
	 */
	EReference getClearEvidence_Target();

	/**
	 * Returns the meta object for enum '{@link roqme.metamodel.kernel.StrengthEnum <em>Strength Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Strength Enum</em>'.
	 * @see roqme.metamodel.kernel.StrengthEnum
	 * @generated
	 */
	EEnum getStrengthEnum();

	/**
	 * Returns the meta object for enum '{@link roqme.metamodel.kernel.InfluenceEnum <em>Influence Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Influence Enum</em>'.
	 * @see roqme.metamodel.kernel.InfluenceEnum
	 * @generated
	 */
	EEnum getInfluenceEnum();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	KernelFactory getKernelFactory();

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
		 * The meta object literal for the '{@link roqme.metamodel.kernel.impl.PrimitiveContextImpl <em>Primitive Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.kernel.impl.PrimitiveContextImpl
		 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getPrimitiveContext()
		 * @generated
		 */
		EClass PRIMITIVE_CONTEXT = eINSTANCE.getPrimitiveContext();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.kernel.impl.DerivedContextImpl <em>Derived Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.kernel.impl.DerivedContextImpl
		 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getDerivedContext()
		 * @generated
		 */
		EClass DERIVED_CONTEXT = eINSTANCE.getDerivedContext();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DERIVED_CONTEXT__DEFINITION = eINSTANCE.getDerivedContext_Definition();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.kernel.impl.GeneralPurposeVariableImpl <em>General Purpose Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.kernel.impl.GeneralPurposeVariableImpl
		 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getGeneralPurposeVariable()
		 * @generated
		 */
		EClass GENERAL_PURPOSE_VARIABLE = eINSTANCE.getGeneralPurposeVariable();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERAL_PURPOSE_VARIABLE__DEFINITION = eINSTANCE.getGeneralPurposeVariable_Definition();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.kernel.impl.ObservationImpl <em>Observation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.kernel.impl.ObservationImpl
		 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getObservation()
		 * @generated
		 */
		EClass OBSERVATION = eINSTANCE.getObservation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBSERVATION__NAME = eINSTANCE.getObservation_Name();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBSERVATION__PATTERN = eINSTANCE.getObservation_Pattern();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBSERVATION__ACTIONS = eINSTANCE.getObservation_Actions();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.kernel.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.kernel.impl.PropertyImpl
		 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Transformation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__TRANSFORMATION = eINSTANCE.getProperty_Transformation();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.kernel.impl.BeliefVariableImpl <em>Belief Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.kernel.impl.BeliefVariableImpl
		 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getBeliefVariable()
		 * @generated
		 */
		EClass BELIEF_VARIABLE = eINSTANCE.getBeliefVariable();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BELIEF_VARIABLE__REFERENCE = eINSTANCE.getBeliefVariable_Reference();

		/**
		 * The meta object literal for the '<em><b>Survival</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BELIEF_VARIABLE__SURVIVAL = eINSTANCE.getBeliefVariable_Survival();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.kernel.impl.SetEvidenceImpl <em>Set Evidence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.kernel.impl.SetEvidenceImpl
		 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getSetEvidence()
		 * @generated
		 */
		EClass SET_EVIDENCE = eINSTANCE.getSetEvidence();

		/**
		 * The meta object literal for the '<em><b>Influence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_EVIDENCE__INFLUENCE = eINSTANCE.getSetEvidence_Influence();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_EVIDENCE__TARGET = eINSTANCE.getSetEvidence_Target();

		/**
		 * The meta object literal for the '<em><b>Strength</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_EVIDENCE__STRENGTH = eINSTANCE.getSetEvidence_Strength();

		/**
		 * The meta object literal for the '<em><b>Survival</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_EVIDENCE__SURVIVAL = eINSTANCE.getSetEvidence_Survival();

		/**
		 * The meta object literal for the '<em><b>Conditioned By</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_EVIDENCE__CONDITIONED_BY = eINSTANCE.getSetEvidence_ConditionedBy();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.kernel.impl.ImportImpl <em>Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.kernel.impl.ImportImpl
		 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getImport()
		 * @generated
		 */
		EClass IMPORT = eINSTANCE.getImport();

		/**
		 * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__IMPORT_URI = eINSTANCE.getImport_ImportURI();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.kernel.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.kernel.impl.ParameterImpl
		 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.kernel.impl.ContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.kernel.impl.ContextImpl
		 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getContext()
		 * @generated
		 */
		EClass CONTEXT = eINSTANCE.getContext();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.kernel.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.kernel.impl.ActionImpl
		 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.kernel.impl.SetVariableImpl <em>Set Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.kernel.impl.SetVariableImpl
		 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getSetVariable()
		 * @generated
		 */
		EClass SET_VARIABLE = eINSTANCE.getSetVariable();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_VARIABLE__VARIABLE = eINSTANCE.getSetVariable_Variable();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_VARIABLE__EXPRESSION = eINSTANCE.getSetVariable_Expression();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.kernel.impl.TimerImpl <em>Timer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.kernel.impl.TimerImpl
		 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getTimer()
		 * @generated
		 */
		EClass TIMER = eINSTANCE.getTimer();

		/**
		 * The meta object literal for the '<em><b>Once</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMER__ONCE = eINSTANCE.getTimer_Once();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMER__DEFINITION = eINSTANCE.getTimer_Definition();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMER__OFFSET = eINSTANCE.getTimer_Offset();

		/**
		 * The meta object literal for the '<em><b>Paused</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMER__PAUSED = eINSTANCE.getTimer_Paused();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.kernel.impl.TimerActionImpl <em>Timer Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.kernel.impl.TimerActionImpl
		 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getTimerAction()
		 * @generated
		 */
		EClass TIMER_ACTION = eINSTANCE.getTimerAction();

		/**
		 * The meta object literal for the '<em><b>Timer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMER_ACTION__TIMER = eINSTANCE.getTimerAction_Timer();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.kernel.impl.StartTimerImpl <em>Start Timer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.kernel.impl.StartTimerImpl
		 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getStartTimer()
		 * @generated
		 */
		EClass START_TIMER = eINSTANCE.getStartTimer();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.kernel.impl.StopTimerImpl <em>Stop Timer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.kernel.impl.StopTimerImpl
		 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getStopTimer()
		 * @generated
		 */
		EClass STOP_TIMER = eINSTANCE.getStopTimer();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.kernel.impl.ResumeTimerImpl <em>Resume Timer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.kernel.impl.ResumeTimerImpl
		 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getResumeTimer()
		 * @generated
		 */
		EClass RESUME_TIMER = eINSTANCE.getResumeTimer();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.kernel.impl.ClearEvidenceImpl <em>Clear Evidence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.kernel.impl.ClearEvidenceImpl
		 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getClearEvidence()
		 * @generated
		 */
		EClass CLEAR_EVIDENCE = eINSTANCE.getClearEvidence();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLEAR_EVIDENCE__TARGET = eINSTANCE.getClearEvidence_Target();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.kernel.StrengthEnum <em>Strength Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.kernel.StrengthEnum
		 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getStrengthEnum()
		 * @generated
		 */
		EEnum STRENGTH_ENUM = eINSTANCE.getStrengthEnum();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.kernel.InfluenceEnum <em>Influence Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.kernel.InfluenceEnum
		 * @see roqme.metamodel.kernel.impl.KernelPackageImpl#getInfluenceEnum()
		 * @generated
		 */
		EEnum INFLUENCE_ENUM = eINSTANCE.getInfluenceEnum();

	}

} //KernelPackage
