/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import static utils.Utils.prognosisFulfilled;

/**
 *
 * @author mcaikovs
 */
public enum State {

    Fever("F"),
    Healthy("H"),
    Dead("X", Healthy, 1_000_000), //One time in a million a Dead becomes Healthy.),
    Diabetes("D", Dead),//Insulin prevents diabetic subject from dying
    Tuberculosis("T");

    String abbreviation;
    State prognosis;
    int prognosisProbability = 1;

    private State(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    private State(String abbreviation, State prognosis) {
        this(abbreviation);
        this.prognosis = prognosis;
    }

    private State(String abbreviation, State prognosis, int prognosisProbability) {
        this(abbreviation, prognosis);
        this.prognosisProbability = prognosisProbability;
    }


}
