package org.polarsys.reqcycle.repository.connector.document.ocl.ui;

import java.util.Collections;
import java.util.List;

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
import org.polarsys.reqcycle.repository.connector.ui.wizard.pages.AbstractStorageBean;

public class DocOclSettingPage extends AbstractSettingPage{

	
	private Text txtSelectedDoc;

	private Button btnBrowseDoc;
	
	private OCLDocBean bean;

	private ComboViewer viewer;

	public DocOclSettingPage(SettingBean bean) {
		super("Document OCL Connector settings");
		this.bean = (OCLDocBean) bean ;
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
		viewer = new ComboViewer(compositeContainer);
		viewer.setContentProvider(ArrayContentProvider.getInstance());
		viewer.setLabelProvider(new LabelProvider(){
			@Override
			public String getText(Object element) {
				if (element instanceof IContentHandler) {
					IContentHandler<DocumentModel> handler = (IContentHandler<DocumentModel>) element;
					return handler.getLabel();
				}
				return super.getText(element);
			}
		});
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection structured = (IStructuredSelection) event.getSelection();
					IContentHandler<DocumentModel> handler = (IContentHandler<DocumentModel>) structured.getFirstElement();
					bean.setHandlerClassName (handler.getClass().getName());
				}
			}
		});
		viewer.setInput(Collections.emptyList());
		viewer.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		return compositeContainer;
	}
	
	@Override
	protected void specificHookListeners() {
		getDestinationFileSelectionListener();
		
		btnBrowseDoc.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ResourceDialog dialog = new ResourceDialog(getShell(), "Select a document", SWT.NONE);
				
				if(Window.OK == dialog.open()){
					List<URI> uris = dialog.getURIs();
					
					if(!uris.isEmpty()) {
						//asking doc2Modele if the file extension is 
						String fileString = CommonPlugin.asLocalURI(uris.get(0)).toFileString();
					    Doc2Model<DocumentModel> doc2Model = new Doc2Model<DocumentModel>();
						String fileType = doc2Model.getFileType(fileString);
						if (fileType.toString() != null){
							txtSelectedDoc.setText(uris.get(0).toString());	
							viewer.setInput(doc2Model.getContentHandlers(fileString, DocumentModel.class));
					    }
					    else{
						txtSelectedDoc.setText("");
						setErrorMessage("Your document is not supported. Retry and choose document file");
						}
					    getWizard().getContainer().updateMessage();
					    getWizard().getContainer().updateButtons();
					}
			
		}
			}
		});
	}


	@Override
	protected Boolean specificIsPageComplete(Boolean result) {
		  if (txtSelectedDoc.getText() == null || txtSelectedDoc.getText()== "") {
		  
		  return result = false; 
		  }	
		 return result;
	}
	
	@Override
	protected StringBuffer specificIsPageComplete(Boolean result, StringBuffer error) {
		if ( result == false) {
		return  new StringBuffer("Choose a document Input\n");
		}
		return error;
	}


	@Override
	protected void doSpecificInitDataBindings(DataBindingContext bindingContext) {
		IObservableValue observeTextTxtSelectedDocObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtSelectedDoc);
		IObservableValue uriBeanObserveValue = PojoProperties.value("uri").observe(bean);
		bindingContext.bindValue(observeTextTxtSelectedDocObserveWidget, uriBeanObserveValue, null, null);
	}


	@Override
	public AbstractStorageBean getBean() {
		return bean;
	}


	
}
