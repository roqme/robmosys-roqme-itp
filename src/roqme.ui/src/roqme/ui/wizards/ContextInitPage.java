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

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.ecore.base.basicAttributes.AbstractAttributeType;
import org.ecore.base.basicAttributes.AttributeDefinition;
import org.ecore.base.basicAttributes.InlineEnumerationType;
import org.ecore.base.basicAttributes.PrimitiveType;
import org.ecore.service.communicationObject.AbstractCommElement;
import org.ecore.service.communicationObject.CommElementReference;
import org.ecore.service.communicationObject.CommunicationObject;
import org.ecore.service.communicationObject.Enumeration;
import org.ecore.service.communicationPattern.CommunicationPattern;
import org.ecore.service.communicationPattern.EventPattern;
import org.ecore.service.communicationPattern.PushPattern;
import org.ecore.service.communicationPattern.QueryPattern;
import org.ecore.service.communicationPattern.SendPattern;
import org.ecore.service.serviceDefinition.AbstractServiceDefinition;
import org.ecore.service.serviceDefinition.CommunicationServiceDefinition;
import org.ecore.service.serviceDefinition.ForkingServiceDefinition;
import org.ecore.service.serviceDefinition.JoiningServiceDefinition;
import org.ecore.service.serviceDefinition.RequestAnswerServiceDefinition;
import org.ecore.service.serviceDefinition.ServiceDefModel;
import org.ecore.service.serviceDefinition.ServiceDefRepository;
import org.xtext.service.communicationObject.CommunicationObjectRuntimeModule;
import org.xtext.service.serviceDefinition.ServiceDefinitionRuntimeModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class ContextInitPage extends WizardPage {

	private static final String[] FILTER_NAMES = { "Services (*.services)" };
	private static final String[] FILTER_EXTS = { "*.services"};
	
	private Composite 			container;
	private TableEditor 		contextTableEditor;
	private Table 				contextTable;
	private Button 				btnLoad;
	private Button 				btnAdd;
	private Tree 				servicesTree;
	private Injector 			injector;
	
	private ServiceData 		working_serviceData;
	private List<AttributeData> working_attrsData;
	private TreeItem 			working_currentTreeItem;
	
	private int					contextCounter;

	public ContextInitPage() {		
		super("contextInitPage");
		setTitle("SmartSoft Context Providers");
		setDescription("Select attributes providing context data from communication objects in service definitions.");

		injector = Guice.createInjector(new ServiceDefinitionRuntimeModule());
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
				.put("services", injector.getInstance(IResourceFactory.class));
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
				.put("types", Guice.createInjector(new CommunicationObjectRuntimeModule())
						.getInstance(IResourceFactory.class));
	
		working_attrsData = new ArrayList<AttributeData>();
		contextCounter = 0;
	}

	public List<Map<String, Object>> getContexts() {
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		HashMap<String, Object> contextData;
		TableItem items[] = contextTable.getItems();
		
		for(int i=0; i<items.length; i++) {
			contextData = (HashMap<String, Object>) ((AttributeData) items[i].getData()).toMap();
			contextData.put("context", items[i].getText(1));
			result.add(contextData);
		}
		return result;
	}
	
	@Override
	public void createControl(Composite parent) {
		
		container = new Composite(parent, SWT.NONE);
		setControl(container);
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		container.setLayout(gridLayout);
		
		Label repositoryLabel = new Label(container, SWT.NONE);
		repositoryLabel.setText("Repositories");
		GridData gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
	    gridData.horizontalSpan = 2;
	    repositoryLabel.setLayoutData(gridData);
	    
		/*
		 * Creating the tree to show the SmartSoft services
		 */
		servicesTree = new Tree(container, SWT.Selection | /*SWT.CHECK |*/ SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan = 2;
		gridData.verticalSpan = 3;
		gridData.heightHint = 150;
		servicesTree.setLayoutData(gridData);
	    
		/*
		 * Creating the button to load model repositories
		 */
	    btnLoad = new Button(container, SWT.NONE);
	    btnLoad.setText("Load repository");
	    gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
	    gridData.horizontalSpan = 2;
	    btnLoad.setLayoutData(gridData);
	    btnLoad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dlg = new FileDialog(getShell(), SWT.OPEN);
				dlg.setFilterNames(FILTER_NAMES);
				dlg.setFilterExtensions(FILTER_EXTS);
				dlg.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
				String selection = dlg.open();
				if (selection != null) {
					loadRepository(selection);
				}
			}
		});
		
		/*
		 * Creating the context table
		 */
		contextTable = new Table(container, 
				SWT.SINGLE | SWT.FULL_SELECTION | SWT.HIDE_SELECTION | 
				SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan = 2;
		gridData.verticalSpan = 3;
		gridData.heightHint = 100;
		contextTable.setLayoutData(gridData);
		String[] titles = { "Attribute", "Context Name" };

		TableColumn column1 = new TableColumn(contextTable, SWT.LEFT);
		column1.setText(titles[0]);

		TableColumn column2 = new TableColumn(contextTable, SWT.LEFT);
		column2.setText(titles[1]);

		for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
			contextTable.getColumn(loopIndex).pack();
		}

		contextTable.setHeaderVisible(true);
		contextTable.setLinesVisible(true);

		contextTableEditor = new TableEditor(contextTable);
		contextTableEditor.horizontalAlignment = SWT.LEFT;
		contextTableEditor.grabHorizontal = true;
		
		// This listener allows changing the name of a context in the second column 
		contextTable.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent event) {
				Control old = contextTableEditor.getEditor();
				if (old != null)
					old.dispose();

				// Click coordinates
				Point pt = new Point(event.x, event.y);

				// Looks for the selected cell
				TableItem item = contextTable.getItem(pt);
				if (item != null) {
					int column = -1;
					for (int i = 0, n = contextTable.getColumnCount(); i < n; i++) {
						Rectangle rect = item.getBounds(i);
						if (rect.contains(pt)) {
							column = i;
							break;
						}
					}
					// It cannot be column 0
					if (column >= 1) {
						final Text text = new Text(contextTable, SWT.NONE);
						text.setForeground(item.getForeground());
						text.setText(item.getText(column));
						text.setForeground(item.getForeground());
						text.selectAll();
						text.setFocus();
						contextTableEditor.minimumWidth = text.getBounds().width;

						contextTableEditor.setEditor(text, item, column);

						final int col = column;
						// Listener to update the cell value
						text.addModifyListener(new ModifyListener() {
							public void modifyText(ModifyEvent event) {
								item.setText(col, text.getText());
							}
						});
					}
				}
			}
		});
		
		/*
		 * Creating the "Add Context" button
		 */
		btnAdd = new Button(container, SWT.NONE);
		btnAdd.setText("Add context");
		gridData = new GridData(SWT.END, SWT.CENTER, true, false);
		btnAdd.setLayoutData(gridData);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				TreeItem selection[] = servicesTree.getSelection();
				
				if(selection.length > 0 
						&& selection[0].getData() != null
						&& selection[0].getData() instanceof AttributeData) 
				{	
					AttributeData attrData = (AttributeData) selection[0].getData();
					TableItem item = new TableItem(contextTable, SWT.NONE);
					item.setData(attrData);
					item.setText(0, attrData.stringForTable()); // First column
					item.setText(1, "context" + String.valueOf(contextCounter++)); // Second column
				}
			}
		});
		
		/*
		 * Creating the "Remove Context" button
		 */
		Button btnRemove = new Button(container, SWT.NONE);
		btnRemove.setText("Remove context");
		gridData = new GridData(SWT.END, SWT.CENTER, false, false);
		btnRemove.setLayoutData(gridData);
		btnRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(contextTable.getSelectionCount() > 0) {
					contextTable.remove(contextTable.getSelectionIndex());
				}
			}
		});
	}
	
	private void loadRepository(String servicesModelPath) {
		
		File servicesFile = new File(servicesModelPath); 
		File repositoryDir = servicesFile.getParentFile();

		File typesFiles[] = repositoryDir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".types");
			}
		});
		
		XtextResourceSet xtextResourceSet = injector.getInstance(XtextResourceSet.class);

		for(int i=0; i< typesFiles.length; i++) {
			xtextResourceSet.getResource(
					URI.createURI("file:" + typesFiles[i].getAbsolutePath()), true);
		}
		
		XtextResource xtextResource = (XtextResource) xtextResourceSet.getResource(
				URI.createURI("file:" + servicesFile.getAbsolutePath()), true);
		EcoreUtil.resolveAll(xtextResource);
		addServicesToTree(xtextResource);
	}
	
	private void addServicesToTree(XtextResource resource) {
		
		Iterator<EObject> it = resource.getContents().iterator();
		ServiceDefRepository repoObj;
		EObject eobj = null;
		boolean found = false;
		
		while(!found && it.hasNext()) {
			found = ((eobj = it.next()) instanceof ServiceDefModel);
		}

		if(found) {
			working_currentTreeItem = new TreeItem(servicesTree, SWT.NONE);
			repoObj = ((ServiceDefModel)eobj).getRepository();
			working_currentTreeItem.setText("Repository " + repoObj.getName());
			
			Iterator<AbstractServiceDefinition> srvIt = repoObj.getServices().iterator();
			
			while(srvIt.hasNext()) {
				eobj = srvIt.next();
				if(eobj instanceof CommunicationServiceDefinition) {
					processService((CommunicationServiceDefinition) eobj);
				}
			}
		}
	}
	
	public void processService(CommunicationServiceDefinition service) {
		
		working_currentTreeItem = new TreeItem(working_currentTreeItem, SWT.NONE);
		working_serviceData = new ServiceData(service.eResource(), 
				((ServiceDefRepository)service.eContainer()).getName(), service.getName());
		
		if(service instanceof ForkingServiceDefinition) {
			working_currentTreeItem.setText( service.getName());
			processPattern(((ForkingServiceDefinition) service).getPattern());
		}
		else if(service instanceof JoiningServiceDefinition) {
			working_currentTreeItem.setText(service.getName());
			processPattern(((JoiningServiceDefinition) service).getPattern());
		}
		else if(service instanceof RequestAnswerServiceDefinition) {
			working_currentTreeItem.setText(service.getName());
			processPattern(((RequestAnswerServiceDefinition) service).getPattern());
		}
	}
	
	public void processPattern(CommunicationPattern pattern) {
		
		TreeItem auxItem;
		String aux = working_currentTreeItem.getText();
		working_attrsData.clear();
		
		if(pattern instanceof PushPattern) {
			working_currentTreeItem.setText(aux + " : PushPattern");
			processCommElement("", ((PushPattern) pattern).getDataType());
			createAttrsTreeItems(working_currentTreeItem);
		}
		else if(pattern instanceof EventPattern) {
			working_currentTreeItem.setText(aux + " : EventPattern");
			
			auxItem = new TreeItem(working_currentTreeItem, SWT.NONE);
			auxItem.setText("[Event]");
			processCommElement("", ((EventPattern) pattern).getEventType());
			createAttrsTreeItems(auxItem);
			
			auxItem = new TreeItem(working_currentTreeItem, SWT.NONE);
			auxItem.setText("[State]");
			working_attrsData.clear();
			processCommElement("", ((EventPattern) pattern).getEventStateType());
			createAttrsTreeItems(auxItem);
			
			auxItem = new TreeItem(working_currentTreeItem, SWT.NONE);
			auxItem.setText("[Activation]");
			working_attrsData.clear();
			processCommElement("", ((EventPattern) pattern).getActivationType());
			createAttrsTreeItems(auxItem);
		}
		else if(pattern instanceof SendPattern) {
			working_currentTreeItem.setText(aux + " : SendPattern");
			processCommElement("", ((SendPattern) pattern).getDataType());
			createAttrsTreeItems(working_currentTreeItem);
		}
		else if(pattern instanceof QueryPattern) {
			working_currentTreeItem.setText(aux + " : QueryPattern");
			
			auxItem = new TreeItem(working_currentTreeItem, SWT.NONE);
			auxItem.setText("[Request]");
			processCommElement("", ((QueryPattern) pattern).getRequestType());
			createAttrsTreeItems(auxItem);
			
			auxItem = new TreeItem(working_currentTreeItem, SWT.NONE);
			auxItem.setText("[Asnwer]");
			working_attrsData.clear();
			processCommElement("", ((QueryPattern) pattern).getAnswerType());
			createAttrsTreeItems(auxItem);
		}
	}
	
	public void processCommElement(
			String attrPath, AbstractCommElement commElement) 
	{
		AbstractAttributeType attrType;
		AttributeDefinition attrDef;
		
		if(commElement instanceof CommunicationObject) {
			String root = attrPath.isEmpty() ? attrPath : attrPath + ".";
			
			Iterator<AttributeDefinition> iterator 
				= ((CommunicationObject)commElement).getAttributes().iterator();
		
			while(iterator.hasNext()) {
				attrDef = (AttributeDefinition) iterator.next();
				attrType = attrDef.getType();
				
				if(attrType instanceof CommElementReference) {
					processCommElement(root + attrDef.getName(), 
						((CommElementReference) attrType).getTypeName());
				}
				else {
					working_attrsData.add( new AttributeData(
							working_serviceData, root + attrDef.getName(), attrType));
				}
			}
		}
		else {
			working_attrsData.add( new AttributeData(
					working_serviceData, attrPath, commElement));
		}
	}
	
	void createAttrsTreeItems(TreeItem parent) {

		TreeItem item;
		AttributeData attr;
		Iterator<AttributeData> iterator = working_attrsData.iterator();
		
		while(iterator.hasNext()) {
			attr = iterator.next();
			item = new TreeItem(parent, SWT.NONE);
			item.setData(attr);
			item.setText(attr.toString());
		}
	}
	
	protected class ServiceData {
		private Resource resource;
		private String repository;
		private String service;
		
		protected ServiceData(Resource resource, String repository, String service) {
			this.resource = resource;
			this.repository = repository;
			this.service = service;
		}
		
		public Resource getResource() 	{ return resource;	}
		public String getRepository() 	{ return repository;}
		public String getService() 		{ return service;	}
	}
	
	protected class AttributeData {
		private ServiceData service;
		private String attribute;
		private EObject attrType;
		
		protected AttributeData(ServiceData serviceData, String attribute, EObject attrType) {
			this.service = serviceData;
			this.attribute = attribute;
			this.attrType = attrType;
		}
		
		public ServiceData getServiceData() { return service; 	}
		public String getAttribute() 		{ return attribute;	}
		public EObject getAttrType() 		{ return attrType;	}
		
		public String stringForTable() {
			return service.getRepository() + "." + service.getService() + " : " + toString();
		}
		
		public String toString() {
			String result = attribute;
			if(attrType instanceof PrimitiveType) {
				result += " [" + ((PrimitiveType)attrType).getTypeName() + "]";
			}
			else if(attrType instanceof InlineEnumerationType || 
					attrType instanceof Enumeration) 
			{
				result += " [Enum]";
			}
			return result; 
		}
		
		public Map<String, Object> toMap() {
			HashMap<String, Object> result = new HashMap<String, Object>();
			
			result.put("resource", service.getResource());
			result.put("repository", service.getRepository());
			result.put("service", service.getService());
			result.put("attribute", attribute);
			result.put("attrType", attrType);
			
			return result;
		}
	}
}
