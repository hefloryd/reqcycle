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
package org.polarsys.reqcycle.repository.connector.rmf;

import java.util.Collection;

import javax.inject.Inject;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.rmf.reqif10.SpecType;
import org.polarsys.reqcycle.repository.connector.ICallable;
import org.polarsys.reqcycle.repository.connector.rmf.ui.RMFRepositoryMappingPage;
import org.polarsys.reqcycle.repository.connector.rmf.ui.RMFSettingPage;
import org.polarsys.reqcycle.repository.connector.ui.wizard.IConnectorWizard;
import org.polarsys.reqcycle.repository.connector.ui.wizard.pages.AbstractStorageBean;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.MappingModel.MappingElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.types.IType;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class RMFConnector extends Wizard implements IConnectorWizard {

	/** Page containing mapping information */
	protected RMFRepositoryMappingPage mappingPage;

	/** Page containing the ReqIF file and skip mapping check box */
	protected RMFSettingPage settingPage;

	protected static Collection mapping;

	protected RequirementSource initSource;

	protected RMFSettingBean bean;

	protected static boolean edition = false;

	@Inject
	IDataModelManager dataTypeManage;

	@Inject
	IDataManager dataManager;

	protected URI initFileUri;

	public RMFConnector() {
	}

	@Override
	public ICallable getRequirementsCreator() {

		// return new ICallable() {
		RMFCallable callable = ZigguratInject.make(RMFCallable.class);
		callable.setMapping(mapping);
		return callable;
	}

	@Override
	public void addPages() {
		// if the wizard is initialized with a requirement source (requirement
		// source edition)
		// then the mapping page is added instead of settingPage
		if (edition) {
			ResourceSet rs = new ResourceSetImpl();
			Collection<SpecType> specTypes = RMFUtils.getReqIFTypes(rs, initSource.getRepositoryUri());
			Collection<IType> eClassifiers = bean.getDataModel().getTypes();
			EList<MappingElement> mapping = initSource.getMappings();
			mappingPage = createMappingPage(specTypes, eClassifiers, mapping);
			addPage(mappingPage);
		} else {
			bean = new RMFSettingBean();
			settingPage = new RMFSettingPage(bean);

			addPage(settingPage);
		}
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page instanceof RMFSettingPage) {
			ResourceSet rs = new ResourceSetImpl();
			if (bean.getUri() != null && !bean.getUri().equals("")) {
				final Collection<SpecType> specTypes = RMFUtils.getReqIFTypes(rs, bean.getUri());

				if (bean.getDataModel() != null) {

					Collection<IType> eClassifiers = bean.getDataModel().getTypes();
					mappingPage = createMappingPage(specTypes, eClassifiers, mapping);
					mappingPage.setWizard(this);
				}
			}

			return mappingPage;
		}
		return super.getNextPage(page);
	}

	private RMFRepositoryMappingPage createMappingPage(final Collection<SpecType> specTypes, final Collection<IType> eClassifiers, final Collection mapping) {
		return new RMFRepositoryMappingPage("ReqIF Mapping", "") {

			@Override
			protected Object getTargetInput() {
				return eClassifiers;
			}

			@Override
			protected String getTargetDetail() {
				return "ReqCycle";
			}

			@Override
			protected IBaseLabelProvider getSourceLabelProvider() {
				return new LabelProvider() {

					@Override
					public String getText(Object element) {
						if (element instanceof SpecType) {
							return ((SpecType) element).getLongName();
						}
						return super.getText(element);
					}
				};
			}

			@Override
			protected Object getSourceInput() {
				return specTypes;
			}

			@Override
			protected String getSourceDetail() {
				return "ReqIF";
			}

			@Override
			protected IContentProvider getSourceContentProvider() {
				return RMFUtils.contentProvider;
			}

			@Override
			protected String getResultDetail() {
				return null;
			}

			@Override
			protected Collection<EObject> addToMapping() {
				return mapping;
			}
		};
	}

	@Override
	public void initializeWithRequirementSource(RequirementSource requirementSource) {
		initSource = requirementSource;
		edition = true;
	}

	@Override
	public void init(ISelection selection, String name) {
		if (selection instanceof IStructuredSelection) {
			Object obj = ((IStructuredSelection) selection).getFirstElement();
			if (obj instanceof IFile) {
				initFileUri = URI.createPlatformResourceURI(((IFile) obj).getFullPath().toPortableString(), true);
			}
		}
	}

	@Override
	public boolean performFinish() {
		if (!edition && mappingPage != null) {
			mapping = mappingPage.getResult();
		}

		return true;
	}

	@Override
	public boolean canFinish() {
		// TODO : refactor using beans
		if (settingPage != null && settingPage.isPageComplete() && bean != null && mappingPage != null && mappingPage.isPageComplete()) {
			return true;
		} else if (initSource != null) {
			return mappingPage != null && mappingPage.isPageComplete();
		}
		return false;
	}

	public static class RMFSettingBean extends AbstractStorageBean {

		private Boolean isCopy = true;

		public RMFSettingBean() {
		}

		public Boolean getIsCopy() {
			return isCopy;
		}

		public void setIsCopy(Boolean isCopy) {
			this.isCopy = isCopy;
		}

		@Override
		public void storeProperties(RequirementSource source) {
			super.storeProperties(source);
			try {
				source.setProperty(IRMFConstants.RMF_IS_COPY, Boolean.toString(getIsCopy()));
				source.setProperty(IRMFConstants.RMF_EDITION, Boolean.toString(edition));
				// PropertyUtils.setEObjectsInSource(source, IRMFConstants.RMF_MAPPING, (List<EObject>) mapping);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void storeProperties(RequirementSource source) {
		bean.storeProperties(source);

	}

}
