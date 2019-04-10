/**
 */
package roqme.metamodel.kernel.impl;

import org.eclipse.emf.ecore.EClass;

import roqme.metamodel.datatypes.impl.TypedVariableImpl;

import roqme.metamodel.kernel.Context;
import roqme.metamodel.kernel.KernelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ContextImpl extends TypedVariableImpl implements Context {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KernelPackage.Literals.CONTEXT;
	}

} //ContextImpl
