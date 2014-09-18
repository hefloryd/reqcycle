/**
 * Copyright (c) 2013, 2014 AtoS and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *  Abdellah El Ayadi(AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.export.model.ReqCycleExport;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Requirement</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Requirement#getValues <em>Values</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Requirement#getDownwardTraceability <em>Downward Traceability</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Requirement#getID <em>ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.ReqCycleExportPackage#getRequirement()
 * @model
 * @generated
 */
public interface Requirement extends EObject {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2013, 2014 AtoS and others\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html *\r\nContributors:\r\n Abdellah El Ayadi(AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.reqcycle.export.model.ReqCycleExport.AttributeValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.ReqCycleExportPackage#getRequirement_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttributeValue> getValues();

	/**
	 * Returns the value of the '<em><b>Downward Traceability</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.reqcycle.export.model.ReqCycleExport.Traceability}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Downward Traceability</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Downward Traceability</em>' containment reference list.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.ReqCycleExportPackage#getRequirement_DownwardTraceability()
	 * @model containment="true"
	 * @generated
	 */
	EList<Traceability> getDownwardTraceability();

	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see #setID(String)
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.ReqCycleExportPackage#getRequirement_ID()
	 * @model
	 * @generated
	 */
	String getID();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Requirement#getID <em>ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>ID</em>' attribute.
	 * @see #getID()
	 * @generated
	 */
	void setID(String value);

} // Requirement
