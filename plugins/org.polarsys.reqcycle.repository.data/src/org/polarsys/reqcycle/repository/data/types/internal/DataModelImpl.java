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
package org.polarsys.reqcycle.repository.data.types.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.types.IDataModel;
import org.polarsys.reqcycle.repository.data.types.IType;

/**
 * The Class DataModelImpl.
 */
public class DataModelImpl implements IDataModel, IAdaptable {

	protected boolean needsNewVersionOnSave = false;

	protected static final Pattern VERSION_REGEX = Pattern.compile(".*/([0-9]*)");

	/** The ePackage. */
	protected EPackage ePackage;

	/** The subPackages. */
	protected Collection<IDataModel> subPackages = new ArrayList<IDataModel>();

	/** The requirement types. */
	protected Collection<IType> types = new ArrayList<IType>();

	protected int version = 0;

	/**
	 * Instantiates a new data model.
	 */
	public DataModelImpl() {
		ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName("");
		ePackage.setNsPrefix("");
		ePackage.setNsURI(IDataModelManager.MODEL_NS_URI);
	}

	/**
	 * Instantiates a new data model.
	 * 
	 * @param name
	 *            the data model name
	 */
	public DataModelImpl(String name, int version) {
		this.version = version;
		ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName(name);
		ePackage.setNsPrefix(name);
		ePackage.setNsURI(IDataModelManager.MODEL_NS_URI + "/" + name + "/" + this.version);

	}

	/**
	 * Instantiates a new data model.
	 * 
	 * @param ePackage
	 *            the ePackage
	 */
	public DataModelImpl(EPackage ePackage) {
		this.ePackage = ePackage;

		Matcher matcher = VERSION_REGEX.matcher(ePackage.getNsURI());
		if (matcher.matches()) {
			version = Integer.parseInt(matcher.group(1));
		}

		for (EClassifier classifier : ePackage.getEClassifiers()) {
			if (classifier instanceof EEnum) {
				types.add(new EnumerationTypeImpl((EEnum) classifier));
			} else if (classifier instanceof EClass) {
				types.add(new RequirementTypeImpl((EClass) classifier, this));
			}
		}

		for (EPackage subPackage : ePackage.getESubpackages()) {
			subPackages.add(new DataModelImpl(subPackage));
		}
	}

	@Override
	public int getVersion() {
		return version;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.polarsys.reqcycle.repository.data.types.IDataModel#getName()
	 */
	@Override
	public String getName() {
		return ePackage != null ? ePackage.getName() : null;
	}

	/**
	 * Gets the factory instance.
	 * 
	 * @return the factory instance
	 */
	protected EFactory getFactoryInstance() {
		return ePackage.getEFactoryInstance();
	}

	/**
	 * Adds the data model.
	 * 
	 * @param dataModel
	 *            the data model to add
	 */
	public void addSubDataModel(IDataModel dataModel) {
		subPackages.add(dataModel);

		EPackage ePackage = null;
		if (dataModel instanceof IAdaptable) {
			ePackage = (EPackage) ((IAdaptable) dataModel).getAdapter(EPackage.class);
		}
		if (ePackage != null) {
			this.ePackage.getESubpackages().add(ePackage);
		}
	}

	public void removeSubDataModel(IDataModel p) {
		subPackages.remove(p);

		EPackage ePackage = null;
		if (p instanceof IAdaptable) {
			ePackage = (EPackage) ((IAdaptable) p).getAdapter(EPackage.class);
		}
		if (ePackage != null) {
			EcoreUtil.remove(ePackage);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.polarsys.reqcycle.repository.data.types.IDataModel#addRequirementType (org.polarsys.reqcycle.repository.data.types.IRequirementType)
	 */
	@Override
	public void addType(IType type) {
		EClassifier eType = null;
		if (type instanceof IAdaptable) {
			eType = (EClassifier) ((IAdaptable) type).getAdapter(EClassifier.class);
		}
		if (eType != null) {
			ePackage.getEClassifiers().add(eType);
			types.add(type);
		}
	}

	/**
	 * Gets the sub data models.
	 * 
	 * @return the sub data models
	 */
	public Collection<IDataModel> getSubDataModels() {
		return subPackages;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.polarsys.reqcycle.repository.data.types.IDataModel#getRequirementType (java.lang.String)
	 */
	@Override
	public IType getType(String name) {
		for (IType type : types) {
			if (name.equals(type.getName())) {
				return type;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.polarsys.reqcycle.repository.data.types.IDataModel#getRequirementTypes ()
	 */
	@Override
	public Collection<IType> getTypes() {
		return types;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == EPackage.class) {
			return ePackage;
		}
		return null;
	}

	@Override
	public String getDataModelURI() {
		return ePackage.getNsURI();
	}

	@Override
	public void removeType(IType type) {
		if (type instanceof IAdaptable) {
			EClassifier classifier = (EClassifier) ((IAdaptable) type).getAdapter(EClassifier.class);
			if (classifier != null) {
				if (ePackage.getEClassifiers().remove(classifier)) {
					needsNewVersionOnSave = true;
				}
			}
		}
		types.remove(type);
	}

	public DataModelImpl prepareSave() {
		if (needsNewVersionOnSave) {
			needsNewVersionOnSave = false;
			String oldNsURI = ePackage.getNsURI();
			version = version + 1;
			ePackage.setNsURI(IDataModelManager.MODEL_NS_URI + "/" + ePackage.getName() + "/" + version);
			// reload old version of the DataModel which need to be kept for migration
			ResourceSetImpl rs = new ResourceSetImpl();
			Resource oldResource = rs.getResource(ePackage.eResource().getURI(), true);
			TreeIterator<EObject> it = oldResource.getAllContents();
			while (it.hasNext()) {
				EObject obj = it.next();
				if (obj instanceof EPackage && oldNsURI.equals(((EPackage) obj).getNsURI())) {
					return new DataModelImpl((EPackage) obj);
				}
			}
		}
		return null;
	}

}
