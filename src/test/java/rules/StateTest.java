package rules;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mcaikovs
 */
public class StateTest {

    void tearDown() {
    }

    @Test
    public void testDoesMatch() {
        State stateInRule = new State("F");
        assertTrue(stateInRule.matches(new State("F")));
        assertFalse(stateInRule.matches(new State("T")));

        stateInRule = new State("X");
        assertTrue(stateInRule.matches(new State("X")));
        assertFalse(stateInRule.matches(new State("T")));

        stateInRule = new State("*");
        assertTrue(stateInRule.matches(new State("T")));
        assertFalse(stateInRule.matches(new State("X")));
    }

}
