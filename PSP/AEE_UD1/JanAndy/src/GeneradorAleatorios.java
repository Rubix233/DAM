
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AndyJan
 */
public class GeneradorAleatorios {
    public static void main(String[] args){
         Random r = new Random();
         int min = 0;
         int max = 10;
         int generado = min+r.nextInt(max-min+1);
         System.out.println(generado);
         System.exit(generado);
     }
}
