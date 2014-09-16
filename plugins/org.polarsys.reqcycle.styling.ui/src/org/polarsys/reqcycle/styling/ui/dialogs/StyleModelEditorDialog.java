package org.polarsys.reqcycle.styling.ui.dialogs;

import java.util.Collection;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;
import org.polarsys.reqcycle.predicates.core.api.IPredicate;
import org.polarsys.reqcycle.predicates.persistance.util.IPredicatesConfManager;
import org.polarsys.reqcycle.styling.model.Styling.CaseStyle;
import org.polarsys.reqcycle.styling.model.Styling.ConstantPattern;
import org.polarsys.reqcycle.styling.model.Styling.FontOption;
import org.polarsys.reqcycle.styling.model.Styling.Segment;
import org.polarsys.reqcycle.styling.model.Styling.StylingFactory;
import org.polarsys.reqcycle.styling.model.Styling.StylingModel;
import org.polarsys.reqcycle.styling.model.Styling.StylingPackage.Literals;
import org.polarsys.reqcycle.styling.model.Styling.StylingPredicate;
import org.polarsys.reqcycle.styling.model.Styling.util.StylingAdapterFactory;
import org.polarsys.reqcycle.styling.ui.IStylingManager;
import org.polarsys.reqcycle.styling.ui.dialogs.IconRegistry.Descriptor;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class StyleModelEditorDialog extends TitleAreaDialog implements IDoubleClickListener {
	IStylingManager styleManager = ZigguratInject.make(IStylingManager.class);
	IPredicatesConfManager predicatesConfManager = ZigguratInject.make(IPredicatesConfManager.class);

	private ListViewer listViewer;
	private StyledText styledText;
	private CaseStyle caseStyle;
	private StylingModel stylingModel;
	private Combo combo;
	private ComboViewer comboViewer;
	private Label iconLabel;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public StyleModelEditorDialog(Shell parentShell, CaseStyle style, StylingModel styling) {
		super(parentShell);
		setShellStyle(SWT.DIALOG_TRIM | SWT.MAX | SWT.RESIZE | SWT.PRIMARY_MODAL);
		caseStyle = style;
		if (caseStyle.getIcon() == null) {
			caseStyle.setIcon(StylingFactory.eINSTANCE.createIcon());
			caseStyle.getIcon().setImage("");
		}
		stylingModel = styling;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Styling predicate editor");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		if (caseStyle instanceof StylingPredicate) {
			Label lblName = new Label(container, SWT.NONE);
			lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblName.setText("Predicate : ");

			comboViewer = new ComboViewer(container, SWT.READ_ONLY);
			combo = comboViewer.getCombo();
			combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		}

		Group composite = new Group(container, SWT.NONE);
		composite.setText("Segments");
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 2));
		composite.setBounds(0, 0, 64, 64);

		listViewer = new ListViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		List list = listViewer.getList();
		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		listViewer.addDoubleClickListener(this);

		Composite compositeBtn = new Composite(composite, SWT.NONE);
		compositeBtn.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		GridLayout gl_compositeBtn = new GridLayout(1, false);
		gl_compositeBtn.marginHeight = 0;
		gl_compositeBtn.verticalSpacing = 0;
		gl_compositeBtn.horizontalSpacing = 0;
		compositeBtn.setLayout(gl_compositeBtn);

		Button btnAdd = new Button(compositeBtn, SWT.NONE);
		btnAdd.setToolTipText("Add new segment");
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				EList<Segment> segmentList = caseStyle.getSegments();
				Segment newSegment = StylingFactory.eINSTANCE.createSegment();

				ConstantPattern pattern = StylingFactory.eINSTANCE.createConstantPattern();
				pattern.setValue("New segment");
				newSegment.setPattern(pattern);
				newSegment.setStyle(StylingFactory.eINSTANCE.createStyle());
				newSegment.setColor(new Color(Display.getDefault(), 0, 0, 0));
				segmentList.add(newSegment);

				listViewer.setInput(caseStyle.getSegments());
				listViewer.setSelection(new StructuredSelection(newSegment));
				handlePreview();
			}
		});
		btnAdd.setImage(ResourceManager.getPluginImage("org.polarsys.reqcycle.styling.ui", "icons/add_obj.gif"));

		Button btnRemove = new Button(compositeBtn, SWT.NONE);
		btnRemove.setToolTipText("Remove selected segment");
		btnRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!listViewer.getSelection().isEmpty()) {
					IStructuredSelection selection = (IStructuredSelection) listViewer.getSelection();
					Segment segment = (Segment) selection.getFirstElement();
					if (segment != null) {
						EList<Segment> segmentList = caseStyle.getSegments();
						segmentList.remove(segment);

						listViewer.setInput(caseStyle.getSegments());
						handlePreview();
					}
				}
			}
		});
		btnRemove.setImage(ResourceManager.getPluginImage("org.polarsys.reqcycle.styling.ui", "icons/delete_obj.gif"));

		Button btnEdit = new Button(compositeBtn, SWT.NONE);
		btnEdit.setToolTipText("Edit selected segment");
		btnEdit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!listViewer.getSelection().isEmpty()) {
					IStructuredSelection selection = (IStructuredSelection) listViewer.getSelection();
					Segment segment = (Segment) selection.getFirstElement();
					if (segment != null) {
						editSegment(segment);
					}
				}
			}
		});
		btnEdit.setImage(ResourceManager.getPluginImage("org.polarsys.reqcycle.styling.ui", "icons/edit_obj.png"));
		btnEdit.setBounds(0, 0, 75, 25);

		Button btnUp = new Button(compositeBtn, SWT.NONE);
		btnUp.setToolTipText("Move up selected segment");
		btnUp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!listViewer.getSelection().isEmpty()) {
					IStructuredSelection selection = (IStructuredSelection) listViewer.getSelection();
					Segment segment = (Segment) selection.getFirstElement();
					if (segment != null) {
						EList<Segment> segmentList = caseStyle.getSegments();
						int pos = segmentList.indexOf(segment);
						if (pos > 0) {
							segmentList.move(pos, pos - 1);
							listViewer.setInput(caseStyle.getSegments());
							listViewer.setSelection(selection);
							handlePreview();
						}
					}
				}
			}
		});
		btnUp.setImage(ResourceManager.getPluginImage("org.polarsys.reqcycle.styling.ui", "icons/prev_nav-1.gif"));
		btnUp.setBounds(0, 0, 75, 25);

		Button btnDown = new Button(compositeBtn, SWT.NONE);
		btnDown.setToolTipText("Move down selected segment");
		btnDown.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!listViewer.getSelection().isEmpty()) {
					IStructuredSelection selection = (IStructuredSelection) listViewer.getSelection();
					Segment segment = (Segment) selection.getFirstElement();
					if (segment != null) {
						EList<Segment> segmentList = caseStyle.getSegments();
						int pos = segmentList.indexOf(segment);
						if ((pos != -1) && (pos != segmentList.size() - 1)) {
							segmentList.move(pos, pos + 1);
							listViewer.setInput(caseStyle.getSegments());
							listViewer.setSelection(selection);
							handlePreview();
						}
					}
				}
			}
		});
		btnDown.setImage(ResourceManager.getPluginImage("org.polarsys.reqcycle.styling.ui", "icons/next_nav-1.gif"));

		if (caseStyle instanceof StylingPredicate) {
			comboViewer.setContentProvider(ArrayContentProvider.getInstance());

			AdapterFactory adapterfactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterfactory) {
				@Override
				public String getText(Object object) {
					if (object instanceof IPredicate) {
						return (((IPredicate) object).getDisplayName());
					}
					return super.getText(object);
				}
			};

			comboViewer.setLabelProvider(labelProvider);

			Collection<IPredicate> predicates = predicatesConfManager.getPredicates(false);

			final Iterable<IPredicate> alreadyUsed = Iterables.filter(Iterables.transform(stylingModel.getStyles(), new Function<CaseStyle, IPredicate>() {

				@Override
				public IPredicate apply(CaseStyle arg0) {
					if (arg0 instanceof StylingPredicate) {
						StylingPredicate sp = (StylingPredicate) arg0;
						return sp.getPredicate();
					}
					return null;
				}

			}), Predicates.notNull());

			Collection<IPredicate> selectionPredicates = Lists.newArrayList(Iterables.filter(predicates, new Predicate<IPredicate>() {
				public boolean apply(IPredicate arg0) {
					for (IPredicate p : alreadyUsed) {
						if (p.getDisplayName().equals(arg0.getDisplayName())) {
							return false;
						}
					}
					return true;
				};
			}));

			selectionPredicates.add(((StylingPredicate) caseStyle).getPredicate());

			comboViewer.setInput(selectionPredicates);
			comboViewer.setSelection(new StructuredSelection(((StylingPredicate) caseStyle).getPredicate()));

		}

		initProviders(listViewer);

		Label lblIcon = new Label(container, SWT.NONE);
		lblIcon.setText("Icon :");

		Button btnNewButton = new Button(container, SWT.NONE);
		btnNewButton.setToolTipText("Select icon");
		btnNewButton.setText("...");
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PictureChooserDialog d = new PictureChooserDialog(getShell(), caseStyle.getIcon().getImage());

				if (d.open() == Window.OK) {
					caseStyle.getIcon().setImage(d.imageSelected);

					Display.getDefault().syncExec(new Runnable() {
						public void run() {
							iconLabel.setImage(IconRegistry.getImage(caseStyle.getIcon().getImage()));
						}
					});

				}
			}
		});

		Group grpPreview = new Group(container, SWT.NONE);
		GridData gd_grpPreview = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_grpPreview.widthHint = 393;
		grpPreview.setLayoutData(gd_grpPreview);
		grpPreview.setText("Preview");
		grpPreview.setLayout(new GridLayout(2, false));

		iconLabel = new Label(grpPreview, SWT.NONE);

		if (caseStyle.getIcon().getImage().equals("")) {
			Collection<Descriptor> listDesc = IconRegistry.getRegisteredImages();
			if (listDesc.size() != 0) {
				Descriptor desc = listDesc.iterator().next();
				caseStyle.getIcon().setImage(desc.id);
				iconLabel.setImage(IconRegistry.getImage(desc.id));
			}
		} else {
			iconLabel.setImage(IconRegistry.getImage(caseStyle.getIcon().getImage()));
		}

		styledText = new StyledText(grpPreview, SWT.NONE);
		styledText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		styledText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		styledText.setAlignment(SWT.CENTER);
		styledText.setEditable(false);
		styledText.setEnabled(false);

		handlePreview();
		return area;
	}

	private void handlePreview() {
		int pos = 0;
		EList<Segment> segmentList = caseStyle.getSegments();
		styledText.setText("");

		for (int i = 0; i < segmentList.size(); i++) {
			Segment segment = segmentList.get(i);

			styledText.append(segment.getPattern().getPattern());

			StyleRange style = new StyleRange();
			style.foreground = segment.getColor();
			style.start = pos;
			style.length = segment.getPattern().getPattern().length();
			int font = SWT.NORMAL;
			if (segment.getStyle().getAppliedFonts().contains(FontOption.BOLD)) {
				font |= SWT.BOLD;
			}
			if (segment.getStyle().getAppliedFonts().contains(FontOption.ITALIC)) {
				font |= SWT.ITALIC;
			}
			if (segment.getStyle().getAppliedFonts().contains(FontOption.UNDERLINE)) {
				style.underline = true;
			}
			if (segment.getStyle().getAppliedFonts().contains(FontOption.STRIKE)) {
				style.strikeout = true;
			}
			style.font = SWTResourceManager.getFont("Segoe UI", 9, font);
			styledText.setStyleRange(style);

			pos += segment.getPattern().getPattern().length();
		}
	}

	private void initProviders(ListViewer list) {
		AdapterFactory adapterfactory = new StylingAdapterFactory();
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterfactory) {
			@Override
			public String getText(Object object) {
				if (object instanceof Segment) {
					return ((Segment) object).getPattern().getPattern();
				}
				return super.getText(object);
			}
		};

		ArrayContentProvider contentProvider = ArrayContentProvider.getInstance();

		list.setLabelProvider(labelProvider);
		list.setContentProvider(contentProvider);

		list.setInput(caseStyle.getSegments());
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		if (caseStyle instanceof StylingPredicate) {
			initDataBindings();
		}
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(428, 497);
	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeSingleSelectionComboViewer = ViewerProperties.singleSelection().observe(comboViewer);
		IObservableValue caseStylePredicateObserveValue = EMFObservables.observeValue(caseStyle, Literals.STYLING_PREDICATE__PREDICATE);
		bindingContext.bindValue(observeSingleSelectionComboViewer, caseStylePredicateObserveValue, null, null);
		//
		return bindingContext;
	}

	private void editSegment(Segment segment) {
		SegmentEditorDialog editor = new SegmentEditorDialog(Display.getDefault().getActiveShell(), segment);
		if (editor.open() == Window.OK) {
			// TODO

			listViewer.setInput(caseStyle.getSegments());
			handlePreview();
		}
	}

	@Override
	public void doubleClick(DoubleClickEvent event) {
		final IStructuredSelection selection = (IStructuredSelection) event.getSelection();
		if (selection.getFirstElement() instanceof Segment) {
			editSegment((Segment) selection.getFirstElement());
		}
	}
}
