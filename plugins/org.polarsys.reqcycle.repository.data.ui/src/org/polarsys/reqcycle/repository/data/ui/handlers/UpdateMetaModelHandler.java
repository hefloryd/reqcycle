package org.polarsys.reqcycle.repository.data.ui.handlers;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.IDataModelManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementSourceDataPackage;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementsContainer;
import org.polarsys.reqcycle.repository.data.types.IDataModel;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

public class UpdateMetaModelHandler extends AbstractHandler {

	private @Inject IDataModelManager dataModelManager = ZigguratInject.make(IDataModelManager.class);
	private @Inject IDataManager dataManager = ZigguratInject.make(IDataManager.class);

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (sel instanceof IStructuredSelection) {
			Iterator it = ((IStructuredSelection) sel).iterator();
			while (it.hasNext()) {
				Object obj = it.next();
				if (obj instanceof RequirementSource) {
					String currentDataModelURI = ((RequirementSource) obj).getDataModelURI();
					IDataModel outdatedDataModel = dataModelManager.getDataModelByURI(currentDataModelURI);
					IDataModel updatedDataModel = dataModelManager.getCurrentDataModel(outdatedDataModel.getName());
					if (updatedDataModel.getVersion() > outdatedDataModel.getVersion()) {
						migrate((RequirementSource) obj, outdatedDataModel, updatedDataModel);
					}
				}
			}
		}

		for (IWorkbenchPage p : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages()) {
			for (IViewReference vr : p.getViewReferences()) {
				if (vr.getId().equals("org.polarsys.reqcycle.repository.ui.views.sources")) {
					IViewPart v = vr.getView(false);
					if (v != null) {
						Viewer viewer = (Viewer) v.getAdapter(Viewer.class);
						if (viewer != null) {
							viewer.refresh();
						}
					}
				}
			}
		}
		return null;
	}

	private void migrate(RequirementSource reqSource, IDataModel outdatedDataModel, IDataModel updatedDataModel) {
		EPackage outdatedEPackage = (EPackage) ((IAdaptable) outdatedDataModel).getAdapter(EPackage.class);
		EPackage updatedEPackage = (EPackage) ((IAdaptable) updatedDataModel).getAdapter(EPackage.class);

		final Map<EClass, EClass> classesMapping = Maps.newHashMap();
		final Map<EStructuralFeature, EStructuralFeature> featuresMapping = Maps.newHashMap();

		for (EClassifier updatedEClassifier : updatedEPackage.getEClassifiers()) {
			EClassifier outdatedEClassifier = outdatedEPackage.getEClassifier(updatedEClassifier.getName());
			if (outdatedEClassifier instanceof EClass && updatedEClassifier instanceof EClass) {
				classesMapping.put((EClass) outdatedEClassifier, (EClass) updatedEClassifier);

				for (EStructuralFeature updatedFeature : ((EClass) updatedEClassifier).getEStructuralFeatures()) {
					EStructuralFeature outdatedFeature = ((EClass) outdatedEClassifier).getEStructuralFeature(updatedFeature.getName());
					if (outdatedFeature != null) {
						featuresMapping.put(outdatedFeature, updatedFeature);
					}
				}
			}
		}

		Copier c = new EcoreUtil.Copier() {

			@Override
			protected EClass getTarget(EClass eClass) {
				if (RequirementSourceDataPackage.eINSTANCE.equals(eClass.getEPackage())) {
					return eClass;
				}
				return classesMapping.get(eClass);
			}

			@Override
			protected EStructuralFeature getTarget(EStructuralFeature eStructuralFeature) {
				if (RequirementSourceDataPackage.eINSTANCE.equals(eStructuralFeature.getEContainingClass().getEPackage())) {
					return eStructuralFeature;
				}
				return featuresMapping.get(eStructuralFeature);
			}
		};

		RequirementsContainer originalContainer = reqSource.getContents();
		Resource resource = originalContainer.eResource();

		Map<EObject, String> idsMap = Maps.newHashMap();
		TreeIterator<EObject> it = resource.getAllContents();
		while (it.hasNext()) {
			EObject obj = it.next();
			idsMap.put(obj, resource.getURIFragment(obj));
		}

		EObject newContainer = c.copy(originalContainer);
		c.copyReferences();

		reqSource.setContents((RequirementsContainer) newContainer);
		reqSource.setDataModelURI(updatedDataModel.getDataModelURI());

		resource.getContents().remove(originalContainer);
		resource.getContents().add(newContainer);

		BiMap<EObject, EObject> reverse = HashBiMap.create(c).inverse();

		it = resource.getAllContents();
		while (it.hasNext()) {
			EObject next = it.next();
			EObject originalObj = reverse.get(next);
			if (originalObj != null) {
				String id = idsMap.get(originalObj);
				if (id != null) {
					((XMLResource) resource).setID(next, id);
				}
			}
		}

		try {
			dataManager.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
