/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Carrera;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andy Jan
 */
public class Liebre extends Thread {

    static final int duerme = 2;
    static final int granSalto = 9;
    static final int resbalonGrande = -12;
    static final int pequenoSalto = 1;
    static final int resbalonPequeno = -2;
    
    int posicion = 0;
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
        System.out.println("Soy la liebre y he llegado");
    }

    private void moverse(int movimiento) {
        //System.out.println(movimiento);
        switch (movimiento) {
            case 1:
                try {
                    Thread.sleep(duerme * 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Liebre.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case 2:
                posicion += granSalto;
                break;

            case 3:
                posicion += resbalonGrande;
                if (posicion < 1) {
                    posicion = 1;
                }
                break;

            case 4:
                posicion += pequenoSalto;
                break;

            case 5:
                posicion += resbalonPequeno;
                if (posicion < 1) {
                    posicion = 1;
                }
        }
    }

    private int movimiento() {
        int generado = r.nextInt(101);

        if (generado < 20) {
            return 1;
        }
        if (generado < 40) {
            return 2;
        }
        if (generado < 50) {
            return 3;
        }
        if (generado < 80) {
            return 4;
        }
        return 5;
    }

    private void pintarse() {
        StringBuilder pista = new StringBuilder();
        int posVisual = Math.min(this.posicion, 69);

        for (int i = 0; i < 70; i++) {
            if (i == posVisual) {
                pista.append("L");
            } else {
                pista.append("-");
            }
        }
        System.out.println(pista.toString());
    }
}
