/**
 */
package org.polarsys.reqcycle.predicates.ui.providers;

import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.polarsys.reqcycle.predicates.core.PredicatesFactory;
import org.polarsys.reqcycle.predicates.core.PredicatesPackage;
import org.polarsys.reqcycle.predicates.core.api.OperationPredicate;

/**
 * This is the item provider adapter for a {@link org.polarsys.reqcycle.predicates.core.api.OperationPredicate} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class OperationPredicateItemProvider extends IPredicateContainerItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OperationPredicateItemProvider(AdapterFactory adapterFactory) {
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

			addOperationNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Operation Name feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOperationNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OperationPredicate_operationName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_OperationPredicate_operationName_feature", "_UI_OperationPredicate_type"),
				 PredicatesPackage.Literals.OPERATION_PREDICATE__OPERATION_NAME,
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
			childrenFeatures.add(PredicatesPackage.Literals.OPERATION_PREDICATE__PARAMETERS);
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
	 * This returns OperationPredicate.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/OperationPredicate"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((OperationPredicate)object).getDisplayName();
		return label == null || label.length() == 0 ?
			getString("_UI_OperationPredicate_type") :
			getString("_UI_OperationPredicate_type") + " " + label;
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

		switch (notification.getFeatureID(OperationPredicate.class)) {
			case PredicatesPackage.OPERATION_PREDICATE__OPERATION_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case PredicatesPackage.OPERATION_PREDICATE__PARAMETERS:
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
				(PredicatesPackage.Literals.OPERATION_PREDICATE__PARAMETERS,
				 PredicatesFactory.eINSTANCE.createIntParameter()));

		newChildDescriptors.add
			(createChildParameter
				(PredicatesPackage.Literals.OPERATION_PREDICATE__PARAMETERS,
				 PredicatesFactory.eINSTANCE.createBooleanParameter()));

		newChildDescriptors.add
			(createChildParameter
				(PredicatesPackage.Literals.OPERATION_PREDICATE__PARAMETERS,
				 PredicatesFactory.eINSTANCE.createStringParameter()));

		newChildDescriptors.add
			(createChildParameter
				(PredicatesPackage.Literals.OPERATION_PREDICATE__PARAMETERS,
				 PredicatesFactory.eINSTANCE.createEObjectParameter()));
	}

}
