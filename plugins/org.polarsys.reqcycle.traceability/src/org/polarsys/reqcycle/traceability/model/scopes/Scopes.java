/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.model.scopes;

import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.utils.ReachableUtils;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.Sets;

public class Scopes {
	static Set<Reachable> WORKSPACE_REACHABLES = null;
	static {
		ResourceVisitor visitor = getVisitor();
		WORKSPACE_REACHABLES = Sets.newHashSet(visitor.getResult().getReachables());
		ResourcesPlugin.getWorkspace().addResourceChangeListener(new IResourceChangeListener() {

			@Override
			public void resourceChanged(IResourceChangeEvent event) {
				try {
					event.getDelta().accept(new IResourceDeltaVisitor() {

						@Override
						public boolean visit(IResourceDelta delta) throws CoreException {
							if (delta.getKind() == IResourceDelta.ADDED) {
								WORKSPACE_REACHABLES.add(ReachableUtils.getReachable(delta.getResource()));
							} else if (delta.getKind() == IResourceDelta.REMOVED) {
								WORKSPACE_REACHABLES.remove(ReachableUtils.getReachable(delta.getResource()));
							}
							return true;
						}
					});
				} catch (CoreException e) {
					// reinit the reachables in error case
					ResourceVisitor visitor = getVisitor();
					WORKSPACE_REACHABLES = Sets.newHashSet(visitor.getResult().getReachables());
				}
			}
		});
	}

	private static ResourceVisitor getVisitor() {
		ResourceVisitor visitor = new ResourceVisitor();
		ZigguratInject.inject(visitor);
		try {
			ResourcesPlugin.getWorkspace().getRoot().accept(visitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return visitor;
	}

	public static IScope getProjectScope(IResource r) {
		ResourceVisitor visitor = new ResourceVisitor();
		ZigguratInject.inject(visitor);
		try {
			r.getProject().accept(visitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return visitor.getResult();
	}

	public static IScope getSubTree(IResource r) {
		ResourceVisitor visitor = new ResourceVisitor();
		ZigguratInject.inject(visitor);
		try {
			r.accept(visitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return visitor.getResult();
	}

	public static IScope getWorkspaceScope() {
		return new ResourceScope(WORKSPACE_REACHABLES);
	}

	private static class ResourceVisitor implements IResourceVisitor {
		CompositeScope scope = new CompositeScope();

		@Override
		public boolean visit(IResource resource) throws CoreException {
			Reachable r = ReachableUtils.getReachable(resource);
			if (r != null) {
				scope.add(new ResourceScope(r));
			}
			return true;
		}

		public IScope getResult() {
			return scope;
		}
	}
}
