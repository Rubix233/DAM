
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy
 */
public class HiloConsumidor extends Thread {

    private int id;
    private String tipo = "consumidor";

    public HiloConsumidor(int id) {
        this.id = id;
    }

    @Override
    public void run() {

        int puerto = 50000;
        String host = "localhost";

        try {
            Socket socket = new Socket(host, puerto);

            ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

            salida.writeObject((String) "CONSUMIDOR");

            boolean seguir = true;

            do {
                try {
                    int num = (int) entrada.readObject();
                    System.out.println(num);
                } catch (ClassCastException e) {
                    seguir = false;
                }

            } while (seguir);
            
            entrada.close();
            salida.close();
            socket.close();



        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HiloConsumidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
