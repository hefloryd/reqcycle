/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.utils.configuration;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * An adapter factory which forbids the editin in property view 
 *
 */
public class ReadOnlyAdapterFactory extends ComposedAdapterFactory {
	public ReadOnlyAdapterFactory(Registry registry) {
		super(registry);
	}
	
	@Override
	protected Adapter adapt(Notifier target, Object type, boolean isNew) {
		if (IItemPropertySource.class == type){
			Adapter result = super.adapt(target, type,isNew);
			if (result instanceof IItemPropertySource) {
				IItemPropertySource source = (IItemPropertySource) result;
				return new ROPropertySource(source);
			}
		}
		return super.adapt(target, type, isNew);
	}
	
	
	private static class ROPropertySource implements IItemPropertySource, Adapter{
		IItemPropertySource delegate = null;
		public ROPropertySource(IItemPropertySource source) {
			this.delegate = source;
		}

		public List<IItemPropertyDescriptor> getPropertyDescriptors(
				Object object) {
			List<IItemPropertyDescriptor> result = delegate.getPropertyDescriptors(object);
			return Lists.newArrayList(Iterables.transform(result, new Function<IItemPropertyDescriptor, IItemPropertyDescriptor>() {
				@Override
				public IItemPropertyDescriptor apply(
						IItemPropertyDescriptor arg0) {
					return new ROPropertyDescriptor(arg0);
				}
			})); 
		}

		public IItemPropertyDescriptor getPropertyDescriptor(Object object,
				Object propertyID) {
			return new ROPropertyDescriptor(delegate.getPropertyDescriptor(object, propertyID));
		}

		public Object getEditableValue(Object object) {
			return delegate.getEditableValue(object);
		}

		@Override
		public void notifyChanged(Notification notification) {
			if (delegate instanceof Adapter) {
				Adapter adapter = (Adapter) delegate;
				adapter.notifyChanged(notification);
			}
		}

		@Override
		public Notifier getTarget() {
			if (delegate instanceof Adapter) {
				Adapter adapter = (Adapter) delegate;
				adapter.getTarget();
			}
			return null;
		}

		@Override
		public void setTarget(Notifier newTarget) {
			if (delegate instanceof Adapter) {
				Adapter adapter = (Adapter) delegate;
				adapter.setTarget(newTarget);
			}
			
		}

		@Override
		public boolean isAdapterForType(Object type) {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
	
	private static class ROPropertyDescriptor implements IItemPropertyDescriptor{
		IItemPropertyDescriptor delegate = null;
		public ROPropertyDescriptor(IItemPropertyDescriptor desc) {
			this.delegate = desc;
		}

		public Object getPropertyValue(Object object) {
			return delegate.getPropertyValue(object);
		}

		public boolean isPropertySet(Object object) {
			return delegate.isPropertySet(object);
		}

		public boolean canSetProperty(Object object) {
			return false;
		}

		public void resetPropertyValue(Object object) {
			delegate.resetPropertyValue(object);
		}

		public void setPropertyValue(Object object, Object value) {
			delegate.setPropertyValue(object, value);
		}

		public String getCategory(Object object) {
			return delegate.getCategory(object);
		}

		public String getDescription(Object object) {
			return delegate.getDescription(object);
		}

		public String getDisplayName(Object object) {
			return delegate.getDisplayName(object);
		}

		public String[] getFilterFlags(Object object) {
			return delegate.getFilterFlags(object);
		}

		public Object getHelpContextIds(Object object) {
			return delegate.getHelpContextIds(object);
		}

		public String getId(Object object) {
			return delegate.getId(object);
		}

		public IItemLabelProvider getLabelProvider(Object object) {
			return delegate.getLabelProvider(object);
		}

		public boolean isCompatibleWith(Object object, Object anotherObject,
				IItemPropertyDescriptor anotherPropertyDescriptor) {
			return delegate.isCompatibleWith(object, anotherObject,
					anotherPropertyDescriptor);
		}

		public Object getFeature(Object object) {
			return delegate.getFeature(object);
		}

		public boolean isMany(Object object) {
			return delegate.isMany(object);
		}

		public Collection<?> getChoiceOfValues(Object object) {
			return delegate.getChoiceOfValues(object);
		}

		public boolean isMultiLine(Object object) {
			return delegate.isMultiLine(object);
		}

		public boolean isSortChoices(Object object) {
			return delegate.isSortChoices(object);
		}

		
		
	}
}
