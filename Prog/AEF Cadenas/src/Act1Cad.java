/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Act1Cad {

    public static void main(String[] args) {
        //Entorno
        String introducido;
        //Algoritmo
        do {
            System.out.print("Introduce tu cadena: ");
            introducido = Leer.dato();
        } while (!introducido.matches("^.{1,25}$"));

        introducido = introducido.trim().replaceAll("\\s+", " ");

        System.out.println("*" + introducido + "*");

    }//Fin Programa
}
