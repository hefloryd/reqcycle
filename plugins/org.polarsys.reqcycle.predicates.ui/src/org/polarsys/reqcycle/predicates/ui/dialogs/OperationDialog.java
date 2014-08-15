package org.polarsys.reqcycle.predicates.ui.dialogs;

import java.lang.reflect.Method;
import java.util.Map;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.polarsys.reqcycle.core.ui.dialogs.ValidatingTitleAreaDialog;
import org.polarsys.reqcycle.operations.ReqCycleOperation;
import org.polarsys.reqcycle.operations.dialogs.OperationAttributesEditor;
import org.polarsys.reqcycle.operations.dialogs.SelectOperationDialog;
import org.polarsys.reqcycle.predicates.core.api.OperationPredicate;
import org.polarsys.reqcycle.ui.eattrpropseditor.GenericEAttrPropsEditor;

public class OperationDialog extends ValidatingTitleAreaDialog {

	private OperationPredicate predicate;
	private Text operationText;
	private Button btnSelectOperation;
	private Button btnEditOperation;
	private Method method;

	private Map<String, GenericEAttrPropsEditor> editors;
	private String operationName;

	public OperationDialog(OperationPredicate predicate, Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.MIN | SWT.MAX | SWT.TITLE);
		this.predicate = predicate;
		operationName = "";
		editors = null;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Edit Operation Predicate : " + predicate.getDisplayName());

		Composite area = new Composite(parent, SWT.None);
		area.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		area.setLayout(new GridLayout(3, false));

		operationText = new Text(area, SWT.BORDER);
		operationText.setEditable(false);
		operationText.setEnabled(false);
		operationText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		btnSelectOperation = new Button(area, SWT.NONE);
		btnSelectOperation.setText("...");
		btnSelectOperation.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				SelectOperationDialog dialog = new SelectOperationDialog(
						Display.getDefault().getActiveShell());
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

					if (method.getParameterTypes().length > 1) {
						btnEditOperation.setEnabled(true);
					} else {
						btnEditOperation.setEnabled(false);
					}

					operationName = op.getMethod().getName();

					validateInput();
				}
			}
		});

		btnEditOperation = new Button(area, SWT.NONE);
		btnEditOperation.setText("Edit");
		btnEditOperation.setEnabled(false);
		new Label(area, SWT.NONE);
		new Label(area, SWT.NONE);
		new Label(area, SWT.NONE);

		btnEditOperation.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				OperationAttributesEditor dialog = new OperationAttributesEditor(
						Display.getDefault().getActiveShell(), method);
				int result = dialog.open();
				if (result == Window.OK) {
					editors = dialog.getEditors();
				}
				validateInput();
			}
		});

		validateInput();

		return area;
	}

	@Override
	public IValidator getInputValidator() {
		return new IValidator() {
			@Override
			public String isValid() {
				if (operationName == null) {
					return "An operation must be selected";
				}
				return null;
			}
		};
	}

	public Map<String, GenericEAttrPropsEditor> getEditors() {
		return editors;
	}

	public String getOperationName() {
		return operationName;
	}
}
