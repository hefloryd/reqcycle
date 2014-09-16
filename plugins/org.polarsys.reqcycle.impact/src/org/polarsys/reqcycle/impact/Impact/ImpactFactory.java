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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.reqcycle.impact.Impact.ImpactPackage
 * @generated
 */
public interface ImpactFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImpactFactory eINSTANCE = org.polarsys.reqcycle.impact.Impact.impl.ImpactFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Analysis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Analysis</em>'.
	 * @generated
	 */
	ImpactAnalysis createImpactAnalysis();

	/**
	 * Returns a new object of class '<em>Requirement Impacted</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Requirement Impacted</em>'.
	 * @generated
	 */
	RequirementImpacted createRequirementImpacted();

	/**
	 * Returns a new object of class '<em>Traceability Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Traceability Link</em>'.
	 * @generated
	 */
	TraceabilityLink createTraceabilityLink();

	/**
	 * Returns a new object of class '<em>Attribute Impacted</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Impacted</em>'.
	 * @generated
	 */
	AttributeImpacted createAttributeImpacted();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ImpactPackage getImpactPackage();

} //ImpactFactory
