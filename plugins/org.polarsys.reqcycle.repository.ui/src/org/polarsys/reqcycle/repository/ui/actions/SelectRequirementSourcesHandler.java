package org.polarsys.reqcycle.repository.ui.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.ui.views.RequirementView;
import org.polarsys.reqcycle.ui.components.dialogs.CheckBoxInputDialog;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class SelectRequirementSourcesHandler extends AbstractHandler {

	/** Requirement Source Manager */
	@Inject
	IDataManager requirementSourceManager;

	protected Collection<RequirementSource> sources;

	public SelectRequirementSourcesHandler() {
		super();
		ZigguratInject.inject(this);
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Collection<RequirementSource> selectedSources = openRequirementSourceChooser(sources);
		if (selectedSources != null) {
			IWorkbenchPart part = HandlerUtil.getActivePart(event);
			if (part instanceof RequirementView) {
				RequirementView reqView = (RequirementView) part;
				reqView.setSources(selectedSources);
				sources = selectedSources;
				reqView.getCommonViewer().refresh();
			}
		}
		return null;
	}

	protected Collection<RequirementSource> openRequirementSourceChooser(
			Collection<RequirementSource> initialSelection) {
		Set<RequirementSource> repositories = requirementSourceManager
				.getRequirementSources();

		@SuppressWarnings({ "rawtypes", "unchecked" })
		CheckBoxInputDialog dialog = new CheckBoxInputDialog(Display
				.getDefault().getActiveShell(), "Requirement filtering",
				"Select Requirement Sources to filter", repositories, null,
				(Collection) initialSelection);

		if (dialog.open() == Window.OK) {
			Collection<RequirementSource> selectedSources = new ArrayList<RequirementSource>();

			Collection<Object> selection = dialog.getSelectedItems();
			for (Object object : selection) {
				if (object instanceof RequirementSource) {
					selectedSources.add((RequirementSource) object);
				}
			}
			return selectedSources;
		}

		return null;
	}

}
