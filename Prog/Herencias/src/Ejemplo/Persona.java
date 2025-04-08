/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejemplo;

/**
 *
 * @author Andy Jan
 */
public class Persona {
    private String nombre;
    private String apellido;
    
    
    
    public Persona(){
        
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public void Setnombre(String nom){
        this.nombre = nom;
    }
    
    public String getApellido(){
        return this.apellido;
    }
    public void setApellido(String ape){
        this.apellido = ape;
    }
}
