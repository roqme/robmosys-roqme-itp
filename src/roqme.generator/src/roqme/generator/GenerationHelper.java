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

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator2;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.util.CancelIndicator;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import roqme.mapping.editor.ui.internal.EditorActivator;
import roqme.metamodel.datatypes.RoqmeModel;
import roqme.metamodel.datatypes.Sentence;
import roqme.metamodel.mapping.Import;
import roqme.metamodel.mapping.MappingModel;

public class GenerationHelper {

	public static final Injector INJECTOR 
			= EditorActivator.getInstance().getInjector(
					EditorActivator.ORG_XTEXT_ROQMEMAPPING_ROQMEMAPPING);

	
	/**
	 * Creates a new Roqme project with the given name. If the project already exists, 
	 * the method only returns the corresponding reference.
	 *  
	 * @param name Project name.
	 * @return An object representing the project.
	 */
	public static IProject createRoqmeProject(String name) {
		return createRoqmeProject(name, null);
	}
	
	
	/**
	 * Creates a new Roqme project with the given name. If the project already exists, 
	 * the method only returns the corresponding reference.
	 *  
	 * @param name Project name.
	 * @param location Project location.
	 * @return An object representing the project.
	 */
	public static IProject createRoqmeProject(String name, java.net.URI location) {
		IProject project = null;
		
		try {
			IProgressMonitor progressMonitor = new NullProgressMonitor();
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			project = root.getProject(name);
			
			if(!project.exists()) {
				java.net.URI projectUri = (location != null 
						&& root.getLocationURI().equals(location)) ? null : location;
				
				IProjectDescription description = project.getWorkspace().newProjectDescription(name);
				description.setLocationURI(projectUri);
				description.setNatureIds(new String[] {XtextProjectHelper.NATURE_ID});
				project.create(description, progressMonitor);
			}
			project.open(progressMonitor);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return project;
	}
	
	
	/**
	 * Creates a new Eclipse project with the given name. If the project already exists, 
	 * the method only returns the corresponding reference.
	 *  
	 * @param name Project name.
	 * @return An object representing the project.
	 */
	public static IProject createProject(String name) {
		return createProject(name, null);
	}
	
	
	/**
	 * Creates a new Eclipse project with the given name. If the project already exists, 
	 * the method only returns the corresponding reference.
	 *  
	 * @param name Project name.
	 * @param location Project location.
	 * @return An object representing the project.
	 */
	public static IProject createProject(String name, java.net.URI location) {
		IProject project = null;
		
		try {
			IProgressMonitor progressMonitor = new NullProgressMonitor();
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			project = root.getProject(name);
			
			if(!project.exists()) {
				java.net.URI projectUri = (location != null 
						&& root.getLocationURI().equals(location)) ? null : location;
				
				IProjectDescription description = project.getWorkspace().newProjectDescription(name);
				description.setLocationURI(projectUri);
				project.create(description, progressMonitor);
			}
			project.open(progressMonitor);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return project;
	}

	
	/**
	 * Creates a folder in an existing project. If the folder already exists, the
	 * method only returns the corresponding reference.
	 * @param name Folder name.
	 * @param destination Project or Folder where the folder is created.
	 * @return An object representing the folder.
	 */
	public static IFolder createFolder(String name, IResource destination) {
		IFolder folder = null;
		
		try {
			IProgressMonitor progressMonitor = new NullProgressMonitor();

			if(destination != null) {
				if(destination.getType() == IFolder.FOLDER) {
					folder = ((IFolder)destination).getFolder(name);
				}
				else if(destination.getType() == IProject.PROJECT) {
					folder = ((IProject)destination).getFolder(name);
				}

				if(folder != null && !folder.exists()) {
					folder.create(true, true, progressMonitor);
				}
				//folder.setDerived(true, progressMonitor);
			}
		} 
		catch (CoreException e) {
			e.printStackTrace();
		}
		return folder;
	}
	
	/**
	 * Reads all the models with a given extension in a location.
	 * @param source Object representing a folder (IFolder), a project (IProject) or
	 * a file (IFile).
	 * @param extension Model extension.
	 * @return Set containing all the models read. 
	 */
	public static ResourceSet readAllModels(IResource source, String extension) {
		ResourceSet resourceSet = INJECTOR.getInstance(XtextResourceSet.class);
		Resource xtextResource;
		IResource[] resources = null;
		
		try {
			if(source.getType() == IResource.PROJECT) {
				resources = ((IProject) source).members();
			}
			else if(source.getType() == IResource.FOLDER) {
				resources = ((IFolder) source).members();
			}
			else if(source.getType() == IResource.FILE) {
				resources = new IResource[] { source };
			}
				
			if(resources != null) {
				for(int i=0; i<resources.length; i++) {
					
					if(resources[i].getType() == IResource.FILE
							&& resources[i].getFileExtension().equalsIgnoreCase(extension)) 
					{
						xtextResource = resourceSet.getResource(
								URI.createURI(resources[i].getLocationURI().toString()), true);
						EcoreUtil.resolveAll(xtextResource);	
					}
				}
			}
		} 
		catch (CoreException e) {
			e.printStackTrace();
		}
		return resourceSet;
	}
	
	
	public static ResourceSet readRoqmeMapModel(IResource roqmeMap) {
		
		Resource roqmemapRes = null;
		URI uri, absUri;
		IResource file;
		File typesFiles[];
		EObject eobj = null;
		
		ResourceSet resourceSet = INJECTOR.getInstance(XtextResourceSet.class);

		if(roqmeMap.getType() == IResource.FILE
				&& roqmeMap.getFileExtension().equalsIgnoreCase("roqmemap")) 
		{
			roqmemapRes = resourceSet.getResource(
					URI.createURI(roqmeMap.getLocationURI().toString()), true);
			
			Iterator<EObject> itEObject = roqmemapRes.getContents().iterator();
			boolean foundRoot = false;
			
			while(!foundRoot && itEObject.hasNext()) {
				foundRoot = (eobj = itEObject.next()) instanceof MappingModel;
			}
			
			if(foundRoot) {
				Iterator<Import> itImports = ((MappingModel) eobj).getImports().iterator();
				
				while(itImports.hasNext()) {
					
					uri = URI.createURI(itImports.next().getImportURI());
					absUri = null;
					
					if(!uri.hasAbsolutePath()) {
						file = roqmeMap.getParent().findMember(uri.path());
						if(file != null && file.getType() == IResource.FILE) {
							absUri = URI.createURI(file.getLocationURI().toString());
						}
					}
					else {
						absUri = uri;
					}
					
					if(absUri != null) {
						resourceSet.getResource(absUri, true);
						
						if(absUri.fileExtension().equalsIgnoreCase("services")) {
	
							typesFiles = (new File(absUri.path())).getParentFile().listFiles(
								new FilenameFilter() {
									@Override
									public boolean accept(File dir, String name) {
										return name.endsWith(".types");
									}
								});
							
							for(int i=0; i<typesFiles.length; i++) {
								resourceSet.getResource(
									URI.createURI("file:" + typesFiles[i].getAbsolutePath()), true);
							}
						}
					}
				}
				EcoreUtil.resolveAll(resourceSet);
			}
		}
		return resourceSet;
	}

	
	public static ResourceSet readAllImportedRoqmeModels(IResource roqmeMap) {
		
		ResourceSet resultingSet = INJECTOR.getInstance(XtextResourceSet.class);
		EObject eobj = null;
		URI uri;
		IResource resource;
		Resource res;
		
		if(roqmeMap.getType() == IResource.FILE) {
		
			try {
				Resource mappingRes = INJECTOR.getInstance(XtextResourceSet.class)
						.getResource(URI.createURI(roqmeMap.getLocationURI().toString()), true);
				
				Iterator<EObject> itEObject = mappingRes.getContents().iterator();
				boolean foundRoot = false;
				
				while(!foundRoot && itEObject.hasNext()) {
					foundRoot = (eobj = itEObject.next()) instanceof MappingModel;
				}
				
				if(foundRoot) {
					Iterator<Import> itImports = ((MappingModel) eobj).getImports().iterator();
					
					while(itImports.hasNext()) {
						uri = URI.createURI(itImports.next().getImportURI());
						
						if(uri.fileExtension().equalsIgnoreCase("roqme")) {
							
							if(!uri.hasAbsolutePath()) {
								resource = roqmeMap.getParent().findMember(uri.path());
								
								if(resource != null && resource.getType() == IResource.FILE) {
									res = resultingSet.getResource(
											URI.createURI(resource.getLocationURI().toString()), true);
									readRecursiveImportedRoqmeModels(res, resultingSet);
								}
							}
							else {
								res = resultingSet.getResource(uri, true);
								readRecursiveImportedRoqmeModels(res, resultingSet);
							}
						}
					}
					EcoreUtil.resolveAll(resultingSet);
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultingSet;
	}

	
	private static void readRecursiveImportedRoqmeModels(Resource roqmeRes, ResourceSet resourceSet) {
		
		if(roqmeRes == null) return;
		
		Iterator<EObject> itEObject = roqmeRes.getContents().iterator();
		EObject eobj = null;
		boolean foundRoot = false;
		
		while(!foundRoot && itEObject.hasNext()) {
			foundRoot = (eobj = itEObject.next()) instanceof RoqmeModel;
		}
		
		if(foundRoot) {
			Iterator<Sentence> sentencesIt = ((RoqmeModel) eobj).getSentences().iterator();
			URI uri;
			Resource resource = null;
			Sentence sentence;
			
			while(sentencesIt.hasNext()) {
				
				if( (sentence = sentencesIt.next()) instanceof Import) {
					uri = URI.createURI(((Import)sentence).getImportURI());	
				
					if(uri.fileExtension().equalsIgnoreCase("roqme")) {

						if(!uri.hasAbsolutePath()) {
							resource = resourceSet.getResource(
									roqmeRes.getURI().trimSegments(1)
									.appendSegments(uri.segments()), true);
						}
						else {
							resource = resourceSet.getResource(uri, true);
						}
						readRecursiveImportedRoqmeModels(resource, resourceSet);
					}
				}
			}
		}
	}
	
	
	/**
	 * Invokes a specific code generation.
	 * @param generator Code generator.
	 * @param source Models from which the generation is executed.
	 * @param destination Indicates where the result is generated.
	 */
	public static void generate(IGenerator2 generator, ResourceSet source, IResource destination) {
		GeneratorContext context;
	
		JavaIoFileSystemAccess fileSystemAccess 
			= INJECTOR.getInstance(JavaIoFileSystemAccess.class);
		
		fileSystemAccess.setOutputPath(
				IFileSystemAccess.DEFAULT_OUTPUT, 
				destination != null ? destination.getLocation().toString() 
						: ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
		
		for(Resource resource : source.getResources()) {
			context = new GeneratorContext();
			context.setCancelIndicator(CancelIndicator.NullImpl);

			try {
				generator.beforeGenerate(resource, fileSystemAccess, context);
				generator.doGenerate(resource, fileSystemAccess, context);
			} finally {
				generator.afterGenerate(resource, fileSystemAccess, context);
			}
		}		
	}
	
	/**
	 * Updates a given project or folder to make its changes visible in Eclipse.
	 * @param resource Project (IProject) or folder (IFolder) to refresh.
	 */
	public static void refresh(IResource resource) {
		
		IResource resToUpdate = resource != null ? resource 
				: ResourcesPlugin.getWorkspace().getRoot();

		try {
			// If the resource is a project, we close and open it because
			// sometimes it is not enough refreshing it
			if(resToUpdate instanceof IProject) {
				IProgressMonitor monitor = new NullProgressMonitor();
				((IProject) resToUpdate).close(monitor);
				((IProject) resToUpdate).open(monitor);
			}
			resToUpdate.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} 
		catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Open the given file in an appropriate editor.
	 * @param resource Project or folder
	 * @param fileName The file to open.
	 */
	public static void openFileInEditor(IResource resource, String fileName) {
	
		IResource resourceToOpen = resource.getType() == IResource.PROJECT ? 
				((IProject) resource).findMember(fileName) :
				resource.getType() == IResource.FOLDER ?
				((IFolder) resource).findMember(fileName) : null;

		if(resourceToOpen != null && resourceToOpen.getType() == IResource.FILE) {
			IFile fileToOpen = (IFile) resourceToOpen;
			
			// Get the active page
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			
			// Figure out the default editor for the file type based on extension
			IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(fileToOpen.getName());
		
			if(desc != null) {
				try {
					page.openEditor(new FileEditorInput(fileToOpen), desc.getId());
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		}
	}	
	
	/**
	 * Copies a file or a folder (and its content) in the destination folder or project.
	 * @param sourcePath Source folder or file.
	 * @param destFolder Destination folder or project.
	 */
	public static void copyFiles(String sourcePath, IResource destination) {
		copyFiles(sourcePath, destination, true);
	}
	
	/**
	 * Copies a file or a folder (and its content) in the destination folder or project.
	 * @param sourcePath Source folder or file.
	 * @param destFolder Destination folder or project.
	 * @param createRootDirectory Indicates whether or not the root directory should be created in the destination.
	 */
	public static void copyFiles(String sourcePath, IResource destination, boolean createRootDirectory) {

		Bundle bundle = Platform.getBundle("roqme.generator");
		URL fileURL = bundle.getEntry(sourcePath);
		
		try {
			File source = new File(FileLocator.resolve(fileURL).getPath());
			
			if(destination instanceof IProject) {
				copyFiles(source, (IProject) destination, createRootDirectory);
			}
			else if(destination instanceof IFolder) {
				copyFiles(source, (IFolder) destination, createRootDirectory);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	private static void copyFiles(File source, IResource destination, boolean createDirectory) 
			throws IOException, CoreException 
	{	
		if(source.isDirectory()) {	
			IFolder folder = null;
			
			if(createDirectory) {
				if(destination instanceof IProject) {
					folder = ((IProject)destination).getFolder(source.getName());
				}
				else if(destination instanceof IFolder) {
					folder = ((IFolder)destination).getFolder(source.getName());
				}
				if(folder != null && !folder.exists()) {
					folder.create(true, true, new NullProgressMonitor());
				}
			}

			File files[] = source.listFiles();		    		
			for (File file : files) {
				copyFiles(file, createDirectory?folder:destination, true);
			}
		}
		else {
			IFile file = null;
			
			if(destination instanceof IProject) {
				file = ((IProject)destination).getFile(source.getName());
			}
			else if(destination instanceof IFolder) {
				file = ((IFolder)destination).getFile(source.getName());
			}
			if(file != null) {
				InputStream in = new FileInputStream(source);

				if(file.exists())
					file.setContents(in, true, false, new NullProgressMonitor());
				else
					file.create(in, true, new NullProgressMonitor());
				
				in.close();
			}
		}	
	}
	
	/**
	 * Copies a file in the specified destination (folder or project).
	 * @param sourcePath Source folder or file.
	 * @param destFolder Destination folder or project.
	 * @param newName Name for the copied file.
	 */
	public static void copyFile(String sourcePath, IResource destination, String newName) {
		
		Bundle bundle = Platform.getBundle("roqme.generator");
		URL fileURL = bundle.getEntry(sourcePath);
		
		try {
			IFile file = null;

			if(destination instanceof IProject) {
				file = ((IProject) destination).getFile(newName);				
			}
			else if(destination instanceof IFolder) {
				file = ((IFolder) destination).getFile(newName);
			}
			
			if(file != null) {
				InputStream in = FileLocator.resolve(fileURL).openStream();
				
				if(file.exists()) {
					file.setContents(in, true, false, new NullProgressMonitor());
				} else {
					file.create(in, 
							newName.startsWith(".") ? 
									(IResource.HIDDEN | IResource.FORCE) : IResource.FORCE, 
							new NullProgressMonitor());
				}
				
				in.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
