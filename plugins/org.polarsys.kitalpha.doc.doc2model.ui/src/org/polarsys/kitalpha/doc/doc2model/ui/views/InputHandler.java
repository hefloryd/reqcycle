package org.polarsys.kitalpha.doc.doc2model.ui.views;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.polarsys.kitalpha.doc.doc2model.common.Common.DocumentModel;
import org.polarsys.kitalpha.doc.doc2model.core.Doc2Model;
import org.polarsys.kitalpha.doc.doc2model.wordprocessor.wordprocessor.WPFile;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class InputHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public InputHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		InputFileDialog inputDialog = new InputFileDialog(window.getShell(), "", SWT.NONE);
		if (inputDialog.open() == Window.OK) {
			List<URI> uris = inputDialog.getURIs();
			for (URI uri : uris) {	
				//Doc2Model<ExcelFile> doc2Model = new Doc2Model<ExcelFile>();
				Doc2Model<WPFile> doc2Model = new Doc2Model<WPFile>();
				String fileString = CommonPlugin.asLocalURI(uri).toFileString();
				System.out.println(doc2Model.getFileType(fileString));
				Doc2Model<DocumentModel> d2m = new Doc2Model<DocumentModel>();
				d2m.setContentHandler(Doc2Model.getDefaultContentHandler(fileString));
				DocumentModel m = d2m.transform(fileString, DocumentModel.class).getDocModel();
				WPFile file = doc2Model/*.setContentHandler(new WPContentHandler())*/.transform(fileString, WPFile.class).getDocModel();
				//Resource r = new ResourceSetImpl().createResource(URI.createFileURI("D:/LOCAL/workspaces/runtime-reqcycle/Test/ouputWord.wp"));
				//r.getContents().add(file);
				/*try {
					r.save(Collections.emptyMap());
				} catch (IOException e) {
					e.printStackTrace();
				}*/
				
				
			}
		}
		return null;
	}
}
