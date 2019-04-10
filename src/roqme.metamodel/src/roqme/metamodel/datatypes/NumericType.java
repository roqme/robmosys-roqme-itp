/**
 */
package roqme.metamodel.datatypes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numeric Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.datatypes.NumericType#getConstraints <em>Constraints</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.datatypes.DatatypesPackage#getNumericType()
 * @model
 * @generated
 */
public interface NumericType extends DataType {
	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link roqme.metamodel.datatypes.NumericTypeConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see roqme.metamodel.datatypes.DatatypesPackage#getNumericType_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<NumericTypeConstraint> getConstraints();

} // NumericType
