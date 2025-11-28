package Amigos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Andy Jan
 */
public class Calculadora {
    
    
    
    public static int sumarDivisores(int numero){
        if (numero <= 1) return 0;
        
        //Empezamos en 1 y vamos hasta la raiz cuadrada
        int suma = 1;
        double raiz = Math.sqrt(numero);
        
        for (int i = 2; i <= raiz; i++) {
            if (numero % i == 0) {
                suma += i;
                //Si i es un divisor (4 de 100) entonces n/i tambien lo es (25)
                if (i != (numero / i)) {
                    suma += (numero / i);
                }
            }
        }
        return suma;
    }
    
    public static int sonAmigos(int n1){
        int n2 = sumarDivisores(sumarDivisores(n1));
        
        //Por si es un numero que ya hemos visto
        if (n2 == n1 || n2 <= 1) {
            return -1;
        }       
        if (sumarDivisores(n2) == n1) {
            return n2;
        }
        return -1;
        

    }
}
