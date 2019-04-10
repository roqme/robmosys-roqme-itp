package org.xtext.roqmemapping.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;

import com.google.inject.Binder;

import org.xtext.roqmemapping.ui.AbstractRoQMEMappingUiModule;
import org.xtext.roqmemapping.ui.syntaxcoloring.RoQMEMappingAntlrTokenToAttributeIdMapper;
import org.xtext.roqmemapping.ui.syntaxcoloring.RoQMEMappingHighlightingConfiguration;


/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class RoQMEMappingUiModule extends AbstractRoQMEMappingUiModule {
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration;
  
	public RoQMEMappingUiModule(final AbstractUIPlugin plugin) {
		super(plugin);
	}
  
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return RoQMEMappingHighlightingConfiguration.class;
	}

	public void configureAbstractAntlrTokenToAttributeIdMapper(Binder binder) {
		binder.bind(AbstractAntlrTokenToAttributeIdMapper.class).to(RoQMEMappingAntlrTokenToAttributeIdMapper.class);
	}
}