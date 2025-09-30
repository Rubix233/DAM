
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.PrintWriter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Realizar un programa en Java que cree el directorio NUEVODIR en el directorio
 * actual, con dos ficheros vacíos. A continuación, renombrará uno de ellos.
 *
 * @author Andy Jan
 */
public class Ud1Act3 {

    public static void main(String[] args) throws IOException {

        File archivo1;
        File archivo2;
        File directorio;
        PrintWriter escritor;

        directorio = new File("NUEVODIR");
        directorio.mkdirs();

        archivo1 = new File(directorio, "fichero1.txt");
        archivo2 = new File(directorio, "fichero2.txt");

        if (archivo1.createNewFile()) {
            System.out.println("fichero1.txt creado.");
        } else {
            System.out.println("fichero1.txt ya existe.");
        }
        escritor = new PrintWriter(archivo1);
        escritor.println("Prueba");
        escritor.close();
        
        if (archivo2.createNewFile()) {
            System.out.println("fichero2.txt creado.");
        } else {
            System.out.println("fichero2.txt ya existe.");
        }
        
        if(archivo1.renameTo(new File(directorio, "fichero1Renombrado.txt"))){
            System.out.println("fichero1 renombrado");
        }
        
    }
}
