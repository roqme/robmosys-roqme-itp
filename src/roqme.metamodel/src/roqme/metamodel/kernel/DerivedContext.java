/**
 */
package roqme.metamodel.kernel;

import roqme.metamodel.expressions.ContextPattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Derived Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.kernel.DerivedContext#getDefinition <em>Definition</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.kernel.KernelPackage#getDerivedContext()
 * @model
 * @generated
 */
public interface DerivedContext extends Context {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' containment reference.
	 * @see #setDefinition(ContextPattern)
	 * @see roqme.metamodel.kernel.KernelPackage#getDerivedContext_Definition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ContextPattern getDefinition();

	/**
	 * Sets the value of the '{@link roqme.metamodel.kernel.DerivedContext#getDefinition <em>Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' containment reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(ContextPattern value);

} // DerivedContext
