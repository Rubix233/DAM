/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejemplo;

/**
 *
 * @author Andy Jan
 */
public class Empleado extends Persona {
    private float sueldoBase;
    
    public Empleado(){
        
    }
    public float getSueldo(){
        return this.sueldoBase;
    }
    public void setSueldo(float sueldo){
        this.sueldoBase = sueldo;
    }
}
