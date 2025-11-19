
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
public class HiloIterador extends Thread {

    int max,contador;

    public HiloIterador(String name, int max) {
        this.setName(name);
        this.max = max;
    }

    @Override
    public void run() {
        try {
            for (contador = 0; contador <= max; contador++) {

                System.out.println(this.getName() + "#" + contador);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloIterador.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(this.getName()+ " ha sido interrumpido por: " + contador);
        }
    }
}
