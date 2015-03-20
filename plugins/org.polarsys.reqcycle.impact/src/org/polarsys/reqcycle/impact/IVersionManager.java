/**
 * Copyright (c) 2014 AtoS
 *     All rights reserved. This program and the accompanying materials
 *     are made available under the terms of the Eclipse Public License v1.0
 *     which accompanies this distribution, and is available at
 *     http://www.eclipse.org/legal/epl-v10.html *
 *     Contributors:
 *       Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.impact;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFileState;
import org.eclipse.team.core.RepositoryProvider;
import org.eclipse.team.core.history.IFileRevision;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;

public interface IVersionManager {
	public Map<RepositoryProvider, Collection<IFileRevision>> getHistory(RequirementSource requirementSource);

	public List<IFileState> getLocalHistory(RequirementSource requirementSource);

	public RequirementSource loadResource(IFileRevision rev, String dataModelURI, Scope scope, String resourceName);

	public RequirementSource loadLocalHistoryResource(IFileState fileState, String dataModelURI, Scope scope, String resourceName);

}
