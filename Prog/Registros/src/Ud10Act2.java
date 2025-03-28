/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
/*
 * Programa que cargue un vector con 20 números enteros generados
    aleatoriamente y mostrarlos por orden de introducción.
 */
public class Ud10Act2 {
    public static void main(String[] args){
        //Entorno
        float[] tabla;
        byte datos;
        
        //Algoritmo
        datos = 20;
        tabla = new float[datos];
        
        for(byte i = 0; i < datos; i++){
            tabla[i] = (float)Math.random()*10;
        }//Fin Para
        for(byte i = 0; i < datos; i++){
            System.out.println(tabla[i]);
        }//Fin Para
    }
}
