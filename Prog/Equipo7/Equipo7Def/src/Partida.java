/**
 * Clase que representa una partida del juego, gestionando el turno,
 * el estado del tablero y el final de la partida.
 * 
 * @author Equipo7
 */
public class Partida {
    // Atributos

    private Tablero tablero = new Tablero();
    private char[] fichas = {1, 2};
    private byte turno;
    private boolean esFinPartida;

    // Constructores:

    /**
     * Constructor por defecto que inicializa el tablero
     * y lo pinta al comenzar la partida.
     */
    public Partida() {
        tablero.PintaTablero();
    }

    // Métodos:

    /**
     * Devuelve el turno actual del jugador.
     * 
     * @return el valor del turno (0 o 1).
     */
    public byte getTurno() {
        return turno;
    }

    /**
     * Indica si la partida ha finalizado.
     * 
     * @return true si la partida ha terminado; false en caso contrario.
     */
    public boolean esFinPartida() {
        return esFinPartida;
    }

    /**
     * Ejecuta una tirada del jugador actual en la columna indicada.
     * Si la tirada es válida, coloca la ficha, actualiza el estado del tablero,
     * comprueba si hay ganador o si el tablero está lleno, y alterna el turno si la partida continúa.
     * 
     * @param col columna donde el jugador actual desea colocar su ficha.
     * @return true si la tirada ha sido válida y la ficha se colocó; false en caso contrario.
     */
    public boolean tirada(byte col) {
        // Entorno:
        boolean valido;
        valido = tablero.colocaFicha(fichas[turno], tablero.buscaVacio(col), col);
        if (valido) {
            esFinPartida = tablero.estaLleno() || tablero.haGanado(fichas[turno]);
            tablero.PintaTablero();
            if (!esFinPartida) {
                turno = (byte) ((turno + 1) % 2);
            }
        }

        return valido;
    }

    /**
     * Devuelve el número del jugador que ha ganado la partida.
     * 
     * @return 0 si no hay ganador; 1 o 2 dependiendo del jugador que ha ganado.
     */
    public byte getGanador() {
        // Entorno:
        byte ganador;
        // Algoritmo
        ganador = 0;
        if (tablero.haGanado(fichas[turno])) {
            ganador = (byte) (turno + 1);
        }

        return ganador;
    }
}
