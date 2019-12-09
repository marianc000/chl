/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import static folder.Constants.COMMA;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author mcaikovs
 */
public class RuleSummary {

    List<Rule> rules;

    public RuleSummary(List<Rule> rules) {
        this.rules = rules;
    }

    Set<String> getAllDrugs() {
        Set<String> drugs = new HashSet<>(); // longest drugs first
        rules.forEach(rule -> {
            String[] drugsInRule = rule.getDrugs().split(COMMA);
            for (String drugInRule : drugsInRule) {
                drugs.add(drugInRule);
            }
        });

        return drugs;
    }

    Set<String> getAllStates() { // assumption is that state is always denote by a single character
        return rules.stream().map(rule -> rule.getInitialState()).collect(Collectors.toSet());
    }
}
