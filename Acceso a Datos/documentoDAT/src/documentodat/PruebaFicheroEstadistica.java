/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package documentodat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author andyj
 */
public class PruebaFicheroEstadistica {
      public static void main(String[] args) {
        FileInputStream fileInput = null;

        byte numeroLeido;
        byte numeroActual = 1;

        try {
            fileInput = new FileInputStream("Ficheros/Frecuencia.dat");

            numeroLeido = (byte) fileInput.read();
            while (numeroLeido != -1){
                    System.out.print("" + numeroActual + " => ");
                    System.out.println(numeroLeido);
                    numeroLeido = (byte) fileInput.read();
                    numeroActual++;
            }
            if(numeroLeido == -1) System.out.println("Fin del archivo");

        } catch (FileNotFoundException fnf) {
            System.out.println("No existe el archivo");
        } catch (IOException io) {
            System.out.println("Paso algo con el disco");
        } finally {
            try {
                if (fileInput != null) fileInput.close();

            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo.");
            }
        }
    }
}
