/**
 */
package org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor;

import org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Chunk</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.StringChunk#getTitle <em>Title</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorPackage#getStringChunk()
 * @model
 * @generated
 */
public interface StringChunk extends ContentElement {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' containment reference.
	 * @see #setTitle(Title)
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorPackage#getStringChunk_Title()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Title getTitle();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.StringChunk#getTitle <em>Title</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' containment reference.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(Title value);

} // StringChunk
