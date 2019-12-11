package rules;

import java.util.Set;

/**
 *
 * @author mcaikovs
 */
public class Rule {

    State applicableForState;
    Set<String> requiredDrugs;
    Prognosis stateAfterTreatment, stateWtithoutTreatment;

    public Rule(State applicableForState, Set<String> drugs, Prognosis stateAfterTreatment, Prognosis stateWtithoutTreatment) {
        this.applicableForState = applicableForState;
        this.requiredDrugs = drugs;
        this.stateAfterTreatment = stateAfterTreatment;
        this.stateWtithoutTreatment = stateWtithoutTreatment;
    }
//
//    @Override
//    public String toString() {
//        return "Rule{" + "applicableForState=" + applicableForState + ", drugs=" + requiredDrugs + ", stateAfterTreatment=" + stateAfterTreatment + ", stateWtithoutTreatment=" + stateWtithoutTreatment + '}';
//    }

    boolean isApplicableForState(State patientState) {
        return applicableForState.matches(patientState);
    }

    public State applyRuleToGetNewState(State patientState, Set<String> usedDrugs) {
        if (!isApplicableForState(patientState)) {  // skip rule
            return patientState;
        }

        if (usedDrugs.containsAll(requiredDrugs)) {
            return stateAfterTreatment.getNewState(patientState);
        }

        return stateWtithoutTreatment.getNewState(patientState);
    }
}
