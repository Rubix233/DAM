
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
public class Ejemplo6 {

    public static void main(String[] args) {

        BufferedReader lectorPrograma = null;
        BufferedReader lectorError = null;


        String rutaClases = ".\\build\\classes";
        String rutaJava = ".\\src\\PruebaHijo.java";
        String nombreCompilado = "PruebaHijo";
        String[] ejecutar = {"java", "-cp"};
        String linea = "";

        int salidaP1;

        Process proceso1 = null;

        try {
            proceso1 = Runtime.getRuntime().exec(ejecutar[0] + " " + ejecutar[1] + " " + rutaClases + " " + nombreCompilado);
            
            lectorPrograma = new BufferedReader(new InputStreamReader(proceso1.getInputStream()));
            lectorError = new BufferedReader(new InputStreamReader(proceso1.getErrorStream()));
            salidaP1 = proceso1.waitFor();

            if (salidaP1 == 0) {
                while ((linea = lectorPrograma.readLine()) != null) {
                    System.out.print("“Padre --> Comando: java PruebaHijo devuelve -> ");
                    System.out.println(linea);
                }
            } else {
                while ((linea = lectorError.readLine()) != null) {
                    System.out.println(linea);
                }
            }
            lectorPrograma.close();
            lectorError.close();
        } catch (IOException io) {
            System.out.println("Problema entrada-salida");
        } catch (InterruptedException interrumpido) {
            System.out.println("Interrumpido en proceso");
        }

    }
}
