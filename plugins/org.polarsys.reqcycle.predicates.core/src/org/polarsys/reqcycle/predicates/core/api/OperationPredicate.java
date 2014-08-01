/**
 */
package org.polarsys.reqcycle.predicates.core.api;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.predicates.core.api.OperationPredicate#getOperationName <em>Operation Name</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.predicates.core.api.OperationPredicate#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.predicates.core.PredicatesPackage#getOperationPredicate()
 * @model
 * @generated
 */
public interface OperationPredicate extends IPredicateContainer {
	/**
	 * Returns the value of the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Name</em>' attribute.
	 * @see #setOperationName(String)
	 * @see org.polarsys.reqcycle.predicates.core.PredicatesPackage#getOperationPredicate_OperationName()
	 * @model
	 * @generated
	 */
	String getOperationName();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.predicates.core.api.OperationPredicate#getOperationName <em>Operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Name</em>' attribute.
	 * @see #getOperationName()
	 * @generated
	 */
	void setOperationName(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.reqcycle.predicates.core.api.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.polarsys.reqcycle.predicates.core.PredicatesPackage#getOperationPredicate_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

} // OperationPredicate
