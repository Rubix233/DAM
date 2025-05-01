/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Figuras;

/**
 *
 * @author Andy Jan
 */
public class Triangulo implements FiguraGeometricaPI {

    private float lado1;
    private float lado2;
    private double angulo;
    
    
    public Triangulo(float lado1, float lado2, double angulo){
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.angulo = angulo;
    }
    
    public float getLado1(){
        return this.lado1;
    }
    
    public float getLado2(){
        return this.lado2;
    }
    
    @Override
    public String toString(){
        return "triangulo con lados: "+this.lado1+", "+this.lado2+", "
                                       + (perimetro()-(this.lado1+this.lado2))
                                       +" Area: "+area()+ " Perimetro: "+perimetro();
    }
    
    
    @Override
    public double area() {
        return (lado1 * lado2 * Math.sin(Math.toRadians(angulo)))/2;
    }

    @Override
    public String getTipoFigura() {
        return "Triangulo";
    }

    @Override
    public double perimetro() {
        return lado1 + lado2 + (Math.sqrt( Math.pow(lado1, 2) + Math.pow(lado2, 2) - lado1 * lado2 * Math.cos(angulo) ));
    }
    
}
