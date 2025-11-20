
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
public class InterruptThred extends Thread{
    
    
    @Override
    public void run(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            System.out.println("Interrupted");
        }
    }
}
