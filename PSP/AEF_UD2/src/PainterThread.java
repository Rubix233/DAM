/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class PainterThread extends Thread{

    String mensaje;

    public PainterThread(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(mensaje);
            Thread.yield();
        }
    }
}
