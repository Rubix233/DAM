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
public class Camion extends Vehiculo{
    private float carga;
    
    public Camion(){
        
    }
    public Camion(String marca, String modelo, 
            GregorianCalendar fechaMatriculacion, String matricula, float carga){
        super(marca,modelo,fechaMatriculacion,matricula);
        this.carga = carga;
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
    public float getCarga(){
        return this.carga;
    }
    public void setCarga(float carga){
        this.carga = carga;
    }
}
