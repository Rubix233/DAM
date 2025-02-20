/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adndy Jan
 */
public class Prueba {
    public static void main(String[] args){
        Numero numeroPrueba;
        Consumo consumoPrueba;
        Finanzas finanzasPrueba;
        Contador c1;
        Contador c2;
        Contador c3;
        Contador c4;
        
        //PRUEBA NUMERO
        /*
        numeroPrueba = new Numero(10);
        
        System.out.println(numeroPrueba.getValor());
        numeroPrueba.aniade(5);
        System.out.println(numeroPrueba.getValor());
        numeroPrueba.resta(10);
        System.out.println(numeroPrueba.getValor());
        numeroPrueba.setValor(10);
        System.out.println(numeroPrueba.getValor());
        
        System.out.println(numeroPrueba.getDoble());
        System.out.println(numeroPrueba.getTriple());
        System.out.println(numeroPrueba.getCuadruple());
        
        
        //PRUEBA CONSUMO
        consumoPrueba = new Consumo(200f,20f,100f);
        
        //Ver como empezamos
        System.out.println(""+consumoPrueba.getTiempo()+" Horas");
        System.out.println("" + consumoPrueba.consumoMedio()+"L/100Km");
        System.out.println(""+consumoPrueba.consumoEuros()+"Eur");
        
        //Cambiar precio
        consumoPrueba.setPrecio(3f);
        System.out.println("3Eur/L en total: "
                +consumoPrueba.consumoEuros()+"Eur");
        
        //Cambiar datos del viaje
        consumoPrueba.setKms(100f);
        consumoPrueba.setLitros(5.5f);
        consumoPrueba.setVmed(10f);
        consumoPrueba.setPrecio(2f);
        System.out.println(""+consumoPrueba.getTiempo()+" Horas");
        System.out.println("" + consumoPrueba.consumoMedio()+"L/100Km");
        System.out.println(""+consumoPrueba.consumoEuros()+"Eur");
        
        //PRUEBA FINANZAS
        finanzasPrueba = new Finanzas(1.5);
        
        System.out.println(finanzasPrueba.dolaresToEuros(10));
        System.out.println(finanzasPrueba.eurosToDolares(15));
        
        //PRUEBA CONTADOR
        // Constructor sin parámetros
        c1 = new Contador();
        System.out.println("Prueba constructor sin parámetros:");
        System.out.println("Valor inicial esperado: 0, obtenido: " 
                + c1.obtenerCuenta());

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
        
        */
        //PRUEBA TEMPERATURA
        System.out.println("Febrero en Sevilla: "
                +Temperatura.celsiusToFarenheit(40)+"ºF");
        System.out.println("Febrero en Sevilla: "
                +Temperatura.farenheitToCelsius(100)+"ºC");
    }
}
