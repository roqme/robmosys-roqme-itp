/**
 */
package roqme.metamodel.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Term Op</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.expressions.BinaryTermOp#getLeft <em>Left</em>}</li>
 *   <li>{@link roqme.metamodel.expressions.BinaryTermOp#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.expressions.ExpressionsPackage#getBinaryTermOp()
 * @model abstract="true"
 * @generated
 */
public interface BinaryTermOp extends Term {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(Term)
	 * @see roqme.metamodel.expressions.ExpressionsPackage#getBinaryTermOp_Left()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Term getLeft();

	/**
	 * Sets the value of the '{@link roqme.metamodel.expressions.BinaryTermOp#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Term value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(Term)
	 * @see roqme.metamodel.expressions.ExpressionsPackage#getBinaryTermOp_Right()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Term getRight();

	/**
	 * Sets the value of the '{@link roqme.metamodel.expressions.BinaryTermOp#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Term value);

} // BinaryTermOp
