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
import org.polarsys.reqcycle.repository.connector.rmf.RMFConnector.RMFSettingBean;
import org.polarsys.reqcycle.repository.connector.ui.wizard.pages.AbstractSettingPage;
import org.polarsys.reqcycle.repository.connector.ui.wizard.pages.AbstractStorageBean;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;

public class RMFSettingPage extends AbstractSettingPage {

	private Text fileURIText;

	private Button browseFileBtn;

	// private String uri;

	private Button btnSkipMapping;

	private RMFSettingBean bean;

	@Inject
	IDataModelManager dataManager;

	/**
	 * @param title
	 *            Page title
	 * @param description
	 *            page description
	 * @wbp.parser.constructor
	 */
	public RMFSettingPage(RMFSettingBean bean) {
		super("RMF Connector settings");
		setTitle("Connector RMF: settings page");
		this.bean = bean;
	}

	/**
	 * @param title
	 *            Page title
	 * @param description
	 *            Page description
	 * @param uri
	 *            input uri
	 */
	/*
	 * public RMFSettingPage(String title, String description, String uri) { this(title, description); this.uri = uri; }
	 */

	/*
	 * @Override public boolean canFlipToNextPage() { return isPageComplete() && !bean.skipMapping; }
	 */

	/*
	 * @Override public boolean isPageComplete() { StringBuffer error = new StringBuffer(); boolean result = true; if (bean.getUri() == null || bean.getUri().isEmpty()) { error.append("Choose a ReqIF File.\n"); result = false; }
	 * 
	 * if (!result) { setErrorMessage(error.toString()); } else { setErrorMessage(null); }
	 * 
	 * return result; }
	 */

	public boolean preFinish(RequirementSource repository) {
		return true;
	}

	/*
	 * private void init() { if (uri != null && !uri.isEmpty()) { bean.setUri(uri); if (fileURIText != null) { fileURIText.setText(uri); } } }
	 */

	/*
	 * @Override public void handleEvent(Event event) { getWizard().getContainer().updateButtons(); }
	 * 
	 * public RMFSettingPageBean getBean() { return bean; }
	 */
	@Override
	protected void doSpecificInitDataBindings(DataBindingContext bindingContext) {
		//
		IObservableValue observeTextFileURITextObserveWidget = WidgetProperties.text(SWT.Modify).observe(fileURIText);
		IObservableValue uriBeanObserveValue = PojoProperties.value("uri").observe(bean);
		bindingContext.bindValue(observeTextFileURITextObserveWidget, uriBeanObserveValue, null, null);
		//
		IObservableValue observeSelectionBtnSkipMappingObserveWidget = WidgetProperties.selection().observe(btnSkipMapping);
		IObservableValue skipMappingBeanObserveValue = PojoProperties.value("skipMapping").observe(bean);
		bindingContext.bindValue(observeSelectionBtnSkipMappingObserveWidget, skipMappingBeanObserveValue, null, null);
		//

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

		Label lblSeparator = new Label(compositeContainer, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblSeparator.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 4, 1));

		btnSkipMapping = new Button(compositeContainer, SWT.CHECK);

		Label lblSkipMapping = new Label(compositeContainer, SWT.NONE);
		lblSkipMapping.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblSkipMapping.setText("Skip mapping (Perform mapping later)");
		new Label(compositeContainer, SWT.NONE);

		return compositeContainer;
	}

	@Override
	protected void specificHookListeners() {

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
	protected Boolean specificIsPageComplete(Boolean result) {
		if (fileURIText.getText() == null || fileURIText.getText().isEmpty()) {

			result = false;
		}
		return result;
	}

	@Override
	protected StringBuffer specificIsPageComplete(Boolean result, StringBuffer error) {
		if (result == false) {
			return new StringBuffer("Choose a ReqIF File.\n");
		}
		return error;
	}

	@Override
	public AbstractStorageBean getBean() {
		// TODO Auto-generated method stub
		return bean;
	}
}
