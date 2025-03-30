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
        final byte datos = 50;
        int intro;
        byte pos;
        int max;
       
        //Algoritmo
        
        System.out.println("Introduzca el primer dato: ");
        intro = Leer.datoInt();
        max = intro;
        pos = 0;
        
        for(byte i = 1; i < datos; i++){
            System.out.println("Introduzca el dato "+(i+1)+" : ");
            intro = Leer.datoInt();
            if(intro > max){
                max = intro;
                pos = i;
                pos++;
            }//Fin Si
        }//Fin Para
        System.out.println("El numero mas grande es: " + max 
                            + " en la posicion "+pos+" de la tabla.");
        
    }//Fin Programa
}
