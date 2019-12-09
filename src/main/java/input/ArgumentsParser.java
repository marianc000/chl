package input;

 
import static folder.Constants.NO_NEEDED_DRUG;
import java.util.List;
import java.util.Set;
import static utils.Utils.commaSeparatedStringToList;
import static utils.Utils.commaSeparatedStringToSet;

/**
 *
 * @author mcaikovs
 */
public class ArgumentsParser {

    public PatientsAndTreatments parse(String[] args) {
        List<String> states = commaSeparatedStringToList(args[0]);
        
        String drugParam = NO_NEEDED_DRUG;//none

        if (args.length > 1) {
            drugParam = args[1];
        }

        Set<String> drugs = commaSeparatedStringToSet(drugParam);

        return new PatientsAndTreatments(states, drugs);
    }

}
