package org.polarsys.reqcycle.impact.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class OpenImpactAnalysis extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.polarsys.reqcycle.impact.ui.views.impact");
		} catch (PartInitException e) {
			e.printStackTrace();
		}

		return null;
	}
}
