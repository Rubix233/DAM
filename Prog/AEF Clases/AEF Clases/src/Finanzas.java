/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Finanzas {
    private static double importeCambio = 1.37;
    
    
    public Finanzas(){
        
    }
    public Finanzas(double valorEur){
        Finanzas.importeCambio = valorEur;
    }
    public double dolaresToEuros(double euros){
        return euros * Finanzas.importeCambio;
    }
    public double eurosToDolares(double dolares){
        return dolares * 1/Finanzas.importeCambio;
    }
    @Override
    public boolean equals(Object obj){
        return obj instanceof Finanzas;
    }
    
    @Override
    public String toString(){
        return Double.toString(importeCambio);
    }
}
