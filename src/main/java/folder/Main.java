package folder;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 *
 * @author mcaikovs
 */
public class Main {

    
    
    public static void main(String[] args) throws IOException {
//        if (args.length < 1) {
//            return;
//        }
        args = new String[]{"F", "P"};
        List<PatientWithTreatment> patients = new ArgumentsParser().parse(args);
        List<Rule> rules = new RulesInTextReader().getRules();

//        RuleSummary ruleSummary = new RuleSummary(rules);
//        Set<String> knownDrugs = ruleSummary.getAllDrugs();
//        Set<String> initialStates = ruleSummary.getAllStates();
    }
}
