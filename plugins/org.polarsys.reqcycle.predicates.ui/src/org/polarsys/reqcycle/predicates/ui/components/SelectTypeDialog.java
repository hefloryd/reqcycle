package org.polarsys.reqcycle.predicates.ui.components;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.polarsys.reqcycle.predicates.core.util.PredicatesAdapterFactory;
import org.polarsys.reqcycle.ui.eattrpropseditor.GenericEAttrPropsEditor;

public class SelectTypeDialog extends TitleAreaDialog {

	private ListViewer listViewer;
	private Object type;
	private GenericEAttrPropsEditor attributeEditor;
	private Boolean isStrictTypeOf;

	/**
	 * The collection of EClass of the model to which we are going to apply the predicate.
	 */
	private final Collection<EClass> eClassesOfModelToEdit;

	public SelectTypeDialog(final Shell parentShell, final Collection<EClass> eClassesOfModelToEdit) {
		super(parentShell);
		this.eClassesOfModelToEdit = eClassesOfModelToEdit;
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		final Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(1, false));

		listViewer = new ListViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		List list = listViewer.getList();
		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		initProviders(listViewer);

		listViewer.setInput(this.eClassesOfModelToEdit.toArray());

		attributeEditor = new GenericEAttrPropsEditor(container, SWT.NONE);
		attributeEditor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Collection<Object> possibleValues = Collections.emptyList();
		attributeEditor.init("Is strict type of : ", Boolean.class, possibleValues);

		return container;
	}

	private void initProviders(ListViewer list) {
		AdapterFactory adapterfactory = new PredicatesAdapterFactory();
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterfactory) {
			@Override
			public String getText(Object object) {
				if (object instanceof EClass) {
					return ((EClass) object).getName();
				}
				return super.getText(object);
			}
		};

		ArrayContentProvider contentProvider = ArrayContentProvider.getInstance();

		list.setLabelProvider(labelProvider);
		list.setContentProvider(contentProvider);
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == IDialogConstants.OK_ID) {
			if (!attributeEditor.isEditionValid()) {
				MessageDialog.openError(getShell(), "Error", "Is strict type of must be selected");
				return;
			}
			if (listViewer.getSelection().isEmpty()) {
				MessageDialog.openError(getShell(), "Error", "A type must be selected");
				return;
			}
			IStructuredSelection selection = (IStructuredSelection) listViewer.getSelection();
			type = selection.getFirstElement();
			isStrictTypeOf = (Boolean) attributeEditor.getEnteredValue();
		}
		super.buttonPressed(buttonId);
	}

	public Object getResult() {
		return type;
	}

	public Boolean getIsStrictTypeOf() {
		return isStrictTypeOf;
	}
}
