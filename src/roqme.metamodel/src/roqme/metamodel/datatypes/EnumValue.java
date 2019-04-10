/**
 */
package roqme.metamodel.datatypes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.datatypes.EnumValue#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.datatypes.DatatypesPackage#getEnumValue()
 * @model
 * @generated
 */
public interface EnumValue extends SingleValue {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(EnumLiteral)
	 * @see roqme.metamodel.datatypes.DatatypesPackage#getEnumValue_Value()
	 * @model required="true"
	 * @generated
	 */
	EnumLiteral getValue();

	/**
	 * Sets the value of the '{@link roqme.metamodel.datatypes.EnumValue#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(EnumLiteral value);

} // EnumValue
