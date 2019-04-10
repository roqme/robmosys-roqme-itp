/**
 */
package roqme.metamodel.expressions.impl;

import org.eclipse.emf.ecore.EClass;

import roqme.metamodel.expressions.ExpressionsPackage;
import roqme.metamodel.expressions.WhileTerm;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>While Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class WhileTermImpl extends BinaryPatternOpImpl implements WhileTerm {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WhileTermImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.WHILE_TERM;
	}

} //WhileTermImpl
