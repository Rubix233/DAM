/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package documentodat;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author andyj
 */
public class PruebaFichData {
     public static void main(String[] args) {
        FileInputStream fileInput = null;
        DataInputStream dataInput = null;

        String nombreLeido;
        byte edadLeida;
        boolean finFichero = false; 

        try {
            fileInput = new FileInputStream("Ficheros/FichData.dat");
            dataInput = new DataInputStream(fileInput);

            while (!finFichero) {
                try {
                    nombreLeido = dataInput.readUTF();
                    edadLeida = dataInput.readByte();
                    System.out.println(nombreLeido);
                    System.out.println(edadLeida);
                    
                } catch (EOFException eof) {
                    finFichero = true;
                    System.out.println("Fin del archivo");
                }

            }

        } catch (FileNotFoundException fnf) {
            System.out.println("No existe el archivo");
        } catch (IOException io) {
            System.out.println("Paso algo con el disco");
        } finally {
            try {
                if (dataInput != null) {
                    dataInput.close();
                }
                if (fileInput != null) {
                    fileInput.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo.");
            }
        }
    }
}
