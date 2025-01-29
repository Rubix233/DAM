
/**
 *
 * @author Andy Jan
 */
public class Utilidades {

    public static byte cifras(int numero) {
        byte tamanoNum = 1;

        do {
            tamanoNum++;
        } while (numero >= Math.pow(10, tamanoNum));

        return tamanoNum;
    }

    public static byte sacaDigito(int num, byte pos) {
        byte digito;
        int numero = Math.abs(num);
        byte tamanoNum = cifras(numero);

        digito = (byte) (numero / Math.pow(10, (tamanoNum - pos)) % 10);
        return digito;
    }

    public static byte datoByte() {
        byte dato;
        short numero;

        System.out.print("Introduzca numero: ");
        numero = Leer.datoShort();

        while (numero < -128 || numero > 127) {
            System.out.print("Dato incorrecto, introduzca otro: ");
            numero = Leer.datoShort();
        }

        dato = (byte) numero;
        return dato;
    }

    public static boolean esBisiesto(short ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    public static void nombreMes(byte mes) {
        if (mes < 1 || mes > 12) {
            System.out.print("Mes incorrecto");
        }
        switch (mes) {
            case 1:
                System.out.print("Enero");
                break;
            case 2:
                System.out.print("Febrero");
                break;
            case 3:
                System.out.print("Marzo");
                break;
            case 4:
                System.out.print("Abril");
                break;
            case 5:
                System.out.print("Mayo");
                break;
            case 6:
                System.out.print("Junio");
                break;
            case 7:
                System.out.print("Julio");
                break;
            case 8:
                System.out.print("Agosto");
                break;
            case 9:
                System.out.print("Septiembre");
                break;
            case 10:
                System.out.print("Octubre");
                break;
            case 11:
                System.out.print("Noviembre");
                break;
            case 12:
                System.out.print("Diciembre");
                break;
        }
    }
    
   
}
