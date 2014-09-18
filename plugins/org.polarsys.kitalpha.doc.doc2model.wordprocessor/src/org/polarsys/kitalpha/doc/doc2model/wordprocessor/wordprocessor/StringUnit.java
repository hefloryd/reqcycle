/**
 */
package org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor;

import org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.StringUnit#getTitle <em>Title</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.StringUnit#isIsBold <em>Is Bold</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorPackage#getStringUnit()
 * @model
 * @generated
 */
public interface StringUnit extends ContentElement, SectionContents {
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
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorPackage#getStringUnit_Title()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Title getTitle();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.StringUnit#getTitle <em>Title</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' containment reference.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(Title value);

	/**
	 * Returns the value of the '<em><b>Is Bold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Bold</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Bold</em>' attribute.
	 * @see #setIsBold(boolean)
	 * @see org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorPackage#getStringUnit_IsBold()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isIsBold();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.StringUnit#isIsBold <em>Is Bold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Bold</em>' attribute.
	 * @see #isIsBold()
	 * @generated
	 */
	void setIsBold(boolean value);

} // StringUnit
