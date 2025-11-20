
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class InterruptedMain {
    public static void main(String[] args) {
        InterruptThred it = new InterruptThred();
        
        it.start();
        try {
            Thread.sleep(500);
            it.interrupt();
        } catch (InterruptedException ex) {
            Logger.getLogger(InterruptedMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
