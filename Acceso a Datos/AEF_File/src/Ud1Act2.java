
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Mostrar la lista de los archivos contenidos en el directorio indicado por
 * teclado. (Esto segunda parte) Mostrando el nombre seguido del tamaño del
 * archivo si se trata de un fichero, o de la cadena “<dir>”, si se trata de un
 * directorio.
 *
 * @author Andy Jan
 */
public class Ud1Act2 {

    public static void main(String[] args) throws IOException {
        BufferedReader teclado;
        File directorio;
        String introducido;
        File[] archivos;

        teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduzca directorio a buscar relativo a " + System.getProperty("user.dir"));
        introducido = teclado.readLine();

        directorio = new File(introducido);
        archivos = directorio.listFiles();
        if (directorio.exists()) {
            if (archivos.length > 0) {
                for (File archivo : archivos) {
                    System.out.println(archivo.getName()+ "\t" + (archivo.isDirectory() ? "<Dir>" : archivo.length() + " bytes"));
                }
            } else {
                System.out.println("Directorio vacio.");
            }
        } else {
            System.out.println("Directorio no existe");
        }

    }
}
