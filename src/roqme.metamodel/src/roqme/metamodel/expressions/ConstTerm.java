/**
 */
package roqme.metamodel.expressions;

import roqme.metamodel.datatypes.TypedValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Const Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.expressions.ConstTerm#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.expressions.ExpressionsPackage#getConstTerm()
 * @model
 * @generated
 */
public interface ConstTerm extends Term {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(TypedValue)
	 * @see roqme.metamodel.expressions.ExpressionsPackage#getConstTerm_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TypedValue getValue();

	/**
	 * Sets the value of the '{@link roqme.metamodel.expressions.ConstTerm#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(TypedValue value);

} // ConstTerm
