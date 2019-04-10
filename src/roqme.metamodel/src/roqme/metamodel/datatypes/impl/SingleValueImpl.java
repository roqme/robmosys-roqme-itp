/**
 */
package roqme.metamodel.datatypes.impl;

import org.eclipse.emf.ecore.EClass;

import roqme.metamodel.datatypes.DatatypesPackage;
import roqme.metamodel.datatypes.SingleValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class SingleValueImpl extends TypedValueImpl implements SingleValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingleValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatatypesPackage.Literals.SINGLE_VALUE;
	}

} //SingleValueImpl
