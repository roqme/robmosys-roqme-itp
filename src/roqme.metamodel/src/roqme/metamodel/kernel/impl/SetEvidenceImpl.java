/**
 */
package roqme.metamodel.kernel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import roqme.metamodel.datatypes.TimeValue;

import roqme.metamodel.expressions.GeneralExpression;

import roqme.metamodel.kernel.BeliefVariable;
import roqme.metamodel.kernel.InfluenceEnum;
import roqme.metamodel.kernel.KernelPackage;
import roqme.metamodel.kernel.SetEvidence;
import roqme.metamodel.kernel.StrengthEnum;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Evidence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.kernel.impl.SetEvidenceImpl#getInfluence <em>Influence</em>}</li>
 *   <li>{@link roqme.metamodel.kernel.impl.SetEvidenceImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link roqme.metamodel.kernel.impl.SetEvidenceImpl#getStrength <em>Strength</em>}</li>
 *   <li>{@link roqme.metamodel.kernel.impl.SetEvidenceImpl#getSurvival <em>Survival</em>}</li>
 *   <li>{@link roqme.metamodel.kernel.impl.SetEvidenceImpl#getConditionedBy <em>Conditioned By</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SetEvidenceImpl extends ActionImpl implements SetEvidence {
	/**
	 * The default value of the '{@link #getInfluence() <em>Influence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfluence()
	 * @generated
	 * @ordered
	 */
	protected static final InfluenceEnum INFLUENCE_EDEFAULT = InfluenceEnum.REINFORCE;

	/**
	 * The cached value of the '{@link #getInfluence() <em>Influence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfluence()
	 * @generated
	 * @ordered
	 */
	protected InfluenceEnum influence = INFLUENCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected BeliefVariable target;

	/**
	 * The default value of the '{@link #getStrength() <em>Strength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrength()
	 * @generated
	 * @ordered
	 */
	protected static final StrengthEnum STRENGTH_EDEFAULT = StrengthEnum.MEDIUM;

	/**
	 * The cached value of the '{@link #getStrength() <em>Strength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrength()
	 * @generated
	 * @ordered
	 */
	protected StrengthEnum strength = STRENGTH_EDEFAULT;

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
	 * The cached value of the '{@link #getConditionedBy() <em>Conditioned By</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionedBy()
	 * @generated
	 * @ordered
	 */
	protected GeneralExpression conditionedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetEvidenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KernelPackage.Literals.SET_EVIDENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfluenceEnum getInfluence() {
		return influence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfluence(InfluenceEnum newInfluence) {
		InfluenceEnum oldInfluence = influence;
		influence = newInfluence == null ? INFLUENCE_EDEFAULT : newInfluence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.SET_EVIDENCE__INFLUENCE, oldInfluence, influence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeliefVariable getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (BeliefVariable)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KernelPackage.SET_EVIDENCE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeliefVariable basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(BeliefVariable newTarget) {
		BeliefVariable oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.SET_EVIDENCE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrengthEnum getStrength() {
		return strength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStrength(StrengthEnum newStrength) {
		StrengthEnum oldStrength = strength;
		strength = newStrength == null ? STRENGTH_EDEFAULT : newStrength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.SET_EVIDENCE__STRENGTH, oldStrength, strength));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KernelPackage.SET_EVIDENCE__SURVIVAL, oldSurvival, newSurvival);
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
				msgs = ((InternalEObject)survival).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KernelPackage.SET_EVIDENCE__SURVIVAL, null, msgs);
			if (newSurvival != null)
				msgs = ((InternalEObject)newSurvival).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KernelPackage.SET_EVIDENCE__SURVIVAL, null, msgs);
			msgs = basicSetSurvival(newSurvival, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.SET_EVIDENCE__SURVIVAL, newSurvival, newSurvival));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralExpression getConditionedBy() {
		return conditionedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConditionedBy(GeneralExpression newConditionedBy, NotificationChain msgs) {
		GeneralExpression oldConditionedBy = conditionedBy;
		conditionedBy = newConditionedBy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KernelPackage.SET_EVIDENCE__CONDITIONED_BY, oldConditionedBy, newConditionedBy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConditionedBy(GeneralExpression newConditionedBy) {
		if (newConditionedBy != conditionedBy) {
			NotificationChain msgs = null;
			if (conditionedBy != null)
				msgs = ((InternalEObject)conditionedBy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KernelPackage.SET_EVIDENCE__CONDITIONED_BY, null, msgs);
			if (newConditionedBy != null)
				msgs = ((InternalEObject)newConditionedBy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KernelPackage.SET_EVIDENCE__CONDITIONED_BY, null, msgs);
			msgs = basicSetConditionedBy(newConditionedBy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.SET_EVIDENCE__CONDITIONED_BY, newConditionedBy, newConditionedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KernelPackage.SET_EVIDENCE__SURVIVAL:
				return basicSetSurvival(null, msgs);
			case KernelPackage.SET_EVIDENCE__CONDITIONED_BY:
				return basicSetConditionedBy(null, msgs);
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
			case KernelPackage.SET_EVIDENCE__INFLUENCE:
				return getInfluence();
			case KernelPackage.SET_EVIDENCE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case KernelPackage.SET_EVIDENCE__STRENGTH:
				return getStrength();
			case KernelPackage.SET_EVIDENCE__SURVIVAL:
				return getSurvival();
			case KernelPackage.SET_EVIDENCE__CONDITIONED_BY:
				return getConditionedBy();
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
			case KernelPackage.SET_EVIDENCE__INFLUENCE:
				setInfluence((InfluenceEnum)newValue);
				return;
			case KernelPackage.SET_EVIDENCE__TARGET:
				setTarget((BeliefVariable)newValue);
				return;
			case KernelPackage.SET_EVIDENCE__STRENGTH:
				setStrength((StrengthEnum)newValue);
				return;
			case KernelPackage.SET_EVIDENCE__SURVIVAL:
				setSurvival((TimeValue)newValue);
				return;
			case KernelPackage.SET_EVIDENCE__CONDITIONED_BY:
				setConditionedBy((GeneralExpression)newValue);
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
			case KernelPackage.SET_EVIDENCE__INFLUENCE:
				setInfluence(INFLUENCE_EDEFAULT);
				return;
			case KernelPackage.SET_EVIDENCE__TARGET:
				setTarget((BeliefVariable)null);
				return;
			case KernelPackage.SET_EVIDENCE__STRENGTH:
				setStrength(STRENGTH_EDEFAULT);
				return;
			case KernelPackage.SET_EVIDENCE__SURVIVAL:
				setSurvival((TimeValue)null);
				return;
			case KernelPackage.SET_EVIDENCE__CONDITIONED_BY:
				setConditionedBy((GeneralExpression)null);
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
			case KernelPackage.SET_EVIDENCE__INFLUENCE:
				return influence != INFLUENCE_EDEFAULT;
			case KernelPackage.SET_EVIDENCE__TARGET:
				return target != null;
			case KernelPackage.SET_EVIDENCE__STRENGTH:
				return strength != STRENGTH_EDEFAULT;
			case KernelPackage.SET_EVIDENCE__SURVIVAL:
				return survival != null;
			case KernelPackage.SET_EVIDENCE__CONDITIONED_BY:
				return conditionedBy != null;
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
		result.append(" (influence: ");
		result.append(influence);
		result.append(", strength: ");
		result.append(strength);
		result.append(')');
		return result.toString();
	}

} //SetEvidenceImpl
