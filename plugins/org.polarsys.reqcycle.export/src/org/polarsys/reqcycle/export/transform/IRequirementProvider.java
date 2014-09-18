/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Abdellah El Ayadi (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.reqcycle.export.transform;

import java.util.Map;

import org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement;

public interface IRequirementProvider {
	Iterable<Requirement> getRequirements();

	String getLabel();

	Map<String, String> getMetadata();
}
