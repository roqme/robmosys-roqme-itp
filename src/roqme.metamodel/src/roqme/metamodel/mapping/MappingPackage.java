/**
 */
package roqme.metamodel.mapping;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see roqme.metamodel.mapping.MappingFactory
 * @model kind="package"
 * @generated
 */
public interface MappingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mapping";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://robmosys.eu/roqme/mapping";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "roqme.mapping";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MappingPackage eINSTANCE = roqme.metamodel.mapping.impl.MappingPackageImpl.init();

	/**
	 * The meta object id for the '{@link roqme.metamodel.mapping.impl.MappingModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.mapping.impl.MappingModelImpl
	 * @see roqme.metamodel.mapping.impl.MappingPackageImpl#getMappingModel()
	 * @generated
	 */
	int MAPPING_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Monitors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL__MONITORS = 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL__IMPORTS = 1;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.mapping.impl.MonitorImpl <em>Monitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.mapping.impl.MonitorImpl
	 * @see roqme.metamodel.mapping.impl.MappingPackageImpl#getMonitor()
	 * @generated
	 */
	int MONITOR = 1;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR__CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR__SERVICE = 1;

	/**
	 * The feature id for the '<em><b>Opts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR__OPTS = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR__SOURCE = 3;

	/**
	 * The feature id for the '<em><b>Source Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR__SOURCE_TYPE = 4;

	/**
	 * The number of structural features of the '<em>Monitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Monitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.mapping.impl.ConfigOptImpl <em>Config Opt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.mapping.impl.ConfigOptImpl
	 * @see roqme.metamodel.mapping.impl.MappingPackageImpl#getConfigOpt()
	 * @generated
	 */
	int CONFIG_OPT = 2;

	/**
	 * The number of structural features of the '<em>Config Opt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_OPT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Config Opt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_OPT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.mapping.impl.PeriodImpl <em>Period</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.mapping.impl.PeriodImpl
	 * @see roqme.metamodel.mapping.impl.MappingPackageImpl#getPeriod()
	 * @generated
	 */
	int PERIOD = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIOD__VALUE = CONFIG_OPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIOD__UNIT = CONFIG_OPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Period</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIOD_FEATURE_COUNT = CONFIG_OPT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Period</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIOD_OPERATION_COUNT = CONFIG_OPT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.mapping.impl.MinTimeBtwUpdatesImpl <em>Min Time Btw Updates</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.mapping.impl.MinTimeBtwUpdatesImpl
	 * @see roqme.metamodel.mapping.impl.MappingPackageImpl#getMinTimeBtwUpdates()
	 * @generated
	 */
	int MIN_TIME_BTW_UPDATES = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_TIME_BTW_UPDATES__VALUE = CONFIG_OPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_TIME_BTW_UPDATES__UNIT = CONFIG_OPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Min Time Btw Updates</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_TIME_BTW_UPDATES_FEATURE_COUNT = CONFIG_OPT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Min Time Btw Updates</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_TIME_BTW_UPDATES_OPERATION_COUNT = CONFIG_OPT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.mapping.impl.MinDiffBtwUpdatesImpl <em>Min Diff Btw Updates</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.mapping.impl.MinDiffBtwUpdatesImpl
	 * @see roqme.metamodel.mapping.impl.MappingPackageImpl#getMinDiffBtwUpdates()
	 * @generated
	 */
	int MIN_DIFF_BTW_UPDATES = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_DIFF_BTW_UPDATES__VALUE = CONFIG_OPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Min Diff Btw Updates</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_DIFF_BTW_UPDATES_FEATURE_COUNT = CONFIG_OPT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Min Diff Btw Updates</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_DIFF_BTW_UPDATES_OPERATION_COUNT = CONFIG_OPT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link roqme.metamodel.mapping.impl.ImportImpl <em>Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see roqme.metamodel.mapping.impl.ImportImpl
	 * @see roqme.metamodel.mapping.impl.MappingPackageImpl#getImport()
	 * @generated
	 */
	int IMPORT = 6;

	/**
	 * The feature id for the '<em><b>Import URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__IMPORT_URI = 0;

	/**
	 * The number of structural features of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link roqme.metamodel.mapping.MappingModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see roqme.metamodel.mapping.MappingModel
	 * @generated
	 */
	EClass getMappingModel();

	/**
	 * Returns the meta object for the containment reference list '{@link roqme.metamodel.mapping.MappingModel#getMonitors <em>Monitors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Monitors</em>'.
	 * @see roqme.metamodel.mapping.MappingModel#getMonitors()
	 * @see #getMappingModel()
	 * @generated
	 */
	EReference getMappingModel_Monitors();

	/**
	 * Returns the meta object for the containment reference list '{@link roqme.metamodel.mapping.MappingModel#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see roqme.metamodel.mapping.MappingModel#getImports()
	 * @see #getMappingModel()
	 * @generated
	 */
	EReference getMappingModel_Imports();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.mapping.Monitor <em>Monitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Monitor</em>'.
	 * @see roqme.metamodel.mapping.Monitor
	 * @generated
	 */
	EClass getMonitor();

	/**
	 * Returns the meta object for the reference '{@link roqme.metamodel.mapping.Monitor#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see roqme.metamodel.mapping.Monitor#getContext()
	 * @see #getMonitor()
	 * @generated
	 */
	EReference getMonitor_Context();

	/**
	 * Returns the meta object for the reference '{@link roqme.metamodel.mapping.Monitor#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Service</em>'.
	 * @see roqme.metamodel.mapping.Monitor#getService()
	 * @see #getMonitor()
	 * @generated
	 */
	EReference getMonitor_Service();

	/**
	 * Returns the meta object for the containment reference list '{@link roqme.metamodel.mapping.Monitor#getOpts <em>Opts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Opts</em>'.
	 * @see roqme.metamodel.mapping.Monitor#getOpts()
	 * @see #getMonitor()
	 * @generated
	 */
	EReference getMonitor_Opts();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.mapping.Monitor#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see roqme.metamodel.mapping.Monitor#getSource()
	 * @see #getMonitor()
	 * @generated
	 */
	EAttribute getMonitor_Source();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.mapping.Monitor#getSourceType <em>Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Type</em>'.
	 * @see roqme.metamodel.mapping.Monitor#getSourceType()
	 * @see #getMonitor()
	 * @generated
	 */
	EAttribute getMonitor_SourceType();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.mapping.ConfigOpt <em>Config Opt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config Opt</em>'.
	 * @see roqme.metamodel.mapping.ConfigOpt
	 * @generated
	 */
	EClass getConfigOpt();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.mapping.Period <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Period</em>'.
	 * @see roqme.metamodel.mapping.Period
	 * @generated
	 */
	EClass getPeriod();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.mapping.Period#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see roqme.metamodel.mapping.Period#getValue()
	 * @see #getPeriod()
	 * @generated
	 */
	EAttribute getPeriod_Value();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.mapping.Period#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see roqme.metamodel.mapping.Period#getUnit()
	 * @see #getPeriod()
	 * @generated
	 */
	EAttribute getPeriod_Unit();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.mapping.MinTimeBtwUpdates <em>Min Time Btw Updates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Min Time Btw Updates</em>'.
	 * @see roqme.metamodel.mapping.MinTimeBtwUpdates
	 * @generated
	 */
	EClass getMinTimeBtwUpdates();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.mapping.MinTimeBtwUpdates#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see roqme.metamodel.mapping.MinTimeBtwUpdates#getValue()
	 * @see #getMinTimeBtwUpdates()
	 * @generated
	 */
	EAttribute getMinTimeBtwUpdates_Value();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.mapping.MinTimeBtwUpdates#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see roqme.metamodel.mapping.MinTimeBtwUpdates#getUnit()
	 * @see #getMinTimeBtwUpdates()
	 * @generated
	 */
	EAttribute getMinTimeBtwUpdates_Unit();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.mapping.MinDiffBtwUpdates <em>Min Diff Btw Updates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Min Diff Btw Updates</em>'.
	 * @see roqme.metamodel.mapping.MinDiffBtwUpdates
	 * @generated
	 */
	EClass getMinDiffBtwUpdates();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.mapping.MinDiffBtwUpdates#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see roqme.metamodel.mapping.MinDiffBtwUpdates#getValue()
	 * @see #getMinDiffBtwUpdates()
	 * @generated
	 */
	EAttribute getMinDiffBtwUpdates_Value();

	/**
	 * Returns the meta object for class '{@link roqme.metamodel.mapping.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import</em>'.
	 * @see roqme.metamodel.mapping.Import
	 * @generated
	 */
	EClass getImport();

	/**
	 * Returns the meta object for the attribute '{@link roqme.metamodel.mapping.Import#getImportURI <em>Import URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import URI</em>'.
	 * @see roqme.metamodel.mapping.Import#getImportURI()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_ImportURI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MappingFactory getMappingFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link roqme.metamodel.mapping.impl.MappingModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.mapping.impl.MappingModelImpl
		 * @see roqme.metamodel.mapping.impl.MappingPackageImpl#getMappingModel()
		 * @generated
		 */
		EClass MAPPING_MODEL = eINSTANCE.getMappingModel();

		/**
		 * The meta object literal for the '<em><b>Monitors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_MODEL__MONITORS = eINSTANCE.getMappingModel_Monitors();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_MODEL__IMPORTS = eINSTANCE.getMappingModel_Imports();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.mapping.impl.MonitorImpl <em>Monitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.mapping.impl.MonitorImpl
		 * @see roqme.metamodel.mapping.impl.MappingPackageImpl#getMonitor()
		 * @generated
		 */
		EClass MONITOR = eINSTANCE.getMonitor();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MONITOR__CONTEXT = eINSTANCE.getMonitor_Context();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MONITOR__SERVICE = eINSTANCE.getMonitor_Service();

		/**
		 * The meta object literal for the '<em><b>Opts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MONITOR__OPTS = eINSTANCE.getMonitor_Opts();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MONITOR__SOURCE = eINSTANCE.getMonitor_Source();

		/**
		 * The meta object literal for the '<em><b>Source Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MONITOR__SOURCE_TYPE = eINSTANCE.getMonitor_SourceType();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.mapping.impl.ConfigOptImpl <em>Config Opt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.mapping.impl.ConfigOptImpl
		 * @see roqme.metamodel.mapping.impl.MappingPackageImpl#getConfigOpt()
		 * @generated
		 */
		EClass CONFIG_OPT = eINSTANCE.getConfigOpt();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.mapping.impl.PeriodImpl <em>Period</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.mapping.impl.PeriodImpl
		 * @see roqme.metamodel.mapping.impl.MappingPackageImpl#getPeriod()
		 * @generated
		 */
		EClass PERIOD = eINSTANCE.getPeriod();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERIOD__VALUE = eINSTANCE.getPeriod_Value();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERIOD__UNIT = eINSTANCE.getPeriod_Unit();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.mapping.impl.MinTimeBtwUpdatesImpl <em>Min Time Btw Updates</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.mapping.impl.MinTimeBtwUpdatesImpl
		 * @see roqme.metamodel.mapping.impl.MappingPackageImpl#getMinTimeBtwUpdates()
		 * @generated
		 */
		EClass MIN_TIME_BTW_UPDATES = eINSTANCE.getMinTimeBtwUpdates();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIN_TIME_BTW_UPDATES__VALUE = eINSTANCE.getMinTimeBtwUpdates_Value();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIN_TIME_BTW_UPDATES__UNIT = eINSTANCE.getMinTimeBtwUpdates_Unit();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.mapping.impl.MinDiffBtwUpdatesImpl <em>Min Diff Btw Updates</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.mapping.impl.MinDiffBtwUpdatesImpl
		 * @see roqme.metamodel.mapping.impl.MappingPackageImpl#getMinDiffBtwUpdates()
		 * @generated
		 */
		EClass MIN_DIFF_BTW_UPDATES = eINSTANCE.getMinDiffBtwUpdates();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIN_DIFF_BTW_UPDATES__VALUE = eINSTANCE.getMinDiffBtwUpdates_Value();

		/**
		 * The meta object literal for the '{@link roqme.metamodel.mapping.impl.ImportImpl <em>Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see roqme.metamodel.mapping.impl.ImportImpl
		 * @see roqme.metamodel.mapping.impl.MappingPackageImpl#getImport()
		 * @generated
		 */
		EClass IMPORT = eINSTANCE.getImport();

		/**
		 * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__IMPORT_URI = eINSTANCE.getImport_ImportURI();

	}

} //MappingPackage
