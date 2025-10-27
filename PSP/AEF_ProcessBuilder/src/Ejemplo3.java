
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AndyJan
 */
public class Ejemplo3 {
    public static void main(String[] args){
        try{
            new ProcessBuilder("java", "-cp","..\\Pruebas\\build\\classes","AccesoAJVM").inheritIO().start();
            
        } catch (IOException io){
            System.out.println("err");
        }
        
    }
}
