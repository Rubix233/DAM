
import java.io.File;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Prueba {
    public static void main(String[] args) {
        String ruta = ".\\build\\classes";//Paths.get("").toAbsolutePath().toString();
        File directorio = new File(ruta);
        File [] archivos = directorio.listFiles();
        
        for(File arch : archivos){
           System.out.println(arch.getName()); 
        }
        

    }
}
