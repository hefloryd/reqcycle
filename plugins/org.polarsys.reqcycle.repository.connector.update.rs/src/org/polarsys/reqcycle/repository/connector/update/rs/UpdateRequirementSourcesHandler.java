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
package org.polarsys.reqcycle.repository.connector.update.rs;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.polarsys.reqcycle.impact.Impact.ImpactAnalysis;
import org.polarsys.reqcycle.impact.Impact.ImpactFactory;
import org.polarsys.reqcycle.ocl.OCLCallable;
import org.polarsys.reqcycle.repository.connector.ICallable;
import org.polarsys.reqcycle.repository.connector.document.DocCallable;
import org.polarsys.reqcycle.repository.connector.document.ocl.DocOclCallable;
import org.polarsys.reqcycle.repository.connector.rmf.RMFCallable;
import org.polarsys.reqcycle.repository.connector.update.rs.pages.DialogImpactAnalysis;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementSourceDataFactory;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.Lists;

public class UpdateRequirementSourcesHandler {

	/** Requirement Source Manager */
	IDataManager requirementSourceManager = ZigguratInject.make(IDataManager.class);

	private Map<RequirementSource, String> InputrequirementSources;

	private ICallable createRequirementSource = null;

	@Inject
	IEventBroker broker;

	/**
	 * @param requirementSources
	 */
	public UpdateRequirementSourcesHandler(Map<RequirementSource, String> requirementSources) {
		super();
		ZigguratInject.inject(this);
		this.InputrequirementSources = requirementSources;
		run();
	}

	private void run() {

		validateUris(InputrequirementSources);
		
		for (Map.Entry<RequirementSource, String> reqSrc : InputrequirementSources.entrySet()) {

			// validate and update document uri in a requirement source

			//

			// generate a new requirement source with the new document or model path
			RequirementSource newReqSource = EcoreUtil.copy(reqSrc.getKey());
			try {
				newReqSource.setRepositoryURI(reqSrc.getValue());
				// using the impact analysis to check all changes
				regenerateRequirementSource(newReqSource);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// returncode = 0 if OK is pressed and 1 if CANCEL pressed
			int returnCode = getImpactAnalysis(reqSrc.getKey(), newReqSource);

			// update requirements sources
			if (returnCode == 0) {
				requirementSourceManager.removeRequirementSource(reqSrc.getKey(), true);
				getRequirementSourceManager().addRequirementSource(newReqSource);

				List<RequirementSource> list = Lists.newArrayList();
				list.add(reqSrc.getKey());
				list.add(newReqSource);
				broker.post(IUpdateListener.LISTENER, list);
			}
		}
	}

	private void validateUris(Map<RequirementSource, String> inputrequirementSources2) {
		for (Map.Entry<RequirementSource, String> reqSrc : InputrequirementSources.entrySet()) {
			String idConnector = reqSrc.getKey().getConnectorId();

			if (idConnector.equals(IConnectorId.ID_OCL_CONNECTOR) || idConnector.equals(IConnectorId.ID_DOC_OCL_CONNECTOR)) {

			} else if (idConnector.equals(IConnectorId.ID_DOC_CONNECTOR)) {

			} else if (idConnector.equals(IConnectorId.ID_DOC_OCL_CONNECTOR)) {

			}

			/*
			 * else if (idConnector.equals(IConnectorId.ID_LOCAL_CONNECTOR)){
			 * 
			 * }
			 */
			else if (idConnector.equals(IConnectorId.ID_RMF_CONNECTOR)) {

			}
		}

	}

	/**
	 * @param oldSource
	 *            : the source in a configuration
	 * @param updateSource
	 *            : the new generated source updated
	 */
	private int getImpactAnalysis(RequirementSource oldSource, RequirementSource updateSource) {
		int code = 1;
		ImpactAnalysis analysis = ImpactFactory.eINSTANCE.createImpactAnalysis();

		analysis.launchAnalysis(oldSource, updateSource);
		if (analysis.getRequirementsAdded().size() == 0 && analysis.getRequirementsDeleted().size() == 0 && analysis.getRequirementsModified().size() == 0) {
			MessageBox message = new MessageBox(Display.getDefault().getActiveShell());
			message.setMessage("The versions are identical.");
			message.open();
			return code;
		}

		DialogImpactAnalysis impactAnaDialog = new DialogImpactAnalysis(Display.getDefault().getActiveShell(), analysis);
		impactAnaDialog.open();
		return code = impactAnaDialog.getReturnCode();

	}

	private void regenerateRequirementSource(RequirementSource source) {
		String idConnector = source.getConnectorId();

		if (idConnector != null && !idConnector.equals("")) {
			createRequirementSource = getRequirementsCreator(idConnector);
		}

		try {
			if (createRequirementSource == null) {
				throw new Exception("requirement source is null; Should not occur = bug");
			}
			source.setContents(RequirementSourceDataFactory.eINSTANCE.createRequirementsContainer());

			createRequirementSource.fillRequirementSource(source);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private ICallable getRequirementsCreator(String idConnector) {

		ICallable callable = null;

		if (idConnector.equals(IConnectorId.ID_OCL_CONNECTOR)) {
			callable = ZigguratInject.make(OCLCallable.class);
			return callable;
		} else if (idConnector.equals(IConnectorId.ID_DOC_CONNECTOR)) {
			callable = ZigguratInject.make(DocCallable.class);
			return callable;
		} else if (idConnector.equals(IConnectorId.ID_DOC_OCL_CONNECTOR)) {
			callable = ZigguratInject.make(DocOclCallable.class);
			return callable;
		}
		/*
		 * else if (idConnector.equals(IConnectorId.ID_LOCAL_CONNECTOR)){ //callable = ZigguratInject.make(RMFCallable.class); return callable; }
		 */
		else if (idConnector.equals(IConnectorId.ID_RMF_CONNECTOR)) {
			callable = ZigguratInject.make(RMFCallable.class);
			return callable;
		}

		return callable;

	}

	private IDataManager getRequirementSourceManager() {
		if (requirementSourceManager == null) {
			requirementSourceManager = ZigguratInject.make(IDataManager.class);
		}
		return requirementSourceManager;
	}

	public Map<RequirementSource, String> getInputRequirementSources() {
		return InputrequirementSources;
	}

	public void setInputRequirementSources(Map<RequirementSource, String> requirementSources) {
		this.InputrequirementSources = requirementSources;
	}

}
