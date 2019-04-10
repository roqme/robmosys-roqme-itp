/**
 */
package roqme.metamodel.kernel.impl;

import org.eclipse.emf.ecore.EClass;

import roqme.metamodel.datatypes.impl.TypedVariableImpl;

import roqme.metamodel.kernel.KernelPackage;
import roqme.metamodel.kernel.Parameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ParameterImpl extends TypedVariableImpl implements Parameter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KernelPackage.Literals.PARAMETER;
	}

} //ParameterImpl
