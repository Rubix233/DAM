package Yeti2;



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
        Yeti yetiB;
        
        yetiA = new Yeti();

        System.out.println("Nuestro Yeti A: ");
        yetiA.mostrarAtributos();
        
        System.out.println("Si le damos de comer...");
        yetiA.alimentarYeti();
        yetiA.mostrarAtributos();
        
        yetiB = new Yeti('N','H',true, (byte)3);
        
        System.out.println("Nuestro Yeti B: ");
        yetiB.mostrarAtributos();
        
        System.out.println("Si le damos de comer...");
        yetiB.alimentarYeti();
        yetiB.mostrarAtributos();
        
        System.out.println("Si le damos de comer otra vez...");
        yetiB.alimentarYeti();
        //Volver a ver el yeti A
        System.out.println("Nuestro Yeti A: ");
        yetiA.mostrarAtributos();
    }
    
}
