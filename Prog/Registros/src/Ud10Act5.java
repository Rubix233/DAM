/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */

/*
 * Se introducen 50 números enteros por teclado, mostrar el menor de
    ellos indicando la posición en que se ha introducido. (Si hay más de un mínimo,
    mostrar la última aparición).
 */
public class Ud10Act5 {
    public static void main(String[] args) {
        //Entorno
        int[] tabla;
        byte datos, pos;
        int min;
       
        //Algoritmo
        datos = 10;
        tabla = new int[datos];
        
        System.out.println("Introduzca el primer dato: ");
        tabla[0] = Leer.datoInt();
        min = tabla[0];
        pos = 0;
        
        for(byte i = 1; i < datos; i++){
            System.out.println("Introduzca el dato "+(i+1)+" : ");
            tabla[i] = Leer.datoInt();
            if(tabla[i] <= min){
                min = tabla[i];
                pos = i;
                pos++;
            }//Fin Si
        }//Fin Para
        System.out.println("El numero mas grande es: " + min 
                            + " en la posicion "+pos+" de la tabla.");
        
    }//Fin Programa
}
