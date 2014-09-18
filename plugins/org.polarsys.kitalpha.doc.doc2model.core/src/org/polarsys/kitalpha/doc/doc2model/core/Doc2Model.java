package org.polarsys.kitalpha.doc.doc2model.core;

import java.util.Collection;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.polarsys.kitalpha.doc.doc2model.common.Common.DocumentModel;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.Lists;

public class Doc2Model<T> {

	private IParsingFacility _parsingFacility = ZigguratInject.make(IParsingFacility.class);
	private IContentHandler<T> userHandler = null;
	private T documentModel;


	public Doc2Model<T> transform(String fileString, Class<T> theClass) {
		if (userHandler == null){
			userHandler = getContentHandler (fileString, theClass);
		}
		documentModel = (T) _parsingFacility.transform(fileString,userHandler);
		return this;
	}


	public Collection<IContentHandler<T>> getContentHandlers (String fileString, Class<T> theClass) {
		Collection<IContentHandler<T>> result = Lists.newArrayList();
		IConfigurationElement[] config = Platform.getExtensionRegistry().
				getConfigurationElementsFor(Activator.PLUGIN_ID,"IContentHandler");
		for (IConfigurationElement element : config) {
			Object o;
			try {
				o = ZigguratInject.make(Platform.getBundle(element.getContributor().getName()).loadClass(element.getAttribute("handler")));
				if(o instanceof org.polarsys.kitalpha.doc.doc2model.core.IContentHandler<?>){
					@SuppressWarnings("unchecked")
					IContentHandler<?> handler = (IContentHandler<?>) o;
					if (theClass == null || theClass.isAssignableFrom(handler.getDocumentClass())){
						result.add((IContentHandler<T>) handler) ;
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InvalidRegistryObjectException e) {
				e.printStackTrace();
			}

		}
		return result;
	}
	
	public IContentHandler<T> getContentHandler(String fileString, String classQualifiedName) {
		Collection<IContentHandler<T>> result = getContentHandlers(fileString, null);
		for (IContentHandler<T> h : result){
			if (h.getClass().getName().equals(classQualifiedName)){
				return h ;
			}
		}
		return null ;
	}
	
	private IContentHandler<T> getContentHandler(String fileString, Class<T> theClass) {
		Collection<IContentHandler<T>> result = getContentHandlers(fileString, theClass);
		if (result != null && result.size() > 0){
			return result.iterator().next();
		}
		return null ;
	}

	/**
	 * @param fileString
	 * @return an empty String if no file type found
	 */
	public String getFileType(String fileString) {
		return _parsingFacility.getFileType(fileString);
	}

	public Doc2Model<T> setContentHandler(IContentHandler<T> handler){
		this.userHandler = handler;
		return this;
	}

	public T getDocModel (){
		return (T) documentModel;
	}


	public static IContentHandler<DocumentModel> getDefaultContentHandler(
			String fileString) {
		return null;
	}


}
