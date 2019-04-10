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

package roqme.generator;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;

import roqme.generator.cep.RoqmeCepGenerator;
import roqme.generator.project.RoqmeEmptyProjectInitializer;
import roqme.generator.project.RoqmeProjectInitializer;
import roqme.generator.reasoner.RoqmeReasonerGenerator;
import roqme.generator.smartsoft.RoqmeComponentGenerator;
import roqme.generator.viewer.GrafanaGenerator;

public class RoqmeGenerator {
	
	private static final int TOTAL_WORK = 100;
	
	public static final RoqmeGenerator INSTANCE = new RoqmeGenerator();
	
	public void generateAll(IResource selectedResource) {
		
		IWorkbench wb = PlatformUI.getWorkbench();
		IProgressService ps = wb.getProgressService();
		   
		try {
			ps.busyCursorWhile(new IRunnableWithProgress() {
				@Override
				public void run(IProgressMonitor monitor) throws InterruptedException {		
					monitor.beginTask("Generating the RoQME QoS Provider", TOTAL_WORK);
					generateAll_impl(selectedResource, monitor);
					
					// We wait some time to force the display of the progress bar dialog
					// Note that when the process spends less than getLongOperationTime, the 
					// the progress bar dialog does not appear
					Thread.sleep(ps.getLongOperationTime());
					monitor.done();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void generateAll_impl(IResource selectedResource, IProgressMonitor monitor) {
		
		int nSteps = 9;
		int subtaskWork = TOTAL_WORK / nSteps;
		
		/*
		 * Copies a SmartSoft project with supporting code
		 */
		IProject project = GenerationHelper.createProject("CommRoqmeEstimate");
		GenerationHelper.copyFiles("files/roqme-smartsoft/CommRoqmeEstimate", project, false);
		GenerationHelper.copyFile("files/roqme-smartsoft/CommRoqmeEstimate_metadata/classpath", project, ".classpath");
		GenerationHelper.copyFile("files/roqme-smartsoft/CommRoqmeEstimate_metadata/cproject", project, ".cproject");
		GenerationHelper.copyFiles("files/roqme-smartsoft/CommRoqmeEstimate_metadata/.settings", project, true);
		GenerationHelper.copyFile("files/roqme-smartsoft/CommRoqmeEstimate_metadata/project", project, ".project");
		monitor.worked(subtaskWork);

		/*
		 * Reads all the models in the selected resource
		 */
		ResourceSet models = GenerationHelper.readRoqmeMapModel(selectedResource);
		monitor.worked(subtaskWork);
		
		/*
		 * It creates a new project named "QoSMetricProvider" and executes the generator
		 * to create the SmartSoft component. 
		 */
		project = GenerationHelper.createProject("QoSMetricProvider");
		GenerationHelper.generate(
				new RoqmeComponentGenerator(project.getName(), false), models, project);
		monitor.worked(subtaskWork);
		
		/*
		 * Executes the reasoner generator
		 */
		IFolder reasonerFolder = GenerationHelper.createFolder("reasoner", project);
		GenerationHelper.generate(new RoqmeReasonerGenerator(), models, reasonerFolder);
		GenerationHelper.copyFiles("files/roqme-reasoner", reasonerFolder, false);
		monitor.worked(subtaskWork);
		
		/*
		 * Copies the DDS supporting library
		 */
		IFolder ddsFolder = GenerationHelper.createFolder("roqme-dds", project);
		GenerationHelper.copyFiles("files/roqme-dds", ddsFolder, false);
		monitor.worked(subtaskWork);
		
		/*
		 * Executes the CEP generator
		 */
		IFolder cepFolder = GenerationHelper.createFolder("event-processing", project);
		GenerationHelper.generate(new RoqmeCepGenerator(), models, cepFolder);
		GenerationHelper.copyFiles("files/roqme-cep/roqmecep-1.0.jar", cepFolder);
		monitor.worked(subtaskWork);
		
		/*
		 * Executes the graph viewer generator
		 */
		IFolder utilsFolder = GenerationHelper.createFolder("utils", project);
		IFolder viewerFolder = GenerationHelper.createFolder("viewer", utilsFolder);
		GenerationHelper.generate(
				new GrafanaGenerator("platform:/plugin/roqme.generator/files/colors.txt"), 
				models, viewerFolder);
		monitor.worked(subtaskWork);
		
		/*
		 * Copies the Roqme recorder
		 */
		IFolder recorderFolder = GenerationHelper.createFolder("recorder", utilsFolder);
		GenerationHelper.copyFiles("files/roqme-recorder/RoQMERecorder.jar", recorderFolder);
		monitor.worked(subtaskWork);

		/*
		 * Shows changes
		 */
		GenerationHelper.refresh(project);
		monitor.worked(subtaskWork);
	}
	
	public void generateRoqmeProject(String projectName, URI projectUri, List<Map<String, Object>> contexts) {
		
		IProject project = GenerationHelper.createRoqmeProject(projectName, projectUri);
		
		JavaIoFileSystemAccess fileSystemAccess 
			= GenerationHelper.INJECTOR.getInstance(JavaIoFileSystemAccess.class);

		fileSystemAccess.setOutputPath(
			IFileSystemAccess.DEFAULT_OUTPUT, 
			project.getLocation().toString());
		
		// The user has not provided any context specification
		if(contexts == null || contexts.isEmpty()) {
			(new RoqmeEmptyProjectInitializer()).generateModels(projectName, fileSystemAccess);
		}
		// The user has not provided the context settings
		else {
			(new RoqmeProjectInitializer()).generateModels(projectName, contexts, fileSystemAccess);
		}
		
		GenerationHelper.refresh(project);
		GenerationHelper.openFileInEditor(project, projectName + ".roqme");
	}
}
