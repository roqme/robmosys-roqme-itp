/**
 */
package roqme.metamodel.datatypes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import roqme.metamodel.datatypes.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DatatypesFactoryImpl extends EFactoryImpl implements DatatypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DatatypesFactory init() {
		try {
			DatatypesFactory theDatatypesFactory = (DatatypesFactory)EPackage.Registry.INSTANCE.getEFactory(DatatypesPackage.eNS_URI);
			if (theDatatypesFactory != null) {
				return theDatatypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DatatypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatatypesFactoryImpl() {
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
			case DatatypesPackage.ROQME_MODEL: return createRoqmeModel();
			case DatatypesPackage.REFERENCED_DECLARATION: return createReferencedDeclaration();
			case DatatypesPackage.CONTAINED_DECLARATION: return createContainedDeclaration();
			case DatatypesPackage.INBUILT_DECLARATION: return createInbuiltDeclaration();
			case DatatypesPackage.DATA_TYPE_DEFINITION: return createDataTypeDefinition();
			case DatatypesPackage.ENUM_TYPE: return createEnumType();
			case DatatypesPackage.ENUM_LITERAL: return createEnumLiteral();
			case DatatypesPackage.EVENT_TYPE: return createEventType();
			case DatatypesPackage.NUMERIC_TYPE: return createNumericType();
			case DatatypesPackage.TIME_TYPE: return createTimeType();
			case DatatypesPackage.BOOLEAN_TYPE: return createBooleanType();
			case DatatypesPackage.BOOLEAN_VALUE: return createBooleanValue();
			case DatatypesPackage.ENUM_VALUE: return createEnumValue();
			case DatatypesPackage.NUMERIC_VALUE: return createNumericValue();
			case DatatypesPackage.TIME_VALUE: return createTimeValue();
			case DatatypesPackage.EVENT_VALUE: return createEventValue();
			case DatatypesPackage.LOWER_BOUND: return createLowerBound();
			case DatatypesPackage.UPPER_BOUND: return createUpperBound();
			case DatatypesPackage.UNIT_MEASURED_TYPE: return createUnitMeasuredType();
			case DatatypesPackage.UNIT_MEASURED_VALUE: return createUnitMeasuredValue();
			case DatatypesPackage.ARRAY_VALUE: return createArrayValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoqmeModel createRoqmeModel() {
		RoqmeModelImpl roqmeModel = new RoqmeModelImpl();
		return roqmeModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferencedDeclaration createReferencedDeclaration() {
		ReferencedDeclarationImpl referencedDeclaration = new ReferencedDeclarationImpl();
		return referencedDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainedDeclaration createContainedDeclaration() {
		ContainedDeclarationImpl containedDeclaration = new ContainedDeclarationImpl();
		return containedDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InbuiltDeclaration createInbuiltDeclaration() {
		InbuiltDeclarationImpl inbuiltDeclaration = new InbuiltDeclarationImpl();
		return inbuiltDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeDefinition createDataTypeDefinition() {
		DataTypeDefinitionImpl dataTypeDefinition = new DataTypeDefinitionImpl();
		return dataTypeDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumType createEnumType() {
		EnumTypeImpl enumType = new EnumTypeImpl();
		return enumType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumLiteral createEnumLiteral() {
		EnumLiteralImpl enumLiteral = new EnumLiteralImpl();
		return enumLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventType createEventType() {
		EventTypeImpl eventType = new EventTypeImpl();
		return eventType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericType createNumericType() {
		NumericTypeImpl numericType = new NumericTypeImpl();
		return numericType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeType createTimeType() {
		TimeTypeImpl timeType = new TimeTypeImpl();
		return timeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanType createBooleanType() {
		BooleanTypeImpl booleanType = new BooleanTypeImpl();
		return booleanType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanValue createBooleanValue() {
		BooleanValueImpl booleanValue = new BooleanValueImpl();
		return booleanValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumValue createEnumValue() {
		EnumValueImpl enumValue = new EnumValueImpl();
		return enumValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericValue createNumericValue() {
		NumericValueImpl numericValue = new NumericValueImpl();
		return numericValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeValue createTimeValue() {
		TimeValueImpl timeValue = new TimeValueImpl();
		return timeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventValue createEventValue() {
		EventValueImpl eventValue = new EventValueImpl();
		return eventValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LowerBound createLowerBound() {
		LowerBoundImpl lowerBound = new LowerBoundImpl();
		return lowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UpperBound createUpperBound() {
		UpperBoundImpl upperBound = new UpperBoundImpl();
		return upperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitMeasuredType createUnitMeasuredType() {
		UnitMeasuredTypeImpl unitMeasuredType = new UnitMeasuredTypeImpl();
		return unitMeasuredType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitMeasuredValue createUnitMeasuredValue() {
		UnitMeasuredValueImpl unitMeasuredValue = new UnitMeasuredValueImpl();
		return unitMeasuredValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayValue createArrayValue() {
		ArrayValueImpl arrayValue = new ArrayValueImpl();
		return arrayValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatatypesPackage getDatatypesPackage() {
		return (DatatypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DatatypesPackage getPackage() {
		return DatatypesPackage.eINSTANCE;
	}

} //DatatypesFactoryImpl
