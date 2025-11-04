/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class NombreRegistro {
    String nombre;
    String apellidos;
    float sueldo;
    
    public NombreRegistro(){
        
    }
    public NombreRegistro(String nombre, String apellidos, float sueldo){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sueldo = sueldo;
    }
    
    public String getNombre(){
        return this.nombre.toString();
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getApellido(){
        return this.apellidos.toString();
    }
    public void setApellido(String apellido){
        this.nombre = apellido;
    }
    public float getSueldo(){
        return this.sueldo;
    }
    public void setSueldo(float sueldo){
        this.sueldo = sueldo;
    }
    
    
}
