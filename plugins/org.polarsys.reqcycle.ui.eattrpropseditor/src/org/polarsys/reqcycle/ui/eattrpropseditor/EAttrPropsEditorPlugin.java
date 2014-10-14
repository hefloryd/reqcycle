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
package org.polarsys.reqcycle.ui.eattrpropseditor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.ClassUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.util.EcoreAdapterFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Composite;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.polarsys.reqcycle.ui.eattrpropseditor.api.IEAttrPropsEditor;

public class EAttrPropsEditorPlugin implements BundleActivator {

	public static final String PLUGIN_ID = "org.polarsys.reqcycle.ui.eattrpropseditor";

	private static BundleContext context;

	private static Map<Class<?>, Instantiator> eAttrEditorManager = new HashMap<Class<?>, Instantiator>();

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		EAttrPropsEditorPlugin.context = bundleContext;
		this.readEAttrEditorExtensions();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		EAttrPropsEditorPlugin.context = null;
	}

	private void readEAttrEditorExtensions() {
		final IExtensionRegistry registry = Platform.getExtensionRegistry();
		final IConfigurationElement[] elements = registry.getConfigurationElementsFor(PLUGIN_ID, "definition");
		for (final IConfigurationElement e : elements) {
			try {
				final Class<?> type = Platform.getBundle(e.getContributor().getName()).loadClass(e.getAttribute("type"));
				eAttrEditorManager.put(type, (new Instantiator(e)));
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvalidRegistryObjectException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		eAttrEditorManager = Collections.unmodifiableMap(eAttrEditorManager);
	}

	public static class Instantiator {
		private IConfigurationElement element;

		public Instantiator(IConfigurationElement element) {
			this.element = element;
		}
		
		public IEAttrPropsEditor<?> create () {
			try {
				return (IEAttrPropsEditor<?>) element.createExecutableExtension("class");
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
	
	/**
	 * <b>NOTE :</b> The returned Map is immutable.
	 * 
	 * @return The Map of available {@link IEAttrPropsEditor} editors. The map's key represents the type that an editor supports, and the value represents the instance of the editor itself.
	 */
	public static Map<Class<?>, Instantiator> getEAttrEditorManager() {
		return eAttrEditorManager;
	}

	/**
	 * Creates a specific and appropriate EAttribute editor based on the type of the EAttribute.
	 * 
	 * @param eAttr
	 * @param javaClassTypeName
	 *            - The javaClassType of the attribute. Optional, and so may be <tt>null</tt>. If not <code>null</code>, then no further lookup will be done onto the attribute in order to retrieve its java class type, but the specified javaClassType
	 *            will be used directly instead.
	 * @param container
	 * @param style
	 * @return The appropriate instance of {@link IEAttrPropsEditor} to use.
	 */
	public static IEAttrPropsEditor<?> getStructuralFeatureEditor(String attributeName, Class type, Composite container, int style) {

		// String editorType = null;
		// if(javaClassTypeName != null) {
		// editorType = javaClassTypeName;
		// } else {
		// final EClassifier eType = eAttr.getEType();
		// editorType = getEditorType(eType);
		// }

		IEAttrPropsEditor<?> editor = getEditorByTypeInstance(type);

		if (editor != null) {			
			editor.setContainer(container);
			editor.setStyle(style);
			editor.setAttributeName(attributeName);
			return editor;
		} else {
			throw new UnsupportedOperationException("Unsupported type. No editor found ...");
		}
	}

	public static String getEditorType(final EClassifier eType) {
		if (eType instanceof EClass) {
			throw new UnsupportedOperationException("EClass not yet supported ...");
		}

		String editorType = eType.getInstanceClassName();

		if (eType instanceof EEnum) {
			editorType = EEnum.class.getName();
		} else {
			try {
				Class<?> javaClass = ClassUtils.getClass(editorType);
				if (javaClass.isPrimitive()) {
					javaClass = ClassUtils.primitiveToWrapper(javaClass);
				}
				editorType = javaClass.getName();
			} catch (ClassNotFoundException e) {
				e.printStackTrace(System.err); // Change or remove
				return null; // Bad bad bad ...
			}
		}
		return editorType;
	}

	private static IEAttrPropsEditor<?> getEditorByTypeInstance(Class<?> initialClass) {
		try {
			Class<?> nearestClass = null;
			for (final Class<?> currentSupportedClass : getEAttrEditorManager().keySet()) {
				if (currentSupportedClass.isAssignableFrom(initialClass)) {
					if (nearestClass == null || (nearestClass.isAssignableFrom(currentSupportedClass))) {
						nearestClass = currentSupportedClass;
					}
					if (nearestClass.equals(initialClass))
						break;
				}
			}
			if (nearestClass != null) {
				return getEAttrEditorManager().get(nearestClass).create();
			}
		} catch (NullPointerException e) {
			e.printStackTrace(System.err); // XXX Change or remove
		}
		return null;
	}

}
