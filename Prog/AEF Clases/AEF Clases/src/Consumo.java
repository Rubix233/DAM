/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Consumo {
    private float kms;
    private float litros;
    private float vmed;
    private float precio = 1.50f;
    
    public Consumo(float kilometros,float litros, float vmed){
        this.kms = kilometros;
        this.litros = litros;
        this.vmed = vmed;
    }
    public void setKms(float kms){
        this.kms = kms;
    }
    public void setLitros(float litros){
        this.litros = litros;
    }
    public void setVmed(float vmed){
        this.vmed = vmed;
    }
    public void setPrecio(float precio){
        this.precio = precio;
    }
    public float getTiempo(){
        return kms / vmed;
    }
    public float consumoMedio(){
        return litros *100/kms;
    }
    public float consumoEuros(){
        return litros * precio;
    }
}
