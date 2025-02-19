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
        Yeti jeff;
        Yeti andres;
        
        //Crear yeti A
        jeff = new Yeti('R', 'H');
        jeff.mostrarAtributos();
        
        andres = new Yeti(jeff);
        andres.mostrarAtributos();
        /*
        //Mostrar yeti A
        System.out.println("Nuestro Yeti A: ");
        yetiA.mostrarAtributos();
        
        //Darle de comer y mostrar yeti A
        System.out.println("Si le damos de comer...");
        yetiA.alimentarYeti();
        yetiA.mostrarAtributos();
        
        //Crear yeti B modificando la zona de yetis
        yetiB = new Yeti('N','H',true, (byte)3);
        
        //Mostrar yeti B
        System.out.println("Nuestro Yeti B: ");
        yetiB.mostrarAtributos();
        
        //Dar de comer y mostrar yeti B
        System.out.println("Si le damos de comer...");
        yetiB.alimentarYeti();
        yetiB.mostrarAtributos();
        
        //Volver a darle de comer
        System.out.println("Si le damos de comer otra vez...");
        yetiB.alimentarYeti();
        
        //Volver a ver el yeti A
        System.out.println("Nuestro Yeti A: ");
        yetiA.mostrarAtributos();
        */
        
        
        
    }
    
}
