
import java.io.File;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *EjDir realiza el dir>salida.txt creando un fichero salida.log con los posibles errores.
Hacer una prueba sin errores y otra con errores.
 * @author Andy Jan
 */
public class EJDir {
    public static void main(String[] args){
        
        ProcessBuilder dirProceso = new ProcessBuilder("CMD","/C","DIR");
        String salidaRuta = "Salidas/salida.txt";
        String erroresRuta = "Salidas/errores.log";
        
        File salida = new File(salidaRuta.replace("/", File.separator));
        File errores = new File(erroresRuta.replace("/", File.separator));
        
        errores.mkdir();
        
        dirProceso.redirectOutput(salida);
        dirProceso.redirectError(errores);
        
        try{
           dirProceso.start(); 
        }catch (IOException io){
            
        }
        
        
    }
}
