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

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>ELink</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ELink#getUpwards
 * <em>Upwards</em>}</li>
 * <li>
 * {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ELink#getDownwards
 * <em>Downwards</em>}</li>
 * <li>
 * {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ELink#getAttributes
 * <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ReqCycleTraceabilityPackage#getELink()
 * @model
 * @generated
 */
public interface ELink extends Element {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String copyright = "Copyright (c) 2013 AtoS\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html *\r\nContributors:\r\n Abdellah EL AYADI (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * Returns the value of the '<em><b>Upwards</b></em>' reference list. The
	 * list contents are of type
	 * {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable}
	 * . <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upwards</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Upwards</em>' reference list.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ReqCycleTraceabilityPackage#getELink_Upwards()
	 * @model transient="true" changeable="false" derived="true"
	 * @generated
	 */
	EList<EReachable> getUpwards();

	/**
	 * Returns the value of the '<em><b>Downwards</b></em>' reference list. The
	 * list contents are of type
	 * {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.EReachable}
	 * . <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Downwards</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Downwards</em>' reference list.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ReqCycleTraceabilityPackage#getELink_Downwards()
	 * @model transient="true" changeable="false" derived="true"
	 * @generated
	 */
	EList<EReachable> getDownwards();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment
	 * reference list. The list contents are of type
	 * {@link org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.Property}
	 * . <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Attributes</em>' containment reference
	 *         list.
	 * @see org.polarsys.reqcycle.traceability.emf.ReqCycleTraceability.ReqCycleTraceabilityPackage#getELink_Attributes()
	 * @model containment="true" transient="true" changeable="false"
	 *        derived="true"
	 * @generated
	 */
	EList<Property> getAttributes();

} // ELink
