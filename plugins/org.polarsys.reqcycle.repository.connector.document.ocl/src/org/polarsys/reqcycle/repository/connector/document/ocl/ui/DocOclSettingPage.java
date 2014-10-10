/*******************************************************************************
 *  Copyright (c) 2013, 2014 AtoS and others
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *  Malick WADE (AtoS) - initial API and implementation and/or initial documentation
 *
 *******************************************************************************/
package org.polarsys.reqcycle.repository.connector.document.ocl.ui;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.polarsys.kitalpha.doc.doc2model.common.Common.DocumentModel;
import org.polarsys.kitalpha.doc.doc2model.core.Doc2Model;
import org.polarsys.kitalpha.doc.doc2model.core.IContentHandler;
import org.polarsys.reqcycle.ocl.ui.SettingBean;
import org.polarsys.reqcycle.repository.connector.ui.wizard.pages.AbstractSettingPage;

public class DocOclSettingPage extends AbstractSettingPage{

	
	private Text txtSelectedDoc;

	private Button btnBrowseDoc;
	
	private ComboViewer cImportType;
	

	



	public DocOclSettingPage(SettingBean bean) {
		super("Document OCL Connector settings", bean);
		setTitle("Connector DOCUMENT with OCL configuration: settings page");
		
		setDescription("Connector settings");
	}


	@Override
	protected Composite doCreateSpecific(Composite compositeContainer) {
		compositeContainer.setLayout(new GridLayout(4, false));
		setControl(compositeContainer);

		Label lblDocFile = new Label(compositeContainer, SWT.NONE);
		lblDocFile.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblDocFile.setText("Document :");

		txtSelectedDoc = new Text(compositeContainer, SWT.BORDER);
		txtSelectedDoc.setEnabled(false);
		txtSelectedDoc.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		btnBrowseDoc = new Button(compositeContainer, SWT.NONE);
		btnBrowseDoc.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		btnBrowseDoc.setText("Browse");
		
		Label lblType = new Label(compositeContainer, SWT.NONE);
		lblType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblType.setText("Import Type :");
		cImportType = new ComboViewer(compositeContainer);
		cImportType.setContentProvider(ArrayContentProvider.getInstance());
		cImportType.setLabelProvider(new LabelProvider(){
			@Override
			public String getText(Object element) {
				if (element instanceof IContentHandler) {
					IContentHandler<DocumentModel> handler = (IContentHandler<DocumentModel>) element;
					return handler.getLabel();
				}
				return super.getText(element);
			}
		});
		cImportType.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection structured = (IStructuredSelection) event.getSelection();
					IContentHandler<DocumentModel> handler = (IContentHandler<DocumentModel>) structured.getFirstElement();
					getBean().setHandlerClassName (handler.getClass().getName());
				}
			}
		});
		cImportType.setInput(Collections.emptyList());
		cImportType.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		return compositeContainer;
	}
	
	@Override
	protected void hookListeners() {
		super.hookListeners();
		getDestinationFileSelectionListener();
		
		btnBrowseDoc.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ResourceDialog dialog = new ResourceDialog(getShell(), "Select a document", SWT.NONE);

				if (Window.OK == dialog.open()) {
					final List<URI> uris = dialog.getURIs();

					if (!uris.isEmpty()) {
						// asking doc2Modele if the file extension is correct
						String fileString = CommonPlugin.asLocalURI(uris.get(0)).toFileString();
						Doc2Model<DocumentModel> doc2Model = new Doc2Model<DocumentModel>();
						String fileType = doc2Model.getFileType(fileString);
						if (fileType != null && fileType.toString() != null) {
							txtSelectedDoc.setText(uris.get(0).toString());
							//cImportType.setInput(doc2Model.getContentHandlers(fileString, DocumentModel.class));
						}else {
							txtSelectedDoc.setText("");
							setErrorMessage("Your document is not supported. Retry and choose document file");
						}
					}

				}
			}
		});
	}

	@Override
	public boolean isPageComplete() {
		boolean result = super.isPageComplete();
		String msg = getErrorMessage();
		if (msg == null) {
			msg = "";
		}

		if (txtSelectedDoc.getText() == null || txtSelectedDoc.getText() == "") {
			result = false;
			msg += "Choose a document Input\n";
		}

		if (!result) {
			setErrorMessage(msg);
		}
		return result;
	}

	@Override
	protected void doSpecificInitDataBindings(DataBindingContext bindingContext) {
		IObservableValue observeTextTxtSelectedDocObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtSelectedDoc);
		IObservableValue uriBeanObserveValue = PojoProperties.value("uri").observe(getBean());
		Binding bind =bindingContext.bindValue(observeTextTxtSelectedDocObserveWidget, uriBeanObserveValue, null, null);
		
	}


	@Override
	public OCLDocBean getBean() {
		return (OCLDocBean) super.getBean();
	}
	
	

	



}
