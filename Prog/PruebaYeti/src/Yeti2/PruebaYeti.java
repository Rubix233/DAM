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
        Yeti yetiC;
        
        //Crear yeti distinto al default
        yetiA = new Yeti('R', 'H');
        System.out.println("Color yeti A: "+yetiA.getColor());
        System.out.println("Sexo yeti A: "+yetiA.getSexo());
        
        //Crear yeti usando otro yeti como parametro
        yetiB = new Yeti(yetiA);
        System.out.println("Color yeti B: "+yetiB.getColor());
        System.out.println("Color yeti B: "+yetiB.getSexo());
        
        //Cambiar el color
        yetiA.setColor('V');
        System.out.println("Color yeti A despues de cambio: "+yetiA.getColor());
        
        //Cambiar el sexo
        yetiA.setSexo('M');
        System.out.println("Sexo yeti A despues de cambio: "+yetiA.getSexo());
        
        //Cambiar hambriento
        System.out.println("Yeti B hambre: "+yetiB.getHambriento());
        yetiB.setHambriento(true);
        System.out.println("Yeti B hambre despues de cambio: "+yetiB.getHambriento());
        
        //Comprobar si son iguales
        System.out.println("Son iguales: "+yetiA.equals(yetiB));
        
        //Copiar atributos de un yeti
        yetiB.copia(yetiA);
        System.out.println("Son iguales despues de copiar: "+yetiA.equals(yetiB));
        
        //Crear otro yeti usando uno como mensaje
        yetiC = yetiA.copia();
        System.out.println("Yeti C:");
        yetiC.mostrarAtributos();
        
        //Copiar por clase
        yetiC.setColor('L');
        yetiC.setSexo('H');
        Yeti.copia(yetiC, yetiB);
        System.out.println("Yeti B post copia");
        yetiB.mostrarAtributos();
        
        /*
        //Crear yeti A
        yetiA = new Yeti();
        
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
