package org.polarsys.reqcycle.impact.Impact.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFileState;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.team.core.RepositoryProvider;
import org.eclipse.team.core.history.IFileHistory;
import org.eclipse.team.core.history.IFileHistoryProvider;
import org.eclipse.team.core.history.IFileRevision;
import org.polarsys.reqcycle.impact.IVersionManager;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementsContainer;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Singleton
public class VersionManager implements IVersionManager {

	@Inject
	IDataManager dataManager;

	public VersionManager() {
		ZigguratInject.inject(this);
	}

	public Map<RepositoryProvider, Collection<IFileRevision>> getHistory(RequirementSource requirementSource) {
		Map<RepositoryProvider, Collection<IFileRevision>> versions = Maps.newHashMap();

		IFile file = WorkspaceSynchronizer.getFile(requirementSource.getContents().eResource());
		IProject proj = file.getProject();

		String[] repoTypes = RepositoryProvider.getAllProviderTypeIds();
		ArrayList<RepositoryProvider> repos = Lists.newArrayList();

		for (String repoType : repoTypes) {
			RepositoryProvider repo = RepositoryProvider.getProvider(proj, repoType);
			if (repo != null) {
				repos.add(repo);
			}
		}

		for (RepositoryProvider repo : repos) {
			IFileHistory history = repo.getFileHistoryProvider().getFileHistoryFor(file, IFileHistoryProvider.NONE, null);
			IFileRevision[] revs = history.getFileRevisions();

			versions.put(repo, Arrays.asList(revs));
		}

		return versions;
	}

	public ArrayList<IFileState> getLocalHistory(RequirementSource requirementSource) {
		IFile file = WorkspaceSynchronizer.getFile(requirementSource.getContents().eResource());

		try {
			IFileState[] localHistory = file.getHistory(null);

			return Lists.newArrayList(localHistory);
		} catch (CoreException e) {
			e.printStackTrace();
		}

		return null;
	}

	public RequirementSource loadResource(IFileRevision rev, String dataModelURI, Scope scope, String resourceName) {
		IStorage storage = null;
		InputStream c = null;

		try {
			storage = rev.getStorage(null);
			c = storage.getContents();
		} catch (CoreException e) {
			e.printStackTrace();
			return null;
		}

		return loadResource(c, dataModelURI, scope, resourceName, URI.createURI(rev.getURI().toString()));
	}

	public RequirementSource loadLocalHistoryResource(IFileState fileState, String dataModelURI, Scope scope, String resourceName) {
		InputStream input;
		try {
			input = fileState.getContents();
		} catch (CoreException e) {
			e.printStackTrace();
			return null;
		}
		return loadResource(input, dataModelURI, scope, resourceName, URI.createPlatformResourceURI(fileState.getFullPath().toString(), true));
	}

	private RequirementSource loadResource(InputStream inputStream, String dataModelURI, Scope scope, String resourceName, URI fileURI) {
		RequirementSource source = null;
		try {

			Resource resource = new XMIResourceImpl(fileURI) {
				@Override
				protected boolean useUUIDs() {
					return true;
				}
			};

			resource.load(inputStream, Collections.emptyMap());

			EList<EObject> contents = resource.getContents();
			Iterator<EObject> iter = contents.iterator();
			while (iter.hasNext()) {
				EObject eObject = iter.next();
				if (eObject instanceof RequirementsContainer) {
					source = dataManager.createRequirementSource();

					source.setName(resourceName);
					source.setDataModelURI(dataModelURI);
					source.setDefaultScope(scope);

					source.setContents((RequirementsContainer) eObject);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return source;
	}
}
