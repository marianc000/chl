/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rules;

import static folder.Constants.NO_DRUGS;
import java.util.Set;

/**
 *
 * @author mcaikovs
 */
public class Rule {

    Set<String> drugs;
    String initialState;
    Prognosis prognosis;

    public Rule(Set<String> drugs, String initialState, String resultingState, int probability) {
        this.drugs = drugs;
        this.initialState = initialState;
        this.prognosis = new Prognosis(resultingState, probability);
    }

    public Set<String> getDrugs() {
        return drugs;
    }

    public boolean noDrugRule() {
        return drugs.contains(NO_DRUGS);
    }

    public String getInitialState() {
        return initialState;
    }

    public boolean isApplicableForState(String state) {
        return initialState.equals(state);
    }

    public String getResultingState() {
        String newState = this.prognosis.getNewState();
        if (newState == null) {
            newState = this.initialState;
        }
        return newState;
    }
}
