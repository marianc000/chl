/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mcaikovs
 */
public class RuleSummaryTest {

    public RuleSummaryTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testgetAllDrugs() throws IOException {
        RuleSummary i = new RuleSummary(new RulesInTextReader().getRules());
        Set<String> r = i.getAllDrugs();
        assertEquals(r.toString(), "[P, I, As, An, -]");
    }

    @Test
    public void testgetAllStates() throws IOException {
        RuleSummary i = new RuleSummary(new RulesInTextReader().getRules());
        Set<String> r = i.getAllStates();
        assertEquals(r.toString(), "[T, D, F, X, *]");
    }
}
