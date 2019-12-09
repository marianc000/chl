/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import java.util.Set;

/**
 *
 * @author mcaikovs
 */
public class PatientWithTreatment {

    String states;
    Set<String> drugs;

    public PatientWithTreatment(String states, Set<String> drugs) {
        this.states = states;
        this.drugs = drugs;
    }

    public String getStates() {
        return states;
    }

    public Set<String> getDrugs() {
        return drugs;
    }

}
