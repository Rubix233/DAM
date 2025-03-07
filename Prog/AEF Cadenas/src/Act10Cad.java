/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Act10Cad {
    public static void contarLetras(String intro){
        intro = intro.trim().toUpperCase();
        int length = intro.length();
        
        while (!intro.isEmpty()){
            System.out.print(intro.substring(0, 1));
            intro = intro.replaceAll(intro.substring(0, 1), "");
            System.out.println(" aparece "+ (length-intro.length()) + " veces");
            length -= length-intro.length();
        }//Fin Mientras
        
    }
    
    public static void main(String[] args){
        //Entorno
        String introducido;
        //Algoritmo
        System.out.print("Introduzca su cadena: ");
        introducido = Leer.dato();
        contarLetras(introducido);

    }//Fin Programa
    
}
