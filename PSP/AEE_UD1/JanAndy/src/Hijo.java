/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Hijo {

    public static void main(String[] args) {
        try {
            Thread.sleep(3000);
            System.out.println("Proceso Hijo terminado");
        } catch (InterruptedException inter) {
            System.out.println("Se ha interrumpido la espera");
        } finally {
            System.exit(2);
        }


    }
}
