/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Carrera;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andy Jan
 */
public class Observador extends Thread {

    Thread liebre, tortuga;
    String ganador = null;

    public Observador(Thread liebre, Thread tortuga) {
        this.liebre = liebre;
        this.tortuga = tortuga;

    }

    @Override
    public void run() {
        while (ganador == null) {
            if (!liebre.isAlive() && !tortuga.isAlive()) {
                ganador = "Empate";
            } else {
                if (!liebre.isAlive()) {
                    ganador = "Liebre";
                    try {
                        tortuga.join();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Observador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (!tortuga.isAlive()) {
                        ganador = "Tortuga";
                        try {
                            liebre.join();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Observador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            Thread.yield();
        }
        System.out.println("Ganador: " + ganador);
    }
}
