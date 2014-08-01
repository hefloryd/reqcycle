package org.polarsys.reqcycle.traceability.storage.sesame.reachable;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Path;
import org.openrdf.model.Graph;
import org.openrdf.rio.RDFWriterRegistry;
import org.polarsys.reqcycle.traceability.engine.ITraceabilityEngine.DIRECTION;
import org.polarsys.reqcycle.traceability.model.Link;
import org.polarsys.reqcycle.traceability.model.Pair;
import org.polarsys.reqcycle.traceability.storage.IStorageProvider;
import org.polarsys.reqcycle.traceability.storage.ITraceabilityStorage;
import org.polarsys.reqcycle.uri.model.Reachable;
import org.polarsys.reqcycle.uri.visitors.IVisitable;
import org.polarsys.reqcycle.uri.visitors.IVisitor;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class SesameVisitable implements IVisitable, IAdaptable {

	@Inject
	@Named("RDF")
	IStorageProvider provider = null;
	ITraceabilityStorage storage;
	private Reachable reachable;

	public SesameVisitable(Reachable reachable) {
		this.reachable = reachable;
		String path = reachable.getPath();
		if ("platform".equals(reachable.getScheme())) {
			IFile f = ResourcesPlugin.getWorkspace().getRoot()
					.getFile(new Path(path));
			if (f.exists()) {
				path = f.getLocationURI().getPath();
			}
		}
		ZigguratInject.inject(this); // TODO 
		storage = provider.getStorage(path);

	}

	@Override
	public void accept(IVisitor visitor) {
		Iterable<Pair<Link, Reachable>> traces = storage.getAllTraceability(DIRECTION.UPWARD);
		for(Pair<Link, Reachable> x : traces) {
			Link link = x.getFirst(); // TODO
			visitor.visit(new Object[]{reachable,link}, this);
		}
	}

	@Override
	public void dispose() {
		if(storage != null) {
			storage.dispose();
		}
	}

	@Override
	public Object getAdapter(Class adapter) {
		return null;
	}

}
