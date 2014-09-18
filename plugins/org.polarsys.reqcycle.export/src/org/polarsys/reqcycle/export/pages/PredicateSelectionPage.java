/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Abdellah El Ayadi (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.reqcycle.export.pages;

import javax.inject.Inject;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.polarsys.reqcycle.export.ProviderUtils;
import org.polarsys.reqcycle.predicates.core.api.IPredicate;
import org.polarsys.reqcycle.predicates.persistance.util.IPredicatesConfManager;
import org.polarsys.reqcycle.predicates.ui.providers.PredicatesTableLabelProvider;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class PredicateSelectionPage extends WizardPage {

	@Inject
	IPredicatesConfManager predicatesConfManager;

	private Table table;

	private WizardController controller;

	@Override
	public boolean isPageComplete() {
		return true;
	}

	/**
	 * Create the wizard.
	 */
	public PredicateSelectionPage(WizardController controller) {
		super("wizardPage");
		this.controller = controller;
		ZigguratInject.inject(this);
		setTitle("Traceability");
		setDescription("Selection of predicates");
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new FormLayout());

		Composite composite = new Composite(container, SWT.NONE);
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(0, 305);
		fd_composite.right = new FormAttachment(0, 564);
		fd_composite.top = new FormAttachment(0, 10);
		fd_composite.left = new FormAttachment(0);
		composite.setLayoutData(fd_composite);
		composite.setLayout(new GridLayout(1, false));

		Group grpPredicate = new Group(composite, SWT.NONE);
		grpPredicate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpPredicate.setBounds(0, 0, 70, 82);
		grpPredicate.setLayout(new GridLayout(1, false));
		grpPredicate.setText("Predicates");

		final CheckboxTableViewer predicateTableViewer = CheckboxTableViewer.newCheckList(grpPredicate, SWT.BORDER | SWT.FULL_SELECTION);
		predicateTableViewer.setLabelProvider(new PredicatesTableLabelProvider());
		predicateTableViewer.setContentProvider(ProviderUtils.getArrayContentProvider());
		predicateTableViewer.setInput(predicatesConfManager.getPredicates(false));
		predicateTableViewer.addCheckStateListener(new ICheckStateListener() {

			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				if (event.getChecked()) {
					controller.addPredicateResult((IPredicate) event.getElement());
				} else {
					controller.removePredicateResult((IPredicate) event.getElement());
				}
			}
		});
		table = predicateTableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setBounds(0, 0, 85, 85);
	}

}
