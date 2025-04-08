/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejemplo;

/**
 *
 * @author Andy Jan
 */
public class Encargado extends Empleado{
    public Encargado(){
        
    }
    @Override
    public float getSueldo(){
        return super.getSueldo()*1.1f;
    }
}
