/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
/*
 * Programa que cargue una tabla con 5 valores enteros (7,8,3,0,33) y
que rote una posición a la derecha sus elementos y muestre cómo ha quedado la
tabla.
 */
public class Ud10Act9 {
   public static void main(String[] args){
        //Entorno
        int[] tabla = {7,8,3,0,33};
        int aux = 0;
        int i;
        String out = "";
        //Algoritmo
        
        aux = tabla[tabla.length-1];
        
        for(i = tabla.length-1; i > 0; i--){
            tabla[i] = tabla[i-1];
        }//Fin Para
        tabla[0] = aux;
        
        for(i = 0; i<tabla.length;i++){
            out += tabla[i]+" ";
        }//Fin Para
        System.out.println(out.trim());
        
    }//Fin Programa
}
