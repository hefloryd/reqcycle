package org.polarsys.kitalpha.doc.doc2model.ui.views;

import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

public class InputFileDialog extends ResourceDialog {

	public InputFileDialog(Shell parent, String title, int style) {
		super(parent, title, SWT.OPEN | style);
	}
}
