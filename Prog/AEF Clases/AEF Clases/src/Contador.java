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
        this.incremento = incremento;
    }
    public Contador(int valor, byte incremento){
        this.valor = valor;
        this.incremento = incremento;
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
}
