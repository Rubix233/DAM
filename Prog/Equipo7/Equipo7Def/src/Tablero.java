/**
 * Clase que representa un tablero de juego con una matriz de celdas,
 * donde se pueden colocar fichas y verificar si algún jugador ha ganado.
 * 
 * @author Equipo7
 */
public class Tablero {
    // Atributos

    private char[][] matriz;
    private byte numeroFichasIntroducidas;
    private byte ultimaColumna;
    private byte ultimaFila;

    // Constructores

    /**
     * Constructor por defecto que inicializa el tablero con espacios vacíos.
     */
    public Tablero() {
        // Entorno:
        byte i, j;
        // Algoritmo
        matriz = new char[6][8];
        for (i = 0; i < matriz.length; i++) {
            for (j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = 32;
            }
        }
    }

    // Métodos

    /**
     * Comprueba si el tablero está completamente lleno.
     * 
     * @return true si no se pueden introducir más fichas; false en caso contrario.
     */
    public boolean estaLleno() {
        return numeroFichasIntroducidas >= matriz.length * matriz[0].length;
    }

    /**
     * Busca la primera fila vacía en una columna dada.
     * 
     * @param col la columna donde se quiere buscar una celda vacía.
     * @return la fila vacía más baja en la columna, o -1 si no hay espacio o la columna es inválida.
     */
    public byte buscaVacio(byte col) {
        // Entorno:
        byte i;

        // Algoritmo:
        i = (byte) (matriz.length - 1);
        if (col >= 0 && col < matriz[0].length) {
            while (i >= 0 && matriz[i][col] != 32) {
                i--;
            }
            if (i < 0) {
                i = -1;
            }
        } else {
            i = -1;
        }
        return i;
    }

    /**
     * Coloca una ficha en una posición específica del tablero.
     * 
     * @param ficha el carácter que representa la ficha a colocar.
     * @param fila la fila en la que colocar la ficha.
     * @param columna la columna en la que colocar la ficha.
     * @return true si la ficha se ha colocado correctamente; false en caso contrario.
     */
    public boolean colocaFicha(char ficha, byte fila, byte columna) {
        // Entorno:
        boolean fichaColocada;
        // Algoritmo:
        fichaColocada = false;
        if (columna >= 0 && columna <= 7 && fila >= 0 && fila <= 5
                && matriz[fila][columna] == 32) {
            matriz[fila][columna] = ficha;
            ultimaColumna = columna;
            ultimaFila = fila;
            fichaColocada = true;
            numeroFichasIntroducidas++;
        }
        return fichaColocada;
    }

    /**
     * Verifica si la ficha dada ha conseguido una condición de victoria.
     * 
     * @param ficha el carácter que representa la ficha a comprobar.
     * @return true si se detecta una secuencia ganadora; false en caso contrario.
     */
    public boolean haGanado(char ficha) {
        return compruebaFila(ficha) || compruebaColumna(ficha)
                || compruebaDiagonalPrincipal(ficha)
                || compruebaDiagonalSecundaria(ficha);
    }

    /**
     * Muestra el tablero actual por pantalla con sus celdas y fichas colocadas.
     */
    public void PintaTablero() {
        System.out.print("  ");
        for (int col = 0; col < matriz[0].length; col++) {
            System.out.print(" " + (col + 1) + "  ");
        }
        System.out.println();

        // Parte superior del tablero
        for (int fila = 0; fila < matriz.length; fila++) {
            // Línea superior de celdas
            System.out.print("  ");
            for (int col = 0; col < matriz[fila].length; col++) {
                System.out.print("+---");
            }
            System.out.println("+");

            // Contenido de las celdas
            System.out.print((fila + 1) + " ");
            for (int col = 0; col < matriz[fila].length; col++) {
                System.out.print("| " + matriz[fila][col] + " ");
            }
            System.out.println("|");
        }

        // Parte inferior del tablero
        System.out.print("  ");
        for (int col = 0; col < matriz[0].length; col++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }

    // Métodos privados de comprobación de victoria

    /**
     * Comprueba si hay 4 fichas iguales consecutivas en la misma fila.
     * 
     * @param ficha el carácter que representa la ficha a comprobar.
     * @return true si hay al menos 4 fichas consecutivas en fila; false en caso contrario.
     */
    private boolean compruebaFila(char ficha) {
        // Entorno
        byte contador, col;
        // Algoritmo
        contador = 1;
        col = (byte) (ultimaColumna - 1);
        while (col >= 0 && matriz[ultimaFila][col] == ficha) {
            contador++;
            col--;
        }

        col = (byte) (ultimaColumna + 1);
        while (col < matriz[0].length && matriz[ultimaFila][col] == ficha) {
            contador++;
            col++;
        }

        return contador >= 4;
    }

    /**
     * Comprueba si hay 4 fichas iguales consecutivas en la misma columna.
     * 
     * @param ficha el carácter que representa la ficha a comprobar.
     * @return true si hay al menos 4 fichas consecutivas en columna; false en caso contrario.
     */
    private boolean compruebaColumna(char ficha) {
        // Entorno
        byte contador, fila;
        // Algoritmo
        contador = 1;

        fila = (byte) (ultimaFila + 1);
        while (fila < matriz.length && matriz[fila][ultimaColumna] == ficha) {
            contador++;
            fila++;
        }

        return contador >= 4;

    }

    /**
     * Comprueba si hay 4 fichas iguales consecutivas en la diagonal principal (\).
     * 
     * @param ficha el carácter que representa la ficha a comprobar.
     * @return true si hay al menos 4 fichas consecutivas en diagonal principal; false en caso contrario.
     */
    private boolean compruebaDiagonalPrincipal(char ficha) {
        // Entorno:
        byte contador, fila, columna;
        // Algoritmo
        contador = 1;
        fila = (byte) (ultimaFila - 1);
        columna = (byte) (ultimaColumna - 1);

        while (fila >= 0 && columna >= 0 && matriz[fila][columna] == ficha) {
            contador++;
            fila--;
            columna--;
        }

        fila = (byte) (ultimaFila + 1);
        columna = (byte) (ultimaColumna + 1);
        while (fila < matriz.length && columna < matriz[0].length
                && matriz[fila][columna] == ficha) {
            contador++;
            fila++;
            columna++;
        }

        return contador >= 4;

    }

    /**
     * Comprueba si hay 4 fichas iguales consecutivas en la diagonal secundaria (/).
     * 
     * @param ficha el carácter que representa la ficha a comprobar.
     * @return true si hay al menos 4 fichas consecutivas en diagonal secundaria; false en caso contrario.
     */
    private boolean compruebaDiagonalSecundaria(char ficha) {
        // Entorno:
        byte contador, fila, columna;
        // Algoritmo:
        contador = 1;
        fila = (byte) (ultimaFila - 1);
        columna = (byte) (ultimaColumna + 1);

        while (fila >= 0 && columna < matriz[0].length
                && matriz[fila][columna] == ficha) {
            contador++;
            fila--;
            columna++;
        }

        fila = (byte) (ultimaFila + 1);
        columna = (byte) (ultimaColumna - 1);
        while (fila < matriz.length && columna >= 0
                && matriz[fila][columna] == ficha) {
            contador++;
            fila++;
            columna--;
        }

        return contador >= 4;

    }
}
