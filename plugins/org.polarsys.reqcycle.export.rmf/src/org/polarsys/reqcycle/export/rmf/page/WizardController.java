/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Abdellah El Ayadi (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.reqcycle.export.rmf.page;

import java.util.HashSet;

import org.eclipse.emf.common.util.URI;
import org.polarsys.reqcycle.export.rmf.transform.IRequirementProvider;

public class WizardController {

	private HashSet<IRequirementProvider> reqResult = new HashSet<IRequirementProvider>();

	private URI outputUri;

	public void addReqProvider(IRequirementProvider requirementSourceReqProvider) {
		reqResult.add(requirementSourceReqProvider);
	}

	public void removeReqProvider(IRequirementProvider requirementSourceReqProvider) {
		reqResult.remove(requirementSourceReqProvider);
	}

	public HashSet<IRequirementProvider> getReqResult() {
		return reqResult;
	}

	public URI getOutputUri() {
		return outputUri;
	}

	public void setOutputUri(URI outputUri) {
		this.outputUri = outputUri;
	}

}
