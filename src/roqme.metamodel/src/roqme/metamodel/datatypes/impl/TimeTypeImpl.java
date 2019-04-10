/**
 */
package roqme.metamodel.datatypes.impl;

import org.eclipse.emf.ecore.EClass;

import roqme.metamodel.datatypes.DatatypesPackage;
import roqme.metamodel.datatypes.TimeType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TimeTypeImpl extends UnitMeasuredTypeImpl implements TimeType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeTypeImpl() {
		super();
		this.unit = "seconds"; // Needs to be added manually
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatatypesPackage.Literals.TIME_TYPE;
	}

} //TimeTypeImpl
