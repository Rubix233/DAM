/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

/**
 *
 * @author Andy Jan
 */
public class Lavadora extends Electrodomestico {
    private float carga = 5;
    
    public Lavadora(){
        
    }
    public Lavadora(float precio, float peso){
        super(precio, peso);
    }
    public Lavadora(float precio, float peso,String color, char consumo, float carga){
        super(precio, peso, color, consumo);
        this.carga = carga;
    }
    
    public float getCarga(){
        return this.carga;
    }
    @Override
    public float precioFinal(){
        float precio = super.precioFinal();
        if(carga > 30){
            precio += 50;
        }
        return precio;
    }
}
