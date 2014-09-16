/*******************************************************************************
 * Copyright (c) 2014 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html *
 * Contributors:
 *    Reda Semlal (AtoS) - backend optimizations
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.builder.impl;

import java.util.LinkedList;
import java.util.List;

import org.polarsys.reqcycle.traceability.builder.ITraceabilityBuilder.IBuilderCallBack;
import org.polarsys.reqcycle.traceability.model.TType;
import org.polarsys.reqcycle.uri.model.ProxyResolver;
import org.polarsys.reqcycle.uri.model.Reachable;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

/**
 * Delegate wrapper around {@link IBuilderCallBack} that uses a {@link ProxyResolver} to resolve the source and target objects before calling {@link #newUpwardRelation(Object, Object, Object, List, TType)}.
 * 
 * <p>
 * The behavior of the other methods is unmodified.
 * </p>
 * 
 * @author rsemlal
 */
public class ProxyResolutionBuilderCallbackWrapper implements IBuilderCallBack {

	private final IBuilderCallBack callBack;
	private final ProxyResolveFunction proxyResolverFunction;

	/**
	 * 
	 * @param callBack
	 *            Nested {@link IBuilderCallBack} instance.
	 * @param proxyResolver
	 *            a {@link ProxyResolver} instance to use for proxy resolution.
	 */
	public ProxyResolutionBuilderCallbackWrapper(final IBuilderCallBack callBack, final ProxyResolver proxyResolver) {
		this.callBack = callBack;
		this.proxyResolverFunction = new ProxyResolveFunction(proxyResolver);
	}

	@Override
	public boolean needsBuild(final Reachable reachable) {
		return this.callBack.needsBuild(reachable);
	}

	@Override
	public void startBuild(final Reachable reachable) {
		this.callBack.startBuild(reachable);
	}

	@Override
	public void endBuild(final Reachable reachable) {
		this.callBack.endBuild(reachable);
	}

	@Override
	public void errorOccurs(final Reachable reachable, final Throwable t) {
		this.callBack.errorOccurs(reachable, t);
	}

	@Override
	public void newUpwardRelation(final Object traceabilityObject, final Object resource, final Object source, final List<? extends Object> targets, final TType label) {
		final Object newSource = this.proxyResolverFunction.apply(source);
		final List<Object> newTargets = new LinkedList<Object>(Collections2.transform(targets, this.proxyResolverFunction));
		this.callBack.newUpwardRelation(traceabilityObject, resource, newSource, newTargets, label);
	}

	private static final class ProxyResolveFunction implements Function<Object, Object> {
		private final ProxyResolver proxyResolver;

		public ProxyResolveFunction(final ProxyResolver proxyResolver) {
			super();
			this.proxyResolver = proxyResolver;
		}

		@Override
		public Object apply(final Object arg0) {
			return this.proxyResolver.resolve(arg0);
		}
	}

}
