package org.polarsys.reqcycle.core.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.polarsys.reqcycle.prefs.ui.ReqcyclePrefsImportWizard;
import org.polarsys.reqcycle.utils.inject.ZigguratInject;

public class ImportConfigurationHandler extends AbstractHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ReqcyclePrefsImportWizard wizard = new ReqcyclePrefsImportWizard();
		ZigguratInject.inject(wizard);
		Shell shell = Display.getDefault().getActiveShell();
		WizardDialog wd = new WizardDialog(shell, wizard);
		wd.setHelpAvailable(false);
		wd.open();
		
		return null;
	}
	
}
