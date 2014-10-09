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
package org.polarsys.reqcycle.repository.connector.document.ui;

import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.polarsys.kitalpha.doc.doc2model.common.Common.DocumentModel;
import org.polarsys.kitalpha.doc.doc2model.core.Doc2Model;
import org.polarsys.reqcycle.inittypes.inittypes.FileType;
import org.polarsys.reqcycle.inittypes.inittypes.Type;
import org.polarsys.reqcycle.repository.connector.document.DocConnector.DOCSettingBean;
import org.polarsys.reqcycle.repository.connector.document.DocUtils;
import org.polarsys.reqcycle.repository.connector.ui.wizard.pages.AbstractSettingPage;

public class DocSettingPage extends AbstractSettingPage {

	private DOCSettingBean bean;

	private Combo cTypeFile;

	private Text txtSelectedDoc;

	private Button btnBrowseDoc;

	private List<FileType> listFileTypeInWorkspace = null;
	private ComboViewer cvTypeFile;

	public DocSettingPage(DOCSettingBean bean) {
		super("Document Connector settings", bean);
		setTitle("Connector DOCUMENT: settings page");
		this.bean = bean;
	}

	protected void doSpecificInitDataBindings(DataBindingContext bindingContext) {
		//
		IObservableValue observeTextTxtSelectedDocObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtSelectedDoc);
		IObservableValue uriBeanObserveValue = PojoProperties.value("uri").observe(bean);
		bindingContext.bindValue(observeTextTxtSelectedDocObserveWidget, uriBeanObserveValue, null, null);
		//
		IObservableValue observeSingleSelectionCvTypeFile = ViewerProperties.singleSelection().observe(cvTypeFile);
		IObservableValue listTypeBeanObserveValue = PojoProperties.value("fileType").observe(bean);
		bindingContext.bindValue(observeSingleSelectionCvTypeFile, listTypeBeanObserveValue, null, null);

	}

	@Override
	protected Composite doCreateSpecific(Composite parent) {

		Composite compositeContainer = parent;
		compositeContainer.setLayout(new GridLayout(4, false));
		setControl(compositeContainer);

		Label lblDocFile = new Label(compositeContainer, SWT.NONE);
		lblDocFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblDocFile.setText("Document :");

		txtSelectedDoc = new Text(compositeContainer, SWT.BORDER);
		txtSelectedDoc.setEnabled(false);
		txtSelectedDoc.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		btnBrowseDoc = new Button(compositeContainer, SWT.NONE);
		btnBrowseDoc.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		btnBrowseDoc.setText("Browse");

		Label lbltypeFile = new Label(compositeContainer, SWT.NONE);
		lbltypeFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lbltypeFile.setText(".types file");

		cvTypeFile = new ComboViewer(compositeContainer, SWT.READ_ONLY);
		cTypeFile = cvTypeFile.getCombo();
		cTypeFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		cvTypeFile.setContentProvider(ArrayContentProvider.getInstance());
		cvTypeFile.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof FileType) {
					return ((FileType) element).getName();
				}
				return super.getText(element);

			}
		});
		listFileTypeInWorkspace = DocUtils.getAllFilesInProject();
		cvTypeFile.setInput(listFileTypeInWorkspace);
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
					List<URI> uris = dialog.getURIs();

					if (!uris.isEmpty()) {
						String fileString = CommonPlugin.asLocalURI(uris.get(0)).toFileString();
						Doc2Model<DocumentModel> doc2Model = new Doc2Model<DocumentModel>();
						String fileType = doc2Model.getFileType(fileString);
						if (fileType != null && fileType.toString() != null) {
							txtSelectedDoc.setText(uris.get(0).toString());
						}else {
							txtSelectedDoc.setText("");
							setErrorMessage("Your document is not supported. Retry and choose document file");
						}
					}
				}
			}
		});

		cvTypeFile.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object obj = ((IStructuredSelection) selection).getFirstElement();
					if (obj != null && obj instanceof FileType) {
						List<Type> types = DocUtils.getListTypes(((FileType) obj).getName());
						bean.setListType(types);
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

}
