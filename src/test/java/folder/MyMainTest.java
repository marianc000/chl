/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mcaikovs
 */
public class MyMainTest {

    MyMain i = new MyMain();

    @Test
    public void testRun() throws IOException {
        assertEquals(i.run(new String[]{"F", "P"}), "F:0,H:1,D:0,T:0,X:0");
        assertEquals(i.run(new String[]{"D,D"}), "F:0,H:0,D:0,T:0,X:2");
    }

}
