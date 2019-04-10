/**
 */
package roqme.metamodel.expressions.impl;

import org.eclipse.emf.ecore.EClass;

import roqme.metamodel.expressions.BinaryRelationalOp;
import roqme.metamodel.expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Relational Op</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class BinaryRelationalOpImpl extends BinaryTermOpImpl implements BinaryRelationalOp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryRelationalOpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.BINARY_RELATIONAL_OP;
	}

} //BinaryRelationalOpImpl
