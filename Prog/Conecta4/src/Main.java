/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Main {

    public static byte datoByte() {
        byte dato;
        short numero;

        //System.out.print("Introduzca numero: ");
        numero = Leer.datoShort();

        while (numero < Byte.MIN_VALUE || numero > Byte.MAX_VALUE) {
            System.out.print("Dato incorrecto, introduzca otro: ");
            numero = Leer.datoShort();
        }

        dato = (byte) numero;
        return dato;
    }

    public static void main(String[] args) {

        Partida partida = new Partida();
        byte intro;

        while (!partida.esFinPartida()) {
            System.out.println("Jugador: " + (partida.getTurno() + 1) + " introduzca columna:");
            intro = datoByte();

            partida.tirada((byte) (intro - 1));
        }
        
        
        System.out.println("Partida terminada.");
        if (partida.getGanador() != -1) {
            System.out.println("El jugador " + (partida.getGanador() + 1) + " ha ganado.");
        } else {
            System.out.println("La partida terminó en empate.");
        }
    }
}
