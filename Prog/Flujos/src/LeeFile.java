
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy
 */

/*
 * Leer byte, short, int, long, float, double. Un programa para cada uno
 */
public class LeeFile {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader file = null;

        FileWriter bWriter;
        String linea;

       
        bWriter = new FileWriter("Prueba/Prueba.txt",true);
        bWriter.append("aaa\n");
        bWriter.flush();
        bWriter.append("bbb");
        bWriter.append("ccc");
        bWriter.flush();
        //bWriter.close();
        
        try {
            file = new BufferedReader(new FileReader(("src/ArchivoPrueba.txt").replace('/', File.separatorChar)));
            try {
                while ((linea = file.readLine()) != null) {
                    System.out.println(linea);
                }//Fin mientras
                
            } catch (IOException a) {
                System.err.println("Error de archivo mientras se lee");
            } finally {
                file.close();
                System.out.println("Archivo cerrado");
            }//Fin Try


        } catch (FileNotFoundException e) {
            System.err.println("Error al leer archivo");
        }//Fin Try
        
        
    }
}
