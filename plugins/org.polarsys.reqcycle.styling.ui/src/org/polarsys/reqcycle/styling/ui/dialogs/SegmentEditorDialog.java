package org.polarsys.reqcycle.styling.ui.dialogs;

import java.lang.reflect.Method;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.polarsys.reqcycle.core.ui.dialogs.ValidatingTitleAreaDialog;
import org.polarsys.reqcycle.operations.IReqCycleOperationManager;
import org.polarsys.reqcycle.operations.ReqCycleOperation;
import org.polarsys.reqcycle.operations.dialogs.OperationAttributesEditor;
import org.polarsys.reqcycle.operations.dialogs.SelectOperationDialog;
import org.polarsys.reqcycle.repository.data.types.IAttribute;
import org.polarsys.reqcycle.styling.model.Styling.BooleanParameter;
import org.polarsys.reqcycle.styling.model.Styling.ConstantPattern;
import org.polarsys.reqcycle.styling.model.Styling.EObjectParameter;
import org.polarsys.reqcycle.styling.model.Styling.FontOption;
import org.polarsys.reqcycle.styling.model.Styling.IntParameter;
import org.polarsys.reqcycle.styling.model.Styling.ModelPattern;
import org.polarsys.reqcycle.styling.model.Styling.OperationPattern;
import org.polarsys.reqcycle.styling.model.Styling.Parameter;
import org.polarsys.reqcycle.styling.model.Styling.Pattern;
import org.polarsys.reqcycle.styling.model.Styling.Segment;
import org.polarsys.reqcycle.styling.model.Styling.StringParameter;
import org.polarsys.reqcycle.styling.model.Styling.StylingFactory;
import org.polarsys.reqcycle.ui.eattrpropseditor.GenericEAttrPropsEditor;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class SegmentEditorDialog extends ValidatingTitleAreaDialog {

	@Inject
	IReqCycleOperationManager reqCycleOperationlManager;

	private Segment segment;
	private Text constantText;
	private Text modelText;
	private Text operationText;
	private StyleRange style;
	private StyledText styledText;

	private Button btnItallic;
	private Button btnBold;
	private Button btnUnderline;
	private Button btnStrike;
	private Button btnLoadResources;
	private Button btnOperation;
	private Button btnEditOperation;

	private Button constantButton;
	private Button modelButton;
	private Button operationButton;

	private Method method;

	private ColorSelector colorSelector;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public SegmentEditorDialog(Shell parentShell, Segment segmentToEdit) {
		super(parentShell);
		segment = segmentToEdit;
		ZigguratInject.inject(this);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Segment editor");

		Composite area = new Composite(parent, SWT.None);
		area.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		area.setLayout(new GridLayout(8, false));

		Label lblColor = new Label(area, SWT.NONE);
		lblColor.setText("Color :");

		colorSelector = new ColorSelector(area);
		colorSelector.setColorValue(new RGB(segment.getColor().getRed(), segment.getColor().getGreen(), segment.getColor().getBlue()));
		colorSelector.getButton().setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 7, 1));
		colorSelector.getButton().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				segment.setColor(new Color(Display.getDefault(), colorSelector.getColorValue()));
				handleStyle();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		Label lblFont = new Label(area, SWT.NONE);
		lblFont.setText("Font :");

		btnItallic = new Button(area, SWT.CHECK);
		btnItallic.setText("I");
		if (segment.getStyle().getAppliedFonts().contains(FontOption.ITALIC)) {
			btnItallic.setSelection(true);
		}
		btnItallic.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				handleStyle();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		btnBold = new Button(area, SWT.CHECK);
		btnBold.setText("B");
		if (segment.getStyle().getAppliedFonts().contains(FontOption.BOLD)) {
			btnBold.setSelection(true);
		}
		btnBold.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				handleStyle();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		btnUnderline = new Button(area, SWT.CHECK);
		btnUnderline.setText("U");
		if (segment.getStyle().getAppliedFonts().contains(FontOption.UNDERLINE)) {
			btnUnderline.setSelection(true);
		}
		btnUnderline.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				handleStyle();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		btnStrike = new Button(area, SWT.CHECK);
		btnStrike.setText("S");
		if (segment.getStyle().getAppliedFonts().contains(FontOption.STRIKE)) {
			btnStrike.setSelection(true);
		}
		btnStrike.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				handleStyle();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		new Label(area, SWT.NONE);
		new Label(area, SWT.NONE);
		new Label(area, SWT.NONE);

		constantButton = new Button(area, SWT.RADIO);
		constantButton.setText("Constant :");
		constantButton.addSelectionListener(new SegmentSelectionListener());

		constantText = new Text(area, SWT.BORDER);
		constantText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 7, 1));
		constantText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				Pattern pattern = segment.getPattern();
				if (pattern instanceof ConstantPattern) {
					((ConstantPattern) pattern).setValue(constantText.getText());
				} else {
					ConstantPattern newPattern = StylingFactory.eINSTANCE.createConstantPattern();
					newPattern.setValue(constantText.getText());
					segment.setPattern(newPattern);
				}
				validateInput();
			}
		});

		modelButton = new Button(area, SWT.RADIO);
		modelButton.setText("Model :");
		modelButton.addSelectionListener(new SegmentSelectionListener());

		modelText = new Text(area, SWT.BORDER);
		modelText.setEditable(false);
		modelText.setEnabled(false);
		modelText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 6, 1));

		btnLoadResources = new Button(area, SWT.NONE);
		btnLoadResources.setText("...");
		btnLoadResources.setLayoutData(GridDataFactory.fillDefaults().create());
		btnLoadResources.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				SelectModelDialog dialog = new SelectModelDialog(Display.getDefault().getActiveShell());
				int result = dialog.open();
				if (result == Window.OK) {
					IAttribute att = dialog.getResult();
					String attributeName = att.getName();
					ModelPattern pattern = StylingFactory.eINSTANCE.createModelPattern();
					pattern.setAttributeName(attributeName);
					segment.setPattern(pattern);
					modelText.setText(attributeName);

					validateInput();
				}
			}
		});

		operationButton = new Button(area, SWT.RADIO);
		operationButton.setText("Operation :");
		operationButton.addSelectionListener(new SegmentSelectionListener());

		operationText = new Text(area, SWT.BORDER);
		operationText.setEditable(false);
		operationText.setEnabled(false);
		operationText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));

		btnOperation = new Button(area, SWT.NONE);
		btnOperation.setText("...");
		btnOperation.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				SelectOperationDialog dialog = new SelectOperationDialog(Display.getDefault().getActiveShell());
				int result = dialog.open();
				if (result == Window.OK) {
					ReqCycleOperation op = dialog.getResult();

					String opText = op.getMethod().getName();

					method = op.getMethod();

					Class<?>[] paramList = method.getParameterTypes();

					if (paramList.length > 1) {
						opText += "(";
						for (int i = 1; i < paramList.length; i++) {
							Class<?> c = paramList[i];
							if (i != 1) {
								opText += " ,";
							}
							opText += c.getSimpleName();
						}
						opText += ")";
					}

					operationText.setText(opText);

					// TODO
					if (method.getParameterTypes().length > 1) {
						btnEditOperation.setEnabled(true);
					} else {
						btnEditOperation.setEnabled(false);
						OperationPattern pattern = StylingFactory.eINSTANCE.createOperationPattern();
						pattern.setOperation(method.getName());

						segment.setPattern(pattern);
					}

					validateInput();
				}
			}
		});

		btnEditOperation = new Button(area, SWT.NONE);
		btnEditOperation.setText("Edit");
		btnEditOperation.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				OperationAttributesEditor dialog = new OperationAttributesEditor(Display.getDefault().getActiveShell(), method);
				int result = dialog.open();
				if (result == Window.OK) {
					OperationPattern pattern = StylingFactory.eINSTANCE.createOperationPattern();
					pattern.setOperation(method.getName());

					for (Map.Entry<String, GenericEAttrPropsEditor> entry : dialog.getEditors().entrySet()) {
						GenericEAttrPropsEditor editor = entry.getValue();

						Object obj = editor.getEnteredValue();
						if (obj instanceof String) {
							StringParameter param = StylingFactory.eINSTANCE.createStringParameter();
							param.setName(entry.getKey());
							param.setValue((String) obj);
							pattern.getParameters().add(param);
						} else if (obj instanceof Integer) {
							IntParameter param = StylingFactory.eINSTANCE.createIntParameter();
							param.setName(entry.getKey());
							param.setValue((Integer) obj);
							pattern.getParameters().add(param);
						} else if (obj instanceof Boolean) {
							BooleanParameter param = StylingFactory.eINSTANCE.createBooleanParameter();
							param.setName(entry.getKey());
							param.setValue((Boolean) obj);
							pattern.getParameters().add(param);
						} else if (obj instanceof EObject) {
							EObjectParameter param = StylingFactory.eINSTANCE.createEObjectParameter();
							param.setName(entry.getKey());
							param.setValue((EObject) obj);
							pattern.getParameters().add(param);
						}
					}

					segment.setPattern(pattern);
				}
			}
		});

		initRadioButtons();

		styledText = new StyledText(area, SWT.BORDER);
		styledText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		styledText.setAlignment(SWT.CENTER);
		styledText.setText("The quick brown fox jumps over the lazy dog");
		styledText.setEditable(false);
		styledText.setEnabled(false);
		styledText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 8, 1));

		handleStyle();

		return area;
	}

	private void handleStyle() {
		style = new StyleRange();
		style.foreground = segment.getColor();
		style.start = 0;
		style.length = styledText.getText().length();
		style.underline = btnUnderline.getSelection();
		style.strikeout = btnStrike.getSelection();
		int font = SWT.NORMAL;
		segment.getStyle().getAppliedFonts().clear();
		if (btnBold.getSelection()) {
			font |= SWT.BOLD;
			segment.getStyle().getAppliedFonts().add(FontOption.BOLD);
		}
		if (btnItallic.getSelection()) {
			font |= SWT.ITALIC;
			segment.getStyle().getAppliedFonts().add(FontOption.ITALIC);

		}
		if (btnUnderline.getSelection()) {
			segment.getStyle().getAppliedFonts().add(FontOption.UNDERLINE);

		}
		if (btnStrike.getSelection()) {
			segment.getStyle().getAppliedFonts().add(FontOption.STRIKE);

		}
		style.font = SWTResourceManager.getFont("Segoe UI", 9, font);
		styledText.setStyleRange(style);
	}

	private class SegmentSelectionListener extends SelectionAdapter {

		@Override
		public void widgetSelected(SelectionEvent e) {
			Object source = e.getSource();
			if (source instanceof Button) {
				Button btn = (Button) source;
				handleRadioButtons(btn.getText());
			}
		}
	}

	private void initRadioButtons() {
		Pattern pattern = segment.getPattern();
		if (pattern instanceof ConstantPattern) {
			constantText.setEnabled(true);
			btnLoadResources.setEnabled(false);
			btnOperation.setEnabled(false);
			btnEditOperation.setEnabled(false);

			constantText.setText(((ConstantPattern) pattern).getPattern());
			constantButton.setSelection(true);
		} else if (pattern instanceof ModelPattern) {
			constantText.setEnabled(false);
			btnLoadResources.setEnabled(true);
			btnOperation.setEnabled(false);
			btnEditOperation.setEnabled(false);

			modelText.setText(((ModelPattern) pattern).getAttributeName());
			modelButton.setSelection(true);
		} else if (pattern instanceof OperationPattern) {
			constantText.setEnabled(false);
			btnLoadResources.setEnabled(false);
			btnOperation.setEnabled(true);

			String operationName = ((OperationPattern) pattern).getOperation();
			operationText.setText(operationName);
			operationButton.setSelection(true);

			EList<Parameter> paramList = ((OperationPattern) pattern).getParameters();
			Class<?>[] listTypes = new Class<?>[paramList.size()];
			for (int i = 0; i < paramList.size(); i++) {
				Parameter p = paramList.get(i);
				if (p instanceof StringParameter) {
					listTypes[i] = String.class;
				} else if (p instanceof IntParameter) {
					listTypes[i] = Integer.class;
				} else if (p instanceof BooleanParameter) {
					listTypes[i] = Boolean.class;
				} else if (p instanceof EObjectParameter) {
					listTypes[i] = EObject.class;
				} else {
					// Type is not supported
					return;
				}
			}
			ReqCycleOperation op = reqCycleOperationlManager.getOperationForEditingAttributes(operationName, listTypes);
			if (op != null) {
				method = op.getMethod();
				if (paramList.size() > 0) {
					btnEditOperation.setEnabled(true);
				} else {
					btnEditOperation.setEnabled(false);
				}
			} else {
				btnEditOperation.setEnabled(false);
			}
		}
	}

	private void handleRadioButtons(String buttonSelected) {
		if (buttonSelected.equals("Constant :")) {
			constantText.setEnabled(true);
			btnLoadResources.setEnabled(false);
			btnOperation.setEnabled(false);
			btnEditOperation.setEnabled(false);
			modelText.setText("");
			operationText.setText("");
		} else if (buttonSelected.equals("Model :")) {
			constantText.setEnabled(false);
			btnLoadResources.setEnabled(true);
			btnOperation.setEnabled(false);
			btnEditOperation.setEnabled(false);
			constantText.setText("");
			operationText.setText("");
		} else if (buttonSelected.equals("Operation :")) {
			constantText.setEnabled(false);
			btnLoadResources.setEnabled(false);
			btnOperation.setEnabled(true);
			btnEditOperation.setEnabled(false);
			constantText.setText("");
			modelText.setText("");
		}
		validateInput();
	}

	@Override
	public IValidator getInputValidator() {
		return new IValidator() {
			@Override
			public String isValid() {
				if (constantButton.getSelection()) {
					if (constantText.getText().equals("")) {
						return "A constant text must be entered";
					}
				} else if (modelButton.getSelection()) {
					if (modelText.getText().equals("")) {
						return "A model must be selected";
					}
				} else if (operationButton.getSelection()) {
					if (operationText.getText().equals("")) {
						return "An operation must be selected";
					}
				}
				return null;
			}
		};
	}
}
