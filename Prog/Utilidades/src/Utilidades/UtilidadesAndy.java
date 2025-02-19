


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
    public static byte cifras(int numero) {
        byte tamanoNum = 1;

        while (numero >= Math.pow(10, tamanoNum)) {
            tamanoNum++;
        };

        return tamanoNum;
    }
    public static byte sacaDigito(int num, byte pos) {
        byte digito;
        int numero = Math.abs(num);

        digito = (byte) (numero / Math.pow(10, (pos-1)) % 10);
        return digito;
    }
}
