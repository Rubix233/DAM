/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploEmpleados2;



/**
 *
 * @author Andy Jan
 */
public class Main {
    public static void main(String[] args){
        Encargado jose;
        
        jose = new Encargado("Jose", "Jama", 1000);
        

        
        System.out.println(jose.getNombre());
        System.out.println(jose.getApellido());
        System.out.println(jose.getSueldo());  
    }
}
