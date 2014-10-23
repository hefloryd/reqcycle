package org.polarsys.reqcycle.papyrus.dnd;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jface.util.LocalSelectionTransfer;
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

import com.google.common.collect.Lists;

public class PapyrusDropAdapterAssistant extends CommonDropAdapterAssistant {

	@Inject
	IReachableManager manager;

	public PapyrusDropAdapterAssistant() {
		ZigguratInject.inject(this);
	}

	@Override
	public IStatus validateDrop(Object target, int operation, TransferData transferType) {
		try {
			if (manager.getHandlerFromObject(target).getFromObject(target).getReachable() != null) {
				return Status.OK_STATUS;
			}
		} catch (IReachableHandlerException e) {
			e.printStackTrace();
		}
		return Status.CANCEL_STATUS;
	}

	@Override
	public IStatus handleDrop(CommonDropAdapter aDropAdapter, DropTargetEvent aDropTargetEvent, Object aTarget) {
		try {
			if (LocalSelectionTransfer.getTransfer().isSupportedType(aDropAdapter.getCurrentTransfer())) {
				if (!(aTarget instanceof EObject)) {
					if (aTarget instanceof IAdaptable) {
						IAdaptable adaptable = (IAdaptable) aTarget;
						if (adaptable.getAdapter(EObject.class) != null) {
							aTarget = adaptable.getAdapter(EObject.class);
						}
					}
				}
				
				List<Reachable> reachables = Lists.newArrayList();
				DropRequirementDelegate req = new DropRequirementDelegate();
				if (aDropTargetEvent.data instanceof IStructuredSelection) {
					IStructuredSelection select = (IStructuredSelection) aDropTargetEvent.data;
					Iterator<?> iterator = select.iterator();
					while (iterator.hasNext()){
						Object o = iterator.next();
						Reachable reachable = manager.getHandlerFromObject(o).getFromObject(o).getReachable();
						if (reachable != null){
							reachables.add(reachable);
						}
						else {
							return Status.CANCEL_STATUS;
						}
					}
				}
				IFile file = WorkspaceSynchronizer.getFile(((EObject) aTarget).eResource());
				req.handleDrop(reachables, manager.getHandlerFromObject(aTarget).getFromObject(aTarget).getReachable(), file);
			}
			return Status.OK_STATUS;
		}
		catch(IReachableHandlerException e){
			e.printStackTrace();
			return Status.CANCEL_STATUS;
		}
	}

}
