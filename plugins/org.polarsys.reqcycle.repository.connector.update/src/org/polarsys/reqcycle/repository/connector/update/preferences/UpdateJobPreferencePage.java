package org.polarsys.reqcycle.repository.connector.update.preferences;

import java.util.regex.Pattern;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

public class UpdateJobPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	public UpdateJobPreferencePage() {
	}
	private DataBindingContext m_bindingContext;
	private Button btnBrowse;
	protected int currentRefresh;
	private Text refreshTime;
	private Text pathForImpactAnalysis;
	private Button btnCheckButton;
	private static Pattern TIME_PATTERN = Pattern.compile("\\d*");
	private Label lblRefreshTimeseconds;

	@Override
	public void init(IWorkbench workbench) {

	}

	@Override
	protected Control createContents(Composite parent) {
		parent.setLayout(new GridLayout());
		Composite top = new Composite (parent, SWT.None);
		top.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		top.setLayout(new GridLayout(1, false));
		
		Group grpReferenceUpdate = new Group(top, SWT.NONE);
		grpReferenceUpdate.setLayout(new GridLayout(3, false));
		grpReferenceUpdate.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		grpReferenceUpdate.setText("Reference Update");
		
		lblRefreshTimeseconds = new Label(grpReferenceUpdate, SWT.NONE);
		lblRefreshTimeseconds.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblRefreshTimeseconds.setText("refresh time (seconds) : ");
		
		refreshTime = new Text(grpReferenceUpdate, SWT.BORDER);
		refreshTime.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				if (refreshTime.getText() == null || refreshTime.getText().isEmpty() || !TIME_PATTERN.matcher(refreshTime.getText()).matches())
				{
					setErrorMessage("please fill a numeric value");
				}
				else {
					setErrorMessage(null);
				}
			}
		});
		refreshTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		final Group grpImpactAnalysis = new Group(top, SWT.NONE);
		grpImpactAnalysis.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpImpactAnalysis.setText("Impact Analysis");
		grpImpactAnalysis.setLayout(new GridLayout(3, false));
		
		btnCheckButton = new Button(grpImpactAnalysis, SWT.CHECK);
		btnCheckButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnCheckButton.setText("save impact analysis model");
		new Label(grpImpactAnalysis, SWT.NONE);
		new Label(grpImpactAnalysis, SWT.NONE);
		btnCheckButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean newValue = btnCheckButton.getSelection() ;
				pathForImpactAnalysis.setEnabled(newValue);
				btnBrowse.setEnabled(newValue);
				if (newValue && (pathForImpactAnalysis.getText()== null || pathForImpactAnalysis.getText().isEmpty())){
					setErrorMessage("please fill a path");
				}
				else {
					if (!newValue){
						setErrorMessage(null);
					}
				}		
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		pathForImpactAnalysis = new Text(grpImpactAnalysis, SWT.BORDER);
		pathForImpactAnalysis.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		pathForImpactAnalysis.setEnabled(btnCheckButton.getSelection());
		pathForImpactAnalysis.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				if (pathForImpactAnalysis.getText()== null || pathForImpactAnalysis.getText().isEmpty()){
					setErrorMessage("please fill a path");
				}
				else {
					setErrorMessage(null);
				}				
			}
		});
		
		btnBrowse = new Button(grpImpactAnalysis, SWT.NONE);
		btnBrowse.setText("...");
		btnBrowse.setLayoutData(new GridData(SWT.CENTER,SWT.CENTER, false, false));
		btnBrowse.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				ContainerSelectionDialog container = new ContainerSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(), true, "Please choose a folder for impact analysis models save");
				if (container.open() == ContainerSelectionDialog.OK){
					pathForImpactAnalysis.setText(container.getResult()[0].toString());
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		btnBrowse.setEnabled(btnCheckButton.getSelection());
		setDefaultValues();
		return parent;
	}

	private void setDefaultValues() {
		if (refreshTime.getText() == null  || refreshTime.getText().isEmpty()){
			refreshTime.setText(String.valueOf(PreferenceController.getRefreshTime()));
		}
		btnCheckButton.setSelection(PreferenceController.isImpactAnalysis());
	}

	@Override
	public boolean performOk() {
		PreferenceController.savePref(PreferenceController.PREF_IS_IMPACT_ANALYSIS, btnCheckButton.getSelection());
		PreferenceController.savePref(PreferenceController.PREF_REFRESH_TIME, Integer.parseInt(refreshTime.getText()));
		PreferenceController.savePref(PreferenceController.PREF_IMPACT_ANALYSIS, pathForImpactAnalysis.getText());
		return super.performOk();
	}
	@Override
	protected void performDefaults() {
		super.performDefaults();
		setDefaultValues();
	}
}
