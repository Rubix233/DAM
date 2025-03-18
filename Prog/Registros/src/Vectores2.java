/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Vectores2 {
    public static void main(String[] args){
        //Entorno
        int[] tabla;
        String out = "";
        int i;
        
        //Algoritmo
        tabla = new int[5];
        
        for (i = 0; i<tabla.length; i++){
            System.out.print("Introduzca int: ");
            tabla[i] = Leer.datoInt();
        }//Fin Para
        
        for (i = 0; i<tabla.length-1; i++){
            out = out + tabla[i] +" - ";
        }//Fin Para
        out = out + tabla[i];
        
        System.out.println(out);
        out = "";
        
        for (i = tabla.length-1; i > 0; i--){
            out = out + tabla[i] +" - ";
        }//Fin Para
        out = out + tabla[i];
        System.out.println(out);
    }//Fin Programa
}
