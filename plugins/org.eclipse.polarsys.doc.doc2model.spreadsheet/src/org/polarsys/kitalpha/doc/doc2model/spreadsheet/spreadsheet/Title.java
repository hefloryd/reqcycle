/**
 */
package org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet;

import org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Title</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Title#getHiearchy <em>Hiearchy</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetPackage#getTitle()
 * @model
 * @generated
 */
public interface Title extends ContentElement {
	/**
	 * Returns the value of the '<em><b>Hiearchy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hiearchy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hiearchy</em>' attribute.
	 * @see #setHiearchy(String)
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetPackage#getTitle_Hiearchy()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getHiearchy();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Title#getHiearchy <em>Hiearchy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hiearchy</em>' attribute.
	 * @see #getHiearchy()
	 * @generated
	 */
	void setHiearchy(String value);

} // Title
