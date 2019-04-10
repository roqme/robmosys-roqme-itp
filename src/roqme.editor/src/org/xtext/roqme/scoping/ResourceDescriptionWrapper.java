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

package org.xtext.roqme.scoping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;

import roqme.metamodel.datatypes.RoqmeModel;
import roqme.metamodel.datatypes.TypedVariable;
import org.xtext.roqme.naming.RoQMEQualifiedNameConverter;


/**
 * This class wraps an IResourceDescription object and adds new information that is necessary when building
 * references using the imported namespace.
 * 
 * @author Juan F. Ingles Romero
 *
 */
public class ResourceDescriptionWrapper implements IResourceDescription {

	/**
	 * Wrapped resource description instance.
	 */
	private IResourceDescription m_resourceDescription;
	
	/**
	 * Imported namespace.
	 */
	private String m_namespace;
	
	/**
	 * Auxiliary constant.
	 */
	private final Iterable<IEObjectDescription> WITHOUT_RESULTS = new ArrayList<IEObjectDescription>();
	
	/**
	 * Creates an instance passing the object to wrap and the import EObject.
	 * @param resourceDescription instance to be wrapped.
	 */
	public ResourceDescriptionWrapper(IResourceDescription resourceDescription) {

		m_resourceDescription = resourceDescription;
		m_namespace = getImportedNameSpace();
	}
	
	@Override
	public boolean isEmpty() {
		return m_resourceDescription.isEmpty();
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjects(EClass type,
			QualifiedName name, boolean ignoreCase) {

		Iterable<IEObjectDescription> result = WITHOUT_RESULTS;
		
		if(m_namespace != null) {
			if(name.getFirstSegment().equals(m_namespace)) {
				result = wrapElements(m_resourceDescription.getExportedObjects(type, name.skipFirst(1), ignoreCase));
			}
		} 
		else {
			result = m_resourceDescription.getExportedObjects(type, name, ignoreCase);
		}
		return result;
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByType(
			EClass type) {

		Iterable<IEObjectDescription> result = null;
		
		if(m_namespace != null)
			result = wrapElements(m_resourceDescription.getExportedObjectsByType(type));
		else 
			result = m_resourceDescription.getExportedObjectsByType(type);
		
		return result;
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(
			EObject object) {

		Iterable<IEObjectDescription> result = null;
		
		if(m_namespace != null)
			result = wrapElements(m_resourceDescription.getExportedObjectsByObject(object));
		else 
			result = m_resourceDescription.getExportedObjectsByObject(object);
		
		return result;
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjects() {
		
		Iterable<IEObjectDescription> result = null;
		
		if(m_namespace != null)
			result = wrapElements(m_resourceDescription.getExportedObjects());
		else 
			result = m_resourceDescription.getExportedObjects();
		
		return result;
	}

	@Override
	public Iterable<QualifiedName> getImportedNames() {
		return m_resourceDescription.getImportedNames();
	}

	@Override
	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		return m_resourceDescription.getReferenceDescriptions();
	}

	@Override
	public URI getURI() {
		return m_resourceDescription.getURI();
	}
	
	/**
	 * Auxiliary method for wrapping IObjectDescription instances with EObjectDescriptionWrapper.
	 * @param elements instances to be wrapped.
	 * @return collection of wrapped elements (which are instances of EObjectDescriptionWrapper).
	 */
	protected Iterable<IEObjectDescription> wrapElements(Iterable<IEObjectDescription> elements) {
		
		List<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
		Iterator<IEObjectDescription> it = elements.iterator();
		
		while(it.hasNext()) {
			result.add(new EObjectDescriptionWrapper(it.next(), m_namespace));
		}
		return result;
	}

	/**
	 * This method allows getting the imported namespace.
	 * @return imported namespace.
	 */
	protected String getImportedNameSpace() {
		
		String result = null;
		IEObjectDescription aux;

		Iterator<IEObjectDescription> it 
			= m_resourceDescription.getExportedObjects().iterator();
	
		boolean found = false;
		
		while(!found && it.hasNext()) {
			aux = it.next();

			if(found=(aux.getEObjectOrProxy() instanceof TypedVariable)) {
				result = ((RoqmeModel)aux.getEObjectOrProxy().eContainer()).getNamespace();
			}
		}
		return (result!=null && !result.isEmpty()) ? result : null;
	}
	
	/**
	 * This class wraps an IEObjectDescription object and adds new information that 
	 * is necessary when building references using the imported namespace.
	 * 
	 * @author Juan F. Ingles Romero
	 *
	 */
	protected class EObjectDescriptionWrapper implements IEObjectDescription {
	
		/**
		 * Wrapped eobject description instance.
		 */
		private IEObjectDescription m_eobjectDescription;
		
		/**
		 * Imported namespace.
		 */
		private String m_namespace;
		
		/**
		 * This converter supports the conversion between String and QualifiedNames
		 */
		private IQualifiedNameConverter m_qualifiedNameConverter;
		
		/**
		 * Creates an instance passing the object to wrap and the imported namespace.
		 * @param eobjectDescription object to wrap.
		 * @param namespace imported namespace.
		 */
		protected EObjectDescriptionWrapper(IEObjectDescription eobjectDescription, String namespace) {
			m_eobjectDescription = eobjectDescription;
			m_qualifiedNameConverter = new RoQMEQualifiedNameConverter();
			m_namespace = namespace;
		}
		
		@Override
		public QualifiedName getName() {
			QualifiedName result = m_eobjectDescription.getName();

			if(m_namespace != null) {
				result = m_qualifiedNameConverter
						.toQualifiedName(m_namespace)
						.append(result);
			}	
			return result;		
		}
	
		@Override
		public QualifiedName getQualifiedName() {
			QualifiedName result = m_eobjectDescription.getQualifiedName();
			
			if(m_namespace != null) {
				result = m_qualifiedNameConverter
						.toQualifiedName(m_namespace)
						.append(result);
			}	
			return result;
		}
	
		@Override
		public EObject getEObjectOrProxy() {
			return m_eobjectDescription.getEObjectOrProxy();
		}
	
		@Override
		public URI getEObjectURI() {
			return m_eobjectDescription.getEObjectURI();
		}
	
		@Override
		public EClass getEClass() {
			return m_eobjectDescription.getEClass();
		}
	
		@Override
		public String getUserData(String key) {
			return m_eobjectDescription.getUserData(key);
		}
	
		@Override
		public String[] getUserDataKeys() {
			return m_eobjectDescription.getUserDataKeys();
		}
		
		public String toString() {
			return getQualifiedName().toString();
		}	
	}
	
}
