package org.polarsys.reqcycle.repository.connector.ui.wizard.pages;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;
import org.polarsys.reqcycle.repository.data.types.IDataModel;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public abstract class AbstractSettingPage extends WizardPage implements IChangeListener {

	@Inject
	protected IDataModelManager dataManager;

	private ComboViewer cvDataModel;

	private ComboViewer cvScope;

	private Combo cScope;

	private Combo cDataModel;

	private Collection<Scope> inputScope = new ArrayList<Scope>();

	private Text txtFile;

	private Button btnBrowseDestinationFile;

	private Button btnCopyImport;
	private Button btnReferenceImport;
	private Label lblMode;
	private Composite radioBtnComposite;

	private DataBindingContext bindingContext;

	protected AbstractSettingPage(String pageName) {
		super(pageName);
		ZigguratInject.inject(this);
	}

	public abstract AbstractStorageBean getBean();

	@Override
	public void createControl(Composite parent) {

		Composite compositeContainer = new Composite(parent, SWT.NONE);
		compositeContainer = doCreateSpecific(compositeContainer);

		createModele(compositeContainer, "Model");
		createScope(compositeContainer, "Scope");
		createDestinationFile(compositeContainer);
		createCopyOrRefMode(compositeContainer);
		hookListeners();
		bindingContext = new DataBindingContext();
		initDataBindings(bindingContext);
		observeBean(bindingContext, this);
	}

	public static void observeBean(DataBindingContext bindingContext, IChangeListener listener) {
		IObservableList list = bindingContext.getValidationStatusProviders();
		for (Object o : list) {
			Binding b = (Binding) o;
			b.getTarget().addChangeListener(listener);
		}
	}

	protected void createModele(Composite compositeContainer, String labelTitleModele) {

		Label lblSeparatorModele = new Label(compositeContainer, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblSeparatorModele.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 4, 1));
		Label lblDataModel = new Label(compositeContainer, SWT.NONE);
		lblDataModel.setText(labelTitleModele);

		cvDataModel = new ComboViewer(compositeContainer);
		cDataModel = cvDataModel.getCombo();
		cDataModel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		cvDataModel.setContentProvider(ArrayContentProvider.getInstance());
		cvDataModel.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof IDataModel) {
					return ((IDataModel) element).getName();
				}
				return super.getText(element);
			}
		});
		cvDataModel.setInput(dataManager.getCurrentDataModels());

	}

	protected void createScope(Composite compositeContainer, String labelTitleScope) {

		Label lblScope = new Label(compositeContainer, SWT.NONE);
		lblScope.setText(labelTitleScope);

		cvScope = new ComboViewer(compositeContainer);
		cScope = cvScope.getCombo();
		cScope.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		cScope.setEnabled(false);
		cvScope.setContentProvider(ArrayContentProvider.getInstance());
		cvScope.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof Scope) {
					return ((Scope) element).getName();
				}
				return super.getText(element);
			}
		});
		cvScope.setInput(inputScope);

	}

	protected void createCopyOrRefMode(Composite compositeContainer) {

		Label lblSeparatorModele = new Label(compositeContainer, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblSeparatorModele.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 4, 1));

		radioBtnComposite = new Composite(compositeContainer, SWT.NONE);
		radioBtnComposite.setLayout(new GridLayout(5, false));
		radioBtnComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		lblMode = new Label(radioBtnComposite, SWT.None);
		lblMode.setText("Import Mode :");

		btnCopyImport = new Button(radioBtnComposite, SWT.RADIO);
		btnCopyImport.setText("Copy");
		btnCopyImport.setSelection(true);

		btnReferenceImport = new Button(radioBtnComposite, SWT.RADIO);
		btnReferenceImport.setText("Reference");
		btnReferenceImport.setEnabled(false);
		new Label(radioBtnComposite, SWT.NONE);
		lblSeparatorModele = new Label(compositeContainer, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblSeparatorModele.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 4, 1));

	}

	protected void hookListeners() {
		specificHookListeners();
		getDataModelSelectionChangedListener();
	}

	protected void createDestinationFile(Composite compositeContainer) {

		Label lblSeparator = new Label(compositeContainer, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblSeparator.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 4, 1));

		Composite radioBtnComposite = new Composite(compositeContainer, SWT.NONE);
		radioBtnComposite.setLayout(new GridLayout(1, false));
		radioBtnComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 4, 1));

		Composite compositeCopy = new Composite(radioBtnComposite, SWT.NONE);
		compositeCopy.setLayout(new GridLayout(3, false));
		compositeCopy.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		Label lblCopyFile = new Label(compositeCopy, SWT.NONE);
		lblCopyFile.setText("Repository Folder :");

		txtFile = new Text(compositeCopy, SWT.BORDER);
		txtFile.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		// txtFile.setEditable(false);
		txtFile.setEnabled(false);

		btnBrowseDestinationFile = new Button(compositeCopy, SWT.NONE);
		btnBrowseDestinationFile.setText("Browse");

	}

	protected void getDataModelSelectionChangedListener() {

		cvDataModel.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				inputScope.clear();
				cScope.setEnabled(false);
				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object obj = ((IStructuredSelection) selection).getFirstElement();
					if (obj instanceof IDataModel) {
						cScope.setEnabled(true);
						inputScope.addAll(dataManager.getScopes((IDataModel) obj));

					}
				}
				cvScope.refresh();
			}
		});
	}

	protected void getDestinationFileSelectionListener() {

		btnBrowseDestinationFile.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				ContainerSelectionDialog dialog = new ContainerSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(), true, "select location for save");
				if (Window.OK == dialog.open()) {
					Object[] result = dialog.getResult();
					if (result != null && result.length > 0) {
						if (result[0] instanceof IPath) {
							IPath path = (IPath) result[0];
							txtFile.setText(path.append(getBean().getFileName()).addFileExtension("reqcycle").toString());
						}
					}

				}
			}
		});
	}

	protected final DataBindingContext initDataBindings(DataBindingContext bindingContext) {

		IObservableValue observeSingleSelectionCvDataModel = ViewerProperties.singleSelection().observe(cvDataModel);
		IObservableValue dataPackageBeanObserveValue = PojoProperties.value("dataModel").observe(getBean());
		bindingContext.bindValue(observeSingleSelectionCvDataModel, dataPackageBeanObserveValue, null, null);
		//
		IObservableValue observeSingleSelectionCvScope = ViewerProperties.singleSelection().observe(cvScope);
		IObservableValue scopeBeanObserveValue = PojoProperties.value("scope").observe(getBean());
		bindingContext.bindValue(observeSingleSelectionCvScope, scopeBeanObserveValue, null, null);
		//
		IObservableValue observeTextTxtFileObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtFile);
		IObservableValue modelPathBeanObserveValue = PojoProperties.value("outputPath").observe(getBean());
		bindingContext.bindValue(observeTextTxtFileObserveWidget, modelPathBeanObserveValue, null, null);

		doSpecificInitDataBindings(bindingContext);
		return bindingContext;
	}

	protected void doSpecificInitDataBindings(DataBindingContext bindingContext) {
		// DO NOTHING
		// intended to be overridden

	}

	@Override
	public boolean isPageComplete() {
		StringBuffer error = new StringBuffer();
		boolean result = true;

		result = specificIsPageComplete(result);

		error.append(specificIsPageComplete(result, error));

		if ((getBean().getDataModel() == null)) {
			error.append("Choose a Data Model\n");
			result = false;
		}

		if (getBean().getScope() == null) {
			error.append("Choose a Scope\n");
			result = false;
		}

		if ((getBean().getOutputPath() == null) || (getBean().getOutputPath() == "")) {
			error.append("Choose a destination path\n");
			result = false;
		}

		if (!result) {
			setErrorMessage(error.toString());
		} else {
			setErrorMessage(null);
		}

		return result;
	}

	protected abstract Composite doCreateSpecific(Composite parent);

	protected abstract void specificHookListeners();

	protected abstract Boolean specificIsPageComplete(Boolean result);

	protected abstract StringBuffer specificIsPageComplete(Boolean result, StringBuffer error);

	@Override
	public void handleChange(ChangeEvent event) {
		bindingContext.updateModels();
		bindingContext.updateTargets();
		getWizard().getContainer().updateButtons();
		getWizard().getContainer().updateMessage();
		IWizardPage p = getNextPage();
		while (p != null) {
			if (p != this && p instanceof IUpdatablePage) {
				((IUpdatablePage) p).hasChanged();
			}
			p = p.getNextPage();
		}
	}

	public void setFileName(String fileName) {
		getBean().setFileName(fileName);
	}

}
