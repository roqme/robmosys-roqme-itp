/**
 */
package roqme.metamodel.expressions.impl;

import org.eclipse.emf.ecore.EClass;

import roqme.metamodel.expressions.BinaryArithOp;
import roqme.metamodel.expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Arith Op</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class BinaryArithOpImpl extends BinaryTermOpImpl implements BinaryArithOp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryArithOpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.BINARY_ARITH_OP;
	}

} //BinaryArithOpImpl
