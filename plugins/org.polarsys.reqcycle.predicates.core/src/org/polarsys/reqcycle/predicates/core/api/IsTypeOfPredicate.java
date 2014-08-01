/**
 */
package org.polarsys.reqcycle.predicates.core.api;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Is Type Of Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.predicates.core.api.IsTypeOfPredicate#getType <em>Type</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.predicates.core.api.IsTypeOfPredicate#isIsStrictTypeOf <em>Is Strict Type Of</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.predicates.core.PredicatesPackage#getIsTypeOfPredicate()
 * @model
 * @generated
 */
public interface IsTypeOfPredicate extends IPredicate {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(Object)
	 * @see org.polarsys.reqcycle.predicates.core.PredicatesPackage#getIsTypeOfPredicate_Type()
	 * @model
	 * @generated
	 */
	Object getType();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.predicates.core.api.IsTypeOfPredicate#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(Object value);

	/**
	 * Returns the value of the '<em><b>Is Strict Type Of</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Strict Type Of</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Strict Type Of</em>' attribute.
	 * @see #setIsStrictTypeOf(boolean)
	 * @see org.polarsys.reqcycle.predicates.core.PredicatesPackage#getIsTypeOfPredicate_IsStrictTypeOf()
	 * @model
	 * @generated
	 */
	boolean isIsStrictTypeOf();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.predicates.core.api.IsTypeOfPredicate#isIsStrictTypeOf <em>Is Strict Type Of</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Strict Type Of</em>' attribute.
	 * @see #isIsStrictTypeOf()
	 * @generated
	 */
	void setIsStrictTypeOf(boolean value);

} // IsTypeOfPredicate
