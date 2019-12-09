package folder;

import static folder.Constants.NO_DRUGS;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import output.Output;
import rules.Rule;
import rules.RuleMatcher;
import rules.RulesInTextReader;
import static utils.Utils.commaSeparatedStringToList;
import static utils.Utils.commaSeparatedStringToSet;

/**
 *
 * @author mcaikovs
 */
public class MyMain {

    String run(String[] args) throws IOException {

        List<String> states = commaSeparatedStringToList(args[0]);

        String drugParam = NO_DRUGS;

        if (args.length > 1) {
            drugParam = args[1];
        }

        Set<String> drugs = commaSeparatedStringToSet(drugParam);

        List<Rule> matchingRules = new RuleMatcher(getRules()).getMatchingRules(drugs);

        Output output = new Output();
 
        states.forEach(state -> {
            matchingRules.forEach(rule -> {
                if (rule.isApplicableForState(state)) {
                    output.addState(rule.getResultingState());
                }
            });
        });
        
        return output.print();
    }

    protected List<Rule> getRules() throws IOException {
        return new RulesInTextReader().getRules();
    }

    public static void main(String... args) throws IOException {
//        if (args.length < 1 || args.length > 2) {
//            throw new RuntimeException("invalid arguments");
//        }
        System.out.println(new MyMain().run(args));
    }
}
