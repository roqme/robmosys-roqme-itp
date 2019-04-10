/**
 */
package roqme.metamodel.expressions.impl;

import org.eclipse.emf.ecore.EClass;

import roqme.metamodel.expressions.ExpressionsPackage;
import roqme.metamodel.expressions.MultTerm;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mult Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MultTermImpl extends BinaryArithOpImpl implements MultTerm {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultTermImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.MULT_TERM;
	}

} //MultTermImpl
