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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.rmf.reqif10.Specification;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.polarsys.reqcycle.repository.connector.rmf.RMFUtils;
import org.polarsys.reqcycle.repository.connector.ui.wizard.pages.AbstractSettingPage;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;

public class RMFSettingPage extends AbstractSettingPage {

	private Text fileURIText;

	private Button browseFileBtn;

	private final String EXTENSIONS = "reqif";

	private ComboViewer comboViewer;

	Collection<Specification> docsTypes = new LinkedList<Specification>();

	@Inject
	IDataModelManager dataManager;

	/**
	 * @param title
	 *            Page title
	 * @param description
	 *            page description
	 * @wbp.parser.constructor
	 */
	public RMFSettingPage(RMFBean bean) {
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

		IObservableValue observeDocument = ViewerProperties.singleSelection().observe(comboViewer);
		IObservableValue documentObserveValue = PojoProperties.value("specification").observe(getBean());
		bindingContext.bindValue(observeDocument, documentObserveValue, null, null);

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

		Label lblDocSpec = new Label(compositeContainer, SWT.NONE);
		lblDocSpec.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblDocSpec.setText("Specification :");

		comboViewer = new ComboViewer(compositeContainer, SWT.None | SWT.READ_ONLY);
		Combo combo = comboViewer.getCombo();
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		comboViewer.setContentProvider(new ArrayContentProvider());
		comboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Specification) {
					String longName = ((Specification) element).getLongName();
					return longName != null && !longName.isEmpty() ? longName : ((Specification) element).getIdentifier();
				}
				return super.getText(element);
			}
		});
		combo.setEnabled(false);

		comboViewer.setInput(docsTypes);

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
						URI uri = uris.get(0);
						String extension = uri.path().substring(uri.path().lastIndexOf(".") + 1, uri.path().length());
						if (EXTENSIONS.contains(extension.toLowerCase())) {
							fileURIText.setText(uri.toString());
							docsTypes.clear();
							docsTypes.addAll(RMFUtils.getReqIFDocuments(new ResourceSetImpl(), uri.toString()));
							Combo combo = comboViewer.getCombo();
							if (combo != null) {
								combo.setEnabled(true);
								comboViewer.refresh();
							}
						} else {
							fileURIText.setText("");
							docsTypes.clear();
							Combo combo = comboViewer.getCombo();
							if (combo != null) {
								combo.setEnabled(false);
								comboViewer.refresh();
							}
							setErrorMessage("Your document is not supported. Retry and choose reqIF file");

						}

					}
				}
			}
		});

	}

	@Override
	public boolean isPageComplete() {
		boolean result = super.isPageComplete();
		if (fileURIText.getText() == null || fileURIText.getText().isEmpty()) {
			setErrorMsg("Choose a ReqIF File.\n");
			result = false;
		} else {
			if (((RMFBean) getBean()).getSpecification() == null) {
				setErrorMsg("Choose a specification.\n");
				result = false;
			}
		}

		return result;
	}

	private void setErrorMsg(String message) {
		String msg = getErrorMessage();
		if (msg == null) {
			msg = "";
		}
		msg += message;
		setErrorMessage(msg);
	}

}
