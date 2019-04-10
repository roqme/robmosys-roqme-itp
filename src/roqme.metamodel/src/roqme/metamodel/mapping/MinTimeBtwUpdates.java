/**
 */
package roqme.metamodel.mapping;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Min Time Btw Updates</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.mapping.MinTimeBtwUpdates#getValue <em>Value</em>}</li>
 *   <li>{@link roqme.metamodel.mapping.MinTimeBtwUpdates#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.mapping.MappingPackage#getMinTimeBtwUpdates()
 * @model
 * @generated
 */
public interface MinTimeBtwUpdates extends ConfigOpt {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(int)
	 * @see roqme.metamodel.mapping.MappingPackage#getMinTimeBtwUpdates_Value()
	 * @model required="true"
	 * @generated
	 */
	int getValue();

	/**
	 * Sets the value of the '{@link roqme.metamodel.mapping.MinTimeBtwUpdates#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(int value);

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' attribute.
	 * @see #setUnit(String)
	 * @see roqme.metamodel.mapping.MappingPackage#getMinTimeBtwUpdates_Unit()
	 * @model required="true"
	 * @generated
	 */
	String getUnit();

	/**
	 * Sets the value of the '{@link roqme.metamodel.mapping.MinTimeBtwUpdates#getUnit <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' attribute.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(String value);

} // MinTimeBtwUpdates
