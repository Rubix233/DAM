/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class HiloAmigos extends Thread {

    int min, max;

    public HiloAmigos(String name, int min, int max) {
        this.setName(name);
        this.min = min;
        this.max = max;
    }

    @Override
    public void run() {
        for (int i = min; i <= max; i++) {
            int n2 = Calculadora.sumarDivisores(Calculadora.calcularDivisores(i));
            if (Calculadora.sumarDivisores(Calculadora.calcularDivisores(n2)) == i) {
                System.out.println("" + i + " es amigo de " + n2);
            }
        }
    }
}
