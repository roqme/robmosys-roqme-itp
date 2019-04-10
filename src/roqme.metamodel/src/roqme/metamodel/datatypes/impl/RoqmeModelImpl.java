/**
 */
package roqme.metamodel.datatypes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import roqme.metamodel.datatypes.DataTypeDefinition;
import roqme.metamodel.datatypes.DatatypesPackage;
import roqme.metamodel.datatypes.RoqmeModel;
import roqme.metamodel.datatypes.Sentence;
import roqme.metamodel.datatypes.TypedVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Roqme Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.datatypes.impl.RoqmeModelImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link roqme.metamodel.datatypes.impl.RoqmeModelImpl#getDataTypes <em>Data Types</em>}</li>
 *   <li>{@link roqme.metamodel.datatypes.impl.RoqmeModelImpl#getSentences <em>Sentences</em>}</li>
 *   <li>{@link roqme.metamodel.datatypes.impl.RoqmeModelImpl#getVariables <em>Variables</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoqmeModelImpl extends DocumentableElementImpl implements RoqmeModel {
	/**
	 * The default value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected String namespace = NAMESPACE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDataTypes() <em>Data Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<DataTypeDefinition> dataTypes;

	/**
	 * The cached value of the '{@link #getSentences() <em>Sentences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSentences()
	 * @generated
	 * @ordered
	 */
	protected EList<Sentence> sentences;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedVariable> variables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoqmeModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatatypesPackage.Literals.ROQME_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespace(String newNamespace) {
		String oldNamespace = namespace;
		namespace = newNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.ROQME_MODEL__NAMESPACE, oldNamespace, namespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataTypeDefinition> getDataTypes() {
		if (dataTypes == null) {
			dataTypes = new EObjectContainmentEList<DataTypeDefinition>(DataTypeDefinition.class, this, DatatypesPackage.ROQME_MODEL__DATA_TYPES);
		}
		return dataTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Sentence> getSentences() {
		if (sentences == null) {
			sentences = new EObjectContainmentEList<Sentence>(Sentence.class, this, DatatypesPackage.ROQME_MODEL__SENTENCES);
		}
		return sentences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedVariable> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList<TypedVariable>(TypedVariable.class, this, DatatypesPackage.ROQME_MODEL__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DatatypesPackage.ROQME_MODEL__DATA_TYPES:
				return ((InternalEList<?>)getDataTypes()).basicRemove(otherEnd, msgs);
			case DatatypesPackage.ROQME_MODEL__SENTENCES:
				return ((InternalEList<?>)getSentences()).basicRemove(otherEnd, msgs);
			case DatatypesPackage.ROQME_MODEL__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
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
			case DatatypesPackage.ROQME_MODEL__NAMESPACE:
				return getNamespace();
			case DatatypesPackage.ROQME_MODEL__DATA_TYPES:
				return getDataTypes();
			case DatatypesPackage.ROQME_MODEL__SENTENCES:
				return getSentences();
			case DatatypesPackage.ROQME_MODEL__VARIABLES:
				return getVariables();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DatatypesPackage.ROQME_MODEL__NAMESPACE:
				setNamespace((String)newValue);
				return;
			case DatatypesPackage.ROQME_MODEL__DATA_TYPES:
				getDataTypes().clear();
				getDataTypes().addAll((Collection<? extends DataTypeDefinition>)newValue);
				return;
			case DatatypesPackage.ROQME_MODEL__SENTENCES:
				getSentences().clear();
				getSentences().addAll((Collection<? extends Sentence>)newValue);
				return;
			case DatatypesPackage.ROQME_MODEL__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends TypedVariable>)newValue);
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
			case DatatypesPackage.ROQME_MODEL__NAMESPACE:
				setNamespace(NAMESPACE_EDEFAULT);
				return;
			case DatatypesPackage.ROQME_MODEL__DATA_TYPES:
				getDataTypes().clear();
				return;
			case DatatypesPackage.ROQME_MODEL__SENTENCES:
				getSentences().clear();
				return;
			case DatatypesPackage.ROQME_MODEL__VARIABLES:
				getVariables().clear();
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
			case DatatypesPackage.ROQME_MODEL__NAMESPACE:
				return NAMESPACE_EDEFAULT == null ? namespace != null : !NAMESPACE_EDEFAULT.equals(namespace);
			case DatatypesPackage.ROQME_MODEL__DATA_TYPES:
				return dataTypes != null && !dataTypes.isEmpty();
			case DatatypesPackage.ROQME_MODEL__SENTENCES:
				return sentences != null && !sentences.isEmpty();
			case DatatypesPackage.ROQME_MODEL__VARIABLES:
				return variables != null && !variables.isEmpty();
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
		result.append(" (namespace: ");
		result.append(namespace);
		result.append(')');
		return result.toString();
	}

} //RoqmeModelImpl
