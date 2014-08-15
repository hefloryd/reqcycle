package org.polarsys.reqcycle.traceability.storage.sesame.storage;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.eclipse.core.resources.ResourceAttributes;
import org.openrdf.model.Resource;
import org.openrdf.model.Statement;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.RDFHandler;
import org.openrdf.rio.RDFHandlerException;
import org.openrdf.rio.RDFParseException;
import org.openrdf.rio.helpers.RDFWriterBase;
import org.openrdf.rio.rdfxml.RDFXMLWriter;
import org.openrdf.sail.memory.MemoryStore;
import org.openrdf.sail.nativerdf.NativeStore;
import org.polarsys.reqcycle.traceability.storage.IStorageProvider;
import org.polarsys.reqcycle.traceability.storage.ITraceabilityStorage;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class RDFSesameTraceabilityStorage extends SesameStorageProvider {

	@Override
	public ITraceabilityStorage getStorage(final String path) {
		try {
			
			final MemoryStore store = new MemoryStore();
			final Repository repository = new SailRepository(store);
			repository.initialize();
			final RepositoryConnection connection = repository.getConnection();
			File f = new File(path);
			if (f.exists()){
				try {
					connection.add(new FileReader(f), "" , RDFFormat.RDFXML, new Resource[] {});
				} catch (RDFParseException | IOException e) {
					e.printStackTrace();
				}
			}
			final ITraceabilityStorage traceabilityStorage = new SesameTraceabilityStorage(this, path, connection){
				@Override
				public void commit() {
					try {
						connection.export(new RDFXMLWriter(new FileWriter(new File(path))), new Resource[]{});
					} catch (RepositoryException | RDFHandlerException
							| IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				@Override
				public void save() {
					// do nothing
				}
			};
			ZigguratInject.inject(traceabilityStorage);
			return traceabilityStorage;
		} catch (RepositoryException e) {
			throw new SesameStorageRuntimeException("Error initializing storage repository", e);
		}
	}

	
	

}
