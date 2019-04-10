package roqme.generator.cep;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import roqme.metamodel.datatypes.BooleanType;
import roqme.metamodel.datatypes.BooleanValue;
import roqme.metamodel.datatypes.ContainedDeclaration;
import roqme.metamodel.datatypes.DataType;
import roqme.metamodel.datatypes.DataTypeDeclaration;
import roqme.metamodel.datatypes.DataTypeDefinition;
import roqme.metamodel.datatypes.EnumLiteral;
import roqme.metamodel.datatypes.EnumType;
import roqme.metamodel.datatypes.EnumValue;
import roqme.metamodel.datatypes.EventType;
import roqme.metamodel.datatypes.NumericType;
import roqme.metamodel.datatypes.NumericValue;
import roqme.metamodel.datatypes.ReferencedDeclaration;
import roqme.metamodel.datatypes.RoqmeModel;
import roqme.metamodel.datatypes.Sentence;
import roqme.metamodel.datatypes.SingleValue;
import roqme.metamodel.datatypes.TimeType;
import roqme.metamodel.datatypes.TypedValue;
import roqme.metamodel.datatypes.TypedVariable;
import roqme.metamodel.datatypes.UnitMeasuredValue;
import roqme.metamodel.expressions.AddTerm;
import roqme.metamodel.expressions.AggregationFtnEnum;
import roqme.metamodel.expressions.AggregationFunction;
import roqme.metamodel.expressions.AndBooleanTerm;
import roqme.metamodel.expressions.AndEventTerm;
import roqme.metamodel.expressions.ArithFtnEnum;
import roqme.metamodel.expressions.ArithFunction;
import roqme.metamodel.expressions.BinaryArithOp;
import roqme.metamodel.expressions.BinaryLogicalOp;
import roqme.metamodel.expressions.BinaryPatternOp;
import roqme.metamodel.expressions.BinaryRelationalOp;
import roqme.metamodel.expressions.BinaryTermOp;
import roqme.metamodel.expressions.CollectionFunction;
import roqme.metamodel.expressions.ConditionalTerm;
import roqme.metamodel.expressions.ConstTerm;
import roqme.metamodel.expressions.ContextPattern;
import roqme.metamodel.expressions.DivTerm;
import roqme.metamodel.expressions.EqualTerm;
import roqme.metamodel.expressions.FollowedByTerm;
import roqme.metamodel.expressions.FunctionTerm;
import roqme.metamodel.expressions.GreaterEqualTerm;
import roqme.metamodel.expressions.GreaterThanTerm;
import roqme.metamodel.expressions.LessEqualTerm;
import roqme.metamodel.expressions.LessThanTerm;
import roqme.metamodel.expressions.MultTerm;
import roqme.metamodel.expressions.NaryTermOp;
import roqme.metamodel.expressions.NotBooleanTerm;
import roqme.metamodel.expressions.NotEqualTerm;
import roqme.metamodel.expressions.NotEventTerm;
import roqme.metamodel.expressions.OnceTerm;
import roqme.metamodel.expressions.OrBooleanTerm;
import roqme.metamodel.expressions.OrEventTerm;
import roqme.metamodel.expressions.PatternFtnEnum;
import roqme.metamodel.expressions.PatternFunction;
import roqme.metamodel.expressions.RangeTerm;
import roqme.metamodel.expressions.RepeatTerm;
import roqme.metamodel.expressions.ScheduleFunction;
import roqme.metamodel.expressions.SelfTerm;
import roqme.metamodel.expressions.SubTerm;
import roqme.metamodel.expressions.Term;
import roqme.metamodel.expressions.UnaryLogicalOp;
import roqme.metamodel.expressions.UnaryPatternOp;
import roqme.metamodel.expressions.UnaryTermOp;
import roqme.metamodel.expressions.VarTerm;
import roqme.metamodel.expressions.WhileTerm;
import roqme.metamodel.kernel.Action;
import roqme.metamodel.kernel.Context;
import roqme.metamodel.kernel.DerivedContext;
import roqme.metamodel.kernel.GeneralPurposeVariable;
import roqme.metamodel.kernel.Import;
import roqme.metamodel.kernel.Observation;
import roqme.metamodel.kernel.Parameter;
import roqme.metamodel.kernel.SetVariable;
import roqme.metamodel.kernel.Timer;

@SuppressWarnings("all")
public class RoqmeCepGenerator extends AbstractGenerator {
  private final static String BASE_PATH = "src/";
  
  private final static String ENUM_PACKAGE_PATH = (RoqmeCepGenerator.BASE_PATH + "enums");
  
  private final static String ENUM_PACKAGE_NAME = "enums";
  
  private final static String JAVA_EXTENSION = ".java";
  
  private static char letter = 'a';
  
  private Map<Term, String> auxPatternsNames = new HashMap<Term, String>();
  
  private Map<String, String> varTermAs = new LinkedHashMap<String, String>();
  
  private boolean once = false;
  
  @Override
  public void doGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    boolean _equalsIgnoreCase = input.getURI().fileExtension().equalsIgnoreCase("roqme");
    if (_equalsIgnoreCase) {
      Iterable<RoqmeModel> _filter = Iterables.<RoqmeModel>filter(IteratorExtensions.<EObject>toIterable(input.getAllContents()), RoqmeModel.class);
      for (final RoqmeModel model : _filter) {
        {
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(model.getNamespace());
          if (_isNullOrEmpty) {
            final String[] splitStr = input.getURI().lastSegment().split("\\.");
            model.setNamespace(splitStr[0]);
          }
          String _namespace = model.getNamespace();
          String _plus = (RoqmeCepGenerator.BASE_PATH + _namespace);
          String _plus_1 = (_plus + ".epl");
          fsa.generateFile(_plus_1, this.generateEPL(model, fsa));
          String _capitalize = this.capitalize(model.getNamespace());
          String _plus_2 = (RoqmeCepGenerator.BASE_PATH + _capitalize);
          String _plus_3 = (_plus_2 + ".java");
          fsa.generateFile(_plus_3, this.generateEsperEngine(model));
        }
      }
    }
  }
  
  public String capitalize(final String line) {
    char _upperCase = Character.toUpperCase(line.charAt(0));
    String _substring = line.substring(1);
    return (Character.valueOf(_upperCase) + _substring);
  }
  
  public CharSequence generateEPL(final RoqmeModel model, final IFileSystemAccess2 fsa) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module ");
    String _namespace = model.getNamespace();
    _builder.append(_namespace);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    {
      boolean _anyEnum = this.anyEnum(model.getVariables());
      if (_anyEnum) {
        _builder.append("import ");
        _builder.append(RoqmeCepGenerator.ENUM_PACKAGE_NAME);
        _builder.append(".*;");
      }
    }
    _builder.newLineIfNotEmpty();
    CharSequence _generateImports = this.generateImports(model.getSentences());
    _builder.append(_generateImports);
    _builder.newLineIfNotEmpty();
    CharSequence _generateTypesDefinitions = this.generateTypesDefinitions(model.getDataTypes(), fsa);
    _builder.append(_generateTypesDefinitions);
    _builder.newLineIfNotEmpty();
    CharSequence _generateDataDefinitions = this.generateDataDefinitions(model.getVariables(), fsa);
    _builder.append(_generateDataDefinitions);
    _builder.newLineIfNotEmpty();
    CharSequence _generatePatternDefinitions = this.generatePatternDefinitions(model.getSentences());
    _builder.append(_generatePatternDefinitions);
    _builder.newLineIfNotEmpty();
    CharSequence _generateObservationStreamPattern = this.generateObservationStreamPattern();
    _builder.append(_generateObservationStreamPattern);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateObservationStreamPattern() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("@Name(\'Observations\')");
    _builder.newLine();
    _builder.append("SELECT val");
    _builder.newLine();
    _builder.append("FROM Observations;");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateTypesDefinitions(final EList<DataTypeDefinition> types, final IFileSystemAccess2 fsa) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final DataTypeDefinition type : types) {
        {
          DataType _dataType = type.getDataType();
          if ((_dataType instanceof BooleanType)) {
            _builder.append("create objectarray schema ");
            String _name = type.getName();
            _builder.append(_name);
            _builder.append("(val bool,ts long) starttimestamp ts endtimestamp ts;");
            _builder.newLineIfNotEmpty();
          } else {
            DataType _dataType_1 = type.getDataType();
            if ((_dataType_1 instanceof EventType)) {
              _builder.append("create objectarray schema ");
              String _name_1 = type.getName();
              _builder.append(_name_1);
              _builder.append("(ts long) starttimestamp ts endtimestamp ts;");
              _builder.newLineIfNotEmpty();
            } else {
              DataType _dataType_2 = type.getDataType();
              if ((_dataType_2 instanceof EnumType)) {
                _builder.append("\t");
                DataType _dataType_3 = type.getDataType();
                final EnumType enumVar = ((EnumType) _dataType_3);
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                String _name_2 = type.getName();
                String _plus = ((RoqmeCepGenerator.ENUM_PACKAGE_PATH + "/") + _name_2);
                String _plus_1 = (_plus + RoqmeCepGenerator.JAVA_EXTENSION);
                fsa.generateFile(_plus_1, this.generateJavaEnums(enumVar, type.getName()));
                _builder.newLineIfNotEmpty();
                _builder.append("create objectarray schema ");
                String _name_3 = type.getName();
                _builder.append(_name_3);
                _builder.append("(val ");
                String _name_4 = type.getName();
                _builder.append(_name_4);
                _builder.append(",ts long) starttimestamp ts endtimestamp ts;");
                _builder.newLineIfNotEmpty();
              } else {
                DataType _dataType_4 = type.getDataType();
                if ((_dataType_4 instanceof NumericType)) {
                  _builder.append("create objectarray schema ");
                  String _name_5 = type.getName();
                  _builder.append(_name_5);
                  _builder.append("(val double,ts long) starttimestamp ts endtimestamp ts;");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence generateEsperEngine(final RoqmeModel model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.roqme.cep.PatternDetector;");
    _builder.newLine();
    _builder.append("import Roqme.RoqmeDDSException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _capitalize = this.capitalize(model.getNamespace());
    _builder.append(_capitalize);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void main(String[] args) throws RoqmeDDSException, InterruptedException {");
    _builder.newLine();
    _builder.append("\t\t");
    String _capitalize_1 = this.capitalize(model.getNamespace());
    _builder.append(_capitalize_1, "\t\t");
    _builder.append(" exec = new ");
    String _capitalize_2 = this.capitalize(model.getNamespace());
    _builder.append(_capitalize_2, "\t\t");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("PatternDetector pd=null;");
    _builder.newLine();
    _builder.append("\t\t");
    final List<String> imports = this.getImportURIs(model.getSentences());
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try{");
    _builder.newLine();
    {
      boolean _anyEnum = this.anyEnum(model.getVariables());
      if (_anyEnum) {
        _builder.append("\t\t\t");
        _builder.append("pd = new PatternDetector(\"");
        _builder.append(RoqmeCepGenerator.ENUM_PACKAGE_NAME, "\t\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("\t\t\t");
        _builder.append("pd = new PatternDetector();");
        _builder.newLine();
      }
    }
    {
      boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(imports);
      if (_isNullOrEmpty) {
        _builder.append("\t\t\t");
        _builder.append("pd.launch(\"");
        String _namespace = model.getNamespace();
        String _plus = (_namespace + ".epl");
        _builder.append(_plus, "\t\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("\t\t\t");
        _builder.append("List imports = new ArrayList<String>();");
        _builder.newLine();
        {
          for(final String resource : imports) {
            _builder.append("\t\t\t");
            _builder.append("imports.add(\"");
            String _replace = resource.replace("roqme", "epl");
            _builder.append(_replace, "\t\t\t");
            _builder.append("\");");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t\t");
        _builder.append("imports.add(\"");
        String _namespace_1 = model.getNamespace();
        String _plus_1 = (_namespace_1 + ".epl");
        _builder.append(_plus_1, "\t\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("pd.launch(imports);");
        _builder.newLine();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("synchronized (pd) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("exec.wait();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch(Exception e){");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("e.printStackTrace();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} finally {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("pd.destroy();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateImports(final List<Sentence> sentences) {
    StringConcatenation _builder = new StringConcatenation();
    List<String> imports = this.getImportURIs(sentences);
    _builder.newLineIfNotEmpty();
    {
      for(final String elem : imports) {
        String uses = elem;
        _builder.newLineIfNotEmpty();
        {
          boolean _contains = uses.contains("/");
          if (_contains) {
            _builder.append(uses = IterableExtensions.<String>last(((Iterable<String>)Conversions.doWrapArray(uses.split("/")))));
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("uses ");
        String _next = ((List<String>)Conversions.doWrapArray(uses.split("\\."))).iterator().next();
        _builder.append(_next);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public boolean anyEnum(final EList<TypedVariable> variables) {
    boolean res = false;
    boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(variables);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      Iterator<TypedVariable> varIt = variables.iterator();
      while ((varIt.hasNext() && (!res))) {
        {
          final TypedVariable next = varIt.next();
          DataTypeDeclaration _declaration = null;
          if (next!=null) {
            _declaration=next.getDeclaration();
          }
          if ((_declaration instanceof ContainedDeclaration)) {
            DataTypeDeclaration _declaration_1 = next.getDeclaration();
            final ContainedDeclaration contDec = ((ContainedDeclaration) _declaration_1);
            DataType _type = contDec.getType();
            final DataType dataType = ((DataType) _type);
            res = (dataType instanceof EnumType);
          }
        }
      }
    }
    return res;
  }
  
  public List<String> getImportURIs(final List<Sentence> sentences) {
    ArrayList<String> modules = CollectionLiterals.<String>newArrayList();
    for (final Sentence sentence : sentences) {
      if ((sentence instanceof Import)) {
        Import imp = ((Import) sentence);
        modules.add(imp.getImportURI());
      }
    }
    return modules;
  }
  
  public CharSequence generateDataDefinitions(final EList<TypedVariable> variables, final IFileSystemAccess2 fsa) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final TypedVariable typedVar : variables) {
        {
          if ((typedVar instanceof Context)) {
            CharSequence _generateContext = this.generateContext(((Context) typedVar), fsa);
            _builder.append(_generateContext);
            _builder.newLineIfNotEmpty();
          } else {
            if (((typedVar instanceof Parameter) || (typedVar instanceof GeneralPurposeVariable))) {
              CharSequence _generateVariable = this.generateVariable(typedVar, fsa);
              _builder.append(_generateVariable);
              _builder.newLineIfNotEmpty();
            } else {
              if ((typedVar instanceof Timer)) {
                this.generateTimer(((Timer) typedVar));
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.newLine();
    CharSequence _generateDerivedContexts = this.generateDerivedContexts(variables);
    _builder.append(_generateDerivedContexts);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public void generateTimer(final Timer timer) {
    final Term timerTerm = timer.getDefinition().getTerm();
    if ((timerTerm instanceof ConstTerm)) {
      TypedValue _value = ((ConstTerm)timerTerm).getValue();
      final UnitMeasuredValue timeValue = ((UnitMeasuredValue) _value);
      final double value = timeValue.getValue();
      final String unit = timeValue.getUnit();
      this.auxPatternsNames.put(timerTerm, (((("timer:interval(" + Double.valueOf(value)) + " ") + unit) + ")"));
    } else {
      if ((timerTerm instanceof ScheduleFunction)) {
        this.generateSchedule(((ScheduleFunction)timerTerm));
      }
    }
  }
  
  public void generateSchedule(final ScheduleFunction timerTerm) {
    String _pattern = timerTerm.getPattern();
    String _plus = ("timer:at(" + _pattern);
    String _plus_1 = (_plus + ")");
    this.auxPatternsNames.put(timerTerm, _plus_1);
  }
  
  public String generateScheduleFunctionTerm(final ScheduleFunction function) {
    return this.auxPatternsNames.get(function);
  }
  
  public CharSequence generateVariable(final TypedVariable param, final IFileSystemAccess2 fsa) {
    CharSequence _xblockexpression = null;
    {
      DataTypeDeclaration _declaration = param.getDeclaration();
      final ContainedDeclaration contDec = ((ContainedDeclaration) _declaration);
      TypedValue _initializedTo = param.getInitializedTo();
      final TypedValue typedValue = ((TypedValue) _initializedTo);
      DataType _type = contDec.getType();
      final DataType dataType = ((DataType) _type);
      String dec = "";
      final String paramName = param.getName();
      String type = "";
      String init = "";
      if ((dataType instanceof EnumType)) {
        fsa.generateFile((((RoqmeCepGenerator.ENUM_PACKAGE_PATH + "/") + paramName) + RoqmeCepGenerator.JAVA_EXTENSION), this.generateJavaEnums(((EnumType)dataType), paramName));
        type = paramName;
      } else {
        type = this.getEsperDataType(dataType);
      }
      if ((param instanceof Parameter)) {
        dec = "create constant variable";
        if ((typedValue instanceof SingleValue)) {
          Object _generateSingleValue = this.generateSingleValue(((SingleValue)typedValue));
          String _plus = ("= " + _generateSingleValue);
          init = _plus;
        }
      } else {
        if ((param instanceof GeneralPurposeVariable)) {
          dec = "create variable";
          final Term gpvTerm = ((GeneralPurposeVariable)param).getDefinition().getTerm();
          if ((gpvTerm instanceof ConstTerm)) {
            Object _generateConstTerm = this.generateConstTerm(((ConstTerm)gpvTerm));
            String _plus_1 = ("= " + _generateConstTerm);
            init = _plus_1;
          }
        }
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(dec);
      _builder.append(" ");
      _builder.append(type);
      _builder.append(" ");
      _builder.append(paramName);
      {
        boolean _isEmpty = init.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          _builder.append(" ");
          _builder.append(init);
        }
      }
      _builder.append(";");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public String getEsperDataType(final DataType dt) {
    String _xifexpression = null;
    if ((dt instanceof TimeType)) {
      _xifexpression = "long";
    } else {
      String _xifexpression_1 = null;
      if ((dt instanceof BooleanType)) {
        _xifexpression_1 = "bool";
      } else {
        String _xifexpression_2 = null;
        if ((dt instanceof NumericType)) {
          _xifexpression_2 = "double";
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public Object generateSingleValue(final SingleValue sv) {
    Object _xifexpression = null;
    if ((sv instanceof NumericValue)) {
      double _xblockexpression = (double) 0;
      {
        final NumericValue nv = ((NumericValue) sv);
        _xblockexpression = nv.getValue();
      }
      _xifexpression = Double.valueOf(_xblockexpression);
    } else {
      Object _xifexpression_1 = null;
      if ((sv instanceof BooleanValue)) {
        boolean _xblockexpression_1 = false;
        {
          final BooleanValue bv = ((BooleanValue) sv);
          _xblockexpression_1 = bv.isValue();
        }
        _xifexpression_1 = Boolean.valueOf(_xblockexpression_1);
      } else {
        String _xifexpression_2 = null;
        if ((sv instanceof EnumValue)) {
          _xifexpression_2 = this.generateEnumConstTerm(((EnumValue)sv));
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public CharSequence generateContext(final Context context, final IFileSystemAccess2 fsa) {
    StringConcatenation _builder = new StringConcatenation();
    {
      DataTypeDeclaration _declaration = context.getDeclaration();
      if ((_declaration instanceof ReferencedDeclaration)) {
        DataTypeDeclaration _declaration_1 = context.getDeclaration();
        final ReferencedDeclaration refDec = ((ReferencedDeclaration) _declaration_1);
        _builder.newLineIfNotEmpty();
        _builder.append("create objectarray schema ");
        String _name = context.getName();
        _builder.append(_name);
        _builder.append("() starttimestamp ts endtimestamp ts inherits ");
        String _name_1 = refDec.getType().getName();
        _builder.append(_name_1);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      } else {
        DataTypeDeclaration _declaration_2 = context.getDeclaration();
        final ContainedDeclaration contDec = ((ContainedDeclaration) _declaration_2);
        _builder.newLineIfNotEmpty();
        DataType _type = contDec.getType();
        final DataType dataType = ((DataType) _type);
        _builder.newLineIfNotEmpty();
        String contextName = context.getName();
        _builder.newLineIfNotEmpty();
        {
          if ((dataType instanceof EnumType)) {
            final EnumType enumVar = ((EnumType) dataType);
            _builder.newLineIfNotEmpty();
            fsa.generateFile((((RoqmeCepGenerator.ENUM_PACKAGE_PATH + "/") + contextName) + RoqmeCepGenerator.JAVA_EXTENSION), this.generateJavaEnums(enumVar, contextName));
            _builder.newLineIfNotEmpty();
            _builder.append("create objectarray schema ");
            _builder.append(contextName);
            _builder.append("(val ");
            _builder.append(contextName);
            _builder.append(",ts long) starttimestamp ts endtimestamp ts;");
            _builder.newLineIfNotEmpty();
          } else {
            if ((dataType instanceof TimeType)) {
              _builder.append("create objectarray schema ");
              _builder.append(contextName);
              _builder.append("(val long,ts long) starttimestamp ts endtimestamp ts;");
              _builder.newLineIfNotEmpty();
            } else {
              if ((dataType instanceof NumericType)) {
                _builder.append("create objectarray schema ");
                _builder.append(contextName);
                _builder.append("(val double,ts long) starttimestamp ts endtimestamp ts;");
                _builder.newLineIfNotEmpty();
              } else {
                if ((dataType instanceof BooleanType)) {
                  _builder.append("create objectarray schema ");
                  _builder.append(contextName);
                  _builder.append("(val bool,ts long) starttimestamp ts endtimestamp ts;");
                  _builder.newLineIfNotEmpty();
                } else {
                  if ((dataType instanceof EventType)) {
                    _builder.append("create objectarray schema ");
                    _builder.append(contextName);
                    _builder.append("(ts long) starttimestamp ts endtimestamp ts;");
                    _builder.newLineIfNotEmpty();
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
  
  public CharSequence generateDerivedContexts(final List<TypedVariable> derivedContexts) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final TypedVariable element : derivedContexts) {
        {
          if ((element instanceof DerivedContext)) {
            final String name = ((DerivedContext)element).getName();
            _builder.newLineIfNotEmpty();
            final ContextPattern ctxPattern = ((DerivedContext)element).getDefinition();
            _builder.newLineIfNotEmpty();
            final DataTypeDeclaration contDec = ((DerivedContext)element).getDeclaration();
            _builder.newLineIfNotEmpty();
            {
              if ((contDec instanceof ContainedDeclaration)) {
                DataType _type = ((ContainedDeclaration)contDec).getType();
                final DataType dataType = ((DataType) _type);
                _builder.newLineIfNotEmpty();
                String _generateDerivedContextPatterns = this.generateDerivedContextPatterns(name, ctxPattern.getTerm(), dataType);
                _builder.append(_generateDerivedContextPatterns);
                _builder.newLineIfNotEmpty();
              } else {
                if ((contDec instanceof ReferencedDeclaration)) {
                  final ReferencedDeclaration refdec = ((ReferencedDeclaration) contDec);
                  _builder.newLineIfNotEmpty();
                  DataType _dataType = refdec.getType().getDataType();
                  final DataType dataType_1 = ((DataType) _dataType);
                  _builder.newLineIfNotEmpty();
                  String _generateDerivedContextPatterns_1 = this.generateDerivedContextPatterns(name, ctxPattern.getTerm(), dataType_1);
                  _builder.append(_generateDerivedContextPatterns_1);
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          } else {
            if ((element instanceof GeneralPurposeVariable)) {
              String _generateOnSetClausePatterns = this.generateOnSetClausePatterns(((GeneralPurposeVariable) element));
              _builder.append(_generateOnSetClausePatterns);
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
    }
    return _builder;
  }
  
  public String generateOnSetClausePatterns(final GeneralPurposeVariable variable) {
    String _xblockexpression = null;
    {
      final Term gpvTerm = variable.getDefinition().getTerm();
      final String streamName = variable.getName();
      DataTypeDeclaration _declaration = variable.getDeclaration();
      final ContainedDeclaration contDec = ((ContainedDeclaration) _declaration);
      DataType _type = contDec.getType();
      final DataType dataType = ((DataType) _type);
      _xblockexpression = this.generateOnSetClausePattern(gpvTerm, dataType, streamName);
    }
    return _xblockexpression;
  }
  
  public String generateOnSetClausePatterns(final SetVariable setVar) {
    String _xblockexpression = null;
    {
      final Term setTerm = setVar.getExpression().getTerm();
      final String streamName = setVar.getVariable().getName();
      DataTypeDeclaration _declaration = setVar.getVariable().getDeclaration();
      final ContainedDeclaration contDec = ((ContainedDeclaration) _declaration);
      DataType _type = contDec.getType();
      final DataType dataType = ((DataType) _type);
      _xblockexpression = this.generateOnSetClausePattern(setTerm, dataType, streamName);
    }
    return _xblockexpression;
  }
  
  public String generateOnSetClausePattern(final Term term, final DataType dataType, final String streamName) {
    String _xblockexpression = null;
    {
      RoqmeCepGenerator.letter = 'a';
      String _xifexpression = null;
      if ((!(term instanceof ConstTerm))) {
        String _xblockexpression_1 = null;
        {
          StringConcatenation _builder = new StringConcatenation();
          CharSequence _generateAuxiliarPatterns = this.generateAuxiliarPatterns(streamName, term, false);
          _builder.append(_generateAuxiliarPatterns);
          final String aux = _builder.toString();
          String _xifexpression_1 = null;
          if (((dataType instanceof NumericType) || (dataType instanceof EnumType))) {
            StringConcatenation _builder_1 = new StringConcatenation();
            CharSequence _generateOnSetClauseEPL = this.generateOnSetClauseEPL(streamName, "a.val", this.generateTerm(term));
            _builder_1.append(_generateOnSetClauseEPL);
            _xifexpression_1 = (aux + _builder_1);
          } else {
            String _xifexpression_2 = null;
            if ((dataType instanceof BooleanType)) {
              StringConcatenation _builder_2 = new StringConcatenation();
              CharSequence _generateOnSetClauseEPL_1 = this.generateOnSetClauseEPL(streamName, "true", this.generateTerm(term));
              _builder_2.append(_generateOnSetClauseEPL_1);
              String _plus = (aux + _builder_2);
              StringConcatenation _builder_3 = new StringConcatenation();
              CharSequence _generateOnSetClauseEPL_2 = this.generateOnSetClauseEPL(streamName, "false", this.generateNotTerm(term).toString());
              _builder_3.append(_generateOnSetClauseEPL_2);
              _xifexpression_2 = (_plus + _builder_3);
            }
            _xifexpression_1 = _xifexpression_2;
          }
          _xblockexpression_1 = _xifexpression_1;
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public CharSequence generateOnSetClauseEPL(final String varName, final String value, final String pattern) {
    CharSequence _xblockexpression = null;
    {
      String finalPattern = pattern;
      boolean _equals = Objects.equal("a.val", value);
      if (_equals) {
        finalPattern = ("a = " + pattern);
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("on pattern [every ( ");
      _builder.append(finalPattern);
      _builder.append(" ) ]");
      _builder.newLineIfNotEmpty();
      _builder.append("set ");
      _builder.append(varName);
      _builder.append(" = ");
      _builder.append(value);
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public String generateDerivedContextPatterns(final String streamName, final Term term, final DataType dataType) {
    String _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _generateAuxiliarPatterns = this.generateAuxiliarPatterns(streamName, term, false);
      _builder.append(_generateAuxiliarPatterns);
      final String aux = _builder.toString();
      RoqmeCepGenerator.letter = 'a';
      String _xifexpression = null;
      if (((dataType instanceof NumericType) || (dataType instanceof EnumType))) {
        StringConcatenation _builder_1 = new StringConcatenation();
        CharSequence _generateDerivedContextPattern = this.generateDerivedContextPattern(streamName, "a.val", this.generateTerm(term));
        _builder_1.append(_generateDerivedContextPattern);
        _xifexpression = (aux + _builder_1);
      } else {
        String _xifexpression_1 = null;
        if ((dataType instanceof BooleanType)) {
          String _xifexpression_2 = null;
          if (((term instanceof ConditionalTerm) || this.isCustomAggregationFunction(term))) {
            String _xblockexpression_1 = null;
            {
              Object _generateNaryTermOp = this.generateNaryTermOp(((NaryTermOp) term));
              String _string = null;
              if (_generateNaryTermOp!=null) {
                _string=_generateNaryTermOp.toString();
              }
              final String termStr = _string;
              StringConcatenation _builder_2 = new StringConcatenation();
              CharSequence _generateDerivedContextPattern_1 = this.generateDerivedContextPattern(streamName, "a.val", termStr);
              _builder_2.append(_generateDerivedContextPattern_1);
              _xblockexpression_1 = (aux + _builder_2);
            }
            _xifexpression_2 = _xblockexpression_1;
          } else {
            StringConcatenation _builder_2 = new StringConcatenation();
            CharSequence _generateDerivedContextPattern_1 = this.generateDerivedContextPattern(streamName, "true", this.generateTerm(term));
            _builder_2.append(_generateDerivedContextPattern_1);
            String _plus = (aux + _builder_2);
            StringConcatenation _builder_3 = new StringConcatenation();
            CharSequence _generateDerivedContextPattern_2 = this.generateDerivedContextPattern(streamName, "false", this.generateNotTerm(term).toString());
            _builder_3.append(_generateDerivedContextPattern_2);
            _xifexpression_2 = (_plus + _builder_3);
          }
          _xifexpression_1 = _xifexpression_2;
        } else {
          String _xifexpression_3 = null;
          if ((dataType instanceof EventType)) {
            StringConcatenation _builder_4 = new StringConcatenation();
            CharSequence _generateDerivedContextPattern_3 = this.generateDerivedContextPattern(streamName, "", this.generateTerm(term));
            _builder_4.append(_generateDerivedContextPattern_3);
            _xifexpression_3 = (aux + _builder_4);
          }
          _xifexpression_1 = _xifexpression_3;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public CharSequence generateDerivedContextPattern(final String streamName, final String selectattrs, final String pattern) {
    CharSequence _xblockexpression = null;
    {
      String finalSelectAttrs = "";
      String finalPattern = pattern;
      boolean _matched = false;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(selectattrs);
      if (_isNullOrEmpty) {
        _matched=true;
        finalSelectAttrs = selectattrs;
      }
      if (!_matched) {
        if (Objects.equal(selectattrs, "a.val")) {
          _matched=true;
          finalSelectAttrs = (selectattrs + " as val");
          finalPattern = ("a = " + pattern);
        }
      }
      if (!_matched) {
        finalSelectAttrs = (selectattrs + " as val");
      }
      String _everyO = this.getEveryO();
      String _plus = ("pattern [ " + _everyO);
      String _plus_1 = (_plus + finalPattern);
      String _everyC = this.getEveryC();
      String _plus_2 = (_plus_1 + _everyC);
      final String strPattern = (_plus_2 + " ]");
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _generateInsertIntoPattern = this.generateInsertIntoPattern(streamName, finalSelectAttrs, strPattern);
      _builder.append(_generateInsertIntoPattern);
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence generatePatternDefinitions(final EList<Sentence> sentences) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Sentence sentence : sentences) {
        {
          if ((sentence instanceof Observation)) {
            String _generateObservation = this.generateObservation(((Observation) sentence));
            _builder.append(_generateObservation);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public String generateObservation(final Observation obs) {
    String _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _generateAuxiliarPatterns = this.generateAuxiliarPatterns(obs.getName(), obs.getPattern().getTerm(), false);
      _builder.append(_generateAuxiliarPatterns);
      final String aux = _builder.toString();
      RoqmeCepGenerator.letter = 'a';
      StringConcatenation _builder_1 = new StringConcatenation();
      CharSequence _generateObservationPattern = this.generateObservationPattern(obs.getName(), obs.getPattern().getTerm());
      _builder_1.append(_generateObservationPattern);
      String _plus = (aux + _builder_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      String _generateSetVariableActions = this.generateSetVariableActions(obs);
      _builder_2.append(_generateSetVariableActions);
      _xblockexpression = (_plus + _builder_2);
    }
    return _xblockexpression;
  }
  
  public String generateSetVariableActions(final Observation observation) {
    final String obsName = observation.getName();
    String res = "";
    EList<Action> _actions = observation.getActions();
    for (final Action action : _actions) {
      if ((action instanceof SetVariable)) {
        final String name = ((SetVariable)action).getVariable().getName();
        Term _term = ((SetVariable)action).getExpression().getTerm();
        if ((_term instanceof ConstTerm)) {
          Term _term_1 = ((SetVariable)action).getExpression().getTerm();
          Object _generateConstTerm = this.generateConstTerm(((ConstTerm) _term_1));
          String _string = null;
          if (_generateConstTerm!=null) {
            _string=_generateConstTerm.toString();
          }
          final String value = _string;
          CharSequence _generateOnSetClauseEPL = this.generateOnSetClauseEPL(name, value, (("Observations(val = \'" + obsName) + "\')"));
          String _plus = (res + _generateOnSetClauseEPL);
          res = _plus;
        } else {
          Term _term_2 = ((SetVariable)action).getExpression().getTerm();
          if ((_term_2 instanceof BinaryArithOp)) {
            Object _generateExpressionClause = this.generateExpressionClause(((SetVariable)action).getExpression().getTerm());
            String _string_1 = null;
            if (_generateExpressionClause!=null) {
              _string_1=_generateExpressionClause.toString();
            }
            final String value_1 = _string_1;
            CharSequence _generateOnSetClauseEPL_1 = this.generateOnSetClauseEPL(name, value_1, (("Observations(val = \'" + obsName) + "\')"));
            String _plus_1 = (res + _generateOnSetClauseEPL_1);
            res = _plus_1;
          }
        }
      }
    }
    return res;
  }
  
  public CharSequence generateAuxiliarPatterns(final String obsName, final Term term, final boolean arith) {
    CharSequence _xifexpression = null;
    if ((term instanceof BinaryArithOp)) {
      StringConcatenation _builder = new StringConcatenation();
      Object _generateAuxiliarPatterns = this.generateAuxiliarPatterns(obsName, ((BinaryArithOp)term).getLeft(), true);
      _builder.append(_generateAuxiliarPatterns);
      _builder.newLineIfNotEmpty();
      Object _generateAuxiliarPatterns_1 = this.generateAuxiliarPatterns(obsName, ((BinaryArithOp)term).getRight(), true);
      _builder.append(_generateAuxiliarPatterns_1);
      _builder.newLineIfNotEmpty();
      {
        if ((!arith)) {
          String _generateArithmeticsPatterns = this.generateArithmeticsPatterns(obsName, ((BinaryArithOp)term));
          _builder.append(_generateArithmeticsPatterns);
        }
      }
      _xifexpression = _builder;
    } else {
      CharSequence _xifexpression_1 = null;
      if ((term instanceof BinaryTermOp)) {
        StringConcatenation _builder_1 = new StringConcatenation();
        Object _generateAuxiliarPatterns_2 = this.generateAuxiliarPatterns(obsName, ((BinaryTermOp)term).getLeft(), false);
        _builder_1.append(_generateAuxiliarPatterns_2);
        _builder_1.newLineIfNotEmpty();
        Object _generateAuxiliarPatterns_3 = this.generateAuxiliarPatterns(obsName, ((BinaryTermOp)term).getRight(), false);
        _builder_1.append(_generateAuxiliarPatterns_3);
        _xifexpression_1 = _builder_1;
      } else {
        CharSequence _xifexpression_2 = null;
        if ((term instanceof AggregationFunction)) {
          StringConcatenation _builder_2 = new StringConcatenation();
          {
            EList<Term> _terms = ((AggregationFunction)term).getTerms();
            for(final Term nary : _terms) {
              Object _generateAuxiliarPatterns_4 = this.generateAuxiliarPatterns(obsName, nary, false);
              _builder_2.append(_generateAuxiliarPatterns_4);
            }
          }
          _builder_2.newLineIfNotEmpty();
          CharSequence _generateAggregationPatterns = this.generateAggregationPatterns(obsName, ((AggregationFunction)term));
          _builder_2.append(_generateAggregationPatterns);
          _builder_2.newLineIfNotEmpty();
          _xifexpression_2 = _builder_2;
        } else {
          CharSequence _xifexpression_3 = null;
          if ((term instanceof ArithFunction)) {
            StringConcatenation _builder_3 = new StringConcatenation();
            {
              EList<Term> _terms_1 = ((ArithFunction)term).getTerms();
              for(final Term nary_1 : _terms_1) {
                Object _generateAuxiliarPatterns_5 = this.generateAuxiliarPatterns(obsName, nary_1, false);
                _builder_3.append(_generateAuxiliarPatterns_5);
              }
            }
            _builder_3.newLineIfNotEmpty();
            CharSequence _generateArithFunctionPatterns = this.generateArithFunctionPatterns(obsName, ((ArithFunction)term));
            _builder_3.append(_generateArithFunctionPatterns);
            _builder_3.newLineIfNotEmpty();
            _xifexpression_3 = _builder_3;
          } else {
            CharSequence _xifexpression_4 = null;
            if ((term instanceof PatternFunction)) {
              StringConcatenation _builder_4 = new StringConcatenation();
              {
                EList<Term> _terms_2 = ((PatternFunction)term).getTerms();
                for(final Term nary_2 : _terms_2) {
                  Object _generateAuxiliarPatterns_6 = this.generateAuxiliarPatterns(obsName, nary_2, false);
                  _builder_4.append(_generateAuxiliarPatterns_6);
                }
              }
              _builder_4.newLineIfNotEmpty();
              CharSequence _generatePatternFunctionPatterns = this.generatePatternFunctionPatterns(obsName, ((PatternFunction)term));
              _builder_4.append(_generatePatternFunctionPatterns);
              _builder_4.newLineIfNotEmpty();
              _xifexpression_4 = _builder_4;
            } else {
              CharSequence _xifexpression_5 = null;
              if ((term instanceof ConditionalTerm)) {
                CharSequence _xblockexpression = null;
                {
                  final Term condition = ((ConditionalTerm)term).getTerms().get(0);
                  StringConcatenation _builder_5 = new StringConcatenation();
                  Object _generateAuxiliarPatterns_7 = this.generateAuxiliarPatterns(obsName, condition, false);
                  _builder_5.append(_generateAuxiliarPatterns_7);
                  _builder_5.newLineIfNotEmpty();
                  CharSequence _generateConditionalPatterns = this.generateConditionalPatterns(obsName, ((ConditionalTerm)term));
                  _builder_5.append(_generateConditionalPatterns);
                  _builder_5.newLineIfNotEmpty();
                  _xblockexpression = _builder_5;
                }
                _xifexpression_5 = _xblockexpression;
              } else {
                CharSequence _xifexpression_6 = null;
                if ((term instanceof ScheduleFunction)) {
                  this.generateSchedule(((ScheduleFunction)term));
                } else {
                  CharSequence _xifexpression_7 = null;
                  if ((term instanceof NaryTermOp)) {
                    StringConcatenation _builder_5 = new StringConcatenation();
                    {
                      EList<Term> _terms_3 = ((NaryTermOp)term).getTerms();
                      for(final Term nary_3 : _terms_3) {
                        Object _generateAuxiliarPatterns_7 = this.generateAuxiliarPatterns(obsName, nary_3, false);
                        _builder_5.append(_generateAuxiliarPatterns_7);
                      }
                    }
                    _xifexpression_7 = _builder_5;
                  } else {
                    CharSequence _xifexpression_8 = null;
                    if ((term instanceof RangeTerm)) {
                      StringConcatenation _builder_6 = new StringConcatenation();
                      Object _generateAuxiliarPatterns_8 = this.generateAuxiliarPatterns(obsName, ((RangeTerm)term).getTerm(), false);
                      _builder_6.append(_generateAuxiliarPatterns_8);
                      _builder_6.newLineIfNotEmpty();
                      CharSequence _generateRangeTermPatterns = this.generateRangeTermPatterns(obsName, ((RangeTerm)term));
                      _builder_6.append(_generateRangeTermPatterns);
                      _builder_6.newLineIfNotEmpty();
                      _xifexpression_8 = _builder_6;
                    } else {
                      CharSequence _xifexpression_9 = null;
                      if ((term instanceof UnaryTermOp)) {
                        CharSequence _xblockexpression_1 = null;
                        {
                          this.once = (term instanceof OnceTerm);
                          StringConcatenation _builder_7 = new StringConcatenation();
                          Object _generateAuxiliarPatterns_9 = this.generateAuxiliarPatterns(obsName, ((UnaryTermOp)term).getTerm(), false);
                          _builder_7.append(_generateAuxiliarPatterns_9);
                          _xblockexpression_1 = _builder_7;
                        }
                        _xifexpression_9 = _xblockexpression_1;
                      }
                      _xifexpression_8 = _xifexpression_9;
                    }
                    _xifexpression_7 = _xifexpression_8;
                  }
                  _xifexpression_6 = _xifexpression_7;
                }
                _xifexpression_5 = _xifexpression_6;
              }
              _xifexpression_4 = _xifexpression_5;
            }
            _xifexpression_3 = _xifexpression_4;
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public CharSequence generateRangeTermPatterns(final String obsName, final RangeTerm term) {
    CharSequence _xblockexpression = null;
    {
      final String streamName = this.generateStreamName(term, obsName);
      this.auxPatternsNames.put(term, streamName);
      final String strTerm = this.generateTerm(term.getTerm());
      String _everyO = this.getEveryO();
      String _plus = ("pattern [ " + _everyO);
      String _plus_1 = (_plus + strTerm);
      String _everyC = this.getEveryC();
      String _plus_2 = (_plus_1 + _everyC);
      final String pattern = (_plus_2 + " ]");
      final int lowerBound = term.getLowerBound();
      final int upperBound = term.getUpperBound();
      final String havingClause = (((("count(*) >= " + Integer.valueOf(lowerBound)) + " and ") + "count(*) <= ") + Integer.valueOf(upperBound));
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _generateInsertIntoHavingPattern = this.generateInsertIntoHavingPattern(streamName, "", pattern, havingClause);
      _builder.append(_generateInsertIntoHavingPattern);
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence generateConditionalPatterns(final String obsName, final ConditionalTerm term) {
    CharSequence _xblockexpression = null;
    {
      Term _get = term.getTerms().get(0);
      final BinaryTermOp condition = ((BinaryTermOp) _get);
      Term _get_1 = term.getTerms().get(1);
      final ConstTerm trueCase = ((ConstTerm) _get_1);
      Term _get_2 = term.getTerms().get(2);
      final ConstTerm falseCase = ((ConstTerm) _get_2);
      final String streamName = this.generateStreamName(term, obsName);
      this.auxPatternsNames.put(term, streamName);
      final String expr = this.generateExpressionClause(condition).toString();
      final String caseExpr = this.generateCaseExpresion(expr, trueCase, falseCase);
      final String strPattern = this.generateFromClause(condition, "lastevent").toString();
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _generateInsertIntoPattern = this.generateInsertIntoPattern(streamName, caseExpr, strPattern);
      _builder.append(_generateInsertIntoPattern);
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public String generateCaseExpresion(final String expr, final ConstTerm trueCase, final ConstTerm falseCase) {
    Object _generateConstTerm = this.generateConstTerm(trueCase);
    String _plus = ((("CASE WHEN " + expr) + " THEN ") + _generateConstTerm);
    String _plus_1 = (_plus + " ELSE ");
    Object _generateConstTerm_1 = this.generateConstTerm(falseCase);
    String _plus_2 = (_plus_1 + _generateConstTerm_1);
    return (_plus_2 + " END as val");
  }
  
  public CharSequence generateArithFunctionPatterns(final String obsName, final ArithFunction term) {
    CharSequence _xblockexpression = null;
    {
      final String functionName = term.getName().toString().toLowerCase();
      final String streamName = this.generateStreamName(term, obsName);
      String selectAttr = "val";
      if ((Objects.equal(term.getName(), ArithFtnEnum.POW) && (term.getTerms().get(1) != null))) {
        final String exp = this.generateTerm(term.getTerms().get(1));
        selectAttr = ("val," + exp);
      }
      this.auxPatternsNames.put(term, streamName);
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _generateInsertIntoPattern = this.generateInsertIntoPattern(streamName, ((((("Math." + functionName) + "(") + selectAttr) + ")") + " as val"), this.generateTerm(term.getTerms().get(0)));
      _builder.append(_generateInsertIntoPattern);
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence generateAggregationPatterns(final String obsName, final AggregationFunction term) {
    CharSequence _xblockexpression = null;
    {
      final String streamName = this.generateStreamName(term, obsName);
      this.auxPatternsNames.put(term, streamName);
      CharSequence _xifexpression = null;
      boolean _isCustomAggregationFunction = this.isCustomAggregationFunction(term);
      if (_isCustomAggregationFunction) {
        _xifexpression = this.generateCustomAggregationFunctions(streamName, term);
      } else {
        _xifexpression = this.generateEsperAggregationFunctions(streamName, term);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public boolean isCustomAggregationFunction(final Term term) {
    boolean _xblockexpression = false;
    {
      boolean res = false;
      boolean _xifexpression = false;
      if ((term instanceof AggregationFunction)) {
        boolean _xifexpression_1 = false;
        if (((Objects.equal(((AggregationFunction)term).getName(), AggregationFtnEnum.DECREASING) || Objects.equal(((AggregationFunction)term).getName(), AggregationFtnEnum.INCREASING)) || Objects.equal(((AggregationFunction)term).getName(), AggregationFtnEnum.STABLE))) {
          _xifexpression_1 = res = true;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public CharSequence generateCustomAggregationFunctions(final String streamName, final AggregationFunction term) {
    CharSequence _xblockexpression = null;
    {
      final String symbol = this.getSymbolForCustomAggregation(term);
      String selectAttr = ((("window(" + "b.val") + symbol) + "a.val).allOf(v=>v=true) as val");
      final int size = term.getTerms().size();
      CharSequence _xifexpression = null;
      if ((size == 2)) {
        CharSequence _xblockexpression_1 = null;
        {
          final String termStr = this.generateTerm(term.getTerms().get(0));
          Term _get = term.getTerms().get(1);
          final String window = this.generateAggregationWindow(((ConstTerm) _get));
          String _everyO = this.getEveryO();
          String _plus = ("pattern [ " + _everyO);
          String _plus_1 = (_plus + "a=");
          String _plus_2 = (_plus_1 + termStr);
          String _plus_3 = (_plus_2 + " -> b=");
          String _plus_4 = (_plus_3 + termStr);
          String _everyC = this.getEveryC();
          String _plus_5 = (_plus_4 + _everyC);
          String _plus_6 = (_plus_5 + " ]#");
          final String pattern = (_plus_6 + window);
          _xblockexpression_1 = this.generateInsertIntoPattern(streamName, selectAttr, pattern);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String getSymbolForCustomAggregation(final AggregationFunction term) {
    String _switchResult = null;
    AggregationFtnEnum _name = term.getName();
    if (_name != null) {
      switch (_name) {
        case DECREASING:
          _switchResult = "<";
          break;
        case INCREASING:
          _switchResult = ">";
          break;
        case STABLE:
          _switchResult = "=";
          break;
        default:
          break;
      }
    }
    return _switchResult;
  }
  
  public CharSequence generateEsperAggregationFunctions(final String streamName, final AggregationFunction term) {
    CharSequence _xblockexpression = null;
    {
      final String functionName = term.getName().toString();
      final String lowerFunctionName = functionName.toLowerCase();
      final int size = term.getTerms().size();
      String selectAttr = "val";
      AggregationFtnEnum _name = term.getName();
      boolean _equals = Objects.equal(_name, AggregationFtnEnum.COUNT);
      if (_equals) {
        selectAttr = "*";
      }
      CharSequence _switchResult = null;
      switch (size) {
        case 1:
          CharSequence _xblockexpression_1 = null;
          {
            final String fromClause = this.generateTerm(term.getTerms().get(0));
            _xblockexpression_1 = this.generateInsertIntoPattern(streamName, ((((lowerFunctionName + "(") + selectAttr) + ")") + " as val"), fromClause);
          }
          _switchResult = _xblockexpression_1;
          break;
        case 2:
          CharSequence _xblockexpression_2 = null;
          {
            Term _get = term.getTerms().get(1);
            final String window = this.generateAggregationWindow(((ConstTerm) _get));
            Object _generateFromClause = this.generateFromClause(term.getTerms().get(0), window);
            String _string = null;
            if (_generateFromClause!=null) {
              _string=_generateFromClause.toString();
            }
            final String fromClause = _string;
            _xblockexpression_2 = this.generateInsertIntoPattern(streamName, ((((lowerFunctionName + "(") + selectAttr) + ")") + " as val"), fromClause);
          }
          _switchResult = _xblockexpression_2;
          break;
        case 3:
          CharSequence _xblockexpression_3 = null;
          {
            Term _get = term.getTerms().get(1);
            final String window = this.generateAggregationWindow(((ConstTerm) _get));
            Object _generateFromClause = this.generateFromClause(term.getTerms().get(0), window);
            String _string = null;
            if (_generateFromClause!=null) {
              _string=_generateFromClause.toString();
            }
            final String fromClause = _string;
            Object _generateExpressionClause = this.generateExpressionClause(term.getTerms().get(2));
            String _string_1 = null;
            if (_generateExpressionClause!=null) {
              _string_1=_generateExpressionClause.toString();
            }
            final String whereClause = _string_1;
            _xblockexpression_3 = this.generateInsertIntoWherePattern(streamName, ((((lowerFunctionName + "(") + selectAttr) + ")") + " as val"), fromClause, whereClause);
          }
          _switchResult = _xblockexpression_3;
          break;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public String generateAggregationWindow(final ConstTerm const_) {
    String _xblockexpression = null;
    {
      String window = "";
      final TypedValue value = const_.getValue();
      if ((value instanceof UnitMeasuredValue)) {
        final double realValue = ((UnitMeasuredValue)value).getValue();
        final String unit = ((UnitMeasuredValue)value).getUnit();
        window = (((("time_batch(" + Double.valueOf(realValue)) + " ") + unit) + ")");
      } else {
        if ((value instanceof NumericValue)) {
          double _value = ((NumericValue)value).getValue();
          String _plus = ("lenght(" + Double.valueOf(_value));
          String _plus_1 = (_plus + ")");
          window = _plus_1;
        }
      }
      _xblockexpression = window;
    }
    return _xblockexpression;
  }
  
  public CharSequence generatePatternFunctionPatterns(final String obsName, final PatternFunction term) {
    CharSequence _xblockexpression = null;
    {
      final PatternFtnEnum functionName = term.getName();
      final String streamName = this.generateStreamName(term, obsName);
      this.auxPatternsNames.put(term, streamName);
      CharSequence _xifexpression = null;
      boolean _equals = Objects.equal(functionName, PatternFtnEnum.EVENT_WHEN);
      if (_equals) {
        StringConcatenation _builder = new StringConcatenation();
        CharSequence _generateEventWhenPattern = this.generateEventWhenPattern(term, streamName);
        _builder.append(_generateEventWhenPattern);
        _xifexpression = _builder;
      } else {
        CharSequence _xifexpression_1 = null;
        boolean _equals_1 = Objects.equal(functionName, PatternFtnEnum.UPDATE);
        if (_equals_1) {
          StringConcatenation _builder_1 = new StringConcatenation();
          CharSequence _generateUpdatePattern = this.generateUpdatePattern(term, streamName);
          _builder_1.append(_generateUpdatePattern);
          _xifexpression_1 = _builder_1;
        } else {
          CharSequence _xifexpression_2 = null;
          boolean _equals_2 = Objects.equal(functionName, PatternFtnEnum.PERIOD);
          if (_equals_2) {
            StringConcatenation _builder_2 = new StringConcatenation();
            CharSequence _generatePeriodPattern = this.generatePeriodPattern(term, streamName);
            _builder_2.append(_generatePeriodPattern);
            _xifexpression_2 = _builder_2;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public CharSequence generatePeriodPattern(final PatternFunction term, final String streamName) {
    CharSequence _xblockexpression = null;
    {
      final Term firstTerm = term.getTerms().get(0);
      CharSequence _xifexpression = null;
      if (((firstTerm != null) && this.isContextNode(firstTerm))) {
        CharSequence _xblockexpression_1 = null;
        {
          final String varTerm = this.generateContextTerm(firstTerm);
          final String selectClause = "cast((b.ts - a.ts)/1000,long)  as val";
          String strPattern = ((((((((((" ( a = " + varTerm) + " )") + " -> ") + "( not ") + varTerm) + " AND ") + "( b = ") + varTerm) + "(val!=a.val)") + " ) )");
          String _everyO = this.getEveryO();
          String _plus = ("pattern [ " + _everyO);
          String _plus_1 = (_plus + strPattern);
          String _everyC = this.getEveryC();
          String _plus_2 = (_plus_1 + _everyC);
          final String pattern = (_plus_2 + " ]");
          _xblockexpression_1 = this.generateInsertIntoPattern(streamName, selectClause, pattern);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        CharSequence _xifexpression_1 = null;
        if ((firstTerm instanceof FollowedByTerm)) {
          CharSequence _xblockexpression_2 = null;
          {
            final String leftStr = this.generateTerm(((FollowedByTerm)firstTerm).getLeft());
            final String rightStr = this.generateTerm(((FollowedByTerm)firstTerm).getRight());
            final String selectClause = "cast((b.ts - a.ts)/1000,long) as val";
            String strPattern = ((((((" ( a = " + leftStr) + " )") + " -> ") + "( b = ") + rightStr) + " )");
            String _everyO = this.getEveryO();
            String _plus = ("pattern [ " + _everyO);
            String _plus_1 = (_plus + strPattern);
            String _everyC = this.getEveryC();
            String _plus_2 = (_plus_1 + _everyC);
            final String pattern = (_plus_2 + " ]");
            _xblockexpression_2 = this.generateInsertIntoPattern(streamName, selectClause, pattern);
          }
          _xifexpression_1 = _xblockexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public CharSequence generateUpdatePattern(final PatternFunction term, final String streamName) {
    CharSequence _xblockexpression = null;
    {
      String whereClause = "";
      final Term firstTerm = term.getTerms().get(0);
      String patternTrueToFalse = "";
      String patternFalseToTrue = "";
      CharSequence _xifexpression = null;
      if ((firstTerm instanceof FollowedByTerm)) {
        CharSequence _xblockexpression_1 = null;
        {
          final String termStr = this.generateTerm(firstTerm);
          final CharSequence notTermStr = this.generateNotTerm(firstTerm);
          String _everyO = this.getEveryO();
          String _plus = ("pattern [ " + _everyO);
          String _plus_1 = (_plus + "(");
          String _plus_2 = (_plus_1 + termStr);
          String _plus_3 = (_plus_2 + ")");
          String _plus_4 = (_plus_3 + "->");
          String _plus_5 = (_plus_4 + "(");
          String _plus_6 = (_plus_5 + notTermStr);
          String _plus_7 = (_plus_6 + ")");
          String _everyC = this.getEveryC();
          String _plus_8 = (_plus_7 + _everyC);
          String _plus_9 = (_plus_8 + " ]");
          patternTrueToFalse = _plus_9;
          String _everyO_1 = this.getEveryO();
          String _plus_10 = ("pattern [ " + _everyO_1);
          String _plus_11 = (_plus_10 + "(");
          String _plus_12 = (_plus_11 + notTermStr);
          String _plus_13 = (_plus_12 + ")");
          String _plus_14 = (_plus_13 + "->");
          String _plus_15 = (_plus_14 + "(");
          String _plus_16 = (_plus_15 + termStr);
          String _plus_17 = (_plus_16 + ")");
          String _everyC_1 = this.getEveryC();
          String _plus_18 = (_plus_17 + _everyC_1);
          String _plus_19 = (_plus_18 + " ]");
          patternFalseToTrue = _plus_19;
          StringConcatenation _builder = new StringConcatenation();
          CharSequence _generateInsertIntoPattern = this.generateInsertIntoPattern(streamName, "", patternTrueToFalse);
          _builder.append(_generateInsertIntoPattern);
          _builder.newLineIfNotEmpty();
          CharSequence _generateInsertIntoPattern_1 = this.generateInsertIntoPattern(streamName, "", patternFalseToTrue);
          _builder.append(_generateInsertIntoPattern_1);
          _xblockexpression_1 = _builder;
        }
        _xifexpression = _xblockexpression_1;
      } else {
        CharSequence _xifexpression_1 = null;
        boolean _isContextNode = this.isContextNode(firstTerm);
        boolean _not = (!_isContextNode);
        if (_not) {
          CharSequence _xblockexpression_2 = null;
          {
            whereClause = this.generateExpressionClause(firstTerm).toString();
            final String termStr = this.generateTerm(firstTerm);
            final CharSequence notTermStr = this.generateNotTerm(firstTerm);
            Object startPattern = this.generateFromClause(firstTerm, "firstevent");
            String _everyO = this.getEveryO();
            String _plus = ("pattern [ " + _everyO);
            String _plus_1 = (_plus + "(");
            String _plus_2 = (_plus_1 + termStr);
            String _plus_3 = (_plus_2 + ")");
            String _plus_4 = (_plus_3 + "->");
            String _plus_5 = (_plus_4 + "(");
            String _plus_6 = (_plus_5 + notTermStr);
            String _plus_7 = (_plus_6 + ")");
            String _everyC = this.getEveryC();
            String _plus_8 = (_plus_7 + _everyC);
            String _plus_9 = (_plus_8 + " ]");
            patternTrueToFalse = _plus_9;
            String _everyO_1 = this.getEveryO();
            String _plus_10 = ("pattern [ " + _everyO_1);
            String _plus_11 = (_plus_10 + "(");
            String _plus_12 = (_plus_11 + notTermStr);
            String _plus_13 = (_plus_12 + ")");
            String _plus_14 = (_plus_13 + "->");
            String _plus_15 = (_plus_14 + "(");
            String _plus_16 = (_plus_15 + termStr);
            String _plus_17 = (_plus_16 + ")");
            String _everyC_1 = this.getEveryC();
            String _plus_18 = (_plus_17 + _everyC_1);
            String _plus_19 = (_plus_18 + " ]");
            patternFalseToTrue = _plus_19;
            StringConcatenation _builder = new StringConcatenation();
            CharSequence _generateInsertIntoWherePattern = this.generateInsertIntoWherePattern(streamName, "", startPattern.toString(), whereClause);
            _builder.append(_generateInsertIntoWherePattern);
            _builder.newLineIfNotEmpty();
            CharSequence _generateInsertIntoPattern = this.generateInsertIntoPattern(streamName, "", patternTrueToFalse);
            _builder.append(_generateInsertIntoPattern);
            _builder.newLineIfNotEmpty();
            CharSequence _generateInsertIntoPattern_1 = this.generateInsertIntoPattern(streamName, "", patternFalseToTrue);
            _builder.append(_generateInsertIntoPattern_1);
            _xblockexpression_2 = _builder;
          }
          _xifexpression_1 = _xblockexpression_2;
        } else {
          CharSequence _xblockexpression_3 = null;
          {
            final String ctxName = this.generateContextTerm(firstTerm);
            patternTrueToFalse = (((((((((("(a = " + ctxName) + ")") + "->") + "(") + "not ") + ctxName) + " AND ") + ctxName) + "(val!=a.val)") + ")");
            String _everyO = this.getEveryO();
            String _plus = ("pattern [ " + _everyO);
            String _plus_1 = (_plus + "(");
            String _plus_2 = (_plus_1 + patternTrueToFalse);
            String _plus_3 = (_plus_2 + ")");
            String _everyC = this.getEveryC();
            String _plus_4 = (_plus_3 + _everyC);
            final String finalpatternTrueToFalse = (_plus_4 + " ]");
            Object startPattern = this.generateFromClause(firstTerm, "firstevent");
            StringConcatenation _builder = new StringConcatenation();
            CharSequence _generateInsertIntoPattern = this.generateInsertIntoPattern(streamName, "", startPattern.toString());
            _builder.append(_generateInsertIntoPattern);
            _builder.newLineIfNotEmpty();
            CharSequence _generateInsertIntoPattern_1 = this.generateInsertIntoPattern(streamName, "", finalpatternTrueToFalse);
            _builder.append(_generateInsertIntoPattern_1);
            _xblockexpression_3 = _builder;
          }
          _xifexpression_1 = _xblockexpression_3;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public CharSequence generateEventWhenPattern(final PatternFunction term, final String streamName) {
    CharSequence _xblockexpression = null;
    {
      final Term firstTerm = term.getTerms().get(0);
      Object _generateExpressionClause = this.generateExpressionClause(firstTerm);
      String _string = null;
      if (_generateExpressionClause!=null) {
        _string=_generateExpressionClause.toString();
      }
      String whereClause = _string;
      final Object startPattern = this.generateFromClause(firstTerm, "firstevent");
      CharSequence _generateNotTerm = this.generateNotTerm(firstTerm);
      String _plus = ("(" + _generateNotTerm);
      String _plus_1 = (_plus + ")");
      String _plus_2 = (_plus_1 + "->");
      String _plus_3 = (_plus_2 + "(");
      String _generateTerm = this.generateTerm(firstTerm);
      String _plus_4 = (_plus_3 + _generateTerm);
      final String pattern = (_plus_4 + ")");
      String _everyO = this.getEveryO();
      String _plus_5 = ("pattern [ " + _everyO);
      String _plus_6 = (_plus_5 + pattern);
      String _everyC = this.getEveryC();
      String _plus_7 = (_plus_6 + _everyC);
      final String finalPattern = (_plus_7 + " ]");
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _generateInsertIntoWherePattern = this.generateInsertIntoWherePattern(streamName, "", startPattern.toString(), whereClause.toString());
      _builder.append(_generateInsertIntoWherePattern);
      _builder.newLineIfNotEmpty();
      CharSequence _generateInsertIntoPattern = this.generateInsertIntoPattern(streamName, "", finalPattern);
      _builder.append(_generateInsertIntoPattern);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public String generateArithmeticsPatterns(final String obsName, final BinaryArithOp term) {
    String _xblockexpression = null;
    {
      String streamName = this.generateStreamName(term, obsName);
      this.auxPatternsNames.put(term, streamName);
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _generateBinaryArithOpPattern = this.generateBinaryArithOpPattern(term, streamName);
      _builder.append(_generateBinaryArithOpPattern);
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  public String generateStreamName(final Term term, final String obsName) {
    String _xblockexpression = null;
    {
      String opName = "";
      if ((term instanceof AddTerm)) {
        opName = "ADD";
      } else {
        if ((term instanceof SubTerm)) {
          opName = "SUB";
        } else {
          if ((term instanceof MultTerm)) {
            opName = "MUL";
          } else {
            if ((term instanceof DivTerm)) {
              opName = "DIV";
            } else {
              if ((term instanceof ArithFunction)) {
                opName = ((ArithFunction)term).getName().toString();
              } else {
                if ((term instanceof AggregationFunction)) {
                  opName = ((AggregationFunction)term).getName().toString();
                } else {
                  if ((term instanceof PatternFunction)) {
                    final PatternFtnEnum functionName = ((PatternFunction)term).getName();
                    boolean _equals = Objects.equal(functionName, PatternFtnEnum.EVENT_WHEN);
                    if (_equals) {
                      opName = "EW";
                    } else {
                      boolean _equals_1 = Objects.equal(functionName, PatternFtnEnum.UPDATE);
                      if (_equals_1) {
                        opName = "UP";
                      } else {
                        boolean _equals_2 = Objects.equal(functionName, PatternFtnEnum.PERIOD);
                        if (_equals_2) {
                          opName = "PE";
                        }
                      }
                    }
                  } else {
                    if ((term instanceof ConditionalTerm)) {
                      opName = "IF";
                    } else {
                      if ((term instanceof RangeTerm)) {
                        opName = "RG";
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      _xblockexpression = this.getUniqueStreamName((obsName + opName));
    }
    return _xblockexpression;
  }
  
  public String getUniqueStreamName(final String streamName) {
    final Collection<String> streamNames = this.auxPatternsNames.values();
    String res = "";
    boolean _contains = streamNames.contains(streamName);
    boolean _not = (!_contains);
    if (_not) {
      res = streamName;
    } else {
      int i = 1;
      String uniqueStreamName = (streamName + Integer.valueOf(i));
      while (streamNames.contains(uniqueStreamName)) {
        {
          i = (i + 1);
          uniqueStreamName = (streamName + Integer.valueOf(i));
        }
      }
      res = uniqueStreamName;
    }
    return res;
  }
  
  public CharSequence generateObservationPattern(final String obsName, final Term term) {
    CharSequence _xblockexpression = null;
    {
      String strAuxPattern = this.generateTerm(term);
      String _everyO = this.getEveryO();
      String _plus = ("pattern [ " + _everyO);
      String _plus_1 = (_plus + strAuxPattern);
      String _everyC = this.getEveryC();
      String _plus_2 = (_plus_1 + _everyC);
      final String strPattern = (_plus_2 + " ]");
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _generateObsInsertIntoPattern = this.generateObsInsertIntoPattern(obsName, strPattern);
      _builder.append(_generateObsInsertIntoPattern);
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence generateBinaryArithOpPattern(final BinaryArithOp term, final String streamName) {
    CharSequence _xblockexpression = null;
    {
      final Object selectAttrs = this.generateExpressionClause(term);
      Object _generateFromArithClause = this.generateFromArithClause(term, "lastevent");
      String _string = null;
      if (_generateFromArithClause!=null) {
        _string=_generateFromArithClause.toString();
      }
      final String strPattern = _string;
      StringConcatenation _builder = new StringConcatenation();
      String _plus = (selectAttrs + " as val");
      CharSequence _generateInsertIntoPattern = this.generateInsertIntoPattern(streamName, _plus, strPattern);
      _builder.append(_generateInsertIntoPattern);
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence generateObsInsertIntoPattern(final String selectAttrs, final String pattern) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("INSERT INTO Observations");
    _builder.newLine();
    _builder.append("SELECT \'");
    _builder.append(selectAttrs);
    _builder.append("\' as val");
    _builder.newLineIfNotEmpty();
    _builder.append("FROM ");
    String _replace = null;
    if (pattern!=null) {
      _replace=pattern.replace("\n", "");
    }
    _builder.append(_replace);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateInsertIntoPattern(final String streamName, final String selectAttrs, final String pattern) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("INSERT INTO ");
    _builder.append(streamName);
    _builder.newLineIfNotEmpty();
    _builder.append("SELECT ");
    {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(selectAttrs);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        _builder.append(selectAttrs);
        _builder.append(",");
      }
    }
    _builder.append("current_timestamp as ts");
    _builder.newLineIfNotEmpty();
    _builder.append("FROM ");
    String _replace = null;
    if (pattern!=null) {
      _replace=pattern.replace("\n", "");
    }
    _builder.append(_replace);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateInsertIntoWherePattern(final String streamName, final String selectAttrs, final String pattern, final String whereClause) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("INSERT INTO ");
    _builder.append(streamName);
    _builder.newLineIfNotEmpty();
    _builder.append("SELECT ");
    {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(selectAttrs);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        _builder.append(selectAttrs);
        _builder.append(",");
      }
    }
    _builder.append("current_timestamp as ts");
    _builder.newLineIfNotEmpty();
    _builder.append("FROM ");
    String _replace = null;
    if (pattern!=null) {
      _replace=pattern.replace("\n", "");
    }
    _builder.append(_replace);
    _builder.newLineIfNotEmpty();
    _builder.append("WHERE ");
    _builder.append(whereClause);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateInsertIntoHavingPattern(final String streamName, final String selectAttrs, final String pattern, final String havingClause) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("INSERT INTO ");
    _builder.append(streamName);
    _builder.newLineIfNotEmpty();
    _builder.append("SELECT ");
    {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(selectAttrs);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        _builder.append(selectAttrs);
        _builder.append(",");
      }
    }
    _builder.append("current_timestamp as ts");
    _builder.newLineIfNotEmpty();
    _builder.append("FROM ");
    String _replace = null;
    if (pattern!=null) {
      _replace=pattern.replace("\n", "");
    }
    _builder.append(_replace);
    _builder.newLineIfNotEmpty();
    _builder.append("HAVING ");
    _builder.append(havingClause);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public String generateTerm(final Term term) {
    String _xifexpression = null;
    if ((term instanceof NaryTermOp)) {
      StringConcatenation _builder = new StringConcatenation();
      Object _generateNaryTermOp = this.generateNaryTermOp(((NaryTermOp) term));
      _builder.append(_generateNaryTermOp);
      _xifexpression = _builder.toString();
    } else {
      String _xifexpression_1 = null;
      if ((term instanceof ConstTerm)) {
        String _xifexpression_2 = null;
        boolean _isEnumConstTerm = this.isEnumConstTerm(term);
        if (_isEnumConstTerm) {
          _xifexpression_2 = this.generateEnumFilter(((ConstTerm) term), "=");
        } else {
          StringConcatenation _builder_1 = new StringConcatenation();
          Object _generateConstTerm = this.generateConstTerm(((ConstTerm) term));
          _builder_1.append(_generateConstTerm);
          _xifexpression_2 = _builder_1.toString();
        }
        _xifexpression_1 = _xifexpression_2;
      } else {
        String _xifexpression_3 = null;
        if ((term instanceof BinaryTermOp)) {
          StringConcatenation _builder_2 = new StringConcatenation();
          CharSequence _generateBinaryTermOp = this.generateBinaryTermOp(((BinaryTermOp) term));
          _builder_2.append(_generateBinaryTermOp);
          _xifexpression_3 = _builder_2.toString();
        } else {
          String _xifexpression_4 = null;
          boolean _isBooleanVarTerm = this.isBooleanVarTerm(term);
          if (_isBooleanVarTerm) {
            StringConcatenation _builder_3 = new StringConcatenation();
            String _generateVarBooleanTerm = this.generateVarBooleanTerm(term, "true", "=");
            _builder_3.append(_generateVarBooleanTerm);
            _xifexpression_4 = _builder_3.toString();
          } else {
            String _xifexpression_5 = null;
            if ((term instanceof VarTerm)) {
              StringConcatenation _builder_4 = new StringConcatenation();
              String _generateVarTerm = this.generateVarTerm(((VarTerm) term));
              _builder_4.append(_generateVarTerm);
              _xifexpression_5 = _builder_4.toString();
            } else {
              String _xifexpression_6 = null;
              if ((term instanceof SelfTerm)) {
                StringConcatenation _builder_5 = new StringConcatenation();
                CharSequence _generateSelfTerm = this.generateSelfTerm(((SelfTerm) term));
                _builder_5.append(_generateSelfTerm);
                _xifexpression_6 = _builder_5.toString();
              } else {
                String _xifexpression_7 = null;
                if ((term instanceof UnaryTermOp)) {
                  StringConcatenation _builder_6 = new StringConcatenation();
                  CharSequence _generateUnaryTermOp = this.generateUnaryTermOp(((UnaryTermOp) term));
                  _builder_6.append(_generateUnaryTermOp);
                  _xifexpression_7 = _builder_6.toString();
                }
                _xifexpression_6 = _xifexpression_7;
              }
              _xifexpression_5 = _xifexpression_6;
            }
            _xifexpression_4 = _xifexpression_5;
          }
          _xifexpression_3 = _xifexpression_4;
        }
        _xifexpression_1 = _xifexpression_3;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public CharSequence generateUnaryTermOp(final UnaryTermOp term) {
    CharSequence _xifexpression = null;
    if ((term instanceof UnaryLogicalOp)) {
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _generateUnaryLogicalOp = this.generateUnaryLogicalOp(((UnaryLogicalOp)term));
      _builder.append(_generateUnaryLogicalOp);
      _xifexpression = _builder;
    } else {
      CharSequence _xifexpression_1 = null;
      if ((term instanceof UnaryPatternOp)) {
        StringConcatenation _builder_1 = new StringConcatenation();
        CharSequence _generateUnaryPatternOP = this.generateUnaryPatternOP(((UnaryPatternOp)term));
        _builder_1.append(_generateUnaryPatternOP);
        _xifexpression_1 = _builder_1;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public CharSequence generateUnaryPatternOP(final UnaryPatternOp term) {
    CharSequence _xifexpression = null;
    if ((term instanceof RepeatTerm)) {
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _generateRepeatTerm = this.generateRepeatTerm(((RepeatTerm)term));
      _builder.append(_generateRepeatTerm);
      _xifexpression = _builder;
    } else {
      CharSequence _xifexpression_1 = null;
      if ((term instanceof NotEventTerm)) {
        StringConcatenation _builder_1 = new StringConcatenation();
        CharSequence _generateNotEventTerm = this.generateNotEventTerm(((NotEventTerm)term));
        _builder_1.append(_generateNotEventTerm);
        _xifexpression_1 = _builder_1;
      } else {
        CharSequence _xifexpression_2 = null;
        if ((term instanceof RangeTerm)) {
          StringConcatenation _builder_2 = new StringConcatenation();
          String _generateRangeTerm = this.generateRangeTerm(((RangeTerm)term));
          _builder_2.append(_generateRangeTerm);
          _xifexpression_2 = _builder_2;
        } else {
          CharSequence _xifexpression_3 = null;
          if ((term instanceof OnceTerm)) {
            StringConcatenation _builder_3 = new StringConcatenation();
            CharSequence _generateOnceTerm = this.generateOnceTerm(((OnceTerm)term));
            _builder_3.append(_generateOnceTerm);
            _xifexpression_3 = _builder_3;
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public CharSequence generateBinaryTermOp(final BinaryTermOp term) {
    CharSequence _xifexpression = null;
    if ((term instanceof BinaryLogicalOp)) {
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _generateBinaryLogicalOP = this.generateBinaryLogicalOP(((BinaryLogicalOp) term));
      _builder.append(_generateBinaryLogicalOP);
      _xifexpression = _builder;
    } else {
      CharSequence _xifexpression_1 = null;
      if ((term instanceof BinaryArithOp)) {
        StringConcatenation _builder_1 = new StringConcatenation();
        String _generateBinaryArithOpTerm = this.generateBinaryArithOpTerm(((BinaryArithOp)term));
        _builder_1.append(_generateBinaryArithOpTerm);
        _xifexpression_1 = _builder_1;
      } else {
        CharSequence _xifexpression_2 = null;
        if ((term instanceof BinaryPatternOp)) {
          StringConcatenation _builder_2 = new StringConcatenation();
          CharSequence _generateBinaryPatternOp = this.generateBinaryPatternOp(((BinaryPatternOp) term));
          _builder_2.append(_generateBinaryPatternOp);
          _xifexpression_2 = _builder_2;
        } else {
          CharSequence _xifexpression_3 = null;
          if ((term instanceof BinaryRelationalOp)) {
            StringConcatenation _builder_3 = new StringConcatenation();
            CharSequence _generateBinaryRelationalOp = this.generateBinaryRelationalOp(((BinaryRelationalOp) term));
            _builder_3.append(_generateBinaryRelationalOp);
            _xifexpression_3 = _builder_3;
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public String generateBinaryArithOpTerm(final BinaryArithOp term) {
    String _xblockexpression = null;
    {
      final String varTermName = this.auxPatternsNames.get(term);
      String _xifexpression = null;
      if (((varTermName != null) && (!varTermName.isEmpty()))) {
        _xifexpression = varTermName;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public CharSequence generateBinaryRelationalOp(final BinaryRelationalOp term) {
    CharSequence _xblockexpression = null;
    {
      final String symbol = this.getSymbol(term);
      _xblockexpression = this.generateBinaryRelationalTerm(term, symbol);
    }
    return _xblockexpression;
  }
  
  public CharSequence generateBinaryRelationalTerm(final BinaryRelationalOp term, final String symbol) {
    CharSequence _xblockexpression = null;
    {
      String valStr = "(val";
      final Term right = term.getRight();
      final Term left = term.getLeft();
      CharSequence _xifexpression = null;
      if ((this.isBooleanVarTerm(left) && (right instanceof ConstTerm))) {
        CharSequence _xblockexpression_1 = null;
        {
          final Object boolVal = this.generateConstTerm(((ConstTerm) right));
          StringConcatenation _builder = new StringConcatenation();
          String _generateVarBooleanTerm = this.generateVarBooleanTerm(left, boolVal.toString(), symbol);
          _builder.append(_generateVarBooleanTerm);
          _xblockexpression_1 = _builder;
        }
        _xifexpression = _xblockexpression_1;
      } else {
        CharSequence _xifexpression_1 = null;
        if ((this.isBooleanVarTerm(right) && (left instanceof ConstTerm))) {
          CharSequence _xblockexpression_2 = null;
          {
            final Object boolVal = this.generateConstTerm(((ConstTerm) left));
            final String finalSymbol = this.getReverseSymbol(symbol);
            StringConcatenation _builder = new StringConcatenation();
            String _generateVarBooleanTerm = this.generateVarBooleanTerm(right, boolVal.toString(), finalSymbol);
            _builder.append(_generateVarBooleanTerm);
            _xblockexpression_2 = _builder;
          }
          _xifexpression_1 = _xblockexpression_2;
        } else {
          CharSequence _xifexpression_2 = null;
          if ((this.isContextNode(left) && this.isContextNode(right))) {
            CharSequence _xblockexpression_3 = null;
            {
              final char aLetter = RoqmeCepGenerator.letter++;
              final char bLetter = RoqmeCepGenerator.letter++;
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("(");
              _builder.append(aLetter);
              _builder.append("=");
              String _generateTerm = this.generateTerm(left);
              _builder.append(_generateTerm);
              _builder.append(" AND ");
              _builder.append(bLetter);
              _builder.append("=");
              String _generateTerm_1 = this.generateTerm(right);
              _builder.append(_generateTerm_1);
              _builder.append(") while(");
              _builder.append(aLetter);
              _builder.append(".val ");
              _builder.append(symbol);
              _builder.append(" ");
              _builder.append(bLetter);
              _builder.append(".val)");
              _xblockexpression_3 = _builder;
            }
            _xifexpression_2 = _xblockexpression_3;
          } else {
            CharSequence _xifexpression_3 = null;
            boolean _isContextNode = this.isContextNode(right);
            if (_isContextNode) {
              CharSequence _xblockexpression_4 = null;
              {
                String finalSymbol = this.getReverseSymbol(symbol);
                String lefttStr = "";
                boolean _isEnumConstTerm = this.isEnumConstTerm(left);
                if (_isEnumConstTerm) {
                  Object _generateConstTerm = this.generateConstTerm(((ConstTerm) left));
                  String _string = null;
                  if (_generateConstTerm!=null) {
                    _string=_generateConstTerm.toString();
                  }
                  lefttStr = _string;
                } else {
                  lefttStr = this.generateTerm(left);
                }
                StringConcatenation _builder = new StringConcatenation();
                String _generateTerm = this.generateTerm(right);
                _builder.append(_generateTerm);
                _builder.append(valStr);
                _builder.append(" ");
                _builder.append(finalSymbol);
                _builder.append(" ");
                _builder.append(lefttStr);
                _builder.append(")");
                _xblockexpression_4 = _builder;
              }
              _xifexpression_3 = _xblockexpression_4;
            } else {
              CharSequence _xifexpression_4 = null;
              boolean _isContextNode_1 = this.isContextNode(left);
              if (_isContextNode_1) {
                CharSequence _xblockexpression_5 = null;
                {
                  String rightStr = "";
                  boolean _isEnumConstTerm = this.isEnumConstTerm(right);
                  if (_isEnumConstTerm) {
                    Object _generateConstTerm = this.generateConstTerm(((ConstTerm) right));
                    String _string = null;
                    if (_generateConstTerm!=null) {
                      _string=_generateConstTerm.toString();
                    }
                    rightStr = _string;
                  } else {
                    rightStr = this.generateTerm(right);
                  }
                  StringConcatenation _builder = new StringConcatenation();
                  String _generateTerm = this.generateTerm(left);
                  _builder.append(_generateTerm);
                  _builder.append(valStr);
                  _builder.append(" ");
                  _builder.append(symbol);
                  _builder.append(" ");
                  _builder.append(rightStr);
                  _builder.append(")");
                  _xblockexpression_5 = _builder;
                }
                _xifexpression_4 = _xblockexpression_5;
              }
              _xifexpression_3 = _xifexpression_4;
            }
            _xifexpression_2 = _xifexpression_3;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String getReverseSymbol(final String symbol) {
    String _switchResult = null;
    if (symbol != null) {
      switch (symbol) {
        case "<":
          _switchResult = ">";
          break;
        case ">":
          _switchResult = "<";
          break;
        case "<=":
          _switchResult = ">=";
          break;
        case ">=":
          _switchResult = "<=";
          break;
        default:
          _switchResult = symbol;
          break;
      }
    } else {
      _switchResult = symbol;
    }
    return _switchResult;
  }
  
  public String getOpossiteSymbol(final String symbol) {
    String _switchResult = null;
    if (symbol != null) {
      switch (symbol) {
        case ">":
          _switchResult = "<=";
          break;
        case "<":
          _switchResult = ">=";
          break;
        case "=":
          _switchResult = "!=";
          break;
        case "!=":
          _switchResult = "=";
          break;
        case ">=":
          _switchResult = "<";
          break;
        case "<=":
          _switchResult = ">";
          break;
        case "AND":
          _switchResult = "OR";
          break;
        case "OR":
          _switchResult = "AND";
          break;
        default:
          _switchResult = symbol;
          break;
      }
    } else {
      _switchResult = symbol;
    }
    return _switchResult;
  }
  
  public CharSequence generateBinaryPatternOp(final BinaryPatternOp term) {
    CharSequence _xblockexpression = null;
    {
      String symbol = this.getSymbol(term);
      CharSequence _xifexpression = null;
      if ((term instanceof WhileTerm)) {
        StringConcatenation _builder = new StringConcatenation();
        CharSequence _generateWhileTerm = this.generateWhileTerm(((WhileTerm)term));
        _builder.append(_generateWhileTerm);
        _xifexpression = _builder;
      } else {
        CharSequence _xblockexpression_1 = null;
        {
          final String leftStr = this.getBinaryOpStrTerm(term.getLeft());
          final String rightStr = this.getBinaryOpStrTerm(term.getRight());
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append(leftStr);
          _builder_1.append(" ");
          _builder_1.append(symbol);
          _builder_1.append(" ");
          _builder_1.append(rightStr);
          _xblockexpression_1 = _builder_1;
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String getBinaryOpStrTerm(final Term term) {
    String _xifexpression = null;
    boolean _isBooleanVarTerm = this.isBooleanVarTerm(term);
    if (_isBooleanVarTerm) {
      _xifexpression = this.generateVarBooleanTerm(term, "true", "=");
    } else {
      _xifexpression = this.generateTerm(term);
    }
    return _xifexpression;
  }
  
  public CharSequence generateWhileTerm(final WhileTerm term) {
    CharSequence _xblockexpression = null;
    {
      final Term right = term.getRight();
      final ArrayList<String> whileVarTerms = CollectionLiterals.<String>newArrayList();
      String expr = "";
      this.fillVarTermList(right, whileVarTerms);
      Object _generateExpressionClause = this.generateExpressionClause(right);
      String _string = null;
      if (_generateExpressionClause!=null) {
        _string=_generateExpressionClause.toString();
      }
      expr = _string;
      RoqmeCepGenerator.letter = 'a';
      StringConcatenation _builder = new StringConcatenation();
      String _generateWhileTermRec = this.generateWhileTermRec(term.getLeft(), whileVarTerms);
      _builder.append(_generateWhileTermRec);
      _builder.append(" while (");
      _builder.append(expr);
      _builder.append(")");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public Object fillVarTermList(final Term term, final ArrayList<String> whileVarTerms) {
    Object _xifexpression = null;
    boolean _isContextNode = this.isContextNode(term);
    if (_isContextNode) {
      boolean _xblockexpression = false;
      {
        String varTerm = "";
        if ((term instanceof VarTerm)) {
          varTerm = this.generateVarTerm(((VarTerm)term));
        } else {
          varTerm = this.generateTerm(term);
        }
        boolean _xifexpression_1 = false;
        boolean _contains = whileVarTerms.contains(varTerm);
        boolean _not = (!_contains);
        if (_not) {
          _xifexpression_1 = whileVarTerms.add(varTerm);
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = Boolean.valueOf(_xblockexpression);
    } else {
      Object _xifexpression_1 = null;
      if ((term instanceof BinaryTermOp)) {
        Object _xblockexpression_1 = null;
        {
          this.fillVarTermList(((BinaryTermOp)term).getLeft(), whileVarTerms);
          _xblockexpression_1 = this.fillVarTermList(((BinaryTermOp)term).getRight(), whileVarTerms);
        }
        _xifexpression_1 = _xblockexpression_1;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public String generateWhileTermRec(final Term term, final List<String> whileVarTerms) {
    String strTerm = this.generateTerm(term);
    for (final String contextName : whileVarTerms) {
      boolean _contains = strTerm.contains(contextName);
      if (_contains) {
        String _string = contextName.toString();
        char _plusPlus = RoqmeCepGenerator.letter++;
        String _plus = (Character.valueOf(_plusPlus) + " = ");
        String _string_1 = contextName.toString();
        String _plus_1 = (_plus + _string_1);
        strTerm = strTerm.replace(_string, _plus_1);
      } else {
        char _plusPlus_1 = RoqmeCepGenerator.letter++;
        String _plus_2 = ((strTerm + " AND ") + Character.valueOf(_plusPlus_1));
        String _plus_3 = (_plus_2 + " = ");
        String _plus_4 = (_plus_3 + contextName);
        strTerm = _plus_4;
      }
    }
    return strTerm;
  }
  
  public Object generateFromClause(final Term term, final String window) {
    Object _xblockexpression = null;
    {
      RoqmeCepGenerator.letter = 'a';
      this.varTermAs.clear();
      _xblockexpression = this.generateFromClauseRec(term, window);
    }
    return _xblockexpression;
  }
  
  public Object generateFromArithClause(final Term term, final String window) {
    Object _xblockexpression = null;
    {
      RoqmeCepGenerator.letter = 'a';
      this.varTermAs.clear();
      _xblockexpression = this.generateFromArithClauseRec(term, window);
    }
    return _xblockexpression;
  }
  
  public Object generateFromClauseRec(final Term term, final String window) {
    Object _xifexpression = null;
    boolean _isContextNode = this.isContextNode(term);
    if (_isContextNode) {
      String _xblockexpression = null;
      {
        final String varTermName = this.generateContextTerm(term);
        String _xifexpression_1 = null;
        String _get = this.varTermAs.get(varTermName);
        boolean _tripleEquals = (_get == null);
        if (_tripleEquals) {
          String _xblockexpression_1 = null;
          {
            final String varTermCharacter = this.getVarTermLetter(varTermName);
            _xblockexpression_1 = ((((varTermName + "#") + window) + " as ") + varTermCharacter);
          }
          _xifexpression_1 = _xblockexpression_1;
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    } else {
      Object _xifexpression_1 = null;
      if ((term instanceof BinaryTermOp)) {
        String _xblockexpression_1 = null;
        {
          Object _generateFromClauseRec = this.generateFromClauseRec(((BinaryTermOp)term).getLeft(), window);
          String _string = null;
          if (_generateFromClauseRec!=null) {
            _string=_generateFromClauseRec.toString();
          }
          final String left = _string;
          Object _generateFromClauseRec_1 = this.generateFromClauseRec(((BinaryTermOp)term).getRight(), window);
          String _string_1 = null;
          if (_generateFromClauseRec_1!=null) {
            _string_1=_generateFromClauseRec_1.toString();
          }
          final String right = _string_1;
          String _xifexpression_2 = null;
          if (((!StringExtensions.isNullOrEmpty(left)) && (!StringExtensions.isNullOrEmpty(right)))) {
            _xifexpression_2 = ((left + ",") + right);
          } else {
            String _xifexpression_3 = null;
            boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(left);
            if (_isNullOrEmpty) {
              _xifexpression_3 = right;
            } else {
              _xifexpression_3 = left;
            }
            _xifexpression_2 = _xifexpression_3;
          }
          _xblockexpression_1 = _xifexpression_2;
        }
        _xifexpression_1 = _xblockexpression_1;
      } else {
        Object _xifexpression_2 = null;
        if ((term instanceof NaryTermOp)) {
          String res = "";
          String prev = "";
          String current = "";
          EList<Term> _terms = ((NaryTermOp)term).getTerms();
          for (final Term nary : _terms) {
            {
              current = this.generateFromClauseRec(nary, window).toString();
              if (((!StringExtensions.isNullOrEmpty(prev)) && (!StringExtensions.isNullOrEmpty(current)))) {
                res = ((res + ",") + current);
              } else {
                res = (res + ", ");
              }
              prev = current;
            }
          }
          return res;
        } else {
          Object _xifexpression_3 = null;
          if ((term instanceof UnaryTermOp)) {
            _xifexpression_3 = this.generateFromClauseRec(((UnaryTermOp)term).getTerm(), window);
          } else {
            String _xifexpression_4 = null;
            if ((term instanceof ConstTerm)) {
              String _xifexpression_5 = null;
              TypedValue _value = ((ConstTerm)term).getValue();
              if ((_value instanceof EnumValue)) {
                String _xblockexpression_2 = null;
                {
                  TypedValue _value_1 = ((ConstTerm)term).getValue();
                  final EnumValue enumVal = ((EnumValue) _value_1);
                  EnumType _enumType = enumVal.getValue().getEnumType();
                  final DataType enumType = ((DataType) _enumType);
                  EObject _eContainer = enumType.eContainer();
                  final DataTypeDeclaration contDec = ((DataTypeDeclaration) _eContainer);
                  EObject _eContainer_1 = contDec.eContainer();
                  final TypedVariable typedVar = ((TypedVariable) _eContainer_1);
                  final String varTermName = typedVar.getName();
                  String _xifexpression_6 = null;
                  String _get = this.varTermAs.get(varTermName);
                  boolean _tripleEquals = (_get == null);
                  if (_tripleEquals) {
                    String _xblockexpression_3 = null;
                    {
                      final String varTermCharacter = this.getVarTermLetter(varTermName);
                      _xblockexpression_3 = ((((varTermName + "#") + window) + " as ") + varTermCharacter);
                    }
                    _xifexpression_6 = _xblockexpression_3;
                  }
                  _xblockexpression_2 = _xifexpression_6;
                }
                _xifexpression_5 = _xblockexpression_2;
              }
              _xifexpression_4 = _xifexpression_5;
            }
            _xifexpression_3 = _xifexpression_4;
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public String generateContextTerm(final Term term) {
    String _xifexpression = null;
    if ((!(term instanceof VarTerm))) {
      _xifexpression = this.auxPatternsNames.get(term);
    } else {
      _xifexpression = this.generateVarTerm(((VarTerm) term));
    }
    return _xifexpression;
  }
  
  public Object generateFromArithClauseRec(final Term term, final String window) {
    Object _xifexpression = null;
    if ((this.isContextNode(term) && (!(term instanceof BinaryArithOp)))) {
      String _xblockexpression = null;
      {
        final String varTermName = this.generateContextTerm(term);
        String _xifexpression_1 = null;
        String _get = this.varTermAs.get(varTermName);
        boolean _tripleEquals = (_get == null);
        if (_tripleEquals) {
          String _xblockexpression_1 = null;
          {
            final String varTermCharacter = this.getVarTermLetter(varTermName);
            _xblockexpression_1 = ((((varTermName + "#") + window) + " as ") + varTermCharacter);
          }
          _xifexpression_1 = _xblockexpression_1;
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    } else {
      Object _xifexpression_1 = null;
      if ((term instanceof BinaryTermOp)) {
        String _xblockexpression_1 = null;
        {
          Object _generateFromArithClauseRec = this.generateFromArithClauseRec(((BinaryTermOp)term).getLeft(), window);
          String _string = null;
          if (_generateFromArithClauseRec!=null) {
            _string=_generateFromArithClauseRec.toString();
          }
          final String left = _string;
          Object _generateFromArithClauseRec_1 = this.generateFromArithClauseRec(((BinaryTermOp)term).getRight(), window);
          String _string_1 = null;
          if (_generateFromArithClauseRec_1!=null) {
            _string_1=_generateFromArithClauseRec_1.toString();
          }
          final String right = _string_1;
          String _xifexpression_2 = null;
          if (((!StringExtensions.isNullOrEmpty(left)) && (!StringExtensions.isNullOrEmpty(right)))) {
            _xifexpression_2 = ((left + ",") + right);
          } else {
            String _xifexpression_3 = null;
            boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(left);
            if (_isNullOrEmpty) {
              _xifexpression_3 = right;
            } else {
              _xifexpression_3 = left;
            }
            _xifexpression_2 = _xifexpression_3;
          }
          _xblockexpression_1 = _xifexpression_2;
        }
        _xifexpression_1 = _xblockexpression_1;
      } else {
        Object _xifexpression_2 = null;
        if ((term instanceof NaryTermOp)) {
          String _xblockexpression_2 = null;
          {
            String res = "";
            String prev = "";
            String current = "";
            EList<Term> _terms = ((NaryTermOp)term).getTerms();
            for (final Term nary : _terms) {
              {
                current = this.generateFromArithClauseRec(nary, window).toString();
                if (((!StringExtensions.isNullOrEmpty(prev)) && (!StringExtensions.isNullOrEmpty(current)))) {
                  res = ((res + ",") + current);
                } else {
                  res = (res + ", ");
                }
                prev = current;
              }
            }
            _xblockexpression_2 = res;
          }
          _xifexpression_2 = _xblockexpression_2;
        } else {
          Object _xifexpression_3 = null;
          if ((term instanceof UnaryTermOp)) {
            _xifexpression_3 = this.generateFromArithClauseRec(((UnaryTermOp)term).getTerm(), window);
          } else {
            String _xifexpression_4 = null;
            if ((term instanceof ConstTerm)) {
              String _xifexpression_5 = null;
              TypedValue _value = ((ConstTerm)term).getValue();
              if ((_value instanceof EnumValue)) {
                String _xblockexpression_3 = null;
                {
                  TypedValue _value_1 = ((ConstTerm)term).getValue();
                  final EnumValue enumVal = ((EnumValue) _value_1);
                  EnumType _enumType = enumVal.getValue().getEnumType();
                  final DataType enumType = ((DataType) _enumType);
                  EObject _eContainer = enumType.eContainer();
                  final DataTypeDeclaration contDec = ((DataTypeDeclaration) _eContainer);
                  EObject _eContainer_1 = contDec.eContainer();
                  final TypedVariable typedVar = ((TypedVariable) _eContainer_1);
                  final String varTermName = typedVar.getName();
                  String _xifexpression_6 = null;
                  String _get = this.varTermAs.get(varTermName);
                  boolean _tripleEquals = (_get == null);
                  if (_tripleEquals) {
                    String _xblockexpression_4 = null;
                    {
                      final String varTermCharacter = this.getVarTermLetter(varTermName);
                      _xblockexpression_4 = ((((varTermName + "#") + window) + " as ") + varTermCharacter);
                    }
                    _xifexpression_6 = _xblockexpression_4;
                  }
                  _xblockexpression_3 = _xifexpression_6;
                }
                _xifexpression_5 = _xblockexpression_3;
              }
              _xifexpression_4 = _xifexpression_5;
            }
            _xifexpression_3 = _xifexpression_4;
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public Object generateExpressionClauseRec(final Term term) {
    Object _xifexpression = null;
    if ((term instanceof BinaryTermOp)) {
      CharSequence _xblockexpression = null;
      {
        final String symbol = this.getSymbol(((BinaryTermOp)term));
        _xblockexpression = this.generateBinaryTermExpression(((BinaryTermOp)term), symbol, false);
      }
      _xifexpression = _xblockexpression;
    } else {
      Object _xifexpression_1 = null;
      boolean _isBooleanVarTerm = this.isBooleanVarTerm(term);
      if (_isBooleanVarTerm) {
        String _expresionOperand = this.getExpresionOperand(term);
        _xifexpression_1 = (_expresionOperand + " = true");
      } else {
        Object _xifexpression_2 = null;
        boolean _isEnumConstTerm = this.isEnumConstTerm(term);
        if (_isEnumConstTerm) {
          String _xblockexpression_1 = null;
          {
            final ConstTerm constTerm = ((ConstTerm) term);
            String _expresionOperand_1 = this.getExpresionOperand(term);
            String _plus = (_expresionOperand_1 + " = ");
            TypedValue _value = constTerm.getValue();
            String _generateEnumConstTerm = this.generateEnumConstTerm(((EnumValue) _value));
            _xblockexpression_1 = (_plus + _generateEnumConstTerm);
          }
          _xifexpression_2 = _xblockexpression_1;
        } else {
          Object _xifexpression_3 = null;
          if ((term instanceof NotBooleanTerm)) {
            _xifexpression_3 = this.generateNotExpressionClauseRec(((NotBooleanTerm)term).getTerm());
          } else {
            _xifexpression_3 = this.getExpresionOperand(term);
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public Object generateNotExpressionClauseRec(final Term term) {
    Object _xifexpression = null;
    if ((term instanceof BinaryTermOp)) {
      Object _xblockexpression = null;
      {
        final String symbol = this.getSymbol(((BinaryTermOp)term));
        final String opossiteSymbol = this.getOpossiteSymbol(symbol);
        _xblockexpression = this.generateBinaryTermExpression(((BinaryTermOp)term), opossiteSymbol, true);
      }
      _xifexpression = _xblockexpression;
    } else {
      Object _xifexpression_1 = null;
      boolean _isBooleanVarTerm = this.isBooleanVarTerm(term);
      if (_isBooleanVarTerm) {
        String _expresionOperand = this.getExpresionOperand(term);
        _xifexpression_1 = (_expresionOperand + " = false");
      } else {
        Object _xifexpression_2 = null;
        boolean _isEnumConstTerm = this.isEnumConstTerm(term);
        if (_isEnumConstTerm) {
          String _xblockexpression_1 = null;
          {
            final ConstTerm constTerm = ((ConstTerm) term);
            String _expresionOperand_1 = this.getExpresionOperand(term);
            String _plus = (_expresionOperand_1 + " != ");
            TypedValue _value = constTerm.getValue();
            String _generateEnumConstTerm = this.generateEnumConstTerm(((EnumValue) _value));
            _xblockexpression_1 = (_plus + _generateEnumConstTerm);
          }
          _xifexpression_2 = _xblockexpression_1;
        } else {
          Object _xifexpression_3 = null;
          if ((term instanceof NotBooleanTerm)) {
            _xifexpression_3 = this.generateExpressionClauseRec(((NotBooleanTerm)term).getTerm());
          } else {
            _xifexpression_3 = this.getExpresionOperand(term);
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public Object generateExpressionClause(final Term term) {
    Object _xblockexpression = null;
    {
      RoqmeCepGenerator.letter = 'a';
      this.varTermAs.clear();
      _xblockexpression = this.generateExpressionClauseRec(term);
    }
    return _xblockexpression;
  }
  
  public CharSequence generateBinaryTermExpression(final BinaryTermOp term, final String symbol, final boolean isFromNot) {
    CharSequence _xblockexpression = null;
    {
      final Term left = term.getLeft();
      final Term right = term.getRight();
      CharSequence _xifexpression = null;
      if ((this.isEnumConstTerm(right) && this.isContextNode(left))) {
        StringConcatenation _builder = new StringConcatenation();
        String _expresionOperand = this.getExpresionOperand(left);
        _builder.append(_expresionOperand);
        _builder.append(" ");
        _builder.append(symbol);
        _builder.append(" ");
        String _generateEnumConstTerm = this.generateEnumConstTerm(((ConstTerm) right));
        _builder.append(_generateEnumConstTerm);
        _xifexpression = _builder;
      } else {
        CharSequence _xifexpression_1 = null;
        if ((this.isBooleanConstTerm(right) && this.isContextNode(left))) {
          StringConcatenation _builder_1 = new StringConcatenation();
          String _expresionOperand_1 = this.getExpresionOperand(left);
          _builder_1.append(_expresionOperand_1);
          _builder_1.append(" ");
          _builder_1.append(symbol);
          _builder_1.append(" ");
          Object _generateConstTerm = this.generateConstTerm(((ConstTerm) right));
          _builder_1.append(_generateConstTerm);
          _xifexpression_1 = _builder_1;
        } else {
          CharSequence _xifexpression_2 = null;
          if (isFromNot) {
            StringConcatenation _builder_2 = new StringConcatenation();
            Object _generateNotExpressionClauseRec = this.generateNotExpressionClauseRec(left);
            _builder_2.append(_generateNotExpressionClauseRec);
            _builder_2.append(" ");
            _builder_2.append(symbol);
            _builder_2.append(" ");
            Object _generateNotExpressionClauseRec_1 = this.generateNotExpressionClauseRec(right);
            _builder_2.append(_generateNotExpressionClauseRec_1);
            _xifexpression_2 = _builder_2;
          } else {
            StringConcatenation _builder_3 = new StringConcatenation();
            Object _generateExpressionClauseRec = this.generateExpressionClauseRec(left);
            _builder_3.append(_generateExpressionClauseRec);
            _builder_3.append(" ");
            _builder_3.append(symbol);
            _builder_3.append(" ");
            Object _generateExpressionClauseRec_1 = this.generateExpressionClauseRec(right);
            _builder_3.append(_generateExpressionClauseRec_1);
            _xifexpression_2 = _builder_3;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public boolean isBooleanConstTerm(final Term term) {
    boolean res = false;
    if ((term instanceof ConstTerm)) {
      final TypedValue valueTerm = ((ConstTerm)term).getValue();
      res = (valueTerm instanceof BooleanValue);
    }
    return res;
  }
  
  public String getExpresionOperand(final Term term) {
    String _xblockexpression = null;
    {
      String pattName = this.auxPatternsNames.get(term);
      String result = "";
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(pattName);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        String _varTermLetter = this.getVarTermLetter(pattName);
        String _plus = (_varTermLetter + ".val");
        result = _plus;
      } else {
        if ((term instanceof VarTerm)) {
          if (((((VarTerm)term).getVariable() instanceof Parameter) || (((VarTerm)term).getVariable() instanceof GeneralPurposeVariable))) {
            result = this.generateVarTerm(((VarTerm)term));
          } else {
            String _varTermLetter_1 = this.getVarTermLetter(this.generateVarTerm(((VarTerm)term)));
            String _plus_1 = (_varTermLetter_1 + ".val");
            result = _plus_1;
          }
        } else {
          if ((term instanceof ConstTerm)) {
            TypedValue _value = ((ConstTerm)term).getValue();
            if ((_value instanceof EnumValue)) {
              TypedValue _value_1 = ((ConstTerm)term).getValue();
              final EnumValue enumVal = ((EnumValue) _value_1);
              EnumType _enumType = enumVal.getValue().getEnumType();
              final DataType enumType = ((DataType) _enumType);
              EObject _eContainer = enumType.eContainer();
              final DataTypeDeclaration contDec = ((DataTypeDeclaration) _eContainer);
              EObject _eContainer_1 = contDec.eContainer();
              final TypedVariable typedVar = ((TypedVariable) _eContainer_1);
              final String varTermName = typedVar.getName();
              result = this.varTermAs.get(varTermName);
              boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(result);
              if (_isNullOrEmpty_1) {
                result = this.getVarTermLetter(varTermName);
              }
              result = (result + ".val");
            } else {
              result = this.generateConstTerm(((ConstTerm)term)).toString();
            }
          }
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public String getVarTermLetter(final String varTermName) {
    String varTermLetter = this.varTermAs.get(varTermName);
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(varTermLetter);
    if (_isNullOrEmpty) {
      char _plusPlus = RoqmeCepGenerator.letter++;
      varTermLetter = String.valueOf(_plusPlus);
      this.varTermAs.put(varTermName, varTermLetter);
    }
    return varTermLetter;
  }
  
  public CharSequence generateBinaryLogicalOP(final BinaryLogicalOp term) {
    CharSequence _xblockexpression = null;
    {
      String symbol = this.getSymbol(term);
      StringConcatenation _builder = new StringConcatenation();
      String _generateTerm = this.generateTerm(term.getLeft());
      _builder.append(_generateTerm);
      _builder.append(" ");
      _builder.append(symbol);
      _builder.append(" ");
      String _generateTerm_1 = this.generateTerm(term.getRight());
      _builder.append(_generateTerm_1);
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public Object generateConstTerm(final ConstTerm term) {
    Object _xblockexpression = null;
    {
      final TypedValue valueTerm = term.getValue();
      Object _xifexpression = null;
      if ((valueTerm instanceof EnumValue)) {
        _xifexpression = this.generateEnumConstTerm(term);
      } else {
        Object _xifexpression_1 = null;
        if ((valueTerm instanceof BooleanValue)) {
          _xifexpression_1 = Boolean.valueOf(((BooleanValue)valueTerm).isValue());
        } else {
          Object _xifexpression_2 = null;
          if ((valueTerm instanceof NumericValue)) {
            Object _xifexpression_3 = null;
            if ((valueTerm instanceof UnitMeasuredValue)) {
              String _xblockexpression_1 = null;
              {
                final double doubleVal = Double.parseDouble(Double.valueOf(((UnitMeasuredValue)valueTerm).getValue()).toString());
                final int intVal = Double.valueOf(doubleVal).intValue();
                _xblockexpression_1 = String.valueOf(intVal);
              }
              _xifexpression_3 = _xblockexpression_1;
            } else {
              _xifexpression_3 = Double.valueOf(((NumericValue)valueTerm).getValue());
            }
            _xifexpression_2 = ((Object)_xifexpression_3);
          }
          _xifexpression_1 = ((Object)_xifexpression_2);
        }
        _xifexpression = ((Object)_xifexpression_1);
      }
      _xblockexpression = ((Object)_xifexpression);
    }
    return _xblockexpression;
  }
  
  public String generateEnumConstTerm(final ConstTerm constTerm) {
    String _xblockexpression = null;
    {
      TypedValue _value = constTerm.getValue();
      final EnumValue enumVal = ((EnumValue) _value);
      EnumType _enumType = enumVal.getValue().getEnumType();
      final DataType enumType = ((DataType) _enumType);
      EObject contDec = enumType.eContainer();
      String name = "";
      if ((contDec instanceof DataTypeDeclaration)) {
        EObject _eContainer = ((DataTypeDeclaration)contDec).eContainer();
        final TypedVariable typedVar = ((TypedVariable) _eContainer);
        name = typedVar.getName();
      } else {
        if ((contDec instanceof DataTypeDefinition)) {
          name = ((DataTypeDefinition)contDec).getName();
        }
      }
      String _name = enumVal.getValue().getName();
      _xblockexpression = ((name + ".") + _name);
    }
    return _xblockexpression;
  }
  
  public String generateEnumConstTerm(final EnumValue enumVal) {
    String _xblockexpression = null;
    {
      EnumType _enumType = enumVal.getValue().getEnumType();
      final DataType enumType = ((DataType) _enumType);
      EObject contDec = enumType.eContainer();
      String name = "";
      if ((contDec instanceof DataTypeDeclaration)) {
        EObject _eContainer = ((DataTypeDeclaration)contDec).eContainer();
        final TypedVariable typedVar = ((TypedVariable) _eContainer);
        name = typedVar.getName();
      } else {
        if ((contDec instanceof DataTypeDefinition)) {
          name = ((DataTypeDefinition)contDec).getName();
        }
      }
      String _name = enumVal.getValue().getName();
      _xblockexpression = ((name + ".") + _name);
    }
    return _xblockexpression;
  }
  
  public String generateEnumFilter(final ConstTerm term, final String symbol) {
    String _xblockexpression = null;
    {
      final TypedValue valueTerm = term.getValue();
      String _xifexpression = null;
      if ((valueTerm instanceof EnumValue)) {
        String _xblockexpression_1 = null;
        {
          final Object value = this.generateConstTerm(term);
          EnumType _enumType = ((EnumValue)valueTerm).getValue().getEnumType();
          final DataType enumType = ((DataType) _enumType);
          EObject _eContainer = enumType.eContainer();
          final DataTypeDeclaration contDec = ((DataTypeDeclaration) _eContainer);
          EObject _eContainer_1 = contDec.eContainer();
          final TypedVariable typedVar = ((TypedVariable) _eContainer_1);
          String _name = typedVar.getName();
          String _plus = (_name + "(val");
          String _plus_1 = (_plus + symbol);
          String _plus_2 = (_plus_1 + value);
          _xblockexpression_1 = (_plus_2 + ")");
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public Object generateNaryTermOp(final NaryTermOp term) {
    Object _xifexpression = null;
    if ((term instanceof FunctionTerm)) {
      _xifexpression = this.generateFuncionTerm(((FunctionTerm) term));
    } else {
      String _xifexpression_1 = null;
      if ((term instanceof ConditionalTerm)) {
        _xifexpression_1 = this.generateConditionalTerm(((ConditionalTerm)term));
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public String generateConditionalTerm(final ConditionalTerm term) {
    return this.auxPatternsNames.get(term);
  }
  
  public Object generateFuncionTerm(final FunctionTerm term) {
    Object _xifexpression = null;
    if ((term instanceof ScheduleFunction)) {
      _xifexpression = this.generateScheduleFunctionTerm(((ScheduleFunction)term));
    } else {
      Object _xifexpression_1 = null;
      if ((term instanceof PatternFunction)) {
        _xifexpression_1 = this.generatePatternFunctionTerm(((PatternFunction)term));
      } else {
        Object _xifexpression_2 = null;
        if ((term instanceof ArithFunction)) {
          _xifexpression_2 = this.generateArithFunctionTerm(((ArithFunction)term));
        } else {
          Object _xifexpression_3 = null;
          if ((term instanceof AggregationFunction)) {
            _xifexpression_3 = this.generateAggregationFunctionTerm(((AggregationFunction)term));
          } else {
            Object _xifexpression_4 = null;
            if ((term instanceof CollectionFunction)) {
              _xifexpression_4 = this.generateCollectionFunctionTerm(((CollectionFunction)term));
            }
            _xifexpression_3 = _xifexpression_4;
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public Object generateCollectionFunctionTerm(final CollectionFunction function) {
    return null;
  }
  
  public String generateAggregationFunctionTerm(final AggregationFunction term) {
    return this.auxPatternsNames.get(term);
  }
  
  public String generateArithFunctionTerm(final ArithFunction term) {
    return this.auxPatternsNames.get(term);
  }
  
  public CharSequence generateOnceTerm(final OnceTerm once) {
    CharSequence _xblockexpression = null;
    {
      this.once = true;
      StringConcatenation _builder = new StringConcatenation();
      String _generateTerm = this.generateTerm(once.getTerm());
      _builder.append(_generateTerm);
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public String generateRangeTerm(final RangeTerm term) {
    return this.auxPatternsNames.get(term);
  }
  
  public CharSequence generateNotEventTerm(final NotEventTerm not) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(" ");
    _builder.append("not (");
    String _generateTerm = this.generateTerm(not.getTerm());
    _builder.append(_generateTerm, " ");
    _builder.append(")");
    return _builder;
  }
  
  public CharSequence generateRepeatTerm(final RepeatTerm term) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[");
    int _nrep = term.getNrep();
    _builder.append(_nrep);
    _builder.append("] (");
    String _generateTerm = this.generateTerm(term.getTerm());
    _builder.append(_generateTerm);
    _builder.append(")");
    return _builder;
  }
  
  public CharSequence generateUnaryLogicalOp(final UnaryLogicalOp not) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generateNotTerm = this.generateNotTerm(not.getTerm());
    _builder.append(_generateNotTerm);
    return _builder;
  }
  
  public CharSequence generateNotTerm(final Term term) {
    CharSequence _xifexpression = null;
    if ((term instanceof BinaryTermOp)) {
      CharSequence _xifexpression_1 = null;
      if ((term instanceof BinaryLogicalOp)) {
        _xifexpression_1 = this.generateNotBinaryLogicalOP(((BinaryLogicalOp) term));
      } else {
        CharSequence _xifexpression_2 = null;
        if ((term instanceof BinaryPatternOp)) {
          _xifexpression_2 = this.generateNotBinaryPatternOp(((BinaryPatternOp) term));
        } else {
          CharSequence _xifexpression_3 = null;
          if ((term instanceof BinaryRelationalOp)) {
            _xifexpression_3 = this.generateNotBinaryRelationalOp(((BinaryRelationalOp) term));
          } else {
            String _xifexpression_4 = null;
            if ((term instanceof BinaryArithOp)) {
              _xifexpression_4 = this.generateTerm(term);
            }
            _xifexpression_3 = _xifexpression_4;
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    } else {
      String _xifexpression_5 = null;
      if (((term instanceof NotEventTerm) || (term instanceof NotBooleanTerm))) {
        String _xblockexpression = null;
        {
          final UnaryTermOp unaryTerm = ((UnaryTermOp) term);
          String _xifexpression_6 = null;
          boolean _isBooleanVarTerm = this.isBooleanVarTerm(unaryTerm.getTerm());
          if (_isBooleanVarTerm) {
            _xifexpression_6 = this.generateVarBooleanTerm(unaryTerm.getTerm(), "true", "=");
          } else {
            String _xifexpression_7 = null;
            boolean _isEnumConstTerm = this.isEnumConstTerm(unaryTerm.getTerm());
            if (_isEnumConstTerm) {
              Term _term = unaryTerm.getTerm();
              _xifexpression_7 = this.generateEnumFilter(((ConstTerm) _term), "=");
            } else {
              _xifexpression_7 = this.generateTerm(unaryTerm.getTerm());
            }
            _xifexpression_6 = _xifexpression_7;
          }
          _xblockexpression = _xifexpression_6;
        }
        _xifexpression_5 = _xblockexpression;
      } else {
        String _xifexpression_6 = null;
        boolean _isEnumConstTerm = this.isEnumConstTerm(term);
        if (_isEnumConstTerm) {
          _xifexpression_6 = this.generateEnumFilter(((ConstTerm) term), "!=");
        } else {
          String _xifexpression_7 = null;
          boolean _isBooleanVarTerm = this.isBooleanVarTerm(term);
          if (_isBooleanVarTerm) {
            _xifexpression_7 = this.generateVarBooleanTerm(term, "false", "=");
          } else {
            _xifexpression_7 = this.generateTerm(term);
          }
          _xifexpression_6 = _xifexpression_7;
        }
        _xifexpression_5 = _xifexpression_6;
      }
      _xifexpression = _xifexpression_5;
    }
    return _xifexpression;
  }
  
  public boolean isBooleanVarTerm(final Term term) {
    boolean res = false;
    if ((term instanceof VarTerm)) {
      DataTypeDeclaration _declaration = ((VarTerm)term).getVariable().getDeclaration();
      if ((_declaration instanceof ContainedDeclaration)) {
        DataTypeDeclaration _declaration_1 = ((VarTerm)term).getVariable().getDeclaration();
        final ContainedDeclaration contDec = ((ContainedDeclaration) _declaration_1);
        DataType _type = contDec.getType();
        res = (_type instanceof BooleanType);
      }
    } else {
      if ((this.isCustomAggregationFunction(term) || (term instanceof ConditionalTerm))) {
        res = true;
      }
    }
    return res;
  }
  
  public boolean isEnumConstTerm(final Term term) {
    boolean res = false;
    if ((term instanceof ConstTerm)) {
      final TypedValue valueTerm = ((ConstTerm)term).getValue();
      res = (valueTerm instanceof EnumValue);
    }
    return res;
  }
  
  public CharSequence generateNotBinaryRelationalOp(final BinaryRelationalOp term) {
    CharSequence _xblockexpression = null;
    {
      String valStr = "(val";
      String symbol = this.getOpossiteSymbol(this.getSymbol(term));
      final Term right = term.getRight();
      final Term left = term.getLeft();
      CharSequence _xifexpression = null;
      if ((this.isBooleanVarTerm(left) && (right instanceof ConstTerm))) {
        CharSequence _xblockexpression_1 = null;
        {
          final Object boolVal = this.generateConstTerm(((ConstTerm) right));
          StringConcatenation _builder = new StringConcatenation();
          String _generateVarBooleanTerm = this.generateVarBooleanTerm(left, boolVal.toString(), symbol);
          _builder.append(_generateVarBooleanTerm);
          _xblockexpression_1 = _builder;
        }
        _xifexpression = _xblockexpression_1;
      } else {
        CharSequence _xifexpression_1 = null;
        if ((this.isBooleanVarTerm(right) && (left instanceof ConstTerm))) {
          CharSequence _xblockexpression_2 = null;
          {
            final Object boolVal = this.generateConstTerm(((ConstTerm) left));
            final String finalSymbol = this.getReverseSymbol(symbol);
            StringConcatenation _builder = new StringConcatenation();
            String _generateVarBooleanTerm = this.generateVarBooleanTerm(right, boolVal.toString(), finalSymbol);
            _builder.append(_generateVarBooleanTerm);
            _xblockexpression_2 = _builder;
          }
          _xifexpression_1 = _xblockexpression_2;
        } else {
          CharSequence _xifexpression_2 = null;
          if ((this.isContextNode(left) && this.isContextNode(right))) {
            CharSequence _xblockexpression_3 = null;
            {
              final char aLetter = RoqmeCepGenerator.letter++;
              final char bLetter = RoqmeCepGenerator.letter++;
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("(");
              _builder.append(aLetter);
              _builder.append("=");
              Object _generateNotTerm = this.generateNotTerm(left);
              _builder.append(_generateNotTerm);
              _builder.append(" AND ");
              _builder.append(bLetter);
              _builder.append("=");
              Object _generateNotTerm_1 = this.generateNotTerm(right);
              _builder.append(_generateNotTerm_1);
              _builder.append(") while(");
              _builder.append(aLetter);
              _builder.append(".val ");
              _builder.append(symbol);
              _builder.append(" ");
              _builder.append(bLetter);
              _builder.append(".val)");
              _xblockexpression_3 = _builder;
            }
            _xifexpression_2 = _xblockexpression_3;
          } else {
            CharSequence _xifexpression_3 = null;
            boolean _isContextNode = this.isContextNode(right);
            if (_isContextNode) {
              CharSequence _xblockexpression_4 = null;
              {
                String finalSymbol = this.getReverseSymbol(symbol);
                String lefttStr = "";
                boolean _isEnumConstTerm = this.isEnumConstTerm(left);
                if (_isEnumConstTerm) {
                  Object _generateConstTerm = this.generateConstTerm(((ConstTerm) left));
                  String _string = null;
                  if (_generateConstTerm!=null) {
                    _string=_generateConstTerm.toString();
                  }
                  lefttStr = _string;
                } else {
                  Object _generateNotTerm = this.generateNotTerm(left);
                  String _string_1 = null;
                  if (_generateNotTerm!=null) {
                    _string_1=_generateNotTerm.toString();
                  }
                  lefttStr = _string_1;
                }
                StringConcatenation _builder = new StringConcatenation();
                Object _generateNotTerm_1 = this.generateNotTerm(right);
                _builder.append(_generateNotTerm_1);
                _builder.append(valStr);
                _builder.append(" ");
                _builder.append(finalSymbol);
                _builder.append(" ");
                _builder.append(lefttStr);
                _builder.append(")");
                _xblockexpression_4 = _builder;
              }
              _xifexpression_3 = _xblockexpression_4;
            } else {
              CharSequence _xifexpression_4 = null;
              boolean _isContextNode_1 = this.isContextNode(left);
              if (_isContextNode_1) {
                CharSequence _xblockexpression_5 = null;
                {
                  String rightStr = "";
                  boolean _isEnumConstTerm = this.isEnumConstTerm(right);
                  if (_isEnumConstTerm) {
                    Object _generateConstTerm = this.generateConstTerm(((ConstTerm) right));
                    String _string = null;
                    if (_generateConstTerm!=null) {
                      _string=_generateConstTerm.toString();
                    }
                    rightStr = _string;
                  } else {
                    Object _generateNotTerm = this.generateNotTerm(right);
                    String _string_1 = null;
                    if (_generateNotTerm!=null) {
                      _string_1=_generateNotTerm.toString();
                    }
                    rightStr = _string_1;
                  }
                  StringConcatenation _builder = new StringConcatenation();
                  Object _generateNotTerm_1 = this.generateNotTerm(left);
                  _builder.append(_generateNotTerm_1);
                  _builder.append(valStr);
                  _builder.append(" ");
                  _builder.append(symbol);
                  _builder.append(" ");
                  _builder.append(rightStr);
                  _builder.append(")");
                  _xblockexpression_5 = _builder;
                }
                _xifexpression_4 = _xblockexpression_5;
              }
              _xifexpression_3 = _xifexpression_4;
            }
            _xifexpression_2 = _xifexpression_3;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public boolean isContextNode(final Term term) {
    boolean res = false;
    if ((term instanceof VarTerm)) {
      boolean _not = (!((((VarTerm)term).getVariable() instanceof Parameter) || (((VarTerm)term).getVariable() instanceof GeneralPurposeVariable)));
      if (_not) {
        res = true;
      }
    } else {
      if (((term instanceof BinaryArithOp) || (term instanceof NaryTermOp))) {
        res = true;
      }
    }
    return res;
  }
  
  public CharSequence generateNotBinaryLogicalOP(final BinaryLogicalOp term) {
    CharSequence _xblockexpression = null;
    {
      String symbol = this.getSymbol(term);
      String opossiteSymbol = this.getOpossiteSymbol(symbol);
      final Term left = term.getLeft();
      final Term right = term.getRight();
      String leftStr = "";
      String rightStr = "";
      boolean _isContextNode = this.isContextNode(left);
      if (_isContextNode) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("not ( ");
        String _generateTerm = this.generateTerm(left);
        _builder.append(_generateTerm);
        _builder.append(" )");
        leftStr = _builder.toString();
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        Object _generateNotTerm = this.generateNotTerm(left);
        _builder_1.append(_generateNotTerm);
        leftStr = _builder_1.toString();
      }
      boolean _isContextNode_1 = this.isContextNode(right);
      if (_isContextNode_1) {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("not ( ");
        String _generateTerm_1 = this.generateTerm(right);
        _builder_2.append(_generateTerm_1);
        _builder_2.append(" )");
        rightStr = _builder_2.toString();
      } else {
        StringConcatenation _builder_3 = new StringConcatenation();
        Object _generateNotTerm_1 = this.generateNotTerm(right);
        _builder_3.append(_generateNotTerm_1);
        rightStr = _builder_3.toString();
      }
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append(leftStr);
      _builder_4.append(" ");
      _builder_4.append(opossiteSymbol);
      _builder_4.append(" ");
      _builder_4.append(rightStr);
      _xblockexpression = _builder_4;
    }
    return _xblockexpression;
  }
  
  public CharSequence generateNotBinaryPatternOp(final BinaryPatternOp term) {
    CharSequence _xblockexpression = null;
    {
      String symbol = this.getSymbol(term);
      String opossiteSymbol = this.getOpossiteSymbol(symbol);
      final Term left = term.getLeft();
      final Term right = term.getRight();
      String leftStr = "";
      String rightStr = "";
      if (((this.isContextNode(left) && (!this.isBooleanVarTerm(left))) && (!this.isEnumConstTerm(left)))) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("not ");
        String _generateTerm = this.generateTerm(left);
        _builder.append(_generateTerm);
        leftStr = _builder.toString();
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        Object _generateNotTerm = this.generateNotTerm(left);
        _builder_1.append(_generateNotTerm);
        leftStr = _builder_1.toString();
      }
      if (((this.isContextNode(right) && (!this.isBooleanVarTerm(right))) && (!this.isEnumConstTerm(right)))) {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("not ");
        String _generateTerm_1 = this.generateTerm(right);
        _builder_2.append(_generateTerm_1);
        rightStr = _builder_2.toString();
      } else {
        StringConcatenation _builder_3 = new StringConcatenation();
        Object _generateNotTerm_1 = this.generateNotTerm(right);
        _builder_3.append(_generateNotTerm_1);
        rightStr = _builder_3.toString();
      }
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append(leftStr);
      _builder_4.append(" ");
      _builder_4.append(opossiteSymbol);
      _builder_4.append(" ");
      _builder_4.append(rightStr);
      _xblockexpression = _builder_4;
    }
    return _xblockexpression;
  }
  
  public CharSequence generateSelfTerm(final SelfTerm term) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  public String generateVarTerm(final VarTerm term) {
    String _xifexpression = null;
    TypedVariable _variable = term.getVariable();
    if ((_variable instanceof Timer)) {
      String _xblockexpression = null;
      {
        TypedVariable _variable_1 = term.getVariable();
        final Timer timer = ((Timer) _variable_1);
        _xblockexpression = this.auxPatternsNames.get(timer.getDefinition().getTerm());
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = term.getVariable().getName();
    }
    return _xifexpression;
  }
  
  public String generateVarBooleanTerm(final Term term, final String value, final String symbol) {
    String _xblockexpression = null;
    {
      final String filter = ((("(val" + symbol) + value) + ")");
      String _xifexpression = null;
      if ((term instanceof VarTerm)) {
        String _name = ((VarTerm)term).getVariable().getName();
        _xifexpression = (_name + filter);
      } else {
        String _xifexpression_1 = null;
        if ((this.isCustomAggregationFunction(term) || (term instanceof ConditionalTerm))) {
          String _generateTerm = this.generateTerm(term);
          _xifexpression_1 = (_generateTerm + filter);
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String generatePatternFunctionTerm(final PatternFunction term) {
    return this.auxPatternsNames.get(term);
  }
  
  public CharSequence generateJavaEnums(final EnumType enumVar, final String contextName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(RoqmeCepGenerator.ENUM_PACKAGE_NAME);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("public enum ");
    _builder.append(contextName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      EList<EnumLiteral> _literals = enumVar.getLiterals();
      boolean _hasElements = false;
      for(final EnumLiteral lit : _literals) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "\t");
        }
        String _name = lit.getName();
        _builder.append(_name, "\t");
      }
      if (_hasElements) {
        _builder.append(";", "\t");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public String getSymbol(final BinaryTermOp term) {
    String symbol = "";
    if ((term instanceof LessThanTerm)) {
      symbol = "<";
    } else {
      if ((term instanceof NotEqualTerm)) {
        symbol = "!=";
      } else {
        if ((term instanceof EqualTerm)) {
          symbol = "=";
        } else {
          if ((term instanceof GreaterEqualTerm)) {
            symbol = ">=";
          } else {
            if ((term instanceof LessEqualTerm)) {
              symbol = "<=";
            } else {
              if ((term instanceof GreaterThanTerm)) {
                symbol = ">";
              } else {
                if ((term instanceof AndBooleanTerm)) {
                  symbol = "AND";
                } else {
                  if ((term instanceof OrBooleanTerm)) {
                    symbol = "OR";
                  }
                }
              }
            }
          }
        }
      }
    }
    if ((term instanceof FollowedByTerm)) {
      symbol = "->";
    } else {
      if ((term instanceof WhileTerm)) {
        symbol = "while";
      } else {
        if ((term instanceof AndEventTerm)) {
          symbol = "AND";
        } else {
          if ((term instanceof OrEventTerm)) {
            symbol = "OR";
          } else {
            if ((term instanceof AddTerm)) {
              symbol = "+";
            } else {
              if ((term instanceof SubTerm)) {
                symbol = "-";
              } else {
                if ((term instanceof MultTerm)) {
                  symbol = "*";
                } else {
                  if ((term instanceof DivTerm)) {
                    symbol = "/";
                  }
                }
              }
            }
          }
        }
      }
    }
    return symbol;
  }
  
  public String getEveryO() {
    String _xifexpression = null;
    if (this.once) {
      StringConcatenation _builder = new StringConcatenation();
      _xifexpression = _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("every ( ");
      _xifexpression = _builder_1.toString();
    }
    return _xifexpression;
  }
  
  public String getEveryC() {
    String _xifexpression = null;
    if (this.once) {
      String _xblockexpression = null;
      {
        this.once = false;
        StringConcatenation _builder = new StringConcatenation();
        _xblockexpression = _builder.toString();
      }
      _xifexpression = _xblockexpression;
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(" ");
      _builder.append(")");
      _xifexpression = _builder.toString();
    }
    return _xifexpression;
  }
}
