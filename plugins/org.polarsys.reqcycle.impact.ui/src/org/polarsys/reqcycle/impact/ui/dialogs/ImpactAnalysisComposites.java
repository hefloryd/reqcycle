package org.polarsys.reqcycle.impact.ui.dialogs;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.polarsys.reqcycle.impact.Impact.AttributeImpacted;
import org.polarsys.reqcycle.impact.Impact.RequirementImpacted;
import org.polarsys.reqcycle.impact.Impact.TraceabilityLink;
import org.polarsys.reqcycle.impact.ui.Activator;
import org.polarsys.reqcycle.impact.ui.providers.ImpactContentProvider;
import org.polarsys.reqcycle.impact.ui.providers.ImpactLabelProvider;
import org.polarsys.reqcycle.impact.ui.providers.ImpactTraceabilityLabelProvider;
import org.polarsys.reqcycle.traceability.engine.ITraceabilityEngine;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.Lists;

public class ImpactAnalysisComposites {

	@Inject
	ITraceabilityEngine engine;

	@Inject
	IReachableManager manager;

	private Label rsValueLabel;
	private Label initialVersionValueLabel;
	private Label finalVersionValueLabel;
	private Label informationMessage;

	private Collection<TraceabilityLink> links = Lists.newArrayList();

	private ArrayList<ImpactContainer> impactList = Lists.newArrayList();

	private TreeViewer treeViewer;
	private TreeViewer attributeList;
	private TableViewer linkViewer;

	public ImpactAnalysisComposites() {
		ZigguratInject.inject(this);
	}

	public Composite createInputComposite(Composite parent) {
		Composite inputComposite = new Composite(parent, SWT.NONE);
		inputComposite.setLayout(new GridLayout(2, false));
		GridData gd_inputComposite = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_inputComposite.heightHint = 73;
		inputComposite.setLayoutData(gd_inputComposite);

		Label rsLabel = new Label(inputComposite, SWT.NONE);
		rsLabel.setText("Requirement Source :");

		rsValueLabel = new Label(inputComposite, SWT.NONE);
		rsValueLabel.setEnabled(false);
		rsValueLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

		Label initialVersionLabel = new Label(inputComposite, SWT.NONE);
		initialVersionLabel.setText("Initial version for impact analysis :");

		initialVersionValueLabel = new Label(inputComposite, SWT.NONE);
		initialVersionValueLabel.setEnabled(false);
		initialVersionValueLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

		Label finalVersionLabel = new Label(inputComposite, SWT.NONE);
		finalVersionLabel.setText("Final version for impact analysis :");

		finalVersionValueLabel = new Label(inputComposite, SWT.NONE);
		finalVersionValueLabel.setEnabled(false);
		finalVersionValueLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

		return inputComposite;
	}

	public void setRequirementSource(String requirementSource) {
		rsValueLabel.setText(requirementSource);
	}

	public void setInitialVersion(String initialVersion) {
		initialVersionValueLabel.setText(initialVersion);
	}

	public void setFinalVersion(String finalVersion) {
		finalVersionValueLabel.setText(finalVersion);
	}

	public Composite createImpactComposite(Composite parent) {
		Composite impactResultComposite = new Composite(parent, SWT.NONE);
		impactResultComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		impactResultComposite.setLayout(new GridLayout(1, false));

		SashForm form = new SashForm(impactResultComposite, SWT.None);
		form.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		treeViewer = new TreeViewer(form, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		treeViewer.setLabelProvider(new ImpactLabelProvider());
		treeViewer.setContentProvider(new ImpactContentProvider());

		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (((IStructuredSelection) event.getSelection()).getFirstElement() instanceof RequirementImpacted) {
					RequirementImpacted req = (RequirementImpacted) (((IStructuredSelection) event.getSelection()).getFirstElement());

					// In the attributes table we display the attributes modified for the
					// selected requirement
					attributeList.setInput(req);
					attributeList.expandAll();

					// In the links table we display the traceability links of the
					// selected requirement
					links.clear();
					links.addAll(req.getLinkList());
					linkViewer.refresh();
				}
			}
		});

		attributeList = new TreeViewer(form, SWT.BORDER);
		Tree tree2 = attributeList.getTree();
		tree2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		attributeList.setLabelProvider(new AttributeLabelProvider());
		attributeList.setContentProvider(new AttributeContentProvider());

		linkViewer = new TableViewer(form, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		linkViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		ArrayContentProvider provider = ArrayContentProvider.getInstance();
		linkViewer.setContentProvider(provider);

		Table table = linkViewer.getTable();
		linkViewer.setInput(links);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		informationMessage = new Label(impactResultComposite, SWT.None);
		informationMessage.setText("");
		informationMessage.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		
		// Creating the columns
		createModel();

		return impactResultComposite;
	}

	public void setImpactResult(EList<RequirementImpacted> reqAdded, EList<RequirementImpacted> reqDeleted, EList<RequirementImpacted> reqModified) {
		impactList.clear();
		if (reqAdded.size() != 0) {
			ImpactContainer added = new ImpactContainer("Added", reqAdded);
			impactList.add(added);
		}
		if (reqDeleted.size() != 0) {
			ImpactContainer deleted = new ImpactContainer("Deleted", reqDeleted);
			impactList.add(deleted);
		}
		if (reqModified.size() != 0) {
			ImpactContainer modified = new ImpactContainer("Modified", reqModified);
			impactList.add(modified);
		}
		attributeList.setInput(null);
		links.clear();
		linkViewer.refresh();
		if (impactList.size() != 0) {
			treeViewer.setInput(impactList);
			informationMessage.setText("");
		} else {
			treeViewer.setInput(null);
			informationMessage.setText("The versions are identical.");
		}
	}

	private void createModel() {
		createTableViewerColumn("Link type", 50 , 0).setLabelProvider(new ImpactTraceabilityLabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof TraceabilityLink) {
					TraceabilityLink link = (TraceabilityLink) element;
					return link.getLinkType();
				}
				return super.getText(element);
			}
		});

		createTableViewerColumn("Direction", 50, 1).setLabelProvider(new ImpactTraceabilityLabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof TraceabilityLink) {
					TraceabilityLink link = (TraceabilityLink) element;
					return link.getLinkDirection();
				}
				return super.getText(element);
			}
		});

		createTableViewerColumn("Link to", 100, 2).setLabelProvider(new ImpactTraceabilityLabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof TraceabilityLink) {
					TraceabilityLink link = (TraceabilityLink) element;
					return link.getLinkedElement();
				}
				return super.getText(element);
			}
		});
	}

	private TableViewerColumn createTableViewerColumn(String title, Integer bound, final int colNumber) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(linkViewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		if (bound != null){
			column.setWidth(bound);
		}
		column.setResizable(true);
		column.setMoveable(false);
		return viewerColumn;
	}

	public class ImpactContainer {
		private String name;
		EList<RequirementImpacted> reqList;

		public ImpactContainer(String name, EList<RequirementImpacted> reqList) {
			this.name = name;
			this.reqList = reqList;
		}

		public String getName() {
			return this.name;
		}

		public EList<RequirementImpacted> getReqList() {
			return this.reqList;
		}
	}

	public class AttributeLabelProvider implements ILabelProvider {

		Image imageOldValue;
		Image imageNewValue;

		public AttributeLabelProvider() {
			super();
			ImageDescriptor descrNew = Activator.getImageDescriptor("icons/add_obj.gif");
			imageNewValue = descrNew.createImage();

			ImageDescriptor descrOld = Activator.getImageDescriptor("icons/remove_correction.gif");
			imageOldValue = descrOld.createImage();
		}

		@Override
		public void addListener(ILabelProviderListener listener) {
		}

		@Override
		public void dispose() {
		}

		@Override
		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		@Override
		public void removeListener(ILabelProviderListener listener) {
		}

		@Override
		public Image getImage(Object element) {
			if (element instanceof AttributeValue) {
				if (((AttributeValue) element).getStatus().equals(Status.NEW_VALUE)) {
					return imageNewValue;
				} else {
					return imageOldValue;
				}
			}
			return null;
		}

		@Override
		public String getText(Object element) {
			if (element instanceof AttributeImpacted) {
				return ((AttributeImpacted) element).getId();
			} else if (element instanceof RequirementImpacted) {
				return ((RequirementImpacted) element).getId();
			} else if (element instanceof AttributeValue) {
				return ((AttributeValue) element).getValue();
			}
			return element.toString();
		}
	}

	public class AttributeContentProvider implements ITreeContentProvider {

		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		@Override
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Collection) {
				return ((Collection) inputElement).toArray();
			} else if (inputElement instanceof RequirementImpacted) {
				return ((RequirementImpacted) inputElement).getAttributesImpacted().toArray();
			}
			return null;
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof AttributeImpacted) {
				Object[] listObjects = new Object[2];
				AttributeValue oldValue = new AttributeValue(((AttributeImpacted) parentElement).getOldValue(), Status.OLD_VALUE);
				listObjects[0] = oldValue;
				AttributeValue newValue = new AttributeValue(((AttributeImpacted) parentElement).getNewValue(), Status.NEW_VALUE);
				listObjects[1] = newValue;
				return listObjects;
			}
			return null;
		}

		@Override
		public Object getParent(Object element) {
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			if (element instanceof AttributeImpacted) {
				return true;
			}
			return false;
		}
	}

	protected enum Status {
		OLD_VALUE, NEW_VALUE;
	}

	protected class AttributeValue {

		String value;
		Status status;

		AttributeValue(String value, Status status) {
			this.value = value;
			this.status = status;
		}

		protected String getValue() {
			return this.value;
		}

		protected Status getStatus() {
			return this.status;
		}
	}
}
