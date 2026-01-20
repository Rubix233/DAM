/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej7;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Andy
 */
public class Main {
    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor();
        Thread[] personas = new Thread[4];
        
        personas[0] = new Persona("Pepe", 1, 5, ascensor);
        personas[1]= new Persona("Luis", 2, 8, ascensor);
        personas[2] = new Persona("Veronica", 8, 1, ascensor);
        personas[3] = new Persona("Azofaifa", 3, 0, ascensor);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < personas.length; i++) {
            personas[i].start();
        }
        
        for (int i = 0; i < personas.length; i++) {
            try {
                personas[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("\n\n--- Se acabo lo que sedaba---");
    }
}
