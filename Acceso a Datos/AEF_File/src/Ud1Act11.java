
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * Realizar una aplicación Java que al escribir java more fic.txt muestre el
 * contenido de dicho fichero paginado de 10 en 10 líneas (Pulse intro para
 * continuar).
 *
 * @author Andy Jan
 */
public class Ud1Act11 {

    public static void main(String[] args) {
        final String ruta = "Ficheros/";

        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader lector;
        File directorio = new File(ruta);
        File archivo;

        File[] archivos = directorio.listFiles();

        System.out.println("Selecciona archivo a mostrar: ");
        for (File arch : archivos) {
            if (arch.isFile()) {
                System.out.println(arch.getName());
            }
        }
        System.out.println("*******************************");
        try {
            archivo = new File(directorio, teclado.readLine());
            if (archivo.exists() && archivo.length() > 0) {
                lector = new BufferedReader(new FileReader(archivo));
                String linea = "";
                
                boolean finalizado = false;
                do {
                    linea = lector.readLine();
                    for (int i = 0; i < 10; i++) {
                        if (linea != null) {
                            System.out.println(linea);
                            linea = lector.readLine();
                        } else {
                            System.out.println("Final del documento");
                            finalizado = true;
                            break;
                        }
                    }
                    if(!finalizado){
                        System.out.println("*******************************");
                        System.out.println("Pulsa Intro para continuar");
                        System.out.println("*******************************");
                        teclado.readLine();
                    }

                } while (!finalizado);
            } else {
                System.out.println("Archivo no existe o esta vacio");
            }

        } catch (IOException io) {
            System.out.println("Error de entrada.");
        }

    }
}
