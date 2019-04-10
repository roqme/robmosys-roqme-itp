/**
 */
package roqme.metamodel.expressions.impl;

import org.eclipse.emf.ecore.EClass;

import roqme.metamodel.expressions.ExpressionsPackage;
import roqme.metamodel.expressions.FunctionTerm;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class FunctionTermImpl extends NaryTermOpImpl implements FunctionTerm {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionTermImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.FUNCTION_TERM;
	}

} //FunctionTermImpl
