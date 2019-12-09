package folder;

import input.ArgumentsParser;
import input.PatientsAndTreatments;
import java.io.IOException;
import java.util.List;
import output.Output;
import rules.Rule;
import rules.RuleMatcher;
import rules.RulesInTextReader;

/**
 *
 * @author mcaikovs
 */
public class Main {

    public static void main(String[] args) throws IOException {
//        if (args.length < 1||args.length>2) {
//throw new RuntimeException("invalid arguments");
//        }

        args = new String[]{"F", "P"};
        
        PatientsAndTreatments input = new ArgumentsParser().parse(args);

        List<Rule> rules = new RulesInTextReader().getRules();

        List<Rule> matchingRules = new RuleMatcher(rules).getMatchingRules(input.getDrugs());
        
        Output output = new Output();

        for (String state : input.getStates()) {
            for (Rule rule : matchingRules) {
                if (rule.isApplicableForState(state)){
                    output.addState(rule.getResultingState());
                }
            }
        }

//        RuleSummary ruleSummary = new RuleSummary(rules);
//        Set<String> knownDrugs = ruleSummary.getAllDrugs();
//        Set<String> initialStates = ruleSummary.getAllStates();
        output.print();
    }
}
