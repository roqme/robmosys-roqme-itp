/**
 */
package roqme.metamodel.datatypes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.datatypes.EnumLiteral#getName <em>Name</em>}</li>
 *   <li>{@link roqme.metamodel.datatypes.EnumLiteral#getEnumType <em>Enum Type</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.datatypes.DatatypesPackage#getEnumLiteral()
 * @model
 * @generated
 */
public interface EnumLiteral extends EObject {
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
	 * @see roqme.metamodel.datatypes.DatatypesPackage#getEnumLiteral_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link roqme.metamodel.datatypes.EnumLiteral#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Enum Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link roqme.metamodel.datatypes.EnumType#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum Type</em>' container reference.
	 * @see #setEnumType(EnumType)
	 * @see roqme.metamodel.datatypes.DatatypesPackage#getEnumLiteral_EnumType()
	 * @see roqme.metamodel.datatypes.EnumType#getLiterals
	 * @model opposite="literals" required="true" transient="false"
	 * @generated
	 */
	EnumType getEnumType();

	/**
	 * Sets the value of the '{@link roqme.metamodel.datatypes.EnumLiteral#getEnumType <em>Enum Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enum Type</em>' container reference.
	 * @see #getEnumType()
	 * @generated
	 */
	void setEnumType(EnumType value);

} // EnumLiteral
