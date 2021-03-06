/**
 */
package org.polarsys.reqcycle.predicates.ui.providers;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.polarsys.reqcycle.predicates.core.PredicatesFactory;
import org.polarsys.reqcycle.predicates.core.PredicatesPackage;

import org.polarsys.reqcycle.predicates.core.api.IPredicateContainer;

import org.polarsys.reqcycle.predicates.ui.PredicatesUIPlugin;

/**
 * This is the item provider adapter for a {@link org.polarsys.reqcycle.predicates.core.api.IPredicateContainer} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class IPredicateContainerItemProvider extends PredicatesItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, IItemColorProvider,
		IItemFontProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IPredicateContainerItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addDisplayNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Display Name feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDisplayNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IPredicate_displayName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IPredicate_displayName_feature", "_UI_IPredicate_type"),
				 PredicatesPackage.Literals.IPREDICATE__DISPLAY_NAME,
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(PredicatesPackage.Literals.IPREDICATE_CONTAINER__RESULT_PREDICATE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((IPredicateContainer)object).getDisplayName();
		return label == null || label.length() == 0 ?
			getString("_UI_IPredicateContainer_type") :
			getString("_UI_IPredicateContainer_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(IPredicateContainer.class)) {
			case PredicatesPackage.IPREDICATE_CONTAINER__DISPLAY_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case PredicatesPackage.IPREDICATE_CONTAINER__RESULT_PREDICATE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(PredicatesPackage.Literals.IPREDICATE_CONTAINER__RESULT_PREDICATE,
				 PredicatesFactory.eINSTANCE.createStringEqualPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(PredicatesPackage.Literals.IPREDICATE_CONTAINER__RESULT_PREDICATE,
				 PredicatesFactory.eINSTANCE.createDateEqualPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(PredicatesPackage.Literals.IPREDICATE_CONTAINER__RESULT_PREDICATE,
				 PredicatesFactory.eINSTANCE.createEnumEqualPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(PredicatesPackage.Literals.IPREDICATE_CONTAINER__RESULT_PREDICATE,
				 PredicatesFactory.eINSTANCE.createBooleanEqualPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(PredicatesPackage.Literals.IPREDICATE_CONTAINER__RESULT_PREDICATE,
				 PredicatesFactory.eINSTANCE.createContainsPatternPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(PredicatesPackage.Literals.IPREDICATE_CONTAINER__RESULT_PREDICATE,
				 PredicatesFactory.eINSTANCE.createStringIntoPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(PredicatesPackage.Literals.IPREDICATE_CONTAINER__RESULT_PREDICATE,
				 PredicatesFactory.eINSTANCE.createEnumIntoPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(PredicatesPackage.Literals.IPREDICATE_CONTAINER__RESULT_PREDICATE,
				 PredicatesFactory.eINSTANCE.createAndPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(PredicatesPackage.Literals.IPREDICATE_CONTAINER__RESULT_PREDICATE,
				 PredicatesFactory.eINSTANCE.createOrPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(PredicatesPackage.Literals.IPREDICATE_CONTAINER__RESULT_PREDICATE,
				 PredicatesFactory.eINSTANCE.createNotPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(PredicatesPackage.Literals.IPREDICATE_CONTAINER__RESULT_PREDICATE,
				 PredicatesFactory.eINSTANCE.createCompareNumberPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(PredicatesPackage.Literals.IPREDICATE_CONTAINER__RESULT_PREDICATE,
				 PredicatesFactory.eINSTANCE.createIEAttrPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(PredicatesPackage.Literals.IPREDICATE_CONTAINER__RESULT_PREDICATE,
				 PredicatesFactory.eINSTANCE.createTruePredicate()));

		newChildDescriptors.add
			(createChildParameter
				(PredicatesPackage.Literals.IPREDICATE_CONTAINER__RESULT_PREDICATE,
				 PredicatesFactory.eINSTANCE.createOperationPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(PredicatesPackage.Literals.IPREDICATE_CONTAINER__RESULT_PREDICATE,
				 PredicatesFactory.eINSTANCE.createIsTypeOfPredicate()));

		newChildDescriptors.add
			(createChildParameter
				(PredicatesPackage.Literals.IPREDICATE_CONTAINER__RESULT_PREDICATE,
				 PredicatesFactory.eINSTANCE.createIsNullPredicate()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return PredicatesUIPlugin.INSTANCE;
	}

}
