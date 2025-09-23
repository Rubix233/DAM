
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
    public static void main(String[] args){
        File archivo;
        FileReader lector;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        final String ruta = "Ficheros/";
        String introducido;
        
        System.out.println("Introduzca el nombre del archivo que buscas: ");
        
    }
}
