/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Recursivas {

    public static int potencia(int b, int e) {
        int f;

        if (e == 0) {
            f = 1;
        } else {
            if (e == 1) {
                f = b;
            } else {
                f = b * potencia(b, e - 1);
            }
        }
        return f;
    }

    public static int fibonacci(int x) {
        int f;
        if (x == 0 ||x == 1) {
            f = x;
        } else {
            f = fibonacci(x - 1) + fibonacci(x - 2);
        }
        return f;
    }
}
