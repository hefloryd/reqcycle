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
package org.polarsys.reqcycle.ui.eattrpropseditor.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.reqcycle.ui.eattrpropseditor.api.IEditionResult;

public class SimpleEditionResult implements IEditionResult {

	private final EObject editObject;

	private final Map<String, Object> editedEntries;

	public SimpleEditionResult(final EObject eObject) {
		this.editObject = eObject;
		this.editedEntries = new HashMap<String, Object>();
	}

	@Override
	public EObject getEObjectToEdit() {
		return this.editObject;
	}

	@Override
	public Map<String, Object> getEditedEntries() {
		return this.editedEntries;
	}

}
