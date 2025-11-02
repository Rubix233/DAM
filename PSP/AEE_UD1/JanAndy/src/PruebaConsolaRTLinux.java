
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
public class PruebaConsolaRTLinux {
    private static void mostrarContenido(String comando, String argumento){
        String lineaProceso;
        BufferedReader procesoEntrada, procesoError;
        
        Runtime rt = Runtime.getRuntime();
            try {
                Process proceso = rt.exec(comando + " " + argumento);
                procesoEntrada = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                procesoError = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));
                try {
                    if ((lineaProceso = procesoError.readLine()) != null) {
                        do {
                            System.out.println(lineaProceso);
                        } while ((lineaProceso = procesoError.readLine()) != null);
                    } else {
                        while ((lineaProceso = procesoEntrada.readLine()) != null) {
                            System.out.println(lineaProceso);
                        }
                    }
                } catch (IOException io) {
                    System.out.println("Error al leer");
                }
            } catch (IOException io) {
                System.out.println("error en el comando");
            }  
    }


    public static void main(String[] args) {
        //args = new String[] {"E:\\PSP\\JanAndy\\Prueba.txt"};
        String listar = "ls";
        String mostrar = "cat";
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
