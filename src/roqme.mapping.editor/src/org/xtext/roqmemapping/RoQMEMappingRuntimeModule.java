package org.xtext.roqmemapping;

import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class RoQMEMappingRuntimeModule extends AbstractRoQMEMappingRuntimeModule {
	
	public RoQMEMappingRuntimeModule() {
		super();
	}
	
	@Override
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return ImportUriGlobalScopeProvider.class;
	}
}