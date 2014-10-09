/*******************************************************************************
 *  Copyright (c) 2014 AtoS
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html *
 *  Contributors:
 *    Abdellah El Ayadi (AtoS) - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.polarsys.reqcycle.export.transform;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.osgi.framework.FrameworkUtil;
import org.polarsys.reqcycle.export.model.ReqCycleExport.Attribute;
import org.polarsys.reqcycle.export.model.ReqCycleExport.AttributeValue;
import org.polarsys.reqcycle.export.model.ReqCycleExport.Export;
import org.polarsys.reqcycle.export.model.ReqCycleExport.Model;
import org.polarsys.reqcycle.export.model.ReqCycleExport.Property;
import org.polarsys.reqcycle.export.model.ReqCycleExport.ReqCycleExportFactory;
import org.polarsys.reqcycle.export.model.ReqCycleExport.Traceability;
import org.polarsys.reqcycle.predicates.core.api.IPredicate;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Requirement;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.RequirementsContainer;
import org.polarsys.reqcycle.repository.data.RequirementSourceData.Section;
import org.polarsys.reqcycle.traceability.engine.ITraceabilityEngine;
import org.polarsys.reqcycle.traceability.engine.ITraceabilityEngine.DIRECTION;
import org.polarsys.reqcycle.traceability.engine.Request;
import org.polarsys.reqcycle.traceability.engine.Request.DEPTH;
import org.polarsys.reqcycle.traceability.exceptions.EngineException;
import org.polarsys.reqcycle.traceability.model.Link;
import org.polarsys.reqcycle.traceability.model.Pair;
import org.polarsys.reqcycle.traceability.model.scopes.CompositeScope;
import org.polarsys.reqcycle.traceability.model.scopes.Scopes;
import org.polarsys.reqcycle.traceability.types.ITraceabilityAttributesManager;
import org.polarsys.reqcycle.traceability.types.ITraceabilityAttributesManager.EditableAttribute;
import org.polarsys.reqcycle.traceability.types.ITypesConfigurationProvider;
import org.polarsys.reqcycle.traceability.types.configuration.typeconfiguration.Configuration;
import org.polarsys.reqcycle.traceability.types.engine.ITypedTraceabilityEngine;
import org.polarsys.reqcycle.traceability.utils.EngineUtils;
import org.polarsys.reqcycle.uri.IReachableManager;
import org.polarsys.reqcycle.uri.exceptions.IReachableHandlerException;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.model.ReachableObject;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

public class TraceabilityExport {

	IReachableManager manager = ZigguratInject.make(IReachableManager.class);
	ITraceabilityEngine engine = ZigguratInject.make(ITraceabilityEngine.class);
	ITypedTraceabilityEngine typedEngine = ZigguratInject.make(ITypedTraceabilityEngine.class);
	ReqCycleExportFactory factory = ReqCycleExportFactory.eINSTANCE;
	ITraceabilityAttributesManager attributesManager = ZigguratInject.make(ITraceabilityAttributesManager.class);
	ITypesConfigurationProvider typeProvider = ZigguratInject.make(ITypesConfigurationProvider.class);

	public Export transform(Iterable<IRequirementProvider> reqResult, Iterable<IPredicate> predicateResult, List<IProject> projects, boolean exportTraceability, String outputPath, IProgressMonitor monitor) {

		// model.get
		Multimap<Reachable, Link> traceaMap = null;
		if (exportTraceability) {
			Request request = getRequest(reqResult, projects);
			try {
				Iterator<Pair<Link, Reachable>> traca = getEngine().getTraceability(request);
				traceaMap = EngineUtils.toFollowingMap(traca);
			} catch (EngineException e) {
				e.printStackTrace();
			}
		}

		Export export = factory.createExport();
		export.setPath(outputPath);
		Date date = new Date();
		DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		export.setDate(shortDateFormat.format(date));
		monitor.beginTask("Extraction", Lists.newArrayList(reqResult).size());
		for (IRequirementProvider iRequirementProvider : reqResult) {
			if (monitor.isCanceled()) {
				return null;
			}
			List<Attribute> attributes = Lists.newArrayList();
			initAttributes(attributes);
			List<Attribute> predicateAttributes = Lists.newArrayList();
			List<Attribute> tracea = Lists.newArrayList();
			initPredicatesattributes(predicateAttributes, predicateResult);

			// creation model
			Model m = initModel();
			m.setName(iRequirementProvider.getLabel());
			for (Entry<String, String> entry : iRequirementProvider.getMetadata().entrySet()) {
				Property uriProperty = factory.createProperty();
				uriProperty.setName(entry.getKey());
				uriProperty.setValue(entry.getValue());
				m.getMetadata().add(uriProperty);
			}
			for (Requirement r : iRequirementProvider.getRequirements()) {
				org.polarsys.reqcycle.export.model.ReqCycleExport.Requirement reqCopy = factory.createRequirement();
				reqCopy.setID(r.getId());
				handleSection(attributes, r, reqCopy);
				// ajoute attribute value : text & section
				handleEAttributes(attributes, r, reqCopy);

				handlePredicates(predicateResult, predicateAttributes, r, reqCopy);

				if (traceaMap != null) {
					handleTracea(traceaMap, r, tracea, reqCopy);
				}

				m.getRequirements().add(reqCopy);
			}
			m.getAttributes().addAll(attributes);
			m.getAttributes().addAll(predicateAttributes);
			m.getAttributes().addAll(tracea);

			export.getModels().add(m);
			monitor.worked(1);
		}

		return export;
	}

	private void handleSection(List<Attribute> attributes, Requirement r, org.polarsys.reqcycle.export.model.ReqCycleExport.Requirement reqCopy) {
		AttributeValue val = factory.createAttributeValue();
		val.setValue(getSection(r));
		val.setAttribute(getAttribute(attributes, "section", String.class.getName()));
		reqCopy.getValues().add(val);
	}

	private String getSection(Requirement r) {
		List<String> result = Lists.newArrayList();
		EObject parent = r.eContainer();
		while (parent != null && (!(parent instanceof RequirementsContainer))) {
			if (parent instanceof Section) {
				Section section = (Section) parent;
				result.add(section.getId());
				parent = parent.eContainer();
			}
		}
		return Joiner.on("\\").join(result);
	}

	protected void handleTracea(Multimap<Reachable, Link> traceaMap, Requirement r, List<Attribute> tracea, org.polarsys.reqcycle.export.model.ReqCycleExport.Requirement reqCopy) {
		Collection<Link> links = traceaMap.get(getReachable(r));
		for (Link l : links) {
			Traceability t = factory.createTraceability();

			Attribute attribute = getAttribute(tracea, l.getLabel(), String.class.getName());
			AttributeValue val = factory.createAttributeValue();
			val.setValue(getLabel(l.getTargets().iterator().next()));
			val.setAttribute(attribute);

			t.getTraceabilityValues().add(val);

			Collection<EditableAttribute> attributeOfLink = attributesManager.getAttributes(l.getId());
			for (EditableAttribute a : attributeOfLink) {
				Attribute att = getAttribute(tracea, a.getName(), a.getType().getName());
				AttributeValue value = factory.createAttributeValue();
				value.setValue(valueOf(a.getValue()));
				value.setAttribute(att);
				t.getTraceabilityValues().add(value);
			}
			reqCopy.getDownwardTraceability().add(t);
		}
	}

	protected String valueOf(Object object) {
		if (object != null) {
			return String.valueOf(object);
		}
		return "";
	}

	protected void handlePredicates(Iterable<IPredicate> predicateResult, List<Attribute> predicateAttributes, Requirement r, org.polarsys.reqcycle.export.model.ReqCycleExport.Requirement reqCopy) {
		for (IPredicate p : predicateResult) {
			AttributeValue val = factory.createAttributeValue();
			val.setAttribute(getAttribute(predicateAttributes, p.getDisplayName(), Boolean.class.getName()));
			try {
				val.setValue(valueOf(p.match(r)));
			} catch (Exception e) {
				val.setValue("error");
			}
			reqCopy.getValues().add(val);
		}
	}

	protected void handleEAttributes(List<Attribute> attributes, Requirement r, org.polarsys.reqcycle.export.model.ReqCycleExport.Requirement reqCopy) {
		for (EAttribute att : r.eClass().getEAllAttributes()) {
			// ajout attribut si n'existe pas
			// ignorer : uri
			if (!"uri".equals(att.getName()) && !"id".equals(att.getName())) {
				Attribute attribute = getAttribute(attributes, att.getName(), att.getEType().getInstanceClassName());
				AttributeValue attributeValue = factory.createAttributeValue();
				attributeValue.setValue(valueOf(r.eGet(att)));
				attributeValue.setAttribute(attribute);
				reqCopy.getValues().add(attributeValue);
			}
		}
	}

	private ITraceabilityEngine getEngine() {
		Configuration defaultConfiguration = typeProvider.getDefaultConfiguration();
		if (defaultConfiguration != null) {
			return typedEngine;
		}
		return engine;
	}

	private Attribute getAttribute(List<Attribute> attributes, String name, String type) {
		for (Attribute att : attributes) {
			if (att.getName().equals(name)) {
				return att;
			}
		}
		Attribute newAtt = factory.createAttribute();
		newAtt.setName(name);
		newAtt.setType(type);
		attributes.add(newAtt);
		return newAtt;
	}

	private void initPredicatesattributes(List<Attribute> predicateAttributes, Iterable<IPredicate> predicateResult) {
		for (IPredicate p : predicateResult) {
			Attribute Att = factory.createAttribute();
			Att.setName(p.getDisplayName());
		}
	}

	private void initAttributes(List<Attribute> attributes) {
		Attribute att = factory.createAttribute();
		att.setName("text");
		attributes.add(att);

		Attribute section = factory.createAttribute();
		section.setName("section");
		attributes.add(section);
	}

	private Model initModel() {
		Model model = factory.createModel();
		model.setVersion(FrameworkUtil.getBundle(getClass()).getVersion().toString());
		return model;
	}

	private Request getRequest(Iterable<IRequirementProvider> reqResult, List<IProject> projects) {
		Request r = new Request();
		r.setDirection(DIRECTION.DOWNWARD);
		r.setDepth(DEPTH.ONE);
		if (projects.size() == ResourcesPlugin.getWorkspace().getRoot().getProjects().length) {
			r.setScope(Scopes.getWorkspaceScope());
		} else {
			CompositeScope compo = new CompositeScope();
			for (IProject p : projects) {
				compo.add(Scopes.getProjectScope(p));
			}
			r.setScope(compo);
		}
		// for each sources or scopes
		for (IRequirementProvider p : reqResult) {
			// for each req
			for (Requirement req : p.getRequirements()) {
				r.addSource(getReachable(req));
			}
		}
		return r;
	}

	private Reachable getReachable(Requirement req) {
		try {
			return manager.getHandlerFromObject(req).getFromObject(req).getReachable();
		} catch (IReachableHandlerException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String getLabel(Reachable reachable) {
		try {
			ReachableObject fromReachable = manager.getHandlerFromReachable(reachable).getFromReachable(reachable);
			if (fromReachable != null) {
				ILabelProvider provider = (ILabelProvider) fromReachable.getAdapter(ILabelProvider.class);
				if (provider != null) {
					return provider.getText(reachable);
				}
			}
		} catch (IReachableHandlerException e) {
			e.printStackTrace();
		}
		return "no label";
	}

}
