/**
 */
package roqme.metamodel.datatypes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Roqme Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.datatypes.RoqmeModel#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link roqme.metamodel.datatypes.RoqmeModel#getDataTypes <em>Data Types</em>}</li>
 *   <li>{@link roqme.metamodel.datatypes.RoqmeModel#getSentences <em>Sentences</em>}</li>
 *   <li>{@link roqme.metamodel.datatypes.RoqmeModel#getVariables <em>Variables</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.datatypes.DatatypesPackage#getRoqmeModel()
 * @model
 * @generated
 */
public interface RoqmeModel extends DocumentableElement {
	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' attribute.
	 * @see #setNamespace(String)
	 * @see roqme.metamodel.datatypes.DatatypesPackage#getRoqmeModel_Namespace()
	 * @model
	 * @generated
	 */
	String getNamespace();

	/**
	 * Sets the value of the '{@link roqme.metamodel.datatypes.RoqmeModel#getNamespace <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' attribute.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(String value);

	/**
	 * Returns the value of the '<em><b>Data Types</b></em>' containment reference list.
	 * The list contents are of type {@link roqme.metamodel.datatypes.DataTypeDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Types</em>' containment reference list.
	 * @see roqme.metamodel.datatypes.DatatypesPackage#getRoqmeModel_DataTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataTypeDefinition> getDataTypes();

	/**
	 * Returns the value of the '<em><b>Sentences</b></em>' containment reference list.
	 * The list contents are of type {@link roqme.metamodel.datatypes.Sentence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sentences</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sentences</em>' containment reference list.
	 * @see roqme.metamodel.datatypes.DatatypesPackage#getRoqmeModel_Sentences()
	 * @model containment="true"
	 * @generated
	 */
	EList<Sentence> getSentences();

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link roqme.metamodel.datatypes.TypedVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see roqme.metamodel.datatypes.DatatypesPackage#getRoqmeModel_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypedVariable> getVariables();

} // RoqmeModel
