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
package org.polarsys.reqcycle.ui.simplepropseditors.internal.components;

import org.eclipse.swt.widgets.Composite;
import org.polarsys.reqcycle.ui.eattrpropseditor.api.AbstractPropsTextEditorComponent;

public class CharSequencePropsEditorComponent extends AbstractPropsTextEditorComponent<CharSequence> {

	public CharSequencePropsEditorComponent(String attributeName, Composite parent, int style) {
		super(attributeName, CharSequence.class, parent, style);
	}

	@Override
	protected CharSequence convertFromString(String textValue) {
		return textValue;
	}

	@Override
	protected boolean isTextValid(String textValue) {
		return true;
	}

}
