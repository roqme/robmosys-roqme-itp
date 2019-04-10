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

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.ClasspathUriResolutionException;
import org.eclipse.xtext.resource.IClasspathUriResolver;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import org.eclipse.xtext.scoping.impl.LoadOnDemandResourceDescriptions;
import org.eclipse.xtext.scoping.impl.SelectableBasedScope;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.IResourceScopeCache;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Extension of the Xtext Gobal Scope Provider to allow using alias in the Roqme import mechanism. 
 * The implementation is based on the class <code>ImportUriGlobalScopeProvider</code>. This class
 * need to be bound in <code>RootRuntimeModule</code>.
 * <pre><code>
 * import "models/mymodel.roqme" as model1
 * ...
 * // referring to a variable defined in mymodel.roqme
 * model1.variable1
 * </pre></code>
 * 
 * @author Juan F. Ingles Romero
 *
 */
public class RoQMEImportUriScopeProvider extends AbstractGlobalScopeProvider {

	/**
	 * URI attribute resolver for getting the value of the URI attribute in the import element. By default, 
	 * it looks for "importURI". It is instantiated by Google Guice.
	 */
	@Inject
	private ImportUriResolver importResolver;
	
	/**
	 * This provider allows obtaining Resource Descriptions that are used to build the scope object. 
	 * It is instantiated by Google Guice.
	 */
	@Inject
	private Provider<LoadOnDemandResourceDescriptions> loadOnDemandDescriptions;
	
	/**
	 * Cache object that maps a collection of ImportURITuple objects with resources.
	 * It is instantiated by Google Guice.
	 */
	@Inject
	private IResourceScopeCache cache;
	
	
	/**
	 * Gets the URI attribute resolver for obtaining the value of the configured URI in an import element.
	 * @return import URI attribute resolver.
	 */
	public ImportUriResolver getImportUriResolver() {
		return importResolver;
	}
	
	/**
	 * Sets the URI attribute resolver for obtaining the value of the configured URI in an import element.
	 * @param importResolver URI attribute resolver.
	 */
	public void setImportResolver(ImportUriResolver importResolver) {
		this.importResolver = importResolver;
	}
	
	/**
	 * Sets the cache for mapping collections of ImportURITuple objects with resources.
	 * @param cache cache object.
	 */
	public void setCache(IResourceScopeCache cache) {
		this.cache = cache;
	}
	

	public IResourceDescriptions getResourceDescriptions(Resource resource, Collection<URI> importUris) {
		IResourceDescriptions result = getResourceDescriptions(resource);
		LoadOnDemandResourceDescriptions demandResourceDescriptions = loadOnDemandDescriptions.get();
		demandResourceDescriptions.initialize(result, importUris, resource);
		return demandResourceDescriptions;
	}
	
	
	/**
	 * Gets the scope (collection of references) by obtaining the external references from the resources linked by
	 * the import elements in the model (contained in the given resource).
	 */
	@Override
	protected IScope getScope(Resource resource, boolean ignoreCase, EClass type, Predicate<IEObjectDescription> filter) {
		final LinkedHashSet<ImportUriTuple> uniqueImportURIs = getImportedUris(resource);
		IResourceDescriptions descriptions = getResourceDescriptions(resource, extractURIs(uniqueImportURIs));
		List<ImportUriTuple> urisAsList = Lists.newArrayList(uniqueImportURIs);
		Collections.reverse(urisAsList);
		IScope scope = IScope.NULLSCOPE;
		for (ImportUriTuple tuple : urisAsList) {
			scope = createLazyResourceScope(scope, tuple, descriptions, type, filter, ignoreCase);
		}
		
		return scope;
	}
	
	/**
	 * Auxiliary method to get a collection of ImportUriTuple objects associated with a resource. Note that
	 * each ImportUriTuple contains the information of each import element configured in a model 
	 * (that is saved in a passed resource).
	 * @param resource resource that contains the main model.
	 * @return a collection of ImportUriTuple objects.
	 */
	protected LinkedHashSet<ImportUriTuple> getImportedUris(final Resource resource) {
		
		// Search in the cache instances (sets of ImportUriTuple) associated with a concrete resource. If the search returns
		// no result then it execute the passed provider.
		return cache.get(ImportUriGlobalScopeProvider.class.getName(), resource, new Provider<LinkedHashSet<ImportUriTuple>>(){
			public LinkedHashSet<ImportUriTuple> get() {
				final LinkedHashSet<ImportUriTuple> uniqueImportURIs = new LinkedHashSet<ImportUriTuple>(5);
				IAcceptor<ImportUriTuple> collector = createURICollector(resource, uniqueImportURIs);
				TreeIterator<EObject> iterator = resource.getAllContents();
				EObject object;
				while (iterator.hasNext()) {
					object = iterator.next();
					collector.accept(new ImportUriTuple(object, importResolver.apply(object)));
				}
				Iterator<ImportUriTuple> uriIter = uniqueImportURIs.iterator();
				while(uriIter.hasNext()) {
					if (!EcoreUtil2.isValidUri(resource, uriIter.next().getUri()))
						uriIter.remove();
				}
				return uniqueImportURIs;
			}
		});
	}
	
	/**
	 * Auxiliary method for creating RoqmeURICollector objects.
	 * @param resource resource where the main model is contained.
	 * @param collectInto it may be an empty set.
	 * @return new Roqme URI collector instance.
	 */
	protected IAcceptor<ImportUriTuple> createURICollector(Resource resource, Set<ImportUriTuple> collectInto) {
		ResourceSet resourceSet = resource.getResourceSet();
		return new RoqmeURICollector(resourceSet, collectInto);
	}

	/**
	 * Auxiliary method for creating scope instances and stacking result.
	 * 
	 * @param parent parent scope.
	 * @param tuple identifies an import element.
	 * @param descriptions resource descriptions.
	 * @param type
	 * @param filter
	 * @param ignoreCase
	 * @return
	 */
	protected IScope createLazyResourceScope(IScope parent, final ImportUriTuple tuple, final IResourceDescriptions descriptions,
			EClass type, final Predicate<IEObjectDescription> filter, boolean ignoreCase) {
		
		IResourceDescription description = descriptions.getResourceDescription(tuple.getUri());		
		
		if(description != null)
			description = new ResourceDescriptionWrapper(description);
		
		return SelectableBasedScope.createScope(parent, description, filter, type, ignoreCase);
	}

	public void setLoadOnDemandDescriptions(Provider<LoadOnDemandResourceDescriptions> loadOnDemandDescriptions) {
		this.loadOnDemandDescriptions = loadOnDemandDescriptions;
	}

	public Provider<LoadOnDemandResourceDescriptions> getLoadOnDemandDescriptions() {
		return loadOnDemandDescriptions;
	}

	/**
	 * Auxiliary method for creating a collection of URI objects from a collection of ImportUriTuples.
	 * @param tuples collection of tuples with the information of the import elements in the model.
	 * @return collection of URI objects.
	 */
	private Collection<URI> extractURIs(Collection<ImportUriTuple> tuples) {
		
		Collection<URI> result = new LinkedHashSet<URI>();	
		Iterator<ImportUriTuple> it = tuples.iterator();
		
		while(it.hasNext()) {
			result.add(it.next().getUri());
		}
		return result;
	}
	
	
	/**
	 * This class represents a set of <code>ImportUriTuple</code>. It allows resolving the 
	 * URI objects attribute in <code>ImportUriTuple</code>, for that it uses the 
	 * <code>IClasspathUriResolver</code> in the <code>XtextResourceSet</code>.
	 * 
	 * @author Juan F. Ingles Romero
	 *
	 */
	public static class RoqmeURICollector implements IAcceptor<ImportUriTuple> {
		
		private IClasspathUriResolver uriResolver;
		private Object uriContext;
		private Set<ImportUriTuple> result;

		/**
		 * Creates an instance passing a ResourceSet and a set of ImportUriTuple. This set
		 * may be empty but not null. Otherwise, an IllegalArgumentException is got.
		 * 
		 * @param resourceSet Resource set.
		 * @param result Set of import tuples that cannot be null.
		 */
		protected RoqmeURICollector(ResourceSet resourceSet, Set<ImportUriTuple> result) {

			if (result == null)
				throw new IllegalArgumentException();
			
			this.result = result;
			
			if (resourceSet instanceof XtextResourceSet) {
				uriResolver = ((XtextResourceSet) resourceSet).getClasspathUriResolver();
				uriContext = ((XtextResourceSet) resourceSet).getClasspathURIContext();
			}
		}

		/**
		 * Resolves the URI that the user writes in the import element.
		 * 
		 * @param uriAsString URI written in the import element.
		 * @return resolved URI object.
		 * @throws IllegalArgumentException
		 */
		public URI resolve(String uriAsString) throws IllegalArgumentException {
					
			URI uri = URI.createURI(uriAsString);
			if (uriResolver != null) {
				try {
					return uriResolver.resolve(uriContext, uri);
				} catch(ClasspathUriResolutionException e) {
					return uri;
				}
			}
			return uri;
		}

		/**
		 * This method accepts a new ImportUriTuple in the collection. Before adding
		 * the new element, it resolves the URI calling the resolve method, if the URI 
		 * cannot be resolved then it is ignored.
		 */
		public void accept(ImportUriTuple tuple) {
			if (tuple == null || tuple.getUriAsString() == null) {
				return;
			}
			try {
				URI importUri = resolve(tuple.getUriAsString());
				if (importUri != null) {
					tuple.setUri(importUri);
					result.add(tuple);
				}
			} catch(IllegalArgumentException e) {
				// ignore, invalid uri given
			}
		}
	}
	
	
	/**
	 * This class helps keeping the necessary information from import elements to later 
	 * manage the inclusion of the alias in the qualified names.
	 * 
	 * @author Juan F. Ingles Romero
	 *
	 */
	public class ImportUriTuple {
		
		/**
		 * Import object in the Roqme model.
		 */
		private EObject m_importElement;
		
		/**
		 * Resolved URI object configured in the import.
		 */
		private URI m_uri;
		
		/**
		 * URI string typed in the import.
		 */
		private String m_uriAsString;
		
		/**
		 * Creates an instance using the import EObject in the model and the configured URI string.
		 * @param importElement Roqme import element.
		 * @param uriAsString configured URI in the import. 
		 */
		protected ImportUriTuple(EObject importElement, String uriAsString) {
			m_importElement = importElement;
			m_uriAsString = uriAsString;
		}
		
		/**
		 * Creates an instance using the import EObject in the model, the configured URI string 
		 * and the resolved URI object.
		 * @param importElement Roqme import element.
		 * @param uriAsString configured URI in the import. 
		 * @param uri resolved URI object.
		 */
		protected ImportUriTuple(EObject importElement, String uriAsString, URI uri) {
			m_importElement = importElement;
			m_uriAsString = uriAsString;
			m_uri = uri;
		}
		
		/**
		 * Returns the Import EObject reference.
		 * @return Roqme import element.
		 */
		public EObject getImport() {
			return m_importElement;
		}
		
		/**
		 * Returns the configured URI in the import element.
		 * @return URI as string.
		 */
		public String getUriAsString() {
			return m_uriAsString;
		}
		
		/**
		 * Returns the resolved URI object configured in the import element.
		 * @return resolved URI object.
		 */
		public URI getUri() {
			return m_uri;
		}
		
		/**
		 * Sets the resolved URI object configured in the import element.
		 * @param uri resolved URI object.
		 */
		public void setUri(URI uri) {
			m_uri = uri;
		}
	}

}

