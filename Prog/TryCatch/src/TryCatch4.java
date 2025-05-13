/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class TryCatch4 {
    public static void main(String[] args){
        String[] tabla = new String[] {"12", "m", "8", "18"};
        
        for(String e : tabla){
            try{
                System.out.println(Integer.valueOf(e)/2);
            } catch (NumberFormatException a){
                System.out.println("No es un numero");
            }
            
        }
    }
}
