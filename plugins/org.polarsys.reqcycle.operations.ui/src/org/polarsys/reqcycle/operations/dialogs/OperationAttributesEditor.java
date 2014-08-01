package org.polarsys.reqcycle.operations.dialogs;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.polarsys.reqcycle.operations.IParameter;
import org.polarsys.reqcycle.ui.eattrpropseditor.GenericEAttrPropsEditor;

public class OperationAttributesEditor extends TitleAreaDialog {

	private final Map<String, GenericEAttrPropsEditor> editors;
	private Method method;

	public OperationAttributesEditor(Shell shell, Method method) {
		super(shell);
		setShellStyle(SWT.MIN | SWT.MAX | SWT.RESIZE);
		this.method = method;
		this.editors = new LinkedHashMap<String, GenericEAttrPropsEditor>();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Enter parameters");

		Composite top = new Composite(parent, SWT.None);
		top.setLayout(new GridLayout(1, true));
		top.setLayoutData(GridDataFactory.fillDefaults().grab(true, true)
				.create());

		ScrolledComposite scrolledComposite = new ScrolledComposite(top,
				SWT.BORDER | SWT.V_SCROLL);
		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		Composite c = new Composite(scrolledComposite, SWT.NONE);
		c.setLayout(new GridLayout(1, false));

		scrolledComposite.setContent(c);
		Class<?>[] paramList = method.getParameterTypes();
		if (paramList.length > 1) {
			for (int i = 1; i < paramList.length; i++) {
				Class<?> paramClass = paramList[i];
				Annotation[] annotations = method.getParameterAnnotations()[i];
				String paramName = null;
				for (Annotation a : annotations) {
					if (a instanceof IParameter) {
						paramName = ((IParameter) a).value();
						break;
					}
				}
				if (paramName == null) {
					paramName = "Parameter " + i;
				}

				paramName += " (" + paramClass.getSimpleName() + ")";

				addEditor(paramClass, paramName, c);
			}
		}

		scrolledComposite.setMinSize(c.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		return top;
	}

	public void addEditor(Class<?> c, String attName, Composite composite) {
		final GenericEAttrPropsEditor attributeEditor = new GenericEAttrPropsEditor(
				composite, SWT.NONE);
		attributeEditor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Collection<Object> possibleValues = Collections.emptyList();
		attributeEditor.init(attName, c, possibleValues);

		this.editors.put(attName, attributeEditor);
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == IDialogConstants.OK_ID) {
			Iterator<Map.Entry<String, GenericEAttrPropsEditor>> entries = editors
					.entrySet().iterator();
			while (entries.hasNext()) {
				GenericEAttrPropsEditor editor = entries.next().getValue();
				if (!editor.isEditionValid()) {
					MessageDialog.openError(getShell(), "Error",
							"Some values are not entered or not valid");
					return;
				}
			}
		}
		super.buttonPressed(buttonId);
	}

	public Map<String, GenericEAttrPropsEditor> getEditors() {
		return editors;
	}

}