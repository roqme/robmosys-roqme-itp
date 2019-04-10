/**
 */
package roqme.metamodel.kernel;

import roqme.metamodel.datatypes.TimeValue;
import roqme.metamodel.datatypes.TypedVariable;

import roqme.metamodel.expressions.GeneralExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.kernel.Timer#isOnce <em>Once</em>}</li>
 *   <li>{@link roqme.metamodel.kernel.Timer#getDefinition <em>Definition</em>}</li>
 *   <li>{@link roqme.metamodel.kernel.Timer#getOffset <em>Offset</em>}</li>
 *   <li>{@link roqme.metamodel.kernel.Timer#isPaused <em>Paused</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.kernel.KernelPackage#getTimer()
 * @model
 * @generated
 */
public interface Timer extends TypedVariable {
	/**
	 * Returns the value of the '<em><b>Once</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Once</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Once</em>' attribute.
	 * @see #setOnce(boolean)
	 * @see roqme.metamodel.kernel.KernelPackage#getTimer_Once()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isOnce();

	/**
	 * Sets the value of the '{@link roqme.metamodel.kernel.Timer#isOnce <em>Once</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Once</em>' attribute.
	 * @see #isOnce()
	 * @generated
	 */
	void setOnce(boolean value);

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
	 * @see roqme.metamodel.kernel.KernelPackage#getTimer_Definition()
	 * @model containment="true"
	 * @generated
	 */
	GeneralExpression getDefinition();

	/**
	 * Sets the value of the '{@link roqme.metamodel.kernel.Timer#getDefinition <em>Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' containment reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(GeneralExpression value);

	/**
	 * Returns the value of the '<em><b>Offset</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' containment reference.
	 * @see #setOffset(TimeValue)
	 * @see roqme.metamodel.kernel.KernelPackage#getTimer_Offset()
	 * @model containment="true"
	 * @generated
	 */
	TimeValue getOffset();

	/**
	 * Sets the value of the '{@link roqme.metamodel.kernel.Timer#getOffset <em>Offset</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' containment reference.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(TimeValue value);

	/**
	 * Returns the value of the '<em><b>Paused</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Paused</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Paused</em>' attribute.
	 * @see #setPaused(boolean)
	 * @see roqme.metamodel.kernel.KernelPackage#getTimer_Paused()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isPaused();

	/**
	 * Sets the value of the '{@link roqme.metamodel.kernel.Timer#isPaused <em>Paused</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Paused</em>' attribute.
	 * @see #isPaused()
	 * @generated
	 */
	void setPaused(boolean value);

} // Timer
