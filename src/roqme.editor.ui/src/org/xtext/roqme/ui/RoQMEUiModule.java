package org.xtext.roqme.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;

import com.google.inject.Binder;

import org.xtext.roqme.ui.AbstractRoQMEUiModule;
import org.xtext.roqme.ui.autoedit.RoQMEAutoEditStrategyProvider;
import org.xtext.roqme.ui.syntaxcoloring.RoQMEAntlrTokenToAttributeIdMapper;
import org.xtext.roqme.ui.syntaxcoloring.RoQMEHighlightingConfiguration;


/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class RoQMEUiModule extends AbstractRoQMEUiModule {
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration;
  
	public RoQMEUiModule(final AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return RoQMEAutoEditStrategyProvider.class;
	}
  
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return RoQMEHighlightingConfiguration.class;
	}

	public void configureAbstractAntlrTokenToAttributeIdMapper(Binder binder) {
		binder.bind(AbstractAntlrTokenToAttributeIdMapper.class).to(RoQMEAntlrTokenToAttributeIdMapper.class);
	}
}