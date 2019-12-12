package main;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import output.OutputFormatter;
import rules.Rule;
import rules.RulesInTextLoader;
import rules.State;
import static utils.Utils.commaSeparatedStringToList;
import static utils.Utils.commaSeparatedStringToSet;

/**
 *
 * @author mcaikovs
 */
public class Main {

    protected List<Rule> getRules() throws IOException {
        return new RulesInTextLoader().getRules();
    }

    protected OutputFormatter getOutput() {
        return new OutputFormatter();
    }

    List<State> convertEachStateToASingleStateFollowingOrderedRules(List<State> states, Set<String> drugs) throws IOException {
        List<Rule> rules = getRules();

        return states.stream().map(state -> {

            for (Rule rule : rules) {
                state = rule.applyRuleToGetNewState(state, drugs);
            }
            return state;
        }
        ).collect(Collectors.toList());
    }

    String formatStatesAfterTreatment(List<State> states, Set<String> drugs) throws IOException {
        return getOutput().formatOutput(convertEachStateToASingleStateFollowingOrderedRules(states, drugs));
    }

    static String parseAndRun(String... args) throws IOException { // isolated for tests

        List<State> states = commaSeparatedStringToList(args[0]).stream().map(stateString -> new State(stateString)).collect(Collectors.toList());

        Set<String> drugs = new HashSet<>();

        if (args.length == 2) {
            drugs = commaSeparatedStringToSet(args[1]);;
        }

        return new Main().formatStatesAfterTreatment(states, drugs);
    }

    public static void main(String... args) throws IOException {

        if (args.length < 1 || args.length > 2) {
            throw new RuntimeException("invalid arguments");
        }
        
        System.out.println(parseAndRun(args));
    }
}
