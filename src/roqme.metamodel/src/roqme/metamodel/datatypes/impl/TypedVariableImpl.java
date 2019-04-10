/**
 */
package roqme.metamodel.datatypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import roqme.metamodel.datatypes.DataTypeDeclaration;
import roqme.metamodel.datatypes.DatatypesPackage;
import roqme.metamodel.datatypes.TypedValue;
import roqme.metamodel.datatypes.TypedVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.datatypes.impl.TypedVariableImpl#getName <em>Name</em>}</li>
 *   <li>{@link roqme.metamodel.datatypes.impl.TypedVariableImpl#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link roqme.metamodel.datatypes.impl.TypedVariableImpl#getInitializedTo <em>Initialized To</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TypedVariableImpl extends DocumentableElementImpl implements TypedVariable {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDeclaration() <em>Declaration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaration()
	 * @generated
	 * @ordered
	 */
	protected DataTypeDeclaration declaration;

	/**
	 * The cached value of the '{@link #getInitializedTo() <em>Initialized To</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializedTo()
	 * @generated
	 * @ordered
	 */
	protected TypedValue initializedTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypedVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatatypesPackage.Literals.TYPED_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.TYPED_VARIABLE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeDeclaration getDeclaration() {
		return declaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaration(DataTypeDeclaration newDeclaration, NotificationChain msgs) {
		DataTypeDeclaration oldDeclaration = declaration;
		declaration = newDeclaration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DatatypesPackage.TYPED_VARIABLE__DECLARATION, oldDeclaration, newDeclaration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaration(DataTypeDeclaration newDeclaration) {
		if (newDeclaration != declaration) {
			NotificationChain msgs = null;
			if (declaration != null)
				msgs = ((InternalEObject)declaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DatatypesPackage.TYPED_VARIABLE__DECLARATION, null, msgs);
			if (newDeclaration != null)
				msgs = ((InternalEObject)newDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DatatypesPackage.TYPED_VARIABLE__DECLARATION, null, msgs);
			msgs = basicSetDeclaration(newDeclaration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.TYPED_VARIABLE__DECLARATION, newDeclaration, newDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedValue getInitializedTo() {
		return initializedTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitializedTo(TypedValue newInitializedTo, NotificationChain msgs) {
		TypedValue oldInitializedTo = initializedTo;
		initializedTo = newInitializedTo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DatatypesPackage.TYPED_VARIABLE__INITIALIZED_TO, oldInitializedTo, newInitializedTo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializedTo(TypedValue newInitializedTo) {
		if (newInitializedTo != initializedTo) {
			NotificationChain msgs = null;
			if (initializedTo != null)
				msgs = ((InternalEObject)initializedTo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DatatypesPackage.TYPED_VARIABLE__INITIALIZED_TO, null, msgs);
			if (newInitializedTo != null)
				msgs = ((InternalEObject)newInitializedTo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DatatypesPackage.TYPED_VARIABLE__INITIALIZED_TO, null, msgs);
			msgs = basicSetInitializedTo(newInitializedTo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.TYPED_VARIABLE__INITIALIZED_TO, newInitializedTo, newInitializedTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DatatypesPackage.TYPED_VARIABLE__DECLARATION:
				return basicSetDeclaration(null, msgs);
			case DatatypesPackage.TYPED_VARIABLE__INITIALIZED_TO:
				return basicSetInitializedTo(null, msgs);
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
			case DatatypesPackage.TYPED_VARIABLE__NAME:
				return getName();
			case DatatypesPackage.TYPED_VARIABLE__DECLARATION:
				return getDeclaration();
			case DatatypesPackage.TYPED_VARIABLE__INITIALIZED_TO:
				return getInitializedTo();
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
			case DatatypesPackage.TYPED_VARIABLE__NAME:
				setName((String)newValue);
				return;
			case DatatypesPackage.TYPED_VARIABLE__DECLARATION:
				setDeclaration((DataTypeDeclaration)newValue);
				return;
			case DatatypesPackage.TYPED_VARIABLE__INITIALIZED_TO:
				setInitializedTo((TypedValue)newValue);
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
			case DatatypesPackage.TYPED_VARIABLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DatatypesPackage.TYPED_VARIABLE__DECLARATION:
				setDeclaration((DataTypeDeclaration)null);
				return;
			case DatatypesPackage.TYPED_VARIABLE__INITIALIZED_TO:
				setInitializedTo((TypedValue)null);
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
			case DatatypesPackage.TYPED_VARIABLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DatatypesPackage.TYPED_VARIABLE__DECLARATION:
				return declaration != null;
			case DatatypesPackage.TYPED_VARIABLE__INITIALIZED_TO:
				return initializedTo != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //TypedVariableImpl
