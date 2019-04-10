/**
 */
package roqme.metamodel.datatypes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.datatypes.ArrayValue#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.datatypes.DatatypesPackage#getArrayValue()
 * @model
 * @generated
 */
public interface ArrayValue extends TypedValue {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link roqme.metamodel.datatypes.SingleValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see roqme.metamodel.datatypes.DatatypesPackage#getArrayValue_Values()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<SingleValue> getValues();

} // ArrayValue
