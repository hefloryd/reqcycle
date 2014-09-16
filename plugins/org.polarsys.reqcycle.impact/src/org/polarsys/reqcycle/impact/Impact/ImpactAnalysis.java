/**
 * Copyright (c) 2014 AtoS
 *     All rights reserved. This program and the accompanying materials
 *     are made available under the terms of the Eclipse Public License v1.0
 *     which accompanies this distribution, and is available at
 *     http://www.eclipse.org/legal/epl-v10.html *
 *     Contributors:
 *       Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.impact.Impact;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Analysis</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.polarsys.reqcycle.impact.Impact.ImpactAnalysis#getRequirementsAdded <em>Requirements Added</em>}</li>
 * <li>{@link org.polarsys.reqcycle.impact.Impact.ImpactAnalysis#getRequirementsDeleted <em>Requirements Deleted</em>}</li>
 * <li>{@link org.polarsys.reqcycle.impact.Impact.ImpactAnalysis#getRequirementsModified <em>Requirements Modified</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.reqcycle.impact.Impact.ImpactPackage#getImpactAnalysis()
 * @model
 * @generated
 */
public interface ImpactAnalysis extends EObject {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model targetNameDataType="org.polarsys.reqcycle.impact.Impact.URI"
	 * @generated
	 */
	void saveAnalysis(URI targetName);

	/**
	 * Returns the value of the '<em><b>Requirements Added</b></em>' containment reference list. The list contents are of type {@link org.polarsys.reqcycle.impact.Impact.RequirementImpacted}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirements Added</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Requirements Added</em>' containment reference list.
	 * @see org.polarsys.reqcycle.impact.Impact.ImpactPackage#getImpactAnalysis_RequirementsAdded()
	 * @model containment="true"
	 * @generated
	 */
	EList<RequirementImpacted> getRequirementsAdded();

	/**
	 * Returns the value of the '<em><b>Requirements Deleted</b></em>' containment reference list. The list contents are of type {@link org.polarsys.reqcycle.impact.Impact.RequirementImpacted}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirements Deleted</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Requirements Deleted</em>' containment reference list.
	 * @see org.polarsys.reqcycle.impact.Impact.ImpactPackage#getImpactAnalysis_RequirementsDeleted()
	 * @model containment="true"
	 * @generated
	 */
	EList<RequirementImpacted> getRequirementsDeleted();

	/**
	 * Returns the value of the '<em><b>Requirements Modified</b></em>' containment reference list. The list contents are of type {@link org.polarsys.reqcycle.impact.Impact.RequirementImpacted}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirements Modified</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Requirements Modified</em>' containment reference list.
	 * @see org.polarsys.reqcycle.impact.Impact.ImpactPackage#getImpactAnalysis_RequirementsModified()
	 * @model containment="true"
	 * @generated
	 */
	EList<RequirementImpacted> getRequirementsModified();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated
	 */
	void launchAnalysis(RequirementSource rsFrom, RequirementSource rstTo);

} // ImpactAnalysis
