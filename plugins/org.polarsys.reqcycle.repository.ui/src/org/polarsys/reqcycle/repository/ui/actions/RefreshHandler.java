package org.polarsys.reqcycle.repository.ui.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.polarsys.reqcycle.repository.ui.views.RequirementView;

public class RefreshHandler extends AbstractHandler {

	public RefreshHandler() {
		super();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchPart part = HandlerUtil.getActivePart(event);
		if (part instanceof RequirementView) {
			RequirementView reqView = (RequirementView) part;
			reqView.getCommonViewer().refresh();
		}

		return null;
	}
}
