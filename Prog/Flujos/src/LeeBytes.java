
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy
 */
public class LeeBytes {
    public static void main(String[] args){
        int c;
        int contador = 0;
        
        try{
            c = System.in.read();
            while(c != '\n'){
                contador++;
                System.out.print((char)c);
                c = System.in.read();
            }
            System.out.println();
            System.out.println("Contador " + contador + " Bytes en total");
        } catch(IOException a){
            System.out.println("Error");
        }
        
        
        
    }
}
