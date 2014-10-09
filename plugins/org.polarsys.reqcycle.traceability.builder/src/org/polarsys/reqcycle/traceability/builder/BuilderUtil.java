package org.polarsys.reqcycle.traceability.builder;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;

public class BuilderUtil {

	public static boolean isBuilderInstalled(IProject project) {
		try {
			IProjectDescription desc = project.getDescription();
			ICommand[] commands = desc.getBuildSpec();
			for (int i = 0; i < commands.length; ++i) {
				if (commands[i].getBuilderName().equals(Activator.PLUGIN_ID)) {
					return true;
				}
			}
		} catch (CoreException e) {
		}
		return false;
	}

	public static void installBuilder(IProject project) {
		try {
			IProjectDescription desc = project.getDescription();
			ICommand[] commands = desc.getBuildSpec();
			ICommand command = desc.newCommand();
			command.setBuilderName(Activator.PLUGIN_ID);
			ICommand[] newCommands = new ICommand[commands.length + 1];

			// Add it after other builders.
			System.arraycopy(commands, 0, newCommands, 0, commands.length);
			newCommands[commands.length] = command;
			desc.setBuildSpec(newCommands);
			project.setDescription(desc, null);
		} catch (CoreException e) {
		}
	}

	public static void removeBuilder(IProject project) {
		try {
			IProjectDescription desc = project.getDescription();
			ICommand[] commands = desc.getBuildSpec();
			ICommand[] newCommands = new ICommand[commands.length - 1];
			for (int i = 0, j = 0; i < commands.length; i++) {
				if (!commands[i].getBuilderName().equals(Activator.PLUGIN_ID)) {
					newCommands[j] = commands[i];
					j++;
				}
			}
			desc.setBuildSpec(newCommands);
			project.setDescription(desc, null);
		} catch (CoreException e) {
		}
	}
}
