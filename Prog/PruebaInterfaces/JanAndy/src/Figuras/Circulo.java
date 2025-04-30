/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Figuras;

/**
 *
 * @author Andy Jan
 */
public class Circulo implements FiguraGeometricaPI {

    private float radio;
    
    
    public Circulo(float radio){
        this.radio = radio;
    }
    
    public float getDiametro(){
        return this.radio*2;
    }
    
    @Override
    public String toString(){
        return "Circulo con radio: "+ this.radio+ " Area: "+area()+ 
                " Perimetro: "+ perimetro();
    }
    
    
    
    @Override
    public double area() {
        return this.PI * Math.pow(this.radio, 2);
    }

    @Override
    public String getTipoFigura() {
        return "Circulo";
    }

    @Override
    public double perimetro() {
        return 2 * this.PI * this.radio;
    }
    
}
