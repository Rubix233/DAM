/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.util.GregorianCalendar;

/**
 *
 * @author Andy Jan
 */
public abstract class Vehiculo {
    private String marca;
    private String modelo;
    private GregorianCalendar fechaMatriculacion;
    private String matricula;
    
    public Vehiculo(){
        
    }
    public Vehiculo(String marca,String modelo, 
            GregorianCalendar fechaMatriculacion, String matricula){
        this.marca = marca;
        this.modelo = modelo;
        this.fechaMatriculacion = fechaMatriculacion;
        this.matricula = matricula;
    }
    public String getMarca(){
        return this.marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public String getModelo(){
        return this.modelo;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public GregorianCalendar getFechaMatriculacion(){
        return this.fechaMatriculacion;
    }
    public void setFechaMatriculacion(GregorianCalendar fechaMatriculacion){
        this.fechaMatriculacion = fechaMatriculacion;
    }
    
    public String getMatricula(){
        return this.matricula;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
}
