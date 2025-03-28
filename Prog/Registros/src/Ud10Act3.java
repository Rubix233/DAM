/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
/*
 * Programa cargue un vector con 15 números enteros generados
 aleatoriamente y mostrarlos en orden inverso al de introducción.
 */
public class Ud10Act3 {

    public static void main(String[] args) {
        //Entorno
        float[] tabla;
        byte datos;

        //Algoritmo
        datos = 15;
        tabla = new float[datos];
        
        for(byte i = 0; i < datos; i++){
            tabla[i] = (float)Math.random()*10;
        }//Fin Para
        
        for(byte i = (byte)(datos -1); i >= 0; i--){
            System.out.println(tabla[i]);
        }//Fin Para
    }
}
