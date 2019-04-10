package roqme.generator.smartsoft;

import com.google.common.collect.Iterables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import roqme.generator.smartsoft.RoqmeComponentTemplate;
import roqme.metamodel.mapping.MappingModel;

@SuppressWarnings("all")
public class RoqmeComponentGenerator extends AbstractGenerator {
  private RoqmeComponentTemplate template;
  
  public RoqmeComponentGenerator(final String projectName, final boolean createProject) {
    RoqmeComponentTemplate _roqmeComponentTemplate = new RoqmeComponentTemplate(projectName, createProject);
    this.template = _roqmeComponentTemplate;
  }
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    boolean _equalsIgnoreCase = resource.getURI().fileExtension().equalsIgnoreCase("roqmemap");
    if (_equalsIgnoreCase) {
      Iterable<MappingModel> _filter = Iterables.<MappingModel>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), MappingModel.class);
      for (final MappingModel mappModel : _filter) {
        this.template.compile(mappModel, fsa);
      }
    }
  }
}
