
import java.io.File;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class PruebaConsola {
    private static void mostrarContenido(String comando, String argumento, String os){
            try {
                if(os.equals("windows")){
                   new ProcessBuilder("CMD","/C",comando,argumento).inheritIO().start(); 
                } else{
                    new ProcessBuilder(comando,argumento).inheritIO().start(); 
                }
            } catch (IOException io) {
                System.out.println("error en el comando");
            }     
    }


    public static void main(String[] args) {
        //args = new String[] {"E:\\PSP\\AEE_UD1\\JanAndy\\Prueba.txt"};
        String listar,mostrar,os;
        File ruta;

        if(System.getProperty("os.name").toLowerCase().contains("win")){
            listar = "DIR";
            mostrar = "TYPE";
            os = "windows";
        } else {
            listar = "ls";
            mostrar = "cat";
            os = "linux";
        }

        if (args.length == 1) {
            ruta = new File(args[0]);
            if(ruta.isDirectory()){
                System.out.println("Es un directorio");
                mostrarContenido( listar, ruta.getAbsolutePath(),os);
            }else{
                System.out.println("Es un archivo");
                mostrarContenido( mostrar, ruta.getAbsolutePath(),os);
            }        
        } else {
            System.out.println("Cantidad de argumenos no validos");
        }
    }
}
