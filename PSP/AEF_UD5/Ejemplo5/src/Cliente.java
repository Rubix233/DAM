/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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


            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

            salida.writeUTF("Hola, soy el cliente con IP: " + myIP);
            
            Numero num = (Numero) entrada.readObject();
            System.out.println(num.getDato());

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
