
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Hacer un programa Java que muestre la siguiente información del fichero
indicado por teclado si existe:
INFORMACIÓN SOBRE EL FICHERO nombre
Ruta relativa:
Ruta absoluta:
Se puede escribir: S/N
Se puede leer: S/N
Tamaño:
Es un directorio /Es un fichero
 * @author Andy Jan
 */
public class Ud1Act1 {
    public static void main(String[] args) throws IOException{
        final String ruta = "Ficheros/";
        
        File archivo = null;       
        File directorio = new File(ruta);
        File[] archivos = directorio.listFiles();
        
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        String introducido;
        
        if(archivos.length > 0){
           System.out.println("Introduzca el nombre del archivo que buscas: ");
            introducido = teclado.readLine(); 
            
            for(File arch : archivos){
                if(arch.getName().equals(introducido)){
                    archivo = arch;
                }
            }
            
            if(archivo != null){
                System.out.println("INFORMACION DEL ARCHIVO");
                System.out.println("-----------------------");
                System.out.println("Ruta relativa: "+archivo.getPath());
                System.out.println("Ruta absoluta: "+archivo.getAbsolutePath());
                System.out.println("Se puede escribir: "+(archivo.canWrite() ? "S" : "N"));
                System.out.println("Se puede escribir: "+(archivo.canRead() ? "S" : "N"));
                System.out.println("Tamaño: "+ archivo.length()+" bytes");
                System.out.println((archivo.isDirectory() ? "Es un directorio" : "Es un archivo"));
            }else{
                System.out.println("No se ha encontrado el archivo que buscas");
            }
            
            
        } else {
            System.out.println("No hay archivos en el directorio " + ruta);
        }
        
        
        
        
    }
}
