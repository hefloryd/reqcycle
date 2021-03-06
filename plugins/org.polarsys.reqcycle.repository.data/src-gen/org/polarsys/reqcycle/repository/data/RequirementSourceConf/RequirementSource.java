/**
 * Copyright (c) 2013 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *   Anass Radouani (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.repository.data.RequirementSourceConf;

import java.beans.PropertyChangeListener;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.polarsys.reqcycle.repository.data.MappingModel.MappingElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementsContainer;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Requirement Source</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource#getContents <em>Contents</em>}</li>
 * <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource#getName <em>Name</em>}</li>
 * <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource#getProperties <em>Properties</em>}</li>
 * <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource#getConnectorId <em>Connector Id</em>}</li>
 * <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource#getMappings <em>Mappings</em>}</li>
 * <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource#getDataModelURI <em>Data Model URI</em>}</li>
 * <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource#getDefaultScope <em>Default Scope</em>}</li>
 * <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource#getRepositoryURI <em>Repository URI</em>}</li>
 * <li>{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource#getDestinationURI <em>Destination URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSourceConfPackage#getRequirementSource()
 * @model
 * @generated
 */
public interface RequirementSource extends EObject {
	/**
	 * Returns the value of the '<em><b>Contents</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Contents</em>' reference.
	 * @see #setContents(RequirementsContainer)
	 * @see org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSourceConfPackage#getRequirementSource_Contents()
	 * @model
	 * @generated
	 */
	RequirementsContainer getContents();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource#getContents <em>Contents</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Contents</em>' reference.
	 * @see #getContents()
	 * @generated
	 */
	void setContents(RequirementsContainer value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSourceConfPackage#getRequirementSource_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource#getName <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' map. The key is of type {@link java.lang.String}, and the value is of type {@link java.lang.String}, <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' map isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Properties</em>' map.
	 * @see org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSourceConfPackage#getRequirementSource_Properties()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 * @generated
	 */
	EMap<String, String> getProperties();

	/**
	 * Returns the value of the '<em><b>Connector Id</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connector Id</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Connector Id</em>' attribute.
	 * @see #setConnectorId(String)
	 * @see org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSourceConfPackage#getRequirementSource_ConnectorId()
	 * @model
	 * @generated
	 */
	String getConnectorId();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource#getConnectorId <em>Connector Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Connector Id</em>' attribute.
	 * @see #getConnectorId()
	 * @generated
	 */
	void setConnectorId(String value);

	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' containment reference list. The list contents are of type {@link org.polarsys.reqcycle.repository.data.MappingModel.MappingElement}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Mappings</em>' containment reference list.
	 * @see org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSourceConfPackage#getRequirementSource_Mappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingElement> getMappings();

	/**
	 * Returns the value of the '<em><b>Data Model URI</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Model URI</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Data Model URI</em>' attribute.
	 * @see #setDataModelURI(String)
	 * @see org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSourceConfPackage#getRequirementSource_DataModelURI()
	 * @model
	 * @generated
	 */
	String getDataModelURI();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource#getDataModelURI <em>Data Model URI</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Data Model URI</em>' attribute.
	 * @see #getDataModelURI()
	 * @generated
	 */
	void setDataModelURI(String value);

	/**
	 * Returns the value of the '<em><b>Default Scope</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Scope</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Default Scope</em>' reference.
	 * @see #setDefaultScope(Scope)
	 * @see org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSourceConfPackage#getRequirementSource_DefaultScope()
	 * @model
	 * @generated
	 */
	Scope getDefaultScope();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource#getDefaultScope <em>Default Scope</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Default Scope</em>' reference.
	 * @see #getDefaultScope()
	 * @generated
	 */
	void setDefaultScope(Scope value);

	/**
	 * Returns the value of the '<em><b>Repository URI</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository URI</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Repository URI</em>' attribute.
	 * @see #setRepositoryURI(String)
	 * @see org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSourceConfPackage#getRequirementSource_RepositoryURI()
	 * @model
	 * @generated
	 */
	String getRepositoryURI();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource#getRepositoryURI <em>Repository URI</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Repository URI</em>' attribute.
	 * @see #getRepositoryURI()
	 * @generated
	 */
	void setRepositoryURI(String value);

	/**
	 * Returns the value of the '<em><b>Destination URI</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination URI</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Destination URI</em>' attribute.
	 * @see #setDestinationURI(String)
	 * @see org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSourceConfPackage#getRequirementSource_DestinationURI()
	 * @model
	 * @generated
	 */
	String getDestinationURI();

	/**
	 * Sets the value of the '{@link org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource#getDestinationURI <em>Destination URI</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Destination URI</em>' attribute.
	 * @see #getDestinationURI()
	 * @generated
	 */
	void setDestinationURI(String value);

	EList<AbstractElement> getRequirements();

	void setProperty(String property, String newValue) throws Exception;

	boolean hasProperty(String propertyKey);

	String getProperty(String propertyKey);

	void removeProperty(String key);

	void removeChangeListeners(PropertyChangeListener listener);

	void addChangeListeners(PropertyChangeListener listener);

	void store();

	void dispose();

	Collection<EPackage> getTargetEPackages();

	boolean contains(AbstractElement abstractElement);

	void clearContent();

	void setRequirementsResourceURI(URI uri);

} // RequirementSource
