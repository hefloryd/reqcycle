package org.polarsys.reqcycle.repository.connector.ui;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.polarsys.reqcycle.repository.connector.ui.wizard.pages.ISourceConstants;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.ScopeConf.Scope;
import org.polarsys.reqcycle.repository.data.types.IDataModel;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

public class PropertyUtils {
	static IDataModelManager modelManager = ZigguratInject.make(IDataModelManager.class);

	public static String SCOPE_ID_KEY = Activator.PLUGIN_ID + ".scope";
	public static String DATAMODEL_ID_KEY = Activator.PLUGIN_ID + ".dataModel.uri";

	public static Scope getScopeFromSource(RequirementSource source) {
		IDataModel datamodel = getDataModelFromSource(source);
		String scopeId = source.getProperty(SCOPE_ID_KEY);
		if (datamodel != null) {
			return modelManager.getScope(scopeId, datamodel);
		}
		return null;
	}

	public static String getURI(RequirementSource source) {
		String uri = source.getProperty(ISourceConstants.PROPERTY_URI);
		return uri;
	}

	public static IDataModel getDataModelFromSource(RequirementSource source) {
		String datamodelURI = source.getProperty(DATAMODEL_ID_KEY);
		return modelManager.getDataModelByURI(datamodelURI);
	}

	public static void setScopeInSource(RequirementSource source, Scope scope) {
		try {
			setDataModelInSource(source, source.getDataModelURI());
			source.setDefaultScope(scope);
			source.setProperty(SCOPE_ID_KEY, scope.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void setDataModelInSource(RequirementSource source, IDataModel model) {
		setDataModelInSource(source, model.getDataModelURI());
	}

	public static void setDataModelInSource(RequirementSource source, String uri) {
		try {
			source.setDataModelURI(uri);
			source.setProperty(DATAMODEL_ID_KEY, uri);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setEObjectsInSource(RequirementSource source, String key, List<EObject> eobjects) {
		XMIResource res = new XMIResourceImpl();
		res.getContents().addAll(eobjects);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try {
			res.save(new BufferedOutputStream(byteArrayOutputStream), Collections.emptyMap());
			String s = new String(byteArrayOutputStream.toByteArray());
			source.setProperty(key, s);
			byteArrayOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<EObject> getEObjectsInSource(RequirementSource source, String key) {
		XMIResource res = new XMIResourceImpl();
		try {
			BufferedInputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(source.getProperty(key).getBytes()));
			res.load(inputStream, Collections.emptyMap());
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res.getContents();
	}

	public static String getMultiString(Iterable<String> strings) {
		return Joiner.on("||").join(strings);
	}

	public static List<String> getStrings(String string) {
		return Splitter.on("||").splitToList(string);
	}

}
