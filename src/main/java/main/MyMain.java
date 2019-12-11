package main;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import output.Output;
import rules.Rule;
import rules.RulesInTextReader;
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
//    
//    public String run(List<State> states, Set<String> drugs, List<Rule> rules, Output output) throws IOException {
//        List<State> newStates = convertEachStateToAState(states, drugs, rules);
//    }
////    public String run(List<State> states, Set<String> drugs, List<Rule> rules, Output output) throws IOException {
////        //   System.out.println(">run: states: " + states + "; drugs: " + drugs);
////        states.forEach(state -> {
////            //     System.out.println("state: " + state);
////            State newState = state;
////            for (Rule rule : rules) {
////
////                //        System.out.println("rule: " + rule);
////                newState = rule.getResultingState(newState, drugs);
////                //       System.out.println("newState: " + newState);
////            };
////            output.addState(newState);
////        });
////
////        return output.getOutput();
////    }

    static String parseAndRun(String... args) throws IOException { // isolated for tests

        List<State> states = commaSeparatedStringToList(args[0]).stream().map(stateString -> new State(stateString)).collect(Collectors.toList());
        
        String drugStr = null;
        if (args.length == 2) {
            drugStr = args[1];
        }
        
        Set<String> drugs = commaSeparatedStringToSet(drugStr);
        
        List<Rule> rules = new RulesInTextReader().getRules();
        
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
