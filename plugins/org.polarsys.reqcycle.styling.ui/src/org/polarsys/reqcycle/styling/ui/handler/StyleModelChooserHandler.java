package org.polarsys.reqcycle.styling.ui.handler;

import java.util.Collection;

import javax.inject.Inject;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.navigator.CommonNavigator;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.styling.manager.IStylingManager;
import org.polarsys.reqcycle.styling.ui.dialogs.StyleModelChooserDialog;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class StyleModelChooserHandler extends AbstractHandler {
	/** Requirement Source Manager */
	@Inject
	IDataManager requirementSourceManager;
	@Inject
	IStylingManager styleManager = ZigguratInject.make(IStylingManager.class);
	protected Collection<RequirementSource> sources;

	public StyleModelChooserHandler() {
		super();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		StyleModelChooserDialog dialog = new StyleModelChooserDialog(Display.getDefault().getActiveShell());
		int result = dialog.open();
		if (result == Window.CANCEL) {
			styleManager.reload();
		} else if (result == Window.OK) {
			styleManager.save();

			IWorkbenchPart part = HandlerUtil.getActivePart(event);
			if (part instanceof CommonNavigator) {
				CommonNavigator navigator = (CommonNavigator) part;
				navigator.getCommonViewer().refresh();
			}
		}

		return null;
	}

}
