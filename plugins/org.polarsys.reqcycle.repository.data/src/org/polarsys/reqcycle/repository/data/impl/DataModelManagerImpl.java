/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Anass Radouani (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
package org.polarsys.reqcycle.repository.data.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;
import org.polarsys.reqcycle.repository.data.ScopeConf.ScopeConfFactory;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scopes;
import org.polarsys.reqcycle.repository.data.types.IAttribute;
import org.polarsys.reqcycle.repository.data.types.IDataModel;
import org.polarsys.reqcycle.repository.data.types.IEnumerationType;
import org.polarsys.reqcycle.repository.data.types.IEnumerator;
import org.polarsys.reqcycle.repository.data.types.IRequirementType;
import org.polarsys.reqcycle.repository.data.types.IType;
import org.polarsys.reqcycle.repository.data.types.internal.AttributeImpl;
import org.polarsys.reqcycle.repository.data.types.internal.DataModelImpl;
import org.polarsys.reqcycle.repository.data.types.internal.EnumerationTypeImpl;
import org.polarsys.reqcycle.repository.data.types.internal.EnumeratorImpl;
import org.polarsys.reqcycle.repository.data.types.internal.RequirementTypeImpl;
import org.polarsys.reqcycle.utils.configuration.IConfigurationManager;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Singleton
public class DataModelManagerImpl implements IDataModelManager {

	/** EPackage containing possible data types */
	protected IDataModel containerDataModel;

	/** Configuration Manager */
	@Inject
	IConfigurationManager confManager;

	/** Configuration ID */
	final static String DATAMODELS_CONF_ID = "org.polarsys.reqcycle.data.datamodels";

	final static String SCOPES_CONF_ID = "org.polarsys.reqcycle.data.scopes";

	protected Scopes scopes;

	@Inject
	protected IDataManager dataManager;

	/**
	 * Constructor
	 */
	@Inject
	DataModelManagerImpl(IConfigurationManager confManager, IDataManager dataManager) {
		this.confManager = confManager;
		this.dataManager = dataManager;

		initTypes();
		initScopes();
	}

	protected void initScopes() {
		Collection<EObject> conf = confManager.getConfiguration(null, null, SCOPES_CONF_ID, null, null, true);
		EObject element = null;
		if (conf != null && !conf.isEmpty()) {
			element = conf.iterator().next();
		}
		if (element instanceof Scopes) {
			scopes = ((Scopes) element);
		} else {
			scopes = ScopeConfFactory.eINSTANCE.createScopes();
			saveScopes();
		}
	}

	protected void initTypes() {
		Collection<EObject> conf = confManager.getConfiguration(null, IConfigurationManager.Scope.WORKSPACE, DATAMODELS_CONF_ID, null, "ecore", true);
		EObject element = null;
		if (conf != null && !conf.isEmpty()) {
			element = conf.iterator().next();
		}
		EPackage ePackage;
		if (element instanceof EPackage) {
			ePackage = (EPackage) element;
			containerDataModel = new DataModelImpl(ePackage);
		} else {
			ePackage = EcoreFactory.eINSTANCE.createEPackage();
			ePackage.setName("DataModels");
			ePackage.setNsPrefix("DataModels");
			ePackage.setNsURI(MODEL_NS_URI);
			containerDataModel = new DataModelImpl(ePackage);
			saveDataModels();
		}
		registerDataModels(ePackage);
	}

	@Override
	public void discardUnsavedChanges() {
		initTypes();
	}

	@Override
	public void save() {
		saveDataModels();
		saveScopes();
	}

	protected void saveScopes() {
		try {
			confManager.saveConfiguration(Collections.singleton(scopes), null, null, SCOPES_CONF_ID, null, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void saveDataModels() {
		for (IDataModel dataModel : Lists.newArrayList(getAllDataModels())) {
			DataModelImpl oldDataModel = ((DataModelImpl) dataModel).prepareSave();
			if (oldDataModel != null) {
				((DataModelImpl) containerDataModel).addSubDataModel(oldDataModel);
			}
		}
		try {
			EPackage ePackage = null;
			if (containerDataModel instanceof IAdaptable) {
				ePackage = (EPackage) ((IAdaptable) containerDataModel).getAdapter(EPackage.class);
			}
			confManager.saveConfiguration(Collections.singleton(ePackage), null, IConfigurationManager.Scope.WORKSPACE, DATAMODELS_CONF_ID, null, "ecore");
			registerDataModels(ePackage);
		} catch (IOException e) {
			// FIXME : use logger
			e.printStackTrace();
		}
	}

	@Override
	public IDataModel createDataModel(String name) {
		IDataModel dataModel = new DataModelImpl(name, 1);
		addDataModel(dataModel);
		return dataModel;
	}

	@Override
	public void addDataModel(IDataModel p) {
		if (p == null) {
			return;
		}
		if (getCurrentDataModel(p.getName()) != null) {
			throw new RuntimeException("A data model with the uri name already exists.");
		}
		((DataModelImpl) containerDataModel).addSubDataModel(p);
	}

	@Override
	public void removeDataModel(IDataModel p) {
		if (p == null) {
			return;
		}
		((DataModelImpl) containerDataModel).removeSubDataModel(p);
		getScopes(containerDataModel);
	}

	public void removeScope(Scope... scopes) {
		this.scopes.getScopes().removeAll(Arrays.asList(scopes));
	}

	protected void registerDataModels(EPackage ePackage) {
		Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
		for (EPackage p : ePackage.getESubpackages()) {
			Registry.INSTANCE.put(p.getNsURI(), p);
		}
	}

	@Override
	public IDataModel getCurrentDataModel(String name) {
		IDataModel matchingDataModel = null;
		for (IDataModel dataModel : getAllDataModels()) {
			if (name.equals(dataModel.getName()) && isNewer(matchingDataModel, dataModel)) {
				matchingDataModel = dataModel;
			}
		}
		return matchingDataModel;
	}

	// @Override
	public Collection<IDataModel> getAllVersionsOfDataModel(String name) {
		List<IDataModel> matchingDataModels = Lists.newArrayList();
		for (IDataModel dataModel : getAllDataModels()) {
			if (name.equals(dataModel.getName())) {
				matchingDataModels.add(dataModel);
			}
		}
		return matchingDataModels;
	}

	protected boolean isNewer(IDataModel ref, IDataModel toCompare) {
		if (ref == null || toCompare.getVersion() > ref.getVersion()) {
			return true;
		}
		return false;
	}

	@Override
	public Collection<IDataModel> getCurrentDataModels() {
		Map<String, IDataModel> nameToDataModels = Maps.newHashMap();
		for (IDataModel dataModel : getAllDataModels()) {
			IDataModel matchingDataModel = nameToDataModels.get(dataModel.getName());
			if (matchingDataModel == null || isNewer(matchingDataModel, dataModel)) {
				nameToDataModels.put(dataModel.getName(), dataModel);
			}
		}
		return nameToDataModels.values();
	}

	public Collection<IDataModel> getAllDataModels() {
		Assert.isNotNull(containerDataModel);
		return ((DataModelImpl) containerDataModel).getSubDataModels();
	}

	@Override
	public IRequirementType createRequirementType(String name, IDataModel dataModel) {
		IRequirementType element = new RequirementTypeImpl(name, dataModel);
		return element;
	}

	@Override
	public IEnumerationType createEnumerationType(String name) {
		IEnumerationType element = new EnumerationTypeImpl(name);
		return element;
	}

	@Override
	public IEnumerator createEnumerator(String name) {
		IEnumerator enumeratorType = new EnumeratorImpl(name);
		return enumeratorType;
	}

	@Override
	public IAttribute createAttribute(String name, IType type, boolean isMany) {
		return new AttributeImpl(name, type, isMany);
	}

	@Override
	public Scope createScope(String name, IDataModel dataModel) {
		Scope scope = ScopeConfFactory.eINSTANCE.createScope();
		scope.setName(name);
		scope.setDataModelName(dataModel.getName());
		return scope;
	}

	@Override
	public void addScopes(IDataModel dataModel, Scope... scopes) {
		for (Scope scope : scopes) {
			this.scopes.getScopes().add(scope);
		}
	}

	@Override
	public Collection<Scope> getAllScopes() {
		return scopes.getScopes();
	}

	@Override
	public Collection<Scope> getScopes(final IDataModel dataModel) {
		return Collections2.filter(scopes.getScopes(), new Predicate<Scope>() {

			@Override
			public boolean apply(Scope arg0) {
				if (arg0.getDataModelName().equals(dataModel.getName())) {
					return true;
				}
				return false;
			}
		});
	}

	@Override
	public Scope getScope(String name, IDataModel dataModel) {
		for (Scope s : scopes.getScopes()) {
			if (s.getDataModelName().equals(dataModel.getName()) && s.getName().equals(name)) {
				return s;
			}
		}
		return null;
	}

	@Override
	public IDataModel getDataModelByURI(String uri) {
		for (IDataModel dataModel : getAllDataModels()) {
			if (uri.equals(dataModel.getDataModelURI())) {
				return dataModel;
			}
		}
		return null;
	}

	private boolean isTypesUsed(Collection<EClass> types) {
		for (RequirementSource requirementSource : dataManager.getRequirementSources()) {
			requirementSource = resolveProxy(requirementSource);
			return isRequirementTypesUsed(requirementSource.getRequirements(), types);
		}
		return false;
	}

	private <T extends EObject> T resolveProxy(T obj) {
		if (obj.eIsProxy() && obj.eResource() != null) {
			EObject newObj = EcoreUtil.resolve(obj, obj.eResource().getResourceSet());
			return (T) newObj;
		}
		return obj;
	}

	private boolean isRequirementTypesUsed(EList<AbstractElement> requirements, Collection<EClass> types) {
		for (AbstractElement abstractElement : requirements) {
			abstractElement = resolveProxy(abstractElement);
			if (types.contains(abstractElement.eClass())) {
				return true;
			}
			if (abstractElement != null && abstractElement.getScopes() != null && !abstractElement.getScopes().isEmpty()) {
				for (Scope scope : abstractElement.getScopes()) {
					scope = resolveProxy(scope);
				}
			}
			if (abstractElement instanceof Requirement) {
				return isRequirementTypesUsed(((Requirement) abstractElement).getChildren(), types);
			}
		}
		return false;
	}

	@Override
	public boolean isDataModelUsed(IDataModel dataModel) {
		Collection<IType> types = dataModel.getTypes();
		Collection<EClass> eTypes = Collections2.transform(types, new Function<IType, EClass>() {

			@Override
			public EClass apply(IType type) {
				EClass eclass = null;
				if (type instanceof IAdaptable) {
					eclass = (EClass) ((IAdaptable) type).getAdapter(EClass.class);
				}
				return eclass;
			};
		});

		if (isTypesUsed(Collections2.filter(eTypes, Predicates.notNull()))) {
			return true;
		}
		String dataModelURI = dataModel.getDataModelURI();
		Set<RequirementSource> sources = dataManager.getRequirementSources();
		for (RequirementSource requirementSource : sources) {
			if (dataModelURI.equals(requirementSource.getDataModelURI())) {
				return true;
			}
		}

		for (Scope scope : getScopes(dataModel)) {
			EList<AbstractElement> reqs = scope.getRequirements();
			if (reqs != null && !reqs.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty(IDataModel dataModel) {
		return dataModel.getTypes().isEmpty();
	}

	@Override
	public IRequirementType getType(AbstractElement ae) {
		EClass eClass = ae.eClass();
		ECrossReferenceAdapter c = ECrossReferenceAdapter.getCrossReferenceAdapter(eClass);

		if (c == null && eClass.eResource() != null) {
			c = new ECrossReferenceAdapter();
			eClass.eResource().getResourceSet().eAdapters().add(c);
		}

		if (c != null) {
			Collection<Setting> settings = c.getInverseReferences(eClass);
			for (Setting setting : settings) {
				EObject eo = setting.getEObject();
				if (eo instanceof IRequirementType) {
					return ((IRequirementType) eo);
				}
			}
		}

		return null;
	}

}
