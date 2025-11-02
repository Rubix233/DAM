/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Andy Jan
 */
public class NavegadorWeb {

    private static String normalizarURL(String url) {
        url = url.toLowerCase();
        return (url.matches("^https?://.*")) ? url : ("https://" + url);
    }
    public static void main(String[] args) {

        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String linea;
        ProcessBuilder explore = new ProcessBuilder("explorer", "");

        do {
            System.out.println("Introduce pagina web:");
            try {
                linea = teclado.readLine();
                explore.command().set((explore.command().size() - 1), normalizarURL(linea));
                try {
                    explore.start();
                    Thread.sleep(10000);
                } catch (IOException io) {
                    System.out.println("Error al iniciar navegador");
                } catch (InterruptedException inter) {
                    System.out.println("Se interrumpio al esperar");
                }
            } catch (IOException io) {
                System.out.println("Error con el teclado");
            }
            do {
                System.out.println("Desea continuar? (S/N)");
                try {
                    linea = teclado.readLine();
                } catch (IOException io) {
                    System.out.println("Error con el teclado");
                    linea = "n";
                }
            } while (!linea.toLowerCase().matches("[sn]"));
        } while (linea.equals("s"));
    }
}
