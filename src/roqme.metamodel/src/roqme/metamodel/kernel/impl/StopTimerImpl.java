/**
 */
package roqme.metamodel.kernel.impl;

import org.eclipse.emf.ecore.EClass;

import roqme.metamodel.kernel.KernelPackage;
import roqme.metamodel.kernel.StopTimer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stop Timer</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class StopTimerImpl extends TimerActionImpl implements StopTimer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StopTimerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KernelPackage.Literals.STOP_TIMER;
	}

} //StopTimerImpl
