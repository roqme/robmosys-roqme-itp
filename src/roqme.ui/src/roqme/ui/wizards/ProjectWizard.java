//  This file belongs to the RoQME toolchain.
//  Copyright (C) 2019  University of Extremadura, University of Málaga, Biometric Vox.
//
//  RoQME is free software; you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation; either version 3 of the License, or
//  any later version.
//
//  RoQME is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
//
//  GNU GPLv3 link: http://www.gnu.org/licenses/gpl-3.0.html

package roqme.ui.wizards;

import java.net.URI;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

import roqme.generator.RoqmeGenerator;

public class ProjectWizard extends Wizard implements INewWizard, IExecutableExtension {
	
	private WizardNewProjectCreationPage 	projectCreationPage;
	private ContextInitPage 				contextInitPage;


	public ProjectWizard() {
		setWindowTitle("Create RoQME Project");
	}

	@Override
	public void addPages() {
		super.addPages();
		
		// First wizard page
		projectCreationPage = new WizardNewProjectCreationPage("ProjectCreationPage");
		projectCreationPage.setTitle("New Project Wizard");
		projectCreationPage.setDescription("Create a new RoQME project.");
		addPage(projectCreationPage);
		
		// Second wizard page
		contextInitPage = new ContextInitPage();
		addPage(contextInitPage);
	}

	@Override
	public boolean performFinish() {
		String projectName = projectCreationPage.getProjectName();
		URI projectUri = null;
		
		if (!projectCreationPage.useDefaults()) {
			projectUri = projectCreationPage.getLocationURI();
		}
		RoqmeGenerator.INSTANCE.generateRoqmeProject(
				projectName, projectUri, contextInitPage.getContexts());

		return true;
	}
		
	@Override
	public void setInitializationData(IConfigurationElement config,String propertyName, Object data) throws CoreException {}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {}
}
