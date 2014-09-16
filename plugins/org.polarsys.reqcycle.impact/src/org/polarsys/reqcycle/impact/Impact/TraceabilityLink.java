/**
 * Copyright (c) 2014 AtoS
 *     All rights reserved. This program and the accompanying materials
 *     are made available under the terms of the Eclipse Public License v1.0
 *     which accompanies this distribution, and is available at
 *     http://www.eclipse.org/legal/epl-v10.html *
 *     Contributors:
 *       Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.impact.Impact;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Traceability Link</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.polarsys.reqcycle.impact.Impact.TraceabilityLink#getLinkType <em>Link Type</em>}</li>
 * <li>{@link org.polarsys.reqcycle.impact.Impact.TraceabilityLink#getLinkDirection <em>Link Direction</em>}</li>
 * <li>{@link org.polarsys.reqcycle.impact.Impact.TraceabilityLink#getLinkedElement <em>Linked Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.impact.Impact.ImpactPackage#getTraceabilityLink()
 * @model
 * @generated
 */
public interface TraceabilityLink extends EObject {
	/**
	 * Returns the value of the '<em><b>Link Type</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Type</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Link Type</em>' attribute.
	 * @see #setLinkType(String)
	 * @see org.polarsys.reqcycle.impact.Impact.ImpactPackage#getTraceabilityLink_LinkType()
	 * @model required="true"
	 * @generated
	 */
	String getLinkType();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.impact.Impact.TraceabilityLink#getLinkType <em>Link Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Link Type</em>' attribute.
	 * @see #getLinkType()
	 * @generated
	 */
	void setLinkType(String value);

	/**
	 * Returns the value of the '<em><b>Link Direction</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Direction</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Link Direction</em>' attribute.
	 * @see #setLinkDirection(String)
	 * @see org.polarsys.reqcycle.impact.Impact.ImpactPackage#getTraceabilityLink_LinkDirection()
	 * @model required="true"
	 * @generated
	 */
	String getLinkDirection();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.impact.Impact.TraceabilityLink#getLinkDirection <em>Link Direction</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Link Direction</em>' attribute.
	 * @see #getLinkDirection()
	 * @generated
	 */
	void setLinkDirection(String value);

	/**
	 * Returns the value of the '<em><b>Linked Element</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linked Element</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Linked Element</em>' attribute.
	 * @see #setLinkedElement(String)
	 * @see org.polarsys.reqcycle.impact.Impact.ImpactPackage#getTraceabilityLink_LinkedElement()
	 * @model required="true"
	 * @generated
	 */
	String getLinkedElement();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.impact.Impact.TraceabilityLink#getLinkedElement <em>Linked Element</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Linked Element</em>' attribute.
	 * @see #getLinkedElement()
	 * @generated
	 */
	void setLinkedElement(String value);

} // TraceabilityLink
