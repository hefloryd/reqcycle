/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Anass Radouani (AtoS) - initial API and implementation and/or initial documentation
 *    Malick WADE (AtoS) - restructuring of the connector architecture (2014)
 *   
 *******************************************************************************/

/**
 * 
 */
package org.polarsys.reqcycle.repository.connector.rmf.ui;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.polarsys.reqcycle.repository.connector.ui.wizard.pages.AbstractSettingPage;
import org.polarsys.reqcycle.repository.connector.ui.wizard.pages.AbstractStorageBean;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;

public class RMFSettingPage extends AbstractSettingPage {

	private Text fileURIText;

	private Button browseFileBtn;

	@Inject
	IDataModelManager dataManager;

	/**
	 * @param title
	 *            Page title
	 * @param description
	 *            page description
	 * @wbp.parser.constructor
	 */
	public RMFSettingPage(AbstractStorageBean bean) {
		super("RMF Connector settings", bean);
		setTitle("Connector RMF: settings page");
	}

	public boolean preFinish(RequirementSource repository) {
		return true;
	}

	@Override
	protected void doSpecificInitDataBindings(DataBindingContext bindingContext) {
		//
		IObservableValue observeTextFileURITextObserveWidget = WidgetProperties.text(SWT.Modify).observe(fileURIText);
		IObservableValue uriBeanObserveValue = PojoProperties.value("uri").observe(getBean());
		bindingContext.bindValue(observeTextFileURITextObserveWidget, uriBeanObserveValue, null, null);

	}

	@Override
	protected Composite doCreateSpecific(Composite parent) {
		Composite compositeContainer = parent;
		compositeContainer.setLayout(new GridLayout(4, false));
		setControl(compositeContainer);

		Label lblReqIfFile = new Label(compositeContainer, SWT.NONE);
		lblReqIfFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblReqIfFile.setText("ReqIF file :");

		fileURIText = new Text(compositeContainer, SWT.BORDER);
		fileURIText.setEditable(false);
		fileURIText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		browseFileBtn = new Button(compositeContainer, SWT.NONE);
		browseFileBtn.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1));
		browseFileBtn.setText("Browse");

		return compositeContainer;
	}

	@Override
	protected void hookListeners() {
		super.hookListeners();

		getDestinationFileSelectionListener();

		browseFileBtn.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				ResourceDialog dialog = new ResourceDialog(getShell(), "Select ReqIF file", SWT.NONE);
				int res = dialog.open();
				if (res == ResourceDialog.OK) {
					List<URI> uris = dialog.getURIs();
					if (!uris.isEmpty()) {
						fileURIText.setText(uris.get(0).toString());
					}
				}
			}
		});

	}

	@Override
	public boolean isPageComplete() {
		boolean result = super.isPageComplete();
		if (fileURIText.getText() == null || fileURIText.getText().isEmpty()) {
			String msg = getErrorMessage();
			if (msg == null) {
				msg = "";
			}
			msg += "Choose a ReqIF File.\n";
			setErrorMessage(msg);
			result = false;
		}
		return result;
	}

}
