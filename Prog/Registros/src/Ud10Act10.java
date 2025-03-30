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
que rote una posición a la izquierda sus elementos y muestre cómo ha quedado
la tabla.
 */
public class Ud10Act10 {
    public static void main(String[] args){
        //Entorno
        int[] tabla = {7,8,3,0,33};
        int aux = 0;
        int i;
        String out = "";
        //Algoritmo
        
        aux = tabla[0];
        
        for(i = 0; i < tabla.length-1; i++){
            tabla[i] = tabla[i+1];
        }//Fin Para
        tabla[tabla.length-1] = aux;
        
        for(i = 0; i<tabla.length;i++){
            out += tabla[i]+" ";
        }//Fin Para
        System.out.println(out.trim());
        
    }//Fin Programa
}
