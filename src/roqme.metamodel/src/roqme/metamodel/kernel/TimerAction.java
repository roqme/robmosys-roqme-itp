/**
 */
package roqme.metamodel.kernel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timer Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.kernel.TimerAction#getTimer <em>Timer</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.kernel.KernelPackage#getTimerAction()
 * @model abstract="true"
 * @generated
 */
public interface TimerAction extends Action {
	/**
	 * Returns the value of the '<em><b>Timer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timer</em>' reference.
	 * @see #setTimer(Timer)
	 * @see roqme.metamodel.kernel.KernelPackage#getTimerAction_Timer()
	 * @model required="true"
	 * @generated
	 */
	Timer getTimer();

	/**
	 * Sets the value of the '{@link roqme.metamodel.kernel.TimerAction#getTimer <em>Timer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timer</em>' reference.
	 * @see #getTimer()
	 * @generated
	 */
	void setTimer(Timer value);

} // TimerAction
