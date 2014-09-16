package org.polarsys.reqcycle.styling.ui.dialogs;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.polarsys.reqcycle.core.ui.dialogs.ValidatingTitleAreaDialog;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.types.IAttribute;
import org.polarsys.reqcycle.repository.data.types.IDataModel;
import org.polarsys.reqcycle.repository.data.types.IRequirementType;
import org.polarsys.reqcycle.repository.data.types.IType;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class SelectModelDialog extends ValidatingTitleAreaDialog {

	@Inject
	IDataModelManager dataModelManager;

	private FilteredTree filteredTree;
	private TreeViewer treeViewer;

	protected IAttribute currentAttribute;

	public SelectModelDialog(Shell parent) {
		super(parent);
		ZigguratInject.inject(this);
	}

	@Override
	protected Control createContents(Composite parent) {
		Control result = super.createContents(parent);
		validateInput();
		return result;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Select Model");

		Composite area = new Composite(parent, SWT.None);
		area.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		area.setLayout(new GridLayout(1, false));

		PatternFilter filter = new PatternFilter();
		this.filteredTree = new FilteredTree(area, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL, filter, true);

		treeViewer = filteredTree.getViewer();
		final Tree tree = treeViewer.getTree();

		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		treeViewer.setContentProvider(new EClassContentProvider());
		treeViewer.setLabelProvider(new EClassLabelProvider());
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				validateInput();
				if (((IStructuredSelection) event.getSelection()).getFirstElement() instanceof IAttribute) {
					IAttribute att = (IAttribute) ((IStructuredSelection) event.getSelection()).getFirstElement();
					currentAttribute = att;
				}
			}
		});

		ArrayList<IType> input = new ArrayList<IType>();
		for (IDataModel dataModel : dataModelManager.getCurrentDataModels()) {
			input.addAll(dataModel.getTypes());
		}
		treeViewer.setInput(input);

		return area;
	}

	protected Collection<EClass> getAllEClasses(EPackage obj) {
		Collection<EClass> result = new ArrayList<EClass>();

		for (EClassifier eClassifier : obj.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				result.add((EClass) eClassifier);
			}
		}

		for (EPackage ePackage : obj.getESubpackages()) {
			result.addAll(getAllEClasses(ePackage));
		}

		return result;
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
			if (parentElement instanceof IRequirementType) {
				return ((IRequirementType) parentElement).getAttributes().toArray();
			}
			return null;
		}

		public Object getParent(Object element) {
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			if (element instanceof IRequirementType) {
				Collection<IAttribute> attr = ((IRequirementType) element).getAttributes();
				return attr.size() > 0;
			}
			return false;
		}
	}

	private class EClassLabelProvider extends LabelProvider {

		@Override
		public String getText(Object element) {
			if (element instanceof IRequirementType) {
				return ((IRequirementType) element).getName();
			} else if (element instanceof IAttribute) {
				return (((IAttribute) element).getName());
			}
			return super.getText(element);
		}
	}

	@Override
	public IValidator getInputValidator() {
		return new IValidator() {
			@Override
			public String isValid() {
				if (treeViewer.getSelection().isEmpty()) {
					return "An attribute must be selected";
				}
				IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
				if (!(selection.getFirstElement() instanceof IAttribute)) {
					return "An attribute must be selected";
				}
				return null;
			}

		};
	}

	public IAttribute getResult() {
		return currentAttribute;
	}
}
