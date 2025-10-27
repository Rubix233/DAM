
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Ejemplo2 {
    public static void main(String[] args) throws IOException{
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        Map<String,String> mapaEntorno;
        String lineaPorTeclado, lineaPrograma;  
        
        
        System.out.println("Introduzca tu saludo: ");
        lineaPorTeclado = teclado.readLine();
        
        ProcessBuilder constructorProceso = new ProcessBuilder("java","-cp","E:\\DAM\\PSP\\AEF_ProcessBuilder\\build\\classes","UnSaludo", lineaPorTeclado);
        
        try{
           Process unSaludo = constructorProceso.start(); 
           BufferedReader outputSaludo = new BufferedReader(new InputStreamReader(unSaludo.getInputStream()));
           mapaEntorno = constructorProceso.environment();
           
           System.out.println("Variables de entorno:");
            
           for(Map.Entry<String, String> entry : mapaEntorno.entrySet()){
           System.out.println("Propiedad: "+ entry.getKey() + " -> " + entry.getValue());
           }
           
           //Me he quedado aqui, tengo que sacar la lista de parametros.
           
           while((lineaPrograma = outputSaludo.readLine()) != null){
               System.out.println(lineaPrograma);
           }
        
        }catch (IOException io){
            System.out.println("Err");
        }
        
        
    }
    
    
    
    
    
    
}
