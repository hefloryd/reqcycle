package org.polarsys.kitalpha.doc.doc2model.tikaParsingFacility;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.apache.tika.config.TikaConfig;
import org.apache.tika.detect.Detector;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.polarsys.kitalpha.doc.doc2model.core.IContentHandler;
import org.polarsys.kitalpha.doc.doc2model.core.IParsingFacility;
import org.polarsys.kitalpha.doc.doc2model.core.ModelContentHandler;
import org.xml.sax.SAXException;

import com.google.common.collect.Sets;


public class TikaParsingFacility implements IParsingFacility {

	static Set<ITikaParser> parsers = loadParsers();
	
	public TikaParsingFacility() {
		// TODO Auto-generated constructor stub
	}

	private static Set<ITikaParser> loadParsers() {
		Set<ITikaParser> result = Sets.newHashSet();
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(Activator.PLUGIN_ID, "tikaParser");
		for (IConfigurationElement conf : elements){
			try {
				ITikaParser p = (ITikaParser) conf.createExecutableExtension("instance");
				result.add(p);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public String getFileType(String filePath) {

		MediaType mediaType = MediaType.TEXT_PLAIN;

		try {
			InputStream content = new FileInputStream(new File(filePath));
			TikaConfig config = TikaConfig.getDefaultConfig();
			Detector detector = config.getDetector();
			TikaInputStream stream = TikaInputStream.get(content);
			Metadata metadata = new Metadata();
			mediaType = detector.detect(stream, metadata);
			return mediaType.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		// TODO Auto-generated method stub
		return "";
	}
	
	/**
	 * TODO
	 * @param stream
	 * @param handler
	 * @return
	 */
	public <T> T transform(InputStream content, IContentHandler<T> handler, String fileType) {
		Metadata metadata = new Metadata();
		ParseContext context = new ParseContext();
		Parser parser = getParser(fileType);
		ModelContentHandler<T> contentHandler = handler.getContentHandler();
		try {
			parser.parse(content,contentHandler,metadata,context);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (TikaException e) {
			e.printStackTrace();
		} finally {
			try {
				content.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return contentHandler.getResult();
	}
	
	
	protected Parser getParser(String fileType) {
		for (ITikaParser p : parsers){
			if (p.handles(fileType)){
				return p.getParser();
			}
		}
		return null;
	}

	@Override
	public <T> T transform(String filePath, IContentHandler<T> handler) {
		InputStream content;
		try {
			content = new FileInputStream(new File(filePath));
			return transform(content, handler, getFileType(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}


}
