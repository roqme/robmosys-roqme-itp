/**
 */
package roqme.metamodel.kernel;

import org.eclipse.emf.common.util.EList;

import roqme.metamodel.datatypes.Sentence;

import roqme.metamodel.expressions.ContextPattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Observation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.kernel.Observation#getName <em>Name</em>}</li>
 *   <li>{@link roqme.metamodel.kernel.Observation#getPattern <em>Pattern</em>}</li>
 *   <li>{@link roqme.metamodel.kernel.Observation#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.kernel.KernelPackage#getObservation()
 * @model
 * @generated
 */
public interface Observation extends Sentence {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see roqme.metamodel.kernel.KernelPackage#getObservation_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link roqme.metamodel.kernel.Observation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' containment reference.
	 * @see #setPattern(ContextPattern)
	 * @see roqme.metamodel.kernel.KernelPackage#getObservation_Pattern()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ContextPattern getPattern();

	/**
	 * Sets the value of the '{@link roqme.metamodel.kernel.Observation#getPattern <em>Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' containment reference.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(ContextPattern value);

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link roqme.metamodel.kernel.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see roqme.metamodel.kernel.KernelPackage#getObservation_Actions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Action> getActions();

} // Observation
