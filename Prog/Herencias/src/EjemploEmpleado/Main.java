/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploEmpleado;

/**
 *
 * @author Andy Jan
 */
public class Main {
    public static void main(String[] args){
        Encargado jose;
        
        jose = new Encargado();
        
        jose.Setnombre("Jose");
        jose.setApellido("Jama");
        jose.setSueldo(10000f);
        
        System.out.println(jose.getNombre());
        System.out.println(jose.getApellido());
        System.out.println(jose.getSueldo());  
    }
}
