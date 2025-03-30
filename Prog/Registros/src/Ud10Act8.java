/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
/*
 * Frecuencias de calificaciones. Se introduce por teclado una secuencia
de calificaciones (números enteros entre 0 y 10). La secuencia termina cuando se
introduce un número menor que 0 o mayor que 10. Programa que obtiene y
muestra la lista de frecuencias (número de repeticiones) de cada una de las notas.
 */
public class Ud10Act8 {
    public static void main(String[] args){
        //Entorno
        int[] notas;
        int intro;        
        
        //Algoritmo
        notas = new int[11];
        intro = 0;
        
        do{
           System.out.println("Introduzca una nota 0-10");
            intro = Leer.datoInt();
            if(intro <= 10 && intro >= 0){
               notas[intro]++;  
            }
        }while(intro <= 10 && intro >= 0);//Fin Mientras
        
        for(int i = 0; i<notas.length;i++){
            System.out.println("De "+i+" hay "+notas[i]);
        }//Fin Para
    }//Fin Programa
}
