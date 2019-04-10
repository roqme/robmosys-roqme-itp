package roqme.generator.viewer;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.io.CharStreams;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import roqme.metamodel.datatypes.BooleanType;
import roqme.metamodel.datatypes.ContainedDeclaration;
import roqme.metamodel.datatypes.DataType;
import roqme.metamodel.datatypes.DataTypeDeclaration;
import roqme.metamodel.datatypes.EnumLiteral;
import roqme.metamodel.datatypes.EnumType;
import roqme.metamodel.datatypes.EnumValue;
import roqme.metamodel.datatypes.EventType;
import roqme.metamodel.datatypes.InbuiltDeclaration;
import roqme.metamodel.datatypes.ReferencedDeclaration;
import roqme.metamodel.datatypes.RoqmeModel;
import roqme.metamodel.datatypes.Sentence;
import roqme.metamodel.datatypes.TypedValue;
import roqme.metamodel.datatypes.TypedVariable;
import roqme.metamodel.expressions.BinaryTermOp;
import roqme.metamodel.expressions.ConstTerm;
import roqme.metamodel.expressions.NaryTermOp;
import roqme.metamodel.expressions.Term;
import roqme.metamodel.expressions.UnaryTermOp;
import roqme.metamodel.expressions.VarTerm;
import roqme.metamodel.kernel.Action;
import roqme.metamodel.kernel.Observation;
import roqme.metamodel.kernel.Parameter;
import roqme.metamodel.kernel.SetEvidence;
import roqme.metamodel.kernel.Timer;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class GrafanaGenerator extends AbstractGenerator {
  public static class State {
    private int counter;
    
    public State(final int counter) {
      this.counter = counter;
    }
    
    public void incState() {
      this.counter = (this.counter + 1);
    }
    
    public void clearState() {
      this.counter = 0;
    }
    
    public void incPositionX() {
      int _counter = this.counter;
      this.counter = (_counter + 12);
    }
    
    public void incPositionY() {
      int _counter = this.counter;
      this.counter = (_counter + 9);
    }
    
    public int getState() {
      return this.counter;
    }
  }
  
  public static class Color {
    private String name;
    
    private String code;
    
    public Color(final String name, final String code) {
      this.name = name;
      this.code = code;
    }
  }
  
  public static class Colors {
    private String uri;
    
    private List<GrafanaGenerator.Color> colors;
    
    public Colors(final String uri1) {
      try {
        this.uri = uri1;
        URL url = new URL(uri1);
        InputStream _inputStream = url.openConnection().getInputStream();
        InputStreamReader reader = new InputStreamReader(_inputStream);
        final Function1<String, GrafanaGenerator.Color> _function = (String line) -> {
          final Iterator<String> segments = ((List<String>)Conversions.doWrapArray(line.split(","))).iterator();
          String _valueOf = String.valueOf(segments.next());
          String _valueOf_1 = String.valueOf(segments.next());
          return new GrafanaGenerator.Color(_valueOf, _valueOf_1);
        };
        this.colors = ListExtensions.<String, GrafanaGenerator.Color>map(CharStreams.readLines(reader), _function);
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
    
    public List<GrafanaGenerator.Color> getColors() {
      return this.colors;
    }
  }
  
  private String pathColors;
  
  private DataType type;
  
  public GrafanaGenerator(final String pathColors) {
    this.pathColors = pathColors;
  }
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    boolean _equalsIgnoreCase = resource.getURI().fileExtension().equalsIgnoreCase("roqme");
    if (_equalsIgnoreCase) {
      Iterable<RoqmeModel> _filter = Iterables.<RoqmeModel>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), RoqmeModel.class);
      for (final RoqmeModel e : _filter) {
        {
          GrafanaGenerator.Colors colorsClass = new GrafanaGenerator.Colors(this.pathColors);
          List<GrafanaGenerator.Color> lColors = colorsClass.getColors();
          fsa.generateFile(
            "GrafanaDashboard.json", 
            "DEFAULT_OUTPUT", 
            this.generateDashboard(e, lColors));
          fsa.generateFile(
            "docker-compose.yml", 
            "DEFAULT_OUTPUT", 
            this.generateDockerCompose());
        }
      }
    }
  }
  
  public CharSequence generateDockerCompose() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("influxdb:");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("image: influxdb:1.6.1");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("container_name: influxdb");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ports:");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("- \"8083:8083\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("- \"8086:8086\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("- \"8090:8090\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("volumes:");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("# Data persistency");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("- ./var-lib-influxdb:/var/lib/influxdb");
    _builder.newLine();
    _builder.append("grafana:");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("image: grafana/grafana:5.0.0");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("container_name: grafana");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("ports:");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("- \"3000:3000\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("links:");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("- influxdb");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("volumes:");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("# Data persistency");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("# sudo mkdir -p ./var-lib-grafana; chown smartsoft:smartsoft ./var-lib-grafana");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("- ./var-lib-grafana:/var/lib/grafana");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateDashboard(final RoqmeModel roqmeModel, final List<GrafanaGenerator.Color> lColors) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"__inputs\": [");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"name\": \"");
    String _namespace = roqmeModel.getNamespace();
    _builder.append(_namespace, "      ");
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    _builder.append("      ");
    _builder.append("\"label\": \"");
    String _namespace_1 = roqmeModel.getNamespace();
    _builder.append(_namespace_1, "      ");
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    _builder.append("      ");
    _builder.append("\"description\": \"\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"type\": \"datasource\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"pluginId\": \"influxdb\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"pluginName\": \"InfluxDB\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"__requires\": [");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"type\": \"grafana\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"id\": \"grafana\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"name\": \"Grafana\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"version\": \"5.3.2\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"type\": \"panel\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"id\": \"graph\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"name\": \"Graph\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"version\": \"5.0.0\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"type\": \"datasource\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"id\": \"influxdb\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"name\": \"InfluxDB\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"version\": \"5.0.0\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"annotations\": {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"list\": [");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("\"builtIn\": 1,");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("\"datasource\": \"-- Grafana --\",");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("\"enable\": true,");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("\"hide\": true,");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("\"iconColor\": \"rgba(0, 211, 255, 1)\",");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("\"name\": \"Annotations & Alerts\",");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("\"type\": \"dashboard\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"editable\": true,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"gnetId\": null,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"graphTooltip\": 0,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"id\": null,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"links\": [],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"panels\": [");
    _builder.newLine();
    _builder.append("    ");
    LinkedList<TypedVariable> list = new LinkedList<TypedVariable>();
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    LinkedList<TypedVariable> normalList = new LinkedList<TypedVariable>();
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    LinkedList<TypedVariable> metricsList = new LinkedList<TypedVariable>();
    _builder.newLineIfNotEmpty();
    {
      EList<TypedVariable> _variables = roqmeModel.getVariables();
      for(final TypedVariable variable : _variables) {
        {
          DataTypeDeclaration _declaration = variable.getDeclaration();
          if ((_declaration instanceof ContainedDeclaration)) {
            _builder.append("    ");
            DataTypeDeclaration _declaration_1 = variable.getDeclaration();
            ContainedDeclaration conDec = ((ContainedDeclaration) _declaration_1);
            _builder.newLineIfNotEmpty();
            {
              if ((((((conDec.getType() instanceof EventType) || (conDec.getType() instanceof EnumType)) || (conDec.getType() instanceof BooleanType)) && (!(variable instanceof Parameter))) && (!(variable instanceof Timer)))) {
                _builder.append("    ");
                list.addLast(variable);
                _builder.newLineIfNotEmpty();
              }
            }
            {
              if ((((!(((conDec.getType() instanceof EventType) || (conDec.getType() instanceof EnumType)) || (conDec.getType() instanceof BooleanType))) && (!(variable instanceof Parameter))) && (!(variable instanceof Timer)))) {
                _builder.append("    ");
                normalList.addLast(variable);
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          if ((((variable.getDeclaration() instanceof InbuiltDeclaration) && (!(variable instanceof Parameter))) && (!(variable instanceof Timer)))) {
            _builder.append("    ");
            metricsList.addLast(variable);
            _builder.newLineIfNotEmpty();
          }
        }
        {
          DataTypeDeclaration _declaration_2 = variable.getDeclaration();
          if ((_declaration_2 instanceof ReferencedDeclaration)) {
            _builder.append("    ");
            DataTypeDeclaration _declaration_3 = variable.getDeclaration();
            ReferencedDeclaration cRef = ((ReferencedDeclaration) _declaration_3);
            _builder.newLineIfNotEmpty();
            _builder.append("    ");
            DataType type = cRef.getType().getDataType();
            _builder.newLineIfNotEmpty();
            {
              if ((((type instanceof EventType) || (type instanceof EnumType)) || (type instanceof BooleanType))) {
                _builder.append("    ");
                list.addLast(variable);
                _builder.newLineIfNotEmpty();
              }
            }
            {
              if ((!(((type instanceof EventType) || (type instanceof EnumType)) || (type instanceof BooleanType)))) {
                _builder.append("    ");
                normalList.addLast(variable);
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.append("    ");
    Integer x = new Integer(0);
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    LinkedList<Integer> ln = new LinkedList<Integer>();
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    ln.add(0, x);
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    GrafanaGenerator.State y = new GrafanaGenerator.State(0);
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    GrafanaGenerator.State xax = new GrafanaGenerator.State(0);
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    GrafanaGenerator.State id = new GrafanaGenerator.State(0);
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _generatePanelsPoints = this.generatePanelsPoints(roqmeModel, list, xax, y, id, lColors);
    _builder.append(_generatePanelsPoints, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _generatePanels = this.generatePanels(roqmeModel, normalList, id, xax, y, lColors);
    _builder.append(_generatePanels, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _generatePanelsMetrics = this.generatePanelsMetrics(roqmeModel, metricsList, id, xax, y, lColors);
    _builder.append(_generatePanelsMetrics, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"refresh\": \"1s\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"schemaVersion\": 16,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"style\": \"dark\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"tags\": [],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"templating\": {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"list\": []");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"time\": {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"from\": \"now-15m\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"to\": \"now\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"timepicker\": {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"refresh_intervals\": [");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"1s\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"2s\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"5s\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"0s\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"30s\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"1m\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"5m\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"15m\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"30m\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"1h\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"2h\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"1d\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"time_options\": [");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"5m\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"15m\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"1h\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"6h\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"12h\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"24h\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"2d\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"7d\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"30d\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"timezone\": \"\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"title\": \"RoQME\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"uid\": \"hcRqpXTmk\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"version\": 24");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generatePanelsPoints(final RoqmeModel roqmeModel, final LinkedList<TypedVariable> types, final GrafanaGenerator.State x, final GrafanaGenerator.State y, final GrafanaGenerator.State id, final List<GrafanaGenerator.Color> lColors) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    LinkedList<String> lAlias = new LinkedList<String>();
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("\"bars\": false,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"dashLength\": 10,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"dashes\": false,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"datasource\": \"${");
    String _namespace = roqmeModel.getNamespace();
    _builder.append(_namespace, "  ");
    _builder.append("}\",");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("\"fill\": 0,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"gridPos\": {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"h\": 6,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"w\": 24,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"x\": 0,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"y\": ");
    int _state = y.getState();
    _builder.append(_state, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    y.incPositionY();
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"id\": ");
    int _state_1 = id.getState();
    _builder.append(_state_1, "  ");
    _builder.append(",");
    id.incState();
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("\"legend\": {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"avg\": false,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"current\": false,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"max\": false,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"min\": false,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"show\": true,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"total\": false,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"values\": false");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"lines\": false,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"linewidth\": 2,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"nullPointMode\": \"null\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"percentage\": false,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"pointradius\": 2,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"points\": true,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"renderer\": \"flot\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"seriesOverrides\": [],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"spaceLength\": 10,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"stack\": false,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"steppedLine\": false,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"targets\": [");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generateBoolEvenEnumVariable = this.generateBoolEvenEnumVariable(roqmeModel, types, lAlias);
    _builder.append(_generateBoolEvenEnumVariable, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"aliasColors\": {");
    _builder.newLine();
    {
      boolean _hasElements = false;
      for(final String alias : lAlias) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "  ");
        }
        _builder.append("  ");
        _builder.append("\"");
        _builder.append(alias, "  ");
        _builder.append("\" : \"");
        {
          int _size = lColors.size();
          int _modulo = (_size % 2);
          boolean _equals = (_modulo == 0);
          if (_equals) {
            _builder.append(lColors.remove(0).code, "  ");
            _builder.append("\"");
          } else {
            int _size_1 = lColors.size();
            int _minus = (_size_1 - 1);
            _builder.append(lColors.remove(_minus).code, "  ");
            _builder.append("\"");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
      }
    }
    lAlias.clear();
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"thresholds\": [],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"timeFrom\": null,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"timeShift\": null,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"title\": \"Discrets Contexts\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"tooltip\": {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"shared\": true,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"sort\": 0,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"value_type\": \"individual\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"type\": \"graph\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"xaxis\": {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"buckets\": null,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"mode\": \"time\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"name\": null,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"show\": true,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"values\": []");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"yaxes\": [");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"format\": \"short\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"label\": null,");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"logBase\": 1,");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"max\": null,");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"min\": null,");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"show\": true");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"format\": \"short\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"label\": null,");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"logBase\": 1,");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"max\": null,");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"min\": null,");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"show\": true");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"yaxis\": {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"align\": false,");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"alignLevel\": null");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("},");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generatePanels(final RoqmeModel roqmeModel, final LinkedList<TypedVariable> normals, final GrafanaGenerator.State id, final GrafanaGenerator.State x, final GrafanaGenerator.State y, final List<GrafanaGenerator.Color> lColors) {
    StringConcatenation _builder = new StringConcatenation();
    LinkedList<String> lAlias = new LinkedList<String>();
    _builder.newLineIfNotEmpty();
    LinkedList<String> lObs = new LinkedList<String>();
    _builder.newLineIfNotEmpty();
    {
      for(final TypedVariable variable : normals) {
        _builder.append("{");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"bars\": false,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"dashLength\": 10,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"dashes\": false,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"datasource\": \"${");
        String _namespace = roqmeModel.getNamespace();
        _builder.append(_namespace, "  ");
        _builder.append("}\",");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("\"fill\": 0,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"gridPos\": {");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"h\": 6,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"w\": 24,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"x\": 0,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"y\": ");
        int _state = y.getState();
        _builder.append(_state, "    ");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        y.incPositionY();
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"id\": ");
        int _state_1 = id.getState();
        _builder.append(_state_1, "  ");
        id.incState();
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("\"legend\": {");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"avg\": false,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"current\": false,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"max\": false,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"min\": false,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"show\": true,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"total\": false,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"values\": false");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"lines\": true,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"linewidth\": 2,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"nullPointMode\": \"connected\",");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"percentage\": false,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"pointradius\": 5,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"points\": false,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"renderer\": \"flot\",");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"seriesOverrides\": [],");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"spaceLength\": 10,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"stack\": false,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"steppedLine\": false,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"targets\": [");
        _builder.newLine();
        _builder.append("\t");
        CharSequence _generateNormalVariable = this.generateNormalVariable(roqmeModel, variable, false, lAlias, lObs);
        _builder.append(_generateNormalVariable, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("],");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"aliasColors\": {");
        _builder.newLine();
        {
          boolean _hasElements = false;
          for(final String alias : lAlias) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "  ");
            }
            _builder.append("  ");
            _builder.append("\"");
            _builder.append(alias, "  ");
            _builder.append("\" : \"");
            {
              int _size = lColors.size();
              int _modulo = (_size % 2);
              boolean _equals = (_modulo == 0);
              if (_equals) {
                _builder.append(lColors.remove(0).code, "  ");
                _builder.append("\"");
              } else {
                int _size_1 = lColors.size();
                int _minus = (_size_1 - 1);
                _builder.append(lColors.remove(_minus).code, "  ");
                _builder.append("\"");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
          }
        }
        lAlias.clear();
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"seriesOverrides\": [");
        _builder.newLine();
        {
          boolean _hasElements_1 = false;
          for(final String obs : lObs) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder.appendImmediate(",", "  ");
            }
            _builder.append("  ");
            _builder.append("{");
            _builder.newLine();
            _builder.append("  ");
            _builder.append(" ");
            _builder.append("\"alias\": \"");
            _builder.append(obs, "   ");
            _builder.append("\",");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            _builder.append(" ");
            _builder.append("\"nullPointMode\": \"null\"\t  \t");
            _builder.newLine();
            _builder.append("  ");
            _builder.append("}");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("],");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"thresholds\": [],");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"timeFrom\": null,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"timeShift\": null,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"title\": \"");
        String _name = variable.getName();
        _builder.append(_name, "  ");
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("\"tooltip\": {");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"shared\": true,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"sort\": 0,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"value_type\": \"individual\"");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"type\": \"graph\",");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"xaxis\": {");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"buckets\": null,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"mode\": \"time\",");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"name\": null,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"show\": true,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"values\": []");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"yaxes\": [");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("{");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"format\": \"short\",");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"label\": null,");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"logBase\": 1,");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"max\": null,");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"min\": null,");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"show\": true");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("},");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("{");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"format\": \"short\",");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"label\": null,");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"logBase\": 1,");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"max\": null,");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"min\": null,");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"show\": true");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("],");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"yaxis\": {");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"align\": false,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"alignLevel\": null");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("},");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence generatePanelsMetrics(final RoqmeModel roqmeModel, final LinkedList<TypedVariable> normals, final GrafanaGenerator.State id, final GrafanaGenerator.State x, final GrafanaGenerator.State y, final List<GrafanaGenerator.Color> lColors) {
    StringConcatenation _builder = new StringConcatenation();
    LinkedList<String> lAlias = new LinkedList<String>();
    LinkedList<String> lObs = new LinkedList<String>();
    _builder.newLineIfNotEmpty();
    {
      boolean _hasElements = false;
      for(final TypedVariable variable : normals) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n},", "");
        }
        _builder.append("{");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"bars\": false,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"dashLength\": 10,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"dashes\": false,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"datasource\": \"${");
        String _namespace = roqmeModel.getNamespace();
        _builder.append(_namespace, "  ");
        _builder.append("}\",");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("\"fill\": 0,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"gridPos\": {");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"h\": 6,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"w\": 24,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"x\": 0,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"y\": ");
        int _state = y.getState();
        _builder.append(_state, "    ");
        y.incPositionY();
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"id\": ");
        int _state_1 = id.getState();
        _builder.append(_state_1, "  ");
        id.incState();
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("\"legend\": {");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"avg\": false,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"current\": false,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"max\": false,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"min\": false,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"show\": true,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"total\": false,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"values\": false");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"lines\": true,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"linewidth\": 2,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"nullPointMode\": \"connected\",");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"percentage\": false,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"pointradius\": 5,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"points\": false,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"renderer\": \"flot\",");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"seriesOverrides\": [],");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"spaceLength\": 10,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"stack\": false,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"steppedLine\": false,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"targets\": [");
        _builder.newLine();
        _builder.append("\t");
        CharSequence _generateNormalVariable = this.generateNormalVariable(roqmeModel, variable, true, lAlias, lObs);
        _builder.append(_generateNormalVariable, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("],");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"aliasColors\": {");
        {
          boolean _hasElements_1 = false;
          for(final String alias : lAlias) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder.appendImmediate(",", "  ");
            }
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            _builder.append("\"");
            _builder.append(alias, "  ");
            _builder.append("\" : \"");
            {
              int _size = lColors.size();
              int _modulo = (_size % 2);
              boolean _equals = (_modulo == 0);
              if (_equals) {
                _builder.append(lColors.remove(0).code, "  ");
                _builder.append("\"");
              } else {
                int _size_1 = lColors.size();
                int _minus = (_size_1 - 1);
                _builder.append(lColors.remove(_minus).code, "  ");
                _builder.append("\"");
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
          }
        }
        lAlias.clear();
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"seriesOverrides\": [");
        _builder.newLine();
        {
          boolean _hasElements_2 = false;
          for(final String obs : lObs) {
            if (!_hasElements_2) {
              _hasElements_2 = true;
            } else {
              _builder.appendImmediate(",", "  ");
            }
            _builder.append("  ");
            _builder.append("{");
            _builder.newLine();
            _builder.append("  ");
            _builder.append(" ");
            _builder.append("\"alias\": \"");
            _builder.append(obs, "   ");
            _builder.append("\",");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            _builder.append(" ");
            _builder.append("\"nullPointMode\": \"null\"\t  \t");
            _builder.newLine();
            _builder.append("  ");
            _builder.append("}");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("],      ");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"thresholds\": [],");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"timeFrom\": null,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"timeShift\": null,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"title\": \"");
        String _name = variable.getName();
        _builder.append(_name, "  ");
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("\"tooltip\": {");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"shared\": true,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"sort\": 0,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"value_type\": \"individual\"");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"type\": \"graph\",");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"xaxis\": {");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"buckets\": null,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"mode\": \"time\",");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"name\": null,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"show\": true,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"values\": []");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"yaxes\": [");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("{");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"format\": \"short\",");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"label\": null,");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"logBase\": 1,");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"max\": null,");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"min\": null,");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"show\": true");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("},");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("{");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"format\": \"short\",");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"label\": null,");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"logBase\": 1,");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"max\": null,");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"min\": null,");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"show\": true");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("],");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"yaxis\": {");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"align\": false,");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\"alignLevel\": null");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  /**
   * GENERAR NORMAL
   */
  public CharSequence generateNormalMetric(final RoqmeModel roqmeModel, final TypedVariable variable, final LinkedList<String> lAlias) {
    StringConcatenation _builder = new StringConcatenation();
    LinkedList<String> obs = new LinkedList<String>();
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"alias\": \"");
    String _name = variable.getName();
    _builder.append(_name, "  ");
    _builder.append("\",");
    lAlias.addLast(variable.getName());
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("\"groupBy\": [");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"params\": [");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("\"$__interval\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"type\": \"time\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"params\": [");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("\"null\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"type\": \"fill\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"measurement\": \"Out_Estimate\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"orderByTime\": \"ASC\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"policy\": \"default\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"refId\": \"A\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"resultFormat\": \"time_series\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"select\": [");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("[");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("\"params\": [");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("\"");
    String _name_1 = variable.getName();
    _builder.append(_name_1, "          ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("\"type\": \"field\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("\"params\": [],");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("\"type\": \"mean\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"tags\": []");
    _builder.newLine();
    _builder.append("},");
    CharSequence _generateObservations = this.generateObservations(roqmeModel, variable.getName(), obs);
    _builder.append(_generateObservations);
    _builder.newLineIfNotEmpty();
    CharSequence _printObs = this.printObs(obs, lAlias);
    _builder.append(_printObs);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  /**
   * GENERAR NORMAL
   */
  public CharSequence generateNormalVariable(final RoqmeModel roqmeModel, final TypedVariable variable, final boolean metric, final LinkedList<String> lAlias, final LinkedList<String> lObs) {
    StringConcatenation _builder = new StringConcatenation();
    LinkedList<String> obs = new LinkedList<String>();
    LinkedList<String> obsMetrics = new LinkedList<String>();
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"alias\": \"");
    String _name = variable.getName();
    _builder.append(_name, "  ");
    _builder.append("\",");
    lAlias.addLast(variable.getName());
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("\"groupBy\": [");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"params\": [");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("\"$__interval\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"type\": \"time\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"params\": [");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("\"null\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"type\": \"fill\"");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"measurement\": ");
    {
      if (metric) {
        _builder.append("\"Out_Estimate\",");
      } else {
        _builder.append("\"In_Context\",");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("\"orderByTime\": \"ASC\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"policy\": \"default\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"refId\": \"A\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"resultFormat\": \"time_series\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"select\": [");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("[");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("\"params\": [");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("\"");
    String _name_1 = variable.getName();
    _builder.append(_name_1, "          ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("\"type\": \"field\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("\"params\": [],");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("\"type\": \"mean\"");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("]");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"tags\": []");
    _builder.newLine();
    _builder.append("}");
    {
      DataTypeDeclaration _declaration = variable.getDeclaration();
      if ((_declaration instanceof InbuiltDeclaration)) {
        CharSequence _generateObservationsMetrics = this.generateObservationsMetrics(roqmeModel, variable.getName(), obsMetrics);
        _builder.append(_generateObservationsMetrics);
        {
          int _size = obsMetrics.size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append(",");
            CharSequence _printObs = this.printObs(obsMetrics, lAlias);
            _builder.append(_printObs);
            {
              for(final String ob : obsMetrics) {
                {
                  boolean _contains = lObs.contains(ob);
                  boolean _not = (!_contains);
                  if (_not) {
                    lObs.addLast(ob);
                  }
                }
              }
            }
          }
        }
      }
    }
    {
      DataTypeDeclaration _declaration_1 = variable.getDeclaration();
      boolean _not_1 = (!(_declaration_1 instanceof InbuiltDeclaration));
      if (_not_1) {
        CharSequence _generateObservations = this.generateObservations(roqmeModel, variable.getName(), obs);
        _builder.append(_generateObservations);
        {
          int _size_1 = obs.size();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            _builder.append(",");
            CharSequence _printObs_1 = this.printObs(obs, lAlias);
            _builder.append(_printObs_1);
            {
              for(final String ob_1 : obs) {
                {
                  boolean _contains_1 = lObs.contains(ob_1);
                  boolean _not_2 = (!_contains_1);
                  if (_not_2) {
                    lObs.addLast(ob_1);
                  }
                }
              }
            }
          }
        }
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public void changeDataType(final DataType dt) {
    this.type = dt;
  }
  
  public CharSequence generateBoolEvenEnumVariable(final RoqmeModel roqmeModel, final LinkedList<TypedVariable> types, final LinkedList<String> lAlias) {
    StringConcatenation _builder = new StringConcatenation();
    LinkedList<String> obs = new LinkedList<String>();
    _builder.newLineIfNotEmpty();
    {
      for(final TypedVariable variable : types) {
        DataTypeDeclaration _declaration = variable.getDeclaration();
        DataTypeDeclaration cDec = ((DataTypeDeclaration) _declaration);
        _builder.newLineIfNotEmpty();
        _builder.append(this.type = ((DataType) null));
        _builder.newLineIfNotEmpty();
        {
          DataTypeDeclaration _declaration_1 = variable.getDeclaration();
          if ((_declaration_1 instanceof ReferencedDeclaration)) {
            DataTypeDeclaration _declaration_2 = variable.getDeclaration();
            ReferencedDeclaration cRec = ((ReferencedDeclaration) _declaration_2);
            _builder.newLineIfNotEmpty();
            this.changeDataType(cRec.getType().getDataType());
            _builder.newLineIfNotEmpty();
          } else {
            ContainedDeclaration contained = ((ContainedDeclaration) cDec);
            _builder.newLineIfNotEmpty();
            this.changeDataType(contained.getType());
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((this.type instanceof EnumType)) {
            EnumType enumV = ((EnumType) this.type);
            _builder.newLineIfNotEmpty();
            _builder.newLine();
            {
              EList<EnumLiteral> _literals = enumV.getLiterals();
              boolean _hasElements = false;
              for(final EnumLiteral literal : _literals) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate("\n", "");
                }
                _builder.append("{");
                _builder.newLine();
                _builder.append("  ");
                _builder.append("\"alias\": \"");
                String _name = variable.getName();
                _builder.append(_name, "  ");
                _builder.append(".");
                String _name_1 = literal.getName();
                _builder.append(_name_1, "  ");
                _builder.append("\",");
                String _name_2 = variable.getName();
                String _plus = (_name_2 + ".");
                String _name_3 = literal.getName();
                String _plus_1 = (_plus + _name_3);
                lAlias.addLast(_plus_1);
                _builder.newLineIfNotEmpty();
                _builder.append("  ");
                _builder.append("\"groupBy\": [");
                _builder.newLine();
                _builder.append("    ");
                _builder.append("{");
                _builder.newLine();
                _builder.append("      ");
                _builder.append("\"params\": [");
                _builder.newLine();
                _builder.append("        ");
                _builder.append("\"$__interval\"");
                _builder.newLine();
                _builder.append("      ");
                _builder.append("],");
                _builder.newLine();
                _builder.append("      ");
                _builder.append("\"type\": \"time\"");
                _builder.newLine();
                _builder.append("    ");
                _builder.append("},");
                _builder.newLine();
                _builder.append("    ");
                _builder.append("{");
                _builder.newLine();
                _builder.append("      ");
                _builder.append("\"params\": [");
                _builder.newLine();
                _builder.append("        ");
                _builder.append("\"null\"");
                _builder.newLine();
                _builder.append("      ");
                _builder.append("],");
                _builder.newLine();
                _builder.append("      ");
                _builder.append("\"type\": \"fill\"");
                _builder.newLine();
                _builder.append("    ");
                _builder.append("}");
                _builder.newLine();
                _builder.append("  ");
                _builder.append("],");
                _builder.newLine();
                _builder.append("  ");
                _builder.append("\"measurement\": \"In_Context\",");
                _builder.newLine();
                _builder.append("  ");
                _builder.append("\"orderByTime\": \"ASC\",");
                _builder.newLine();
                _builder.append("  ");
                _builder.append("\"policy\": \"default\",");
                _builder.newLine();
                _builder.append("  ");
                _builder.append("\"refId\": \"A\",");
                _builder.newLine();
                _builder.append("  ");
                _builder.append("\"resultFormat\": \"time_series\",");
                _builder.newLine();
                _builder.append("  ");
                _builder.append("\"select\": [");
                _builder.newLine();
                _builder.append("    ");
                _builder.append("[");
                _builder.newLine();
                _builder.append("      ");
                _builder.append("{");
                _builder.newLine();
                _builder.append("        ");
                _builder.append("\"params\": [");
                _builder.newLine();
                _builder.append("          ");
                _builder.append("\"");
                String _name_4 = variable.getName();
                _builder.append(_name_4, "          ");
                _builder.append(".");
                String _name_5 = literal.getName();
                _builder.append(_name_5, "          ");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
                _builder.append("        ");
                _builder.append("],");
                _builder.newLine();
                _builder.append("        ");
                _builder.append("\"type\": \"field\"");
                _builder.newLine();
                _builder.append("      ");
                _builder.append("},");
                _builder.newLine();
                _builder.append("      ");
                _builder.append("{");
                _builder.newLine();
                _builder.append("        ");
                _builder.append("\"params\": [],");
                _builder.newLine();
                _builder.append("        ");
                _builder.append("\"type\": \"mean\"");
                _builder.newLine();
                _builder.append("      ");
                _builder.append("}");
                _builder.newLine();
                _builder.append("    ");
                _builder.append("]");
                _builder.newLine();
                _builder.append("  ");
                _builder.append("],");
                _builder.newLine();
                _builder.append("  ");
                _builder.append("\"tags\": []");
                _builder.newLine();
                _builder.append("},");
                CharSequence _generateObservations = this.generateObservations(roqmeModel, literal.getName(), obs);
                _builder.append(_generateObservations);
              }
            }
          } else {
            _builder.append("{");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            _builder.append("\"alias\": \"");
            String _name_6 = variable.getName();
            _builder.append(_name_6, "  ");
            _builder.append("\",");
            lAlias.addLast(variable.getName());
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            _builder.append("\"groupBy\": [");
            _builder.newLine();
            _builder.append("    ");
            _builder.append("{");
            _builder.newLine();
            _builder.append("      ");
            _builder.append("\"params\": [");
            _builder.newLine();
            _builder.append("        ");
            _builder.append("\"$__interval\"");
            _builder.newLine();
            _builder.append("      ");
            _builder.append("],");
            _builder.newLine();
            _builder.append("      ");
            _builder.append("\"type\": \"time\"");
            _builder.newLine();
            _builder.append("    ");
            _builder.append("},");
            _builder.newLine();
            _builder.append("    ");
            _builder.append("{");
            _builder.newLine();
            _builder.append("      ");
            _builder.append("\"params\": [");
            _builder.newLine();
            _builder.append("        ");
            _builder.append("\"null\"");
            _builder.newLine();
            _builder.append("      ");
            _builder.append("],");
            _builder.newLine();
            _builder.append("      ");
            _builder.append("\"type\": \"fill\"");
            _builder.newLine();
            _builder.append("    ");
            _builder.append("}");
            _builder.newLine();
            _builder.append("  ");
            _builder.append("],");
            _builder.newLine();
            _builder.append("  ");
            _builder.append("\"measurement\": \"In_Context\",");
            _builder.newLine();
            _builder.append("  ");
            _builder.append("\"orderByTime\": \"ASC\",");
            _builder.newLine();
            _builder.append("  ");
            _builder.append("\"policy\": \"default\",");
            _builder.newLine();
            _builder.append("  ");
            _builder.append("\"refId\": \"A\",");
            _builder.newLine();
            _builder.append("  ");
            _builder.append("\"resultFormat\": \"time_series\",");
            _builder.newLine();
            _builder.append("  ");
            _builder.append("\"select\": [");
            _builder.newLine();
            _builder.append("    ");
            _builder.append("[");
            _builder.newLine();
            _builder.append("      ");
            _builder.append("{");
            _builder.newLine();
            _builder.append("        ");
            _builder.append("\"params\": [");
            _builder.newLine();
            _builder.append("          ");
            _builder.append("\"");
            String _name_7 = variable.getName();
            _builder.append(_name_7, "          ");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
            _builder.append("        ");
            _builder.append("],");
            _builder.newLine();
            _builder.append("        ");
            _builder.append("\"type\": \"field\"");
            _builder.newLine();
            _builder.append("      ");
            _builder.append("},");
            _builder.newLine();
            _builder.append("      ");
            _builder.append("{");
            _builder.newLine();
            _builder.append("        ");
            _builder.append("\"params\": [],");
            _builder.newLine();
            _builder.append("        ");
            _builder.append("\"type\": \"mean\"");
            _builder.newLine();
            _builder.append("      ");
            _builder.append("}");
            _builder.newLine();
            _builder.append("    ");
            _builder.append("]");
            _builder.newLine();
            _builder.append("  ");
            _builder.append("],");
            _builder.newLine();
            _builder.append("  ");
            _builder.append("\"tags\": []");
            _builder.newLine();
            _builder.append("},");
            CharSequence _generateObservations_1 = this.generateObservations(roqmeModel, variable.getName(), obs);
            _builder.append(_generateObservations_1);
          }
        }
      }
    }
    CharSequence _printObs = this.printObs(obs, lAlias);
    _builder.append(_printObs);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence printObs(final LinkedList<String> obs, final LinkedList<String> lAlias) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final String ob : obs) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        _builder.append("{");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"alias\": \"");
        _builder.append(ob, "  ");
        _builder.append("\",");
        lAlias.addLast(ob);
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("\"groupBy\": [");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("{");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"params\": [");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("\"$__interval\"");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("],");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"type\": \"time\"");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("},");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("{");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"params\": [");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("\"null\"");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("],");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("\"type\": \"fill\"");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("],");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"measurement\": \"Observation\",");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"orderByTime\": \"ASC\",");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"policy\": \"default\",");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"refId\": \"A\",");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"resultFormat\": \"time_series\",");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"select\": [");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("[");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("{");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("\"params\": [");
        _builder.newLine();
        _builder.append("          ");
        _builder.append("\"");
        _builder.append(ob, "          ");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("        ");
        _builder.append("],");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("\"type\": \"field\"");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("},");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("{");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("\"params\": [],");
        _builder.newLine();
        _builder.append("        ");
        _builder.append("\"type\": \"mean\"");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("]");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("],");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("\"tags\": []");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence generateObservations(final RoqmeModel roqmeModel, final String contextName, final LinkedList<String> obs) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Sentence> _sentences = roqmeModel.getSentences();
      for(final Sentence sentence : _sentences) {
        {
          if ((sentence instanceof Observation)) {
            {
              Term _term = ((Observation)sentence).getPattern().getTerm();
              if ((_term instanceof NaryTermOp)) {
                Term _term_1 = ((Observation)sentence).getPattern().getTerm();
                NaryTermOp term = ((NaryTermOp) _term_1);
                _builder.newLineIfNotEmpty();
                {
                  EList<Term> _terms = term.getTerms();
                  for(final Term termn : _terms) {
                    CharSequence _generateNaryTerm = this.generateNaryTerm(termn, contextName, ((Observation)sentence).getName(), obs);
                    _builder.append(_generateNaryTerm);
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            {
              Term _term_2 = ((Observation)sentence).getPattern().getTerm();
              if ((_term_2 instanceof UnaryTermOp)) {
                Term _term_3 = ((Observation)sentence).getPattern().getTerm();
                UnaryTermOp term_1 = ((UnaryTermOp) _term_3);
                _builder.newLineIfNotEmpty();
                CharSequence _generateNaryTerm_1 = this.generateNaryTerm(term_1.getTerm(), contextName, ((Observation)sentence).getName(), obs);
                _builder.append(_generateNaryTerm_1);
                _builder.newLineIfNotEmpty();
              }
            }
            {
              Term _term_4 = ((Observation)sentence).getPattern().getTerm();
              if ((_term_4 instanceof BinaryTermOp)) {
                CharSequence _generateNaryTerm_2 = this.generateNaryTerm(((Observation)sentence).getPattern().getTerm(), contextName, ((Observation)sentence).getName(), obs);
                _builder.append(_generateNaryTerm_2);
                _builder.newLineIfNotEmpty();
              }
            }
            {
              Term _term_5 = ((Observation)sentence).getPattern().getTerm();
              if ((_term_5 instanceof VarTerm)) {
                Term _term_6 = ((Observation)sentence).getPattern().getTerm();
                VarTerm varterm = ((VarTerm) _term_6);
                _builder.newLineIfNotEmpty();
                {
                  String _name = varterm.getVariable().getName();
                  boolean _equals = Objects.equal(_name, contextName);
                  if (_equals) {
                    {
                      boolean _contains = obs.contains(((Observation)sentence).getName());
                      boolean _not = (!_contains);
                      if (_not) {
                        obs.addLast(((Observation)sentence).getName());
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
              }
            }
            {
              Term _term_7 = ((Observation)sentence).getPattern().getTerm();
              if ((_term_7 instanceof ConstTerm)) {
                Term _term_8 = ((Observation)sentence).getPattern().getTerm();
                ConstTerm valueterm = ((ConstTerm) _term_8);
                _builder.newLineIfNotEmpty();
                {
                  TypedValue _value = valueterm.getValue();
                  if ((_value instanceof EnumValue)) {
                    TypedValue _value_1 = valueterm.getValue();
                    EnumValue enumT = ((EnumValue) _value_1);
                    _builder.newLineIfNotEmpty();
                    {
                      String _name_1 = enumT.getValue().getName();
                      boolean _equals_1 = Objects.equal(_name_1, contextName);
                      if (_equals_1) {
                        {
                          boolean _contains_1 = obs.contains(((Observation)sentence).getName());
                          boolean _not_1 = (!_contains_1);
                          if (_not_1) {
                            obs.addLast(((Observation)sentence).getName());
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence generateNaryTerm(final Term term, final String contextName, final String obs, final LinkedList<String> lObs) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((term instanceof VarTerm)) {
        VarTerm varterm = ((VarTerm) term);
        _builder.newLineIfNotEmpty();
        {
          boolean _equals = varterm.getVariable().getName().equals(contextName);
          if (_equals) {
            {
              boolean _contains = lObs.contains(obs);
              boolean _not = (!_contains);
              if (_not) {
                lObs.addLast(obs);
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    {
      if ((term instanceof ConstTerm)) {
        ConstTerm valueterm = ((ConstTerm) term);
        _builder.newLineIfNotEmpty();
        {
          TypedValue _value = valueterm.getValue();
          if ((_value instanceof EnumValue)) {
            TypedValue _value_1 = valueterm.getValue();
            EnumValue enumT = ((EnumValue) _value_1);
            _builder.newLineIfNotEmpty();
            {
              String _name = enumT.getValue().getName();
              boolean _equals_1 = Objects.equal(_name, contextName);
              if (_equals_1) {
                {
                  boolean _contains_1 = lObs.contains(obs);
                  boolean _not_1 = (!_contains_1);
                  if (_not_1) {
                    lObs.addLast(obs);
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
        }
      }
    }
    {
      if ((term instanceof BinaryTermOp)) {
        BinaryTermOp binaryterm = ((BinaryTermOp) term);
        _builder.newLineIfNotEmpty();
        {
          Term _right = binaryterm.getRight();
          if ((_right instanceof VarTerm)) {
            Term _right_1 = binaryterm.getRight();
            VarTerm rightTerm = ((VarTerm) _right_1);
            _builder.newLineIfNotEmpty();
            {
              String _name_1 = rightTerm.getVariable().getName();
              boolean _equals_2 = Objects.equal(_name_1, contextName);
              if (_equals_2) {
                {
                  boolean _contains_2 = lObs.contains(obs);
                  boolean _not_2 = (!_contains_2);
                  if (_not_2) {
                    lObs.addLast(obs);
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
        }
        {
          Term _left = binaryterm.getLeft();
          if ((_left instanceof VarTerm)) {
            Term _left_1 = binaryterm.getLeft();
            VarTerm leftTerm = ((VarTerm) _left_1);
            _builder.newLineIfNotEmpty();
            {
              String _name_2 = leftTerm.getVariable().getName();
              boolean _equals_3 = Objects.equal(_name_2, contextName);
              if (_equals_3) {
                {
                  boolean _contains_3 = lObs.contains(obs);
                  boolean _not_3 = (!_contains_3);
                  if (_not_3) {
                    lObs.addLast(obs);
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
        }
        {
          Term _right_2 = binaryterm.getRight();
          if ((_right_2 instanceof ConstTerm)) {
            Term _right_3 = binaryterm.getRight();
            ConstTerm valueterm_1 = ((ConstTerm) _right_3);
            _builder.newLineIfNotEmpty();
            {
              TypedValue _value_2 = valueterm_1.getValue();
              if ((_value_2 instanceof EnumValue)) {
                TypedValue _value_3 = valueterm_1.getValue();
                EnumValue enumT_1 = ((EnumValue) _value_3);
                _builder.newLineIfNotEmpty();
                {
                  String _name_3 = enumT_1.getValue().getName();
                  boolean _equals_4 = Objects.equal(_name_3, contextName);
                  if (_equals_4) {
                    {
                      boolean _contains_4 = lObs.contains(obs);
                      boolean _not_4 = (!_contains_4);
                      if (_not_4) {
                        lObs.addLast(obs);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
              }
            }
          }
        }
        {
          Term _left_2 = binaryterm.getLeft();
          if ((_left_2 instanceof ConstTerm)) {
            Term _left_3 = binaryterm.getLeft();
            ConstTerm valueterm_2 = ((ConstTerm) _left_3);
            _builder.newLineIfNotEmpty();
            {
              TypedValue _value_4 = valueterm_2.getValue();
              if ((_value_4 instanceof EnumValue)) {
                TypedValue _value_5 = valueterm_2.getValue();
                EnumValue enumT_2 = ((EnumValue) _value_5);
                _builder.newLineIfNotEmpty();
                {
                  String _name_4 = enumT_2.getValue().getName();
                  boolean _equals_5 = Objects.equal(_name_4, contextName);
                  if (_equals_5) {
                    {
                      boolean _contains_5 = lObs.contains(obs);
                      boolean _not_5 = (!_contains_5);
                      if (_not_5) {
                        lObs.addLast(obs);
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
              }
            }
          }
        }
        {
          if ((binaryterm instanceof BinaryTermOp)) {
            Object _generateNaryTerm = this.generateNaryTerm(binaryterm.getLeft(), contextName, obs, lObs);
            _builder.append(_generateNaryTerm);
            _builder.newLineIfNotEmpty();
            Object _generateNaryTerm_1 = this.generateNaryTerm(binaryterm.getRight(), contextName, obs, lObs);
            _builder.append(_generateNaryTerm_1);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence generateObservationsMetrics(final RoqmeModel roqmeModel, final String metricName, final LinkedList<String> obs) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Sentence> _sentences = roqmeModel.getSentences();
      for(final Sentence sentence : _sentences) {
        {
          if ((sentence instanceof Observation)) {
            Observation observation = ((Observation) sentence);
            _builder.newLineIfNotEmpty();
            {
              EList<Action> _actions = observation.getActions();
              for(final Action action : _actions) {
                {
                  if ((action instanceof SetEvidence)) {
                    SetEvidence evidence = ((SetEvidence) action);
                    _builder.newLineIfNotEmpty();
                    {
                      String _name = evidence.getTarget().getName();
                      boolean _equals = Objects.equal(_name, metricName);
                      if (_equals) {
                        {
                          boolean _contains = obs.contains(observation.getName());
                          boolean _not = (!_contains);
                          if (_not) {
                            obs.addLast(observation.getName());
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence generateNaryTermMetrics(final Term term, final String contextName, final String obs, final LinkedList<String> lObs) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((term instanceof BinaryTermOp)) {
        BinaryTermOp binaryterm = ((BinaryTermOp) term);
        _builder.newLineIfNotEmpty();
        {
          Term _right = binaryterm.getRight();
          if ((_right instanceof VarTerm)) {
            Term _right_1 = binaryterm.getRight();
            VarTerm rightTerm = ((VarTerm) _right_1);
            _builder.newLineIfNotEmpty();
            {
              String _name = rightTerm.getVariable().getName();
              boolean _equals = Objects.equal(_name, contextName);
              if (_equals) {
                {
                  boolean _contains = lObs.contains(obs);
                  boolean _not = (!_contains);
                  if (_not) {
                    lObs.addLast(obs);
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
        }
        {
          Term _left = binaryterm.getLeft();
          if ((_left instanceof VarTerm)) {
            Term _left_1 = binaryterm.getLeft();
            VarTerm leftTerm = ((VarTerm) _left_1);
            _builder.newLineIfNotEmpty();
            {
              String _name_1 = leftTerm.getVariable().getName();
              boolean _equals_1 = Objects.equal(_name_1, contextName);
              if (_equals_1) {
                {
                  boolean _contains_1 = lObs.contains(obs);
                  boolean _not_1 = (!_contains_1);
                  if (_not_1) {
                    lObs.addLast(obs);
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
        }
        {
          if ((binaryterm instanceof BinaryTermOp)) {
            CharSequence _generateNaryTerm = this.generateNaryTerm(binaryterm.getLeft(), contextName, obs, lObs);
            _builder.append(_generateNaryTerm);
            CharSequence _generateNaryTerm_1 = this.generateNaryTerm(binaryterm.getRight(), contextName, obs, lObs);
            _builder.append(_generateNaryTerm_1);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
}
