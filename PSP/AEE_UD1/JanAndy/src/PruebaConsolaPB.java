
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class PruebaConsolaPB {
    private static void mostrarContenido(String comando, String argumento){
            try {
                new ProcessBuilder("CMD","/C",comando,argumento).inheritIO().start();

            } catch (IOException io) {
                System.out.println("error en el comando");
            }     
    }


    public static void main(String[] args) {
        //args = new String[] {"E:\\PSP\\JanAndy\\Prueba.txt"};
        String listar = "DIR";
        String mostrar = "TYPE";
        File ruta;

        if (args.length == 1) {
            ruta = new File(args[0]);
            if(ruta.isDirectory()){
                System.out.println("Es un directorio");
                mostrarContenido( listar, ruta.getAbsolutePath());
            }else{
                System.out.println("Es un archivo");
                mostrarContenido( mostrar, ruta.getAbsolutePath());
            }        
        } else {
            System.out.println("Cantidad de argumenos no validos");
        }

    }
}
