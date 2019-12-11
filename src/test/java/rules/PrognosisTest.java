/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static utils.Utils.prognosisFulfilled;

/**
 *
 * @author mcaikovs
 */
public class PrognosisTest {

    public int executeTimes(Prognosis prognosis, int tries) {
        int r = 0;

        for (int i = 0; i < tries; i++) {
            if (prognosis.fulfilled()) {
                r++;
            }
        }
        return r;
    }

    @Test
    public void testPrognosisFulfilled() {
        State someState = new State("TEST");
        assertEquals(executeTimes(new Prognosis(someState), 100), 100);

        int r = executeTimes(new Prognosis(someState, 100), 300);
        System.out.println(r);
        assertTrue(r < 10 && r > 0);

    }

    @Test
    public void testGetNewState() {
        State expectedState = new State("OLD");
        State currentState = new State("NEW");
        assertTrue(new Prognosis(expectedState).getNewState(currentState).equals(expectedState));
        assertTrue(new Prognosis(expectedState, Integer.MAX_VALUE).getNewState(currentState).equals(currentState));

        expectedState = new State(expectedState.noNewStateString());
        assertTrue(new Prognosis(expectedState).getNewState(currentState).equals(currentState));
        assertTrue(new Prognosis(expectedState, Integer.MAX_VALUE).getNewState(currentState).equals(currentState));
    }
}
