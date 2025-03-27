
import java.util.Arrays;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
//Programa que cargue por teclado, un máximo de 50 números enteros,
//manteniendo la tabla ordenada ascendentemente en todo momento
public class Ud10Act11 {
    public static void main(String[] args){
        //Entorno
        int[] tabla;
        int tamTabla, intro, j;
        
        //Algoritmo
        tamTabla = 10;
        tabla = new int[tamTabla];
        System.out.print("Introduzca el primer dato: ");
        tabla[0] = Leer.datoInt();
        
        for(int i = 1; i < tamTabla;i++){
            System.out.print("Introduzca el dato "+(i+1)+": ");
            intro = Leer.datoInt();
            j = i;
            
            while (j > 0 && tabla[j - 1] > intro  ) {
                tabla[j] = tabla[j - 1];
                j--;
            }//Fin Mientras
            tabla[j] = intro;
            System.out.println(Arrays.toString(tabla));
        }//Fin Para    
    }//Fin Programa
}
