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
    public double dolaresToEuros(double euros){
        return euros * this.importeCambio;
    }
    public double eurosToDolares(double dolares){
        return dolares * 1/this.importeCambio;
    }
}
