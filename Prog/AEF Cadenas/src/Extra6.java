/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Extra6 {
    public static float porcentaje(int total, int parte){
        return ((float)parte/total)*100;
    }
    
    public static void main(String[] args){
        //Entorno
        String intro;
        int grande = 0;
        int chico = 0;
        int palabras = 0;
        int pos = 0;
        
        //Algoritmo        
        System.out.print("Introduzca texto: ");
        intro = Leer.dato().trim().replaceAll("  +", " ");
        
        intro += " ";
        while(intro.indexOf(" ", pos) != -1){
            if (intro.substring(pos, intro.indexOf(" ",pos)).length() < 5){
                chico++;
            } else {
                grande++;
            }//Fin Si
            pos = intro.indexOf(" ", pos)+1;
            palabras++;
        }//Fin Mientras
        
        System.out.println(grande);
        System.out.println(chico);
        System.out.println(palabras);
        System.out.println("De las "+palabras+" palabras, "+
                porcentaje(palabras,chico)+"% son chicas y "+
                porcentaje(palabras,grande)+"% son grandes");
    }//Fin Programa
}
