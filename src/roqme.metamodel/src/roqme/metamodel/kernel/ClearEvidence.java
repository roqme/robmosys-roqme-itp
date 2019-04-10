/**
 */
package roqme.metamodel.kernel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Clear Evidence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.kernel.ClearEvidence#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.kernel.KernelPackage#getClearEvidence()
 * @model
 * @generated
 */
public interface ClearEvidence extends Action {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(BeliefVariable)
	 * @see roqme.metamodel.kernel.KernelPackage#getClearEvidence_Target()
	 * @model required="true"
	 * @generated
	 */
	BeliefVariable getTarget();

	/**
	 * Sets the value of the '{@link roqme.metamodel.kernel.ClearEvidence#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(BeliefVariable value);

} // ClearEvidence
