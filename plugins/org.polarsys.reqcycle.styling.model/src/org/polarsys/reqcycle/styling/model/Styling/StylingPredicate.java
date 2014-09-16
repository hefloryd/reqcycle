/**
 * Copyright (c) 2014 AtoS
 *     All rights reserved. This program and the accompanying materials
 *     are made available under the terms of the Eclipse Public License v1.0
 *     which accompanies this distribution, and is available at
 *     http://www.eclipse.org/legal/epl-v10.html *
 *     Contributors:
 *       Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.styling.model.Styling;

import org.polarsys.reqcycle.predicates.core.api.IPredicate;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Predicate</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.polarsys.reqcycle.styling.model.Styling.StylingPredicate#getPredicate <em>Predicate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.styling.model.Styling.StylingPackage#getStylingPredicate()
 * @model
 * @generated
 */
public interface StylingPredicate extends CaseStyle {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String copyright = "Copyright (c) 2014 AtoS\r\n    All rights reserved. This program and the accompanying materials\r\n    are made available under the terms of the Eclipse Public License v1.0\r\n    which accompanies this distribution, and is available at\r\n    http://www.eclipse.org/legal/epl-v10.html *\r\n    Contributors:\r\n      Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * Returns the value of the '<em><b>Predicate</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Predicate</em>' reference.
	 * @see #setPredicate(IPredicate)
	 * @see org.polarsys.reqcycle.styling.model.Styling.StylingPackage#getStylingPredicate_Predicate()
	 * @model
	 * @generated
	 */
	IPredicate getPredicate();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.styling.model.Styling.StylingPredicate#getPredicate <em>Predicate</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Predicate</em>' reference.
	 * @see #getPredicate()
	 * @generated
	 */
	void setPredicate(IPredicate value);

} // StylingPredicate
