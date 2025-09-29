
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *Repetir la actividad 2 pero realizando el proceso línea a línea.
 * 
 * Aqui he usado el bufferedWriter por cambiar siendo el printstream mas comodo
 * 
 * @author Andy Jan
 */
public class Ud1Act8 {
    public static void main(String[] args){
        final String ruta = "Ficheros/";

        BufferedReader lector;
        BufferedWriter escritor;
        File directorio = new File(ruta);
        File archivo = new File(directorio, "fic1.txt");
        File copia = new File(directorio, "fic2.txt");

        try {
            lector = new BufferedReader(new FileReader(archivo));
            try {
                
                if (archivo.length() > 0) {
                    escritor = new BufferedWriter(new FileWriter(copia));
                    String linea = lector.readLine();
                    do {
                        escritor.write(linea);
                        escritor.newLine();
                        linea = lector.readLine();
                    } while (linea != null);
                    lector.close();
                    escritor.close();
                    System.out.println("Archivo copiado");
                } else {
                    System.out.println("Archivo original vacio");
                }

            } catch (IOException io) {
                System.out.println("Error con el duplicado");
            }

        } catch (FileNotFoundException fnf) {
            System.out.println("Archivo original no encontrado");
        }
    }
}
