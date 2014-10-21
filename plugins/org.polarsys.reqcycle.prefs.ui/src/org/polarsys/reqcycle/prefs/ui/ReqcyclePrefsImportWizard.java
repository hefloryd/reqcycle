package org.polarsys.reqcycle.prefs.ui;

import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.IOUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.polarsys.reqcycle.utils.configuration.IConfigurationManager;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class ReqcyclePrefsImportWizard extends Wizard implements IImportWizard {

	protected IConfigurationManager confManager = ZigguratInject.make(IConfigurationManager.class);

	protected IPath inputPath;

	protected boolean includeReqSources = false;

	@Override
	public void addPages() {
		addPage(new WizardPage("Import ReqCycle preferences") {

			@Override
			public void createControl(Composite parent) {
				setPageComplete(false);				
				
				Composite mainComposite = new Composite(parent, SWT.NONE);
				mainComposite.setLayout(new FillLayout(SWT.HORIZONTAL));

				Composite topComposite = new Composite(mainComposite, SWT.NONE);
				topComposite.setLayout(new GridLayout(1, false));

				org.eclipse.swt.widgets.Group topGroup = new org.eclipse.swt.widgets.Group(topComposite, SWT.NONE);
				topGroup.setLayout(new GridLayout(3, false));
				topGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
				topGroup.setText("Import Information");

				Label lblDestination = new Label(topGroup, SWT.NONE);
				lblDestination.setText("Zip Conf File :");

				final Text textInput = new Text(topGroup, SWT.BORDER);
				textInput.setEnabled(false);
				textInput.setEditable(false);
				textInput.setTouchEnabled(true);
				textInput.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
				if (inputPath != null) {
					textInput.setText(inputPath.toString());
				}

				Button btnBrowse = new Button(topGroup, SWT.NONE);
				btnBrowse.setText("Browse");

				btnBrowse.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						ResourceSelectionDialog d = new ResourceSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(), "zip selection");
						int open = d.open();
						if (open == ResourceSelectionDialog.OK && d.getResult() != null && d.getResult().length > 0) {
							inputPath = ((IFile) d.getResult()[0]).getFullPath();
							textInput.setText(inputPath.toString());
							
							setPageComplete(true);
						}
					}
				});
				final Button reqSourcesButton = new Button(topGroup, SWT.CHECK);
				reqSourcesButton.setText("Import requirement sources");
				reqSourcesButton.setSelection(includeReqSources);
				reqSourcesButton.addSelectionListener(new SelectionAdapter() {

					@Override
					public void widgetSelected(SelectionEvent e) {
						includeReqSources = reqSourcesButton.getSelection();
					}
				});

				setControl(mainComposite);
			}
		});
	}

	@Override
	public boolean performFinish() {
		IPath prefsFolderPath = org.polarsys.reqcycle.utils.configuration.Activator.getDefault().getStateLocation();
		File prefsFolder = new File(prefsFolderPath.toOSString());

		IFile inputFile = ResourcesPlugin.getWorkspace().getRoot().getFile(inputPath);
		if (inputFile != null) {
			confManager.unload();
			for (File f : prefsFolder.listFiles()) {
				f.delete();
			}

			try {
				ZipInputStream zipStream = new ZipInputStream(inputFile.getContents());
				ZipEntry next = zipStream.getNextEntry();
				while (next != null) {
					if (includeReqSources || !next.getName().startsWith("org.polarsys.reqcycle.repositories")) {
						File f = new File(prefsFolder, next.getName());
						FileOutputStream os = new FileOutputStream(f);
						IOUtils.copy(zipStream, os);
						os.close();
					}
					next = zipStream.getNextEntry();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			boolean res = MessageDialog.openQuestion(getShell(), "Restart needed", "A restart of Eclipse is needed to validate the imported ReqCycle configuration. Do you want to restart now ?");
			if (res) {
				PlatformUI.getWorkbench().restart();
			}
		}

		return true;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		if (selection.getFirstElement() instanceof IFile) {
			inputPath = ((IFile)selection.getFirstElement()).getFullPath();
		}
	}

}
