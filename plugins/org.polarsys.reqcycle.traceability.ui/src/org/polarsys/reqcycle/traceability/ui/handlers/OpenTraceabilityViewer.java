package org.polarsys.reqcycle.traceability.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class OpenTraceabilityViewer extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.polarsys.reqcycle.traceability.ui.views.TraceabilityViewer");
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return null;
	}
}