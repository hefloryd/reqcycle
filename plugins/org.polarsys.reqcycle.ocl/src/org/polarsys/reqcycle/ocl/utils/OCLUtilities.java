/*******************************************************************************
 *  Copyright (c) 2013, 2014 AtoS and others
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Olivier Melois (AtoS) - initial API and implementation and/or initial documentation
 *    Raphael Faudou (Samares Engineering) - Fixed some bugs in OCL connector to manage types and align
 * 		connector on other connectors with a destination file
 *******************************************************************************/
package org.polarsys.reqcycle.ocl.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.xtext.base.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS;
import org.eclipse.ocl.examples.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefOperationCS;
import org.polarsys.reqcycle.ocl.ReqcycleOCLPlugin;
import org.polarsys.reqcycle.repository.data.types.IAttribute;
import org.polarsys.reqcycle.repository.data.types.IRequirementType;
import org.polarsys.reqcycle.utils.ocl.OCLEvaluator;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class OCLUtilities {

	protected static Map<String, String> mapToOCLPrimitives = new HashMap<String, String>();
	static {
		mapToOCLPrimitives.put("String", "String"); //$NON-NLS-1$
		mapToOCLPrimitives.put("Boolean", "Boolean"); //$NON-NLS-1$
		mapToOCLPrimitives.put("boolean", "Boolean"); //$NON-NLS-1$
		mapToOCLPrimitives.put("Float", "Real"); //$NON-NLS-1$
		mapToOCLPrimitives.put("int", "Integer"); //$NON-NLS-1$
		mapToOCLPrimitives.put("long", "Integer"); //$NON-NLS-1$
		mapToOCLPrimitives.put("Long", "Integer"); //$NON-NLS-1$
		mapToOCLPrimitives.put("Short", "Integer"); //$NON-NLS-1$

	}

	public static BaseResource loadOCLResource(ResourceSet resourceSet, URI oclURI) throws WrappedException {
		BaseResource xtextResource = null;
		CompleteOCLStandaloneSetup.init();
		try {
			xtextResource = (BaseResource) resourceSet.getResource(oclURI, true);
		} catch (WrappedException e) {
			URI retryURI = null;
			Throwable cause = e.getCause();
			if (cause instanceof CoreException) {
				IStatus status = ((CoreException) cause).getStatus();
				if ((status.getCode() == IResourceStatus.RESOURCE_NOT_FOUND) && status.getPlugin().equals(ResourcesPlugin.PI_RESOURCES)) {
					if (oclURI.isPlatformResource()) {
						retryURI = URI.createPlatformPluginURI(oclURI.toPlatformString(false), false);
					}
				}
			}
			if (retryURI != null) {
				xtextResource = (BaseResource) resourceSet.getResource(retryURI, true);
			} else {
				throw e;
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return xtextResource;
	}

	public static Collection<org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefOperationCS> getOperations(BaseResource resource) {
		Collection<DefOperationCS> result = Lists.newArrayList();
		EList<EObject> contents = resource.getContents();
		if (contents.size() == 1) {
			EObject root = contents.get(0);
			if (root instanceof CompleteOCLDocumentCS) {
				EList<ContextDeclCS> contexts = ((CompleteOCLDocumentCS) root).getContexts();
				for (ContextDeclCS context : contexts) {
					if (context instanceof ClassifierContextDeclCS) {
						EList<DefCS> definitions = ((ClassifierContextDeclCS) context).getDefinitions();
						Iterables.addAll(result, Iterables.filter(definitions, DefOperationCS.class));
					}
				}
			}
		}
		return result;
	}

	/**
	 * Checks whether an OCL resource contains an operation allowing to test whether an uml element can be associated to a given data type. The operation should be named "isX" where "X" is the name of the data type.
	 */
	public static IStatus isOperationPresent(final IRequirementType type, BaseResource resource) {
		if (Iterables.size(getMatchingOperations(type, resource)) > 0) {
			return Status.OK_STATUS;
		}
		;
		return new Status(IStatus.ERROR, ReqcycleOCLPlugin.PLUGIN_ID, "Required operation : " + OCLUtilities.getOperationRequiredSignature(type) + " could not be found");
	}

	/**
	 * Checks whether an OCL resource contains an operation allowing to retrieve a requirement's attribute of a given data type. The operation should be named "getX" where "X" is the name of the attribute.
	 */
	public static IStatus isOperationPresent(final IAttribute attribute, BaseResource resource) {
		String attributeTypeName = attribute.getType().getName();
		if (!mapToOCLPrimitives.containsKey(attributeTypeName)) {
			return new Status(IStatus.WARNING, ReqcycleOCLPlugin.PLUGIN_ID, "Type " + attributeTypeName + " cannot be used in OCL.");
		}
		if (Iterables.size(getMatchingOperations(attribute, resource)) > 0) {
			return Status.OK_STATUS;
		}
		;
		return new Status(IStatus.ERROR, ReqcycleOCLPlugin.PLUGIN_ID, "Required operation : " + OCLUtilities.getOperationRequiredSignature(attribute) + " could not be found.");
	}

	/**
	 * Gets operations that could be used to match uml elements to a data type. These operations must have a specific name and signature (no parameter, return boolean).
	 */
	public static Iterable<DefOperationCS> getMatchingOperations(final IRequirementType type, BaseResource resource) {
		Collection<DefOperationCS> operations = getOperations(resource);
		if (operations == null || Iterables.isEmpty(operations)) {
			return Collections.emptyList();
		}
		return Iterables.filter(operations, new Predicate<DefOperationCS>() {

			@Override
			public boolean apply(DefOperationCS arg0) {
				TypedRefCS operationReturnType = arg0.getOwnedType();
				if (!arg0.getParameters().isEmpty()) {
					return false;
				}
				if (operationReturnType instanceof PrimitiveTypeRefCS) {
					String returnType = ((PrimitiveTypeRefCS) operationReturnType).getName();
					if (!"Boolean".equals(returnType)) { //$NON-NLS-1$
						return false;
					}
				}
				return arg0.getName().replaceAll("\\s", "").equalsIgnoreCase(getOperationRequiredName(type));
			}
		});
	}

	/**
	 * Gets operations that could be used to match uml elements to a data type. These operations must have a specific name and signature (no parameter, return boolean).
	 */
	public static Iterable<DefOperationCS> getMatchingOperations(final IAttribute attribute, BaseResource resource) {
		Collection<DefOperationCS> operations = getOperations(resource);
		if (operations == null || Iterables.isEmpty(operations)) {
			return Collections.emptyList();
		}
		return Iterables.filter(operations, new Predicate<DefOperationCS>() {

			@Override
			public boolean apply(DefOperationCS arg0) {
				TypedRefCS operationReturnType = arg0.getOwnedType();
				if (!arg0.getParameters().isEmpty()) {
					return false;
				}
				if (operationReturnType instanceof PrimitiveTypeRefCS) {
					String returnType = ((PrimitiveTypeRefCS) operationReturnType).getName();
					String attributeTypeName = attribute.getType().getName();
					String lookupResult = mapToOCLPrimitives.get(attributeTypeName);
					if (lookupResult == null || !lookupResult.equals(returnType)) {
						return false;
					}
				}
				return arg0.getName().equalsIgnoreCase(getOperationRequiredName(attribute));
			}
		});
	}

	public static String getOperationRequiredName(IRequirementType type) {
		String dataTypeName = type.getName();
		return getOperationRequiredName(dataTypeName);
	}

	public static String getOperationRequiredName(String dataTypeName) {
		StringBuilder builder = new StringBuilder("is"); //$NON-NLS-1$
		builder.append(Character.toUpperCase(dataTypeName.charAt(0))).append(dataTypeName.substring(1));
		return builder.toString().replaceAll("\\s", "");
	}

	public static String getOperationRequiredName(IAttribute attribute) {
		StringBuilder builder = new StringBuilder("get"); //$NON-NLS-1$
		String name = attribute.getName();
		builder.append(Character.toUpperCase(name.charAt(0))).append(name.substring(1));
		return builder.toString().replaceAll("\\s", "");
	}

	public static String getOperationRequiredSignature(IRequirementType type) {
		return getOperationRequiredName(type) + "() : Boolean"; //$NON-NLS-1$
	}

	public static String getOperationRequiredSignature(IAttribute attribute) {
		String returnTypeName = attribute.getType().getName();
		String lookupType = mapToOCLPrimitives.get(returnTypeName);
		return getOperationRequiredName(attribute) + "() : " + lookupType; //$NON-NLS-1$
	}

	public static boolean isDataType(OCLEvaluator evaluator, EObject eObject, IRequirementType type) {
		String operationName = OCLUtilities.getOperationRequiredName(type);
		EOperation eOperation = evaluator.getCompiledOperation(operationName, eObject);
		if (eOperation != null) {
			Object result = evaluator.evaluateOperation(eOperation, eObject, new Object[0]);
			if (result instanceof Boolean) {
				return (Boolean) result;
			}
		}
		return false;
	}

	public static boolean isSection(OCLEvaluator evaluator, EObject eObject) {
		EOperation eOperation = getSectionMethod(evaluator, eObject);
		if (eOperation != null) {
			Object result = evaluator.evaluateOperation(eOperation, eObject, new Object[0]);
			if (result instanceof Boolean) {
				return (Boolean) result;
			}
		}
		return false;
	}

	private static EOperation getSectionMethod(OCLEvaluator evaluator, EObject eObject) {
		String operationName = OCLUtilities.getOperationRequiredName("Section");
		EOperation eOperation = evaluator.getCompiledOperation(operationName, eObject);
		return eOperation;
	}

	public static Object getAttributeValue(OCLEvaluator evaluator, EObject eObject, IAttribute attribute) {
		String operationName = OCLUtilities.getOperationRequiredName(attribute);
		EClassifier type = getDataType(attribute);
		return getAttributeValue(evaluator, eObject, operationName, type);
	}

	public static Object getAttributeValue(OCLEvaluator evaluator, EObject eObject, String operationName, EClassifier type) {
		EOperation eOperation = evaluator.getCompiledOperation(operationName, eObject);
		if (eOperation != null) {
			Object result = evaluator.evaluateOperation(eOperation, eObject, new Object[0]);

			if (type == null) {
				return null;
			}

			if (type.isInstance(result)) {
				return result;
			} else {
				Object converted = convertResult(result, type);
				if (type.isInstance(converted)) {
					return converted;
				}
			}
		}
		return null;
	}

	private static EClassifier getDataType(IAttribute attribute) {
		EClassifier type = null;
		if (attribute.getType() instanceof IAdaptable) {
			type = (EClassifier) ((IAdaptable) attribute.getType()).getAdapter(EClassifier.class);
		}
		return type;
	}

	protected static Object convertResult(Object result, EClassifier type) {

		if (type == null) {
			return null;
		}

		String instanceClass = type.getInstanceClassName();
		if ("float".equalsIgnoreCase(instanceClass) && result instanceof Double) { //$NON-NLS-1$
			return ((Double) result).floatValue();
		}
		return null;
	}

}
