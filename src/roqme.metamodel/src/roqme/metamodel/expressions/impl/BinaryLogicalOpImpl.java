/**
 */
package roqme.metamodel.expressions.impl;

import org.eclipse.emf.ecore.EClass;

import roqme.metamodel.expressions.BinaryLogicalOp;
import roqme.metamodel.expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Logical Op</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class BinaryLogicalOpImpl extends BinaryTermOpImpl implements BinaryLogicalOp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryLogicalOpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.BINARY_LOGICAL_OP;
	}

} //BinaryLogicalOpImpl
