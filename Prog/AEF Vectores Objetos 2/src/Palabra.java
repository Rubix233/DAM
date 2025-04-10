/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Palabra {
    private String palabra;
    private int contador;
    
    public Palabra(){
        
    }
    public Palabra(String palabra){
        this.palabra = palabra;
        this.contador = 1;
    }
    public String obtenerPalabra(){
        return this.palabra;
    }
    public int obtenerFrecuencia(){
        return this.contador;
    }
    public void incrementaFrecuencia(){
        this.contador++;
    }
}
