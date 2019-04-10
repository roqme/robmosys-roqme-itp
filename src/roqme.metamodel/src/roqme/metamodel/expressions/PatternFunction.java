/**
 */
package roqme.metamodel.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.expressions.PatternFunction#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.expressions.ExpressionsPackage#getPatternFunction()
 * @model
 * @generated
 */
public interface PatternFunction extends FunctionTerm {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The literals are from the enumeration {@link roqme.metamodel.expressions.PatternFtnEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see roqme.metamodel.expressions.PatternFtnEnum
	 * @see #setName(PatternFtnEnum)
	 * @see roqme.metamodel.expressions.ExpressionsPackage#getPatternFunction_Name()
	 * @model required="true"
	 * @generated
	 */
	PatternFtnEnum getName();

	/**
	 * Sets the value of the '{@link roqme.metamodel.expressions.PatternFunction#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see roqme.metamodel.expressions.PatternFtnEnum
	 * @see #getName()
	 * @generated
	 */
	void setName(PatternFtnEnum value);

} // PatternFunction
