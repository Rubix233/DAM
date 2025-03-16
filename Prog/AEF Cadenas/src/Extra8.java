/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Extra8 {
    public static boolean vocalesVari(String intro){
        //Entorno
        byte i;
        byte j = 0;
        intro=intro.toUpperCase();
        String vocales = "AEIOU";
        
        //Algoritmo
        for (i = 0; i < vocales.length(); i++){
            if(intro.indexOf(vocales.charAt(i)) != -1){
                j++;
            }//Fin Si
        }//Fin Para
        return j > 3;
    }
    
    public static void main(String[] args){
        //Entorno
        String intro;
        String palabra;
        int pos = 0;
        byte palabrasVari = 0;
        
        //Algoritmo
        System.out.print("Introduzca texto: ");
        intro = Leer.dato();

        intro += " ";
        while (intro.indexOf(" ", pos) != -1){
            palabra = intro.substring(pos, intro.indexOf(" ", pos));
            if (vocalesVari(palabra)){
                palabrasVari++;
            }//Fin Si
            pos = intro.indexOf(" ", pos)+1;
        }//Fin Mientras
        
        System.out.println("Hay "+palabrasVari+" palabras con 4 o mas vocales.");
    }
}
