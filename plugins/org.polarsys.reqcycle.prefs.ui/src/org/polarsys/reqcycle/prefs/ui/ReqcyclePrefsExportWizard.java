package org.polarsys.reqcycle.prefs.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
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
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

public class ReqcyclePrefsExportWizard extends Wizard implements IExportWizard {

	protected IPath outputPath;
	
	protected boolean includeReqSources = false;

	@Override
	public void addPages() {
		addPage(new WizardPage("Export ReqCycle preferences") {

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
				topGroup.setText("Export Information");

				Label lblDestination = new Label(topGroup, SWT.NONE);
				lblDestination.setText("Destination :");

				final Text textOutput = new Text(topGroup, SWT.BORDER);
				textOutput.setEnabled(false);
				textOutput.setEditable(false);
				textOutput.setTouchEnabled(true);
				textOutput.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
				if (outputPath != null) {
					textOutput.setText(outputPath.toString());
				}

				Button btnSaveAs = new Button(topGroup, SWT.NONE);
				btnSaveAs.setText("Save As");

				btnSaveAs.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						ContainerSelectionDialog d = new ContainerSelectionDialog(getShell(), null, true, "Export preferences to folder :");
						if (d.open() == ContainerSelectionDialog.OK) {
							Object[] paths = d.getResult();
							if (paths.length > 0) {
								outputPath = (IPath) paths[0];
								textOutput.setText(outputPath.toString());
								
								setPageComplete(true);
							}
						}
					}
				});
				
				final Button reqSourcesButton = new Button(topGroup, SWT.CHECK);
				reqSourcesButton.setText("Export requirement sources");
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

		IResource outputFolder = ResourcesPlugin.getWorkspace().getRoot().findMember(outputPath);
		if (outputFolder instanceof IContainer) {
			try {
				IFile outputZip = ((IContainer)outputFolder).getFile(new Path("reqcycle-conf.zip"));
				if (outputZip.exists()) {
					outputZip.delete(true, null);
				}

				FileOutputStream out = new FileOutputStream(outputZip.getLocation().toOSString());
				ZipOutputStream zos = new ZipOutputStream(out);
				for (File f : prefsFolder.listFiles()) {
					if (!includeReqSources && f.getName().startsWith("org.polarsys.reqcycle.repositories")) {
						continue;
					}
					if (f.isFile()) {
						zos.putNextEntry(new ZipEntry(f.getName()));
						InputStream is = new FileInputStream(f);
						IOUtils.copy(is, zos);
						is.close();
						zos.closeEntry();
					}
				}
				zos.close();
				
				outputFolder.refreshLocal(IResource.DEPTH_ONE, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return true;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		if (selection.getFirstElement() instanceof IContainer) {
			outputPath = ((IContainer)selection.getFirstElement()).getFullPath();
		}
	}

}
