/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class PruebaHijo {

    public static void main(String[] args) {
        try {
            Thread.sleep(15000);
            System.out.println("El proceso hijo termina");
        } catch (InterruptedException i) {
            System.out.println("El hilo fue interrumpido mientras esperaba al proceso.");
        }

    }
}
