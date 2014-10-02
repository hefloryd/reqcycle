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
package org.polarsys.reqcycle.repository.connector.document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.polarsys.reqcycle.inittypes.inittypes.FileType;
import org.polarsys.reqcycle.inittypes.inittypes.Requirement;
import org.polarsys.reqcycle.inittypes.inittypes.Type;
import org.polarsys.reqcycle.repository.connector.ICallable;
import org.polarsys.reqcycle.repository.connector.document.ui.DocMappingPage;
import org.polarsys.reqcycle.repository.connector.document.ui.DocSettingPage;
import org.polarsys.reqcycle.repository.connector.ui.PropertyUtils;
import org.polarsys.reqcycle.repository.connector.ui.wizard.IConnectorWizard;
import org.polarsys.reqcycle.repository.connector.ui.wizard.pages.AbstractStorageBean;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.MappingModel.MappingElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;


public class DocConnector extends Wizard implements IConnectorWizard{
	
	//page of wizard
	protected DocSettingPage docSettingPage;
	
	protected DocMappingPage docMappingPage;
	
	protected List<Type> listTypes;
	
	protected boolean edition = false;
	
	protected RequirementSource initSource;

	protected DOCSettingBean bean;
	
	protected URI initFileUri;
	
	@Inject
	IDataManager dataManager;
	
	@Override
	public void initializeWithRequirementSource(RequirementSource requirementSource) {
		initSource = requirementSource;
		edition = true;
		
	}
	
	@Override
	public void addPages() {
		bean = new DOCSettingBean();
		
		docSettingPage = new DocSettingPage(bean);
		docMappingPage = new DocMappingPage(bean); 
		addPage(docSettingPage);
		addPage(docMappingPage);
		super.addPages();
	}
	

	@Override
	public ICallable getRequirementsCreator() {
		DocCallable callable = ZigguratInject.make(DocCallable.class);
		return callable;
	}
	
	@Override
	public void init(ISelection selection, String name) {
		if(selection instanceof IStructuredSelection) {
			Object obj = ((IStructuredSelection)selection).getFirstElement();
			if(obj instanceof IFile) {
				initFileUri = URI.createPlatformResourceURI(((IFile)obj).getFullPath().toPortableString(), true);
			}
		}
		
	}

	@Override
	public boolean performFinish() {
		return true;
	}
	 
	@Override
	public boolean canFinish() {
		
		if(docMappingPage != null && bean.getListType() != null && bean.getListType().size()>0){
		return docMappingPage.isPageComplete();
		}
		return false;
	}


	public class DOCSettingBean extends AbstractStorageBean {
		
		//DOC MAPPING PAGE
		private List<Requirement> listSelectedRequirements;
		
		private Type type;
		
		private List<Type> listType = null;
		
		private FileType fileType;
		
		public DOCSettingBean() {
			this.listSelectedRequirements = new ArrayList<Requirement>();
		}

		

		public FileType getFileType() {
			return fileType;
		}

		public void setFileType(FileType fileType) {
			this.fileType = fileType;
		}

		
		public List<Type> getListType() {
			return listType;
		}

		public void setListType(List<Type> listType) {
			this.listType = listType;
		}
		
		public Type getType() {
			return type;
		}


		public void setType(Type type) {
			this.type = type;
		}


		public List<Requirement> getListValideRequirements() {
			return listSelectedRequirements;
		}


		public void setListValideRequirements(List<Requirement> listSelectedRequirements) {
			this.listSelectedRequirements = listSelectedRequirements;
		}


		
		
		@Override
		public void storeProperties(RequirementSource source) {
			super.storeProperties(source);
			try {

				source.setProperty(IDOCConstants.DOC_NAME,this.getType().getName());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		

	}



	@Override
	public void storeProperties(RequirementSource source) {
	
		bean.storeProperties(source);

		Collection<MappingElement> mapElements = new ArrayList<MappingElement>();
		if (bean.getListValideRequirements() != null) {
			mapElements = DocUtils.mappingElements(bean.getListValideRequirements(), PropertyUtils.getDataModelFromSource(source).getTypes());
		}
		source.getMappings().addAll(mapElements);
		
	}

}
