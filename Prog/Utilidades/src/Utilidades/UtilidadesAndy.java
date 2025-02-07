/**
 *
 * @author Andy Jan
 */

public class UtilidadesAndy {
    public static boolean esPrimo(int num) {
        boolean primo = true;
        if (num % 2 == 0) {
            primo = false;
        } else {
            for (int i = 3; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    primo = false;
                }
            }
        }

        return primo;
    }
    
    public static boolean numeroEnRango(int num, int min, int max){
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
}
