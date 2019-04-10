/**
 */
package roqme.metamodel.kernel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import roqme.metamodel.datatypes.DocumentableElement;
import roqme.metamodel.datatypes.Sentence;
import roqme.metamodel.datatypes.TypedVariable;

import roqme.metamodel.kernel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see roqme.metamodel.kernel.KernelPackage
 * @generated
 */
public class KernelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static KernelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KernelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = KernelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KernelSwitch<Adapter> modelSwitch =
		new KernelSwitch<Adapter>() {
			@Override
			public Adapter casePrimitiveContext(PrimitiveContext object) {
				return createPrimitiveContextAdapter();
			}
			@Override
			public Adapter caseDerivedContext(DerivedContext object) {
				return createDerivedContextAdapter();
			}
			@Override
			public Adapter caseGeneralPurposeVariable(GeneralPurposeVariable object) {
				return createGeneralPurposeVariableAdapter();
			}
			@Override
			public Adapter caseObservation(Observation object) {
				return createObservationAdapter();
			}
			@Override
			public Adapter caseProperty(Property object) {
				return createPropertyAdapter();
			}
			@Override
			public Adapter caseBeliefVariable(BeliefVariable object) {
				return createBeliefVariableAdapter();
			}
			@Override
			public Adapter caseSetEvidence(SetEvidence object) {
				return createSetEvidenceAdapter();
			}
			@Override
			public Adapter caseImport(Import object) {
				return createImportAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseContext(Context object) {
				return createContextAdapter();
			}
			@Override
			public Adapter caseAction(Action object) {
				return createActionAdapter();
			}
			@Override
			public Adapter caseSetVariable(SetVariable object) {
				return createSetVariableAdapter();
			}
			@Override
			public Adapter caseTimer(Timer object) {
				return createTimerAdapter();
			}
			@Override
			public Adapter caseTimerAction(TimerAction object) {
				return createTimerActionAdapter();
			}
			@Override
			public Adapter caseStartTimer(StartTimer object) {
				return createStartTimerAdapter();
			}
			@Override
			public Adapter caseStopTimer(StopTimer object) {
				return createStopTimerAdapter();
			}
			@Override
			public Adapter caseResumeTimer(ResumeTimer object) {
				return createResumeTimerAdapter();
			}
			@Override
			public Adapter caseClearEvidence(ClearEvidence object) {
				return createClearEvidenceAdapter();
			}
			@Override
			public Adapter caseDocumentableElement(DocumentableElement object) {
				return createDocumentableElementAdapter();
			}
			@Override
			public Adapter caseTypedVariable(TypedVariable object) {
				return createTypedVariableAdapter();
			}
			@Override
			public Adapter caseSentence(Sentence object) {
				return createSentenceAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.kernel.PrimitiveContext <em>Primitive Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.kernel.PrimitiveContext
	 * @generated
	 */
	public Adapter createPrimitiveContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.kernel.DerivedContext <em>Derived Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.kernel.DerivedContext
	 * @generated
	 */
	public Adapter createDerivedContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.kernel.GeneralPurposeVariable <em>General Purpose Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.kernel.GeneralPurposeVariable
	 * @generated
	 */
	public Adapter createGeneralPurposeVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.kernel.Observation <em>Observation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.kernel.Observation
	 * @generated
	 */
	public Adapter createObservationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.kernel.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.kernel.Property
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.kernel.BeliefVariable <em>Belief Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.kernel.BeliefVariable
	 * @generated
	 */
	public Adapter createBeliefVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.kernel.SetEvidence <em>Set Evidence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.kernel.SetEvidence
	 * @generated
	 */
	public Adapter createSetEvidenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.kernel.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.kernel.Import
	 * @generated
	 */
	public Adapter createImportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.kernel.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.kernel.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.kernel.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.kernel.Context
	 * @generated
	 */
	public Adapter createContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.kernel.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.kernel.Action
	 * @generated
	 */
	public Adapter createActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.kernel.SetVariable <em>Set Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.kernel.SetVariable
	 * @generated
	 */
	public Adapter createSetVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.kernel.Timer <em>Timer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.kernel.Timer
	 * @generated
	 */
	public Adapter createTimerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.kernel.TimerAction <em>Timer Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.kernel.TimerAction
	 * @generated
	 */
	public Adapter createTimerActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.kernel.StartTimer <em>Start Timer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.kernel.StartTimer
	 * @generated
	 */
	public Adapter createStartTimerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.kernel.StopTimer <em>Stop Timer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.kernel.StopTimer
	 * @generated
	 */
	public Adapter createStopTimerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.kernel.ResumeTimer <em>Resume Timer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.kernel.ResumeTimer
	 * @generated
	 */
	public Adapter createResumeTimerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.kernel.ClearEvidence <em>Clear Evidence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.kernel.ClearEvidence
	 * @generated
	 */
	public Adapter createClearEvidenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.datatypes.DocumentableElement <em>Documentable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.datatypes.DocumentableElement
	 * @generated
	 */
	public Adapter createDocumentableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.datatypes.TypedVariable <em>Typed Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.datatypes.TypedVariable
	 * @generated
	 */
	public Adapter createTypedVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link roqme.metamodel.datatypes.Sentence <em>Sentence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see roqme.metamodel.datatypes.Sentence
	 * @generated
	 */
	public Adapter createSentenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //KernelAdapterFactory
