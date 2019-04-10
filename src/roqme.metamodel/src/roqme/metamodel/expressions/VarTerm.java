/**
 */
package roqme.metamodel.expressions;

import roqme.metamodel.datatypes.TypedVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.expressions.VarTerm#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.expressions.ExpressionsPackage#getVarTerm()
 * @model
 * @generated
 */
public interface VarTerm extends Term {
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
	 * @see roqme.metamodel.expressions.ExpressionsPackage#getVarTerm_Variable()
	 * @model required="true"
	 * @generated
	 */
	TypedVariable getVariable();

	/**
	 * Sets the value of the '{@link roqme.metamodel.expressions.VarTerm#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(TypedVariable value);

} // VarTerm
