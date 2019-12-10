package folder;

import static folder.Constants.COMMA;
import static folder.Constants.NO_DRUGS;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import output.Output;
import rules.Rule;
import rules.RuleMatcher;
import rules.RulesInTextReader;
import rules.State;
import static utils.Utils.commaSeparatedStringToList;
import static utils.Utils.commaSeparatedStringToSet;

/**
 *
 * @author mcaikovs
 */
public class MyMain {

    public String run(List<State> states, Set<String> drugs, List<Rule> rules, Output output) throws IOException {
        System.out.println(">run: states: " + states + "; drugs: " + drugs);
        states.forEach(state -> {
            System.out.println("state: " + state);
            State newState = state;
            for (Rule rule : rules) {

                System.out.println("rule: " + rule);
                newState = rule.getResultingState(newState, drugs);
                System.out.println("newState: " + newState);
            };
            output.addState(newState);
        });

        return output.getOutput();
    }

    static String parseAndRun(String... args) throws IOException {
        if (args.length < 1 || args.length > 2) {
            throw new RuntimeException("invalid arguments");
        }

        List<State> states = Arrays.stream(args[0].split(COMMA)).map(stateStr -> new State(stateStr)).collect(Collectors.toList());
        Set<String> drugs = new HashSet<>();

        if (args.length == 2) {
            drugs = commaSeparatedStringToSet(args[1]);
        }

        List<Rule> rules = new RulesInTextReader().getRules();

        return new MyMain().run(states, drugs, rules, new Output());
    }

    public static void main(String... args) throws IOException {
        System.out.println(parseAndRun(args));
    }
}
