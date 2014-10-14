/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.polarsys.reqcycle.styling.ui.providers;

import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;

public class StylingRequirementItemProviderAdapterFactory extends ReflectiveItemProviderAdapterFactory {

	StylingLabelProvider labelP = new BasicStylingLabelProvider();

	@Override
	public Object adapt(Object object, Object type) {
		if (IItemLabelProvider.class.equals(type)) {
			return new IItemLabelProvider() {

				@Override
				public String getText(Object object) {
					return labelP.getText(object);
				}

				@Override
				public Object getImage(Object object) {
					return labelP.getImage(object);
				}
			};
		}

		return super.adapt(object, type);
	}

}
