/**
 */
package roqme.metamodel.datatypes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.datatypes.EnumType#getLiterals <em>Literals</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.datatypes.DatatypesPackage#getEnumType()
 * @model
 * @generated
 */
public interface EnumType extends DataType {
	/**
	 * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
	 * The list contents are of type {@link roqme.metamodel.datatypes.EnumLiteral}.
	 * It is bidirectional and its opposite is '{@link roqme.metamodel.datatypes.EnumLiteral#getEnumType <em>Enum Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literals</em>' containment reference list.
	 * @see roqme.metamodel.datatypes.DatatypesPackage#getEnumType_Literals()
	 * @see roqme.metamodel.datatypes.EnumLiteral#getEnumType
	 * @model opposite="enumType" containment="true" required="true"
	 * @generated
	 */
	EList<EnumLiteral> getLiterals();

} // EnumType
