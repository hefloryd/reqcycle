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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Traceability</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Traceability#getElementTracedLabel <em>Element Traced Label</em>}</li>
 *   <li>{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Traceability#getTraceabilityValues <em>Traceability Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.ReqCycleExportPackage#getTraceability()
 * @model
 * @generated
 */
public interface Traceability extends EObject {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2013, 2014 AtoS and others\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html *\r\nContributors:\r\n Abdellah El Ayadi(AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * Returns the value of the '<em><b>Element Traced Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Traced Label</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Traced Label</em>' attribute.
	 * @see #setElementTracedLabel(String)
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.ReqCycleExportPackage#getTraceability_ElementTracedLabel()
	 * @model
	 * @generated
	 */
	String getElementTracedLabel();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.export.model.ReqCycleExport.Traceability#getElementTracedLabel <em>Element Traced Label</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Traced Label</em>' attribute.
	 * @see #getElementTracedLabel()
	 * @generated
	 */
	void setElementTracedLabel(String value);

	/**
	 * Returns the value of the '<em><b>Traceability Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.reqcycle.export.model.ReqCycleExport.AttributeValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traceability Values</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traceability Values</em>' containment reference list.
	 * @see org.polarsys.reqcycle.export.model.ReqCycleExport.ReqCycleExportPackage#getTraceability_TraceabilityValues()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttributeValue> getTraceabilityValues();

} // Traceability
