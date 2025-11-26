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
        int hilos = 1;
        
        for(int i = 0; i < hilos; i++){
            int rango = max/hilos;
            int start = i*rango;
            int finish = start+rango;
            
            new HiloAmigos(Integer.toString(i),start,finish).start();
        }
        

    }
}
