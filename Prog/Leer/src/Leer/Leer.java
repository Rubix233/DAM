package Leer;
import java.io.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nuria Fuentes
 */

public class Leer {
    /**
     * Método para leer una línea de texto desde el teclado.
     * @return La línea de texto ingresada como String.
     */
    public static String dato() {
        String sdato = "";
        try {
            // Crear un InputStreamReader para leer bytes desde la entrada estándar (teclado)
            InputStreamReader isr = new InputStreamReader(System.in);
            // Envolver el InputStreamReader en un BufferedReader para leer líneas completas
            BufferedReader flujoE = new BufferedReader(isr);
            // Leer la línea ingresada por el usuario
            sdato = flujoE.readLine();
        } catch (IOException e) {
            // Manejar posibles errores de entrada/salida
            System.err.println("Error: " + e.getMessage());
        }
        // Devolver el texto ingresado
        return sdato;
    }

    /**
     * Método para leer un solo carácter desde el teclado.
     * @return El carácter ingresado.
     */
    public static char datoChar() {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader flujoE = new BufferedReader(isr);
            // Leer el primer carácter de la entrada
            char ch = (char) flujoE.read();
            return ch;
        } catch (IOException e) {
            System.out.println("Error al leer el carácter. Inténtelo de nuevo.");
            // Volver a llamar al método en caso de error
            return datoChar();
        }
    }

    /**
     * Método para leer un valor de tipo short desde el teclado.
     * @return El valor ingresado como short.
     */
    public static short datoShort() {
        try {
            String sdato = dato();
            if (sdato == null) {
                System.out.println();
                return Short.MIN_VALUE;
            } else {
                return Short.parseShort(sdato);
            }
        } catch (NumberFormatException e) {
            System.out.print("Ese dato no es válido. Teclee otro: ");
            return datoShort();
        }
    }

    /**
     * Método para leer un valor de tipo int desde el teclado.
     * @return El valor ingresado como int.
     */
    public static int datoInt() {
        try {
            String sdato = dato();
            if (sdato == null) {
                System.out.println();
                return Integer.MIN_VALUE;
            } else {
                return Integer.parseInt(sdato);
            }
        } catch (NumberFormatException e) {
            System.out.print("Ese dato no es válido. Teclee otro: ");
            return datoInt();
        }
    }

    /**
     * Método para leer un valor de tipo long desde el teclado.
     * @return El valor ingresado como long.
     */
    public static long datoLong() {
        try {
            String sdato = dato();
            if (sdato == null) {
                System.out.println();
                return Long.MIN_VALUE;
            } else {
                return Long.parseLong(sdato);
            }
        } catch (NumberFormatException e) {
            System.out.print("Ese dato no es válido. Teclee otro: ");
            return datoLong();
        }
    }

    /**
     * Método para leer un valor de tipo float desde el teclado.
     * @return El valor ingresado como float.
     */
    public static float datoFloat() {
        try {
            String sdato = dato();
            if (sdato == null) {
                System.out.println();
                return Float.NaN; // Representa "no es un número" (NaN)
            } else {
                Float f = new Float(sdato);
                return f.floatValue();
            }
        } catch (NumberFormatException e) {
            System.out.print("Ese dato no es válido. Teclee otro: ");
            return datoFloat();
        }
    }

    /**
     * Método para leer un valor de tipo double desde el teclado.
     * @return El valor ingresado como double.
     */
    public static double datoDouble() {
        try {
            Double d = new Double(dato());
            return d.doubleValue();
        } catch (NumberFormatException e) {
            System.out.print("Ese dato no es válido. Teclee otro: ");
            return datoDouble();
        } catch (NullPointerException e) {
            return Double.NaN; // Representa "no es un número" (NaN)
        }
    }
    
    public static double datoDouble5() {
        try {
            Double d = new Double(dato());
            return d.doubleValue();
        } catch (NumberFormatException e) {
            System.out.print("Ese dato no es válido. Teclee otro: ");
            return datoDouble();
        } catch (NullPointerException e) {
            return Double.NaN; // Representa "no es un número" (NaN)
        }
    }
}
