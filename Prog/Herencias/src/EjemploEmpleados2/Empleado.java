/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploEmpleados2;



/**
 *
 * @author Andy Jan
 */
public class Empleado extends Persona {
    private float sueldoBase;
    
    public Empleado(){
        
    }
    public Empleado(String nombre, String apellidos,float sueldo){
        super(nombre, apellidos);
        this.sueldoBase = sueldo;
        
    }
    public float getSueldo(){
        return this.sueldoBase;
    }
    public void setSueldo(float sueldo){
        this.sueldoBase = sueldo;
    }
}
