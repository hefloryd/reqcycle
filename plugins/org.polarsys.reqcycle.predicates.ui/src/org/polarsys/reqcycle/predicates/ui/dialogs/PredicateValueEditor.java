package org.polarsys.reqcycle.predicates.ui.dialogs;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.polarsys.reqcycle.predicates.core.api.ContainsPatternPredicate;
import org.polarsys.reqcycle.predicates.core.api.EqualPredicate;
import org.polarsys.reqcycle.predicates.core.api.IPredicate;
import org.polarsys.reqcycle.predicates.core.api.OPERATOR;
import org.polarsys.reqcycle.ui.eattrpropseditor.GenericEAttrPropsEditor;

public class PredicateValueEditor extends TitleAreaDialog {

	private final IPredicate predicate;
	private GenericEAttrPropsEditor editor;
	@SuppressWarnings("rawtypes")
	private Class predicateClass;
	private boolean comparator;
	private OPERATOR operator;
	private ComboViewer viewer;

	public PredicateValueEditor(final Shell parentShell, final IPredicate predicate, @SuppressWarnings("rawtypes") final Class c, boolean comparator) {
		super(parentShell);
		this.predicate = predicate;
		this.editor = null;
		this.predicateClass = c;
		this.comparator = comparator;
		this.viewer = null;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Edition of predicate : " + predicate.getDisplayName());

		Composite container = new Composite(parent, SWT.None);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		container.setLayout(new GridLayout(2, false));

		Collection<Object> possibleValues = Collections.emptyList();
		addEditor(this.predicateClass, "Value : ", container, possibleValues);

		if (comparator) {
			Label label = new Label(container, SWT.NONE);
			label.setText("Comparison operator :");

			viewer = new ComboViewer(container);
			viewer.add(OPERATOR.values());
			viewer.setSelection(new StructuredSelection(OPERATOR.values()[0]));
			viewer.addSelectionChangedListener(new ISelectionChangedListener() {
				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					IStructuredSelection selection = (IStructuredSelection) event.getSelection();
					if (selection.getFirstElement() instanceof OPERATOR) {
						operator = (OPERATOR) (selection.getFirstElement());
					}
				}
			});
		}

		return container;
	}

	public void addEditor(Class<?> c, String attName, Composite composite, Collection<Object> possibleValues) {
		this.editor = new GenericEAttrPropsEditor(composite, SWT.NONE);
		this.editor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		this.editor.init(attName, c, possibleValues);

		if (predicate instanceof EqualPredicate) {
			EqualPredicate<?> equalPredicate = (EqualPredicate<?>) predicate;
			if (equalPredicate.getExpectedObject() != null)
				this.editor.setInitialValue(equalPredicate.getExpectedObject());
		} else if (predicate instanceof ContainsPatternPredicate) {
			ContainsPatternPredicate containsPredicate = (ContainsPatternPredicate) predicate;
			if (containsPredicate.getExpectedPattern() != null) {
				this.editor.setInitialValue(containsPredicate.getExpectedPattern());
			}
		}
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == IDialogConstants.OK_ID) {
			if (!editor.isEditionValid()) {
				MessageDialog.openError(getShell(), "Error", "Some values are not entered or not valid");
				return;
			}
		}
		super.buttonPressed(buttonId);
	}

	public GenericEAttrPropsEditor getEditor() {
		return editor;
	}

	public OPERATOR getOperator() {
		return operator;
	}
}
