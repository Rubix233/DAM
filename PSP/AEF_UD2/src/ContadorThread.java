/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class ContadorThread extends Thread{
    @Override
    public void run(){
        for(int i = 1; i <= 100; i++){
            System.out.println("A"+i);
        }
    }
}
