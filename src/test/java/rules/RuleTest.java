package rules;

import java.io.IOException;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static utils.Utils.commaSeparatedStringToSet;

/**
 *
 * @author mcaikovs
 */
public class RuleTest {

    public RuleTest() throws IOException {
        rules = new RulesInTextLoader().getRules();
    }

    List<Rule> rules;

    String exec(int ruleIdx, String patientState, String usedDrugs) {
        return rules.get(ruleIdx).
                applyRuleToGetNewState(new State(patientState),
                        commaSeparatedStringToSet(usedDrugs)).getStateString();
    }

    @Test
    public void testRule() {
        assertEquals(rules.size(), 7);
        assertEquals(exec(0, "F", "As"), "H"); 
        assertEquals(exec(0, "F", null), "F"); 
        assertEquals(exec(0, "F", "An"), "F"); 
        assertEquals(exec(0, "T", "As"), "T"); 
        assertEquals(exec(0, "T", "An"), "T"); 

        assertEquals(exec(4, "F", "P"), "H"); 
        assertEquals(exec(4, "F", null), "F"); 
        assertEquals(exec(4, "F", "I"), "F"); 
        assertEquals(exec(4, "T", "P"), "T"); 
        assertEquals(exec(4, "T", "P"), "T"); 

        assertEquals(exec(1, "T", "An"), "H"); 
        assertEquals(exec(1, "T", null), "T"); 
        assertEquals(exec(1, "T", "As"), "T"); 
        assertEquals(exec(1, "D", "An"), "D"); 
        assertEquals(exec(1, "D", "As"), "D"); 

        assertEquals(exec(2, "D", "I"), "D"); 
        assertEquals(exec(2, "D", null), "X"); 
        assertEquals(exec(2, "D", "As"), "X"); 
        assertEquals(exec(2, "X", "I"), "X"); 
        assertEquals(exec(2, "X", "As"), "X"); 

        assertEquals(exec(3, "H", "I,An"), "F"); 
        assertEquals(exec(3, "D", "I,An"), "D"); 
        assertEquals(exec(3, "T", "I,An"), "T"); 
        assertEquals(exec(3, "X", "I,An"), "X"); 
        assertEquals(exec(3, "H", null), "H"); 
        assertEquals(exec(3, "H", "As"), "H"); 

        assertEquals(exec(5, "H", "P,As"), "X"); 
        assertEquals(exec(5, "F", "P,As"), "X"); 
        assertEquals(exec(5, "T", "P,As"), "X"); 
        assertEquals(exec(5, "D", "P,As"), "X"); 
        assertEquals(exec(5, "X", "P,As"), "X"); 
        assertEquals(exec(5, "H", null), "H"); 
        assertEquals(exec(5, "F", null), "F"); 
        assertEquals(exec(5, "T", null), "T"); 
        assertEquals(exec(5, "D", null), "D"); 
        assertEquals(exec(5, "X", null), "X"); 

        assertEquals(exec(6, "X", null), "X"); 
        assertEquals(exec(6, "X", "As"), "X"); 
        assertEquals(exec(6, "X", "An"), "X"); 
        assertEquals(exec(6, "T", "As"), "T"); 
        assertEquals(exec(6, "T", "An"), "T"); 
    }

}
