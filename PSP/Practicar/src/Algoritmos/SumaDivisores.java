/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;

/**
 *
 * @author Andy
 */
public class SumaDivisores {
    public static int sumaDivisores(int n) {
    if (n <= 1) return 0;

    int suma = 1; // 1 siempre es divisor (excepto n=1)

    int limite = (int) Math.sqrt(n);

    for (int i = 2; i <= limite; i++) {
        if (n % i == 0) {
            suma += i;

            int otro = n / i;
            if (otro != i && otro != n) {
                suma += otro;
            }
        }
    }

    return suma;
}
}
