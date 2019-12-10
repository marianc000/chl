/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import static folder.Constants.COMMA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author mcaikovs
 */
public class Utils {

    static Random rand = new Random();

    public static boolean prognosisFulfilled(int prognosisProbability) {
        return rand.nextInt(prognosisProbability) == 0;
    }

    public static Set<String> commaSeparatedStringToSet(String str) {
        return new HashSet<>(Arrays.asList(str.split(COMMA)));
    }

    public static List<String> commaSeparatedStringToList(String str) {
        return Arrays.asList(str.split(COMMA));
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
