/**
 */
package roqme.metamodel.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arith Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.expressions.ArithFunction#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.expressions.ExpressionsPackage#getArithFunction()
 * @model
 * @generated
 */
public interface ArithFunction extends FunctionTerm {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The literals are from the enumeration {@link roqme.metamodel.expressions.ArithFtnEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see roqme.metamodel.expressions.ArithFtnEnum
	 * @see #setName(ArithFtnEnum)
	 * @see roqme.metamodel.expressions.ExpressionsPackage#getArithFunction_Name()
	 * @model required="true"
	 * @generated
	 */
	ArithFtnEnum getName();

	/**
	 * Sets the value of the '{@link roqme.metamodel.expressions.ArithFunction#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see roqme.metamodel.expressions.ArithFtnEnum
	 * @see #getName()
	 * @generated
	 */
	void setName(ArithFtnEnum value);

} // ArithFunction
