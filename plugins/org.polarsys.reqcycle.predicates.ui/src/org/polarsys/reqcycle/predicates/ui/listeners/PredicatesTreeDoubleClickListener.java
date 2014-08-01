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
package org.polarsys.reqcycle.predicates.ui.listeners;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.polarsys.reqcycle.predicates.core.PredicatesFactory;
import org.polarsys.reqcycle.predicates.core.api.BooleanEqualPredicate;
import org.polarsys.reqcycle.predicates.core.api.BooleanParameter;
import org.polarsys.reqcycle.predicates.core.api.CompareNumberPredicate;
import org.polarsys.reqcycle.predicates.core.api.CompositePredicate;
import org.polarsys.reqcycle.predicates.core.api.ContainsPatternPredicate;
import org.polarsys.reqcycle.predicates.core.api.DateEqualPredicate;
import org.polarsys.reqcycle.predicates.core.api.EObjectParameter;
import org.polarsys.reqcycle.predicates.core.api.EnumEqualPredicate;
import org.polarsys.reqcycle.predicates.core.api.EnumIntoPredicate;
import org.polarsys.reqcycle.predicates.core.api.EqualPredicate;
import org.polarsys.reqcycle.predicates.core.api.IEAttrPredicate;
import org.polarsys.reqcycle.predicates.core.api.IPredicate;
import org.polarsys.reqcycle.predicates.core.api.ITypedPredicate;
import org.polarsys.reqcycle.predicates.core.api.IntParameter;
import org.polarsys.reqcycle.predicates.core.api.IntoPredicate;
import org.polarsys.reqcycle.predicates.core.api.IsTypeOfPredicate;
import org.polarsys.reqcycle.predicates.core.api.OperationPredicate;
import org.polarsys.reqcycle.predicates.core.api.StringEqualPredicate;
import org.polarsys.reqcycle.predicates.core.api.StringIntoPredicate;
import org.polarsys.reqcycle.predicates.core.api.StringParameter;
import org.polarsys.reqcycle.predicates.persistance.util.IPredicatesConfManager;
import org.polarsys.reqcycle.predicates.ui.components.SelectTypeDialog;
import org.polarsys.reqcycle.predicates.ui.dialogs.IEAttrPredicatesNodeEditorDialog;
import org.polarsys.reqcycle.predicates.ui.dialogs.OperationDialog;
import org.polarsys.reqcycle.predicates.ui.dialogs.PredicateValueEditor;
import org.polarsys.reqcycle.predicates.ui.presentation.PredicatesEditor;
import org.polarsys.reqcycle.ui.eattrpropseditor.GenericEAttrPropsEditor;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class PredicatesTreeDoubleClickListener implements IDoubleClickListener {

	private final PredicatesEditor editor;

	private Collection<EClass> eClasses;

	private boolean useExtendedFeature;

	IPredicatesConfManager manager = ZigguratInject
			.make(IPredicatesConfManager.class);

	/**
	 * @param editor
	 *            - The PredicatesEditor. Must not be <tt>null</tt>.
	 * @param eClassesOfModelToEdit
	 *            - The collection of EClass.
	 * @param useExtendedFeature
	 */
	public PredicatesTreeDoubleClickListener(final PredicatesEditor editor,
			final Collection<EClass> eClassesOfModelToEdit,
			final boolean useExtendedFeature) {
		this.editor = editor;
		this.eClasses = eClassesOfModelToEdit;
		this.useExtendedFeature = useExtendedFeature;
	}

	@Override
	public void doubleClick(DoubleClickEvent event) {
		final Shell parent = event.getViewer().getControl().getShell();
		final IStructuredSelection selection = (IStructuredSelection) event
				.getSelection();
		if (selection.getFirstElement() instanceof CompositePredicate) {
			MessageDialog.openInformation(parent, "Info",
					"Unable to edit a Composite Predicate.");
			return; // quit
		}

		if (selection.getFirstElement() instanceof OperationPredicate) {
			OperationPredicate predicate = ((OperationPredicate) selection
					.getFirstElement());
			OperationDialog dialog = new OperationDialog(predicate, Display
					.getDefault().getActiveShell());
			int result = dialog.open();
			if (result == Window.OK) {
				predicate.setOperationName(dialog.getOperationName());
				predicate.getParameters().clear();

				for (Map.Entry<String, GenericEAttrPropsEditor> entry : dialog
						.getEditors().entrySet()) {
					GenericEAttrPropsEditor editor = entry.getValue();

					Object obj = editor.getEnteredValue();

					if (obj instanceof String) {
						StringParameter param = PredicatesFactory.eINSTANCE
								.createStringParameter();
						param.setName(entry.getKey());
						param.setValue((String) obj);
						predicate.getParameters().add(param);
					} else if (obj instanceof Integer) {
						IntParameter param = PredicatesFactory.eINSTANCE
								.createIntParameter();
						param.setName(entry.getKey());
						param.setValue((Integer) obj);
						predicate.getParameters().add(param);
					} else if (obj instanceof Boolean) {
						BooleanParameter param = PredicatesFactory.eINSTANCE
								.createBooleanParameter();
						param.setName(entry.getKey());
						param.setValue((Boolean) obj);
						predicate.getParameters().add(param);
					} else if (obj instanceof EObject) {
						EObjectParameter param = PredicatesFactory.eINSTANCE
								.createEObjectParameter();
						param.setName(entry.getKey());
						param.setValue((EObject) obj);
						predicate.getParameters().add(param);
					}
				}
			}
			return; // quit
		}

		if (selection.getFirstElement() instanceof EqualPredicate) {
			@SuppressWarnings("unchecked")
			EqualPredicate<Object> predicate = (EqualPredicate<Object>) selection
					.getFirstElement();
			PredicateValueEditor dialog = null;
			if (selection.getFirstElement() instanceof StringEqualPredicate) {
				dialog = new PredicateValueEditor(parent, predicate,
						String.class, false);
			} else if (selection.getFirstElement() instanceof BooleanEqualPredicate) {
				dialog = new PredicateValueEditor(parent, predicate,
						Boolean.class, false);
			} else if (selection.getFirstElement() instanceof EnumEqualPredicate) {
				dialog = new PredicateValueEditor(parent, predicate,
						Enum.class, false);
			} else if (selection.getFirstElement() instanceof DateEqualPredicate) {
				dialog = new PredicateValueEditor(parent, predicate,
						Date.class, false);
			}
			if ((dialog != null) && (dialog.open() == Window.OK)) {
				predicate.setExpectedObject(dialog.getEditor()
						.getEnteredValue());
			}

			return; // quit
		}

		if (selection.getFirstElement() instanceof IntoPredicate) {
			PredicateValueEditor dialog = null;
			if (selection.getFirstElement() instanceof StringIntoPredicate) {
				dialog = new PredicateValueEditor(parent,
						(IPredicate) selection.getFirstElement(), String.class,
						false);
			} else if (selection.getFirstElement() instanceof EnumIntoPredicate) {
				dialog = new PredicateValueEditor(parent,
						(IPredicate) selection.getFirstElement(), Enum.class,
						false);
			}
			if ((dialog != null) && (dialog.open() == Window.OK)) {
				@SuppressWarnings("unchecked")
				IntoPredicate<Object> predicate = (IntoPredicate<Object>) selection
						.getFirstElement();
				predicate.getAllowedEntries().add(
						dialog.getEditor().getEnteredValue());
			}

			return; // quit
		}

		if (selection.getFirstElement() instanceof ContainsPatternPredicate) {
			final PredicateValueEditor dialog = new PredicateValueEditor(
					parent, (IPredicate) selection.getFirstElement(),
					String.class, false);
			if (dialog.open() == Window.OK) {
				String value = (String) dialog.getEditor().getEnteredValue();
				ContainsPatternPredicate predicate = (ContainsPatternPredicate) selection
						.getFirstElement();
				Pattern pattern = Pattern.compile(value);
				predicate.setExpectedPattern(pattern);
			}

			return; // quit
		}

		if (selection.getFirstElement() instanceof CompareNumberPredicate) {
			final PredicateValueEditor dialog = new PredicateValueEditor(
					parent, (IPredicate) selection.getFirstElement(),
					Number.class, true);
			if (dialog.open() == Window.OK) {
				CompareNumberPredicate predicate = (CompareNumberPredicate) selection
						.getFirstElement();
				predicate.setOperator(dialog.getOperator());
				predicate.setExpectedValue((Number) dialog.getEditor()
						.getEnteredValue());
			}

			return; // quit
		}

		if (this.eClasses == null || this.eClasses.isEmpty()) {
			MessageDialog.openError(parent, "Error",
					"You must load a model to edit.");
			return; // quit
		}

		if (selection.getFirstElement() instanceof IsTypeOfPredicate) {
			final SelectTypeDialog dialog = new SelectTypeDialog(parent,
					this.eClasses);
			if (dialog.open() == Window.OK) {
				Object type = dialog.getResult();
				Boolean isStrict = dialog.getIsStrictTypeOf();
				IsTypeOfPredicate predicate = (IsTypeOfPredicate) selection
						.getFirstElement();
				predicate.setType(type);
				predicate.setIsStrictTypeOf(isStrict);
			}
			return; // quit
		}

		if (selection.getFirstElement() instanceof ITypedPredicate) {
			ITypedPredicate<?> predicate = (ITypedPredicate<?>) selection
					.getFirstElement();
			if (predicate instanceof IEAttrPredicate) {
				final IEAttrPredicatesNodeEditorDialog dialog = new IEAttrPredicatesNodeEditorDialog(
						parent, (IEAttrPredicate) predicate, this.eClasses,
						this.useExtendedFeature);
				if (dialog.open() == Window.OK) {

					if (selection.getFirstElement() instanceof IEAttrPredicate) {

						((IEAttrPredicate) selection.getFirstElement())
								.setTypedElement(dialog.getSelectedEAttribute());

					}
				}
			} else {
				MessageDialog.openError(parent, "Error",
						"Only IEAttrPredicate is currently supported.");
			}
		}
	}

	public void setEClasses(Collection<EClass> eClasses) {
		this.eClasses = eClasses;
	}

	public void setUseExtendedFeature(boolean useExtendedFeature) {
		this.useExtendedFeature = useExtendedFeature;
	}

}
