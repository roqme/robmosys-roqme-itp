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

package org.xtext.roqme.ui.autoedit;

import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

/**
 * This implementation overrides the default auto edit. In Roqme, we need to disable the automatic 
 * typing of the symbols: " and '. The first may produce an exception when users write an import. The second
 * is used in Roqme as a single character for function calls. This class needs to be bound in 
 * <code>RootUiModule</code>. 
 * 
 * @author Juan F. Ingles Romero
 *
 */
public class RoQMEAutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {
		
	@Override
	protected void configureStringLiteral(IEditStrategyAcceptor acceptor) {}

}