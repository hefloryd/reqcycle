/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Anass RADOUANI (Atos) anass.radouani@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.polarsys.reqcycle.typesmodel.handler;

import java.util.List;

import javax.inject.Singleton;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.polarsys.reqcycle.inittypes.inittypes.FileType;
import org.polarsys.reqcycle.inittypes.inittypes.Type;
import org.polarsys.reqcycle.inittypes.inittypes.TypeModel;

/**
 * Manager singleton
 * 
 */
@Singleton
public class IniManager implements ITypeManager
{

    IniManagerRegistry registry = new IniManagerRegistry();

    public IniManager()
    {
        try
        {
            ResourcesPlugin.getWorkspace().getRoot().accept(registry);
            ResourcesPlugin.getWorkspace().addResourceChangeListener(new IniResourceChangeListener(registry));
        }
        catch (CoreException e)
        {
        }
    }

    public TypeModel getModel ()
    {
        return registry.getTypeModel();
    }
    
    public List<FileType> getFileTypes ()
    {
        return registry.getTypeModel().getFileTypes();
    }
    
    public List<Type> getAllTypesPerFileTypes(String fileName){
    	return registry.getTypeModel().getTypes(fileName);
    }

    public void save(IFile typesFile, FileType documentType)
    {
        IniManagerRegistry.save(typesFile, documentType);
        
    }
    
}
