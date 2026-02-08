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
       
        new HiloConsumidor(1).start();
        new HiloProductor(2).start();
        new HiloProductor(3).start();

    }
}
