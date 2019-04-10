/**
 */
package roqme.metamodel.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Term Op</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.expressions.UnaryTermOp#getTerm <em>Term</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.expressions.ExpressionsPackage#getUnaryTermOp()
 * @model abstract="true"
 * @generated
 */
public interface UnaryTermOp extends Term {
	/**
	 * Returns the value of the '<em><b>Term</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Term</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Term</em>' containment reference.
	 * @see #setTerm(Term)
	 * @see roqme.metamodel.expressions.ExpressionsPackage#getUnaryTermOp_Term()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Term getTerm();

	/**
	 * Sets the value of the '{@link roqme.metamodel.expressions.UnaryTermOp#getTerm <em>Term</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Term</em>' containment reference.
	 * @see #getTerm()
	 * @generated
	 */
	void setTerm(Term value);

} // UnaryTermOp
