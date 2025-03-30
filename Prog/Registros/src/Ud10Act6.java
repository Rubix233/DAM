/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
/*
 * Se introducen 50 números enteros por teclado, mostrar el mayor de
 ellos indicando todas las posiciones en las que se ha introducido.
 */
public class Ud10Act6 {

    public static void main(String[] args) {
        //Entorno
        int intro, mayor;
        final byte datos = 10;
        String posiciones;


        //Algoritmo

        System.out.println("Introduzca el primer dato: ");
        intro = Leer.datoInt();
        mayor = intro;
        posiciones = "0";

        for (byte i = 1; i < datos; i++) {
            System.out.println("Introduzca el dato " + (i + 1) + " : ");
            intro = Leer.datoInt();

            if (intro > mayor) {
                posiciones = Integer.toString(i + 1) + " ";
                mayor = intro;
            } else {
                if (intro == mayor) {
                    posiciones += Integer.toString(i + 1) + " ";
                }//Fin Si
            }//Fin Si

        }//Fin Para
        System.out.println("El numero mayor es " + mayor + " en las posiciones " + posiciones);

    }//Fin Programa
}
