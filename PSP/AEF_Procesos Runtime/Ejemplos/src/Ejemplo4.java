
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy Jan
 */
public class Ejemplo4 {

    public static void main(String[] args) {


        Runtime rt = Runtime.getRuntime();
        Process procesoDate = null;
        BufferedReader lectorProceso = null;
        BufferedReader lectorErrores = null;
        BufferedWriter escritorProceso = null;

        String linea = "";
        String errores = null;
        int procesoTerminado = -1;

        try {
            procesoDate = rt.exec("CMD /C DAT");

            lectorProceso = new BufferedReader(new InputStreamReader(procesoDate.getInputStream()));
            lectorErrores = new BufferedReader(new InputStreamReader(procesoDate.getErrorStream()));
            escritorProceso = new BufferedWriter(new OutputStreamWriter(procesoDate.getOutputStream()));

            //Manda los argumentos y cierra tuberia para poder leer
            try {
                escritorProceso.write("03-03-15");
                escritorProceso.newLine();
                escritorProceso.flush();
                escritorProceso.close();
            } catch (IOException pipe) {
                System.out.println("Tuberia rota");
            }

            //Comprueba que el proceso haya terminado
            try {
                procesoTerminado = procesoDate.waitFor();
            } catch (InterruptedException cortado) {
                System.out.println("El hilo fue interrumpido mientras esperaba al proceso.");
            }


            //Si ha terminado bien lee linea, si no lee errores
            if (procesoTerminado == 0) {
                while ((linea = lectorProceso.readLine()) != null) {
                    System.out.println(linea);
                }
            } else {
                while ((errores = lectorErrores.readLine()) != null) {
                    System.out.println(errores);
                }
            }
            
            //Cerrar tuberias
            lectorErrores.close();
            lectorProceso.close();
        } catch (IOException io) {
            System.out.println("Error al ejecutar comando");
        }
    }
}
