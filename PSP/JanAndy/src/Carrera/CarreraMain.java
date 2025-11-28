/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Carrera;

/**
 *
 * @author Administrador
 */
public class CarreraMain {
    public static void main(String[] args) {
        Liebre liebre = new Liebre();
        Tortuga tortuga = new Tortuga();
        Observador observador = new Observador(liebre, tortuga);
        
        liebre.start();
        tortuga.start();
        observador.start();
    }
}
