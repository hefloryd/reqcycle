/*******************************************************************************
 *  Copyright (c) 2013, 2014 AtoS and others
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Olivier Melois (AtoS) - initial API and implementation and/or initial documentation
 *    Raphael Faudou (Samares Engineering) - adapted code for Luna compliance
 *   
 *******************************************************************************/
package org.polarsys.reqcycle.utils.ocl;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.CompleteOCLDocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefOperationCS;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.polarsys.reqcycle.utils.ocl.impl.OCLEvaluatorImpl;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class ZigguratOCLPlugin implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		ZigguratOCLPlugin.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		ZigguratOCLPlugin.context = null;
	}

	public static OCLEvaluator createOCLEvaluator() {
		return new OCLEvaluatorImpl();
	}

	public static OCLEvaluator compileOCL(ResourceSet resourceSet, URI oclURI) throws Exception {
		BaseResource resource = (BaseResource) resourceSet.getResource(oclURI, true);
		return compileOCL(resource);
	}

	public static OCLEvaluator compileOCL(BaseResource resource) throws Exception {
		OCLEvaluator evaluator = ZigguratOCLPlugin.createOCLEvaluator();

		Collection<DefOperationCS> operations = getOperations(resource);
		for (DefOperationCS operation : operations) {
			compileOperation(evaluator, operation);
		}
		return evaluator;
	}

	private static void compileOperation(OCLEvaluator evaluator, DefOperationCS operationCS) throws Exception {
		org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ClassifierContextDeclCS classifierContextDecl = operationCS.getClassifierContextDecl();
		Element pivot = classifierContextDecl.getPivot();

		String classifierString = pivot.toString();

		String[] split = classifierString.split("::");
		// -RF- transformed to lower case first part as "toString" returns prefix in upper case in Luna.
		split[0] = split[0].toLowerCase();

		EClassifier classifier = evaluator.lookupEClassifier(Arrays.asList(split));
		String[] defNameExpression = operationCS.toString().split("def\\s*?:", 0);
		String defExpression = defNameExpression[1];
		try {
			evaluator.compileOperation(defExpression, classifier);
		} catch (SemanticException e) {
			String message = "Semantic error : " + operationCS.getName() + " - " + e.getMessage();
			throw new Exception(message);
		}
	}

	private static Collection<DefOperationCS> getOperations(BaseResource resource) {
		Collection<DefOperationCS> result = Lists.newArrayList();
		EList<EObject> contents = resource.getContents();
		if (contents.size() == 1) {
			EObject root = contents.get(0);
			if (root instanceof CompleteOCLDocumentCS) {
				EList<org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ContextDeclCS> contexts = ((CompleteOCLDocumentCS) root).getContexts();
				for (org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.ContextDeclCS context : contexts) {
					if (context instanceof ClassifierContextDeclCS) {
						EList<DefCS> definitions = ((ClassifierContextDeclCS) context).getDefinitions();
						Iterables.addAll(result, Iterables.filter(definitions, DefOperationCS.class));
					}
				}
			}
		}
		return result;
	}

}
