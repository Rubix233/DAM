/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Andy
 */
public class Cliente {

    public static void main(String[] args) {
       
        for(int i = 1; i <= 10; i++){
            new ClienteHilo(i).start();
            try {
                Thread.sleep(20); // Esperar 20ms entre cliente y cliente
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
