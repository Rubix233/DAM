
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author andyj
 */
public class RetardoThread extends Thread {

    Random r = new Random();
    int min = 1;
    int max = 2000;
    int generado = min + r.nextInt(max - min + 1);

    @Override
    public void run() {
        
        try {
            Thread.sleep(generado);
            System.out.println("Hola mundo! Thread "+ Thread.currentThread().getName()+" "+(generado));
        } catch (InterruptedException ex) {
            System.getLogger(RetardoThread.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }
}
