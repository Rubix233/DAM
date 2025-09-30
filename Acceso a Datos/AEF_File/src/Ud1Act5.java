
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



/**
 *Crear un fichero de texto con el notepad de nombre Prueba.txt y mediante
una aplicación Java, mostrarlo en pantalla carácter a carácter.
* 
 * @author Andy Jan
 */
public class Ud1Act5 {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        final String ruta = "Ficheros/";
     
        File directorio = new File(ruta);
        File archivo = new File(directorio, "Prueba.txt");  
        
        if(archivo.exists()){
           FileReader lector = new FileReader(archivo);
           if(archivo.canRead()){
               if(archivo.length() > 0){
                   int caracter = lector.read();
                   while(caracter != -1){
                       System.out.println((char)caracter);
                       caracter = lector.read();
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
