package amigos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Andy Jan
 */
public class AmigosMain {

    public static void main(String[] args) {
        //System.out.println(Runtime.getRuntime().availableProcessors());

        int max = 500000;
        int hilos = 32;
        int rango = (int) Math.ceil((double) max / hilos);
        int puntero = 0;
        
        for(int i = 0; i < hilos; i++){
            int start = puntero +1;
            int finish = Math.min(start + rango - 1, max);
            puntero = finish;
            if(start < max) new HiloAmigos(Integer.toString(i),start,finish).start();
        }

    }
}
