/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Act8Cad {
    public static String rotarStr(String intro){
        intro = intro.trim().toLowerCase();
        String out = intro.substring(intro.length()-1).toUpperCase() ;
        
        for (int i = 0; i < intro.length()-1; i++){
            out += intro.substring(i, i+1);
        }//Fin Para
        return out;
    }
    
    public static void rotacionStr(String intro){
        for (int i = 0; i < intro.length(); i++){
            intro = rotarStr(intro);
            System.out.println(intro);
        }//Fin Si
    }
    
    public static void main(String[] args){
        //Entorno
        String introducido;
        //Algoritmo
        do {
            System.out.print("Introduce tu cadena: ");
            introducido = Leer.dato();
        } while (!introducido.matches("[a-zA-Z]{1,10}"));
        rotacionStr(introducido);
    }
    
}
