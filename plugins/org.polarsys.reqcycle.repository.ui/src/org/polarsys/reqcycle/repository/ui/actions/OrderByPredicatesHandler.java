package org.polarsys.reqcycle.repository.ui.actions;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.polarsys.reqcycle.predicates.core.api.IPredicate;
import org.polarsys.reqcycle.predicates.ui.util.PredicatesUIHelper;
import org.polarsys.reqcycle.repository.ui.views.RequirementView;

public class OrderByPredicatesHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Collection<IPredicate> predicates = Collections.emptyList();
		Collection<IPredicate> selection = PredicatesUIHelper
				.openPredicatesChooser(
						predicates,
						"Requirement ordering",
						"Select predicates to order requirements or press OK to continue without ordering.",
						true);
		if (selection != null) {
			IWorkbenchPart part = HandlerUtil.getActivePart(event);
			if (part instanceof RequirementView) {
				RequirementView reqView = (RequirementView) part;
				reqView.setPredicates(selection);
				reqView.setViewFiltered(false);
				reqView.setViewOrdered(true);
				reqView.setViewByScopes(false);
				reqView.getCommonViewer().refresh(true);
			}
		} else {
			IWorkbenchPart part = HandlerUtil.getActivePart(event);
			if (part instanceof RequirementView) {
				RequirementView reqView = (RequirementView) part;
				reqView.setViewFiltered(false);
				reqView.setViewOrdered(false);
				reqView.setViewByScopes(false);
				reqView.getCommonViewer().refresh();
			}
		}
		return null;
	}
}
