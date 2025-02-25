/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Contador {
    private int valor = 0;
    private byte incremento = 1;
    
    public Contador(){
        
    }
    public Contador(byte incremento){
        if(incremento != 0){
            this.incremento = incremento;
        }
    }
    public Contador(int valor, byte incremento){
        this.valor = valor;
        if(incremento != 0){
            this.incremento = incremento;
        }
    }
    public Contador(Contador referencia){
        this.valor = referencia.valor;
        this.incremento = referencia.incremento;
    }
    public void incrementaCuenta(){
        this.valor = this.valor + this.incremento;
    }
    public void iniciaCuenta(int valor){
        this.valor = valor;
    }
    public int obtenerCuenta(){
        return this.valor;
    }
    @Override
    public boolean equals(Object obj){
        return (obj instanceof Contador && ((Contador)obj).valor == this.valor 
                &&((Contador)obj).incremento == this.incremento );
    }
    
    @Override
    public String toString(){
        return "El valor de este contador en este momento es: "+
                Integer.toString(this.valor)+
                "\nSu incremento es de: "+
                Byte.toString(this.incremento);
    }
}
