package org.polarsys.reqcycle.core.ui.dialogs;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public abstract class ValidatingTitleAreaDialog extends TitleAreaDialog {
	public ValidatingTitleAreaDialog(Shell parentShell) {
		super(parentShell);
	}

	public abstract IValidator getInputValidator();

	@Override
	protected Control createContents(Composite parent) {
		Control result = super.createContents(parent);

		return result;
	}

	protected void validateInput() {
		String errorMessage = null;
		IValidator validator = getInputValidator();
		if (validator != null) {
			errorMessage = validator.isValid();
		}
		setErrorMessage(errorMessage);
		Button okButton = getButton(OK);
		if (okButton != null) {
			okButton.setEnabled(errorMessage == null);
		}
	}

	public static interface IValidator {
		String isValid();
	}

}
