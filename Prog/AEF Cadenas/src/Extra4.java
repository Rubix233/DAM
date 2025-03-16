/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Extra4 {
    public static String intercalado(String a, String b){
        //Entorno
        a = a.trim();
        b = b.trim();
        String out = "";
        int i;
        
        //Algoritmo
        for (i = 0; i < a.length() && i < b.length(); i++){
            out += a.substring(i, i+1) + b.substring(i, i+1);
        }
        if (a.length() > b.length()){
            out += a.substring(i);
        }
        if (a.length() < b.length()){
            out += b.substring(i);
        }
        
        return out;
    }
    
    public static int contarPalabras(String intro){
        //Entorno
        int palabras = 0;
        byte pos = 0;
        
        //Algoritmo
        if (!intro.isEmpty()) {
            palabras = 1;
            while (intro.indexOf(" ", pos) != -1) {
                palabras++;
                pos = (byte) (intro.indexOf(" ", pos) + 1);
            }//Fin Mientras;
        }//Fin Si
        return palabras;
    }
    
    public static void main(String[] args){
        //Entorno
        String str1;
        String str2;
        String out = "";
        int reps;
        int i;
        int pos1 = 0;
        int pos2 = 0;
        
        //Algoritmo
        System.out.print("Introduzca cadena 1: ");
        str1 = Leer.dato().trim().replaceAll("  +", " ");
        
        System.out.print("Introduzca cadena 2: ");
        str2 = Leer.dato().trim().replaceAll("  +", " ");
        
        
        if (contarPalabras(str1) <= contarPalabras(str2)){
            reps = contarPalabras(str1);
        } else {
            reps = contarPalabras(str2);
        }//Fin Si
        
        str1 += " ";
        str2 += " ";
        
        for(i= 0;i<reps;i++){
            out += intercalado(str1.substring(pos1, str1.indexOf(" ",pos1)), 
                                str2.substring(pos2, str2.indexOf(" ",pos2)))+" ";
            pos1 = str1.indexOf(" ",pos1)+1;
            pos2 = str2.indexOf(" ",pos2)+1;
        }//Fin Para
        
        out += intercalado(str1.substring(pos1), str2.substring(pos2));
        
        System.out.println(out);
    }//Fin Programa
}
//Me he bloqueado bastante con el manejo de numero de palabras diferentes