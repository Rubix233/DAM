/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class NumeroPrueba {
    public static void main(String[] args){
        Numero numeroPrueba;
        
        //PRUEBA NUMERO
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
    }
}
