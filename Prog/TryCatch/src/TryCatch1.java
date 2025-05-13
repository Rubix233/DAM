/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class TryCatch1 {
    public static void main(String[] args){
        String[] tabla = new String[] {"12", "20", "8", "18"};
        
        for(String e : tabla){
            System.out.println(Integer.valueOf(e)/2);
        }
        
    }
}
