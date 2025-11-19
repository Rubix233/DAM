
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

    public StatusThread() {
    }

    public StatusThread(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        int i = 0;
        try {
            while (!this.isInterrupted() && i < 10000) {

                i++;
                Thread.sleep(1);

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(StatusThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (this.isInterrupted()) {
                System.out.println("El hilo " + this.getName() + " ha sido interrumpido por " + i);
            } else {
                System.out.println("El hilo " + this.getName() + " ha terminado sin interrupciones ");
            }
        }
    }
}
