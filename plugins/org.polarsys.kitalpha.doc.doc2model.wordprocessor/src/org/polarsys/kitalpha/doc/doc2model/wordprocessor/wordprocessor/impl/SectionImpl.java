/**
 */
package org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Image;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.SectionContents;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.StringChunk;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Table;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Title;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Section</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.SectionImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.SectionImpl#getImage <em>Image</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.SectionImpl#getTable <em>Table</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.SectionImpl#getParagraph <em>Paragraph</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.SectionImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.SectionImpl#getHiearchy <em>Hiearchy</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.SectionImpl#getSections <em>Sections</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.impl.SectionImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SectionImpl extends MinimalEObjectImpl.Container implements Section {
	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected Title title;

	/**
	 * The cached value of the '{@link #getImage() <em>Image</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected EList<Image> image;

	/**
	 * The cached value of the '{@link #getTable() <em>Table</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTable()
	 * @generated
	 * @ordered
	 */
	protected EList<Table> table;

	/**
	 * The cached value of the '{@link #getParagraph() <em>Paragraph</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParagraph()
	 * @generated
	 * @ordered
	 */
	protected EList<StringChunk> paragraph;

	/**
	 * The cached value of the '{@link #getContents() <em>Contents</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContents()
	 * @generated
	 * @ordered
	 */
	protected EList<SectionContents> contents;

	/**
	 * The default value of the '{@link #getHiearchy() <em>Hiearchy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHiearchy()
	 * @generated
	 * @ordered
	 */
	protected static final String HIEARCHY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHiearchy() <em>Hiearchy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHiearchy()
	 * @generated
	 * @ordered
	 */
	protected String hiearchy = HIEARCHY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSections() <em>Sections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSections()
	 * @generated
	 * @ordered
	 */
	protected EList<Section> sections;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WordprocessorPackage.Literals.SECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Title getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTitle(Title newTitle, NotificationChain msgs) {
		Title oldTitle = title;
		title = newTitle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WordprocessorPackage.SECTION__TITLE, oldTitle, newTitle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(Title newTitle) {
		if (newTitle != title) {
			NotificationChain msgs = null;
			if (title != null)
				msgs = ((InternalEObject)title).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WordprocessorPackage.SECTION__TITLE, null, msgs);
			if (newTitle != null)
				msgs = ((InternalEObject)newTitle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WordprocessorPackage.SECTION__TITLE, null, msgs);
			msgs = basicSetTitle(newTitle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WordprocessorPackage.SECTION__TITLE, newTitle, newTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Image> getImage() {
		if (image == null) {
			image = new EObjectContainmentEList<Image>(Image.class, this, WordprocessorPackage.SECTION__IMAGE);
		}
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Table> getTable() {
		if (table == null) {
			table = new EObjectContainmentEList<Table>(Table.class, this, WordprocessorPackage.SECTION__TABLE);
		}
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StringChunk> getParagraph() {
		if (paragraph == null) {
			paragraph = new EObjectContainmentEList<StringChunk>(StringChunk.class, this, WordprocessorPackage.SECTION__PARAGRAPH);
		}
		return paragraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SectionContents> getContents() {
		if (contents == null) {
			contents = new EObjectContainmentEList<SectionContents>(SectionContents.class, this, WordprocessorPackage.SECTION__CONTENTS);
		}
		return contents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHiearchy() {
		return hiearchy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHiearchy(String newHiearchy) {
		String oldHiearchy = hiearchy;
		hiearchy = newHiearchy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WordprocessorPackage.SECTION__HIEARCHY, oldHiearchy, hiearchy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Section> getSections() {
		if (sections == null) {
			sections = new EObjectContainmentWithInverseEList<Section>(Section.class, this, WordprocessorPackage.SECTION__SECTIONS, WordprocessorPackage.SECTION__PARENT);
		}
		return sections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Section getParent() {
		if (eContainerFeatureID() != WordprocessorPackage.SECTION__PARENT) return null;
		return (Section)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(Section newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, WordprocessorPackage.SECTION__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(Section newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != WordprocessorPackage.SECTION__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, WordprocessorPackage.SECTION__SECTIONS, Section.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WordprocessorPackage.SECTION__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WordprocessorPackage.SECTION__SECTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSections()).basicAdd(otherEnd, msgs);
			case WordprocessorPackage.SECTION__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((Section)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WordprocessorPackage.SECTION__TITLE:
				return basicSetTitle(null, msgs);
			case WordprocessorPackage.SECTION__IMAGE:
				return ((InternalEList<?>)getImage()).basicRemove(otherEnd, msgs);
			case WordprocessorPackage.SECTION__TABLE:
				return ((InternalEList<?>)getTable()).basicRemove(otherEnd, msgs);
			case WordprocessorPackage.SECTION__PARAGRAPH:
				return ((InternalEList<?>)getParagraph()).basicRemove(otherEnd, msgs);
			case WordprocessorPackage.SECTION__CONTENTS:
				return ((InternalEList<?>)getContents()).basicRemove(otherEnd, msgs);
			case WordprocessorPackage.SECTION__SECTIONS:
				return ((InternalEList<?>)getSections()).basicRemove(otherEnd, msgs);
			case WordprocessorPackage.SECTION__PARENT:
				return basicSetParent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case WordprocessorPackage.SECTION__PARENT:
				return eInternalContainer().eInverseRemove(this, WordprocessorPackage.SECTION__SECTIONS, Section.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WordprocessorPackage.SECTION__TITLE:
				return getTitle();
			case WordprocessorPackage.SECTION__IMAGE:
				return getImage();
			case WordprocessorPackage.SECTION__TABLE:
				return getTable();
			case WordprocessorPackage.SECTION__PARAGRAPH:
				return getParagraph();
			case WordprocessorPackage.SECTION__CONTENTS:
				return getContents();
			case WordprocessorPackage.SECTION__HIEARCHY:
				return getHiearchy();
			case WordprocessorPackage.SECTION__SECTIONS:
				return getSections();
			case WordprocessorPackage.SECTION__PARENT:
				return getParent();
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
			case WordprocessorPackage.SECTION__TITLE:
				setTitle((Title)newValue);
				return;
			case WordprocessorPackage.SECTION__IMAGE:
				getImage().clear();
				getImage().addAll((Collection<? extends Image>)newValue);
				return;
			case WordprocessorPackage.SECTION__TABLE:
				getTable().clear();
				getTable().addAll((Collection<? extends Table>)newValue);
				return;
			case WordprocessorPackage.SECTION__PARAGRAPH:
				getParagraph().clear();
				getParagraph().addAll((Collection<? extends StringChunk>)newValue);
				return;
			case WordprocessorPackage.SECTION__CONTENTS:
				getContents().clear();
				getContents().addAll((Collection<? extends SectionContents>)newValue);
				return;
			case WordprocessorPackage.SECTION__HIEARCHY:
				setHiearchy((String)newValue);
				return;
			case WordprocessorPackage.SECTION__SECTIONS:
				getSections().clear();
				getSections().addAll((Collection<? extends Section>)newValue);
				return;
			case WordprocessorPackage.SECTION__PARENT:
				setParent((Section)newValue);
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
			case WordprocessorPackage.SECTION__TITLE:
				setTitle((Title)null);
				return;
			case WordprocessorPackage.SECTION__IMAGE:
				getImage().clear();
				return;
			case WordprocessorPackage.SECTION__TABLE:
				getTable().clear();
				return;
			case WordprocessorPackage.SECTION__PARAGRAPH:
				getParagraph().clear();
				return;
			case WordprocessorPackage.SECTION__CONTENTS:
				getContents().clear();
				return;
			case WordprocessorPackage.SECTION__HIEARCHY:
				setHiearchy(HIEARCHY_EDEFAULT);
				return;
			case WordprocessorPackage.SECTION__SECTIONS:
				getSections().clear();
				return;
			case WordprocessorPackage.SECTION__PARENT:
				setParent((Section)null);
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
			case WordprocessorPackage.SECTION__TITLE:
				return title != null;
			case WordprocessorPackage.SECTION__IMAGE:
				return image != null && !image.isEmpty();
			case WordprocessorPackage.SECTION__TABLE:
				return table != null && !table.isEmpty();
			case WordprocessorPackage.SECTION__PARAGRAPH:
				return paragraph != null && !paragraph.isEmpty();
			case WordprocessorPackage.SECTION__CONTENTS:
				return contents != null && !contents.isEmpty();
			case WordprocessorPackage.SECTION__HIEARCHY:
				return HIEARCHY_EDEFAULT == null ? hiearchy != null : !HIEARCHY_EDEFAULT.equals(hiearchy);
			case WordprocessorPackage.SECTION__SECTIONS:
				return sections != null && !sections.isEmpty();
			case WordprocessorPackage.SECTION__PARENT:
				return getParent() != null;
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
		result.append(" (hiearchy: ");
		result.append(hiearchy);
		result.append(')');
		return result.toString();
	}

} //SectionImpl
