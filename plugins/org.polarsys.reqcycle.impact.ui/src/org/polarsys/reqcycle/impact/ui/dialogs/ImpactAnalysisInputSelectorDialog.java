package org.polarsys.reqcycle.impact.ui.dialogs;

import javax.inject.Inject;

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
import org.polarsys.reqcycle.core.ui.dialogs.ValidatingTitleAreaDialog;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class ImpactAnalysisInputSelectorDialog extends
		ValidatingTitleAreaDialog {

	@Inject
	IDataModelManager dataModelManager;

	private RequirementSource requirementSource;
	private RequirementSource requirementSourceFrom;
	private RequirementSource requirementSourceTo;
	private String initialVersion;
	private String finalVersion;

	private Label lblModelSelected;
	private Label lblVersionSelectedFrom;
	private Label lblVersionSelectedTo;
	private Button btnVersionFromButton;
	private Button btnVersionToButton;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public ImpactAnalysisInputSelectorDialog(Shell parentShell,
			RequirementSource requirementSource) {
		super(parentShell);
		setShellStyle(SWT.CLOSE | SWT.MIN | SWT.MAX);
		ZigguratInject.inject(this);
		this.requirementSource = requirementSource;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Select inputs for impact analysis");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(3, false));
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				1));

		Label lblModel = new Label(container, SWT.NONE);
		lblModel.setText("Select model for impact analysis :");

		lblModelSelected = new Label(container, SWT.BORDER);
		lblModelSelected.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false, 1, 1));
		lblModelSelected.setEnabled(false);

		Button btnModelButton = new Button(container, SWT.NONE);
		btnModelButton.setToolTipText("Select model");
		btnModelButton.setText("...");
		btnModelButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				SelectModelDialog dialog = new SelectModelDialog(Display
						.getDefault().getActiveShell());
				if (dialog.open() == Window.OK) {

					requirementSource = dialog.getRequirementSource();
					lblModelSelected.setText(requirementSource.getName());

					btnVersionFromButton.setEnabled(true);
					btnVersionToButton.setEnabled(true);

					if (requirementSourceFrom != null) {
						requirementSourceFrom = null;
						lblVersionSelectedFrom.setText("");
					}
					if (requirementSourceTo != null) {
						requirementSourceTo = null;
						lblVersionSelectedTo.setText("");
					}

					validateInput();
				}
			}
		});

		Label lblVersionFrom = new Label(container, SWT.NONE);
		lblVersionFrom.setText("Select initial version :");

		lblVersionSelectedFrom = new Label(container, SWT.BORDER);
		lblVersionSelectedFrom.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
				true, false, 1, 1));
		lblVersionSelectedFrom.setEnabled(false);

		btnVersionFromButton = new Button(container, SWT.NONE);
		btnVersionFromButton.setToolTipText("Select initial version");
		btnVersionFromButton.setText("...");
		btnVersionFromButton.setEnabled(false);
		btnVersionFromButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (requirementSource != null) {
					SelectVersionDialog dialog = new SelectVersionDialog(
							Display.getDefault().getActiveShell(),
							requirementSource);
					if (dialog.open() == Window.OK) {
						requirementSourceFrom = dialog.getRequirementSource();
						initialVersion = dialog.getRSVersion();
						lblVersionSelectedFrom.setText(initialVersion);

						validateInput();
					}
				}
			}
		});

		Label lblVersionTo = new Label(container, SWT.NONE);
		lblVersionTo.setText("Select final version :");

		lblVersionSelectedTo = new Label(container, SWT.BORDER);
		lblVersionSelectedTo.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
				true, false, 1, 1));
		lblVersionSelectedTo.setEnabled(false);

		btnVersionToButton = new Button(container, SWT.NONE);
		btnVersionToButton.setToolTipText("Select final version");
		btnVersionToButton.setText("...");
		btnVersionToButton.setEnabled(false);
		btnVersionToButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (requirementSource != null) {
					SelectVersionDialog dialog = new SelectVersionDialog(
							Display.getDefault().getActiveShell(),
							requirementSource);
					if (dialog.open() == Window.OK) {
						requirementSourceTo = dialog.getRequirementSource();
						finalVersion = dialog.getRSVersion();
						lblVersionSelectedTo.setText(finalVersion);

						validateInput();
					}
				}
			}
		});

		if (this.requirementSource != null) {
			lblModelSelected.setText(this.requirementSource.getName());

			btnVersionFromButton.setEnabled(true);
			btnVersionToButton.setEnabled(true);
		}
		validateInput();

		return area;
	}

	@Override
	public IValidator getInputValidator() {
		return new IValidator() {
			@Override
			public String isValid() {
				if (requirementSource == null) {
					return "A Data Source must be selected";
				}
				if (requirementSourceFrom == null) {
					return "An initial version must be selected";
				}
				if (requirementSourceTo == null) {
					return "An final version must be selected";
				}
				return null;
			}
		};
	}

	public RequirementSource getRequirementSource() {
		return requirementSource;

	}

	public RequirementSource getRequirementSourceFrom() {
		return requirementSourceFrom;
	}

	public RequirementSource getRequirementSourceTo() {
		return requirementSourceTo;
	}

	public String getInitialVersion() {
		return initialVersion;
	}

	public String getFinalVersion() {
		return finalVersion;
	}
}
