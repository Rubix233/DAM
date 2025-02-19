/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Temperatura {
    public static float celsiusToFarenheit(float celsius){
        return celsius*1.8f+32;
    }
    public static float farenheitToCelsius(float farenheit){
        return (farenheit-32)/1.8f;
    }
}
