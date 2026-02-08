
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
public class HiloProductor extends Thread {

    private int id;
    private String tipo = "productor";
    
    public HiloProductor(int id) {
        this.id = id;
    }
    
    @Override
    public void run() {
        
        int puerto = 50000;
        String host = "localhost";
        Random random = new Random();
        
        try {
            Socket socket = new Socket(host, puerto);
            
            ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
            
            salida.writeObject((String) "PRODUCTOR");
            
            boolean seguir = true;
            do {
                int num = random.nextInt(10) + 1;
                salida.writeObject((int) num);
                
                if (((String) entrada.readObject()).equals("LLENO")) {
                    seguir = false;
                } else {
                    Thread.sleep(2000);
                }
            } while (seguir);
            
            salida.close();
            socket.close();
            
            
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HiloConsumidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloProductor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
