/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Figuras;

/**
 *
 * @author Andy Jan
 */
public class Main {
    public static void main(String[] args) {
        FiguraGeometrica[] figuras = new FiguraGeometrica[5];

        figuras[0] = new Triangulo(3f, 4f, 60);
        figuras[1] = new TrianguloRectangulo(3f, 4f);
        figuras[2] = new Circulo(5f);
        figuras[3] = new Rectangulo(2f, 4f);
        figuras[4] = new Cuadrado(5f);

        for (int i = 0; i < figuras.length; i++) {
            System.out.println("Tipo: " + figuras[i].getTipoFigura());
            System.out.println(figuras[i].toString());
            System.out.println("--------------------------");
        }
    }
}
