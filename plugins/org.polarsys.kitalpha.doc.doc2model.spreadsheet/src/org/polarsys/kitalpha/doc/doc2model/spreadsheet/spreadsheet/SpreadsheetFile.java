/**
 */
package org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet;

import org.eclipse.emf.common.util.EList;

import org.polarsys.kitalpha.doc.doc2model.common.Common.DocumentModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetFile#getSheet <em>Sheet</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetFile#getNbSheet <em>Nb Sheet</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetPackage#getSpreadsheetFile()
 * @model
 * @generated
 */
public interface SpreadsheetFile extends DocumentModel {
	/**
	 * Returns the value of the '<em><b>Sheet</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Sheet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sheet</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sheet</em>' containment reference list.
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetPackage#getSpreadsheetFile_Sheet()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<Sheet> getSheet();

	/**
	 * Returns the value of the '<em><b>Nb Sheet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nb Sheet</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nb Sheet</em>' attribute.
	 * @see #setNbSheet(int)
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetPackage#getSpreadsheetFile_NbSheet()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getNbSheet();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetFile#getNbSheet <em>Nb Sheet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nb Sheet</em>' attribute.
	 * @see #getNbSheet()
	 * @generated
	 */
	void setNbSheet(int value);

} // SpreadsheetFile
