/**
 */
package roqme.metamodel.kernel;

import roqme.metamodel.datatypes.TimeValue;

import roqme.metamodel.expressions.GeneralExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Evidence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.kernel.SetEvidence#getInfluence <em>Influence</em>}</li>
 *   <li>{@link roqme.metamodel.kernel.SetEvidence#getTarget <em>Target</em>}</li>
 *   <li>{@link roqme.metamodel.kernel.SetEvidence#getStrength <em>Strength</em>}</li>
 *   <li>{@link roqme.metamodel.kernel.SetEvidence#getSurvival <em>Survival</em>}</li>
 *   <li>{@link roqme.metamodel.kernel.SetEvidence#getConditionedBy <em>Conditioned By</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.kernel.KernelPackage#getSetEvidence()
 * @model
 * @generated
 */
public interface SetEvidence extends Action {
	/**
	 * Returns the value of the '<em><b>Influence</b></em>' attribute.
	 * The literals are from the enumeration {@link roqme.metamodel.kernel.InfluenceEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Influence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Influence</em>' attribute.
	 * @see roqme.metamodel.kernel.InfluenceEnum
	 * @see #setInfluence(InfluenceEnum)
	 * @see roqme.metamodel.kernel.KernelPackage#getSetEvidence_Influence()
	 * @model required="true"
	 * @generated
	 */
	InfluenceEnum getInfluence();

	/**
	 * Sets the value of the '{@link roqme.metamodel.kernel.SetEvidence#getInfluence <em>Influence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Influence</em>' attribute.
	 * @see roqme.metamodel.kernel.InfluenceEnum
	 * @see #getInfluence()
	 * @generated
	 */
	void setInfluence(InfluenceEnum value);

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
	 * @see roqme.metamodel.kernel.KernelPackage#getSetEvidence_Target()
	 * @model required="true"
	 * @generated
	 */
	BeliefVariable getTarget();

	/**
	 * Sets the value of the '{@link roqme.metamodel.kernel.SetEvidence#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(BeliefVariable value);

	/**
	 * Returns the value of the '<em><b>Strength</b></em>' attribute.
	 * The default value is <code>"MEDIUM"</code>.
	 * The literals are from the enumeration {@link roqme.metamodel.kernel.StrengthEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strength</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strength</em>' attribute.
	 * @see roqme.metamodel.kernel.StrengthEnum
	 * @see #setStrength(StrengthEnum)
	 * @see roqme.metamodel.kernel.KernelPackage#getSetEvidence_Strength()
	 * @model default="MEDIUM" required="true"
	 * @generated
	 */
	StrengthEnum getStrength();

	/**
	 * Sets the value of the '{@link roqme.metamodel.kernel.SetEvidence#getStrength <em>Strength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strength</em>' attribute.
	 * @see roqme.metamodel.kernel.StrengthEnum
	 * @see #getStrength()
	 * @generated
	 */
	void setStrength(StrengthEnum value);

	/**
	 * Returns the value of the '<em><b>Survival</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Survival</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Survival</em>' containment reference.
	 * @see #setSurvival(TimeValue)
	 * @see roqme.metamodel.kernel.KernelPackage#getSetEvidence_Survival()
	 * @model containment="true"
	 * @generated
	 */
	TimeValue getSurvival();

	/**
	 * Sets the value of the '{@link roqme.metamodel.kernel.SetEvidence#getSurvival <em>Survival</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Survival</em>' containment reference.
	 * @see #getSurvival()
	 * @generated
	 */
	void setSurvival(TimeValue value);

	/**
	 * Returns the value of the '<em><b>Conditioned By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conditioned By</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditioned By</em>' containment reference.
	 * @see #setConditionedBy(GeneralExpression)
	 * @see roqme.metamodel.kernel.KernelPackage#getSetEvidence_ConditionedBy()
	 * @model containment="true"
	 * @generated
	 */
	GeneralExpression getConditionedBy();

	/**
	 * Sets the value of the '{@link roqme.metamodel.kernel.SetEvidence#getConditionedBy <em>Conditioned By</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conditioned By</em>' containment reference.
	 * @see #getConditionedBy()
	 * @generated
	 */
	void setConditionedBy(GeneralExpression value);

} // SetEvidence
