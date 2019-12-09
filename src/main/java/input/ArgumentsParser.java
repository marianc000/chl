/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import static folder.Constants.COMMA;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author mcaikovs
 */
public class ArgumentsParser {

    Set<String> stringToSet(String str) {
        return new HashSet<>(Arrays.asList(str.split(COMMA)));
    }

    List<PatientWithTreatment> parse(String[] args) {
        Set<String> states = stringToSet(args[0]);
        Set<String> drugs;
        if (args.length > 1) {
            drugs = stringToSet(args[1]);
        } else {
            drugs = new HashSet<>();
        }

        return states.stream().map(state -> new PatientWithTreatment(state, drugs)).collect(Collectors.toList());
    }

}
