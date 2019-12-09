/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

/**
 *
 * @author mcaikovs
 */
public class Rule {

    String drugs, initialState, resultingState;
    int probability;

    public  Rule(String drugs, String initialState, String resultingState, int probability) {
        this.drugs = drugs;
        this.initialState = initialState;
        this.resultingState = resultingState;
        this.probability = probability;
    }
    public String getDrugs() {
        return drugs;
    }

    public String getInitialState() {
        return initialState;
    }

    public String getResultingState() {
        return resultingState;
    }

    public int getProbability() {
        return probability;
    }


}
