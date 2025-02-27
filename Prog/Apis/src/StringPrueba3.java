/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class StringPrueba3 {

    public static int numeroPalabras(String string) {
        int contador = 0;
        if (!string.isEmpty()) {
            if (string.charAt(0) != ' ') {
                contador++;
            }//Fin Si
            for (int i = 0; i < string.length(); i++) {
                if (i != string.length() - 1
                        && string.charAt(i) == ' '
                        && string.charAt(i + 1) != ' ') {

                    contador++;
                }//Fin Si
            }//Fin Para
        }//Fin Si
        return contador;
    }

    public static void main(String[] args) {
        //Entorno
        String stringPrueba = "";

        //Algoritmo
        System.out.print("Introduzca una cadena: ");
        stringPrueba = Leer.dato();
        System.out.println("Su cadena tiene " + 
                stringPrueba.length() + " caracteres.");
        
        if (numeroPalabras(stringPrueba) <= 0) {
            System.out.println("No contiene ninguna palabra");
        } else {
            if (numeroPalabras(stringPrueba) == 1) {
                System.out.println("Contiene una palabra");
            } else {
                System.out.println("Contiene mas de una palabra");
            }//Fin Si No
        }//Fin Si NO

    }//Fin Programa
}
