/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Act2Cad {

    public static boolean palindromo(String string) {
        int i = 0;
        int length;
        int reps;
        string = string.trim().replaceAll("  +", "");
        length = string.length() - 1;
        reps = length /2;
        if (!string.isEmpty()) {
            while (i <= reps && 
                    string.charAt(i) == string.charAt(length - i)) {
                i++;
            }//Fin Mientras
        }//Fin Si

        return i > reps;
    }
    
    public static void main(String[] args) {
        //Entorno
        String introducido;
        //Algoritmo
        System.out.print("Introduce tu cadena: ");
        introducido = Leer.dato();
        System.out.println(palindromo(introducido));

    }//Fin Programa
}
