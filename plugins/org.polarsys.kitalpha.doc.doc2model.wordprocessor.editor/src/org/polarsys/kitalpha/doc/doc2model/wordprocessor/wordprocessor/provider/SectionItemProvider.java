/**
 */
package org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorFactory;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WordprocessorPackage;

/**
 * This is the item provider adapter for a {@link org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.Section} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SectionItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SectionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addHiearchyPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Hiearchy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHiearchyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Section_hiearchy_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Section_hiearchy_feature", "_UI_Section_type"),
				 WordprocessorPackage.Literals.SECTION__HIEARCHY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(WordprocessorPackage.Literals.SECTION__TITLE);
			childrenFeatures.add(WordprocessorPackage.Literals.SECTION__IMAGE);
			childrenFeatures.add(WordprocessorPackage.Literals.SECTION__TABLE);
			childrenFeatures.add(WordprocessorPackage.Literals.SECTION__PARAGRAPH);
			childrenFeatures.add(WordprocessorPackage.Literals.SECTION__CONTENTS);
			childrenFeatures.add(WordprocessorPackage.Literals.SECTION__SECTIONS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Section.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Section"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Section)object).getHiearchy();
		return label == null || label.length() == 0 ?
			getString("_UI_Section_type") :
			getString("_UI_Section_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Section.class)) {
			case WordprocessorPackage.SECTION__HIEARCHY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case WordprocessorPackage.SECTION__TITLE:
			case WordprocessorPackage.SECTION__IMAGE:
			case WordprocessorPackage.SECTION__TABLE:
			case WordprocessorPackage.SECTION__PARAGRAPH:
			case WordprocessorPackage.SECTION__CONTENTS:
			case WordprocessorPackage.SECTION__SECTIONS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(WordprocessorPackage.Literals.SECTION__TITLE,
				 WordprocessorFactory.eINSTANCE.createTitle()));

		newChildDescriptors.add
			(createChildParameter
				(WordprocessorPackage.Literals.SECTION__IMAGE,
				 WordprocessorFactory.eINSTANCE.createImage()));

		newChildDescriptors.add
			(createChildParameter
				(WordprocessorPackage.Literals.SECTION__TABLE,
				 WordprocessorFactory.eINSTANCE.createTable()));

		newChildDescriptors.add
			(createChildParameter
				(WordprocessorPackage.Literals.SECTION__PARAGRAPH,
				 WordprocessorFactory.eINSTANCE.createStringChunk()));

		newChildDescriptors.add
			(createChildParameter
				(WordprocessorPackage.Literals.SECTION__CONTENTS,
				 WordprocessorFactory.eINSTANCE.createImage()));

		newChildDescriptors.add
			(createChildParameter
				(WordprocessorPackage.Literals.SECTION__CONTENTS,
				 WordprocessorFactory.eINSTANCE.createTable()));

		newChildDescriptors.add
			(createChildParameter
				(WordprocessorPackage.Literals.SECTION__CONTENTS,
				 WordprocessorFactory.eINSTANCE.createParagraph()));

		newChildDescriptors.add
			(createChildParameter
				(WordprocessorPackage.Literals.SECTION__SECTIONS,
				 WordprocessorFactory.eINSTANCE.createSection()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == WordprocessorPackage.Literals.SECTION__IMAGE ||
			childFeature == WordprocessorPackage.Literals.SECTION__CONTENTS ||
			childFeature == WordprocessorPackage.Literals.SECTION__TABLE;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return WpEditorPlugin.INSTANCE;
	}

}
