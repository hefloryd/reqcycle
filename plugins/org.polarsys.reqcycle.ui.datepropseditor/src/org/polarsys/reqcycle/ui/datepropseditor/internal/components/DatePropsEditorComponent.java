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
package org.polarsys.reqcycle.ui.datepropseditor.internal.components;

import java.util.Date;

import org.eclipse.emf.ecore.EAttribute;
import org.polarsys.reqcycle.ui.eattrpropseditor.api.AbstractPropsEditorComponent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class DatePropsEditorComponent extends AbstractPropsEditorComponent<Date> {

	private final CommonDatePropsEditor commonDatePropsEditor;

	public DatePropsEditorComponent(String attributeName, Composite parent, int style) {
		super(Date.class, parent, style);
		setLayout(new GridLayout(1, false));
		this.commonDatePropsEditor = new CommonDatePropsEditor(attributeName, this, getStyle());
		this.commonDatePropsEditor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	}

	@Override
	public Date getValue() {
		return this.commonDatePropsEditor.getCalendarValue().getTime();
	}

	@Override
	public boolean isValid() {
		return true;
	}

}
