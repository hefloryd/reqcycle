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

import org.eclipse.emf.edit.provider.ReflectiveItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;

public class ItemAdapterFactory extends ReflectiveItemProviderAdapterFactory {
	
	BasicStylingLabelProvider lp = new BasicStylingLabelProvider();
	
	public ItemAdapterFactory() {
		super();
		reflectiveItemProviderAdapter = new ReflectiveItemProvider(this){
			@Override
			public Object getImage(Object object) {
				return lp.getImage(object);
			}
			
			@Override
			public String getText(Object object) {
				return lp.getText(object);
			}
		};
	}
	
}
