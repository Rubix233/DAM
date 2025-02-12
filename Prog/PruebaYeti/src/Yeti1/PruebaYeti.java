package Yeti1;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class PruebaYeti {
        
    public static void main(String[] args){
        Yeti yetiA;
        
        yetiA = new Yeti();

        System.out.println("Nuestro Yeti: ");
        yetiA.mostrarAtributos();
        
        System.out.println("Si le damos de comer...");
        yetiA.alimentarYeti();
        yetiA.mostrarAtributos();
        
        System.out.println("Si le damos de comer otra vez...");
        yetiA.alimentarYeti();
    }
    
}
