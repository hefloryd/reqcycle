/**
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *   Malick Wade (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.inittypes.inittypes;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.reqcycle.inittypes.inittypes.TypeModel#getFileTypes <em>File Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.inittypes.inittypes.InittypesPackage#getTypeModel()
 * @model
 * @generated
 */
public interface TypeModel extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2014 AtoS\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html *\r\nContributors:\r\n  Malick Wade (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * Returns the value of the '<em><b>File Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.reqcycle.inittypes.inittypes.FileType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Types</em>' containment reference list.
	 * @see org.polarsys.reqcycle.inittypes.inittypes.InittypesPackage#getTypeModel_FileTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<FileType> getFileTypes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Type getDocumentType(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<Type> getTypes(String name);

} // TypeModel
