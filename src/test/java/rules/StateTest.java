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
        assertTrue(stateInRule.inRuleMatchesPatientState(new State("F")));
        assertFalse(stateInRule.inRuleMatchesPatientState(new State("T")));

        stateInRule = new State("X");
        assertTrue(stateInRule.inRuleMatchesPatientState(new State("X")));
        assertFalse(stateInRule.inRuleMatchesPatientState(new State("T")));

        stateInRule = new State("*");
        assertTrue(stateInRule.inRuleMatchesPatientState(new State("T")));
        assertFalse(stateInRule.inRuleMatchesPatientState(new State("X")));
    }

}
