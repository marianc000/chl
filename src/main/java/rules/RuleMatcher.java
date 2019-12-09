package rules;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author mcaikovs
 */
public class RuleMatcher {

    List<Rule> rules;

    public RuleMatcher(List<Rule> rules) {
        this.rules = rules;
    }

    public List<Rule> getMatchingRules(Set<String> drugs) {
        return rules.stream().filter(rule -> drugs.containsAll(rule.getDrugs()) || rule.noDrugRule()).collect(Collectors.toList());
    }

}
