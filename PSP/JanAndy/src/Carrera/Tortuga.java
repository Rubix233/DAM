/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Carrera;

import static Carrera.Liebre.duerme;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andy Jan
 */
public class Tortuga extends Thread{

    static final int avanceRapido = 3;
    static final int resbalo = -6;
    static final int avanceLento = 1;

    int posicion = 1;
    Random r = new Random();

    @Override
    public void run() {
        do {
            moverse(movimiento());
            pintarse();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Liebre.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (posicion < 70);
        System.out.println("Soy la tortuga y he llegado");
    }

    private void moverse(int movimiento) {
        //System.out.println(movimiento);
        switch (movimiento) {
            case 1:
                posicion += avanceRapido;
                break;

            case 2:
                posicion += resbalo;
                if (posicion < 1) {
                    posicion = 1;
                }
                break;

            case 3:
                posicion += avanceLento;
        }

    }

    private int movimiento() {
        int generado = r.nextInt(101);

        if (generado < 50) {
            return 1;
        }
        if (generado < 70) {
            return 2;
        }
        return 3;
    }

    private void pintarse() {
        StringBuilder pista = new StringBuilder();
        int posVisual = Math.min(this.posicion, 69);

        for (int i = 0; i < 70; i++) {
            if (i == posVisual) {
                pista.append("T");
            } else {
                pista.append("-");
            }
        }
        System.out.println(pista.toString());
    }
}
