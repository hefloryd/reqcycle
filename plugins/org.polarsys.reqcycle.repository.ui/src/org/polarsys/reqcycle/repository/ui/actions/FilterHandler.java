package org.polarsys.reqcycle.repository.ui.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.polarsys.reqcycle.repository.ui.RequirementViewDisplayType;
import org.polarsys.reqcycle.repository.ui.views.RequirementView;

public class FilterHandler extends AbstractHandler {

	public FilterHandler() {
		super();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart part = HandlerUtil.getActivePart(event);
		if (part instanceof RequirementView) {
			RequirementView reqView = (RequirementView) part;
			String filter = reqView.getFilter();
			if (filter == null) {
				filter = "";
			}
			InputDialog dialog = new InputDialog(Display.getDefault().getActiveShell(), "Filter requirements", "Enter value to filter requirements", filter, null);
			if (dialog.open() == Window.OK) {
				filter = dialog.getValue();
				reqView.setFilter(filter);
				reqView.setDisplay(RequirementViewDisplayType.FILTERBYNAME);
				reqView.getCommonViewer().refresh();
			}
		}

		return null;
	}
}
