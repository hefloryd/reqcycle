/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.styling.ui.dialogs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.polarsys.reqcycle.core.ui.dialogs.ValidatingTitleAreaDialog;
import org.polarsys.reqcycle.styling.manager.IStylingManager;
import org.polarsys.reqcycle.styling.model.Styling.StylingModel;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class StyleModelNameDialog extends ValidatingTitleAreaDialog {

	IStylingManager styleManager = ZigguratInject.make(IStylingManager.class);

	private Text text;
	private String styleName;

	public StyleModelNameDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.CLOSE | SWT.MIN | SWT.TITLE | SWT.PRIMARY_MODAL);

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
		setTitle("Style model name");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		text = new Text(container, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 2));
		text.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				validateInput();
			}
		});
		return area;
	}

	@Override
	protected void okPressed() {
		styleName = text.getText();
		super.okPressed();
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
				if (name.equals(s.getModeName())) {
					alreadyUsed = true;
					break;
				}
			}
		}
		return alreadyUsed;
	}

	public String getStyleModelName() {
		return styleName;
	}

	@Override
	public IValidator getInputValidator() {
		return new IValidator() {
			@Override
			public String isValid() {
				String newText = text.getText();
				if (newText == null || newText.isEmpty()) {
					return "Enter the name of the new styling model";
				} else if (isNameAlreadyUsed(newText)) {
					return "This styling model's name is already used.";
				}
				return null;
			}

		};
	}
}
