/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class ConsumoPrueba {
    public static void main(String[] args){
        Consumo consumoPrueba;

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
        
        System.out.println(consumoPrueba.toString());
    }
}
