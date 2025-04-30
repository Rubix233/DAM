/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Figuras;

/**
 *
 * @author Andy Jan
 */
public class TrianguloRectangulo extends Triangulo {
    
    public TrianguloRectangulo(float cateto1, float cateto2){
        super(cateto1, cateto2, 90);
    }
    
    public double getHipotenusa(){
        return Math.hypot(getLado1(), getLado2());
    }
    
    @Override
    public double perimetro(){
        return getLado1() + getLado2() + getHipotenusa();
    }
}
