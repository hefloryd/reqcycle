package org.polarsys.reqcycle.impact.ui.dialogs;

import java.util.Set;

import javax.inject.Inject;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.polarsys.reqcycle.core.ui.dialogs.ValidatingTitleAreaDialog;
import org.polarsys.reqcycle.repository.connector.ConnectorDescriptor;
import org.polarsys.reqcycle.repository.connector.IConnectorManager;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.util.DataUtil;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class SelectModelDialog extends ValidatingTitleAreaDialog implements IDoubleClickListener {

	/** Requirement Source Manager */
	@Inject
	IDataManager requirementSourceManager;

	@Inject
	IConnectorManager repositoryConnectorManager;

	private TreeViewer viewer;

	private RequirementSource sourceSelected;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public SelectModelDialog(Shell parentShell) {
		super(parentShell);
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
		setTitle("Select version");
		Composite area = (Composite) super.createDialogArea(parent);
		area.setLayout(new GridLayout(1, false));
		area.setLayoutData(new GridData(GridData.FILL_BOTH));

		viewer = new TreeViewer(area, SWT.H_SCROLL | SWT.V_SCROLL);
		Tree tree = viewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));

		viewer.setContentProvider(new RSContentProvider());
		viewer.setLabelProvider(new RSLabelProvider());
		viewer.setInput(requirementSourceManager.getRepositoryMap().keySet());
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (((IStructuredSelection) event.getSelection()).getFirstElement() instanceof RequirementSource) {
					sourceSelected = (RequirementSource) ((IStructuredSelection) event.getSelection()).getFirstElement();
					validateInput();
				}
			}
		});
		viewer.addDoubleClickListener(this);

		return area;
	}

	@Override
	public IValidator getInputValidator() {
		return new IValidator() {
			@Override
			public String isValid() {
				if (sourceSelected == null) {
					return "A Requirement Source must be selected";
				}
				return null;
			}
		};
	}

	public RequirementSource getRequirementSource() {
		return sourceSelected;
	}

	public class RSContentProvider implements ITreeContentProvider, IStructuredContentProvider {

		@Override
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		@Override
		public void dispose() {
		}

		@Override
		public Object[] getElements(Object parent) {
			if (parent instanceof Set<?>) {
				return ((Set<?>) parent).toArray();
			}
			return getChildren(parent);
		}

		@Override
		public Object getParent(Object child) {
			return null;
		}

		@Override
		public Object[] getChildren(Object parent) {
			Set<RequirementSource> repositories = requirementSourceManager.getRequirementSources((String) parent);
			return repositories.toArray();
		}

		@Override
		public boolean hasChildren(Object parent) {

			if (parent instanceof String) {
				return !requirementSourceManager.getRequirementSources((String) parent).isEmpty();
			}
			return false;
		}
	}

	public class RSLabelProvider extends LabelProvider {

		@Override
		public String getText(Object obj) {
			if (obj instanceof String) {
				ConnectorDescriptor connectorDescriptor = repositoryConnectorManager.get((String) obj);
				if (connectorDescriptor != null) {
					return connectorDescriptor.getName();
				} else {
					return "";
				}
			}
			if (obj instanceof RequirementSource) {
				return DataUtil.getLabel(obj);
			}
			return obj.toString();
		}

		@Override
		public Image getImage(Object obj) {
			return null;
		}
	}

	@Override
	public void doubleClick(DoubleClickEvent event) {
		if (sourceSelected != null) {
			this.close();
		}
	}
}