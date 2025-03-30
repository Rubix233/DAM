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
        final byte datos = 5;
        int intro;
        byte pos;
        int min;
       
        //Algoritmo

        
        System.out.println("Introduzca el primer dato: ");
        intro = Leer.datoInt();
        min = intro;
        pos = 0;
        
        for(byte i = 1; i < datos; i++){
            System.out.println("Introduzca el dato "+(i+1)+" : ");
            intro = Leer.datoInt();
            if(intro <= min){
                min = intro;
                pos = i;
                pos++;
            }//Fin Si
        }//Fin Para
        System.out.println("El numero mas grande es: " + min 
                            + " en la posicion "+pos+" de la tabla.");
        
    }//Fin Programa
}
