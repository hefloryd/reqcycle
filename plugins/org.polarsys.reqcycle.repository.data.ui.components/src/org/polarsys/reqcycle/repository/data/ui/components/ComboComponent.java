package org.polarsys.reqcycle.repository.data.ui.components;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.polarsys.reqcycle.repository.data.util.EntryUtil;
import org.polarsys.reqcycle.ui.eattrpropseditor.api.AbstractPropsEditorComponent;

public class ComboComponent extends AbstractPropsEditorComponent<String> {

	public ComboComponent(String attributeName,
			Object input,Composite parent) {
		super (String.class,parent,SWT.None);
		final ComboViewer viewer = EntryUtil.createComboViewer(this, attributeName, input);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				setValue((String) viewer.getData(EntryUtil.AN_ENTRY));
			}
		});
	}

	@Override
	public boolean isValid() {
		return getValue() != null;
	}

}
