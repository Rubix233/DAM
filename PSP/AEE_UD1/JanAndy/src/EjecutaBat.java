
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AndyJan
 */
public class EjecutaBat {

    public static void main(String[] args) {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String linea;
        File archivoBat, salida, errorBat;
        ProcessBuilder batBuilder;

        try {
            System.out.println("Introduzca BAT que quieras ejecutar: ");
            linea = teclado.readLine();
            archivoBat = new File(linea);

            if (archivoBat.exists()) {
                batBuilder = new ProcessBuilder("CMD", "/C", archivoBat.getAbsolutePath());

                salida = new File(archivoBat.getParent() + File.separator + "salidaBat.txt");
                errorBat = new File(archivoBat.getParent() + File.separator + "errorBat.txt");
                salida.createNewFile();
                errorBat.createNewFile();

                batBuilder.redirectError(errorBat);
                batBuilder.redirectOutput(salida);
                batBuilder.start();
            } else {
                System.out.println("No existe el archivo");
            }
        } catch (IOException io) {
            System.out.println("Error IO");
        }
    }
}
