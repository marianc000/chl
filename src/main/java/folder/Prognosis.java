/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import java.util.List;
import java.util.Random;

/**
 *
 * @author mcaikovs
 */
public class Prognosis {

    static Random rand = new Random();
    State prognosis;
    int prognosisProbability = 1;
    List<Drug> drugs;

    public Prognosis(State prognosis) {
        this.prognosis = prognosis;
    }

    public Prognosis(State prognosis, int prognosisProbability) {
        this(prognosis);
        this.prognosisProbability = prognosisProbability;
    }

    public Prognosis(State prognosis, int prognosisProbability, List<Drug> drugs) {
        this(prognosis, prognosisProbability);
        this.drugs = drugs;
    }

    boolean prognosisFulfilled(int prognosisProbability) {
        return rand.nextInt(prognosisProbability) == 0;
    }

    public State getNewState() {
        if (prognosisFulfilled(prognosisProbability)) {
            return prognosis;
        }
        return null;
    }

}
