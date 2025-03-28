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
    ellos indicando la posición en que se ha introducido. (Si hay más de un máximo,
    mostrar el primero que aparezca).
 */
public class Ud10Act4 {
    public static void main(String[] args) {
        //Entorno
        int[] tabla;
        byte datos, pos;
        int max;
       
        //Algoritmo
        datos = 10;
        tabla = new int[datos];
        
        System.out.println("Introduzca el primer dato: ");
        tabla[0] = Leer.datoInt();
        max = tabla[0];
        pos = 0;
        
        for(byte i = 1; i < datos; i++){
            System.out.println("Introduzca el dato "+(i+1)+" : ");
            tabla[i] = Leer.datoInt();
            if(tabla[i] > max){
                max = tabla[i];
                pos = i;
                pos++;
            }//Fin Si
        }//Fin Para
        System.out.println("El numero mas grande es: " + max 
                            + " en la posicion "+pos+" de la tabla.");
        
    }//Fin Programa
}
