
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Realizar un programa que elimine el directorio proporcionado por teclado si
 * existe o indique no que no existe si es así.
 *
 * @author Andy Jan
 */
public class Ud1Act4 {

    public static void main(String[] args) throws IOException {
        BufferedReader teclado;

        File directorio;
        File[] archivos;

        teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Introduzca el directorio a eliminar relativo a " + System.getProperty("user.dir"));
        directorio = new File(teclado.readLine());
        if (directorio.getName().contains("ab")) {
            System.out.println("Ese no");
        } else {

        }

        if (directorio.exists()) {
            if (directorio.getName().equals("src")) {
                System.out.println("Ese no gañan");
            } else {
                archivos = directorio.listFiles();

                if (archivos.length > 0) {
                    boolean todoArch = true;
                    for (File archivo : archivos) {
                        if (archivo.isDirectory()) {
                            todoArch = false;
                        }
                    }
                    if (todoArch) {
                        for (File archivo : archivos) {
                            archivo.delete();
                        }
                    } else {
                        System.out.println("Este directorio contiene carpetas y no se puede eliminar.");
                    }

                }
                directorio.delete();
                System.out.println("Eliminado");
            }

        } else {
            System.out.println("No existe el directorio.");
        }
    }
}
