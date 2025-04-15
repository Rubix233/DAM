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
public class Especial extends Camion{
    private byte compartimentos;
    
    public Especial(){
        
    }
    public Especial(String marca, String modelo, 
            GregorianCalendar fechaMatriculacion, String matricula, byte compartimentos){
        super(marca,modelo,fechaMatriculacion,matricula, 0f);
        this.compartimentos = compartimentos;
    }
    
    @Override
    public String getMarca(){
        return super.getMarca();
    }
    @Override
    public void setMarca(String marca){
        super.setMarca(marca);
    }
    
    @Override
    public String getModelo(){
        return super.getModelo();
    }
    @Override
    public void setModelo(String modelo){
        super.setModelo(modelo);
    }
    
    @Override
    public GregorianCalendar getFechaMatriculacion(){
        return super.getFechaMatriculacion();
    }
    @Override
    public void setFechaMatriculacion(GregorianCalendar fechaMatriculacion){
        super.setFechaMatriculacion(fechaMatriculacion);
    }
    
    @Override
    public String getMatricula(){
        return super.getMatricula();
    }
    @Override
    public void setMatricula(String matricula){
        super.setMatricula(matricula);
    }
    @Override
    public float getCarga(){
        return super.getCarga()/this.compartimentos;
    }
    @Override
    public void setCarga(float carga){
        super.setCarga(carga);
    }
    public byte getCompartamientos(){
        return this.compartimentos;
    }
    public void setCompartamientos(byte compartimentos){
        this.compartimentos = compartimentos;
    }
    
    public String getDescripcion(){
        return getMarca() + " " + getModelo()+ " " + getCompartamientos();
    }
    
    
}
