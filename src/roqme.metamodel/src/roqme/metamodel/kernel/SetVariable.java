/**
 */
package roqme.metamodel.kernel;

import roqme.metamodel.datatypes.TypedVariable;

import roqme.metamodel.expressions.GeneralExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.kernel.SetVariable#getVariable <em>Variable</em>}</li>
 *   <li>{@link roqme.metamodel.kernel.SetVariable#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.kernel.KernelPackage#getSetVariable()
 * @model
 * @generated
 */
public interface SetVariable extends Action {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(TypedVariable)
	 * @see roqme.metamodel.kernel.KernelPackage#getSetVariable_Variable()
	 * @model required="true"
	 * @generated
	 */
	TypedVariable getVariable();

	/**
	 * Sets the value of the '{@link roqme.metamodel.kernel.SetVariable#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(TypedVariable value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(GeneralExpression)
	 * @see roqme.metamodel.kernel.KernelPackage#getSetVariable_Expression()
	 * @model containment="true"
	 * @generated
	 */
	GeneralExpression getExpression();

	/**
	 * Sets the value of the '{@link roqme.metamodel.kernel.SetVariable#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(GeneralExpression value);

} // SetVariable
