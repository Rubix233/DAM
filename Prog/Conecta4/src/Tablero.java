/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Tablero {
    private char[][] tablero;
    final byte FILAS = 6;
    final byte COLUMNAS = 7;
    byte ultimaFila;
    byte ultimaColumna;
    
    public Tablero(){
        this.tablero = new char[COLUMNAS][FILAS];
        this.ultimaFila = FILAS - 1;
        this.ultimaColumna = COLUMNAS - 1;
        for(int i = 0; i < COLUMNAS; i++){
            for(int j = 0; j < FILAS; j++){
                this.tablero[i][j] = '.';
            }
        }
    }
    
    public void meteFicha(char ficha, byte pos){
        byte altura = ultimaFila;
        
        while(altura > 0 && this.tablero[pos][altura-1] == '.'){
            altura--;
        }
        if(this.tablero[pos][altura] == '.'){
            this.tablero[pos][altura] = ficha;
        }
    }
    
    public boolean haGanado(byte x, byte y, char ficha){
        boolean ganado = false;
        byte posX;
        byte posY;
        byte cont;
        
        //Vertical
        posX = x;
        posY = y;
        cont = 1;
        //Buscamos la primera de la secuencia
        while(posY > 0 && this.tablero[posX][posY-1] == ficha){
            posY--;
        }
        //Contamos cuantos seguidos hay
        while(posY < ultimaFila && this.tablero[posX][posY+1] == ficha){
            posY++;
            cont++;
        }
        if (cont > 3){
            ganado = true;
        }
        
        //Horizontal
        if (!ganado) {
            posX = x;
            posY = y;
            cont = 1;
            //Buscamos la primera de la secuencia
            while (posX > 0 && this.tablero[posX - 1][posY] == ficha) {
                posX--;
            }
            //Contamos cuantos seguidos hay
            while (posX < ultimaColumna && this.tablero[posX + 1][posY] == ficha) {
                posX++;
                cont++;
            }
            if (cont > 3) {
                ganado = true;
            }

        }
        //Diagonal ascendente
        if(!ganado){
            posX = x;
            posY = y;
            cont = 1;
            //Buscamos la primera de la secuencia
            while(posX > 0 && posY > 0 && this.tablero[posX-1][posY-1] == ficha){
                posX--;
                posY--;
            }
            //Contamos cuantos seguidos hay
            while(posX < ultimaColumna && posY < ultimaFila && this.tablero[posX+1][posY+1] == ficha){
                posX++;
                posY++;
                cont++;
            }
            if (cont > 3) {
                ganado = true;
            }
        }
        //Diagonal descendiente
        if(!ganado){
            posX = x;
            posY = y;
            cont = 1;
            //Buscamos la primera de la secuencia
            while(posX > 0 && posY < ultimaFila && this.tablero[posX-1][posY+1] == ficha){
                posX--;
                posY++;
            }
            //Contamos cuantos seguidos hay
            while(posX < ultimaColumna && posY > 0 && this.tablero[posX+1][posY-1] == ficha){
                posX++;
                posY--;
                cont++;
            }
            if (cont > 3) {
                ganado = true;
            }
        }
        
        return ganado;
    }
}
