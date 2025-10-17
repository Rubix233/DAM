
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy Jan
 */
public class Ejemplo2 {

    public static void main(String[] args) {
        BufferedReader lectorPrograma = null;


        String rutaClases = "..\\Pruebas\\build\\classes";
        String rutaJava = "..\\Pruebas\\src\\AccesoAJVM.java";
        String nombreCompilado = "AccesoAJVM";
        String[] compilar = {"javac", "-d"};
        String[] ejecutar = {"java", "-cp"};
        String linea = "";

        int salidaP1;

        ProcessBuilder compilador = new ProcessBuilder(compilar[0], compilar[1], rutaClases, rutaJava);
        ProcessBuilder ejecutor = new ProcessBuilder(ejecutar[0], ejecutar[1], rutaClases, nombreCompilado);

        Process proceso1 = null;
        Process proceso2 = null;

        try {
            proceso1 = compilador.start();
            salidaP1 = proceso1.waitFor();
            if (salidaP1 != 0) {
                System.out.println("Error al compilar");
            } else {
                proceso2 = ejecutor.start();
                lectorPrograma = new BufferedReader(new InputStreamReader(proceso2.getInputStream()));
                linea = lectorPrograma.readLine();
                while (linea != null) {
                    System.out.println(linea);
                    linea = lectorPrograma.readLine();
                }

            }
        } catch (IOException io){
            System.out.println("Problema entrada-salida");
        } catch (InterruptedException interrumpido){
            System.out.println("Interrumpido en proceso");
        }

    }
}
