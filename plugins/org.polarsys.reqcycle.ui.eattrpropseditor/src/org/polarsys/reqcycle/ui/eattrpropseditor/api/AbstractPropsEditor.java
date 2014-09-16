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
package org.polarsys.reqcycle.ui.eattrpropseditor.api;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.swt.widgets.Composite;

/**
 * An abstract implementation of {@link IEAttrPropsEditor} that holds/returns a UI {@link AbstractPropsEditorComponent}.
 * 
 * @author Papa Issa DIAKHATE
 * 
 * @param <T>
 *            - Type type for which this editor is to be used.
 */
public abstract class AbstractPropsEditor<T> implements IEAttrPropsEditor<T> {

	private Composite container;

	private int style;

	private AbstractPropsEditorComponent<T> component;

	private String attributeName;

	Collection<Object> values = Collections.emptyList();

	/**
	 * @return The instance of UI component (Composite) that represents the editor that is to be used for properties edition.
	 */
	abstract protected AbstractPropsEditorComponent<T> initAndGetComponent();

	@Override
	public Composite getEditor() {
		this.component = this.initAndGetComponent();
		return this.component;
	}

	@Override
	public boolean isValid() {
		return this.component.isValid();
	}

	@Override
	public T getValue() {
		return this.component.getValue();
	}

	@Override
	public void setInitialValue(Object object) {
		this.component.setInitialValue(object);
	}

	@Override
	public Composite getContainer() {
		return this.container;
	}

	@Override
	public void setContainer(Composite container) {
		this.container = container;
	}

	@Override
	public int getStyle() {
		return this.style;
	}

	@Override
	public void setStyle(int style) {
		this.style = style;
	}

	@Override
	public String getAttributeName() {
		return attributeName;
	}

	@Override
	public void setAttributeName(String name) {
		this.attributeName = name;
	}

	@Override
	public Collection<Object> getPossibleValues() {
		return values;
	}

	@Override
	public void setPossibleValues(Collection<Object> values) {
		this.values = values;
	}
}
