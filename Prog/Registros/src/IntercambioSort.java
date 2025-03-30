
import java.util.Arrays;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy Jan
 */
public class IntercambioSort {

    public static void main(String[] args) {
        //Entorno
        int[] tabla = {10, 50, 25, 5, 29};
        int aux, limite, i, j, pos;

        //Algoritmo
        limite = tabla.length - 1;
        
        //Ascendente
        for(i = 0; i<limite;i++){
            pos = i;
            aux = tabla[i];
            for(j = i+1;j<=limite;j++){
                if(tabla[j] < aux){
                    aux = tabla[j];
                    pos = j;
                }//Fin Si
            }//Fin Para
            tabla[pos] = tabla[i];
            tabla[i] = aux;
        }//Fin Para
        
        System.out.println(Arrays.toString(tabla));
        
        //Descendiente
        for(i = 0; i<limite;i++){
            pos = i;
            aux = tabla[i];
            for(j = i+1;j<=limite;j++){
                if(tabla[j] > aux){
                    aux = tabla[j];
                    pos = j;
                }//Fin Si
            }//Fin Para
            tabla[pos] = tabla[i];
            tabla[i] = aux;
        }//Fin Para
        System.out.println(Arrays.toString(tabla));
    }//Fin Programa
}
