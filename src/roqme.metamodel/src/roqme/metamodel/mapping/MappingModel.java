/**
 */
package roqme.metamodel.mapping;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.mapping.MappingModel#getMonitors <em>Monitors</em>}</li>
 *   <li>{@link roqme.metamodel.mapping.MappingModel#getImports <em>Imports</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.mapping.MappingPackage#getMappingModel()
 * @model
 * @generated
 */
public interface MappingModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Monitors</b></em>' containment reference list.
	 * The list contents are of type {@link roqme.metamodel.mapping.Monitor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Monitors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Monitors</em>' containment reference list.
	 * @see roqme.metamodel.mapping.MappingPackage#getMappingModel_Monitors()
	 * @model containment="true"
	 * @generated
	 */
	EList<Monitor> getMonitors();

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link roqme.metamodel.mapping.Import}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see roqme.metamodel.mapping.MappingPackage#getMappingModel_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<Import> getImports();

} // MappingModel
