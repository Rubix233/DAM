
import java.util.Arrays;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Notas {

    public static void main(String[] args) {
        //Entorno
        float[][] tabla;
        byte asignaturas = 3;
        byte alumnos = 10;
        float media;

        //Algoritmo
        tabla = new float[asignaturas][alumnos];

        for (byte i = 0; i < alumnos; i++) {
            for (byte j = 0; j < asignaturas; j++) {
                System.out.println("Introduzca dato de asignatura " + (j+1) + " alumno " + (i+1));
                tabla[j][i] = Leer.datoFloat();
            }//Fin Para
        }//Fin Para
       
        
        
        for (byte i = 0; i < alumnos; i++){
            media = 0;
            for(byte j =0;j<asignaturas;j++){
                media += tabla[j][i];
            }//Fin Para
            media = media / asignaturas;
            System.out.println("El alumno "+(i+1)+" tiene de media "+media);
        }//Fin Para
        
        for (byte i = 0; i < asignaturas; i++){
            media = 0;
            for(byte j =0;j < alumnos;j++){
                media += tabla[i][j];
            }//Fin Para
            media = media / alumnos;
            System.out.println("La asignatura "+(i+1)+" tiene de media "+media);
        }//Fin Para
        
    }//Fin Programa
}
