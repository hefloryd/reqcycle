/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Abdellah El Ayadi (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.reqcycle.export.rmf.wizard;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.polarsys.reqcycle.export.rmf.ProviderUtils;
import org.polarsys.reqcycle.export.rmf.page.WizardController;
import org.polarsys.reqcycle.export.rmf.transform.RequirementSourceReqProvider;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.ui.providers.RequirementSourceLabelProvider;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.Lists;

public class RequirementSourceSelectionPage extends WizardPage {

	private static final String[] EXTENSIONS = new String[] { "reqif" };

	private static final String SELECT_OUTPUT_REQIF_FILE = "Select output Reqif file";

	@Inject
	IDataManager requirementSourceManager = ZigguratInject.make(IDataManager.class);

	protected WizardController controller;

	private List<RequirementSource> selectedSources = Lists.newArrayList();

	public RequirementSourceSelectionPage(WizardController controller) {
		super("wizardPage");
		this.controller = controller;
		setTitle("ReqIF");
		setDescription("Selection of data sources and output file");
	}

	private Table table;
	private Table table_1;

	private CheckboxTableViewer reqSourceTableViewer;

	private Text text;

	@Override
	public boolean isPageComplete() {
		return reqSourceTableViewer.getCheckedElements().length != 0 && !text.getText().isEmpty();
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

		for (RequirementSource s : selectedSources) {
			reqSourceTableViewer.setChecked(s, true);
		}

		Group grpOutput = new Group(composite, SWT.NONE);
		grpOutput.setLayout(new GridLayout(2, false));
		grpOutput.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		grpOutput.setText("Output");

		text = new Text(grpOutput, SWT.BORDER);
		text.setEditable(false);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		if (controller.getOutputUri() != null) {
			text.setText(controller.getOutputUri().path());
			checkExistingFile();
		}
		Button btnNewButton = new Button(grpOutput, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// URI.createPlatformResourceURI(pathName);
				ResourceDialog dialog = new ResourceDialog(getShell(), "blabla", SWT.SAVE | SWT.SINGLE);
				int res = dialog.open();
				if (res == ResourceDialog.OK) {
					URI uri = dialog.getURIs().get(0);
					if (uri != null) {
						if (!"reqif".equals(uri.fileExtension())) {
							uri = uri.trimFileExtension().appendFileExtension("reqif");
						}
						text.setText(uri.toString());
					}
					controller.setOutputUri(uri);
				}

				checkExistingFile();
				getWizard().getContainer().updateButtons();
				getWizard().getContainer().updateMessage();
			}

		});
		btnNewButton.setText("...");

		doCreateGroup(composite);

	}

	protected void doCreateGroup(Composite composite) {
		// TODO Auto-generated method stub

	}

	protected void checkExistingFile() {
		// if (new File(controller.getOutputUri().toFileString()).exists()){
		// setErrorMessage("The file already exists, it will be overriden");
		// }
	}

	public void select(RequirementSource source) {
		selectedSources.add(source);
	}
}
