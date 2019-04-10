/**
 */
package roqme.metamodel.datatypes.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import roqme.metamodel.datatypes.DatatypesPackage;
import roqme.metamodel.datatypes.TypedValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class TypedValueImpl extends MinimalEObjectImpl.Container implements TypedValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypedValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatatypesPackage.Literals.TYPED_VALUE;
	}

} //TypedValueImpl
