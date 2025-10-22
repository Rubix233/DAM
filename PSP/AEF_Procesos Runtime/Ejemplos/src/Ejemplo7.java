
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
public class Ejemplo7 {
    public static void main(String[] args) throws IOException{
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader entradaProceso;
        BufferedReader errorProceso;
        Process procesoDir;
        Runtime rt = Runtime.getRuntime();
        
        String lineaTeclado = "";
        String lineaProceso = null;
        System.out.println("Te encuentras en " + new File(".").getAbsolutePath());
        System.out.println("Introduzca el directorio que quieras ver o nada si quieres ver este: ");
        try{
            lineaTeclado = teclado.readLine();
            if(lineaTeclado != ""){
                procesoDir = rt.exec("CMD /C DIR " + lineaTeclado);
            } else {
                procesoDir = rt.exec("CMD /C DIR");
            }
            entradaProceso = new BufferedReader(new InputStreamReader(procesoDir.getInputStream()));
            errorProceso = new BufferedReader(new InputStreamReader(procesoDir.getErrorStream()));
            
            if((lineaProceso = errorProceso.readLine())!= null){
                do{
                    System.out.println(lineaProceso);
                } while ((lineaProceso = errorProceso.readLine())!= null);
            } else {
                while((lineaProceso = entradaProceso.readLine()) != null){
                    System.out.println(lineaProceso);
                }
            }
            
        } catch (IOException io){
            System.out.println("No se encuentra teclado");
        }
        
        
        
        
    }
}
