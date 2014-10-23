/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.dnd;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.ui.part.PluginTransfer;
import org.eclipse.ui.part.PluginTransferData;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.uri.exceptions.IReachableHandlerException;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.model.ReachableObject;

@Singleton
public class DragRequirementSourceAdapter extends DragSourceAdapter {

	private ISelectionProvider provider;

	private final static String PLUGIN_TRANSFER_ACTION_ID = "org.polarsys.reqcycle.dnd.DropRequirementDelegate";

	@Inject
	IReachableManager manager;

	public DragRequirementSourceAdapter(ISelectionProvider provider) {
		super();
		this.provider = provider;
	}

	public void dragSetData(DragSourceEvent event) {
		IStructuredSelection selection = (IStructuredSelection) provider.getSelection();
		Iterator<?> iterator = selection.iterator();

		if (PluginTransfer.getInstance().isSupportedType(event.dataType)) {
			try {
				List<Reachable> objectURIs = new ArrayList<Reachable>();
				while (iterator.hasNext()) {
					Object next = iterator.next();
					ReachableObject fromObject;
					try {
						fromObject = manager.getHandlerFromObject(next).getFromObject(next);
						if (fromObject.getReachable() != null){
							objectURIs.add(fromObject.getReachable());
						}
					} catch (IReachableHandlerException e) {
						e.printStackTrace();
					}
				}
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutputStream buffered;
				buffered = new ObjectOutputStream(bos);
				buffered.writeObject(objectURIs.toArray());
				byte[] data = bos.toByteArray();
				bos.close();
				buffered.close();

				event.data = new PluginTransferData(PLUGIN_TRANSFER_ACTION_ID, data);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
