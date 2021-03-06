/*
 * generated by Xtext 2.12.0
 */
package org.xtext.roqmemapping.ide

import com.google.inject.Guice
import org.eclipse.xtext.util.Modules2
import org.xtext.roqmemapping.RoQMEMappingRuntimeModule
import org.xtext.roqmemapping.RoQMEMappingStandaloneSetup

/**
 * Initialization support for running Xtext languages as language servers.
 */
class RoQMEMappingIdeSetup extends RoQMEMappingStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new RoQMEMappingRuntimeModule, new RoQMEMappingIdeModule))
	}
	
}
