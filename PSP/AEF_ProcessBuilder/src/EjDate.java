
import java.io.File;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *realiza la ejecución de DATE, tomando la nueva fecha de un fichero de texto
llamado fecha.txt.
 * @author Andy Jan
 */
public class EjDate {
    public static void main(String[] args){
        
        String rutaArchivo = "Entradas/Fechas.txt";
        
        File archivoFecha = new File(rutaArchivo.replace("/", File.separator));
        
        ProcessBuilder procesoDate = new ProcessBuilder("CMD", "/C", "DATE");
        
        procesoDate.redirectInput(archivoFecha);
        procesoDate.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        try{
            procesoDate.start();
        }catch(IOException io){
            
        }
        
        
    }
}
