
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy Jan
 */
public class Padre {

    public static void main(String[] args) {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String linea = "n";
        String rutaClases = Padre.class.getResource("").getPath();
        ProcessBuilder hijoBuilder = new ProcessBuilder("java", "-cp", rutaClases, "Hijo");
        hijoBuilder.inheritIO();
        do {
            try {
                System.out.println("--------------Iniciando proceso hijo------------");
                Process pro = hijoBuilder.start();
                System.out.println("Valor de salida => " + pro.waitFor());
            } catch (IOException io) {
                System.out.println("No se ha encontrado");
            } catch (InterruptedException inter) {
                System.out.println("interrumpido");
            }
            try {
                do {
                    System.out.println("Desea ejecutar de nuevo? (S/N)");
                    linea = teclado.readLine().toLowerCase();
                } while (!linea.matches("[sn]"));
            } catch (IOException io) {
                System.out.println("Probelma con teclado");
            }
        } while (linea.equals("s"));
    }
}
