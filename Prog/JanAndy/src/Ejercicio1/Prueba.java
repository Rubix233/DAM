/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.util.GregorianCalendar;

/**
 *
 * @author Andy Jan
 */
public class Prueba {
     public static void main(String[] args) {
        // Crear fecha de matriculación
        GregorianCalendar fecha = new GregorianCalendar(2010, 4, 15); // 15 de mayo de 2010

        // Crear un Autobus
        Autobus autobus = new Autobus("Mercedes", "Autobus", fecha, "1234-ABC", (byte) 30);
        System.out.println("AUTOBUS");
        System.out.println("Marca: " + autobus.getMarca());
        System.out.println("Modelo: " + autobus.getModelo());
        System.out.println("Fecha Matriculación: " + autobus.getFechaMatriculacion().getTime());
        System.out.println("Matrícula: " + autobus.getMatricula());
        System.out.println("Plazas: " + autobus.getPlazas());
        System.out.println();

        // Crear un Camion
        Camion camion = new Camion("Volvo", "Camion", fecha, "5678-DEF", 18000f);
        System.out.println("CAMIÓN");
        System.out.println("Marca: " + camion.getMarca());
        System.out.println("Modelo: " + camion.getModelo());
        System.out.println("Fecha Matriculación: " + camion.getFechaMatriculacion().getTime());
        System.out.println("Matrícula: " + camion.getMatricula());
        System.out.println("Carga: " + camion.getCarga() + " kg");
        System.out.println();

        // Crear un Especial
        Especial especial = new Especial("Skoda", "Especial", fecha, "9012-GHI", (byte) 3);
        especial.setCarga(9000f); // Total entre 3 compartimentos
        System.out.println("ESPECIAL");
        System.out.println("Marca: " + especial.getMarca());
        System.out.println("Modelo: " + especial.getModelo());
        System.out.println("Fecha Matriculación: " + especial.getFechaMatriculacion().getTime());
        System.out.println("Matrícula: " + especial.getMatricula());
        System.out.println("Compartimentos: " + especial.getCompartamientos());
        System.out.println("Carga por compartimento: " + especial.getCarga() + " kg");
        System.out.println("Descripción: " + especial.getDescripcion());
    }
}
