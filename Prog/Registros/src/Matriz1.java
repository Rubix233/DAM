/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Matriz1 {
    public static void main(String[] args){
        //Entorno
        int[][] tabla;
        byte filas = 3;
        byte columnas = 4;
        
        //Algoritmo
        tabla = new int[filas][columnas];
        
        for (byte i = 0; i < filas; i++){
            for(byte j = 0; j < columnas; j++){
                System.out.println("Introduzca dato de fila "+i+ " columna "+j);
                tabla[i][j] = Leer.datoInt();
            }   
        }
        
        
        
        
        
    }//Fin Programa
}
