package org.polarsys.reqcycle.styling.ui.dialogs;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.Image;
import org.polarsys.reqcycle.styling.ui.Activator;

public class IconRegistry {
	private static final String EXT_ID = "stylingpic";
	private static Map<String, Descriptor> IMAGES = init();

	public static Collection<Descriptor> getRegisteredImages() {
		return Collections.unmodifiableCollection(IMAGES.values());
	}

	public static Image getImage(String id) {
		Image image = JFaceResources.getImageRegistry().get(id);
		return image;
	}

	private static Map<String, Descriptor> init() {
		Map<String, Descriptor> result = new HashMap<String, Descriptor>();
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(Activator.PLUGIN_ID, EXT_ID);
		for (IConfigurationElement e : elements) {
			String pluginId = e.getContributor().getName();
			String path = e.getAttribute("path");
			ImageDescriptor createFromURL = ImageDescriptor.createFromURL(Platform.getBundle(pluginId).getEntry(path));
			String id = pluginId + path;
			JFaceResources.getImageRegistry().put(id, createFromURL);
			Descriptor d = new Descriptor();
			d.id = id;
			result.put(id, d);
		}
		return result;
	}

	public static class Descriptor {
		public String id;
	}
}
