/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Extra2 {

    public static void main(String[] args) {
        //Entorno
        String intro = "";
        int palabras;
        byte pos = 0;

        //Algoritmo
        System.out.print("Introduzca cadena: ");
        intro = Leer.dato();

        intro = intro.trim().replaceAll("  +", " ");

        if (!intro.isEmpty()) {
            palabras = 1;
            while (intro.indexOf(" ", pos) != -1) {
                palabras++;
                pos = (byte) (intro.indexOf(" ", pos) + 1);
            }//Fin Mientras
            System.out.println("La frase tiene "+ palabras + " palabras");
        } else {
            System.out.println("La cadena esta vacia");
        }//Fin Si


    }//Fin Programa
}
