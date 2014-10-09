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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Display;
import org.polarsys.reqcycle.impact.Impact.ImpactAnalysis;
import org.polarsys.reqcycle.impact.Impact.ImpactFactory;
import org.polarsys.reqcycle.impact.Impact.RequirementImpacted;
import org.polarsys.reqcycle.ocl.OCLCallable;
import org.polarsys.reqcycle.repository.connector.ConnectorDescriptor;
import org.polarsys.reqcycle.repository.connector.ICallable;
import org.polarsys.reqcycle.repository.connector.IConnector;
import org.polarsys.reqcycle.repository.connector.IConnectorManager;
import org.polarsys.reqcycle.repository.connector.document.DocCallable;
import org.polarsys.reqcycle.repository.connector.document.ocl.DocOclCallable;
import org.polarsys.reqcycle.repository.connector.rmf.RMFCallable;
import org.polarsys.reqcycle.repository.connector.update.rs.pages.DialogImpactAnalysis;
import org.polarsys.reqcycle.repository.connector.update.rs.preferences.PreferenceController;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementSourceDataFactory;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Section;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Trash;
import org.polarsys.reqcycle.utils.collect.IterableFactory;
import org.polarsys.reqcycle.utils.collect.Picker;
import org.polarsys.reqcycle.utils.collect.exceptions.CannotPickException;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class UpdateRequirementSourcesHandler {

	IConnectorManager connManager = ZigguratInject.make(IConnectorManager.class);
	
	//Requirement Source Manager
	IDataManager requirementSourceManager = ZigguratInject.make(IDataManager.class);

	private Map<RequirementSource, String> InputRequirementSources;
	
	// this map contains all initials and generated req sources
	private Map<RequirementSource, RequirementSource> storageOldNewReqSources;
	
	// this map contains new requirements sources updated and all analysis impact
	private Map<RequirementSource, ImpactAnalysis> mapReqSourcesWithImpactAna;
	
	// this map contains the final requirements sources selected in window DialogUpdatePage
	private Map<RequirementSource, ImpactAnalysis> finalMapReqSourcesWithImpactAna;


	/**
	 * @param requirementSources
	 */
	public UpdateRequirementSourcesHandler(Map<RequirementSource, String> requirementSources) {
		super();
		this.InputRequirementSources = requirementSources;
	}
	
	public UpdateRequirementSourcesHandler() {
		super();
	}

	public void run(IProgressMonitor monitor) {

		// Step 1 --- get a copy of all requirements sources
		storageOldNewReqSources = new HashMap<RequirementSource, RequirementSource>();
		storageOldNewReqSources = createCopyReqSrc(InputRequirementSources, requirementSourceManager);

		// Step 2 --- generate all impacts analysis
		mapReqSourcesWithImpactAna = new HashMap<RequirementSource, ImpactAnalysis>();
		mapReqSourcesWithImpactAna = generateAllImpacts(storageOldNewReqSources, monitor);

		//  Step 3 --- display impact analysis dialog
		monitor.done();
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				final DialogImpactAnalysis impactAnaDialog = new DialogImpactAnalysis(Display.getDefault().getActiveShell(), InputRequirementSources);
				impactAnaDialog.setReqSourceWithImpAnalysis(mapReqSourcesWithImpactAna);
				impactAnaDialog.open();

				// Step 4 --- updating all requirements sources : return code = 0 if OK is pressed and 1 if CANCEL pressed in impact dialog analysis
				if (impactAnaDialog.getReturnCode() == 0) {
					finalMapReqSourcesWithImpactAna = impactAnaDialog.getFinalMapReqSourcesWithImpactAna();
					
					for (Map.Entry<RequirementSource, ImpactAnalysis> reqSrcWithImpact : finalMapReqSourcesWithImpactAna.entrySet()) {
						finalizedUpdateReqSrc(reqSrcWithImpact.getKey(), reqSrcWithImpact.getValue(), requirementSourceManager, storageOldNewReqSources);

					}
				}
			}
		});

	}

	private Map<RequirementSource, RequirementSource> createCopyReqSrc(Map<RequirementSource, String>InputRequirementSources, IDataManager requirementSourceManager) {
		Map<RequirementSource, RequirementSource> storageReqSources =new HashMap<RequirementSource, RequirementSource>();
		for (Map.Entry<RequirementSource, String> reqSrc : InputRequirementSources.entrySet()) {
			RequirementSource newReqSource = EcoreUtil.copy(reqSrc.getKey());
		
			try {
				newReqSource.setRepositoryURI(reqSrc.getValue());
				// using the impact analysis to check all changes
				regenerateRequirementSource(newReqSource, requirementSourceManager);
				storageReqSources.put(reqSrc.getKey(), newReqSource);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return storageReqSources;
	}
	
	protected Map<RequirementSource, RequirementSource> createCopyReqSrc(List<RequirementSource> InputRequirementSources, IDataManager requirementSourceManager) {
		Map<RequirementSource, RequirementSource> storageReqSources =new HashMap<RequirementSource, RequirementSource>();
		for (RequirementSource reqSrc : InputRequirementSources) {
			RequirementSource newReqSource = EcoreUtil.copy(reqSrc);
				// using the impact analysis to check all changes
				regenerateRequirementSource(newReqSource, requirementSourceManager);
				storageReqSources.put(reqSrc, newReqSource);
		}
		return storageReqSources;
	}
	
	protected void finalizedUpdateReqSrc(RequirementSource currentReqSource, ImpactAnalysis currentImpact, IDataManager requirementSourceManager, Map<RequirementSource, RequirementSource> storageOldNewReqSources) {
		RequirementSource reqSource = currentReqSource;
		RequirementSource oldrqSources = getOldReqSource(storageOldNewReqSources, reqSource);
		Section sectionTrash = null;

		if (oldrqSources != null) {
		
			// creating a new section for new deleted requirements
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
			Date date = new Date();
			final String currentDate = "_Trash_" + dateFormat.format(date);
			Section sectionReqDel = requirementSourceManager.createTrash(reqSource.getName() + currentDate, "Trash", "");

			// fill trash chapter all news requirements sources
			ImpactAnalysis currentImpactA = currentImpact;
			ArrayList<RequirementImpacted> deletedRequirements = new ArrayList<RequirementImpacted>();
			if (currentImpactA != null) {
				deletedRequirements.addAll(currentImpactA.getRequirementsDeleted());
			}

			for (RequirementImpacted absreq : deletedRequirements) {
				List<AbstractElement> listAbstractElem = oldrqSources.getRequirements();
				Iterable<AbstractElement> reqs = IterableFactory.createIterable(listAbstractElem, new Picker<AbstractElement>() {

					@Override
					public Iterable<AbstractElement> getNexts(AbstractElement element) throws CannotPickException {
						if (element instanceof Section) {
							return ((Section) element).getChildren();
						}
						return Collections.emptyList();
					}
				});

				for (AbstractElement req : reqs) {
					if (req instanceof AbstractElement && ((AbstractElement) req).getId().equals(absreq.getId())) {
						requirementSourceManager.addElementsToSection(sectionReqDel, (AbstractElement) req);
					}
				}
			}

			// create trash chapter section if requirement source haven't already a Trash
			Boolean reqTrashIsFound = false;
			for (AbstractElement requirement : reqSource.getRequirements()) {
				if (requirement instanceof Trash) {
					reqTrashIsFound = true;
					sectionTrash = (Section) requirement;
					break;
				}
			}

			if (!reqTrashIsFound) {
				// create trash chapter section
				sectionTrash = requirementSourceManager.createTrash(reqSource.getName() + "_Trash", "Trash", "");
				
				if (sectionReqDel.getChildren() != null && sectionReqDel.getChildren().size() > 0) {
					requirementSourceManager.addElementsToSection(sectionTrash, sectionReqDel);
				}
				
				if (sectionTrash.getChildren() != null && sectionTrash.getChildren().size() > 0) {
				requirementSourceManager.addElementsToSource(reqSource, sectionTrash);
				}
			}
			
			//fill an existing trash chapter
			if (sectionReqDel.getChildren() != null && sectionReqDel.getChildren().size() > 0) {
				requirementSourceManager.addElementsToSection(sectionTrash, sectionReqDel);
			}
			// update requirements sources
			requirementSourceManager.removeRequirementSource(oldrqSources, true);
			requirementSourceManager.addRequirementSource(reqSource);
		}
	}

	protected Map<RequirementSource, ImpactAnalysis> generateAllImpacts(Map<RequirementSource, RequirementSource> mapReq, IProgressMonitor monitor) {
		Map<RequirementSource, ImpactAnalysis> mapWhithAnalysis = new HashMap<RequirementSource, ImpactAnalysis>();
		monitor.beginTask("Updating", mapReq.entrySet().size());
		for (Map.Entry<RequirementSource, RequirementSource> reqSrc : mapReq.entrySet()) {
			ImpactAnalysis analysis = ImpactFactory.eINSTANCE.createImpactAnalysis();
			analysis.launchAnalysis(reqSrc.getKey(), reqSrc.getValue());
			mapWhithAnalysis.put(reqSrc.getValue(), analysis);
			monitor.worked(1);
		}
		return mapWhithAnalysis;

	}
	
	protected void saveImpactAnalysis(String destinationPath, ImpactAnalysis analysis){
		URI destPath = getURI(PreferenceController.getPathForImpactAnalysis());
		if (analysis != null){
			analysis.saveAnalysis(destPath);			
		}
		
	}
	
	private URI getURI(String pathForImpactAnalysis) {
		Path path = new Path(pathForImpactAnalysis);
		IContainer cont = null;
		if (path.segmentCount() == 1){
			cont = ResourcesPlugin.getWorkspace().getRoot().getProject(pathForImpactAnalysis);
			if (!cont.exists()){
				try {
					((IProject)cont).create(new NullProgressMonitor());
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
		else {
			cont = ResourcesPlugin.getWorkspace().getRoot().getFolder(path);
			if (!cont.exists()){
				try {
					((IFolder)cont).create(true,true,new NullProgressMonitor());
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
		if (cont != null){
			return URI.createPlatformResourceURI(cont.getFullPath().toString(), true);
		}
		return null;
	}

	// return the old requirement source which has just been updated
	private RequirementSource getOldReqSource(Map<RequirementSource, RequirementSource> storageReqSources, RequirementSource newReqSource) {
		RequirementSource oldReqSource = null;
		for (Entry<RequirementSource, RequirementSource> mapReq : storageReqSources.entrySet()) {
			if (mapReq.getKey().getName().equals(newReqSource.getName())) {
				oldReqSource = mapReq.getKey();
			}
		}
		return oldReqSource;
	}

	private void regenerateRequirementSource(RequirementSource source, IDataManager dataManager) {
		ICallable createRequirementSource = null;
		String idConnector = source.getConnectorId();

		if (idConnector != null && !idConnector.equals("")) {
			createRequirementSource = getRequirementsCreator(idConnector);
		}

		try {
			if (createRequirementSource == null) {
				throw new Exception("requirement source is null; Should not occur = bug");
			}
			
			//save section before creation of new contents			
			List<AbstractElement> sections = source.getRequirements();

			source.setContents(RequirementSourceDataFactory.eINSTANCE.createRequirementsContainer());
		
			//re inject trash section
			Section sectionTrash = null;
			for (AbstractElement abs : sections){
				if( abs instanceof Trash){
					sectionTrash = (Section) abs; 				
				}
			}
			createRequirementSource.fillRequirementSource(source);
			if(sectionTrash != null && sectionTrash.getChildren() != null){
				dataManager.addElementsToSource(source, sectionTrash);		
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private ICallable getRequirementsCreator(String idConnector) {
	
		ConnectorDescriptor connectorD = connManager.get(idConnector);
		IConnector createConnector;
		
		try {
			createConnector = connectorD.createConnector();
			ICallable callable = createConnector.getRequirementsCreator();
			if (idConnector.equals(connectorD.getId())) {
				return callable;
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return null;

	}

	public Map<RequirementSource, String> getInputRequirementSources() {
		return InputRequirementSources;
	}

	public void setInputRequirementSources(Map<RequirementSource, String> requirementSources) {
		this.InputRequirementSources = requirementSources;
	}
	
	public Map<RequirementSource, ImpactAnalysis> getFinalMapReqSourcesWithImpactAna() {
		return finalMapReqSourcesWithImpactAna;
	}

	public void setFinalMapReqSourcesWithImpactAna(Map<RequirementSource, ImpactAnalysis> finalMapReqSourcesWithImpactAna) {
		this.finalMapReqSourcesWithImpactAna = finalMapReqSourcesWithImpactAna;
	}



}
