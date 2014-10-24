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

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
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
import org.polarsys.reqcycle.repository.connector.IURIValidatorConnector;
import org.polarsys.reqcycle.repository.connector.rmf.ui.RMFBean;
import org.polarsys.reqcycle.repository.connector.rmf.ui.RMFRepositoryMappingPage;
import org.polarsys.reqcycle.repository.connector.rmf.ui.RMFSettingPage;
import org.polarsys.reqcycle.repository.connector.ui.wizard.IConnectorWizard;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.MappingModel.MappingElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.types.IType;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class RMFConnector extends Wizard implements IConnectorWizard, IURIValidatorConnector {

	/** Page containing mapping information */
	protected RMFRepositoryMappingPage mappingPage;

	/** Page containing the ReqIF file and skip mapping check box */
	protected RMFSettingPage settingPage;

	protected RequirementSource initSource;

	protected RMFBean bean;

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
		return callable;
	}

	@Override
	public void addPages() {
		// if the wizard is initialized with a requirement source (requirement
		// source edition)
		// then the mapping page is added instead of settingPage
		bean = new RMFBean();
		settingPage = new RMFSettingPage(bean);

		addPage(settingPage);
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page instanceof RMFSettingPage) {
			ResourceSet rs = new ResourceSetImpl();
			if (bean.getUri() != null && !bean.getUri().equals("")) {
				final Collection<SpecType> specTypes = RMFUtils.getReqIFTypes(rs, bean.getUri());

				if (bean.getDataModel() != null) {

					Collection<IType> eClassifiers = bean.getDataModel().getTypes();
					mappingPage = createMappingPage(specTypes, eClassifiers);
					mappingPage.setWizard(this);
				}
			}

			return mappingPage;
		}
		return super.getNextPage(page);
	}

	private RMFRepositoryMappingPage createMappingPage(final Collection<SpecType> specTypes, final Collection<IType> eClassifiers) {
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
				// TODO Auto-generated method stub
				return null;
			}

		};
	}

	@Override
	public void initializeWithRequirementSource(RequirementSource requirementSource) {
		initSource = requirementSource;
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

	@Override
	public void storeProperties(RequirementSource source) {
		bean.storeProperties(source);

		if (mappingPage != null && mappingPage.getResult() != null) {
			Collection<MappingElement> mapElements = new ArrayList<MappingElement>();
			for (EObject eo : mappingPage.getResult()) {
				mapElements.add((MappingElement) eo);
			}
			source.getMappings().addAll(mapElements);
		}

	}

	@Override
	public IStatus validate(URI uri) {
		String EXTENSIONS = "reqif";
		String extension = uri.path().substring(uri.path().lastIndexOf(".") + 1, uri.path().length());
		if (EXTENSIONS.contains(extension.toLowerCase())) {
			return Status.OK_STATUS;
		}
		return new Status(IStatus.WARNING, Activator.PLUGIN_ID, "extension \"" + extension + "\" could not be supported");

	}

}
