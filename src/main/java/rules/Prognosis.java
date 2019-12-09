/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rules;

import java.util.Random;

/**
 *
 * @author mcaikovs
 */
public class Prognosis {

    static Random rand = new Random();
    String prognosis;
    int prognosisProbability  ;

    public Prognosis(String prognosis, int prognosisProbability) {
        this.prognosis = prognosis;
        this.prognosisProbability = prognosisProbability;
    }
   

    boolean prognosisFulfilled(int prognosisProbability) {
        return rand.nextInt(prognosisProbability) == 0;
    }

    public String getNewState() {
        if (prognosisFulfilled(prognosisProbability)) {
            return prognosis;
        }
        return null;
    }
}
