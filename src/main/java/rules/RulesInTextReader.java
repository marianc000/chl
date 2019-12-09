/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rules;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author mcaikovs
 */
public class RulesInTextReader {

    String RULES_FILE_NAME = "/rules";

    List<String> readText() throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(RULES_FILE_NAME)))) {
            List<String> lines = new LinkedList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#") || line.trim().isEmpty()) {
                    continue;
                }
                lines.add(line);

            }

            return lines;
        }
    }

    Pattern emptySpacePattern = Pattern.compile("[ \\t]+");

    String[] extractParameteresFromLine(String text) {
        return emptySpacePattern.split(text);
    }

    public List<Rule> getRules() throws IOException {
        List<String> rulesLines = readText();
        List<Rule> rules = new LinkedList<>();
        for (String line : rulesLines) {   
            String[] params = extractParameteresFromLine(line);
            rules.add(new Rule(params[0], params[1], params[2], Integer.valueOf(params[3])));
        }
        return rules;
    }
}
