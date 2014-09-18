/**
 */
package org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Text#getTitle <em>Title</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Text#getTextContent <em>Text Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetPackage#getText()
 * @model
 * @generated
 */
public interface Text extends EObject {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' reference.
	 * @see #setTitle(Title)
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetPackage#getText_Title()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Title getTitle();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Text#getTitle <em>Title</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' reference.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(Title value);

	/**
	 * Returns the value of the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Content</em>' attribute.
	 * @see #setTextContent(String)
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetPackage#getText_TextContent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getTextContent();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Text#getTextContent <em>Text Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Content</em>' attribute.
	 * @see #getTextContent()
	 * @generated
	 */
	void setTextContent(String value);

} // Text
