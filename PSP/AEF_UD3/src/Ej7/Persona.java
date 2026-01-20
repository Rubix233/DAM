/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej7;

/**
 *
 * @author Andy
 */
public class Persona extends Thread{
    private int origen;
    private int destino;
    private Ascensor ascensor;

    public Persona(String nombre, int origen, int destino, Ascensor ascensor) {
        this.setName(nombre);
        this.origen = origen;
        this.destino = destino;
        this.ascensor = ascensor;
    }

    @Override
    public void run() {
        // La persona intenta usar el ascensor
        ascensor.usarAscensor(this.getName(), origen, destino);
    }
}
