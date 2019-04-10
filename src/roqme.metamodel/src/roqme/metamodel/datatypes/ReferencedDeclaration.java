/**
 */
package roqme.metamodel.datatypes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Referenced Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.datatypes.ReferencedDeclaration#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.datatypes.DatatypesPackage#getReferencedDeclaration()
 * @model
 * @generated
 */
public interface ReferencedDeclaration extends DataTypeDeclaration {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(DataTypeDefinition)
	 * @see roqme.metamodel.datatypes.DatatypesPackage#getReferencedDeclaration_Type()
	 * @model required="true"
	 * @generated
	 */
	DataTypeDefinition getType();

	/**
	 * Sets the value of the '{@link roqme.metamodel.datatypes.ReferencedDeclaration#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(DataTypeDefinition value);

} // ReferencedDeclaration
