
import java.io.BufferedReader;
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
public class Traductor {

    public static void loading() {
        try {
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.println(".");
            Thread.sleep(500);
        } catch (InterruptedException inter) {
            inter.printStackTrace(System.out);
        }
    }

    public static void main(String args[]){

        args = new String[] {"7", "en-es"};
        final String rutaNavegador = "C:\\Archivos de programa\\Internet Explorer\\iexplore.exe";
        //final String rutaNavegador = "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe";
        
        String idioma1, idioma2, frase,continuar;
        int tiempoEspera;
        ProcessBuilder pb = new ProcessBuilder();
        Process navegador;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        if (args.length != 2 || !(args[0].matches("^[0-9]+$")) || !(args[1].toLowerCase().matches("^[a-z]{1,3}-[a-z]{1,3}$"))) {
            System.out.println("Parametros no validos, estableciendo por defecto.");
            loading();
            tiempoEspera = 5;
            idioma1 = "es";
            idioma2 = "en";
            System.out.println("Se ha establecido 5 segundos de espera y los idiomas \"es-en\"");
        } else {
            tiempoEspera = Integer.parseInt(args[0]);
            idioma1 = args[1].split("-")[0];
            idioma2 = args[1].split("-")[1];
            System.out.println("Tiempo de espera: " + tiempoEspera + " segundos, Idiomas: " + args[1]);
        }
        try {
            do {
                System.out.println("Introduzca frase a traducir");
                frase = teclado.readLine();
                pb.command(rutaNavegador, "http://translate.google.es/?sl="
                        +idioma1
                        +"&tl="
                        +idioma2
                        +"&text="
                        +frase
                        +"&op=translate");
                navegador = pb.start();
                Thread.sleep(tiempoEspera*1000);
                navegador.destroy();
                
                do{
                    System.out.println("¿Desea volver a traducir algo? (S/N)");
                    continuar = teclado.readLine().toLowerCase();
                } while (!continuar.matches("[sn]"));
            }while (continuar.equals("s"));       
        }catch(InterruptedException ie){
            System.out.println("Se ha interrumpido el proceso.");
        }catch(IOException ioe){
            System.out.println("Error: " + ioe.getMessage());
        }
    }
}
