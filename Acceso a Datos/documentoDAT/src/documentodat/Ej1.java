/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package documentodat;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author andyj
 */
public class Ej1 {
     public static void main(String[] args) {
        
        FileOutputStream fileOutput = null;

        
        try{
            fileOutput = new FileOutputStream("Ficheros/Naturales100.dat");
            
            for(byte i = 1; i <= 100; i++){
                fileOutput.write(i);
            }
            
        } catch (FileNotFoundException fnf){
            System.out.println("No se encontro el archivo");
        } catch (IOException io){
            System.out.println("Algo se jodio con el disco");
        } finally {
            try{
                if(fileOutput != null) fileOutput.close();
            } catch (IOException io){
                System.out.println("Error al cerrar");
            }
        }
        
        
    }
}
