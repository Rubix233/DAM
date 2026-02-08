
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
            ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
            boolean seguir = true;
            
            String id = (String) entrada.readObject();
            System.out.println("Conexion establecida con cliente " + id);
            
            while(seguir){
                String mensaje = (String) entrada.readObject();
                
                if(!mensaje.equals("*")){
                    salida.writeObject((String)mensaje.toUpperCase());
                } else{
                    seguir = false;
                }    
            }
            System.out.println("Conexion cerrada con cliente " + id);

            
            entrada.close();
            this.socket.close();


        } catch (IOException ex) {
            Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

