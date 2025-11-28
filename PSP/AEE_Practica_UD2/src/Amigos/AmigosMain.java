package Amigos;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class AmigosMain {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

        int max = 50000;
        int hilos = 1;
        
        long empezamos = System.currentTimeMillis();
        
        List<HiloAmigos> listaHilos = new ArrayList<>();

        for(int i = 0; i < hilos; i++){
            HiloAmigos h = new HiloAmigos(Integer.toString(i), i + 1, max, hilos);
            listaHilos.add(h);
            h.start();
        }
        for (HiloAmigos h : listaHilos) {
            try {
                h.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long acabamos = System.currentTimeMillis();
        System.out.println("Tiempo: " + (acabamos - empezamos) + "ms");

    }
}
