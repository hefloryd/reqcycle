/**
 */
package org.polarsys.reqcycle.predicates.core.api;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.predicates.core.api.BooleanParameter#isValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.predicates.core.PredicatesPackage#getBooleanParameter()
 * @model
 * @generated
 */
public interface BooleanParameter extends Parameter {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(boolean)
	 * @see org.polarsys.reqcycle.predicates.core.PredicatesPackage#getBooleanParameter_Value()
	 * @model
	 * @generated
	 */
	boolean isValue();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.predicates.core.api.BooleanParameter#isValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #isValue()
	 * @generated
	 */
	void setValue(boolean value);

} // BooleanParameter
