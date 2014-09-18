/**
 */
package org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet;

import org.polarsys.kitalpha.doc.doc2model.common.Common.ContentElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cell</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Cell#getPosCell <em>Pos Cell</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetPackage#getCell()
 * @model
 * @generated
 */
public interface Cell extends ContentElement {
	/**
	 * Returns the value of the '<em><b>Pos Cell</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pos Cell</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pos Cell</em>' reference.
	 * @see #setPosCell(Point)
	 * @see org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetPackage#getCell_PosCell()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Point getPosCell();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Cell#getPosCell <em>Pos Cell</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pos Cell</em>' reference.
	 * @see #getPosCell()
	 * @generated
	 */
	void setPosCell(Point value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getColNumber();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getRowNumber();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Cell offset(int x, int y);

} // Cell
