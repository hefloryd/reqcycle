package org.polarsys.reqcycle.styling.ui.dialogs;

import java.util.Collection;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.ResourceManager;
import org.polarsys.reqcycle.core.ui.dialogs.ValidatingTitleAreaDialog;
import org.polarsys.reqcycle.predicates.core.api.IPredicate;
import org.polarsys.reqcycle.predicates.persistance.util.IPredicatesConfManager;
import org.polarsys.reqcycle.predicates.ui.util.PredicatesUIHelper;
import org.polarsys.reqcycle.styling.model.Styling.Basic;
import org.polarsys.reqcycle.styling.model.Styling.CaseStyle;
import org.polarsys.reqcycle.styling.model.Styling.Default;
import org.polarsys.reqcycle.styling.model.Styling.StylingFactory;
import org.polarsys.reqcycle.styling.model.Styling.StylingModel;
import org.polarsys.reqcycle.styling.model.Styling.StylingPredicate;
import org.polarsys.reqcycle.styling.ui.IStylingManager;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class CaseStyleEditorDialog extends ValidatingTitleAreaDialog implements IDoubleClickListener {
	IStylingManager styleManager = ZigguratInject.make(IStylingManager.class);
	IPredicatesConfManager predicatesConfManager = ZigguratInject
			.make(IPredicatesConfManager.class);

	private ListViewer listViewer;

	private StylingModel stylingModel;
	private Text text;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public CaseStyleEditorDialog(Shell parentShell, StylingModel style) {
		super(parentShell);
		setShellStyle(SWT.DIALOG_TRIM | SWT.MAX | SWT.RESIZE
				| SWT.PRIMARY_MODAL);
		stylingModel = style;
		if (stylingModel.getDefault() == null) {
			Default defaultStyle = StylingFactory.eINSTANCE.createDefault();
			stylingModel.setDefault(defaultStyle);
		}
		if (stylingModel.getBasic() == null) {
			Basic basicStyle = StylingFactory.eINSTANCE.createBasic();
			stylingModel.setBasic(basicStyle);
		}
	}

	@Override
	protected Control createContents(Composite parent) {
		Control result = super.createContents(parent);
		validateInput();
		return result;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Styling configuration");

		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		Label lblName = new Label(container, SWT.NONE);
		lblName.setText("Name :");

		text = new Text(container, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		text.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validateInput();
			}
		});

		Group composite = new Group(container, SWT.NONE);
		composite.setText("Style predicates");
		composite.setToolTipText("");
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2,
				1));

		listViewer = new ListViewer(composite, SWT.BORDER | SWT.V_SCROLL);
		listViewer.setUseHashlookup(true);
		List list = listViewer.getList();
		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		listViewer.addDoubleClickListener(this);
		
		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, true,
				1, 1));
		composite_1.setLayout(new GridLayout(1, false));

		Button btnAdd = new Button(composite_1, SWT.NONE);
		btnAdd.setToolTipText("Add new styling predicate");
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final Collection<IPredicate> predicates = predicatesConfManager
						.getPredicates(false);

				final Iterable<IPredicate> alreadyUsed = Iterables.filter(
						Iterables.transform(stylingModel.getStyles(),
								new Function<CaseStyle, IPredicate>() {

							@Override
							public IPredicate apply(CaseStyle arg0) {
								if (arg0 instanceof StylingPredicate) {
									StylingPredicate sp = (StylingPredicate) arg0;
									return sp.getPredicate();
								}
								return null;
							}

						}), Predicates.notNull());
				Collection<IPredicate> selectionPredicates = Lists
						.newArrayList(Iterables.filter(predicates,
								new Predicate<IPredicate>() {
							public boolean apply(IPredicate arg0) {
								for (IPredicate p : alreadyUsed) {
									if (p.getDisplayName().equals(
											arg0.getDisplayName())) {
										return false;
									}
								}
								return true;
							};
						}));

				Collection<IPredicate> selection = PredicatesUIHelper
						.openPredicatesChooser(selectionPredicates,
								selectionPredicates, "Creating Styling Model",
								"Select a predicate to apply.", false);
				if (selection != null) {
					EList<CaseStyle> casesStyle = stylingModel.getStyles();
					CaseStyle newStyle = StylingFactory.eINSTANCE
							.createStylingPredicate();
					casesStyle.add(newStyle);

					IPredicate p = selection.iterator().next();
					((StylingPredicate) newStyle).setPredicate(p);

					listViewer.setInput(stylingModel.getStyles());
					listViewer.setSelection(new StructuredSelection(newStyle));
				}
			}
		});
		btnAdd.setImage(ResourceManager.getPluginImage(
				"org.polarsys.reqcycle.styling.ui", "icons/add_obj.gif"));

		Button btnRemove = new Button(composite_1, SWT.NONE);
		btnRemove.setToolTipText("Remove the selected styling predicate");
		btnRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!listViewer.getSelection().isEmpty()) {
					IStructuredSelection selection = (IStructuredSelection) listViewer
							.getSelection();
					CaseStyle caseStyle = (CaseStyle) selection
							.getFirstElement();
					if (caseStyle != null) {
						EList<CaseStyle> casesStyle = stylingModel.getStyles();
						casesStyle.remove(caseStyle);

						listViewer.setInput(stylingModel.getStyles());
					}

				}
			}
		});
		btnRemove.setImage(ResourceManager.getPluginImage(
				"org.polarsys.reqcycle.styling.ui", "icons/delete_obj.gif"));

		Button btnEdit = new Button(composite_1, SWT.NONE);
		btnEdit.setToolTipText("Edit the selected styling predicate");
		btnEdit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!listViewer.getSelection().isEmpty()) {
					IStructuredSelection selection = (IStructuredSelection) listViewer
							.getSelection();
					CaseStyle caseStyle = (CaseStyle) selection
							.getFirstElement();
					if (caseStyle != null) {
						editStylePredicate(caseStyle);
					}
				}
			}
		});
		btnEdit.setImage(ResourceManager.getPluginImage(
				"org.polarsys.reqcycle.styling.ui", "icons/edit_obj.png"));
		new Label(composite_1, SWT.NONE);

		Button btnUp = new Button(composite_1, SWT.NONE);
		btnUp.setToolTipText("Move up the selected styling predicate");
		btnUp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!listViewer.getSelection().isEmpty()) {
					IStructuredSelection selection = (IStructuredSelection) listViewer
							.getSelection();
					CaseStyle caseStyle = (CaseStyle) selection
							.getFirstElement();
					if (caseStyle != null) {
						EList<CaseStyle> list = stylingModel.getStyles();
						int pos = list.indexOf(caseStyle);
						if (pos > 0) {
							list.move(pos, pos - 1);

							listViewer.setInput(stylingModel.getStyles());
							listViewer.setSelection(selection);
						}
					}
				}
			}
		});
		btnUp.setImage(ResourceManager.getPluginImage(
				"org.polarsys.reqcycle.styling.ui", "icons/prev_nav-1.gif"));

		Button btnDown = new Button(composite_1, SWT.NONE);
		btnDown.setToolTipText("Move down the selected styling predicate");
		btnDown.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!listViewer.getSelection().isEmpty()) {
					IStructuredSelection selection = (IStructuredSelection) listViewer
							.getSelection();
					CaseStyle caseStyle = (CaseStyle) selection
							.getFirstElement();
					if (caseStyle != null) {
						EList<CaseStyle> list = stylingModel.getStyles();
						int pos = list.indexOf(caseStyle);
						if ((pos != -1) && (pos != list.size() - 1)) {
							list.move(pos, pos + 1);

							listViewer.setInput(stylingModel.getStyles());
							listViewer.setSelection(selection);
						}
					}
				}
			}
		});
		btnDown.setImage(ResourceManager.getPluginImage(
				"org.polarsys.reqcycle.styling.ui", "icons/next_nav-1.gif"));

		initDataBindings();

		initProviders(listViewer);

		Label lblDefaultPredicate = new Label(container, SWT.NONE);
		lblDefaultPredicate.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		lblDefaultPredicate.setText("Default :");

		Button btnEdit_1 = new Button(container, SWT.NONE);
		btnEdit_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				StyleModelEditorDialog editor = new StyleModelEditorDialog(
						Display.getDefault().getActiveShell(), stylingModel
						.getDefault(), stylingModel);
				if (editor.open() == Window.OK) {
					listViewer.setInput(stylingModel.getStyles());
				}
			}
		});
		btnEdit_1.setText("Edit");
		
		Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblNewLabel.setText("Basic styling is the style used to display requirements in ReqCycle views (except Requirements view).");
		
		Label lblBasic = new Label(container, SWT.NONE);
		lblBasic.setText("Basic :");
		
		Button btnEdit_2 = new Button(container, SWT.NONE);
		btnEdit_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				StyleModelEditorDialog editor = new StyleModelEditorDialog(
						Display.getDefault().getActiveShell(), stylingModel
						.getBasic(), stylingModel);
				if (editor.open() == Window.OK) {
					listViewer.setInput(stylingModel.getStyles());
				}
			}
		});
		btnEdit_2.setText("Edit");

		return area;
	}

	private void initProviders(ListViewer listViewer) {
		AdapterFactory adapterfactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(
				adapterfactory) {
			@Override
			public String getText(Object object) {
				if (object instanceof StylingPredicate) {
					StylingPredicate stylingPredicate = (StylingPredicate) object;

					return (stylingPredicate.getPredicate().getDisplayName());
				}
				return super.getText(object);
			}
		};

		ArrayContentProvider contentProvider = ArrayContentProvider
				.getInstance();

		listViewer.setLabelProvider(labelProvider);
		listViewer.setContentProvider(contentProvider);

		listViewer.setInput(stylingModel.getStyles());
	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTextObserveWidget = WidgetProperties.text(
				SWT.Modify).observe(text);
		IObservableValue modeNameStylingModelObserveValue = PojoProperties
				.value("modeName").observe(stylingModel);
		bindingContext.bindValue(observeTextTextObserveWidget,
				modeNameStylingModelObserveValue, null, null);
		//
		return bindingContext;
	}

	/**
	 * Check if the name is already used
	 * 
	 * @param name
	 *            Name to check
	 */
	private boolean isNameAlreadyUsed(String name) {
		EList<StylingModel> list = styleManager.getStyling().getModels();

		boolean alreadyUsed = false;
		if (name != null && list != null) {
			for (StylingModel s : list) {
				if (!s.equals(stylingModel)) {
					if (name.equals(s.getModeName())) {
						alreadyUsed = true;
						break;
					}
				}
			}
		}
		return alreadyUsed;
	}

	@Override
	public IValidator getInputValidator() {
		return new IValidator() {
			@Override
			public String isValid() {
				String newText = text.getText();
				if (newText == null || newText.isEmpty()) {
					return "Enter the name of the styling model";
				} else if (isNameAlreadyUsed(newText)) {
					return "This styling model's name is already used.";
				}
				return null;
			}

		};
	}
	
	private void editStylePredicate(CaseStyle caseStyle) {
		StyleModelEditorDialog editor = new StyleModelEditorDialog(
				Display.getDefault().getActiveShell(),
				(StylingPredicate) caseStyle, stylingModel);
		if (editor.open() == Window.OK) {
			// TODO

			listViewer.setInput(stylingModel.getStyles());
		}
	}
	
	@Override
	public void doubleClick(DoubleClickEvent event) {
		final IStructuredSelection selection = (IStructuredSelection) event
				.getSelection();
		if (selection.getFirstElement() instanceof CaseStyle) {
			CaseStyle caseStyle = (CaseStyle) selection
					.getFirstElement();
			if (caseStyle != null) {
				editStylePredicate(caseStyle);
			}
		}
	}
}
