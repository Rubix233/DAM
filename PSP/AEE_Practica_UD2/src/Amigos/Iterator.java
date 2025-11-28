package Amigos;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Iterator {
    public static void main(String[] args) {
        
        int max = 50000;
        int startThreads = 1;
        int endThreads = 20;
        int numberOfTests = 20;

        System.out.println("Benchmarking " + max + " numbers.");
        System.out.println("Running " + numberOfTests + " tests per thread count.");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-10s | %-20s%n", "Threads", "Avg Time (ms)");
        System.out.println("--------------------------------------------------");

        // OUTER LOOP: Thread Count (8 -> 32)
        for (int hilos = startThreads; hilos <= endThreads; hilos++) {
            
            long totalTimeForBatch = 0;

            // INNER LOOP: Repeat the test 10 times
            for (int run = 0; run < numberOfTests; run++) {
                
                long start = System.currentTimeMillis();
                
                List<HiloAmigos> listaHilos = new ArrayList<>();

                // 1. Launch Threads
                for(int i = 0; i < hilos; i++){
                    // Using the "Stride" logic (start, max, stride)
                    HiloAmigos h = new HiloAmigos(Integer.toString(i), i + 1, max, hilos);
                    listaHilos.add(h);
                    h.start();
                }

                // 2. Wait for Threads
                for (HiloAmigos h : listaHilos) {
                    try {
                        h.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                long end = System.currentTimeMillis();
                totalTimeForBatch += (end - start);
                
                // Optional: Garbage collection to keep memory clean between runs
                // System.gc(); 
            }

            // Calculate Average
            double avgTime = totalTimeForBatch / (double) numberOfTests;
            
            System.out.printf("%-10d | %-20.2f%n", hilos, avgTime);
        }
        
        System.out.println("--------------------------------------------------");
        System.out.println("Benchmark finished.");
    }
}
