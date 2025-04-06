/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Persona {
    
    private String nombre;
    private String direccion;
    private long telefono;
    
    public Persona(){
        
    }
    public Persona(String nom, String dir, long tel){
        this.nombre = nom;
        this.direccion = dir;
        this.telefono = tel;
    }
    
    public void asignarNombre(String nom){
        this.nombre = nom;
    }
    public String obtenerNombre(){
        return this.nombre;
    }
    public void asignarDireccion(String dir){
        this.direccion = dir;
    }
    public String obtenerDireccion(){
        return this.direccion;
    }
    public void asignarTelefono(long tel){
        this.telefono = tel;
    }
    public long obtenerTelefono(){
        return this.telefono;
    }

}
