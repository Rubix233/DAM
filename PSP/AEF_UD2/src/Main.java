/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Main {
    public static void main(String[] args) {
        /*
        //Primer Thread
        MiPrimerThread t = new MiPrimerThread();
        t.start();
        System.out.println("Hola mundo desde main");
         */
 /*
        //Contadores
        ContadorThread cont = new ContadorThread();
        cont.start();
        for(int i = 1; i <= 100; i++){
            System.out.println("B"+i);
        }
         */
 
 /*
        //Random threads
        RetardoThread t1, t2, t3;
        t1 = new RetardoThread();
        t2 = new RetardoThread();
        t3 = new RetardoThread();

        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");

        t1.start();
        t2.start();
        t3.start();
 */       
        PainterThread p1,p2;
        
        p1 = new PainterThread("SI");
        p2 = new PainterThread("NO");
        
        p1.start();
        p2.start();

    }
}
