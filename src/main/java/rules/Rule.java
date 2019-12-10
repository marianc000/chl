package rules;

import java.util.Set;

/**
 *
 * @author mcaikovs
 */
public class Rule {

    State initialState;
    Set<String> drugs;
    Prognosis stateAfterTreatment, stateWtithoutTreatment;

    public Rule(State initialState, Set<String> drugs, Prognosis stateAfterTreatment, Prognosis stateWtithoutTreatment) {
        this.initialState = initialState;
        this.drugs = drugs;
        this.stateAfterTreatment = stateAfterTreatment;
        this.stateWtithoutTreatment = stateWtithoutTreatment;
    }

    @Override
    public String toString() {
        return "Rule{" + "initialState=" + initialState + ", drugs=" + drugs + ", stateAfterTreatment=" + stateAfterTreatment + ", stateWtithoutTreatment=" + stateWtithoutTreatment + '}';
    }

//
//    public Set<String> getDrugs() {
//        return drugs;
//    }
//
//    public boolean noDrugRule() {
//        return drugs.contains(NO_DRUGS);
//    }
    boolean isApplicableForState(State patientState) {
        return initialState.equals(patientState)
                || (initialState.isAllNotDead() && patientState.isAlive());
    }

    public State getResultingState(State patientState, Set<String> usedDrugs) {

        State r = getResultingState2(patientState, usedDrugs);
        System.out.println("patientState=" + patientState + ", usedDrugs=" + usedDrugs + ", r=" + r);
        return r;
    }

    State getResultingState2(State patientState, Set<String> usedDrugs) {

        if (!isApplicableForState(patientState)) {
            System.out.println("NA");
            return patientState;
        }

        if (usedDrugs.containsAll(drugs)) {
            return stateAfterTreatment.getNewState(patientState);
        }

        return stateWtithoutTreatment.getNewState(patientState);
    }
}
