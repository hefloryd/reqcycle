package org.polarsys.reqcycle.impact;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.eclipse.core.resources.IFileState;
import org.eclipse.team.core.RepositoryProvider;
import org.eclipse.team.core.history.IFileRevision;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;

public interface IVersionManager {
	public Map<RepositoryProvider, Collection<IFileRevision>> getHistory(RequirementSource requirementSource);

	public ArrayList<IFileState> getLocalHistory(RequirementSource requirementSource);

	public RequirementSource loadResource(IFileRevision rev, String dataModelURI, Scope scope, String resourceName);

	public RequirementSource loadLocalHistoryResource(IFileState fileState, String dataModelURI, Scope scope, String resourceName);

}
