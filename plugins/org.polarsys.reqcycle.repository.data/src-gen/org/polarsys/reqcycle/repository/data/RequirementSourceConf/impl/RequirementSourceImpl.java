/**
 * Copyright (c) 2013 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *   Anass Radouani (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.repository.data.RequirementSourceConf.impl;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polarsys.reqcycle.repository.data.MappingModel.MappingElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSourceConfPackage;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementsContainer;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;
import org.polarsys.reqcycle.repository.data.util.DataUtil;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Requirement Source</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.impl.RequirementSourceImpl#getContents <em>Contents</em>}</li>
 * <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.impl.RequirementSourceImpl#getName <em>Name</em>}</li>
 * <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.impl.RequirementSourceImpl#getProperties <em>Properties</em>}</li>
 * <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.impl.RequirementSourceImpl#getConnectorId <em>Connector Id</em>}</li>
 * <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.impl.RequirementSourceImpl#getMappings <em>Mappings</em>}</li>
 * <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.impl.RequirementSourceImpl#getDataModelURI <em>Data Model URI</em>}</li>
 * <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.impl.RequirementSourceImpl#getDefaultScope <em>Default Scope</em>}</li>
 * <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.impl.RequirementSourceImpl#getRepositoryURI <em>Repository URI</em>}</li>
 * <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.impl.RequirementSourceImpl#getDestinationURI <em>Destination URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequirementSourceImpl extends MinimalEObjectImpl.Container implements RequirementSource {
	/**
	 * The cached value of the '{@link #getContents() <em>Contents</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getContents()
	 * @generated
	 * @ordered
	 */
	protected RequirementsContainer contents;
	protected Set<PropertyChangeListener> propertyChangeListeners = new HashSet<PropertyChangeListener>();
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;
	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' map. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> properties;

	/**
	 * The default value of the '{@link #getConnectorId() <em>Connector Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConnectorId()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNECTOR_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConnectorId() <em>Connector Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConnectorId()
	 * @generated
	 * @ordered
	 */
	protected String connectorId = CONNECTOR_ID_EDEFAULT;
	/**
	 * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingElement> mappings;

	/**
	 * The default value of the '{@link #getDataModelURI() <em>Data Model URI</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDataModelURI()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_MODEL_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataModelURI() <em>Data Model URI</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDataModelURI()
	 * @generated
	 * @ordered
	 */
	protected String dataModelURI = DATA_MODEL_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefaultScope() <em>Default Scope</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDefaultScope()
	 * @generated
	 * @ordered
	 */
	protected Scope defaultScope;

	/**
	 * The default value of the '{@link #getRepositoryURI() <em>Repository URI</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRepositoryURI()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_URI_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getRepositoryURI() <em>Repository URI</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRepositoryURI()
	 * @generated
	 * @ordered
	 */
	protected String repositoryURI = REPOSITORY_URI_EDEFAULT;
	/**
	 * The default value of the '{@link #getDestinationURI() <em>Destination URI</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDestinationURI()
	 * @generated
	 * @ordered
	 */
	protected static final String DESTINATION_URI_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDestinationURI() <em>Destination URI</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDestinationURI()
	 * @generated
	 * @ordered
	 */
	protected String destinationURI = DESTINATION_URI_EDEFAULT;
	protected Collection<EPackage> targetEPackages;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RequirementSourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementSourceConfPackage.Literals.REQUIREMENT_SOURCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public RequirementsContainer getContents() {
		if (contents != null && contents.eIsProxy()) {
			InternalEObject oldContents = (InternalEObject) contents;
			contents = (RequirementsContainer) eResolveProxy(oldContents);
			if (contents != oldContents) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementSourceConfPackage.REQUIREMENT_SOURCE__CONTENTS, oldContents, contents));
			}
		}
		return contents;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RequirementsContainer basicGetContents() {
		return contents;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setContents(RequirementsContainer newContents) {
		RequirementsContainer oldContents = contents;
		contents = newContents;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementSourceConfPackage.REQUIREMENT_SOURCE__CONTENTS, oldContents, contents));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementSourceConfPackage.REQUIREMENT_SOURCE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EMap<String, String> getProperties() {
		if (properties == null) {
			properties = new EcoreEMap<String, String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, RequirementSourceConfPackage.REQUIREMENT_SOURCE__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getConnectorId() {
		return connectorId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConnectorId(String newConnectorId) {
		String oldConnectorId = connectorId;
		connectorId = newConnectorId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementSourceConfPackage.REQUIREMENT_SOURCE__CONNECTOR_ID, oldConnectorId, connectorId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<MappingElement> getMappings() {
		if (mappings == null) {
			mappings = new EObjectContainmentEList<MappingElement>(MappingElement.class, this, RequirementSourceConfPackage.REQUIREMENT_SOURCE__MAPPINGS);
		}
		return mappings;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getDataModelURI() {
		return dataModelURI;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setDataModelURI(String newDataModelURI) {
		String oldDataModelURI = dataModelURI;
		dataModelURI = newDataModelURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementSourceConfPackage.REQUIREMENT_SOURCE__DATA_MODEL_URI, oldDataModelURI, dataModelURI));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Scope getDefaultScope() {
		if (defaultScope != null && defaultScope.eIsProxy()) {
			InternalEObject oldDefaultScope = (InternalEObject) defaultScope;
			defaultScope = (Scope) eResolveProxy(oldDefaultScope);
			if (defaultScope != oldDefaultScope) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementSourceConfPackage.REQUIREMENT_SOURCE__DEFAULT_SCOPE, oldDefaultScope, defaultScope));
			}
		}
		return defaultScope;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Scope basicGetDefaultScope() {
		return defaultScope;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setDefaultScope(Scope newDefaultScope) {
		Scope oldDefaultScope = defaultScope;
		defaultScope = newDefaultScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementSourceConfPackage.REQUIREMENT_SOURCE__DEFAULT_SCOPE, oldDefaultScope, defaultScope));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getRepositoryURI() {
		return repositoryURI;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setRepositoryURI(String newRepositoryURI) {
		String oldRepositoryURI = repositoryURI;
		repositoryURI = newRepositoryURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementSourceConfPackage.REQUIREMENT_SOURCE__REPOSITORY_URI, oldRepositoryURI, repositoryURI));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getDestinationURI() {
		return destinationURI;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setDestinationURI(String newDestinationURI) {
		String oldDestinationURI = destinationURI;
		destinationURI = newDestinationURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementSourceConfPackage.REQUIREMENT_SOURCE__DESTINATION_URI, oldDestinationURI, destinationURI));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__PROPERTIES:
			return ((InternalEList<?>) getProperties()).basicRemove(otherEnd, msgs);
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__MAPPINGS:
			return ((InternalEList<?>) getMappings()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__CONTENTS:
			if (resolve)
				return getContents();
			return basicGetContents();
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__NAME:
			return getName();
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__PROPERTIES:
			if (coreType)
				return getProperties();
			else
				return getProperties().map();
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__CONNECTOR_ID:
			return getConnectorId();
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__MAPPINGS:
			return getMappings();
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__DATA_MODEL_URI:
			return getDataModelURI();
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__DEFAULT_SCOPE:
			if (resolve)
				return getDefaultScope();
			return basicGetDefaultScope();
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__REPOSITORY_URI:
			return getRepositoryURI();
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__DESTINATION_URI:
			return getDestinationURI();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__CONTENTS:
			setContents((RequirementsContainer) newValue);
			return;
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__NAME:
			setName((String) newValue);
			return;
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__PROPERTIES:
			((EStructuralFeature.Setting) getProperties()).set(newValue);
			return;
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__CONNECTOR_ID:
			setConnectorId((String) newValue);
			return;
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__MAPPINGS:
			getMappings().clear();
			getMappings().addAll((Collection<? extends MappingElement>) newValue);
			return;
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__DATA_MODEL_URI:
			setDataModelURI((String) newValue);
			return;
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__DEFAULT_SCOPE:
			setDefaultScope((Scope) newValue);
			return;
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__REPOSITORY_URI:
			setRepositoryURI((String) newValue);
			return;
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__DESTINATION_URI:
			setDestinationURI((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__CONTENTS:
			setContents((RequirementsContainer) null);
			return;
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__PROPERTIES:
			getProperties().clear();
			return;
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__CONNECTOR_ID:
			setConnectorId(CONNECTOR_ID_EDEFAULT);
			return;
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__MAPPINGS:
			getMappings().clear();
			return;
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__DATA_MODEL_URI:
			setDataModelURI(DATA_MODEL_URI_EDEFAULT);
			return;
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__DEFAULT_SCOPE:
			setDefaultScope((Scope) null);
			return;
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__REPOSITORY_URI:
			setRepositoryURI(REPOSITORY_URI_EDEFAULT);
			return;
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__DESTINATION_URI:
			setDestinationURI(DESTINATION_URI_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__CONTENTS:
			return contents != null;
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__PROPERTIES:
			return properties != null && !properties.isEmpty();
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__CONNECTOR_ID:
			return CONNECTOR_ID_EDEFAULT == null ? connectorId != null : !CONNECTOR_ID_EDEFAULT.equals(connectorId);
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__MAPPINGS:
			return mappings != null && !mappings.isEmpty();
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__DATA_MODEL_URI:
			return DATA_MODEL_URI_EDEFAULT == null ? dataModelURI != null : !DATA_MODEL_URI_EDEFAULT.equals(dataModelURI);
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__DEFAULT_SCOPE:
			return defaultScope != null;
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__REPOSITORY_URI:
			return REPOSITORY_URI_EDEFAULT == null ? repositoryURI != null : !REPOSITORY_URI_EDEFAULT.equals(repositoryURI);
		case RequirementSourceConfPackage.REQUIREMENT_SOURCE__DESTINATION_URI:
			return DESTINATION_URI_EDEFAULT == null ? destinationURI != null : !DESTINATION_URI_EDEFAULT.equals(destinationURI);
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean hasProperty(String propertyKey) {
		String value = getProperty(propertyKey);
		return value != null && value.trim().length() > 0;
	}

	@Override
	public String getProperty(String propertyKey) {
		return getProperties().get(propertyKey);
	}

	@Override
	public void removeProperty(String key) {
		getProperties().remove(key);
	}

	@Override
	public void removeChangeListeners(PropertyChangeListener listener) {
		propertyChangeListeners.remove(listener);
	}

	@Override
	public void addChangeListeners(PropertyChangeListener listener) {
		propertyChangeListeners.add(listener);
	}

	@Override
	public void store() {
	}

	@Override
	public void dispose() {
	}

	@Override
	public Collection<EPackage> getTargetEPackages() {
		if (targetEPackages == null) {
			targetEPackages = Collections2.transform(getMappings(), new Function<MappingElement, EPackage>() {

				@Override
				public EPackage apply(MappingElement mappingElement) {
					return mappingElement.getTargetElement().getEPackage();
				}
			});
		}
		return targetEPackages;
	}

	@Override
	public String toString() {
		return DataUtil.getLabel(this);
	}

	@Override
	public boolean contains(AbstractElement abstractElement) {

		if (abstractElement == null) {
			return false;
		}

		EObject container = abstractElement.eContainer();

		if (container instanceof RequirementSource) {
			return EcoreUtil.equals(container, this);
		} else if (container instanceof AbstractElement) {
			return contains((AbstractElement) container);
		}

		return false;
	}

	@Override
	public EList<AbstractElement> getRequirements() {
		RequirementsContainer contents = getContents();
		if (contents != null) {
			return contents.getRequirements();
		}
		return ECollections.emptyEList();
	}

	@Override
	public void clearContent() {
		RequirementsContainer contents = getContents();
		if (contents == null) {
			return;
		}
		contents.getRequirements().clear();
	}

	@Override
	public void setRequirementsResourceURI(URI uri) {
		RequirementsContainer contents = getContents();
		Resource eResource = contents.eResource();
		if (eResource != null) {
			eResource.setURI(uri);
		} else {
			this.eResource().getResourceSet();
		}
	}

	@Override
	public void setProperty(String property, String newValue) {
		String oldValue = getProperties().get(property);
		if ((oldValue != null && oldValue.equals(newValue)) || (oldValue == null && newValue != null) || (oldValue != null && newValue != null && !oldValue.equals(newValue))) {
			properties.put(property, newValue);
			notifyChangeListeners(property, oldValue, newValue);
		}
	}

	protected void notifyChangeListeners(String key, String old, String value) {
		PropertyChangeEvent event = new PropertyChangeEvent(this, key, old, value);
		for (PropertyChangeListener listener : propertyChangeListeners) {
			listener.propertyChange(event);
		}
	}

} // RequirementSourceImpl
