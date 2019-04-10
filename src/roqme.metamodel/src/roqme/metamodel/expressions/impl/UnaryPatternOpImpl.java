/**
 */
package roqme.metamodel.expressions.impl;

import org.eclipse.emf.ecore.EClass;

import roqme.metamodel.expressions.ExpressionsPackage;
import roqme.metamodel.expressions.UnaryPatternOp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unary Pattern Op</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class UnaryPatternOpImpl extends UnaryTermOpImpl implements UnaryPatternOp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnaryPatternOpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.UNARY_PATTERN_OP;
	}

} //UnaryPatternOpImpl
