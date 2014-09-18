/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Abdellah El Ayadi (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.reqcycle.export.pages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.polarsys.reqcycle.export.transform.IRequirementProvider;
import org.polarsys.reqcycle.predicates.core.api.IPredicate;

public class WizardController {
	private List<IProject> projectsResult = new ArrayList<IProject>();
	private HashSet<IRequirementProvider> reqResult = new HashSet<IRequirementProvider>();
	HashSet<IPredicate> predicateResult = new HashSet<IPredicate>();
	private String outputPath;

	public void clearProjectResults() {
		projectsResult.clear();
	}

	public void addProjectResult(IProject iProject) {
		projectsResult.add(iProject);
	}

	public void addPredicateResult(IPredicate element) {
		predicateResult.add(element);
	}

	public void removePredicateResult(IPredicate element) {
		predicateResult.remove(element);
	}

	public void addReqProvider(IRequirementProvider requirementSourceReqProvider) {
		reqResult.add(requirementSourceReqProvider);
	}

	public void removeReqProvider(IRequirementProvider requirementSourceReqProvider) {
		reqResult.remove(requirementSourceReqProvider);
	}

	public List<IProject> getProjectsResult() {
		return projectsResult;
	}

	public HashSet<IRequirementProvider> getReqResult() {
		return reqResult;
	}

	public HashSet<IPredicate> getPredicateResult() {
		return predicateResult;
	}

	public String getOutputPath() {
		return outputPath;
	}

	public void setOutputPath(String path) {
		outputPath = path;
	}

}
