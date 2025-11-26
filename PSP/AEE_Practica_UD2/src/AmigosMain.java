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
        int max = 100000;
        int hilos = 16;
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
