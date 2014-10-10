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
package org.polarsys.reqcycle.repository.connector.update;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.IStartup;
import org.polarsys.reqcycle.impact.Impact.ImpactAnalysis;
import org.polarsys.reqcycle.repository.connector.update.preferences.PreferenceController;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.utils.configuration.IConfigurationManager;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class JobUpdateReference extends Job implements IStartup {
	IConfigurationManager configurationManager = ZigguratInject.make(IConfigurationManager.class);
	// Requirement Source Manager
	IDataManager dataManager = ZigguratInject.make(IDataManager.class);
	
	List<RequirementSource> listReqSourcesInRef;


	public JobUpdateReference() {
		super("Job update reference");
		setRule(MutexRule.INSTANCE);
	}

	@Override
	public void earlyStartup() {
		schedule();
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		//	monitor.beginTask("Begin updating requirement source in reference mode", totalWork);
		int timer = PreferenceController.getRefreshTime() * 1000;
		try {
			
			Boolean isImpactAnalysis = PreferenceController.isImpactAnalysis();
			
			//get all requirement resource
			if(dataManager != null){
				Set<RequirementSource> listReqSources = dataManager.getRequirementSources();
				UpdateRequirementSourcesHandler updateReqSourceHandler = new UpdateRequirementSourcesHandler();
				
				
				if (listReqSources != null){
					//get all requirement resource in reference mode
					listReqSourcesInRef = new ArrayList<RequirementSource>();
					for (RequirementSource reqS : listReqSources){
						//a requirement source is in reference mode if his destination URI is null
						if (reqS.getDestinationURI() == null){
							listReqSourcesInRef.add(reqS);				
						}
					}
				}
				
				// Step1 -- get a copy of all requirements sources
				Map<RequirementSource, RequirementSource> storageOldNewReqSources = new HashMap<RequirementSource, RequirementSource>();
				storageOldNewReqSources = updateReqSourceHandler.createCopyReqSrc(listReqSourcesInRef, dataManager);
				
				// Step2 -- generate all impacts analysis
				Map<RequirementSource, ImpactAnalysis> mapReqSourcesWithImpactAna = new HashMap<RequirementSource, ImpactAnalysis>();
				mapReqSourcesWithImpactAna = updateReqSourceHandler.generateAllImpacts(storageOldNewReqSources, monitor);
				
				// Step3 -- updating all requirements
				String destinationPath = PreferenceController.getPathForImpactAnalysis();
				for (Map.Entry<RequirementSource, ImpactAnalysis> reqSrcWithImpact : mapReqSourcesWithImpactAna.entrySet()) {
					updateReqSourceHandler.finalizedUpdateReqSrc(reqSrcWithImpact.getKey(), reqSrcWithImpact.getValue(), dataManager, storageOldNewReqSources);
					
					//Step 4 -- Save impact analysis
					if(isImpactAnalysis && destinationPath != null && !destinationPath.isEmpty()){
						updateReqSourceHandler.saveImpactAnalysis(destinationPath, reqSrcWithImpact.getValue(), reqSrcWithImpact.getKey().getName());
					}
					
				}			
				
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally{
			schedule(timer);
		}
		
		return Status.OK_STATUS;
	}


}
