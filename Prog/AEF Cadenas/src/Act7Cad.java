/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Act7Cad {
    public static void parejas(String intro) {
        intro = intro.trim().toLowerCase();
        int length = intro.length() - 1;
        String visto = "";
        int count;

        for (int i = 0; i < length; i++) {
            String pareja = intro.substring(i, i + 2);
            count = 0;

            if (pareja.matches("[a-z]{2}") && !pareja.matches(visto)) {

                for (int j = 0; j < length; j++) {
                    if (intro.substring(j, j + 2).equals(pareja)) {
                        count++;
                    }//Fin Si
                }//Fin Para

                visto += pareja + "|";
                System.out.println("La combinacion de "
                        + intro.substring(i, i + 2)
                        + " aparece " + count + " veces.");
            }//Fin Si
        }//Fin Para
    }

    public static void main(String[] args) {
        //Entorno

        //Algoritmo
        parejas("Hola que tal la ola");

    }//Fin Programa
}


   /* public static void parejas(String intro){
        intro = intro.trim().toLowerCase();
        String intro2;
        int length = intro.length()-2;
        int i;
        int count;
        int pos;
        
        for (i = 0; i <= length; i++){
            count = 0;
            intro2 = intro;

            while (intro2.indexOf(intro.substring(i, i + 2)) >= i
                    && intro.substring(i, i + 2).matches("[a-z]{2}")) {
                
                while (intro2.indexOf(intro.substring(i, i + 2)) != -1) {
                    count++;
                    pos = intro2.indexOf(intro.substring(i, i + 2)) + 1;
                    intro2 = intro2.substring(pos);
                }//Fin Mientras
                System.out.println("La combinacion de " 
                        + intro.substring(i, i + 2) 
                        + " aparece " + count + " veces.");
            }//Fin Mientras
        }//Fin Para
    }*/