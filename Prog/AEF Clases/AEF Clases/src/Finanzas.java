/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Finanzas {
    private double importeCambio = 1.37;
    
    
    public Finanzas(){
        
    }
    public Finanzas(double valorEur){
        this.importeCambio = valorEur;
    }
    public double dolaresToEuros(double dolares){
        return dolares * this.importeCambio;
    }
    public double eurosToDolares(double euros){
        return euros * 1/this.importeCambio;
    }
}
