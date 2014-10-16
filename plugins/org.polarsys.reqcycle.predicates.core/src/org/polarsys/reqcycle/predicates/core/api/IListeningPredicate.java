/**
 * Copyright (c) 2014 AtoS 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *   Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.predicates.core.api;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IListening Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.polarsys.reqcycle.predicates.core.PredicatesPackage#getIListeningPredicate()
 * @model abstract="true"
 * @generated
 */
public interface IListeningPredicate extends IPredicate {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Object> getObjectsToListen();

} // IListeningPredicate
