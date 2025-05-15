
import java.util.LinkedList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Cola {
    private LinkedList<Object> tCola;
    
    public Cola(){
        this.tCola = new LinkedList<Object>();
    }
    
    public void meterEnCola(Object obj){
        if(obj instanceof Mensaje){
            this.tCola.addLast(obj);
        }
        
    }
    public Object sacarDeCola(){
        Object obj = null;
        if(!this.tCola.isEmpty()){
            obj = this.tCola.removeFirst();
        } 
        return obj;
    }
    public boolean esColaVacia(){
        return this.tCola.isEmpty();
    }
}
