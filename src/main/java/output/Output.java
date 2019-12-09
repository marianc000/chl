/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package output;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mcaikovs
 */
public class Output {

    Map<String, Integer> map = new HashMap<>();

    public void addState(String state) {
        Integer count = map.get(state);
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        map.put(state, count);
    }

    public void print() {
        System.out.println(map);
    }
    // order output
}
