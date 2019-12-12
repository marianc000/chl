package output;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import rules.State;

/**
 *
 * @author mcaikovs
 */
public class OutputFormatterTest {

    OutputFormatter i = new OutputFormatter();

    @Test
    public void testSomeMethod() {
        List<State> states=Stream.of("F", "H", "D", "T", "X","D", "T", "X").map(str->new State(str)).collect(Collectors.toList());
        assertEquals(i.formatOutput(states),"F:1,H:1,D:2,T:2,X:2");        
    }

}
