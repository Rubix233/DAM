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
public class HiloAmigos extends Thread {

    int min, max;

    public HiloAmigos(String name, int min, int max) {
        this.setName(name);
        this.min = min;
        this.max = max;
    }

    @Override
    public void run() {
        buscarAmigosConCribaSegmentada(min,max);
        /*
         for (int i = min; i <= max; i ++) {
         /long n2 = Calculadora.sonAmigos(i);
         if (n2 != -1 && n2 > i) {
         //System.out.println("" + i + " es amigo de " + n2);
         }
            
         }*/
    }


    public void buscarAmigosConCribaSegmentada(int inicio, int fin) {
        int tamano = fin - inicio + 1;
        // Array local: sumas[0] representa al numero 'inicio', sumas[1] a 'inicio+1', etc.
        long[] sumaslocales = new long[tamano];

        // --- FASE 1: LLENADO (LA CRIBA) ---
        // Probamos divisores 'd' desde 1 hasta la mitad del número más grande del rango
        for (int d = 1; d <= fin / 2; d++) {

            // MAGIA MATEMÁTICA:
            // Encontramos el primer múltiplo de 'd' que cae dentro de nuestro rango [inicio, fin]
            // Fórmula: (inicio + d - 1) / d * d  -> redondeo hacia arriba entero
            long primerMultiplo = (long) (inicio + d - 1) / d * d;

            // Si el primer múltiplo calculado es menor que 'inicio' (por redondeo), ajustamos
            if (primerMultiplo < inicio) {
                primerMultiplo += d;
            }

            // IMPORTANTE: Si el múltiplo es igual al divisor (ej: 2 es múltiplo de 2),
            // no debemos sumarlo porque buscamos divisores PROPIOS (menores al número).
            if (primerMultiplo == d) {
                primerMultiplo += d;
            }

            // Recorremos el array local dando saltos de 'd'
            for (long m = primerMultiplo; m <= fin; m += d) {
                // m es el número, d es el divisor.
                // Ajustamos el índice restando 'inicio'
                sumaslocales[(int) (m - inicio)] += d;
            }
        }

        // --- FASE 2: VERIFICACIÓN DE AMIGOS ---
        for (int i = 0; i < tamano; i++) {
            long numA = inicio + i;      // El número real
            long numB = sumaslocales[i]; // La suma de sus divisores (posible amigo)

            // Condiciones básicas para no perder tiempo
            if (numB > numA) {

                // AHORA TENEMOS UN PROBLEMA PEQUEÑO:
                // Conocemos la suma de A (que es B). Pero necesitamos saber la suma de B
                // para ver si devuelve A.

                long sumaDeB = 0;

                // CASO 1: Si B cae dentro de NUESTRO propio rango, miramos nuestro array
                if (numB >= inicio && numB <= fin) {
                    sumaDeB = sumaslocales[(int) (numB - inicio)];
                } // CASO 2: Si B cae fuera, desgraciadamente tenemos que calcularlo a la antigua
                // (Pero esto pasa pocas veces, es muy rápido)
                else {
                    sumaDeB = sumarDivisoresManual(numB);
                }


                if (sumaDeB == numA) {
                    //System.out.println("Hilo [" + inicio + "-" + fin + "] encontró: " + numA + " y " + numB);
                }
            }
        }
    }

    private long sumarDivisoresManual(long n) {
        if (n <= 1) {
            return 0;
        }
        long suma = 1;
        if (n % 2 == 0) {
            suma += 2;
            long par = n / 2;
            if (par != 2) {
                suma += par;
            }
        }
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                suma += i;
                if (i != n / i) {
                    suma += n / i;
                }
            }
        }
        return suma;
    }
}
