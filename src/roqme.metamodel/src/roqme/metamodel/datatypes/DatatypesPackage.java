/**
 */
package roqme.metamodel.datatypes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see roqme.metamodel.datatypes.DatatypesFactory
 * @model kind="package"
 * @generated
 */
public interface DatatypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "datatypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://robmosys.eu/roqme/datatypes";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "roqme.datatypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DatatypesPackage eINSTANCE = roqme.metamodel.datatypes.impl.DatatypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.DocumentableElementImpl <em>Documentable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.DocumentableElementImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getDocumentableElement()
	 * @generated
	 */
	int DOCUMENTABLE_ELEMENT = 28;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTABLE_ELEMENT__DESCRIPTION = 0;

	/**
	 * The number of structural features of the '<em>Documentable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTABLE_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Documentable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTABLE_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.RoqmeModelImpl <em>Roqme Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.RoqmeModelImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getRoqmeModel()
	 * @generated
	 */
	int ROQME_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROQME_MODEL__DESCRIPTION = DOCUMENTABLE_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROQME_MODEL__NAMESPACE = DOCUMENTABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROQME_MODEL__DATA_TYPES = DOCUMENTABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sentences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROQME_MODEL__SENTENCES = DOCUMENTABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROQME_MODEL__VARIABLES = DOCUMENTABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Roqme Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROQME_MODEL_FEATURE_COUNT = DOCUMENTABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Roqme Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROQME_MODEL_OPERATION_COUNT = DOCUMENTABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.TypedVariableImpl <em>Typed Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.TypedVariableImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getTypedVariable()
	 * @generated
	 */
	int TYPED_VARIABLE = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_VARIABLE__DESCRIPTION = DOCUMENTABLE_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_VARIABLE__NAME = DOCUMENTABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_VARIABLE__DECLARATION = DOCUMENTABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initialized To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_VARIABLE__INITIALIZED_TO = DOCUMENTABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Typed Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_VARIABLE_FEATURE_COUNT = DOCUMENTABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Typed Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_VARIABLE_OPERATION_COUNT = DOCUMENTABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.DataTypeDeclarationImpl <em>Data Type Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.DataTypeDeclarationImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getDataTypeDeclaration()
	 * @generated
	 */
	int DATA_TYPE_DECLARATION = 2;

	/**
	 * The number of structural features of the '<em>Data Type Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DECLARATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Data Type Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DECLARATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.ReferencedDeclarationImpl <em>Referenced Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.ReferencedDeclarationImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getReferencedDeclaration()
	 * @generated
	 */
	int REFERENCED_DECLARATION = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCED_DECLARATION__TYPE = DATA_TYPE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Referenced Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCED_DECLARATION_FEATURE_COUNT = DATA_TYPE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Referenced Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCED_DECLARATION_OPERATION_COUNT = DATA_TYPE_DECLARATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.ContainedDeclarationImpl <em>Contained Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.ContainedDeclarationImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getContainedDeclaration()
	 * @generated
	 */
	int CONTAINED_DECLARATION = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINED_DECLARATION__TYPE = DATA_TYPE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Contained Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINED_DECLARATION_FEATURE_COUNT = DATA_TYPE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Contained Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINED_DECLARATION_OPERATION_COUNT = DATA_TYPE_DECLARATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.InbuiltDeclarationImpl <em>Inbuilt Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.InbuiltDeclarationImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getInbuiltDeclaration()
	 * @generated
	 */
	int INBUILT_DECLARATION = 5;

	/**
	 * The number of structural features of the '<em>Inbuilt Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INBUILT_DECLARATION_FEATURE_COUNT = DATA_TYPE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Inbuilt Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INBUILT_DECLARATION_OPERATION_COUNT = DATA_TYPE_DECLARATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.DataTypeDefinitionImpl <em>Data Type Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.DataTypeDefinitionImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getDataTypeDefinition()
	 * @generated
	 */
	int DATA_TYPE_DEFINITION = 6;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION__DESCRIPTION = DOCUMENTABLE_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION__DATA_TYPE = DOCUMENTABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION__NAME = DOCUMENTABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Type Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION_FEATURE_COUNT = DOCUMENTABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Data Type Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION_OPERATION_COUNT = DOCUMENTABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.DataTypeImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__CARDINALITY = 0;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.EnumTypeImpl <em>Enum Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.EnumTypeImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getEnumType()
	 * @generated
	 */
	int ENUM_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TYPE__CARDINALITY = DATA_TYPE__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TYPE__LITERALS = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Enum Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TYPE_OPERATION_COUNT = DATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.EnumLiteralImpl <em>Enum Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.EnumLiteralImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getEnumLiteral()
	 * @generated
	 */
	int ENUM_LITERAL = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Enum Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL__ENUM_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Enum Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Enum Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.EventTypeImpl <em>Event Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.EventTypeImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getEventType()
	 * @generated
	 */
	int EVENT_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_TYPE__CARDINALITY = DATA_TYPE__CARDINALITY;

	/**
	 * The number of structural features of the '<em>Event Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Event Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_TYPE_OPERATION_COUNT = DATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.NumericTypeImpl <em>Numeric Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.NumericTypeImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getNumericType()
	 * @generated
	 */
	int NUMERIC_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TYPE__CARDINALITY = DATA_TYPE__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TYPE__CONSTRAINTS = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Numeric Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Numeric Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TYPE_OPERATION_COUNT = DATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.UnitMeasuredTypeImpl <em>Unit Measured Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.UnitMeasuredTypeImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getUnitMeasuredType()
	 * @generated
	 */
	int UNIT_MEASURED_TYPE = 23;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_MEASURED_TYPE__CARDINALITY = NUMERIC_TYPE__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_MEASURED_TYPE__CONSTRAINTS = NUMERIC_TYPE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_MEASURED_TYPE__UNIT = NUMERIC_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unit Measured Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_MEASURED_TYPE_FEATURE_COUNT = NUMERIC_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Unit Measured Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_MEASURED_TYPE_OPERATION_COUNT = NUMERIC_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.TimeTypeImpl <em>Time Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.TimeTypeImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getTimeType()
	 * @generated
	 */
	int TIME_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TYPE__CARDINALITY = UNIT_MEASURED_TYPE__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TYPE__CONSTRAINTS = UNIT_MEASURED_TYPE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TYPE__UNIT = UNIT_MEASURED_TYPE__UNIT;

	/**
	 * The number of structural features of the '<em>Time Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TYPE_FEATURE_COUNT = UNIT_MEASURED_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Time Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TYPE_OPERATION_COUNT = UNIT_MEASURED_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.BooleanTypeImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getBooleanType()
	 * @generated
	 */
	int BOOLEAN_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__CARDINALITY = DATA_TYPE__CARDINALITY;

	/**
	 * The number of structural features of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_OPERATION_COUNT = DATA_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.TypedValueImpl <em>Typed Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.TypedValueImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getTypedValue()
	 * @generated
	 */
	int TYPED_VALUE = 14;

	/**
	 * The number of structural features of the '<em>Typed Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_VALUE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Typed Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.SingleValueImpl <em>Single Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.SingleValueImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getSingleValue()
	 * @generated
	 */
	int SINGLE_VALUE = 26;

	/**
	 * The number of structural features of the '<em>Single Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUE_FEATURE_COUNT = TYPED_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Single Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_VALUE_OPERATION_COUNT = TYPED_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.BooleanValueImpl <em>Boolean Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.BooleanValueImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getBooleanValue()
	 * @generated
	 */
	int BOOLEAN_VALUE = 15;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE__VALUE = SINGLE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE_FEATURE_COUNT = SINGLE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Boolean Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE_OPERATION_COUNT = SINGLE_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.EnumValueImpl <em>Enum Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.EnumValueImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getEnumValue()
	 * @generated
	 */
	int ENUM_VALUE = 16;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VALUE__VALUE = SINGLE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VALUE_FEATURE_COUNT = SINGLE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Enum Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VALUE_OPERATION_COUNT = SINGLE_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.NumericValueImpl <em>Numeric Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.NumericValueImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getNumericValue()
	 * @generated
	 */
	int NUMERIC_VALUE = 17;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_VALUE__VALUE = SINGLE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Numeric Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_VALUE_FEATURE_COUNT = SINGLE_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Numeric Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_VALUE_OPERATION_COUNT = SINGLE_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.UnitMeasuredValueImpl <em>Unit Measured Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.UnitMeasuredValueImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getUnitMeasuredValue()
	 * @generated
	 */
	int UNIT_MEASURED_VALUE = 24;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_MEASURED_VALUE__VALUE = NUMERIC_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_MEASURED_VALUE__UNIT = NUMERIC_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unit Measured Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_MEASURED_VALUE_FEATURE_COUNT = NUMERIC_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Unit Measured Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_MEASURED_VALUE_OPERATION_COUNT = NUMERIC_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.TimeValueImpl <em>Time Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.TimeValueImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getTimeValue()
	 * @generated
	 */
	int TIME_VALUE = 18;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_VALUE__VALUE = UNIT_MEASURED_VALUE__VALUE;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_VALUE__UNIT = UNIT_MEASURED_VALUE__UNIT;

	/**
	 * The number of structural features of the '<em>Time Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_VALUE_FEATURE_COUNT = UNIT_MEASURED_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Time Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_VALUE_OPERATION_COUNT = UNIT_MEASURED_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.EventValueImpl <em>Event Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.EventValueImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getEventValue()
	 * @generated
	 */
	int EVENT_VALUE = 19;

	/**
	 * The number of structural features of the '<em>Event Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_VALUE_FEATURE_COUNT = SINGLE_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Event Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_VALUE_OPERATION_COUNT = SINGLE_VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.NumericTypeConstraintImpl <em>Numeric Type Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.NumericTypeConstraintImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getNumericTypeConstraint()
	 * @generated
	 */
	int NUMERIC_TYPE_CONSTRAINT = 22;

	/**
	 * The number of structural features of the '<em>Numeric Type Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TYPE_CONSTRAINT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Numeric Type Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TYPE_CONSTRAINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.LowerBoundImpl <em>Lower Bound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.LowerBoundImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getLowerBound()
	 * @generated
	 */
	int LOWER_BOUND = 20;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_BOUND__VALUE = NUMERIC_TYPE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Lower Bound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_BOUND_FEATURE_COUNT = NUMERIC_TYPE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Lower Bound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_BOUND_OPERATION_COUNT = NUMERIC_TYPE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.UpperBoundImpl <em>Upper Bound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.UpperBoundImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getUpperBound()
	 * @generated
	 */
	int UPPER_BOUND = 21;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_BOUND__VALUE = NUMERIC_TYPE_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Upper Bound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_BOUND_FEATURE_COUNT = NUMERIC_TYPE_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Upper Bound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_BOUND_OPERATION_COUNT = NUMERIC_TYPE_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.SentenceImpl <em>Sentence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.SentenceImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getSentence()
	 * @generated
	 */
	int SENTENCE = 25;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE__DESCRIPTION = DOCUMENTABLE_ELEMENT__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Sentence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_FEATURE_COUNT = DOCUMENTABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sentence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENTENCE_OPERATION_COUNT = DOCUMENTABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.datatypes.impl.ArrayValueImpl <em>Array Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.datatypes.impl.ArrayValueImpl
	 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getArrayValue()
	 * @generated
	 */
	int ARRAY_VALUE = 27;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_VALUE__VALUES = TYPED_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Array Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_VALUE_FEATURE_COUNT = TYPED_VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Array Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_VALUE_OPERATION_COUNT = TYPED_VALUE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.RoqmeModel <em>Roqme Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Roqme Model</em>'.
	 * @see roqme.metamodel.datatypes.RoqmeModel
	 * @generated
	 */
	EClass getRoqmeModel();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.datatypes.RoqmeModel#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see roqme.metamodel.datatypes.RoqmeModel#getNamespace()
	 * @see #getRoqmeModel()
	 * @generated
	 */
	EAttribute getRoqmeModel_Namespace();

	/**
	 * Returns the meta object for the containment reference list '{@link roqme.metamodel.datatypes.RoqmeModel#getDataTypes <em>Data Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Types</em>'.
	 * @see roqme.metamodel.datatypes.RoqmeModel#getDataTypes()
	 * @see #getRoqmeModel()
	 * @generated
	 */
	EReference getRoqmeModel_DataTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link roqme.metamodel.datatypes.RoqmeModel#getSentences <em>Sentences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sentences</em>'.
	 * @see roqme.metamodel.datatypes.RoqmeModel#getSentences()
	 * @see #getRoqmeModel()
	 * @generated
	 */
	EReference getRoqmeModel_Sentences();

	/**
	 * Returns the meta object for the containment reference list '{@link roqme.metamodel.datatypes.RoqmeModel#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see roqme.metamodel.datatypes.RoqmeModel#getVariables()
	 * @see #getRoqmeModel()
	 * @generated
	 */
	EReference getRoqmeModel_Variables();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.TypedVariable <em>Typed Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Variable</em>'.
	 * @see roqme.metamodel.datatypes.TypedVariable
	 * @generated
	 */
	EClass getTypedVariable();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.datatypes.TypedVariable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see roqme.metamodel.datatypes.TypedVariable#getName()
	 * @see #getTypedVariable()
	 * @generated
	 */
	EAttribute getTypedVariable_Name();

	/**
	 * Returns the meta object for the containment reference '{@link roqme.metamodel.datatypes.TypedVariable#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Declaration</em>'.
	 * @see roqme.metamodel.datatypes.TypedVariable#getDeclaration()
	 * @see #getTypedVariable()
	 * @generated
	 */
	EReference getTypedVariable_Declaration();

	/**
	 * Returns the meta object for the containment reference '{@link roqme.metamodel.datatypes.TypedVariable#getInitializedTo <em>Initialized To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initialized To</em>'.
	 * @see roqme.metamodel.datatypes.TypedVariable#getInitializedTo()
	 * @see #getTypedVariable()
	 * @generated
	 */
	EReference getTypedVariable_InitializedTo();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.DataTypeDeclaration <em>Data Type Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Declaration</em>'.
	 * @see roqme.metamodel.datatypes.DataTypeDeclaration
	 * @generated
	 */
	EClass getDataTypeDeclaration();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.ReferencedDeclaration <em>Referenced Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Referenced Declaration</em>'.
	 * @see roqme.metamodel.datatypes.ReferencedDeclaration
	 * @generated
	 */
	EClass getReferencedDeclaration();

	/**
	 * Returns the meta object for the reference '{@link roqme.metamodel.datatypes.ReferencedDeclaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see roqme.metamodel.datatypes.ReferencedDeclaration#getType()
	 * @see #getReferencedDeclaration()
	 * @generated
	 */
	EReference getReferencedDeclaration_Type();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.ContainedDeclaration <em>Contained Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contained Declaration</em>'.
	 * @see roqme.metamodel.datatypes.ContainedDeclaration
	 * @generated
	 */
	EClass getContainedDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link roqme.metamodel.datatypes.ContainedDeclaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see roqme.metamodel.datatypes.ContainedDeclaration#getType()
	 * @see #getContainedDeclaration()
	 * @generated
	 */
	EReference getContainedDeclaration_Type();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.InbuiltDeclaration <em>Inbuilt Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inbuilt Declaration</em>'.
	 * @see roqme.metamodel.datatypes.InbuiltDeclaration
	 * @generated
	 */
	EClass getInbuiltDeclaration();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.DataTypeDefinition <em>Data Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Definition</em>'.
	 * @see roqme.metamodel.datatypes.DataTypeDefinition
	 * @generated
	 */
	EClass getDataTypeDefinition();

	/**
	 * Returns the meta object for the containment reference '{@link roqme.metamodel.datatypes.DataTypeDefinition#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Type</em>'.
	 * @see roqme.metamodel.datatypes.DataTypeDefinition#getDataType()
	 * @see #getDataTypeDefinition()
	 * @generated
	 */
	EReference getDataTypeDefinition_DataType();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.datatypes.DataTypeDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see roqme.metamodel.datatypes.DataTypeDefinition#getName()
	 * @see #getDataTypeDefinition()
	 * @generated
	 */
	EAttribute getDataTypeDefinition_Name();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see roqme.metamodel.datatypes.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.datatypes.DataType#getCardinality <em>Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cardinality</em>'.
	 * @see roqme.metamodel.datatypes.DataType#getCardinality()
	 * @see #getDataType()
	 * @generated
	 */
	EAttribute getDataType_Cardinality();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.EnumType <em>Enum Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Type</em>'.
	 * @see roqme.metamodel.datatypes.EnumType
	 * @generated
	 */
	EClass getEnumType();

	/**
	 * Returns the meta object for the containment reference list '{@link roqme.metamodel.datatypes.EnumType#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see roqme.metamodel.datatypes.EnumType#getLiterals()
	 * @see #getEnumType()
	 * @generated
	 */
	EReference getEnumType_Literals();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.EnumLiteral <em>Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal</em>'.
	 * @see roqme.metamodel.datatypes.EnumLiteral
	 * @generated
	 */
	EClass getEnumLiteral();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.datatypes.EnumLiteral#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see roqme.metamodel.datatypes.EnumLiteral#getName()
	 * @see #getEnumLiteral()
	 * @generated
	 */
	EAttribute getEnumLiteral_Name();

	/**
	 * Returns the meta object for the container reference '{@link roqme.metamodel.datatypes.EnumLiteral#getEnumType <em>Enum Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Enum Type</em>'.
	 * @see roqme.metamodel.datatypes.EnumLiteral#getEnumType()
	 * @see #getEnumLiteral()
	 * @generated
	 */
	EReference getEnumLiteral_EnumType();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.EventType <em>Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Type</em>'.
	 * @see roqme.metamodel.datatypes.EventType
	 * @generated
	 */
	EClass getEventType();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.NumericType <em>Numeric Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Type</em>'.
	 * @see roqme.metamodel.datatypes.NumericType
	 * @generated
	 */
	EClass getNumericType();

	/**
	 * Returns the meta object for the containment reference list '{@link roqme.metamodel.datatypes.NumericType#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see roqme.metamodel.datatypes.NumericType#getConstraints()
	 * @see #getNumericType()
	 * @generated
	 */
	EReference getNumericType_Constraints();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.TimeType <em>Time Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Type</em>'.
	 * @see roqme.metamodel.datatypes.TimeType
	 * @generated
	 */
	EClass getTimeType();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Type</em>'.
	 * @see roqme.metamodel.datatypes.BooleanType
	 * @generated
	 */
	EClass getBooleanType();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.TypedValue <em>Typed Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Value</em>'.
	 * @see roqme.metamodel.datatypes.TypedValue
	 * @generated
	 */
	EClass getTypedValue();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.BooleanValue <em>Boolean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Value</em>'.
	 * @see roqme.metamodel.datatypes.BooleanValue
	 * @generated
	 */
	EClass getBooleanValue();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.datatypes.BooleanValue#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see roqme.metamodel.datatypes.BooleanValue#isValue()
	 * @see #getBooleanValue()
	 * @generated
	 */
	EAttribute getBooleanValue_Value();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.EnumValue <em>Enum Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Value</em>'.
	 * @see roqme.metamodel.datatypes.EnumValue
	 * @generated
	 */
	EClass getEnumValue();

	/**
	 * Returns the meta object for the reference '{@link roqme.metamodel.datatypes.EnumValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see roqme.metamodel.datatypes.EnumValue#getValue()
	 * @see #getEnumValue()
	 * @generated
	 */
	EReference getEnumValue_Value();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.NumericValue <em>Numeric Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Value</em>'.
	 * @see roqme.metamodel.datatypes.NumericValue
	 * @generated
	 */
	EClass getNumericValue();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.datatypes.NumericValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see roqme.metamodel.datatypes.NumericValue#getValue()
	 * @see #getNumericValue()
	 * @generated
	 */
	EAttribute getNumericValue_Value();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.TimeValue <em>Time Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Value</em>'.
	 * @see roqme.metamodel.datatypes.TimeValue
	 * @generated
	 */
	EClass getTimeValue();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.EventValue <em>Event Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Value</em>'.
	 * @see roqme.metamodel.datatypes.EventValue
	 * @generated
	 */
	EClass getEventValue();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.LowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lower Bound</em>'.
	 * @see roqme.metamodel.datatypes.LowerBound
	 * @generated
	 */
	EClass getLowerBound();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.datatypes.LowerBound#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see roqme.metamodel.datatypes.LowerBound#getValue()
	 * @see #getLowerBound()
	 * @generated
	 */
	EAttribute getLowerBound_Value();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.UpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Upper Bound</em>'.
	 * @see roqme.metamodel.datatypes.UpperBound
	 * @generated
	 */
	EClass getUpperBound();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.datatypes.UpperBound#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see roqme.metamodel.datatypes.UpperBound#getValue()
	 * @see #getUpperBound()
	 * @generated
	 */
	EAttribute getUpperBound_Value();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.NumericTypeConstraint <em>Numeric Type Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Type Constraint</em>'.
	 * @see roqme.metamodel.datatypes.NumericTypeConstraint
	 * @generated
	 */
	EClass getNumericTypeConstraint();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.UnitMeasuredType <em>Unit Measured Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Measured Type</em>'.
	 * @see roqme.metamodel.datatypes.UnitMeasuredType
	 * @generated
	 */
	EClass getUnitMeasuredType();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.datatypes.UnitMeasuredType#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see roqme.metamodel.datatypes.UnitMeasuredType#getUnit()
	 * @see #getUnitMeasuredType()
	 * @generated
	 */
	EAttribute getUnitMeasuredType_Unit();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.UnitMeasuredValue <em>Unit Measured Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Measured Value</em>'.
	 * @see roqme.metamodel.datatypes.UnitMeasuredValue
	 * @generated
	 */
	EClass getUnitMeasuredValue();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.datatypes.UnitMeasuredValue#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see roqme.metamodel.datatypes.UnitMeasuredValue#getUnit()
	 * @see #getUnitMeasuredValue()
	 * @generated
	 */
	EAttribute getUnitMeasuredValue_Unit();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.Sentence <em>Sentence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sentence</em>'.
	 * @see roqme.metamodel.datatypes.Sentence
	 * @generated
	 */
	EClass getSentence();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.SingleValue <em>Single Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Value</em>'.
	 * @see roqme.metamodel.datatypes.SingleValue
	 * @generated
	 */
	EClass getSingleValue();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.ArrayValue <em>Array Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Value</em>'.
	 * @see roqme.metamodel.datatypes.ArrayValue
	 * @generated
	 */
	EClass getArrayValue();

	/**
	 * Returns the meta object for the containment reference list '{@link roqme.metamodel.datatypes.ArrayValue#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see roqme.metamodel.datatypes.ArrayValue#getValues()
	 * @see #getArrayValue()
	 * @generated
	 */
	EReference getArrayValue_Values();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.datatypes.DocumentableElement <em>Documentable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Documentable Element</em>'.
	 * @see roqme.metamodel.datatypes.DocumentableElement
	 * @generated
	 */
	EClass getDocumentableElement();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.datatypes.DocumentableElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see roqme.metamodel.datatypes.DocumentableElement#getDescription()
	 * @see #getDocumentableElement()
	 * @generated
	 */
	EAttribute getDocumentableElement_Description();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DatatypesFactory getDatatypesFactory();

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
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.RoqmeModelImpl <em>Roqme Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.RoqmeModelImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getRoqmeModel()
		 * @generated
		 */
		EClass ROQME_MODEL = eINSTANCE.getRoqmeModel();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROQME_MODEL__NAMESPACE = eINSTANCE.getRoqmeModel_Namespace();

		/**
		 * The meta object literal for the '<em><b>Data Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROQME_MODEL__DATA_TYPES = eINSTANCE.getRoqmeModel_DataTypes();

		/**
		 * The meta object literal for the '<em><b>Sentences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROQME_MODEL__SENTENCES = eINSTANCE.getRoqmeModel_Sentences();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROQME_MODEL__VARIABLES = eINSTANCE.getRoqmeModel_Variables();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.TypedVariableImpl <em>Typed Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.TypedVariableImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getTypedVariable()
		 * @generated
		 */
		EClass TYPED_VARIABLE = eINSTANCE.getTypedVariable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_VARIABLE__NAME = eINSTANCE.getTypedVariable_Name();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_VARIABLE__DECLARATION = eINSTANCE.getTypedVariable_Declaration();

		/**
		 * The meta object literal for the '<em><b>Initialized To</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_VARIABLE__INITIALIZED_TO = eINSTANCE.getTypedVariable_InitializedTo();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.DataTypeDeclarationImpl <em>Data Type Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.DataTypeDeclarationImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getDataTypeDeclaration()
		 * @generated
		 */
		EClass DATA_TYPE_DECLARATION = eINSTANCE.getDataTypeDeclaration();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.ReferencedDeclarationImpl <em>Referenced Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.ReferencedDeclarationImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getReferencedDeclaration()
		 * @generated
		 */
		EClass REFERENCED_DECLARATION = eINSTANCE.getReferencedDeclaration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCED_DECLARATION__TYPE = eINSTANCE.getReferencedDeclaration_Type();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.ContainedDeclarationImpl <em>Contained Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.ContainedDeclarationImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getContainedDeclaration()
		 * @generated
		 */
		EClass CONTAINED_DECLARATION = eINSTANCE.getContainedDeclaration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINED_DECLARATION__TYPE = eINSTANCE.getContainedDeclaration_Type();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.InbuiltDeclarationImpl <em>Inbuilt Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.InbuiltDeclarationImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getInbuiltDeclaration()
		 * @generated
		 */
		EClass INBUILT_DECLARATION = eINSTANCE.getInbuiltDeclaration();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.DataTypeDefinitionImpl <em>Data Type Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.DataTypeDefinitionImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getDataTypeDefinition()
		 * @generated
		 */
		EClass DATA_TYPE_DEFINITION = eINSTANCE.getDataTypeDefinition();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE_DEFINITION__DATA_TYPE = eINSTANCE.getDataTypeDefinition_DataType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE_DEFINITION__NAME = eINSTANCE.getDataTypeDefinition_Name();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.DataTypeImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '<em><b>Cardinality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__CARDINALITY = eINSTANCE.getDataType_Cardinality();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.EnumTypeImpl <em>Enum Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.EnumTypeImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getEnumType()
		 * @generated
		 */
		EClass ENUM_TYPE = eINSTANCE.getEnumType();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_TYPE__LITERALS = eINSTANCE.getEnumType_Literals();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.EnumLiteralImpl <em>Enum Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.EnumLiteralImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getEnumLiteral()
		 * @generated
		 */
		EClass ENUM_LITERAL = eINSTANCE.getEnumLiteral();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUM_LITERAL__NAME = eINSTANCE.getEnumLiteral_Name();

		/**
		 * The meta object literal for the '<em><b>Enum Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_LITERAL__ENUM_TYPE = eINSTANCE.getEnumLiteral_EnumType();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.EventTypeImpl <em>Event Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.EventTypeImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getEventType()
		 * @generated
		 */
		EClass EVENT_TYPE = eINSTANCE.getEventType();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.NumericTypeImpl <em>Numeric Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.NumericTypeImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getNumericType()
		 * @generated
		 */
		EClass NUMERIC_TYPE = eINSTANCE.getNumericType();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMERIC_TYPE__CONSTRAINTS = eINSTANCE.getNumericType_Constraints();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.TimeTypeImpl <em>Time Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.TimeTypeImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getTimeType()
		 * @generated
		 */
		EClass TIME_TYPE = eINSTANCE.getTimeType();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.BooleanTypeImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getBooleanType()
		 * @generated
		 */
		EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.TypedValueImpl <em>Typed Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.TypedValueImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getTypedValue()
		 * @generated
		 */
		EClass TYPED_VALUE = eINSTANCE.getTypedValue();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.BooleanValueImpl <em>Boolean Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.BooleanValueImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getBooleanValue()
		 * @generated
		 */
		EClass BOOLEAN_VALUE = eINSTANCE.getBooleanValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_VALUE__VALUE = eINSTANCE.getBooleanValue_Value();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.EnumValueImpl <em>Enum Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.EnumValueImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getEnumValue()
		 * @generated
		 */
		EClass ENUM_VALUE = eINSTANCE.getEnumValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_VALUE__VALUE = eINSTANCE.getEnumValue_Value();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.NumericValueImpl <em>Numeric Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.NumericValueImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getNumericValue()
		 * @generated
		 */
		EClass NUMERIC_VALUE = eINSTANCE.getNumericValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_VALUE__VALUE = eINSTANCE.getNumericValue_Value();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.TimeValueImpl <em>Time Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.TimeValueImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getTimeValue()
		 * @generated
		 */
		EClass TIME_VALUE = eINSTANCE.getTimeValue();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.EventValueImpl <em>Event Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.EventValueImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getEventValue()
		 * @generated
		 */
		EClass EVENT_VALUE = eINSTANCE.getEventValue();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.LowerBoundImpl <em>Lower Bound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.LowerBoundImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getLowerBound()
		 * @generated
		 */
		EClass LOWER_BOUND = eINSTANCE.getLowerBound();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOWER_BOUND__VALUE = eINSTANCE.getLowerBound_Value();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.UpperBoundImpl <em>Upper Bound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.UpperBoundImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getUpperBound()
		 * @generated
		 */
		EClass UPPER_BOUND = eINSTANCE.getUpperBound();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPPER_BOUND__VALUE = eINSTANCE.getUpperBound_Value();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.NumericTypeConstraintImpl <em>Numeric Type Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.NumericTypeConstraintImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getNumericTypeConstraint()
		 * @generated
		 */
		EClass NUMERIC_TYPE_CONSTRAINT = eINSTANCE.getNumericTypeConstraint();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.UnitMeasuredTypeImpl <em>Unit Measured Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.UnitMeasuredTypeImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getUnitMeasuredType()
		 * @generated
		 */
		EClass UNIT_MEASURED_TYPE = eINSTANCE.getUnitMeasuredType();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_MEASURED_TYPE__UNIT = eINSTANCE.getUnitMeasuredType_Unit();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.UnitMeasuredValueImpl <em>Unit Measured Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.UnitMeasuredValueImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getUnitMeasuredValue()
		 * @generated
		 */
		EClass UNIT_MEASURED_VALUE = eINSTANCE.getUnitMeasuredValue();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_MEASURED_VALUE__UNIT = eINSTANCE.getUnitMeasuredValue_Unit();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.SentenceImpl <em>Sentence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.SentenceImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getSentence()
		 * @generated
		 */
		EClass SENTENCE = eINSTANCE.getSentence();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.SingleValueImpl <em>Single Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.SingleValueImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getSingleValue()
		 * @generated
		 */
		EClass SINGLE_VALUE = eINSTANCE.getSingleValue();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.ArrayValueImpl <em>Array Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.ArrayValueImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getArrayValue()
		 * @generated
		 */
		EClass ARRAY_VALUE = eINSTANCE.getArrayValue();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_VALUE__VALUES = eINSTANCE.getArrayValue_Values();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.datatypes.impl.DocumentableElementImpl <em>Documentable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.datatypes.impl.DocumentableElementImpl
		 * @see roqme.metamodel.datatypes.impl.DatatypesPackageImpl#getDocumentableElement()
		 * @generated
		 */
		EClass DOCUMENTABLE_ELEMENT = eINSTANCE.getDocumentableElement();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTABLE_ELEMENT__DESCRIPTION = eINSTANCE.getDocumentableElement_Description();

	}

} //DatatypesPackage
