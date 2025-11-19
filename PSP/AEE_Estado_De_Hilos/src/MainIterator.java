/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class MainIterator {
    public static void main(String[] args) {
        int i = 0;
        HiloIterador h1,h2;
        h1 = new HiloIterador("H1", 10);
        h2 = new HiloIterador("H2", 20);
        System.out.println("Iniciando programa");
        h1.start();
        h2.start();
        while(h1.isAlive() || h2.isAlive()){
            i++;
        }
        System.out.println("El programa ha terminado");
        
    }
}
