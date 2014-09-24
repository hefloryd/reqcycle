package org.polarsys.reqcycle.repository.ui.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.polarsys.reqcycle.repository.ui.views.RequirementView;

public class NewInstanceHandler extends AbstractHandler {

	public NewInstanceHandler() {
		super();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		RequirementView.createNewView();

		return null;
	}
}