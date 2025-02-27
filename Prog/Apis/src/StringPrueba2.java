
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class StringPrueba2 {

    public static String camelCase(String string) {
        String returnString = "";

        for (int i = 0; i < string.length(); i++) {
            if (i == 0 || string.charAt(i - 1) == ' ') {
                returnString += (string.toUpperCase().charAt(i));
            } else {
                returnString += (string.toLowerCase().charAt(i));
            }
        }
        return returnString;
    }

    public static void main(String[] args) {
        //Entorno
        String nom;
        String ape1;
        String ape2;
        String nombre;

        //Algoritmo 
        System.out.print("Introduzca nombre: ");
        nom = Leer.dato();
        System.out.print("Introduzca apellido: ");
        ape1 = Leer.dato();
        System.out.print("Introduzca segundo appelido: ");
        ape2 = Leer.dato();
        nombre = nom + " " + ape1 + " " + ape2;
        System.out.println("Has introducido: " + nombre);

        System.out.println("En mayusculas: " + nombre.toUpperCase());
        System.out.println("En minusculas: " + nombre.toLowerCase());

        System.out.println("Correctamente escrito: " + camelCase(nombre));
    }  //Fin Programa
}
