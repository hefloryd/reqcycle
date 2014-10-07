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
import org.polarsys.reqcycle.repository.ui.RequirementViewDisplayType;
import org.polarsys.reqcycle.repository.ui.views.RequirementView;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class SelectPredicatesFiltersHandler extends AbstractHandler {

	public SelectPredicatesFiltersHandler() {
		super();
		ZigguratInject.inject(this);
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Collection<IPredicate> predicates = Collections.emptyList();
		Collection<IPredicate> selection = PredicatesUIHelper.openPredicatesChooser(predicates, "Requirement filtering", "Select a predicate to apply or press OK to continue without filtering.", false);
		if (selection != null) {
			IWorkbenchPart part = HandlerUtil.getActivePart(event);
			if (part instanceof RequirementView) {
				RequirementView reqView = (RequirementView) part;
				reqView.setPredicates(selection);
				reqView.setDisplay(RequirementViewDisplayType.ORDERBYPREDICATE);
				reqView.getCommonViewer().refresh();
			}
		} else {
			IWorkbenchPart part = HandlerUtil.getActivePart(event);
			if (part instanceof RequirementView) {
				RequirementView reqView = (RequirementView) part;
				reqView.setDisplay(RequirementViewDisplayType.NONE);
				reqView.getCommonViewer().refresh();
			}
		}
		return null;
	}
}
