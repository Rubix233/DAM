/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Empleado {
    private String nombre;
    private String apellidos;
    private short departamento;
    private byte seccion;
    private float sueldo;
    
    public void Empleado(){
        
    }
    public void Empleado(String nom, String ape, short dep,byte seccion, float sueldo){
        this.nombre = nom;
        this.apellidos = ape;
        this.departamento = dep;
        this.seccion = seccion;
        this.sueldo = sueldo;
    }
    
    public String getNombreCompleto(){
        return this.nombre +" "+ this.apellidos;
    }
    public void setNombreCompleto(String nom, String ape){
        this.nombre = nom;
        this.apellidos = ape;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nom){
        this.nombre = nom;
    }
    
    public String getApellidos(){
        return this.apellidos;
    }
    public void setApellidos(String ape){
        this.apellidos = ape;
    }
    
    public short getDepart(){
        return this.departamento;
    }
    public void setDepart(short dep){
        this.departamento = dep;
    }
    
    public byte getSeccion(){
        return this.seccion;
    }
    public void setSeccion(byte seccion){
        this.seccion = seccion;
    }
    
    public float getSueldo(){
        return this.sueldo;
    }
    public void setSueldo(float sueldo){
        this.sueldo = sueldo;
    }
    
    public String mostrarDatos(){
        return "Nombre completo: "+this.nombre+" "+this.apellidos+
                "\nDep: "+this.departamento+" |Seccion:  "+this.seccion+
                "\nSueldo:"+this.sueldo;
    }
    public void copia(Empleado origen){
        this.nombre = origen.nombre;
        this.departamento = origen.departamento;
        this.seccion = origen.seccion;
        this.sueldo = origen.sueldo;
    }
}
