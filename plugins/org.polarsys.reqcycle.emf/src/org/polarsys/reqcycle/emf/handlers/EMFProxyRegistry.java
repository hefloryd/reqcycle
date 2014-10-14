/*******************************************************************************
 *  Copyright (c) 2013-2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.emf.handlers;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.polarsys.reqcycle.emf.utils.EMFUtils;

import com.google.common.base.Function;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

@Singleton
public class EMFProxyRegistry implements IEMFProxyRegistry {
	Map<URI, Long> stamps = Maps.newHashMap();
	Cache<URI, Set<String>> cache = CacheBuilder.newBuilder()
			.expireAfterAccess(5, TimeUnit.MINUTES).build();

	@Override
	public boolean isProxy(URI uri) {
		if (!uri.isPlatformResource()) {
			throw new IllegalArgumentException("not a platform resource");
		}
		final URI path = uri.trimFragment();
		final IFile f = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(path.toPlatformString(true)));
		Long timestamp = stamps.get(path);
		if (timestamp == null) {
			timestamp = -1L;
		}
		if (f != null && timestamp != null
				&& timestamp != f.getLocalTimeStamp()) {
			cache.invalidate(path);
		}
		if (!f.exists()){
			cache.invalidate(path);
		}
		Collection<String> eobject;
		try {
			eobject = cache.get(path, new Callable<Set<String>>() {
				@Override
				public Set<String> call() throws Exception {
					Resource r = EMFUtils.getFAURSWithPathMaps().getResource(
							path, true);
					if (r == null){
						return Sets.newHashSet();
					}
					Iterator<String> eobjects = Iterators.transform(
							r.getAllContents(),
							new Function<EObject, String>() {
								@Override
								public String apply(EObject arg0) {
									return arg0.eResource()
											.getURIFragment(arg0);
								}
							});
					stamps.put(path, f.getLocalTimeStamp());
					return Sets.newHashSet(eobjects);
				}
			});
			
			return !eobject.contains(uri.fragment());
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}