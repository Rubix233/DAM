
/**
 *
 * @authores Andy Jan, Alvaro Perez, Alejandra Garzon, Miguel Angel Busatori
 */
public class Adivinanzas1 {

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
    
    public static void main(String[] args) {
        final byte MAX = 100;
        final byte MIN = 0;

        byte intentos = 8;
        byte numSecreto;
        byte introducido;

        //Pedir numero al jugador 1
        System.out.println("Jugador 1 introduzca numero: ");
        do {
            numSecreto = datoByte();
            if (!numeroEnRango(numSecreto, MIN, MAX)) {
                System.out.println("Un numero entre " + MIN + " y " + MAX);
            }
        } while (!numeroEnRango(numSecreto, MIN, MAX));
        //Limpiar consola
        for (int i = 0; i <= 10; i++) {
            System.out.println();
        }

        //Jugador 2
        System.out.println("Jugador 2. Tienes " + intentos + " intentos.");

        do {
            do {
                introducido = datoByte();
                if (!numeroEnRango(introducido, MIN, MAX)) {
                    System.out.println("Un numero entre " + MIN + " y " + MAX);
                }
            } while (!numeroEnRango(introducido, MIN, MAX));

            if (introducido < numSecreto) {
                System.out.println("El objetivo es mayor.");
                intentos--;
                System.out.println("Te quedan " + intentos + " intentos.");
            } else {
                if (introducido > numSecreto) {
                    System.out.println("El objetivo es menor.");
                    intentos--;
                    System.out.println("Te quedan " + intentos + " intentos.");
                }
            }
        } while (intentos > 0 && introducido != numSecreto);

        if (intentos > 0) {
            System.out.println("¡Enhorabuena! ¡Has ganado! Y con "
                    + (intentos - 1) + " intentos sobrantes");
        } else {
            System.out.println("Te has quedado sin intentos. El numero era: "
                    + numSecreto);
        }
    }
}
