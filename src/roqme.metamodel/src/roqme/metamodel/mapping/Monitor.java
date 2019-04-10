/**
 */
package roqme.metamodel.mapping;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.ecore.service.serviceDefinition.CommunicationServiceDefinition;

import roqme.metamodel.kernel.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Monitor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.mapping.Monitor#getContext <em>Context</em>}</li>
 *   <li>{@link roqme.metamodel.mapping.Monitor#getService <em>Service</em>}</li>
 *   <li>{@link roqme.metamodel.mapping.Monitor#getOpts <em>Opts</em>}</li>
 *   <li>{@link roqme.metamodel.mapping.Monitor#getSource <em>Source</em>}</li>
 *   <li>{@link roqme.metamodel.mapping.Monitor#getSourceType <em>Source Type</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.mapping.MappingPackage#getMonitor()
 * @model
 * @generated
 */
public interface Monitor extends EObject {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(Context)
	 * @see roqme.metamodel.mapping.MappingPackage#getMonitor_Context()
	 * @model required="true"
	 * @generated
	 */
	Context getContext();

	/**
	 * Sets the value of the '{@link roqme.metamodel.mapping.Monitor#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(Context value);

	/**
	 * Returns the value of the '<em><b>Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service</em>' reference.
	 * @see #setService(CommunicationServiceDefinition)
	 * @see roqme.metamodel.mapping.MappingPackage#getMonitor_Service()
	 * @model required="true"
	 * @generated
	 */
	CommunicationServiceDefinition getService();

	/**
	 * Sets the value of the '{@link roqme.metamodel.mapping.Monitor#getService <em>Service</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service</em>' reference.
	 * @see #getService()
	 * @generated
	 */
	void setService(CommunicationServiceDefinition value);

	/**
	 * Returns the value of the '<em><b>Opts</b></em>' containment reference list.
	 * The list contents are of type {@link roqme.metamodel.mapping.ConfigOpt}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opts</em>' containment reference list.
	 * @see roqme.metamodel.mapping.MappingPackage#getMonitor_Opts()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConfigOpt> getOpts();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see roqme.metamodel.mapping.MappingPackage#getMonitor_Source()
	 * @model required="true"
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link roqme.metamodel.mapping.Monitor#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

	/**
	 * Returns the value of the '<em><b>Source Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Type</em>' attribute.
	 * @see #setSourceType(String)
	 * @see roqme.metamodel.mapping.MappingPackage#getMonitor_SourceType()
	 * @model required="true"
	 * @generated
	 */
	String getSourceType();

	/**
	 * Sets the value of the '{@link roqme.metamodel.mapping.Monitor#getSourceType <em>Source Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Type</em>' attribute.
	 * @see #getSourceType()
	 * @generated
	 */
	void setSourceType(String value);

} // Monitor
