/*******************************************************************************
 *  Copyright (c) 2013 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Anass Radouani (AtoS) - initial API and implementation and/or initial documentation
 *   
 *******************************************************************************/
package org.polarsys.reqcycle.repository.connector.local;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.IDataTopics;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementSourceDataPackage;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Section;
import org.polarsys.reqcycle.repository.data.types.IDataModel;
import org.polarsys.reqcycle.repository.data.types.IRequirementType;
import org.polarsys.reqcycle.repository.data.types.IType;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class ReqCycleContributionItem extends CompoundContributionItem {

	@Inject
	IDataModelManager dataModelManager;

	@Inject
	IDataManager dataManager;

	protected EObject selectedElement;

	public ReqCycleContributionItem() {
		super();
		ZigguratInject.inject(this);
	}

	@Override
	protected IContributionItem[] getContributionItems() {

		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		Set<EClass> classes = new HashSet<EClass>();
		if (window != null) {
			ISelection selection = window.getSelectionService().getSelection();
			if (selection instanceof IStructuredSelection) {
				Object firstElement = ((IStructuredSelection) selection).getFirstElement();
				selectedElement = null;
				if (firstElement instanceof EObject) {
					selectedElement = (EObject) firstElement;
					classes = getDataEClasses(selectedElement);
				}
			}
		}

		Collection<IContributionItem> menuContributionList = Collections2.transform(classes, new Function<EClass, IContributionItem>() {

			@Override
			public IContributionItem apply(final EClass arg0) {
				ContributionItem contributionItem = new ContributionItem() {

					@Override
					public void fill(Menu menu, int index) {
						MenuItem menuItem = new MenuItem(menu, SWT.None);
						menuItem.setText(arg0.getName());
						menuItem.addSelectionListener(new SelectionAdapter() {

							@Override
							public void widgetSelected(SelectionEvent e) {

								try {

									EObject object = arg0.getEPackage().getEFactoryInstance().create(arg0);
									AbstractElement element;

									if (object instanceof AbstractElement) {
										element = (AbstractElement) object;
									} else {
										throw new Exception("Error while creating a " + arg0.getName() + " element.");
									}

									if (selectedElement instanceof RequirementSource) {
										dataManager.addElementsToSource((RequirementSource) selectedElement, element);
									}

									if (selectedElement instanceof Section) {
										dataManager.addElementsToSection((Section) selectedElement, element);
									}

									dataManager.notifyChange(IDataTopics.NEW_ELEMENT, element);

									// FIXME : set element scope

								} catch (Exception e1) {
									e1.printStackTrace();
								}

							}
						});
					}
				};
				return contributionItem;
			}
		});

		IContributionItem[] array = new IContributionItem[menuContributionList.size()];
		return menuContributionList.toArray(array);
	}

	/**
	 * Gets the data e classes.
	 * 
	 * @param selectedElement
	 *            the selected element
	 * @return the data e classes
	 */
	protected Set<EClass> getDataEClasses(Object selectedElement) {
		if (!(selectedElement instanceof Section || selectedElement instanceof RequirementSource)) {
			return Sets.newHashSet();
		}

		Set<EClass> classes = new HashSet<EClass>();

		// Gets Requirement Types EClasses
		Collection<IDataModel> dataModels = dataModelManager.getCurrentDataModels();
		List<IType> types = Lists.newArrayList();
		for (IDataModel dataModel : dataModels) {
			types.addAll(dataModel.getTypes());
		}
		classes.addAll(Collections2.transform(types, new Function<IType, EClass>() {

			@Override
			public EClass apply(IType arg0) {
				if (arg0 instanceof IAdaptable) {
					return (EClass) ((IAdaptable) arg0).getAdapter(EClass.class);
				}
				return null;
			}
		}));

		// Add Section EClass
		classes.add(RequirementSourceDataPackage.Literals.SECTION);
		return classes;
	}

}
