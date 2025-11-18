
import java.util.Random;
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
public class RetardoThread  extends Thread{
        Random r = new Random();
    int min = 1;
    int max = 2000;
    int generado = min + r.nextInt(max - min + 1);

    @Override
    public void run() {
            try {
                Thread.sleep(generado);
                System.out.println("Hola mundo! Thread "+ Thread.currentThread().getName()+" "+(generado));
            } catch (InterruptedException ex) {
                Logger.getLogger(RetardoThread.class.getName()).log(Level.SEVERE, null, ex);
            }


    }
    
}
