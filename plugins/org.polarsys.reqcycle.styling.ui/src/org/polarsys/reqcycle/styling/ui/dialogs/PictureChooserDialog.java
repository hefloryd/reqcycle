package org.polarsys.reqcycle.styling.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.polarsys.reqcycle.styling.ui.dialogs.IconRegistry.Descriptor;

public class PictureChooserDialog extends TitleAreaDialog {

	protected String imageSelected;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public PictureChooserDialog(Shell parentShell, String selected) {
		super(parentShell);
		imageSelected = selected;
	}

	@Override
	public boolean close() {
		// TODO Auto-generated method stub
		return super.close();
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage("Icon Selection");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite composite = new Composite(scrolledComposite, SWT.NONE);
		composite.setLayout(new GridLayout(9, true));
		
		for (Descriptor i : IconRegistry.getRegisteredImages()){
			Button btnCheckButton = new Button(composite, SWT.RADIO);
			btnCheckButton.setImage(IconRegistry.getImage(i.id));
			btnCheckButton.setData(i);
			if(imageSelected.equals(i.id)) {
				btnCheckButton.setSelection(true);
			}
			
			btnCheckButton.addSelectionListener(new SelectionAdapter(){
				@Override
				public void widgetSelected(SelectionEvent e) {
					Object source = e.getSource();
					if (source instanceof Button) {
						Button btn = (Button) source;
						Object data = btn.getData();
						if (data instanceof Descriptor) {
							Descriptor desc = (Descriptor) data;
							imageSelected = desc.id ;
						}
					}
				}
			});
		}
		
		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		return area;
	}

	/**
	 * Create contents of the button bar.
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
		return new Point(450, 300);
	}
}
