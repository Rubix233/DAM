/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
/*
 * Se introducen 50 números enteros por teclado, mostrar el mayor de
    ellos indicando todas las posiciones en las que se ha introducido.
 */
public class Ud10Act6 {
    public static void main(String[] args) {
        //Entorno
        int[] tabla;
        byte datos;

       
        //Algoritmo
        datos = 10;
        tabla = new int[datos];
        
        System.out.println("Introduzca el primer dato: ");
        tabla[0] = Leer.datoInt();

        for(byte i = 1; i < datos; i++){
            System.out.println("Introduzca el dato "+(i+1)+" : ");
            tabla[i] = Leer.datoInt();
            
        }//Fin Para
        
    }//Fin Programa
}
