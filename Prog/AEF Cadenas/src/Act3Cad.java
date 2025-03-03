
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy Jan
 */
public class Act3Cad {
    public static String strInvertido(String intro) {
        String invertido = "";

        if (intro.matches(".*[.!?,;:]$")) {
            for (int i = intro.length() - 2; i >= 0; i--) {
                invertido += intro.charAt(i);
            }//Fin Para
            invertido += intro.charAt(intro.length() - 1);
        } else {
            for (int i = intro.length() - 1; i >= 0; i--) {
                invertido += intro.charAt(i);
            }//Fin Para
        }//Fin Si
        return invertido;
    }

    public static String codificado(String intro) {
        String string;

        intro = intro.trim();

        if (intro.indexOf(" ") != -1) {
            string = strInvertido(intro.substring(0, intro.indexOf(" ")))
                    + " "
                    + codificado(intro.substring(intro.indexOf(" ")));
        } else {
            string = strInvertido(intro);
        }//Fin Si

        return string;

    }

    public static void main(String[] args) {
        //Entorno
        String introducido;
        String codificado;
        //Algoritmo
        do {
            System.out.print("Introduce tu cadena: ");
            introducido = Leer.dato();
        } while (!introducido.matches("^.{1,256}$"));
        codificado = codificado(introducido);
        System.out.println("Codificado: " + codificado);
        System.out.println("Version descodificada: " + codificado(codificado));

    }//Fin Programa
}
