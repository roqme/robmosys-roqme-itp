/**
 */
package roqme.metamodel.kernel;

import roqme.metamodel.datatypes.TimeValue;
import roqme.metamodel.datatypes.TypedVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Belief Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.kernel.BeliefVariable#getReference <em>Reference</em>}</li>
 *   <li>{@link roqme.metamodel.kernel.BeliefVariable#getSurvival <em>Survival</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.kernel.KernelPackage#getBeliefVariable()
 * @model
 * @generated
 */
public interface BeliefVariable extends TypedVariable {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' attribute.
	 * The default value is <code>"0.5"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' attribute.
	 * @see #setReference(double)
	 * @see roqme.metamodel.kernel.KernelPackage#getBeliefVariable_Reference()
	 * @model default="0.5"
	 * @generated
	 */
	double getReference();

	/**
	 * Sets the value of the '{@link roqme.metamodel.kernel.BeliefVariable#getReference <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' attribute.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(double value);

	/**
	 * Returns the value of the '<em><b>Survival</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Survival</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Survival</em>' containment reference.
	 * @see #setSurvival(TimeValue)
	 * @see roqme.metamodel.kernel.KernelPackage#getBeliefVariable_Survival()
	 * @model containment="true"
	 * @generated
	 */
	TimeValue getSurvival();

	/**
	 * Sets the value of the '{@link roqme.metamodel.kernel.BeliefVariable#getSurvival <em>Survival</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Survival</em>' containment reference.
	 * @see #getSurvival()
	 * @generated
	 */
	void setSurvival(TimeValue value);

} // BeliefVariable
