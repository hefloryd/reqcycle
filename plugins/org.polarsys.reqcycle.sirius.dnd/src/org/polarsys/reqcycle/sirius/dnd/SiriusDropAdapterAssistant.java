package org.polarsys.reqcycle.sirius.dnd;

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
import org.polarsys.reqcycle.uri.model.IObjectHandler;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.Lists;

public class SiriusDropAdapterAssistant extends CommonDropAdapterAssistant {

	@Inject
	IObjectHandler objectHandler;

	public SiriusDropAdapterAssistant() {
		ZigguratInject.inject(this);
	}

	@Override
	public IStatus validateDrop(Object target, int operation, TransferData transferType) {
		if (objectHandler.getFromObject(target).getReachable() != null) {
			return Status.OK_STATUS;
		}
		return Status.CANCEL_STATUS;
	}

	@Override
	public IStatus handleDrop(CommonDropAdapter aDropAdapter, DropTargetEvent aDropTargetEvent, Object aTarget) {
		if (LocalSelectionTransfer.getTransfer().isSupportedType(aDropAdapter.getCurrentTransfer())) {
			if (!(aTarget instanceof EObject)) {
				if (aTarget instanceof IAdaptable) {
					IAdaptable adaptable = (IAdaptable) aTarget;
					if (adaptable.getAdapter(EObject.class) != null) {
						aTarget = adaptable.getAdapter(EObject.class);
					}
				}
			}
			Object selection = null;
			if (aDropTargetEvent.data instanceof IStructuredSelection) {
				IStructuredSelection select = (IStructuredSelection) aDropTargetEvent.data;
				selection = select.getFirstElement();
			}
			DropRequirementDelegate req = new DropRequirementDelegate();
			IFile file = WorkspaceSynchronizer.getFile(((EObject) aTarget).eResource());
			List<Reachable> reachables = Lists.newArrayList();
			reachables.add(objectHandler.getFromObject(selection).getReachable());
			req.handleDrop(reachables, objectHandler.getFromObject(aTarget).getReachable(), file);
		}
		return Status.OK_STATUS;
	}

}
