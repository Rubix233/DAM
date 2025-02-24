/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Numero {
    private int valor;
    
    
    public Numero(){
        
    }    
    public Numero(int numero){
        this.valor = numero;
    }    
    public void aniade(int numero){
        this.valor += numero;
    }
    public void resta(int numero){
         this.valor -= numero;
    }    
    public int getValor(){
        return this.valor;
    }
    public int getDoble(){
        return this.valor*2;
    }
    public int getTriple(){
        return this.valor*3;
    }
    public int getCuadruple(){
        return this.valor*4;
    }
    public void setValor(int numero){
        this.valor = numero;
    }
    
    @Override
    public boolean equals(Object obj){
        return (obj instanceof Numero && ((Numero)obj).valor == this.valor);
    }
    
    @Override
    public String toString(){
        return Integer.toString(this.valor);
    }
}
