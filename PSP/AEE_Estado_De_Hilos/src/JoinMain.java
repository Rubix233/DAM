/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class JoinMain {
    public static void main(String[] args) throws InterruptedException {
        JoinThread j1,j2;
        
        j1 = new JoinThread("j1",5000);
        j2 = new JoinThread("j2",1000,j1);
        
        j1.start();
        j2.start();
        
        Thread.sleep(1500);
        
        System.out.println(j2.getState());
    }
}
