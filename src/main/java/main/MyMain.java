package main;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import output.Output;
import rules.Rule;
import rules.RulesInTextLoader;
import rules.State;
import static utils.Utils.commaSeparatedStringToList;
import static utils.Utils.commaSeparatedStringToSet;

/**
 *
 * @author mcaikovs
 */
public class MyMain {

    List<State> convertEachStateToAState(List<State> states, Set<String> drugs, List<Rule> rules) {
        //   System.out.println(">run: states: " + states + "; drugs: " + drugs);
        return states.stream().map(state -> {

            for (Rule rule : rules) {
                state = rule.applyRuleToGetNewState(state, drugs);
            }
            return state;
        }
        ).collect(Collectors.toList());
    }

    static String parseAndRun(String... args) throws IOException { // isolated for tests

        List<State> states = commaSeparatedStringToList(args[0]).stream().map(stateString -> new State(stateString)).collect(Collectors.toList());

        String drugStr = null;
        if (args.length == 2) {
            drugStr = args[1];
        }

        Set<String> drugs = commaSeparatedStringToSet(drugStr);

        List<Rule> rules = new RulesInTextLoader().getRules();

        List<State> newStates = new MyMain().convertEachStateToAState(states, drugs, rules);

        return new Output().formatOutput(newStates);
    }

    public static void main(String... args) throws IOException {

        if (args.length < 1 || args.length > 2) {
            throw new RuntimeException("invalid arguments");
        }
        System.out.println(parseAndRun(args));
    }
}
