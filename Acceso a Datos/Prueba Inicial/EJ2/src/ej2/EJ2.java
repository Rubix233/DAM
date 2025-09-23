/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ej2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author Administrador
 */
public class EJ2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File archivo = new File("../EJ1/src/Ficheros/muestra.txt");
        
        
        if(archivo.exists()){
            PrintStream escritor = new PrintStream(new FileOutputStream(archivo,true));;
            escritor.println("Fin");
            System.out.println("Done");
        } else { 
            System.out.println("No se encuentra el archivo");
        }     
        
    }
}
