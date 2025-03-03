/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class StringPrueba4 {

    public static void main(String[] args) {
        //Entorno
        int entero;
        String enteroString;

        //Algoritmo
        System.out.print("Introduzca un numero: ");
        entero = Leer.datoInt();

        enteroString = Integer.toString(entero);
        enteroString = enteroString.replace('2', 'A').replace('5', 'Z');
        System.out.println(enteroString);

    }//Fin Programa
}
