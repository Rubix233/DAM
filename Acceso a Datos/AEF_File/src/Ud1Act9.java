
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * Realizar una aplicación Java que añada al fichero copiado anteriormente un *
 * al final.
 *
 * Solucion rapida y sucia, faltan los try catch a la hora de buscar los
 * archivos
 *
 * @author Andy Jan
 */
public class Ud1Act9 {

    public static void main(String[] args) throws IOException {
        final String ruta = "Ficheros/";

        FileWriter escritor;

        File directorio = new File(ruta);
        File archivo = new File(directorio, "fic2.txt");

        if (archivo.exists()) {
            if (archivo.length() > 0) {
                escritor = new FileWriter(archivo, true);

                escritor.append('*');
                escritor.close();
            } else {
                System.out.println("Este archivo aun no tiene nada");
            }
        } else {
            System.out.println("No existe la copia");
        }

    }
}
