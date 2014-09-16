/**
 * Copyright (c) 2014 AtoS
 *     All rights reserved. This program and the accompanying materials
 *     are made available under the terms of the Eclipse Public License v1.0
 *     which accompanies this distribution, and is available at
 *     http://www.eclipse.org/legal/epl-v10.html *
 *     Contributors:
 *       Sebastien Lemanceau (AtoS) - initial API and implementation and/or initial documentation
 */
package org.polarsys.reqcycle.impact.Impact.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.api.Role;
import org.eclipse.emf.diffmerge.api.diff.IDifference;
import org.eclipse.emf.diffmerge.diffdata.EAttributeValuePresence;
import org.eclipse.emf.diffmerge.diffdata.EComparison;
import org.eclipse.emf.diffmerge.diffdata.EElementPresence;
import org.eclipse.emf.diffmerge.diffdata.EReferenceValuePresence;
import org.eclipse.emf.diffmerge.diffdata.impl.EComparisonImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.polarsys.reqcycle.impact.IVersionManager;
import org.polarsys.reqcycle.impact.Impact.AttributeImpacted;
import org.polarsys.reqcycle.impact.Impact.ImpactAnalysis;
import org.polarsys.reqcycle.impact.Impact.ImpactFactory;
import org.polarsys.reqcycle.impact.Impact.ImpactPackage;
import org.polarsys.reqcycle.impact.Impact.RequirementImpacted;
import org.polarsys.reqcycle.impact.Impact.TraceabilityLink;
import org.polarsys.reqcycle.impact.merge.CustomRootedModelScope;
import org.polarsys.reqcycle.repository.data.IDataManager;
import org.polarsys.reqcycle.repository.data.RequirementSourceConf.RequirementSource;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.AbstractElement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Section;
import org.polarsys.reqcycle.traceability.engine.ITraceabilityEngine;
import org.polarsys.reqcycle.traceability.engine.ITraceabilityEngine.DIRECTION;
import org.polarsys.reqcycle.traceability.engine.Request;
import org.polarsys.reqcycle.traceability.engine.Request.DEPTH;
import org.polarsys.reqcycle.traceability.exceptions.EngineException;
import org.polarsys.reqcycle.traceability.model.Link;
import org.polarsys.reqcycle.traceability.model.Pair;
import org.polarsys.reqcycle.traceability.model.TType;
import org.polarsys.reqcycle.traceability.model.scopes.CompositeScope;
import org.polarsys.reqcycle.traceability.model.scopes.Scopes;
import org.polarsys.reqcycle.traceability.ui.TraceabilityUtils;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.uri.exceptions.IReachableHandlerException;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Analysis</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.polarsys.reqcycle.impact.Impact.impl.ImpactAnalysisImpl#getRequirementsAdded
 * <em>Requirements Added</em>}</li>
 * <li>
 * {@link org.polarsys.reqcycle.impact.Impact.impl.ImpactAnalysisImpl#getRequirementsDeleted
 * <em>Requirements Deleted</em>}</li>
 * <li>
 * {@link org.polarsys.reqcycle.impact.Impact.impl.ImpactAnalysisImpl#getRequirementsModified
 * <em>Requirements Modified</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImpactAnalysisImpl extends MinimalEObjectImpl.Container implements
		ImpactAnalysis {
	/**
	 * The cached value of the '{@link #getRequirementsAdded()
	 * <em>Requirements Added</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRequirementsAdded()
	 * @generated
	 * @ordered
	 */
	protected EList<RequirementImpacted> requirementsAdded;

	/**
	 * The cached value of the '{@link #getRequirementsDeleted()
	 * <em>Requirements Deleted</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRequirementsDeleted()
	 * @generated
	 * @ordered
	 */
	protected EList<RequirementImpacted> requirementsDeleted;
	/**
	 * The cached value of the '{@link #getRequirementsModified()
	 * <em>Requirements Modified</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRequirementsModified()
	 * @generated
	 * @ordered
	 */
	protected EList<RequirementImpacted> requirementsModified;

	@Inject
	IReachableManager manager;

	@Inject
	IDataManager dataManager;

	@Inject
	@Named("confResourceSet")
	ResourceSet rs;

	@Inject
	IVersionManager versionManager;

	@Inject
	ITraceabilityEngine engine;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected ImpactAnalysisImpl() {
		super();
		ZigguratInject.inject(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImpactPackage.Literals.IMPACT_ANALYSIS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<RequirementImpacted> getRequirementsAdded() {
		if (requirementsAdded == null) {
			requirementsAdded = new EObjectContainmentEList<RequirementImpacted>(
					RequirementImpacted.class, this,
					ImpactPackage.IMPACT_ANALYSIS__REQUIREMENTS_ADDED);
		}
		return requirementsAdded;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<RequirementImpacted> getRequirementsDeleted() {
		if (requirementsDeleted == null) {
			requirementsDeleted = new EObjectContainmentEList<RequirementImpacted>(
					RequirementImpacted.class, this,
					ImpactPackage.IMPACT_ANALYSIS__REQUIREMENTS_DELETED);
		}
		return requirementsDeleted;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<RequirementImpacted> getRequirementsModified() {
		if (requirementsModified == null) {
			requirementsModified = new EObjectContainmentEList<RequirementImpacted>(
					RequirementImpacted.class, this,
					ImpactPackage.IMPACT_ANALYSIS__REQUIREMENTS_MODIFIED);
		}
		return requirementsModified;
	}

	public Collection<Requirement> getRequirement(AbstractElement absElt) {
		List<Requirement> req = new LinkedList<Requirement>();
		if (absElt instanceof Requirement) {
			req.add((Requirement) absElt);
		} else if (absElt instanceof Section) {
			for (AbstractElement e : ((Section) absElt).getChildren()) {
				if (e instanceof Requirement) {
					req.add((Requirement) e);
				} else if (e instanceof Section) {
					req.addAll(getRequirement(e));
				}
			}
		}
		return req;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void launchAnalysis(RequirementSource sourceFrom,
			RequirementSource sourceTo) {
		this.getRequirementsAdded().clear();
		this.getRequirementsDeleted().clear();
		this.getRequirementsModified().clear();

		if ((sourceFrom != null) && (sourceTo != null)) {

			List<Requirement> targetObjects = new LinkedList<Requirement>();
			for (AbstractElement elt : sourceTo.getRequirements()) {
				if (elt instanceof Requirement) {
					targetObjects.add((Requirement) elt);
				} else if (elt instanceof Section) {
					targetObjects.addAll(getRequirement(elt));
					// for (AbstractElement e : ((Section) elt).getChildren()) {
					// targetObjects.add((Requirement) e);
					// }
				}
			}
			Collections.sort(targetObjects, new Comparator<Requirement>() {

				@Override
				public int compare(Requirement arg0, Requirement arg1) {
					return arg0.getId().compareTo(arg1.getId());
				}

			});

			List<Requirement> refObjects = new LinkedList<Requirement>();
			for (AbstractElement elt : sourceFrom.getRequirements()) {
				if (elt instanceof Requirement) {
					refObjects.add((Requirement) elt);
				} else if (elt instanceof Section) {
					refObjects.addAll(getRequirement(elt));
//					for (AbstractElement e : ((Section) elt).getChildren()) {
//						refObjects.add((Requirement) e);
//					}
				}
			}
			Collections.sort(refObjects, new Comparator<Requirement>() {

				@Override
				public int compare(Requirement arg0, Requirement arg1) {
					return arg0.getId().compareTo(arg1.getId());
				}

			});

			CustomRootedModelScope refScope = new CustomRootedModelScope(
					refObjects);
			CustomRootedModelScope targetScope = new CustomRootedModelScope(
					targetObjects);

			EComparison comparison = new EComparisonImpl(targetScope, refScope,
					null);

			comparison.compute(null, null, null, null);

			List<IDifference> toMergeDiffs = Lists.newArrayList(comparison
					.getRemainingDifferences());

			for (IDifference diff : toMergeDiffs) {
				if (diff instanceof EElementPresence) {
					EElementPresence presence = (EElementPresence) diff;
					// this means a requirement has been added
					if (presence.getPresenceRole() == Role.TARGET) {
						if (presence.getElement() instanceof Requirement) {
							RequirementImpacted reqAdded = ImpactFactory.eINSTANCE
									.createRequirementImpacted();
							reqAdded.setId(((Requirement) presence.getElement())
									.getId());

							this.getRequirementsAdded().add(reqAdded);
						}
					} else { // presence.getPresenceRole() == Role.REFERENCE
						// this means a requirement has been deleted
						if (presence.getElement() instanceof Requirement) {
							RequirementImpacted reqDeleted = ImpactFactory.eINSTANCE
									.createRequirementImpacted();
							reqDeleted.setId(((Requirement) presence
									.getElement()).getId());

							Requirement req = (Requirement) presence
									.getElement();

							reqDeleted.getLinkList().addAll(
									getTraceabilityLinks(req));

							this.getRequirementsDeleted().add(reqDeleted);
						}
					}
				} else if (diff instanceof EReferenceValuePresence) {
					EReferenceValuePresence ref = (EReferenceValuePresence) diff;
					if (ref.getPresenceRole() == Role.TARGET) {

					} else { // presence.getPresenceRole() == Role.REFERENCE

					}
				} else if (diff instanceof EAttributeValuePresence) {
					EAttributeValuePresence ref = (EAttributeValuePresence) diff;
					if (ref.getPresenceRole() == Role.TARGET) {
						if (ref.getElementMatch().getReference() instanceof Requirement) {
							Requirement req = (Requirement) ref
									.getElementMatch().getReference();
							RequirementImpacted reqModified = getReqModified(req);

							AttributeImpacted att = reqModified
									.getImpactedAttribute(ref.getFeature()
											.getName());
							if (att != null) {
								att.setNewValue(ref.getValue().toString());
							} else {
								AttributeImpacted attImpacted = ImpactFactory.eINSTANCE
										.createAttributeImpacted();
								ref.getElementMatch();
								attImpacted.setId(ref.getFeature().getName());
								attImpacted.setNewValue(ref.getValue()
										.toString());

								reqModified.getAttributesImpacted().add(
										attImpacted);
							}
						}
					} else { // presence.getPresenceRole() == Role.REFERENCE
						// Requirement modified already treated in the if case
						Requirement req = (Requirement) ref.getElementMatch()
								.getReference();
						RequirementImpacted reqModified = getReqModified(req);

						AttributeImpacted att = reqModified
								.getImpactedAttribute(ref.getFeature()
										.getName());
						if (att != null) {
							att.setOldValue(ref.getValue().toString());
						} else {
							AttributeImpacted attImpacted = ImpactFactory.eINSTANCE
									.createAttributeImpacted();
							ref.getElementMatch();
							attImpacted.setId(ref.getFeature().getName());
							attImpacted.setOldValue(ref.getValue().toString());

							reqModified.getAttributesImpacted()
									.add(attImpacted);
						}
					}
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	public void saveAnalysis(URI targetName) {
		ResourceSet set = null;
		if (eResource() != null) {
			set = eResource().getResourceSet();
		}
		if (set == null) {
			set = new ResourceSetImpl();
			set.getResourceFactoryRegistry().getExtensionToFactoryMap()
					.put("*", new XMIResourceFactoryImpl());
		}
		Resource r = set.createResource(targetName);
		r.getContents().add(this);
		try {
			r.save(Collections.emptyMap());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ImpactPackage.IMPACT_ANALYSIS__REQUIREMENTS_ADDED:
			return ((InternalEList<?>) getRequirementsAdded()).basicRemove(
					otherEnd, msgs);
		case ImpactPackage.IMPACT_ANALYSIS__REQUIREMENTS_DELETED:
			return ((InternalEList<?>) getRequirementsDeleted()).basicRemove(
					otherEnd, msgs);
		case ImpactPackage.IMPACT_ANALYSIS__REQUIREMENTS_MODIFIED:
			return ((InternalEList<?>) getRequirementsModified()).basicRemove(
					otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	protected RequirementImpacted getReqModified(Requirement requirement) {
		for (RequirementImpacted req : this.getRequirementsModified()) {
			if (req.getId().equals(requirement.getId())) {
				return req;
			}
		}

		RequirementImpacted reqModified = ImpactFactory.eINSTANCE
				.createRequirementImpacted();
		reqModified.setId(requirement.getId());
		reqModified.getLinkList().addAll(getTraceabilityLinks(requirement));
		this.getRequirementsModified().add(reqModified);

		return reqModified;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ImpactPackage.IMPACT_ANALYSIS__REQUIREMENTS_ADDED:
			return getRequirementsAdded();
		case ImpactPackage.IMPACT_ANALYSIS__REQUIREMENTS_DELETED:
			return getRequirementsDeleted();
		case ImpactPackage.IMPACT_ANALYSIS__REQUIREMENTS_MODIFIED:
			return getRequirementsModified();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ImpactPackage.IMPACT_ANALYSIS__REQUIREMENTS_ADDED:
			getRequirementsAdded().clear();
			getRequirementsAdded().addAll(
					(Collection<? extends RequirementImpacted>) newValue);
			return;
		case ImpactPackage.IMPACT_ANALYSIS__REQUIREMENTS_DELETED:
			getRequirementsDeleted().clear();
			getRequirementsDeleted().addAll(
					(Collection<? extends RequirementImpacted>) newValue);
			return;
		case ImpactPackage.IMPACT_ANALYSIS__REQUIREMENTS_MODIFIED:
			getRequirementsModified().clear();
			getRequirementsModified().addAll(
					(Collection<? extends RequirementImpacted>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ImpactPackage.IMPACT_ANALYSIS__REQUIREMENTS_ADDED:
			getRequirementsAdded().clear();
			return;
		case ImpactPackage.IMPACT_ANALYSIS__REQUIREMENTS_DELETED:
			getRequirementsDeleted().clear();
			return;
		case ImpactPackage.IMPACT_ANALYSIS__REQUIREMENTS_MODIFIED:
			getRequirementsModified().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ImpactPackage.IMPACT_ANALYSIS__REQUIREMENTS_ADDED:
			return requirementsAdded != null && !requirementsAdded.isEmpty();
		case ImpactPackage.IMPACT_ANALYSIS__REQUIREMENTS_DELETED:
			return requirementsDeleted != null
					&& !requirementsDeleted.isEmpty();
		case ImpactPackage.IMPACT_ANALYSIS__REQUIREMENTS_MODIFIED:
			return requirementsModified != null
					&& !requirementsModified.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID) {
		case ImpactPackage.IMPACT_ANALYSIS___LAUNCH_ANALYSIS__REQUIREMENTSOURCE_REQUIREMENTSOURCE:
			launchAnalysis((RequirementSource) arguments.get(0),
					(RequirementSource) arguments.get(1));
			return null;
		case ImpactPackage.IMPACT_ANALYSIS___SAVE_ANALYSIS__URI:
			saveAnalysis((URI) arguments.get(0));
			return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	protected Collection<TraceabilityLink> getTraceabilityLinks(
			Requirement requirement) {
		List<TraceabilityLink> traceabilityLinks = new LinkedList<TraceabilityLink>();

		Iterable<Link> itUp = getLinks(requirement, DIRECTION.UPWARD);

		if ((itUp != null) && (itUp.iterator() != null)) {
			Iterator<Link> iterator = itUp.iterator();
			while (iterator.hasNext()) {
				Link link = iterator.next();

				TraceabilityLink traceabilityLink = ImpactFactory.eINSTANCE
						.createTraceabilityLink();

				TType kind = link.getKind();
				StringBuilder builder = new StringBuilder(kind.getLabel());
				TType superKind = kind.getSuperType();
				if (superKind != null) {
					builder.append(String.format(" [Transverse : %s]",
							superKind.getLabel()));
				}
				traceabilityLink.setLinkType(builder.toString());

				Set<Reachable> set = link.getTargets();
				if (set != null && set.size() == 1) {
					Reachable reachable = Iterables.get(set, 0);
					traceabilityLink.setLinkDirection("UP");
					traceabilityLink.setLinkedElement(TraceabilityUtils
							.getText(reachable));
				}
				traceabilityLinks.add(traceabilityLink);
			}
		}

		Iterable<Link> itDown = getLinks(requirement, DIRECTION.DOWNWARD);
		if ((itDown != null) && (itDown.iterator() != null)) {
			Iterator<Link> iterator = itDown.iterator();
			while (iterator.hasNext()) {
				Link link = iterator.next();

				TraceabilityLink traceabilityLink = ImpactFactory.eINSTANCE
						.createTraceabilityLink();

				TType kind = link.getKind();
				StringBuilder builder = new StringBuilder(kind.getLabel());
				TType superKind = kind.getSuperType();
				if (superKind != null) {
					builder.append(String.format(" [Transverse : %s]",
							superKind.getLabel()));
				}
				traceabilityLink.setLinkType(builder.toString());

				Set<Reachable> set = link.getTargets();
				if (set != null && set.size() == 1) {
					Reachable reachable = Iterables.get(set, 0);
					traceabilityLink.setLinkDirection("DOWN");
					traceabilityLink.setLinkedElement(TraceabilityUtils
							.getText(reachable));
				}
				traceabilityLinks.add(traceabilityLink);
			}
		}

		return traceabilityLinks;
	}

	protected Iterable<Link> getLinks(final Requirement req,
			final DIRECTION direction) {
		return new Iterable<Link>() {

			@Override
			public Iterator<Link> iterator() {
				Request request = new Request();
				CompositeScope scope = new CompositeScope();
				scope.add(Scopes.getWorkspaceScope());
				request.setScope(scope);
				request.setDepth(DEPTH.ONE);
				request.setDirection(direction);
				try {
					request.addSource(manager.getHandlerFromObject(req)
							.getFromObject(req).getReachable(req));
				} catch (IReachableHandlerException e1) {
					e1.printStackTrace();
					return new ArrayList<Link>().iterator();
				}
				try {
					Iterator<Pair<Link, Reachable>> traceability = engine
							.getTraceability(request);
					return Iterators.transform(traceability,
							new Function<Pair<Link, Reachable>, Link>() {

								@Override
								public Link apply(Pair<Link, Reachable> arg0) {
									return arg0.getFirst();
								}
							});
				} catch (EngineException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// Traceability links could not be retrieved
					return null;
				}
				return new ArrayList<Link>().iterator();
			}
		};
	}

} // ImpactAnalysisImpl

