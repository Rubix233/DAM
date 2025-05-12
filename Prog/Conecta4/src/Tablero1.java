/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Tablero1 {
    private char[][] matriz;
    private byte numeroFichasIntroducidas;
    private byte ultimaColumna = 8;
    private byte ultimaFila = 6;
    
    public Tablero1(){
        this.matriz = new char[ultimaColumna][ultimaFila];
        
        for(int i = 0; i < ultimaColumna; i++){
            for(int j = 0; j < ultimaFila; j++){
                this.matriz[i][j] = '.';
            }
        }
        this.ultimaFila--;
        this.ultimaColumna--;
        this.numeroFichasIntroducidas = 0;
    }
    public boolean estaLleno(){
        boolean lleno = true;
        int i = 0;
        
        while(i <= ultimaColumna && lleno){
            if(this.matriz[i][0] == '.'){
                lleno = false;
            }
        }
        return lleno;
        
    }
    public byte buscaVacio(byte col){
        byte i = 0;
        
        if(this.matriz[col][0] == '.'){
            while (this.matriz[col][i+1] == '.'){
                i++;
            }
        } else {
            i = -1;
        }
        
        return i;
        
    }
    public boolean colocaFicha(char ficha, byte fila, byte columna){
        boolean colocado = false;
        
        if (fila >= 0 && fila <= ultimaFila && columna >= 0 && columna <= ultimaColumna) {
            if (this.matriz[columna][fila] == '.') {
                this.matriz[columna][fila] = ficha;
                colocado = true;
            }
        }
        
        return colocado;
    }
    
    public boolean haGanado(char ficha){
        return compruebaFila(ficha) || compruebaColumna(ficha) || compruebaDiagonalPrincipal(ficha) || compruebaDiagonalSecundaria(ficha);
    }
    
    private boolean compruebaFila(char ficha){
        byte i = 0;
        byte j = 0;
        byte consecutivos;
        boolean ganado = false;
        
        while(i <= ultimaFila && !ganado){
            j = 0;
            consecutivos = 0;
            while(j <= ultimaColumna && !ganado){
                if (this.matriz[j][i] == ficha){
                    consecutivos++;
                    if (consecutivos > 3){
                        ganado = true;
                    }
                } else {
                    consecutivos = 0;
                } // Por aqui
                
            }
        }
        
    }
    
    private boolean compruebaColumna(char ficha){
        
    }
    private boolean compruebaDiagonalPrincipal(char ficha){
        
    }
    private boolean compruebaDiagonalSecundaria(char ficha){
        
    }
    public void pintaTablero(){
        
    }
}
