/**
 */
package roqme.metamodel.kernel;

import roqme.metamodel.datatypes.TypedVariable;

import roqme.metamodel.expressions.GeneralExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>General Purpose Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.kernel.GeneralPurposeVariable#getDefinition <em>Definition</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.kernel.KernelPackage#getGeneralPurposeVariable()
 * @model
 * @generated
 */
public interface GeneralPurposeVariable extends TypedVariable {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' containment reference.
	 * @see #setDefinition(GeneralExpression)
	 * @see roqme.metamodel.kernel.KernelPackage#getGeneralPurposeVariable_Definition()
	 * @model containment="true"
	 * @generated
	 */
	GeneralExpression getDefinition();

	/**
	 * Sets the value of the '{@link roqme.metamodel.kernel.GeneralPurposeVariable#getDefinition <em>Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' containment reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(GeneralExpression value);

} // GeneralPurposeVariable
