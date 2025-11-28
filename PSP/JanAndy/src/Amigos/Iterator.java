package Amigos;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gemini
 */
public class Iterator {
    // Configuración de la prueba

    private static final int MAX_NUMERO = 1000000; // 1 Millón
    private static final int MAX_HILOS = 10;       // Probar de 1 a 10 hilos
    private static final int REPETICIONES = 20;    // 20 veces cada prueba

    public static void main(String[] args) {
        int procesadores = Runtime.getRuntime().availableProcessors();
        System.out.println("=== INICIANDO BENCHMARK ===");
        System.out.println("Procesadores lógicos detectados: " + procesadores);
        System.out.println("Buscando amigos hasta: " + MAX_NUMERO);
        System.out.println("Repeticiones por configuración: " + REPETICIONES);
        System.out.println("--------------------------------------------------");

        // Bucle externo: Cantidad de hilos (de 1 a 10)
        for (int h = 1; h <= MAX_HILOS; h++) {

            long tiempoTotalAcumulado = 0;

            // Bucle interno: Repeticiones para sacar media (20 veces)
            for (int r = 0; r < REPETICIONES; r++) {
                // Llamamos a la lógica y sumamos el tiempo que tardó
                tiempoTotalAcumulado += ejecutarLogica(h, MAX_NUMERO);

                // Opcional: Sugerir al Garbage Collector que limpie entre pruebas pesadas
                // para que la memoria llena no afecte a la siguiente prueba
                // System.gc(); 
            }

            // Calcular media
            double tiempoMedio = (double) tiempoTotalAcumulado / REPETICIONES;

            // Imprimir resultado
            System.out.println("Hilos: " + h + " \t| Tiempo Medio: " + String.format("%.2f", tiempoMedio) + " ms");
        }

        System.out.println("--------------------------------------------------");
        System.out.println("=== FIN DEL BENCHMARK ===");
    }

    /**
     * Contiene tu lógica original de partición de rangos y gestión de hilos.
     *
     * @return long Tiempo en milisegundos que tardó esta ejecución.
     */
    public static long ejecutarLogica(int numeroHilos, int max) {

        // 1. Cálculo de rangos (Tu lógica matemática)
        int tamanoBase = max / numeroHilos;
        int resto = max % numeroHilos;
        int inicioActual = 1;

        List<HiloAmigos> listaHilos = new ArrayList<>();

        long start = System.currentTimeMillis();

        // 2. Creación y lanzamiento de hilos
        for (int i = 0; i < numeroHilos; i++) {
            // Repartir el resto: si i < resto, le toca 1 numero más
            int tamanoHilo = tamanoBase + (i < resto ? 1 : 0);
            int finActual = inicioActual + tamanoHilo - 1;

            // Instanciamos tu clase HiloAmigos
            // Nota: Asegúrate de que HiloAmigos acepte (nombre, inicio, fin) en el constructor
            HiloAmigos h = new HiloAmigos(Integer.toString(i), inicioActual, finActual);
            listaHilos.add(h);
            h.start();

            // Actualizamos el inicio para el siguiente hilo
            inicioActual = finActual + 1;
        }

        // 3. Barrera (Join): Esperar a que todos terminen
        for (HiloAmigos h : listaHilos) {
            try {
                h.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();

        return (end - start);
    }
}
