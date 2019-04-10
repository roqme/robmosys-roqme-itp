/**
 */
package roqme.metamodel.expressions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nary Term Op</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.expressions.NaryTermOp#getTerms <em>Terms</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.expressions.ExpressionsPackage#getNaryTermOp()
 * @model abstract="true"
 * @generated
 */
public interface NaryTermOp extends Term {
	/**
	 * Returns the value of the '<em><b>Terms</b></em>' containment reference list.
	 * The list contents are of type {@link roqme.metamodel.expressions.Term}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Terms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terms</em>' containment reference list.
	 * @see roqme.metamodel.expressions.ExpressionsPackage#getNaryTermOp_Terms()
	 * @model containment="true"
	 * @generated
	 */
	EList<Term> getTerms();

} // NaryTermOp
