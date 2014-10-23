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
import java.util.Iterator;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;
import org.polarsys.reqcycle.repository.data.types.IDataModel;
import org.polarsys.reqcycle.repository.data.types.IType;
import org.polarsys.reqcycle.repository.data.ui.Activator;
import org.polarsys.reqcycle.repository.data.ui.dialog.NameDialog;
import org.polarsys.reqcycle.repository.data.ui.preference.PreferenceUiUtil;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;

public class DataModelsPreferencePage extends PreferencePage implements IWorkbenchPreferencePage, Listener {

	@Inject
	IDataModelManager dataModelManager;

	/** Models table viewer */
	protected TableViewer tvModels;

	/** Models table */
	protected Table tModels;

	/** Add Model Button */
	protected Button btnAddModel;

	/** Edit Model Button */
	protected Button btnEditModel;

	protected Button btnDeleteModel;

	protected Collection<IDataModel> inputModels;

	@Inject
	private IDataManager dataManager;

	/**
	 * @wbp.parser.constructor
	 */
	public DataModelsPreferencePage() {
		super();
		ZigguratInject.inject(this);
	}

	@Override
	protected void performDefaults() {
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		Button defaultButton = getDefaultsButton();
		// Disable default button
		if (defaultButton != null) {
			defaultButton.setVisible(false);
			defaultButton.setEnabled(false);
		}
	}

	@Override
	public boolean performOk() {
		dataModelManager.save();
		boolean res = MessageDialog.openQuestion(getShell(), "Eclipse Restart needed", "A restart of Eclipse is needed to handle requirement data model changes.\nDo you want to restart now ?");
		if (res) {
			PlatformUI.getWorkbench().restart();
		}
		return true;
	}

	@Override
	public boolean performCancel() {
		dataModelManager.discardUnsavedChanges();
		return super.performCancel();
	}

	@Override
	protected Control createContents(Composite parent) {
		SashForm control = new SashForm(parent, SWT.VERTICAL);
		control.setLayout(new GridLayout(1, false));
		control.setLayoutData(new GridData());

		// Data type Packages group
		Group packagesGrp = PreferenceUiUtil.createGroup(control, "Data Models");
		createModelsUi(packagesGrp);

		doCreateContents(control);

		hookListeners();
		return control;
	}

	/**
	 * Override this method to add element UI
	 * 
	 * @param control
	 */
	public void doCreateContents(Composite control) {
	}

	/**
	 * Create Model Viewer UI
	 * 
	 * @param parent
	 *            Composite parent
	 */
	protected void createModelsUi(Composite parent) {
		// Table Viewer
		Composite viewerComposite = new Composite(parent, SWT.None);
		viewerComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		TableColumnLayout packagesTVLayout = new TableColumnLayout();
		viewerComposite.setLayout(packagesTVLayout);

		tvModels = createDataModelTableViewer(viewerComposite, packagesTVLayout);
		tModels = tvModels.getTable();

		Composite btnComposite = new Composite(parent, SWT.None);
		btnComposite.setLayout(new GridLayout());
		btnComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));

		btnAddModel = PreferenceUiUtil.createButton(btnComposite, "Add Data Model", Activator.getImageDescriptor("/icons/add.gif").createImage());

		btnEditModel = PreferenceUiUtil.createButton(btnComposite, "Edit Data Model", Activator.getImageDescriptor("/icons/edit.png").createImage());
		btnEditModel.setEnabled(false);

		btnDeleteModel = PreferenceUiUtil.createButton(btnComposite, "Delete Data Model", Activator.getImageDescriptor("/icons/delete.gif").createImage());
		// btnDeleteModel.setEnabled(false);

	}

	public TableViewer createDataModelTableViewer(Composite parent, TableColumnLayout packagesTVLayout) {

		// Table Viewer
		TableViewer tvModels = new TableViewer(parent);
		tvModels.setContentProvider(ArrayContentProvider.getInstance());
		Table tModels = tvModels.getTable();
		tModels.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tModels.setLinesVisible(true);

		// Columns
		TableViewerColumn tvcModelsNames = PreferenceUiUtil.createTableViewerColumn(tvModels, "Name", SWT.None);
		tvcModelsNames.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof IDataModel) {
					IDataModel dataModel = (IDataModel) element;
					return dataModel.getName() + (dataModel.getVersion() > 1 ? " (v" + dataModel.getVersion() + ")" : "");
				}
				return super.getText(element);
			}
		});
		packagesTVLayout.setColumnData(tvcModelsNames.getColumn(), new ColumnWeightData(20, 100, true));

		initInput(dataModelManager);
		tvModels.setInput(inputModels);

		return tvModels;
	}

	private void initInput(IDataModelManager dataModelManager) {
		inputModels = new ArrayList<IDataModel>();
		inputModels.addAll(dataModelManager.getCurrentDataModels());
	}

	public void addDataModels(IDataModel... models) {
		for (IDataModel model : models) {
			inputModels.add(model);
		}
	}

	public void removeDataModels(IDataModel... models) {
		for (IDataModel model : models) {
			inputModels.remove(model);
		}
	}

	private <T extends EObject> T resolveProxy(T obj) {
		if (obj.eIsProxy() && obj.eResource() != null) {
			EObject newObj = EcoreUtil.resolve(obj, obj.eResource().getResourceSet());
			return (T) newObj;
		}
		return obj;
	}

	private boolean isTypesUsed(Collection<EClass> types) {
		for (RequirementSource requirementSource : dataManager.getRequirementSources()) {
			requirementSource = resolveProxy(requirementSource);
			return isRequirementTypesUsed(requirementSource.getRequirements(), types);
		}
		return false;
	}

	private boolean isRequirementTypesUsed(EList<AbstractElement> requirements, Collection<EClass> types) {
		for (AbstractElement abstractElement : requirements) {
			abstractElement = resolveProxy(abstractElement);
			if (types.contains(abstractElement.eClass())) {
				return true;
			}
			if (abstractElement != null && abstractElement.getScopes() != null && !abstractElement.getScopes().isEmpty()) {
				for (Scope scope : abstractElement.getScopes()) {
					scope = resolveProxy(scope);
				}
			}
			if (abstractElement instanceof Requirement) {
				return isRequirementTypesUsed(((Requirement) abstractElement).getChildren(), types);
			}
		}
		return false;
	}

	public boolean isDataModelUsed(IDataModel dataModel) {
		Collection<IType> types = dataModel.getTypes();
		Collection<EClass> eTypes = Collections2.transform(types, new Function<IType, EClass>() {

			@Override
			public EClass apply(IType type) {
				EClass eclass = null;
				if (type instanceof IAdaptable) {
					eclass = (EClass) ((IAdaptable) type).getAdapter(EClass.class);
				}
				return eclass;
			};
		});

		if (isTypesUsed(Collections2.filter(eTypes, Predicates.notNull()))) {
			return true;
		}
		String dataModelURI = dataModel.getDataModelURI();
		Set<RequirementSource> sources = dataManager.getRequirementSources();
		for (RequirementSource requirementSource : sources) {
			if (dataModelURI.equals(requirementSource.getDataModelURI())) {
				return true;
			}
		}

		for (Scope scope : dataModelManager.getScopes(dataModel)) {
			EList<AbstractElement> reqs = scope.getRequirements();
			if (reqs != null && !reqs.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Add Listeners
	 */
	public void hookListeners() {

		btnAddModel.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				NameDialog dialog = new NameDialog(e.display.getActiveShell(), "Add Data Model") {

					@Override
					protected void okPressed() {
						String name = getName();
						// FIXME : use exception mecanism instead of using
						// message dialog.
						if (dataModelManager.getCurrentDataModel(name) != null) {
							MessageDialog.openError(getShell(), "Add Data Model", "A Data Model with the same name already exists. Please choose a differente one.");
							return;
						}
						super.okPressed();
					}
				};
				if (dialog.open() == Window.OK) {
					String name = dialog.getName();
					addDataModels(dataModelManager.createDataModel(name));
					tvModels.refresh();
				}
			}
		});

		btnDeleteModel.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tvModels.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object firstElement = ((IStructuredSelection) selection).getFirstElement();
					if (firstElement instanceof IDataModel) {
						IDataModel dataModel = (IDataModel) firstElement;
						if (!isEmpty(dataModel)) {
							if (!MessageDialog.openQuestion(getShell(), "Delete Data Model", "The Data Model you are trying to remove is not empty. Would you like to continue ?")) {
								return;
							}
						}
						if (isUsed(dataModel)) {
							MessageDialog.openError(getShell(), "Delete Data Model", "The Data Model you are trying to remove is used. Used Data Models can't be deleted");
							return;
						} else {
							removeDataModels(dataModel);
							dataModelManager.removeDataModel(dataModel);
							tvModels.refresh();
						}
					}

				}
			}
		});

	}

	protected boolean isEmpty(IDataModel dataModel) {
		return dataModelManager.isEmpty(dataModel);
	}

	protected Boolean isUsed(IDataModel dataModel) {
		return isDataModelUsed(dataModel);
	}

	@Override
	public void handleEvent(Event event) {
		if (tvModels != null) {
			tvModels.refresh();
		}
	}

	@Override
	public void init(IWorkbench workbench) {
	}

	@Override
	public void setVisible(boolean visible) {
		if (visible && tvModels != null && inputModels != null) {
			Collection<IDataModel> dataModels = dataModelManager.getCurrentDataModels();
			Iterator<IDataModel> iter = inputModels.iterator();
			Collection<IDataModel> toRemove = new ArrayList<IDataModel>();
			while (iter.hasNext()) {
				IDataModel dataModel = iter.next();
				if (!dataModels.contains(dataModel)) {
					toRemove.add(dataModel);
				}
			}

			removeDataModels(toRemove.toArray(new IDataModel[toRemove.size()]));
			tvModels.refresh();
		}
		super.setVisible(visible);
	}

}
