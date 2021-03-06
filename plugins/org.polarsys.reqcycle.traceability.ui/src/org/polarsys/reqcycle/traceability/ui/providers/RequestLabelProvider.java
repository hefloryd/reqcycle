/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Tristan Faure (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
package org.polarsys.reqcycle.traceability.ui.providers;

import javax.inject.Inject;

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.polarsys.reqcycle.traceability.model.Link;
import org.polarsys.reqcycle.traceability.types.ITypesConfigurationProvider;
import org.polarsys.reqcycle.traceability.types.RelationUtils;
import org.polarsys.reqcycle.traceability.types.configuration.preferences.dialogs.IconRegistry;
import org.polarsys.reqcycle.traceability.types.configuration.typeconfiguration.Configuration;
import org.polarsys.reqcycle.traceability.types.configuration.typeconfiguration.Relation;
import org.polarsys.reqcycle.traceability.types.ui.IStylePredicateProvider;
import org.polarsys.reqcycle.traceability.ui.TraceabilityUtils;
import org.polarsys.reqcycle.uri.model.Reachable;

public class RequestLabelProvider extends LabelProvider implements IFontProvider, IColorProvider {

	@Inject
	IStylePredicateProvider provider;

	@Inject
	ITypesConfigurationProvider typeConfProvider;

	@Override
	public String getText(Object element) {
		if (element instanceof BusinessDeffered) {
			element = ((BusinessDeffered) element).getBusinessElement();
		}
		if (element instanceof Reachable) {
			Reachable reach = (Reachable) element;
			return TraceabilityUtils.getText(reach);
		} else if (element instanceof Link) {
			return ((Link) element).getLabel();
		}
		return super.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof BusinessDeffered) {
			element = ((BusinessDeffered) element).getBusinessElement();

			if (element instanceof Link) {
				Link link = (Link) element;
				Configuration config = typeConfProvider.getDefaultConfiguration();
				if (config != null) {
					Relation relation = RelationUtils.getMatchingRelation(config, link.getKind(), link.getSources().iterator().next(), link.getTargets().iterator().next());
					if(relation != null) {
						return IconRegistry.getImage(relation.getIcon());
					}
				}
			}
		}
		if (element instanceof Reachable) {
			Reachable reach = (Reachable) element;
			Image image = TraceabilityUtils.getImage(reach);
			if (image != null) {
				return image;
			}
		}
		return super.getImage(element);
	}

	@Override
	public Color getForeground(Object element) {
		if (element instanceof BusinessDeffered) {
			BusinessDeffered deferred = (BusinessDeffered) element;
			if (deferred.getBusinessElement() instanceof Link) {
				Link link = (Link) deferred.getBusinessElement();
				return provider.getColorForRelation(link);
			}
		}
		return null;
	}

	@Override
	public Font getFont(Object element) {
		if (element instanceof BusinessDeffered) {
			BusinessDeffered deferred = (BusinessDeffered) element;
			if (deferred.getBusinessElement() instanceof Link) {
				Link link = (Link) deferred.getBusinessElement();
				return provider.getFontForRelation(link);
			}
		}
		return null;
	}

	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

}
