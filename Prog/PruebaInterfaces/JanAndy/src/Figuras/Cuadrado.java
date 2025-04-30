/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Figuras;

/**
 *
 * @author Andy Jan
 */
public class Cuadrado extends Rectangulo {
    
    public Cuadrado(float lado){
        super(lado,lado);
    }
    
    @Override
    public String getTipoFigura() {
        return "Cuadrado";
    }
    
}
