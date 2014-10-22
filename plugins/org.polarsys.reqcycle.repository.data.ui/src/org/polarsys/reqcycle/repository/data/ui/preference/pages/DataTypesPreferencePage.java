/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Anass Radouani (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
package org.polarsys.reqcycle.repository.data.ui.preference.pages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.polarsys.reqcycle.repository.data.types.IAttribute;
import org.polarsys.reqcycle.repository.data.types.IDataModel;
import org.polarsys.reqcycle.repository.data.types.IEnumerationType;
import org.polarsys.reqcycle.repository.data.types.IEnumerator;
import org.polarsys.reqcycle.repository.data.types.IRequirementType;
import org.polarsys.reqcycle.repository.data.types.IType;
import org.polarsys.reqcycle.repository.data.types.internal.ETypeImpl;
import org.polarsys.reqcycle.repository.data.ui.Activator;
import org.polarsys.reqcycle.repository.data.ui.dialog.AddAttributeDialog;
import org.polarsys.reqcycle.repository.data.ui.dialog.AddTypeDialog;
import org.polarsys.reqcycle.repository.data.ui.dialog.NameDialog;
import org.polarsys.reqcycle.repository.data.ui.preference.PreferenceUiUtil;

public class DataTypesPreferencePage extends DataModelsPreferencePage {

	/** Types Viewer Elements */
	protected TableViewer tvTypes;

	protected Table tTypes;

	protected TableViewerColumn tvcTypesNames;

	protected TableViewerColumn tvcTypesTypes;

	/** Attributes Viewer Elements */
	protected TableViewer tvAttributes;

	protected Table tAttributes;

	protected TableViewerColumn tvcAttributesNames;

	protected TableViewerColumn tvcAttributesTypes;

	/** Add Buttons */
	protected Button btnAddType;

	protected Button btnAddAttribute;

	/** Edit Buttons */
	protected Button btnEditAttribute;

	protected Button btnEditType;

	/** Viewers Inputs */
	protected Collection<Object> inputTypes = new ArrayList<Object>();

	protected Collection<Object> inputAttributes = new ArrayList<Object>();

	/** Viewers Selected Items */
	protected IDataModel selectedModel;

	protected IType selectedType;

	protected IAttribute selectedAttribute;

	private Button btnDeleteAttribute;

	private Button btnDeleteType;

	private Boolean dirty = false;

	public DataTypesPreferencePage() {
	}

	@Override
	public void handleEvent(Event event) {
		super.handleEvent(event);

		inputTypes.clear();
		if (tvTypes != null) {
			tvTypes.refresh();
		}

		inputAttributes.clear();
		if (tvAttributes != null) {
			tvAttributes.refresh();
		}
	}

	@Override
	public void doCreateContents(Composite control) {
		// Data Type group
		Group typeGrp = PreferenceUiUtil.createGroup(control, "Data Types");
		createTypesUi(typeGrp);

		// Attribute group
		Group attributesGrp = PreferenceUiUtil.createGroup(control, "Attributes");
		createAttribuesUi(attributesGrp);
	}

	/**
	 * Create Attributes Ui Elements
	 * 
	 * @param parent
	 *            Composite parent
	 */
	protected void createAttribuesUi(Composite parent) {
		// Table Viewer
		Composite viewerComposite = new Composite(parent, SWT.NONE);
		viewerComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		TableColumnLayout attributeTVLayout = new TableColumnLayout();
		viewerComposite.setLayout(attributeTVLayout);

		tvAttributes = new TableViewer(viewerComposite);
		tvAttributes.setContentProvider(ArrayContentProvider.getInstance());
		tAttributes = tvAttributes.getTable();
		tAttributes.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tAttributes.setHeaderVisible(true);
		tAttributes.setLinesVisible(true);

		// Columns
		tvcAttributesNames = PreferenceUiUtil.createTableViewerColumn(tvAttributes, "Name", SWT.None);
		tvcAttributesNames.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof IAttribute) {
					return ((IAttribute) element).getName();
				} else if (element instanceof IEnumerator) {
					return ((IEnumerator) element).getName();
				}
				return super.getText(element);
			}
		});
		attributeTVLayout.setColumnData(tvcAttributesNames.getColumn(), new ColumnWeightData(20, 100, true));

		tvcAttributesTypes = PreferenceUiUtil.createTableViewerColumn(tvAttributes, "Type", SWT.None);
		tvcAttributesTypes.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof IAttribute) {
					return ((IAttribute) element).getType().getName();
				}
				return "";
			}
		});
		attributeTVLayout.setColumnData(tvcAttributesTypes.getColumn(), new ColumnWeightData(20, 100, true));

		tvAttributes.setInput(inputAttributes);

		Composite btnComposite = new Composite(parent, SWT.None);
		btnComposite.setLayout(new GridLayout());
		btnComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));

		btnAddAttribute = PreferenceUiUtil.createButton(btnComposite, "Add Attribute", Activator.getImageDescriptor("/icons/add.gif").createImage());
		btnAddAttribute.setEnabled(false);

		btnEditAttribute = PreferenceUiUtil.createButton(btnComposite, "Edit Attribute", Activator.getImageDescriptor("/icons/edit.png").createImage());
		btnEditAttribute.setEnabled(false);

		btnDeleteAttribute = PreferenceUiUtil.createButton(btnComposite, "Delete Attribute", Activator.getImageDescriptor("/icons/delete.gif").createImage());
		btnDeleteAttribute.setEnabled(false);
	}

	/**
	 * Create Types Attributes
	 * 
	 * @param parent
	 *            Composite parent
	 */
	protected void createTypesUi(Composite parent) {
		// Table viewer
		Composite viewerComposite = new Composite(parent, SWT.NONE);
		viewerComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		TableColumnLayout typesTVLayout = new TableColumnLayout();
		viewerComposite.setLayout(typesTVLayout);

		tvTypes = new TableViewer(viewerComposite, SWT.BORDER);
		tvTypes.setContentProvider(ArrayContentProvider.getInstance());

		tTypes = tvTypes.getTable();
		tTypes.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tTypes.setHeaderVisible(true);
		tTypes.setLinesVisible(true);

		// Columns
		tvcTypesNames = PreferenceUiUtil.createTableViewerColumn(tvTypes, "Name", SWT.None);
		tvcTypesNames.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof IType) {
					return ((IType) element).getName();
				}
				return super.getText(element);
			}
		});
		typesTVLayout.setColumnData(tvcTypesNames.getColumn(), new ColumnWeightData(20, 100, true));

		tvcTypesTypes = PreferenceUiUtil.createTableViewerColumn(tvTypes, "Type", SWT.None);
		tvcTypesTypes.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof IEnumerationType) {
					return "Enumeration";
				} else {
					return "Requirement";
				}
			}
		});
		typesTVLayout.setColumnData(tvcTypesTypes.getColumn(), new ColumnWeightData(20, 100, true));

		tvTypes.setInput(inputTypes);

		Composite btnComposite = new Composite(parent, SWT.None);
		btnComposite.setLayout(new GridLayout());
		btnComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));

		btnAddType = PreferenceUiUtil.createButton(btnComposite, "Add Data Type", Activator.getImageDescriptor("/icons/add.gif").createImage());
		btnAddType.setEnabled(false);

		btnEditType = PreferenceUiUtil.createButton(btnComposite, "Edit Data Type", Activator.getImageDescriptor("/icons/edit.png").createImage());
		btnEditType.setEnabled(false);

		btnDeleteType = PreferenceUiUtil.createButton(btnComposite, "Delete Data Type", Activator.getImageDescriptor("/icons/delete.gif").createImage());
		btnDeleteType.setEnabled(false);
	}

	@Override
	public void hookListeners() {

		super.hookListeners();

		tvModels.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				btnAddType.setEnabled(false);
				btnAddAttribute.setEnabled(false);
				inputTypes.clear();
				inputAttributes.clear();

				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object obj = ((IStructuredSelection) selection).getFirstElement();
					if (obj instanceof IDataModel) {
						selectedModel = (IDataModel) obj;
						btnAddType.setEnabled(true);
						inputTypes.addAll(selectedModel.getTypes());
					}
				}
				tvTypes.refresh();
				tvAttributes.refresh();
			}
		});

		tvTypes.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				btnAddAttribute.setEnabled(false);
				btnDeleteType.setEnabled(false);
				selectedType = null;
				inputAttributes.clear();

				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object obj = ((IStructuredSelection) selection).getFirstElement();
					if (obj instanceof IType) {
						selectedType = (IType) obj;
						btnAddAttribute.setEnabled(true);
						btnDeleteType.setEnabled(true);

						if (obj instanceof IRequirementType) {
							inputAttributes.addAll(((IRequirementType) obj).getAttributes());
							if (!tvcAttributesTypes.getColumn().getResizable()) {

								int width = (tvAttributes.getTable().getBounds().width) / 2;

								tvcAttributesTypes.getColumn().setWidth(width - tvAttributes.getTable().getBorderWidth());
								tvcAttributesTypes.getColumn().setResizable(true);
								tvcAttributesNames.getColumn().setWidth(width - tvAttributes.getTable().getBorderWidth());
							}
						}
						if (obj instanceof IEnumerationType) {
							inputAttributes.addAll(((IEnumerationType) obj).getEnumerators());
							if (tvcAttributesTypes.getColumn().getResizable()) {
								tvcAttributesTypes.getColumn().setWidth(0);
								tvcAttributesTypes.getColumn().setResizable(false);
								tvcAttributesNames.getColumn().setWidth(tvAttributes.getTable().getBounds().width - tvAttributes.getTable().getBorderWidth() * 2);
							}
						}
					}
				}
				tvAttributes.refresh();
			}
		});

		tvAttributes.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				btnDeleteAttribute.setEnabled(false);
				selectedAttribute = null;
				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object obj = ((IStructuredSelection) selection).getFirstElement();
					if (obj instanceof IAttribute) {
						selectedAttribute = (IAttribute) obj;
						btnDeleteAttribute.setEnabled(true);
					}
				}
			}
		});

		btnAddType.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				AddTypeDialog dialog = new AddTypeDialog(e.display.getActiveShell(), "Add Data Type");
				if (dialog.open() == Window.OK) {
					String name = dialog.getName();
					boolean isReq = dialog.isRequirement();
					IType type;

					if (isReq) {
						type = dataModelManager.createRequirementType(name, selectedModel);

					} else {
						type = dataModelManager.createEnumerationType(name);
					}
					selectedModel.addType(type);
					inputTypes.add(type);
					tvTypes.refresh();
					dirty = true;
				}
			}
		});

		btnDeleteType.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (selectedType != null) {
					if (MessageDialog.openConfirm(e.display.getActiveShell(), "Delete type", "A new version of the meta model needs to be created when deleting a type, do you confirm ?")) {
						if (selectedType instanceof IRequirementType) {
							((IRequirementType) selectedType).getAttributes().clear();
						}
						selectedModel.removeType(selectedType);
						inputTypes.remove(selectedType);
						tvAttributes.refresh();
						tvTypes.refresh();
						dirty = true;
					}
				}
			}
		});

		btnAddAttribute.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				Object attribute = null;
				if (selectedType instanceof IEnumerationType) {

					NameDialog dialog = new NameDialog(e.display.getActiveShell(), "Add Enumeration Value");
					if (dialog.open() == Window.OK) {
						attribute = dataModelManager.createEnumerator(dialog.getName());
						((IEnumerationType) selectedType).addEnumerator((IEnumerator) attribute);
					}

				} else if (selectedType instanceof IRequirementType) {
					Set<IType> types = new HashSet<IType>();
					types.addAll(ETypeImpl.eBasicTypes);
					// FIXME in next version references shall be ok
					// types.addAll(selectedModel.getTypes());

					AddAttributeDialog dialog = new AddAttributeDialog(e.display.getActiveShell(), "Add Attribute", types);

					if (Window.OK == dialog.open()) {
						String name = dialog.getName();
						IType type = dialog.getType();
						// TODO handle many
						attribute = dataModelManager.createAttribute(name, type, false);
						((IRequirementType) selectedType).addAttribute((IAttribute) attribute);
					}
				}
				if (attribute != null) {
					inputAttributes.add(attribute);
					tvAttributes.refresh();
					dirty = true;
				}
			}
		});

		btnDeleteAttribute.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (selectedAttribute != null && selectedType instanceof IRequirementType
						&& MessageDialog.openConfirm(e.display.getActiveShell(), "Delete type", "A new version of the meta model needs to be created when deleting an attribute, do you confirm ?")) {
					((IRequirementType) selectedType).removeAttribute(selectedAttribute);
					inputAttributes.remove(selectedAttribute);
					tvAttributes.refresh();
					dirty = true;
				}
			}
		});
	}

	@Override
	public boolean performOk() {
		boolean result = super.performOk();
		if (dirty) {
			MessageDialog.openWarning(getShell(), "Eclipse Restart", "Please relaunch Eclipse to use newly added Requirements types and attributes");
			tvModels.refresh();
			btnAddType.setEnabled(false);
			btnAddAttribute.setEnabled(false);
			inputTypes.clear();
			if (tvTypes != null) {
				tvTypes.refresh();
			}

			inputAttributes.clear();
			if (tvAttributes != null) {
				tvAttributes.refresh();
			}
			dirty = false;
		}

		return result;
	}
}
