/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Tablero {

    private char[][] matriz;
    private byte numeroFichasIntroducidas;
    byte ultimaColumna;
    byte ultimaFila;

    public Tablero() {
        this.matriz = new char[8][6];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                this.matriz[i][j] = '.';
            }
        }

        this.numeroFichasIntroducidas = 0;
        //System.out.println("Inicializando tablero. Fichas introducidas: " + this.numeroFichasIntroducidas);

    }

    public boolean estaLleno() {
        //System.out.println("Comprobando si el tablero está lleno. Fichas: " + this.numeroFichasIntroducidas);

        return this.numeroFichasIntroducidas >= 8*6;
    }

    public byte buscaVacio(byte col) {
        byte i = 0;
        if (col < 8) {
            if (this.matriz[col][0] == '.') {
                while (i < 5 && this.matriz[col][i + 1] == '.') {
                    i++;
                }
            } else {
                i = -1;
            }
        }
        
        return i;

    }

    public boolean colocaFicha(char ficha, byte fila, byte columna) {
        boolean colocado = false;

        if (fila != -1 && columna >= 0 && columna < 8) {
            //if (this.matriz[columna][fila] == '.') {
                this.matriz[columna][fila] = ficha;
                colocado = true;
                this.ultimaColumna = columna;
                this.ultimaFila = fila;
                this.numeroFichasIntroducidas++;
                //System.out.println("Ficha colocada en columna: " + columna + ", fila: " + fila);
                //System.out.println("Fichas introducidas: " + this.numeroFichasIntroducidas);
           // }
        }

        return colocado;
    }

    public boolean haGanado(char ficha) {
        return compruebaFila(ficha) || compruebaColumna(ficha) || compruebaDiagonalPrincipal(ficha) || compruebaDiagonalSecundaria(ficha);
    }

    private boolean compruebaFila(char ficha) {
        byte posX = this.ultimaColumna;
        byte posY = this.ultimaFila;
        byte cont = 0;
       
        //Buscamos la primera de la secuencia
        while (posX > 0 && this.matriz[posX - 1][posY] == ficha) {
            posX--;
        }
        //Contamos cuantos seguidos hay
        while (posX < 6 && this.matriz[posX][posY] == ficha) {
            posX++;
            cont++;
        }

        return cont >= 4;
    }

    private boolean compruebaColumna(char ficha) {
        byte posX = this.ultimaColumna;
        byte posY = this.ultimaFila;
        byte cont = 0;

        // Buscar la primera ficha de la secuencia vertical
        while (posY > 0 && this.matriz[posX][posY - 1] == ficha) {
            posY--;
        }

        // Contar hacia abajo a partir de la primera ficha
        while (posY < 6 && this.matriz[posX][posY] == ficha) {
            cont++;
            posY++;
        }

        return cont >= 4;
    }

    private boolean compruebaDiagonalPrincipal(char ficha) {
        byte posX = this.ultimaColumna;
        byte posY = this.ultimaFila;
        byte cont = 0;

        //Buscamos la primera de la secuencia
        while (posX > 0 && posY > 0 && this.matriz[posX - 1][posY - 1] == ficha) {
            posX--;
            posY--;
        }
        //Contamos cuantos seguidos hay
        while (posX < 8 && posY < 6 && this.matriz[posX][posY] == ficha) {
            posX++;
            posY++;
            cont++;
        }
        return cont >= 4;
    }

    private boolean compruebaDiagonalSecundaria(char ficha) {
        byte posX = this.ultimaColumna;
        byte posY = this.ultimaFila;
        byte cont = 0;

        //Buscamos la primera de la secuencia
        while (posX > 0 && posY < 5 && this.matriz[posX - 1][posY + 1] == ficha) {
            posX--;
            posY++;
        }
        //Contamos cuantos seguidos hay
        while (posX < 8 && posY > 0 && this.matriz[posX][posY] == ficha) {
            posX++;
            posY--;
            cont++;
        }
       
        return cont >= 4;
    }

    public void pintaTablero() {
        for (int i = 0; i < 6; i++) {
            String fila = "";
            for (int j = 0; j < 8; j++) {
                fila += this.matriz[j][i] + "\t";
            }
            System.out.println(fila);
        }
        System.out.println("=========================================================");
    }
}
