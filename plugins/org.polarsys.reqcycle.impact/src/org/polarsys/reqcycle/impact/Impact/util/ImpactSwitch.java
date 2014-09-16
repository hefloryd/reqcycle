/**
 * Copyright (c) 2014 AtoS
 *     All rights reserved. This program and the accompanying materials
 *     are made available under the terms of the Eclipse Public License v1.0
 *     which accompanies this distribution, and is available at
 *     http://www.eclipse.org/legal/epl-v10.html *
 *     Contributors:
 *       Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.impact.Impact.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.polarsys.reqcycle.impact.Impact.*;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model, starting with the actual class
 * of the object and proceeding up the inheritance hierarchy until a non-null result is returned, which is the result of the switch. <!-- end-user-doc -->
 * 
 * @see org.polarsys.reqcycle.impact.Impact.ImpactPackage
 * @generated
 */
public class ImpactSwitch<T> extends Switch<T> {
	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static ImpactPackage modelPackage;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ImpactSwitch() {
		if (modelPackage == null) {
			modelPackage = ImpactPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case ImpactPackage.IMPACT_ANALYSIS: {
			ImpactAnalysis impactAnalysis = (ImpactAnalysis) theEObject;
			T result = caseImpactAnalysis(impactAnalysis);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpactPackage.REQUIREMENT_IMPACTED: {
			RequirementImpacted requirementImpacted = (RequirementImpacted) theEObject;
			T result = caseRequirementImpacted(requirementImpacted);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpactPackage.TRACEABILITY_LINK: {
			TraceabilityLink traceabilityLink = (TraceabilityLink) theEObject;
			T result = caseTraceabilityLink(traceabilityLink);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ImpactPackage.ATTRIBUTE_IMPACTED: {
			AttributeImpacted attributeImpacted = (AttributeImpacted) theEObject;
			T result = caseAttributeImpacted(attributeImpacted);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Analysis</em>'. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Analysis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImpactAnalysis(ImpactAnalysis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requirement Impacted</em>'. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requirement Impacted</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequirementImpacted(RequirementImpacted object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Traceability Link</em>'. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traceability Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceabilityLink(TraceabilityLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Impacted</em>'. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Impacted</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeImpacted(AttributeImpacted object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch, but this is the last case anyway. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} // ImpactSwitch
