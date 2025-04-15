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
public class Autobus extends Vehiculo {
    private byte plazas;
    
    public Autobus(){
        
    }
    public Autobus(String marca, String modelo, 
            GregorianCalendar fechaMatriculacion, String matricula, byte plazas){
        super(marca,modelo,fechaMatriculacion,matricula);
        this.plazas = plazas;
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
    public byte getPlazas(){
        return this.plazas;
    }
    public void setPlazas(byte plazas){
        this.plazas = plazas;
    }
}
