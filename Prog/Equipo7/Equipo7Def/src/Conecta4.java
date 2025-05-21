/**
 * Clase principal del juego Conecta 4.
 * Controla el flujo general del juego: entrada de datos, turnos y mensaje final.
 * 
 * @author Equipo7
 */
public class Conecta4 {

    /**
     * Lee un valor de tipo byte desde la entrada estándar de forma segura.
     * Si el valor introducido está fuera del rango de un byte, se solicita de nuevo.
     * 
     * @return el valor introducido convertido a byte.
     */
    public static byte leerByte() {
        // Entorno:
        short valor;
        // Algoritmo:
        valor = Leer.datoShort();
        while (valor > Byte.MAX_VALUE || valor < Byte.MIN_VALUE) {
            System.out.println("Dato no válido: ");
            valor = Leer.datoShort();
        }
        return (byte) valor;
    }

    /**
     * Método principal que inicia y gestiona una partida del juego Conecta 4.
     * Permite a los jugadores introducir columnas hasta que haya un ganador o empate.
     * 
     * @param args argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Entorno:
        Partida partida;

        // Algoritmo

        partida = new Partida();

        while (!partida.esFinPartida()) {
            System.out.println("Turno del jugador: " + (partida.getTurno() + 1));
            System.out.print("Introduce una columna [1-8]: ");
            partida.tirada((byte) (leerByte() - 1));
        }
        if (partida.getGanador() == 0) {
            System.out.println("¡Empate! El tablero está lleno.");
        } else {
            System.out.println("¡Jugador " + partida.getGanador() + " ha ganado!");
        }
    }
}
