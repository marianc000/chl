/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        rules = new RulesInTextReader().getRules();
//        for (int c = 0; c < rules.size(); c++) {
//            System.out.println(c + "\t" + rules.get(c));
//        }
//
    }

    List<Rule> rules;

    String exec(int ruleIdx, String patientState, String usedDrugs) {
        return rules.get(ruleIdx).
                applyRuleToGetNewState(new State(patientState),
                        commaSeparatedStringToSet(usedDrugs)).stateString;
    }

    @Test
    public void testRule() {
        assertEquals(rules.size(), 7);
        assertEquals(exec(0, "F", "As"), "H"); // matches and treated
        assertEquals(exec(0, "F", null), "F"); // matches not treated
        assertEquals(exec(0, "F", "An"), "F"); // matches treated with wrong drugs
        assertEquals(exec(0, "T", "As"), "T"); // drugs match
        assertEquals(exec(0, "T", "An"), "T"); // state and drugs do not match

        assertEquals(exec(4, "F", "P"), "H"); // matches and treated
        assertEquals(exec(4, "F", null), "F"); // matches not treated
        assertEquals(exec(4, "F", "I"), "F"); // matches treated with wrong drugs
        assertEquals(exec(4, "T", "P"), "T"); // drugs match
        assertEquals(exec(4, "T", "P"), "T"); // state and drugs do not match

        assertEquals(exec(1, "T", "An"), "H"); // matches and treated
        assertEquals(exec(1, "T", null), "T"); // matches not treated
        assertEquals(exec(1, "T", "As"), "T"); // matches treated with wrong drugs
        assertEquals(exec(1, "D", "An"), "D"); // drugs match
        assertEquals(exec(1, "D", "As"), "D"); // state and drugs do not match

        assertEquals(exec(2, "D", "I"), "D"); // matches and treated
        assertEquals(exec(2, "D", null), "X"); // matches not treated
        assertEquals(exec(2, "D", "As"), "X"); // matches treated with wrong drugs
        assertEquals(exec(2, "X", "I"), "X"); // drugs match
        assertEquals(exec(2, "X", "As"), "X"); // state and drugs do not match

        assertEquals(exec(3, "H", "I,An"), "F"); // matches and treated
        assertEquals(exec(3, "D", "I,An"), "D"); // matches and treated
        assertEquals(exec(3, "T", "I,An"), "T"); // matches and treated
        assertEquals(exec(3, "X", "I,An"), "X"); // matches and treated
        assertEquals(exec(3, "H", null), "H"); // matches not treated
        assertEquals(exec(3, "H", "As"), "H"); // matches treated with wrong drugs

        assertEquals(exec(5, "H", "P,As"), "X"); // matches and treated
        assertEquals(exec(5, "F", "P,As"), "X"); // matches and treated
        assertEquals(exec(5, "T", "P,As"), "X"); // matches and treated
        assertEquals(exec(5, "D", "P,As"), "X"); // matches and treated
        assertEquals(exec(5, "X", "P,As"), "X"); // matches and treated
        assertEquals(exec(5, "H", null), "H"); // matches and treated
        assertEquals(exec(5, "F", null), "F"); // matches and treated
        assertEquals(exec(5, "T", null), "T"); // matches and treated
        assertEquals(exec(5, "D", null), "D"); // matches and treated
        assertEquals(exec(5, "X", null), "X"); // matches and treated

        assertEquals(exec(6, "X", null), "X"); // matches and treated
        assertEquals(exec(6, "X", "As"), "X"); // matches not treated
        assertEquals(exec(6, "X", "An"), "X"); // matches treated with wrong drugs
        assertEquals(exec(6, "T", "As"), "T"); // drugs match
        assertEquals(exec(6, "T", "An"), "T"); // state and drugs do not match
    }

}
