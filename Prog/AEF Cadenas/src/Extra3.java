/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Extra3 {

    public static void main(String[] args) {
        //Entorno
        String intro;
        String tlf;
        
        //Algoritmo
        do {
            System.out.print("Introduzca numero tlf de 10 digitos: ");
            intro = Leer.dato();

        }while (!intro.matches("\\d{10}"));//Fin Mientras
        
        tlf = "("+intro.substring(0, 2)+")-"+intro.substring(2, 3)+"-"+intro.substring(3);
        System.out.println(tlf);
    }
}
