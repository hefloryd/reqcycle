/**
 * Copyright (c) 2014 AtoS
 *     All rights reserved. This program and the accompanying materials
 *     are made available under the terms of the Eclipse Public License v1.0
 *     which accompanies this distribution, and is available at
 *     http://www.eclipse.org/legal/epl-v10.html *
 *     Contributors:
 *       Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.styling.model.Styling.impl;

import java.lang.reflect.InvocationTargetException;
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
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.TextStyle;
import org.polarsys.reqcycle.styling.model.Styling.CaseStyle;
import org.polarsys.reqcycle.styling.model.Styling.FontOption;
import org.polarsys.reqcycle.styling.model.Styling.Icon;
import org.polarsys.reqcycle.styling.model.Styling.Segment;
import org.polarsys.reqcycle.styling.model.Styling.StylingPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Case Style</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.polarsys.reqcycle.styling.model.Styling.impl.CaseStyleImpl#getSegments <em>Segments</em>}</li>
 * <li>{@link org.polarsys.reqcycle.styling.model.Styling.impl.CaseStyleImpl#getIcon <em>Icon</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CaseStyleImpl extends MinimalEObjectImpl.Container implements CaseStyle {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2014 AtoS\r\n    All rights reserved. This program and the accompanying materials\r\n    are made available under the terms of the Eclipse Public License v1.0\r\n    which accompanies this distribution, and is available at\r\n    http://www.eclipse.org/legal/epl-v10.html *\r\n    Contributors:\r\n      Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation";

	/**
	 * The cached value of the '{@link #getSegments() <em>Segments</em>}' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSegments()
	 * @generated
	 * @ordered
	 */
	protected EList<Segment> segments;

	/**
	 * The cached value of the '{@link #getIcon() <em>Icon</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected Icon icon;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CaseStyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StylingPackage.Literals.CASE_STYLE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Segment> getSegments() {
		if (segments == null) {
			segments = new EObjectContainmentEList<Segment>(Segment.class, this, StylingPackage.CASE_STYLE__SEGMENTS);
		}
		return segments;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Icon getIcon() {
		return icon;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetIcon(Icon newIcon, NotificationChain msgs) {
		Icon oldIcon = icon;
		icon = newIcon;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StylingPackage.CASE_STYLE__ICON, oldIcon, newIcon);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIcon(Icon newIcon) {
		if (newIcon != icon) {
			NotificationChain msgs = null;
			if (icon != null)
				msgs = ((InternalEObject) icon).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StylingPackage.CASE_STYLE__ICON, null, msgs);
			if (newIcon != null)
				msgs = ((InternalEObject) newIcon).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StylingPackage.CASE_STYLE__ICON, null, msgs);
			msgs = basicSetIcon(newIcon, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StylingPackage.CASE_STYLE__ICON, newIcon, newIcon));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	public StyledString getStyledString(Object object) {
		int pos = 0;

		StyledString result = new StyledString();

		EList<Segment> segmentList = getSegments();
		for (int i = 0; i < segmentList.size(); i++) {
			final Segment segment = segmentList.get(i);

			String newString = "";
			newString = segment.getPattern().getPatternValue(object);
			result.append(newString);

			TextStyle textStyle = new TextStyle();
			String fontRegistryName = "Segoe UI + N";
			if (segment.getStyle().getAppliedFonts().contains(FontOption.BOLD)) {
				fontRegistryName += "B";
			}
			if (segment.getStyle().getAppliedFonts().contains(FontOption.ITALIC)) {
				fontRegistryName += "I";
			}

			final Font font = JFaceResources.getFontRegistry().get(fontRegistryName);
			textStyle.font = font;

			Styler styler;
			styler = new Styler() {
				public void applyStyles(TextStyle textStyle) {
					textStyle.font = font;

					if (segment.getStyle().getAppliedFonts().contains(FontOption.UNDERLINE)) {
						textStyle.underline = true;
					}
					if (segment.getStyle().getAppliedFonts().contains(FontOption.STRIKE)) {
						textStyle.strikeout = true;
					}

					Color textColor = segment.getColor();
					textStyle.foreground = textColor;
				}
			};
			result.setStyle(pos, newString.length(), styler);

			pos += newString.length();
		}

		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Image getImage() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case StylingPackage.CASE_STYLE__SEGMENTS:
			return ((InternalEList<?>) getSegments()).basicRemove(otherEnd, msgs);
		case StylingPackage.CASE_STYLE__ICON:
			return basicSetIcon(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case StylingPackage.CASE_STYLE__SEGMENTS:
			return getSegments();
		case StylingPackage.CASE_STYLE__ICON:
			return getIcon();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case StylingPackage.CASE_STYLE__SEGMENTS:
			getSegments().clear();
			getSegments().addAll((Collection<? extends Segment>) newValue);
			return;
		case StylingPackage.CASE_STYLE__ICON:
			setIcon((Icon) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case StylingPackage.CASE_STYLE__SEGMENTS:
			getSegments().clear();
			return;
		case StylingPackage.CASE_STYLE__ICON:
			setIcon((Icon) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case StylingPackage.CASE_STYLE__SEGMENTS:
			return segments != null && !segments.isEmpty();
		case StylingPackage.CASE_STYLE__ICON:
			return icon != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case StylingPackage.CASE_STYLE___GET_STYLED_STRING__OBJECT:
			return getStyledString(arguments.get(0));
		case StylingPackage.CASE_STYLE___GET_IMAGE:
			return getImage();
		}
		return super.eInvoke(operationID, arguments);
	}

} // CaseStyleImpl
