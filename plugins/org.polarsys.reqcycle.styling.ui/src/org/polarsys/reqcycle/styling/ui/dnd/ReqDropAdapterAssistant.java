/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.styling.ui.dnd;

import java.util.Collection;
import java.util.Iterator;

import javax.inject.Inject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.navigator.CommonDropAdapter;
import org.eclipse.ui.navigator.CommonDropAdapterAssistant;
import org.polarsys.reqcycle.dnd.DropRequirementDelegate;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.uri.exceptions.IReachableHandlerException;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class ReqDropAdapterAssistant extends CommonDropAdapterAssistant {

	@Inject
	IReachableManager manager;

	public ReqDropAdapterAssistant() {
		ZigguratInject.inject(this);
	}

	@Override
	protected void doInit() {
		// TODO Auto-generated method stub
		super.doInit();
	}

	@Override
	public IStatus validateDrop(Object target, int operation, TransferData transferType) {
		if (LocalSelectionTransfer.getTransfer().isSupportedType(transferType)) {
			ISelection selection = LocalSelectionTransfer.getTransfer().getSelection();
			Iterable<Reachable> reachables = getReachable(selection);
			if (reachables.iterator().hasNext()) {
				return Status.OK_STATUS;
			}
		}
		return null;
	}

	private Iterable<Reachable> getReachable(ISelection selection) {
		Collection<Reachable> result = Lists.newArrayList();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection strucutred = (IStructuredSelection) selection;
			Iterator<?> iterator = strucutred.iterator();
			while (iterator.hasNext()) {
				Object next = iterator.next();
				Reachable r;
				try {
					r = manager.getHandlerFromObject(next).getFromObject(next).getReachable();
					result.add(r);
				} catch (IReachableHandlerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return Iterables.filter(result, Predicates.notNull());
	}

	@Override
	public IStatus handleDrop(CommonDropAdapter aDropAdapter, DropTargetEvent aDropTargetEvent, Object aTarget) {
		if (LocalSelectionTransfer.getTransfer().isSupportedType(aDropAdapter.getCurrentTransfer())) {
			Iterable<Reachable> reachables = getReachable(LocalSelectionTransfer.getTransfer().getSelection());
			DropRequirementDelegate req = new DropRequirementDelegate();
			IFile file = WorkspaceSynchronizer.getFile(((EObject) aTarget).eResource());
			for (Reachable r : reachables) {
				try {
					req.handleDrop(Lists.newArrayList(r), manager.getHandlerFromObject(aTarget).getFromObject(aTarget).getReachable(), file);
				} catch (IReachableHandlerException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
