
import java.io.BufferedReader;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy
 */
public class Leer {

    public static byte datoByte(BufferedReader teclado) {
        byte returnByte = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print("Introduce un byte: ");
                String in = teclado.readLine();
                returnByte = Byte.parseByte(in);
                valido = true;
            } catch (NumberFormatException e) {
                System.err.println("Error: Debes introducir un valor byte válido.");
            } catch (IOException io) {
                System.err.println("Error al leer.");
            }
        }

        return returnByte;
    }

    public static short datoShort(BufferedReader teclado) {
        short returnShort = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print("Introduce un short: ");
                String in = teclado.readLine();
                returnShort = Short.parseShort(in);
                valido = true;
            } catch (NumberFormatException e) {
                System.err.println("Error: Debes introducir un valor short válido.");
            } catch (IOException io) {
                System.err.println("Error al leer.");
            }
        }

        return returnShort;
    }

    public static int datoInt(BufferedReader teclado) {
        int returnInt = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print("Introduce un int: ");
                String in = teclado.readLine();
                returnInt = Integer.parseInt(in);
                valido = true;
            } catch (NumberFormatException e) {
                System.err.println("Error: Debes introducir un valor int válido.");
            } catch (IOException io) {
                System.err.println("Error al leer.");
            }
        }

        return returnInt;
    }

    public static long datoLong(BufferedReader teclado) {
        long returnLong = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print("Introduce un long: ");
                String in = teclado.readLine();
                returnLong = Long.parseLong(in);
                valido = true;
            } catch (NumberFormatException e) {
                System.err.println("Error: Debes introducir un valor long válido.");
            } catch (IOException io) {
                System.err.println("Error al leer.");
            }
        }

        return returnLong;
    }

    public static float datoFloat(BufferedReader teclado) {
        float returnFloat = 0.0f;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print("Introduce un float: ");
                String in = teclado.readLine();
                returnFloat = Float.parseFloat(in);
                valido = true;
            } catch (NumberFormatException e) {
                System.err.println("Error: Debes introducir un valor float válido.");
            } catch (IOException io) {
                System.err.println("Error al leer.");
            }
        }

        return returnFloat;
    }

    public static double datoDouble(BufferedReader teclado) {
        double returnDouble = 0.0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print("Introduce un double: ");
                String in = teclado.readLine();
                returnDouble = Double.parseDouble(in);
                valido = true;
            } catch (NumberFormatException e) {
                System.err.println("Error: Debes introducir un valor double válido.");
            } catch (IOException io) {
                System.err.println("Error al leer.");
            }
        }

        return returnDouble;
    }
}
