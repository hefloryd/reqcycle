/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Papa Issa Diakhate (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
package org.polarsys.reqcycle.predicates.ui.dialogs;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.polarsys.reqcycle.predicates.core.api.IEAttrPredicate;

public class IEAttrPredicatesNodeEditorDialog extends Dialog {

	/**
	 * The TreeViewer that will contain the model to edit (the model to which
	 * the predicate is going to be applied).
	 */
	private TreeViewer treeViewer;

	/**
	 * The collection of EClass of the model to which we are going to apply the
	 * predicate.
	 */
	private final Collection<EClass> eClassesOfModelToEdit;

	private final boolean useExtendedFeature;

	/** The predicate to edit. */
	private final IEAttrPredicate eAttrPredicate;

	/** The EAttribute selected */
	private EAttribute selectedEAttribute;

	public IEAttrPredicatesNodeEditorDialog(final Shell parentShell,
			final IEAttrPredicate eAttrPredicate,
			final Collection<EClass> eClassesOfModelToEdit,
			final boolean useExtendedFeature) {
		super(parentShell);
		this.eAttrPredicate = eAttrPredicate;
		this.eClassesOfModelToEdit = eClassesOfModelToEdit;
		this.useExtendedFeature = useExtendedFeature;
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		final Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(1, false));

		this.initTreeViewer(container);

		return container;
	}

	private void initTreeViewer(final Composite container) {
		this.treeViewer = new TreeViewer(container, SWT.BORDER);
		final Tree tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		treeViewer.setContentProvider(new EClassContentProvider());
		treeViewer.setLabelProvider(new EClassLabelProvider());
		treeViewer
				.addSelectionChangedListener(new SelectionChangedListenerImpl());
		treeViewer.setInput(this.eClassesOfModelToEdit);
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	public EAttribute getSelectedEAttribute() {
		return selectedEAttribute;
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == IDialogConstants.OK_ID) {
			if (this.selectedEAttribute == null) {
				MessageDialog.openError(getShell(), "Error",
						"An attribute must be selected");
				return; // do not accept the OK ...
			}
		}
		super.buttonPressed(buttonId);
	}

	private class EClassContentProvider implements ITreeContentProvider {

		public EClassContentProvider() {
		}

		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return ArrayContentProvider.getInstance().getElements(inputElement);
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if (!useExtendedFeature) {
				if (parentElement instanceof EClass) {
					return ((EClass) parentElement).getEAllAttributes()
							.toArray();
				}
			} else {
				if (parentElement instanceof EClass) {
					return ((EClass) parentElement).getEAllStructuralFeatures()
							.toArray();

				} else if (parentElement instanceof EReference) {
					return ((EReference) parentElement).eContents().toArray();
				} else if (parentElement instanceof EGenericType) {
					final EClassifier classifier = ((EGenericType) parentElement)
							.getEClassifier();
					if (classifier != null && (classifier instanceof EClass)) {
						return ((EClass) classifier)
								.getEAllStructuralFeatures().toArray();
					}
				}
			}

			return null;
		}

		@Override
		public Object getParent(Object element) {
			if (element instanceof EClass) {
				return ((EClass) element).eContainer();
			}
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			if (element instanceof EClass) {
				final List<EObject> original = ((EClass) element).eContents();
				final Collection<EObject> copy = EcoreUtil.copyAll(original);
				final Iterator<EObject> iter = copy.iterator();
				while (iter.hasNext()) {
					final EObject eObj = iter.next();
					if (eObj instanceof EOperation)
						iter.remove();
				}
				return copy.size() > 0;

			} else if (useExtendedFeature) {
				return ((element instanceof EReference) || (element instanceof EGenericType));
			}

			return false;
		}
	}

	private class EClassLabelProvider extends LabelProvider {

		@Override
		public String getText(Object element) {
			if (element instanceof ENamedElement) {
				return ((ENamedElement) element).getName();
			} else if (element instanceof EGenericType) {
				return this.getText(((EGenericType) element).getEClassifier());
			}
			return super.getText(element);
		}
	}

	/**
	 * This ISelectionChangedListener shows the correct IEAttrPropsEditor to use
	 * when the current selection is positioned onto an attribute. If the
	 * selection is not an attribute, no properties editor will be shown.
	 * 
	 * @see ModelAttributesViewerFilter
	 */
	private class SelectionChangedListenerImpl implements
			ISelectionChangedListener {

		public SelectionChangedListenerImpl() {
		}

		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			if (event.getSelection() instanceof IStructuredSelection) {

				final IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();
				final Object selectedObject = selection.getFirstElement();

				if (selectedObject instanceof EAttribute) {

					selectedEAttribute = (EAttribute) selectedObject;

					EClassifier eType = selectedEAttribute.getEType();
					Class<?> selectedClass = eType.getInstanceClass();
					if (selectedClass == null && eType instanceof EEnum) {
						selectedClass = Enumerator.class;
					}
					// TODO : [EnumLiteral] Add Literal (String), not the
					// EnumLiteral
				}
			}
		}
	}

}
