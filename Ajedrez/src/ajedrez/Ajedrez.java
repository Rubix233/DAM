/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import Leer.Leer;

/**
 *
 * @author Administrador
 */
public class Ajedrez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /**
         * 
         */
        
         byte i, j, fila, col;
        
        boolean filaPar = false;
        boolean colPar = false;
        /*------------------------------------------------------------------*/
        /*Pedir fila y columna*/
        do {
            System.out.print("Introduzca la fila (1-8)");
            fila = (byte)Leer.datoShort();
        }while (fila < 1 || fila > 8);
        
        do {
            System.out.print("Introduzca la columna (1-8)");
            col = (byte)Leer.datoShort();
        }while (col < 1 || col > 8);
        /*------------------------------------------------------------------*/
        /*Recorre por todas las fila*/       
        for (i=1; i<=8; i++){
            /*Recorre cada columna de la fila en la que se encuentra*/
            for (j=1; j<=8; j++){
                /*Comprueba si es posicion posible de ficha*/
                if (j == col + (fila - i) || j == col -(fila - i)){
                    System.out.print("*  ");
                    colPar = !colPar;         
                }else{
                    /*Imprime el color de la casilla*/
                   
                    if (filaPar == colPar){				
			System.out.print("B  ");
                        colPar = !colPar;
                    }else {
			System.out.print("N  ");
                        colPar = !colPar;
                    }
                    
                    /*if (filaPar && colPar || !filaPar && !colPar){				
			System.out.print("B  ");
                        colPar = !colPar;
                    }else {
			System.out.print("N  ");
                        colPar = !colPar;
                    }*/
                    
                    
                    
                    /*if (filaPar){
                        if (colPar){
                            System.out.print("B  ");
                            colPar = !colPar;
                        } else {
                            System.out.print("N  ");
                            colPar = !colPar;
                        }
                    } else {
                        if (!colPar){
                            System.out.print("B  ");
                            colPar = !colPar;
                        } else {
                            System.out.print("N  ");
                            colPar = !colPar;
                        }
                    }*/
                }
            }
            filaPar = !filaPar; /*Cambia la fila entre par e impar*/
            System.out.println();   /*Empieza en una nueva linea*/
        } 
    }
}
