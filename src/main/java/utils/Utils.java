/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Random;

/**
 *
 * @author mcaikovs
 */
public class Utils {

    static Random rand = new Random();

    public static boolean prognosisFulfilled(int prognosisProbability) {
        return rand.nextInt(prognosisProbability) == 0;
    }

}
