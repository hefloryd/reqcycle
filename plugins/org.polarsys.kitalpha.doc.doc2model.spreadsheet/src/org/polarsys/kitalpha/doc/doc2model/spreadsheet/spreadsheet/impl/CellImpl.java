/**
 */
package org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polarsys.kitalpha.doc.doc2model.common.Common.impl.ContentElementImpl;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Cell;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Point;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Row;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetPackage;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Table;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cell</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.CellImpl#getPosCell <em>Pos Cell</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CellImpl extends ContentElementImpl implements Cell {
	/**
	 * The cached value of the '{@link #getPosCell() <em>Pos Cell</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosCell()
	 * @generated
	 * @ordered
	 */
	protected Point posCell;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CellImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpreadsheetPackage.Literals.CELL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point getPosCell() {
		if (posCell != null && posCell.eIsProxy()) {
			InternalEObject oldPosCell = (InternalEObject)posCell;
			posCell = (Point)eResolveProxy(oldPosCell);
			if (posCell != oldPosCell) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpreadsheetPackage.CELL__POS_CELL, oldPosCell, posCell));
			}
		}
		return posCell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point basicGetPosCell() {
		return posCell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosCell(Point newPosCell) {
		Point oldPosCell = posCell;
		posCell = newPosCell;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpreadsheetPackage.CELL__POS_CELL, oldPosCell, posCell));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public int getColNumber() {
		if (eContainer() instanceof Row) {
			Row row = (Row) eContainer();
			return row.getCell().indexOf(this);
		}
		return -1 ;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public int getRowNumber() {
		if (eContainer() instanceof Row) {
			Row row = (Row) eContainer();
			if (row.eContainer() instanceof Table) {
				Table table = (Table) row.eContainer();
				return table.getRow().indexOf(row);
			}
		}
		return -1 ;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public Cell offset(int x, int y) {
		if (eContainer() instanceof Row) {
			Row row = (Row) eContainer();
			Table table = (Table) row.eContainer();
			int rowNb = getRowNumber();
			int rowOff = rowNb + x;
			if (rowOff >= 0){
				row = table.getRow().get(rowOff);
				int col = getColNumber();
				int colOff = col + y;
				if (colOff >= 0){
					return row.getCell().get(colOff);
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SpreadsheetPackage.CELL__POS_CELL:
				if (resolve) return getPosCell();
				return basicGetPosCell();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SpreadsheetPackage.CELL__POS_CELL:
				setPosCell((Point)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SpreadsheetPackage.CELL__POS_CELL:
				setPosCell((Point)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SpreadsheetPackage.CELL__POS_CELL:
				return posCell != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SpreadsheetPackage.CELL___GET_COL_NUMBER:
				return getColNumber();
			case SpreadsheetPackage.CELL___GET_ROW_NUMBER:
				return getRowNumber();
			case SpreadsheetPackage.CELL___OFFSET__INT_INT:
				return offset((Integer)arguments.get(0), (Integer)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //CellImpl
