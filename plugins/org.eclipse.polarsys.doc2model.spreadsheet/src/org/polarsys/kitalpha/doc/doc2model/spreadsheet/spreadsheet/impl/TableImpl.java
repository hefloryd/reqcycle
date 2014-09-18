/**
 */
package org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Header;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Point;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Row;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.SpreadsheetPackage;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Table;
import org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.Title;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.TableImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.TableImpl#getHeader <em>Header</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.TableImpl#getRow <em>Row</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.TableImpl#getNbRows <em>Nb Rows</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.TableImpl#getNbColumns <em>Nb Columns</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.spreadsheet.spreadsheet.impl.TableImpl#getTablePos <em>Table Pos</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TableImpl extends MinimalEObjectImpl.Container implements Table {
	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected EList<Title> title;

	/**
	 * The cached value of the '{@link #getHeader() <em>Header</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected EList<Header> header;

	/**
	 * The cached value of the '{@link #getRow() <em>Row</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRow()
	 * @generated
	 * @ordered
	 */
	protected EList<Row> row;

	/**
	 * The default value of the '{@link #getNbRows() <em>Nb Rows</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbRows()
	 * @generated
	 * @ordered
	 */
	protected static final int NB_ROWS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNbRows() <em>Nb Rows</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbRows()
	 * @generated
	 * @ordered
	 */
	protected int nbRows = NB_ROWS_EDEFAULT;

	/**
	 * The default value of the '{@link #getNbColumns() <em>Nb Columns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbColumns()
	 * @generated
	 * @ordered
	 */
	protected static final int NB_COLUMNS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNbColumns() <em>Nb Columns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbColumns()
	 * @generated
	 * @ordered
	 */
	protected int nbColumns = NB_COLUMNS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTablePos() <em>Table Pos</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTablePos()
	 * @generated
	 * @ordered
	 */
	protected Point tablePos;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpreadsheetPackage.Literals.TABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Title> getTitle() {
		if (title == null) {
			title = new EObjectContainmentEList<Title>(Title.class, this, SpreadsheetPackage.TABLE__TITLE);
		}
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Header> getHeader() {
		if (header == null) {
			header = new EObjectContainmentEList<Header>(Header.class, this, SpreadsheetPackage.TABLE__HEADER);
		}
		return header;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Row> getRow() {
		if (row == null) {
			row = new EObjectContainmentEList<Row>(Row.class, this, SpreadsheetPackage.TABLE__ROW);
		}
		return row;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNbRows() {
		return nbRows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbRows(int newNbRows) {
		int oldNbRows = nbRows;
		nbRows = newNbRows;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpreadsheetPackage.TABLE__NB_ROWS, oldNbRows, nbRows));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNbColumns() {
		return nbColumns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbColumns(int newNbColumns) {
		int oldNbColumns = nbColumns;
		nbColumns = newNbColumns;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpreadsheetPackage.TABLE__NB_COLUMNS, oldNbColumns, nbColumns));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point getTablePos() {
		if (tablePos != null && tablePos.eIsProxy()) {
			InternalEObject oldTablePos = (InternalEObject)tablePos;
			tablePos = (Point)eResolveProxy(oldTablePos);
			if (tablePos != oldTablePos) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpreadsheetPackage.TABLE__TABLE_POS, oldTablePos, tablePos));
			}
		}
		return tablePos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point basicGetTablePos() {
		return tablePos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTablePos(Point newTablePos) {
		Point oldTablePos = tablePos;
		tablePos = newTablePos;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SpreadsheetPackage.TABLE__TABLE_POS, oldTablePos, tablePos));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SpreadsheetPackage.TABLE__TITLE:
				return ((InternalEList<?>)getTitle()).basicRemove(otherEnd, msgs);
			case SpreadsheetPackage.TABLE__HEADER:
				return ((InternalEList<?>)getHeader()).basicRemove(otherEnd, msgs);
			case SpreadsheetPackage.TABLE__ROW:
				return ((InternalEList<?>)getRow()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SpreadsheetPackage.TABLE__TITLE:
				return getTitle();
			case SpreadsheetPackage.TABLE__HEADER:
				return getHeader();
			case SpreadsheetPackage.TABLE__ROW:
				return getRow();
			case SpreadsheetPackage.TABLE__NB_ROWS:
				return getNbRows();
			case SpreadsheetPackage.TABLE__NB_COLUMNS:
				return getNbColumns();
			case SpreadsheetPackage.TABLE__TABLE_POS:
				if (resolve) return getTablePos();
				return basicGetTablePos();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SpreadsheetPackage.TABLE__TITLE:
				getTitle().clear();
				getTitle().addAll((Collection<? extends Title>)newValue);
				return;
			case SpreadsheetPackage.TABLE__HEADER:
				getHeader().clear();
				getHeader().addAll((Collection<? extends Header>)newValue);
				return;
			case SpreadsheetPackage.TABLE__ROW:
				getRow().clear();
				getRow().addAll((Collection<? extends Row>)newValue);
				return;
			case SpreadsheetPackage.TABLE__NB_ROWS:
				setNbRows((Integer)newValue);
				return;
			case SpreadsheetPackage.TABLE__NB_COLUMNS:
				setNbColumns((Integer)newValue);
				return;
			case SpreadsheetPackage.TABLE__TABLE_POS:
				setTablePos((Point)newValue);
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
			case SpreadsheetPackage.TABLE__TITLE:
				getTitle().clear();
				return;
			case SpreadsheetPackage.TABLE__HEADER:
				getHeader().clear();
				return;
			case SpreadsheetPackage.TABLE__ROW:
				getRow().clear();
				return;
			case SpreadsheetPackage.TABLE__NB_ROWS:
				setNbRows(NB_ROWS_EDEFAULT);
				return;
			case SpreadsheetPackage.TABLE__NB_COLUMNS:
				setNbColumns(NB_COLUMNS_EDEFAULT);
				return;
			case SpreadsheetPackage.TABLE__TABLE_POS:
				setTablePos((Point)null);
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
			case SpreadsheetPackage.TABLE__TITLE:
				return title != null && !title.isEmpty();
			case SpreadsheetPackage.TABLE__HEADER:
				return header != null && !header.isEmpty();
			case SpreadsheetPackage.TABLE__ROW:
				return row != null && !row.isEmpty();
			case SpreadsheetPackage.TABLE__NB_ROWS:
				return nbRows != NB_ROWS_EDEFAULT;
			case SpreadsheetPackage.TABLE__NB_COLUMNS:
				return nbColumns != NB_COLUMNS_EDEFAULT;
			case SpreadsheetPackage.TABLE__TABLE_POS:
				return tablePos != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (nbRows: ");
		result.append(nbRows);
		result.append(", nbColumns: ");
		result.append(nbColumns);
		result.append(')');
		return result.toString();
	}

} //TableImpl
