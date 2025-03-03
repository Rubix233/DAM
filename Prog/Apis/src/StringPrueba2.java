
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
            }//Fin Si
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
        nombre = nom.trim() + " " + ape1.trim() + " " + ape2.trim()+"*";
        System.out.println("Has introducido: " + nombre);

        System.out.println("En mayusculas: " + nombre.toUpperCase());
        System.out.println("En minusculas: " + nombre.toLowerCase());

        System.out.println("Correctamente escrito: " + camelCase(nombre));
        
        nombre = nom.trim().substring(0, 1).toUpperCase()+
                nom.trim().substring(1).toLowerCase()+" "+
                ape1.trim().substring(0, 1).toUpperCase()+
                ape1.trim().substring(1).toLowerCase()+" "+
                ape2.trim().substring(0, 1).toUpperCase()+
                ape2.trim().substring(1).toLowerCase()+"*";
        System.out.println("Correctamente 2: "+ nombre);
    }  //Fin Programa
}
