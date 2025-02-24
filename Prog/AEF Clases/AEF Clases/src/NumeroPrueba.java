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
        Numero n1;
        Numero n2;
        
        //PRUEBA NUMERO
        n1 = new Numero(10);
        n2 = new Numero(5);
        /*
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
        * */
        System.out.println(n1.toString());
        System.out.println(n1.equals(n2));
        n2.aniade(5);
        System.out.println(n1.equals(n2));
    }
}
