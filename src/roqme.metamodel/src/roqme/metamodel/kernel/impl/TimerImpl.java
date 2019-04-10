/**
 */
package roqme.metamodel.kernel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import roqme.metamodel.datatypes.TimeValue;

import roqme.metamodel.datatypes.impl.TypedVariableImpl;

import roqme.metamodel.expressions.GeneralExpression;

import roqme.metamodel.kernel.KernelPackage;
import roqme.metamodel.kernel.Timer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Timer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.kernel.impl.TimerImpl#isOnce <em>Once</em>}</li>
 *   <li>{@link roqme.metamodel.kernel.impl.TimerImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link roqme.metamodel.kernel.impl.TimerImpl#getOffset <em>Offset</em>}</li>
 *   <li>{@link roqme.metamodel.kernel.impl.TimerImpl#isPaused <em>Paused</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimerImpl extends TypedVariableImpl implements Timer {
	/**
	 * The default value of the '{@link #isOnce() <em>Once</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOnce()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ONCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOnce() <em>Once</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOnce()
	 * @generated
	 * @ordered
	 */
	protected boolean once = ONCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefinition() <em>Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected GeneralExpression definition;

	/**
	 * The cached value of the '{@link #getOffset() <em>Offset</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected TimeValue offset;

	/**
	 * The default value of the '{@link #isPaused() <em>Paused</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPaused()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PAUSED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPaused() <em>Paused</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPaused()
	 * @generated
	 * @ordered
	 */
	protected boolean paused = PAUSED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KernelPackage.Literals.TIMER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOnce() {
		return once;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnce(boolean newOnce) {
		boolean oldOnce = once;
		once = newOnce;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.TIMER__ONCE, oldOnce, once));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralExpression getDefinition() {
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefinition(GeneralExpression newDefinition, NotificationChain msgs) {
		GeneralExpression oldDefinition = definition;
		definition = newDefinition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KernelPackage.TIMER__DEFINITION, oldDefinition, newDefinition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinition(GeneralExpression newDefinition) {
		if (newDefinition != definition) {
			NotificationChain msgs = null;
			if (definition != null)
				msgs = ((InternalEObject)definition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KernelPackage.TIMER__DEFINITION, null, msgs);
			if (newDefinition != null)
				msgs = ((InternalEObject)newDefinition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KernelPackage.TIMER__DEFINITION, null, msgs);
			msgs = basicSetDefinition(newDefinition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.TIMER__DEFINITION, newDefinition, newDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeValue getOffset() {
		return offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOffset(TimeValue newOffset, NotificationChain msgs) {
		TimeValue oldOffset = offset;
		offset = newOffset;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KernelPackage.TIMER__OFFSET, oldOffset, newOffset);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOffset(TimeValue newOffset) {
		if (newOffset != offset) {
			NotificationChain msgs = null;
			if (offset != null)
				msgs = ((InternalEObject)offset).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KernelPackage.TIMER__OFFSET, null, msgs);
			if (newOffset != null)
				msgs = ((InternalEObject)newOffset).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KernelPackage.TIMER__OFFSET, null, msgs);
			msgs = basicSetOffset(newOffset, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.TIMER__OFFSET, newOffset, newOffset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPaused() {
		return paused;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPaused(boolean newPaused) {
		boolean oldPaused = paused;
		paused = newPaused;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.TIMER__PAUSED, oldPaused, paused));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KernelPackage.TIMER__DEFINITION:
				return basicSetDefinition(null, msgs);
			case KernelPackage.TIMER__OFFSET:
				return basicSetOffset(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KernelPackage.TIMER__ONCE:
				return isOnce();
			case KernelPackage.TIMER__DEFINITION:
				return getDefinition();
			case KernelPackage.TIMER__OFFSET:
				return getOffset();
			case KernelPackage.TIMER__PAUSED:
				return isPaused();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KernelPackage.TIMER__ONCE:
				setOnce((Boolean)newValue);
				return;
			case KernelPackage.TIMER__DEFINITION:
				setDefinition((GeneralExpression)newValue);
				return;
			case KernelPackage.TIMER__OFFSET:
				setOffset((TimeValue)newValue);
				return;
			case KernelPackage.TIMER__PAUSED:
				setPaused((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case KernelPackage.TIMER__ONCE:
				setOnce(ONCE_EDEFAULT);
				return;
			case KernelPackage.TIMER__DEFINITION:
				setDefinition((GeneralExpression)null);
				return;
			case KernelPackage.TIMER__OFFSET:
				setOffset((TimeValue)null);
				return;
			case KernelPackage.TIMER__PAUSED:
				setPaused(PAUSED_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KernelPackage.TIMER__ONCE:
				return once != ONCE_EDEFAULT;
			case KernelPackage.TIMER__DEFINITION:
				return definition != null;
			case KernelPackage.TIMER__OFFSET:
				return offset != null;
			case KernelPackage.TIMER__PAUSED:
				return paused != PAUSED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (once: ");
		result.append(once);
		result.append(", paused: ");
		result.append(paused);
		result.append(')');
		return result.toString();
	}

} //TimerImpl
