
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
public class Aleatorios {

    public static void main(String[] args) {
        String rutaClases = Aleatorios.class.getResource("").getPath();
        String linea = "n";
        int entradaInt, finalInt;
        BufferedReader teclado, entradaHijo;
        ProcessBuilder builderAleatorio = new ProcessBuilder("java", "-cp", rutaClases, "GeneradorAleatorios");
        Process proceso;

        teclado = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                proceso = builderAleatorio.start();
                entradaHijo = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                entradaInt = Integer.parseInt(entradaHijo.readLine());
                finalInt = proceso.waitFor();

                System.out.println("Entrada: " + entradaInt);
                System.out.println("Valor devuelto: " + finalInt);
                System.out.println("Son iguales? " + (entradaInt == finalInt));
            } catch (IOException io) {
                System.out.println("Error con tuberias");
            } catch (InterruptedException inter) {
                System.out.println("Interrumpido");
            }
            try {
                do {
                    System.out.println("Desea generar otro numero? (S/N)");
                    linea = teclado.readLine().toLowerCase();
                } while (!linea.matches("[sn]"));
            } catch (IOException io) {
                System.out.println("Probelma con teclado");
            }
        } while (linea.equals("s"));
    }
}
