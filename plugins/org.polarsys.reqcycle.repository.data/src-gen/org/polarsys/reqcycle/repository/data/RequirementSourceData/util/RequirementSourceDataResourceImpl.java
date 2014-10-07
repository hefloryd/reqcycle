/**
 * Copyright (c) 2013 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *   Anass Radouani (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.repository.data.RequirementSourceData.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

/**
 * <!-- begin-user-doc --> The <b>Resource </b> associated with the package. <!-- end-user-doc -->
 * 
 * @see org.polarsys.reqcycle.repository.data.RequirementSourceData.util.RequirementSourceDataResourceFactoryImpl
 * @generated
 */
public class RequirementSourceDataResourceImpl extends XMIResourceImpl {
	/**
	 * Creates an instance of the resource. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param uri
	 *            the URI of the new resource.
	 * @generated
	 */
	public RequirementSourceDataResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	public String getURIFragment(EObject eObject) {
		String f = super.getURIFragment(eObject);
		return URI.encodeFragment(f, true);
	}

	@Override
	public EObject getEObject(String uriFragment) {
		return super.getEObject(URI.decode(uriFragment));
	}

} // RequirementSourceDataResourceImpl
