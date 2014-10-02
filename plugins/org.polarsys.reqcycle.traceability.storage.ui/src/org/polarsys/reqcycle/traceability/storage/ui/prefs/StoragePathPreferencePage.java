package org.polarsys.reqcycle.traceability.storage.ui.prefs;

import java.util.Iterator;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.polarsys.reqcycle.traceability.storage.IStoragePathProvider;
import org.polarsys.reqcycle.traceability.storage.vars.VarManager;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class StoragePathPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {
	public StoragePathPreferencePage() {
	}
	
	private Text txttraceability;

	IStoragePathProvider provider = ZigguratInject.make(IStoragePathProvider.class);

	private VarManager varManager = new VarManager();

	@Override
	public void init(IWorkbench workbench) {

	}

	@Override
	protected Control createContents(Composite parent) {
		parent.setLayout(new GridLayout());
		Composite top = new Composite (parent, SWT.None);
		top.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		top.setLayout(new GridLayout(4, false));
		
		Label lblPath = new Label(top, SWT.NONE);
		lblPath.setText("path : ");
		
		txttraceability = new Text(top, SWT.BORDER);
		txttraceability.setText(varManager.getPreferencePattern());
		txttraceability.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		
		final ListViewer listViewer = new ListViewer(top, SWT.BORDER | SWT.V_SCROLL);
		List list = listViewer.getList();
		listViewer.setContentProvider(ArrayContentProvider.getInstance());
		listViewer.setLabelProvider(new LabelProvider());
		
		listViewer.setInput(varManager.getAllPatterns());
		listViewer.addDoubleClickListener(new IDoubleClickListener() {
			
			@Override
			public void doubleClick(DoubleClickEvent event) {
				insert(listViewer);
			}
		});
		GridData gd_list = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		gd_list.widthHint = 234;
		list.setLayoutData(gd_list);
		
		Composite composite = new Composite(top, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 2, 1));
		composite.setLayout(new GridLayout(1, false));
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				insert(listViewer);
			}
		});
		
		btnNewButton.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		btnNewButton.setText("Insert");
		return parent;
	}
	
	@Override
	public boolean isValid() {
		return txttraceability.getText().length() > 0;
	}
	
	@Override
	public boolean performOk() {
		varManager.setPreferencePattern(txttraceability.getText());
		return super.performOk();
	}

	private void insert(final ListViewer listViewer) {
		ISelection selection = listViewer.getSelection();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structured = (IStructuredSelection) selection;
			Iterator it = structured.iterator();
			while (it.hasNext()){
				Object o = it.next();
				if (o instanceof String) {
					String string = (String) o;
					int caret = txttraceability.getCaretPosition();
					String value = txttraceability.getText();
					String end = value.substring(caret,value.length());
					String start = value.substring(0, caret);
					value = start + string + end; 
					txttraceability.setText(value);
				}
			}
		}
	}

}
