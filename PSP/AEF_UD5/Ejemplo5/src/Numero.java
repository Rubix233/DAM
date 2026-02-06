
import java.io.Serializable;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy
 */
public class Numero implements Serializable{
    private int dato;
    
    public Numero(){
        this.dato = new Random().nextInt(10)+1;
    }
    public int getDato(){
        return dato;
    }
}
