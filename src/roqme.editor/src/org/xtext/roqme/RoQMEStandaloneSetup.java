/**
 * generated by Xtext 2.12.0
 */
package org.xtext.roqme;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.common.TerminalsStandaloneSetup;

import com.google.inject.Injector;

import org.xtext.roqme.RoQMEStandaloneSetupGenerated;
import roqme.metamodel.datatypes.DatatypesPackage;
import roqme.metamodel.expressions.ExpressionsPackage;
import roqme.metamodel.kernel.KernelPackage;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class RoQMEStandaloneSetup extends RoQMEStandaloneSetupGenerated {
  
	public static void doSetup() {  	  
		new RoQMEStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	@Override
	public Injector createInjectorAndDoEMFRegistration() {

		if (!EPackage.Registry.INSTANCE.containsKey("https://robmosys.eu/roqme/datatypes")) {
			EPackage.Registry.INSTANCE.put("https://robmosys.eu/roqme/datatypes", DatatypesPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("https://robmosys.eu/roqme/expressions")) {
			EPackage.Registry.INSTANCE.put("https://robmosys.eu/roqme/expressions", ExpressionsPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("https://robmosys.eu/roqme/kernel")) {
			EPackage.Registry.INSTANCE.put("https://robmosys.eu/roqme/kernel", KernelPackage.eINSTANCE);
		}
		
		return super.createInjectorAndDoEMFRegistration();
	}
}
