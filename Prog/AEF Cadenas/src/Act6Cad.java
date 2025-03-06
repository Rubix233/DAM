/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Act6Cad {
    public static String monoAlfDecode(int clave, String intro) {
        String codificado = "";
        clave = (clave%26)*-1;
        int length = intro.length() - 1;

        //Recorer todos los caracteres
        for (int i = 0; i <= length; i++) {
            //Establecer codigo ASCII y el objetivo
            int charInt = (int) intro.charAt(i);
            int target = charInt + clave;//Por si se cuelan
            
            //Si es letra
            if (charInt >= 65 && charInt <= 90 
                    || charInt >= 97 && charInt <= 122) {
                
                //Si es minuscula y se sale de rango
                if (charInt >= 97) {
                    if (target < 97) {
                        target = 123 - (97 - target);
                    }//Fin Si
                    if (target > 122) {
                        target = (target - 122) + 96;
                    }//Fin Si
                } else { //Si es mayus y se sale de rango
                    if (target < 65) {
                        target = 91 - (65 - target);
                    }//Fin Si
                    if (target > 90) {
                        target = (target - 90) + 64;
                    }//Fin Si
                }//Fin Si
                codificado += (char) target;
            } else {//Si no es letra se deja igual
                codificado += intro.charAt(i);
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
        System.out.print("Introduzca clave para decodificar: ");
        clave = Leer.datoInt();
        System.out.println("Su mensaje decodificado:");
        System.out.println(monoAlfDecode(clave,introducido));


    }//Fin Programa
}
