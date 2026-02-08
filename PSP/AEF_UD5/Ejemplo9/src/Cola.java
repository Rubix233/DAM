/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Andy
 */
public class Cola {

    private Queue<Integer> cola = new LinkedList<>();
    private int maximo;
    private boolean llena = false;

    public Cola(int maximo) {
        this.maximo = maximo;
    }

    public synchronized boolean agregarNum(int num) {
        if (!llena) {
            cola.add(num);

            if (cola.size() >= this.maximo) {
                llena = true;
                notifyAll();
            }
        }
        return !llena;
    }
    
    public synchronized int obtenerNumero() throws InterruptedException{
        while(!llena && cola.size() < this.maximo){
            wait();
        }
        if(cola.isEmpty()){
            return -1;
        }
        
        return cola.poll();
        
    }
}
