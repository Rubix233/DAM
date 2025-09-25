
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *Repetir la actividad 1pero realizando el proceso línea a línea.
 * 
 * @author Andy Jan
 */
public class Ud1Act7 {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        final String ruta = "Ficheros/";
     
        File directorio = new File(ruta);
        File archivo = new File(directorio, "Prueba.txt");  
        
        if(archivo.exists()){
           BufferedReader lector = new BufferedReader(new FileReader(archivo));
           if(archivo.canRead()){
               if(archivo.length() > 0){
                   String linea = lector.readLine();
                   while(linea != null){//Do while seria mejor pero queria separar la primera lectura
                       System.out.println(linea);
                       linea = lector.readLine();
                   }
                   System.out.println("Fin de archivo");


               } else {
                   System.out.println("El archivo no tiene contenido.");
               }
           } else {
               System.out.println("El archivo no se puede leer.");
           }
           
        } else {
            System.out.println("No se ha encontrado Prueba.txt");
        }
    }
}
