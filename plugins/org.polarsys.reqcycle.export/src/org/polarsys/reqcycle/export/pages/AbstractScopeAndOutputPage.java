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

import java.io.File;
import java.util.HashSet;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.wb.swt.SWTResourceManager;
import org.polarsys.reqcycle.export.transform.IRequirementProvider;

public abstract class AbstractScopeAndOutputPage extends WizardPage {
	private Text text;
	private CheckboxTreeViewer checkboxTreeViewer;
	private HashSet<IRequirementProvider> requirementSourceResult;

	protected WizardController controller;

	/**
	 * Create the wizard.
	 */
	public AbstractScopeAndOutputPage(WizardController controller) {
		super("wizardPage");
		this.controller = controller;
		setTitle("Traceability");
		setDescription("If selection empty, the traceability will not be exported ");
	}

	@Override
	public boolean isPageComplete() {
		return !text.getText().isEmpty();
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
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		Group grpProjectsForAnalysis = new Group(composite, SWT.NONE);
		grpProjectsForAnalysis.setLayout(new GridLayout(1, false));
		grpProjectsForAnalysis.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpProjectsForAnalysis.setText("Projects selection for analysis");

		Label lblIfSelectionEmpty = new Label(grpProjectsForAnalysis, SWT.NONE);
		lblIfSelectionEmpty.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblIfSelectionEmpty.setText("If the selection is empty, the traceability will not be exported.");

		checkboxTreeViewer = new CheckboxTreeViewer(grpProjectsForAnalysis, SWT.BORDER | SWT.FULL_SELECTION);
		checkboxTreeViewer.setLabelProvider(new WorkbenchLabelProvider());
		checkboxTreeViewer.setContentProvider(new WorkbenchContentProvider() {
			@Override
			public Object[] getChildren(Object element) {
				if (element instanceof IWorkspace) {
					IWorkspace root = (IWorkspace) element;
					return new Object[] { root.getRoot() };
				}
				return super.getChildren(element);
			}

		});
		checkboxTreeViewer.setFilters(new ViewerFilter[] { new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return element instanceof IProject || element instanceof IWorkspaceRoot;
			}
		} });
		checkboxTreeViewer.setInput(ResourcesPlugin.getWorkspace());
		checkboxTreeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		checkboxTreeViewer.addCheckStateListener(new ICheckStateListener() {
			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				checkboxTreeViewer.setSubtreeChecked(event.getElement(), event.getChecked());
				controller.clearProjectResults();
				for (int i = 0; i < checkboxTreeViewer.getCheckedElements().length; i++) {
					if (checkboxTreeViewer.getCheckedElements()[i] instanceof IProject) {
						controller.addProjectResult((IProject) checkboxTreeViewer.getCheckedElements()[i]);
					}
				}
				getWizard().getContainer().updateButtons();
				getWizard().getContainer().updateMessage();
			}

		});

		Group grpOutput = new Group(composite, SWT.NONE);
		grpOutput.setLayout(new GridLayout(2, false));
		grpOutput.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		grpOutput.setText("Output");

		text = new Text(grpOutput, SWT.BORDER);
		text.setEditable(false);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		if (controller.getOutputPath() != null) {
			text.setText(controller.getOutputPath());
			checkExistingFile();
		}
		Button btnNewButton = new Button(grpOutput, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				doWidgetSelected();

				FileDialog dlg = new FileDialog(getShell(), SWT.SAVE);
				dlg.setText(getFileDialogTitle());
				dlg.setFilterExtensions(getAllowedExtensions());
				String selectedDirectory = dlg.open();
				if (selectedDirectory != null) {
					selectedDirectory = selectedDirectory.replace('\\', '/');
					if (selectedDirectory.toLowerCase().endsWith("." + getAllowedExtensions()[dlg.getFilterIndex()])) {
						text.setText(selectedDirectory);
					} else {
						text.setText(selectedDirectory + "." + getAllowedExtensions()[dlg.getFilterIndex()]);
					}
				}
				controller.setOutputPath(text.getText());
				checkExistingFile();
				getWizard().getContainer().updateButtons();
				getWizard().getContainer().updateMessage();
			}

		});
		btnNewButton.setText("...");
	}

	protected void checkExistingFile() {
		if (new File(controller.getOutputPath()).exists()) {
			setErrorMessage("The file already exists, it will be overriden");
		}
	}

	protected abstract String getCurrentExtension();

	protected void setRequirementSourceResult(HashSet<IRequirementProvider> result) {
		this.requirementSourceResult = result;
	}

	protected HashSet<IRequirementProvider> getRequirementSourceResult() {
		return requirementSourceResult;
	}

	public Text getText() {
		return text;
	}

	protected abstract String[] getAllowedExtensions();

	protected abstract void doWidgetSelected();

	protected abstract String getFileDialogTitle();

}
