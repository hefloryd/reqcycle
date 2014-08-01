package org.polarsys.reqcycle.operations.dialogs;

import javax.inject.Inject;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.polarsys.reqcycle.core.ui.dialogs.ValidatingTitleAreaDialog;
import org.polarsys.reqcycle.operations.IReqCycleOperationManager;
import org.polarsys.reqcycle.operations.ReqCycleOperation;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

public class SelectOperationDialog extends ValidatingTitleAreaDialog {

	@Inject
	IReqCycleOperationManager reqCycleOperationlManager;

	private ListViewer listViewer;
	private Text text;

	protected ReqCycleOperation currentOperation;

	public SelectOperationDialog(Shell parent) {
		super(parent);
		setShellStyle(SWT.MIN | SWT.MAX | SWT.RESIZE);
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
		setTitle("Select Operation");

		Composite area = new Composite(parent, SWT.None);
		area.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		area.setLayout(new GridLayout(1, false));

		listViewer = new ListViewer(area, SWT.BORDER | SWT.V_SCROLL);
		List list = listViewer.getList();
		GridData gd_list = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_list.heightHint = 137;
		gd_list.widthHint = 433;
		list.setLayoutData(gd_list);

		initProviders(listViewer);

		text = new Text(area, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP
				| SWT.V_SCROLL | SWT.MULTI);

		text.setEditable(false);
		GridData gd_text = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_text.minimumHeight = 25;
		gd_text.widthHint = 352;
		gd_text.heightHint = 37;
		text.setLayoutData(gd_text);

		return area;
	}

	private void initProviders(ListViewer list) {
		LabelProvider labelProvider = new LabelProvider() {
			@Override
			public String getText(Object object) {
				if (object instanceof ReqCycleOperation) {
					ReqCycleOperation reqCycleOp = (ReqCycleOperation) object;
					String operation = reqCycleOp.getMethod().getName();

					Class<?>[] paramList = reqCycleOp.getMethod()
							.getParameterTypes();
					operation += "(";
					if (paramList.length > 1) {
						for (int i = 1; i < paramList.length; i++) {
							Class<?> c = paramList[i];
							if (i != 1) {
								operation += " ,";
							}
							operation += c.getSimpleName();
						}
					}
					operation += ")";

					return operation;

				}
				return super.getText(object);
			}
		};

		ArrayContentProvider contentProvider = ArrayContentProvider
				.getInstance();

		list.setLabelProvider(labelProvider);
		list.setContentProvider(contentProvider);
		list.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				validateInput();

				if (!listViewer.getSelection().isEmpty()) {
					IStructuredSelection selection = (IStructuredSelection) listViewer
							.getSelection();
					ReqCycleOperation op = (ReqCycleOperation) selection
							.getFirstElement();
					text.setText("Description : " + op.getDescription());
					currentOperation = op;
				}
			}
		});
		;

		list.setInput(Lists.newArrayList(Ordering.natural().sortedCopy(
				reqCycleOperationlManager.getAllOperations())));
	}

	@Override
	public IValidator getInputValidator() {
		return new IValidator() {
			@Override
			public String isValid() {
				if (listViewer.getSelection().isEmpty()) {
					return "An operation must be selected";
				}
				return null;
			}
		};
	}

	public ReqCycleOperation getResult() {
		return currentOperation;
	}
}
