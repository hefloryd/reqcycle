/*******************************************************************************
 *  Copyright (c) 2013, 2014 AtoS and others
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Olivier Melois (AtoS) - initial API and implementation and/or initial documentation
 *    Raphael Faudou (Samares Engineering) - Fixed some bugs in OCL connector to manage types and align
 * 		connector on other connectors with a destination file
 *    Malick WADE (AtoS) - restructuring connector architecture
 *******************************************************************************/
package org.polarsys.reqcycle.ocl.ui;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.Wizard;
import org.polarsys.reqcycle.ocl.OCLCallable;
import org.polarsys.reqcycle.ocl.ReqcycleOCLPlugin;
import org.polarsys.reqcycle.repository.connector.ICallable;
import org.polarsys.reqcycle.repository.connector.IURIValidatorConnector;
import org.polarsys.reqcycle.repository.connector.ui.wizard.IConnectorWizard;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

public class OCLConnector extends Wizard implements IConnectorWizard,IURIValidatorConnector {

	public OCLConnector() {
		super();
	}

	protected SettingPage oclSettingPage;

	protected OCLPage oclMappingPage;

	protected SettingBean bean = new SettingBean(this);

	private RequirementSource requirementSource = null;

	@Inject
	IDataModelManager manager;

	@Inject
	IDataManager dataManager;

	@Override
	public void addPages() {
		oclSettingPage = new SettingPage(bean);
		oclMappingPage = new OCLPage(bean);
		addPage(oclSettingPage);
		addPage(oclMappingPage);
		super.addPages();
	}

	@Override
	public ICallable getRequirementsCreator() {

		OCLCallable callable = ZigguratInject.make(OCLCallable.class);

		return callable;
	}

	@Override
	public void initializeWithRequirementSource(RequirementSource requirementSource) {
		this.requirementSource = requirementSource;
	}

	@Override
	public boolean performFinish() {
		return true;
	}

	@Override
	public boolean canFinish() {
		if (bean != null && bean.getOclUri() != null && bean.getDataModel() != null && bean.getUri() != null && !bean.getOclUri().isEmpty() && !bean.getUri().isEmpty()) {
			if (bean.getIsReference()) {
				return true;
			} else
				return !bean.getOutputPath().isEmpty();
		}
		return false;
	}

	@Override
	public void init(ISelection selection, String name) {

	}

	@Override
	public void storeProperties(RequirementSource source) {
		bean.storeProperties(source);
	}

	private static Set<String> loadExtensions() {
		final IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor("org.eclipse.emf.ecore","extension_parser");
		HashSet<String> set = Sets.newHashSet(
				Iterables.transform(Arrays.asList(elements), new Function<IConfigurationElement, String>() {
					@Override
					public String apply(IConfigurationElement arg0) {
						return arg0.getAttribute("type").toLowerCase();
					}
				})
		) ;
		set.add("xmi");
		return set;
	}
	
	@Override
	public IStatus validate(URI uri){
		Set<String> EXTENSIONS = loadExtensions ();

		String extension = uri.path().substring(uri.path().lastIndexOf(".")+1, uri.path().length());
		if (EXTENSIONS.contains(extension.toLowerCase())){
			return Status.OK_STATUS;
		}
		return new Status(IStatus.WARNING, ReqcycleOCLPlugin.PLUGIN_ID, "extension \"" + extension + "\" could not be supported");

	}
	
	
	
}
