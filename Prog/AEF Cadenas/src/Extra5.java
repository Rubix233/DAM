/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Extra5 {
    public static void main(String[] args){
        //Entorno
        String intro;
        String noSale="";
        
        //Algoritmo
        System.out.print("Introduzca su texo: ");
        intro= Leer.dato();
        
        for(int i = 'a'; i <= 'z'; i++){
            if(intro.indexOf(i) == -1){
                noSale += (char) i;
            }//Fin Si
        }//Fin Para
        System.out.println("Las letras que no aparecen son: ");
        for(int i = 0; i < noSale.length()-1; i++){
            System.out.print(noSale.substring(i, i+1)+", ");
        }//Fin Para
        System.out.println(noSale.substring(noSale.length()-1));
    }
}
