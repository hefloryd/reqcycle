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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.polarsys.reqcycle.export.ProviderUtils;
import org.polarsys.reqcycle.export.transform.RequirementSourceReqProvider;
import org.polarsys.reqcycle.export.transform.ScopeReqProvider;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;
import org.polarsys.reqcycle.repository.data.types.IDataModel;
import org.polarsys.reqcycle.repository.ui.providers.RequirementSourceLabelProvider;

import com.google.common.collect.Lists;

public class RequirementSourceSelectionPage extends WizardPage {

	@Inject
	IDataManager requirementSourceManager;

	@Inject
	IDataModelManager dataManager;

	private CheckboxTableViewer reqScopeTableViewer;

	private Collection<Scope> scopes = new ArrayList<Scope>();

	private IDataModel dataModel;

	protected WizardController controller;

	private List<RequirementSource> selectedSources = Lists.newArrayList();

	public RequirementSourceSelectionPage(WizardController controller) {
		super("wizardPage");
		this.controller = controller;
		setTitle("Traceability");
		setDescription("Selection of scopes from data model and data sources");
	}

	private Table table;
	private Table table_1;

	private CheckboxTableViewer reqSourceTableViewer;

	@Override
	public boolean isPageComplete() {
		return reqSourceTableViewer.getCheckedElements().length != 0 || reqScopeTableViewer.getCheckedElements().length != 0;
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(1, false));

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite.setLayout(new GridLayout(1, false));

		Group grpDataSource = new Group(composite, SWT.NONE);
		grpDataSource.setLayout(new GridLayout(1, false));
		grpDataSource.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpDataSource.setText("Data Sources");

		reqSourceTableViewer = CheckboxTableViewer.newCheckList(grpDataSource, SWT.BORDER | SWT.FULL_SELECTION);
		reqSourceTableViewer.setLabelProvider(new RequirementSourceLabelProvider());
		reqSourceTableViewer.setContentProvider(ProviderUtils.getArrayContentProvider());
		reqSourceTableViewer.setInput(requirementSourceManager.getRequirementSources());
		table = reqSourceTableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		reqSourceTableViewer.addCheckStateListener(new ICheckStateListener() {
			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				if (event.getChecked()) {
					controller.addReqProvider(new RequirementSourceReqProvider((RequirementSource) event.getElement()));
				} else {
					controller.removeReqProvider(new RequirementSourceReqProvider((RequirementSource) event.getElement()));
				}
				getWizard().getContainer().updateButtons();
				getWizard().getContainer().updateMessage();
			}
		});

		Group grpScope = new Group(composite, SWT.NONE);
		grpScope.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpScope.setText("Scopes");
		grpScope.setLayout(new GridLayout(2, false));
		Label lblDataModel = new Label(grpScope, SWT.NONE);
		lblDataModel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDataModel.setText("Data Model :");

		ComboViewer modelComboViewer = new ComboViewer(grpScope, SWT.READ_ONLY);
		Combo combo = modelComboViewer.getCombo();
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		modelComboViewer.setContentProvider(ProviderUtils.getArrayContentProvider());

		modelComboViewer.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof IDataModel) {
					return ((IDataModel) element).getName();
				}
				return "";
			}
		});
		modelComboViewer.setInput(dataManager.getCurrentDataModels());

		modelComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {

				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object firstElement = ((IStructuredSelection) selection).getFirstElement();
					if (firstElement instanceof IDataModel) {
						IDataModel selectedDataModel = (IDataModel) firstElement;
						if (selectedDataModel != dataModel) {
							dataModel = selectedDataModel;
							setScopes(dataManager.getScopes(dataModel));
						}
					}
				}
			}
		});

		reqScopeTableViewer = CheckboxTableViewer.newCheckList(grpScope, SWT.BORDER | SWT.FULL_SELECTION);
		reqScopeTableViewer.setContentProvider(ProviderUtils.getArrayContentProvider());
		reqScopeTableViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Scope) {
					return ((Scope) element).getName();
				}
				return "a";
			}
		});
		reqScopeTableViewer.setInput(scopes);

		reqScopeTableViewer.addCheckStateListener(new ICheckStateListener() {

			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				if (event.getChecked()) {
					controller.addReqProvider(new ScopeReqProvider((Scope) event.getElement()));
				} else {
					controller.removeReqProvider(new ScopeReqProvider((Scope) event.getElement()));
				}
				getWizard().getContainer().updateButtons();
				getWizard().getContainer().updateMessage();
			}
		});
		table_1 = reqScopeTableViewer.getTable();
		table_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		for (RequirementSource s : selectedSources) {
			reqSourceTableViewer.setChecked(s, true);
		}

		doCreateGroup(composite);

	}

	protected void doCreateGroup(Composite composite) {
		// TODO Auto-generated method stub

	}

	protected void setScopes(Collection<Scope> scopes) {
		this.scopes.clear();
		this.scopes.addAll(scopes);
		if (reqScopeTableViewer != null) {
			reqScopeTableViewer.setSelection(new StructuredSelection(scopes));
			reqScopeTableViewer.refresh();
		}
	}

	public void select(RequirementSource source) {
		selectedSources.add(source);
	}
}
