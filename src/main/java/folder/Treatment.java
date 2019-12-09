/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import java.util.EnumSet;
import java.util.Objects;

/**
 *
 * @author mcaikovs
 */
public class Treatment {

    EnumSet<Drug> treatment = EnumSet.noneOf(Drug.class);

    Treatment(Drug... drugs) {
        for (Drug d : drugs) {
            treatment.add(d);
        }
    }

    @Override
    public int hashCode() {
        return treatment.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return treatment.equals(obj);
    }
}
