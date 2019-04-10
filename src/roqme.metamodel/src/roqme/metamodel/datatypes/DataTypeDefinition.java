/**
 */
package roqme.metamodel.datatypes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.datatypes.DataTypeDefinition#getDataType <em>Data Type</em>}</li>
 *   <li>{@link roqme.metamodel.datatypes.DataTypeDefinition#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.datatypes.DatatypesPackage#getDataTypeDefinition()
 * @model
 * @generated
 */
public interface DataTypeDefinition extends DocumentableElement {
	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type</em>' containment reference.
	 * @see #setDataType(DataType)
	 * @see roqme.metamodel.datatypes.DatatypesPackage#getDataTypeDefinition_DataType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DataType getDataType();

	/**
	 * Sets the value of the '{@link roqme.metamodel.datatypes.DataTypeDefinition#getDataType <em>Data Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type</em>' containment reference.
	 * @see #getDataType()
	 * @generated
	 */
	void setDataType(DataType value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see roqme.metamodel.datatypes.DatatypesPackage#getDataTypeDefinition_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link roqme.metamodel.datatypes.DataTypeDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // DataTypeDefinition
