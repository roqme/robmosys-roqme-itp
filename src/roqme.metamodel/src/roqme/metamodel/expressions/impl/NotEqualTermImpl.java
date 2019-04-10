/**
 */
package roqme.metamodel.expressions.impl;

import org.eclipse.emf.ecore.EClass;

import roqme.metamodel.expressions.ExpressionsPackage;
import roqme.metamodel.expressions.NotEqualTerm;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Not Equal Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class NotEqualTermImpl extends BinaryRelationalOpImpl implements NotEqualTerm {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotEqualTermImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.NOT_EQUAL_TERM;
	}

} //NotEqualTermImpl
