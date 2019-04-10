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

package roqme.generator.viewer

import java.util.LinkedList
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import roqme.metamodel.datatypes.BooleanType
import roqme.metamodel.datatypes.ContainedDeclaration
import roqme.metamodel.datatypes.EnumType
import roqme.metamodel.datatypes.EnumValue
import roqme.metamodel.datatypes.EventType
import roqme.metamodel.datatypes.InbuiltDeclaration
import roqme.metamodel.datatypes.RoqmeModel
import roqme.metamodel.datatypes.TypedVariable
import roqme.metamodel.expressions.BinaryTermOp
import roqme.metamodel.expressions.ConstTerm
import roqme.metamodel.expressions.NaryTermOp
import roqme.metamodel.expressions.Term
import roqme.metamodel.expressions.UnaryTermOp
import roqme.metamodel.expressions.VarTerm
import roqme.metamodel.kernel.Observation
import roqme.metamodel.kernel.Parameter
import roqme.metamodel.kernel.SetEvidence

import static extension com.google.common.io.CharStreams.*
import roqme.metamodel.kernel.Timer
import roqme.metamodel.datatypes.ReferencedDeclaration
import roqme.metamodel.datatypes.DataType
import roqme.metamodel.datatypes.DataTypeDeclaration
import java.net.URL
import java.io.InputStreamReader

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class GrafanaGenerator extends AbstractGenerator{
	String pathColors;
	private DataType type;
	new (String pathColors){
		this.pathColors=pathColors
	}

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		
		if(resource.getURI().fileExtension().equalsIgnoreCase("roqme")) {
			for (e : resource.allContents.toIterable.filter(RoqmeModel)) {
	
				var colorsClass= new Colors(pathColors)
				var lColors=colorsClass.getColors()
	
				fsa.generateFile(
					'GrafanaDashboard.json', 
					'DEFAULT_OUTPUT', 
					generateDashboard(e,lColors)
				);
				fsa.generateFile(
					'docker-compose.yml', 
					'DEFAULT_OUTPUT', 
					generateDockerCompose()
				);
			}
		}
	}
	def generateDockerCompose()'''
	influxdb:
	  image: influxdb:1.6.1
	  container_name: influxdb
	  ports:
	    - "8083:8083"
	    - "8086:8086"
	    - "8090:8090"
	  volumes:
	    # Data persistency
	    - ./var-lib-influxdb:/var/lib/influxdb
	grafana:
	  image: grafana/grafana:5.0.0
	  container_name: grafana
	  ports:
	    - "3000:3000"
	  links:
	    - influxdb
	  volumes:
	    # Data persistency
	    # sudo mkdir -p ./var-lib-grafana; chown smartsoft:smartsoft ./var-lib-grafana
	    - ./var-lib-grafana:/var/lib/grafana
	
	'''

	def generateDashboard(RoqmeModel roqmeModel,List<Color> lColors) '''
		{
		  "__inputs": [
		    {
		      "name": "«roqmeModel.namespace»",
		      "label": "«roqmeModel.namespace»",
		      "description": "",
		      "type": "datasource",
		      "pluginId": "influxdb",
		      "pluginName": "InfluxDB"
		    }
		  ],
		  "__requires": [
		    {
		      "type": "grafana",
		      "id": "grafana",
		      "name": "Grafana",
		      "version": "5.3.2"
		    },
		    {
		      "type": "panel",
		      "id": "graph",
		      "name": "Graph",
		      "version": "5.0.0"
		    },
		    {
		      "type": "datasource",
		      "id": "influxdb",
		      "name": "InfluxDB",
		      "version": "5.0.0"
		    }
		  ],
		  "annotations": {
		    "list": [
		      {
		        "builtIn": 1,
		        "datasource": "-- Grafana --",
		        "enable": true,
		        "hide": true,
		        "iconColor": "rgba(0, 211, 255, 1)",
		        "name": "Annotations & Alerts",
		        "type": "dashboard"
		      }
		    ]
		  },
		  "editable": true,
		  "gnetId": null,
		  "graphTooltip": 0,
		  "id": null,
		  "links": [],
		  "panels": [
		    «var list=new LinkedList<TypedVariable>()»
		  «var normalList=new LinkedList<TypedVariable>()»
		  «var metricsList=new LinkedList<TypedVariable>()»
		    «FOR variable : roqmeModel.variables»
		    	«IF variable.declaration instanceof ContainedDeclaration»
		    		«var conDec=variable.declaration as ContainedDeclaration»
		    		«IF (conDec.type instanceof EventType || conDec.type instanceof EnumType || conDec.type instanceof BooleanType) && !(variable instanceof Parameter) && !(variable instanceof Timer)»
		    			«list.addLast(variable)»
		    		«ENDIF»
		    		«IF !(conDec.type instanceof EventType || conDec.type instanceof EnumType || conDec.type instanceof BooleanType) && !(variable instanceof Parameter) && !(variable instanceof Timer)»
		    			«normalList.addLast(variable)»
		    		«ENDIF»
		    	«ENDIF»
		    	«IF variable.declaration instanceof InbuiltDeclaration && !(variable instanceof Parameter) && !(variable instanceof Timer)»
		    		«metricsList.addLast(variable)»
		    	«ENDIF»
		    	«IF variable.declaration instanceof ReferencedDeclaration»
		    		«var cRef=variable.declaration as ReferencedDeclaration»
		    		«var type=cRef.type.dataType»
		    		«IF (type instanceof EventType || type instanceof EnumType || type instanceof BooleanType)»
		    			«list.addLast(variable)»
		    		«ENDIF»
		    		« IF!(type instanceof EventType || type instanceof EnumType || type instanceof BooleanType)»
		    			«normalList.addLast(variable)»
		    		«ENDIF»
		    	«ENDIF»
		    «ENDFOR»
		    «var x=new Integer(0)»
		    «var ln=new LinkedList<Integer>()»
		    «ln.add(0,x)»
		    «var y=new State(0)»
		    «var xax=new State(0)»
		    «var id=new State(0)»
		    «generatePanelsPoints(roqmeModel,list,xax,y,id,lColors)»
		    «generatePanels(roqmeModel,normalList,id,xax,y,lColors)»
		    «generatePanelsMetrics(roqmeModel,metricsList,id,xax,y,lColors)»
		  }
		  ],
		  "refresh": "1s",
		  "schemaVersion": 16,
		  "style": "dark",
		  "tags": [],
		  "templating": {
		    "list": []
		  },
		  "time": {
		    "from": "now-15m",
		    "to": "now"
		  },
		  "timepicker": {
		    "refresh_intervals": [
		      "1s",
		      "2s",
		      "5s",
		      "0s",
		      "30s",
		      "1m",
		      "5m",
		      "15m",
		      "30m",
		      "1h",
		      "2h",
		      "1d"
		    ],
		    "time_options": [
		      "5m",
		      "15m",
		      "1h",
		      "6h",
		      "12h",
		      "24h",
		      "2d",
		      "7d",
		      "30d"
		    ]
		  },
		  "timezone": "",
		  "title": "RoQME",
		  "uid": "hcRqpXTmk",
		  "version": 24
		}
	'''
def generatePanelsPoints(RoqmeModel roqmeModel,LinkedList<TypedVariable> types,State x,State y,State id,List<Color> lColors)'''
{«var lAlias=new LinkedList<String>()»
  "bars": false,
  "dashLength": 10,
  "dashes": false,
  "datasource": "${«roqmeModel.namespace»}",
  "fill": 0,
  "gridPos": {
    "h": 6,
    "w": 24,
    "x": 0,
    "y": «y.getState()»
    «y.incPositionY()»
  },
  "id": «id.getState()»,«id.incState()»
  "legend": {
    "avg": false,
    "current": false,
    "max": false,
    "min": false,
    "show": true,
    "total": false,
    "values": false
  },
  "lines": false,
  "linewidth": 2,
  "nullPointMode": "null",
  "percentage": false,
  "pointradius": 2,
  "points": true,
  "renderer": "flot",
  "seriesOverrides": [],
  "spaceLength": 10,
  "stack": false,
  "steppedLine": false,
  "targets": [
	«generateBoolEvenEnumVariable(roqmeModel,types,lAlias)»
  ],
  "aliasColors": {
  «FOR alias : lAlias SEPARATOR ','»
  	"«alias»" : "«IF lColors.size() % 2 ==0»«lColors.remove(0).code»"«ELSE»«lColors.remove(lColors.size-1).code»"«ENDIF»
  «ENDFOR»«lAlias.clear»
  },
  "thresholds": [],
  "timeFrom": null,
  "timeShift": null,
  "title": "Discrets Contexts",
  "tooltip": {
    "shared": true,
    "sort": 0,
    "value_type": "individual"
  },
  "type": "graph",
  "xaxis": {
    "buckets": null,
    "mode": "time",
    "name": null,
    "show": true,
    "values": []
  },
  "yaxes": [
    {
      "format": "short",
      "label": null,
      "logBase": 1,
      "max": null,
      "min": null,
      "show": true
    },
    {
      "format": "short",
      "label": null,
      "logBase": 1,
      "max": null,
      "min": null,
      "show": true
    }
  ],
  "yaxis": {
    "align": false,
    "alignLevel": null
  }
},
'''
	def generatePanels(RoqmeModel roqmeModel, LinkedList<TypedVariable> normals,State id,State x,State y,List<Color> lColors) '''
«var lAlias=new LinkedList<String>()»
«var lObs=new LinkedList<String>()»
«FOR variable : normals»
{
  "bars": false,
  "dashLength": 10,
  "dashes": false,
  "datasource": "${«roqmeModel.namespace»}",
  "fill": 0,
  "gridPos": {
    "h": 6,
    "w": 24,
    "x": 0,
    "y": «y.getState()»
    «y.incPositionY()»
  },
  "id": «id.getState()»«id.incState()»,
  "legend": {
    "avg": false,
    "current": false,
    "max": false,
    "min": false,
    "show": true,
    "total": false,
    "values": false
  },
  "lines": true,
  "linewidth": 2,
  "nullPointMode": "connected",
  "percentage": false,
  "pointradius": 5,
  "points": false,
  "renderer": "flot",
  "seriesOverrides": [],
  "spaceLength": 10,
  "stack": false,
  "steppedLine": false,
  "targets": [
	«generateNormalVariable(roqmeModel,variable,false,lAlias,lObs)»
  ],
  "aliasColors": {
  «FOR alias : lAlias SEPARATOR ','»
  	"«alias»" : "«IF lColors.size() % 2 ==0»«lColors.remove(0).code»"«ELSE»«lColors.remove(lColors.size-1).code»"«ENDIF»
  «ENDFOR»«lAlias.clear»
  },
  "seriesOverrides": [
  «FOR obs : lObs SEPARATOR ','»
  {
   "alias": "«obs»",
   "nullPointMode": "null"	  	
  }«ENDFOR»
  ],
  "thresholds": [],
  "timeFrom": null,
  "timeShift": null,
  "title": "«variable.name»",
  "tooltip": {
    "shared": true,
    "sort": 0,
    "value_type": "individual"
  },
  "type": "graph",
  "xaxis": {
    "buckets": null,
    "mode": "time",
    "name": null,
    "show": true,
    "values": []
  },
  "yaxes": [
    {
      "format": "short",
      "label": null,
      "logBase": 1,
      "max": null,
      "min": null,
      "show": true
    },
    {
      "format": "short",
      "label": null,
      "logBase": 1,
      "max": null,
      "min": null,
      "show": true
    }
  ],
  "yaxis": {
    "align": false,
    "alignLevel": null
  }
},
«ENDFOR» 
	'''
static class State {
    var int counter

    new(int counter){
        this.counter = counter
    }
    def void incState(){this.counter=counter+1}
    def void clearState(){this.counter=0}
    def void incPositionX(){this.counter+=12}
    def void incPositionY(){this.counter+=9}
    def int getState(){return counter}
}

static class Color {
  String name
  String code
	
	new(String name, String code) {
	this.name=name
  	this.code=code
	}
}


static class Colors {
  //val colors = new FileReader('colors.txt').readLines.map [ line |
  	
  	String uri
	List<Color> colors
    new(String uri1){
    	this.uri=uri1
    	var url = new URL(uri1)
    	var reader = new InputStreamReader(url.openConnection().getInputStream())
	  	colors = reader.readLines.map [ line |
	    
	    val segments = line.split(',').iterator
	    return new Color(
	      String.valueOf(segments.next), 
	      String.valueOf(segments.next)
	    )
	
	  ]    	
    	
    }
  
  def List<Color> getColors(){return colors}
}
	def generatePanelsMetrics(RoqmeModel roqmeModel, LinkedList<TypedVariable> normals,State id,State x,State y,List<Color> lColors) '''
«var lAlias=new LinkedList<String>()»«var lObs=new LinkedList<String>()»
«FOR variable : normals SEPARATOR '\n},'»
{
  "bars": false,
  "dashLength": 10,
  "dashes": false,
  "datasource": "${«roqmeModel.namespace»}",
  "fill": 0,
  "gridPos": {
    "h": 6,
    "w": 24,
    "x": 0,
    "y": «y.getState()»«y.incPositionY()»
  },
  "id": «id.getState()»«id.incState()»,
  "legend": {
    "avg": false,
    "current": false,
    "max": false,
    "min": false,
    "show": true,
    "total": false,
    "values": false
  },
  "lines": true,
  "linewidth": 2,
  "nullPointMode": "connected",
  "percentage": false,
  "pointradius": 5,
  "points": false,
  "renderer": "flot",
  "seriesOverrides": [],
  "spaceLength": 10,
  "stack": false,
  "steppedLine": false,
  "targets": [
	«generateNormalVariable(roqmeModel,variable,true,lAlias,lObs)»
  ],
  "aliasColors": {«FOR alias : lAlias SEPARATOR ','»
  "«alias»" : "«IF lColors.size() % 2 ==0»«lColors.remove(0).code»"«ELSE»«lColors.remove(lColors.size-1).code»"«ENDIF»
  «ENDFOR»«lAlias.clear»
  },
  "seriesOverrides": [
  «FOR obs : lObs SEPARATOR ','»
  {
   "alias": "«obs»",
   "nullPointMode": "null"	  	
  }«ENDFOR»
  ],      
  "thresholds": [],
  "timeFrom": null,
  "timeShift": null,
  "title": "«variable.name»",
  "tooltip": {
    "shared": true,
    "sort": 0,
    "value_type": "individual"
  },
  "type": "graph",
  "xaxis": {
    "buckets": null,
    "mode": "time",
    "name": null,
    "show": true,
    "values": []
  },
  "yaxes": [
    {
      "format": "short",
      "label": null,
      "logBase": 1,
      "max": null,
      "min": null,
      "show": true
    },
    {
      "format": "short",
      "label": null,
      "logBase": 1,
      "max": null,
      "min": null,
      "show": true
    }
  ],
  "yaxis": {
    "align": false,
    "alignLevel": null
  }
«ENDFOR» 
	'''
/*GENERAR NORMAL*/
def generateNormalMetric(RoqmeModel roqmeModel,TypedVariable variable,LinkedList<String> lAlias)'''
«var obs=new LinkedList<String>()»
{
  "alias": "«variable.name»",«lAlias.addLast(variable.name)»
  "groupBy": [
    {
      "params": [
        "$__interval"
      ],
      "type": "time"
    },
    {
      "params": [
        "null"
      ],
      "type": "fill"
    }
  ],
  "measurement": "Out_Estimate",
  "orderByTime": "ASC",
  "policy": "default",
  "refId": "A",
  "resultFormat": "time_series",
  "select": [
    [
      {
        "params": [
          "«variable.name»"
        ],
        "type": "field"
      },
      {
        "params": [],
        "type": "mean"
      }
    ]
  ],
  "tags": []
},«generateObservations(roqmeModel,variable.name,obs)»
«printObs(obs,lAlias)»
'''


/*GENERAR NORMAL*/
def generateNormalVariable(RoqmeModel roqmeModel,TypedVariable variable,boolean metric,LinkedList<String> lAlias,LinkedList<String> lObs)'''
«var obs=new LinkedList<String>()»«var obsMetrics=new LinkedList<String>()»
{
  "alias": "«variable.name»",«lAlias.addLast(variable.name)»
  "groupBy": [
    {
      "params": [
        "$__interval"
      ],
      "type": "time"
    },
    {
      "params": [
        "null"
      ],
      "type": "fill"
    }
  ],
  "measurement": «IF metric»"Out_Estimate",«ELSE»"In_Context",«ENDIF»
  "orderByTime": "ASC",
  "policy": "default",
  "refId": "A",
  "resultFormat": "time_series",
  "select": [
    [
      {
        "params": [
          "«variable.name»"
        ],
        "type": "field"
      },
      {
        "params": [],
        "type": "mean"
      }
    ]
  ],
  "tags": []
}«IF variable.declaration instanceof InbuiltDeclaration»«generateObservationsMetrics(roqmeModel,variable.name,obsMetrics)»«IF obsMetrics.size()>0»,«printObs(obsMetrics,lAlias)»«FOR ob : obsMetrics»«IF !lObs.contains(ob)»«lObs.addLast(ob)»«ENDIF»«ENDFOR»«ENDIF»«ENDIF»«IF !(variable.declaration instanceof InbuiltDeclaration)»«generateObservations(roqmeModel,variable.name,obs)»«IF obs.size()>0»,«printObs(obs,lAlias)»«FOR ob : obs»«IF !lObs.contains(ob)»«lObs.addLast(ob)»«ENDIF»«ENDFOR»«ENDIF»«ENDIF»
        '''

def void changeDataType(DataType dt){
	this.type=dt
}
def generateBoolEvenEnumVariable(RoqmeModel roqmeModel,LinkedList<TypedVariable> types,LinkedList<String> lAlias)'''«var obs=new LinkedList<String>()»
«FOR variable : types»
«var cDec = variable.declaration as DataTypeDeclaration»
«type=null as DataType»
«IF variable.declaration instanceof ReferencedDeclaration»
«var cRec=variable.declaration as ReferencedDeclaration»
«changeDataType(cRec.type.dataType)»
«ELSE»
«var contained=cDec as ContainedDeclaration»
«changeDataType(contained.type)»
«ENDIF»
«IF type instanceof EnumType»
«var enumV =type as EnumType»

«FOR literal : enumV.literals SEPARATOR '\n'»
{
  "alias": "«variable.name».«literal.name»",«lAlias.addLast(variable.name+"."+literal.name)»
  "groupBy": [
    {
      "params": [
        "$__interval"
      ],
      "type": "time"
    },
    {
      "params": [
        "null"
      ],
      "type": "fill"
    }
  ],
  "measurement": "In_Context",
  "orderByTime": "ASC",
  "policy": "default",
  "refId": "A",
  "resultFormat": "time_series",
  "select": [
    [
      {
        "params": [
          "«variable.name».«literal.name»"
        ],
        "type": "field"
      },
      {
        "params": [],
        "type": "mean"
      }
    ]
  ],
  "tags": []
},«generateObservations(roqmeModel,literal.name,obs)»«ENDFOR»«ELSE»{
  "alias": "«variable.name»",«lAlias.addLast(variable.name)»
  "groupBy": [
    {
      "params": [
        "$__interval"
      ],
      "type": "time"
    },
    {
      "params": [
        "null"
      ],
      "type": "fill"
    }
  ],
  "measurement": "In_Context",
  "orderByTime": "ASC",
  "policy": "default",
  "refId": "A",
  "resultFormat": "time_series",
  "select": [
    [
      {
        "params": [
          "«variable.name»"
        ],
        "type": "field"
      },
      {
        "params": [],
        "type": "mean"
      }
    ]
  ],
  "tags": []
},«generateObservations(roqmeModel,variable.name,obs)»«ENDIF»«ENDFOR»«printObs(obs,lAlias)»
'''


def printObs(LinkedList<String> obs,LinkedList<String> lAlias)'''
«FOR ob : obs SEPARATOR ','»
        {
          "alias": "«ob»",«lAlias.addLast(ob)»
          "groupBy": [
            {
              "params": [
                "$__interval"
              ],
              "type": "time"
            },
            {
              "params": [
                "null"
              ],
              "type": "fill"
            }
          ],
          "measurement": "Observation",
          "orderByTime": "ASC",
          "policy": "default",
          "refId": "A",
          "resultFormat": "time_series",
          "select": [
            [
              {
                "params": [
                  "«ob»"
                ],
                "type": "field"
              },
              {
                "params": [],
                "type": "mean"
              }
            ]
          ],
          "tags": []
        }
«ENDFOR»
'''
	def generateObservations(RoqmeModel roqmeModel, String contextName,LinkedList<String> obs) '''
«FOR sentence : roqmeModel.sentences»
	«IF sentence instanceof Observation»
			«IF sentence.pattern.term instanceof NaryTermOp»
				«var term = sentence.pattern.term as NaryTermOp»
				«FOR termn : term.terms»
					«generateNaryTerm(termn,contextName,sentence.name,obs)»
				«ENDFOR»
			«ENDIF»
			«IF sentence.pattern.term instanceof UnaryTermOp»
				«var term = sentence.pattern.term as UnaryTermOp»
				«generateNaryTerm(term.term,contextName,sentence.name,obs)»
				«ENDIF»
			«IF sentence.pattern.term instanceof BinaryTermOp»
				«generateNaryTerm(sentence.pattern.term,contextName,sentence.name,obs)»
			«ENDIF»
			«IF sentence.pattern.term instanceof VarTerm »
				 «var varterm = sentence.pattern.term as VarTerm»
				 «IF varterm.variable.name == contextName »
				 	«IF !obs.contains(sentence.name)»
				 		«obs.addLast(sentence.name)»
				 	«ENDIF»
				 «ENDIF»
			«ENDIF»
			«IF sentence.pattern.term instanceof ConstTerm»
				 «var valueterm = sentence.pattern.term as ConstTerm»
				 «IF valueterm.value instanceof EnumValue»
				 	«var enumT=valueterm.value as EnumValue»
				 	«IF enumT.value.name == contextName »
						«IF !obs.contains(sentence.name)»
							«obs.addLast(sentence.name)»
						«ENDIF»
					«ENDIF»
				 «ENDIF»
			«ENDIF»
	«ENDIF»
«ENDFOR» 
	'''
	def generateNaryTerm(Term term, String contextName, String obs,LinkedList<String> lObs) '''
		«IF term instanceof VarTerm »
			«var varterm = term as VarTerm»
			«IF varterm.variable.name.equals(contextName)»
				«IF !lObs.contains(obs)»
					«lObs.addLast(obs)»
				«ENDIF»
			«ENDIF»
		«ENDIF»
		«IF term instanceof ConstTerm»
			«var valueterm = term as ConstTerm»
			«IF valueterm.value instanceof EnumValue»
				«var enumT=valueterm.value as EnumValue»
				«IF enumT.value.name == contextName »
					«IF !lObs.contains(obs)»
						«lObs.addLast(obs)»
					«ENDIF»
				«ENDIF»
			«ENDIF»
		«ENDIF»
		«IF term instanceof BinaryTermOp»
			«var binaryterm = term as BinaryTermOp»
			«IF binaryterm.right instanceof VarTerm»
				«var rightTerm = binaryterm.right as VarTerm»
				«IF rightTerm.variable.name == contextName»
					«IF !lObs.contains(obs)»
						«lObs.addLast(obs)»
					«ENDIF»
				«ENDIF»
			«ENDIF»
			«IF binaryterm.left instanceof VarTerm»
				«var leftTerm = binaryterm.left as VarTerm»
				«IF leftTerm.variable.name == contextName»
					«IF !lObs.contains(obs)»
						«lObs.addLast(obs)»
					«ENDIF»
				«ENDIF»
			«ENDIF»
			«IF binaryterm.right instanceof ConstTerm»
				«var valueterm = binaryterm.right as ConstTerm»
				«IF valueterm.value instanceof EnumValue»
					«var enumT=valueterm.value as EnumValue»
					«IF enumT.value.name == contextName »
						«IF !lObs.contains(obs)»
							«lObs.addLast(obs)»
						«ENDIF»
					«ENDIF»
				«ENDIF»
			«ENDIF»
			«IF binaryterm.left instanceof ConstTerm»
				«var valueterm = binaryterm.left as ConstTerm»
				«IF valueterm.value instanceof EnumValue»
					«var enumT=valueterm.value as EnumValue»
					«IF enumT.value.name == contextName »
						«IF !lObs.contains(obs)»
							«lObs.addLast(obs)»
						«ENDIF»
					«ENDIF»
				«ENDIF»
			«ENDIF»			
			«IF binaryterm instanceof BinaryTermOp»
				«generateNaryTerm(binaryterm.left,contextName,obs,lObs)»
				«generateNaryTerm(binaryterm.right,contextName,obs,lObs)»
			«ENDIF»
		«ENDIF»
	'''
	def generateObservationsMetrics(RoqmeModel roqmeModel, String metricName,LinkedList<String> obs) '''
«FOR sentence : roqmeModel.sentences»
	«IF sentence instanceof Observation»
		«var observation = sentence as Observation»
		«FOR action : observation.actions»
			«IF action instanceof SetEvidence»
				«var evidence = action as SetEvidence»
				 «IF evidence.target.name == metricName»
				«IF !(obs.contains(observation.name))»«obs.addLast(observation.name)»
				 	«ENDIF»
				 «ENDIF»
			«ENDIF»
		«ENDFOR»
	«ENDIF»
«ENDFOR» 
	'''
	def generateNaryTermMetrics(Term term, String contextName, String obs,LinkedList<String> lObs) '''
		«IF term instanceof BinaryTermOp»
			«var binaryterm = term as BinaryTermOp»
			«IF binaryterm.right instanceof VarTerm»
				«var rightTerm = binaryterm.right as VarTerm»
				«IF rightTerm.variable.name == contextName»
					«IF !lObs.contains(obs)»
						«lObs.addLast(obs)»
					«ENDIF»
				«ENDIF»
			«ENDIF»
			«IF binaryterm.left instanceof VarTerm»
				«var leftTerm = binaryterm.left as VarTerm»
				«IF leftTerm.variable.name == contextName»
					«IF !lObs.contains(obs)»
						«lObs.addLast(obs)»
					«ENDIF»
				«ENDIF»
			«ENDIF»
			«IF binaryterm instanceof BinaryTermOp»«generateNaryTerm(binaryterm.left,contextName,obs,lObs)»«generateNaryTerm(binaryterm.right,contextName,obs,lObs)»
				«ENDIF»
			«ENDIF»
	'''
}











