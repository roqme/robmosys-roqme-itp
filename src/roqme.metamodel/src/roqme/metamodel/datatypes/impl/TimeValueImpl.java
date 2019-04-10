/**
 */
package roqme.metamodel.datatypes.impl;

import org.eclipse.emf.ecore.EClass;

import roqme.metamodel.datatypes.DatatypesPackage;
import roqme.metamodel.datatypes.TimeValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TimeValueImpl extends UnitMeasuredValueImpl implements TimeValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatatypesPackage.Literals.TIME_VALUE;
	}

} //TimeValueImpl
