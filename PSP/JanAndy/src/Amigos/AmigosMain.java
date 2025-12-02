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
        //System.out.println(Runtime.getRuntime().availableProcessors());

        int max = 1000000;
        int hilos = Runtime.getRuntime().availableProcessors();
        
        int tamanoBase = max / hilos; 
        int resto = max % hilos;
        int inicioActual = 1;
        
        long empezamos = System.currentTimeMillis();
        
        List<HiloAmigos> listaHilos = new ArrayList<>();

        for(int i = 0; i < hilos; i++){
            int tamanoHilo = tamanoBase + (i < resto ? 1 : 0);
            int finActual = inicioActual + tamanoHilo - 1;
            
            HiloAmigos h = new HiloAmigos(Integer.toString(i), inicioActual, finActual);
            listaHilos.add(h);
            h.start();
            inicioActual = finActual + 1;
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
