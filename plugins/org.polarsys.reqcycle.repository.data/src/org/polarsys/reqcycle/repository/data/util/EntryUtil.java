/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Anass Radouani (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
package org.polarsys.reqcycle.repository.data.util;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.polarsys.reqcycle.repository.data.Activator;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;
import org.polarsys.reqcycle.repository.data.types.IDataModel;
import org.polarsys.reqcycle.repository.data.types.IRequirementType;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

/*
 * FIXME : remove entry (Traceability element)
 */
public class EntryUtil {

	static IDataModelManager dataModelManager = ZigguratInject.make(IDataModelManager.class);

	public static final String AN_ENTRY = "entry";

	private static final String CLEAR_IMG_PATH = "/icons/delete.gif";

	public static ComboViewer createComboViewer(Composite composite, String attributeName, Object input) {
		composite.setLayout(new GridLayout(3, false));
		Label label = new Label(composite, SWT.None);
		label.setText(attributeName);
		final ComboViewer comboViewer = new ComboViewer(composite);
		Combo combo = comboViewer.getCombo();
		combo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		final LabelProvider labelProvider = new LabelProvider() {

			@Override
			public String getText(Object element) {
				if (Platform.getAdapterManager().hasAdapter(element, String.class.getName())) {
					Object adapter = Platform.getAdapterManager().getAdapter(element, String.class);
					if (adapter instanceof String) {
						return ((String) adapter);
					}
				}
				return super.getText(element);
			}
		};
		comboViewer.setLabelProvider(labelProvider);
		comboViewer.setContentProvider(new ArrayContentProvider());
		comboViewer.setInput(input);

		comboViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object firstElement = ((IStructuredSelection) selection).getFirstElement();
					if (firstElement instanceof IDataModel || firstElement instanceof IRequirementType || firstElement instanceof Scope) {
						comboViewer.setData(AN_ENTRY, labelProvider.getText(firstElement));
					} else {
						comboViewer.setData(AN_ENTRY, null);
					}
				}
			}
		});

		Button clearCombo = new Button(composite, SWT.PUSH);
		clearCombo.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));
		clearCombo.setImage(Activator.getImageDescriptor(CLEAR_IMG_PATH).createImage());
		clearCombo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (comboViewer != null) {
					comboViewer.setSelection(StructuredSelection.EMPTY);
				}
			}
		});
		return comboViewer;
	}
}
