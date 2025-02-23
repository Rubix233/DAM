/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class FinanzasPrueba {
    public static void main(String[] args){
        Finanzas finanzasPrueba;
        
        //PRUEBA FINANZAS
        finanzasPrueba = new Finanzas(1.5);
        
        System.out.println(finanzasPrueba.dolaresToEuros(10));
        System.out.println(finanzasPrueba.eurosToDolares(15));
    }
}
