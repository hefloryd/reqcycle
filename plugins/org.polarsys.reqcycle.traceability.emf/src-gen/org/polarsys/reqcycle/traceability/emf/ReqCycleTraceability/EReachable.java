/**
 * Copyright (c) 2013 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *  Abdellah EL AYADI (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>EReachable</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable#getDownwards
 * <em>Downwards</em>}</li>
 * <li>
 * {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable#getTypes
 * <em>Types</em>}</li>
 * <li>
 * {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable#getUpwards
 * <em>Upwards</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ReqCycleTraceabilityPackage#getEReachable()
 * @model
 * @generated
 */
public interface EReachable extends Element {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String copyright = "Copyright (c) 2013 AtoS\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html *\r\nContributors:\r\n Abdellah EL AYADI (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * Returns the value of the '<em><b>Downwards</b></em>' reference list. The
	 * list contents are of type
	 * {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ELink}
	 * . <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Downwards</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Downwards</em>' reference list.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ReqCycleTraceabilityPackage#getEReachable_Downwards()
	 * @model transient="true" changeable="false" derived="true"
	 * @generated
	 */
	EList<ELink> getDownwards();

	/**
	 * Returns the value of the '<em><b>Types</b></em>' attribute list. The list
	 * contents are of type {@link java.lang.String}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' attribute list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Types</em>' attribute list.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ReqCycleTraceabilityPackage#getEReachable_Types()
	 * @model transient="true" changeable="false" derived="true"
	 * @generated
	 */
	EList<String> getTypes();

	/**
	 * Returns the value of the '<em><b>Upwards</b></em>' reference list. The
	 * list contents are of type
	 * {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ELink}
	 * . <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upwards</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Upwards</em>' reference list.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ReqCycleTraceabilityPackage#getEReachable_Upwards()
	 * @model transient="true" changeable="false" derived="true"
	 * @generated
	 */
	EList<ELink> getUpwards();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation"
	 * @generated
	 */
	EObject getEObject();

} // EReachable
