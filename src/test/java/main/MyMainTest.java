/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import static main.MyMain.parseAndRun;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author mcaikovs
 */
public class MyMainTest {

    MyMain i = new MyMain();

    @Test
    public void testRun() throws IOException {
        assertEquals(parseAndRun("F", "P"), "F:0,H:1,D:0,T:0,X:0");
        assertEquals(parseAndRun("H,H,H"), "F:0,H:3,D:0,T:0,X:0");

        assertEquals(parseAndRun("D,D"), "F:0,H:0,D:0,T:0,X:2");
        assertEquals(parseAndRun("H,H,D,T,X,F,F", "P,As"), "F:0,H:0,D:0,T:0,X:7");
        assertEquals(parseAndRun("F,F,F", "P,P"), "F:0,H:3,D:0,T:0,X:0");
        assertEquals(parseAndRun("D,F,H", "An,P"), "F:0,H:2,D:0,T:0,X:1");
        assertEquals(parseAndRun("D,F,F"), "F:2,H:0,D:0,T:0,X:1");
        assertEquals(parseAndRun("D,F,F", "I"), "F:2,H:0,D:1,T:0,X:0");

        assertEquals(parseAndRun("F", "As"), "F:0,H:1,D:0,T:0,X:0");
        assertEquals(parseAndRun("F"), "F:1,H:0,D:0,T:0,X:0");
        assertEquals(parseAndRun("F", "An"), "F:1,H:0,D:0,T:0,X:0");
        assertEquals(parseAndRun("T", "As"), "F:0,H:0,D:0,T:1,X:0");
        assertEquals(parseAndRun("T,H", "An"), "F:0,H:2,D:0,T:0,X:0");

        assertEquals(parseAndRun("F", "P"), "F:0,H:1,D:0,T:0,X:0");
        assertEquals(parseAndRun("F"), "F:1,H:0,D:0,T:0,X:0");
        assertEquals(parseAndRun("F", "I"), "F:1,H:0,D:0,T:0,X:0");
        assertEquals(parseAndRun("T", "P"), "F:0,H:0,D:0,T:1,X:0");
        assertEquals(parseAndRun("T,T", "P"), "F:0,H:0,D:0,T:2,X:0");

        assertEquals(parseAndRun("T", "An"), "F:0,H:1,D:0,T:0,X:0");
        assertEquals(parseAndRun("T"), "F:0,H:0,D:0,T:1,X:0");
        assertEquals(parseAndRun("T", "As"), "F:0,H:0,D:0,T:1,X:0");
        assertEquals(parseAndRun("D,T,H", "An,I"), "F:2,H:0,D:1,T:0,X:0");
        assertEquals(parseAndRun("D,F,X", "As"), "F:0,H:1,D:0,T:0,X:2");

        assertEquals(parseAndRun("D", "I"), "F:0,H:0,D:1,T:0,X:0");
        assertEquals(parseAndRun("D"), "F:0,H:0,D:0,T:0,X:1");
        assertEquals(parseAndRun("D", "As"), "F:0,H:0,D:0,T:0,X:1");
        assertEquals(parseAndRun("X", "I"), "F:0,H:0,D:0,T:0,X:1");
        assertEquals(parseAndRun("X", "As"), "F:0,H:0,D:0,T:0,X:1");

        assertEquals(parseAndRun("H", "I,An"), "F:1,H:0,D:0,T:0,X:0");
        assertEquals(parseAndRun("D", "I,An"), "F:0,H:0,D:1,T:0,X:0");
        assertEquals(parseAndRun("T", "I,An"), "F:1,H:0,D:0,T:0,X:0");
        assertEquals(parseAndRun("X", "I,An"), "F:0,H:0,D:0,T:0,X:1");
        assertEquals(parseAndRun("H"), "F:0,H:1,D:0,T:0,X:0");
        assertEquals(parseAndRun("H", "As"), "F:0,H:1,D:0,T:0,X:0");

        assertEquals(parseAndRun("H", "P,As"), "F:0,H:0,D:0,T:0,X:1");
        assertEquals(parseAndRun("F", "P,As"), "F:0,H:0,D:0,T:0,X:1");
        assertEquals(parseAndRun("T", "P,As"), "F:0,H:0,D:0,T:0,X:1");
        assertEquals(parseAndRun("D", "P,As"), "F:0,H:0,D:0,T:0,X:1");
        assertEquals(parseAndRun("X", "P,As"), "F:0,H:0,D:0,T:0,X:1");
        assertEquals(parseAndRun("H"), "F:0,H:1,D:0,T:0,X:0");
        assertEquals(parseAndRun("F"), "F:1,H:0,D:0,T:0,X:0");
        assertEquals(parseAndRun("T"), "F:0,H:0,D:0,T:1,X:0");
        assertEquals(parseAndRun("D,H,Y,C,V"), "F:0,H:1,D:0,T:0,X:1");
        assertEquals(parseAndRun("X"), "F:0,H:0,D:0,T:0,X:1");

        assertEquals(parseAndRun("X"), "F:0,H:0,D:0,T:0,X:1");
        assertEquals(parseAndRun("X", "As"), "F:0,H:0,D:0,T:0,X:1");
        assertEquals(parseAndRun("X", "An"), "F:0,H:0,D:0,T:0,X:1");
        assertEquals(parseAndRun("T", "As"), "F:0,H:0,D:0,T:1,X:0");
        assertEquals(parseAndRun("F,H,D,T,X,Z,C,M", "An,As,I,P"), "F:0,H:0,D:0,T:0,X:8");
        assertEquals(parseAndRun("F,H,D,T", "An,As,I"), "F:3,H:0,D:1,T:0,X:0");
    }

}
