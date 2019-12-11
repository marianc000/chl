package output;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import rules.State;

/**
 *
 * @author mcaikovs
 */
public class Output_1 {

    Map<String, Integer> map = new HashMap<>();
    // It should be a comma separated string with number of patients with a given state, following
    // the format: F:NP,H:NP,D:NP,T:NP,X:NP

    List<String> format = Arrays.asList("F", "H", "D", "T", "X");

    void addState(State state) {
        String stateString = state.getStateString();
        Integer count = map.get(stateString);
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        map.put(stateString, count);
    }

   void addStates(List<State> newStates) {
        newStates.forEach(state -> {
            addState(state);
        });
    }

    String formatState(String state) {
        return state + ":" + (map.get(state) != null ? map.get(state) : 0);
    }

    public String getOutput(List<State> newStates) {
        return format.stream().map(state -> formatState(state)).collect(Collectors.joining(","));
    }
}
