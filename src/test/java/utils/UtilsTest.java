/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static utils.Utils.prognosisFulfilled;

/**
 *
 * @author mcaikovs
 */
public class UtilsTest {

    public UtilsTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    public int executeTimes(int probability, int times) {
        int r = 0;
        for (int i = 0; i < times; i++) {
            if (prognosisFulfilled(probability)) {
                r++;
            }
        }
        return r;
    }

    @Test
    public void testprognosisFulfilled() {

        int r = executeTimes(1, 100);
        assertEquals(r, 100);

        r = executeTimes(1000, 5000);
        System.out.println(r);
        assertTrue(r < 10 && r > 0);

    }

}
