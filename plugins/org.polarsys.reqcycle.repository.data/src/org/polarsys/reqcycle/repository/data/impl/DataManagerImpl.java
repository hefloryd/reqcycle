/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Anass Radouani (AtoS) - initial API and implementation and/or initial documentation
 *    Malick WADE (Atos) - add trash section
 *******************************************************************************/
package org.polarsys.reqcycle.repository.data.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.polarsys.reqcycle.core.ILogger;
import org.polarsys.reqcycle.repository.data.Activator;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.IDataTopics;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSourceConfFactory;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSources;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementSourceDataFactory;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementsContainer;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Section;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Trash;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;
import org.polarsys.reqcycle.repository.data.types.IAttribute;
import org.polarsys.reqcycle.utils.configuration.IConfigurationManager;
import org.polarsys.reqcycle.utils.configuration.impl.EMFConfResourceFactory.EMFConfResource;

import com.google.common.base.Function;
import com.google.common.collect.Maps;

@Singleton
public class DataManagerImpl implements IDataManager, IResourceChangeListener, IResourceDeltaVisitor {

	protected static final Map<?, ?> SAVE_OPTIONS = Collections.emptyMap(); // Collections.singletonMap(XMIResource.OPTION_SCHEMA_LOCATION, true);

	/** Connector id to repositories */
	private Map<String, Set<RequirementSource>> repositoryMap = new HashMap<String, Set<RequirementSource>>();

	private RequirementSources sources;

	@Inject
	IConfigurationManager confManager;

	public static final String SOURCES_CONF_ID = "org.polarsys.reqcycle.repositories";
	public static final String CONTENTS_CONF_ID = "org.polarsys.reqcycle.repositories.contents";

	@Inject
	IEventBroker broker;

	@Inject
	ILogger logger;

	/**
	 * Constructor
	 */
	@Inject
	DataManagerImpl(IConfigurationManager confManager) {
		this.confManager = confManager;

		Collection<EObject> conf = confManager.getConfiguration(null, IConfigurationManager.Scope.WORKSPACE, SOURCES_CONF_ID, null, null, true);

		EObject element = null;
		if (conf != null && !conf.isEmpty()) {
			element = conf.iterator().next();
		}

		if (element instanceof RequirementSources) {
			sources = (RequirementSources) element;
			Collection<RequirementSource> RequirementSources = sources.getRequirementSources();
			for (RequirementSource requirementSourceRepository : RequirementSources) {
				String connectorId = requirementSourceRepository.getConnectorId();
				if (repositoryMap.containsKey(connectorId)) {
					repositoryMap.get(connectorId).add(requirementSourceRepository);
				} else {
					Set<RequirementSource> set = new HashSet<RequirementSource>();
					set.add(requirementSourceRepository);
					repositoryMap.put(connectorId, set);
				}
			}
		} else {
			sources = RequirementSourceConfFactory.eINSTANCE.createRequirementSources();
		}
		initWorkspaceListener();
	}

	private void initWorkspaceListener() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
	}

	@Override
	public void addRequirementSource(final RequirementSource repository) {
		Set<RequirementSource> repositories;
		repositories = repositoryMap.get(repository.getConnectorId());
		if (repositories == null) {
			repositories = new HashSet<RequirementSource>();
			repositoryMap.put(repository.getConnectorId(), repositories);
		}

		if (!repositories.contains(repository)) {
			repositories.add(repository);
		}

		if (!sources.getRequirementSources().contains(repository)) {
			sources.getRequirementSources().add(repository);
		}

		try {
			save();
			notifyChange(IDataTopics.NEW_SOURCE, repository);
		} catch (IOException e) {
			e.printStackTrace();
			logger.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage()));
		}
	}

	private <T extends EObject> T resolveProxy(T obj) {
		if (obj.eIsProxy() && obj.eResource() != null) {
			EObject newObj = EcoreUtil.resolve(obj, obj.eResource().getResourceSet());
			return (T) newObj;
		}
		return obj;
	}

	@Override
	public void removeRequirementSource(final RequirementSource repository, boolean removeFromWS) {

		Set<RequirementSource> repositories = repositoryMap.get(repository.getConnectorId());
		if (repositories != null) {
			RequirementsContainer contents = repository.getContents();

			// fixed bug. contents can be null if the source was not well
			// created
			if (contents != null) {
				contents = resolveProxy(contents);

				Resource resource = contents.eResource();
				if (resource != null && WorkspaceSynchronizer.getFile(resource) != null && removeFromWS) {
					if (resource != null) {
						try {
							if (resource.isLoaded()) {
								resource.unload();
							}
							resource.delete(Collections.emptyMap());
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			repositories.remove(repository);
			sources.removeRequirementSource(repository);
			repository.clearContent();
			EcoreUtil.delete(repository, true);
			try {
				save();
				notifyChange(IDataTopics.REMOVE_SOURCE, repository);
			} catch (IOException e) {
				e.printStackTrace();
				logger.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage()));
			}
		}
	}

	@Override
	public void save() throws IOException {
		saveContents();
		saveSources();
	}

	protected void saveSources() throws IOException {
		confManager.saveConfiguration(Collections.singleton(sources), null, null, SOURCES_CONF_ID, null, null);
	}

	protected void saveContents() throws IOException {
		for (RequirementSource source : sources.getRequirementSources()) {
			if (source.getDestinationURI() == null) {
				confManager.saveConfiguration(Collections.singleton(source.getContents()), null, null, CONTENTS_CONF_ID + "." + source.getName(), null, "reqcycle");
			} else {
				RequirementsContainer reqContainer = source.getContents();
				Resource eResource = reqContainer.eResource();
				if (eResource == null) {
					eResource = confManager.getConfigurationResourceSet().createResource(URI.createURI(source.getDestinationURI()));
					eResource.getContents().add(reqContainer);
				}

				if (eResource instanceof EMFConfResource) {
					((EMFConfResource) eResource).manualSave(SAVE_OPTIONS);
				} else if (eResource != null) {
					eResource.save(SAVE_OPTIONS);
				}
			}
		}
	}

	@Override
	public void removeRequirementSources(String connectorId) {
		Set<RequirementSource> repositories = repositoryMap.get(connectorId);
		for (RequirementSource reqSource : repositories) {
			sources.removeRequirementSource(reqSource);
			reqSource.clearContent();
			notifyChange(IDataTopics.REMOVE_REQUIREMENT, reqSource);
		}
		try {
			save();
			repositoryMap.remove(connectorId);
		} catch (IOException e) {
			e.printStackTrace();
			logger.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage()));
		}
	}

	@Override
	public RequirementSource getRequirementSource(String connectorId, String repositoryUri) {
		Assert.isNotNull(connectorId);
		Assert.isNotNull(repositoryUri);
		if (repositoryMap.containsKey(connectorId)) {
			for (RequirementSource repository : repositoryMap.get(connectorId)) {
				if (repository.getRepositoryURI().equals(repositoryUri)) {
					return repository;
				}
			}
		}
		return null;
	}

	@Override
	public Set<RequirementSource> getRequirementSources(String connectorId) {
		Assert.isNotNull(connectorId);
		Set<RequirementSource> result;
		result = repositoryMap.get(connectorId);
		if (result == null) {
			return Collections.emptySet();
		}
		return new HashSet<RequirementSource>(result);
	}

	@Override
	public Map<String, Set<RequirementSource>> getRepositoryMap() {
		return repositoryMap;
	}

	@Override
	public Set<RequirementSource> getRequirementSources() {
		Collection<Set<RequirementSource>> values = repositoryMap.values();
		Set<RequirementSource> res = new HashSet<RequirementSource>();
		for (Set<RequirementSource> sources : values) {
			res.addAll(sources);
		}
		return res;
	}

	@Override
	public void notifyChange(String event, Object data) {
		// asynchronous publishing
		broker.post(event, data);
	}

	@Override
	public RequirementSource createRequirementSource(String name, String connectorId) {
		RequirementSource source = createRequirementSource();
		source.setName(name);
		source.setConnectorId(connectorId);
		return source;
	}

	@Override
	public RequirementSource createRequirementSource() {
		RequirementSource source = RequirementSourceConfFactory.eINSTANCE.createRequirementSource();
		RequirementsContainer rc = RequirementSourceDataFactory.eINSTANCE.createRequirementsContainer();
		source.setContents(rc);
		return source;
	}

	@Override
	public Section createSection(String id, String name, String uri) {
		Section section = RequirementSourceDataFactory.eINSTANCE.createSection();
		section.setId(id);
		section.setText(name);
		section.setUri(uri);
		return section;
	}

	@Override
	public Trash createTrash(String id, String name, String uri) {
		Trash trash = RequirementSourceDataFactory.eINSTANCE.createTrash();
		trash.setId(id);
		trash.setText(name);
		trash.setUri(uri);
		return trash;
	}

	@Override
	public boolean addElementsToSection(Section section, AbstractElement... element) {
		return section.getChildren().addAll(Arrays.asList(element));
	}

	@Override
	public boolean addElementsToSource(RequirementSource source, AbstractElement... elements) {
		RequirementsContainer contents = source.getContents();
		if (contents == null) {
			contents = RequirementSourceDataFactory.eINSTANCE.createRequirementsContainer();
			source.setContents(contents);
		}
		return contents.getRequirements().addAll(Arrays.asList(elements));
	}

	@Override
	public boolean addElementsToRequirement(Requirement requirement, AbstractElement... element) {
		return requirement.getChildren().addAll(Arrays.asList(element));
	}

	@Override
	public void addAttributeValue(AbstractElement element, IAttribute attribute, Object value) {
		EStructuralFeature eFeature = (EAttribute) ((IAdaptable) attribute).getAdapter(EStructuralFeature.class);
		if (eFeature.isMany()) {
			List l = (List) element.eGet(eFeature);
			l.add(value);
		} else {
			element.eSet(eFeature, value);
		}
	}

	@Override
	public void load() {
		for (RequirementSource requirementSource : sources.getRequirementSources()) {
			requirementSource = resolveProxy(requirementSource);
			loadContents(requirementSource.getRequirements());
		}
	}

	private void loadContents(EList<AbstractElement> requirements) {
		for (AbstractElement abstractElement : requirements) {
			abstractElement = resolveProxy(abstractElement);
			if (abstractElement != null && abstractElement.getScopes() != null && !abstractElement.getScopes().isEmpty()) {
				for (Scope scope : abstractElement.getScopes()) {
					scope = resolveProxy(scope);
				}
			}
			if (abstractElement instanceof Requirement) {
				loadContents(((Requirement) abstractElement).getChildren());
			}
		}
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		try {
			event.getDelta().accept(this);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource res = delta.getResource();
		if (res instanceof IFile && ((IFile) res).getFileExtension().equals("reqcycle")) {
			Map<URI, RequirementSource> setSources = Maps.uniqueIndex(sources.getRequirementSources(), new Function<RequirementSource, URI>() {

				@Override
				public URI apply(RequirementSource arg0) {
					return URI.createURI(arg0.getDestinationURI());
				}

			});
			URI platform = URI.createPlatformResourceURI(res.getFullPath().toString(), true);
			final RequirementSource reqSource = setSources.get(platform);
			if (reqSource != null) {
				try {
					Resource r = confManager.getConfigurationResourceSet().getResource(platform, false);
					if (r != null && r.isLoaded()) {
						r.unload();
						r.load(Collections.emptyMap());

						ViewerNotification notification = new ViewerNotification(new NotificationImpl(Notification.SET, r, r) {
							@Override
							public Object getNotifier() {
								return reqSource;
							}
						}, reqSource.getContents());
						reqSource.eNotify(notification);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
}
