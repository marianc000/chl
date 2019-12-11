package rules;

import java.io.IOException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mcaikovs
 */
public class RulesInTextReaderTest {

    public RulesInTextReaderTest() {
    }
    RulesInTextReader i = new RulesInTextReader();

    @Test
    public void testreadText() throws IOException {
        List<String> r = i.readText();
        assertTrue(r.size() == 7);
    }

    @Test
    public void testextractParameteresFromLine() throws IOException {
        String s = "X                   *         H/1000000                           D                                         One time in a million Dead becomes Healthy";
        String[] r = i.extractParameteresFromLine(s);
        assertTrue(r.length > 4);
    }

    @Test
    public void testgetRules() throws IOException {
        List<Rule> r = i.getRules();
        assertTrue(r.size() == 7);
    }

    @Test
    public void testExtractExpectedStateWithProbability() throws IOException {
        Prognosis p = i.extractExpectedStateWithProbability("X");
        assertEquals(p.inverseProbability, 1);
        assertTrue(p.nextState.equals(new State("X")));

        p = i.extractExpectedStateWithProbability("H/1000000");
        assertEquals(p.inverseProbability, 1000000);
        assertTrue(p.nextState.equals(new State("H")));
    }
}
