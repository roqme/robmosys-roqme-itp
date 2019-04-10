/**
 */
package roqme.metamodel.kernel;

import roqme.metamodel.expressions.OutputTransformation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.kernel.Property#getTransformation <em>Transformation</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.kernel.KernelPackage#getProperty()
 * @model
 * @generated
 */
public interface Property extends BeliefVariable {
	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' containment reference.
	 * @see #setTransformation(OutputTransformation)
	 * @see roqme.metamodel.kernel.KernelPackage#getProperty_Transformation()
	 * @model containment="true"
	 * @generated
	 */
	OutputTransformation getTransformation();

	/**
	 * Sets the value of the '{@link roqme.metamodel.kernel.Property#getTransformation <em>Transformation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' containment reference.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(OutputTransformation value);

} // Property
