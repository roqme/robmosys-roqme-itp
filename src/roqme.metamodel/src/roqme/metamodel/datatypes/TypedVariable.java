/**
 */
package roqme.metamodel.datatypes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.datatypes.TypedVariable#getName <em>Name</em>}</li>
 *   <li>{@link roqme.metamodel.datatypes.TypedVariable#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link roqme.metamodel.datatypes.TypedVariable#getInitializedTo <em>Initialized To</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.datatypes.DatatypesPackage#getTypedVariable()
 * @model abstract="true"
 * @generated
 */
public interface TypedVariable extends DocumentableElement {
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
	 * @see roqme.metamodel.datatypes.DatatypesPackage#getTypedVariable_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link roqme.metamodel.datatypes.TypedVariable#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaration</em>' containment reference.
	 * @see #setDeclaration(DataTypeDeclaration)
	 * @see roqme.metamodel.datatypes.DatatypesPackage#getTypedVariable_Declaration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DataTypeDeclaration getDeclaration();

	/**
	 * Sets the value of the '{@link roqme.metamodel.datatypes.TypedVariable#getDeclaration <em>Declaration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration</em>' containment reference.
	 * @see #getDeclaration()
	 * @generated
	 */
	void setDeclaration(DataTypeDeclaration value);

	/**
	 * Returns the value of the '<em><b>Initialized To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialized To</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialized To</em>' containment reference.
	 * @see #setInitializedTo(TypedValue)
	 * @see roqme.metamodel.datatypes.DatatypesPackage#getTypedVariable_InitializedTo()
	 * @model containment="true"
	 * @generated
	 */
	TypedValue getInitializedTo();

	/**
	 * Sets the value of the '{@link roqme.metamodel.datatypes.TypedVariable#getInitializedTo <em>Initialized To</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialized To</em>' containment reference.
	 * @see #getInitializedTo()
	 * @generated
	 */
	void setInitializedTo(TypedValue value);

} // TypedVariable
