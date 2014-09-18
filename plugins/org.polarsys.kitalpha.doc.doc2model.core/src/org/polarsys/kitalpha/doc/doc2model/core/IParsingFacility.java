package org.polarsys.kitalpha.doc.doc2model.core;




public interface IParsingFacility {
	
	public <T> T transform(String filePath, IContentHandler<T> handler);

	/**
	 * @param fileString
	 * @return an empty String if no file type found
	 */
	public String getFileType(String fileString);
}
