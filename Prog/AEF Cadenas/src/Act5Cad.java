/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Act5Cad {

    public static String monoAlf(int clave, String intro) {
        String codificado = "";
        int length = intro.length() - 1;
        clave = clave%26;
        //Recorer todos los caracteres
        for (int i = 0; i <= length; i++) {
            //Establecer codigo ASCII y el objetivo
            int charInt = intro.charAt(i);
            int target = charInt + clave;//Por si se cuelan
            
            //Si es letra
            if (charInt >= 'A' && charInt <= 'Z' 
                    || charInt >= 'a' && charInt <= 'z') {
                
                //Si es minuscula y se sale de rango
                if (charInt >= 'a') {
                    if (target < 'a') {
                        target = ('z'+1) - ('a' - target);
                    }//Fin Si
                    if (target > 'z') {
                        target = (target - 'z') + ('a'-1);
                    }//Fin Si
                } else { //Si es mayus y se sale de rango
                    if (target < 'A') {
                        target = ('Z'+1) - ('A' - target);
                    }//Fin Si
                    if (target > 'Z') {
                        target = (target - 'Z') + ('A'-1);
                    }//Fin Si
                }//Fin Si
                codificado += (char) target;
            } else {//Si no es letra se deja igual
                codificado += intro.substring(i, i+1);
            }//Fin Si
        }
        return codificado;
    }

    
    public static void main(String[] args) {
        //Entorno
        String introducido;
        int clave;
        
        //Algoritmo
        System.out.print("Introduzca una cadena: ");
        introducido = Leer.dato();
        System.out.print("Introduzca clave para codificar: ");
        clave = Leer.datoInt();
        System.out.println("Su mensaje codificado:");
        System.out.println(monoAlf(clave,introducido));


    }//Fin Programa
}
