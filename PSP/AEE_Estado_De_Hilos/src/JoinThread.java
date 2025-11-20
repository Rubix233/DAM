
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class JoinThread extends Thread{

    Thread j = null;
    int time;
    public JoinThread(String name, int time){
        this.setName(name);
        this.time = time;
    }
    public JoinThread(String name, int time, Thread j){
        this.setName(name);
        this.time = time;
        this.j = j;
    }
    
    @Override
    public void run(){
        try {
            if(j != null) j.join();
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(JoinThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            System.out.println(this.getName() + " has finished");
        }
    }
}
