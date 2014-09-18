/**
 */
package org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor;

import org.eclipse.emf.common.util.EList;
import org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Paragraph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Paragraph#getChunks <em>Chunks</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorPackage#getParagraph()
 * @model
 * @generated
 */
public interface Paragraph extends ContentElement, SectionContents {
	/**
	 * Returns the value of the '<em><b>Chunks</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.StringChunk}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chunks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chunks</em>' containment reference list.
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorPackage#getParagraph_Chunks()
	 * @model containment="true"
	 * @generated
	 */
	EList<StringChunk> getChunks();

} // Paragraph
