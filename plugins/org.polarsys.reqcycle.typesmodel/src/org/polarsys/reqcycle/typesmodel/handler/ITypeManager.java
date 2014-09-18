package org.polarsys.reqcycle.typesmodel.handler;

import java.util.List;

import org.polarsys.reqcycle.inittypes.inittypes.FileType;
import org.polarsys.reqcycle.inittypes.inittypes.Type;
import org.polarsys.reqcycle.inittypes.inittypes.TypeModel;

public interface ITypeManager {
	TypeModel getModel ();
    
    List<FileType> getFileTypes ();
    
    List<Type> getAllTypesPerFileTypes(String fileName);
}
