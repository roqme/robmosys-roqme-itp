/**
 */
package roqme.metamodel.datatypes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contained Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.datatypes.ContainedDeclaration#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.datatypes.DatatypesPackage#getContainedDeclaration()
 * @model
 * @generated
 */
public interface ContainedDeclaration extends DataTypeDeclaration {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(DataType)
	 * @see roqme.metamodel.datatypes.DatatypesPackage#getContainedDeclaration_Type()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DataType getType();

	/**
	 * Sets the value of the '{@link roqme.metamodel.datatypes.ContainedDeclaration#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(DataType value);

} // ContainedDeclaration
