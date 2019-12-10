/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import static folder.MyMain.parseAndRun;
import java.io.IOException;
import org.junit.Test;

/**
 *
 * @author mcaikovs
 */
public class MyMainTest {

    MyMain i = new MyMain();

   
    
    @Test
    public void testRun() throws IOException {
//        assertEquals(i.run(new String[]{"F", "P"}), "F:0,H:1,D:0,T:0,X:0");
//        assertEquals(i.run(new String[]{"D,D"}), "F:0,H:0,D:0,T:0,X:2");
//      // my tests 
//        
//        String r = parseAndRun("F", "P");
//        System.out.println(r);
        
        String  r = parseAndRun("H", "P,As");
        System.out.println(r);
    }

}
