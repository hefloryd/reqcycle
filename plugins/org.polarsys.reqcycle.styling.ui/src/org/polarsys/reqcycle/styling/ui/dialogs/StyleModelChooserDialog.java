package org.polarsys.reqcycle.styling.ui.dialogs;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.ResourceManager;
import org.polarsys.reqcycle.styling.model.Styling.StylingFactory;
import org.polarsys.reqcycle.styling.model.Styling.StylingModel;
import org.polarsys.reqcycle.styling.model.Styling.util.StylingAdapterFactory;
import org.polarsys.reqcycle.styling.ui.IStylingManager;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class StyleModelChooserDialog extends TitleAreaDialog implements IDoubleClickListener {

	private ListViewer listViewer;

	IStylingManager styleManager = ZigguratInject.make(IStylingManager.class);

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public StyleModelChooserDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.MIN | SWT.RESIZE | SWT.TITLE | SWT.PRIMARY_MODAL);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Style configuration");

		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				1));

		listViewer = new ListViewer(composite, SWT.BORDER | SWT.V_SCROLL);
		List list = listViewer.getList();

		listViewer.addDoubleClickListener(this);

		Composite composite_1 = new Composite(container, SWT.NONE);
		composite_1.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false,
				1, 1));
		composite_1.setLayout(new GridLayout(1, false));

		Button btnAdd = new Button(composite_1, SWT.NONE);
		btnAdd.setToolTipText("Add new style configuration");
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				StyleModelNameDialog dialog = new StyleModelNameDialog(Display
						.getDefault().getActiveShell());
				if (dialog.open() == Window.OK) {
					if (!dialog.getStyleModelName().equals("")) {
						StylingModel newStylingModel = StylingFactory.eINSTANCE
								.createStylingModel();
						newStylingModel.setModeName(dialog.getStyleModelName());

						styleManager.getStyling().getModels()
						.add(newStylingModel);

						if (styleManager.getStyling().getModels().size() == 1) {
							styleManager.setPreferredStylingModel(dialog
									.getStyleModelName());

						}

						listViewer.setInput(styleManager.getStyling()
								.getModels());
						listViewer.setSelection(new StructuredSelection(
								newStylingModel));
					}
				}
			}
		});
		btnAdd.setImage(ResourceManager.getPluginImage(
				"org.polarsys.reqcycle.styling.ui", "icons/add_obj.gif"));

		Button btnRemove = new Button(composite_1, SWT.NONE);
		btnRemove.setToolTipText("Remove the selected style configuration");
		btnRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!listViewer.getSelection().isEmpty()) {
					IStructuredSelection selection = (IStructuredSelection) listViewer
							.getSelection();
					StylingModel stylingModel = (StylingModel) selection
							.getFirstElement();
					if (stylingModel != null) {
						styleManager.getStyling().getModels()
						.remove(stylingModel);

						if ((styleManager.getPreferredStyleModel()
								.equals(stylingModel.getModeName()))
								&& (styleManager.getStyling().getModels()
										.size() != 0)) {
							styleManager.setPreferredStylingModel(styleManager
									.getStyling().getModels().get(0)
									.getModeName());
						}
						listViewer.setInput(styleManager.getStyling()
								.getModels());
					}
				}
			}
		});
		btnRemove.setImage(ResourceManager.getPluginImage(
				"org.polarsys.reqcycle.styling.ui", "icons/delete_obj.gif"));

		Button btnEdit = new Button(composite_1, SWT.NONE);
		btnEdit.setToolTipText("Edit the selected style configuration");
		btnEdit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!listViewer.getSelection().isEmpty()) {
					IStructuredSelection selection = (IStructuredSelection) listViewer
							.getSelection();
					StylingModel stylingModel = (StylingModel) selection
							.getFirstElement();
					if (stylingModel != null) {
						editSelectedStylingModel(stylingModel);
					}
				}
			}
		});
		btnEdit.setImage(ResourceManager.getPluginImage(
				"org.polarsys.reqcycle.styling.ui", "icons/edit_obj.png"));
		new Label(composite_1, SWT.NONE);

		Button btnUp = new Button(composite_1, SWT.NONE);
		btnUp.setToolTipText("Move up the selected style configuration");
		btnUp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!listViewer.getSelection().isEmpty()) {
					IStructuredSelection selection = (IStructuredSelection) listViewer
							.getSelection();
					StylingModel stylingModel = (StylingModel) selection
							.getFirstElement();
					if (stylingModel != null) {
						int index = styleManager.getStyling().getModels()
								.indexOf(stylingModel);
						if (index != 0) {
							styleManager.getStyling().getModels()
							.move(index, index - 1);
						}

						listViewer.setInput(styleManager.getStyling()
								.getModels());
						listViewer.setSelection(selection);
					}
				}
			}
		});
		btnUp.setImage(ResourceManager.getPluginImage(
				"org.polarsys.reqcycle.styling.ui", "icons/prev_nav-1.gif"));

		Button btnDown = new Button(composite_1, SWT.NONE);
		btnDown.setToolTipText("Move down the selected style configuration");
		btnDown.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!listViewer.getSelection().isEmpty()) {
					IStructuredSelection selection = (IStructuredSelection) listViewer
							.getSelection();
					StylingModel stylingModel = (StylingModel) selection
							.getFirstElement();
					if (stylingModel != null) {
						int index = styleManager.getStyling().getModels()
								.indexOf(stylingModel);
						if (index != (styleManager.getStyling().getModels()
								.size() - 1)) {
							styleManager.getStyling().getModels()
							.move(index, index + 1);
						}

						listViewer.setInput(styleManager.getStyling()
								.getModels());
						listViewer.setSelection(selection);
					}
				}
			}
		});
		btnDown.setImage(ResourceManager.getPluginImage(
				"org.polarsys.reqcycle.styling.ui", "icons/next_nav-1.gif"));

		Button btnSetPreferred = new Button(composite_1, SWT.NONE);
		btnSetPreferred
		.setToolTipText("Activate the selected style configuration");
		btnSetPreferred.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!listViewer.getSelection().isEmpty()) {
					IStructuredSelection selection = (IStructuredSelection) listViewer
							.getSelection();
					StylingModel stylingModel = (StylingModel) selection
							.getFirstElement();
					if (stylingModel != null) {
						styleManager.setPreferredStylingModel(stylingModel
								.getModeName());
						listViewer.setInput(styleManager.getStyling()
								.getModels());
						listViewer.setSelection(selection);
					}
				}
			}
		});
		btnSetPreferred
		.setImage(ResourceManager.getPluginImage("org.polarsys.reqcycle.styling.ui", "icons/set_pref.png"));
		initProviders(listViewer);
		return area;
	}

	private void initProviders(ListViewer listViewer) {
		AdapterFactory adapterfactory = new StylingAdapterFactory();
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(
				adapterfactory) {
			@Override
			public String getText(Object object) {
				if (object instanceof StylingModel) {

					if (((StylingModel) object).getModeName().equals(
							styleManager.getPreferredStyleModel())) {
						return (((StylingModel) object).getModeName() + " (Selected)");
					} else {
						return ((StylingModel) object).getModeName();
					}
				}
				return super.getText(object);
			}
		};
		ArrayContentProvider contentProvider = ArrayContentProvider
				.getInstance();

		listViewer.setLabelProvider(labelProvider);
		listViewer.setContentProvider(contentProvider);

		listViewer.setInput(styleManager.getStyling().getModels());
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(326, 394);
	}

	public StylingModel getPreferred() {
		String preferred = styleManager.getPreferredStyleModel();
		EList<StylingModel> stylingModelList = styleManager.getStyling()
				.getModels();

		for (int i = 0; i < stylingModelList.size(); i++) {
			if (stylingModelList.get(i).getModeName().equals(preferred)) {
				return stylingModelList.get(i);
			}
		}

		return null;
	}

	private void editSelectedStylingModel(StylingModel selected) {
		CaseStyleEditorDialog editor = new CaseStyleEditorDialog(
				Display.getDefault().getActiveShell(),
				selected);
		String currentStylingModelName = selected
				.getModeName();
		boolean isDefault = false;
		if (styleManager.getPreferredStyleModel().equals(
				currentStylingModelName)) {
			isDefault = true;
		}
		int dialogResult = editor.open();
		if (dialogResult == Window.OK) {
			// TODO
			if (isDefault) {
				styleManager
				.setPreferredStylingModel(selected
						.getModeName());
				listViewer.setInput(styleManager.getStyling()
						.getModels());
			}
		} else if (dialogResult == Window.CANCEL) {
			selected.setModeName(currentStylingModelName);
		} 
	}
	
	@Override
	public void doubleClick(DoubleClickEvent event) {
		final IStructuredSelection selection = (IStructuredSelection) event
				.getSelection();
		if (selection.getFirstElement() instanceof StylingModel) {
			StylingModel stylingModel = (StylingModel) selection
					.getFirstElement();
			if (stylingModel != null) {
				editSelectedStylingModel(stylingModel);
			}
		}
	}
}
