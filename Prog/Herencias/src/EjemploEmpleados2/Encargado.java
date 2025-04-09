/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploEmpleados2;



/**
 *
 * @author Andy Jan
 */
public class Encargado extends Empleado{
    public Encargado(){
        
    }
    public Encargado(String nombre, String apellidos, float sueldo){
        super(nombre, apellidos, sueldo);
    }
    @Override
    public float getSueldo(){
        return super.getSueldo()*1.1f;
    }
}
