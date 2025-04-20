/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

/**
 *
 * @author Andy Jan
 */
public class AElectrodomesticos {
    public static void main(String[] args){
        Electrodomestico[] lista = new Electrodomestico[10];
        float totalTelevisores = 0;
        float totalLavadoras = 0;
        float totalElectrodomesticos = 0;
        
        // Crear objetos solo de clases concretas: Lavadora y Television
        lista[0] = new Lavadora(200, 30, "BLANCO", 'B', 25);
        lista[1] = new Television(500, 25, "NEGRO", 'C', 50, true);
        lista[2] = new Lavadora(150, 40, "GRIS", 'A', 35);
        lista[3] = new Television(300, 15, "AZUL", 'E', 32, false);
        lista[4] = new Lavadora(180, 50, "BLANCO", 'B', 40);
        lista[5] = new Television(400, 22, "NEGRO", 'A', 42, true);
        lista[6] = new Lavadora(160, 35, "AZUL", 'C', 33);
        lista[7] = new Television(450, 30, "ROJO", 'D', 45, true);
        lista[8] = new Lavadora(170, 20, "BLANCO", 'F', 28);
        lista[9] = new Television(350, 28, "GRIS", 'B', 38, false);
        
        for(int i = 0; i < lista.length; i++){
            float precio = lista[i].precioFinal();
            
            if(lista[i] instanceof Lavadora){
                totalLavadoras += precio;
            }
            if(lista[i] instanceof Television){
                totalTelevisores += precio;
            }
            totalElectrodomesticos += precio;
        }
        
        System.out.println("Total precio Lavadoras: " + totalLavadoras + " €");
        System.out.println("Total precio Televisiones: " + totalTelevisores + " €");
        System.out.println("Total precio Electrodomésticos: " + totalElectrodomesticos + " €");
        
    }
    
}
