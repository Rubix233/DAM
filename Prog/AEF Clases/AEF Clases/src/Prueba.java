/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Prueba {
    public static void main(String[] args){
        Numero numeroPrueba;
        Consumo consumoPrueba;
        Finanzas finanzasPrueba;
        
        //Prueba de Numero:
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
        
        
        //Prueba de Consumo
        consumoPrueba = new Consumo(200f,20f,100f);
        
        //Ver como empezamos
        System.out.println(""+consumoPrueba.getTiempo()+" Horas");
        System.out.println("" + consumoPrueba.consumoMedio()+"L/100Km");
        System.out.println(""+consumoPrueba.consumoEuros()+"Eur");
        
        //Cambiar precio
        consumoPrueba.setPrecio(3f);
        System.out.println("3Eur/L en total: "+consumoPrueba.consumoEuros()+"Eur");
        
        //Cambiar datos del viaje
        consumoPrueba.setKms(100f);
        consumoPrueba.setLitros(5.5f);
        consumoPrueba.setVmed(10f);
        consumoPrueba.setPrecio(2f);
        System.out.println(""+consumoPrueba.getTiempo()+" Horas");
        System.out.println("" + consumoPrueba.consumoMedio()+"L/100Km");
        System.out.println(""+consumoPrueba.consumoEuros()+"Eur");
        */
        //Prueba Finanzas
        finanzasPrueba = new Finanzas(1.5);
        
        System.out.println(finanzasPrueba.dolaresToEuros(10));
        System.out.println(finanzasPrueba.eurosToDolares(15));
        
    }
}
