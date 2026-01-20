/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej7;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Andy
 */
public class Ascensor {

    private int plantaActual;
    private Semaphore semaforo;
    private final int PLANTAS = 10;

    public Ascensor() {
        this.plantaActual = 0; 
        this.semaforo = new Semaphore(1, true); // Una persona y modo FIFO
        pintarAscensor("Esperando..."); 
    }

public void usarAscensor(String persona, int origen, int destino) {
        try {

            pintarAscensor("" + persona + " llama desde planta " + origen);
            
            semaforo.acquire();

            moverAscensor(origen, "Recogiendo " + persona + " de P" + origen);

            moverAscensor(destino, "Llevando a " + persona + " a P" + destino);

            pintarAscensor("" + persona + " ha salido. Libre en P" + plantaActual);

            Thread.sleep(1000); 

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }
    }

private void moverAscensor(int destino, String mensaje) {
        if (plantaActual == destino) return;

        int direccion = (destino > plantaActual) ? 1 : -1;

        try {
            while (plantaActual != destino) {
                Thread.sleep(1000); 

                plantaActual += direccion;

                pintarAscensor(mensaje);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
private synchronized void pintarAscensor(String mensaje) {
        StringBuilder sb = new StringBuilder();
        int anchoMaximo = 79; 
        sb.append("\r|"); 

        for (int i = 0; i <= PLANTAS; i++) {
            if (i == plantaActual) {
                sb.append("[#]"); // El ascensor
            } else {
                sb.append(" * "); // Hueco vacío
            }
        }
        sb.append("|Estado: ").append(mensaje);


        if (sb.length() > anchoMaximo) {
            sb.setLength(anchoMaximo); 
        } 
        else {
            while (sb.length() < anchoMaximo) {
                sb.append(" ");
            }
        }
        System.out.print(sb.toString());
    }
}
