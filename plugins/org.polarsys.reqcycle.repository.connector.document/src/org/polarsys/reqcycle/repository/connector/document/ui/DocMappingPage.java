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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.polarsys.reqcycle.inittypes.inittypes.Attribute;
import org.polarsys.reqcycle.inittypes.inittypes.Requirement;
import org.polarsys.reqcycle.inittypes.inittypes.Type;
import org.polarsys.reqcycle.repository.connector.document.DocConnector.DOCSettingBean;
import org.polarsys.reqcycle.repository.connector.document.DocUtils;
import org.polarsys.reqcycle.repository.connector.ui.wizard.pages.IUpdatablePage;
import org.polarsys.reqcycle.repository.data.types.IAttribute;
import org.polarsys.reqcycle.repository.data.types.IRequirementType;
import org.polarsys.reqcycle.repository.data.types.IType;

public class DocMappingPage extends WizardPage implements Listener, IUpdatablePage {

	private Table tableRequirements;
	private ComboViewer cvTypeFile;


	private TableViewer tvRequirements ;
	private Table tableAttributes;
	private TableViewer tvAttributes;
	private TableViewerColumn tvcAttributesNames;

	private TableViewerColumn tvcAttributesTypes;

	private Collection<IAttribute> confAttributes = new ArrayList<IAttribute>();
	
	private final Image reqFound = DocUtils.getImage("signed_yes.gif");
	private final Image reqNotFound =  DocUtils.getImage("signed_no.gif");
	private final Image attNotFound = DocUtils.getImage("warning.gif");
	
	private DOCSettingBean bean;
	private Combo cTypeFile;

	/**
	 * @wbp.parser.constructor
	 */
	public DocMappingPage(DOCSettingBean bean) {
		super("Document Connector Mapping");
		setTitle("Connector document: mapping page");
		this.bean = bean;
	}

	@Override
	public void createControl(Composite parent) {
	Composite composite = new Composite(parent, SWT.NONE);
	composite.setLayout(new GridLayout(3,false));
	setControl(composite);
	
	Label lblTypeFile = new Label(composite, SWT.NONE);
	lblTypeFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
	lblTypeFile.setText("Select a type");
	
	cvTypeFile = new ComboViewer(composite, SWT.READ_ONLY);
	cTypeFile = cvTypeFile.getCombo();
	cTypeFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
	cvTypeFile.setContentProvider(ArrayContentProvider.getInstance());
	cvTypeFile.setLabelProvider(new LabelProvider(){
		@Override
		public String getText(Object element) {
			if(element instanceof Type){
				bean.setType((Type) element);
				return ((Type) element).getName();
			}
			return super.getText(element);
		}
	});
	
	cvTypeFile.setInput(bean.getListType());
	
	Label lhorizSeparator = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
	lhorizSeparator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
	
	Label lblReqType = new Label(composite, SWT.NONE);
	lblReqType.setText("Requirements");
	new Label(composite, SWT.NONE);
	new Label(composite, SWT.NONE);
	
	Composite compositeReq = new Composite(composite, SWT.NONE);
	compositeReq.setLayout(new GridLayout(1, false));
	compositeReq.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
	
	tvRequirements = new TableViewer(compositeReq, SWT.BORDER);
	tableRequirements = tvRequirements.getTable();
	tableRequirements.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
	tableRequirements.setHeaderVisible(true);
	tableRequirements.setLinesVisible(true);
	tvRequirements.setContentProvider(ArrayContentProvider.getInstance());
	
	
	TableViewerColumn tableViewerColumn = new TableViewerColumn(tvRequirements, SWT.NONE);
	TableColumn tblclmnName = tableViewerColumn.getColumn();
	tblclmnName.setWidth(514);
	tblclmnName.setMoveable(true);
	tblclmnName.setText("Name");
	tableViewerColumn.setLabelProvider(new ColumnLabelProvider(){
		@Override
		public String getText(Object element) {
			if(element instanceof Requirement){
				return ((Requirement) element).getNameReq();
			}
			return super.getText(element);
		}
		
		@Override 
		public Image getImage(Object element) {
			
			if(element instanceof Requirement){
				for (IType req : getTypes()){
					if (req.getName().equals(((Requirement)element).getNameReq())){
						return reqFound;					
					}				
				}
				return reqNotFound;
			}
			return super.getImage(element);
		}
	});
	
	Label lblAttributeType = new Label(composite, SWT.NONE);
	lblAttributeType.setText("Attributes");
	new Label(composite, SWT.NONE);
	new Label(composite, SWT.NONE);
	
	Composite compositeAttribute = new Composite(composite, SWT.NONE);
	compositeAttribute.setLayout(new GridLayout(1, false));

	compositeAttribute.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
	
	tvAttributes = new TableViewer(compositeAttribute, SWT.BORDER | SWT.FULL_SELECTION);
	tvAttributes.setContentProvider(ArrayContentProvider.getInstance());
	tableAttributes = tvAttributes.getTable();
	tableAttributes.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
	tableAttributes.setHeaderVisible(true);
	tableAttributes.setLinesVisible(true);
	
	//Columns
			tvcAttributesNames = createTableViewerColumn(tvAttributes, "Name", SWT.None);
			tvcAttributesNames.setLabelProvider(new ColumnLabelProvider() {

				@Override
				public String getText(Object element) {
					if(element instanceof Attribute) {
						return ((Attribute)element).getNameAttribute();
					}
					return super.getText(element);
				}
				
				@Override
				public Image getImage(Object element) {
					if(element instanceof Attribute){
						if (confAttributes !=null){
							for (IAttribute att : confAttributes){
								if (att.getName().equals(((Attribute)element).getNameAttribute())){
								return reqFound;
								}				
							}
						}
						
						return attNotFound;
					}
					return super.getImage(element);
				}
			});

			tvcAttributesTypes = createTableViewerColumn(tvAttributes, "Attribute check", SWT.None);
			tvcAttributesTypes.setLabelProvider(new ColumnLabelProvider() {

				@Override
				public String getText(Object element) {
					if(element instanceof Attribute){
						if (confAttributes !=null){
							for (IAttribute att : confAttributes){
								if (att.getName().equals(((Attribute)element).getNameAttribute())){
								return "OK";
								}				
							}
						}
						return "Warning, this attribute is not found in a configuration";
					}
					return super.getText(element);
				}
			});

		
	hookListeners();

	}

	
	private void hookListeners() {
		
		cvTypeFile.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				//handle button finish and error message
				setErrorMessage(null);								
				ISelection selection = event.getSelection();
				if(selection instanceof IStructuredSelection) {
					Object obj = ((IStructuredSelection)selection).getFirstElement();
					if(obj instanceof Type) {
						List<Requirement> requirements = ((Type)obj).getRequirements();
						tvRequirements.setInput(requirements);
						tvAttributes.setInput(null);						
				//fill a valid list requirement 
						if(getTypes() != null){
						
						bean.setListValideRequirements(requirements);
						}
					}
				}
				getWizard().getContainer().updateButtons();
				getWizard().getContainer().updateMessage();
				
			}
		});
		
		tvRequirements.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				setErrorMessage(null);
				ISelection selection = event.getSelection();
				if(selection instanceof IStructuredSelection){
					Object obj = ((IStructuredSelection) selection).getFirstElement();
					if (obj instanceof Requirement) {
						fillValideAttributes((Requirement) obj);
					}
				}
			}
		});
		
	}
	
	@Override
	public boolean isPageComplete() {
		Boolean finish = true;
		StringBuffer error = new StringBuffer();
		
		if(cvTypeFile == null ){
			finish = false;
		}else if(cvTypeFile.getSelection().isEmpty()){
				error.append("Choose a requirement type\n");
				finish = false;
			}
	
		
		if (!finish){
			setErrorMessage(error.toString());
		}
		return finish;
	}
	
	@Override
	public void hasChanged() {
		if(cvTypeFile != null && ((List<Type>) cvTypeFile.getInput() != bean.getListType())) {
			cvTypeFile.setInput(bean.getListType());
			tvRequirements.setInput(null);
			tvAttributes.setInput(null);
			setErrorMessage(null);
		}
		else if (cvTypeFile != null && bean.getDataModel() != null){
			//reload requirement list			
			List<Requirement> requirements = ((Type) ((IStructuredSelection) cvTypeFile.getSelection()).getFirstElement()).getRequirements();
			tvRequirements.setInput(requirements);
			//reload attribute list
			fillValideAttributes((Requirement) (((IStructuredSelection) tvRequirements.getSelection()).getFirstElement()));

		}

	}
	
	public TableViewerColumn createTableViewerColumn(TableViewer viewer, String title, int style) {
		TableViewerColumn viewerColumn = new TableViewerColumn(viewer, style);
		TableColumn column = viewerColumn.getColumn();
		column.setWidth(168);
		column.setText(title);
		column.setResizable(true);
		column.setMoveable(true);
		return viewerColumn;
	}
	

	
	private Collection<IType> getTypes() {
		if(bean != null){
			return bean.getDataModel().getTypes();
		}
		return null;
	}
	
	
	//control if selected requirement are attribute's in a configuration or not. This control allows to put an OK image or KO image in an iu
	private void fillValideAttributes(Requirement requr){
		//get list attribute in configuration
		Boolean notFound = false;
		for (IType reqType : getTypes()){
			if (reqType instanceof IRequirementType){
				IRequirementType req = (IRequirementType) reqType;
				if ((requr != null) && (req.getName().equals((requr).getNameReq()))){
					confAttributes.addAll(req.getAttributes());
					notFound = true;
					break;
				}		
				
			}
		}
		if (!notFound){
			setErrorMessage("This requirement is not found in a data type configuration");
			tvAttributes.setInput(null);
			} else{
		//list attribute in .type file
		List<Attribute> attributes = (requr).getAttributesReq();
		tvAttributes.setInput(attributes);
			}
	}
	
	public ComboViewer getCvTypeFile() {
		return cvTypeFile;
	}

	public void setCvTypeFile(ComboViewer cvTypeFile) {
		this.cvTypeFile = cvTypeFile;
	}

	public TableViewer getTvRequirement() {
		return tvRequirements;
	}

	public void setTvRequirement(TableViewer tvRequirement) {
		this.tvRequirements = tvRequirement;
	}


	@Override
	public void handleEvent(Event event) {
		// TODO Auto-generated method stub
		
	}
}
