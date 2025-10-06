/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package documentodat;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author andyj
 */
public class DocumentoDAT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FileOutputStream fileOutput = null;//Hasta el 255 (solo mira el ultimo byte)
        DataOutputStream dataOutput = null;//Para mayores de 255 (Mira los 4)
        
        try{
            fileOutput = new FileOutputStream("Ficheros/numeros1.dat");
            dataOutput = new DataOutputStream(fileOutput);
            
            for(int i = 1; i <= 400; i++){
                //fileOutput.write(i);
                dataOutput.writeInt(i);
            }
            
        } catch (FileNotFoundException fnf){
            System.out.println("No se encontro el archivo");
        } catch (IOException io){
            System.out.println("Algo se jodio con el disco");
        } finally {
            try{
                if(fileOutput != null) fileOutput.close();
                if(dataOutput != null) dataOutput.close();
            } catch (IOException io){
                System.out.println("Error al cerrar");
            }
        }
        
        
    }
    
}
