/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class ContadorPrueba {
    public static void main(String[] args){
        Contador c1;
        Contador c2;
        Contador c3;
        Contador c4;
        
        //PRUEBA CONTADOR
        // Constructor sin parámetros
        c1 = new Contador();
        System.out.println("Prueba constructor sin parámetros:");
        System.out.println("Valor inicial esperado: 0, obtenido: " 
                + c1.obtenerCuenta());
        System.out.println(c1.toString());
        /*
        // Constructor con incremento
        c2 = new Contador((byte) 5);
        System.out.println("Prueba constructor con incremento:");
        System.out.println("Valor inicial esperado: 0, obtenido: " 
                + c2.obtenerCuenta());

        // Constructor con valor e incremento
        c3 = new Contador(10, (byte) 3);
        System.out.println("Prueba constructor con valor e incremento:");
        System.out.println("Valor inicial esperado: 10, obtenido: " 
                + c3.obtenerCuenta());

        // Constructor copia
        c4 = new Contador(c3);
        System.out.println("Prueba constructor copia:");
        System.out.println("Valor esperado: 10, obtenido: " 
                + c4.obtenerCuenta());

        // Incremento con valor por defecto
        c1.incrementaCuenta();
        System.out.println("Prueba incremento con valor por defecto:");
        System.out.println("Valor esperado: 1, obtenido: " 
                + c1.obtenerCuenta());

        // Incremento con un valor 3
        c3.incrementaCuenta();
        System.out.println("Prueba incremento con valor específico:");
        System.out.println("Valor esperado: 13, obtenido: " 
                + c3.obtenerCuenta());

        // Iniciar cuenta
        c2.iniciaCuenta(50);
        System.out.println("Prueba iniciar cuenta:");
        System.out.println("Valor esperado: 50, obtenido: " 
                + c2.obtenerCuenta());

        // Incremento después de reiniciar el valor
        c2.incrementaCuenta();
        System.out.println("Prueba incremento después de reiniciar:");
        System.out.println("Valor esperado: 55, obtenido: " 
                + c2.obtenerCuenta());
                * */
    }
}
