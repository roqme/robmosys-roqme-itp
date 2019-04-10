/**
 */
package roqme.metamodel.expressions.impl;

import org.eclipse.emf.ecore.EClass;

import roqme.metamodel.expressions.ExpressionsPackage;
import roqme.metamodel.expressions.NotBooleanTerm;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Not Boolean Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class NotBooleanTermImpl extends UnaryLogicalOpImpl implements NotBooleanTerm {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotBooleanTermImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.NOT_BOOLEAN_TERM;
	}

} //NotBooleanTermImpl
