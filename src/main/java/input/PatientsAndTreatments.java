/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import java.util.List;
import java.util.Set;

/**
 *
 * @author mcaikovs
 */
public class PatientsAndTreatments {

    List<String> states;
    Set<String> drugs;

    public PatientsAndTreatments(List<String> states, Set<String> drugs) {
        this.states = states;
        this.drugs = drugs;
    }

    public List<String> getStates() {
        return states;
    }
 

    public Set<String> getDrugs() {
        return drugs;
    }

}
