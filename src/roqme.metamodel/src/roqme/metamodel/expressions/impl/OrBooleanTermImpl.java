/**
 */
package roqme.metamodel.expressions.impl;

import org.eclipse.emf.ecore.EClass;

import roqme.metamodel.expressions.ExpressionsPackage;
import roqme.metamodel.expressions.OrBooleanTerm;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Or Boolean Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class OrBooleanTermImpl extends BinaryLogicalOpImpl implements OrBooleanTerm {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrBooleanTermImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.OR_BOOLEAN_TERM;
	}

} //OrBooleanTermImpl
