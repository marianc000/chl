package output;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import rules.State;

/**
 *
 * @author mcaikovs
 */
public class OutputFormatter {

    // It should be a comma separated string with number of patients with a given state, following
    // the format: F:NP,H:NP,D:NP,T:NP,X:NP
    static List<String> formattingTemplate = Arrays.asList("F", "H", "D", "T", "X");

    Map<String, Long> stateCountMap;

    protected List<String> getFormattingTemplate() {
        return formattingTemplate;
    }

    Long getStateCount(String state) {
        return stateCountMap.getOrDefault(state, 0L);
    }

    protected String formatState(String state) {
        return state + ":" + getStateCount(state);
    }

    public String formatOutput(List<State> states) {
        stateCountMap = states.stream().collect(Collectors.groupingBy(state -> state.getStateString(), Collectors.counting()));

        return getFormattingTemplate().stream()
                .map(state -> formatState(state))
                .collect(Collectors.joining(","));
    }
}
