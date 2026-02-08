
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
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
public class HiloServer extends Thread {

    private Socket socket;

    public HiloServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

            String mensaje = (String) entrada.readObject();
            System.out.println("Conexion establecida con cliente " + mensaje);

            int secs = (new Random().nextInt(10) + 1) * 1000;
            Thread.sleep(secs);
            System.out.println("Conexion finalizada con cliente " + mensaje
                    + " tras " + (secs/1000) + " segundos");

            entrada.close();
            this.socket.close();


        } catch (IOException ex) {
            Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

