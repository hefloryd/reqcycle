/**
 */
package org.polarsys.reqcycle.predicates.core.api;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>IPredicate Container</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.polarsys.reqcycle.predicates.core.api.IPredicateContainer#getResultPredicate <em>Result Predicate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.predicates.core.PredicatesPackage#getIPredicateContainer()
 * @model abstract="true"
 * @generated
 */
public interface IPredicateContainer extends IPredicate {
	/**
	 * Returns the value of the '<em><b>Result Predicate</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Predicate</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Result Predicate</em>' containment reference.
	 * @see #setResultPredicate(IPredicate)
	 * @see org.polarsys.reqcycle.predicates.core.PredicatesPackage#getIPredicateContainer_ResultPredicate()
	 * @model containment="true"
	 * @generated
	 */
	IPredicate getResultPredicate();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.predicates.core.api.IPredicateContainer#getResultPredicate <em>Result Predicate</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Result Predicate</em>' containment reference.
	 * @see #getResultPredicate()
	 * @generated
	 */
	void setResultPredicate(IPredicate value);

} // IPredicateContainer
