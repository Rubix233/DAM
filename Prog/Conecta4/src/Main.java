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

        while (numero < -128 || numero > 127) {
            System.out.print("Dato incorrecto, introduzca otro: ");
            numero = Leer.datoShort();
        }

        dato = (byte) numero;
        return dato;
    }
    
    public static void main(String[] args){
       
        Partida partida = new Partida();
        byte intro;
        
        /*
        while(!partida.esFinPartida()){
            do{
                System.out.println("Jugador: "+ partida.getTurno()+" introduzca columna:");
                intro = datoByte();
            } while (partida.tirada(intro) || !partida.esFinPartida());
            
        }
        * */
        while (!partida.esFinPartida()) {
        System.out.println("Jugador: " + partida.getTurno() + " introduzca columna:");
        intro = datoByte();

        partida.tirada(intro);

        if (partida.esFinPartida()) {
            System.out.println("Partida terminada.");
            if (partida.getGanador() != -1) {
                System.out.println("El jugador " + partida.getGanador() + " ha ganado.");
            } else {
                System.out.println("La partida terminó en empate.");
            }
            
        }
    }
    }
}
