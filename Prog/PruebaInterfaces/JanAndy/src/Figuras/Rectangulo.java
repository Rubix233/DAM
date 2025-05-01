/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Figuras;

/**
 *
 * @author Andy Jan
 */
public class Rectangulo implements FiguraGeometrica{

    private float base;
    private float altura;
    
    public Rectangulo(float base, float altura){
        this.base = base;
        this.altura = altura;
    }
    
    public float getBase(){
        return this.base;
    }
    public float getAltura(){
        return this.altura;
    }
    
    @Override
    public String toString(){
        return "Rectángulo de base: " + base + ", altura: " + altura +
           " Area: " + area() + " Perimetro: " + perimetro();
    }
    
    @Override
    public double area() {
        return this.base * this.altura;
    }

    @Override
    public String getTipoFigura() {
        return "Rectangulo";
    }

    @Override
    public double perimetro() {
        return base*2 + altura*2;
    }
    
}
