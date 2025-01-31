/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Ud6Ej7 {
    public static void main(String[] args){

        final byte PERSONAS = 10;
        char topNombre;
        char botNombre;
        float topSueldo;
        float botSueldo;

        char introNombre;
        float introSueldo;

        System.out.print("Introduzca nombre de la persona 1:");
        topNombre = Leer.datoChar();
        botNombre = topNombre;
        System.out.print("Introduzca su sueldo: ");
        topSueldo = Leer.datoFloat();
        botSueldo = topSueldo;

        for (byte i = 2; i <= PERSONAS; i++) {
            System.out.print("Introduzca nombre de la persona " + i + ": ");
            introNombre = Leer.datoChar();
            System.out.print("Introduzca su sueldo: ");
            introSueldo = Leer.datoFloat();

            if (introSueldo > topSueldo) {
                topSueldo = introSueldo;
                topNombre = introNombre;
            } else {
                if (introSueldo < botSueldo) {
                    botSueldo = introSueldo;
                    botNombre = introNombre;
                }
            }
        }
        System.out.println("La persona "+topNombre+
                " tiene el mayor sueldo: "+topSueldo);
        System.out.println("La persona "+botNombre+
                " tiene el menor sueldo: "+botSueldo);


    }//Fin Programa
}
