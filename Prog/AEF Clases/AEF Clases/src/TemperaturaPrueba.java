/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class TemperaturaPrueba {
    public static void main(String[] args){
        //PRUEBA TEMPERATURA
        System.out.println("Febrero en Sevilla: "
                +Temperatura.celsiusToFarenheit(40)+"ºF");
        System.out.println("Febrero en Sevilla: "
                +Temperatura.farenheitToCelsius(100)+"ºC");
    }
}
