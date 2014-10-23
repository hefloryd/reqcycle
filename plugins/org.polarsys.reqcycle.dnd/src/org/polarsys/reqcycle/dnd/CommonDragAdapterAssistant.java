package org.polarsys.reqcycle.dnd;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.part.PluginTransfer;
import org.eclipse.ui.part.PluginTransferData;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.uri.exceptions.IReachableHandlerException;
import org.polarsys.reqcycle.uri.model.IObjectHandler;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.model.ReachableObject;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class CommonDragAdapterAssistant extends org.eclipse.ui.navigator.CommonDragAdapterAssistant {

	private final static String PLUGIN_TRANSFER_ACTION_ID = "org.polarsys.reqcycle.dnd.DropRequirementDelegate";

	@Inject
	IReachableManager manager;

	public CommonDragAdapterAssistant() {
		super();
		ZigguratInject.inject(this);
	}

	@Override
	public Transfer[] getSupportedTransferTypes() {
		return new Transfer[] { PluginTransfer.getInstance() };
	}

	@Override
	public void dragStart(DragSourceEvent anEvent, IStructuredSelection selection) {
		Iterator<?> iterator = selection.iterator();

		try {
			List<Reachable> objectURIs = new ArrayList<Reachable>();
			while (iterator.hasNext()) {
				Object next = iterator.next();
				if (manager.getHandlerFromObject(next).handlesObject(next)) {
					ReachableObject fromObject = manager.getHandlerFromObject(next).getFromObject(next);
					objectURIs.add(fromObject.getReachable());
				} else {
					// if one object is not handled, do not transfer any
					anEvent.doit = false;
					return;
				}
			}
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream buffered;
			buffered = new ObjectOutputStream(bos);
			buffered.writeObject(objectURIs.toArray());
			byte[] data = bos.toByteArray();
			bos.close();
			buffered.close();

			anEvent.data = new PluginTransferData(PLUGIN_TRANSFER_ACTION_ID, data);
		} catch (Exception e) {
			anEvent.doit = false;
			return;
		}
		anEvent.doit = true;
		// anEvent.data =
	}

	@Override
	public boolean setDragData(DragSourceEvent event, IStructuredSelection selection) {
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
		return true;
	}

}
