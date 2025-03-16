/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Extra7 {

    public static void main(String[] args) {
        //Entorno
        String intro = "andy jan juriev";
        String out = "";
        int pos = 0;
        int palabraG = 0;
        int palabras = 0;

        //Algoritmo
        intro += " ";
        while (intro.indexOf(" ", pos) != -1) {
            if (intro.substring(pos, intro.indexOf(" ", pos)).length() > palabraG) {
                palabraG = intro.substring(pos, intro.indexOf(" ", pos)).length();
            }//Fin Si
            pos = intro.indexOf(" ", pos) + 1;
            palabras++;
        }//Fin Mientras

        for (int i = 0; i <= palabraG; i++) {
            pos = 0;
            for (int j = 0; j < palabras; j++) {
                String palabra = intro.substring(pos, intro.indexOf(" ", pos));

                if (i < palabra.length()) {
                    out += palabra.substring(i, i + 1);
                } else {
                    if (i == palabra.length()) {
                        out += palabra.length();
                    } else {
                        out += " ";
                    }//Fin Si
                }//Fin Si
                pos = intro.indexOf(" ", pos) + 1;
                out += " ";
            }//Fin Para
            out += "\n";
        }//Fin Para

        System.out.println(out);
    }
}
