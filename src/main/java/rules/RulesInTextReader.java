/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rules;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import static utils.Utils.commaSeparatedStringToSet;
import static utils.Utils.readTextLinesFromResource;

/**
 *
 * @author mcaikovs
 */
public class RulesInTextReader {

    String RULES_FILE_NAME = "/ruleList";

    List<String> readText() throws IOException {
        List<String> lines = readTextLinesFromResource(RULES_FILE_NAME);
        lines.removeIf(line -> line.startsWith("#") || line.trim().isEmpty());
        return lines;
    }

    Pattern emptySpacePattern = Pattern.compile("[ \\t]+");

    String[] extractParameteresFromLine(String text) {
        return emptySpacePattern.split(text);
    }

    Prognosis extractExpectedStateWithProbability(String str) { // H/1000000 or X
        String[] stateAndProbability = str.split("/");
        if (stateAndProbability.length == 2) {
            return new Prognosis(new State(stateAndProbability[0]), Integer.valueOf(stateAndProbability[1]));
        } else {
            return new Prognosis(new State(stateAndProbability[0]));
        }
    }

    public List<Rule> getRules() throws IOException {
        List<String> rulesLines = readText();
        List<Rule> rules = new LinkedList<>();
        for (String line : rulesLines) {
            String[] params = extractParameteresFromLine(line);
            String initialState = params[0];
            Set<String> drugs = commaSeparatedStringToSet(params[1]);
            Prognosis stateAfterTreatment = extractExpectedStateWithProbability(params[2]); // H/1000000 or X
            Prognosis stateWtithoutTreatment = extractExpectedStateWithProbability(params[3]);
            rules.add(new Rule(
                    new State(initialState),
                    drugs,
                    stateAfterTreatment,
                    stateWtithoutTreatment));
        }
        return rules;
    }
}
