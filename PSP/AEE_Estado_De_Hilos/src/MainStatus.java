
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
public class MainStatus {

    public static void main(String[] args) {
        StatusThread t1 = new StatusThread("T1");
        
        //Mostramos el estado despues de crearlo pero antes de iniciarlo
        System.out.println("State of " + t1.getName() + ": " + t1.getState().toString());

        //Iniciamos el hilo
        t1.start();
        
        //Mostramos el estado despues de lanzarlo
        System.out.println("State of " + t1.getName() + ": " + t1.getState().toString());

        //Esperamos un poco para que tenga tiempo para ejecutar algo
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }

        //Interrumpimos el hilo
        t1.interrupt();

        //Mostramos el estado justo al interrumpirlo
        System.out.println("State of " + t1.getName() + ": " + t1.getState().toString());

        //Esperamos a que acabe
        try {
            t1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(MainStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Mostramos el estado cuando termine su ejecucion
        System.out.println("State of " + t1.getName() + ": " + t1.getState().toString());
    }
}
