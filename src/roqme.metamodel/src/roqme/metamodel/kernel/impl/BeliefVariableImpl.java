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
import roqme.metamodel.kernel.BeliefVariable;
import roqme.metamodel.kernel.KernelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Belief Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.kernel.impl.BeliefVariableImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link roqme.metamodel.kernel.impl.BeliefVariableImpl#getSurvival <em>Survival</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BeliefVariableImpl extends TypedVariableImpl implements BeliefVariable {
	/**
	 * The default value of the '{@link #getReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected static final double REFERENCE_EDEFAULT = 0.5;
	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected double reference = REFERENCE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getSurvival() <em>Survival</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSurvival()
	 * @generated
	 * @ordered
	 */
	protected TimeValue survival;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BeliefVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KernelPackage.Literals.BELIEF_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(double newReference) {
		double oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.BELIEF_VARIABLE__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeValue getSurvival() {
		return survival;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSurvival(TimeValue newSurvival, NotificationChain msgs) {
		TimeValue oldSurvival = survival;
		survival = newSurvival;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KernelPackage.BELIEF_VARIABLE__SURVIVAL, oldSurvival, newSurvival);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSurvival(TimeValue newSurvival) {
		if (newSurvival != survival) {
			NotificationChain msgs = null;
			if (survival != null)
				msgs = ((InternalEObject)survival).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KernelPackage.BELIEF_VARIABLE__SURVIVAL, null, msgs);
			if (newSurvival != null)
				msgs = ((InternalEObject)newSurvival).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KernelPackage.BELIEF_VARIABLE__SURVIVAL, null, msgs);
			msgs = basicSetSurvival(newSurvival, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.BELIEF_VARIABLE__SURVIVAL, newSurvival, newSurvival));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KernelPackage.BELIEF_VARIABLE__SURVIVAL:
				return basicSetSurvival(null, msgs);
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
			case KernelPackage.BELIEF_VARIABLE__REFERENCE:
				return getReference();
			case KernelPackage.BELIEF_VARIABLE__SURVIVAL:
				return getSurvival();
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
			case KernelPackage.BELIEF_VARIABLE__REFERENCE:
				setReference((Double)newValue);
				return;
			case KernelPackage.BELIEF_VARIABLE__SURVIVAL:
				setSurvival((TimeValue)newValue);
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
			case KernelPackage.BELIEF_VARIABLE__REFERENCE:
				setReference(REFERENCE_EDEFAULT);
				return;
			case KernelPackage.BELIEF_VARIABLE__SURVIVAL:
				setSurvival((TimeValue)null);
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
			case KernelPackage.BELIEF_VARIABLE__REFERENCE:
				return reference != REFERENCE_EDEFAULT;
			case KernelPackage.BELIEF_VARIABLE__SURVIVAL:
				return survival != null;
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
		result.append(" (reference: ");
		result.append(reference);
		result.append(')');
		return result.toString();
	}

} //BeliefVariableImpl
