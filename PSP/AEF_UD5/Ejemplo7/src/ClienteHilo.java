
import java.io.IOException;
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
public class ClienteHilo extends Thread{
    private int id;
    
    public ClienteHilo(int id){
        this.id = id;
    }
    
    @Override
    public void run(){
        
        int puerto = 50000;
        String host = "localhost";

        try {
            //InetAddress miAddress = InetAddress.getLocalHost();
            //String myIP = miAddress.getHostAddress();

            Socket socket = new Socket(host, puerto);

            ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
            
            salida.writeObject(Integer.toString(this.id));
            
            salida.close();
            socket.close();



        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
