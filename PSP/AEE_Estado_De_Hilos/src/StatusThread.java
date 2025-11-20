
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
public class StatusThread extends Thread {
    Thread t = null;
    boolean haSidoInterrumpido = false;
    
    public StatusThread() {
    }

    public StatusThread(String name) {
        this.setName(name);
    }
    public StatusThread(String name, Thread t) {
        this.setName(name);
        this.t = t;
    }

    @Override
    public void run() {
        int i = 0;
        try {
            while (i < 10000) {

                i++;
                Thread.sleep(1);

            }
        } catch (InterruptedException ex) {
            System.out.println("El hilo " + this.getName() + " ha sido interrumpido por " + i);
            haSidoInterrumpido = true;
        } finally {
            try {
                if (!haSidoInterrumpido) {
                    System.out.println("El hilo " + this.getName() + " ha terminado sin interrupciones ");
                }
                if(t != null)t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(StatusThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
