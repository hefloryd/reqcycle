/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Papa Issa Diakhate (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
/**
 */
package org.polarsys.reqcycle.predicates.core.impl;

import org.eclipse.emf.ecore.EClass;
import org.polarsys.reqcycle.predicates.core.PredicatesPackage;
import org.polarsys.reqcycle.predicates.core.api.AndPredicate;
import org.polarsys.reqcycle.predicates.core.api.IPredicate;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>And Predicate</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AndPredicateImpl extends CompositePredicateImpl implements AndPredicate {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AndPredicateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PredicatesPackage.Literals.AND_PREDICATE;
	}

	@Override
	public boolean match(Object input) {
		for (IPredicate predicate : this.getPredicates()) {
			if (!predicate.match(input))
				return false;
		}
		return true;
	}

} // AndPredicateImpl
