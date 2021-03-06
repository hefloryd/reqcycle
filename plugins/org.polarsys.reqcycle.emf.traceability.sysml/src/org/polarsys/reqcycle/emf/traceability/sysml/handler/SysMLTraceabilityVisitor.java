/*******************************************************************************
 * Copyright (c) 2013,2014 AtoS and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *  Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *  Raphael Faudou (Samares Engineering) fixed bug on capture of SysML links 
 *  			fixed bug on "allocate" relationship
 *******************************************************************************/
package org.polarsys.reqcycle.emf.traceability.sysml.handler;

import java.util.Collections;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.sysml.allocations.Allocate;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.profile.standard.Trace;
import org.polarsys.reqcycle.emf.traceability.sysml.types.traceability.SysMLTTypeProvider;
import org.polarsys.reqcycle.traceability.builder.ITraceabilityBuilder.IBuilderCallBack;
import org.polarsys.reqcycle.traceability.model.TType;
import org.polarsys.reqcycle.uri.visitors.IVisitor;

public class SysMLTraceabilityVisitor implements IVisitor {

	@Override
	public boolean visit(Object o, IAdaptable adapable) {
		if (o instanceof Resource) {
			return ((Resource) o).getURI() != null && ((Resource) o).getURI().fileExtension() != null && ((Resource) o).getURI().fileExtension().equals("uml");
		}
		if (o instanceof Trace) {
			return visit((Trace) o, adapable);
		} else if (o instanceof Allocate) {
			return visit((Allocate) o, adapable);
		}
		return true;
	}

	public boolean visit(Allocate satis, IAdaptable adaptable) {
		Abstraction abstraction = satis.getBase_Abstraction();
		if (abstraction.getClients().isEmpty()) {
			return true;
		}
		if (abstraction.getSuppliers().isEmpty()) {
			return true;
		}
		if (abstraction != null) {
			Object source = abstraction.getSuppliers().get(0);
			Object target = abstraction.getClients().get(0);
			newUpwardRelation(satis, adaptable, source, target);
		}
		return true;
	}

	private void visit(EObject satis, IAdaptable adaptable, Abstraction abstraction) {

		// -RFa- abstraction might be orphan or incomplete
		// we must check clients and suppliers.
		if (abstraction == null || abstraction.getClients().isEmpty() || abstraction.getSuppliers().isEmpty()){
			return ;
		}

		Object source = abstraction.getClients().get(0);
		Object target = abstraction.getSuppliers().get(0);
		newUpwardRelation(satis, adaptable, source, target);
	}

	private void newUpwardRelation(EObject satis, IAdaptable adaptable, Object source, Object target) {
		if (source == null || target == null){
			return ;
		}
		TType tType = SysMLTTypeProvider.get(satis.eClass());
		getCallBack(adaptable).newUpwardRelation(satis, satis.eResource(), source, Collections.singletonList(target), tType);
	}

	public boolean visit(Trace satis, IAdaptable adaptable) {
		Abstraction abstraction = satis.getBase_Abstraction();
		if (abstraction != null) {
			visit(satis, adaptable, abstraction);
		}
		return true;
	}

	private IBuilderCallBack getCallBack(IAdaptable adaptable) {
		return (IBuilderCallBack) adaptable.getAdapter(IBuilderCallBack.class);
	}

	@Override
	public void start(IAdaptable adaptable) {
	}

	@Override
	public void end(IAdaptable adaptable) {
	}

}
