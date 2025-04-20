/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

/**
 *
 * @author Andy Jan
 */
public class Television extends Electrodomestico{
    private float resolucion = 20;
    private boolean sintonizadorTDT = false;
    
    public Television(){
        
    }
    public Television(float precio, float peso){
        super(precio, peso);
    }
    public Television(float precio, float peso,String color, char consumo, float resolucion, boolean tdt){
        super(precio, peso, color, consumo);
        this.resolucion = resolucion;
        this.sintonizadorTDT = tdt;
    }
    
    public float getResolucion(){
        return this.resolucion;
    }
    public boolean getSintonizadorTDT(){
        return this.sintonizadorTDT;
    }
    @Override
    public float precioFinal(){
        float precio = super.precioFinal();
        if(this.resolucion > 40){
            precio += super.getPrecio() * 0.3f;
        }
        if(this.sintonizadorTDT){
            precio += 50;
        }
        return precio;
    }
}
