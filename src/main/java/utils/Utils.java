package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author mcaikovs
 */
public class Utils {

    public static List<String> commaSeparatedStringToList(String str) {
        return Arrays.asList(str.split(","));
    }

    public static Set<String> commaSeparatedStringToSet(String str) {
        return new HashSet<>(commaSeparatedStringToList(str));
    }

    public static List<String> readTextLinesFromResource(String fileName) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Utils.class.getResourceAsStream(fileName)))) {
            List<String> lines = new LinkedList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            return lines;
        }
    }
}
