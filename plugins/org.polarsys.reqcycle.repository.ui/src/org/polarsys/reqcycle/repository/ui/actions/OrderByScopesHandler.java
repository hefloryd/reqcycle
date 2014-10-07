package org.polarsys.reqcycle.repository.ui.actions;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.inject.Inject;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;
import org.polarsys.reqcycle.repository.data.types.IDataModel;
import org.polarsys.reqcycle.repository.ui.RequirementViewDisplayType;
import org.polarsys.reqcycle.repository.ui.views.RequirementView;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class OrderByScopesHandler extends AbstractHandler {

	@Inject
	IDataModelManager dataModelManager;

	public OrderByScopesHandler() {
		super();
		ZigguratInject.inject(this);
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchPart part = HandlerUtil.getActivePart(event);
		if (part instanceof RequirementView) {
			Collection<Scope> scopes = new LinkedList<Scope>();

			Collection<IDataModel> dataModels = dataModelManager.getCurrentDataModels();
			Iterator<IDataModel> iterator = dataModels.iterator();
			while (iterator.hasNext()) {
				IDataModel next = iterator.next();
				scopes.addAll(dataModelManager.getScopes(next));
			}

			RequirementView reqView = (RequirementView) part;
			reqView.setScopes(scopes);
			reqView.setDisplay(RequirementViewDisplayType.ORDERBYSCOPE);
			reqView.getCommonViewer().refresh();
		}

		return null;
	}
}