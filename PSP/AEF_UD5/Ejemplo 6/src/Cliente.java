/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andy
 */
public class Cliente {

    public static void main(String[] args) {
        int puerto = 50000;
        String host = "localhost";

        try {
            InetAddress miAddress = InetAddress.getLocalHost();
            String myIP = miAddress.getHostAddress();

            Socket socket = new Socket(host, puerto);


            ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

            salida.writeUTF("Hola, soy el cliente con IP: " + myIP);
            salida.flush();
            
            Usuario usuario = (Usuario) entrada.readObject();
            usuario.setIP(myIP);
            usuario.setNombre("Andy Cliente");
            
            salida.writeObject(usuario);
            salida.flush();

            salida.close();
            entrada.close();
            socket.close();

        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
