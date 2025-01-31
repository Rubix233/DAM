
/**
 *
 * @author Andy Jan
 */
public class Utilidades {

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
        byte tamanoNum = cifras(numero);

        digito = (byte) (numero / Math.pow(10, (tamanoNum - pos)) % 10);
        return digito;
    }

    public static int invierte(int numero) {
        int invertido = 0;
        byte tamano = cifras(numero);
        if (tamano == 1) {
            invertido = numero;
        } else {
            for (byte i = 1; i <= tamano; i++) {
                invertido = invertido
                        + (sacaDigito(numero, i) * (int) Math.pow(10, i - 1));
            }
        }

        return invertido;
    }

    public static boolean capicua(int num) {
        boolean esCapi;
        byte cifras;
        byte i = 1;

        cifras = cifras(num);
        if (cifras == 1) {
            esCapi = true;
        } else {
            while (i <= cifras / 2 && sacaDigito(num, i)
                    == sacaDigito(num, (byte) (cifras - i + 1))) {
                i++;
            }
            if (i > cifras / 2) {
                esCapi = true;
            } else {
                esCapi = false;
            }
        }
        return esCapi;
    }

    public static boolean esBisiesto(short ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    public static boolean esFechaValida(byte dia, byte mes, short ano) {
        boolean valido;
        byte diasMax = 0;
        if (mes < 1 || mes > 12) {
            valido = false;
        } else {
            switch (mes) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    diasMax = 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    diasMax = 30;
                    break;
                case 2:
                    diasMax = 28;
                    if (esBisiesto(ano)) {
                        diasMax = 29;
                    }
            }
            valido = !(dia < 1 || dia > diasMax);
        }

        return valido;
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

    public static boolean continuar() {
        boolean seguir;
        char intro;
        do {
            System.out.print("¿Desea continuar? (S/N)");
            intro = Leer.datoChar();
        } while ((intro != 's' && intro != 'S' && intro != 'n' && intro != 'N'));


        if (intro == 's' || intro == 'S') {
            seguir = true;
        } else {
            seguir = false;
        }

        return seguir;

    }
}
