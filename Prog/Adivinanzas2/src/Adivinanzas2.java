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

    public static byte datoByte() {
        byte dato;
        short numero;

        //System.out.print("Introduzca numero: ");
        numero = Leer.datoShort();

        while (numero < -128 || numero > 127) {
            System.out.print("Dato incorrecto, introduzca otro: ");
            numero = Leer.datoShort();
        }

        dato = (byte) numero;
        return dato;
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
        final int MAX = 99999;
        final int MIN = 0;

        byte intentos = 10;
        int numSecreto;
        int introducido;
        byte digitosCorrectos;

        //Pedir numero al jugador 1
        System.out.println("Jugador 1 introduzca numero: ");
        do {
            numSecreto = Leer.datoInt();
            if (!numeroEnRango(numSecreto, MIN, MAX)) {
                System.out.println("Un numero entre " + MIN + " y " + (MAX));
            }
        } while (!numeroEnRango(numSecreto, MIN, MAX));

        //Limpiar consola
        for (int i = 0; i <= 10; i++) {
            System.out.println();
        }

        //Jugador 2
        System.out.println("Jugador 2. Tienes " + intentos + " intentos.");

        do {
            //Pedir numero viable al j2
            do {
                introducido = Leer.datoInt();
                if (!numeroEnRango(introducido, MIN, MAX)) {
                    System.out.println("Un numero entre " + MIN + " y " + MAX);
                }
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
                        }
                    }
                } //Si el introducido es mayor o igual al secreto
                else if (cifras(introducido) >= cifras(numSecreto)) {
                    //Comprobar cada digito derecha a izquierda
                    for (byte i = 1; i <= cifras(numSecreto); i++) {
                        if (sacaDigito(introducido, i)
                                == sacaDigito(numSecreto, i)) {
                            digitosCorrectos++;
                        }
                    }
                }
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
        }

    }
}
