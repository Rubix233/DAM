/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejemplo2;

/**
 *
 * @author Andy Jan
 */
public class ClaseB extends ClaseA{
    protected int atributoX = 2;
    
    public int metodoX(){
        return atributoX*-10;
    }
    public int metodoZ(){
        atributoX = super.atributoX+3;
        return super.metodoX() + atributoX;
    }
}
