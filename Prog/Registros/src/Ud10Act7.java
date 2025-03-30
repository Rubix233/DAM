/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
/*
 * Programa que cargue una tabla con 5 valores enteros (7,8,3,0,33) y
    hacer un programa que permita sucesivas consultas a dicha tabla, indicando si
    está en qué posición está y si no está, diciendo que no se encuentra.
 */
public class Ud10Act7 {
    public static void main(String[] args){
        //Entorno
        int[] tabla = {7,8,3,0,33};
        int intro;
        String continuar;
        boolean esta;
        //Algoritmo
        do{
          System.out.print("Introduzca el numero buscado:");
        intro = Leer.datoInt();
        esta = false;
        for(int i = 0; i < tabla.length; i++){
            if(intro == tabla[i]){
                esta = true;
                System.out.println("Tu numero se encuentra en la posicion "+(i+1));
            }
        }
        if(!esta){
            System.out.println("Su numero no se encuentra.");
        }
            do{
                System.out.println("Desea continuar? S/N");
            continuar = Leer.dato();
            }while(!continuar.matches("[sSnN]"));
        }while(!continuar.matches("[nN]"));
        
    }//Fin Programa
}
