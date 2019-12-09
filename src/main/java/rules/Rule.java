/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rules;

/**
 *
 * @author mcaikovs
 */
public class Rule {

    String drugs, initialState;
    Prognosis prognosis;

    public Rule(String drugs, String initialState, String resultingState, int probability) {
        this.drugs = drugs;
        this.initialState = initialState;
        this.prognosis = new Prognosis(resultingState, probability);
    }

    public String getDrugs() {
        return drugs;
    }

    public String getInitialState() {
        return initialState;
    }

    public String getResultingState() {
        String newState = this.prognosis.getNewState();
        if (newState == null) {
            newState = this.initialState;
        }
        return newState;
    }
}
