/**
 */
package roqme.metamodel.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repeat Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.expressions.RepeatTerm#getNrep <em>Nrep</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.expressions.ExpressionsPackage#getRepeatTerm()
 * @model
 * @generated
 */
public interface RepeatTerm extends UnaryPatternOp {
	/**
	 * Returns the value of the '<em><b>Nrep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nrep</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nrep</em>' attribute.
	 * @see #setNrep(int)
	 * @see roqme.metamodel.expressions.ExpressionsPackage#getRepeatTerm_Nrep()
	 * @model required="true"
	 * @generated
	 */
	int getNrep();

	/**
	 * Sets the value of the '{@link roqme.metamodel.expressions.RepeatTerm#getNrep <em>Nrep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nrep</em>' attribute.
	 * @see #getNrep()
	 * @generated
	 */
	void setNrep(int value);

} // RepeatTerm
