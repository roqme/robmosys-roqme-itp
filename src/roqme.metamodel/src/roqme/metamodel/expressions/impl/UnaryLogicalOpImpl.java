/**
 */
package roqme.metamodel.expressions.impl;

import org.eclipse.emf.ecore.EClass;

import roqme.metamodel.expressions.ExpressionsPackage;
import roqme.metamodel.expressions.UnaryLogicalOp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unary Logical Op</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class UnaryLogicalOpImpl extends UnaryTermOpImpl implements UnaryLogicalOp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnaryLogicalOpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.UNARY_LOGICAL_OP;
	}

} //UnaryLogicalOpImpl
