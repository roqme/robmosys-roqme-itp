/**
 */
package roqme.metamodel.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregation Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link roqme.metamodel.expressions.AggregationFunction#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see roqme.metamodel.expressions.ExpressionsPackage#getAggregationFunction()
 * @model
 * @generated
 */
public interface AggregationFunction extends FunctionTerm {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The literals are from the enumeration {@link roqme.metamodel.expressions.AggregationFtnEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see roqme.metamodel.expressions.AggregationFtnEnum
	 * @see #setName(AggregationFtnEnum)
	 * @see roqme.metamodel.expressions.ExpressionsPackage#getAggregationFunction_Name()
	 * @model required="true"
	 * @generated
	 */
	AggregationFtnEnum getName();

	/**
	 * Sets the value of the '{@link roqme.metamodel.expressions.AggregationFunction#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see roqme.metamodel.expressions.AggregationFtnEnum
	 * @see #getName()
	 * @generated
	 */
	void setName(AggregationFtnEnum value);

} // AggregationFunction
