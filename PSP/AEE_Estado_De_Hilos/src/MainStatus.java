
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
        StatusThread t2 = new StatusThread("T2", t1);

        //Mostramos el estado despues de crearlo pero antes de iniciarlo
        System.out.println("State of " + t2.getName() + ": " + t2.getState().toString());

        //Iniciamos el hilo
        t1.start();
        t2.start();

        //Mostramos el estado despues de lanzarlo
        System.out.println("State of " + t2.getName() + ": " + t2.getState().toString());

        //Esperamos un poco para que tenga tiempo para ejecutar algo
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }

        //Interrumpimos el hilo
        t2.interrupt();

        //Mostramos el estado justo al interrumpirlo
        System.out.println("State of " + t2.getName() + ": " + t2.getState().toString());

        //Esperamos ligeramente para que se pueda ejecutar el finally de t2
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        
        //Mostramos estado despues del finally de t2
        System.out.println("State of " + t2.getName() + ": " + t2.getState().toString());
        
        //Esperamos a que acabe t1 al que esta tambien esperando t2
        try {

            t1.join();

        } catch (InterruptedException ex) {
            Logger.getLogger(MainStatus.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Mostramos el estado cuando t1 termine su ejecucion
        System.out.println("State of " + t2.getName() + ": " + t2.getState().toString());
        
        //Damos un poco de tiempo para que t2 termine su Finally
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        //Mostramos su estado cuando haya acabado
        System.out.println("State of " + t2.getName() + ": " + t2.getState().toString());
        
        
        /*
         * T2 solo se muestra como bloqueado si cuando termine T1 el micro se le asigna primero al main. 
         * En este caso T1 ha terminado por lo tanto T2 ya no esta esperando pero como se apropia el main
         * del micro T2 esta en bloqueado mientras espera a su turno para el micro para poder finalizarse
         */
    }
}
