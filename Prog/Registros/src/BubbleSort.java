
import java.util.Arrays;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class BubbleSort {
    public static void main(String[] args){
        //Entorno
        int[] tabla = {10,50,25,5,29};
        int aux,limite,i,j;
        
        //Algoritmo
        //Ascendente
        limite = tabla.length - 1;
        
        while (limite > 0) {
            j = 1;
            for (i = 0; i < limite; i++) {
                if (tabla[i] > tabla[j]) {
                    aux = tabla[j];
                    tabla[j] = tabla[i];
                    tabla[i] = aux;
                }//Fin Si
                j++;
            }//Fin Para
            limite--;
        }//Fin Mientras
        System.out.println(Arrays.toString(tabla));
        
        //Descentente
        limite = tabla.length - 1;

        while (limite > 0) {
            j = 1;
            for (i = 0; i < limite; i++) {
                if (tabla[i] < tabla[j]) {
                    aux = tabla[j];
                    tabla[j] = tabla[i];
                    tabla[i] = aux;
                }//Fin SI
                j++;
            }//Fin Para
            limite--;
        }//Fin Mientras
        System.out.println(Arrays.toString(tabla));
        
    }//Fin Programa
}
