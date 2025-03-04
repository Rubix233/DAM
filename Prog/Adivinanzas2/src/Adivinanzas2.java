/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Adivinanzas2 {

    public static boolean numeroEnRango(int num, int min, int max) {
        return (num >= min && num <= max);
    }

    public static byte cifras(int numero) {
        byte tamanoNum = 1;

        while (numero >= Math.pow(10, tamanoNum)) {
            tamanoNum++;
        };

        return tamanoNum;
    }

    public static byte sacaDigito(int num, byte pos) {
        return (byte) (Math.abs(num) / Math.pow(10, (pos - 1)) % 10);
    }

    public static void main(String[] args) {
        //Entorno
        final int MAX = 99999;
        final int MIN = 0;

        byte intentos = 10;
        int numSecreto;
        int introducido;
        byte digitosCorrectos;

        //Algoritmo
        //Pedir numero al jugador 1
        System.out.println("Jugador 1 introduzca numero: ");
        do {
            numSecreto = Leer.datoInt();
            if (!numeroEnRango(numSecreto, MIN, MAX)) {
                System.out.println("Un numero entre " + MIN + " y " + (MAX));
            }//Fin Si
        } while (!numeroEnRango(numSecreto, MIN, MAX));//Fin Repetir

        //Limpiar consola
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");


        //Jugador 2
        System.out.println("Jugador 2. Tienes " + intentos + " intentos.");

        do {
            //Pedir numero viable al j2
            do {
                introducido = Leer.datoInt();
                if (!numeroEnRango(introducido, MIN, MAX)) {
                    System.out.println("Un numero entre " + MIN + " y " + MAX);
                }//Fin Si
            } while (!numeroEnRango(introducido, MIN, MAX));
            //Comprobar si son iguales
            if (introducido != numSecreto) {
                digitosCorrectos = 0;
                //Si el introducido es mas chico que el secreto
                if (cifras(introducido) < cifras(numSecreto)) {
                    //Comprobar cada digito derecha a izquierda
                    for (byte i = 1; i <= cifras(introducido); i++) {
                        if (sacaDigito(introducido, i)
                                == sacaDigito(numSecreto, i)) {
                            digitosCorrectos++;
                        }//Fin Si
                    }//Fin Para
                } //Si el introducido es mayor o igual al secreto
                else if (cifras(introducido) >= cifras(numSecreto)) {
                    //Comprobar cada digito derecha a izquierda
                    for (byte i = 1; i <= cifras(numSecreto); i++) {
                        if (sacaDigito(introducido, i)
                                == sacaDigito(numSecreto, i)) {
                            digitosCorrectos++;
                        }//Fin Si
                    }//Fin Para
                }//Fin Si
                //Mostrar en caso de fallar el intento
                System.out.println("Digitos correctos: " + digitosCorrectos);
                intentos--;
                System.out.println("Te quedan " + intentos + " intentos");
            }

        } while (intentos > 0 && introducido != numSecreto);
        //Mensaje de final de juego
        if (intentos > 0) {
            System.out.println("¡Enhorabuena! ¡Has ganado! Y con "
                    + (intentos - 1) + " intentos sobrantes");
        } else {
            System.out.println("Te has quedado sin intentos. El numero era: "
                    + numSecreto);
        }//Fin Si
    }//Fin Programa
}
