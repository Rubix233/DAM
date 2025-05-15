/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Partida {
    private Tablero tablero;
    private char[] fichas;
    private byte turno;
    private boolean esFinPartida;
    
    public Partida(){
        this.tablero = new Tablero();
        this.fichas = new char[] {'O','X'};
        this.turno = 0;
        this.esFinPartida = false;
        this.tablero.pintaTablero();
    }
    
    public byte getTurno(){
        return this.turno;
    }
    public boolean esFinPartida(){
        return this.esFinPartida;
    }
    public boolean tirada(byte col){
        
        char ficha = fichas[getTurno()];
        boolean tiradaValida;
        
        //System.out.println("Intentando colocar ficha en columna: " + col);

        if(this.tablero.colocaFicha(ficha, this.tablero.buscaVacio(col), col)){
            this.tablero.pintaTablero();
            tiradaValida = true;
 
            //System.out.println("Ficha: " + ficha);
            //System.out.println("haGanado: " + this.tablero.haGanado(ficha));
            //System.out.println("estaLleno: " + this.tablero.estaLleno());
            //System.out.println("ultimaFila: " + this.tablero.ultimaFila + ", ultimaColumna: " + this.tablero.ultimaColumna);

            
            this.esFinPartida = this.tablero.estaLleno() || this.tablero.haGanado(this.fichas[getTurno()]);
            
            if(!this.esFinPartida){
                if(this.turno == 0){
                    this.turno++;
                }else {
                    this.turno = 0;
                }
                
            } else {
                System.out.println("Fin");
            }
            
        }else{
            System.out.println("Columna llena o no valida, prueba otra.");
            tiradaValida = false;
        }
        
     return tiradaValida;   
    }
    public byte getGanador(){
        byte ganador = -1;
        if(this.tablero.haGanado(this.fichas[getTurno()])){
            ganador = getTurno();
        }
        
        return ganador;
    }
}
