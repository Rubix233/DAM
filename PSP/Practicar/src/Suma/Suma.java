/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Suma;

/**
 *
 * @author Andy
 */
public class Suma {

    public static void main(String[] args) {
        
        
        int min, max, suma;
        if (args.length != 2) {
            System.err.println("Cantidad de argumentos no correctos. Introduzca solo 2");
            System.exit(-1);
        } else {
            try {
                if (Integer.valueOf(args[0]) <= Integer.valueOf(args[1])) {
                    min = Integer.valueOf(args[0]);
                    max = Integer.valueOf(args[1]);
                } else {
                    min = Integer.valueOf(args[1]);
                    max = Integer.valueOf(args[0]);
                }

                if (min >= 0 && max >= 0) {
                    suma = 0;
                    for (int i = min; i <= max; i++) {
                        suma += i;
                    }
                    System.out.println("Desde valor: "+min);
                    System.out.println("Hasta valor: "+max);
                    System.out.println(suma);
                    System.exit(suma);

                } else {
                    System.err.println("Numeros negativos no se permiten");
                    System.exit(-1);
                }


            } catch (NumberFormatException nfe) {
                System.err.println("Uno o ambos argumentos no son numeros enteros");
            }

        }
    }
}
