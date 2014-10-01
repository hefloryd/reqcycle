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
package org.polarsys.reqcycle.repository.connector.local;

import javax.inject.Inject;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.Wizard;
import org.polarsys.reqcycle.repository.connector.ICallable;
import org.polarsys.reqcycle.repository.connector.ui.wizard.IConnectorWizard;
import org.polarsys.reqcycle.repository.connector.ui.wizard.pages.AbstractSettingPage;
import org.polarsys.reqcycle.repository.connector.ui.wizard.pages.AbstractStorageBean;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;
import org.polarsys.reqcycle.repository.data.types.IDataModel;

public class LocalConnector extends Wizard implements IConnectorWizard {

	public final static String LOCAL_CONNECTOR_ID = "org.polarsys.reqcycle.repository.connector.local.connectorCore";

	@Inject
	IDataManager manager;

	private AbstractSettingPage settingPage;

	private IDataModel dataModel;

	private Scope scope;

	private String destination;

	public LocalConnector() {
	}

	@Override
	public void initializeWithRequirementSource(RequirementSource requirementSource) {
	}

	@Override
	public ICallable getRequirementsCreator() {
		return new ICallable() {

			@Override
			public void fillRequirementSource(RequirementSource source) throws Exception {
				// source.setProperty(IRequirementSourceProperties.IS_LOCAL, "true");
			}
		};
	}

	@Override
	public void init(ISelection selection, String name) {
		// Don't need to init
	}

	@Override
	public boolean performFinish() {
		if (settingPage == null) {
			return false;
		}
		dataModel = settingPage.getBean().getDataModel();
		scope = settingPage.getBean().getScope();
		destination = settingPage.getBean().getOutputPath();
		return true;
	}

	@Override
	public void addPages() {
		settingPage = new AbstractSettingPage("Setting Page", new AbstractStorageBean());
		addPage(settingPage);
	}

	@Override
	public void storeProperties(RequirementSource source) {
		// TODO Auto-generated method stub

	}

}
