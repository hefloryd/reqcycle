package org.polarsys.reqcycle.traceability.storage.sesame.reachable;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.eclipse.core.runtime.IAdaptable;
import org.polarsys.reqcycle.traceability.builder.ITraceabilityBuilder.IBuilderCallBack;
import org.polarsys.reqcycle.traceability.model.Link;
import org.polarsys.reqcycle.uri.visitors.IVisitor;

public class TraceabilityVisitor implements IVisitor {
	
	@PostConstruct
	public void init() {
	}

	@Override
	public void start(IAdaptable adaptable) {

	}

	@Override
	public boolean visit(Object o, IAdaptable adaptable) {
		if (o instanceof Object[]) {
			Object[] tab = (Object[]) o ;
			Link link = (Link) tab[1];
			Object container = tab[0]; // TODO
			Object source = link.getSources().iterator().next(); //TODO
			Object target = link.getTargets().iterator().next(); //TODO
			getCallBack(adaptable).newUpwardRelation(link.getId(),
					container, source, Collections.singletonList(target),
				 link.getKind());
			return true;
		}
		return false;
	}

	IBuilderCallBack getCallBack(IAdaptable adaptable) {
		return (IBuilderCallBack) adaptable.getAdapter(IBuilderCallBack.class);
	}

	@Override
	public void end(IAdaptable adaptable) {

	}

}
