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
public class PruebaFicheroShort {
        public static void main(String[] args) {
        FileInputStream fileInput = null;//Nos sirve hasta 255 
        DataInputStream dataInput = null;//Necesario a partir de 255 para poder leer los 4 bytes si o si

        short numeroLeido;
        boolean finFichero = false; //En caso de usar DataInputStream devuelve excepcion y lo controlo con booleano

        try {
            fileInput = new FileInputStream("Ficheros/Naturales500.dat");
            dataInput = new DataInputStream(fileInput);

            numeroLeido = dataInput.readShort();

            while (!finFichero) {
                try {
                    System.out.println(numeroLeido);

                    numeroLeido = dataInput.readShort();
                    
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
