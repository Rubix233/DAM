/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Extra1 {

    public static void main(String[] args) {
        //Entorno
        String intro = "";
        byte numLetra = 0;
        String bigWord = "";
        byte pos = 0;
        
        //Algoritmo
        System.out.println("Introduzca la frase");
        intro= Leer.dato();
        
        intro = intro.trim().replaceAll("  +", " ");

        if (!intro.isEmpty()) {
            do {
                if (intro.substring(pos, intro.indexOf(" ", pos)).length() > numLetra) {
                    numLetra = (byte) intro.substring(pos, intro.indexOf(" ", pos)).length();
                    bigWord = intro.substring(pos, intro.indexOf(" ", pos));
                }//Fin Si
                pos = (byte) (intro.indexOf(" ", pos) + 1);
            } while (intro.indexOf(" ", pos) != -1);//Fin Mientras
        }//Fin Si
        System.out.println("La palabra mas grande es "+bigWord+ " con "+numLetra+ " letras.");
    }//Fin Programa
}
