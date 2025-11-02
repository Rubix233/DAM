
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AndyJan
 */
public class PadreProcesoJava {

    public static void main(String[] args) throws IOException {

        ProcesoJava.exec(P1.class);
        ProcesoJava.exec(P1.class);
        ProcesoJava.exec(P2.class);

        try {
            Thread.sleep(30000);
            System.out.println("Proceso padre terminado");
        } catch (InterruptedException inter) {
            System.out.println("Se ha interrumpido la espera");
        }

    }
}
