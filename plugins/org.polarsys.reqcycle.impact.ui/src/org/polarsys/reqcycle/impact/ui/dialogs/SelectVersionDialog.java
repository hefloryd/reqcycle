package org.polarsys.reqcycle.impact.ui.dialogs;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.core.resources.IFileState;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.team.core.RepositoryProvider;
import org.eclipse.team.core.history.IFileRevision;
import org.polarsys.reqcycle.core.ui.dialogs.ValidatingTitleAreaDialog;
import org.polarsys.reqcycle.impact.IVersionManager;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class SelectVersionDialog extends ValidatingTitleAreaDialog implements IDoubleClickListener {

	private TreeViewer treeViewer;
	private Map<RepositoryProvider, Collection<IFileRevision>> history;
	private List<IFileState> localHistory;
	private RequirementSource requirementSource;
	private RequirementSource requirementSourceSelected;
	private String rsVersion;

	IVersionManager versionManager = ZigguratInject.make(IVersionManager.class);

	@Inject
	IDataManager dataManager;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public SelectVersionDialog(Shell parentShell, RequirementSource requirementSource) {
		super(parentShell);
		ZigguratInject.inject(this);
		this.requirementSource = requirementSource;
		history = versionManager.getHistory(requirementSource);
		localHistory = versionManager.getLocalHistory(requirementSource);
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
		setTitle("Select version");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(3, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		treeViewer = new TreeViewer(composite);
		treeViewer.setContentProvider(new VersionContentProvider());
		treeViewer.setLabelProvider(new VersionLabelProvider());
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (((IStructuredSelection) event.getSelection()).getFirstElement() instanceof IFileRevision) {
					IFileRevision fileRev = (IFileRevision) (((IStructuredSelection) event.getSelection()).getFirstElement());
					Date date = new Date(fileRev.getTimestamp());
					rsVersion = date.toString();
					requirementSourceSelected = versionManager.loadResource(fileRev, requirementSource.getDataModelURI(), requirementSource.getDefaultScope(), requirementSource.getName());
				} else if (((IStructuredSelection) event.getSelection()).getFirstElement() instanceof IFileState) {
					IFileState fileState = (IFileState) (((IStructuredSelection) event.getSelection()).getFirstElement());
					Date date = new Date(fileState.getModificationTime());
					rsVersion = date.toString();
					requirementSourceSelected = versionManager.loadLocalHistoryResource(fileState, requirementSource.getDataModelURI(), requirementSource.getDefaultScope(), requirementSource.getName());
				} else if (((IStructuredSelection) event.getSelection()).getFirstElement().equals("Current")) {
					requirementSourceSelected = EcoreUtil.copy(requirementSource);
					rsVersion = "Current";
				} else {
					requirementSourceSelected = null;
				}
				validateInput();
			}
		});
		treeViewer.addDoubleClickListener(this);
		treeViewer.setInput(history.keySet());

		return area;
	}

	private class VersionContentProvider implements ITreeContentProvider {

		public VersionContentProvider() {
		}

		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		@Override
		public Object[] getElements(Object inputElement) {
			List<Object> list = new LinkedList<Object>();
			list.addAll(history.keySet());
			if (localHistory != null) {
				list.add("Local History");
			}
			list.add("Current");
			return list.toArray();
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof RepositoryProvider) {
				return history.get((RepositoryProvider) parentElement).toArray();
			} else if (parentElement.equals("Local History")) {
				return localHistory.toArray();
			}
			return null;
		}

		public Object getParent(Object element) {
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			if (element instanceof RepositoryProvider) {
				return history.get((RepositoryProvider) element).size() > 0;
			} else if (element.equals("Local History")) {
				return localHistory.size() > 0;
			}
			return false;
		}
	}

	private class VersionLabelProvider extends LabelProvider {

		@Override
		public String getText(Object element) {
			if (element instanceof RepositoryProvider) {
				return ((RepositoryProvider) element).getID();
			} else if (element instanceof IFileRevision) {
				Date date = new Date(((IFileRevision) element).getTimestamp());
				return date.toString();
			} else if (element instanceof IFileState) {
				Date date = new Date(((IFileState) element).getModificationTime());
				return date.toString();
			}
			return super.getText(element);
		}
	}

	@Override
	public IValidator getInputValidator() {
		return new IValidator() {
			@Override
			public String isValid() {
				if (requirementSourceSelected == null) {
					return "A version must be selected";
				}
				return null;
			}

		};
	}

	public RequirementSource getRequirementSource() {
		return requirementSourceSelected;
	}

	public String getRSVersion() {
		return rsVersion;
	}

	@Override
	public void doubleClick(DoubleClickEvent event) {
		if (requirementSourceSelected != null) {
			this.close();
		}
	}
}
