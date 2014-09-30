package org.polarsys.reqcycle.repository.ui.views;

import java.util.Collection;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.ViewPart;
import org.polarsys.reqcycle.impact.Impact.ImpactAnalysis;
import org.polarsys.reqcycle.impact.Impact.ImpactFactory;
import org.polarsys.reqcycle.impact.ui.dialogs.ImpactAnalysisComposites;
import org.polarsys.reqcycle.impact.ui.dialogs.ImpactAnalysisInputSelectorDialog;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement;
import org.polarsys.reqcycle.repository.ui.Activator;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class ImpactView extends ViewPart {
	/** View ID */
	public static final String VIEW_ID = "org.polarsys.reqcycle.repository.ui.views.impact";

	private ImpactAnalysis impact;

	private RequirementSource requirementSource;

	private String FileExtension = "xmi";

	protected EList<Requirement> requirementsAdded;
	protected EList<Requirement> requirementsDeleted;
	protected EList<Requirement> requirementsModified;

	// Action select Impact Analysis inputs and launch analysis
	private Action selectImpactInputs;
	// Action save Impact Analysis
	private Action saveImpact;

	// Composites for impact analysis
	ImpactAnalysisComposites impactComposites;

	public ImpactView() {
		ZigguratInject.inject(this);
		impactComposites = new ImpactAnalysisComposites();
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		composite.setLayout(new GridLayout(1, false));

		impactComposites.createInputComposite(composite);
		impactComposites.createImpactComposite(composite);

		impactComposites.setRequirementSource("Not selected");
		impactComposites.setInitialVersion("Not selected");
		impactComposites.setFinalVersion("Not selected");

		makeActions();
		contributeToActionBars();
	}

	public void setImpactAnalysis(ImpactAnalysis impact) {
		this.impact = impact;
	}

	public static void openNewImpactView(Collection<RequirementSource> requirementSources) {
		IViewPart view = createNewView();
		if (view == null) {
			return;
		}

		ImpactView reqView = (ImpactView) view;
		reqView.setRequirementSource(requirementSources.iterator().next());
	}

	public static IViewPart createNewView() {
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		int nbView = 0;
		for (IViewReference ref : activePage.getViewReferences()) {
			if (ref.getId().startsWith(VIEW_ID)) {
				nbView++;
			}
		}
		// increment to have the second view named #2
		nbView++;
		IViewPart view = null;
		try {
			view = activePage.showView(VIEW_ID, VIEW_ID + "_" + nbView, IWorkbenchPage.VIEW_ACTIVATE);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return view;

	}

	public void setRequirementSource(RequirementSource requirementSource) {
		this.requirementSource = requirementSource;
		impactComposites.setRequirementSource(this.requirementSource.getName());
	}

	public RequirementSource getRequirementSource() {
		return this.requirementSource;
	}

	/**
	 * Fills the action Bars
	 */
	protected void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalToolBar(bars.getToolBarManager());
	}

	/**
	 * Fills the local ToolBar
	 * 
	 * @param manager
	 *            The tool Bar manager
	 */
	protected void fillLocalToolBar(IToolBarManager manager) {
		manager.add(selectImpactInputs);
		manager.add(new Separator());
		manager.add(saveImpact);
	}

	protected void makeActions() {
		selectImpactInputs = new Action("Select Impact Analysis inputs") {

			@Override
			public void run() {
				RequirementSource reqSource = getRequirementSource();

				ImpactAnalysisInputSelectorDialog dialog = new ImpactAnalysisInputSelectorDialog(Display.getDefault().getActiveShell(), reqSource);

				if (dialog.open() == Window.OK) {
					ImpactAnalysis analysis = ImpactFactory.eINSTANCE.createImpactAnalysis();
					if (reqSource == null) {
						reqSource = dialog.getRequirementSource();
					}

					RequirementSource requirementSourceFrom = dialog.getRequirementSourceFrom();
					RequirementSource requirementSourceTo = dialog.getRequirementSourceTo();

					analysis.launchAnalysis(requirementSourceFrom, requirementSourceTo);

					impactComposites.setRequirementSource(dialog.getRequirementSource().getName());
					impactComposites.setInitialVersion(dialog.getInitialVersion());
					impactComposites.setFinalVersion(dialog.getFinalVersion());

					setImpactAnalysis(analysis);

					impactComposites.setImpactResult(impact.getRequirementsAdded(), impact.getRequirementsDeleted(), impact.getRequirementsModified());
				}
			}
		};
		selectImpactInputs.setImageDescriptor(Activator.getImageDescriptor("icons/goto_input-1.gif"));

		saveImpact = new Action("Save Impact Analysis") {

			@Override
			public void run() {
				SaveAsDialog d = new SaveAsDialog(Display.getDefault().getActiveShell()) {
				};
				if (d.open() == ResourceSelectionDialog.OK) {
					String extension = d.getResult().getFileExtension();
					String path = d.getResult().toString();
					if ((extension == null) || (extension.equals(FileExtension))) {
						path += "." + FileExtension;
					}
					impact.saveAnalysis(URI.createPlatformResourceURI(path, true));
					try {
						ResourcesPlugin.getWorkspace().getRoot().getFile(d.getResult()).getParent().refreshLocal(IResource.DEPTH_ONE, null);
					} catch (CoreException e) {
						e.printStackTrace();
					}

				}
			}
		};
		saveImpact.setImageDescriptor(Activator.getImageDescriptor("icons/Save_obj.gif"));
	}

	protected Resource newResource(URI uri, RequirementSource requirementSource) {
		XMIResourceImpl resource = new XMIResourceImpl() {
			@Override
			protected boolean useUUIDs() {
				return true;
			}
		};
		resource.getContents().add(requirementSource.getContents());
		resource.setURI(uri);
		return resource;
	}

	@Override
	public void setFocus() {
	}
}
