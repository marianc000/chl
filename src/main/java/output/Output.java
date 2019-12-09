/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package output;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author mcaikovs
 */
public class Output {

    Map<String, Integer> map = new HashMap<>();
    List<String> format = Arrays.asList("F", "H", "D", "T", "X");

    public void addState(String state) {
        Integer count = map.get(state);
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        map.put(state, count);
    }

    String formatState(String state) {
        return state + ":" + (map.get(state) != null ? map.get(state) : 0);
    }

    public String print() {
        System.out.println(map);
        return format.stream().map(state -> formatState(state)).collect(Collectors.joining(","));
    }

// order output
}
